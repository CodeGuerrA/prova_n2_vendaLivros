package com.projetoTesteSoftware.vendasLivros.book.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDTO {

    private Long id;
    private String title;
    private String isbn;
    private BigDecimal price;
    private Integer quantityInStock;
    private Long stockId;  // ID do estoque
    private Long authorId; // ID do autor
    private List<Long> saleItemIds = new ArrayList<>(); // IDs dos itens de venda
}
