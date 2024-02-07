package de.traumastudios.ExoCompanionAPI.coloration.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.coloration.domain.Coloration;
import de.traumastudios.ExoCompanionAPI.culture.repository.CultureEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "colorations")
@Getter
@Setter
@NoArgsConstructor
public class ColorationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "colorations")
    @JsonBackReference
    private List<CultureEntity> cultures;

    /*@ManyToMany(mappedBy = "colorations")
    @JsonBackReference
    private List<AquaticAnimalEntity> animals;*/

    public ColorationEntity(Coloration entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.cultures = entity.getCultures().stream().map(CultureEntity::new).toList();
        // this.animals = entity.getAnimals().stream().map(AquaticAnimalEntity::new).toList();
    }
}
