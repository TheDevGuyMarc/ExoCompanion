package de.traumastudios.ExoCompanionAPI.aquaticanimal.domain;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.repository.AquaticAnimalEntity;
import de.traumastudios.ExoCompanionAPI.behavior.domain.Behavior;
import de.traumastudios.ExoCompanionAPI.category.domain.Category;
import de.traumastudios.ExoCompanionAPI.coloration.domain.Coloration;
import de.traumastudios.ExoCompanionAPI.feedingtype.domain.FeedingType;
import de.traumastudios.ExoCompanionAPI.food.domain.Food;
import de.traumastudios.ExoCompanionAPI.origin.domain.Origin;
import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import de.traumastudios.ExoCompanionAPI.rarity.domain.Rarity;
import de.traumastudios.ExoCompanionAPI.requirement.domain.Requirement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AquaticAnimal {
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
    private String image;
    private List<Origin> origins;
    private List<Category> categories;
    private double sizeMaleMin;
    private double sizeMaleMax;
    private double sizeFemaleMin;
    private double sizeFemaleMax;
    private String sexDifference;
    private boolean nanoTank;
    private boolean speciesTank;
    private double recommendedTankSize;
    private double tempMin;
    private double tempMax;
    private double khMin;
    private double khMax;
    private double phMin;
    private double phMax;
    private double co2Min;
    private double co2Max;
    private double ghMin;
    private double ghMax;
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

    public AquaticAnimal(AquaticAnimalEntity entity) {
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
        this.nanoTank = entity.isNanoTank();
        this.speciesTank = entity.isSpeciesTank();
        this.recommendedTankSize = entity.getRecommendedTankSize();
        this.tempMin = entity.getTempMin();
        this.tempMax = entity.getTempMax();
        this.khMin = entity.getKhMin();
        this.khMax = entity.getKhMax();
        this.phMin = entity.getPhMin();
        this.phMax = entity.getPhMax();
        this.co2Min = entity.getCo2Min();
        this.co2Max = entity.getCo2Max();
        this.ghMin = entity.getGhMin();
        this.ghMax = entity.getGhMax();
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
    }
}
