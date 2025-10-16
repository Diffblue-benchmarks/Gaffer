package uk.gov.gchq.gaffer.accumulostore.key.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ElementFilterExceptionDiffblueTest {
  /**
   * Test {@link ElementFilterException#ElementFilterException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementFilterException#ElementFilterException(String)}
   */
  @Test
  @DisplayName(
      "Test new ElementFilterException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ElementFilterException.<init>(String)",
    "void ElementFilterException.<init>(String, Throwable)"
  })
  void testNewElementFilterException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    ElementFilterException actualElementFilterException =
        new ElementFilterException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualElementFilterException.getMessage());
    assertNull(actualElementFilterException.getCause());
    assertEquals(0, actualElementFilterException.getSuppressed().length);
  }

  /**
   * Test {@link ElementFilterException#ElementFilterException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementFilterException#ElementFilterException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new ElementFilterException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ElementFilterException.<init>(String)",
    "void ElementFilterException.<init>(String, Throwable)"
  })
  void testNewElementFilterException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    ElementFilterException actualElementFilterException =
        new ElementFilterException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualElementFilterException.getMessage());
    assertEquals(0, actualElementFilterException.getSuppressed().length);
    assertSame(e, actualElementFilterException.getCause());
  }
}
