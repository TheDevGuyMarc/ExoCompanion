package de.traumastudios.ExoCompanionAPI.planttype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantTypeRepository extends JpaRepository<PlantTypeEntity, Long> {
    Optional<PlantTypeEntity> findById(Long id);
    Optional<PlantTypeEntity> findByName(String name);
}
