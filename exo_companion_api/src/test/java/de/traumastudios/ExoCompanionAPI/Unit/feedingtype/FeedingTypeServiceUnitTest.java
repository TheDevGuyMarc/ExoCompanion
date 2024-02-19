package de.traumastudios.ExoCompanionAPI.Unit.feedingtype;

import de.traumastudios.ExoCompanionAPI.feedingtype.domain.FeedingType;
import de.traumastudios.ExoCompanionAPI.feedingtype.repository.FeedingTypeEntity;
import de.traumastudios.ExoCompanionAPI.feedingtype.repository.FeedingTypeRepository;
import de.traumastudios.ExoCompanionAPI.feedingtype.service.FeedingTypeService;
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
public class FeedingTypeServiceUnitTest {
    @Mock
    private FeedingTypeRepository feedingTypeRepository;

    @InjectMocks
    private FeedingTypeService feedingTypeService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllFeedingTypes() {
        // given
        FeedingTypeEntity entity1 = mock(FeedingTypeEntity.class);
        FeedingTypeEntity entity2 = mock(FeedingTypeEntity.class);

        List<FeedingTypeEntity> mockFeedingType = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockFeedingType).when(feedingTypeRepository).findAll();
        List<FeedingType> feedingTypes = this.feedingTypeService.findAllFeedingTypes();

        // then
        Assertions.assertThat(feedingTypes)
            .allMatch(feedingType -> feedingType instanceof FeedingType)
            .withFailMessage("Element in the list is not of type FeedingType");
    }

    @Test
    public void itShouldFindAFeedingTypeById() {
        // given
        FeedingTypeEntity entity = mock(FeedingTypeEntity.class);
        Optional<FeedingTypeEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(feedingTypeRepository).findById(productID);
        Optional<FeedingType> feedingType = this.feedingTypeService.findFeedingTypeById(productID);

        // then
        Assertions.assertThat(feedingType).isPresent();
        Assertions.assertThat(feedingType).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfAFeedingTypeCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(feedingTypeRepository).findById(nonExistentId);

        // When
        Optional<FeedingType> feedingType = this.feedingTypeService.findFeedingTypeById(nonExistentId);

        // Then
        Assertions.assertThat(feedingType).isEmpty();
    }

    @Test
    public void itShouldFindAFeedingTypeByName() {
        // given
        FeedingTypeEntity entity = mock(FeedingTypeEntity.class);
        Optional<FeedingTypeEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(feedingTypeRepository).findByName(name);
        Optional<FeedingType> feedingType = this.feedingTypeService.findFeedingTypeByName(name);

        // then
        Assertions.assertThat(feedingType).isPresent();
        Assertions.assertThat(feedingType.get()).isInstanceOf(FeedingType.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfAFeedingTypeCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentFeedingType";
        doReturn(Optional.empty()).when(feedingTypeRepository).findByName(nonExistentName);

        // When
        Optional<FeedingType> feedingType = this.feedingTypeService.findFeedingTypeByName(nonExistentName);

        // Then
        Assertions.assertThat(feedingType).isEmpty();
    }

    @Test
    public void itShouldCreateANewFeedingType() {
        // Given
        FeedingTypeEntity savedEntity = mock(FeedingTypeEntity.class); // Mocked entity saved in the repository
        FeedingType animal = mock(FeedingType.class); // FeedingType object passed to the service

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(feedingTypeRepository).saveAndFlush(any(FeedingTypeEntity.class));

        // When
        FeedingType createdFeedingType = this.feedingTypeService.createFeedingType(animal);

        // Then
        Assertions.assertThat(createdFeedingType).isNotNull(); // Assert that the returned feeding type is not null
        verify(feedingTypeRepository).saveAndFlush(any(FeedingTypeEntity.class)); // Verify that saveAndFlush was called
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingFeedingType() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingFeedingTypeById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(feedingTypeRepository).deleteById(id);
        this.feedingTypeService.deleteFeedingType(id);

        // then
        Assertions.assertThatCode(() -> this.feedingTypeService.deleteFeedingType(id)).doesNotThrowAnyException();
    }
}
