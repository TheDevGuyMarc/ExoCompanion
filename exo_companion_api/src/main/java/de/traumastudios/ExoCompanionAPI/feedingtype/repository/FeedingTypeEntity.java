package de.traumastudios.ExoCompanionAPI.feedingtype.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.repository.AquaticAnimalEntity;
import de.traumastudios.ExoCompanionAPI.feedingtype.domain.FeedingType;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "feeding_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedingTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "feedingTypes")
    @JsonBackReference
    private List<LandAnimalEntity> landAnimals;

    @ManyToMany(mappedBy = "feedingTypes")
    @JsonBackReference
    private List<AquaticAnimalEntity> aquaticAnimals;

    public FeedingTypeEntity(FeedingType entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.landAnimals = entity.getLandAnimals().stream().map(LandAnimalEntity::new).toList();
        this.aquaticAnimals = entity.getAquaticAnimals().stream().map(AquaticAnimalEntity::new).toList();
    }
}
