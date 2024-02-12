package de.traumastudios.ExoCompanionAPI.landanimal.controller;

import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import de.traumastudios.ExoCompanionAPI.landanimal.service.LandAnimalService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/land-animals")
public class LandAnimalController {
    private final LandAnimalService landAnimalService;

    public LandAnimalController(LandAnimalService landAnimalService) {
        this.landAnimalService = landAnimalService;
    }

    @GetMapping
    public List<LandAnimalDTO> list() {
        return this.landAnimalService.findAllLandAnimals()
                .stream()
                .map(LandAnimalDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public LandAnimalDTO read(@PathVariable @Min(1) Long id) {
        return this.landAnimalService.findLandAnimalById(id)
                .map(LandAnimalDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public LandAnimalDTO readByName(@PathVariable @NotBlank String name) {
        return this.landAnimalService.findLandAnimalByName(name)
                .map(LandAnimalDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public LandAnimalDTO create(@RequestBody @Valid @NotNull @NotEmpty LandAnimal animal) {
        return new LandAnimalDTO(this.landAnimalService.createLandAnimal(animal));
    }

    @PutMapping("/{id}")
    public LandAnimalDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty LandAnimal animal) {
        return new LandAnimalDTO(this.landAnimalService.updateLandAnimal(id, animal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.landAnimalService.deleteLandAnimal(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
