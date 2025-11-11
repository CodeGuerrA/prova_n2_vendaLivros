package com.projetoTesteSoftware.vendasLivros.stock.domain.port;

import com.projetoTesteSoftware.vendasLivros.stock.domain.entity.Stock;

import java.util.Optional;

public interface StockRepositoryPort {

    Stock save(Stock stock);

    Optional<Stock> findById(Long id);

    void deleteById(Long id);
}
