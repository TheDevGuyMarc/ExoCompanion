package de.traumastudios.ExoCompanionAPI.substrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubstrateRepository extends JpaRepository<SubstrateEntity, Long> {
    Optional<SubstrateEntity> findById(Long id);
    Optional<SubstrateEntity> findByName(String name);
}
