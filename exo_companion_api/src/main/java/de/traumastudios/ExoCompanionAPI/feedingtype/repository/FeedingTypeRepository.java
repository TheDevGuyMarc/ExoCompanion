package de.traumastudios.ExoCompanionAPI.feedingtype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedingTypeRepository extends JpaRepository<FeedingTypeEntity, Long> {
    Optional<FeedingTypeEntity> findById(Long id);
    Optional<FeedingTypeEntity> findByName(String name);
}
