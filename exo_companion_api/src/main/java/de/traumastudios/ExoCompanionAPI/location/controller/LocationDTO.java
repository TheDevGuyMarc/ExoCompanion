package de.traumastudios.ExoCompanionAPI.location.controller;

import de.traumastudios.ExoCompanionAPI.location.domain.Location;
import lombok.Getter;

@Getter
public class LocationDTO {
    private final Long id;
    private final String name;
    private final String description;

    public LocationDTO(Location entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
    }
}
