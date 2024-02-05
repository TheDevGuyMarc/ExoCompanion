package de.traumastudios.ExoCompanionAPI.difficulty.domain;

import de.traumastudios.ExoCompanionAPI.difficulty.repository.DifficultyEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Difficulty {
    private Long id;
    private String name;
    private String description;

    public Difficulty(DifficultyEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
    }
}
