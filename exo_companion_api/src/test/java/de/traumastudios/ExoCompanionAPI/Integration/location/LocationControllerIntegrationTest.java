package de.traumastudios.ExoCompanionAPI.Integration.location;

import de.traumastudios.ExoCompanionAPI.location.controller.LocationController;
import de.traumastudios.ExoCompanionAPI.location.service.LocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(LocationController.class)
public class LocationControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private LocationService locationService;

    @Test
    public void itShouldListAllLocations() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnALocationIfAnIdIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldReturnALocationIfAnNameIsGiven() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldCreateANewLocation() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldUpdateAnExistingLocation() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingLocation() {
        // given

        // when

        // then
    }
}
