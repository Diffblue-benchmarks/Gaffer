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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.accumulo.core.iterators.IteratorEnvironment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.impl.ElementPostAggregationFilter;

class AbstractElementFilterDiffblueTest {
  /**
   * Test {@link AbstractElementFilter#deepCopy(IteratorEnvironment)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractElementFilter#deepCopy(IteratorEnvironment)}
   */
  @Test
  @DisplayName("Test deepCopy(IteratorEnvironment); when 'null'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.accumulo.core.iterators.SortedKeyValueIterator AbstractElementFilter.deepCopy(IteratorEnvironment)"
  })
  void testDeepCopy_whenNull_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> new ElementPostAggregationFilter().deepCopy(null));
  }

  /**
   * Test {@link AbstractElementFilter#validateOptions(Map)}.
   *
   * <p>Method under test: {@link AbstractElementFilter#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractElementFilter.validateOptions(Map)"})
  void testValidateOptions() {
    // Arrange
    ElementPostAggregationFilter elementPostAggregationFilter = new ElementPostAggregationFilter();

    HashMap<String, String> options = new HashMap<>();
    options.put("accumulostore.key.element_converter", "accumulostore.key.element_converter");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> elementPostAggregationFilter.validateOptions(options));
  }

  /**
   * Test {@link AbstractElementFilter#validateOptions(Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code negate} is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractElementFilter#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); given 'null'; when HashMap() 'negate' is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   *   <li>When {@link HashMap#HashMap()} {@code negate} is {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link AbstractElementFilter#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); given TRUE toString; when HashMap() 'negate' is TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractElementFilter.validateOptions(Map)"})
  void testValidateOptions_givenTrueToString_whenHashMapNegateIsTrueToString() {
    // Arrange
    ElementPostAggregationFilter elementPostAggregationFilter = new ElementPostAggregationFilter();

    HashMap<String, String> options = new HashMap<>();
    options.put("negate", Boolean.TRUE.toString());
    options.put("accumulostore.key.element_converter", "Options");
    options.put("Schema", "Options");

    // Act and Assert
    assertTrue(elementPostAggregationFilter.validateOptions(options));
  }

  /**
   * Test {@link AbstractElementFilter#validateOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractElementFilter#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractElementFilter.validateOptions(Map)"})
  void testValidateOptions_whenHashMap_thenThrowIllegalArgumentException() {
    // Arrange
    ElementPostAggregationFilter elementPostAggregationFilter = new ElementPostAggregationFilter();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> elementPostAggregationFilter.validateOptions(new HashMap<>()));
  }
}
