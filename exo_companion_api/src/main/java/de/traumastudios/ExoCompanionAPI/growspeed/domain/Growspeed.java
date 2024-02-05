package de.traumastudios.ExoCompanionAPI.growspeed.domain;

import de.traumastudios.ExoCompanionAPI.culture.domain.Culture;
import de.traumastudios.ExoCompanionAPI.growspeed.repository.GrowspeedEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Growspeed {
    private Long id;
    private String name;
    private String description;
    private List<Culture> cultures;

    public Growspeed(GrowspeedEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.cultures = entity.getCultures().stream().map(Culture::new).toList();
    }
}
