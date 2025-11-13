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

package uk.gov.gchq.gaffer.commonutil.elementvisibilityutil.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VisibilityParseExceptionDiffblueTest {
  /**
   * Test {@link VisibilityParseException#VisibilityParseException(String, byte[], int)}.
   * <p>
   * Method under test: {@link VisibilityParseException#VisibilityParseException(String, byte[], int)}
   */
  @Test
  @DisplayName("Test new VisibilityParseException(String, byte[], int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VisibilityParseException.<init>(String, byte[], int)"})
  void testNewVisibilityParseException() throws UnsupportedEncodingException {
    // Arrange and Act
    VisibilityParseException actualVisibilityParseException = new VisibilityParseException("Just cause",
        "AXAXAXAX".getBytes("UTF-8"), -1);

    // Assert
    assertEquals("Just cause in string 'AXAXAXAX' at position -1",
        actualVisibilityParseException.getLocalizedMessage());
    assertEquals("Just cause in string 'AXAXAXAX' at position -1", actualVisibilityParseException.getMessage());
    assertNull(actualVisibilityParseException.getCause());
    assertEquals(-1, actualVisibilityParseException.getErrorOffset());
    assertEquals(0, actualVisibilityParseException.getSuppressed().length);
  }

  /**
   * Test {@link VisibilityParseException#getMessage()}.
   * <p>
   * Method under test: {@link VisibilityParseException#getMessage()}
   */
  @Test
  @DisplayName("Test getMessage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String VisibilityParseException.getMessage()"})
  void testGetMessage() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("Just cause in string 'AXAXAXAX' at position -1",
        (new VisibilityParseException("Just cause", "AXAXAXAX".getBytes("UTF-8"), -1)).getMessage());
  }
}
