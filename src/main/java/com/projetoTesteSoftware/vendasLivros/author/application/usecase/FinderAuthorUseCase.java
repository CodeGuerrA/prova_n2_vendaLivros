package com.projetoTesteSoftware.vendasLivros.author.application.usecase;

import com.projetoTesteSoftware.vendasLivros.author.api.dto.response.AuthorResponseDTO;
import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import com.projetoTesteSoftware.vendasLivros.author.domain.port.AuthorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinderAuthorUseCase {

    private final AuthorRepositoryPort authorRepositoryPort;

    public List<AuthorResponseDTO> findAll() {
        List<Author> authors = authorRepositoryPort.findByAll();

        return authors.stream().map(author -> {
            AuthorResponseDTO dto = new AuthorResponseDTO();
            dto.setId(author.getId());
            dto.setName(author.getName());
            dto.setBookIds(author.getBooks().stream()
                    .map(book -> book.getId())
                    .toList());
            return dto;
        }).collect(Collectors.toList());
    }
}
