package de.traumastudios.ExoCompanionAPI.requirement.controller;

import de.traumastudios.ExoCompanionAPI.requirement.domain.Requirement;
import de.traumastudios.ExoCompanionAPI.requirement.service.RequirementService;
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
@RequestMapping("/requirements")
public class RequirementController {
    private final RequirementService requirementService;

    public RequirementController(RequirementService requirementService) {
        this.requirementService = requirementService;
    }

    @GetMapping
    public List<RequirementDTO> list() {
        return this.requirementService.findAllRequirements()
                .stream()
                .map(RequirementDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public RequirementDTO read(@PathVariable @Min(1) Long id) {
        return this.requirementService.findRequirementById(id)
                .map(RequirementDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public RequirementDTO readByName(@PathVariable @NotBlank String name) {
        return this.requirementService.findRequirementByName(name)
                .map(RequirementDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public RequirementDTO create(@RequestBody @Valid @NotNull @NotEmpty Requirement requirement) {
        return new RequirementDTO(this.requirementService.createRequirement(requirement));
    }

    @PutMapping("/{id}")
    public RequirementDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Requirement requirement) {
        return new RequirementDTO(this.requirementService.updateRequirement(id, requirement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.requirementService.deleteRequirement(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
