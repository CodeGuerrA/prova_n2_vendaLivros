package com.projetoTesteSoftware.vendasLivros.author.domain.port;

import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepositoryPort {

    Author save(Author author);

    void delete(Author author);

    List<Author>findByAll();

    Optional<Author>findbyID(Long authorId);
}
