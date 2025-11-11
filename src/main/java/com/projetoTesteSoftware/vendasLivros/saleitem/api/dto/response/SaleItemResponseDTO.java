package com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleItemResponseDTO {

    private Long id;           // Id do item da venda
    private Long bookId;       // Id do livro
    private Integer quantity;  // Quantidade vendida
    private BigDecimal price;  // Preço unitário congelado
    private Long saleId;   // ID da venda
}

