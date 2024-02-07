package de.traumastudios.ExoCompanionAPI.culture.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.traumastudios.ExoCompanionAPI.coloration.repository.ColorationEntity;
import de.traumastudios.ExoCompanionAPI.culture.domain.Culture;
import de.traumastudios.ExoCompanionAPI.growspeed.repository.GrowspeedEntity;
import de.traumastudios.ExoCompanionAPI.plant.repository.PlantEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cultures")
@Getter
@Setter
@NoArgsConstructor
public class CultureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String lightDemand;

    @Column
    private double tempMin;

    @Column
    private double tempMax;

    @Column
    private double khMin;

    @Column
    private double khMax;

    @Column
    private double phMin;

    @Column
    private double phMax;

    @Column
    private double co2Min;

    @Column
    private double co2Max;

    @Column
    private double no3Min;

    @Column
    private double no3Max;

    @Column
    private double po4Min;

    @Column
    private double po4Max;

    @Column
    private double kMin;

    @Column
    private double kMax;

    @Column
    private double feMin;

    @Column
    private double feMax;

    @Column
    private String cultivation;

    @Column
    private boolean growingEmerse;

    @Column
    private boolean winterDurable;

    @ManyToMany
    @JoinTable(
        name = "culture_growspeeds",
        joinColumns = @JoinColumn(name = "culture_id"),
        inverseJoinColumns = @JoinColumn(name = "growspeed_id")
    )
    private List<GrowspeedEntity> growSpeeds;

    @ManyToMany
    @JoinTable(
        name = "culture_colorations",
        joinColumns = @JoinColumn(name = "culture_id"),
        inverseJoinColumns = @JoinColumn(name = "coloration_id")
    )
    private List<ColorationEntity> colorations;

    @ManyToMany(mappedBy = "cultures")
    @JsonBackReference
    private List<PlantEntity> plants;


    public CultureEntity(Culture entity) {
        this.id = entity.getId();
        this.lightDemand = entity.getLightDemand();
        this.tempMin = entity.getTempMin();
        this.tempMax = entity.getTempMax();
        this.khMin = entity.getKhMin();
        this.khMax = entity.getKhMax();
        this.phMin = entity.getPhMin();
        this.phMax = entity.getPhMax();
        this.co2Min = entity.getCo2Min();
        this.co2Max = entity.getCo2Max();
        this.no3Min = entity.getNo3Min();
        this.no3Max = entity.getNo3Max();
        this.po4Min = entity.getPo4Min();
        this.po4Max = entity.getPo4Max();
        this.kMin = entity.getKMin();
        this.kMax = entity.getKMax();
        this.feMin = entity.getFeMin();
        this.feMax = entity.getFeMax();
        this.cultivation = entity.getCultivation();
        this.growingEmerse = entity.isGrowingEmerse();
        this.winterDurable = entity.isWinterDurable();
        this.growSpeeds = entity.getGrowSpeeds().stream().map(GrowspeedEntity::new).toList();
        this.colorations = entity.getColorations().stream().map(ColorationEntity::new).toList();
        this.plants = entity.getPlants().stream().map(PlantEntity::new).toList();
    }
}
