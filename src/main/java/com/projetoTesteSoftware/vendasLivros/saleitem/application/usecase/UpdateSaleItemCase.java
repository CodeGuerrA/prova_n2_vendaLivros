package com.projetoTesteSoftware.vendasLivros.saleitem.application.usecase;

import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;
import com.projetoTesteSoftware.vendasLivros.saleitem.domain.port.SaleItemRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateSaleItemCase {

    private final SaleItemRepositoryPort saleItemRepositoryPort;

    public SaleItem update(Long id, SaleItem updated) {

        SaleItem old = saleItemRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SaleItem não encontrado!"));

        old.setQuantity(updated.getQuantity());
        old.setPrice(updated.getPrice());

        return saleItemRepositoryPort.save(old);
    }
}
