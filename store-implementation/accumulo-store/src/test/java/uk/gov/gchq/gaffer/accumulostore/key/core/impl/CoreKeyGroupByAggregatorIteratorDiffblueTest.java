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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator;

class CoreKeyGroupByAggregatorIteratorDiffblueTest {
  /**
   * Test {@link CoreKeyGroupByAggregatorIterator#reduce(String, Key, Iterator, Set,
   * ElementAggregator)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then not {@link ArrayList#ArrayList()} iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyGroupByAggregatorIterator#reduce(String, Key, Iterator,
   * Set, ElementAggregator)}
   */
  @Test
  @DisplayName(
      "Test reduce(String, Key, Iterator, Set, ElementAggregator); given '42'; when HashSet() add '42'; then not ArrayList() iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Properties CoreKeyGroupByAggregatorIterator.reduce(String, Key, Iterator, Set, ElementAggregator)"
  })
  void testReduce_given42_whenHashSetAdd42_thenNotArrayListIteratorHasNext() {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator =
        new CoreKeyGroupByAggregatorIterator();
    Key key = new Key();

    ArrayList<Properties> propertiesList = new ArrayList<>();
    Iterator<Properties> iter = propertiesList.iterator();

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("42");
    groupBy.add("foo");

    // Act
    Properties actualReduceResult =
        coreKeyGroupByAggregatorIterator.reduce(
            "Group", key, iter, groupBy, new ElementAggregator());

    // Assert
    assertFalse(iter.hasNext());
    assertTrue(actualReduceResult.isEmpty());
  }

  /**
   * Test {@link CoreKeyGroupByAggregatorIterator#reduce(String, Key, Iterator, Set,
   * ElementAggregator)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then not {@link ArrayList#ArrayList()} iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyGroupByAggregatorIterator#reduce(String, Key, Iterator,
   * Set, ElementAggregator)}
   */
  @Test
  @DisplayName(
      "Test reduce(String, Key, Iterator, Set, ElementAggregator); given 'foo'; when HashSet() add 'foo'; then not ArrayList() iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Properties CoreKeyGroupByAggregatorIterator.reduce(String, Key, Iterator, Set, ElementAggregator)"
  })
  void testReduce_givenFoo_whenHashSetAddFoo_thenNotArrayListIteratorHasNext() {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator =
        new CoreKeyGroupByAggregatorIterator();
    Key key = new Key();

    ArrayList<Properties> propertiesList = new ArrayList<>();
    Iterator<Properties> iter = propertiesList.iterator();

    HashSet<String> groupBy = new HashSet<>();
    groupBy.add("foo");

    // Act
    Properties actualReduceResult =
        coreKeyGroupByAggregatorIterator.reduce(
            "Group", key, iter, groupBy, new ElementAggregator());

    // Assert
    assertFalse(iter.hasNext());
    assertTrue(actualReduceResult.isEmpty());
  }

  /**
   * Test {@link CoreKeyGroupByAggregatorIterator#reduce(String, Key, Iterator, Set,
   * ElementAggregator)}.
   *
   * <ul>
   *   <li>Given {@link Properties#Properties()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Properties#Properties()}.
   *   <li>Then return {@link Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyGroupByAggregatorIterator#reduce(String, Key, Iterator,
   * Set, ElementAggregator)}
   */
  @Test
  @DisplayName(
      "Test reduce(String, Key, Iterator, Set, ElementAggregator); given Properties(); when ArrayList() add Properties(); then return Properties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Properties CoreKeyGroupByAggregatorIterator.reduce(String, Key, Iterator, Set, ElementAggregator)"
  })
  void testReduce_givenProperties_whenArrayListAddProperties_thenReturnProperties() {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator =
        new CoreKeyGroupByAggregatorIterator();
    Key key = new Key();

    ArrayList<Properties> propertiesList = new ArrayList<>();
    Properties properties = new Properties();
    propertiesList.add(properties);
    Iterator<Properties> iter = propertiesList.iterator();
    HashSet<String> groupBy = new HashSet<>();

    // Act
    Properties actualReduceResult =
        coreKeyGroupByAggregatorIterator.reduce(
            "Group", key, iter, groupBy, new ElementAggregator());

    // Assert
    assertFalse(iter.hasNext());
    assertTrue(actualReduceResult.isEmpty());
    assertSame(properties, actualReduceResult);
  }

  /**
   * Test {@link CoreKeyGroupByAggregatorIterator#reduce(String, Key, Iterator, Set,
   * ElementAggregator)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then not {@link ArrayList#ArrayList()} iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyGroupByAggregatorIterator#reduce(String, Key, Iterator,
   * Set, ElementAggregator)}
   */
  @Test
  @DisplayName(
      "Test reduce(String, Key, Iterator, Set, ElementAggregator); when HashSet(); then not ArrayList() iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Properties CoreKeyGroupByAggregatorIterator.reduce(String, Key, Iterator, Set, ElementAggregator)"
  })
  void testReduce_whenHashSet_thenNotArrayListIteratorHasNext() {
    // Arrange
    CoreKeyGroupByAggregatorIterator coreKeyGroupByAggregatorIterator =
        new CoreKeyGroupByAggregatorIterator();
    Key key = new Key();

    ArrayList<Properties> propertiesList = new ArrayList<>();
    Iterator<Properties> iter = propertiesList.iterator();
    HashSet<String> groupBy = new HashSet<>();

    // Act
    Properties actualReduceResult =
        coreKeyGroupByAggregatorIterator.reduce(
            "Group", key, iter, groupBy, new ElementAggregator());

    // Assert
    assertFalse(iter.hasNext());
    assertTrue(actualReduceResult.isEmpty());
  }

  /**
   * Test {@link CoreKeyGroupByAggregatorIterator#describeOptions()}.
   *
   * <p>Method under test: {@link CoreKeyGroupByAggregatorIterator#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorOptions CoreKeyGroupByAggregatorIterator.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult =
        new CoreKeyGroupByAggregatorIterator().describeOptions();

    // Assert
    assertEquals(
        "Applies a reduce function to a set of Properties with identical rowKey, column family and column"
            + " qualifier constants.",
        actualDescribeOptionsResult.getDescription());
    assertEquals("Column_Qualifier_Aggregator", actualDescribeOptionsResult.getName());
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(2, namedOptions.size());
    assertEquals(
        "Required: The element converter class to be used for key/value conversion",
        namedOptions.get("accumulostore.key.element_converter"));
    assertEquals("Required: The json serialised form of the schema", namedOptions.get("Schema"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test new {@link CoreKeyGroupByAggregatorIterator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * CoreKeyGroupByAggregatorIterator}
   */
  @Test
  @DisplayName("Test new CoreKeyGroupByAggregatorIterator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreKeyGroupByAggregatorIterator.<init>()"})
  void testNewCoreKeyGroupByAggregatorIterator() {
    // Arrange and Act
    CoreKeyGroupByAggregatorIterator actualCoreKeyGroupByAggregatorIterator =
        new CoreKeyGroupByAggregatorIterator();

    // Assert
    assertNull(actualCoreKeyGroupByAggregatorIterator.elementConverter);
    assertNull(actualCoreKeyGroupByAggregatorIterator.view);
    assertNull(actualCoreKeyGroupByAggregatorIterator.schema);
  }
}
