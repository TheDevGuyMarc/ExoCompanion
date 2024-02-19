package de.traumastudios.ExoCompanionAPI.requirement.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.repository.AquaticAnimalEntity;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalEntity;
import de.traumastudios.ExoCompanionAPI.requirement.domain.Requirement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "requirements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private List<LandAnimalEntity> landAnimals;

    @ManyToMany(mappedBy = "requirements")
    @JsonBackReference
    private List<AquaticAnimalEntity> aquaticAnimals;

    public RequirementEntity(Requirement entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.landAnimals = entity.getLandAnimals().stream().map(LandAnimalEntity::new).toList();
        this.aquaticAnimals = entity.getAquaticAnimals().stream().map(AquaticAnimalEntity::new).toList();
    }
}
