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

package uk.gov.gchq.gaffer.accumulostore.key;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.impl.ElementPostAggregationFilter;

class AbstractElementFilterDiffblueTest {
  /**
   * Test {@link AbstractElementFilter#validateOptions(Map)}.
   * <p>
   * Method under test: {@link AbstractElementFilter#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractElementFilter.validateOptions(Map)"})
  void testValidateOptions() {
    // Arrange
    ElementPostAggregationFilter elementPostAggregationFilter = new ElementPostAggregationFilter();

    HashMap<String, String> options = new HashMap<>();
    options.put("accumulostore.key.element_converter", "accumulostore.key.element_converter");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> elementPostAggregationFilter.validateOptions(options));
  }

  /**
   * Test {@link AbstractElementFilter#validateOptions(Map)}.
   * <ul>
   *   <li>Given {@code negate}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code negate} is {@code Options}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractElementFilter#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); given 'negate'; when HashMap() 'negate' is 'Options'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractElementFilter.validateOptions(Map)"})
  void testValidateOptions_givenNegate_whenHashMapNegateIsOptions_thenReturnTrue() {
    // Arrange
    ElementPostAggregationFilter elementPostAggregationFilter = new ElementPostAggregationFilter();

    HashMap<String, String> options = new HashMap<>();
    options.put("negate", "Options");
    options.put("accumulostore.key.element_converter", "Options");
    options.put("Schema", "Options");

    // Act and Assert
    assertTrue(elementPostAggregationFilter.validateOptions(options));
  }

  /**
   * Test {@link AbstractElementFilter#validateOptions(Map)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code negate} is {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractElementFilter#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); given 'null'; when HashMap() 'negate' is 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractElementFilter.validateOptions(Map)"})
  void testValidateOptions_givenNull_whenHashMapNegateIsNull_thenReturnTrue() {
    // Arrange
    ElementPostAggregationFilter elementPostAggregationFilter = new ElementPostAggregationFilter();

    HashMap<String, String> options = new HashMap<>();
    options.put("negate", null);
    options.put("accumulostore.key.element_converter", "Options");
    options.put("Schema", "Options");

    // Act and Assert
    assertTrue(elementPostAggregationFilter.validateOptions(options));
  }

  /**
   * Test {@link AbstractElementFilter#validateOptions(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractElementFilter#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractElementFilter.validateOptions(Map)"})
  void testValidateOptions_whenHashMap_thenThrowIllegalArgumentException() {
    // Arrange
    ElementPostAggregationFilter elementPostAggregationFilter = new ElementPostAggregationFilter();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> elementPostAggregationFilter.validateOptions(new HashMap<>()));
  }
}
