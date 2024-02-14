package de.traumastudios.ExoCompanionAPI.Integration.origin;

import de.traumastudios.ExoCompanionAPI.origin.repository.OriginRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class OriginRepositoryIntegrationTest {
    @Autowired
    private OriginRepository originRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldFindAOriginById() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldFindAOriginByName() {
        // given

        // when

        // then
    }
}
