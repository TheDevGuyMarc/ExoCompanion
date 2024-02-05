package de.traumastudios.ExoCompanionAPI.coloration.controller;

import de.traumastudios.ExoCompanionAPI.coloration.domain.Coloration;
import de.traumastudios.ExoCompanionAPI.coloration.service.ColorationService;
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
@RequestMapping("/colorations")
public class ColorationController {
    private final ColorationService colorationService;

    public ColorationController(ColorationService colorationService) {
        this.colorationService = colorationService;
    }

    @GetMapping
    public List<ColorationDTO> list() {
        return this.colorationService.findAllColorations()
                .stream()
                .map(ColorationDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ColorationDTO read(@PathVariable @Min(1) Long id) {
        return this.colorationService.findColorationById(id)
                .map(ColorationDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public ColorationDTO readByName(@PathVariable @NotBlank String name) {
        return this.colorationService.findColorationByName(name)
                .map(ColorationDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public ColorationDTO create(@RequestBody @Valid @NotNull @NotEmpty Coloration coloration) {
        return new ColorationDTO(this.colorationService.createColoration(coloration));
    }

    @PutMapping("/{id}")
    public ColorationDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Coloration coloration) {
        return new ColorationDTO(this.colorationService.updateColoration(id, coloration));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.colorationService.deleteColoration(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
