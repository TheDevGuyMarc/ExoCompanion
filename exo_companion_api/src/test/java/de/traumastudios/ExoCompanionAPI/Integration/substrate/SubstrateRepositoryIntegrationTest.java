package de.traumastudios.ExoCompanionAPI.Integration.substrate;

import de.traumastudios.ExoCompanionAPI.substrate.repository.SubstrateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class SubstrateRepositoryIntegrationTest {
    @Autowired
    private SubstrateRepository substrateRepository;

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
