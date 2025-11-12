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

package uk.gov.gchq.gaffer.commonutil.pair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class PairDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Pair#equals(Object)}
   *   <li>{@link Pair#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>();
    Pair<Object, Object> pair2 = new Pair<>();

    // Act and Assert
    assertEquals(pair, pair2);
    int expectedHashCodeResult = pair.hashCode();
    assertEquals(expectedHashCodeResult, pair2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Pair#equals(Object)}
   *   <li>{@link Pair#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>();

    // Act and Assert
    assertEquals(pair, pair);
    int expectedHashCodeResult = pair.hashCode();
    assertEquals(expectedHashCodeResult, pair.hashCode());
  }

  /**
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>();
    pair.setFirst("First");

    // Act and Assert
    assertNotEquals(pair, new Pair<>());
  }

  /**
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>();

    // Act and Assert
    assertNotEquals(pair, null);
  }

  /**
   * Method under test: {@link Pair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Pair<Object, Object> pair = new Pair<>();

    // Act and Assert
    assertNotEquals(pair, "Different type to Pair");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Pair#Pair()}
   *   <li>{@link Pair#setFirst(Object)}
   *   <li>{@link Pair#setSecond(Object)}
   *   <li>{@link Pair#toString()}
   *   <li>{@link Pair#getFirst()}
   *   <li>{@link Pair#getSecond()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Pair<Object, Object> actualPair = new Pair<>();
    actualPair.setFirst("First");
    actualPair.setSecond("Second");
    String actualToStringResult = actualPair.toString();
    Object actualFirst = actualPair.getFirst();

    // Assert that nothing has changed
    assertEquals("First", actualFirst);
    assertEquals("Pair[first=First,second=Second]", actualToStringResult);
    assertEquals("Second", actualPair.getSecond());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Pair#Pair(Object)}
   *   <li>{@link Pair#setFirst(Object)}
   *   <li>{@link Pair#setSecond(Object)}
   *   <li>{@link Pair#toString()}
   *   <li>{@link Pair#getFirst()}
   *   <li>{@link Pair#getSecond()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    Pair<Object, Object> actualPair = new Pair<>("First");
    actualPair.setFirst("First");
    actualPair.setSecond("Second");
    String actualToStringResult = actualPair.toString();
    Object actualFirst = actualPair.getFirst();

    // Assert that nothing has changed
    assertEquals("First", actualFirst);
    assertEquals("Pair[first=First,second=Second]", actualToStringResult);
    assertEquals("Second", actualPair.getSecond());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Pair#Pair(Object, Object)}
   *   <li>{@link Pair#setFirst(Object)}
   *   <li>{@link Pair#setSecond(Object)}
   *   <li>{@link Pair#toString()}
   *   <li>{@link Pair#getFirst()}
   *   <li>{@link Pair#getSecond()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange and Act
    Pair<Object, Object> actualPair = new Pair<>("First", "Second");
    actualPair.setFirst("First");
    actualPair.setSecond("Second");
    String actualToStringResult = actualPair.toString();
    Object actualFirst = actualPair.getFirst();

    // Assert that nothing has changed
    assertEquals("First", actualFirst);
    assertEquals("Pair[first=First,second=Second]", actualToStringResult);
    assertEquals("Second", actualPair.getSecond());
  }
}
