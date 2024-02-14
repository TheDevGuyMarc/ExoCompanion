package de.traumastudios.ExoCompanionAPI.Integration.difficulty;

import de.traumastudios.ExoCompanionAPI.difficulty.controller.DifficultyController;
import de.traumastudios.ExoCompanionAPI.difficulty.service.DifficultyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DifficultyController.class)
public class DifficultyControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DifficultyService difficultyService;

    @Test
    public void itShouldListAllDifficulties() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnADifficultyIfAnIdIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnADifficultyIfAnNameIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldCreateANewDifficulty() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldUpdateAnExistingDifficulty() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingDifficulty() {
        // given

        // when

        // then
    }
}
