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

class ElementFilterExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link ElementFilterException#ElementFilterException(String)}
   */
  @Test
  void testNewElementFilterException() {
    // Arrange and Act
    ElementFilterException actualElementFilterException = new ElementFilterException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualElementFilterException.getMessage());
    assertNull(actualElementFilterException.getCause());
    assertEquals(0, actualElementFilterException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ElementFilterException#ElementFilterException(String, Throwable)}
   */
  @Test
  void testNewElementFilterException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    ElementFilterException actualElementFilterException = new ElementFilterException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualElementFilterException.getMessage());
    assertEquals(0, actualElementFilterException.getSuppressed().length);
    assertSame(e, actualElementFilterException.getCause());
  }
}
