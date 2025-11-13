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

package uk.gov.gchq.gaffer.federatedstore.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.koryphe.iterable.ChainedIterable;
import uk.gov.gchq.koryphe.iterable.ChainedIterator;

class ConcatenateMergeFunctionDiffblueTest {
  /**
   * Test {@link ConcatenateMergeFunction#apply(Object, Iterable)} with {@code Object}, {@code
   * Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ChainedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link ConcatenateMergeFunction#apply(Object, Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Object, Iterable) with 'Object', 'Iterable'; when ArrayList(); then return ChainedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ConcatenateMergeFunction.apply(Object, Iterable)"})
  void testApplyWithObjectIterable_whenArrayList_thenReturnChainedIterable() {
    // Arrange
    ConcatenateMergeFunction concatenateMergeFunction = new ConcatenateMergeFunction();
    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    Iterable<Object> actualApplyResult =
        concatenateMergeFunction.apply(objectList, new ArrayList<>());
    Iterator<Object> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof ChainedIterable);
    Iterator<Object> iteratorResult = actualApplyResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link ConcatenateMergeFunction#apply(Object, Iterable)} with {@code Object}, {@code
   * Iterable}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link ChainedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link ConcatenateMergeFunction#apply(Object, Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Object, Iterable) with 'Object', 'Iterable'; when 'null'; then return ChainedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ConcatenateMergeFunction.apply(Object, Iterable)"})
  void testApplyWithObjectIterable_whenNull_thenReturnChainedIterable() {
    // Arrange
    ConcatenateMergeFunction concatenateMergeFunction = new ConcatenateMergeFunction();

    // Act
    Iterable<Object> actualApplyResult = concatenateMergeFunction.apply(null, new ArrayList<>());
    Iterator<Object> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof ChainedIterable);
    Iterator<Object> iteratorResult = actualApplyResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link ConcatenateMergeFunction#apply(Object, Iterable)} with {@code Object}, {@code
   * Iterable}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ConcatenateMergeFunction#apply(Object, Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Object, Iterable) with 'Object', 'Iterable'; when 'null'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ConcatenateMergeFunction.apply(Object, Iterable)"})
  void testApplyWithObjectIterable_whenNull_thenReturnList() {
    // Arrange
    ConcatenateMergeFunction concatenateMergeFunction = new ConcatenateMergeFunction();

    // Act
    Iterable<Object> actualApplyResult = concatenateMergeFunction.apply(new ArrayList<>(), null);
    Iterator<Object> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Object>) actualApplyResult).isEmpty());
  }

  /**
   * Test {@link ConcatenateMergeFunction#apply(Object, Iterable)} with {@code Object}, {@code
   * Iterable}.
   *
   * <ul>
   *   <li>When {@code Update}.
   *   <li>Then return iterator next is {@code Update}.
   * </ul>
   *
   * <p>Method under test: {@link ConcatenateMergeFunction#apply(Object, Iterable)}
   */
  @Test
  @DisplayName(
      "Test apply(Object, Iterable) with 'Object', 'Iterable'; when 'Update'; then return iterator next is 'Update'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ConcatenateMergeFunction.apply(Object, Iterable)"})
  void testApplyWithObjectIterable_whenUpdate_thenReturnIteratorNextIsUpdate() {
    // Arrange
    ConcatenateMergeFunction concatenateMergeFunction = new ConcatenateMergeFunction();

    // Act
    Iterable<Object> actualApplyResult =
        concatenateMergeFunction.apply("Update", new ArrayList<>());
    Iterator<Object> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof ChainedIterable);
    Iterator<Object> iteratorResult = actualApplyResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertEquals("Update", iteratorResult.next());
    assertEquals("Update", actualIteratorResult.next());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link ConcatenateMergeFunction#equals(Object)}, and {@link
   * ConcatenateMergeFunction#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConcatenateMergeFunction#equals(Object)}
   *   <li>{@link ConcatenateMergeFunction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConcatenateMergeFunction.equals(Object)",
    "int ConcatenateMergeFunction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConcatenateMergeFunction concatenateMergeFunction = new ConcatenateMergeFunction();
    ConcatenateMergeFunction concatenateMergeFunction2 = new ConcatenateMergeFunction();

    // Act and Assert
    assertEquals(concatenateMergeFunction, concatenateMergeFunction2);
    assertNotEquals(concatenateMergeFunction.hashCode(), concatenateMergeFunction2.hashCode());
  }

  /**
   * Test {@link ConcatenateMergeFunction#equals(Object)}, and {@link
   * ConcatenateMergeFunction#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConcatenateMergeFunction#equals(Object)}
   *   <li>{@link ConcatenateMergeFunction#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConcatenateMergeFunction.equals(Object)",
    "int ConcatenateMergeFunction.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConcatenateMergeFunction concatenateMergeFunction = new ConcatenateMergeFunction();

    // Act and Assert
    assertEquals(concatenateMergeFunction, concatenateMergeFunction);
    int expectedHashCodeResult = concatenateMergeFunction.hashCode();
    assertEquals(expectedHashCodeResult, concatenateMergeFunction.hashCode());
  }

  /**
   * Test {@link ConcatenateMergeFunction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConcatenateMergeFunction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConcatenateMergeFunction.equals(Object)",
    "int ConcatenateMergeFunction.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConcatenateMergeFunction(), 1);
  }

  /**
   * Test {@link ConcatenateMergeFunction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConcatenateMergeFunction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConcatenateMergeFunction.equals(Object)",
    "int ConcatenateMergeFunction.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConcatenateMergeFunction(), null);
  }

  /**
   * Test {@link ConcatenateMergeFunction#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ConcatenateMergeFunction#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ConcatenateMergeFunction.equals(Object)",
    "int ConcatenateMergeFunction.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConcatenateMergeFunction(), "Different type to ConcatenateMergeFunction");
  }
}
