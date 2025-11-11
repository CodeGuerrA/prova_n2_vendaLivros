package com.projetoTesteSoftware.vendasLivros.client.application.facade;

import com.projetoTesteSoftware.vendasLivros.client.api.dto.request.ClientRequestDTO;
import com.projetoTesteSoftware.vendasLivros.client.api.dto.response.ClientResponseDTO;
import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;

import java.util.List;

public interface ClientFacade {


    // Cria cliente usando DTO de request e retorna DTO de response
    ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO);

    // Lista todos os clientes
    List<ClientResponseDTO> findAllClients();

    // Atualiza cliente usando DTO de request
    ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO);

    // Deleta cliente (pode retornar void ou DTO)
    void deleteClient(Long id);
}

