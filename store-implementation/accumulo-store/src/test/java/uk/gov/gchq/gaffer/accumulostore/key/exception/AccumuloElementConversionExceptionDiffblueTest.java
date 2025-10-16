package uk.gov.gchq.gaffer.accumulostore.key.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AccumuloElementConversionExceptionDiffblueTest {
  /**
   * Test {@link AccumuloElementConversionException#AccumuloElementConversionException(String)}.
   *
   * <ul>
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloElementConversionException#AccumuloElementConversionException(String)}
   */
  @Test
  @DisplayName("Test new AccumuloElementConversionException(String); then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloElementConversionException.<init>(String)",
    "void AccumuloElementConversionException.<init>(String, Throwable)"
  })
  void testNewAccumuloElementConversionException_thenReturnCauseIsNull() {
    // Arrange and Act
    AccumuloElementConversionException actualAccumuloElementConversionException =
        new AccumuloElementConversionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualAccumuloElementConversionException.getMessage());
    assertNull(actualAccumuloElementConversionException.getCause());
    assertEquals(0, actualAccumuloElementConversionException.getSuppressed().length);
  }

  /**
   * Test {@link AccumuloElementConversionException#AccumuloElementConversionException(String,
   * Throwable)}.
   *
   * <ul>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloElementConversionException#AccumuloElementConversionException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloElementConversionException(String, Throwable); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloElementConversionException.<init>(String)",
    "void AccumuloElementConversionException.<init>(String, Throwable)"
  })
  void testNewAccumuloElementConversionException_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    AccumuloElementConversionException actualAccumuloElementConversionException =
        new AccumuloElementConversionException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualAccumuloElementConversionException.getMessage());
    assertEquals(0, actualAccumuloElementConversionException.getSuppressed().length);
    assertSame(e, actualAccumuloElementConversionException.getCause());
  }
}
