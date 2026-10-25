package org.example.autoloc.services;

import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Equipement;
import org.example.autoloc.repositories.EquipementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IEquipementServiceImp implements IEquipementService {

    private final EquipementRepository equipementRepository;

    @Override
    public Equipement ajouterEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement modifierEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> consulterEquipements() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement consulterEquipementById(Long idEquipement) {
        return equipementRepository.findById(idEquipement).orElse(null);
    }

    @Override
    public void supprimerEquipementById(Long idEquipement) {
        equipementRepository.deleteById(idEquipement);
    }
}
