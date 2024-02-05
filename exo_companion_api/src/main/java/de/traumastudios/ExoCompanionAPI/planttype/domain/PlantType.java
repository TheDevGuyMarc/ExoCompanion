package de.traumastudios.ExoCompanionAPI.planttype.domain;

import de.traumastudios.ExoCompanionAPI.planttype.repository.PlantTypeEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlantType {
    private Long id;
    private String name;
    private String description;
    private byte[] image;

    public PlantType(PlantTypeEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
    }
}
