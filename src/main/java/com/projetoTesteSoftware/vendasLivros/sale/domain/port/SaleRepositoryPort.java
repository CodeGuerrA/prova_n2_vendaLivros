package com.projetoTesteSoftware.vendasLivros.sale.domain.port;

import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleRepositoryPort {
    Sale save(Sale sale);

    List<Sale> findAll();

    Optional<Sale> findById(Long id);

    void deleteById(Long id);
}
