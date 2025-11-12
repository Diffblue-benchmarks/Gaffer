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
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;

class ByteArrayEscapeUtilsDiffblueTest {
  /**
   * Method under test: {@link ByteArrayEscapeUtils#escape(byte[], byte[])}
   */
  @Test
  void testEscape() throws UnsupportedEncodingException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");

    // Act
    byte[] actualEscapeResult = ByteArrayEscapeUtils.escape(bytes, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAXAXAXAXAX".getBytes("UTF-8"), actualEscapeResult);
  }

  /**
   * Method under test: {@link ByteArrayEscapeUtils#escape(byte[], byte[])}
   */
  @Test
  void testEscape2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 2, 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X',
            'A', 'X', 'A', 'X'},
        ByteArrayEscapeUtils.escape(
            new byte[]{ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteArrayEscapeUtils#escape(byte[], byte[])}
   */
  @Test
  void testEscape3() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'X', 'A', 'X', 'A',
            'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
        ByteArrayEscapeUtils.escape(new byte[]{ByteArrayEscapeUtils.DELIMITER, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[])}
   */
  @Test
  void testUnEscape() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualUnEscapeResult = ByteArrayEscapeUtils.unEscape("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualUnEscapeResult);
  }

  /**
   * Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[])}
   */
  @Test
  void testUnEscape2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualUnEscapeResult = ByteArrayEscapeUtils
        .unEscape(new byte[]{ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualUnEscapeResult);
  }

  /**
   * Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[])}
   */
  @Test
  void testUnEscape3() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{ByteArrayEscapeUtils.DELIMITER, 'A', 'X', 'A', 'X', 'A', 'X'},
        ByteArrayEscapeUtils.unEscape(new byte[]{ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
            ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[])}
   */
  @Test
  void testUnEscape4() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'A', 'X', 'A', 'X', 'A', 'X'},
        ByteArrayEscapeUtils
            .unEscape(new byte[]{ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)}
   */
  @Test
  void testUnEscape5() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'X', 'A'}, ByteArrayEscapeUtils.unEscape("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)}
   */
  @Test
  void testUnEscape6() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'A'}, ByteArrayEscapeUtils
        .unEscape(new byte[]{'A', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 3));
  }

  /**
   * Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)}
   */
  @Test
  void testUnEscape7() {
    // Arrange, Act and Assert
    assertThrows(InvalidParameterException.class, () -> ByteArrayEscapeUtils.unEscape(new byte[]{}, 1, 3));
  }

  /**
   * Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)}
   */
  @Test
  void testUnEscape8() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualUnEscapeResult = ByteArrayEscapeUtils.unEscape("AXAXAXAX".getBytes("UTF-8"), 1, 8);

    // Assert
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualUnEscapeResult);
  }

  /**
   * Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)}
   */
  @Test
  void testUnEscape9() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{ByteArrayEscapeUtils.DELIMITER},
        ByteArrayEscapeUtils.unEscape(new byte[]{'A', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
            ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'X', 'A', 'X', 'A', 'X'}, 1, 3));
  }

  /**
   * Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)}
   */
  @Test
  void testUnEscape10() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{ByteArrayEscapeUtils.DELIMITER_PLUS_ONE}, ByteArrayEscapeUtils
        .unEscape(new byte[]{'A', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 2, 'X', 'A', 'X', 'A', 'X'}, 1, 3));
  }

  /**
   * Method under test:
   * {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}
   */
  @Test
  void testUnEscapeByPosition() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'X', 'A'},
        ByteArrayEscapeUtils.unEscapeByPosition("AXAXAXAX".getBytes("UTF-8"), 1, 3));
    assertArrayEquals(new byte[]{'A'}, ByteArrayEscapeUtils.unEscapeByPosition(
        new byte[]{'A', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 3));
    assertThrows(InvalidParameterException.class, () -> ByteArrayEscapeUtils.unEscapeByPosition(new byte[]{}, 1, 3));
    assertArrayEquals(new byte[]{ByteArrayEscapeUtils.DELIMITER},
        ByteArrayEscapeUtils.unEscapeByPosition(new byte[]{'A', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
            ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'X', 'A', 'X', 'A', 'X'}, 1, 3));
    assertArrayEquals(new byte[]{ByteArrayEscapeUtils.DELIMITER_PLUS_ONE}, ByteArrayEscapeUtils.unEscapeByPosition(
        new byte[]{'A', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 2, 'X', 'A', 'X', 'A', 'X'}, 1, 3));
  }

  /**
   * Method under test:
   * {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}
   */
  @Test
  void testUnEscapeByPosition2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualUnEscapeByPositionResult = ByteArrayEscapeUtils.unEscapeByPosition("AXAXAXAX".getBytes("UTF-8"), 1, 8);

    // Assert
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), actualUnEscapeByPositionResult);
  }

  /**
   * Method under test:
   * {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}
   */
  @Test
  void testUnEscapeByLength() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualUnEscapeByLengthResult = ByteArrayEscapeUtils.unEscapeByLength("AXAXAXAX".getBytes("UTF-8"), 2, 3);

    // Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), actualUnEscapeByLengthResult);
  }

  /**
   * Method under test:
   * {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}
   */
  @Test
  void testUnEscapeByLength2() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'X', 'A'}, ByteArrayEscapeUtils.unEscapeByLength(
        new byte[]{'A', 'X', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'X', 'A', 'X', 'A', 'X'}, 2, 3));
  }

  /**
   * Method under test:
   * {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}
   */
  @Test
  void testUnEscapeByLength3() {
    // Arrange, Act and Assert
    assertThrows(InvalidParameterException.class, () -> ByteArrayEscapeUtils.unEscapeByLength(new byte[]{}, 2, 3));
  }

  /**
   * Method under test:
   * {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}
   */
  @Test
  void testUnEscapeByLength4() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualUnEscapeByLengthResult = ByteArrayEscapeUtils.unEscapeByLength("AXAXAXAX".getBytes("UTF-8"), 5, 3);

    // Assert
    assertArrayEquals("XAX".getBytes("UTF-8"), actualUnEscapeByLengthResult);
  }

  /**
   * Method under test:
   * {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}
   */
  @Test
  void testUnEscapeByLength5() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'A'}, ByteArrayEscapeUtils
        .unEscapeByLength(new byte[]{'A', 'X', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 2, 'A', 'X', 'A', 'X'}, 2, 3));
  }

  /**
   * Method under test:
   * {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}
   */
  @Test
  void testUnEscapeByLength6() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{ByteArrayEscapeUtils.DELIMITER, 'A'},
        ByteArrayEscapeUtils.unEscapeByLength(new byte[]{'A', 'X', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
            ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'A', 'X', 'A', 'X'}, 2, 3));
  }
}
