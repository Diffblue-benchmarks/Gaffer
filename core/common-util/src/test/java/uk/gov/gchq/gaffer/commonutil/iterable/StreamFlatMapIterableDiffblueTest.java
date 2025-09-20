package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StreamFlatMapIterableDiffblueTest {
  /**
   * Test {@link StreamFlatMapIterable#StreamFlatMapIterable(Iterable, Function)}.
   *
   * <p>Method under test: {@link StreamFlatMapIterable#StreamFlatMapIterable(Iterable, Function)}
   */
  @Test
  @DisplayName("Test new StreamFlatMapIterable(Iterable, Function)")
  @Tag("MaintainedByDiffblue")
  void testNewStreamFlatMapIterable() {
    // Arrange and Act
    StreamFlatMapIterable<Object, Object> actualStreamFlatMapIterable =
        new StreamFlatMapIterable<>(new ArrayList<>(), mock(Function.class));

    // Assert
    Iterator<Object> iteratorResult = actualStreamFlatMapIterable.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertFalse(iteratorResult.hasNext());
    Stream<Object> stream = actualStreamFlatMapIterable.getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
