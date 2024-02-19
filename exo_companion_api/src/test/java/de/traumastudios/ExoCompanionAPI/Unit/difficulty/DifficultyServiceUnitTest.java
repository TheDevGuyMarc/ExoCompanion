package de.traumastudios.ExoCompanionAPI.Unit.difficulty;

import de.traumastudios.ExoCompanionAPI.difficulty.domain.Difficulty;
import de.traumastudios.ExoCompanionAPI.difficulty.repository.DifficultyEntity;
import de.traumastudios.ExoCompanionAPI.difficulty.repository.DifficultyRepository;
import de.traumastudios.ExoCompanionAPI.difficulty.service.DifficultyService;
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
public class DifficultyServiceUnitTest {
    @Mock
    private DifficultyRepository difficultyRepository;

    @InjectMocks
    private DifficultyService difficultyService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllDifficulties() {
        // given
        DifficultyEntity entity1 = mock(DifficultyEntity.class);
        DifficultyEntity entity2 = mock(DifficultyEntity.class);

        List<DifficultyEntity> difficultyEntities = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(difficultyEntities).when(difficultyRepository).findAll();
        List<Difficulty> difficulties = this.difficultyService.findAllDifficulties();

        // then
        Assertions.assertThat(difficulties)
            .allMatch(difficulty -> difficulty instanceof Difficulty)
            .withFailMessage("Element in the list is not of type Difficulty");
    }

    @Test
    public void itShouldFindADifficultyById() {
        // given
        DifficultyEntity entity = mock(DifficultyEntity.class);
        Optional<DifficultyEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(difficultyRepository).findById(productID);
        Optional<Difficulty> difficulty = this.difficultyService.findDifficultyById(productID);

        // then
        Assertions.assertThat(difficulty).isPresent();
        Assertions.assertThat(difficulty).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfADifficultyCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(difficultyRepository).findById(nonExistentId);

        // When
        Optional<Difficulty> difficulty = this.difficultyService.findDifficultyById(nonExistentId);

        // Then
        Assertions.assertThat(difficulty).isEmpty();
    }

    @Test
    public void itShouldFindADifficultyByName() {
        // given
        DifficultyEntity entity = mock(DifficultyEntity.class);
        Optional<DifficultyEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(difficultyRepository).findByName(name);
        Optional<Difficulty> difficulty = this.difficultyService.findDifficultyByName(name);

        // then
        Assertions.assertThat(difficulty).isPresent();
        Assertions.assertThat(difficulty.get()).isInstanceOf(Difficulty.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfADifficultyCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentDifficulty";
        doReturn(Optional.empty()).when(difficultyRepository).findByName(nonExistentName);

        // When
        Optional<Difficulty> difficulty = this.difficultyService.findDifficultyByName(nonExistentName);

        // Then
        Assertions.assertThat(difficulty).isEmpty();
    }

    @Test
    public void itShouldCreateANewDifficulty() {
        // Given
        DifficultyEntity savedEntity = mock(DifficultyEntity.class); // Mocked entity saved in the repository
        Difficulty difficulty = mock(Difficulty.class); // Difficulty object passed to the service

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(difficultyRepository).saveAndFlush(any(DifficultyEntity.class));

        // When
        Difficulty createdDifficulty = this.difficultyService.createDifficulty(difficulty);

        // Then
        Assertions.assertThat(createdDifficulty).isNotNull(); // Assert that the returned difficulty is not null
        verify(difficultyRepository).saveAndFlush(any(DifficultyEntity.class)); // Verify that saveAndFlush was called
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingDifficulty() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingDifficultyById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(difficultyRepository).deleteById(id);
        this.difficultyService.deleteDifficulty(id);

        // then
        Assertions.assertThatCode(() -> this.difficultyService.deleteDifficulty(id)).doesNotThrowAnyException();
    }
}
