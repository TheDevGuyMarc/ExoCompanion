package de.traumastudios.ExoCompanionAPI.culture.repository;

import de.traumastudios.ExoCompanionAPI.culture.domain.Culture;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
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

    // TODO: Add grow-speed relation

    // TODO: Add coloration relation


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
    }
}
