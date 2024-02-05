package de.traumastudios.ExoCompanionAPI.coloration.controller;

import de.traumastudios.ExoCompanionAPI.coloration.domain.Coloration;
import lombok.Getter;

import java.util.List;

@Getter
public class ColorationDTO {
    private final Long id;
    private final String name;
    private final String description;
    // private final List<AquaticAnimalDTO> animals;

    public ColorationDTO(Coloration entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        // this.animals = entity.getAnimals().stream().map(AquaticAnimalDTO::new).toList();
    }
}
