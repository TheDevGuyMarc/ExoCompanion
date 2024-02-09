package de.traumastudios.ExoCompanionAPI.culture.controller;

import de.traumastudios.ExoCompanionAPI.culture.domain.Culture;
import de.traumastudios.ExoCompanionAPI.culture.service.CultureService;
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
@RequestMapping("/cultures")
public class CultureController {
    private final CultureService cultureService;

    public CultureController(CultureService cultureService) {
        this.cultureService = cultureService;
    }

    @GetMapping
    public List<CultureDTO> list() {
        return this.cultureService.findAllCultures()
                .stream()
                .map(CultureDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public CultureDTO read(@PathVariable @Min(1) Long id) {
        return this.cultureService.findCultureById(id)
                .map(CultureDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public CultureDTO create(@RequestBody @Valid @NotNull @NotEmpty Culture culture) {
        return new CultureDTO(this.cultureService.createCulture(culture));
    }

    @PutMapping("/{id}")
    public CultureDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Culture culture) {
        return new CultureDTO(this.cultureService.updateCulture(id, culture));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.cultureService.deleteCulture(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
