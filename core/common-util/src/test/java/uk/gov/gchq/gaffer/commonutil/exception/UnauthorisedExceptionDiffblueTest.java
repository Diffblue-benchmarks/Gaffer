package uk.gov.gchq.gaffer.commonutil.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnauthorisedExceptionDiffblueTest {
  /**
   * Test {@link UnauthorisedException#UnauthorisedException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UnauthorisedException#UnauthorisedException(String)}
   */
  @Test
  @DisplayName(
      "Test new UnauthorisedException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnauthorisedException.<init>(String)",
    "void UnauthorisedException.<init>(String, Throwable)"
  })
  void testNewUnauthorisedException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    UnauthorisedException actualUnauthorisedException =
        new UnauthorisedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualUnauthorisedException.getMessage());
    assertNull(actualUnauthorisedException.getCause());
    assertEquals(0, actualUnauthorisedException.getSuppressed().length);
  }

  /**
   * Test {@link UnauthorisedException#UnauthorisedException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link UnauthorisedException#UnauthorisedException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new UnauthorisedException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UnauthorisedException.<init>(String)",
    "void UnauthorisedException.<init>(String, Throwable)"
  })
  void testNewUnauthorisedException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    UnauthorisedException actualUnauthorisedException =
        new UnauthorisedException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualUnauthorisedException.getMessage());
    assertEquals(0, actualUnauthorisedException.getSuppressed().length);
    assertSame(cause, actualUnauthorisedException.getCause());
  }
}
