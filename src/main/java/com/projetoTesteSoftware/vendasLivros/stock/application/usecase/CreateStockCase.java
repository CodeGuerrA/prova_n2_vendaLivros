package com.projetoTesteSoftware.vendasLivros.stock.application.usecase;

import com.projetoTesteSoftware.vendasLivros.stock.domain.entity.Stock;
import com.projetoTesteSoftware.vendasLivros.stock.domain.port.StockRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStockCase {

    private final StockRepositoryPort stockRepositoryPort;

    public Stock create(Stock stock) {
        return stockRepositoryPort.save(stock);
    }

}
