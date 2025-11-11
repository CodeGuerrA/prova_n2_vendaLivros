package com.projetoTesteSoftware.vendasLivros.saleitem.application.facade.impl;

import com.projetoTesteSoftware.vendasLivros.saleitem.application.facade.SaleItemFacade;

import com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase.CreateSaleItemCase;
import com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase.DeleteSaleItemCase;
import com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase.FindAllSaleItemCase;
import com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase.UpdateSaleItemCase;
import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleItemFacadeImpl implements SaleItemFacade {

    private final CreateSaleItemCase createUseCase;
    private final FindAllSaleItemCase findAllUseCase;
    private final UpdateSaleItemCase updateUseCase;
    private final DeleteSaleItemCase deleteUseCase;

    @Override
    public SaleItem create(SaleItem saleItem) {
        return createUseCase.create(saleItem);
    }

    @Override
    public List<SaleItem> findAll() {
        return findAllUseCase.findAll();
    }

    @Override
    public SaleItem update(Long id, SaleItem saleItem) {
        return updateUseCase.update(id, saleItem);
    }

    @Override
    public void delete(Long id) {
        deleteUseCase.delete(id);
    }
}