package de.traumastudios.ExoCompanionAPI.Integration.coloration;

import de.traumastudios.ExoCompanionAPI.coloration.controller.ColorationController;
import de.traumastudios.ExoCompanionAPI.coloration.service.ColorationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ColorationController.class)
public class ColorationControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ColorationService colorationService;

    @Test
    public void itShouldListAllColorations() {
        // given

        // when

        // then
    }
    
    @Test
    public void itShouldReturnAColorationIfAnIdIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnAColorationIfAnNameIsGiven() {
        // given

        // when

        // then
    }
    
    @Test
    public void itShouldCreateANewColoration() {
        // given

        // when

        // then
    }
    
    @Test
    public void itShouldUpdateAnExistingColoration() {
        // given

        // when

        // then
    }
    
    @Test
    public void itShouldDeleteAnExistingColoration() {
        // given

        // when

        // then
    }
}
