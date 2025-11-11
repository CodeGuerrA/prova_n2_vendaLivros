package com.projetoTesteSoftware.vendasLivros.sale.application.facade;

import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;

import java.util.List;

public interface SaleFacade {
    Sale createSale(Sale sale);

    List<Sale> findAllSales();

    Sale updateSale(Long id, Sale sale);

    void deleteSale(Long id);
}
