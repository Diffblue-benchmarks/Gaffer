package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.stream.FlatMapStreamSupplier;
import uk.gov.gchq.gaffer.commonutil.stream.StreamSupplier;

class StreamIterableDiffblueTest {
  /**
   * Test {@link StreamIterable#StreamIterable(StreamSupplier)}.
   *
   * <ul>
   *   <li>Then return Stream limit five collect toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link StreamIterable#StreamIterable(StreamSupplier)}
   */
  @Test
  @DisplayName(
      "Test new StreamIterable(StreamSupplier); then return Stream limit five collect toList Empty")
  @Tag("MaintainedByDiffblue")
  void testNewStreamIterable_thenReturnStreamLimitFiveCollectToListEmpty() {
    // Arrange
    FlatMapStreamSupplier<Object, Object> streamSupplier =
        new FlatMapStreamSupplier<>(new ArrayList<>(), mock(Function.class));

    // Act
    StreamIterable<Object> actualStreamIterable = new StreamIterable<>(streamSupplier);

    // Assert
    Iterator<Object> iteratorResult = actualStreamIterable.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertFalse(iteratorResult.hasNext());
    Stream<Object> stream = actualStreamIterable.getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Test {@link StreamIterable#StreamIterable(Supplier)}.
   *
   * <ul>
   *   <li>When {@link Supplier}.
   *   <li>Then return Stream is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link StreamIterable#StreamIterable(Supplier)}
   */
  @Test
  @DisplayName("Test new StreamIterable(Supplier); when Supplier; then return Stream is 'null'")
  @Tag("MaintainedByDiffblue")
  void testNewStreamIterable_whenSupplier_thenReturnStreamIsNull() {
    // Arrange and Act
    StreamIterable<Object> actualStreamIterable = new StreamIterable<>(mock(Supplier.class));

    // Assert
    Iterator<Object> iteratorResult = actualStreamIterable.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    Stream<Object> actualStream = actualStreamIterable.getStream();
    assertNull(actualStream);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link StreamIterable#close()}.
   *
   * <ul>
   *   <li>Given {@link StreamSupplier} {@link StreamSupplier#close()} does nothing.
   *   <li>Then calls {@link StreamSupplier#close()}.
   * </ul>
   *
   * <p>Method under test: {@link StreamIterable#close()}
   */
  @Test
  @DisplayName("Test close(); given StreamSupplier close() does nothing; then calls close()")
  @Tag("MaintainedByDiffblue")
  void testClose_givenStreamSupplierCloseDoesNothing_thenCallsClose() throws IOException {
    // Arrange
    StreamSupplier<Object> streamSupplier = mock(StreamSupplier.class);
    doNothing().when(streamSupplier).close();
    try (StreamIterable<Object> streamIterable = new StreamIterable<>(streamSupplier)) {}

    // Act and Assert
    verify(streamSupplier).close();
  }

  /**
   * Test {@link StreamIterable#iterator()}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} return {@link ArrayList#ArrayList()}
   *       stream.
   *   <li>Then return {@link StreamIterator}.
   * </ul>
   *
   * <p>Method under test: {@link StreamIterable#iterator()}
   */
  @Test
  @DisplayName(
      "Test iterator(); given Supplier get() return ArrayList() stream; then return StreamIterator")
  @Tag("MaintainedByDiffblue")
  void testIterator_givenSupplierGetReturnArrayListStream_thenReturnStreamIterator() {
    // Arrange
    Supplier<Stream<Object>> streamSupplier = mock(Supplier.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(streamSupplier.get()).thenReturn(streamResult);
    StreamIterable<Object> streamIterable = new StreamIterable<>(streamSupplier);

    // Act
    Iterator<Object> actualIteratorResult = streamIterable.iterator();

    // Assert
    verify(streamSupplier).get();
    assertTrue(actualIteratorResult instanceof StreamIterator);
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link StreamIterable#getStream()}.
   *
   * <ul>
   *   <li>Given {@link Supplier} {@link Supplier#get()} return {@link ArrayList#ArrayList()}
   *       stream.
   *   <li>Then calls {@link Supplier#get()}.
   * </ul>
   *
   * <p>Method under test: {@link StreamIterable#getStream()}
   */
  @Test
  @DisplayName("Test getStream(); given Supplier get() return ArrayList() stream; then calls get()")
  @Tag("MaintainedByDiffblue")
  void testGetStream_givenSupplierGetReturnArrayListStream_thenCallsGet() {
    // Arrange
    Supplier<Stream<Object>> streamSupplier = mock(Supplier.class);

    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> streamResult = objectList.stream();
    when(streamSupplier.get()).thenReturn(streamResult);
    StreamIterable<Object> streamIterable = new StreamIterable<>(streamSupplier);

    // Act
    streamIterable.getStream();

    // Assert
    verify(streamSupplier).get();
  }
}
