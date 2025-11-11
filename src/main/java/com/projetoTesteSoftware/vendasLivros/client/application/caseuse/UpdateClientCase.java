package com.projetoTesteSoftware.vendasLivros.client.application.caseuse;

import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;
import com.projetoTesteSoftware.vendasLivros.client.domain.port.ClientRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateClientCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public Client update(Long id, Client client) {
        Client clientFound = clientRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));

        clientFound.setName(client.getName());

        return clientRepositoryPort.save(clientFound);
    }
}
