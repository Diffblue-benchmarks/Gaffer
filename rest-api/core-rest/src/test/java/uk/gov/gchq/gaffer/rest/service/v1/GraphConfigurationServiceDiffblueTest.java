/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.rest.service.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfigurationService.<init>()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "uk.gov.gchq.gaffer.store.schema.Schema GraphConfigurationService.getSchema()"
  })
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GraphConfigurationService.getDescription()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions()"})
  void testGetFilterFunctions() {
    // Arrange, Act and Assert
    assertEquals(50, new GraphConfigurationService().getFilterFunctions().size());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_thenReturnSizeIsTwentyOne() {
    // Arrange, Act and Assert
    assertEquals(
        21,
        new GraphConfigurationService()
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getFilterFunctions("."));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_whenEmptyString_thenReturnSizeIsFifty() {
    // Arrange, Act and Assert
    assertEquals(50, new GraphConfigurationService().getFilterFunctions("").size());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_whenInputClass() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getFilterFunctions("Input Class"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getFilterFunctions("[]"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_thenReturnSizeIsTwenty() {
    // Arrange and Act
    Set<String> actualSerialisedFields =
        new GraphConfigurationService()
            .getSerialisedFields(
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenClassName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getSerialisedFields("Class Name"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getSerialisedFields("."));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenJavaUtilFunctionPredicate_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new GraphConfigurationService()
            .getSerialisedFields("java.util.function.Predicate")
            .isEmpty());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenJavaUtilSet_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new GraphConfigurationService().getSerialisedFields("java.util.Set").isEmpty());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getSerialisedFields("[]"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenUkGovGchqKorypheSignatureSignatureUnknownGenericType() {
    // Arrange, Act and Assert
    assertTrue(
        new GraphConfigurationService()
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getTransformFunctions()"})
  void testGetTransformFunctions() {
    // Arrange, Act and Assert
    assertEquals(128, new GraphConfigurationService().getTransformFunctions().size());
  }

  /**
   * Test {@link GraphConfigurationService#getStoreTraits()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getStoreTraits()}
   */
  @Test
  @DisplayName("Test getStoreTraits()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getStoreTraits()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getNextOperations(String)"})
  void testGetNextOperations_whenDot() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getNextOperations("."));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getNextOperations(String)"})
  void testGetNextOperations_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getNextOperations("[]"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getNextOperations(String)"})
  void testGetNextOperations_whenOperationClassName() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationService().getNextOperations("Operation Class Name"));
  }

  /**
   * Test {@link GraphConfigurationService#getElementGenerators()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getElementGenerators()}
   */
  @Test
  @DisplayName("Test getElementGenerators()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getElementGenerators()"})
  void testGetElementGenerators() {
    // Arrange, Act and Assert
    assertEquals(6, new GraphConfigurationService().getElementGenerators().size());
  }

  /**
   * Test {@link GraphConfigurationService#getObjectGenerators()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getObjectGenerators()}
   */
  @Test
  @DisplayName("Test getObjectGenerators()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getObjectGenerators()"})
  void testGetObjectGenerators() {
    // Arrange, Act and Assert
    assertEquals(7, new GraphConfigurationService().getObjectGenerators().size());
  }

  /**
   * Test {@link GraphConfigurationService#getOperations()}.
   *
   * <p>Method under test: {@link GraphConfigurationService#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set GraphConfigurationService.getOperations()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean GraphConfigurationService.isOperationSupported(Class)"})
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
