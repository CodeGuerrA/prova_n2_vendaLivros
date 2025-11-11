package com.projetoTesteSoftware.vendasLivros.sale.application.facade.impl;

import com.projetoTesteSoftware.vendasLivros.sale.application.facade.SaleFacade;
import com.projetoTesteSoftware.vendasLivros.sale.application.usecase.CreateSaleCase;
import com.projetoTesteSoftware.vendasLivros.sale.application.usecase.DeleteSaleCase;
import com.projetoTesteSoftware.vendasLivros.sale.application.usecase.FindAllSalesCase;
import com.projetoTesteSoftware.vendasLivros.sale.application.usecase.UpdateSaleCase;
import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleFacadeImpl implements SaleFacade {

    private final CreateSaleCase createCase;
    private final FindAllSalesCase findAllCase;
    private final UpdateSaleCase updateCase;
    private final DeleteSaleCase deleteCase;

    @Override
    public Sale createSale(Sale sale) {
        return createCase.create(sale);
    }

    @Override
    public List<Sale> findAllSales() {
        return findAllCase.findAll();
    }

    @Override
    public Sale updateSale(Long id, Sale sale) {
        return updateCase.update(id, sale);
    }

    @Override
    public void deleteSale(Long id) {
        deleteCase.delete(id);
    }
}