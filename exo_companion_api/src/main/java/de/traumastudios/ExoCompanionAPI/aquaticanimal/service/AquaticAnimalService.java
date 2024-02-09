package de.traumastudios.ExoCompanionAPI.aquaticanimal.service;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.domain.AquaticAnimal;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.exception.AquaticAnimalNotFoundException;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.repository.AquaticAnimalEntity;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.repository.AquaticAnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AquaticAnimalService {
    private final AquaticAnimalRepository aquaticAnimalRepository;

    public AquaticAnimalService(AquaticAnimalRepository aquaticAnimalRepository) {
        this.aquaticAnimalRepository = aquaticAnimalRepository;
    }

    public List<AquaticAnimal> findAllAquaticAnimals() {
        return this.aquaticAnimalRepository.findAll()
                .stream()
                .map(AquaticAnimal::new)
                .toList();
    }

    public Optional<AquaticAnimal> findAquaticAnimalById(Long id) {
        return this.aquaticAnimalRepository.findById(id)
                .map(AquaticAnimal::new);
    }

    public Optional<AquaticAnimal> findAquaticAnimalByName(String name) {
        return this.aquaticAnimalRepository.findByName(name)
                .map(AquaticAnimal::new);
    }

    public AquaticAnimal createAquaticAnimal(AquaticAnimal animal) {
        return new AquaticAnimal(this.aquaticAnimalRepository.saveAndFlush(new AquaticAnimalEntity(animal)));
    }

    public AquaticAnimal updateAquaticAnimal(Long id, AquaticAnimal animal) {
        Optional<AquaticAnimal> existingElement = this.aquaticAnimalRepository.findById(id)
                .map(AquaticAnimal::new);

        if (existingElement.isPresent()) {
            AquaticAnimal updatedElement = existingElement.get();
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
            updatedElement.setNanoTank(animal.isNanoTank());
            updatedElement.setSpeciesTank(animal.isSpeciesTank());
            updatedElement.setRecommendedTankSize(animal.getRecommendedTankSize());
            updatedElement.setTempMin(animal.getTempMin());
            updatedElement.setTempMax(animal.getTempMax());
            updatedElement.setKhMin(animal.getKhMin());
            updatedElement.setKhMax(animal.getKhMax());
            updatedElement.setPhMin(animal.getPhMin());
            updatedElement.setPhMax(animal.getPhMax());
            updatedElement.setCo2Min(animal.getCo2Min());
            updatedElement.setCo2Max(animal.getCo2Max());
            updatedElement.setGhMin(animal.getGhMin());
            updatedElement.setGhMax(animal.getGhMax());
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

            return new AquaticAnimal(this.aquaticAnimalRepository.saveAndFlush(new AquaticAnimalEntity(updatedElement)));
        }
        else {
            throw new AquaticAnimalNotFoundException("Could not find a aquatic animal with id: " + id);
        }
    }

    public void deleteAquaticAnimal(Long id) {
        this.aquaticAnimalRepository.deleteById(id);
    }
}
