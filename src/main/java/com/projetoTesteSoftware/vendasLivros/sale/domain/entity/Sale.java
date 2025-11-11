package com.projetoTesteSoftware.vendasLivros.sale.domain.entity;

import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sale_id")
    private Long id;

    @Column(name = "sale_date", nullable = false)
    private LocalDateTime saleDate;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    // Construtor para facilitar criação de vendas
    public Sale(Client client, Book book, Integer quantity, BigDecimal price) {
        this.client = client;
        this.book = book;
        this.quantity = quantity;
        this.price = price;
        this.saleDate = LocalDateTime.now();
        this.totalAmount = price.multiply(BigDecimal.valueOf(quantity));
    }
}
