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

package uk.gov.gchq.gaffer.commonutil.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class OverwritingExceptionDiffblueTest {
  /**
   * Method under test: {@link OverwritingException#OverwritingException()}
   */
  @Test
  void testNewOverwritingException() {
    // Arrange and Act
    OverwritingException actualOverwritingException = new OverwritingException();

    // Assert
    assertNull(actualOverwritingException.getMessage());
    assertNull(actualOverwritingException.getCause());
    assertEquals(0, actualOverwritingException.getSuppressed().length);
  }

  /**
   * Method under test: {@link OverwritingException#OverwritingException(String)}
   */
  @Test
  void testNewOverwritingException2() {
    // Arrange and Act
    OverwritingException actualOverwritingException = new OverwritingException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualOverwritingException.getMessage());
    assertNull(actualOverwritingException.getCause());
    assertEquals(0, actualOverwritingException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link OverwritingException#OverwritingException(String, Throwable)}
   */
  @Test
  void testNewOverwritingException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OverwritingException actualOverwritingException = new OverwritingException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualOverwritingException.getMessage());
    assertEquals(0, actualOverwritingException.getSuppressed().length);
    assertSame(cause, actualOverwritingException.getCause());
  }
}
