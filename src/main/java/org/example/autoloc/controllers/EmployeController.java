package org.example.autoloc.controllers;

import org.example.autoloc.entities.Employe;
import org.example.autoloc.services.IEmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    private final IEmployeService employeService;

    public EmployeController(IEmployeService employeService) {
        this.employeService = employeService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Employe> ajouterEmploye(@RequestBody Employe employe) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeService.ajouterEmploye(employe));
    }

    // READ ALL
    @GetMapping
    public List<Employe> consulterEmployes() {
        return employeService.consulterEmployes();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Employe> consulterEmployeById(@PathVariable Long id) {
        Employe employe = employeService.consulterEmployeById(id);
        if (employe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employe);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Employe> modifierEmploye(@PathVariable Long id, @RequestBody Employe employe) {
        if (employeService.consulterEmployeById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        employe.setIdEmploye(id);
        return ResponseEntity.ok(employeService.modifierEmploye(employe));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEmployeById(@PathVariable Long id) {
        if (employeService.consulterEmployeById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        employeService.supprimerEmployeById(id);
        return ResponseEntity.noContent().build();
    }
}
