package com.projetoTesteSoftware.vendasLivros.book.application.facade;

import com.projetoTesteSoftware.vendasLivros.book.api.dto.request.BookRequestDTO;
import com.projetoTesteSoftware.vendasLivros.book.api.dto.response.BookResponseDTO;

import java.util.List;

public interface BookFacade {

    // Cria livro usando DTO de request e retorna DTO de response
    BookResponseDTO createBook(BookRequestDTO bookRequestDTO, Long auhtorID, Long stockId);

    // Lista todos os livros
    List<BookResponseDTO> findAllBooks();

    // Deleta livro (void)
    void deleteBook(Long id);

    // Atualiza livro usando DTO de request e retorna DTO de response
    BookResponseDTO updateBook(Long id, BookRequestDTO bookRequestDTO, Long auhtorID, Long stockId);
}
