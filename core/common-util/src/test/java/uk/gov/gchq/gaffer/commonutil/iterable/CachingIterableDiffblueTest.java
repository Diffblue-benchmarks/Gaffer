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
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class CachingIterableDiffblueTest {
  /**
   * Method under test: {@link CachingIterable#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange
    CachingIterable<Object> cachingIterable = new CachingIterable<>(new ArrayList<>(), 3);

    // Act and Assert
    assertFalse(cachingIterable.iterator().hasNext());
  }

  /**
   * Method under test: {@link CachingIterable#CachingIterable(Iterable)}
   */
  @Test
  void testNewCachingIterable() {
    // Arrange and Act
    CachingIterable<Object> actualCachingIterable = new CachingIterable<>(new ArrayList<>());

    // Assert
    assertFalse(actualCachingIterable.iterator().hasNext());
  }

  /**
   * Method under test: {@link CachingIterable#CachingIterable(Iterable)}
   */
  @Test
  void testNewCachingIterable2() {
    // Arrange and Act
    CachingIterable<Object> actualCachingIterable = new CachingIterable<>(null);

    // Assert
    assertFalse(actualCachingIterable.iterator().hasNext());
  }

  /**
   * Method under test: {@link CachingIterable#CachingIterable(Iterable, int)}
   */
  @Test
  void testNewCachingIterable3() {
    // Arrange and Act
    CachingIterable<Object> actualCachingIterable = new CachingIterable<>(new ArrayList<>(), 3);

    // Assert
    assertFalse(actualCachingIterable.iterator().hasNext());
  }

  /**
   * Method under test: {@link CachingIterable#CachingIterable(Iterable, int)}
   */
  @Test
  void testNewCachingIterable4() {
    // Arrange and Act
    CachingIterable<Object> actualCachingIterable = new CachingIterable<>(null, 3);

    // Assert
    assertFalse(actualCachingIterable.iterator().hasNext());
  }
}
