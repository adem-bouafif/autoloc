package org.example.autoloc.controllers;

import org.example.autoloc.entities.Contrat;
import org.example.autoloc.services.IContratService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {

    private final IContratService contratService;

    public ContratController(IContratService contratService) {
        this.contratService = contratService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Contrat> ajouterContrat(@RequestBody Contrat contrat) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contratService.ajouterContrat(contrat));
    }

    // READ ALL
    @GetMapping
    public List<Contrat> consulterContrats() {
        return contratService.consulterContrats();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Contrat> consulterContratById(@PathVariable Long id) {
        Contrat contrat = contratService.consulterContratById(id);
        if (contrat == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contrat);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Contrat> modifierContrat(@PathVariable Long id, @RequestBody Contrat contrat) {
        Contrat existant = contratService.consulterContratById(id);
        if (existant == null) {
            return ResponseEntity.notFound().build();
        }
        contrat.setIdContrat(id);
        contrat.setPaiements(existant.getPaiements()); // on garde les paiements existants
        return ResponseEntity.ok(contratService.modifierContrat(contrat));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerContratById(@PathVariable Long id) {
        if (contratService.consulterContratById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        contratService.supprimerContratById(id);
        return ResponseEntity.noContent().build();
    }
}
