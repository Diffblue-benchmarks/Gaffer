/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.operation.impl.join.methods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.koryphe.tuple.MapTuple;

class OuterJoinDiffblueTest {
  /**
   * Test {@link OuterJoin#joinFlattened(Object, List, String, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OuterJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinFlattened(Object, List, String, String); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OuterJoin.joinFlattened(Object, List, String, String)"})
  void testJoinFlattened_given42_whenArrayListAdd42_thenReturnEmpty() {
    // Arrange
    OuterJoin outerJoin = new OuterJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");

    // Act and Assert
    assertTrue(outerJoin.joinFlattened("Key", matches, "Key Name", "42").isEmpty());
  }

  /**
   * Test {@link OuterJoin#joinFlattened(Object, List, String, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link OuterJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinFlattened(Object, List, String, String); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OuterJoin.joinFlattened(Object, List, String, String)"})
  void testJoinFlattened_given42_whenArrayListAdd42_thenReturnEmpty2() {
    // Arrange
    OuterJoin outerJoin = new OuterJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");
    matches.add("42");

    // Act and Assert
    assertTrue(outerJoin.joinFlattened("Key", matches, "Key Name", "42").isEmpty());
  }

  /**
   * Test {@link OuterJoin#joinFlattened(Object, List, String, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link OuterJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinFlattened(Object, List, String, String); when ArrayList(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List OuterJoin.joinFlattened(Object, List, String, String)"})
  void testJoinFlattened_whenArrayList_thenReturnSizeIsOne() {
    // Arrange
    OuterJoin outerJoin = new OuterJoin();

    // Act
    List<MapTuple> actualJoinFlattenedResult =
        outerJoin.joinFlattened("Key", new ArrayList<>(), "Key Name", "42");

    // Assert
    assertEquals(1, actualJoinFlattenedResult.size());
    MapTuple getResult = actualJoinFlattenedResult.get(0);
    Iterable<Object> valuesResult = getResult.values();
    assertTrue(valuesResult instanceof Collection);
    Map values = getResult.getValues();
    assertEquals(2, values.size());
    assertEquals("Key", values.get("Key Name"));
    Iterator<Object> iteratorResult = getResult.iterator();
    assertEquals("Key", iteratorResult.next());
    assertNull(iteratorResult.next());
    assertNull(values.get("42"));
    assertEquals(2, ((Collection<Object>) valuesResult).size());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link OuterJoin#joinAggregated(Object, List, String, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OuterJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinAggregated(Object, List, String, String); given '42'; when ArrayList() add '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapTuple OuterJoin.joinAggregated(Object, List, String, String)"})
  void testJoinAggregated_given42_whenArrayListAdd42_thenReturnNull() {
    // Arrange
    OuterJoin outerJoin = new OuterJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");

    // Act and Assert
    assertNull(outerJoin.joinAggregated("Key", matches, "Key Name", "42"));
  }

  /**
   * Test {@link OuterJoin#joinAggregated(Object, List, String, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OuterJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinAggregated(Object, List, String, String); given '42'; when ArrayList() add '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapTuple OuterJoin.joinAggregated(Object, List, String, String)"})
  void testJoinAggregated_given42_whenArrayListAdd42_thenReturnNull2() {
    // Arrange
    OuterJoin outerJoin = new OuterJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");
    matches.add("42");

    // Act and Assert
    assertNull(outerJoin.joinAggregated("Key", matches, "Key Name", "42"));
  }

  /**
   * Test {@link OuterJoin#joinAggregated(Object, List, String, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link OuterJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinAggregated(Object, List, String, String); when ArrayList(); then return Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapTuple OuterJoin.joinAggregated(Object, List, String, String)"})
  void testJoinAggregated_whenArrayList_thenReturnValuesSizeIsTwo() {
    // Arrange
    OuterJoin outerJoin = new OuterJoin();
    ArrayList<Object> matches = new ArrayList<>();

    // Act
    MapTuple actualJoinAggregatedResult =
        outerJoin.joinAggregated("Key", matches, "Key Name", "42");

    // Assert
    Map values = actualJoinAggregatedResult.getValues();
    assertEquals(2, values.size());
    assertEquals("Key", values.get("Key Name"));
    assertSame(matches, values.get("42"));
    Iterator<Object> iteratorResult = actualJoinAggregatedResult.iterator();
    Object nextResult = iteratorResult.next();
    Object actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals("Key", nextResult);
    assertSame(matches, actualNextResult);
    Iterable<Object> valuesResult = actualJoinAggregatedResult.values();
    assertTrue(valuesResult instanceof Collection);
    assertEquals(2, ((Collection<Object>) valuesResult).size());
  }
}
