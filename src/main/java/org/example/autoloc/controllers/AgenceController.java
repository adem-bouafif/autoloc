package org.example.autoloc.controllers;

import org.example.autoloc.entities.Agence;
import org.example.autoloc.services.IAgenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
public class AgenceController {

    private final IAgenceService agenceService;

    public AgenceController(IAgenceService agenceService) {
        this.agenceService = agenceService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Agence> ajouterAgence(@RequestBody Agence agence) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agenceService.ajouterAgence(agence));
    }

    // READ ALL
    @GetMapping
    public List<Agence> consulterAgences() {
        return agenceService.consulterAgences();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Agence> consulterAgenceById(@PathVariable Long id) {
        Agence agence = agenceService.consulterAgenceById(id);
        if (agence == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agence);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Agence> modifierAgence(@PathVariable Long id, @RequestBody Agence agence) {
        if (agenceService.consulterAgenceById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        agence.setIdAgence(id);
        return ResponseEntity.ok(agenceService.modifierAgence(agence));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAgenceById(@PathVariable Long id) {
        if (agenceService.consulterAgenceById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        agenceService.supprimerAgenceById(id);
        return ResponseEntity.noContent().build();
    }
}
