package com.projetoTesteSoftware.vendasLivros.book.infrastrucuture.adapter;

import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import com.projetoTesteSoftware.vendasLivros.book.domain.port.BookRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.book.infrastrucuture.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookRepositoryAdapter implements BookRepositoryPort {
    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public List<Book> findByAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findbyID(Long id) {
        return bookRepository.findById(id);
    }
}
