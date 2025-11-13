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

package uk.gov.gchq.gaffer.federatedstore.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferCheckedException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.store.schema.Schema;

class ApplyViewToElementsFunctionDiffblueTest {
  /**
   * Test {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction()}.
   *
   * <p>Method under test: {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction()}
   */
  @Test
  @DisplayName("Test new ApplyViewToElementsFunction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApplyViewToElementsFunction.<init>()"})
  void testNewApplyViewToElementsFunction() {
    // Arrange, Act and Assert
    Set<String> requiredContextValues =
        new ApplyViewToElementsFunction().getRequiredContextValues();
    assertEquals(3, requiredContextValues.size());
    assertTrue(requiredContextValues.contains(ApplyViewToElementsFunction.SCHEMA));
    assertTrue(requiredContextValues.contains(ApplyViewToElementsFunction.USER));
    assertTrue(requiredContextValues.contains(ApplyViewToElementsFunction.VIEW));
  }

  /**
   * Test {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction(Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@link ApplyViewToElementsFunction#TEMP_RESULTS_GRAPH} is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction(Map)}
   */
  @Test
  @DisplayName(
      "Test new ApplyViewToElementsFunction(Map); given '42'; when HashMap() TEMP_RESULTS_GRAPH is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApplyViewToElementsFunction.<init>(Map)"})
  void testNewApplyViewToElementsFunction_given42_whenHashMapTemp_results_graphIs42()
      throws GafferCheckedException {
    // Arrange
    HashMap<String, Object> context = new HashMap<>();
    context.put(ApplyViewToElementsFunction.TEMP_RESULTS_GRAPH, "42");

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> new ApplyViewToElementsFunction(context));
  }

  /**
   * Test {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction(Map)}.
   *
   * <ul>
   *   <li>Given {@link ApplyViewToElementsFunction#SCHEMA}.
   *   <li>When {@link HashMap#HashMap()} {@link ApplyViewToElementsFunction#SCHEMA} is {@link
   *       Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction(Map)}
   */
  @Test
  @DisplayName(
      "Test new ApplyViewToElementsFunction(Map); given SCHEMA; when HashMap() SCHEMA is Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApplyViewToElementsFunction.<init>(Map)"})
  void testNewApplyViewToElementsFunction_givenSchema_whenHashMapSchemaIsSchema()
      throws GafferCheckedException {
    // Arrange
    HashMap<String, Object> context = new HashMap<>();
    context.put(ApplyViewToElementsFunction.SCHEMA, new Schema());
    context.put(ApplyViewToElementsFunction.TEMP_RESULTS_GRAPH, null);
    context.put(ApplyViewToElementsFunction.VIEW, new View());
    context.put(ApplyViewToElementsFunction.USER, "Context");

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> new ApplyViewToElementsFunction(context));
  }

  /**
   * Test {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction(Map)}
   */
  @Test
  @DisplayName("Test new ApplyViewToElementsFunction(Map); when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApplyViewToElementsFunction.<init>(Map)"})
  void testNewApplyViewToElementsFunction_whenHashMap() throws GafferCheckedException {
    // Arrange, Act and Assert
    assertThrows(
        GafferCheckedException.class, () -> new ApplyViewToElementsFunction(new HashMap<>()));
  }

  /**
   * Test {@link ApplyViewToElementsFunction#createFunctionWithContext(HashMap)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@link ApplyViewToElementsFunction#TEMP_RESULTS_GRAPH} is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ApplyViewToElementsFunction#createFunctionWithContext(HashMap)}
   */
  @Test
  @DisplayName(
      "Test createFunctionWithContext(HashMap); given '42'; when HashMap() TEMP_RESULTS_GRAPH is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplyViewToElementsFunction ApplyViewToElementsFunction.createFunctionWithContext(HashMap)"
  })
  void testCreateFunctionWithContext_given42_whenHashMapTemp_results_graphIs42()
      throws GafferCheckedException {
    // Arrange
    ApplyViewToElementsFunction applyViewToElementsFunction = new ApplyViewToElementsFunction();

    HashMap<String, Object> context = new HashMap<>();
    context.put(ApplyViewToElementsFunction.TEMP_RESULTS_GRAPH, "42");

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> applyViewToElementsFunction.createFunctionWithContext(context));
  }

  /**
   * Test {@link ApplyViewToElementsFunction#createFunctionWithContext(HashMap)}.
   *
   * <ul>
   *   <li>Given {@link ApplyViewToElementsFunction#SCHEMA}.
   *   <li>When {@link HashMap#HashMap()} {@link ApplyViewToElementsFunction#SCHEMA} is {@link
   *       Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link ApplyViewToElementsFunction#createFunctionWithContext(HashMap)}
   */
  @Test
  @DisplayName(
      "Test createFunctionWithContext(HashMap); given SCHEMA; when HashMap() SCHEMA is Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplyViewToElementsFunction ApplyViewToElementsFunction.createFunctionWithContext(HashMap)"
  })
  void testCreateFunctionWithContext_givenSchema_whenHashMapSchemaIsSchema()
      throws GafferCheckedException {
    // Arrange
    ApplyViewToElementsFunction applyViewToElementsFunction = new ApplyViewToElementsFunction();

    HashMap<String, Object> context = new HashMap<>();
    context.put(ApplyViewToElementsFunction.SCHEMA, new Schema());
    context.put(ApplyViewToElementsFunction.TEMP_RESULTS_GRAPH, null);
    context.put(ApplyViewToElementsFunction.VIEW, new View());
    context.put(ApplyViewToElementsFunction.USER, "Context");

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> applyViewToElementsFunction.createFunctionWithContext(context));
  }

  /**
   * Test {@link ApplyViewToElementsFunction#createFunctionWithContext(HashMap)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link ApplyViewToElementsFunction#createFunctionWithContext(HashMap)}
   */
  @Test
  @DisplayName("Test createFunctionWithContext(HashMap); when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApplyViewToElementsFunction ApplyViewToElementsFunction.createFunctionWithContext(HashMap)"
  })
  void testCreateFunctionWithContext_whenHashMap() throws GafferCheckedException {
    // Arrange
    ApplyViewToElementsFunction applyViewToElementsFunction = new ApplyViewToElementsFunction();

    // Act and Assert
    assertThrows(
        GafferCheckedException.class,
        () -> applyViewToElementsFunction.createFunctionWithContext(new HashMap<>()));
  }

  /**
   * Test {@link ApplyViewToElementsFunction#getRequiredContextValues()}.
   *
   * <p>Method under test: {@link ApplyViewToElementsFunction#getRequiredContextValues()}
   */
  @Test
  @DisplayName("Test getRequiredContextValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set ApplyViewToElementsFunction.getRequiredContextValues()"})
  void testGetRequiredContextValues() {
    // Arrange and Act
    Set<String> actualRequiredContextValues =
        new ApplyViewToElementsFunction().getRequiredContextValues();

    // Assert
    assertEquals(3, actualRequiredContextValues.size());
    assertTrue(actualRequiredContextValues.contains(ApplyViewToElementsFunction.SCHEMA));
    assertTrue(actualRequiredContextValues.contains(ApplyViewToElementsFunction.USER));
    assertTrue(actualRequiredContextValues.contains(ApplyViewToElementsFunction.VIEW));
  }
}
