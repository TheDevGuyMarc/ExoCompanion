package de.traumastudios.ExoCompanionAPI.rarity.repository;

import de.traumastudios.ExoCompanionAPI.rarity.domain.Rarity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class RarityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    /*@ManyToMany(mappedBy = "rarities")
    @JsonBackReference
    private List<LandAnimalEntity> animals;*/

    public RarityEntity(Rarity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        // this.animals = entity.getAnimals().stream().map(LandAnimalEntity::new).toList();
    }
}
