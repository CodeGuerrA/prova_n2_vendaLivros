package com.projetoTesteSoftware.vendasLivros.sale.infrastructure;

import com.projetoTesteSoftware.vendasLivros.book.domain.entity.Book;
import com.projetoTesteSoftware.vendasLivros.sale.domain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
