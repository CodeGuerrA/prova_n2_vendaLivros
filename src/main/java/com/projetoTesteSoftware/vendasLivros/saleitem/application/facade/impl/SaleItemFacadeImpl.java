package com.projetoTesteSoftware.vendasLivros.saleitem.application.facade.impl;

import com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.request.SaleItemRequestDTO;
import com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.response.SaleItemResponseDTO;
import com.projetoTesteSoftware.vendasLivros.saleitem.application.facade.SaleItemFacade;
import com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase.CreateSaleItemCase;
import com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase.DeleteSaleItemCase;
import com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase.FindAllSaleItemCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleItemFacadeImpl implements SaleItemFacade {

    private final CreateSaleItemCase createUseCase;
    private final FindAllSaleItemCase findAllUseCase;
    private final DeleteSaleItemCase deleteUseCase;

    @Override
    public SaleItemResponseDTO create(SaleItemRequestDTO saleItemRequestDTO) {
        return createUseCase.create(saleItemRequestDTO);
    }

    @Override
    public List<SaleItemResponseDTO> findAll() {
        return findAllUseCase.findAll();
    }


    @Override
    public void delete(Long id) {
        deleteUseCase.delete(id);
    }
}
