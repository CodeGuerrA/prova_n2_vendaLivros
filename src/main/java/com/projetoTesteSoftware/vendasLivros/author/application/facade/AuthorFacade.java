package com.projetoTesteSoftware.vendasLivros.author.application.facade;

import com.projetoTesteSoftware.vendasLivros.author.api.dto.request.AuthorRequestDTO;
import com.projetoTesteSoftware.vendasLivros.author.api.dto.response.AuthorResponseDTO;

import java.util.List;

public interface AuthorFacade {

    // Cria autor usando DTO de request e retorna DTO de response
    AuthorResponseDTO createAuthor(AuthorRequestDTO authorRequestDTO);

    // Lista todos os autores
    List<AuthorResponseDTO> findAllAuthors();

    // Deleta autor (void)
    void deleteAuthor(Long id);

    // Atualiza autor usando DTO de request e retorna DTO de response
    AuthorResponseDTO updateAuthor(Long id, AuthorRequestDTO authorRequestDTO);
}
