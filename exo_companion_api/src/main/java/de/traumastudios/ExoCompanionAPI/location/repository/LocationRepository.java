package de.traumastudios.ExoCompanionAPI.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
    Optional<LocationEntity> findById(Long id);
    Optional<LocationEntity> findByName(String name);
}
