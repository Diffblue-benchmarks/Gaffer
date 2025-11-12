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

class UnauthorisedExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link UnauthorisedException#UnauthorisedException(String)}
   */
  @Test
  void testNewUnauthorisedException() {
    // Arrange and Act
    UnauthorisedException actualUnauthorisedException = new UnauthorisedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualUnauthorisedException.getMessage());
    assertNull(actualUnauthorisedException.getCause());
    assertEquals(0, actualUnauthorisedException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link UnauthorisedException#UnauthorisedException(String, Throwable)}
   */
  @Test
  void testNewUnauthorisedException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UnauthorisedException actualUnauthorisedException = new UnauthorisedException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualUnauthorisedException.getMessage());
    assertEquals(0, actualUnauthorisedException.getSuppressed().length);
    assertSame(cause, actualUnauthorisedException.getCause());
  }
}
