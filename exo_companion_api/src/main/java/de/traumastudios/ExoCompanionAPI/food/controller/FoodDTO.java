package de.traumastudios.ExoCompanionAPI.food.controller;

import de.traumastudios.ExoCompanionAPI.food.domain.Food;
import de.traumastudios.ExoCompanionAPI.landanimal.controller.LandAnimalDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class FoodDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final String image;
    private final String manufacturer;
    private final double amount;
    private final double price;
    private final List<LandAnimalDTO> animals;

    public FoodDTO(Food entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
        this.manufacturer = entity.getManufacturer();
        this.amount = entity.getAmount();
        this.price = entity.getPrice();
        this.animals = entity.getAnimals().stream().map(LandAnimalDTO::new).toList();
    }
}
