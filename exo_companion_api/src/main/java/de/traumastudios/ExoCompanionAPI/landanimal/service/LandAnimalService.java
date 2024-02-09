package de.traumastudios.ExoCompanionAPI.landanimal.service;

import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import de.traumastudios.ExoCompanionAPI.landanimal.exception.LandAnimalNotFoundException;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalEntity;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandAnimalService {
    private final LandAnimalRepository landAnimalRepository;

    public LandAnimalService(LandAnimalRepository landAnimalRepository) {
        this.landAnimalRepository = landAnimalRepository;
    }

    public List<LandAnimal> findAllLandAnimals() {
        return this.landAnimalRepository.findAll()
                .stream()
                .map(LandAnimal::new)
                .toList();
    }

    public Optional<LandAnimal> findLandAnimalById(Long id) {
        return this.landAnimalRepository.findById(id)
                .map(LandAnimal::new);
    }

    public Optional<LandAnimal> findLandAnimalByName(String name) {
        return this.landAnimalRepository.findByName(name)
                .map(LandAnimal::new);
    }

    public LandAnimal createLandAnimal(LandAnimal animal) {
        return new LandAnimal(this.landAnimalRepository.saveAndFlush(new LandAnimalEntity(animal)));
    }

    public LandAnimal updateLandAnimal(Long id, LandAnimal animal) {
        Optional<LandAnimal> existingElement = this.landAnimalRepository.findById(id)
                .map(LandAnimal::new);

        if (existingElement.isPresent()) {
            LandAnimal updatedElement = existingElement.get();
            updatedElement.setId(animal.getId());
            updatedElement.setName(animal.getName());
            updatedElement.setEngName(animal.getEngName());
            updatedElement.setLatName(animal.getLatName());
            updatedElement.setRoot(animal.getRoot());
            updatedElement.setSubRoot(animal.getSubRoot());
            updatedElement.setClassification(animal.getClassification());
            updatedElement.setSubClassification(animal.getSubClassification());
            updatedElement.setAnimalOrder(animal.getAnimalOrder());
            updatedElement.setSubOrder(animal.getSubOrder());
            updatedElement.setFamily(animal.getFamily());
            updatedElement.setGenus(animal.getGenus());
            updatedElement.setImage(animal.getImage());
            updatedElement.setOrigins(animal.getOrigins());
            updatedElement.setCategories(animal.getCategories());
            updatedElement.setSizeMaleMin(animal.getSizeMaleMin());
            updatedElement.setSizeMaleMax(animal.getSizeMaleMax());
            updatedElement.setSizeFemaleMin(animal.getSizeFemaleMin());
            updatedElement.setSizeFemaleMax(animal.getSizeFemaleMax());
            updatedElement.setSexDifference(animal.getSexDifference());
            updatedElement.setSpeciesTank(animal.isSpeciesTank());
            updatedElement.setRecommendedTankSize(animal.getRecommendedTankSize());
            updatedElement.setTempMin(animal.getTempMin());
            updatedElement.setTempMax(animal.getTempMax());
            updatedElement.setMoistureMin(animal.getMoistureMin());
            updatedElement.setMoistureMax(animal.getMoistureMax());
            updatedElement.setRequirements(animal.getRequirements());
            updatedElement.setFoods(animal.getFoods());
            updatedElement.setFeedingTypes(animal.getFeedingTypes());
            updatedElement.setPlantsRecommended(animal.isPlantsRecommended());
            updatedElement.setUnfitPlants(animal.getUnfitPlants());
            updatedElement.setBehaviors(animal.getBehaviors());
            updatedElement.setBreedingPossible(animal.isBreedingPossible());
            updatedElement.setBreedingDifficulty(animal.getBreedingDifficulty());
            updatedElement.setBreedingTips(animal.getBreedingTips());
            updatedElement.setColorations(animal.getColorations());
            updatedElement.setRarities(animal.getRarities());
            updatedElement.setSubstrates(animal.getSubstrates());

            return new LandAnimal(this.landAnimalRepository.saveAndFlush(new LandAnimalEntity(updatedElement)));
        }
        else {
            throw new LandAnimalNotFoundException("Could not find a land animal with id: " + id);
        }
    }

    public void deleteLandAnimal(Long id) {
        this.landAnimalRepository.deleteById(id);
    }
}
