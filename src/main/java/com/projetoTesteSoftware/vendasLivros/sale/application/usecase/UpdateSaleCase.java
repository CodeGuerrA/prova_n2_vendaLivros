package com.projetoTesteSoftware.vendasLivros.sale.application.usecase;

import com.projetoTesteSoftware.vendasLivros.sale.api.dto.request.SaleRequestDTO;
import com.projetoTesteSoftware.vendasLivros.sale.api.dto.response.SaleResponseDTO;
import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;
import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;
import com.projetoTesteSoftware.vendasLivros.sale.domain.port.SaleRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.book.domain.port.BookRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.client.domain.port.ClientRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.request.SaleItemRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateSaleCase {

    private final SaleRepositoryPort saleRepositoryPort;
    private final BookRepositoryPort bookRepositoryPort;
    private final ClientRepositoryPort clientRepositoryPort;

    public SaleResponseDTO update(Long id, SaleRequestDTO saleRequestDTO) {
        Sale sale = saleRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada!"));

        // Atualiza cliente
        if (saleRequestDTO.getClientId() != null) {
            var client = clientRepositoryPort.findById(saleRequestDTO.getClientId())
                    .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));
            sale.setClient(client);
        }

        // Atualiza itens da venda
        List<SaleItem> updatedItems = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        if (saleRequestDTO.getItems() != null) {
            for (SaleItemRequestDTO itemDTO : saleRequestDTO.getItems()) {
                var book = bookRepositoryPort.findbyID(itemDTO.getBookId())
                        .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado: ID " + itemDTO.getBookId()));

                if (book.getQuantityInStock() < itemDTO.getQuantity()) {
                    throw new EntityNotFoundException("Estoque insuficiente do livro: " + book.getTitle());
                }

                book.setQuantityInStock(book.getQuantityInStock() - itemDTO.getQuantity());
                bookRepositoryPort.save(book);

                SaleItem item = new SaleItem();
                item.setBook(book);
                item.setQuantity(itemDTO.getQuantity());
                item.setPrice(book.getPrice());
                item.setSale(sale);

                updatedItems.add(item);
                total = total.add(book.getPrice().multiply(BigDecimal.valueOf(itemDTO.getQuantity())));
            }
        }

        sale.setItems(updatedItems);
        sale.setTotalAmount(total);

        Sale saved = saleRepositoryPort.save(sale);

        // Converte para DTO de resposta
        SaleResponseDTO responseDTO = new SaleResponseDTO();
        responseDTO.setId(saved.getId());
        responseDTO.setSaleDate(saved.getSaleDate());
        responseDTO.setTotalAmount(saved.getTotalAmount());
        responseDTO.setClientId(saved.getClient() != null ? saved.getClient().getId() : null);
        responseDTO.setSaleItemIds(saved.getItems().stream()
                .map(SaleItem::getId)
                .toList());

        return responseDTO;
    }
}
