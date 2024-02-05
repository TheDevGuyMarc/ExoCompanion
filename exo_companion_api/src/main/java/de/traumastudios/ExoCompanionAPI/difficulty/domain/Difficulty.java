package de.traumastudios.ExoCompanionAPI.difficulty.domain;

import de.traumastudios.ExoCompanionAPI.difficulty.repository.DifficultyEntity;
import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Difficulty {
    private Long id;
    private String name;
    private String description;
    private List<Plant> plants;

    public Difficulty(DifficultyEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.plants = entity.getPlants().stream().map(Plant::new).toList();
    }
}
