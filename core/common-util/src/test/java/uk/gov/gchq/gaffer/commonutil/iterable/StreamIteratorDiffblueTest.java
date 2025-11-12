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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class StreamIteratorDiffblueTest {
  /**
   * Method under test: {@link StreamIterator#hasNext()}
   */
  @Test
  void testHasNext() {
    // Arrange
    StreamIterator<Object> streamIterator = new StreamIterator<>();

    // Act and Assert
    assertFalse(streamIterator.hasNext());
  }

  /**
   * Method under test: {@link StreamIterator#hasNext()}
   */
  @Test
  void testHasNext2() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Stream<Object> stream = objectList.stream();
    StreamIterator<Object> streamIterator = new StreamIterator<>(stream);

    // Act and Assert
    assertTrue(streamIterator.hasNext());
  }

  /**
   * Method under test: {@link StreamIterator#next()}
   */
  @Test
  void testNext() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Stream<Object> stream = objectList.stream();
    StreamIterator<Object> streamIterator = new StreamIterator<>(stream);

    // Act and Assert
    assertEquals("42", streamIterator.next());
  }

  /**
   * Method under test: {@link StreamIterator#getStream()}
   */
  @Test
  void testGetStream() {
    // Arrange
    StreamIterator<Object> streamIterator = new StreamIterator<>();

    // Act
    Stream<Object> actualStream = streamIterator.getStream();

    // Assert
    assertTrue(actualStream.limit(5).collect(Collectors.toList()).isEmpty());
  }

  /**
   * Method under test: {@link StreamIterator#StreamIterator()}
   */
  @Test
  void testNewStreamIterator() {
    // Arrange and Act
    StreamIterator<Object> actualStreamIterator = new StreamIterator<>();

    // Assert
    assertFalse(actualStreamIterator.hasNext());
  }

  /**
   * Method under test: {@link StreamIterator#StreamIterator(Stream)}
   */
  @Test
  void testNewStreamIterator2() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> stream = objectList.stream();

    // Act
    StreamIterator<Object> actualStreamIterator = new StreamIterator<>(stream);

    // Assert
    assertFalse(actualStreamIterator.hasNext());
  }

  /**
   * Method under test: {@link StreamIterator#StreamIterator(Stream)}
   */
  @Test
  void testNewStreamIterator3() {
    // Arrange and Act
    StreamIterator<Object> actualStreamIterator = new StreamIterator<>(null);

    // Assert
    assertFalse(actualStreamIterator.hasNext());
  }
}
