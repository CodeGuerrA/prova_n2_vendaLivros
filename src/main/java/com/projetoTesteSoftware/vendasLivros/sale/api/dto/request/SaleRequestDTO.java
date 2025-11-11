package com.projetoTesteSoftware.vendasLivros.sale.api.dto.request;
import com.projetoTesteSoftware.vendasLivros.saleitem.api.dto.request.SaleItemRequestDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SaleRequestDTO {

    private LocalDateTime saleDate;
    private BigDecimal totalAmount;

    // ID do cliente relacionado à venda
    private Long clientId;

    // IDs dos itens da venda (opcional, se necessário criar já com itens)
    private List<SaleItemRequestDTO> items = new ArrayList<>(); // inicializa vazia
}
