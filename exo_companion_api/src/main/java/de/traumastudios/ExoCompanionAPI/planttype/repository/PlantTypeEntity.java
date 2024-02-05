package de.traumastudios.ExoCompanionAPI.planttype.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.plant.repository.PlantEntity;
import de.traumastudios.ExoCompanionAPI.planttype.domain.PlantType;
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
public class PlantTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Lob
    private byte[] image;

    @ManyToMany(mappedBy = "plantTypes")
    @JsonBackReference
    private List<PlantEntity> plants;


    public PlantTypeEntity(PlantType entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
        this.plants = entity.getPlants().stream().map(PlantEntity::new).toList();
    }
}
