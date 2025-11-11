package com.projetoTesteSoftware.vendasLivros.book.application.usecase;

import com.projetoTesteSoftware.vendasLivros.book.api.dto.request.BookRequestDTO;
import com.projetoTesteSoftware.vendasLivros.book.api.dto.response.BookResponseDTO;
import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import com.projetoTesteSoftware.vendasLivros.book.domain.port.BookRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.author.domain.port.AuthorRepositoryPort;
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

    public BookResponseDTO create(BookRequestDTO bookRequestDTO, Long authorId, Long stockId) {
        // Busca autor e estoque
        var author = authorRepositoryPort.findbyID(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado!"));

        var stock = stockRepositoryPort.findById(stockId)
                .orElseThrow(() -> new EntityNotFoundException("Stock não encontrado!"));

        // Cria entidade Book
        Book book = new Book();
        book.setTitle(bookRequestDTO.getTitle());
        book.setIsbn(bookRequestDTO.getIsbn());
        book.setPrice(bookRequestDTO.getPrice());
        book.setQuantityInStock(bookRequestDTO.getQuantityInStock());
        book.setAuthor(author);
        book.setStock(stock);

        // Mantém referência bidirecional
        stock.getBooks().add(book);

        // Salva no repositório
        Book savedBook = bookRepositoryPort.save(book);

        // Converte para DTO de resposta
        BookResponseDTO responseDTO = new BookResponseDTO();
        responseDTO.setId(savedBook.getId());
        responseDTO.setTitle(savedBook.getTitle());
        responseDTO.setIsbn(savedBook.getIsbn());
        responseDTO.setPrice(savedBook.getPrice());
        responseDTO.setQuantityInStock(savedBook.getQuantityInStock());
        responseDTO.setAuthorId(savedBook.getAuthor().getId());
        responseDTO.setStockId(savedBook.getStock().getId());

        return responseDTO;
    }
}
