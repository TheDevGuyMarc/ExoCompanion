package de.traumastudios.ExoCompanionAPI.Unit.substrate;

import de.traumastudios.ExoCompanionAPI.aquaticanimal.domain.AquaticAnimal;
import de.traumastudios.ExoCompanionAPI.aquaticanimal.repository.AquaticAnimalEntity;
import de.traumastudios.ExoCompanionAPI.substrate.domain.Substrate;
import de.traumastudios.ExoCompanionAPI.substrate.repository.SubstrateEntity;
import de.traumastudios.ExoCompanionAPI.substrate.repository.SubstrateRepository;
import de.traumastudios.ExoCompanionAPI.substrate.service.SubstrateService;
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
public class SubstrateServiceUnitTest {
    @Mock
    private SubstrateRepository substrateRepository;

    @InjectMocks
    private SubstrateService substrateService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllSubstrates() {
        // given
        SubstrateEntity entity1 = mock(SubstrateEntity.class);
        SubstrateEntity entity2 = mock(SubstrateEntity.class);

        List<SubstrateEntity> mockSubstrates = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockSubstrates).when(substrateRepository).findAll();
        List<Substrate> substrates = this.substrateService.findAllSubstrates();

        // then
        Assertions.assertThat(substrates)
            .allMatch(substrate -> substrate instanceof Substrate)
            .withFailMessage("Element in the list is not of type Substrate");
    }

    @Test
    public void itShouldFindASubstrateById() {
        // given
        SubstrateEntity entity = mock(SubstrateEntity.class);
        Optional<SubstrateEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(substrateRepository).findById(productID);
        Optional<Substrate> substrate = this.substrateService.findSubstrateById(productID);

        // then
        Assertions.assertThat(substrate).isPresent();
        Assertions.assertThat(substrate).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfASubstrateCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(substrateRepository).findById(nonExistentId);

        // When
        Optional<Substrate> substrate = this.substrateService.findSubstrateById(nonExistentId);

        // Then
        Assertions.assertThat(substrate).isEmpty();
    }

    @Test
    public void itShouldFindASubstrateByName() {
        // given
        SubstrateEntity entity = mock(SubstrateEntity.class);
        Optional<SubstrateEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(substrateRepository).findByName(name);
        Optional<Substrate> substrate = this.substrateService.findSubstrateByName(name);

        // then
        Assertions.assertThat(substrate).isPresent();
        Assertions.assertThat(substrate.get()).isInstanceOf(Substrate.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfASubstrateCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentSubstrate";
        doReturn(Optional.empty()).when(substrateRepository).findByName(nonExistentName);

        // When
        Optional<Substrate> substrate = this.substrateService.findSubstrateByName(nonExistentName);

        // Then
        Assertions.assertThat(substrate).isEmpty();
    }

    @Test
    public void itShouldCreateANewSubstrate() {
        // Given
        SubstrateEntity savedEntity = mock(SubstrateEntity.class);
        Substrate substrate = mock(Substrate.class);

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(substrateRepository).saveAndFlush(any(SubstrateEntity.class));

        // When
        Substrate createdSubstrate = this.substrateService.createSubstrate(substrate);

        // Then
        Assertions.assertThat(createdSubstrate).isNotNull();
        verify(substrateRepository).saveAndFlush(any(SubstrateEntity.class));
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingSubstrate() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingSubstrateById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(substrateRepository).deleteById(id);
        this.substrateService.deleteSubstrate(id);

        // then
        Assertions.assertThatCode(() -> this.substrateService.deleteSubstrate(id)).doesNotThrowAnyException();
    }
}
