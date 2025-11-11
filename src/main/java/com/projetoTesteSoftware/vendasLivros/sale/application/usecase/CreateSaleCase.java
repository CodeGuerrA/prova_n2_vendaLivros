package com.projetoTesteSoftware.vendasLivros.sale.application.usecase;

import com.projetoTesteSoftware.vendasLivros.sale.api.dto.request.SaleRequestDTO;
import com.projetoTesteSoftware.vendasLivros.sale.api.dto.response.SaleResponseDTO;
import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;
import com.projetoTesteSoftware.vendasLivros.sale.domain.port.SaleRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.book.domain.port.BookRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.request.SaleItemRequestDTO;
import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateSaleCase {

    private final SaleRepositoryPort saleRepositoryPort;
    private final BookRepositoryPort bookRepositoryPort;

    public SaleResponseDTO create(SaleRequestDTO saleRequestDTO) {
        // Cria a venda
        Sale sale = new Sale();
        sale.setSaleDate(saleRequestDTO.getSaleDate() != null ? saleRequestDTO.getSaleDate() : LocalDateTime.now());

        BigDecimal total = BigDecimal.ZERO;
        List<SaleItem> items = new ArrayList<>();

        // Garante que items nunca será nulo
        if (saleRequestDTO.getItems() != null) {
            for (SaleItemRequestDTO itemRequest : saleRequestDTO.getItems()) {
                var book = bookRepositoryPort.findbyID(itemRequest.getBookId())
                        .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado: " + itemRequest.getBookId()));

                int quantity = itemRequest.getQuantity() > 0 ? itemRequest.getQuantity() : 1;

                if (book.getQuantityInStock() < quantity) {
                    throw new EntityNotFoundException("Estoque insuficiente do livro: " + book.getTitle());
                }

                // Atualiza estoque
                book.setQuantityInStock(book.getQuantityInStock() - quantity);
                bookRepositoryPort.save(book);

                // Cria item da venda
                SaleItem item = new SaleItem();
                item.setBook(book);
                item.setQuantity(quantity);
                item.setPrice(book.getPrice());
                item.setSale(sale);

                items.add(item);

                // Soma total: preço * quantidade
                total = total.add(book.getPrice().multiply(BigDecimal.valueOf(quantity)));
            }
        }

        sale.setItems(items);
        sale.setTotalAmount(total);

        // Salva a venda
        Sale savedSale = saleRepositoryPort.save(sale);

        // Converte para DTO de resposta
        SaleResponseDTO responseDTO = new SaleResponseDTO();
        responseDTO.setId(savedSale.getId());
        responseDTO.setSaleDate(savedSale.getSaleDate());
        responseDTO.setTotalAmount(savedSale.getTotalAmount());
        responseDTO.setClientId(saleRequestDTO.getClientId());
        responseDTO.setSaleItemIds(savedSale.getItems().stream().map(SaleItem::getId).toList());

        return responseDTO;
    }
}
