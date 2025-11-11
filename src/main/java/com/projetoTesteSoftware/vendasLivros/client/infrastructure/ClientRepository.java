package com.projetoTesteSoftware.vendasLivros.client.infrastructure;

import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
