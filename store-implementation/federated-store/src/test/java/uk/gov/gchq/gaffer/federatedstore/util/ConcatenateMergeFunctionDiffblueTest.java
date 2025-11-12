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
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.koryphe.iterable.ChainedIterable;
import uk.gov.gchq.koryphe.iterable.ChainedIterator;

class ConcatenateMergeFunctionDiffblueTest {
  /**
   * Method under test: {@link ConcatenateMergeFunction#apply(Object, Iterable)}
   */
  @Test
  void testApply() {
    // Arrange
    ConcatenateMergeFunction concatenateMergeFunction = new ConcatenateMergeFunction();

    // Act
    Iterable<Object> actualApplyResult = concatenateMergeFunction.apply("Update", new ArrayList<>());
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
   * Method under test: {@link ConcatenateMergeFunction#apply(Object, Iterable)}
   */
  @Test
  void testApply2() {
    // Arrange and Act
    Iterable<Object> actualApplyResult = (new ConcatenateMergeFunction()).apply(null, mock(Iterable.class));
    Iterator<Object> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof ChainedIterable);
    assertTrue(actualApplyResult.iterator() instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConcatenateMergeFunction#equals(Object)}
   *   <li>{@link ConcatenateMergeFunction#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ConcatenateMergeFunction concatenateMergeFunction = new ConcatenateMergeFunction();
    ConcatenateMergeFunction concatenateMergeFunction2 = new ConcatenateMergeFunction();

    // Act and Assert
    assertEquals(concatenateMergeFunction, concatenateMergeFunction2);
    int notExpectedHashCodeResult = concatenateMergeFunction.hashCode();
    assertNotEquals(notExpectedHashCodeResult, concatenateMergeFunction2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConcatenateMergeFunction#equals(Object)}
   *   <li>{@link ConcatenateMergeFunction#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ConcatenateMergeFunction concatenateMergeFunction = new ConcatenateMergeFunction();

    // Act and Assert
    assertEquals(concatenateMergeFunction, concatenateMergeFunction);
    int expectedHashCodeResult = concatenateMergeFunction.hashCode();
    assertEquals(expectedHashCodeResult, concatenateMergeFunction.hashCode());
  }

  /**
   * Method under test: {@link ConcatenateMergeFunction#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConcatenateMergeFunction(), 1);
  }

  /**
   * Method under test: {@link ConcatenateMergeFunction#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConcatenateMergeFunction(), null);
  }

  /**
   * Method under test: {@link ConcatenateMergeFunction#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ConcatenateMergeFunction(), "Different type to ConcatenateMergeFunction");
  }
}
