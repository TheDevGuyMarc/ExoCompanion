package de.traumastudios.ExoCompanionAPI.planttype.controller;

import de.traumastudios.ExoCompanionAPI.planttype.domain.PlantType;
import lombok.Getter;

@Getter
public class PlantTypeDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final byte[] image;

    public PlantTypeDTO(PlantType entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
    }
}
