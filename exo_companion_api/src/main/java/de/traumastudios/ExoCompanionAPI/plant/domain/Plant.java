package de.traumastudios.ExoCompanionAPI.plant.domain;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.domain.AquaticAnimal;
import de.traumastudios.ExoCompanionAPI.category.domain.Category;
import de.traumastudios.ExoCompanionAPI.culture.domain.Culture;
import de.traumastudios.ExoCompanionAPI.difficulty.domain.Difficulty;
import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import de.traumastudios.ExoCompanionAPI.location.domain.Location;
import de.traumastudios.ExoCompanionAPI.origin.domain.Origin;
import de.traumastudios.ExoCompanionAPI.plant.repository.PlantEntity;
import de.traumastudios.ExoCompanionAPI.planttype.domain.PlantType;
import de.traumastudios.ExoCompanionAPI.rarity.domain.Rarity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Plant {
    private Long id;
    private String name;
    private String engName;
    private String latName;
    private String group;
    private String synonyms;
    private String subGroup;
    private String plantOrder;
    private String subOrder;
    private String family;
    private String genus;
    private byte[] image;
    private double heightMin;
    private double heightMax;
    private double widthMin;
    private double widthMax;
    private List<Category> categories;
    private List<PlantType> plantTypes;
    private List<Origin> origins;
    private List<Difficulty> difficulties;
    private List<Location> locations;
    private List<Rarity> rarities;
    private List<Culture> cultures;
    private List<LandAnimal> landAnimals;
    private List<AquaticAnimal> aquaticAnimals;

    public Plant(PlantEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.engName = entity.getEngName();
        this.latName = entity.getLatName();
        this.group = entity.getPlantGroup();
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
        this.categories = entity.getCategories().stream().map(Category::new).toList();
        this.plantTypes = entity.getPlantTypes().stream().map(PlantType::new).toList();
        this.origins = entity.getOrigins().stream().map(Origin::new).toList();
        this.difficulties = entity.getDifficulties().stream().map(Difficulty::new).toList();
        this.locations = entity.getLocations().stream().map(Location::new).toList();
        this.rarities = entity.getRarities().stream().map(Rarity::new).toList();
        this.cultures = entity.getCultures().stream().map(Culture::new).toList();
        this.landAnimals = entity.getLandAnimals().stream().map(LandAnimal::new).toList();
        this.aquaticAnimals = entity.getAquaticAnimals().stream().map(AquaticAnimal::new).toList();
    }
}
