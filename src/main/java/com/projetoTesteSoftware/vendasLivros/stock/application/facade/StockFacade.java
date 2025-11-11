package com.projetoTesteSoftware.vendasLivros.stock.application.facade;

import com.projetoTesteSoftware.vendasLivros.stock.api.dto.request.StockRequestDTO;
import com.projetoTesteSoftware.vendasLivros.stock.api.dto.response.StockResponseDTO;
import com.projetoTesteSoftware.vendasLivros.stock.domain.entity.Stock;

public interface StockFacade {
    StockResponseDTO createStock(StockRequestDTO stockRequestDTO);
    void delete(Long id);
}
