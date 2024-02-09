package de.traumastudios.ExoCompanionAPI.origin.controller;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.controller.AquaticAnimalDTO;
import de.traumastudios.ExoCompanionAPI.landanimal.controller.LandAnimalDTO;
import de.traumastudios.ExoCompanionAPI.origin.domain.Origin;
import de.traumastudios.ExoCompanionAPI.plant.controller.PlantDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class OriginDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final int tempMin;
    private final int tempMax;
    private final double humidity;
    private final int dayCycleHours;
    private final List<PlantDTO> plants;
    private final List<LandAnimalDTO> landAnimals;
    private final List<AquaticAnimalDTO> aquaticAnimals;

    public OriginDTO(Origin entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.tempMin = entity.getTempMin();
        this.tempMax = entity.getTempMax();
        this.humidity = entity.getHumidity();
        this.dayCycleHours = entity.getDayCycleHours();
        this.plants = entity.getPlants().stream().map(PlantDTO::new).toList();
        this.landAnimals = entity.getLandAnimals().stream().map(LandAnimalDTO::new).toList();
        this.aquaticAnimals = entity.getAquaticAnimals().stream().map(AquaticAnimalDTO::new).toList();
    }
}
