package com.projetoTesteSoftware.vendasLivros.author.application.facade.impl;

import com.projetoTesteSoftware.vendasLivros.author.application.facade.AuthorFacade;
import com.projetoTesteSoftware.vendasLivros.author.application.usecase.CreateAuthorUseCase;
import com.projetoTesteSoftware.vendasLivros.author.application.usecase.DeleteAuthorUseCase;
import com.projetoTesteSoftware.vendasLivros.author.application.usecase.FinderAuthorUseCase;
import com.projetoTesteSoftware.vendasLivros.author.application.usecase.UpdateAuthorUseCase;
import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorFacadeImpl implements AuthorFacade {

    private final CreateAuthorUseCase createAuthorUseCase;
    private final UpdateAuthorUseCase updateAuthorUseCase;
    private final DeleteAuthorUseCase deleteAuthorUseCase;
    private final FinderAuthorUseCase finderAuthorUseCase;

    @Override
    public Author createAuthor(Author author) {
        return createAuthorUseCase.saveAuthor(author);
    }

    @Override
    public List<Author> findAllAuthors() {
        return finderAuthorUseCase.findAll();
    }

    @Override
    public void deleteAuthor(Long id) {
        deleteAuthorUseCase.deleteById(id);
    }

    @Override
    public Author updateAuthor(Author author, Long id) {
        return updateAuthorUseCase.updateAuthor(author, id);
    }
}
