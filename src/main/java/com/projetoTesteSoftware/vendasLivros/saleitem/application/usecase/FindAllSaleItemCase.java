package com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase;

import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;
import com.projetoTesteSoftware.vendasLivros.saleitem.domain.port.SaleItemRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllSaleItemCase {

    private final SaleItemRepositoryPort saleItemRepositoryPort;

    public List<SaleItem> findAll() {
        return saleItemRepositoryPort.findAll();
    }
}
