package de.traumastudios.ExoCompanionAPI.requirement.domain;

import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import de.traumastudios.ExoCompanionAPI.requirement.repository.RequirementEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Requirement {
    private Long id;
    private String name;
    private String description;
    private List<LandAnimal> animals;

    public Requirement(RequirementEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.animals = entity.getAnimals().stream().map(LandAnimal::new).toList();
    }
}
