package de.traumastudios.ExoCompanionAPI.planttype.service;

import de.traumastudios.ExoCompanionAPI.planttype.domain.PlantType;
import de.traumastudios.ExoCompanionAPI.planttype.exception.PlantTypeNotFoundException;
import de.traumastudios.ExoCompanionAPI.planttype.repository.PlantTypeEntity;
import de.traumastudios.ExoCompanionAPI.planttype.repository.PlantTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantTypeService {
    private final PlantTypeRepository plantTypeRepository;

    public PlantTypeService(PlantTypeRepository plantTypeRepository) {
        this.plantTypeRepository = plantTypeRepository;
    }

    public List<PlantType> findAllPlantTypes() {
        return this.plantTypeRepository.findAll()
                .stream()
                .map(PlantType::new)
                .toList();
    }

    public Optional<PlantType> findPlantTypeById(Long id) {
        return this.plantTypeRepository.findById(id)
                .map(PlantType::new);
    }

    public Optional<PlantType> findPlantTypeByName(String name) {
        return this.plantTypeRepository.findByName(name)
                .map(PlantType::new);
    }

    public PlantType createPlantType(PlantType plantType) {
        return new PlantType(this.plantTypeRepository.saveAndFlush(new PlantTypeEntity(plantType)));
    }

    public PlantType updatePlantType(Long id, PlantType plantType) {
        Optional<PlantType> existingElement = this.plantTypeRepository.findById(id)
                .map(PlantType::new);

        if (existingElement.isPresent()) {
            PlantType updatedElement = existingElement.get();
            updatedElement.setId(plantType.getId());
            updatedElement.setName(plantType.getName());
            updatedElement.setDescription(plantType.getDescription());
            updatedElement.setImage(plantType.getImage());

            return new PlantType(this.plantTypeRepository.saveAndFlush(new PlantTypeEntity(updatedElement)));
        }
        else {
            throw new PlantTypeNotFoundException("Could not find a plant type with id: " + id);
        }
    }

    public void deletePlantType(Long id) {
        this.plantTypeRepository.deleteById(id);
    }
}
