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

package uk.gov.gchq.gaffer.core.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class GafferRuntimeExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GafferRuntimeException#setStatus(Status)}
   *   <li>{@link GafferRuntimeException#getStatus()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    GafferRuntimeException gafferRuntimeException = new GafferRuntimeException("An error occurred");

    // Act
    gafferRuntimeException.setStatus(Status.CONTINUE);

    // Assert that nothing has changed
    assertEquals(Status.CONTINUE, gafferRuntimeException.getStatus());
  }

  /**
   * Method under test:
   * {@link GafferRuntimeException#GafferRuntimeException(String)}
   */
  @Test
  void testNewGafferRuntimeException() {
    // Arrange and Act
    GafferRuntimeException actualGafferRuntimeException = new GafferRuntimeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualGafferRuntimeException.getLocalizedMessage());
    assertEquals("An error occurred", actualGafferRuntimeException.getMessage());
    assertNull(actualGafferRuntimeException.getCause());
    assertEquals(0, actualGafferRuntimeException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualGafferRuntimeException.getStatus());
  }

  /**
   * Method under test:
   * {@link GafferRuntimeException#GafferRuntimeException(String, Throwable)}
   */
  @Test
  void testNewGafferRuntimeException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    GafferRuntimeException actualGafferRuntimeException = new GafferRuntimeException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualGafferRuntimeException.getLocalizedMessage());
    assertEquals("An error occurred", actualGafferRuntimeException.getMessage());
    assertEquals(0, actualGafferRuntimeException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualGafferRuntimeException.getStatus());
    assertSame(cause, actualGafferRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link GafferRuntimeException#GafferRuntimeException(String, Throwable, Status)}
   */
  @Test
  void testNewGafferRuntimeException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    GafferRuntimeException actualGafferRuntimeException = new GafferRuntimeException("An error occurred", cause,
        Status.CONTINUE);

    // Assert
    assertEquals("An error occurred", actualGafferRuntimeException.getLocalizedMessage());
    assertEquals("An error occurred", actualGafferRuntimeException.getMessage());
    assertEquals(0, actualGafferRuntimeException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualGafferRuntimeException.getStatus());
    assertSame(cause, actualGafferRuntimeException.getCause());
  }

  /**
   * Method under test:
   * {@link GafferRuntimeException#GafferRuntimeException(String, Status)}
   */
  @Test
  void testNewGafferRuntimeException4() {
    // Arrange and Act
    GafferRuntimeException actualGafferRuntimeException = new GafferRuntimeException("An error occurred",
        Status.CONTINUE);

    // Assert
    assertEquals("An error occurred", actualGafferRuntimeException.getLocalizedMessage());
    assertEquals("An error occurred", actualGafferRuntimeException.getMessage());
    assertNull(actualGafferRuntimeException.getCause());
    assertEquals(0, actualGafferRuntimeException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualGafferRuntimeException.getStatus());
  }
}
