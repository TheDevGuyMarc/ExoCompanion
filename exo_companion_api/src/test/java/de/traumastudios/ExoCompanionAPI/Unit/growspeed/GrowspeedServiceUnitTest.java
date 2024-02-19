package de.traumastudios.ExoCompanionAPI.Unit.growspeed;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.domain.AquaticAnimal;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.repository.AquaticAnimalEntity;
import de.traumastudios.ExoCompanionAPI.growspeed.domain.Growspeed;
import de.traumastudios.ExoCompanionAPI.growspeed.repository.GrowspeedEntity;
import de.traumastudios.ExoCompanionAPI.growspeed.repository.GrowspeedRepository;
import de.traumastudios.ExoCompanionAPI.growspeed.service.GrowspeedService;
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
public class GrowspeedServiceUnitTest {
    @Mock
    private GrowspeedRepository growspeedRepository;

    @InjectMocks
    private GrowspeedService growspeedService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllGrowspeeds() {
        // given
        GrowspeedEntity entity1 = mock(GrowspeedEntity.class);
        GrowspeedEntity entity2 = mock(GrowspeedEntity.class);

        List<GrowspeedEntity> mockGrowspeeds = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockGrowspeeds).when(growspeedRepository).findAll();
        List<Growspeed> growspeeds = this.growspeedService.findAllGrowspeeds();

        // then
        Assertions.assertThat(growspeeds)
            .allMatch(growspeed -> growspeed instanceof Growspeed)
            .withFailMessage("Element in the list is not of type Growspeed");
    }

    @Test
    public void itShouldFindAGrowspeedById() {
        // given
        GrowspeedEntity entity = mock(GrowspeedEntity.class);
        Optional<GrowspeedEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(growspeedRepository).findById(productID);
        Optional<Growspeed> growspeed = this.growspeedService.findGrowspeedById(productID);

        // then
        Assertions.assertThat(growspeed).isPresent();
        Assertions.assertThat(growspeed).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfAGrowspeedCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(growspeedRepository).findById(nonExistentId);

        // When
        Optional<Growspeed> growspeed = this.growspeedService.findGrowspeedById(nonExistentId);

        // Then
        Assertions.assertThat(growspeed).isEmpty();
    }

    @Test
    public void itShouldFindAGrowspeedByName() {
        // given
        GrowspeedEntity entity = mock(GrowspeedEntity.class);
        Optional<GrowspeedEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(growspeedRepository).findByName(name);
        Optional<Growspeed> growspeed = this.growspeedService.findGrowspeedByName(name);

        // then
        Assertions.assertThat(growspeed).isPresent();
        Assertions.assertThat(growspeed.get()).isInstanceOf(Growspeed.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfAGrowspeedCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonexistentfish";
        doReturn(Optional.empty()).when(growspeedRepository).findByName(nonExistentName);

        // When
        Optional<Growspeed> growspeed = this.growspeedService.findGrowspeedByName(nonExistentName);

        // Then
        Assertions.assertThat(growspeed).isEmpty();
    }

    @Test
    public void itShouldCreateANewGrowspeed() {
        // Given
        GrowspeedEntity savedEntity = mock(GrowspeedEntity.class); // Mocked entity saved in the repository
        Growspeed growspeed = mock(Growspeed.class); // Animal object passed to the service

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(growspeedRepository).saveAndFlush(any(GrowspeedEntity.class));

        // When
        Growspeed createdAnimal = this.growspeedService.createGrowspeed(growspeed);

        // Then
        Assertions.assertThat(createdAnimal).isNotNull(); // Assert that the returned animal is not null
        verify(growspeedRepository).saveAndFlush(any(GrowspeedEntity.class)); // Verify that saveAndFlush was called
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingGrowspeed() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingGrowspeedById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(growspeedRepository).deleteById(id);
        this.growspeedService.deleteGrowspeed(id);

        // then
        Assertions.assertThatCode(() -> this.growspeedService.deleteGrowspeed(id)).doesNotThrowAnyException();
    }
}
