package de.traumastudios.ExoCompanionAPI.Integration.culture;

import de.traumastudios.ExoCompanionAPI.culture.controller.CultureController;
import de.traumastudios.ExoCompanionAPI.culture.service.CultureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CultureController.class)
public class CultureControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CultureService cultureService;

    @Test
    public void itShouldListAllCultures() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnACultureIfAnIdIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnACultureIfAnNameIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldCreateANewCulture() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldUpdateAnExistingCulture() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingCulture() {
        // given

        // when

        // then
    }
}
