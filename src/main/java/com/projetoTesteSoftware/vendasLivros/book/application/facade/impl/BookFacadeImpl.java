package com.projetoTesteSoftware.vendasLivros.book.application.facade.impl;

import com.projetoTesteSoftware.vendasLivros.book.api.dto.request.BookRequestDTO;
import com.projetoTesteSoftware.vendasLivros.book.api.dto.response.BookResponseDTO;
import com.projetoTesteSoftware.vendasLivros.book.application.facade.BookFacade;
import com.projetoTesteSoftware.vendasLivros.book.application.usecase.CreateBookCase;
import com.projetoTesteSoftware.vendasLivros.book.application.usecase.DeleteBookCase;
import com.projetoTesteSoftware.vendasLivros.book.application.usecase.FinderBookCase;
import com.projetoTesteSoftware.vendasLivros.book.application.usecase.UpdateBookCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookFacadeImpl implements BookFacade {

    private final CreateBookCase createBookCase;
    private final UpdateBookCase updateBookCase;
    private final FinderBookCase finderBookCase;
    private final DeleteBookCase deleteBookCase;

    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO, Long authorId, Long stockId) {
        // Passa explicitamente os IDs do autor e do estoque
        return createBookCase.create(bookRequestDTO, authorId, stockId);
    }

    @Override
    public List<BookResponseDTO> findAllBooks() {
        return finderBookCase.findAll();
    }

    @Override
    public void deleteBook(Long id) {
        deleteBookCase.delete(id);
    }

    @Override
    public BookResponseDTO updateBook(Long id, BookRequestDTO bookRequestDTO, Long authorId, Long stockId) {
        return updateBookCase.update(authorId, stockId, bookRequestDTO, id);
    }

}
