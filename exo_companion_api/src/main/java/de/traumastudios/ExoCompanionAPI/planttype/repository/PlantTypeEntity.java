package de.traumastudios.ExoCompanionAPI.planttype.repository;

import de.traumastudios.ExoCompanionAPI.planttype.domain.PlantType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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


    public PlantTypeEntity(PlantType entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.image = entity.getImage();
    }
}
