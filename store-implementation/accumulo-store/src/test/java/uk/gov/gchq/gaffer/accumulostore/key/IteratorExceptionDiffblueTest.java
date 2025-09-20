package uk.gov.gchq.gaffer.accumulostore.key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IteratorExceptionDiffblueTest {
  /**
   * Test {@link IteratorException#IteratorException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorException#IteratorException(String)}
   */
  @Test
  @DisplayName(
      "Test new IteratorException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IteratorException.<init>(String)",
    "void IteratorException.<init>(String, Throwable)",
    "void IteratorException.<init>(Throwable)"
  })
  void testNewIteratorException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    IteratorException actualIteratorException = new IteratorException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualIteratorException.getMessage());
    assertNull(actualIteratorException.getCause());
    assertEquals(0, actualIteratorException.getSuppressed().length);
  }

  /**
   * Test {@link IteratorException#IteratorException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorException#IteratorException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new IteratorException(String, Throwable); when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IteratorException.<init>(String)",
    "void IteratorException.<init>(String, Throwable)",
    "void IteratorException.<init>(Throwable)"
  })
  void testNewIteratorException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    IteratorException actualIteratorException = new IteratorException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualIteratorException.getMessage());
    assertEquals(0, actualIteratorException.getSuppressed().length);
    assertSame(e, actualIteratorException.getCause());
  }

  /**
   * Test {@link IteratorException#IteratorException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link IteratorException#IteratorException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new IteratorException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IteratorException.<init>(String)",
    "void IteratorException.<init>(String, Throwable)",
    "void IteratorException.<init>(Throwable)"
  })
  void testNewIteratorException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    IteratorException actualIteratorException = new IteratorException(e);

    // Assert
    assertEquals("java.lang.Throwable", actualIteratorException.getMessage());
    assertEquals(0, actualIteratorException.getSuppressed().length);
    assertSame(e, actualIteratorException.getCause());
  }
}
