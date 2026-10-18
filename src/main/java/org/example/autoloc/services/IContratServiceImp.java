package org.example.autoloc.services;

import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Contrat;
import org.example.autoloc.repositories.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IContratServiceImp implements IContratService {
    /*@Autowired
    private ContratRepository contratRepository;*/
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
    public void supprimerContratById(Long idContrat) {
        contratRepository.deleteById(idContrat);

    }
}
