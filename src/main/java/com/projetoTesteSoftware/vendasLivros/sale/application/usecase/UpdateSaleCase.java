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
public class UpdateSaleCase {

    private final SaleRepositoryPort saleRepositoryPort;
    private final BookRepositoryPort bookRepositoryPort;
    private final ClientRepositoryPort clientRepositoryPort;

    public SaleResponseDTO update(Long id, SaleRequestDTO saleRequestDTO) {
        Sale sale = saleRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada: " + id));

        // Atualiza cliente
        if (saleRequestDTO.getClientId() != null) {
            Client client = clientRepositoryPort.findById(saleRequestDTO.getClientId())
                    .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado: " + saleRequestDTO.getClientId()));
            sale.setClient(client);
        }

        // Atualiza livro e quantidade
        if (saleRequestDTO.getBookId() != null) {
            Book book = bookRepositoryPort.findbyID(saleRequestDTO.getBookId())
                    .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado: " + saleRequestDTO.getBookId()));

            int quantity = saleRequestDTO.getQuantity() != null && saleRequestDTO.getQuantity() > 0
                    ? saleRequestDTO.getQuantity()
                    : 1;

            if (book.getQuantityInStock() < quantity) {
                throw new EntityNotFoundException("Estoque insuficiente do livro: " + book.getTitle());
            }

            // Atualiza estoque (adiciona de volta a quantidade anterior)
            if (sale.getBook() != null) {
                Book oldBook = sale.getBook();
                oldBook.setQuantityInStock(oldBook.getQuantityInStock() + sale.getQuantity());
                bookRepositoryPort.save(oldBook);
            }

            book.setQuantityInStock(book.getQuantityInStock() - quantity);
            bookRepositoryPort.save(book);

            sale.setBook(book);
            sale.setQuantity(quantity);
            sale.setPrice(book.getPrice());
            sale.setTotalAmount(book.getPrice().multiply(BigDecimal.valueOf(quantity)));
        }

        // Atualiza data da venda se fornecida
        if (saleRequestDTO.getSaleDate() != null) {
            sale.setSaleDate(saleRequestDTO.getSaleDate());
        }

        Sale saved = saleRepositoryPort.save(sale);

        // Converte para DTO de resposta
        SaleResponseDTO responseDTO = new SaleResponseDTO();
        responseDTO.setId(saved.getId());
        responseDTO.setSaleDate(saved.getSaleDate());
        responseDTO.setTotalAmount(saved.getTotalAmount());
        responseDTO.setClientId(saved.getClient() != null ? saved.getClient().getId() : null);
        responseDTO.setClientName(saved.getClient() != null ? saved.getClient().getName() : null);
        responseDTO.setBookId(saved.getBook() != null ? saved.getBook().getId() : null);
        responseDTO.setBookName(saved.getBook() != null ? saved.getBook().getTitle() : null);
        responseDTO.setQuantity(saved.getQuantity());
        responseDTO.setPrice(saved.getPrice());

        return responseDTO;
    }
}
