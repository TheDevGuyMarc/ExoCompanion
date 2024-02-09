package de.traumastudios.ExoCompanionAPI.rarity.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalEntity;
import de.traumastudios.ExoCompanionAPI.plant.repository.PlantEntity;
import de.traumastudios.ExoCompanionAPI.rarity.domain.Rarity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rarities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RarityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "rarities")
    @JsonBackReference
    private List<PlantEntity> plants;

    @ManyToMany(mappedBy = "rarities")
    @JsonBackReference
    private List<LandAnimalEntity> animals;

    public RarityEntity(Rarity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.plants = entity.getPlants().stream().map(PlantEntity::new).toList();
        this.animals = entity.getAnimals().stream().map(LandAnimalEntity::new).toList();
    }
}
