package de.traumastudios.ExoCompanionAPI.origin.domain;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.domain.AquaticAnimal;
import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import de.traumastudios.ExoCompanionAPI.origin.repository.OriginEntity;
import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Origin {
    private Long id;
    private String name;
    private String description;
    private int tempMin;
    private int tempMax;
    private double humidity;
    private int dayCycleHours;
    private List<Plant> plants;
    private List<LandAnimal> landAnimals;
    private List<AquaticAnimal> aquaticAnimals;

    public Origin(OriginEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.tempMin = entity.getTempMin();
        this.tempMax = entity.getTempMax();
        this.humidity = entity.getHumidity();
        this.dayCycleHours = entity.getDayCycleHours();
        this.plants = entity.getPlants().stream().map(Plant::new).toList();
        this.landAnimals = entity.getLandAnimals().stream().map(LandAnimal::new).toList();
        this.aquaticAnimals = entity.getAquaticAnimals().stream().map(AquaticAnimal::new).toList();
    }
}
