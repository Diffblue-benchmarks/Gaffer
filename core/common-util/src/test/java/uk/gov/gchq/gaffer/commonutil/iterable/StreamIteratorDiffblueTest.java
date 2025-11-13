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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StreamIteratorDiffblueTest {
  /**
   * Test {@link StreamIterator#StreamIterator()}.
   * <p>
   * Method under test: {@link StreamIterator#StreamIterator()}
   */
  @Test
  @DisplayName("Test new StreamIterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StreamIterator.<init>()"})
  void testNewStreamIterator() {
    // Arrange and Act
    StreamIterator<Object> actualStreamIterator = new StreamIterator<>();

    // Assert
    assertFalse(actualStreamIterator.hasNext());
  }

  /**
   * Test {@link StreamIterator#StreamIterator(Stream)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} stream.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamIterator#StreamIterator(Stream)}
   */
  @Test
  @DisplayName("Test new StreamIterator(Stream); when ArrayList() stream")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StreamIterator.<init>(Stream)"})
  void testNewStreamIterator_whenArrayListStream() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    Stream<Object> stream = objectList.stream();

    // Act
    StreamIterator<Object> actualStreamIterator = new StreamIterator<>(stream);

    // Assert
    assertFalse(actualStreamIterator.hasNext());
  }

  /**
   * Test {@link StreamIterator#StreamIterator(Stream)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamIterator#StreamIterator(Stream)}
   */
  @Test
  @DisplayName("Test new StreamIterator(Stream); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StreamIterator.<init>(Stream)"})
  void testNewStreamIterator_whenNull() {
    // Arrange and Act
    StreamIterator<Object> actualStreamIterator = new StreamIterator<>(null);

    // Assert
    assertFalse(actualStreamIterator.hasNext());
  }

  /**
   * Test {@link StreamIterator#hasNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamIterator#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); given ArrayList() add '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StreamIterator.hasNext()"})
  void testHasNext_givenArrayListAdd42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Stream<Object> stream = objectList.stream();
    StreamIterator<Object> streamIterator = new StreamIterator<>(stream);

    // Act and Assert
    assertTrue(streamIterator.hasNext());
  }

  /**
   * Test {@link StreamIterator#hasNext()}.
   * <ul>
   *   <li>Given {@link StreamIterator#StreamIterator()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamIterator#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); given StreamIterator(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StreamIterator.hasNext()"})
  void testHasNext_givenStreamIterator_thenReturnFalse() {
    // Arrange
    StreamIterator<Object> streamIterator = new StreamIterator<>();

    // Act and Assert
    assertFalse(streamIterator.hasNext());
  }

  /**
   * Test {@link StreamIterator#next()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StreamIterator#next()}
   */
  @Test
  @DisplayName("Test next(); given ArrayList() add '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object StreamIterator.next()"})
  void testNext_givenArrayListAdd42_thenReturn42() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add("42");
    Stream<Object> stream = objectList.stream();
    StreamIterator<Object> streamIterator = new StreamIterator<>(stream);

    // Act and Assert
    assertEquals("42", streamIterator.next());
  }

  /**
   * Test {@link StreamIterator#getStream()}.
   * <p>
   * Method under test: {@link StreamIterator#getStream()}
   */
  @Test
  @DisplayName("Test getStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Stream StreamIterator.getStream()"})
  void testGetStream() {
    // Arrange
    StreamIterator<Object> streamIterator = new StreamIterator<>();

    // Act
    Stream<Object> actualStream = streamIterator.getStream();

    // Assert
    assertTrue(actualStream.limit(5).collect(Collectors.toList()).isEmpty());
  }
}
