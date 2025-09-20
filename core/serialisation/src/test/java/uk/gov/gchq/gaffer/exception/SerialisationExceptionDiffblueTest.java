package uk.gov.gchq.gaffer.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SerialisationExceptionDiffblueTest {
  /**
   * Test {@link SerialisationException#SerialisationException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SerialisationException#SerialisationException(String)}
   */
  @Test
  @DisplayName(
      "Test new SerialisationException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  void testNewSerialisationException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    SerialisationException actualSerialisationException =
        new SerialisationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualSerialisationException.getMessage());
    assertNull(actualSerialisationException.getCause());
    assertEquals(0, actualSerialisationException.getSuppressed().length);
  }

  /**
   * Test {@link SerialisationException#SerialisationException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link SerialisationException#SerialisationException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new SerialisationException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  void testNewSerialisationException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    SerialisationException actualSerialisationException =
        new SerialisationException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualSerialisationException.getMessage());
    assertEquals(0, actualSerialisationException.getSuppressed().length);
    assertSame(e, actualSerialisationException.getCause());
  }
}
