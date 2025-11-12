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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;

class BytesAndRangeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BytesAndRange#getBytes()}
   *   <li>{@link BytesAndRange#getLength()}
   *   <li>{@link BytesAndRange#getOffSet()}
   * </ul>
   */
  @Test
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

  /**
   * Method under test: {@link BytesAndRange#BytesAndRange(byte[], int, int)}
   */
  @Test
  void testNewBytesAndRange() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    BytesAndRange actualBytesAndRange = new BytesAndRange(bytes, 1, 3);

    // Assert
    assertEquals(1, actualBytesAndRange.getOffSet());
    assertEquals(3, actualBytesAndRange.getLength());
    assertSame(bytes, actualBytesAndRange.getBytes());
  }

  /**
   * Method under test: {@link BytesAndRange#BytesAndRange(byte[], int, int)}
   */
  @Test
  void testNewBytesAndRange2() {
    // Arrange, Act and Assert
    assertThrows(InvalidParameterException.class,
        () -> new BytesAndRange(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, -1, -1));

  }

  /**
   * Method under test: {@link BytesAndRange#BytesAndRange(byte[], int, int)}
   */
  @Test
  void testNewBytesAndRange3() {
    // Arrange, Act and Assert
    assertThrows(InvalidParameterException.class,
        () -> new BytesAndRange(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, -1, 0));

  }
}
