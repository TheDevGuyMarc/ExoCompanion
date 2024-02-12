package de.traumastudios.ExoCompanionAPI.difficulty.controller;

import de.traumastudios.ExoCompanionAPI.difficulty.domain.Difficulty;
import de.traumastudios.ExoCompanionAPI.difficulty.service.DifficultyService;
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
@RequestMapping("/difficulties")
public class DifficultyController {
    private final DifficultyService difficultyService;

    public DifficultyController(DifficultyService difficultyService) {
        this.difficultyService = difficultyService;
    }

    @GetMapping
    public List<DifficultyDTO> list() {
        return this.difficultyService.findAllDifficulties()
                .stream()
                .map(DifficultyDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public DifficultyDTO read(@PathVariable @Min(1) Long id) {
        return this.difficultyService.findDifficultyById(id)
                .map(DifficultyDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public DifficultyDTO readByName(@PathVariable @NotBlank String name) {
        return this.difficultyService.findDifficultyByName(name)
                .map(DifficultyDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public DifficultyDTO create(@RequestBody @Valid @NotNull @NotEmpty Difficulty difficulty) {
        return new DifficultyDTO(this.difficultyService.createDifficulty(difficulty));
    }

    @PutMapping("/{id}")
    public DifficultyDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Difficulty difficulty) {
        return new DifficultyDTO(this.difficultyService.updateDifficulty(id, difficulty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.difficultyService.deleteDifficulty(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
