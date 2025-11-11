package com.projetoTesteSoftware.vendasLivros.sale.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SaleResponseDTO {

    private Long id;
    private LocalDateTime saleDate;
    private BigDecimal totalAmount;

    // ID do cliente associado
    private Long clientId;

    // IDs dos itens da venda
    private List<Long> saleItemIds;
}
