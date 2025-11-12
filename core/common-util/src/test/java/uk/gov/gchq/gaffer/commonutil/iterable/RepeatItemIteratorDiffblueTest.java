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
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class RepeatItemIteratorDiffblueTest {
  /**
   * Method under test: {@link RepeatItemIterator#hasNext()}
   */
  @Test
  void testHasNext() {
    // Arrange
    RepeatItemIterator<Object> repeatItemIterator = new RepeatItemIterator<>("Item", 1L);

    // Act and Assert
    assertTrue(repeatItemIterator.hasNext());
  }

  /**
   * Method under test: {@link RepeatItemIterator#hasNext()}
   */
  @Test
  void testHasNext2() {
    // Arrange
    RepeatItemIterator<Object> repeatItemIterator = new RepeatItemIterator<>("Item", -1L);

    // Act and Assert
    assertFalse(repeatItemIterator.hasNext());
  }

  /**
   * Method under test: {@link RepeatItemIterator#next()}
   */
  @Test
  void testNext() {
    // Arrange
    RepeatItemIterator<Object> repeatItemIterator = new RepeatItemIterator<>("Item", 1L);

    // Act and Assert
    assertEquals("Item", repeatItemIterator.next());
    assertFalse(repeatItemIterator.hasNext());
  }

  /**
   * Method under test: {@link RepeatItemIterator#next()}
   */
  @Test
  void testNext2() {
    // Arrange
    RepeatItemIterator<Object> repeatItemIterator = new RepeatItemIterator<>("Item", -1L);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> repeatItemIterator.next());
  }

  /**
   * Method under test:
   * {@link RepeatItemIterator#RepeatItemIterator(Object, long)}
   */
  @Test
  void testNewRepeatItemIterator() {
    // Arrange and Act
    RepeatItemIterator<Object> actualRepeatItemIterator = new RepeatItemIterator<>("Item", 1L);

    // Assert
    assertEquals("Item", actualRepeatItemIterator.next());
    assertFalse(actualRepeatItemIterator.hasNext());
  }
}
