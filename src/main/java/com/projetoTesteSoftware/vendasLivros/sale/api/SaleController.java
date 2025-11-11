package com.projetoTesteSoftware.vendasLivros.sale.api;

import com.projetoTesteSoftware.vendasLivros.sale.api.dto.request.SaleRequestDTO;
import com.projetoTesteSoftware.vendasLivros.sale.api.dto.response.SaleResponseDTO;
import com.projetoTesteSoftware.vendasLivros.sale.application.facade.SaleFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleFacade saleFacade;

    // Cria uma nova venda
    @PostMapping
    public ResponseEntity<SaleResponseDTO> createSale(@RequestBody SaleRequestDTO saleRequestDTO) {
        SaleResponseDTO createdSale = saleFacade.createSale(saleRequestDTO);
        return ResponseEntity.status(201).body(createdSale);
    }

    // Lista todas as vendas
    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> findAllSales() {
        List<SaleResponseDTO> sales = saleFacade.findAllSales();
        return ResponseEntity.ok(sales);
    }

    // Atualiza uma venda existente
    @PutMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> updateSale(@PathVariable Long id,
                                                      @RequestBody SaleRequestDTO saleRequestDTO) {
        SaleResponseDTO updatedSale = saleFacade.updateSale(id, saleRequestDTO);
        return ResponseEntity.ok(updatedSale);
    }

    // Deleta uma venda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
        saleFacade.deleteSale(id);
        return ResponseEntity.noContent().build();
    }
}
