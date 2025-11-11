package com.projetoTesteSoftware.vendasLivros.author.application.usecase;

import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import com.projetoTesteSoftware.vendasLivros.author.domain.port.AuthorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteAuthorUseCase {
private final AuthorRepositoryPort authorRepositoryPort;

    public void deleteById(Long id) {
        Author authorFound = authorRepositoryPort.findbyID(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        authorRepositoryPort.delete(authorFound);
    }
}
