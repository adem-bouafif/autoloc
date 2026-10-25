package org.example.autoloc.controllers;

import org.example.autoloc.entities.Paiement;
import org.example.autoloc.services.IPaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paiements")
public class PaiementController {

    private final IPaiementService paiementService;

    public PaiementController(IPaiementService paiementService) {
        this.paiementService = paiementService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Paiement> ajouterPaiement(@RequestBody Paiement paiement) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paiementService.ajouterPaiement(paiement));
    }

    // READ ALL
    @GetMapping
    public List<Paiement> consulterPaiements() {
        return paiementService.consulterPaiements();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Paiement> consulterPaiementById(@PathVariable Long id) {
        Paiement paiement = paiementService.consulterPaiementById(id);
        if (paiement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paiement);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Paiement> modifierPaiement(@PathVariable Long id, @RequestBody Paiement paiement) {
        if (paiementService.consulterPaiementById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        paiement.setIdPaiement(id);
        return ResponseEntity.ok(paiementService.modifierPaiement(paiement));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerPaiementById(@PathVariable Long id) {
        if (paiementService.consulterPaiementById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        paiementService.supprimerPaiementById(id);
        return ResponseEntity.noContent().build();
    }
}
