package de.traumastudios.ExoCompanionAPI.feedingtype.controller;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.controller.AquaticAnimalDTO;
import de.traumastudios.ExoCompanionAPI.feedingtype.domain.FeedingType;
import de.traumastudios.ExoCompanionAPI.landanimal.controller.LandAnimalDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class FeedingTypeDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<LandAnimalDTO> landAnimals;
    private final List<AquaticAnimalDTO> aquaticAnimals;

    public FeedingTypeDTO(FeedingType entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.landAnimals = entity.getLandAnimals().stream().map(LandAnimalDTO::new).toList();
        this.aquaticAnimals = entity.getAquaticAnimals().stream().map(AquaticAnimalDTO::new).toList();
    }
}
