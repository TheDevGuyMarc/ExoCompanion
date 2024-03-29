package de.traumastudios.ExoCompanionAPI.rarity.controller;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.controller.AquaticAnimalDTO;
import de.traumastudios.ExoCompanionAPI.landanimal.controller.LandAnimalDTO;
import de.traumastudios.ExoCompanionAPI.plant.controller.PlantDTO;
import de.traumastudios.ExoCompanionAPI.rarity.domain.Rarity;
import lombok.Getter;

import java.util.List;

@Getter
public class RarityDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<PlantDTO> plants;
    private final List<LandAnimalDTO> landAnimals;
    private final List<AquaticAnimalDTO> aquaticAnimals;

    public RarityDTO(Rarity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.plants = entity.getPlants().stream().map(PlantDTO::new).toList();
        this.landAnimals = entity.getLandAnimals().stream().map(LandAnimalDTO::new).toList();
        this.aquaticAnimals = entity.getAquaticAnimals().stream().map(AquaticAnimalDTO::new).toList();
    }
}
