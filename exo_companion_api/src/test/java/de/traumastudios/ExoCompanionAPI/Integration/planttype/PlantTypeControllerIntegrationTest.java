package de.traumastudios.ExoCompanionAPI.Integration.planttype;

import de.traumastudios.ExoCompanionAPI.planttype.controller.PlantTypeController;
import de.traumastudios.ExoCompanionAPI.planttype.service.PlantTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PlantTypeController.class)
public class PlantTypeControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlantTypeService plantTypeService;

    @Test
    public void itShouldListAllPlantTypes() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnAPlantTypeIfAnIdIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnAPlantTypeIfAnNameIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldCreateANewPlantType() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldUpdateAnExistingPlantType() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingPlantType() {
        // given

        // when

        // then
    }
}
