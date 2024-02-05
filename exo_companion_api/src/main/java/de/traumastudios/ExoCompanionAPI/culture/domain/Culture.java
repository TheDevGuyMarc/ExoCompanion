package de.traumastudios.ExoCompanionAPI.culture.domain;

import de.traumastudios.ExoCompanionAPI.coloration.domain.Coloration;
import de.traumastudios.ExoCompanionAPI.culture.repository.CultureEntity;
import de.traumastudios.ExoCompanionAPI.growspeed.domain.Growspeed;
import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Culture {
    private Long id;
    private String lightDemand;
    private double tempMin;
    private double tempMax;
    private double khMin;
    private double khMax;
    private double phMin;
    private double phMax;
    private double co2Min;
    private double co2Max;
    private double no3Min;
    private double no3Max;
    private double po4Min;
    private double po4Max;
    private double kMin;
    private double kMax;
    private double feMin;
    private double feMax;
    private String cultivation;
    private boolean growingEmerse;
    private boolean winterDurable;
    private List<Growspeed> growspeeds;
    private List<Coloration> colorations;
    private Plant plant;


    public Culture(CultureEntity entity) {
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
        this.growspeeds = entity.getGrowSpeeds().stream().map(Growspeed::new).toList();
        this.colorations = entity.getColorations().stream().map(Coloration::new).toList();
        this.plant = new Plant(entity.getPlant());
    }
}
