package com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase;

import com.projetoTesteSoftware.vendasLivros.saleitem.domain.port.SaleItemRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteSaleItemCase {

    private final SaleItemRepositoryPort saleItemRepositoryPort;

    public void delete(Long id) {
        saleItemRepositoryPort.deleteById(id);
    }
}
