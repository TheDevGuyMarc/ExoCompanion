package de.traumastudios.ExoCompanionAPI.Integration.culture;

import de.traumastudios.ExoCompanionAPI.culture.repository.CultureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CultureRepositoryIntegrationTest {
    @Autowired
    private CultureRepository cultureRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldFindACultureById() {
        // given

        // when

        // then
    }
}
