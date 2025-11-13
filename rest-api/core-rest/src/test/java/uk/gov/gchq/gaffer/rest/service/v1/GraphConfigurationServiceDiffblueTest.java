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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GraphConfigurationServiceDiffblueTest {
  @InjectMocks
  private GraphConfigurationService graphConfigurationService;

  /**
   * Test new {@link GraphConfigurationService} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link GraphConfigurationService}
   */
  @Test
  @DisplayName("Test new GraphConfigurationService (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link GraphConfigurationService#getFilterFunctions()}.
   * <p>
   * Method under test: {@link GraphConfigurationService#getFilterFunctions()}
   */
  @Test
  @DisplayName("Test getFilterFunctions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions()"})
  void testGetFilterFunctions() {
    // Arrange, Act and Assert
    assertEquals(50, graphConfigurationService.getFilterFunctions().size());
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   * <ul>
   *   <li>Then return size is twenty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; then return size is twenty-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_thenReturnSizeIsTwentyOne() {
    // Arrange, Act and Assert
    assertEquals(21,
        graphConfigurationService.getFilterFunctions("com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition")
            .size());
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; when '.'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfigurationService.getFilterFunctions("."));
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return size is fifty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; when empty string; then return size is fifty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_whenEmptyString_thenReturnSizeIsFifty() {
    // Arrange, Act and Assert
    assertEquals(50, graphConfigurationService.getFilterFunctions("").size());
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   * <ul>
   *   <li>When {@code Input Class}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; when 'Input Class'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_whenInputClass() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfigurationService.getFilterFunctions("Input Class"));
  }

  /**
   * Test {@link GraphConfigurationService#getFilterFunctions(String)} with {@code String}.
   * <ul>
   *   <li>When {@code []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getFilterFunctions(String)}
   */
  @Test
  @DisplayName("Test getFilterFunctions(String) with 'String'; when '[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getFilterFunctions(String)"})
  void testGetFilterFunctionsWithString_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfigurationService.getFilterFunctions("[]"));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   * <ul>
   *   <li>Then return size is twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); then return size is twenty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_thenReturnSizeIsTwenty() {
    // Arrange and Act
    Set<String> actualSerialisedFields = graphConfigurationService
        .getSerialisedFields("com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition");

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
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when 'Class Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenClassName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfigurationService.getSerialisedFields("Class Name"));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when '.'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfigurationService.getSerialisedFields("."));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   * <ul>
   *   <li>When {@code java.util.function.Predicate}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when 'java.util.function.Predicate'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenJavaUtilFunctionPredicate_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(graphConfigurationService.getSerialisedFields("java.util.function.Predicate").isEmpty());
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   * <ul>
   *   <li>When {@code Set}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when 'java.util.Set'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenJavaUtilSet_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(graphConfigurationService.getSerialisedFields("java.util.Set").isEmpty());
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   * <ul>
   *   <li>When {@code []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when '[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfigurationService.getSerialisedFields("[]"));
  }

  /**
   * Test {@link GraphConfigurationService#getSerialisedFields(String)}.
   * <ul>
   *   <li>When {@code uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when 'uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenUkGovGchqKorypheSignatureSignatureUnknownGenericType() {
    // Arrange, Act and Assert
    assertTrue(
        graphConfigurationService.getSerialisedFields("uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType")
            .isEmpty());
  }

  /**
   * Test {@link GraphConfigurationService#getTransformFunctions()}.
   * <p>
   * Method under test: {@link GraphConfigurationService#getTransformFunctions()}
   */
  @Test
  @DisplayName("Test getTransformFunctions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getTransformFunctions()"})
  void testGetTransformFunctions() {
    // Arrange, Act and Assert
    assertEquals(128, graphConfigurationService.getTransformFunctions().size());
  }

  /**
   * Test {@link GraphConfigurationService#getNextOperations(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String); when '.'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getNextOperations(String)"})
  void testGetNextOperations_whenDot() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfigurationService.getNextOperations("."));
  }

  /**
   * Test {@link GraphConfigurationService#getNextOperations(String)}.
   * <ul>
   *   <li>When {@code []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String); when '[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getNextOperations(String)"})
  void testGetNextOperations_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphConfigurationService.getNextOperations("[]"));
  }

  /**
   * Test {@link GraphConfigurationService#getNextOperations(String)}.
   * <ul>
   *   <li>When {@code Operation Class Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationService#getNextOperations(String)}
   */
  @Test
  @DisplayName("Test getNextOperations(String); when 'Operation Class Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getNextOperations(String)"})
  void testGetNextOperations_whenOperationClassName() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> graphConfigurationService.getNextOperations("Operation Class Name"));
  }

  /**
   * Test {@link GraphConfigurationService#getElementGenerators()}.
   * <p>
   * Method under test: {@link GraphConfigurationService#getElementGenerators()}
   */
  @Test
  @DisplayName("Test getElementGenerators()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getElementGenerators()"})
  void testGetElementGenerators() {
    // Arrange, Act and Assert
    assertEquals(6, graphConfigurationService.getElementGenerators().size());
  }

  /**
   * Test {@link GraphConfigurationService#getObjectGenerators()}.
   * <p>
   * Method under test: {@link GraphConfigurationService#getObjectGenerators()}
   */
  @Test
  @DisplayName("Test getObjectGenerators()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set GraphConfigurationService.getObjectGenerators()"})
  void testGetObjectGenerators() {
    // Arrange, Act and Assert
    assertEquals(7, graphConfigurationService.getObjectGenerators().size());
  }
}
