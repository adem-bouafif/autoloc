package org.example.autoloc.controllers;

import org.example.autoloc.entities.Equipement;
import org.example.autoloc.services.IEquipementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
public class EquipementController {

    private final IEquipementService equipementService;

    public EquipementController(IEquipementService equipementService) {
        this.equipementService = equipementService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Equipement> ajouterEquipement(@RequestBody Equipement equipement) {
        return ResponseEntity.status(HttpStatus.CREATED).body(equipementService.ajouterEquipement(equipement));
    }

    // READ ALL
    @GetMapping
    public List<Equipement> consulterEquipements() {
        return equipementService.consulterEquipements();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Equipement> consulterEquipementById(@PathVariable Long id) {
        Equipement equipement = equipementService.consulterEquipementById(id);
        if (equipement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipement);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Equipement> modifierEquipement(@PathVariable Long id, @RequestBody Equipement equipement) {
        if (equipementService.consulterEquipementById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        equipement.setIdEquipement(id);
        return ResponseEntity.ok(equipementService.modifierEquipement(equipement));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEquipementById(@PathVariable Long id) {
        if (equipementService.consulterEquipementById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        equipementService.supprimerEquipementById(id);
        return ResponseEntity.noContent().build();
    }
}
