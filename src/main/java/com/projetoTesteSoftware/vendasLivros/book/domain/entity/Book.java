package com.projetoTesteSoftware.vendasLivros.book.domain.entity;


import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import com.projetoTesteSoftware.vendasLivros.stock.domain.entity.Stock;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "book_title", nullable = false)
    private String title;

    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    @Column(name = "book_price", nullable = false)
    private BigDecimal price;

    @Column(name = "book_quantity")
    private Integer quantityInStock;

    // Relacionamento ManyToOne com Stock
    @ManyToOne
    @JoinColumn(name = "stock_id")
    private Stock stock;

    // Relacionamento ManyToOne com Author (um livro tem um autor)
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
