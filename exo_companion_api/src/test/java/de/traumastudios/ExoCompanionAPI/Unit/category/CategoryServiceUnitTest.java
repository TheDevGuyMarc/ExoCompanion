package de.traumastudios.ExoCompanionAPI.Unit.category;

import de.traumastudios.ExoCompanionAPI.category.domain.Category;
import de.traumastudios.ExoCompanionAPI.category.repository.CategoryEntity;
import de.traumastudios.ExoCompanionAPI.category.repository.CategoryRepository;
import de.traumastudios.ExoCompanionAPI.category.service.CategoryService;
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
public class CategoryServiceUnitTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllCategories() {
        // given
        CategoryEntity entity1 = mock(CategoryEntity.class);
        CategoryEntity entity2 = mock(CategoryEntity.class);

        List<CategoryEntity> mockCategory = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockCategory).when(categoryRepository).findAll();
        List<Category> categories = this.categoryService.findAllCategories();

        // then
        Assertions.assertThat(categories)
            .allMatch(category -> category instanceof Category)
            .withFailMessage("Element in list is not of type Category");
    }

    @Test
    public void itShouldFindACategoryById() {
        // given
        CategoryEntity entity = mock(CategoryEntity.class);
        Optional<CategoryEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(categoryRepository).findById(productID);
        Optional<Category> category = this.categoryService.findCategoryById(productID);

        // then
        Assertions.assertThat(category).isPresent();
        Assertions.assertThat(category).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfACategoryCouldNotBeFoundById() {
        // given
        Long nonExistentId = 2L;

        // when
        doReturn(Optional.empty()).when(categoryRepository).findById(nonExistentId);
        Optional<Category> category = this.categoryService.findCategoryById(nonExistentId);

        // then
        Assertions.assertThat(category).isEmpty();
    }

    @Test
    public void itShouldFindACategoryByName() {
        // given
        CategoryEntity entity = mock(CategoryEntity.class);
        Optional<CategoryEntity> testObject = Optional.of(entity);
        String name = "category";

        // when
        doReturn(testObject).when(categoryRepository).findByName(name);
        Optional<Category> category = this.categoryService.findCategoryByName(name);

        // then
        Assertions.assertThat(category).isPresent();
        Assertions.assertThat(category.get()).isInstanceOf(Category.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfACategoryCouldNotBeFoundByName() {
        // given
        String nonExistentName = "noExistentCategory";

        // when
        doReturn(Optional.empty()).when(categoryRepository).findByName(nonExistentName);
        Optional<Category> category = this.categoryService.findCategoryByName(nonExistentName);

        // then
        Assertions.assertThat(category).isEmpty();
    }

    @Test
    public void itShouldCreateANewCategory() {
        // Given
        CategoryEntity savedEntity = mock(CategoryEntity.class);
        Category category = mock(Category.class);

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(categoryRepository).saveAndFlush(any(CategoryEntity.class));

        // When
        Category createdCategory = this.categoryService.createCategory(category);

        // Then
        Assertions.assertThat(createdCategory).isNotNull();
        verify(categoryRepository).saveAndFlush(any(CategoryEntity.class));
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingCategory() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingCategoryById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(categoryRepository).deleteById(id);
        this.categoryService.deleteCategory(id);

        // then
        Assertions.assertThatCode(() -> this.categoryService.deleteCategory(id)).doesNotThrowAnyException();
    }
}
