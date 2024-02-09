package de.traumastudios.ExoCompanionAPI.substrate.controller;

import de.traumastudios.ExoCompanionAPI.landanimal.controller.LandAnimalDTO;
import de.traumastudios.ExoCompanionAPI.substrate.domain.Substrate;
import lombok.Getter;

import java.util.List;

@Getter
public class SubstrateDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final String image;
    private final String manufacturer;
    private final double amount;
    private final double price;
    private final List<LandAnimalDTO> animals;

    public SubstrateDTO(Substrate entity) {
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
