package com.projetoTesteSoftware.vendasLivros.sale.application.usecase;

import com.projetoTesteSoftware.vendasLivros.sale.domain.port.SaleRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteSaleCase {

    private final SaleRepositoryPort saleRepositoryPort;

    public void delete(Long id) {
        saleRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada!"));

        saleRepositoryPort.deleteById(id);
    }
}