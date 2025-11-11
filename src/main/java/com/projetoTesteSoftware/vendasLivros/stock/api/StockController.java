package com.projetoTesteSoftware.vendasLivros.stock.api;

import com.projetoTesteSoftware.vendasLivros.stock.application.facade.StockFacade;
import com.projetoTesteSoftware.vendasLivros.stock.domain.entity.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockFacade stockFacade;

    @PostMapping
    public ResponseEntity<Stock> create(@RequestBody Stock stock) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(stockFacade.create(stock));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stockFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
