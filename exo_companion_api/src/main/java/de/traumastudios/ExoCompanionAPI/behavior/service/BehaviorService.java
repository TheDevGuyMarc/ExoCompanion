package de.traumastudios.ExoCompanionAPI.behavior.service;

import de.traumastudios.ExoCompanionAPI.behavior.domain.Behavior;
import de.traumastudios.ExoCompanionAPI.behavior.exception.BehaviorNotFoundException;
import de.traumastudios.ExoCompanionAPI.behavior.repository.BehaviorEntity;
import de.traumastudios.ExoCompanionAPI.behavior.repository.BehaviorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BehaviorService {
    private final BehaviorRepository behaviorRepository;

    public BehaviorService(BehaviorRepository behaviorRepository) {
        this.behaviorRepository = behaviorRepository;
    }

    public List<Behavior> findAllBehaviors() {
        return this.behaviorRepository.findAll()
                .stream()
                .map(Behavior::new)
                .toList();
    }

    public Optional<Behavior> findBehaviorById(Long id) {
        return this.behaviorRepository.findById(id)
                .map(Behavior::new);
    }

    public Optional<Behavior> findBehaviorByName(String name) {
        return this.behaviorRepository.findByName(name)
                .map(Behavior::new);
    }

    public Behavior createBehavior(Behavior behavior) {
        return new Behavior(this.behaviorRepository.saveAndFlush(new BehaviorEntity(behavior)));
    }

    public Behavior updateBehavior(Long id, Behavior behavior) {
        Optional<Behavior> existingElement = this.behaviorRepository.findById(id)
                .map(Behavior::new);

        if (existingElement.isPresent()) {
            Behavior updatedElement = existingElement.get();
            updatedElement.setId(behavior.getId());
            updatedElement.setName(behavior.getName());
            updatedElement.setDescription(behavior.getDescription());
            updatedElement.setAnimals(behavior.getAnimals());

            return new Behavior(this.behaviorRepository.saveAndFlush(new BehaviorEntity(updatedElement)));
        }
        else {
            throw new BehaviorNotFoundException("Could not find a behavior with id: " + id);
        }
    }

    public void deleteBehavior(Long id) {
        this.behaviorRepository.deleteById(id);
    }
}
