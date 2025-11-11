package com.projetoTesteSoftware.vendasLivros.client.domain.port;

import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {
    Client save(Client client);

    List<Client> findAll();

    Optional<Client> findById(Long id);

    void delete(Client client);
}
