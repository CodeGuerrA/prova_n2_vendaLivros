package com.projetoTesteSoftware.vendasLivros.book.application.usecase;

import com.projetoTesteSoftware.vendasLivros.book.api.dto.response.BookResponseDTO;
import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import com.projetoTesteSoftware.vendasLivros.book.domain.port.BookRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinderBookCase {

    private final BookRepositoryPort bookRepositoryPort;

    public List<BookResponseDTO> findAll() {
        List<Book> books = bookRepositoryPort.findByAll();
        List<BookResponseDTO> dtos = new ArrayList<>();

        for (Book book : books) {
            BookResponseDTO dto = new BookResponseDTO();
            dto.setId(book.getId());
            dto.setTitle(book.getTitle());
            dto.setIsbn(book.getIsbn());
            dto.setPrice(book.getPrice());
            dto.setQuantityInStock(book.getQuantityInStock());
            dto.setAuthorId(book.getAuthor() != null ? book.getAuthor().getId() : null);
            dto.setStockId(book.getStock() != null ? book.getStock().getId() : null);

            dtos.add(dto);
        }

        return dtos;
    }
}
