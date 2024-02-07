package de.traumastudios.ExoCompanionAPI.culture.service;

import de.traumastudios.ExoCompanionAPI.culture.domain.Culture;
import de.traumastudios.ExoCompanionAPI.culture.exception.CultureNotFoundException;
import de.traumastudios.ExoCompanionAPI.culture.repository.CultureEntity;
import de.traumastudios.ExoCompanionAPI.culture.repository.CultureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CultureService {
    private final CultureRepository cultureRepository;

    public CultureService(CultureRepository cultureRepository) {
        this.cultureRepository = cultureRepository;
    }

    public List<Culture> findAllCultures() {
        return this.cultureRepository.findAll()
                .stream()
                .map(Culture::new)
                .toList();
    }

    public Optional<Culture> findCultureById(Long id) {
        return this.cultureRepository.findById(id)
                .map(Culture::new);
    }

    public Culture createCulture(Culture culture) {
        return new Culture(this.cultureRepository.saveAndFlush(new CultureEntity(culture)));
    }

    public Culture updateCulture(Long id, Culture culture) {
        Optional<Culture> existingElement = this.cultureRepository.findById(id)
                .map(Culture::new);

        if (existingElement.isPresent()) {
            Culture updatedElement = existingElement.get();
            updatedElement.setId(culture.getId());
            updatedElement.setLightDemand(culture.getLightDemand());
            updatedElement.setTempMin(culture.getTempMin());
            updatedElement.setTempMax(culture.getTempMax());
            updatedElement.setKhMin(culture.getKhMin());
            updatedElement.setKhMax(culture.getKhMax());
            updatedElement.setPhMin(culture.getPhMin());
            updatedElement.setPhMax(culture.getPhMax());
            updatedElement.setCo2Min(culture.getCo2Min());
            updatedElement.setCo2Max(culture.getCo2Max());
            updatedElement.setNo3Min(culture.getNo3Min());
            updatedElement.setNo3Max(culture.getNo3Max());
            updatedElement.setPo4Min(culture.getPo4Min());
            updatedElement.setPo4Max(culture.getPo4Max());
            updatedElement.setKMin(culture.getKMin());
            updatedElement.setKMax(culture.getKMax());
            updatedElement.setFeMin(culture.getFeMin());
            updatedElement.setFeMax(culture.getFeMax());
            updatedElement.setCultivation(culture.getCultivation());
            updatedElement.setGrowingEmerse(culture.isGrowingEmerse());
            updatedElement.setWinterDurable(culture.isWinterDurable());
            updatedElement.setGrowSpeeds(culture.getGrowSpeeds());
            updatedElement.setColorations(culture.getColorations());
            updatedElement.setPlants(culture.getPlants());

            return new Culture(this.cultureRepository.saveAndFlush(new CultureEntity(updatedElement)));
        }
        else {
            throw new CultureNotFoundException("Could not find a culture with id: " + id);
        }
    }

    public void deleteCulture(Long id) {
        this.cultureRepository.deleteById(id);
    }
}
