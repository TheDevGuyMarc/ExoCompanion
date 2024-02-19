package de.traumastudios.ExoCompanionAPI.Unit.planttype;

import de.traumastudios.ExoCompanionAPI.planttype.domain.PlantType;
import de.traumastudios.ExoCompanionAPI.planttype.repository.PlantTypeEntity;
import de.traumastudios.ExoCompanionAPI.planttype.repository.PlantTypeRepository;
import de.traumastudios.ExoCompanionAPI.planttype.service.PlantTypeService;
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
public class PlantTypeServiceUnitTest {
    @Mock
    private PlantTypeRepository plantTypeRepository;

    @InjectMocks
    private PlantTypeService plantTypeService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllPlantTypes() {
        // given
        PlantTypeEntity entity1 = mock(PlantTypeEntity.class);
        PlantTypeEntity entity2 = mock(PlantTypeEntity.class);

        List<PlantTypeEntity> mockPlantTypes = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockPlantTypes).when(plantTypeRepository).findAll();
        List<PlantType> plantTypes = this.plantTypeService.findAllPlantTypes();

        // then
        Assertions.assertThat(plantTypes)
            .allMatch(plantType -> plantType instanceof PlantType)
            .withFailMessage("Element in the list is not of type PlantType");
    }

    @Test
    public void itShouldFindAPlantTypeById() {
        // given
        PlantTypeEntity entity = mock(PlantTypeEntity.class);
        Optional<PlantTypeEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(plantTypeRepository).findById(productID);
        Optional<PlantType> plantType = this.plantTypeService.findPlantTypeById(productID);

        // then
        Assertions.assertThat(plantType).isPresent();
        Assertions.assertThat(plantType).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfAPlantTypeCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(plantTypeRepository).findById(nonExistentId);

        // When
        Optional<PlantType> plantType = this.plantTypeService.findPlantTypeById(nonExistentId);

        // Then
        Assertions.assertThat(plantType).isEmpty();
    }

    @Test
    public void itShouldFindAPlantTypeByName() {
        // given
        PlantTypeEntity entity = mock(PlantTypeEntity.class);
        Optional<PlantTypeEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(plantTypeRepository).findByName(name);
        Optional<PlantType> plantType = this.plantTypeService.findPlantTypeByName(name);

        // then
        Assertions.assertThat(plantType).isPresent();
        Assertions.assertThat(plantType.get()).isInstanceOf(PlantType.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfAPlantTypeCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentPlantType";
        doReturn(Optional.empty()).when(plantTypeRepository).findByName(nonExistentName);

        // When
        Optional<PlantType> plantType = this.plantTypeService.findPlantTypeByName(nonExistentName);

        // Then
        Assertions.assertThat(plantType).isEmpty();
    }

    @Test
    public void itShouldCreateANewPlantType() {
        // Given
        PlantTypeEntity savedEntity = mock(PlantTypeEntity.class);
        PlantType plantType = mock(PlantType.class);

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(plantTypeRepository).saveAndFlush(any(PlantTypeEntity.class));

        // When
        PlantType createdPlantType = this.plantTypeService.createPlantType(plantType);

        // Then
        Assertions.assertThat(createdPlantType).isNotNull();
        verify(plantTypeRepository).saveAndFlush(any(PlantTypeEntity.class));
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingPlantType() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingPlantTypeById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(plantTypeRepository).deleteById(id);
        this.plantTypeService.deletePlantType(id);

        // then
        Assertions.assertThatCode(() -> this.plantTypeService.deletePlantType(id)).doesNotThrowAnyException();
    }
}
