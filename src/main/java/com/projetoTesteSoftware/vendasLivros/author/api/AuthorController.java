package com.projetoTesteSoftware.vendasLivros.author.api;

import com.projetoTesteSoftware.vendasLivros.author.application.facade.AuthorFacade;
import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
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

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody Author author) {
        Author createdAuthor = authorFacade.createAuthor(author);
        return ResponseEntity.created(URI.create("/authors/" + createdAuthor.getId()))
                .body(createdAuthor);
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAll() {
        return ResponseEntity.ok(authorFacade.findAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        Author author = authorFacade.findAllAuthors().stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        return ResponseEntity.ok(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@RequestBody Author author, @PathVariable Long id) {
        Author updatedAuthor = authorFacade.updateAuthor(author, id);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorFacade.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
