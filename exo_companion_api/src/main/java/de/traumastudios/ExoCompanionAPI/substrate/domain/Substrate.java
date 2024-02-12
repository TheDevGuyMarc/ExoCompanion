package de.traumastudios.ExoCompanionAPI.substrate.domain;

import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import de.traumastudios.ExoCompanionAPI.substrate.repository.SubstrateEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Substrate {
    private Long id;
    private String name;
    private String description;
    private byte[] image;
    private String manufacturer;
    private double amount;
    private double price;
    private List<LandAnimal> animals;

    public Substrate(SubstrateEntity entity) {
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
