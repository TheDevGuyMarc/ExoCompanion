package de.traumastudios.ExoCompanionAPI.Integration.difficulty;

import de.traumastudios.ExoCompanionAPI.difficulty.repository.DifficultyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class DifficultyRepositoryIntegrationTest {
    @Autowired
    private DifficultyRepository difficultyRepository;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldFindADifficultyById() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldFindADifficultyByName() {
        // given

        // when

        // then
    }
}
