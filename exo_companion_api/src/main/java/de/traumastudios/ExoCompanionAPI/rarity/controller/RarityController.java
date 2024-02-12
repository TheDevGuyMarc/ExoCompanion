package de.traumastudios.ExoCompanionAPI.rarity.controller;

import de.traumastudios.ExoCompanionAPI.rarity.domain.Rarity;
import de.traumastudios.ExoCompanionAPI.rarity.service.RarityService;
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
@RequestMapping("/rarities")
public class RarityController {
    private final RarityService rarityService;

    public RarityController(RarityService rarityService) {
        this.rarityService = rarityService;
    }

    @GetMapping
    public List<RarityDTO> list() {
        return this.rarityService.findAllRarities()
                .stream()
                .map(RarityDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public RarityDTO read(@PathVariable @Min(1) Long id) {
        return this.rarityService.findRarityById(id)
                .map(RarityDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public RarityDTO readByName(@PathVariable @NotBlank String name) {
        return this.rarityService.findRarityByName(name)
                .map(RarityDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public RarityDTO create(@RequestBody @Valid @NotNull @NotEmpty Rarity rarity) {
        return new RarityDTO(this.rarityService.createRarity(rarity));
    }

    @PutMapping("/{id}")
    public RarityDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Rarity rarity) {
        return new RarityDTO(this.rarityService.updateRarity(id, rarity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.rarityService.deleteRarity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
