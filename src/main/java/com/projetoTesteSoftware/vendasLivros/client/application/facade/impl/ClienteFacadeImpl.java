package com.projetoTesteSoftware.vendasLivros.client.application.facade.impl;

import com.projetoTesteSoftware.vendasLivros.client.api.dto.request.ClientRequestDTO;
import com.projetoTesteSoftware.vendasLivros.client.api.dto.response.ClientResponseDTO;
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
    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) {
        return createClientCase.create(clientRequestDTO);
    }

    @Override
    public List<ClientResponseDTO> findAllClients() {
        return findClientCase.findAll();
    }

    @Override
    public ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO) {
        return updateClientCase.update(id, clientRequestDTO);
    }

    @Override
    public void deleteClient(Long id) {
         deleteClientCase.delete(id);
    }
}
