package com.projetoTesteSoftware.vendasLivros.author.domain.entity;

import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    private Long id;

    @Column(name = "book_name")
    private String name;
    //autor pode ter varios livros
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();
}
