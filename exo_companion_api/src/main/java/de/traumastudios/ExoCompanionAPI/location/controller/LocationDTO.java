package de.traumastudios.ExoCompanionAPI.location.controller;

import de.traumastudios.ExoCompanionAPI.location.domain.Location;
import de.traumastudios.ExoCompanionAPI.plant.controller.PlantDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class LocationDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<PlantDTO> plants;

    public LocationDTO(Location entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.plants = entity.getPlants().stream().map(PlantDTO::new).toList();
    }
}
