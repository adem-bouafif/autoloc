package org.example.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.autoloc.entities.enums.StatutReservation;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString(exclude = {"client", "vehicule", "contrat"})
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    @OneToOne(mappedBy = "reservation")
    private Contrat contrat;
}
