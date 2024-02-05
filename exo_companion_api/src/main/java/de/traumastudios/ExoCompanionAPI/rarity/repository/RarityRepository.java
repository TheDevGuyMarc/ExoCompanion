package de.traumastudios.ExoCompanionAPI.rarity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RarityRepository extends JpaRepository<RarityEntity, Long> {
    Optional<RarityEntity> findById(Long id);
    Optional<RarityEntity> findByName(String name);
}
