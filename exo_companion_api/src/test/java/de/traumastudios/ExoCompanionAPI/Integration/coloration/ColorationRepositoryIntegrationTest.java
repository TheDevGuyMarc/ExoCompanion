package de.traumastudios.ExoCompanionAPI.Integration.coloration;

import de.traumastudios.ExoCompanionAPI.coloration.repository.ColorationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ColorationRepositoryIntegrationTest {
    @Autowired
    private ColorationRepository colorationRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldFindAColorationById() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldFindAColorationByName() {
        // given

        // when

        // then
    }
}
