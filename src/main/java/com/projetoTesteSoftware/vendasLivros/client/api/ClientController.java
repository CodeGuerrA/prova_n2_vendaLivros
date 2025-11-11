package com.projetoTesteSoftware.vendasLivros.client.api;

import com.projetoTesteSoftware.vendasLivros.client.application.facade.ClientFacade;
import com.projetoTesteSoftware.vendasLivros.client.domain.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientFacade clientFacade;

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientFacade.createClient(client));
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAllClients() {
        return ResponseEntity.ok(clientFacade.findALlClients());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        return ResponseEntity.ok(clientFacade.updateClient(id, client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientFacade.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
