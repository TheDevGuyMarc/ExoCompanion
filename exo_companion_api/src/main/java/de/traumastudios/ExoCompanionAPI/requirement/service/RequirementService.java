package de.traumastudios.ExoCompanionAPI.requirement.service;

import de.traumastudios.ExoCompanionAPI.requirement.domain.Requirement;
import de.traumastudios.ExoCompanionAPI.requirement.exception.RequirementNotFoundException;
import de.traumastudios.ExoCompanionAPI.requirement.repository.RequirementEntity;
import de.traumastudios.ExoCompanionAPI.requirement.repository.RequirementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequirementService {
    private final RequirementRepository requirementRepository;

    public RequirementService(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    public List<Requirement> findAllRequirements() {
        return this.requirementRepository.findAll()
                .stream()
                .map(Requirement::new)
                .toList();
    }

    public Optional<Requirement> findRequirementById(Long id) {
        return this.requirementRepository.findById(id)
                .map(Requirement::new);
    }

    public Optional<Requirement> findRequirementByName(String name) {
        return this.requirementRepository.findByName(name)
                .map(Requirement::new);
    }

    public Requirement createRequirement(Requirement requirement) {
        return new Requirement(this.requirementRepository.saveAndFlush(new RequirementEntity(requirement)));
    }

    public Requirement updateRequirement(Long id, Requirement requirement) {
        Optional<Requirement> existingElement = this.requirementRepository.findById(id)
                .map(Requirement::new);

        if (existingElement.isPresent()) {
            Requirement updatedElement = existingElement.get();
            updatedElement.setId(requirement.getId());
            updatedElement.setName(requirement.getName());
            updatedElement.setDescription(requirement.getDescription());
            updatedElement.setAnimals(requirement.getAnimals());

            return new Requirement(this.requirementRepository.saveAndFlush(new RequirementEntity(updatedElement)));
        }
        else {
            throw new RequirementNotFoundException("Could not find a requirement with id: " + id);
        }
    }

    public void deleteRequirement(Long id) {
        this.requirementRepository.deleteById(id);
    }
}
