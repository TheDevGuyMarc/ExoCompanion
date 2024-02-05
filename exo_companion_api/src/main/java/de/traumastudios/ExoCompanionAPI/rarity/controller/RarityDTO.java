package de.traumastudios.ExoCompanionAPI.rarity.controller;

import de.traumastudios.ExoCompanionAPI.rarity.domain.Rarity;
import lombok.Getter;

import java.util.List;

@Getter
public class RarityDTO {
    private final Long id;
    private final String name;
    private final String description;
    // private final List<LandAnimalDTO> animals;

    public RarityDTO(Rarity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        // this.animals = entity.getAnimals().stream().map(LandAnimalDTO::new).toList();
    }
}
