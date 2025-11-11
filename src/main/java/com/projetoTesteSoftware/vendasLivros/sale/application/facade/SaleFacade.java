package com.projetoTesteSoftware.vendasLivros.sale.application.facade;

import com.projetoTesteSoftware.vendasLivros.sale.api.dto.request.SaleRequestDTO;
import com.projetoTesteSoftware.vendasLivros.sale.api.dto.response.SaleResponseDTO;

import java.util.List;

public interface SaleFacade {

    // Cria uma venda a partir de DTO de request
    SaleResponseDTO createSale(SaleRequestDTO saleRequestDTO);

    // Lista todas as vendas
    List<SaleResponseDTO> findAllSales();

    // Atualiza uma venda existente
    SaleResponseDTO updateSale(Long id, SaleRequestDTO saleRequestDTO);

    // Deleta uma venda (void)
    void deleteSale(Long id);
}
