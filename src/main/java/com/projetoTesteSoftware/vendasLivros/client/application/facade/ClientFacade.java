package com.projetoTesteSoftware.vendasLivros.client.application.facade;

import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;

import java.util.List;

public interface ClientFacade {

    Client createClient(Client client);

    List<Client> findALlClients();

    Client updateClient(Long id, Client client);

    void deleteClient(Long id);

}
