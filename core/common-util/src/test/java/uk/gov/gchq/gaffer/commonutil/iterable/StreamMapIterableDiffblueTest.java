package uk.gov.gchq.gaffer.commonutil.iterable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StreamMapIterableDiffblueTest {
  /**
   * Test {@link StreamMapIterable#StreamMapIterable(Iterable, Function)}.
   *
   * <p>Method under test: {@link StreamMapIterable#StreamMapIterable(Iterable, Function)}
   */
  @Test
  @DisplayName("Test new StreamMapIterable(Iterable, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StreamMapIterable.<init>(Iterable, Function)"})
  void testNewStreamMapIterable() {
    // Arrange and Act
    StreamMapIterable<Object, Object> actualStreamMapIterable =
        new StreamMapIterable<>(new ArrayList<>(), mock(Function.class));

    // Assert
    Iterator<Object> iteratorResult = actualStreamMapIterable.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertFalse(iteratorResult.hasNext());
    Stream<Object> stream = actualStreamMapIterable.getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
