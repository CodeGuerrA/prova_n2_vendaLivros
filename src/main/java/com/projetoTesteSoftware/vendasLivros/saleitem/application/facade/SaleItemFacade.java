package com.projetoTesteSoftware.vendasLivros.saleitem.application.facade;

import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;

import java.util.List;

public interface SaleItemFacade {

    SaleItem create(SaleItem saleItem);

    List<SaleItem> findAll();

    SaleItem update(Long id, SaleItem saleItem);

    void delete(Long id);
}
