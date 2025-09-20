package uk.gov.gchq.gaffer.operation.impl.export.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.koryphe.iterable.LimitedIterable;
import uk.gov.gchq.koryphe.iterable.LimitedIterator;

class SetExporterDiffblueTest {
  /**
   * Test {@link SetExporter#add(String, Iterable)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link Iterable#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link SetExporter#add(String, Iterable)}
   */
  @Test
  @DisplayName("Test add(String, Iterable); given ArrayList() add '42'; then calls iterator()")
  @Tag("MaintainedByDiffblue")
  void testAdd_givenArrayListAdd42_thenCallsIterator() {
    // Arrange
    SetExporter setExporter = new SetExporter();

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");

    Iterable<Object> results = mock(Iterable.class);
    when(results.iterator()).thenReturn(objectList.iterator());

    // Act
    setExporter.add("Key", results);

    // Assert
    verify(results).iterator();
  }

  /**
   * Test {@link SetExporter#add(String, Iterable)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link Iterable#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link SetExporter#add(String, Iterable)}
   */
  @Test
  @DisplayName("Test add(String, Iterable); given ArrayList() iterator; then calls iterator()")
  @Tag("MaintainedByDiffblue")
  void testAdd_givenArrayListIterator_thenCallsIterator() {
    // Arrange
    SetExporter setExporter = new SetExporter();

    Iterable<Object> results = mock(Iterable.class);

    ArrayList<Object> objectList = new ArrayList<>();
    when(results.iterator()).thenReturn(objectList.iterator());

    // Act
    setExporter.add("Key", results);

    // Assert
    verify(results).iterator();
  }

  /**
   * Test {@link SetExporter#get(String, int, Integer)} with {@code key}, {@code start}, {@code
   * end}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>When three.
   *   <li>Then return Start is one.
   * </ul>
   *
   * <p>Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  @DisplayName(
      "Test get(String, int, Integer) with 'key', 'start', 'end'; given ArrayList() add '42'; when three; then return Start is one")
  @Tag("MaintainedByDiffblue")
  void testGetWithKeyStartEnd_givenArrayListAdd42_whenThree_thenReturnStartIsOne() {
    // Arrange
    ArrayList<Object> results = new ArrayList<>();
    results.add("42");

    SetExporter setExporter = new SetExporter();
    setExporter.add("Key", results);

    // Act
    Iterable<?> actualGetResult = setExporter.get("Key", 1, 3);
    Iterator<?> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertEquals(1, ((LimitedIterable<?>) actualGetResult).getStart());
    assertEquals(3, ((LimitedIterable<?>) actualGetResult).getEnd().intValue());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link SetExporter#get(String, int, Integer)} with {@code key}, {@code start}, {@code
   * end}.
   *
   * <ul>
   *   <li>Given {@link SetExporter} (default constructor) add {@code Key} and {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Start is one.
   * </ul>
   *
   * <p>Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  @DisplayName(
      "Test get(String, int, Integer) with 'key', 'start', 'end'; given SetExporter (default constructor) add 'Key' and ArrayList(); then return Start is one")
  @Tag("MaintainedByDiffblue")
  void testGetWithKeyStartEnd_givenSetExporterAddKeyAndArrayList_thenReturnStartIsOne() {
    // Arrange
    SetExporter setExporter = new SetExporter();
    setExporter.add("Key", new ArrayList<>());

    // Act
    Iterable<?> actualGetResult = setExporter.get("Key", 1, 3);
    Iterator<?> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertEquals(1, ((LimitedIterable<?>) actualGetResult).getStart());
    assertEquals(3, ((LimitedIterable<?>) actualGetResult).getEnd().intValue());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link SetExporter#get(String, int, Integer)} with {@code key}, {@code start}, {@code
   * end}.
   *
   * <ul>
   *   <li>Given {@link SetExporter} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return End is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  @DisplayName(
      "Test get(String, int, Integer) with 'key', 'start', 'end'; given SetExporter (default constructor); when 'null'; then return End is 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetWithKeyStartEnd_givenSetExporter_whenNull_thenReturnEndIsNull() {
    // Arrange and Act
    Iterable<?> actualGetResult = new SetExporter().get("Key", 1, null);
    Iterator<?> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertNull(((LimitedIterable<?>) actualGetResult).getEnd());
    assertEquals(1, ((LimitedIterable<?>) actualGetResult).getStart());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link SetExporter#get(String, int, Integer)} with {@code key}, {@code start}, {@code
   * end}.
   *
   * <ul>
   *   <li>Given {@link SetExporter} (default constructor).
   *   <li>When three.
   *   <li>Then return Start is one.
   * </ul>
   *
   * <p>Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  @DisplayName(
      "Test get(String, int, Integer) with 'key', 'start', 'end'; given SetExporter (default constructor); when three; then return Start is one")
  @Tag("MaintainedByDiffblue")
  void testGetWithKeyStartEnd_givenSetExporter_whenThree_thenReturnStartIsOne() {
    // Arrange and Act
    Iterable<?> actualGetResult = new SetExporter().get("Key", 1, 3);
    Iterator<?> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertEquals(1, ((LimitedIterable<?>) actualGetResult).getStart());
    assertEquals(3, ((LimitedIterable<?>) actualGetResult).getEnd().intValue());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link SetExporter#get(String, int, Integer)} with {@code key}, {@code start}, {@code
   * end}.
   *
   * <ul>
   *   <li>Given {@link SetExporter} (default constructor).
   *   <li>When zero.
   *   <li>Then return Start is zero.
   * </ul>
   *
   * <p>Method under test: {@link SetExporter#get(String, int, Integer)}
   */
  @Test
  @DisplayName(
      "Test get(String, int, Integer) with 'key', 'start', 'end'; given SetExporter (default constructor); when zero; then return Start is zero")
  @Tag("MaintainedByDiffblue")
  void testGetWithKeyStartEnd_givenSetExporter_whenZero_thenReturnStartIsZero() {
    // Arrange and Act
    Iterable<?> actualGetResult = new SetExporter().get("Key", 0, 3);
    Iterator<?> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertEquals(0, ((LimitedIterable<?>) actualGetResult).getStart());
    assertEquals(3, ((LimitedIterable<?>) actualGetResult).getEnd().intValue());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link SetExporter#get(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link SetExporter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SetExporter#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'key'; given SetExporter (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testGetWithKey_givenSetExporter() {
    // Arrange and Act
    Iterable<?> actualGetResult = new SetExporter().get("Key");
    Iterator<?> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertNull(((LimitedIterable<?>) actualGetResult).getEnd());
    assertEquals(0, ((LimitedIterable<?>) actualGetResult).getStart());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link SetExporter#get(String)} with {@code key}.
   *
   * <ul>
   *   <li>Given {@link SetExporter} (default constructor) add {@code Key} and {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SetExporter#get(String)}
   */
  @Test
  @DisplayName(
      "Test get(String) with 'key'; given SetExporter (default constructor) add 'Key' and ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testGetWithKey_givenSetExporterAddKeyAndArrayList() {
    // Arrange
    SetExporter setExporter = new SetExporter();
    setExporter.add("Key", new ArrayList<>());

    // Act
    Iterable<?> actualGetResult = setExporter.get("Key");
    Iterator<?> actualIteratorResult = actualGetResult.iterator();

    // Assert
    assertTrue(actualGetResult instanceof LimitedIterable);
    assertTrue(actualIteratorResult instanceof LimitedIterator);
    assertNull(((LimitedIterable<?>) actualGetResult).getEnd());
    assertEquals(0, ((LimitedIterable<?>) actualGetResult).getStart());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SetExporter}
   *   <li>{@link SetExporter#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("SetExporter[exports={}]", new SetExporter().toString());
  }
}
