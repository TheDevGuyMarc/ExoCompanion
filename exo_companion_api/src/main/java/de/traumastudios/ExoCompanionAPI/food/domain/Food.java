package de.traumastudios.ExoCompanionAPI.food.domain;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.domain.AquaticAnimal;
import de.traumastudios.ExoCompanionAPI.food.repository.FoodEntity;
import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Food {
    private Long id;
    private String name;
    private String description;
    private byte[] image;
    private String manufacturer;
    private double amount;
    private double price;
    private List<LandAnimal> landAnimals;
    private List<AquaticAnimal> aquaticAnimals;

    public Food(FoodEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
        this.manufacturer = entity.getManufacturer();
        this.amount = entity.getAmount();
        this.price = entity.getPrice();
        this.landAnimals = entity.getLandAnimals().stream().map(LandAnimal::new).toList();
        this.aquaticAnimals = entity.getAquaticAnimals().stream().map(AquaticAnimal::new).toList();
    }
}
