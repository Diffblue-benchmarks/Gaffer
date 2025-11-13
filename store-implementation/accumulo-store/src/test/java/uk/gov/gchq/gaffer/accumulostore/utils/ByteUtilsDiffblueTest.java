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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ByteUtilsDiffblueTest {
  /**
   * Test {@link ByteUtils#compareBytes(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtils#compareBytes(byte[], byte[])}
   */
  @Test
  @DisplayName("Test compareBytes(byte[], byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ByteUtils.compareBytes(byte[], byte[])"})
  void testCompareBytes_whenAxaxaxaxBytesIsUtf8_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ByteUtils.compareBytes(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtils#compareBytes(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return minus fifty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtils#compareBytes(byte[], byte[])}
   */
  @Test
  @DisplayName("Test compareBytes(byte[], byte[]); when 'XAXAXAX' Bytes is 'UTF-8'; then return minus fifty-seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ByteUtils.compareBytes(byte[], byte[])"})
  void testCompareBytes_whenXaxaxaxBytesIsUtf8_thenReturnMinusFiftySeven() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-57, ByteUtils.compareBytes(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)} with {@code a}, {@code b}.
   * <p>
   * Method under test: {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)}
   */
  @Test
  @DisplayName("Test areKeyBytesEqual(BytesAndRange, BytesAndRange) with 'a', 'b'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(BytesAndRange, BytesAndRange)"})
  void testAreKeyBytesEqualWithAB() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange a = new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 3, 3);

    // Act and Assert
    assertTrue(ByteUtils.areKeyBytesEqual(a, new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3)));
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)} with {@code a}, {@code b}.
   * <p>
   * Method under test: {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)}
   */
  @Test
  @DisplayName("Test areKeyBytesEqual(BytesAndRange, BytesAndRange) with 'a', 'b'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(BytesAndRange, BytesAndRange)"})
  void testAreKeyBytesEqualWithAB2() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange a = new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 1);

    // Act and Assert
    assertFalse(ByteUtils.areKeyBytesEqual(a, new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3)));
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)} with {@code a}, {@code b}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)}
   */
  @Test
  @DisplayName("Test areKeyBytesEqual(BytesAndRange, BytesAndRange) with 'a', 'b'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(BytesAndRange, BytesAndRange)"})
  void testAreKeyBytesEqualWithAB_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange a = new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Act and Assert
    assertTrue(ByteUtils.areKeyBytesEqual(a, new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3)));
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)} with {@code a}, {@code b}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)}
   */
  @Test
  @DisplayName("Test areKeyBytesEqual(BytesAndRange, BytesAndRange) with 'a', 'b'; when 'A'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(BytesAndRange, BytesAndRange)"})
  void testAreKeyBytesEqualWithAB_whenA_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange a = new BytesAndRange(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 3);

    // Act and Assert
    assertFalse(ByteUtils.areKeyBytesEqual(a, new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3)));
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(byte[], byte[])} with {@code bytes1}, {@code bytes2}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName("Test areKeyBytesEqual(byte[], byte[]) with 'bytes1', 'bytes2'; when 'A'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(byte[], byte[])"})
  void testAreKeyBytesEqualWithBytes1Bytes2_whenA_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(
        ByteUtils.areKeyBytesEqual(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(byte[], byte[])} with {@code bytes1}, {@code bytes2}.
   * <ul>
   *   <li>When {@code AAAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName("Test areKeyBytesEqual(byte[], byte[]) with 'bytes1', 'bytes2'; when 'AAAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(byte[], byte[])"})
  void testAreKeyBytesEqualWithBytes1Bytes2_whenAaaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AAAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtils.areKeyBytesEqual(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(byte[], byte[])} with {@code bytes1}, {@code bytes2}.
   * <ul>
   *   <li>When {@code AXAXAXAA} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName("Test areKeyBytesEqual(byte[], byte[]) with 'bytes1', 'bytes2'; when 'AXAXAXAA' Bytes is 'UTF-8'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(byte[], byte[])"})
  void testAreKeyBytesEqualWithBytes1Bytes2_whenAxaxaxaaBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAA".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtils.areKeyBytesEqual(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(byte[], byte[])} with {@code bytes1}, {@code bytes2}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName("Test areKeyBytesEqual(byte[], byte[]) with 'bytes1', 'bytes2'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(byte[], byte[])"})
  void testAreKeyBytesEqualWithBytes1Bytes2_whenAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtils.areKeyBytesEqual(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(byte[], byte[])} with {@code bytes1}, {@code bytes2}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName("Test areKeyBytesEqual(byte[], byte[]) with 'bytes1', 'bytes2'; when empty array of byte; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(byte[], byte[])"})
  void testAreKeyBytesEqualWithBytes1Bytes2_whenEmptyArrayOfByte_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ByteUtils.areKeyBytesEqual(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }
}
