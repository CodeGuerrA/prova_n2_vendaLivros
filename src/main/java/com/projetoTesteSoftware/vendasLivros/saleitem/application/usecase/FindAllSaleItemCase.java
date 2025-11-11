package com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase;

import com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.response.SaleItemResponseDTO;
import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;
import com.projetoTesteSoftware.vendasLivros.saleitem.domain.port.SaleItemRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllSaleItemCase {

    private final SaleItemRepositoryPort saleItemRepositoryPort;

    public List<SaleItemResponseDTO> findAll() {
        List<SaleItem> saleItems = saleItemRepositoryPort.findAll();

        return saleItems.stream().map(item -> {
            SaleItemResponseDTO dto = new SaleItemResponseDTO();
            dto.setId(item.getId());
            dto.setBookId(item.getBook().getId());
            dto.setSaleId(item.getSale().getId());
            dto.setQuantity(item.getQuantity());
            dto.setPrice(item.getPrice());
            return dto;
        }).collect(Collectors.toList());
    }
}
