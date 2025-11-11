package com.projetoTesteSoftware.vendasLivros.saleitem.api;

import com.projetoTesteSoftware.vendasLivros.saleitem.application.facade.SaleItemFacade;
import com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.request.SaleItemRequestDTO;
import com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.response.SaleItemResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale-items")
@RequiredArgsConstructor
public class SaleItemController {

    private final SaleItemFacade facade;

    // Cria um novo SaleItem
    @PostMapping
    public ResponseEntity<SaleItemResponseDTO> create(@RequestBody SaleItemRequestDTO requestDTO) {
        SaleItemResponseDTO responseDTO = facade.create(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    // Lista todos os SaleItems
    @GetMapping
    public ResponseEntity<List<SaleItemResponseDTO>> findAll() {
        List<SaleItemResponseDTO> saleItems = facade.findAll();
        return ResponseEntity.ok(saleItems);
    }

    // Deleta um SaleItem
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        facade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
