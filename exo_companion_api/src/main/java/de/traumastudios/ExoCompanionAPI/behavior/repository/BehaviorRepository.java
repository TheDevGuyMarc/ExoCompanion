package de.traumastudios.ExoCompanionAPI.behavior.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BehaviorRepository extends JpaRepository<BehaviorEntity, Long> {
    Optional<BehaviorEntity> findById(Long id);
    Optional<BehaviorEntity> findByName(String name);
}
