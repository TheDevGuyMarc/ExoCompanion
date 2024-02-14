package de.traumastudios.ExoCompanionAPI.Integration.landanimal;

import de.traumastudios.ExoCompanionAPI.landanimal.repository.LandAnimalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class LandAnimalRepositoryIntegrationTest {
    @Autowired
    private LandAnimalRepository landAnimalRepository;

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
