package de.traumastudios.ExoCompanionAPI.location.controller;

import de.traumastudios.ExoCompanionAPI.location.domain.Location;
import de.traumastudios.ExoCompanionAPI.location.service.LocationService;
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
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<LocationDTO> list() {
        return this.locationService.findAllLocations()
                .stream()
                .map(LocationDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public LocationDTO read(@PathVariable @Min(1) Long id) {
        return this.locationService.findLocationById(id)
                .map(LocationDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public LocationDTO readByName(@PathVariable @NotBlank String name) {
        return this.locationService.findLocationByName(name)
                .map(LocationDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public LocationDTO create(@RequestBody @Valid @NotNull @NotEmpty Location location) {
        return new LocationDTO(this.locationService.createLocation(location));
    }

    @PutMapping("/{id}")
    public LocationDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Location location) {
        return new LocationDTO(this.locationService.updateLocation(id, location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.locationService.deleteLocation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
