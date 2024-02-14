package de.traumastudios.ExoCompanionAPI.Integration.location;

import de.traumastudios.ExoCompanionAPI.location.repository.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class LocationRepositoryIntegrationTest {
    @Autowired
    private LocationRepository locationRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldFindALocationById() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldFindALocationByName() {
        // given

        // when

        // then
    }
}
