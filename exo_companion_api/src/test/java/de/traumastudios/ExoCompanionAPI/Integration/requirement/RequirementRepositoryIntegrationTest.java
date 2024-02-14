package de.traumastudios.ExoCompanionAPI.Integration.requirement;

import de.traumastudios.ExoCompanionAPI.requirement.repository.RequirementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RequirementRepositoryIntegrationTest {
    @Autowired
    private RequirementRepository requirementRepository;

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
