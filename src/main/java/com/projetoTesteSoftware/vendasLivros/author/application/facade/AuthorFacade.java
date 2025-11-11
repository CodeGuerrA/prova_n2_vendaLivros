package com.projetoTesteSoftware.vendasLivros.author.application.facade;

import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;

import java.util.List;

public interface AuthorFacade {
    Author createAuthor(Author author);

    List<Author> findAllAuthors();

    void deleteAuthor(Long id);

    Author updateAuthor(Author author, Long id);

}
