package com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase;

import com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.request.SaleItemRequestDTO;
import com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.response.SaleItemResponseDTO;
import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;
import com.projetoTesteSoftware.vendasLivros.saleitem.domain.port.SaleItemRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.book.domain.port.BookRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.sale.domain.port.SaleRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSaleItemCase {

    private final SaleItemRepositoryPort saleItemRepositoryPort;
    private final BookRepositoryPort bookRepositoryPort;
    private final SaleRepositoryPort saleRepositoryPort;

    public SaleItemResponseDTO create(SaleItemRequestDTO requestDTO) {
        // Cria entidade SaleItem
        SaleItem item = new SaleItem();

        var book = bookRepositoryPort.findbyID(requestDTO.getBookId())
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado!"));

        var sale = saleRepositoryPort.findById(requestDTO.getSaleId())
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada!"));

        item.setBook(book);
        item.setSale(sale);
        item.setQuantity(requestDTO.getQuantity());
        item.setPrice(book.getPrice()); // Congela preço

        SaleItem savedItem = saleItemRepositoryPort.save(item);

        // Converte para DTO de resposta
        SaleItemResponseDTO responseDTO = new SaleItemResponseDTO();
        responseDTO.setId(savedItem.getId());
        responseDTO.setBookId(book.getId());
        responseDTO.setQuantity(savedItem.getQuantity());
        responseDTO.setPrice(savedItem.getPrice());

        return responseDTO;
    }
}
