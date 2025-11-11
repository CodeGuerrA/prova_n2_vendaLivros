package com.projetoTesteSoftware.vendasLivros.author.infrastructure;

import com.projetoTesteSoftware.vendasLivros.author.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
