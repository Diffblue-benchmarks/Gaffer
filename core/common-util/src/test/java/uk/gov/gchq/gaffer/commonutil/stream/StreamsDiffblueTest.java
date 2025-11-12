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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterator;

class StreamsDiffblueTest {
  /**
   * Method under test: {@link Streams#toStream(Iterable)}
   */
  @Test
  void testToStream() {
    // Arrange and Act
    Stream<Object> actualToStreamResult = Streams.toStream(new ArrayList<>());

    // Assert
    assertTrue(actualToStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link Streams#toStream(Iterable)}
   */
  @Test
  void testToStream2() {
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
   * Method under test: {@link Streams#toStream(Iterator)}
   */
  @Test
  void testToStream3() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    Stream<Object> actualToStreamResult = Streams.toStream(objectList.iterator());

    // Assert
    assertTrue(actualToStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link Streams#toStream(Iterator)}
   */
  @Test
  void testToStream4() {
    // Arrange and Act
    Stream<Object> actualToStreamResult = Streams.toStream(new StreamIterator<>());

    // Assert
    assertTrue(actualToStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link Streams#toStream(Object[])}
   */
  @Test
  void testToStream5() {
    // Arrange and Act
    Stream<Object> actualToStreamResult = Streams.toStream("Array");

    // Assert
    List<Object> collectResult = actualToStreamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("Array", collectResult.get(0));
  }

  /**
   * Method under test: {@link Streams#toParallelStream(Iterable)}
   */
  @Test
  void testToParallelStream() {
    // Arrange and Act
    Stream<Object> actualToParallelStreamResult = Streams.toParallelStream(new ArrayList<>());

    // Assert
    assertTrue(actualToParallelStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link Streams#toParallelStream(Iterable)}
   */
  @Test
  void testToParallelStream2() {
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
   * Method under test: {@link Streams#toParallelStream(Iterator)}
   */
  @Test
  void testToParallelStream3() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    Stream<Object> actualToParallelStreamResult = Streams.toParallelStream(objectList.iterator());

    // Assert
    assertTrue(actualToParallelStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link Streams#toParallelStream(Iterator)}
   */
  @Test
  void testToParallelStream4() {
    // Arrange and Act
    Stream<Object> actualToParallelStreamResult = Streams.toParallelStream(new StreamIterator<>());

    // Assert
    assertTrue(actualToParallelStreamResult.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link Streams#toParallelStream(Object[])}
   */
  @Test
  void testToParallelStream5() {
    // Arrange and Act
    Stream<Object> actualToParallelStreamResult = Streams.toParallelStream("Array");

    // Assert
    List<Object> collectResult = actualToParallelStreamResult.limit(5).collect(Collectors.toList());
    assertEquals(1, collectResult.size());
    assertEquals("Array", collectResult.get(0));
  }

  /**
   * Method under test: {@link Streams#toBatches(Iterable, int)}
   */
  @Test
  void testToBatches() {
    // Arrange and Act
    Stream<List<Object>> actualToBatchesResult = Streams.toBatches(new ArrayList<>(), 3);

    // Assert
    assertTrue(actualToBatchesResult.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
