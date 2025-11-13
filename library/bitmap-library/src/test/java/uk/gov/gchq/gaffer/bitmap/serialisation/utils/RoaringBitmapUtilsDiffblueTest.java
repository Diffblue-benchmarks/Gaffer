/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.bitmap.serialisation.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class RoaringBitmapUtilsDiffblueTest {
  /**
   * Test {@link RoaringBitmapUtils#upConvertSerialisedForm(byte[], int, int)}.
   * <ul>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoaringBitmapUtils#upConvertSerialisedForm(byte[], int, int)}
   */
  @Test
  @DisplayName("Test upConvertSerialisedForm(byte[], int, int); then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RoaringBitmapUtils.upConvertSerialisedForm(byte[], int, int)"})
  void testUpConvertSerialisedForm_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class,
        () -> RoaringBitmapUtils.upConvertSerialisedForm("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link RoaringBitmapUtils#upConvertSerialisedForm(byte[], int, int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoaringBitmapUtils#upConvertSerialisedForm(byte[], int, int)}
   */
  @Test
  @DisplayName("Test upConvertSerialisedForm(byte[], int, int); when four; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RoaringBitmapUtils.upConvertSerialisedForm(byte[], int, int)"})
  void testUpConvertSerialisedForm_whenFour_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class,
        () -> RoaringBitmapUtils.upConvertSerialisedForm("AXAXAXAX".getBytes("UTF-8"), 2, 4));
  }
}
