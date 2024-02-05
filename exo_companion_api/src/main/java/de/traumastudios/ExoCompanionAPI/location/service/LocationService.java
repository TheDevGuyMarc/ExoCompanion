package de.traumastudios.ExoCompanionAPI.location.service;


import de.traumastudios.ExoCompanionAPI.location.domain.Location;
import de.traumastudios.ExoCompanionAPI.location.exception.LocationNotFoundException;
import de.traumastudios.ExoCompanionAPI.location.repository.LocationEntity;
import de.traumastudios.ExoCompanionAPI.location.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> findAllLocations() {
        return this.locationRepository.findAll()
                .stream()
                .map(Location::new)
                .toList();
    }

    public Optional<Location> findLocationById(Long id) {
        return this.locationRepository.findById(id)
                .map(Location::new);
    }

    public Optional<Location> findLocationByName(String name) {
        return this.locationRepository.findByName(name)
                .map(Location::new);
    }

    public Location createLocation(Location location) {
        return new Location(this.locationRepository.saveAndFlush(new LocationEntity(location)));
    }

    public Location updateLocation(Long id, Location location) {
        Optional<Location> existingElement = this.locationRepository.findById(id)
                .map(Location::new);

        if (existingElement.isPresent()) {
            Location updatedElement = existingElement.get();
            updatedElement.setId(location.getId());
            updatedElement.setName(location.getName());
            updatedElement.setDescription(location.getDescription());
            updatedElement.setPlants(location.getPlants());

            return new Location(this.locationRepository.saveAndFlush(new LocationEntity(updatedElement)));
        }
        else {
            throw new LocationNotFoundException("Could not find a location with id: " + id);
        }
    }

    public void deleteLocation(Long id) {
        this.locationRepository.deleteById(id);
    }
}
