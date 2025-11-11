package com.projetoTesteSoftware.vendasLivros.book.infrastrucuture;

import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
