package de.traumastudios.ExoCompanionAPI.planttype.controller;

import de.traumastudios.ExoCompanionAPI.plant.controller.PlantDTO;
import de.traumastudios.ExoCompanionAPI.planttype.domain.PlantType;
import lombok.Getter;

import java.util.List;

@Getter
public class PlantTypeDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final byte[] image;
    private final List<PlantDTO> plants;

    public PlantTypeDTO(PlantType entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
        this.plants = entity.getPlants().stream().map(PlantDTO::new).toList();
    }
}
