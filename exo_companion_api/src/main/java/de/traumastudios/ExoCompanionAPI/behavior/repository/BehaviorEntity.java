package de.traumastudios.ExoCompanionAPI.behavior.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.behavior.domain.Behavior;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "behaviors")
@Getter
@Setter
@NoArgsConstructor
public class BehaviorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "behaviors")
    @JsonBackReference
    private List<LandAnimalEntity> animals;

    public BehaviorEntity(Behavior entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.animals = entity.getAnimals().stream().map(LandAnimalEntity::new).toList();
    }
}
