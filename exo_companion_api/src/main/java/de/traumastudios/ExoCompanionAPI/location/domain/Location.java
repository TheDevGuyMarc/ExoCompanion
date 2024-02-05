package de.traumastudios.ExoCompanionAPI.location.domain;

import de.traumastudios.ExoCompanionAPI.location.repository.LocationEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private Long id;
    private String name;
    private String description;

    public Location(LocationEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
    }
}
