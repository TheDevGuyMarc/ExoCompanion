package de.traumastudios.ExoCompanionAPI.Integration.origin;

import de.traumastudios.ExoCompanionAPI.origin.controller.OriginController;
import de.traumastudios.ExoCompanionAPI.origin.service.OriginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(OriginController.class)
public class OriginControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OriginService originService;

    @Test
    public void itShouldListAllOrigins() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnAOriginIfAnIdIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnAOriginIfAnNameIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldCreateANewOrigin() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldUpdateAnExistingOrigin() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingOrigin() {
        // given

        // when

        // then
    }
}
