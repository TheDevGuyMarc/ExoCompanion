package de.traumastudios.ExoCompanionAPI.plant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<PlantEntity, Long> {
    Optional<PlantEntity> findById(Long id);
    Optional<PlantEntity> findByName(String name);
}
