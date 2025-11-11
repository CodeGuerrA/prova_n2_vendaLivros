package com.projetoTesteSoftware.vendasLivros.author.api;

import com.projetoTesteSoftware.vendasLivros.author.api.dto.request.AuthorRequestDTO;
import com.projetoTesteSoftware.vendasLivros.author.api.dto.response.AuthorResponseDTO;
import com.projetoTesteSoftware.vendasLivros.author.application.facade.AuthorFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorFacade authorFacade;

    // Cria um novo autor
    @PostMapping
    public ResponseEntity<AuthorResponseDTO> create(@RequestBody AuthorRequestDTO authorRequestDTO) {
        AuthorResponseDTO createdAuthor = authorFacade.createAuthor(authorRequestDTO);
        return ResponseEntity.created(URI.create("/authors/" + createdAuthor.getId()))
                .body(createdAuthor);
    }

    // Lista todos os autores
    @GetMapping
    public ResponseEntity<List<AuthorResponseDTO>> findAll() {
        List<AuthorResponseDTO> authors = authorFacade.findAllAuthors();
        return ResponseEntity.ok(authors);
    }

    // Retorna autor por id
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> findById(@PathVariable Long id) {
        AuthorResponseDTO author = authorFacade.findAllAuthors().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        return ResponseEntity.ok(author);
    }

    // Atualiza autor existente
    @PutMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> update(@PathVariable Long id,
                                                    @RequestBody AuthorRequestDTO authorRequestDTO) {
        AuthorResponseDTO updatedAuthor = authorFacade.updateAuthor(id, authorRequestDTO);
        return ResponseEntity.ok(updatedAuthor);
    }

    // Deleta autor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorFacade.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
