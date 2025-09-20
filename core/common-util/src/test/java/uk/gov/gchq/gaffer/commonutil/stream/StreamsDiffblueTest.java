package uk.gov.gchq.gaffer.commonutil.stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterator;

class StreamsDiffblueTest {
  /**
   * Test {@link Streams#toStream(Object[])} with {@code array}.
   *
   * <p>Method under test: {@link Streams#toStream(Object[])}
   */
  @Test
  @DisplayName("Test toStream(Object[]) with 'array'")
  @Tag("MaintainedByDiffblue")
  void testToStreamWithArray() {
    // Arrange and Act
    Stream<Object> actualToStreamResult = Streams.toStream("Array");

    // Assert
    List<Object> collectResult = actualToStreamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("Array", collectResult.get(0));
  }

  /**
   * Test {@link Streams#toStream(Iterable)} with {@code iterable}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} stream.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link Streams#toStream(Iterable)}
   */
  @Test
  @DisplayName(
      "Test toStream(Iterable) with 'iterable'; given ArrayList() stream; then calls get()")
  @Tag("MaintainedByDiffblue")
  void testToStreamWithIterable_givenArrayListStream_thenCallsGet() {
    // Arrange
    Supplier<Stream<Object>> streamSupplier = mock(Supplier.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act
    Streams.toStream(new StreamIterable<>(streamSupplier));

    // Assert
    verify(streamSupplier).get();
  }

  /**
   * Test {@link Streams#toStream(Iterable)} with {@code iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link Streams#toStream(Iterable)}
   */
  @Test
  @DisplayName(
      "Test toStream(Iterable) with 'iterable'; when ArrayList(); then return limit five collect toList Empty")
  @Tag("MaintainedByDiffblue")
  void testToStreamWithIterable_whenArrayList_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Object> actualToStreamResult = Streams.toStream(new ArrayList<>());

    // Assert
    assertTrue(actualToStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Streams#toStream(Iterator)} with {@code iterator}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} iterator.
   * </ul>
   *
   * <p>Method under test: {@link Streams#toStream(Iterator)}
   */
  @Test
  @DisplayName("Test toStream(Iterator) with 'iterator'; when ArrayList() iterator")
  @Tag("MaintainedByDiffblue")
  void testToStreamWithIterator_whenArrayListIterator() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    Stream<Object> actualToStreamResult = Streams.toStream(objectList.iterator());

    // Assert
    assertTrue(actualToStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Streams#toStream(Iterator)} with {@code iterator}.
   *
   * <ul>
   *   <li>When {@link StreamIterator#StreamIterator()}.
   * </ul>
   *
   * <p>Method under test: {@link Streams#toStream(Iterator)}
   */
  @Test
  @DisplayName("Test toStream(Iterator) with 'iterator'; when StreamIterator()")
  @Tag("MaintainedByDiffblue")
  void testToStreamWithIterator_whenStreamIterator() {
    // Arrange and Act
    Stream<Object> actualToStreamResult = Streams.toStream(new StreamIterator<>());

    // Assert
    assertTrue(actualToStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Streams#toParallelStream(Object[])} with {@code array}.
   *
   * <p>Method under test: {@link Streams#toParallelStream(Object[])}
   */
  @Test
  @DisplayName("Test toParallelStream(Object[]) with 'array'")
  @Tag("MaintainedByDiffblue")
  void testToParallelStreamWithArray() {
    // Arrange and Act
    Stream<Object> actualToParallelStreamResult = Streams.toParallelStream("Array");

    // Assert
    List<Object> collectResult = actualToParallelStreamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("Array", collectResult.get(0));
  }

  /**
   * Test {@link Streams#toParallelStream(Iterable)} with {@code iterable}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} stream.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link Streams#toParallelStream(Iterable)}
   */
  @Test
  @DisplayName(
      "Test toParallelStream(Iterable) with 'iterable'; given ArrayList() stream; then calls get()")
  @Tag("MaintainedByDiffblue")
  void testToParallelStreamWithIterable_givenArrayListStream_thenCallsGet() {
    // Arrange
    Supplier<Stream<Object>> streamSupplier = mock(Supplier.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act
    Streams.toParallelStream(new StreamIterable<>(streamSupplier));

    // Assert
    verify(streamSupplier).get();
  }

  /**
   * Test {@link Streams#toParallelStream(Iterable)} with {@code iterable}.
   *
   * <ul>
   *   <li>Then return limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link Streams#toParallelStream(Iterable)}
   */
  @Test
  @DisplayName(
      "Test toParallelStream(Iterable) with 'iterable'; then return limit five collect toList Empty")
  @Tag("MaintainedByDiffblue")
  void testToParallelStreamWithIterable_thenReturnLimitFiveCollectToListEmpty() {
    // Arrange and Act
    Stream<Object> actualToParallelStreamResult = Streams.toParallelStream(new ArrayList<>());

    // Assert
    assertTrue(actualToParallelStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Streams#toParallelStream(Iterator)} with {@code iterator}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} iterator.
   * </ul>
   *
   * <p>Method under test: {@link Streams#toParallelStream(Iterator)}
   */
  @Test
  @DisplayName("Test toParallelStream(Iterator) with 'iterator'; when ArrayList() iterator")
  @Tag("MaintainedByDiffblue")
  void testToParallelStreamWithIterator_whenArrayListIterator() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    Stream<Object> actualToParallelStreamResult = Streams.toParallelStream(objectList.iterator());

    // Assert
    assertTrue(actualToParallelStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Streams#toParallelStream(Iterator)} with {@code iterator}.
   *
   * <ul>
   *   <li>When {@link StreamIterator#StreamIterator()}.
   * </ul>
   *
   * <p>Method under test: {@link Streams#toParallelStream(Iterator)}
   */
  @Test
  @DisplayName("Test toParallelStream(Iterator) with 'iterator'; when StreamIterator()")
  @Tag("MaintainedByDiffblue")
  void testToParallelStreamWithIterator_whenStreamIterator() {
    // Arrange and Act
    Stream<Object> actualToParallelStreamResult = Streams.toParallelStream(new StreamIterator<>());

    // Assert
    assertTrue(actualToParallelStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link Streams#toBatches(Iterable, int)}.
   *
   * <p>Method under test: {@link Streams#toBatches(Iterable, int)}
   */
  @Test
  @DisplayName("Test toBatches(Iterable, int)")
  @Tag("MaintainedByDiffblue")
  void testToBatches() {
    // Arrange and Act
    Stream<List<Object>> actualToBatchesResult = Streams.toBatches(new ArrayList<>(), 3);

    // Assert
    assertTrue(actualToBatchesResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
