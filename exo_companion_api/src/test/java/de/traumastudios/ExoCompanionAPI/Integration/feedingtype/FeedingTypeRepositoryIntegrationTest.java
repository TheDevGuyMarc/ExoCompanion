package de.traumastudios.ExoCompanionAPI.Integration.feedingtype;

import de.traumastudios.ExoCompanionAPI.feedingtype.repository.FeedingTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class FeedingTypeRepositoryIntegrationTest {
    @Autowired
    private FeedingTypeRepository feedingTypeRepository;

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
