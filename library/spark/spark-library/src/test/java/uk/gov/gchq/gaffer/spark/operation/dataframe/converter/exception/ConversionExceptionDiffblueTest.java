package uk.gov.gchq.gaffer.spark.operation.dataframe.converter.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConversionExceptionDiffblueTest {
  /**
   * Test {@link ConversionException#ConversionException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConversionException#ConversionException(String)}
   */
  @Test
  @DisplayName(
      "Test new ConversionException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConversionException.<init>(String)",
    "void ConversionException.<init>(String, Throwable)"
  })
  void testNewConversionException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    ConversionException actualConversionException = new ConversionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualConversionException.getMessage());
    assertNull(actualConversionException.getCause());
    assertEquals(0, actualConversionException.getSuppressed().length);
  }

  /**
   * Test {@link ConversionException#ConversionException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link ConversionException#ConversionException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new ConversionException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConversionException.<init>(String)",
    "void ConversionException.<init>(String, Throwable)"
  })
  void testNewConversionException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable e = new Throwable();

    // Act
    ConversionException actualConversionException = new ConversionException("An error occurred", e);

    // Assert
    assertEquals("An error occurred", actualConversionException.getMessage());
    assertEquals(0, actualConversionException.getSuppressed().length);
    assertSame(e, actualConversionException.getCause());
  }
}
