package com.projetoTesteSoftware.vendasLivros.book.application.usecase;

import com.projetoTesteSoftware.vendasLivros.author.domain.port.AuthorRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import com.projetoTesteSoftware.vendasLivros.book.domain.port.BookRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.stock.domain.port.StockRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookCase {

    private final BookRepositoryPort bookRepositoryPort;
    private final AuthorRepositoryPort authorRepositoryPort;
    private final StockRepositoryPort stockRepositoryPort;

    public Book create(Book book, Long authorId, Long stockId) {

        var author = authorRepositoryPort.findbyID(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado!"));

        var stock = stockRepositoryPort.findById(stockId)
                .orElseThrow(() -> new EntityNotFoundException("Stock não encontrado!"));

        book.setAuthor(author);
        book.setStock(stock);
        stock.getBooks().add(book);

        return bookRepositoryPort.save(book);
    }

}
