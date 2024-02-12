package de.traumastudios.ExoCompanionAPI.landanimal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LandAnimalRepository extends JpaRepository<LandAnimalEntity, Long> {
    Optional<LandAnimalEntity> findById(Long id);
    Optional<LandAnimalEntity> findByName(String name);
}
