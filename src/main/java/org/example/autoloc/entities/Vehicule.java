package org.example.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.autoloc.entities.enums.CategorieVehicule;
import org.example.autoloc.entities.enums.StatutVehicule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"agence", "maintenances", "equipements", "reservations"})
@NoArgsConstructor
@AllArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    @Column(unique = true)
    private String immatriculation;

    private String marque;
    private String modele;

    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;

    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Maintenance> maintenances = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id")
    )
    private List<Equipement> equipements = new ArrayList<>();

    @OneToMany(mappedBy = "vehicule")
    private List<Reservation> reservations = new ArrayList<>();
}
