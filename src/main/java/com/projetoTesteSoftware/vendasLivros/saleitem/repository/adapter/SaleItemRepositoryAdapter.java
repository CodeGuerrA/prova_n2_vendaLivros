package com.projetoTesteSoftware.vendasLivros.saleitem.repository.adapter;

import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;
import com.projetoTesteSoftware.vendasLivros.saleitem.domain.port.SaleItemRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.saleitem.repository.SaleItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SaleItemRepositoryAdapter implements SaleItemRepositoryPort {

    private final SaleItemRepository repository;

    @Override
    public SaleItem save(SaleItem saleItem) {
        return repository.save(saleItem);
    }

    @Override
    public List<SaleItem> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SaleItem> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
