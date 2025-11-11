package com.projetoTesteSoftware.vendasLivros.sale.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequestDTO {

    private Long clientId;    // ID do cliente que está comprando
    private Long bookId;      // ID do livro que será comprado
    private Integer quantity; // Quantidade do livro
    private LocalDateTime saleDate; // Data da venda (opcional)
}
