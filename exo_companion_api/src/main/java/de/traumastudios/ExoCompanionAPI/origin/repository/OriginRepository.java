package de.traumastudios.ExoCompanionAPI.origin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OriginRepository extends JpaRepository<OriginEntity, Long> {
    Optional<OriginEntity> findById(Long id);
    Optional<OriginEntity> findByName(String name);
}
