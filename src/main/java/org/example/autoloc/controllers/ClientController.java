package org.example.autoloc.controllers;

import org.example.autoloc.entities.Client;
import org.example.autoloc.services.IClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Client> ajouterClient(@RequestBody Client client) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.ajouterClient(client));
    }

    // READ ALL
    @GetMapping
    public List<Client> consulterClients() {
        return clientService.consulterClients();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Client> consulterClientById(@PathVariable Long id) {
        Client client = clientService.consulterClientById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Client> modifierClient(@PathVariable Long id, @RequestBody Client client) {
        if (clientService.consulterClientById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        client.setIdClient(id);
        return ResponseEntity.ok(clientService.modifierClient(client));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerClientById(@PathVariable Long id) {
        if (clientService.consulterClientById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        clientService.supprimerClientById(id);
        return ResponseEntity.noContent().build();
    }
}
