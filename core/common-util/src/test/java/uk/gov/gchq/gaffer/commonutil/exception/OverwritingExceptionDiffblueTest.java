package uk.gov.gchq.gaffer.commonutil.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OverwritingExceptionDiffblueTest {
  /**
   * Test {@link OverwritingException#OverwritingException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link OverwritingException#OverwritingException(String)}
   */
  @Test
  @DisplayName("Test new OverwritingException(String); then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  void testNewOverwritingException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    OverwritingException actualOverwritingException = new OverwritingException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualOverwritingException.getMessage());
    assertNull(actualOverwritingException.getCause());
    assertEquals(0, actualOverwritingException.getSuppressed().length);
  }

  /**
   * Test {@link OverwritingException#OverwritingException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OverwritingException#OverwritingException()}
   */
  @Test
  @DisplayName("Test new OverwritingException(); then return Message is 'null'")
  @Tag("MaintainedByDiffblue")
  void testNewOverwritingException_thenReturnMessageIsNull() {
    // Arrange and Act
    OverwritingException actualOverwritingException = new OverwritingException();

    // Assert
    assertNull(actualOverwritingException.getMessage());
    assertNull(actualOverwritingException.getCause());
    assertEquals(0, actualOverwritingException.getSuppressed().length);
  }

  /**
   * Test {@link OverwritingException#OverwritingException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link OverwritingException#OverwritingException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new OverwritingException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  void testNewOverwritingException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    OverwritingException actualOverwritingException =
        new OverwritingException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualOverwritingException.getMessage());
    assertEquals(0, actualOverwritingException.getSuppressed().length);
    assertSame(cause, actualOverwritingException.getCause());
  }
}
