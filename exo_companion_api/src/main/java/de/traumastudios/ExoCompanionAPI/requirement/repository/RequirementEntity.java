package de.traumastudios.ExoCompanionAPI.requirement.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalEntity;
import de.traumastudios.ExoCompanionAPI.requirement.domain.Requirement;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class RequirementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "requirements")
    @JsonBackReference
    private List<LandAnimalEntity> animals;

    public RequirementEntity(Requirement entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.animals = entity.getAnimals().stream().map(LandAnimalEntity::new).toList();
    }
}
