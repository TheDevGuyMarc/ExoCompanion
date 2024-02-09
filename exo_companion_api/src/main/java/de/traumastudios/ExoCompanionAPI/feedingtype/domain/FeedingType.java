package de.traumastudios.ExoCompanionAPI.feedingtype.domain;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.domain.AquaticAnimal;
import de.traumastudios.ExoCompanionAPI.feedingtype.repository.FeedingTypeEntity;
import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FeedingType {
    private Long id;
    private String name;
    private String description;
    private List<LandAnimal> landAnimals;
    private List<AquaticAnimal> aquaticAnimals;

    public FeedingType(FeedingTypeEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.landAnimals = entity.getLandAnimals().stream().map(LandAnimal::new).toList();
        this.aquaticAnimals = entity.getAquaticAnimals().stream().map(AquaticAnimal::new).toList();
    }
}
