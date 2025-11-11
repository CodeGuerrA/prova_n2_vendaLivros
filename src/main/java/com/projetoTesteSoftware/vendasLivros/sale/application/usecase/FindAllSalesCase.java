package com.projetoTesteSoftware.vendasLivros.sale.application.usecase;

import com.projetoTesteSoftware.vendasLivros.sale.api.dto.response.SaleResponseDTO;
import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;
import com.projetoTesteSoftware.vendasLivros.sale.domain.port.SaleRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FindAllSalesCase {

    private final SaleRepositoryPort saleRepositoryPort;

    public List<SaleResponseDTO> findAll() {
        List<Sale> sales = saleRepositoryPort.findAll();

        // Converte cada Sale para SaleResponseDTO
        return sales.stream().map(sale -> {
            SaleResponseDTO dto = new SaleResponseDTO();
            dto.setId(sale.getId());
            dto.setSaleDate(sale.getSaleDate());
            dto.setTotalAmount(sale.getTotalAmount());
            dto.setClientId(sale.getClient().getId());
            dto.setSaleItemIds(
                    sale.getItems().stream().map(item -> item.getId()).toList()
            );
            return dto;
        }).collect(Collectors.toList());
    }
}
