package com.projetoTesteSoftware.vendasLivros.sale.application.usecase;

import com.projetoTesteSoftware.vendasLivros.sale.api.dto.response.SaleResponseDTO;
import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;
import com.projetoTesteSoftware.vendasLivros.sale.domain.port.SaleRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllSalesCase {

    private final SaleRepositoryPort saleRepositoryPort;

    public List<SaleResponseDTO> findAll() {
        List<Sale> sales = saleRepositoryPort.findAll();
        List<SaleResponseDTO> responseList = new ArrayList<>();

        for (Sale sale : sales) {
            SaleResponseDTO dto = new SaleResponseDTO();
            dto.setId(sale.getId());
            dto.setSaleDate(sale.getSaleDate());
            dto.setTotalAmount(sale.getTotalAmount());
            dto.setClientId(sale.getClient() != null ? sale.getClient().getId() : null);
            dto.setClientName(sale.getClient() != null ? sale.getClient().getName() : null);
            dto.setBookId(sale.getBook() != null ? sale.getBook().getId() : null);
            dto.setBookName(sale.getBook() != null ? sale.getBook().getTitle() : null);
            dto.setQuantity(sale.getQuantity());
            dto.setPrice(sale.getPrice());

            responseList.add(dto);
        }

        return responseList;
    }
}
