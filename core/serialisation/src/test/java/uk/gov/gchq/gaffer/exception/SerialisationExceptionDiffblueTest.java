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

package uk.gov.gchq.gaffer.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class SerialisationExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link SerialisationException#SerialisationException(String)}
   */
  @Test
  void testNewSerialisationException() {
    // Arrange and Act
    SerialisationException actualSerialisationException = new SerialisationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSerialisationException.getMessage());
    assertNull(actualSerialisationException.getCause());
    assertEquals(0, actualSerialisationException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link SerialisationException#SerialisationException(String, Throwable)}
   */
  @Test
  void testNewSerialisationException2() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    SerialisationException actualSerialisationException = new SerialisationException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualSerialisationException.getMessage());
    assertEquals(0, actualSerialisationException.getSuppressed().length);
    assertSame(e, actualSerialisationException.getCause());
  }
}
