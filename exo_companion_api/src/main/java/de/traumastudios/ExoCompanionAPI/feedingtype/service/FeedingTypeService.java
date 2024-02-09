package de.traumastudios.ExoCompanionAPI.feedingtype.service;

import de.traumastudios.ExoCompanionAPI.feedingtype.domain.FeedingType;
import de.traumastudios.ExoCompanionAPI.feedingtype.exception.FeedingTypeNotFoundException;
import de.traumastudios.ExoCompanionAPI.feedingtype.repository.FeedingTypeEntity;
import de.traumastudios.ExoCompanionAPI.feedingtype.repository.FeedingTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedingTypeService {
    private final FeedingTypeRepository feedingTypeRepository;

    public FeedingTypeService(FeedingTypeRepository feedingTypeRepository) {
        this.feedingTypeRepository = feedingTypeRepository;
    }

    public List<FeedingType> findAllFeedingTypes() {
        return this.feedingTypeRepository.findAll()
                .stream()
                .map(FeedingType::new)
                .toList();
    }

    public Optional<FeedingType> findFeedingTypeById(Long id) {
        return this.feedingTypeRepository.findById(id)
                .map(FeedingType::new);
    }

    public Optional<FeedingType> findFeedingTypeByName(String name) {
        return this.feedingTypeRepository.findByName(name)
                .map(FeedingType::new);
    }

    public FeedingType createFeedingType(FeedingType feedingType) {
        return new FeedingType(this.feedingTypeRepository.saveAndFlush(new FeedingTypeEntity(feedingType)));
    }

    public FeedingType updateFeedingType(Long id, FeedingType feedingType) {
        Optional<FeedingType> existingElement = this.feedingTypeRepository.findById(id)
                .map(FeedingType::new);

        if (existingElement.isPresent()) {
            FeedingType updatedElement = existingElement.get();
            updatedElement.setId(feedingType.getId());
            updatedElement.setName(feedingType.getName());
            updatedElement.setDescription(feedingType.getDescription());
            updatedElement.setLandAnimals(feedingType.getLandAnimals());
            updatedElement.setAquaticAnimals(feedingType.getAquaticAnimals());

            return new FeedingType(this.feedingTypeRepository.saveAndFlush(new FeedingTypeEntity(updatedElement)));
        }
        else {
            throw new FeedingTypeNotFoundException("Could not find a feeding type with id: " + id);
        }
    }

    public void deleteFeedingType(Long id) {
        this.feedingTypeRepository.deleteById(id);
    }
}
