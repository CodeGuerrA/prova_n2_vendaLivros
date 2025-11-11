package com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase;

import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;
import com.projetoTesteSoftware.vendasLivros.saleitem.domain.port.SaleItemRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSaleItemCase {

    private final SaleItemRepositoryPort saleItemRepositoryPort;

    public SaleItem create(SaleItem saleItem) {
        return saleItemRepositoryPort.save(saleItem);
    }
}
