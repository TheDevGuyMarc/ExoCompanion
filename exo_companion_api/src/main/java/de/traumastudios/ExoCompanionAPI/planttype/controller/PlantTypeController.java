package de.traumastudios.ExoCompanionAPI.planttype.controller;

import de.traumastudios.ExoCompanionAPI.planttype.domain.PlantType;
import de.traumastudios.ExoCompanionAPI.planttype.service.PlantTypeService;
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
@RequestMapping("/plant-types")
public class PlantTypeController {
    private final PlantTypeService plantTypeService;

    public PlantTypeController(PlantTypeService plantTypeService) {
        this.plantTypeService = plantTypeService;
    }

    @GetMapping
    public List<PlantTypeDTO> list() {
        return this.plantTypeService.findAllPlantTypes()
                .stream()
                .map(PlantTypeDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public PlantTypeDTO read(@PathVariable @Min(1) Long id) {
        return this.plantTypeService.findPlantTypeById(id)
                .map(PlantTypeDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public PlantTypeDTO readByName(@PathVariable @NotBlank String name) {
        return this.plantTypeService.findPlantTypeByName(name)
                .map(PlantTypeDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public PlantTypeDTO create(@RequestBody @Valid @NotNull @NotEmpty PlantType plantType) {
        return new PlantTypeDTO(this.plantTypeService.createPlantType(plantType));
    }

    @PutMapping("/{id}")
    public PlantTypeDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty PlantType plantType) {
        return new PlantTypeDTO(this.plantTypeService.updatePlantType(id, plantType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.plantTypeService.deletePlantType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
