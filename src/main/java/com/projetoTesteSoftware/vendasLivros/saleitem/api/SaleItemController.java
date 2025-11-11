package com.projetoTesteSoftware.vendasLivros.saleitem.api;


import com.projetoTesteSoftware.vendasLivros.saleitem.application.facade.SaleItemFacade;
import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sale-items")
@RequiredArgsConstructor
public class SaleItemController {

    private final SaleItemFacade facade;

    @PostMapping
    public ResponseEntity<SaleItem> create(@RequestBody SaleItem saleItem) {
        return ResponseEntity.ok(facade.create(saleItem));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(facade.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleItem> update(@PathVariable Long id, @RequestBody SaleItem saleItem) {
        return ResponseEntity.ok(facade.update(id, saleItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        facade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
