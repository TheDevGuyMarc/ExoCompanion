package de.traumastudios.ExoCompanionAPI.plant.controller;

import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import lombok.Getter;

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

    // TODO: List<Category> relation
    // TODO: List<PlantType> relation
    // TODO: List<Origin> relation
    // TODO: Difficulty relation
    // TODO: List<Location> relation
    // TODO: Rarity relation


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
    }
}
