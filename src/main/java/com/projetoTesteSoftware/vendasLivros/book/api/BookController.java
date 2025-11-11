package com.projetoTesteSoftware.vendasLivros.book.api;

import com.projetoTesteSoftware.vendasLivros.book.application.facade.BookFacade;
import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import jakarta.persistence.EntityNotFoundException;
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

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book, @PathVariable Long authorId, @PathVariable Long bookId) {
        Book savedBook = bookFacade.createBook(book, authorId, bookId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookFacade.findAllBooks());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {
        Book updated = bookFacade.updateBook(id, book);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookFacade.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
