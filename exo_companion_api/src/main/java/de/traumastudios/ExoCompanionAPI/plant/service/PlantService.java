package de.traumastudios.ExoCompanionAPI.plant.service;

import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import de.traumastudios.ExoCompanionAPI.plant.exception.PlantNotFoundException;
import de.traumastudios.ExoCompanionAPI.plant.repository.PlantEntity;
import de.traumastudios.ExoCompanionAPI.plant.repository.PlantRepository;
import de.traumastudios.ExoCompanionAPI.planttype.domain.PlantType;
import de.traumastudios.ExoCompanionAPI.planttype.exception.PlantTypeNotFoundException;
import de.traumastudios.ExoCompanionAPI.planttype.repository.PlantTypeEntity;
import de.traumastudios.ExoCompanionAPI.planttype.repository.PlantTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantService {
    private final PlantRepository plantRepository;

    public PlantService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    public List<Plant> findAllPlants() {
        return this.plantRepository.findAll()
                .stream()
                .map(Plant::new)
                .toList();
    }

    public Optional<Plant> findPlantById(Long id) {
        return this.plantRepository.findById(id)
                .map(Plant::new);
    }

    public Optional<Plant> findPlantByName(String name) {
        return this.plantRepository.findByName(name)
                .map(Plant::new);
    }

    public Plant createPlant(Plant plant) {
        return new Plant(this.plantRepository.saveAndFlush(new PlantEntity(plant)));
    }

    public Plant updatePlant(Long id, Plant plant) {
        Optional<Plant> existingElement = this.plantRepository.findById(id)
                .map(Plant::new);

        if (existingElement.isPresent()) {
            Plant updatedElement = existingElement.get();
            updatedElement.setId(plant.getId());
            updatedElement.setName(plant.getName());
            updatedElement.setEngName(plant.getEngName());
            updatedElement.setLatName(plant.getLatName());
            updatedElement.setGroup(plant.getGroup());
            updatedElement.setSynonyms(plant.getSynonyms());
            updatedElement.setSubGroup(plant.getSubGroup());
            updatedElement.setOrder(plant.getOrder());
            updatedElement.setSubOrder(plant.getSubOrder());
            updatedElement.setFamily(plant.getFamily());
            updatedElement.setGenus(plant.getGenus());
            updatedElement.setImage(plant.getImage());
            updatedElement.setHeightMin(plant.getHeightMin());
            updatedElement.setHeightMax(plant.getHeightMax());
            updatedElement.setWidthMin(plant.getWidthMin());
            updatedElement.setWidthMax(plant.getWidthMax());
            updatedElement.setCategories(plant.getCategories());
            updatedElement.setPlantTypes(plant.getPlantTypes());
            updatedElement.setOrigins(plant.getOrigins());
            updatedElement.setDifficulties(plant.getDifficulties());
            updatedElement.setLocations(plant.getLocations());
            updatedElement.setRarities(plant.getRarities());
            updatedElement.setCulture(plant.getCulture());

            return new Plant(this.plantRepository.saveAndFlush(new PlantEntity(updatedElement)));
        }
        else {
            throw new PlantNotFoundException("Could not find a plant with id: " + id);
        }
    }

    public void deletePlant(Long id) {
        this.plantRepository.deleteById(id);
    }
}
