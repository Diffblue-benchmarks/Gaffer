package uk.gov.gchq.gaffer.bitmap.serialisation.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class RoaringBitmapUtilsDiffblueTest {
  /**
   * Test {@link RoaringBitmapUtils#upConvertSerialisedForm(byte[], int, int)}.
   *
   * <ul>
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapUtils#upConvertSerialisedForm(byte[], int, int)}
   */
  @Test
  @DisplayName("Test upConvertSerialisedForm(byte[], int, int); then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  void testUpConvertSerialisedForm_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () -> RoaringBitmapUtils.upConvertSerialisedForm("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link RoaringBitmapUtils#upConvertSerialisedForm(byte[], int, int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapUtils#upConvertSerialisedForm(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test upConvertSerialisedForm(byte[], int, int); when four; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  void testUpConvertSerialisedForm_whenFour_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertThrows(
        SerialisationException.class,
        () -> RoaringBitmapUtils.upConvertSerialisedForm("AXAXAXAX".getBytes("UTF-8"), 2, 4));
  }
}
