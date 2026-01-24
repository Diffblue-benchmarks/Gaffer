/*
 * Copyright 2026 Crown Copyright
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ByteUtilsDiffblueTest {
  /**
   * Test {@link ByteUtils#compareBytes(byte[], byte[])}.
   *
   * <ul>
   *   <li>Then return minus eighty.
   * </ul>
   *
   * <p>Method under test: {@link ByteUtils#compareBytes(byte[], byte[])}
   */
  @Test
  @DisplayName("Test compareBytes(byte[], byte[]); then return minus eighty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ByteUtils.compareBytes(byte[], byte[])"})
  void testCompareBytes_thenReturnMinusEighty() throws UnsupportedEncodingException {
    // Arrange and Act
    int actualCompareBytesResult =
        ByteUtils.compareBytes(
            "A\bA\bA\bA\bA\bA\bA\bA\b".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(-80, actualCompareBytesResult);
  }

  /**
   * Test {@link ByteUtils#compareBytes(byte[], byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ByteUtils#compareBytes(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test compareBytes(byte[], byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ByteUtils.compareBytes(byte[], byte[])"})
  void testCompareBytes_whenAxaxaxaxBytesIsUtf8_thenReturnZero()
      throws UnsupportedEncodingException {
    // Arrange and Act
    int actualCompareBytesResult =
        ByteUtils.compareBytes("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(0, actualCompareBytesResult);
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)} with {@code a}, {@code
   * b}.
   *
   * <p>Method under test: {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)}
   */
  @Test
  @DisplayName("Test areKeyBytesEqual(BytesAndRange, BytesAndRange) with 'a', 'b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(BytesAndRange, BytesAndRange)"})
  void testAreKeyBytesEqualWithAB() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange a = new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 3, 3);

    // Act
    boolean actualAreKeyBytesEqualResult =
        ByteUtils.areKeyBytesEqual(a, new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3));

    // Assert
    assertTrue(actualAreKeyBytesEqualResult);
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)} with {@code a}, {@code
   * b}.
   *
   * <p>Method under test: {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)}
   */
  @Test
  @DisplayName("Test areKeyBytesEqual(BytesAndRange, BytesAndRange) with 'a', 'b'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(BytesAndRange, BytesAndRange)"})
  void testAreKeyBytesEqualWithAB2() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange a = new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 1);

    // Act
    boolean actualAreKeyBytesEqualResult =
        ByteUtils.areKeyBytesEqual(a, new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3));

    // Assert
    assertFalse(actualAreKeyBytesEqualResult);
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)} with {@code a}, {@code
   * b}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)}
   */
  @Test
  @DisplayName(
      "Test areKeyBytesEqual(BytesAndRange, BytesAndRange) with 'a', 'b'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(BytesAndRange, BytesAndRange)"})
  void testAreKeyBytesEqualWithAB_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange a = new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Act
    boolean actualAreKeyBytesEqualResult =
        ByteUtils.areKeyBytesEqual(a, new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3));

    // Assert
    assertTrue(actualAreKeyBytesEqualResult);
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)} with {@code a}, {@code
   * b}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteUtils#areKeyBytesEqual(BytesAndRange, BytesAndRange)}
   */
  @Test
  @DisplayName(
      "Test areKeyBytesEqual(BytesAndRange, BytesAndRange) with 'a', 'b'; when 'A'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(BytesAndRange, BytesAndRange)"})
  void testAreKeyBytesEqualWithAB_whenA_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    BytesAndRange a =
        new BytesAndRange(
            new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3}, 1, 3);

    // Act
    boolean actualAreKeyBytesEqualResult =
        ByteUtils.areKeyBytesEqual(a, new BytesAndRange("AXAXAXAX".getBytes("UTF-8"), 1, 3));

    // Assert
    assertFalse(actualAreKeyBytesEqualResult);
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(byte[], byte[])} with {@code bytes1}, {@code bytes2}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test areKeyBytesEqual(byte[], byte[]) with 'bytes1', 'bytes2'; when 'A'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(byte[], byte[])"})
  void testAreKeyBytesEqualWithBytes1Bytes2_whenA_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualAreKeyBytesEqualResult =
        ByteUtils.areKeyBytesEqual(
            new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualAreKeyBytesEqualResult);
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(byte[], byte[])} with {@code bytes1}, {@code bytes2}.
   *
   * <ul>
   *   <li>When {@code AAAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test areKeyBytesEqual(byte[], byte[]) with 'bytes1', 'bytes2'; when 'AAAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(byte[], byte[])"})
  void testAreKeyBytesEqualWithBytes1Bytes2_whenAaaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualAreKeyBytesEqualResult =
        ByteUtils.areKeyBytesEqual("AAAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualAreKeyBytesEqualResult);
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(byte[], byte[])} with {@code bytes1}, {@code bytes2}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAA} Bytes is {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test areKeyBytesEqual(byte[], byte[]) with 'bytes1', 'bytes2'; when 'AXAXAXAA' Bytes is 'UTF-8'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(byte[], byte[])"})
  void testAreKeyBytesEqualWithBytes1Bytes2_whenAxaxaxaaBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualAreKeyBytesEqualResult =
        ByteUtils.areKeyBytesEqual("AXAXAXAA".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualAreKeyBytesEqualResult);
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(byte[], byte[])} with {@code bytes1}, {@code bytes2}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test areKeyBytesEqual(byte[], byte[]) with 'bytes1', 'bytes2'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(byte[], byte[])"})
  void testAreKeyBytesEqualWithBytes1Bytes2_whenAxaxaxaxBytesIsUtf8_thenReturnTrue()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualAreKeyBytesEqualResult =
        ByteUtils.areKeyBytesEqual("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertTrue(actualAreKeyBytesEqualResult);
  }

  /**
   * Test {@link ByteUtils#areKeyBytesEqual(byte[], byte[])} with {@code bytes1}, {@code bytes2}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ByteUtils#areKeyBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test areKeyBytesEqual(byte[], byte[]) with 'bytes1', 'bytes2'; when empty array of byte; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ByteUtils.areKeyBytesEqual(byte[], byte[])"})
  void testAreKeyBytesEqualWithBytes1Bytes2_whenEmptyArrayOfByte_thenReturnFalse()
      throws UnsupportedEncodingException {
    // Arrange and Act
    boolean actualAreKeyBytesEqualResult =
        ByteUtils.areKeyBytesEqual(new byte[] {}, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertFalse(actualAreKeyBytesEqualResult);
  }
}
