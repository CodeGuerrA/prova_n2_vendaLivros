package com.projetoTesteSoftware.vendasLivros.stock.application.usecase;

import com.projetoTesteSoftware.vendasLivros.stock.domain.port.StockRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteStockCase {

    private final StockRepositoryPort stockRepositoryPort;

    public void delete(Long id) {
        if (!stockRepositoryPort.findById(id).isPresent()) {
            throw new EntityNotFoundException("Estoque não encontrado para deletar!");
        }
        stockRepositoryPort.deleteById(id);
    }
}
