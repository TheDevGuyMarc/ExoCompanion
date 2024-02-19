package de.traumastudios.ExoCompanionAPI.Unit.location;

import de.traumastudios.ExoCompanionAPI.location.domain.Location;
import de.traumastudios.ExoCompanionAPI.location.repository.LocationEntity;
import de.traumastudios.ExoCompanionAPI.location.repository.LocationRepository;
import de.traumastudios.ExoCompanionAPI.location.service.LocationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocationServiceUnitTest {
    @Mock
    private LocationRepository repository;

    @InjectMocks
    private LocationService locationService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllLocations() {
        // given
        LocationEntity entity1 = mock(LocationEntity.class);
        LocationEntity entity2 = mock(LocationEntity.class);

        List<LocationEntity> mockLocations = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockLocations).when(repository).findAll();
        List<Location> locations = this.locationService.findAllLocations();

        // then
        Assertions.assertThat(locations)
            .allMatch(location -> location instanceof Location)
            .withFailMessage("Element in the list is not of type Location");
    }

    @Test
    public void itShouldFindALocationById() {
        // given
        LocationEntity entity = mock(LocationEntity.class);
        Optional<LocationEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(repository).findById(productID);
        Optional<Location> location = this.locationService.findLocationById(productID);

        // then
        Assertions.assertThat(location).isPresent();
        Assertions.assertThat(location).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfALocationCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(repository).findById(nonExistentId);

        // When
        Optional<Location> location = this.locationService.findLocationById(nonExistentId);

        // Then
        Assertions.assertThat(location).isEmpty();
    }

    @Test
    public void itShouldFindALocationByName() {
        // given
        LocationEntity entity = mock(LocationEntity.class);
        Optional<LocationEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(repository).findByName(name);
        Optional<Location> location = this.locationService.findLocationByName(name);

        // then
        Assertions.assertThat(location).isPresent();
        Assertions.assertThat(location.get()).isInstanceOf(Location.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfALocationCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonexistentfish";
        doReturn(Optional.empty()).when(repository).findByName(nonExistentName);

        // When
        Optional<Location> location = this.locationService.findLocationByName(nonExistentName);

        // Then
        Assertions.assertThat(location).isEmpty();
    }

    @Test
    public void itShouldCreateANewLocation() {
        // Given
        LocationEntity savedEntity = mock(LocationEntity.class); // Mocked entity saved in the repository
        Location location = mock(Location.class); // Animal object passed to the service

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(repository).saveAndFlush(any(LocationEntity.class));

        // When
        Location createdLocation = this.locationService.createLocation(location);

        // Then
        Assertions.assertThat(createdLocation).isNotNull(); // Assert that the returned animal is not null
        verify(repository).saveAndFlush(any(LocationEntity.class)); // Verify that saveAndFlush was called
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingLocation() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingLocationById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(repository).deleteById(id);
        this.locationService.deleteLocation(id);

        // then
        Assertions.assertThatCode(() -> this.locationService.deleteLocation(id)).doesNotThrowAnyException();
    }
}
