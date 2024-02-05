package de.traumastudios.ExoCompanionAPI.origin.service;

import de.traumastudios.ExoCompanionAPI.origin.domain.Origin;
import de.traumastudios.ExoCompanionAPI.origin.exception.OriginNotFoundException;
import de.traumastudios.ExoCompanionAPI.origin.repository.OriginEntity;
import de.traumastudios.ExoCompanionAPI.origin.repository.OriginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OriginService {
    private final OriginRepository originRepository;

    public OriginService(OriginRepository originRepository) {
        this.originRepository = originRepository;
    }

    public List<Origin> findAllOrigins() {
        return this.originRepository.findAll()
                .stream()
                .map(Origin::new)
                .toList();
    }

    public Optional<Origin> findOriginById(Long id) {
        return this.originRepository.findById(id)
                .map(Origin::new);
    }

    public Optional<Origin> findOriginByName(String name) {
        return this.originRepository.findByName(name)
                .map(Origin::new);
    }

    public Origin createOrigin(Origin origin) {
        return new Origin(this.originRepository.saveAndFlush(new OriginEntity(origin)));
    }

    public Origin updateOrigin(Long id, Origin origin) {
        Optional<Origin> existingElement = this.originRepository.findById(id)
                .map(Origin::new);

        if (existingElement.isPresent()) {
            Origin updatedElement = existingElement.get();
            updatedElement.setId(origin.getId());
            updatedElement.setName(origin.getName());
            updatedElement.setDescription(origin.getDescription());
            updatedElement.setTempMin(origin.getTempMin());
            updatedElement.setTempMax(origin.getTempMax());
            updatedElement.setHumidity(origin.getHumidity());
            updatedElement.setDayCycleHours(origin.getDayCycleHours());
            //updatedElement.setAnimals(origin.getAnimals());

            return new Origin(this.originRepository.saveAndFlush(new OriginEntity(updatedElement)));
        }
        else {
            throw new OriginNotFoundException("Could not find a origin with id: " + id);
        }
    }

    public void deleteOrigin(Long id) {
        this.originRepository.deleteById(id);
    }
}
