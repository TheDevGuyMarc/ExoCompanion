package de.traumastudios.ExoCompanionAPI.landanimal.controller;

import de.traumastudios.ExoCompanionAPI.behavior.controller.BehaviorDTO;
import de.traumastudios.ExoCompanionAPI.category.controller.CategoryDTO;
import de.traumastudios.ExoCompanionAPI.coloration.controller.ColorationDTO;
import de.traumastudios.ExoCompanionAPI.feedingtype.controller.FeedingTypeDTO;
import de.traumastudios.ExoCompanionAPI.food.controller.FoodDTO;
import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import de.traumastudios.ExoCompanionAPI.origin.controller.OriginDTO;
import de.traumastudios.ExoCompanionAPI.plant.controller.PlantDTO;
import de.traumastudios.ExoCompanionAPI.rarity.controller.RarityDTO;
import de.traumastudios.ExoCompanionAPI.requirement.controller.RequirementDTO;
import de.traumastudios.ExoCompanionAPI.substrate.controller.SubstrateDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class LandAnimalDTO {
    private final Long id;
    private final String name;
    private final String engName;
    private final String latName;
    private final String root;
    private final String subRoot;
    private final String classification;
    private final String subClassification;
    private final String animalOrder;
    private final String subOrder;
    private final String family;
    private final String genus;
    private final String image;
    private final List<OriginDTO> origins;
    private final List<CategoryDTO> categories;
    private final double sizeMaleMin;
    private final double sizeMaleMax;
    private final double sizeFemaleMin;
    private final double sizeFemaleMax;
    private final String sexDifference;
    private final boolean speciesTank;
    private final double recommendedTankSize;
    private final double tempMin;
    private final double tempMax;
    private final double moistureMin;
    private final double moistureMax;
    private final List<RequirementDTO> requirements;
    private final List<FoodDTO> foods;
    private final List<FeedingTypeDTO> feedingTypes;
    private boolean plantsRecommended;
    private List<PlantDTO> unfitPlants;
    private final List<BehaviorDTO> behaviors;
    private final boolean breedingPossible;
    private final String breedingDifficulty;
    private final String breedingTips;
    private final List<ColorationDTO> colorations;
    private final List<RarityDTO> rarities;
    private final List<SubstrateDTO> substrates;

    public LandAnimalDTO(LandAnimal entity) {
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
        this.origins = entity.getOrigins().stream().map(OriginDTO::new).toList();
        this.categories = entity.getCategories().stream().map(CategoryDTO::new).toList();
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
        this.requirements = entity.getRequirements().stream().map(RequirementDTO::new).toList();
        this.foods = entity.getFoods().stream().map(FoodDTO::new).toList();
        this.feedingTypes = entity.getFeedingTypes().stream().map(FeedingTypeDTO::new).toList();
        this.plantsRecommended = entity.isPlantsRecommended();
        this.unfitPlants = entity.getUnfitPlants().stream().map(PlantDTO::new).toList();
        this.behaviors = entity.getBehaviors().stream().map(BehaviorDTO::new).toList();
        this.breedingPossible = entity.isBreedingPossible();
        this.breedingDifficulty = entity.getBreedingDifficulty();
        this.breedingTips = entity.getBreedingTips();
        this.colorations = entity.getColorations().stream().map(ColorationDTO::new).toList();
        this.rarities = entity.getRarities().stream().map(RarityDTO::new).toList();
        this.substrates = entity.getSubstrates().stream().map(SubstrateDTO::new).toList();
    }
}
