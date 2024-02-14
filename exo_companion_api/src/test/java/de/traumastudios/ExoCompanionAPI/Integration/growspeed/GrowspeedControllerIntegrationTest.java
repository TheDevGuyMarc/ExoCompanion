package de.traumastudios.ExoCompanionAPI.Integration.growspeed;

import de.traumastudios.ExoCompanionAPI.growspeed.controller.GrowspeedController;
import de.traumastudios.ExoCompanionAPI.growspeed.service.GrowspeedService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GrowspeedController.class)
public class GrowspeedControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GrowspeedService growspeedService;

    @Test
    public void itShouldListAllGrowspeeds() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnAGrowspeedIfAnIdIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnAGrowspeedIfAnNameIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldCreateANewGrowspeed() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldUpdateAnExistingGrowspeed() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingGrowspeed() {
        // given

        // when

        // then
    }
}
