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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class StringUtilDiffblueTest {
  /**
   * Method under test: {@link StringUtil#toString(byte[])}
   */
  @Test
  void testToString() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", StringUtil.toString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link StringUtil#toBytes(String)}
   */
  @Test
  void testToBytes() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualToBytesResult = StringUtil.toBytes("String");

    // Assert
    assertArrayEquals("String".getBytes("UTF-8"), actualToBytesResult);
  }

  /**
   * Method under test: {@link StringUtil#toBytes(String)}
   */
  @Test
  void testToBytes2() {
    // Arrange, Act and Assert
    assertEquals(0, StringUtil.toBytes(null).length);
  }

  /**
   * Method under test: {@link StringUtil#escapeComma(String)}
   */
  @Test
  void testEscapeComma() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtil.escapeComma("Str"));
    assertEquals("\\\\", StringUtil.escapeComma(","));
  }

  /**
   * Method under test: {@link StringUtil#unescapeComma(String)}
   */
  @Test
  void testUnescapeComma() {
    // Arrange, Act and Assert
    assertEquals("Escaped Str", StringUtil.unescapeComma("Escaped Str"));
  }

  /**
   * Method under test: {@link StringUtil#toCsv(Class[])}
   */
  @Test
  void testToCsv() throws UnsupportedEncodingException {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    byte[] actualToCsvResult = StringUtil.toCsv(forNameResult);

    // Assert
    assertArrayEquals("java.lang.Object".getBytes("UTF-8"), actualToCsvResult);
  }

  /**
   * Method under test: {@link StringUtil#toCsv(Class[])}
   */
  @Test
  void testToCsv2() {
    // Arrange, Act and Assert
    assertEquals(0, StringUtil.toCsv().length);
  }

  /**
   * Method under test: {@link StringUtil#csvToClasses(byte[], Class)}
   */
  @Test
  void testCsvToClasses() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StringUtil.csvToClasses(bytes, clazz));
  }

  /**
   * Method under test: {@link StringUtil#csvToClasses(byte[], Class)}
   */
  @Test
  void testCsvToClasses2() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = ",XAXAXAX".getBytes("UTF-8");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StringUtil.csvToClasses(bytes, clazz));
  }

  /**
   * Method under test: {@link StringUtil#nullIfEmpty(String)}
   */
  @Test
  void testNullIfEmpty() {
    // Arrange, Act and Assert
    assertEquals("String", StringUtil.nullIfEmpty("String"));
    assertNull(StringUtil.nullIfEmpty(null));
    assertNull(StringUtil.nullIfEmpty(""));
  }
}
