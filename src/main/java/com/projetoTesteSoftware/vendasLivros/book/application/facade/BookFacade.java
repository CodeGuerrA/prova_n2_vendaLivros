package com.projetoTesteSoftware.vendasLivros.book.application.facade;

import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;

import java.util.List;

public interface BookFacade {

    Book createBook(Book book, Long authorId, Long stockId);

    List<Book>findAllBooks();

    void deleteBook(Long id);

    Book updateBook(Long id, Book book);
}
