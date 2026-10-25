package org.example.autoloc.controllers;

import org.example.autoloc.entities.Reservation;
import org.example.autoloc.services.IReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Reservation> ajouterReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.ajouterReservation(reservation));
    }

    // READ ALL
    @GetMapping
    public List<Reservation> consulterReservations() {
        return reservationService.consulterReservations();
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> consulterReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.consulterReservationById(id);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservation);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> modifierReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        if (reservationService.consulterReservationById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        reservation.setIdReservation(id);
        return ResponseEntity.ok(reservationService.modifierReservation(reservation));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerReservationById(@PathVariable Long id) {
        if (reservationService.consulterReservationById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        reservationService.supprimerReservationById(id);
        return ResponseEntity.noContent().build();
    }
}
