package de.traumastudios.ExoCompanionAPI.plant.domain;

import de.traumastudios.ExoCompanionAPI.plant.repository.PlantEntity;
import lombok.Getter;
import lombok.Setter;

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
    private String order;
    private String subOrder;
    private String family;
    private String genus;
    private byte[] image;
    private double heightMin;
    private double heightMax;
    private double widthMin;
    private double widthMax;

    // TODO: List<Category> relation
    // TODO: List<PlantType> relation
    // TODO: List<Origin> relation
    // TODO: Difficulty relation
    // TODO: List<Location> relation
    // TODO: Rarity relation


    public Plant(PlantEntity entity) {
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
