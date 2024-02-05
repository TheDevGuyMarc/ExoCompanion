package de.traumastudios.ExoCompanionAPI.coloration.domain;

import de.traumastudios.ExoCompanionAPI.coloration.repository.ColorationEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Coloration {
    private Long id;
    private String name;
    private String description;
    // private List<AquaticAnimal> animals;

    public Coloration(ColorationEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        // this.animals = entity.getAnimals().stream().map(AquaticAnimal::new).toList();
    }
}
