package com.projetoTesteSoftware.vendasLivros.author.application.usecase;

import com.projetoTesteSoftware.vendasLivros.author.api.dto.request.AuthorRequestDTO;
import com.projetoTesteSoftware.vendasLivros.author.api.dto.response.AuthorResponseDTO;
import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import com.projetoTesteSoftware.vendasLivros.author.domain.port.AuthorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateAuthorUseCase {

    private final AuthorRepositoryPort authorRepositoryPort;

    public AuthorResponseDTO updateAuthor(Long authorId, AuthorRequestDTO authorRequestDTO) {
        Author authorFound = authorRepositoryPort.findbyID(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        authorFound.setName(authorRequestDTO.getName());

        Author updatedAuthor = authorRepositoryPort.save(authorFound);

        AuthorResponseDTO responseDTO = new AuthorResponseDTO();
        responseDTO.setId(updatedAuthor.getId());
        responseDTO.setName(updatedAuthor.getName());
        responseDTO.setBookIds(updatedAuthor.getBooks().stream()
                .map(book -> book.getId())
                .toList());

        return responseDTO;
    }
}
