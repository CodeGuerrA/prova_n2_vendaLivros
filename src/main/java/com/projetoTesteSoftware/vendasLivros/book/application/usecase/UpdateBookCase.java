package com.projetoTesteSoftware.vendasLivros.book.application.usecase;

import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import com.projetoTesteSoftware.vendasLivros.book.domain.port.BookRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateBookCase {
    private final BookRepositoryPort bookRepositoryPort;

    public Book update(Long id, Book book) {
        Book bookSaved = bookRepositoryPort.findbyID(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado para atualização!"));

        // Aplica as mudanças
        bookSaved.setTitle(book.getTitle());
        bookSaved.setIsbn(book.getIsbn());
        bookSaved.setPrice(book.getPrice());
        bookSaved.setQuantityInStock(book.getQuantityInStock());
        bookSaved.setAuthor(book.getAuthor());

        return bookRepositoryPort.save(bookSaved);
    }
}
