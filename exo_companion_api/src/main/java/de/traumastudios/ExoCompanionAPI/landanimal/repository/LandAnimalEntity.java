package de.traumastudios.ExoCompanionAPI.landanimal.repository;

import de.traumastudios.ExoCompanionAPI.behavior.repository.BehaviorEntity;
import de.traumastudios.ExoCompanionAPI.category.repository.CategoryEntity;
import de.traumastudios.ExoCompanionAPI.coloration.repository.ColorationEntity;
import de.traumastudios.ExoCompanionAPI.feedingtype.repository.FeedingTypeEntity;
import de.traumastudios.ExoCompanionAPI.food.repository.FoodEntity;
import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import de.traumastudios.ExoCompanionAPI.origin.repository.OriginEntity;
import de.traumastudios.ExoCompanionAPI.plant.repository.PlantEntity;
import de.traumastudios.ExoCompanionAPI.rarity.repository.RarityEntity;
import de.traumastudios.ExoCompanionAPI.requirement.repository.RequirementEntity;
import de.traumastudios.ExoCompanionAPI.substrate.repository.SubstrateEntity;
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
public class LandAnimalEntity {
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
    private String root;

    @Column
    private String subRoot;

    @Column
    private String classification;

    @Column
    private String subClassification;

    @Column
    private String order;

    @Column
    private String subOrder;

    @Column
    private String family;

    @Column
    private String genus;

    @ManyToMany
    @JoinTable(
        name = "landanimal_origins",
        joinColumns = @JoinColumn(name = "landanimal_id"),
        inverseJoinColumns = @JoinColumn(name = "origin_id")
    )
    private List<OriginEntity> origins;

    @ManyToMany
    @JoinTable(
        name = "landanimal_categories",
        joinColumns = @JoinColumn(name = "landanimal_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryEntity> categories;

    @Column
    private String image;

    @Column
    private double sizeMaleMin;

    @Column
    private double sizeMaleMax;

    @Column
    private double sizeFemaleMin;

    @Column
    private double sizeFemaleMax;

    @Column
    private String sexDifference;

    @Column
    private boolean speciesTank;

    @Column
    private double recommendedTankSize;

    @Column
    private double tempMin;

    @Column
    private double tempMax;

    @Column
    private double moistureMin;

    @Column
    private double moistureMax;

    @ManyToMany
    @JoinTable(
        name = "landanimal_requirements",
        joinColumns = @JoinColumn(name = "landanimal_id"),
        inverseJoinColumns = @JoinColumn(name = "requirement_id")
    )
    private List<RequirementEntity> requirements;

    @ManyToMany
    @JoinTable(
        name = "landanimal_foods",
        joinColumns = @JoinColumn(name = "landanimal_id"),
        inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<FoodEntity> foods;

    @ManyToMany
    @JoinTable(
        name = "landanimal_feedingtypes",
        joinColumns = @JoinColumn(name = "landanimal_id"),
        inverseJoinColumns = @JoinColumn(name = "feedingtype_id")
    )
    private List<FeedingTypeEntity> feedingTypes;

    @Column
    private boolean plantsRecommended;

    @ManyToMany
    @JoinTable(
        name = "landanimal_plants",
        joinColumns = @JoinColumn(name = "landanimal_id"),
        inverseJoinColumns = @JoinColumn(name = "plant_id")
    )
    private List<PlantEntity> unfitPlants;

    @ManyToMany
    @JoinTable(
        name = "landanimal_behaviors",
        joinColumns = @JoinColumn(name = "landanimal_id"),
        inverseJoinColumns = @JoinColumn(name = "behavior_id")
    )
    private List<BehaviorEntity> behaviors;

    @Column
    private boolean breedingPossible;

    @Column
    private String breedingDifficulty;

    @Column
    private String breedingTips;

    @ManyToMany
    @JoinTable(
        name = "landanimal_colorations",
        joinColumns = @JoinColumn(name = "aquaticanimal_id"),
        inverseJoinColumns = @JoinColumn(name = "coloration_id")
    )
    private List<ColorationEntity> colorations;

    @ManyToMany
    @JoinTable(
            name = "landanimal_rarities",
            joinColumns = @JoinColumn(name = "landanimal_id"),
            inverseJoinColumns = @JoinColumn(name = "rarity_id")
    )
    private List<RarityEntity> rarities;

    @ManyToMany
    @JoinTable(
            name = "landanimal_substrates",
            joinColumns = @JoinColumn(name = "landanimal_id"),
            inverseJoinColumns = @JoinColumn(name = "substrate_id")
    )
    private List<SubstrateEntity> substrates;

    public LandAnimalEntity(LandAnimal entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.engName = entity.getEngName();
        this.latName = entity.getLatName();
        this.root = entity.getRoot();
        this.subRoot = entity.getSubRoot();
        this.classification = entity.getClassification();
        this.subClassification = entity.getSubClassification();
        this.order = entity.getOrder();
        this.subOrder = entity.getSubOrder();
        this.family = entity.getFamily();
        this.genus = entity.getGenus();
        this.origins = entity.getOrigins().stream().map(OriginEntity::new).toList();
        this.categories = entity.getCategories().stream().map(CategoryEntity::new).toList();
        this.image = entity.getImage();
        this.sizeMaleMin = entity.getSizeMaleMin();
        this.sizeMaleMax = entity.getSizeMaleMax();
        this.sizeFemaleMin = entity.getSizeFemaleMin();
        this.sizeFemaleMax = entity.getSizeFemaleMax();
        this.sexDifference = entity.getSexDifference();
        this.speciesTank = entity.isSpeciesTank();
        this.recommendedTankSize = entity.getRecommendedTankSize();
        this.tempMin = entity.getTempMin();
        this.tempMax = entity.getTempMax();
        this.moistureMin = entity.getMoistureMin();
        this.moistureMax = entity.getMoistureMax();
        this.requirements = entity.getRequirements().stream().map(RequirementEntity::new).toList();
        this.foods = entity.getFoods().stream().map(FoodEntity::new).toList();
        this.feedingTypes = entity.getFeedingTypes().stream().map(FeedingTypeEntity::new).toList();
        this.plantsRecommended = entity.isPlantsRecommended();
        this.unfitPlants = entity.getUnfitPlants().stream().map(PlantEntity::new).toList();
        this.behaviors = entity.getBehaviors().stream().map(BehaviorEntity::new).toList();
        this.breedingPossible = entity.isBreedingPossible();
        this.breedingDifficulty = entity.getBreedingDifficulty();
        this.breedingTips = entity.getBreedingTips();
        this.colorations = entity.getColorations().stream().map(ColorationEntity::new).toList();
        this.rarities = entity.getRarities().stream().map(RarityEntity::new).toList();
        this.substrates = entity.getSubstrates().stream().map(SubstrateEntity::new).toList();
    }
}
