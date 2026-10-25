package org.example.autoloc.repositories;

import org.example.autoloc.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
}
