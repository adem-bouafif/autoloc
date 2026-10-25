package org.example.autoloc.repositories;

import org.example.autoloc.entities.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}
