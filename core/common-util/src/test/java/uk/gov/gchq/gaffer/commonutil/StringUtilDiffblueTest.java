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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringUtilDiffblueTest {
  /**
   * Test {@link StringUtil#toString(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link StringUtil#toString(byte[])}
   */
  @Test
  @DisplayName("Test toString(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtil.toString(byte[])"})
  void testToStringWithByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("AXAXAXAX", StringUtil.toString("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link StringUtil#toBytes(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#toBytes(String)}
   */
  @Test
  @DisplayName("Test toBytes(String); when 'null'; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] StringUtil.toBytes(String)"})
  void testToBytes_whenNull_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, StringUtil.toBytes(null));
  }

  /**
   * Test {@link StringUtil#toBytes(String)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code String} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#toBytes(String)}
   */
  @Test
  @DisplayName("Test toBytes(String); when 'String'; then return 'String' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] StringUtil.toBytes(String)"})
  void testToBytes_whenString_thenReturnStringBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualToBytesResult = StringUtil.toBytes("String");

    // Assert
    assertArrayEquals("String".getBytes("UTF-8"), actualToBytesResult);
  }

  /**
   * Test {@link StringUtil#escapeComma(String)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then return {@code \\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#escapeComma(String)}
   */
  @Test
  @DisplayName("Test escapeComma(String); when ','; then return '\\\\'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtil.escapeComma(String)"})
  void testEscapeComma_whenComma_thenReturnBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\\\", StringUtil.escapeComma(","));
  }

  /**
   * Test {@link StringUtil#escapeComma(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#escapeComma(String)}
   */
  @Test
  @DisplayName("Test escapeComma(String); when 'Str'; then return 'Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtil.escapeComma(String)"})
  void testEscapeComma_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtil.escapeComma("Str"));
  }

  /**
   * Test {@link StringUtil#unescapeComma(String)}.
   * <p>
   * Method under test: {@link StringUtil#unescapeComma(String)}
   */
  @Test
  @DisplayName("Test unescapeComma(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtil.unescapeComma(String)"})
  void testUnescapeComma() {
    // Arrange, Act and Assert
    assertEquals("Escaped Str", StringUtil.unescapeComma("Escaped Str"));
  }

  /**
   * Test {@link StringUtil#toCsv(Class[])}.
   * <ul>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#toCsv(Class[])}
   */
  @Test
  @DisplayName("Test toCsv(Class[]); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] StringUtil.toCsv(Class[])"})
  void testToCsv_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, StringUtil.toCsv());
  }

  /**
   * Test {@link StringUtil#toCsv(Class[])}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code Object} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#toCsv(Class[])}
   */
  @Test
  @DisplayName("Test toCsv(Class[]); when 'java.lang.Object'; then return 'java.lang.Object' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] StringUtil.toCsv(Class[])"})
  void testToCsv_whenJavaLangObject_thenReturnJavaLangObjectBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Class<Object> forNameResult = Object.class;

    // Act
    byte[] actualToCsvResult = StringUtil.toCsv(forNameResult);

    // Assert
    assertArrayEquals("java.lang.Object".getBytes("UTF-8"), actualToCsvResult);
  }

  /**
   * Test {@link StringUtil#csvToClasses(byte[], Class)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#csvToClasses(byte[], Class)}
   */
  @Test
  @DisplayName("Test csvToClasses(byte[], Class); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set StringUtil.csvToClasses(byte[], Class)"})
  void testCsvToClasses_whenAxaxaxaxBytesIsUtf8_thenThrowRuntimeException() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StringUtil.csvToClasses(bytes, clazz));
  }

  /**
   * Test {@link StringUtil#csvToClasses(byte[], Class)}.
   * <ul>
   *   <li>When {@code ,XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#csvToClasses(byte[], Class)}
   */
  @Test
  @DisplayName("Test csvToClasses(byte[], Class); when ',XAXAXAX' Bytes is 'UTF-8'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set StringUtil.csvToClasses(byte[], Class)"})
  void testCsvToClasses_whenXaxaxaxBytesIsUtf8_thenThrowRuntimeException() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = ",XAXAXAX".getBytes("UTF-8");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(RuntimeException.class, () -> StringUtil.csvToClasses(bytes, clazz));
  }

  /**
   * Test {@link StringUtil#nullIfEmpty(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#nullIfEmpty(String)}
   */
  @Test
  @DisplayName("Test nullIfEmpty(String); when empty string; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtil.nullIfEmpty(String)"})
  void testNullIfEmpty_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtil.nullIfEmpty(""));
  }

  /**
   * Test {@link StringUtil#nullIfEmpty(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#nullIfEmpty(String)}
   */
  @Test
  @DisplayName("Test nullIfEmpty(String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtil.nullIfEmpty(String)"})
  void testNullIfEmpty_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtil.nullIfEmpty(null));
  }

  /**
   * Test {@link StringUtil#nullIfEmpty(String)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#nullIfEmpty(String)}
   */
  @Test
  @DisplayName("Test nullIfEmpty(String); when 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtil.nullIfEmpty(String)"})
  void testNullIfEmpty_whenString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String", StringUtil.nullIfEmpty("String"));
  }
}
