package uk.gov.gchq.gaffer.commonutil.elementvisibilityutil.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VisibilityParseExceptionDiffblueTest {
  /**
   * Test {@link VisibilityParseException#VisibilityParseException(String, byte[], int)}.
   *
   * <p>Method under test: {@link VisibilityParseException#VisibilityParseException(String, byte[],
   * int)}
   */
  @Test
  @DisplayName("Test new VisibilityParseException(String, byte[], int)")
  @Tag("MaintainedByDiffblue")
  void testNewVisibilityParseException() throws UnsupportedEncodingException {
    // Arrange and Act
    VisibilityParseException actualVisibilityParseException =
        new VisibilityParseException("Just cause", "AXAXAXAX".getBytes("UTF-8"), -1);

    // Assert
    assertEquals(
        "Just cause in string 'AXAXAXAX' at position -1",
        actualVisibilityParseException.getLocalizedMessage());
    assertEquals(
        "Just cause in string 'AXAXAXAX' at position -1",
        actualVisibilityParseException.getMessage());
    assertNull(actualVisibilityParseException.getCause());
    assertEquals(-1, actualVisibilityParseException.getErrorOffset());
    assertEquals(0, actualVisibilityParseException.getSuppressed().length);
  }

  /**
   * Test {@link VisibilityParseException#getMessage()}.
   *
   * <p>Method under test: {@link VisibilityParseException#getMessage()}
   */
  @Test
  @DisplayName("Test getMessage()")
  @Tag("MaintainedByDiffblue")
  void testGetMessage() throws UnsupportedEncodingException {
    // Arrange
    VisibilityParseException visibilityParseException =
        new VisibilityParseException("Just cause", "AXAXAXAX".getBytes("UTF-8"), -1);

    // Act and Assert
    assertEquals(
        "Just cause in string 'AXAXAXAX' at position -1", visibilityParseException.getMessage());
  }
}
