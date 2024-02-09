package de.traumastudios.ExoCompanionAPI.requirement.controller;

import de.traumastudios.ExoCompanionAPI.landanimal.controller.LandAnimalDTO;
import de.traumastudios.ExoCompanionAPI.requirement.domain.Requirement;
import lombok.Getter;

import java.util.List;

@Getter
public class RequirementDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<LandAnimalDTO> animals;

    public RequirementDTO(Requirement entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.animals = entity.getAnimals().stream().map(LandAnimalDTO::new).toList();
    }
}
