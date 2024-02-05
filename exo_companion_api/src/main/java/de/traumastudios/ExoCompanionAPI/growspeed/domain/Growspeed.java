package de.traumastudios.ExoCompanionAPI.growspeed.domain;

import de.traumastudios.ExoCompanionAPI.growspeed.repository.GrowspeedEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Growspeed {
    private Long id;
    private String name;
    private String description;

    public Growspeed(GrowspeedEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
    }
}
