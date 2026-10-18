package org.example.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"employes", "vehicules"})
@NoArgsConstructor
@AllArgsConstructor
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    @OneToMany(mappedBy = "agence")
    private List<Employe> employes = new ArrayList<>();

    @OneToMany(mappedBy = "agence")
    private List<Vehicule> vehicules = new ArrayList<>();
}
