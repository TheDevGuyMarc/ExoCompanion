package de.traumastudios.ExoCompanionAPI.difficulty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DifficultyRepository extends JpaRepository<DifficultyEntity, Long> {
    Optional<DifficultyEntity> findById(Long id);
    Optional<DifficultyEntity> findByName(String name);
}
