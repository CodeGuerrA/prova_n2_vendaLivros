package com.projetoTesteSoftware.vendasLivros.author.api.dto.response;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponseDTO {

    private Long id;
    private String name;
    private List<String> bookNames = new ArrayList<>(); // Nomes dos livros
    private List<Long> bookIds = new ArrayList<>();    // IDs dos livros
}

