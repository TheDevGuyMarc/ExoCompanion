package de.traumastudios.ExoCompanionAPI.Unit.behavior;

import de.traumastudios.ExoCompanionAPI.behavior.domain.Behavior;
import de.traumastudios.ExoCompanionAPI.behavior.repository.BehaviorEntity;
import de.traumastudios.ExoCompanionAPI.behavior.repository.BehaviorRepository;
import de.traumastudios.ExoCompanionAPI.behavior.service.BehaviorService;
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
public class BehaviorServiceUnitTest {
    @Mock
    private BehaviorRepository behaviorRepository;

    @InjectMocks
    private BehaviorService behaviorService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllBehaviors() {
        // given
        BehaviorEntity entity1 = mock(BehaviorEntity.class);
        BehaviorEntity entity2 = mock(BehaviorEntity.class);

        List<BehaviorEntity> mockBehaviors = List.of(
          entity1,
          entity2
        );

        // when
        doReturn(mockBehaviors).when(behaviorRepository).findAll();
        List<Behavior> behaviors = this.behaviorService.findAllBehaviors();

        // then
        Assertions.assertThat(behaviors)
            .allMatch(behavior -> behavior instanceof Behavior)
            .withFailMessage("Element in the list is not of type Behavior");
    }

    @Test
    public void itShouldFindABehaviorById() {
        // given
        BehaviorEntity entity = mock(BehaviorEntity.class);
        Optional<BehaviorEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(behaviorRepository).findById(productID);
        Optional<Behavior> behavior = this.behaviorService.findBehaviorById(productID);

        // then
        Assertions.assertThat(behavior).isPresent();
        Assertions.assertThat(behavior).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfABehaviorCouldNotBeFoundById() {
        // given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(behaviorRepository).findById(nonExistentId);

        // when
        Optional<Behavior> behavior = this.behaviorService.findBehaviorById(nonExistentId);

        // then
        Assertions.assertThat(behavior).isEmpty();
    }

    @Test
    public void itShouldFindABehaviorByName() {
        // given
        BehaviorEntity entity = mock(BehaviorEntity.class);
        Optional<BehaviorEntity> testObject = Optional.of(entity);
        String name = "guarding";

        // when
        doReturn(testObject).when(behaviorRepository).findByName(name);
        Optional<Behavior> behavior = this.behaviorService.findBehaviorByName(name);

        // then
        Assertions.assertThat(behavior).isPresent();
        Assertions.assertThat(behavior.get()).isInstanceOf(Behavior.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfABehaviorCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentBehavior";
        doReturn(Optional.empty()).when(behaviorRepository).findByName(nonExistentName);

        // When
        Optional<Behavior> behavior = this.behaviorService.findBehaviorByName(nonExistentName);

        // Then
        Assertions.assertThat(behavior).isEmpty();
    }

    @Test
    public void itShouldCreateANewBehavior() {
        // Given
        BehaviorEntity savedEntity = mock(BehaviorEntity.class);
        Behavior behavior = mock(Behavior.class);

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(behaviorRepository).saveAndFlush(any(BehaviorEntity.class));

        // When
        Behavior createdBehavior = this.behaviorService.createBehavior(behavior);

        // Then
        Assertions.assertThat(createdBehavior).isNotNull();
        verify(behaviorRepository).saveAndFlush(any(BehaviorEntity.class));
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingBehavior() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingBehaviorById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(behaviorRepository).deleteById(id);
        this.behaviorService.deleteBehavior(id);

        // then
        Assertions.assertThatCode(() -> this.behaviorService.deleteBehavior(id)).doesNotThrowAnyException();
    }
}
