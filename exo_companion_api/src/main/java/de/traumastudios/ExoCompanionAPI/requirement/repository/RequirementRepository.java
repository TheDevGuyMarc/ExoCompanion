package de.traumastudios.ExoCompanionAPI.requirement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequirementRepository extends JpaRepository<RequirementEntity, Long> {
    Optional<RequirementEntity> findById(Long id);
    Optional<RequirementEntity> findByName(String name);
}
