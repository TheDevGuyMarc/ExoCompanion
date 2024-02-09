package de.traumastudios.ExoCompanionAPI.substrate.controller;

import de.traumastudios.ExoCompanionAPI.substrate.domain.Substrate;
import de.traumastudios.ExoCompanionAPI.substrate.service.SubstrateService;
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
@RequestMapping("/substrates")
public class SubstrateController {
    private final SubstrateService substrateService;

    public SubstrateController(SubstrateService substrateService) {
        this.substrateService = substrateService;
    }

    @GetMapping
    public List<SubstrateDTO> list() {
        return this.substrateService.findAllSubstrates()
                .stream()
                .map(SubstrateDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public SubstrateDTO read(@PathVariable @Min(1) Long id) {
        return this.substrateService.findSubstrateById(id)
                .map(SubstrateDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public SubstrateDTO readByName(@PathVariable @NotBlank String name) {
        return this.substrateService.findSubstrateByName(name)
                .map(SubstrateDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public SubstrateDTO create(@RequestBody @Valid @NotNull @NotEmpty Substrate substrate) {
        return new SubstrateDTO(this.substrateService.createSubstrate(substrate));
    }

    @PutMapping("/{id}")
    public SubstrateDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Substrate substrate) {
        return new SubstrateDTO(this.substrateService.updateSubstrate(id, substrate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.substrateService.deleteSubstrate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
