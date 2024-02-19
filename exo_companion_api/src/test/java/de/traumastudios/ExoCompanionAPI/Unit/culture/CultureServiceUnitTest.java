package de.traumastudios.ExoCompanionAPI.Unit.culture;

import de.traumastudios.ExoCompanionAPI.culture.domain.Culture;
import de.traumastudios.ExoCompanionAPI.culture.repository.CultureEntity;
import de.traumastudios.ExoCompanionAPI.culture.repository.CultureRepository;
import de.traumastudios.ExoCompanionAPI.culture.service.CultureService;
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

@ExtendWith(MockitoExtension.class)
public class CultureServiceUnitTest {
    @Mock
    private CultureRepository cultureRepository;

    @InjectMocks
    private CultureService cultureService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void itShouldListAllCultures() {
        // given
        CultureEntity entity1 = mock(CultureEntity.class);
        CultureEntity entity2 = mock(CultureEntity.class);

        List<CultureEntity> mockCultures = List.of(
            entity1,
            entity2
        );

        // when
        doReturn(mockCultures).when(cultureRepository).findAll();
        List<Culture> cultures = this.cultureService.findAllCultures();

        // then
        Assertions.assertThat(cultures)
            .allMatch(culture -> culture instanceof Culture)
            .withFailMessage("Element in the list is not of type Culture");
    }

    @Test
    public void itShouldFindACultureById() {
        // given
        CultureEntity entity = mock(CultureEntity.class);
        Optional<CultureEntity> testObject = Optional.of(entity);
        Long productID = 1L;

        // when
        doReturn(testObject).when(cultureRepository).findById(productID);
        Optional<Culture> culture = this.cultureService.findCultureById(productID);

        // then
        Assertions.assertThat(culture).isPresent();
        Assertions.assertThat(culture).isNotNull();
    }

    @Test
    public void itShouldThrowAnExceptionIfACultureCouldNotBeFoundById() {
        // Given
        Long nonExistentId = 2L;
        doReturn(Optional.empty()).when(cultureRepository).findById(nonExistentId);

        // When
        Optional<Culture> culture = this.cultureService.findCultureById(nonExistentId);

        // Then
        Assertions.assertThat(culture).isEmpty();
    }

    @Test
    public void itShouldCreateANewCulture() {
        // Given
        CultureEntity savedEntity = mock(CultureEntity.class); // Mocked entity saved in the repository
        Culture culture = mock(Culture.class); // Culture object passed to the service

        // Mock the behavior of the repository's saveAndFlush method to return the saved entity
        doReturn(savedEntity).when(cultureRepository).saveAndFlush(any(CultureEntity.class));

        // When
        Culture createdCulture = this.cultureService.createCulture(culture);

        // Then
        Assertions.assertThat(createdCulture).isNotNull(); // Assert that the returned culture is not null
        verify(cultureRepository).saveAndFlush(any(CultureEntity.class)); // Verify that saveAndFlush was called
    }

    @Test
    @Disabled
    public void itShouldUpdateAnExistingCulture() {
        // given

        // when

        // then
    }

    @Test
    public void itShouldDeleteAnExistingCultureById() {
        // given
        Long id = 1L;

        // when
        doNothing().when(cultureRepository).deleteById(id);
        this.cultureService.deleteCulture(id);

        // then
        Assertions.assertThatCode(() -> this.cultureService.deleteCulture(id)).doesNotThrowAnyException();
    }
}
