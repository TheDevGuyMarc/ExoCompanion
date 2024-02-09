package de.traumastudios.ExoCompanionAPI.coloration.controller;

import de.traumastudios.ExoCompanionAPI.coloration.domain.Coloration;
import de.traumastudios.ExoCompanionAPI.culture.controller.CultureDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class ColorationDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<CultureDTO> cultures;
    // private final List<AquaticAnimalDTO> animals;

    public ColorationDTO(Coloration entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.cultures = entity.getCultures().stream().map(CultureDTO::new).toList();
        // this.animals = entity.getAnimals().stream().map(AquaticAnimalDTO::new).toList();
    }
}
