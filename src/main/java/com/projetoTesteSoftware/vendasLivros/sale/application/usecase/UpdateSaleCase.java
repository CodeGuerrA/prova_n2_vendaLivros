package com.projetoTesteSoftware.vendasLivros.sale.application.usecase;

import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;
import com.projetoTesteSoftware.vendasLivros.sale.domain.port.SaleRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateSaleCase {

    private final SaleRepositoryPort saleRepositoryPort;

    public Sale update(Long id, Sale sale) {
        Sale found = saleRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada!"));

        found.setClient(sale.getClient());
        return saleRepositoryPort.save(found);
    }
}
