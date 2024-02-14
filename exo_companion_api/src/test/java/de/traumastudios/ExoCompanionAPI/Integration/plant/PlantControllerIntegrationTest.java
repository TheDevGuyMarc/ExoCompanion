package de.traumastudios.ExoCompanionAPI.Integration.plant;

import de.traumastudios.ExoCompanionAPI.plant.controller.PlantController;
import de.traumastudios.ExoCompanionAPI.plant.service.PlantService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PlantController.class)
public class PlantControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlantService plantService;

    @Test
    public void itShouldListAllPlants() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnAPlantIfAnIdIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnAPlantIfAnNameIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldCreateANewPlant() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldUpdateAnExistingPlant() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingPlant() {
        // given

        // when

        // then
    }
}
