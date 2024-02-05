package de.traumastudios.ExoCompanionAPI.difficulty.controller;

import de.traumastudios.ExoCompanionAPI.difficulty.domain.Difficulty;
import de.traumastudios.ExoCompanionAPI.plant.controller.PlantDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class DifficultyDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<PlantDTO> plants;

    public DifficultyDTO(Difficulty entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.plants = entity.getPlants().stream().map(PlantDTO::new).toList();
    }
}
