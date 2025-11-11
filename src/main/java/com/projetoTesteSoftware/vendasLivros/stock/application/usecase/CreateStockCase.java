package com.projetoTesteSoftware.vendasLivros.stock.application.usecase;

import com.projetoTesteSoftware.vendasLivros.stock.domain.entity.Stock;
import com.projetoTesteSoftware.vendasLivros.stock.domain.port.StockRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.stock.api.dto.request.StockRequestDTO;
import com.projetoTesteSoftware.vendasLivros.stock.api.dto.response.StockResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStockCase {

    private final StockRepositoryPort stockRepositoryPort;

    public StockResponseDTO create(StockRequestDTO requestDTO) {
        Stock stock = new Stock();
        Stock saved = stockRepositoryPort.save(stock);

        StockResponseDTO responseDTO = new StockResponseDTO();
        responseDTO.setId(saved.getId());
        return responseDTO;
    }
}
