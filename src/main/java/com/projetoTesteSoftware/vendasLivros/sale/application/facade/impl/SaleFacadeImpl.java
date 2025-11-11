package com.projetoTesteSoftware.vendasLivros.sale.application.facade.impl;

import com.projetoTesteSoftware.vendasLivros.sale.api.dto.request.SaleRequestDTO;
import com.projetoTesteSoftware.vendasLivros.sale.api.dto.response.SaleResponseDTO;
import com.projetoTesteSoftware.vendasLivros.sale.application.facade.SaleFacade;
import com.projetoTesteSoftware.vendasLivros.sale.application.usecase.CreateSaleCase;
import com.projetoTesteSoftware.vendasLivros.sale.application.usecase.DeleteSaleCase;
import com.projetoTesteSoftware.vendasLivros.sale.application.usecase.FindAllSalesCase;
import com.projetoTesteSoftware.vendasLivros.sale.application.usecase.UpdateSaleCase;
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
    public SaleResponseDTO createSale(SaleRequestDTO saleRequestDTO) {
        return createCase.create(saleRequestDTO);
    }

    @Override
    public List<SaleResponseDTO> findAllSales() {
        return findAllCase.findAll();
    }

    @Override
    public SaleResponseDTO updateSale(Long id, SaleRequestDTO saleRequestDTO) {
        return updateCase.update(id, saleRequestDTO);
    }

    @Override
    public void deleteSale(Long id) {
        deleteCase.delete(id);
    }
}
