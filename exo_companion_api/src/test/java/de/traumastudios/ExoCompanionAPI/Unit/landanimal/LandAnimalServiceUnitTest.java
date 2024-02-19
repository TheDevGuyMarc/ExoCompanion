package de.traumastudios.ExoCompanionAPI.Unit.landanimal;

import de.traumastudios.ExoCompanionAPI.landanimal.domain.LandAnimal;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalEntity;
import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalRepository;
import de.traumastudios.ExoCompanionAPI.landanimal.service.LandAnimalService;
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
public class LandAnimalServiceUnitTest {
    @Mock
    private LandAnimalRepository landAnimalRepository;

    @InjectMocks
    private LandAnimalService landAnimalService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllLandAnimals() {
        // given
        LandAnimalEntity entity1 = mock(LandAnimalEntity.class);
        LandAnimalEntity entity2 = mock(LandAnimalEntity.class);

        List<LandAnimalEntity> mockAnimals = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockAnimals).when(landAnimalRepository).findAll();
        List<LandAnimal> animals = this.landAnimalService.findAllLandAnimals();

        // then
        Assertions.assertThat(animals)
            .allMatch(animal -> animal instanceof LandAnimal)
            .withFailMessage("Element in the list is not of type LandAnimal");
    }

    @Test
    public void itShouldFindALandAnimalById() {
        // given
        LandAnimalEntity entity = mock(LandAnimalEntity.class);
        Optional<LandAnimalEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(landAnimalRepository).findById(productID);
        Optional<LandAnimal> animal = this.landAnimalService.findLandAnimalById(productID);

        // then
        Assertions.assertThat(animal).isPresent();
        Assertions.assertThat(animal).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfALandAnimalCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(landAnimalRepository).findById(nonExistentId);

        // When
        Optional<LandAnimal> animal = this.landAnimalService.findLandAnimalById(nonExistentId);

        // Then
        Assertions.assertThat(animal).isEmpty();
    }

    @Test
    public void itShouldFindALandAnimalByName() {
        // given
        LandAnimalEntity entity = mock(LandAnimalEntity.class);
        Optional<LandAnimalEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(landAnimalRepository).findByName(name);
        Optional<LandAnimal> animal = this.landAnimalService.findLandAnimalByName(name);

        // then
        Assertions.assertThat(animal).isPresent();
        Assertions.assertThat(animal.get()).isInstanceOf(LandAnimal.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfALandAnimalCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentLandAnimal";
        doReturn(Optional.empty()).when(landAnimalRepository).findByName(nonExistentName);

        // When
        Optional<LandAnimal> animal = this.landAnimalService.findLandAnimalByName(nonExistentName);

        // Then
        Assertions.assertThat(animal).isEmpty();
    }

    @Test
    public void itShouldCreateANewLandAnimal() {
        // Given
        LandAnimalEntity savedEntity = mock(LandAnimalEntity.class);
        LandAnimal animal = mock(LandAnimal.class);

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(landAnimalRepository).saveAndFlush(any(LandAnimalEntity.class));

        // When
        LandAnimal createdAnimal = this.landAnimalService.createLandAnimal(animal);

        // Then
        Assertions.assertThat(createdAnimal).isNotNull();
        verify(landAnimalRepository).saveAndFlush(any(LandAnimalEntity.class));
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingLandAnimal() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingLandAnimalById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(landAnimalRepository).deleteById(id);
        this.landAnimalService.deleteLandAnimal(id);

        // then
        Assertions.assertThatCode(() -> this.landAnimalService.deleteLandAnimal(id)).doesNotThrowAnyException();
    }
}
