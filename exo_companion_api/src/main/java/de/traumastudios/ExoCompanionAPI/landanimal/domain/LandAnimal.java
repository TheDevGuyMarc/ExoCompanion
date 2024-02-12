package de.traumastudios.ExoCompanionAPI.landanimal.domain;

import de.traumastudios.ExoCompanionAPI.behavior.domain.Behavior;
import de.traumastudios.ExoCompanionAPI.category.domain.Category;
import de.traumastudios.ExoCompanionAPI.coloration.domain.Coloration;
import de.traumastudios.ExoCompanionAPI.feedingtype.domain.FeedingType;
import de.traumastudios.ExoCompanionAPI.food.domain.Food;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalEntity;
import de.traumastudios.ExoCompanionAPI.origin.domain.Origin;
import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import de.traumastudios.ExoCompanionAPI.rarity.domain.Rarity;
import de.traumastudios.ExoCompanionAPI.requirement.domain.Requirement;
import de.traumastudios.ExoCompanionAPI.substrate.domain.Substrate;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LandAnimal {
    private Long id;
    private String name;
    private String engName;
    private String latName;
    private String root;
    private String subRoot;
    private String classification;
    private String subClassification;
    private String animalOrder;
    private String subOrder;
    private String family;
    private String genus;
    private byte[] image;
    private List<Origin> origins;
    private List<Category> categories;
    private double sizeMaleMin;
    private double sizeMaleMax;
    private double sizeFemaleMin;
    private double sizeFemaleMax;
    private String sexDifference;
    private boolean speciesTank;
    private double recommendedTankSize;
    private double tempMin;
    private double tempMax;
    private double moistureMin;
    private double moistureMax;
    private List<Requirement> requirements;
    private List<Food> foods;
    private List<FeedingType> feedingTypes;
    private boolean plantsRecommended;
    private List<Plant> unfitPlants;
    private List<Behavior> behaviors;
    private boolean breedingPossible;
    private String breedingDifficulty;
    private String breedingTips;
    private List<Coloration> colorations;
    private List<Rarity> rarities;
    private List<Substrate> substrates;

    public LandAnimal(LandAnimalEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.engName = entity.getEngName();
        this.latName = entity.getLatName();
        this.root = entity.getRoot();
        this.subRoot = entity.getSubRoot();
        this.classification = entity.getClassification();
        this.subClassification = entity.getSubClassification();
        this.animalOrder = entity.getAnimalOrder();
        this.subOrder = entity.getSubOrder();
        this.family = entity.getFamily();
        this.genus = entity.getGenus();
        this.image = entity.getImage();
        this.origins = entity.getOrigins().stream().map(Origin::new).toList();
        this.categories = entity.getCategories().stream().map(Category::new).toList();
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
        this.requirements = entity.getRequirements().stream().map(Requirement::new).toList();
        this.foods = entity.getFoods().stream().map(Food::new).toList();
        this.feedingTypes = entity.getFeedingTypes().stream().map(FeedingType::new).toList();
        this.plantsRecommended = entity.isPlantsRecommended();
        this.unfitPlants = entity.getUnfitPlants().stream().map(Plant::new).toList();
        this.behaviors = entity.getBehaviors().stream().map(Behavior::new).toList();
        this.breedingPossible = entity.isBreedingPossible();
        this.breedingDifficulty = entity.getBreedingDifficulty();
        this.breedingTips = entity.getBreedingTips();
        this.colorations = entity.getColorations().stream().map(Coloration::new).toList();
        this.rarities = entity.getRarities().stream().map(Rarity::new).toList();
        this.substrates = entity.getSubstrates().stream().map(Substrate::new).toList();
    }
}
