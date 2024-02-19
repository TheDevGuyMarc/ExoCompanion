package de.traumastudios.ExoCompanionAPI.Unit.requirement;

import de.traumastudios.ExoCompanionAPI.requirement.domain.Requirement;
import de.traumastudios.ExoCompanionAPI.requirement.repository.RequirementEntity;
import de.traumastudios.ExoCompanionAPI.requirement.repository.RequirementRepository;
import de.traumastudios.ExoCompanionAPI.requirement.service.RequirementService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RequirementServiceUnitTest {
    @Mock
    private RequirementRepository requirementRepository;

    @InjectMocks
    private RequirementService requirementService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllRequirements() {
        // given
        RequirementEntity entity1 = mock(RequirementEntity.class);
        RequirementEntity entity2 = mock(RequirementEntity.class);

        List<RequirementEntity> mockRequirement = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockRequirement).when(requirementRepository).findAll();
        List<Requirement> requirements = this.requirementService.findAllRequirements();

        // then
        Assertions.assertThat(requirements)
            .allMatch(requirement -> requirement instanceof Requirement)
            .withFailMessage("Element in the list is not of type Requirement");
    }

    @Test
    public void itShouldFindARequirementById() {
        // given
        RequirementEntity entity = mock(RequirementEntity.class);
        Optional<RequirementEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(requirementRepository).findById(productID);
        Optional<Requirement> requirement = this.requirementService.findRequirementById(productID);

        // then
        Assertions.assertThat(requirement).isPresent();
        Assertions.assertThat(requirement).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfARequirementCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(requirementRepository).findById(nonExistentId);

        // When
        Optional<Requirement> requirement = this.requirementService.findRequirementById(nonExistentId);

        // Then
        Assertions.assertThat(requirement).isEmpty();
    }

    @Test
    public void itShouldFindARequirementByName() {
        // given
        RequirementEntity entity = mock(RequirementEntity.class);
        Optional<RequirementEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(requirementRepository).findByName(name);
        Optional<Requirement> requirement = this.requirementService.findRequirementByName(name);

        // then
        Assertions.assertThat(requirement).isPresent();
        Assertions.assertThat(requirement.get()).isInstanceOf(Requirement.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfARequirementCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentRequirement";
        doReturn(Optional.empty()).when(requirementRepository).findByName(nonExistentName);

        // When
        Optional<Requirement> requirement = this.requirementService.findRequirementByName(nonExistentName);

        // Then
        Assertions.assertThat(requirement).isEmpty();
    }

    @Test
    public void itShouldCreateANewRequirement() {
        // Given
        RequirementEntity savedEntity = mock(RequirementEntity.class);
        Requirement requirement = mock(Requirement.class);

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(requirementRepository).saveAndFlush(any(RequirementEntity.class));

        // When
        Requirement createdRequirement = this.requirementService.createRequirement(requirement);

        // Then
        Assertions.assertThat(createdRequirement).isNotNull();
        verify(requirementRepository).saveAndFlush(any(RequirementEntity.class));
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingRequirement() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingRequirementById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(requirementRepository).deleteById(id);
        this.requirementService.deleteRequirement(id);

        // then
        Assertions.assertThatCode(() -> this.requirementService.deleteRequirement(id)).doesNotThrowAnyException();
    }
}
