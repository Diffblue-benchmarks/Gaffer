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
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class ByteUtilDiffblueTest {
  /**
   * Method under test: {@link ByteUtil#compareSortedBytes(byte[], byte[])}
   */
  @Test
  void testCompareSortedBytes() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ByteUtil.compareSortedBytes(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#compareSortedBytes(byte[], byte[])}
   */
  @Test
  void testCompareSortedBytes2() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-57, ByteUtil.compareSortedBytes(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}
   */
  @Test
  void testAreSortedBytesEqual() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue(ByteUtil.areSortedBytesEqual(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}
   */
  @Test
  void testAreSortedBytesEqual2() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "\bXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.areSortedBytesEqual(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}
   */
  @Test
  void testAreSortedBytesEqual3() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes1 = "AXAXAXAA".getBytes("UTF-8");

    // Act and Assert
    assertFalse(ByteUtil.areSortedBytesEqual(bytes1, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}
   */
  @Test
  void testAreSortedBytesEqual4() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(ByteUtil.areSortedBytesEqual(new byte[]{}, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteUtil#areSortedBytesEqual(byte[], byte[])}
   */
  @Test
  void testAreSortedBytesEqual5() {
    // Arrange, Act and Assert
    assertTrue(ByteUtil.areSortedBytesEqual(new byte[]{}, new byte[]{}));
  }
}
