package de.traumastudios.ExoCompanionAPI.plant.repository;

import de.traumastudios.ExoCompanionAPI.category.repository.CategoryEntity;
import de.traumastudios.ExoCompanionAPI.culture.repository.CultureEntity;
import de.traumastudios.ExoCompanionAPI.difficulty.repository.DifficultyEntity;
import de.traumastudios.ExoCompanionAPI.location.repository.LocationEntity;
import de.traumastudios.ExoCompanionAPI.origin.repository.OriginEntity;
import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import de.traumastudios.ExoCompanionAPI.planttype.repository.PlantTypeEntity;
import de.traumastudios.ExoCompanionAPI.rarity.repository.RarityEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "plants")
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
    private String plantGroup;

    @Column
    private String synonyms;

    @Column
    private String subGroup;

    @Column
    private String plantOrder;

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

    @ManyToMany
    @JoinTable(
        name = "plant_categories",
        joinColumns = @JoinColumn(name = "plant_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryEntity> categories;

    @ManyToMany
    @JoinTable(
        name = "plant_planttypes",
        joinColumns = @JoinColumn(name = "plant_id"),
        inverseJoinColumns = @JoinColumn(name = "planttype_id")
    )
    private List<PlantTypeEntity> plantTypes;

    @ManyToMany
    @JoinTable(
        name = "plant_origins",
        joinColumns = @JoinColumn(name = "plant_id"),
        inverseJoinColumns = @JoinColumn(name = "origin_id")
    )
    private List<OriginEntity> origins;

    @ManyToMany
    @JoinTable(
        name = "plant_difficulties",
        joinColumns = @JoinColumn(name = "plant_id"),
        inverseJoinColumns = @JoinColumn(name = "difficulty_id")
    )
    private List<DifficultyEntity> difficulties;

    @ManyToMany
    @JoinTable(
        name = "plant_locations",
        joinColumns = @JoinColumn(name = "plant_id"),
        inverseJoinColumns = @JoinColumn(name = "location_id")
    )
    private List<LocationEntity> locations;

    @ManyToMany
    @JoinTable(
        name = "plant_rarities",
        joinColumns = @JoinColumn(name = "plant_id"),
        inverseJoinColumns = @JoinColumn(name = "rarity_id")
    )
    private List<RarityEntity> rarities;

    @ManyToMany
    @JoinTable(
        name = "plant_cultures",
        joinColumns = @JoinColumn(name = "plant_id"),
        inverseJoinColumns = @JoinColumn(name = "culture_id")
    )
    private List<CultureEntity> cultures;

    public PlantEntity(Plant entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.engName = entity.getEngName();
        this.latName = entity.getLatName();
        this.plantGroup = entity.getGroup();
        this.synonyms = entity.getSynonyms();
        this.subGroup = entity.getSubGroup();
        this.plantOrder = entity.getPlantOrder();
        this.subOrder = entity.getSubOrder();
        this.family = entity.getFamily();
        this.genus = entity.getGenus();
        this.image = entity.getImage();
        this.heightMin = entity.getHeightMin();
        this.heightMax = entity.getHeightMax();
        this.widthMin = entity.getWidthMin();
        this.widthMax = entity.getWidthMax();
        this.categories = entity.getCategories().stream().map(CategoryEntity::new).toList();
        this.plantTypes = entity.getPlantTypes().stream().map(PlantTypeEntity::new).toList();
        this.origins = entity.getOrigins().stream().map(OriginEntity::new).toList();
        this.difficulties = entity.getDifficulties().stream().map(DifficultyEntity::new).toList();
        this.locations = entity.getLocations().stream().map(LocationEntity::new).toList();
        this.rarities = entity.getRarities().stream().map(RarityEntity::new).toList();
        this.cultures = entity.getCultures().stream().map(CultureEntity::new).toList();
    }
}
