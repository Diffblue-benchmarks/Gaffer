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

package uk.gov.gchq.gaffer.accumulostore.key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class AccumuloRuntimeExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link AccumuloRuntimeException#AccumuloRuntimeException(String)}
   */
  @Test
  void testNewAccumuloRuntimeException() {
    // Arrange and Act
    AccumuloRuntimeException actualAccumuloRuntimeException = new AccumuloRuntimeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualAccumuloRuntimeException.getMessage());
    assertNull(actualAccumuloRuntimeException.getCause());
    assertEquals(0, actualAccumuloRuntimeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link AccumuloRuntimeException#AccumuloRuntimeException(String, Throwable)}
   */
  @Test
  void testNewAccumuloRuntimeException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    AccumuloRuntimeException actualAccumuloRuntimeException = new AccumuloRuntimeException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualAccumuloRuntimeException.getMessage());
    assertEquals(0, actualAccumuloRuntimeException.getSuppressed().length);
    assertSame(e, actualAccumuloRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link AccumuloRuntimeException#AccumuloRuntimeException(Throwable)}
   */
  @Test
  void testNewAccumuloRuntimeException3() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    AccumuloRuntimeException actualAccumuloRuntimeException = new AccumuloRuntimeException(e);

    // Assert
    assertEquals("java.lang.Throwable", actualAccumuloRuntimeException.getMessage());
    assertEquals(0, actualAccumuloRuntimeException.getSuppressed().length);
    assertSame(e, actualAccumuloRuntimeException.getCause());
  }
}
