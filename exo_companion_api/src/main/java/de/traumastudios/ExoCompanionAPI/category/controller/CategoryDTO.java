package de.traumastudios.ExoCompanionAPI.category.controller;

import de.traumastudios.ExoCompanionAPI.category.domain.Category;
import de.traumastudios.ExoCompanionAPI.plant.controller.PlantDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class CategoryDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<PlantDTO> plants;
    // private final List<AquaticAnimalDTO> animals;

    public CategoryDTO(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.plants = entity.getPlants().stream().map(PlantDTO::new).toList();
        // this.animals = entity.getAnimals().stream().map(AquaticAnimalDTO::new).toList();
    }
}
