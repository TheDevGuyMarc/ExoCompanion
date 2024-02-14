package de.traumastudios.ExoCompanionAPI.Integration.rarity;

import de.traumastudios.ExoCompanionAPI.rarity.controller.RarityController;
import de.traumastudios.ExoCompanionAPI.rarity.service.RarityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RarityController.class)
public class RarityControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RarityService rarityService;

    @Test
    public void itShouldListAllRarities() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnARarityIfAnIdIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnARarityIfAnNameIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldCreateANewRarity() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldUpdateAnExistingRarity() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingRarity() {
        // given

        // when

        // then
    }
}
