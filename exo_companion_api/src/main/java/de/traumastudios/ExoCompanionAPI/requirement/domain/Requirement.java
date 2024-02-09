package de.traumastudios.ExoCompanionAPI.requirement.domain;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.domain.AquaticAnimal;
import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import de.traumastudios.ExoCompanionAPI.requirement.repository.RequirementEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Requirement {
    private Long id;
    private String name;
    private String description;
    private List<LandAnimal> landAnimals;
    private List<AquaticAnimal> aquaticAnimals;

    public Requirement(RequirementEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.landAnimals = entity.getLandAnimals().stream().map(LandAnimal::new).toList();
        this.aquaticAnimals = entity.getAquaticAnimals().stream().map(AquaticAnimal::new).toList();
    }
}
