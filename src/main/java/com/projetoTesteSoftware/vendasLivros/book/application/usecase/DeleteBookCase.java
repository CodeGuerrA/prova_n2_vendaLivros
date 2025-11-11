package com.projetoTesteSoftware.vendasLivros.book.application.usecase;

import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import com.projetoTesteSoftware.vendasLivros.book.domain.port.BookRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteBookCase {
    private final BookRepositoryPort bookRepositoryPort;

    public void delete(Long id) {

        Book book = bookRepositoryPort.findbyID(id)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado para deletar!"));

        bookRepositoryPort.delete(book);
    }
}
