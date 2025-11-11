package com.projetoTesteSoftware.vendasLivros.client.application.facade.impl;

import com.projetoTesteSoftware.vendasLivros.client.application.caseuse.CreateClientCase;
import com.projetoTesteSoftware.vendasLivros.client.application.caseuse.DeleteClientCase;
import com.projetoTesteSoftware.vendasLivros.client.application.caseuse.FindClientCase;
import com.projetoTesteSoftware.vendasLivros.client.application.caseuse.UpdateClientCase;
import com.projetoTesteSoftware.vendasLivros.client.application.facade.ClientFacade;
import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteFacadeImpl implements ClientFacade {
    private final CreateClientCase createClientCase;
    private final FindClientCase findClientCase;
    private final UpdateClientCase updateClientCase;
    private final DeleteClientCase deleteClientCase;


    @Override
    public Client createClient(Client client) {
        return createClientCase.create(client);
    }

    @Override
    public List<Client> findALlClients() {
        return findClientCase.findAll();
    }

    @Override
    public Client updateClient(Long id, Client client) {
        return updateClientCase.update(id, client);
    }

    @Override
    public void deleteClient(Long id) {
        deleteClientCase.delete(id);
    }
}
