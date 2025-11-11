package com.projetoTesteSoftware.vendasLivros.book.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO {

    private String title;
    private String isbn;
    private BigDecimal price;
    private Integer quantityInStock;
}