package de.traumastudios.ExoCompanionAPI.plant.controller;

import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import de.traumastudios.ExoCompanionAPI.plant.service.PlantService;
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
@RequestMapping("/plants")
public class PlantController {
    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public List<PlantDTO> list() {
        return this.plantService.findAllPlants()
                .stream()
                .map(PlantDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public PlantDTO read(@PathVariable @Min(1) Long id) {
        return this.plantService.findPlantById(id)
                .map(PlantDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public PlantDTO readByName(@PathVariable @NotBlank String name) {
        return this.plantService.findPlantByName(name)
                .map(PlantDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public PlantDTO create(@RequestBody @Valid @NotNull @NotEmpty Plant plant) {
        return new PlantDTO(this.plantService.createPlant(plant));
    }

    @PutMapping("/{id}")
    public PlantDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Plant plant) {
        return new PlantDTO(this.plantService.updatePlant(id, plant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.plantService.deletePlant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
