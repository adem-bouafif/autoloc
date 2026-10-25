package org.example.autoloc.controllers;

import org.example.autoloc.entities.Vehicule;
import org.example.autoloc.services.IVehiculeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    public VehiculeController(IVehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Vehicule> ajouterVehicule(@RequestBody Vehicule vehicule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculeService.ajouterVehicule(vehicule));
    }

    // READ ALL
    @GetMapping
    public List<Vehicule> consulterVehicules() {
        return vehiculeService.consulterVehicules();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> consulterVehiculeById(@PathVariable Long id) {
        Vehicule vehicule = vehiculeService.consulterVehiculeById(id);
        if (vehicule == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicule);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> modifierVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        Vehicule existant = vehiculeService.consulterVehiculeById(id);
        if (existant == null) {
            return ResponseEntity.notFound().build();
        }
        vehicule.setIdVehicule(id);
        // Keep the existing relations so the PUT does not wipe them
        vehicule.setMaintenances(existant.getMaintenances());
        vehicule.setReservations(existant.getReservations());
        vehicule.setEquipements(existant.getEquipements());
        return ResponseEntity.ok(vehiculeService.modifierVehicule(vehicule));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerVehiculeById(@PathVariable Long id) {
        if (vehiculeService.consulterVehiculeById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        vehiculeService.supprimerVehiculeById(id);
        return ResponseEntity.noContent().build();
    }
}