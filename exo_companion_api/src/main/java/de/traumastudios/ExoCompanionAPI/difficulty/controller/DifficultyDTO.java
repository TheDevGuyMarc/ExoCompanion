package de.traumastudios.ExoCompanionAPI.difficulty.controller;

import de.traumastudios.ExoCompanionAPI.difficulty.domain.Difficulty;
import lombok.Getter;

@Getter
public class DifficultyDTO {
    private final Long id;
    private final String name;
    private final String description;

    public DifficultyDTO(Difficulty entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
    }
}
