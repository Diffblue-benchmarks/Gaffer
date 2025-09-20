package uk.gov.gchq.gaffer.operation.impl.join.methods;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.koryphe.tuple.MapTuple;

class FullJoinDiffblueTest {
  /**
   * Test {@link FullJoin#joinFlattened(Object, List, String, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link FullJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinFlattened(Object, List, String, String); given '42'; when ArrayList() add '42'; then return size is two")
  @Tag("MaintainedByDiffblue")
  void testJoinFlattened_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    FullJoin fullJoin = new FullJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");
    matches.add("42");

    // Act
    List<MapTuple> actualJoinFlattenedResult =
        fullJoin.joinFlattened("Key", matches, "Key Name", "42");

    // Assert
    assertEquals(2, actualJoinFlattenedResult.size());
    MapTuple expectedGetResult = actualJoinFlattenedResult.get(0);
    assertEquals(expectedGetResult, actualJoinFlattenedResult.get(1));
  }

  /**
   * Test {@link FullJoin#joinFlattened(Object, List, String, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then first values return {@link Collection}.
   * </ul>
   *
   * <p>Method under test: {@link FullJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinFlattened(Object, List, String, String); when ArrayList(); then first values return Collection")
  @Tag("MaintainedByDiffblue")
  void testJoinFlattened_whenArrayList_thenFirstValuesReturnCollection() {
    // Arrange
    FullJoin fullJoin = new FullJoin();

    // Act
    List<MapTuple> actualJoinFlattenedResult =
        fullJoin.joinFlattened("Key", new ArrayList<>(), "Key Name", "42");

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
   * Test {@link FullJoin#joinAggregated(Object, List, String, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Values {@code 42} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FullJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinAggregated(Object, List, String, String); given '42'; when ArrayList() add '42'; then return Values '42' size is one")
  @Tag("MaintainedByDiffblue")
  void testJoinAggregated_given42_whenArrayListAdd42_thenReturnValues42SizeIsOne() {
    // Arrange
    FullJoin fullJoin = new FullJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");

    // Act
    MapTuple actualJoinAggregatedResult = fullJoin.joinAggregated("Key", matches, "Key Name", "42");

    // Assert
    Map values = actualJoinAggregatedResult.getValues();
    assertEquals(2, values.size());
    assertEquals("Key", values.get("Key Name"));
    Object getResult = values.get("42");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<String>) getResult).size());
    assertEquals("42", ((List<String>) getResult).get(0));
    assertSame(matches, getResult);
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

  /**
   * Test {@link FullJoin#joinAggregated(Object, List, String, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Values {@code 42} size is two.
   * </ul>
   *
   * <p>Method under test: {@link FullJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinAggregated(Object, List, String, String); given '42'; when ArrayList() add '42'; then return Values '42' size is two")
  @Tag("MaintainedByDiffblue")
  void testJoinAggregated_given42_whenArrayListAdd42_thenReturnValues42SizeIsTwo() {
    // Arrange
    FullJoin fullJoin = new FullJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");
    matches.add("42");

    // Act and Assert
    Map values = fullJoin.joinAggregated("Key", matches, "Key Name", "42").getValues();
    assertEquals(2, values.size());
    Object getResult = values.get("42");
    assertTrue(getResult instanceof List);
    assertEquals(2, ((List<String>) getResult).size());
    assertEquals("42", ((List<String>) getResult).get(0));
    assertEquals("42", ((List<String>) getResult).get(1));
    assertTrue(values.containsKey("Key Name"));
  }

  /**
   * Test {@link FullJoin#joinAggregated(Object, List, String, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Values {@code Key Name} is {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link FullJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinAggregated(Object, List, String, String); when ArrayList(); then return Values 'Key Name' is 'Key'")
  @Tag("MaintainedByDiffblue")
  void testJoinAggregated_whenArrayList_thenReturnValuesKeyNameIsKey() {
    // Arrange
    FullJoin fullJoin = new FullJoin();
    ArrayList<Object> matches = new ArrayList<>();

    // Act
    MapTuple actualJoinAggregatedResult = fullJoin.joinAggregated("Key", matches, "Key Name", "42");

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
