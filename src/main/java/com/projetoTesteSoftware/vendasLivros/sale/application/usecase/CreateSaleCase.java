package com.projetoTesteSoftware.vendasLivros.sale.application.usecase;

import com.projetoTesteSoftware.vendasLivros.sale.api.dto.request.SaleRequestDTO;
import com.projetoTesteSoftware.vendasLivros.sale.api.dto.response.SaleResponseDTO;
import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;
import com.projetoTesteSoftware.vendasLivros.sale.domain.port.SaleRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.book.domain.port.BookRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import com.projetoTesteSoftware.vendasLivros.client.domain.port.ClientRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateSaleCase {

    private final SaleRepositoryPort saleRepositoryPort;
    private final BookRepositoryPort bookRepositoryPort;
    private final ClientRepositoryPort clientRepositoryPort;

    public SaleResponseDTO create(SaleRequestDTO saleRequestDTO) {
        // Busca e valida o cliente
        Client client = clientRepositoryPort.findById(saleRequestDTO.getClientId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Cliente não encontrado: " + saleRequestDTO.getClientId()));

        // Busca e valida o livro pelo ID
        Book book = bookRepositoryPort.findbyID(saleRequestDTO.getBookId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Livro não encontrado: " + saleRequestDTO.getBookId()));

        int quantity = saleRequestDTO.getQuantity() != null && saleRequestDTO.getQuantity() > 0
                ? saleRequestDTO.getQuantity()
                : 1;

        if (book.getQuantityInStock() < quantity) {
            throw new EntityNotFoundException("Estoque insuficiente do livro: " + book.getTitle());
        }

        // Atualiza estoque
        book.setQuantityInStock(book.getQuantityInStock() - quantity);
        bookRepositoryPort.save(book);

        // Cria a venda
        Sale sale = new Sale();
        sale.setClient(client);
        sale.setBook(book);
        sale.setQuantity(quantity);
        sale.setPrice(book.getPrice());
        sale.setSaleDate(saleRequestDTO.getSaleDate() != null ? saleRequestDTO.getSaleDate() : LocalDateTime.now());
        sale.setTotalAmount(book.getPrice().multiply(BigDecimal.valueOf(quantity)));

        // Salva a venda
        Sale savedSale = saleRepositoryPort.save(sale);

        // Converte para DTO de resposta sem lambda
        SaleResponseDTO responseDTO = new SaleResponseDTO();
        responseDTO.setId(savedSale.getId());
        responseDTO.setSaleDate(savedSale.getSaleDate());
        responseDTO.setTotalAmount(savedSale.getTotalAmount());
        responseDTO.setClientId(client.getId());
        responseDTO.setClientName(client.getName());  // nome do cliente
        responseDTO.setBookId(book.getId());
        responseDTO.setBookName(book.getTitle());      // nome do livro
        responseDTO.setQuantity(quantity);
        responseDTO.setPrice(book.getPrice());

        return responseDTO;
    }
}
