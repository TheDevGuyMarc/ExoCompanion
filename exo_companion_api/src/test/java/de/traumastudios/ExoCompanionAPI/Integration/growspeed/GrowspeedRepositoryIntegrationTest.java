package de.traumastudios.ExoCompanionAPI.Integration.growspeed;

import de.traumastudios.ExoCompanionAPI.growspeed.repository.GrowspeedRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class GrowspeedRepositoryIntegrationTest {
    @Autowired
    private GrowspeedRepository growspeedRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldFindAGrowspeedById() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldFindAGrowspeedByName() {
        // given

        // when

        // then
    }
}
