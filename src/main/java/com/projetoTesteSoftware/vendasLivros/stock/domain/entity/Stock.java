package com.projetoTesteSoftware.vendasLivros.stock.domain.entity;

import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "stocks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Um estoque pode ter vários livros
    @OneToMany(mappedBy = "stock")
    private List<Book> books = new ArrayList<>();
}
