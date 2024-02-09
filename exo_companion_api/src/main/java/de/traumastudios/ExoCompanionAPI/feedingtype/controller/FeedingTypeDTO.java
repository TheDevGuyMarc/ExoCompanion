package de.traumastudios.ExoCompanionAPI.feedingtype.controller;

import de.traumastudios.ExoCompanionAPI.feedingtype.domain.FeedingType;
import de.traumastudios.ExoCompanionAPI.landanimal.controller.LandAnimalDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class FeedingTypeDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<LandAnimalDTO> animals;

    public FeedingTypeDTO(FeedingType entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.animals = entity.getAnimals().stream().map(LandAnimalDTO::new).toList();
    }
}
