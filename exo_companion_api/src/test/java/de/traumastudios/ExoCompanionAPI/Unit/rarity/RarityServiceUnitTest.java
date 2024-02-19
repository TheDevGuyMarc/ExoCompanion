package de.traumastudios.ExoCompanionAPI.Unit.rarity;

import de.traumastudios.ExoCompanionAPI.rarity.domain.Rarity;
import de.traumastudios.ExoCompanionAPI.rarity.repository.RarityEntity;
import de.traumastudios.ExoCompanionAPI.rarity.repository.RarityRepository;
import de.traumastudios.ExoCompanionAPI.rarity.service.RarityService;
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
public class RarityServiceUnitTest {
    @Mock
    private RarityRepository rarityRepository;

    @InjectMocks
    private RarityService rarityService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllRarities() {
        // given
        RarityEntity entity1 = mock(RarityEntity.class);
        RarityEntity entity2 = mock(RarityEntity.class);

        List<RarityEntity> mockRarity = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockRarity).when(rarityRepository).findAll();
        List<Rarity> rarities = this.rarityService.findAllRarities();

        // then
        Assertions.assertThat(rarities)
            .allMatch(rarity -> rarity instanceof Rarity)
            .withFailMessage("Element in the list is not of type Rarity");
    }

    @Test
    public void itShouldFindARarityById() {
        // given
        RarityEntity entity = mock(RarityEntity.class);
        Optional<RarityEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(rarityRepository).findById(productID);
        Optional<Rarity> rarity = this.rarityService.findRarityById(productID);

        // then
        Assertions.assertThat(rarity).isPresent();
        Assertions.assertThat(rarity).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfARarityCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(rarityRepository).findById(nonExistentId);

        // When
        Optional<Rarity> rarity = this.rarityService.findRarityById(nonExistentId);

        // Then
        Assertions.assertThat(rarity).isEmpty();
    }

    @Test
    public void itShouldFindARarityByName() {
        // given
        RarityEntity entity = mock(RarityEntity.class);
        Optional<RarityEntity> testObject = Optional.of(entity);
        String name = "fish";

        // when
        doReturn(testObject).when(rarityRepository).findByName(name);
        Optional<Rarity> rarity = this.rarityService.findRarityByName(name);

        // then
        Assertions.assertThat(rarity).isPresent();
        Assertions.assertThat(rarity.get()).isInstanceOf(Rarity.class);
    }

    @Test
    public void itShouldThrowAnExceptionIfARarityCouldNotBeFoundByName() {
        // Given
        String nonExistentName = "nonExistentRarity";
        doReturn(Optional.empty()).when(rarityRepository).findByName(nonExistentName);

        // When
        Optional<Rarity> rarity = this.rarityService.findRarityByName(nonExistentName);

        // Then
        Assertions.assertThat(rarity).isEmpty();
    }

    @Test
    public void itShouldCreateANewRarity() {
        // Given
        RarityEntity savedEntity = mock(RarityEntity.class);
        Rarity rarity = mock(Rarity.class);

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(rarityRepository).saveAndFlush(any(RarityEntity.class));

        // When
        Rarity createdRarity = this.rarityService.createRarity(rarity);

        // Then
        Assertions.assertThat(createdRarity).isNotNull();
        verify(rarityRepository).saveAndFlush(any(RarityEntity.class));
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingRarity() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingRarityById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(rarityRepository).deleteById(id);
        this.rarityService.deleteRarity(id);

        // then
        Assertions.assertThatCode(() -> this.rarityService.deleteRarity(id)).doesNotThrowAnyException();
    }
}
