package de.traumastudios.ExoCompanionAPI.Integration.planttype;

import de.traumastudios.ExoCompanionAPI.planttype.repository.PlantTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PlantTypeRepositoryIntegrationTest {
    @Autowired
    private PlantTypeRepository plantTypeRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldFindAPlantTypeById() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldFindAPlantTypeByName() {
        // given

        // when

        // then
    }
}
