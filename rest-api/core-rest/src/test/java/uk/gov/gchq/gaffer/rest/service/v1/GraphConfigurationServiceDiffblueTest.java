package uk.gov.gchq.gaffer.rest.service.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.gchq.gaffer.rest.factory.GraphFactory;

@ExtendWith(MockitoExtension.class)
class GraphConfigurationServiceDiffblueTest {
  @InjectMocks private GraphConfigurationService graphConfigurationService;

  @Mock private GraphFactory graphFactory;

  /**
   * Test new {@link GraphConfigurationService} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link GraphConfigurationService}
   */
  @Test
  @DisplayName("Test new GraphConfigurationService (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewGraphConfigurationService() {
    // Arrange and Act
    GraphConfigurationService actualGraphConfigurationService = new GraphConfigurationService();

    // Assert
    assertEquals(128, actualGraphConfigurationService.getTransformFunctions().size());
    assertEquals(50, actualGraphConfigurationService.getFilterFunctions().size());
    assertEquals(6, actualGraphConfigurationService.getElementGenerators().size());
    assertEquals(7, actualGraphConfigurationService.getObjectGenerators().size());
  }

  /**
   * Test {@link GraphConfigurationService#getSchema()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getSchema()}
   */
  @Test
  @DisplayName("Test getSchema()")
  @Tag("MaintainedByDiffblue")
  void testGetSchema() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfigurationService.getSchema());
    verify(graphFactory).getGraph();
  }

  /**
   * Test {@link GraphConfigurationService#getDescription()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("MaintainedByDiffblue")
  void testGetDescription() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfigurationService.getDescription());
    verify(graphFactory).getGraph();
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getFilterFunctions()}
   */
  @Test
  @DisplayName("Test getFilterFunctions()")
  @Tag("MaintainedByDiffblue")
  void testGetFilterFunctions() {
    // Arrange, Act and Assert
    assertEquals(50, graphConfigurationService.getFilterFunctions().size());
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return size is twenty-one.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; then return size is twenty-one")
  @Tag("MaintainedByDiffblue")
  void testGetFilterFunctionsWithString_thenReturnSizeIsTwentyOne() {
    // Arrange, Act and Assert
    assertEquals(
        21,
        graphConfigurationService
            .getFilterFunctions("com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition")
            .size());
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName(
      "Test getFilterFunctions(String) with 'String'; when '.'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testGetFilterFunctionsWithString_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> graphConfigurationService.getFilterFunctions("."));
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return size is fifty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName(
      "Test getFilterFunctions(String) with 'String'; when empty string; then return size is fifty")
  @Tag("MaintainedByDiffblue")
  void testGetFilterFunctionsWithString_whenEmptyString_thenReturnSizeIsFifty() {
    // Arrange, Act and Assert
    assertEquals(50, graphConfigurationService.getFilterFunctions("").size());
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Input Class}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; when 'Input Class'")
  @Tag("MaintainedByDiffblue")
  void testGetFilterFunctionsWithString_whenInputClass() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphConfigurationService.getFilterFunctions("Input Class"));
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; when '[]'")
  @Tag("MaintainedByDiffblue")
  void testGetFilterFunctionsWithString_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> graphConfigurationService.getFilterFunctions("[]"));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>Then return size is twenty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); then return size is twenty")
  @Tag("MaintainedByDiffblue")
  void testGetSerialisedFields_thenReturnSizeIsTwenty() {
    // Arrange and Act
    Set<String> actualSerialisedFields =
        graphConfigurationService.getSerialisedFields(
            "com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition");

    // Assert
    assertEquals(20, actualSerialisedFields.size());
    assertTrue(actualSerialisedFields.contains("accessor"));
    assertTrue(actualSerialisedFields.contains("field"));
    assertTrue(actualSerialisedFields.contains("fullName"));
    assertTrue(actualSerialisedFields.contains("getter"));
    assertTrue(actualSerialisedFields.contains("internalName"));
    assertTrue(actualSerialisedFields.contains("metadata"));
    assertTrue(actualSerialisedFields.contains("nonConstructorMutator"));
    assertTrue(actualSerialisedFields.contains("primaryMember"));
    assertTrue(actualSerialisedFields.contains("rawPrimaryType"));
    assertTrue(actualSerialisedFields.contains("required"));
    assertTrue(actualSerialisedFields.contains("wrapperName"));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFields(String); when 'Class Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testGetSerialisedFields_whenClassName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphConfigurationService.getSerialisedFields("Class Name"));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when '.'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testGetSerialisedFields_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> graphConfigurationService.getSerialisedFields("."));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code java.util.function.Predicate}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFields(String); when 'java.util.function.Predicate'; then return Empty")
  @Tag("MaintainedByDiffblue")
  void testGetSerialisedFields_whenJavaUtilFunctionPredicate_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        graphConfigurationService.getSerialisedFields("java.util.function.Predicate").isEmpty());
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code Set}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when 'java.util.Set'; then return Empty")
  @Tag("MaintainedByDiffblue")
  void testGetSerialisedFields_whenJavaUtilSet_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(graphConfigurationService.getSerialisedFields("java.util.Set").isEmpty());
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when '[]'")
  @Tag("MaintainedByDiffblue")
  void testGetSerialisedFields_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> graphConfigurationService.getSerialisedFields("[]"));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFields(String); when 'uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType'")
  @Tag("MaintainedByDiffblue")
  void testGetSerialisedFields_whenUkGovGchqKorypheSignatureSignatureUnknownGenericType() {
    // Arrange, Act and Assert
    assertTrue(
        graphConfigurationService
            .getSerialisedFields("uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType")
            .isEmpty());
  }

  /**
   * Test {@link GraphConfigurationService#getTransformFunctions()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getTransformFunctions()}
   */
  @Test
  @DisplayName("Test getTransformFunctions()")
  @Tag("MaintainedByDiffblue")
  void testGetTransformFunctions() {
    // Arrange, Act and Assert
    assertEquals(128, graphConfigurationService.getTransformFunctions().size());
  }

  /**
   * Test {@link GraphConfigurationService#getStoreTraits()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getStoreTraits()}
   */
  @Test
  @DisplayName("Test getStoreTraits()")
  @Tag("MaintainedByDiffblue")
  void testGetStoreTraits() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfigurationService.getStoreTraits());
    verify(graphFactory).getGraph();
  }

  /**
   * Test {@link GraphConfigurationService#getNextOperations(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String); when '.'")
  @Tag("MaintainedByDiffblue")
  void testGetNextOperations_whenDot() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> graphConfigurationService.getNextOperations("."));
  }

  /**
   * Test {@link GraphConfigurationService#getNextOperations(String)}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String); when '[]'")
  @Tag("MaintainedByDiffblue")
  void testGetNextOperations_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> graphConfigurationService.getNextOperations("[]"));
  }

  /**
   * Test {@link GraphConfigurationService#getNextOperations(String)}.
   *
   * <ul>
   *   <li>When {@code Operation Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationService#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String); when 'Operation Class Name'")
  @Tag("MaintainedByDiffblue")
  void testGetNextOperations_whenOperationClassName() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphConfigurationService.getNextOperations("Operation Class Name"));
  }

  /**
   * Test {@link GraphConfigurationService#getElementGenerators()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getElementGenerators()}
   */
  @Test
  @DisplayName("Test getElementGenerators()")
  @Tag("MaintainedByDiffblue")
  void testGetElementGenerators() {
    // Arrange, Act and Assert
    assertEquals(6, graphConfigurationService.getElementGenerators().size());
  }

  /**
   * Test {@link GraphConfigurationService#getObjectGenerators()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getObjectGenerators()}
   */
  @Test
  @DisplayName("Test getObjectGenerators()")
  @Tag("MaintainedByDiffblue")
  void testGetObjectGenerators() {
    // Arrange, Act and Assert
    assertEquals(7, graphConfigurationService.getObjectGenerators().size());
  }

  /**
   * Test {@link GraphConfigurationService#getOperations()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations()")
  @Tag("MaintainedByDiffblue")
  void testGetOperations() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfigurationService.getOperations());
    verify(graphFactory).getGraph();
  }

  /**
   * Test {@link GraphConfigurationService#isOperationSupported(Class)}.
   *
   * <p>Method under test: {@link GraphConfigurationService#isOperationSupported(Class)}
   */
  @Test
  @DisplayName("Test isOperationSupported(Class)")
  @Tag("MaintainedByDiffblue")
  void testIsOperationSupported() {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new IllegalArgumentException());
    Class<Object> operation = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> graphConfigurationService.isOperationSupported(operation));
    verify(graphFactory).getGraph();
  }
}
