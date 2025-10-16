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

class InnerJoinDiffblueTest {
  /**
   * Test {@link InnerJoin#joinFlattened(Object, List, String, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link InnerJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinFlattened(Object, List, String, String); given '42'; when ArrayList() add '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InnerJoin.joinFlattened(Object, List, String, String)"})
  void testJoinFlattened_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
    // Arrange
    InnerJoin innerJoin = new InnerJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");

    // Act
    List<MapTuple> actualJoinFlattenedResult =
        innerJoin.joinFlattened("Key", matches, "Key Name", "42");

    // Assert
    assertEquals(1, actualJoinFlattenedResult.size());
    MapTuple getResult = actualJoinFlattenedResult.get(0);
    Map values = getResult.getValues();
    assertEquals(2, values.size());
    Object actualGetResult = values.get("Key Name");
    assertEquals("Key", actualGetResult);
    assertEquals("42", values.get("42"));
    Iterator<Object> iteratorResult = getResult.iterator();
    Object nextResult = iteratorResult.next();
    Object nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals("Key", nextResult);
    assertEquals("42", nextResult2);
    Iterable<Object> valuesResult = getResult.values();
    assertTrue(valuesResult instanceof Collection);
    assertEquals(2, ((Collection<Object>) valuesResult).size());
  }

  /**
   * Test {@link InnerJoin#joinFlattened(Object, List, String, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link InnerJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinFlattened(Object, List, String, String); given '42'; when ArrayList() add '42'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InnerJoin.joinFlattened(Object, List, String, String)"})
  void testJoinFlattened_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    InnerJoin innerJoin = new InnerJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");
    matches.add("42");

    // Act
    List<MapTuple> actualJoinFlattenedResult =
        innerJoin.joinFlattened("Key", matches, "Key Name", "42");

    // Assert
    assertEquals(2, actualJoinFlattenedResult.size());
    MapTuple expectedGetResult = actualJoinFlattenedResult.get(0);
    assertEquals(expectedGetResult, actualJoinFlattenedResult.get(1));
  }

  /**
   * Test {@link InnerJoin#joinFlattened(Object, List, String, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link InnerJoin#joinFlattened(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinFlattened(Object, List, String, String); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List InnerJoin.joinFlattened(Object, List, String, String)"})
  void testJoinFlattened_whenArrayList_thenReturnEmpty() {
    // Arrange
    InnerJoin innerJoin = new InnerJoin();

    // Act and Assert
    assertTrue(innerJoin.joinFlattened("Key", new ArrayList<>(), "Key Name", "42").isEmpty());
  }

  /**
   * Test {@link InnerJoin#joinAggregated(Object, List, String, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link InnerJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinAggregated(Object, List, String, String); given '42'; when ArrayList() add '42'; then return Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapTuple InnerJoin.joinAggregated(Object, List, String, String)"})
  void testJoinAggregated_given42_whenArrayListAdd42_thenReturnValuesSizeIsTwo() {
    // Arrange
    InnerJoin innerJoin = new InnerJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");
    matches.add("42");

    // Act
    MapTuple actualJoinAggregatedResult =
        innerJoin.joinAggregated("Key", matches, "Key Name", "42");

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

  /**
   * Test {@link InnerJoin#joinAggregated(Object, List, String, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then Values {@code 42} return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link InnerJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinAggregated(Object, List, String, String); given '42'; when ArrayList() add '42'; then Values '42' return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapTuple InnerJoin.joinAggregated(Object, List, String, String)"})
  void testJoinAggregated_given42_whenArrayListAdd42_thenValues42ReturnList() {
    // Arrange
    InnerJoin innerJoin = new InnerJoin();

    ArrayList<Object> matches = new ArrayList<>();
    matches.add("42");

    // Act
    MapTuple actualJoinAggregatedResult =
        innerJoin.joinAggregated("Key", matches, "Key Name", "42");

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
   * Test {@link InnerJoin#joinAggregated(Object, List, String, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link InnerJoin#joinAggregated(Object, List, String, String)}
   */
  @Test
  @DisplayName(
      "Test joinAggregated(Object, List, String, String); when ArrayList(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MapTuple InnerJoin.joinAggregated(Object, List, String, String)"})
  void testJoinAggregated_whenArrayList_thenReturnNull() {
    // Arrange
    InnerJoin innerJoin = new InnerJoin();

    // Act and Assert
    assertNull(innerJoin.joinAggregated("Key", new ArrayList<>(), "Key Name", "42"));
  }
}
