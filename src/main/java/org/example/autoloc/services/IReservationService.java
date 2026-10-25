package org.example.autoloc.services;

import org.example.autoloc.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation reservation);
    Reservation modifierReservation(Reservation reservation);
    List<Reservation> consulterReservations();
    Reservation consulterReservationById(Long idReservation);
    void supprimerReservationById(Long idReservation);
}
