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

package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.junit.jupiter.api.Test;

class OneOrMoreDiffblueTest {
  /**
   * Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  void testAdd() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act
    boolean actualAddResult = oneOrMore.add("Item");

    // Assert
    assertEquals(1, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddResult);
  }

  /**
   * Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  void testAdd2() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act and Assert
    assertFalse(oneOrMore.add("Item"));
  }

  /**
   * Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  void testAdd3() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();
    oneOrMore.add(42);

    // Act
    boolean actualAddResult = oneOrMore.add("Item");

    // Assert
    assertEquals(2, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddResult);
  }

  /**
   * Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  void testAdd4() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(false, "Item");

    // Act
    boolean actualAddResult = oneOrMore.add("Item");

    // Assert
    assertEquals(2, oneOrMore.size());
    assertTrue(actualAddResult);
  }

  /**
   * Method under test: {@link OneOrMore#add(Object)}
   */
  @Test
  void testAdd5() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");
    oneOrMore.add(42);

    // Act and Assert
    assertFalse(oneOrMore.add("Item"));
  }

  /**
   * Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  void testAddAll() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act
    boolean actualAddAllResult = oneOrMore.addAll(new ArrayList<>());

    // Assert
    assertEquals(0, oneOrMore.size());
    assertFalse(actualAddAllResult);
    assertTrue(oneOrMore.isEmpty());
  }

  /**
   * Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  void testAddAll2() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");

    // Act
    boolean actualAddAllResult = oneOrMore.addAll(items);

    // Assert
    assertEquals(1, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddAllResult);
  }

  /**
   * Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  void testAddAll3() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    ArrayList<Object> items = new ArrayList<>();
    items.add("42");
    items.add("42");

    // Act
    boolean actualAddAllResult = oneOrMore.addAll(items);

    // Assert
    assertEquals(1, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddAllResult);
  }

  /**
   * Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  void testAddAll4() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    ArrayList<Object> items = new ArrayList<>();
    items.add(2);
    items.add("42");

    // Act
    boolean actualAddAllResult = oneOrMore.addAll(items);

    // Assert
    assertEquals(2, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddAllResult);
  }

  /**
   * Method under test: {@link OneOrMore#addAll(Collection)}
   */
  @Test
  void testAddAll5() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    ArrayList<Object> items = new ArrayList<>();
    items.add(2);
    items.add("42");
    items.add("42");

    // Act
    boolean actualAddAllResult = oneOrMore.addAll(items);

    // Assert
    assertEquals(2, oneOrMore.size());
    assertFalse(oneOrMore.isEmpty());
    assertTrue(actualAddAllResult);
  }

  /**
   * Method under test: {@link OneOrMore#size()}
   */
  @Test
  void testSize() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertEquals(0, oneOrMore.size());
  }

  /**
   * Method under test: {@link OneOrMore#size()}
   */
  @Test
  void testSize2() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act and Assert
    assertEquals(1, oneOrMore.size());
  }

  /**
   * Method under test: {@link OneOrMore#size()}
   */
  @Test
  void testSize3() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");
    oneOrMore.add(42);

    // Act and Assert
    assertEquals(2, oneOrMore.size());
  }

  /**
   * Method under test: {@link OneOrMore#isEmpty()}
   */
  @Test
  void testIsEmpty() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertTrue(oneOrMore.isEmpty());
  }

  /**
   * Method under test: {@link OneOrMore#isEmpty()}
   */
  @Test
  void testIsEmpty2() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act and Assert
    assertFalse(oneOrMore.isEmpty());
  }

  /**
   * Method under test: {@link OneOrMore#isEmpty()}
   */
  @Test
  void testIsEmpty3() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");
    oneOrMore.add(42);

    // Act and Assert
    assertFalse(oneOrMore.isEmpty());
  }

  /**
   * Method under test: {@link OneOrMore#contains(Object)}
   */
  @Test
  void testContains() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertFalse(oneOrMore.contains("42"));
  }

  /**
   * Method under test: {@link OneOrMore#contains(Object)}
   */
  @Test
  void testContains2() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act and Assert
    assertFalse(oneOrMore.contains("42"));
  }

  /**
   * Method under test: {@link OneOrMore#contains(Object)}
   */
  @Test
  void testContains3() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();
    oneOrMore.add("42");

    // Act and Assert
    assertTrue(oneOrMore.contains("42"));
  }

  /**
   * Method under test: {@link OneOrMore#contains(Object)}
   */
  @Test
  void testContains4() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");
    oneOrMore.add(42);

    // Act and Assert
    assertFalse(oneOrMore.contains("42"));
  }

  /**
   * Method under test: {@link OneOrMore#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertFalse(oneOrMore.iterator().hasNext());
  }

  /**
   * Method under test: {@link OneOrMore#iterator()}
   */
  @Test
  void testIterator2() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>(true, "Item");

    // Act
    Iterator<Object> actualIteratorResult = oneOrMore.iterator();

    // Assert
    assertEquals("Item", actualIteratorResult.next());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OneOrMore#equals(Object)}
   *   <li>{@link OneOrMore#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();
    OneOrMore<Object> oneOrMore2 = new OneOrMore<>();

    // Act and Assert
    assertEquals(oneOrMore, oneOrMore2);
    int expectedHashCodeResult = oneOrMore.hashCode();
    assertEquals(expectedHashCodeResult, oneOrMore2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OneOrMore#equals(Object)}
   *   <li>{@link OneOrMore#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertEquals(oneOrMore, oneOrMore);
    int expectedHashCodeResult = oneOrMore.hashCode();
    assertEquals(expectedHashCodeResult, oneOrMore.hashCode());
  }

  /**
   * Method under test: {@link OneOrMore#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();
    oneOrMore.add("Item");

    // Act and Assert
    assertNotEquals(oneOrMore, new OneOrMore<>());
  }

  /**
   * Method under test: {@link OneOrMore#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertNotEquals(oneOrMore, null);
  }

  /**
   * Method under test: {@link OneOrMore#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertNotEquals(oneOrMore, "Different type to OneOrMore");
  }

  /**
   * Method under test: {@link OneOrMore#OneOrMore()}
   */
  @Test
  void testNewOneOrMore() {
    // Arrange and Act
    OneOrMore<Object> actualOneOrMore = new OneOrMore<>();

    // Assert
    assertEquals(0, actualOneOrMore.size());
    assertTrue(actualOneOrMore.isEmpty());
  }

  /**
   * Method under test: {@link OneOrMore#OneOrMore(boolean)}
   */
  @Test
  void testNewOneOrMore2() {
    // Arrange and Act
    OneOrMore<Object> actualOneOrMore = new OneOrMore<>(true);

    // Assert
    assertEquals(0, actualOneOrMore.size());
    assertTrue(actualOneOrMore.isEmpty());
  }

  /**
   * Method under test: {@link OneOrMore#OneOrMore(boolean)}
   */
  @Test
  void testNewOneOrMore3() {
    // Arrange and Act
    OneOrMore<Object> actualOneOrMore = new OneOrMore<>(false);

    // Assert
    assertEquals(0, actualOneOrMore.size());
    assertTrue(actualOneOrMore.isEmpty());
  }

  /**
   * Method under test: {@link OneOrMore#OneOrMore(boolean, Object)}
   */
  @Test
  void testNewOneOrMore4() {
    // Arrange and Act
    OneOrMore<Object> actualOneOrMore = new OneOrMore<>(true, "Item");

    // Assert
    assertEquals(1, actualOneOrMore.size());
    assertFalse(actualOneOrMore.isEmpty());
  }

  /**
   * Method under test: {@link OneOrMore#OneOrMore(boolean, Object)}
   */
  @Test
  void testNewOneOrMore5() {
    // Arrange and Act
    OneOrMore<Object> actualOneOrMore = new OneOrMore<>(false, "Item");

    // Assert
    assertEquals(1, actualOneOrMore.size());
    assertFalse(actualOneOrMore.isEmpty());
  }

  /**
   * Method under test: {@link OneOrMore#toString()}
   */
  @Test
  void testToString() {
    // Arrange
    OneOrMore<Object> oneOrMore = new OneOrMore<>();

    // Act and Assert
    assertEquals("OneOrMore[deduplicate=true]", oneOrMore.toString());
  }
}
