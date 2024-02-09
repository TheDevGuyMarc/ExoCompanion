package de.traumastudios.ExoCompanionAPI.coloration.controller;

import de.traumastudios.ExoCompanionAPI.coloration.domain.Coloration;
import de.traumastudios.ExoCompanionAPI.culture.controller.CultureDTO;
import de.traumastudios.ExoCompanionAPI.landanimal.controller.LandAnimalDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class ColorationDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<CultureDTO> cultures;
    private final List<LandAnimalDTO> animals;

    public ColorationDTO(Coloration entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.cultures = entity.getCultures().stream().map(CultureDTO::new).toList();
        this.animals = entity.getAnimals().stream().map(LandAnimalDTO::new).toList();
    }
}
