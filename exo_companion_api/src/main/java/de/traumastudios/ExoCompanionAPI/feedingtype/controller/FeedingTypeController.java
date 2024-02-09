package de.traumastudios.ExoCompanionAPI.feedingtype.controller;

import de.traumastudios.ExoCompanionAPI.feedingtype.domain.FeedingType;
import de.traumastudios.ExoCompanionAPI.feedingtype.service.FeedingTypeService;
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
@RequestMapping("/feeding-types")
public class FeedingTypeController {
    private final FeedingTypeService feedingTypeService;

    public FeedingTypeController(FeedingTypeService feedingTypeService) {
        this.feedingTypeService = feedingTypeService;
    }

    @GetMapping
    public List<FeedingTypeDTO> list() {
        return this.feedingTypeService.findAllFeedingTypes()
                .stream()
                .map(FeedingTypeDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public FeedingTypeDTO read(@PathVariable @Min(1) Long id) {
        return this.feedingTypeService.findFeedingTypeById(id)
                .map(FeedingTypeDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public FeedingTypeDTO readByName(@PathVariable @NotBlank String name) {
        return this.feedingTypeService.findFeedingTypeByName(name)
                .map(FeedingTypeDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public FeedingTypeDTO create(@RequestBody @Valid @NotNull @NotEmpty FeedingType feedingType) {
        return new FeedingTypeDTO(this.feedingTypeService.createFeedingType(feedingType));
    }

    @PutMapping("/{id}")
    public FeedingTypeDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty FeedingType feedingType) {
        return new FeedingTypeDTO(this.feedingTypeService.updateFeedingType(id, feedingType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.feedingTypeService.deleteFeedingType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
