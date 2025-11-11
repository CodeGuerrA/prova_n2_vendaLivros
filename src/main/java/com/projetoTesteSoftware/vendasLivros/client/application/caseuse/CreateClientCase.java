package com.projetoTesteSoftware.vendasLivros.client.application.caseuse;

import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;
import com.projetoTesteSoftware.vendasLivros.client.domain.port.ClientRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateClientCase {
    private final ClientRepositoryPort clientRepositoryPort;

    public Client create(Client client){
        return clientRepositoryPort.save(client);
    }
}
