package de.traumastudios.ExoCompanionAPI.food.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.food.domain.Food;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "foods")
@Getter
@Setter
@NoArgsConstructor
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String image;

    @Column
    private String manufacturer;

    @Column
    private double amount;

    @Column
    private double price;

    @ManyToMany(mappedBy = "foods")
    @JsonBackReference
    private List<LandAnimalEntity> animals;

    public FoodEntity(Food entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
        this.manufacturer = entity.getManufacturer();
        this.amount = entity.getAmount();
        this.price = entity.getPrice();
        this.animals = entity.getAnimals().stream().map(LandAnimalEntity::new).toList();
    }
}
