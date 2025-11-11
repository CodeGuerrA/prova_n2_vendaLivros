package com.projetoTesteSoftware.vendasLivros.client.infrastructure;

import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
