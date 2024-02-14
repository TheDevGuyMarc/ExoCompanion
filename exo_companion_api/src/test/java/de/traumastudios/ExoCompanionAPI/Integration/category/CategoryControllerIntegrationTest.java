package de.traumastudios.ExoCompanionAPI.Integration.category;

import de.traumastudios.ExoCompanionAPI.category.controller.CategoryController;
import de.traumastudios.ExoCompanionAPI.category.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CategoryController.class)
public class CategoryControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryService categoryService;

    @Test
    public void itShouldListAllCategories() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnACategoryIfAnIdIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnACategoryIfAnNameIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldCreateANewCategory() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldUpdateAnExistingCategory() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingCategory() {
        // given

        // when

        // then
    }
}
