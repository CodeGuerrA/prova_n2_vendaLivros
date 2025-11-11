package com.projetoTesteSoftware.vendasLivros.saleitem.domain.port;

import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;

import java.util.List;
import java.util.Optional;

public interface SaleItemRepositoryPort {
    SaleItem save(SaleItem saleItem);

    List<SaleItem> findAll();

    Optional<SaleItem> findById(Long id);

    void deleteById(Long id);
}
