package com.projetoTesteSoftware.vendasLivros.stock.application.facade.impl;

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
    public Stock create(Stock stock) {
        return createStockCase.create(stock);
    }

    @Override
    public void delete(Long id) {
        deleteStockCase.delete(id);
    }
}
