package de.traumastudios.ExoCompanionAPI.behavior.controller;

import de.traumastudios.ExoCompanionAPI.behavior.domain.Behavior;
import de.traumastudios.ExoCompanionAPI.landanimal.controller.LandAnimalDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class BehaviorDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<LandAnimalDTO> animals;

    public BehaviorDTO(Behavior entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.animals = entity.getAnimals().stream().map(LandAnimalDTO::new).toList();
    }
}
