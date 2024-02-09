package de.traumastudios.ExoCompanionAPI.food.domain;

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
    private String image;
    private String manufacturer;
    private double amount;
    private double price;
    private List<LandAnimal> animals;

    public Food(FoodEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
        this.manufacturer = entity.getManufacturer();
        this.amount = entity.getAmount();
        this.price = entity.getPrice();
        this.animals = entity.getAnimals().stream().map(LandAnimal::new).toList();
    }
}
