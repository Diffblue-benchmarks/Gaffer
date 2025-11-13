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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EmptyIterableDiffblueTest {
  /**
   * Test {@link EmptyIterable#iterator()}.
   *
   * <p>Method under test: {@link EmptyIterable#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator EmptyIterable.iterator()"})
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
   * Test {@link EmptyIterable#equals(Object)}, and {@link EmptyIterable#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmptyIterable#equals(Object)}
   *   <li>{@link EmptyIterable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmptyIterable.equals(Object)", "int EmptyIterable.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();
    EmptyIterable<Object> emptyIterable2 = new EmptyIterable<>();

    // Act and Assert
    assertEquals(emptyIterable, emptyIterable2);
    assertEquals(emptyIterable.hashCode(), emptyIterable2.hashCode());
  }

  /**
   * Test {@link EmptyIterable#equals(Object)}, and {@link EmptyIterable#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmptyIterable#equals(Object)}
   *   <li>{@link EmptyIterable#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmptyIterable.equals(Object)", "int EmptyIterable.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act and Assert
    assertEquals(emptyIterable, emptyIterable);
    int expectedHashCodeResult = emptyIterable.hashCode();
    assertEquals(expectedHashCodeResult, emptyIterable.hashCode());
  }

  /**
   * Test {@link EmptyIterable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmptyIterable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmptyIterable.equals(Object)", "int EmptyIterable.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act and Assert
    assertNotEquals(emptyIterable, "Obj");
  }

  /**
   * Test {@link EmptyIterable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmptyIterable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmptyIterable.equals(Object)", "int EmptyIterable.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act and Assert
    assertNotEquals(emptyIterable, null);
  }

  /**
   * Test {@link EmptyIterable#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmptyIterable#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmptyIterable.equals(Object)", "int EmptyIterable.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmptyIterable<Object> emptyIterable = new EmptyIterable<>();

    // Act and Assert
    assertNotEquals(emptyIterable, "Different type to EmptyIterable");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EmptyIterable}
   *   <li>{@link EmptyIterable#close()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmptyIterable.<init>()", "void EmptyIterable.close()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EmptyIterable<Object> actualEmptyIterable = new EmptyIterable<>();
    actualEmptyIterable.close();

    // Assert
    Iterator<Object> iteratorResult = actualEmptyIterable.iterator();
    assertTrue(iteratorResult instanceof EmptyIterator);
    assertFalse(iteratorResult.hasNext());
  }
}
