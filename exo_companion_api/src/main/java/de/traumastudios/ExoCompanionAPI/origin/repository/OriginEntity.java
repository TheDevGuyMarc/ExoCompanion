package de.traumastudios.ExoCompanionAPI.origin.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.repository.AquaticAnimalEntity;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalEntity;
import de.traumastudios.ExoCompanionAPI.origin.domain.Origin;
import de.traumastudios.ExoCompanionAPI.plant.repository.PlantEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "origins")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OriginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int tempMin;

    @Column
    private int tempMax;

    @Column
    private double humidity;

    @Column
    private int dayCycleHours;

    @ManyToMany(mappedBy = "origins")
    @JsonBackReference
    private List<PlantEntity> plants;

    @ManyToMany(mappedBy = "origins")
    @JsonBackReference
    private List<LandAnimalEntity> landAnimals;

    @ManyToMany(mappedBy = "origins")
    @JsonBackReference
    private List<AquaticAnimalEntity> aquaticAnimals;

    public OriginEntity(Origin entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.tempMin = entity.getTempMin();
        this.tempMax = entity.getTempMax();
        this.humidity = entity.getHumidity();
        this.dayCycleHours = entity.getDayCycleHours();
        this.plants = entity.getPlants().stream().map(PlantEntity::new).toList();
        this.landAnimals = entity.getLandAnimals().stream().map(LandAnimalEntity::new).toList();
        this.aquaticAnimals = entity.getAquaticAnimals().stream().map(AquaticAnimalEntity::new).toList();
    }
}
