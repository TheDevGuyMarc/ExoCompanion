package de.traumastudios.ExoCompanionAPI.growspeed.controller;

import de.traumastudios.ExoCompanionAPI.culture.controller.CultureDTO;
import de.traumastudios.ExoCompanionAPI.growspeed.domain.Growspeed;
import lombok.Getter;

import java.util.List;

@Getter
public class GrowspeedDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<CultureDTO> cultures;

    public GrowspeedDTO(Growspeed entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.cultures = entity.getCultures().stream().map(CultureDTO::new).toList();
    }
}
