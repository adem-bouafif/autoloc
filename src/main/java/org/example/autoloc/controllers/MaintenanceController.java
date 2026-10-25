package org.example.autoloc.controllers;

import org.example.autoloc.entities.Maintenance;
import org.example.autoloc.services.IMaintenanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    public MaintenanceController(IMaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Maintenance> ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return ResponseEntity.status(HttpStatus.CREATED).body(maintenanceService.ajouterMaintenance(maintenance));
    }

    // READ ALL
    @GetMapping
    public List<Maintenance> consulterMaintenances() {
        return maintenanceService.consulterMaintenances();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> consulterMaintenanceById(@PathVariable Long id) {
        Maintenance maintenance = maintenanceService.consulterMaintenanceById(id);
        if (maintenance == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(maintenance);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> modifierMaintenance(@PathVariable Long id, @RequestBody Maintenance maintenance) {
        if (maintenanceService.consulterMaintenanceById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        maintenance.setIdMaintenance(id);
        return ResponseEntity.ok(maintenanceService.modifierMaintenance(maintenance));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMaintenanceById(@PathVariable Long id) {
        if (maintenanceService.consulterMaintenanceById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        maintenanceService.supprimerMaintenanceById(id);
        return ResponseEntity.noContent().build();
    }
}
