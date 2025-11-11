package com.projetoTesteSoftware.vendasLivros.client.application.caseuse;

import com.projetoTesteSoftware.vendasLivros.client.api.dto.request.ClientRequestDTO;
import com.projetoTesteSoftware.vendasLivros.client.api.dto.response.ClientResponseDTO;
import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;
import com.projetoTesteSoftware.vendasLivros.client.domain.port.ClientRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateClientCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public ClientResponseDTO update(Long id, ClientRequestDTO clientRequestDTO) {
        // Busca o cliente existente
        Client clientFound = clientRepositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado!"));

        // Atualiza os campos do cliente
        clientFound.setName(clientRequestDTO.getName());

        // Salva as alterações
        Client updatedClient = clientRepositoryPort.save(clientFound);

        // Converte para DTO de resposta
        ClientResponseDTO response = new ClientResponseDTO();
        response.setId(updatedClient.getId());
        response.setName(updatedClient.getName());
        response.setSalesIds(updatedClient.getSales().stream()
                .map(sale -> sale.getId())
                .toList());

        return response;
    }
}
