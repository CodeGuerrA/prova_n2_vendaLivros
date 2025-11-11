package com.projetoTesteSoftware.vendasLivros.client.application.caseuse;

import com.projetoTesteSoftware.vendasLivros.client.api.dto.request.ClientRequestDTO;
import com.projetoTesteSoftware.vendasLivros.client.api.dto.response.ClientResponseDTO;
import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;
import com.projetoTesteSoftware.vendasLivros.client.domain.port.ClientRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CreateClientCase {
    private final ClientRepositoryPort clientRepositoryPort;

    public ClientResponseDTO create(ClientRequestDTO clientRequestDTO) {

        Client client = new Client();
        client.setName(clientRequestDTO.getName());

        Client savedClient = clientRepositoryPort.save(client);

        ClientResponseDTO response = new ClientResponseDTO();
        response.setId(savedClient.getId());
        response.setName(savedClient.getName());
        response.setSalesIds(new ArrayList<>()); // ✅ Lista vazia, não null

        return response;
    }
}
