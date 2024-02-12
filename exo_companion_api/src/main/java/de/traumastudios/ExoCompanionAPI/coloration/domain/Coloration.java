package de.traumastudios.ExoCompanionAPI.coloration.domain;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.domain.AquaticAnimal;
import de.traumastudios.ExoCompanionAPI.coloration.repository.ColorationEntity;
import de.traumastudios.ExoCompanionAPI.culture.domain.Culture;
import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Coloration {
    private Long id;
    private String name;
    private String description;
    private List<Culture> cultures;
    private List<LandAnimal> landAnimals;
    private List<AquaticAnimal> aquaticAnimals;

    public Coloration(ColorationEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.cultures = entity.getCultures().stream().map(Culture::new).toList();
        this.landAnimals = entity.getLandAnimals().stream().map(LandAnimal::new).toList();
        this.aquaticAnimals = entity.getAquaticAnimals().stream().map(AquaticAnimal::new).toList();
    }
}
