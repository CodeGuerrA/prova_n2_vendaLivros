package com.projetoTesteSoftware.vendasLivros.stock.infrastructure.adapter;

import com.projetoTesteSoftware.vendasLivros.stock.domain.entity.Stock;
import com.projetoTesteSoftware.vendasLivros.stock.domain.port.StockRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.stock.infrastructure.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class StockRepositoryAdapter implements StockRepositoryPort {
    private final StockRepository stockRepository;
    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        stockRepository.deleteById(id);
    }
}
