package uk.gov.gchq.gaffer.commonutil.stream;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Comparator;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.LimitedInMemorySortedIterable;
import uk.gov.gchq.gaffer.commonutil.stream.GafferCollectors.GafferCollectorImpl;

class GafferCollectorsDiffblueTest {
  /**
   * Test GafferCollectorImpl {@link GafferCollectorImpl#characteristics()}.
   *
   * <p>Method under test: {@link GafferCollectorImpl#characteristics()}
   */
  @Test
  @DisplayName("Test GafferCollectorImpl characteristics()")
  @Tag("MaintainedByDiffblue")
  void testGafferCollectorImplCharacteristics() {
    // Arrange
    GafferCollectorImpl<Object, Object, Object> gafferCollectorImpl =
        new GafferCollectorImpl<>(
            mock(Supplier.class), mock(BiConsumer.class), mock(BinaryOperator.class));

    // Act and Assert
    assertTrue(gafferCollectorImpl.characteristics().isEmpty());
  }

  /**
   * Test GafferCollectorImpl getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GafferCollectorImpl#GafferCollectorImpl(Supplier, BiConsumer, BinaryOperator,
   *       Function)}
   *   <li>{@link GafferCollectorImpl#accumulator()}
   *   <li>{@link GafferCollectorImpl#combiner()}
   *   <li>{@link GafferCollectorImpl#finisher()}
   *   <li>{@link GafferCollectorImpl#supplier()}
   * </ul>
   */
  @Test
  @DisplayName("Test GafferCollectorImpl getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGafferCollectorImplGettersAndSetters() {
    // Arrange
    Supplier<Object> supplier = mock(Supplier.class);
    BiConsumer<Object, Object> accumulator = mock(BiConsumer.class);
    BinaryOperator<Object> combiner = mock(BinaryOperator.class);
    Function<Object, Object> finisher = mock(Function.class);

    // Act
    GafferCollectorImpl<Object, Object, Object> actualGafferCollectorImpl =
        new GafferCollectorImpl<>(supplier, accumulator, combiner, finisher);
    BiConsumer<Object, Object> actualAccumulatorResult = actualGafferCollectorImpl.accumulator();
    BinaryOperator<Object> actualCombinerResult = actualGafferCollectorImpl.combiner();
    Function<Object, Object> actualFinisherResult = actualGafferCollectorImpl.finisher();

    // Assert
    assertSame(accumulator, actualAccumulatorResult);
    assertSame(combiner, actualCombinerResult);
    assertSame(finisher, actualFinisherResult);
    assertSame(supplier, actualGafferCollectorImpl.supplier());
  }

  /**
   * Test GafferCollectorImpl {@link GafferCollectorImpl#GafferCollectorImpl(Supplier, BiConsumer,
   * BinaryOperator)}.
   *
   * <p>Method under test: {@link GafferCollectorImpl#GafferCollectorImpl(Supplier, BiConsumer,
   * BinaryOperator)}
   */
  @Test
  @DisplayName(
      "Test GafferCollectorImpl new GafferCollectorImpl(Supplier, BiConsumer, BinaryOperator)")
  @Tag("MaintainedByDiffblue")
  void testGafferCollectorImplNewGafferCollectorImpl() {
    // Arrange
    Supplier<Object> supplier = mock(Supplier.class);
    BiConsumer<Object, Object> accumulator = mock(BiConsumer.class);
    BinaryOperator<Object> combiner = mock(BinaryOperator.class);

    // Act
    GafferCollectorImpl<Object, Object, Object> actualGafferCollectorImpl =
        new GafferCollectorImpl<>(supplier, accumulator, combiner);

    // Assert
    assertTrue(actualGafferCollectorImpl.characteristics().isEmpty());
    assertSame(accumulator, actualGafferCollectorImpl.accumulator());
    assertSame(combiner, actualGafferCollectorImpl.combiner());
    assertSame(supplier, actualGafferCollectorImpl.supplier());
  }

  /**
   * Test {@link GafferCollectors#toLinkedHashSet()}.
   *
   * <p>Method under test: {@link GafferCollectors#toLinkedHashSet()}
   */
  @Test
  @DisplayName("Test toLinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  void testToLinkedHashSet() {
    // Arrange and Act
    Collector<Object, ?, Set<Object>> actualToLinkedHashSetResult =
        GafferCollectors.toLinkedHashSet();

    // Assert
    assertTrue(actualToLinkedHashSetResult instanceof GafferCollectorImpl);
    assertTrue(actualToLinkedHashSetResult.characteristics().isEmpty());
  }

  /**
   * Test {@link GafferCollectors#toLimitedInMemorySortedIterable(Comparator, Integer, boolean)}.
   *
   * <p>Method under test: {@link GafferCollectors#toLimitedInMemorySortedIterable(Comparator,
   * Integer, boolean)}
   */
  @Test
  @DisplayName("Test toLimitedInMemorySortedIterable(Comparator, Integer, boolean)")
  @Tag("MaintainedByDiffblue")
  void testToLimitedInMemorySortedIterable() {
    // Arrange and Act
    Collector<Object, LimitedInMemorySortedIterable<Object>, LimitedInMemorySortedIterable<Object>>
        actualToLimitedInMemorySortedIterableResult =
            GafferCollectors.toLimitedInMemorySortedIterable(mock(Comparator.class), 1, true);

    // Assert
    assertTrue(actualToLimitedInMemorySortedIterableResult instanceof GafferCollectorImpl);
    assertTrue(actualToLimitedInMemorySortedIterableResult.characteristics().isEmpty());
  }
}
