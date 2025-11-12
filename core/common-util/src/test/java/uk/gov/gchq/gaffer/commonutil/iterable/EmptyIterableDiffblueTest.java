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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

class EmptyIterableDiffblueTest {
  /**
   * Method under test: {@link EmptyIterable#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act
    Iterator<Object> actualIteratorResult = emptyIterable.iterator();

    // Assert
    assertTrue(actualIteratorResult instanceof EmptyIterator);
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EmptyIterable#equals(Object)}
   *   <li>{@link EmptyIterable#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();
    EmptyIterable<Object> emptyIterable2 = new EmptyIterable<>();

    // Act and Assert
    assertEquals(emptyIterable, emptyIterable2);
    int expectedHashCodeResult = emptyIterable.hashCode();
    assertEquals(expectedHashCodeResult, emptyIterable2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EmptyIterable#equals(Object)}
   *   <li>{@link EmptyIterable#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act and Assert
    assertEquals(emptyIterable, emptyIterable);
    int expectedHashCodeResult = emptyIterable.hashCode();
    assertEquals(expectedHashCodeResult, emptyIterable.hashCode());
  }

  /**
   * Method under test: {@link EmptyIterable#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act and Assert
    assertNotEquals(emptyIterable, "Obj");
  }

  /**
   * Method under test: {@link EmptyIterable#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act and Assert
    assertNotEquals(emptyIterable, null);
  }

  /**
   * Method under test: {@link EmptyIterable#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act and Assert
    assertNotEquals(emptyIterable, "Different type to EmptyIterable");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmptyIterable}
   *   <li>{@link EmptyIterable#close()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EmptyIterable<Object> actualEmptyIterable = new EmptyIterable<>();
    actualEmptyIterable.close();

    // Assert that nothing has changed
    Iterator<Object> iteratorResult = actualEmptyIterable.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
  }
}
