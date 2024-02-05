package de.traumastudios.ExoCompanionAPI.culture.controller;

import de.traumastudios.ExoCompanionAPI.culture.domain.Culture;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CultureDTO {
    private final Long id;
    private final String lightDemand;
    private double tempMin;
    private final double tempMax;
    private final double khMin;
    private final double khMax;
    private final double phMin;
    private final double phMax;
    private final double co2Min;
    private final double co2Max;
    private final double no3Min;
    private final double no3Max;
    private final double po4Min;
    private final double po4Max;
    private final double kMin;
    private final double kMax;
    private final double feMin;
    private final double feMax;
    private final String cultivation;
    private final boolean growingEmerse;
    private final boolean winterDurable;

    // TODO: Add grow-speed relation

    // TODO: Add coloration relation


    public CultureDTO(Culture entity) {
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
