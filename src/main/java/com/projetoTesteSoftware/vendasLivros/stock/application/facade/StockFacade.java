package com.projetoTesteSoftware.vendasLivros.stock.application.facade;

import com.projetoTesteSoftware.vendasLivros.stock.domain.entity.Stock;

public interface StockFacade {
    Stock create(Stock stock);
    void delete(Long id);
}
