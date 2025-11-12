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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class ByteUtilsDiffblueTest {
  /**
   * Method under test: {@link ByteUtils#compareBytes(byte[], byte[])}
   */
  @Test
  void testCompareBytes() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ByteUtils.compareBytes(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtils#compareBytes(byte[], byte[])}
   */
  @Test
  void testCompareBytes2() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-57, ByteUtils.compareBytes(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)}
   */
  @Test
  void testAreKeyBytesEqual() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange a = new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Act and Assert
    assertTrue(ByteUtils.areKeyBytesEqual(a, new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3)));
  }

  /**
   * Method under test:
   * {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)}
   */
  @Test
  void testAreKeyBytesEqual2() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange a = new BytesAndRange(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 3);

    // Act and Assert
    assertFalse(ByteUtils.areKeyBytesEqual(a, new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3)));
  }

  /**
   * Method under test:
   * {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)}
   */
  @Test
  void testAreKeyBytesEqual3() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange a = new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 3, 3);

    // Act and Assert
    assertTrue(ByteUtils.areKeyBytesEqual(a, new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3)));
  }

  /**
   * Method under test:
   * {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)}
   */
  @Test
  void testAreKeyBytesEqual4() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange a = new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 1);

    // Act and Assert
    assertFalse(ByteUtils.areKeyBytesEqual(a, new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3)));
  }

  /**
   * Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  void testAreKeyBytesEqual5() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtils.areKeyBytesEqual(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  void testAreKeyBytesEqual6() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(
        ByteUtils.areKeyBytesEqual(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  void testAreKeyBytesEqual7() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AAAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtils.areKeyBytesEqual(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  void testAreKeyBytesEqual8() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAA".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtils.areKeyBytesEqual(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  void testAreKeyBytesEqual9() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ByteUtils.areKeyBytesEqual(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }
}
