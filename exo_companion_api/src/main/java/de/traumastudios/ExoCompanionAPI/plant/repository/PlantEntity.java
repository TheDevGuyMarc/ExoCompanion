package de.traumastudios.ExoCompanionAPI.plant.repository;

import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
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
public class PlantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String engName;

    @Column
    private String latName;

    @Column
    private String group;

    @Column
    private String synonyms;

    @Column
    private String subGroup;

    @Column
    private String order;

    @Column
    private String subOrder;

    @Column
    private String family;

    @Column
    private String genus;

    @Lob
    private byte[] image;

    @Column
    private double heightMin;

    @Column
    private double heightMax;

    @Column
    private double widthMin;

    @Column
    private double widthMax;

    // TODO: List<Category> relation
    // TODO: List<PlantType> relation
    // TODO: List<Origin> relation
    // TODO: Difficulty relation
    // TODO: List<Location> relation
    // TODO: Rarity relation


    public PlantEntity(Plant entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.engName = entity.getEngName();
        this.latName = entity.getLatName();
        this.group = entity.getGroup();
        this.synonyms = entity.getSynonyms();
        this.subGroup = entity.getSubGroup();
        this.order = entity.getOrder();
        this.subOrder = entity.getSubOrder();
        this.family = entity.getFamily();
        this.genus = entity.getGenus();
        this.image = entity.getImage();
        this.heightMin = entity.getHeightMin();
        this.heightMax = entity.getHeightMax();
        this.widthMin = entity.getWidthMin();
        this.widthMax = entity.getWidthMax();
    }
}
