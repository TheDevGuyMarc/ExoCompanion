package de.traumastudios.ExoCompanionAPI.behavior.controller;

import de.traumastudios.ExoCompanionAPI.behavior.domain.Behavior;
import de.traumastudios.ExoCompanionAPI.behavior.service.BehaviorService;
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
@RequestMapping("/behaviors")
public class BehaviorController {
    private final BehaviorService behaviorService;

    public BehaviorController(BehaviorService behaviorService) {
        this.behaviorService = behaviorService;
    }

    @GetMapping
    public List<BehaviorDTO> list() {
        return this.behaviorService.findAllBehaviors()
                .stream()
                .map(BehaviorDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public BehaviorDTO read(@PathVariable @Min(1) Long id) {
        return this.behaviorService.findBehaviorById(id)
                .map(BehaviorDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public BehaviorDTO readByName(@PathVariable @NotBlank String name) {
        return this.behaviorService.findBehaviorByName(name)
                .map(BehaviorDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public BehaviorDTO create(@RequestBody @Valid @NotNull @NotEmpty Behavior requirement) {
        return new BehaviorDTO(this.behaviorService.createBehavior(requirement));
    }

    @PutMapping("/{id}")
    public BehaviorDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Behavior requirement) {
        return new BehaviorDTO(this.behaviorService.updateBehavior(id, requirement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.behaviorService.deleteBehavior(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
