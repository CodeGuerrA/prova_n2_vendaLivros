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
public class UpdateBookCase {

    private final BookRepositoryPort bookRepositoryPort;
    private final AuthorRepositoryPort authorRepositoryPort;
    private final StockRepositoryPort stockRepositoryPort;

    public BookResponseDTO update(Long authorId, Long stockId, BookRequestDTO bookRequestDTO, Long id) {
        // Busca livro existente
        Book bookSaved = bookRepositoryPort.findbyID(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado para atualização!"));

        // Atualiza dados básicos
        bookSaved.setTitle(bookRequestDTO.getTitle());
        bookSaved.setIsbn(bookRequestDTO.getIsbn());
        bookSaved.setPrice(bookRequestDTO.getPrice());
        bookSaved.setQuantityInStock(bookRequestDTO.getQuantityInStock());

        // Atualiza autor, se necessário

            var author = authorRepositoryPort.findbyID(authorId)
                    .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado!"));
            bookSaved.setAuthor(author);


        // Atualiza estoque, se necessário
            var stock = stockRepositoryPort.findById(stockId)
                    .orElseThrow(() -> new EntityNotFoundException("Stock não encontrado!"));
            bookSaved.setStock(stock);


        // Salva alterações
        Book updatedBook = bookRepositoryPort.save(bookSaved);

        // Converte para DTO de resposta
        BookResponseDTO responseDTO = new BookResponseDTO();
        responseDTO.setId(updatedBook.getId());
        responseDTO.setTitle(updatedBook.getTitle());
        responseDTO.setIsbn(updatedBook.getIsbn());
        responseDTO.setPrice(updatedBook.getPrice());
        responseDTO.setQuantityInStock(updatedBook.getQuantityInStock());
        responseDTO.setAuthorId(updatedBook.getAuthor() != null ? updatedBook.getAuthor().getId() : null);
        responseDTO.setStockId(updatedBook.getStock() != null ? updatedBook.getStock().getId() : null);
        responseDTO.setSaleItemIds(updatedBook.getSaleItems().stream()
                .map(item -> item.getId())
                .toList());

        return responseDTO;
    }
}
