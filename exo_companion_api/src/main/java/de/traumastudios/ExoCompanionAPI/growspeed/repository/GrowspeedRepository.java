package de.traumastudios.ExoCompanionAPI.growspeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrowspeedRepository extends JpaRepository<GrowspeedEntity, Long> {
    Optional<GrowspeedEntity> findById(Long id);
    Optional<GrowspeedEntity> findByName(String name);
}
