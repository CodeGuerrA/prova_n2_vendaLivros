package com.projetoTesteSoftware.vendasLivros.saleitem.repository;

import com.projetoTesteSoftware.vendasLivros.saleitem.domain.entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}
