package de.traumastudios.ExoCompanionAPI.plant.controller;

import de.traumastudios.ExoCompanionAPI.category.controller.CategoryDTO;
import de.traumastudios.ExoCompanionAPI.culture.controller.CultureDTO;
import de.traumastudios.ExoCompanionAPI.difficulty.controller.DifficultyDTO;
import de.traumastudios.ExoCompanionAPI.location.controller.LocationDTO;
import de.traumastudios.ExoCompanionAPI.origin.controller.OriginDTO;
import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import de.traumastudios.ExoCompanionAPI.planttype.controller.PlantTypeDTO;
import de.traumastudios.ExoCompanionAPI.rarity.controller.RarityDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class PlantDTO {
    private final Long id;
    private final String name;
    private final String engName;
    private final String latName;
    private final String group;
    private final String synonyms;
    private final String subGroup;
    private final String order;
    private final String subOrder;
    private final String family;
    private final String genus;
    private final byte[] image;
    private final double heightMin;
    private final double heightMax;
    private final double widthMin;
    private final double widthMax;
    private final List<CategoryDTO> categories;
    private final List<PlantTypeDTO> plantTypes;
    private final List<OriginDTO> origins;
    private final List<DifficultyDTO> difficulties;
    private final List<LocationDTO> locations;
    private final List<RarityDTO> rarities;
    private final List<CultureDTO> cultures;

    public PlantDTO(Plant entity) {
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
        this.categories = entity.getCategories().stream().map(CategoryDTO::new).toList();
        this.plantTypes = entity.getPlantTypes().stream().map(PlantTypeDTO::new).toList();
        this.origins = entity.getOrigins().stream().map(OriginDTO::new).toList();
        this.difficulties = entity.getDifficulties().stream().map(DifficultyDTO::new).toList();
        this.locations = entity.getLocations().stream().map(LocationDTO::new).toList();
        this.rarities = entity.getRarities().stream().map(RarityDTO::new).toList();
        this.cultures = entity.getCultures().stream().map(CultureDTO::new).toList();
    }
}
