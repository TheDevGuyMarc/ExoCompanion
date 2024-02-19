package de.traumastudios.ExoCompanionAPI.Unit.plant;

import de.traumastudios.ExoCompanionAPI.plant.domain.Plant;
import de.traumastudios.ExoCompanionAPI.plant.repository.PlantEntity;
import de.traumastudios.ExoCompanionAPI.plant.repository.PlantRepository;
import de.traumastudios.ExoCompanionAPI.plant.service.PlantService;
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
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PlantServiceUnitTest {
    @Mock
    private PlantRepository plantRepository;

    @InjectMocks
    private PlantService plantService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllPlants() {
        // given
        PlantEntity entity1 = mock(PlantEntity.class);
        PlantEntity entity2 = mock(PlantEntity.class);

        List<PlantEntity> mockPlants = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockPlants).when(plantRepository).findAll();
        List<Plant> plants = this.plantService.findAllPlants();

        // then
        Assertions.assertThat(plants)
            .allMatch(plant -> plant instanceof Plant)
            .withFailMessage("Element in the list is not of type Plant");
    }

    @Test
    public void itShouldFindAPlantById() {
        // given
        PlantEntity entity = mock(PlantEntity.class);
        Optional<PlantEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(plantRepository).findById(productID);
        Optional<Plant> plant = this.plantService.findPlantById(productID);

        // then
        Assertions.assertThat(plant).isPresent();
        Assertions.assertThat(plant).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfAPlantCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(plantRepository).findById(nonExistentId);

        // When
        Optional<Plant> plant = this.plantService.findPlantById(nonExistentId);

        // Then
        Assertions.assertThat(plant).isEmpty();
    }

    @Test
    public void itShouldFindAPlantByName() {
        // given
        PlantEntity entity = mock(PlantEntity.class);
        Optional<PlantEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(plantRepository).findByName(name);
        Optional<Plant> plant = this.plantService.findPlantByName(name);

        // then
        Assertions.assertThat(plant).isPresent();
        Assertions.assertThat(plant.get()).isInstanceOf(Plant.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfAPlantCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentPlant";
        doReturn(Optional.empty()).when(plantRepository).findByName(nonExistentName);

        // When
        Optional<Plant> plant = this.plantService.findPlantByName(nonExistentName);

        // Then
        Assertions.assertThat(plant).isEmpty();
    }

    @Test
    public void itShouldCreateANewPlant() {
        // Given
        PlantEntity savedEntity = mock(PlantEntity.class);
        Plant plant = mock(Plant.class);

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(plantRepository).saveAndFlush(any(PlantEntity.class));

        // When
        Plant createdPlant = this.plantService.createPlant(plant);

        // Then
        Assertions.assertThat(createdPlant).isNotNull();
        verify(plantRepository).saveAndFlush(any(PlantEntity.class));
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingPlant() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingPlantById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(plantRepository).deleteById(id);
        this.plantService.deletePlant(id);

        // then
        Assertions.assertThatCode(() -> this.plantService.deletePlant(id)).doesNotThrowAnyException();
    }
}
