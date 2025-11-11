package com.projetoTesteSoftware.vendasLivros.client.application.caseuse;

import com.projetoTesteSoftware.vendasLivros.client.api.dto.response.ClientResponseDTO;
import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;
import com.projetoTesteSoftware.vendasLivros.client.domain.port.ClientRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindClientCase {

    private final ClientRepositoryPort clientRepositoryPort;

    public List<ClientResponseDTO> findAll() {
        List<Client> clients = clientRepositoryPort.findAll();

        // Converte cada Client em ClientResponseDTO
        return clients.stream().map(client -> {
            ClientResponseDTO dto = new ClientResponseDTO();
            dto.setId(client.getId());
            dto.setName(client.getName());
            dto.setSalesIds(client.getSales().stream()
                    .map(sale -> sale.getId())
                    .toList());
            return dto;
        }).toList();
    }
}
