package com.projetoTesteSoftware.vendasLivros.sale.api;

import com.projetoTesteSoftware.vendasLivros.sale.application.facade.SaleFacade;
import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleFacade saleFacade;

    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        return ResponseEntity.ok(saleFacade.createSale(sale));
    }

    @GetMapping
    public ResponseEntity<List<Sale>> findAllSales() {
        return ResponseEntity.ok(saleFacade.findAllSales());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> updateSale(@PathVariable Long id, @RequestBody Sale sale) {
        return ResponseEntity.ok(saleFacade.updateSale(id, sale));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        saleFacade.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
