package com.projetoTesteSoftware.vendasLivros.sale.infrastructure.adapter;

import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;
import com.projetoTesteSoftware.vendasLivros.sale.domain.port.SaleRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.sale.infrastructure.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class SaleRepositoryAdapter implements SaleRepositoryPort {
    private final SaleRepository saleRepository;
    @Override
    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public Optional<Sale> findById(Long id) {
        return saleRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        saleRepository.deleteById(id);
    }
}
