package de.traumastudios.ExoCompanionAPI.rarity.service;

import de.traumastudios.ExoCompanionAPI.rarity.domain.Rarity;
import de.traumastudios.ExoCompanionAPI.rarity.exception.RarityNotFoundException;
import de.traumastudios.ExoCompanionAPI.rarity.repository.RarityEntity;
import de.traumastudios.ExoCompanionAPI.rarity.repository.RarityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RarityService {
    private final RarityRepository rarityRepository;

    public RarityService(RarityRepository rarityRepository) {
        this.rarityRepository = rarityRepository;
    }

    public List<Rarity> findAllRarities() {
        return this.rarityRepository.findAll()
                .stream()
                .map(Rarity::new)
                .toList();
    }

    public Optional<Rarity> findRarityById(Long id) {
        return this.rarityRepository.findById(id)
                .map(Rarity::new);
    }

    public Optional<Rarity> findRarityByName(String name) {
        return this.rarityRepository.findByName(name)
                .map(Rarity::new);
    }

    public Rarity createRarity(Rarity rarity) {
        return new Rarity(this.rarityRepository.saveAndFlush(new RarityEntity(rarity)));
    }

    public Rarity updateRarity(Long id, Rarity rarity) {
        Optional<Rarity> existingElement = this.rarityRepository.findById(id)
                .map(Rarity::new);

        if (existingElement.isPresent()) {
            Rarity updatedElement = existingElement.get();
            updatedElement.setId(rarity.getId());
            updatedElement.setName(rarity.getName());
            updatedElement.setDescription(rarity.getDescription());
            updatedElement.setPlants(rarity.getPlants());
            updatedElement.setAnimals(rarity.getAnimals());

            return new Rarity(this.rarityRepository.saveAndFlush(new RarityEntity(updatedElement)));
        }
        else {
            throw new RarityNotFoundException("Could not find a rarity with id: " + id);
        }
    }

    public void deleteRarity(Long id) {
        this.rarityRepository.deleteById(id);
    }
}
