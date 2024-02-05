package de.traumastudios.ExoCompanionAPI.origin.repository;

import de.traumastudios.ExoCompanionAPI.origin.domain.Origin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
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

    /*@ManyToMany(mappedBy = "origins")
    @JsonBackReference
    private List<AquaticAnimalEntity> animals;*/

    public OriginEntity(Origin entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.tempMin = entity.getTempMin();
        this.tempMax = entity.getTempMax();
        this.humidity = entity.getHumidity();
        this.dayCycleHours = entity.getDayCycleHours();
        // this.animals = entity.getAnimals().stream().map(AquaticAnimalEntity::new).toList();
    }
}
