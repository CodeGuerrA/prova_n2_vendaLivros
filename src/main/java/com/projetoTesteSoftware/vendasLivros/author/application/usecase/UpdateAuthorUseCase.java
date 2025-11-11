package com.projetoTesteSoftware.vendasLivros.author.application.usecase;

import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import com.projetoTesteSoftware.vendasLivros.author.domain.port.AuthorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateAuthorUseCase {
private final AuthorRepositoryPort authorRepositoryPort;
    public Author updateAuthor(Author author, Long authorId) {
        Author authorFound = authorRepositoryPort.findbyID(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        authorFound.setName(author.getName());

        return authorRepositoryPort.save(authorFound);
    }
}
