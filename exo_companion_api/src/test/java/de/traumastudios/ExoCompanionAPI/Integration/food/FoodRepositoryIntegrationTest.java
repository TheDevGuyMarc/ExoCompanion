package de.traumastudios.ExoCompanionAPI.Integration.food;

import de.traumastudios.ExoCompanionAPI.food.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class FoodRepositoryIntegrationTest {
    @Autowired
    private FoodRepository foodRepository;

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
