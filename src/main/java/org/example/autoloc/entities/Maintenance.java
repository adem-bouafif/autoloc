package org.example.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString(exclude = "vehicule")
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;
}
