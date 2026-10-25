package org.example.autoloc.services;

import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Contrat;
import org.example.autoloc.repositories.ContratRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class IContratServiceImp implements IContratService {

    private final ContratRepository contratRepository;

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat modifierContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> consulterContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat consulterContratById(Long idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    @Transactional
    public void supprimerContratById(Long idContrat) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        if (contrat == null) {
            return;
        }
        // Break the link on the Reservation side (mappedBy) so Hibernate does not
        // flush a Reservation that still points to a deleted Contrat
        if (contrat.getReservation() != null) {
            contrat.getReservation().setContrat(null);
        }
        contratRepository.delete(contrat);
    }
}