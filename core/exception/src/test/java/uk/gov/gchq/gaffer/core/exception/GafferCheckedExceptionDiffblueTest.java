/*
 * Copyright 2026 Crown Copyright
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GafferCheckedExceptionDiffblueTest {
  /**
   * Test {@link GafferCheckedException#GafferCheckedException(String)}.
   *
   * <p>Method under test: {@link GafferCheckedException#GafferCheckedException(String)}
   */
  @Test
  @DisplayName("Test new GafferCheckedException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferCheckedException.<init>(String)"})
  void testNewGafferCheckedException() {
    // Arrange and Act
    GafferCheckedException actualGafferCheckedException =
        new GafferCheckedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualGafferCheckedException.getLocalizedMessage());
    assertEquals("An error occurred", actualGafferCheckedException.getMessage());
    assertNull(actualGafferCheckedException.getCause());
    assertEquals(0, actualGafferCheckedException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualGafferCheckedException.getStatus());
  }

  /**
   * Test {@link GafferCheckedException#GafferCheckedException(String, Throwable)}.
   *
   * <p>Method under test: {@link GafferCheckedException#GafferCheckedException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new GafferCheckedException(String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferCheckedException.<init>(String, Throwable)"})
  void testNewGafferCheckedException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    GafferCheckedException actualGafferCheckedException =
        new GafferCheckedException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualGafferCheckedException.getLocalizedMessage());
    assertEquals("An error occurred", actualGafferCheckedException.getMessage());
    assertEquals(0, actualGafferCheckedException.getSuppressed().length);
    assertEquals(Status.INTERNAL_SERVER_ERROR, actualGafferCheckedException.getStatus());
    assertSame(cause, actualGafferCheckedException.getCause());
  }

  /**
   * Test {@link GafferCheckedException#GafferCheckedException(String, Throwable, Status)}.
   *
   * <p>Method under test: {@link GafferCheckedException#GafferCheckedException(String, Throwable,
   * Status)}
   */
  @Test
  @DisplayName("Test new GafferCheckedException(String, Throwable, Status)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferCheckedException.<init>(String, Throwable, Status)"})
  void testNewGafferCheckedException3() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    GafferCheckedException actualGafferCheckedException =
        new GafferCheckedException("An error occurred", cause, Status.CONTINUE);

    // Assert
    assertEquals("An error occurred", actualGafferCheckedException.getLocalizedMessage());
    assertEquals("An error occurred", actualGafferCheckedException.getMessage());
    assertEquals(0, actualGafferCheckedException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualGafferCheckedException.getStatus());
    assertSame(cause, actualGafferCheckedException.getCause());
  }

  /**
   * Test {@link GafferCheckedException#GafferCheckedException(String, Status)}.
   *
   * <p>Method under test: {@link GafferCheckedException#GafferCheckedException(String, Status)}
   */
  @Test
  @DisplayName("Test new GafferCheckedException(String, Status)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferCheckedException.<init>(String, Status)"})
  void testNewGafferCheckedException4() {
    // Arrange and Act
    GafferCheckedException actualGafferCheckedException =
        new GafferCheckedException("An error occurred", Status.CONTINUE);

    // Assert
    assertEquals("An error occurred", actualGafferCheckedException.getLocalizedMessage());
    assertEquals("An error occurred", actualGafferCheckedException.getMessage());
    assertNull(actualGafferCheckedException.getCause());
    assertEquals(0, actualGafferCheckedException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualGafferCheckedException.getStatus());
  }

  /**
   * Test {@link GafferCheckedException#GafferCheckedException(Throwable)}.
   *
   * <p>Method under test: {@link GafferCheckedException#GafferCheckedException(Throwable)}
   */
  @Test
  @DisplayName("Test new GafferCheckedException(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferCheckedException.<init>(Throwable)"})
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
   * Test {@link GafferCheckedException#GafferCheckedException(Throwable, Status)}.
   *
   * <p>Method under test: {@link GafferCheckedException#GafferCheckedException(Throwable, Status)}
   */
  @Test
  @DisplayName("Test new GafferCheckedException(Throwable, Status)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GafferCheckedException.<init>(Throwable, Status)"})
  void testNewGafferCheckedException6() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    GafferCheckedException actualGafferCheckedException =
        new GafferCheckedException(cause, Status.CONTINUE);

    // Assert
    assertEquals("java.lang.Throwable", actualGafferCheckedException.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualGafferCheckedException.getMessage());
    assertEquals(0, actualGafferCheckedException.getSuppressed().length);
    assertEquals(Status.CONTINUE, actualGafferCheckedException.getStatus());
    assertSame(cause, actualGafferCheckedException.getCause());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GafferCheckedException#setStatus(Status)}
   *   <li>{@link GafferCheckedException#getStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Status GafferCheckedException.getStatus()",
    "void GafferCheckedException.setStatus(Status)"
  })
  void testGettersAndSetters() {
    // Arrange
    GafferCheckedException gafferCheckedException = new GafferCheckedException("An error occurred");

    // Act
    gafferCheckedException.setStatus(Status.CONTINUE);

    // Assert
    assertEquals(Status.CONTINUE, gafferCheckedException.getStatus());
  }
}
