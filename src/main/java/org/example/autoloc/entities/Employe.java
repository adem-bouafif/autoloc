package org.example.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.autoloc.entities.enums.RoleEmploye;

@Entity
@Getter
@Setter
@ToString(exclude = "agence")
@NoArgsConstructor
@AllArgsConstructor
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;

    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private RoleEmploye role;

    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence agence;
}
