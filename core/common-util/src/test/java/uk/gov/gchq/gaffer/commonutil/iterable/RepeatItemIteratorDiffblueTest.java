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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RepeatItemIteratorDiffblueTest {
  /**
   * Test {@link RepeatItemIterator#RepeatItemIterator(Object, long)}.
   * <p>
   * Method under test: {@link RepeatItemIterator#RepeatItemIterator(Object, long)}
   */
  @Test
  @DisplayName("Test new RepeatItemIterator(Object, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RepeatItemIterator.<init>(Object, long)"})
  void testNewRepeatItemIterator() {
    // Arrange and Act
    RepeatItemIterator<Object> actualRepeatItemIterator = new RepeatItemIterator<>("Item", 1L);

    // Assert
    assertEquals("Item", actualRepeatItemIterator.next());
    assertFalse(actualRepeatItemIterator.hasNext());
  }

  /**
   * Test {@link RepeatItemIterator#hasNext()}.
   * <ul>
   *   <li>Given {@link RepeatItemIterator#RepeatItemIterator(Object, long)} with {@code Item} and repeats is minus one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepeatItemIterator#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); given RepeatItemIterator(Object, long) with 'Item' and repeats is minus one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RepeatItemIterator.hasNext()"})
  void testHasNext_givenRepeatItemIteratorWithItemAndRepeatsIsMinusOne_thenReturnFalse() {
    // Arrange
    RepeatItemIterator<Object> repeatItemIterator = new RepeatItemIterator<>("Item", -1L);

    // Act and Assert
    assertFalse(repeatItemIterator.hasNext());
  }

  /**
   * Test {@link RepeatItemIterator#hasNext()}.
   * <ul>
   *   <li>Given {@link RepeatItemIterator#RepeatItemIterator(Object, long)} with {@code Item} and repeats is one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepeatItemIterator#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); given RepeatItemIterator(Object, long) with 'Item' and repeats is one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RepeatItemIterator.hasNext()"})
  void testHasNext_givenRepeatItemIteratorWithItemAndRepeatsIsOne_thenReturnTrue() {
    // Arrange
    RepeatItemIterator<Object> repeatItemIterator = new RepeatItemIterator<>("Item", 1L);

    // Act and Assert
    assertTrue(repeatItemIterator.hasNext());
  }

  /**
   * Test {@link RepeatItemIterator#next()}.
   * <ul>
   *   <li>Given {@link RepeatItemIterator#RepeatItemIterator(Object, long)} with {@code Item} and repeats is one.</li>
   *   <li>Then return {@code Item}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepeatItemIterator#next()}
   */
  @Test
  @DisplayName("Test next(); given RepeatItemIterator(Object, long) with 'Item' and repeats is one; then return 'Item'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object RepeatItemIterator.next()"})
  void testNext_givenRepeatItemIteratorWithItemAndRepeatsIsOne_thenReturnItem() {
    // Arrange
    RepeatItemIterator<Object> repeatItemIterator = new RepeatItemIterator<>("Item", 1L);

    // Act and Assert
    assertEquals("Item", repeatItemIterator.next());
    assertFalse(repeatItemIterator.hasNext());
  }

  /**
   * Test {@link RepeatItemIterator#next()}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RepeatItemIterator#next()}
   */
  @Test
  @DisplayName("Test next(); then throw NoSuchElementException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object RepeatItemIterator.next()"})
  void testNext_thenThrowNoSuchElementException() {
    // Arrange
    RepeatItemIterator<Object> repeatItemIterator = new RepeatItemIterator<>("Item", -1L);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> repeatItemIterator.next());
  }
}
