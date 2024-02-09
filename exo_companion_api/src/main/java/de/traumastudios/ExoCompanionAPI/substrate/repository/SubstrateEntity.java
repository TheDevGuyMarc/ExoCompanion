package de.traumastudios.ExoCompanionAPI.substrate.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalEntity;
import de.traumastudios.ExoCompanionAPI.substrate.domain.Substrate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "substrates")
@Getter
@Setter
@NoArgsConstructor
public class SubstrateEntity {
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

    @ManyToMany(mappedBy = "substrates")
    @JsonBackReference
    private List<LandAnimalEntity> animals;

    public SubstrateEntity(Substrate entity) {
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
