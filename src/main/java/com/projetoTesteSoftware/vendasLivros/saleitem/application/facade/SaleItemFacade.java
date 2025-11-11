package com.projetoTesteSoftware.vendasLivros.saleitem.application.facade;

import com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.request.SaleItemRequestDTO;
import com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.response.SaleItemResponseDTO;

import java.util.List;

public interface SaleItemFacade {

    // Cria um novo item de venda
    SaleItemResponseDTO create(SaleItemRequestDTO saleItemRequestDTO);

    // Lista todos os itens de venda
    List<SaleItemResponseDTO> findAll();

    // Atualiza um item existente

    // Deleta um item de venda
    void delete(Long id);
}
