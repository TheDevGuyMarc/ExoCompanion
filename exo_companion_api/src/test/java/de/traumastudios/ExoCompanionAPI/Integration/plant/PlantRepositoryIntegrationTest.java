package de.traumastudios.ExoCompanionAPI.Integration.plant;

import de.traumastudios.ExoCompanionAPI.plant.repository.PlantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PlantRepositoryIntegrationTest {
    @Autowired
    private PlantRepository plantRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldFindAPlantById() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldFindAPlantByName() {
        // given

        // when

        // then
    }
}
