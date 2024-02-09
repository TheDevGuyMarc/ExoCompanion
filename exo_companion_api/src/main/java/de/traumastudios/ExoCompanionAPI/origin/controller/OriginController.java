package de.traumastudios.ExoCompanionAPI.origin.controller;

import de.traumastudios.ExoCompanionAPI.origin.domain.Origin;
import de.traumastudios.ExoCompanionAPI.origin.service.OriginService;
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
@RequestMapping("/origins")
public class OriginController {
    private final OriginService originService;

    public OriginController(OriginService originService) {
        this.originService = originService;
    }

    @GetMapping
    public List<OriginDTO> list() {
        return this.originService.findAllOrigins()
                .stream()
                .map(OriginDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public OriginDTO read(@PathVariable @Min(1) Long id) {
        return this.originService.findOriginById(id)
                .map(OriginDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public OriginDTO readByName(@PathVariable @NotBlank String name) {
        return this.originService.findOriginByName(name)
                .map(OriginDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public OriginDTO create(@RequestBody @Valid @NotNull @NotEmpty Origin origin) {
        return new OriginDTO(this.originService.createOrigin(origin));
    }

    @PutMapping("/{id}")
    public OriginDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Origin origin) {
        return new OriginDTO(this.originService.updateOrigin(id, origin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.originService.deleteOrigin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
