package uk.gov.gchq.gaffer.core.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange
    GafferCheckedException gafferCheckedException = new GafferCheckedException("An error occurred");

    // Act
    gafferCheckedException.setStatus(Status.CONTINUE);

    // Assert
    assertEquals(Status.CONTINUE, gafferCheckedException.getStatus());
  }
}
