package de.traumastudios.ExoCompanionAPI.growspeed.controller;

import de.traumastudios.ExoCompanionAPI.growspeed.domain.Growspeed;
import lombok.Getter;

@Getter
public class GrowspeedDTO {
    private final Long id;
    private final String name;
    private final String description;

    public GrowspeedDTO(Growspeed entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
    }
}
