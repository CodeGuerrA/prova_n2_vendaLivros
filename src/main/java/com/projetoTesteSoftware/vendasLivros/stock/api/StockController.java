package com.projetoTesteSoftware.vendasLivros.stock.api;

import com.projetoTesteSoftware.vendasLivros.stock.api.dto.request.StockRequestDTO;
import com.projetoTesteSoftware.vendasLivros.stock.api.dto.response.StockResponseDTO;
import com.projetoTesteSoftware.vendasLivros.stock.application.facade.StockFacade;
import com.projetoTesteSoftware.vendasLivros.stock.domain.entity.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockFacade stockFacade;

    @PostMapping
    public ResponseEntity<StockResponseDTO> create(@RequestBody StockRequestDTO stockRequestDTO) {
        StockResponseDTO created = stockFacade.createStock(stockRequestDTO);
        return ResponseEntity.created(URI.create("/stocks/" + created.getId()))
                .body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stockFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
