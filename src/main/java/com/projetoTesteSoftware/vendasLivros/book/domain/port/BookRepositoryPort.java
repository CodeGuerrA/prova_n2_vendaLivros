package com.projetoTesteSoftware.vendasLivros.book.domain.port;

import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepositoryPort {

    Book save(Book book);

    void delete(Book book);

    List<Book> findByAll();

    Optional<Book> findbyID(Long id);
}
