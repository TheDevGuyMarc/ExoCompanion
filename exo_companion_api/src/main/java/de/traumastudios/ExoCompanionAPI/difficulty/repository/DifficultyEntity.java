package de.traumastudios.ExoCompanionAPI.difficulty.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.difficulty.domain.Difficulty;
import de.traumastudios.ExoCompanionAPI.plant.repository.PlantEntity;
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
public class DifficultyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "difficulties")
    @JsonBackReference
    private List<PlantEntity> plants;

    public DifficultyEntity(Difficulty entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.plants = entity.getPlants().stream().map(PlantEntity::new).toList();
    }
}
