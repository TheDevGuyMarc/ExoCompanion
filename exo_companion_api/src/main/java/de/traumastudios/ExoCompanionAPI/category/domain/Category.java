package de.traumastudios.ExoCompanionAPI.category.domain;

import de.traumastudios.ExoCompanionAPI.category.repository.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Long id;
    private String name;
    private String description;
    // private List<AquaticAnimal> animals;

    public Category(CategoryEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        // this.animals = entity.getAnimals().stream().map(AquaticAnimal::new).toList();
    }
}
