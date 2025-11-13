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

package uk.gov.gchq.gaffer.accumulostore.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BytesAndRangeDiffblueTest {
  /**
   * Test {@link BytesAndRange#BytesAndRange(byte[], int, int)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link InvalidParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BytesAndRange#BytesAndRange(byte[], int, int)}
   */
  @Test
  @DisplayName("Test new BytesAndRange(byte[], int, int); when 'A'; then throw InvalidParameterException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BytesAndRange.<init>(byte[], int, int)"})
  void testNewBytesAndRange_whenA_thenThrowInvalidParameterException() {
    // Arrange, Act and Assert
    assertThrows(InvalidParameterException.class,
        () -> new BytesAndRange(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, -1, -1));

  }

  /**
   * Test {@link BytesAndRange#BytesAndRange(byte[], int, int)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return OffSet is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BytesAndRange#BytesAndRange(byte[], int, int)}
   */
  @Test
  @DisplayName("Test new BytesAndRange(byte[], int, int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return OffSet is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BytesAndRange.<init>(byte[], int, int)"})
  void testNewBytesAndRange_whenAxaxaxaxBytesIsUtf8_thenReturnOffSetIsOne() throws UnsupportedEncodingException {
    // Arrange and Act
    BytesAndRange actualBytesAndRange = new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    assertEquals(1, actualBytesAndRange.getOffSet());
    assertEquals(3, actualBytesAndRange.getLength());
    byte[] expectedBytes = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, actualBytesAndRange.getBytes());
  }

  /**
   * Test {@link BytesAndRange#BytesAndRange(byte[], int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then throw {@link InvalidParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BytesAndRange#BytesAndRange(byte[], int, int)}
   */
  @Test
  @DisplayName("Test new BytesAndRange(byte[], int, int); when zero; then throw InvalidParameterException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BytesAndRange.<init>(byte[], int, int)"})
  void testNewBytesAndRange_whenZero_thenThrowInvalidParameterException() {
    // Arrange, Act and Assert
    assertThrows(InvalidParameterException.class,
        () -> new BytesAndRange(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, -1, 0));

  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BytesAndRange#getBytes()}
   *   <li>{@link BytesAndRange#getLength()}
   *   <li>{@link BytesAndRange#getOffSet()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] BytesAndRange.getBytes()", "int BytesAndRange.getLength()",
      "int BytesAndRange.getOffSet()"})
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange bytesAndRange = new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Act
    byte[] actualBytes = bytesAndRange.getBytes();
    int actualLength = bytesAndRange.getLength();

    // Assert
    assertEquals(1, bytesAndRange.getOffSet());
    assertEquals(3, actualLength);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBytes);
  }
}
