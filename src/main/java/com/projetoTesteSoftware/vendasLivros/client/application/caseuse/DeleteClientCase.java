package com.projetoTesteSoftware.vendasLivros.client.application.caseuse;

import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;
import com.projetoTesteSoftware.vendasLivros.client.domain.port.ClientRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteClientCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public void delete(Long id) {
        Client client = clientRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado para deletar!"));

        clientRepositoryPort.delete(client);
    }
}
