package com.projetoTesteSoftware.vendasLivros.author.application.facade.impl;

import com.projetoTesteSoftware.vendasLivros.author.api.dto.request.AuthorRequestDTO;
import com.projetoTesteSoftware.vendasLivros.author.api.dto.response.AuthorResponseDTO;
import com.projetoTesteSoftware.vendasLivros.author.application.facade.AuthorFacade;
import com.projetoTesteSoftware.vendasLivros.author.application.usecase.CreateAuthorUseCase;
import com.projetoTesteSoftware.vendasLivros.author.application.usecase.DeleteAuthorUseCase;
import com.projetoTesteSoftware.vendasLivros.author.application.usecase.FinderAuthorUseCase;
import com.projetoTesteSoftware.vendasLivros.author.application.usecase.UpdateAuthorUseCase;
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
    public AuthorResponseDTO createAuthor(AuthorRequestDTO authorRequestDTO) {
        return createAuthorUseCase.saveAuthor(authorRequestDTO);
    }

    @Override
    public List<AuthorResponseDTO> findAllAuthors() {
        return finderAuthorUseCase.findAll();
    }

    @Override
    public void deleteAuthor(Long id) {
        deleteAuthorUseCase.deleteById(id);
    }

    @Override
    public AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO authorRequestDTO) {
        return updateAuthorUseCase.updateAuthor(id, authorRequestDTO);
    }
}
