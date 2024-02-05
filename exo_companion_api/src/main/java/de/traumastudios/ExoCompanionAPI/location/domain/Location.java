package de.traumastudios.ExoCompanionAPI.location.domain;

import de.traumastudios.ExoCompanionAPI.location.repository.LocationEntity;
import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Location {
    private Long id;
    private String name;
    private String description;
    private List<Plant> plants;

    public Location(LocationEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.plants = entity.getPlants().stream().map(Plant::new).toList();
    }
}
