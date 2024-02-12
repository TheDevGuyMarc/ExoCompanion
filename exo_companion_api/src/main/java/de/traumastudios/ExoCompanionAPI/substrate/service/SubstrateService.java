package de.traumastudios.ExoCompanionAPI.substrate.service;

import de.traumastudios.ExoCompanionAPI.substrate.domain.Substrate;
import de.traumastudios.ExoCompanionAPI.substrate.exception.SubstrateNotFoundException;
import de.traumastudios.ExoCompanionAPI.substrate.repository.SubstrateEntity;
import de.traumastudios.ExoCompanionAPI.substrate.repository.SubstrateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubstrateService {
    private final SubstrateRepository substrateRepository;

    public SubstrateService(SubstrateRepository substrateRepository) {
        this.substrateRepository = substrateRepository;
    }

    public List<Substrate> findAllSubstrates() {
        return this.substrateRepository.findAll()
                .stream()
                .map(Substrate::new)
                .toList();
    }

    public Optional<Substrate> findSubstrateById(Long id) {
        return this.substrateRepository.findById(id)
                .map(Substrate::new);
    }

    public Optional<Substrate> findSubstrateByName(String name) {
        return this.substrateRepository.findByName(name)
                .map(Substrate::new);
    }

    public Substrate createSubstrate(Substrate substrate) {
        return new Substrate(this.substrateRepository.saveAndFlush(new SubstrateEntity(substrate)));
    }

    public Substrate updateSubstrate(Long id, Substrate substrate) {
        Optional<Substrate> existingElement = this.substrateRepository.findById(id)
                .map(Substrate::new);

        if (existingElement.isPresent()) {
            Substrate updatedElement = existingElement.get();
            updatedElement.setId(substrate.getId());
            updatedElement.setName(substrate.getName());
            updatedElement.setDescription(substrate.getDescription());
            updatedElement.setImage(substrate.getImage());
            updatedElement.setManufacturer(substrate.getManufacturer());
            updatedElement.setAmount(substrate.getAmount());
            updatedElement.setPrice(substrate.getPrice());
            updatedElement.setAnimals(substrate.getAnimals());

            return new Substrate(this.substrateRepository.saveAndFlush(new SubstrateEntity(updatedElement)));
        }
        else {
            throw new SubstrateNotFoundException("Could not find a substrate with id: " + id);
        }
    }

    public void deleteSubstrate(Long id) {
        this.substrateRepository.deleteById(id);
    }
}
