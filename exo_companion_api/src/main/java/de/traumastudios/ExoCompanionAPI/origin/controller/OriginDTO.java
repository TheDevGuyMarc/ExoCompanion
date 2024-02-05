package de.traumastudios.ExoCompanionAPI.origin.controller;

import de.traumastudios.ExoCompanionAPI.origin.domain.Origin;
import lombok.Getter;

@Getter
public class OriginDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final int tempMin;
    private final int tempMax;
    private final double humidity;
    private final int dayCycleHours;
    // private final List<AquaticAnimalDTO> animals;

    public OriginDTO(Origin entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.tempMin = entity.getTempMin();
        this.tempMax = entity.getTempMax();
        this.humidity = entity.getHumidity();
        this.dayCycleHours = entity.getDayCycleHours();
        // this.animals = entity.getAnimals().stream().map(AquaticAnimalDTO::new).toList();
    }
}
