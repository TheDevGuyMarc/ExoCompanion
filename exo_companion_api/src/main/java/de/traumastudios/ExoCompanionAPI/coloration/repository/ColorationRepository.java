package de.traumastudios.ExoCompanionAPI.coloration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColorationRepository extends JpaRepository<ColorationEntity, Long> {
    Optional<ColorationEntity> findById(Long id);
    Optional<ColorationEntity> findByName(String name);
}
