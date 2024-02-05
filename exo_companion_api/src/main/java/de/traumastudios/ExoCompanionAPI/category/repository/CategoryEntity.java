package de.traumastudios.ExoCompanionAPI.category.repository;

import de.traumastudios.ExoCompanionAPI.category.domain.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    /*@ManyToMany(mappedBy = "categories")
    @JsonBackReference
    private List<AquaticAnimalEntity> animals;*/

    public CategoryEntity(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        // this.animals = entity.getAnimals().stream().map(AquaticAnimalEntity::new).toList();
    }
}
