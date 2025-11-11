package com.projetoTesteSoftware.vendasLivros.sale.api.dto.response;

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
public class SaleResponseDTO {

    private Long id;              // ID da venda
    private LocalDateTime saleDate;
    private BigDecimal totalAmount;

    private Long clientId;        // ID do cliente
    private String clientName;    // Nome do cliente

    private Long bookId;          // ID do livro vendido
    private String bookName;      // Nome do livro vendido

    private Integer quantity;     // Quantidade vendida
    private BigDecimal price;     // Preço unitário do livro
}
