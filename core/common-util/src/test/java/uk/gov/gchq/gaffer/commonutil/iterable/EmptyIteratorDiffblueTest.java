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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class EmptyIteratorDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmptyIterator}
   *   <li>{@link EmptyIterator#close()}
   *   <li>{@link EmptyIterator#hasNext()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EmptyIterator<Object> actualEmptyIterator = new EmptyIterator<>();
    actualEmptyIterator.close();

    // Assert that nothing has changed
    assertFalse(actualEmptyIterator.hasNext());
    assertFalse(actualEmptyIterator.hasNext());
  }

  /**
   * Method under test: {@link EmptyIterator#next()}
   */
  @Test
  void testNext() {
    // Arrange
    EmptyIterator<Object> emptyIterator = new EmptyIterator<>();

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> emptyIterator.next());
  }

  /**
   * Method under test: {@link EmptyIterator#remove()}
   */
  @Test
  void testRemove() {
    // Arrange
    EmptyIterator<Object> emptyIterator = new EmptyIterator<>();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> emptyIterator.remove());
  }
}
