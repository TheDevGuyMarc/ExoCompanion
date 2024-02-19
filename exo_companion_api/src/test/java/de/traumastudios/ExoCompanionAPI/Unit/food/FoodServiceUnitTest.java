package de.traumastudios.ExoCompanionAPI.Unit.food;

import de.traumastudios.ExoCompanionAPI.food.domain.Food;
import de.traumastudios.ExoCompanionAPI.food.repository.FoodEntity;
import de.traumastudios.ExoCompanionAPI.food.repository.FoodRepository;
import de.traumastudios.ExoCompanionAPI.food.service.FoodService;
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
public class FoodServiceUnitTest {
    @Mock
    private FoodRepository foodRepository;

    @InjectMocks
    private FoodService foodService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllFoods() {
        // given
        FoodEntity entity1 = mock(FoodEntity.class);
        FoodEntity entity2 = mock(FoodEntity.class);

        List<FoodEntity> mockFood = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockFood).when(foodRepository).findAll();
        List<Food> foods = this.foodService.findAllFoods();

        // then
        Assertions.assertThat(foods)
            .allMatch(food -> food instanceof Food)
            .withFailMessage("Element in the list is not of type Food");
    }

    @Test
    public void itShouldFindAFoodById() {
        // given
        FoodEntity entity = mock(FoodEntity.class);
        Optional<FoodEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(foodRepository).findById(productID);
        Optional<Food> food = this.foodService.findFoodById(productID);

        // then
        Assertions.assertThat(food).isPresent();
        Assertions.assertThat(food).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfAFoodCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(foodRepository).findById(nonExistentId);

        // When
        Optional<Food> food = this.foodService.findFoodById(nonExistentId);

        // Then
        Assertions.assertThat(food).isEmpty();
    }

    @Test
    public void itShouldFindAFoodByName() {
        // given
        FoodEntity entity = mock(FoodEntity.class);
        Optional<FoodEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(foodRepository).findByName(name);
        Optional<Food> food = this.foodService.findFoodByName(name);

        // then
        Assertions.assertThat(food).isPresent();
        Assertions.assertThat(food.get()).isInstanceOf(Food.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfAFoodCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentFood";
        doReturn(Optional.empty()).when(foodRepository).findByName(nonExistentName);

        // When
        Optional<Food> food = this.foodService.findFoodByName(nonExistentName);

        // Then
        Assertions.assertThat(food).isEmpty();
    }

    @Test
    public void itShouldCreateANewFood() {
        // Given
        FoodEntity savedEntity = mock(FoodEntity.class);
        Food food = mock(Food.class);

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(foodRepository).saveAndFlush(any(FoodEntity.class));

        // When
        Food createdFood = this.foodService.createFood(food);

        // Then
        Assertions.assertThat(createdFood).isNotNull();
        verify(foodRepository).saveAndFlush(any(FoodEntity.class));
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingFood() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingFoodById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(foodRepository).deleteById(id);
        this.foodService.deleteFood(id);

        // then
        Assertions.assertThatCode(() -> this.foodService.deleteFood(id)).doesNotThrowAnyException();
    }
}
