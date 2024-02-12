package de.traumastudios.ExoCompanionAPI.aquaticanimal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AquaticAnimalRepository extends JpaRepository<AquaticAnimalEntity, Long> {
    Optional<AquaticAnimalEntity> findById(Long id);
    Optional<AquaticAnimalEntity> findByName(String name);
}
