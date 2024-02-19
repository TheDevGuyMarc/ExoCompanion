package de.traumastudios.ExoCompanionAPI.Unit.coloration;

import de.traumastudios.ExoCompanionAPI.coloration.domain.Coloration;
import de.traumastudios.ExoCompanionAPI.coloration.repository.ColorationEntity;
import de.traumastudios.ExoCompanionAPI.coloration.repository.ColorationRepository;
import de.traumastudios.ExoCompanionAPI.coloration.service.ColorationService;
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

@ExtendWith(MockitoExtension.class)
public class ColorationServiceUnitTest {
    @Mock
    private ColorationRepository colorationRepository;

    @InjectMocks
    private ColorationService colorationService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllColorations() {
        // given
        ColorationEntity entity1 = mock(ColorationEntity.class);
        ColorationEntity entity2 = mock(ColorationEntity.class);

        List<ColorationEntity> mockColorations = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockColorations).when(colorationRepository).findAll();
        List<Coloration> colorations = this.colorationService.findAllColorations();

        // then
        Assertions.assertThat(colorations)
            .allMatch(coloration -> coloration instanceof Coloration)
            .withFailMessage("Element in the list is not of type Coloration");
    }

    @Test
    public void itShouldFindAColorationById() {
        // given
        ColorationEntity entity = mock(ColorationEntity.class);
        Optional<ColorationEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(colorationRepository).findById(productID);
        Optional<Coloration> coloration = this.colorationService.findColorationById(productID);

        // then
        Assertions.assertThat(coloration).isPresent();
        Assertions.assertThat(coloration).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfAColorationCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(colorationRepository).findById(nonExistentId);

        // When
        Optional<Coloration> coloration = this.colorationService.findColorationById(nonExistentId);

        // Then
        Assertions.assertThat(coloration).isEmpty();
    }

    @Test
    public void itShouldFindAColorationByName() {
        // given
        ColorationEntity entity = mock(ColorationEntity.class);
        Optional<ColorationEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(colorationRepository).findByName(name);
        Optional<Coloration> coloration = this.colorationService.findColorationByName(name);

        // then
        Assertions.assertThat(coloration).isPresent();
        Assertions.assertThat(coloration.get()).isInstanceOf(Coloration.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfAColorationCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentColoration";
        doReturn(Optional.empty()).when(colorationRepository).findByName(nonExistentName);

        // When
        Optional<Coloration> coloration = this.colorationService.findColorationByName(nonExistentName);

        // Then
        Assertions.assertThat(coloration).isEmpty();
    }

    @Test
    public void itShouldCreateANewColoration() {
        // Given
        ColorationEntity savedEntity = mock(ColorationEntity.class); // Mocked entity saved in the repository
        Coloration coloration = mock(Coloration.class); // Coloration object passed to the service

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(colorationRepository).saveAndFlush(any(ColorationEntity.class));

        // When
        Coloration createdColoration = this.colorationService.createColoration(coloration);

        // Then
        Assertions.assertThat(createdColoration).isNotNull(); // Assert that the returned coloration is not null
        verify(colorationRepository).saveAndFlush(any(ColorationEntity.class)); // Verify that saveAndFlush was called
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingColoration() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingColorationById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(colorationRepository).deleteById(id);
        this.colorationService.deleteColoration(id);

        // then
        Assertions.assertThatCode(() -> this.colorationService.deleteColoration(id)).doesNotThrowAnyException();
    }
}
