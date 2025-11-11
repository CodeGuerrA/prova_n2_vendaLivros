package com.projetoTesteSoftware.vendasLivros.stock.application.facade.impl;

import com.projetoTesteSoftware.vendasLivros.stock.api.dto.request.StockRequestDTO;
import com.projetoTesteSoftware.vendasLivros.stock.api.dto.response.StockResponseDTO;
import com.projetoTesteSoftware.vendasLivros.stock.application.facade.StockFacade;
import com.projetoTesteSoftware.vendasLivros.stock.application.usecase.CreateStockCase;
import com.projetoTesteSoftware.vendasLivros.stock.application.usecase.DeleteStockCase;
import com.projetoTesteSoftware.vendasLivros.stock.domain.entity.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockFacadeImpl implements StockFacade {

    private final CreateStockCase createStockCase;
    private final DeleteStockCase deleteStockCase;

    @Override
    public StockResponseDTO createStock(StockRequestDTO stockRequestDTO) {
        // Já retorna StockResponseDTO direto do UseCase
        return createStockCase.create(stockRequestDTO);
    }

    @Override
    public void delete(Long id) {
        deleteStockCase.delete(id);
    }
}
