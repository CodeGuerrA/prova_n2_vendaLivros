package com.projetoTesteSoftware.vendasLivros.book.application.facade.impl;

import com.projetoTesteSoftware.vendasLivros.book.application.facade.BookFacade;
import com.projetoTesteSoftware.vendasLivros.book.application.usecase.CreateBookCase;
import com.projetoTesteSoftware.vendasLivros.book.application.usecase.DeleteBookCase;
import com.projetoTesteSoftware.vendasLivros.book.application.usecase.FinderBookCase;
import com.projetoTesteSoftware.vendasLivros.book.application.usecase.UpdateBookCase;
import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
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
    public Book createBook(Book book, Long authorId, Long stockId) {
        return createBookCase.create(book, authorId, stockId);
    }

    @Override
    public List<Book> findAllBooks() {
        return finderBookCase.findAll();
    }

    @Override
    public void deleteBook(Long id) {
        deleteBookCase.delete(id);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        return updateBookCase.update(id, book);
    }
}
