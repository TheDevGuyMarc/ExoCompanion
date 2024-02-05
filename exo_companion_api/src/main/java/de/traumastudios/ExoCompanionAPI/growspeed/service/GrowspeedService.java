package de.traumastudios.ExoCompanionAPI.growspeed.service;

import de.traumastudios.ExoCompanionAPI.growspeed.domain.Growspeed;
import de.traumastudios.ExoCompanionAPI.growspeed.exception.GrowspeedNotFoundException;
import de.traumastudios.ExoCompanionAPI.growspeed.repository.GrowspeedEntity;
import de.traumastudios.ExoCompanionAPI.growspeed.repository.GrowspeedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrowspeedService {
    private final GrowspeedRepository growspeedRepository;

    public GrowspeedService(GrowspeedRepository growspeedRepository) {
        this.growspeedRepository = growspeedRepository;
    }

    public List<Growspeed> findAllGrowspeeds() {
        return this.growspeedRepository.findAll()
                .stream()
                .map(Growspeed::new)
                .toList();
    }

    public Optional<Growspeed> findGrowspeedById(Long id) {
        return this.growspeedRepository.findById(id)
                .map(Growspeed::new);
    }

    public Optional<Growspeed> findGrowspeedByName(String name) {
        return this.growspeedRepository.findByName(name)
                .map(Growspeed::new);
    }

    public Growspeed createGrowspeed(Growspeed growspeed) {
        return new Growspeed(this.growspeedRepository.saveAndFlush(new GrowspeedEntity(growspeed)));
    }

    public Growspeed updateGrowspeed(Long id, Growspeed growspeed) {
        Optional<Growspeed> existingElement = this.growspeedRepository.findById(id)
                .map(Growspeed::new);

        if (existingElement.isPresent()) {
            Growspeed updatedElement = existingElement.get();
            updatedElement.setId(growspeed.getId());
            updatedElement.setName(growspeed.getName());
            updatedElement.setDescription(growspeed.getDescription());

            return new Growspeed(this.growspeedRepository.saveAndFlush(new GrowspeedEntity(updatedElement)));
        }
        else {
            throw new GrowspeedNotFoundException("Could not find a growspeed with id: " + id);
        }
    }

    public void deleteGrowspeed(Long id) {
        this.growspeedRepository.deleteById(id);
    }
}
