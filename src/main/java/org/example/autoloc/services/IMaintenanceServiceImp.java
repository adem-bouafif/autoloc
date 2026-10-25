package org.example.autoloc.services;

import lombok.AllArgsConstructor;
import org.example.autoloc.entities.Maintenance;
import org.example.autoloc.repositories.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IMaintenanceServiceImp implements IMaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance ajouterMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance modifierMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> consulterMaintenances() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance consulterMaintenanceById(Long idMaintenance) {
        return maintenanceRepository.findById(idMaintenance).orElse(null);
    }

    @Override
    public void supprimerMaintenanceById(Long idMaintenance) {
        maintenanceRepository.deleteById(idMaintenance);
    }
}
