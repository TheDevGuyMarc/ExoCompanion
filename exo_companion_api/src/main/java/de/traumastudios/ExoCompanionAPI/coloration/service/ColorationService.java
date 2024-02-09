package de.traumastudios.ExoCompanionAPI.coloration.service;

import de.traumastudios.ExoCompanionAPI.coloration.domain.Coloration;
import de.traumastudios.ExoCompanionAPI.coloration.exception.ColorationNotFoundException;
import de.traumastudios.ExoCompanionAPI.coloration.repository.ColorationEntity;
import de.traumastudios.ExoCompanionAPI.coloration.repository.ColorationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorationService {
    private final ColorationRepository colorationRepository;

    public ColorationService(ColorationRepository colorationRepository) {
        this.colorationRepository = colorationRepository;
    }

    public List<Coloration> findAllColorations() {
        return this.colorationRepository.findAll()
                .stream()
                .map(Coloration::new)
                .toList();
    }

    public Optional<Coloration> findColorationById(Long id) {
        return this.colorationRepository.findById(id)
                .map(Coloration::new);
    }

    public Optional<Coloration> findColorationByName(String name) {
        return this.colorationRepository.findByName(name)
                .map(Coloration::new);
    }

    public Coloration createColoration(Coloration coloration) {
        return new Coloration(this.colorationRepository.saveAndFlush(new ColorationEntity(coloration)));
    }

    public Coloration updateColoration(Long id, Coloration coloration) {
        Optional<Coloration> existingElement = this.colorationRepository.findById(id)
                .map(Coloration::new);

        if (existingElement.isPresent()) {
            Coloration updatedElement = existingElement.get();
            updatedElement.setId(coloration.getId());
            updatedElement.setName(coloration.getName());
            updatedElement.setDescription(coloration.getDescription());
            updatedElement.setCultures(coloration.getCultures());
            updatedElement.setAnimals(coloration.getAnimals());

            return new Coloration(this.colorationRepository.saveAndFlush(new ColorationEntity(updatedElement)));
        }
        else {
            throw new ColorationNotFoundException("Could not find a coloration with id: " + id);
        }
    }

    public void deleteColoration(Long id) {
        this.colorationRepository.deleteById(id);
    }
}
