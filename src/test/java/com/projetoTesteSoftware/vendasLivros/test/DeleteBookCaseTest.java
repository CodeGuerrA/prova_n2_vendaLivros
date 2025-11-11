package com.projetoTesteSoftware.vendasLivros.test;

import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import com.projetoTesteSoftware.vendasLivros.book.application.usecase.DeleteBookCase;
import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import com.projetoTesteSoftware.vendasLivros.book.domain.port.BookRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("DeleteBookCase Unit Tests")
public class DeleteBookCaseTest {

    @Mock
    private BookRepositoryPort bookRepositoryPort;

    @InjectMocks
    private DeleteBookCase deleteBookCase;

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setIsbn("1234567890");
        book.setPrice(BigDecimal.valueOf(50));

        // Configurando autor de teste
        Author author = new Author();
        author.setId(1L);
        author.setName("Test Author");
        book.setAuthor(author);
    }

    @Test
    @DisplayName("Should delete book successfully")
    void testDeleteBook_Success() {
        when(bookRepositoryPort.findbyID(1L)).thenReturn(Optional.of(book));
        doNothing().when(bookRepositoryPort).delete(book);

        deleteBookCase.delete(1L);

        verify(bookRepositoryPort).findbyID(1L);
        verify(bookRepositoryPort).delete(book);
    }

    @Test
    @DisplayName("Should throw exception when deleting non-existent book")
    void testDeleteBook_NotFound() {
        when(bookRepositoryPort.findbyID(999L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> deleteBookCase.delete(999L))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Livro com ID 999 não encontrado.");

        verify(bookRepositoryPort).findbyID(999L);
        verify(bookRepositoryPort, never()).delete(any(Book.class));
    }
}
