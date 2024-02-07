package de.traumastudios.ExoCompanionAPI.Unit.category;

import de.traumastudios.ExoCompanionAPI.category.repository.CategoryEntity;
import de.traumastudios.ExoCompanionAPI.category.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryRepositoryTest {
    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        // Mock data setup
        CategoryEntity category = new CategoryEntity();
        category.setId(1L);
        category.setName("TestCategory");
        category.setDescription("Test Description");

        // Mocking findById method
        lenient().when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        // Mocking findByName method
        lenient().when(categoryRepository.findByName("TestCategory")).thenReturn(Optional.of(category));
    }

    @Test
    public void itShouldFindACategoryById() {
        // given
        Long id = 1L;

        // when
        Optional<CategoryEntity> categoryOptional = categoryRepository.findById(id);

        // then
        assertTrue(categoryOptional.isPresent());
        assertEquals("TestCategory", categoryOptional.get().getName());
    }

    @Test
    public void itShouldFindACategoryByName() {
        // given
        String name = "TestCategory";

        // when
        Optional<CategoryEntity> categoryOptional = categoryRepository.findByName(name);

        // then
        assertTrue(categoryOptional.isPresent());
        assertEquals(1L, categoryOptional.get().getId());
    }
}
