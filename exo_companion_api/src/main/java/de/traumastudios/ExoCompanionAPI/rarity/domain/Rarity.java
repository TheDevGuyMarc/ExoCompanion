package de.traumastudios.ExoCompanionAPI.rarity.domain;

import de.traumastudios.ExoCompanionAPI.rarity.repository.RarityEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Rarity {
    private Long id;
    private String name;
    private String description;
    // private List<LandAnimal> animals;

    public Rarity(RarityEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        // this.animals = entity.getAnimals().stream().map(LandAnimal::new).toList();
    }
}
