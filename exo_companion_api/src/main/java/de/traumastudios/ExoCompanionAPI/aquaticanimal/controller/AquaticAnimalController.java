package de.traumastudios.ExoCompanionAPI.aquaticanimal.controller;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.domain.AquaticAnimal;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.service.AquaticAnimalService;
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
@RequestMapping("/aquatic-animals")
public class AquaticAnimalController {
    private final AquaticAnimalService aquaticAnimalService;

    public AquaticAnimalController(AquaticAnimalService aquaticAnimalService) {
        this.aquaticAnimalService = aquaticAnimalService;
    }

    @GetMapping
    public List<AquaticAnimalDTO> list() {
        return this.aquaticAnimalService.findAllAquaticAnimals()
                .stream()
                .map(AquaticAnimalDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public AquaticAnimalDTO read(@PathVariable @Min(1) Long id) {
        return this.aquaticAnimalService.findAquaticAnimalById(id)
                .map(AquaticAnimalDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public AquaticAnimalDTO readByName(@PathVariable @NotBlank String name) {
        return this.aquaticAnimalService.findAquaticAnimalByName(name)
                .map(AquaticAnimalDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public AquaticAnimalDTO create(@RequestBody @Valid @NotNull @NotEmpty AquaticAnimal animal) {
        return new AquaticAnimalDTO(this.aquaticAnimalService.createAquaticAnimal(animal));
    }

    @PutMapping("/{id}")
    public AquaticAnimalDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty AquaticAnimal animal) {
        return new AquaticAnimalDTO(this.aquaticAnimalService.updateAquaticAnimal(id, animal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.aquaticAnimalService.deleteAquaticAnimal(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
