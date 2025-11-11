package com.projetoTesteSoftware.vendasLivros.book.api;

import com.projetoTesteSoftware.vendasLivros.book.api.dto.request.BookRequestDTO;
import com.projetoTesteSoftware.vendasLivros.book.api.dto.response.BookResponseDTO;
import com.projetoTesteSoftware.vendasLivros.book.application.facade.BookFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookFacade bookFacade;

    // Cria um novo livro
    @PostMapping
    public ResponseEntity<BookResponseDTO> create(@RequestBody BookRequestDTO bookRequestDTO,
                                                  @RequestParam Long authorId,
                                                  @RequestParam Long stockId) {
        BookResponseDTO savedBook = bookFacade.createBook(bookRequestDTO, authorId, stockId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    // Lista todos os livros
    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> findAll() {
        List<BookResponseDTO> books = bookFacade.findAllBooks();
        return ResponseEntity.ok(books);
    }

    // Atualiza um livro existente
    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> update(@PathVariable Long id,
                                                  @RequestParam Long authorId,
                                                  @RequestParam Long stockId,
                                                  @RequestBody BookRequestDTO bookRequestDTO) {
        BookResponseDTO updated = bookFacade.updateBook(id, bookRequestDTO,stockId,authorId);
        return ResponseEntity.ok(updated);
    }

    // Deleta um livro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookFacade.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
