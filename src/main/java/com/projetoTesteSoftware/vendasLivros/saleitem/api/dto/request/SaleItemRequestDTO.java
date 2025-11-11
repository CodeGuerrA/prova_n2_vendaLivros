package com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleItemRequestDTO {

    private Long bookId;
    private Long saleId;   // ID da venda
    // Id do livro
    private Integer quantity;  // Quantidade vendida

}
