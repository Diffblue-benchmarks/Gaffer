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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferCheckedException;

class ApplyViewToElementsFunctionDiffblueTest {
  /**
   * Test {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction()}.
   * <p>
   * Method under test: {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction()}
   */
  @Test
  @DisplayName("Test new ApplyViewToElementsFunction()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApplyViewToElementsFunction.<init>()"})
  void testNewApplyViewToElementsFunction() {
    // Arrange, Act and Assert
    Set<String> requiredContextValues = (new ApplyViewToElementsFunction()).getRequiredContextValues();
    assertEquals(3, requiredContextValues.size());
    assertTrue(requiredContextValues.contains(ApplyViewToElementsFunction.SCHEMA));
    assertTrue(requiredContextValues.contains(ApplyViewToElementsFunction.USER));
    assertTrue(requiredContextValues.contains(ApplyViewToElementsFunction.VIEW));
  }

  /**
   * Test {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction(Map)}.
   * <ul>
   *   <li>Given {@link ApplyViewToElementsFunction#TEMP_RESULTS_GRAPH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction(Map)}
   */
  @Test
  @DisplayName("Test new ApplyViewToElementsFunction(Map); given TEMP_RESULTS_GRAPH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApplyViewToElementsFunction.<init>(Map)"})
  void testNewApplyViewToElementsFunction_givenTemp_results_graph() throws GafferCheckedException {
    // Arrange
    HashMap<String, Object> context = new HashMap<>();
    context.put(ApplyViewToElementsFunction.TEMP_RESULTS_GRAPH, "42");

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> new ApplyViewToElementsFunction(context));
  }

  /**
   * Test {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApplyViewToElementsFunction#ApplyViewToElementsFunction(Map)}
   */
  @Test
  @DisplayName("Test new ApplyViewToElementsFunction(Map); when HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApplyViewToElementsFunction.<init>(Map)"})
  void testNewApplyViewToElementsFunction_whenHashMap() throws GafferCheckedException {
    // Arrange, Act and Assert
    assertThrows(GafferCheckedException.class, () -> new ApplyViewToElementsFunction(new HashMap<>()));
  }

  /**
   * Test {@link ApplyViewToElementsFunction#createFunctionWithContext(HashMap)}.
   * <ul>
   *   <li>Given {@link ApplyViewToElementsFunction#TEMP_RESULTS_GRAPH}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApplyViewToElementsFunction#createFunctionWithContext(HashMap)}
   */
  @Test
  @DisplayName("Test createFunctionWithContext(HashMap); given TEMP_RESULTS_GRAPH")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApplyViewToElementsFunction ApplyViewToElementsFunction.createFunctionWithContext(HashMap)"})
  void testCreateFunctionWithContext_givenTemp_results_graph() throws GafferCheckedException {
    // Arrange
    ApplyViewToElementsFunction applyViewToElementsFunction = new ApplyViewToElementsFunction();

    HashMap<String, Object> context = new HashMap<>();
    context.put(ApplyViewToElementsFunction.TEMP_RESULTS_GRAPH, "42");

    // Act and Assert
    assertThrows(GafferCheckedException.class, () -> applyViewToElementsFunction.createFunctionWithContext(context));
  }

  /**
   * Test {@link ApplyViewToElementsFunction#createFunctionWithContext(HashMap)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApplyViewToElementsFunction#createFunctionWithContext(HashMap)}
   */
  @Test
  @DisplayName("Test createFunctionWithContext(HashMap); when HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApplyViewToElementsFunction ApplyViewToElementsFunction.createFunctionWithContext(HashMap)"})
  void testCreateFunctionWithContext_whenHashMap() throws GafferCheckedException {
    // Arrange
    ApplyViewToElementsFunction applyViewToElementsFunction = new ApplyViewToElementsFunction();

    // Act and Assert
    assertThrows(GafferCheckedException.class,
        () -> applyViewToElementsFunction.createFunctionWithContext(new HashMap<>()));
  }

  /**
   * Test {@link ApplyViewToElementsFunction#getRequiredContextValues()}.
   * <p>
   * Method under test: {@link ApplyViewToElementsFunction#getRequiredContextValues()}
   */
  @Test
  @DisplayName("Test getRequiredContextValues()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ApplyViewToElementsFunction.getRequiredContextValues()"})
  void testGetRequiredContextValues() {
    // Arrange and Act
    Set<String> actualRequiredContextValues = (new ApplyViewToElementsFunction()).getRequiredContextValues();

    // Assert
    assertEquals(3, actualRequiredContextValues.size());
    assertTrue(actualRequiredContextValues.contains(ApplyViewToElementsFunction.SCHEMA));
    assertTrue(actualRequiredContextValues.contains(ApplyViewToElementsFunction.USER));
    assertTrue(actualRequiredContextValues.contains(ApplyViewToElementsFunction.VIEW));
  }
}
