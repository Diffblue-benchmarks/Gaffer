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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferRuntimeExceptionDiffblueTest {
  /**
   * Test {@link GafferRuntimeException#GafferRuntimeException(String)}.
   * <p>
   * Method under test: {@link GafferRuntimeException#GafferRuntimeException(String)}
   */
  @Test
  @DisplayName("Test new GafferRuntimeException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GafferRuntimeException.<init>(String)"})
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
   * Test {@link GafferRuntimeException#GafferRuntimeException(String, Throwable)}.
   * <p>
   * Method under test: {@link GafferRuntimeException#GafferRuntimeException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new GafferRuntimeException(String, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GafferRuntimeException.<init>(String, Throwable)"})
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
   * Test {@link GafferRuntimeException#GafferRuntimeException(String, Throwable, Status)}.
   * <p>
   * Method under test: {@link GafferRuntimeException#GafferRuntimeException(String, Throwable, Status)}
   */
  @Test
  @DisplayName("Test new GafferRuntimeException(String, Throwable, Status)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GafferRuntimeException.<init>(String, Throwable, Status)"})
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
   * Test {@link GafferRuntimeException#GafferRuntimeException(String, Status)}.
   * <p>
   * Method under test: {@link GafferRuntimeException#GafferRuntimeException(String, Status)}
   */
  @Test
  @DisplayName("Test new GafferRuntimeException(String, Status)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GafferRuntimeException.<init>(String, Status)"})
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

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GafferRuntimeException#setStatus(Status)}
   *   <li>{@link GafferRuntimeException#getStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Status GafferRuntimeException.getStatus()", "void GafferRuntimeException.setStatus(Status)"})
  void testGettersAndSetters() {
    // Arrange
    GafferRuntimeException gafferRuntimeException = new GafferRuntimeException("An error occurred");

    // Act
    gafferRuntimeException.setStatus(Status.CONTINUE);

    // Assert
    assertEquals(Status.CONTINUE, gafferRuntimeException.getStatus());
  }
}
