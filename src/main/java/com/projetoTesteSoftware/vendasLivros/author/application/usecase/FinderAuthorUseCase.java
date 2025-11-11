package com.projetoTesteSoftware.vendasLivros.author.application.usecase;

import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import com.projetoTesteSoftware.vendasLivros.author.domain.port.AuthorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinderAuthorUseCase {
    private final AuthorRepositoryPort authorRepositoryPort;

    public List<Author> findAll() {
        return authorRepositoryPort.findByAll();
    }
}
