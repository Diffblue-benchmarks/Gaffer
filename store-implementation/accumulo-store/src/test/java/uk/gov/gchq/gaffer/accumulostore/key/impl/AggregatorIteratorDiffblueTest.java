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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
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
   * <ul>
   *   <li>Given {@link Value#Value()}.</li>
   *   <li>When {@link Key#Key()}.</li>
   *   <li>Then not {@link ArrayList#ArrayList()} iterator hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggregatorIterator#reduce(Key, Iterator)}
   */
  @Test
  @DisplayName("Test reduce(Key, Iterator); given Value(); when Key(); then not ArrayList() iterator hasNext")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link AggregatorIterator#describeOptions()}.
   * <p>
   * Method under test: {@link AggregatorIterator#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IteratorOptions AggregatorIterator.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult = (new AggregatorIterator()).describeOptions();

    // Assert
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(5, namedOptions.size());
    assertEquals("<col fam>[:<col qual>]{,<col fam>[:<col qual>]} escape non-alphanum chars using %<hex>.",
        namedOptions.get("columns"));
    assertEquals("Aggregator", actualDescribeOptionsResult.getName());
    assertEquals("Applies a reduce function to elements with identical (rowKey, column family, column qualifier,"
        + " visibility)", actualDescribeOptionsResult.getDescription());
    assertEquals("If true, only reduce on full major compactions.  Defaults to false. ",
        namedOptions.get("reduceOnFullCompactionOnly"));
    assertEquals("Required: The element converter class to be used for key/value conversion",
        namedOptions.get("accumulostore.key.element_converter"));
    assertEquals("Required: The json serialised form of the schema", namedOptions.get("Schema"));
    assertEquals("set to true to apply Combiner to every column, otherwise leave blank. if true, columns option will be"
        + " ignored.", namedOptions.get("all"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test new {@link AggregatorIterator} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AggregatorIterator}
   */
  @Test
  @DisplayName("Test new AggregatorIterator (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AggregatorIterator.<init>()"})
  void testNewAggregatorIterator() {
    // Arrange, Act and Assert
    IteratorOptions describeOptionsResult = (new AggregatorIterator()).describeOptions();
    Map<String, String> namedOptions = describeOptionsResult.getNamedOptions();
    assertEquals(5, namedOptions.size());
    assertEquals("<col fam>[:<col qual>]{,<col fam>[:<col qual>]} escape non-alphanum chars using %<hex>.",
        namedOptions.get("columns"));
    assertEquals("Aggregator", describeOptionsResult.getName());
    assertEquals("Applies a reduce function to elements with identical (rowKey, column family, column qualifier,"
        + " visibility)", describeOptionsResult.getDescription());
    assertEquals("If true, only reduce on full major compactions.  Defaults to false. ",
        namedOptions.get("reduceOnFullCompactionOnly"));
    assertEquals("Required: The json serialised form of the schema", namedOptions.get("Schema"));
    assertEquals("set to true to apply Combiner to every column, otherwise leave blank. if true, columns option will be"
        + " ignored.", namedOptions.get("all"));
    assertNull(describeOptionsResult.getUnnamedOptionDescriptions());
  }
}
