package com.projetoTesteSoftware.vendasLivros.test;


import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import com.projetoTesteSoftware.vendasLivros.book.infrastrucuture.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookRepositoryIntegrationTest {

    @Autowired
    private BookRepository bookRepository;

    private Book book;

    @BeforeEach
    void setUp() {
        Author author = new Author();
        author.setId(1L);
        author.setName("Autor Teste");

        book = new Book();
        book.setTitle("Livro Teste");
        book.setIsbn("1234567890");
        book.setPrice(BigDecimal.valueOf(50));
        book.setAuthor(author);
    }

    @Test
    @DisplayName("Test Create Book")
    void testCreateBook() {
        Book saved = bookRepository.save(book);

        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getTitle()).isEqualTo("Livro Teste");
    }

    @Test
    @DisplayName("Test Update Book")
    void testUpdateBook() {
        Book saved = bookRepository.save(book);
        saved.setTitle("Livro Atualizado");

        Book updated = bookRepository.save(saved);

        assertThat(updated.getTitle()).isEqualTo("Livro Atualizado");
    }

    @Test
    @DisplayName("Test Delete Book")
    void testDeleteBook() {
        Book saved = bookRepository.save(book);

        bookRepository.delete(saved);

        Optional<Book> deleted = bookRepository.findById(saved.getId());
        assertThat(deleted).isEmpty();
    }
}

