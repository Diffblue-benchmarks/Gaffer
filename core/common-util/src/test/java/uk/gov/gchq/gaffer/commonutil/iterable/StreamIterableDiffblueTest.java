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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.commonutil.stream.FlatMapStreamSupplier;
import uk.gov.gchq.gaffer.commonutil.stream.StreamSupplier;

class StreamIterableDiffblueTest {
  /**
   * Method under test: {@link StreamIterable#close()}
   */
  @Test
  void testClose() throws IOException {
    // Arrange
    FlatMapStreamSupplier<Object, Object> streamSupplier = mock(FlatMapStreamSupplier.class);
    doNothing().when(streamSupplier).close();
    try (StreamIterable<Object> streamIterable = new StreamIterable<>(streamSupplier)) {}

    // Act and Assert
    verify(streamSupplier).close();
  }

  /**
   * Method under test: {@link StreamIterable#iterator()}
   */
  @Test
  void testIterator() {
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
   * Method under test: {@link StreamIterable#getStream()}
   */
  @Test
  void testGetStream() {
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

  /**
   * Method under test: {@link StreamIterable#StreamIterable(Supplier)}
   */
  @Test
  void testNewStreamIterable() {
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
   * Method under test: {@link StreamIterable#StreamIterable(StreamSupplier)}
   */
  @Test
  void testNewStreamIterable2() {
    // Arrange and Act
    StreamIterable<Object> actualStreamIterable = new StreamIterable<>(
        new FlatMapStreamSupplier<>(new ArrayList<>(), mock(Function.class)));

    // Assert
    Iterator<Object> iteratorResult = actualStreamIterable.iterator();
    assertTrue(iteratorResult instanceof StreamIterator);
    assertFalse(iteratorResult.hasNext());
    Stream<Object> stream = actualStreamIterable.getStream();
    assertTrue(stream.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
