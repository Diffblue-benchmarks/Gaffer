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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.LimitedInMemorySortedIterable;

class GafferCollectorsDiffblueTest {
  /**
   * Method under test:
   * {@link GafferCollectors.GafferCollectorImpl#characteristics()}
   */
  @Test
  void testGafferCollectorImplCharacteristics() {
    // Arrange
    GafferCollectors.GafferCollectorImpl<Object, Object, Object> gafferCollectorImpl = new GafferCollectors.GafferCollectorImpl<>(
        mock(Supplier.class), mock(BiConsumer.class), mock(BinaryOperator.class));

    // Act and Assert
    assertTrue(gafferCollectorImpl.characteristics().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link GafferCollectors.GafferCollectorImpl#GafferCollectorImpl(Supplier, BiConsumer, BinaryOperator, Function)}
   *   <li>{@link GafferCollectors.GafferCollectorImpl#accumulator()}
   *   <li>{@link GafferCollectors.GafferCollectorImpl#combiner()}
   *   <li>{@link GafferCollectors.GafferCollectorImpl#finisher()}
   *   <li>{@link GafferCollectors.GafferCollectorImpl#supplier()}
   * </ul>
   */
  @Test
  void testGafferCollectorImplGettersAndSetters() {
    // Arrange
    Supplier<Object> supplier = mock(Supplier.class);
    BiConsumer<Object, Object> accumulator = mock(BiConsumer.class);
    BinaryOperator<Object> combiner = mock(BinaryOperator.class);
    Function<Object, Object> finisher = mock(Function.class);

    // Act
    GafferCollectors.GafferCollectorImpl<Object, Object, Object> actualGafferCollectorImpl = new GafferCollectors.GafferCollectorImpl<>(
        supplier, accumulator, combiner, finisher);
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
   * Method under test:
   * {@link GafferCollectors.GafferCollectorImpl#GafferCollectorImpl(Supplier, BiConsumer, BinaryOperator)}
   */
  @Test
  void testGafferCollectorImplNewGafferCollectorImpl() {
    // Arrange
    Supplier<Object> supplier = mock(Supplier.class);
    BiConsumer<Object, Object> accumulator = mock(BiConsumer.class);
    BinaryOperator<Object> combiner = mock(BinaryOperator.class);

    // Act
    GafferCollectors.GafferCollectorImpl<Object, Object, Object> actualGafferCollectorImpl = new GafferCollectors.GafferCollectorImpl<>(
        supplier, accumulator, combiner);

    // Assert
    assertTrue(actualGafferCollectorImpl.characteristics().isEmpty());
    assertSame(accumulator, actualGafferCollectorImpl.accumulator());
    assertSame(combiner, actualGafferCollectorImpl.combiner());
    assertSame(supplier, actualGafferCollectorImpl.supplier());
  }

  /**
   * Method under test: {@link GafferCollectors#toLinkedHashSet()}
   */
  @Test
  void testToLinkedHashSet() {
    // Arrange and Act
    Collector<Object, ?, Set<Object>> actualToLinkedHashSetResult = GafferCollectors.toLinkedHashSet();

    // Assert
    assertTrue(actualToLinkedHashSetResult instanceof GafferCollectors.GafferCollectorImpl);
    assertTrue(actualToLinkedHashSetResult.characteristics().isEmpty());
  }

  /**
   * Method under test:
   * {@link GafferCollectors#toLimitedInMemorySortedIterable(Comparator, Integer, boolean)}
   */
  @Test
  void testToLimitedInMemorySortedIterable() {
    // Arrange and Act
    Collector<Object, LimitedInMemorySortedIterable<Object>, LimitedInMemorySortedIterable<Object>> actualToLimitedInMemorySortedIterableResult = GafferCollectors
        .<Object>toLimitedInMemorySortedIterable(mock(Comparator.class), 1, true);

    // Assert
    assertTrue(actualToLimitedInMemorySortedIterableResult instanceof GafferCollectors.GafferCollectorImpl);
    assertTrue(actualToLimitedInMemorySortedIterableResult.characteristics().isEmpty());
  }
}
