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

package uk.gov.gchq.gaffer.accumulostore.key.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class BloomFilterIteratorExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link BloomFilterIteratorException#BloomFilterIteratorException(String)}
   */
  @Test
  void testNewBloomFilterIteratorException() {
    // Arrange and Act
    BloomFilterIteratorException actualBloomFilterIteratorException = new BloomFilterIteratorException(
        "An error occurred");

    // Assert
    assertEquals("An error occurred", actualBloomFilterIteratorException.getMessage());
    assertNull(actualBloomFilterIteratorException.getCause());
    assertEquals(0, actualBloomFilterIteratorException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link BloomFilterIteratorException#BloomFilterIteratorException(String, Throwable)}
   */
  @Test
  void testNewBloomFilterIteratorException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    BloomFilterIteratorException actualBloomFilterIteratorException = new BloomFilterIteratorException(
        "An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualBloomFilterIteratorException.getMessage());
    assertEquals(0, actualBloomFilterIteratorException.getSuppressed().length);
    assertSame(e, actualBloomFilterIteratorException.getCause());
  }
}
