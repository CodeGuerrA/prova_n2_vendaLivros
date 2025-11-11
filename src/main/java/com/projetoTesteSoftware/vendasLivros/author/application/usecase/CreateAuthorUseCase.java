package com.projetoTesteSoftware.vendasLivros.author.application.usecase;

import com.projetoTesteSoftware.vendasLivros.author.api.dto.request.AuthorRequestDTO;
import com.projetoTesteSoftware.vendasLivros.author.api.dto.response.AuthorResponseDTO;
import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import com.projetoTesteSoftware.vendasLivros.author.domain.port.AuthorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAuthorUseCase {

    private final AuthorRepositoryPort authorRepositoryPort;

    public AuthorResponseDTO saveAuthor(AuthorRequestDTO authorRequestDTO) {
        Author author = new Author();
        author.setName(authorRequestDTO.getName());

        Author savedAuthor = authorRepositoryPort.save(author);

        AuthorResponseDTO responseDTO = new AuthorResponseDTO();
        responseDTO.setId(savedAuthor.getId());
        responseDTO.setName(savedAuthor.getName());
        responseDTO.setBookNames(savedAuthor.getBooks().stream()
                .map(book -> book.getTitle())
                .toList());

        return responseDTO;
    }
}
