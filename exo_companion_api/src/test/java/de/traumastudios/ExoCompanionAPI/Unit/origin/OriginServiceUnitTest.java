package de.traumastudios.ExoCompanionAPI.Unit.origin;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.domain.AquaticAnimal;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.repository.AquaticAnimalEntity;
import de.traumastudios.ExoCompanionAPI.origin.domain.Origin;
import de.traumastudios.ExoCompanionAPI.origin.repository.OriginEntity;
import de.traumastudios.ExoCompanionAPI.origin.repository.OriginRepository;
import de.traumastudios.ExoCompanionAPI.origin.service.OriginService;
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
public class OriginServiceUnitTest {
    @Mock
    private OriginRepository originRepository;

    @InjectMocks
    private OriginService originService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllOrigins() {
        // given
        OriginEntity entity1 = mock(OriginEntity.class);
        OriginEntity entity2 = mock(OriginEntity.class);

        List<OriginEntity> mockOrigins = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockOrigins).when(originRepository).findAll();
        List<Origin> origins = this.originService.findAllOrigins();

        // then
        Assertions.assertThat(origins)
            .allMatch(origin -> origin instanceof Origin)
            .withFailMessage("Element in the list is not of type Origin");
    }

    @Test
    public void itShouldFindAOriginById() {
        // given
        OriginEntity entity = mock(OriginEntity.class);
        Optional<OriginEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(originRepository).findById(productID);
        Optional<Origin> origin = this.originService.findOriginById(productID);

        // then
        Assertions.assertThat(origin).isPresent();
        Assertions.assertThat(origin).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfAOriginCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(originRepository).findById(nonExistentId);

        // When
        Optional<Origin> origin = this.originService.findOriginById(nonExistentId);

        // Then
        Assertions.assertThat(origin).isEmpty();
    }

    @Test
    public void itShouldFindAOriginByName() {
        // given
        OriginEntity entity = mock(OriginEntity.class);
        Optional<OriginEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(originRepository).findByName(name);
        Optional<Origin> origin = this.originService.findOriginByName(name);

        // then
        Assertions.assertThat(origin).isPresent();
        Assertions.assertThat(origin.get()).isInstanceOf(Origin.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfAOriginCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentOrigin";
        doReturn(Optional.empty()).when(originRepository).findByName(nonExistentName);

        // When
        Optional<Origin> origin = this.originService.findOriginByName(nonExistentName);

        // Then
        Assertions.assertThat(origin).isEmpty();
    }

    @Test
    public void itShouldCreateANewOrigin() {
        // Given
        OriginEntity savedEntity = mock(OriginEntity.class);
        Origin origin = mock(Origin.class);

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(originRepository).saveAndFlush(any(OriginEntity.class));

        // When
        Origin createdOrigin = this.originService.createOrigin(origin);

        // Then
        Assertions.assertThat(createdOrigin).isNotNull();
        verify(originRepository).saveAndFlush(any(OriginEntity.class));
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingOrigin() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingOriginById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(originRepository).deleteById(id);
        this.originService.deleteOrigin(id);

        // then
        Assertions.assertThatCode(() -> this.originService.deleteOrigin(id)).doesNotThrowAnyException();
    }
}
