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

class GafferCheckedExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GafferCheckedException#setStatus(Status)}
   *   <li>{@link GafferCheckedException#getStatus()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    GafferCheckedException gafferCheckedException = new GafferCheckedException("An error occurred");

    // Act
    gafferCheckedException.setStatus(Status.CONTINUE);

    // Assert that nothing has changed
    assertEquals(Status.CONTINUE, gafferCheckedException.getStatus());
  }

  /**
   * Method under test:
   * {@link GafferCheckedException#GafferCheckedException(String)}
   */
  @Test
  void testNewGafferCheckedException() {
    // Arrange and Act
    GafferCheckedException actualGafferCheckedException = new GafferCheckedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualGafferCheckedException.getLocalizedMessage());
    assertEquals("An error occurred", actualGafferCheckedException.getMessage());
    assertNull(actualGafferCheckedException.getCause());
    assertEquals(0, actualGafferCheckedException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualGafferCheckedException.getStatus());
  }

  /**
   * Method under test:
   * {@link GafferCheckedException#GafferCheckedException(String, Throwable)}
   */
  @Test
  void testNewGafferCheckedException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    GafferCheckedException actualGafferCheckedException = new GafferCheckedException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualGafferCheckedException.getLocalizedMessage());
    assertEquals("An error occurred", actualGafferCheckedException.getMessage());
    assertEquals(0, actualGafferCheckedException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualGafferCheckedException.getStatus());
    assertSame(cause, actualGafferCheckedException.getCause());
  }

  /**
   * Method under test:
   * {@link GafferCheckedException#GafferCheckedException(String, Throwable, Status)}
   */
  @Test
  void testNewGafferCheckedException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    GafferCheckedException actualGafferCheckedException = new GafferCheckedException("An error occurred", cause,
        Status.CONTINUE);

    // Assert
    assertEquals("An error occurred", actualGafferCheckedException.getLocalizedMessage());
    assertEquals("An error occurred", actualGafferCheckedException.getMessage());
    assertEquals(0, actualGafferCheckedException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualGafferCheckedException.getStatus());
    assertSame(cause, actualGafferCheckedException.getCause());
  }

  /**
   * Method under test:
   * {@link GafferCheckedException#GafferCheckedException(String, Status)}
   */
  @Test
  void testNewGafferCheckedException4() {
    // Arrange and Act
    GafferCheckedException actualGafferCheckedException = new GafferCheckedException("An error occurred",
        Status.CONTINUE);

    // Assert
    assertEquals("An error occurred", actualGafferCheckedException.getLocalizedMessage());
    assertEquals("An error occurred", actualGafferCheckedException.getMessage());
    assertNull(actualGafferCheckedException.getCause());
    assertEquals(0, actualGafferCheckedException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualGafferCheckedException.getStatus());
  }

  /**
   * Method under test:
   * {@link GafferCheckedException#GafferCheckedException(Throwable)}
   */
  @Test
  void testNewGafferCheckedException5() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    GafferCheckedException actualGafferCheckedException = new GafferCheckedException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualGafferCheckedException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualGafferCheckedException.getMessage());
    assertEquals(0, actualGafferCheckedException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualGafferCheckedException.getStatus());
    assertSame(cause, actualGafferCheckedException.getCause());
  }

  /**
   * Method under test:
   * {@link GafferCheckedException#GafferCheckedException(Throwable, Status)}
   */
  @Test
  void testNewGafferCheckedException6() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    GafferCheckedException actualGafferCheckedException = new GafferCheckedException(cause, Status.CONTINUE);

    // Assert
    assertEquals("java.lang.Throwable", actualGafferCheckedException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualGafferCheckedException.getMessage());
    assertEquals(0, actualGafferCheckedException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualGafferCheckedException.getStatus());
    assertSame(cause, actualGafferCheckedException.getCause());
  }
}
