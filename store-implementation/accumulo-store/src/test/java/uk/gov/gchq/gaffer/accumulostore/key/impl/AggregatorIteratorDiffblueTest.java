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

package uk.gov.gchq.gaffer.accumulostore.key.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AggregatorIteratorDiffblueTest {
  /**
   * Test {@link AggregatorIterator#reduce(Key, Iterator)}.
   *
   * <ul>
   *   <li>Given {@link Value#Value()}.
   *   <li>When {@link Key#Key()}.
   *   <li>Then not {@link ArrayList#ArrayList()} iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorIterator#reduce(Key, Iterator)}
   */
  @Test
  @DisplayName(
      "Test reduce(Key, Iterator); given Value(); when Key(); then not ArrayList() iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value AggregatorIterator.reduce(Key, Iterator)"})
  void testReduce_givenValue_whenKey_thenNotArrayListIteratorHasNext() {
    // Arrange
    AggregatorIterator aggregatorIterator = new AggregatorIterator();
    Key key = new Key();

    ArrayList<Value> valueList = new ArrayList<>();
    Value value = new Value();
    valueList.add(value);
    Iterator<Value> iter = valueList.iterator();

    // Act
    Value actualReduceResult = aggregatorIterator.reduce(key, iter);

    // Assert
    assertFalse(iter.hasNext());
    assertSame(value, actualReduceResult);
  }

  /**
   * Test {@link AggregatorIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code columns} is {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); given '42'; when HashMap() 'columns' is '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggregatorIterator.validateOptions(Map)"})
  void testValidateOptions_given42_whenHashMapColumnsIs42_thenReturnTrue() {
    // Arrange
    AggregatorIterator aggregatorIterator = new AggregatorIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("all", Boolean.FALSE.toString());
    options.put("columns", "42");
    options.put("accumulostore.key.element_converter", "Options");
    options.put("Schema", "Options");

    // Act and Assert
    assertTrue(aggregatorIterator.validateOptions(options));
  }

  /**
   * Test {@link AggregatorIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link HashMap#HashMap()} {@code columns} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); given empty string; when HashMap() 'columns' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggregatorIterator.validateOptions(Map)"})
  void testValidateOptions_givenEmptyString_whenHashMapColumnsIsEmptyString() {
    // Arrange
    AggregatorIterator aggregatorIterator = new AggregatorIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("all", Boolean.FALSE.toString());
    options.put("columns", "");
    options.put("accumulostore.key.element_converter", "Options");
    options.put("Schema", "Options");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> aggregatorIterator.validateOptions(options));
  }

  /**
   * Test {@link AggregatorIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#FALSE} toString.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); given FALSE toString; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggregatorIterator.validateOptions(Map)"})
  void testValidateOptions_givenFalseToString_thenReturnTrue() {
    // Arrange
    AggregatorIterator aggregatorIterator = new AggregatorIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("all", Boolean.FALSE.toString());
    options.put("columns", "Options");
    options.put("accumulostore.key.element_converter", "Options");
    options.put("Schema", "Options");

    // Act and Assert
    assertTrue(aggregatorIterator.validateOptions(options));
  }

  /**
   * Test {@link AggregatorIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); given TRUE toString; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggregatorIterator.validateOptions(Map)"})
  void testValidateOptions_givenTrueToString_thenReturnTrue() {
    // Arrange
    AggregatorIterator aggregatorIterator = new AggregatorIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("all", Boolean.TRUE.toString());
    options.put("columns", "Options");
    options.put("accumulostore.key.element_converter", "Options");
    options.put("Schema", "Options");

    // Act and Assert
    assertTrue(aggregatorIterator.validateOptions(options));
  }

  /**
   * Test {@link AggregatorIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   *   <li>When {@link HashMap#HashMap()} {@code all} is {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); given TRUE toString; when HashMap() 'all' is TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggregatorIterator.validateOptions(Map)"})
  void testValidateOptions_givenTrueToString_whenHashMapAllIsTrueToString() {
    // Arrange
    AggregatorIterator aggregatorIterator = new AggregatorIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("all", Boolean.TRUE.toString());
    options.put("columns", "Options");
    options.put("Schema", "Options");
    options.put("Schema", "Options");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> aggregatorIterator.validateOptions(options));
  }

  /**
   * Test {@link AggregatorIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   *   <li>When {@link HashMap#HashMap()} {@code all} is {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); given TRUE toString; when HashMap() 'all' is TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggregatorIterator.validateOptions(Map)"})
  void testValidateOptions_givenTrueToString_whenHashMapAllIsTrueToString2() {
    // Arrange
    AggregatorIterator aggregatorIterator = new AggregatorIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("all", Boolean.TRUE.toString());
    options.put("columns", "Options");
    options.put("accumulostore.key.element_converter", "Options");
    options.put("accumulostore.key.element_converter", "Options");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> aggregatorIterator.validateOptions(options));
  }

  /**
   * Test {@link AggregatorIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code columns} is {@code
   *       accumulostore.key.element_converter}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); when HashMap() 'columns' is 'accumulostore.key.element_converter'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggregatorIterator.validateOptions(Map)"})
  void testValidateOptions_whenHashMapColumnsIsAccumulostoreKeyElementConverter() {
    // Arrange
    AggregatorIterator aggregatorIterator = new AggregatorIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("all", Boolean.FALSE.toString());
    options.put("columns", "accumulostore.key.element_converter");
    options.put("accumulostore.key.element_converter", "Options");
    options.put("Schema", "Options");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> aggregatorIterator.validateOptions(options));
  }

  /**
   * Test {@link AggregatorIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AggregatorIterator.validateOptions(Map)"})
  void testValidateOptions_whenHashMap_thenThrowIllegalArgumentException() {
    // Arrange
    AggregatorIterator aggregatorIterator = new AggregatorIterator();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> aggregatorIterator.validateOptions(new HashMap<>()));
  }

  /**
   * Test {@link AggregatorIterator#describeOptions()}.
   *
   * <p>Method under test: {@link AggregatorIterator#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorOptions AggregatorIterator.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult = new AggregatorIterator().describeOptions();

    // Assert
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(5, namedOptions.size());
    assertEquals(
        "<col fam>[:<col qual>]{,<col fam>[:<col qual>]} escape non-alphanum chars using %<hex>.",
        namedOptions.get("columns"));
    assertEquals("Aggregator", actualDescribeOptionsResult.getName());
    assertEquals(
        "Applies a reduce function to elements with identical (rowKey, column family, column qualifier,"
            + " visibility)",
        actualDescribeOptionsResult.getDescription());
    assertEquals(
        "If true, only reduce on full major compactions.  Defaults to false. ",
        namedOptions.get("reduceOnFullCompactionOnly"));
    assertEquals(
        "Required: The element converter class to be used for key/value conversion",
        namedOptions.get("accumulostore.key.element_converter"));
    assertEquals("Required: The json serialised form of the schema", namedOptions.get("Schema"));
    assertEquals(
        "set to true to apply Combiner to every column, otherwise leave blank. if true, columns option will be"
            + " ignored.",
        namedOptions.get("all"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test new {@link AggregatorIterator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AggregatorIterator}
   */
  @Test
  @DisplayName("Test new AggregatorIterator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AggregatorIterator.<init>()"})
  void testNewAggregatorIterator() {
    // Arrange, Act and Assert
    IteratorOptions describeOptionsResult = new AggregatorIterator().describeOptions();
    Map<String, String> namedOptions = describeOptionsResult.getNamedOptions();
    assertEquals(5, namedOptions.size());
    assertEquals(
        "<col fam>[:<col qual>]{,<col fam>[:<col qual>]} escape non-alphanum chars using %<hex>.",
        namedOptions.get("columns"));
    assertEquals("Aggregator", describeOptionsResult.getName());
    assertEquals(
        "Applies a reduce function to elements with identical (rowKey, column family, column qualifier,"
            + " visibility)",
        describeOptionsResult.getDescription());
    assertEquals(
        "If true, only reduce on full major compactions.  Defaults to false. ",
        namedOptions.get("reduceOnFullCompactionOnly"));
    assertEquals("Required: The json serialised form of the schema", namedOptions.get("Schema"));
    assertEquals(
        "set to true to apply Combiner to every column, otherwise leave blank. if true, columns option will be"
            + " ignored.",
        namedOptions.get("all"));
    assertNull(describeOptionsResult.getUnnamedOptionDescriptions());
  }
}
