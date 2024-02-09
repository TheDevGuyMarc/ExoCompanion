package de.traumastudios.ExoCompanionAPI.behavior.domain;

import de.traumastudios.ExoCompanionAPI.behavior.repository.BehaviorEntity;
import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Behavior {
    private Long id;
    private String name;
    private String description;
    private List<LandAnimal> animals;

    public Behavior(BehaviorEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.animals = entity.getAnimals().stream().map(LandAnimal::new).toList();
    }
}
