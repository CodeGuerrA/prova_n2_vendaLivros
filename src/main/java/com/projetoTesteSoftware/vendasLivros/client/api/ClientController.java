package com.projetoTesteSoftware.vendasLivros.client.api;

import com.projetoTesteSoftware.vendasLivros.client.api.dto.request.ClientRequestDTO;
import com.projetoTesteSoftware.vendasLivros.client.api.dto.response.ClientResponseDTO;
import com.projetoTesteSoftware.vendasLivros.client.application.facade.ClientFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientFacade clientFacade;

    // Cria um novo cliente
    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO createdClient = clientFacade.createClient(clientRequestDTO);
        return ResponseEntity.ok(createdClient);
    }

    // Lista todos os clientes
    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAllClients() {
        List<ClientResponseDTO> clients = clientFacade.findAllClients();
        return ResponseEntity.ok(clients);
    }

    // Atualiza cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable Long id,
                                                          @RequestBody ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO updatedClient = clientFacade.updateClient(id, clientRequestDTO);
        return ResponseEntity.ok(updatedClient);
    }

    // Deleta cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientFacade.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
