package de.traumastudios.ExoCompanionAPI.growspeed.controller;

import de.traumastudios.ExoCompanionAPI.growspeed.domain.Growspeed;
import de.traumastudios.ExoCompanionAPI.growspeed.service.GrowspeedService;
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
@RequestMapping("/grow-speeds")
public class GrowspeedController {
    private final GrowspeedService growspeedService;

    public GrowspeedController(GrowspeedService growspeedService) {
        this.growspeedService = growspeedService;
    }

    @GetMapping
    public List<GrowspeedDTO> list() {
        return this.growspeedService.findAllGrowspeeds()
                .stream()
                .map(GrowspeedDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public GrowspeedDTO read(@PathVariable @Min(1) Long id) {
        return this.growspeedService.findGrowspeedById(id)
                .map(GrowspeedDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public GrowspeedDTO readByName(@PathVariable @NotBlank String name) {
        return this.growspeedService.findGrowspeedByName(name)
                .map(GrowspeedDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public GrowspeedDTO create(@RequestBody @Valid @NotNull @NotEmpty Growspeed difficulty) {
        return new GrowspeedDTO(this.growspeedService.createGrowspeed(difficulty));
    }

    @PutMapping("/{id}")
    public GrowspeedDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Growspeed difficulty) {
        return new GrowspeedDTO(this.growspeedService.updateGrowspeed(id, difficulty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.growspeedService.deleteGrowspeed(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
