package de.traumastudios.ExoCompanionAPI.category.domain;

import de.traumastudios.ExoCompanionAPI.category.repository.CategoryEntity;
import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category {
    private Long id;
    private String name;
    private String description;
    private List<Plant> plants;
    // private List<AquaticAnimal> animals;

    public Category(CategoryEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.plants = entity.getPlants().stream().map(Plant::new).toList();
        // this.animals = entity.getAnimals().stream().map(AquaticAnimal::new).toList();
    }
}
