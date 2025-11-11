package com.projetoTesteSoftware.vendasLivros.author.application.usecase;

import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import com.projetoTesteSoftware.vendasLivros.author.domain.port.AuthorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAuthorUseCase {
    private final AuthorRepositoryPort authorRepositoryPort;

    public Author saveAuthor(Author author) {
        return authorRepositoryPort.save(author);
    }
}
