package org.example.autoloc.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.autoloc.entities.enums.ModePaiement;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString(exclude = "contrat")
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;

    private BigDecimal montant;
    private LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;

    @ManyToOne(optional = false)
    @JoinColumn(name = "contrat_id", nullable = false)
    private Contrat contrat;
}
