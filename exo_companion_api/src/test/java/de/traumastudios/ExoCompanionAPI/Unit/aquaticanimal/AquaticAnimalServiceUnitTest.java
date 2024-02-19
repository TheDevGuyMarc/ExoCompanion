package de.traumastudios.ExoCompanionAPI.Unit.aquaticanimal;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.domain.AquaticAnimal;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.repository.AquaticAnimalEntity;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.repository.AquaticAnimalRepository;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.service.AquaticAnimalService;
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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AquaticAnimalServiceUnitTest {
    @Mock
    private AquaticAnimalRepository aquaticAnimalRepository;

    @InjectMocks
    private AquaticAnimalService aquaticAnimalService;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void itShouldListAllAquaticAnimals() {
        // given
        AquaticAnimalEntity entity1 = mock(AquaticAnimalEntity.class);
        AquaticAnimalEntity entity2 = mock(AquaticAnimalEntity.class);

        List<AquaticAnimalEntity> mockAnimals = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockAnimals).when(aquaticAnimalRepository).findAll();
        List<AquaticAnimal> animals = this.aquaticAnimalService.findAllAquaticAnimals();

        // then
        Assertions.assertThat(animals)
            .allMatch(animal -> animal instanceof AquaticAnimal)
            .withFailMessage("Element in the list is not of type AquaticAnimal");
    }

    @Test
    public void itShouldFindAAquaticAnimalById() {
        // given
        AquaticAnimalEntity entity = mock(AquaticAnimalEntity.class);
        Optional<AquaticAnimalEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(aquaticAnimalRepository).findById(productID);
        Optional<AquaticAnimal> animal = this.aquaticAnimalService.findAquaticAnimalById(productID);

        // then
        Assertions.assertThat(animal).isPresent();
        Assertions.assertThat(animal).isNotNull();
    }

    @Test
    void itShouldReturnEmptyOptionalIfAquaticAnimalCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(aquaticAnimalRepository).findById(nonExistentId);

        // When
        Optional<AquaticAnimal> animal = this.aquaticAnimalService.findAquaticAnimalById(nonExistentId);

        // Then
        Assertions.assertThat(animal).isEmpty();
    }

    @Test
    public void itShouldFindAAquaticAnimalByName() {
        // given
        AquaticAnimalEntity entity = mock(AquaticAnimalEntity.class);
        Optional<AquaticAnimalEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(aquaticAnimalRepository).findByName(name);
        Optional<AquaticAnimal> animal = this.aquaticAnimalService.findAquaticAnimalByName(name);

        // then
        Assertions.assertThat(animal).isPresent();
        Assertions.assertThat(animal.get()).isInstanceOf(AquaticAnimal.class);
    }

    @Test
    public void itShouldReturnEmptyOptionalIfAquaticAnimalCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentFish";
        doReturn(Optional.empty()).when(aquaticAnimalRepository).findByName(nonExistentName);

        // When
        Optional<AquaticAnimal> animal = this.aquaticAnimalService.findAquaticAnimalByName(nonExistentName);

        // Then
        Assertions.assertThat(animal).isEmpty();
    }

    @Test
    public void itShouldCreateANewAquaticAnimal() {
        // Given
        AquaticAnimalEntity savedEntity = mock(AquaticAnimalEntity.class);
        AquaticAnimal animal = mock(AquaticAnimal.class);

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(aquaticAnimalRepository).saveAndFlush(any(AquaticAnimalEntity.class));

        // When
        AquaticAnimal createdAnimal = this.aquaticAnimalService.createAquaticAnimal(animal);

        // Then
        Assertions.assertThat(createdAnimal).isNotNull();
        verify(aquaticAnimalRepository).saveAndFlush(any(AquaticAnimalEntity.class));
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingAquaticAnimal() {
        // Given
        Long id = 1L;
        AquaticAnimal existingAnimal = mock(AquaticAnimal.class);
        Optional<AquaticAnimalEntity> existingEntity = Optional.of(new AquaticAnimalEntity(existingAnimal));
        AquaticAnimal updatedAnimal = mock(AquaticAnimal.class);
        when(aquaticAnimalRepository.findById(id)).thenReturn(existingEntity);
        when(aquaticAnimalRepository.saveAndFlush(any())).thenReturn(new AquaticAnimalEntity(updatedAnimal));

        // When
        AquaticAnimal result = this.aquaticAnimalService.updateAquaticAnimal(id, updatedAnimal);

        // Then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getId()).isEqualTo(updatedAnimal.getId());
    }

    @Test
    public void itShouldDeleteAnExistingAquaticAnimalById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(aquaticAnimalRepository).deleteById(id);
        this.aquaticAnimalService.deleteAquaticAnimal(id);

        // then
        Assertions.assertThatCode(() -> this.aquaticAnimalService.deleteAquaticAnimal(id)).doesNotThrowAnyException();
    }
}
