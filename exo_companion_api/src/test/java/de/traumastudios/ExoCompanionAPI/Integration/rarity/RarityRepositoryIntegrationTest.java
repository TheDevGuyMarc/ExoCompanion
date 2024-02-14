package de.traumastudios.ExoCompanionAPI.Integration.rarity;

import de.traumastudios.ExoCompanionAPI.rarity.repository.RarityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RarityRepositoryIntegrationTest {
    @Autowired
    private RarityRepository rarityRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldFindARarityById() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldFindARarityByName() {
        // given

        // when

        // then
    }
}
