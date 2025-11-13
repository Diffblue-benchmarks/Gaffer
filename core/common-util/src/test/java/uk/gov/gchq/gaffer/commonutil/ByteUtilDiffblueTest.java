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

package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ByteUtilDiffblueTest {
  /**
   * Test {@link ByteUtil#compareSortedBytes(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#compareSortedBytes(byte[], byte[])}
   */
  @Test
  @DisplayName("Test compareSortedBytes(byte[], byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ByteUtil.compareSortedBytes(byte[], byte[])"})
  void testCompareSortedBytes_whenAxaxaxaxBytesIsUtf8_thenReturnZero() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ByteUtil.compareSortedBytes(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#compareSortedBytes(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return minus fifty-seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#compareSortedBytes(byte[], byte[])}
   */
  @Test
  @DisplayName("Test compareSortedBytes(byte[], byte[]); when 'XAXAXAX' Bytes is 'UTF-8'; then return minus fifty-seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ByteUtil.compareSortedBytes(byte[], byte[])"})
  void testCompareSortedBytes_whenXaxaxaxBytesIsUtf8_thenReturnMinusFiftySeven() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-57, ByteUtil.compareSortedBytes(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAA} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName("Test areSortedBytesEqual(byte[], byte[]); when 'AXAXAXAA' Bytes is 'UTF-8'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtil.areSortedBytesEqual(byte[], byte[])"})
  void testAreSortedBytesEqual_whenAxaxaxaaBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAA".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.areSortedBytesEqual(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName("Test areSortedBytesEqual(byte[], byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtil.areSortedBytesEqual(byte[], byte[])"})
  void testAreSortedBytesEqual_whenAxaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.areSortedBytesEqual(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName("Test areSortedBytesEqual(byte[], byte[]); when empty array of byte; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtil.areSortedBytesEqual(byte[], byte[])"})
  void testAreSortedBytesEqual_whenEmptyArrayOfByte_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ByteUtil.areSortedBytesEqual(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName("Test areSortedBytesEqual(byte[], byte[]); when empty array of byte; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtil.areSortedBytesEqual(byte[], byte[])"})
  void testAreSortedBytesEqual_whenEmptyArrayOfByte_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ByteUtil.areSortedBytesEqual(new byte[]{}, new byte[]{}));
  }

  /**
   * Test {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}.
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}
   */
  @Test
  @DisplayName("Test areSortedBytesEqual(byte[], byte[]); when 'XAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ByteUtil.areSortedBytesEqual(byte[], byte[])"})
  void testAreSortedBytesEqual_whenXaxaxaxBytesIsUtf8_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.areSortedBytesEqual(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }
}
