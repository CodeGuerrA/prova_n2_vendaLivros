package com.projetoTesteSoftware.vendasLivros.author.infrastructure.adapter;

import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import com.projetoTesteSoftware.vendasLivros.author.domain.port.AuthorRepositoryPort;
import com.projetoTesteSoftware.vendasLivros.author.infrastructure.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorRepositoryAdapter implements AuthorRepositoryPort {

    private final AuthorRepository authorRepository;

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public List<Author> findByAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findbyID(Long authorId) {
        return authorRepository.findById(authorId);
    }
}
