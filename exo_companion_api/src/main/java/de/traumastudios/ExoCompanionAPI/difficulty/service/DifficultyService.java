package de.traumastudios.ExoCompanionAPI.difficulty.service;

import de.traumastudios.ExoCompanionAPI.difficulty.domain.Difficulty;
import de.traumastudios.ExoCompanionAPI.difficulty.exception.DifficultyNotFoundException;
import de.traumastudios.ExoCompanionAPI.difficulty.repository.DifficultyEntity;
import de.traumastudios.ExoCompanionAPI.difficulty.repository.DifficultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DifficultyService {
    private final DifficultyRepository difficultyRepository;

    public DifficultyService(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }

    public List<Difficulty> findAllDifficulties() {
        return this.difficultyRepository.findAll()
                .stream()
                .map(Difficulty::new)
                .toList();
    }

    public Optional<Difficulty> findDifficultyById(Long id) {
        return this.difficultyRepository.findById(id)
                .map(Difficulty::new);
    }

    public Optional<Difficulty> findDifficultyByName(String name) {
        return this.difficultyRepository.findByName(name)
                .map(Difficulty::new);
    }

    public Difficulty createDifficulty(Difficulty difficulty) {
        return new Difficulty(this.difficultyRepository.saveAndFlush(new DifficultyEntity(difficulty)));
    }

    public Difficulty updateDifficulty(Long id, Difficulty difficulty) {
        Optional<Difficulty> existingElement = this.difficultyRepository.findById(id)
                .map(Difficulty::new);

        if (existingElement.isPresent()) {
            Difficulty updatedElement = existingElement.get();
            updatedElement.setId(difficulty.getId());
            updatedElement.setName(difficulty.getName());
            updatedElement.setDescription(difficulty.getDescription());
            updatedElement.setPlants(difficulty.getPlants());

            return new Difficulty(this.difficultyRepository.saveAndFlush(new DifficultyEntity(updatedElement)));
        }
        else {
            throw new DifficultyNotFoundException("Could not find a difficulty with id: " + id);
        }
    }

    public void deleteDifficulty(Long id) {
        this.difficultyRepository.deleteById(id);
    }
}
