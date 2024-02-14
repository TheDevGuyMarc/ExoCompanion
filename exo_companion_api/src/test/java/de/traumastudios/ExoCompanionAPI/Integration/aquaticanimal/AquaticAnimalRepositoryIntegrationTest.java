package de.traumastudios.ExoCompanionAPI.Integration.aquaticanimal;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.repository.AquaticAnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AquaticAnimalRepositoryIntegrationTest {
    @Autowired
    private AquaticAnimalRepository aquaticAnimalRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldFindACategoryById() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldFindACategoryByName() {
        // given

        // when

        // then
    }
}
