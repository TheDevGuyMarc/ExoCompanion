package de.traumastudios.ExoCompanionAPI.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
    Optional<FoodEntity> findById(Long id);
    Optional<FoodEntity> findByName(String name);
}
