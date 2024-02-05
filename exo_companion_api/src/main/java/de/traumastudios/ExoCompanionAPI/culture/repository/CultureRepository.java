package de.traumastudios.ExoCompanionAPI.culture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CultureRepository extends JpaRepository<CultureEntity, Long> {
    Optional<CultureEntity> findById(Long id);
    Optional<CultureEntity> findByName(String name);
}
