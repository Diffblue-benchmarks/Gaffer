package uk.gov.gchq.gaffer.commonutil;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ByteArrayEscapeUtilsDiffblueTest {
  /**
   * Test {@link ByteArrayEscapeUtils#escape(byte[], byte[])} with {@code bytes}, {@code
   * appendAfterEscaping}.
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#escape(byte[], byte[])}
   */
  @Test
  @DisplayName("Test escape(byte[], byte[]) with 'bytes', 'appendAfterEscaping'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.escape(byte[], byte[])"})
  void testEscapeWithBytesAppendAfterEscaping() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualEscapeResult =
        ByteArrayEscapeUtils.escape(
            new byte[] {ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
          2,
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X'
        },
        actualEscapeResult);
  }

  /**
   * Test {@link ByteArrayEscapeUtils#escape(byte[], byte[])} with {@code bytes}, {@code
   * appendAfterEscaping}.
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#escape(byte[], byte[])}
   */
  @Test
  @DisplayName("Test escape(byte[], byte[]) with 'bytes', 'appendAfterEscaping'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.escape(byte[], byte[])"})
  void testEscapeWithBytesAppendAfterEscaping2() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualEscapeResult =
        ByteArrayEscapeUtils.escape(
            new byte[] {ByteArrayEscapeUtils.DELIMITER, 'X', 'A', 'X', 'A', 'X', 'A', 'X'},
            "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals(
        new byte[] {
          ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
          ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X',
          'A',
          'X'
        },
        actualEscapeResult);
  }

  /**
   * Test {@link ByteArrayEscapeUtils#escape(byte[], byte[])} with {@code bytes}, {@code
   * appendAfterEscaping}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAXAXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#escape(byte[], byte[])}
   */
  @Test
  @DisplayName(
      "Test escape(byte[], byte[]) with 'bytes', 'appendAfterEscaping'; then return 'AXAXAXAXAXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.escape(byte[], byte[])"})
  void testEscapeWithBytesAppendAfterEscaping_thenReturnAxaxaxaxaxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualEscapeResult =
        ByteArrayEscapeUtils.escape("AXAXAXAX".getBytes("UTF-8"), "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAXAXAXAXAX".getBytes("UTF-8"), actualEscapeResult);
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)} with {@code allBytes}, {@code
   * start}, {@code end}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@link ByteArrayEscapeUtils#DELIMITER_PLUS_ONE}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscape(byte[], int, int) with 'allBytes', 'start', 'end'; then return array of byte with DELIMITER_PLUS_ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscape(byte[], int, int)"})
  void testUnEscapeWithAllBytesStartEnd_thenReturnArrayOfByteWithDelimiter_plus_one() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {ByteArrayEscapeUtils.DELIMITER_PLUS_ONE},
        ByteArrayEscapeUtils.unEscape(
            new byte[] {'A', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 2, 'X', 'A', 'X', 'A', 'X'},
            1,
            3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)} with {@code allBytes}, {@code
   * start}, {@code end}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@code X} and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscape(byte[], int, int) with 'allBytes', 'start', 'end'; then return array of byte with 'X' and 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscape(byte[], int, int)"})
  void testUnEscapeWithAllBytesStartEnd_thenReturnArrayOfByteWithXAndA()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'X', 'A'}, ByteArrayEscapeUtils.unEscape("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)} with {@code allBytes}, {@code
   * start}, {@code end}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscape(byte[], int, int) with 'allBytes', 'start', 'end'; then throw InvalidParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscape(byte[], int, int)"})
  void testUnEscapeWithAllBytesStartEnd_thenThrowInvalidParameterException() {
    // Arrange, Act and Assert
    assertThrows(
        InvalidParameterException.class, () -> ByteArrayEscapeUtils.unEscape(new byte[] {}, 1, 3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)} with {@code allBytes}, {@code
   * start}, {@code end}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return array of {@code byte} with {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscape(byte[], int, int) with 'allBytes', 'start', 'end'; when 'A'; then return array of byte with 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscape(byte[], int, int)"})
  void testUnEscapeWithAllBytesStartEnd_whenA_thenReturnArrayOfByteWithA() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'A'},
        ByteArrayEscapeUtils.unEscape(
            new byte[] {'A', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'A', 'X', 'A', 'X', 'A', 'X'},
            1,
            3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)} with {@code allBytes}, {@code
   * start}, {@code end}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscape(byte[], int, int) with 'allBytes', 'start', 'end'; when eight; then return 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscape(byte[], int, int)"})
  void testUnEscapeWithAllBytesStartEnd_whenEight_thenReturnXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "XAXAXAX".getBytes("UTF-8"),
        ByteArrayEscapeUtils.unEscape("AXAXAXAX".getBytes("UTF-8"), 1, 8));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)} with {@code allBytes}, {@code
   * start}, {@code end}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return array of {@code byte} with {@link ByteArrayEscapeUtils#DELIMITER}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscape(byte[], int, int) with 'allBytes', 'start', 'end'; when 'X'; then return array of byte with DELIMITER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscape(byte[], int, int)"})
  void testUnEscapeWithAllBytesStartEnd_whenX_thenReturnArrayOfByteWithDelimiter() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {ByteArrayEscapeUtils.DELIMITER},
        ByteArrayEscapeUtils.unEscape(
            new byte[] {
              'A',
              ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
              ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
              'X',
              'A',
              'X',
              'A',
              'X'
            },
            1,
            3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscape(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@link ByteArrayEscapeUtils#DELIMITER} and {@code
   *       A}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[])}
   */
  @Test
  @DisplayName(
      "Test unEscape(byte[]) with 'bytes'; then return array of byte with DELIMITER and 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscape(byte[])"})
  void testUnEscapeWithBytes_thenReturnArrayOfByteWithDelimiterAndA() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {ByteArrayEscapeUtils.DELIMITER, 'A', 'X', 'A', 'X', 'A', 'X'},
        ByteArrayEscapeUtils.unEscape(
            new byte[] {
              ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
              ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
              'A',
              'X',
              'A',
              'X',
              'A',
              'X'
            }));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscape(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with {@link ByteArrayEscapeUtils#DELIMITER_PLUS_ONE}
   *       and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[])}
   */
  @Test
  @DisplayName(
      "Test unEscape(byte[]) with 'bytes'; then return array of byte with DELIMITER_PLUS_ONE and 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscape(byte[])"})
  void testUnEscapeWithBytes_thenReturnArrayOfByteWithDelimiter_plus_oneAndA() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'A', 'X', 'A', 'X', 'A', 'X'},
        ByteArrayEscapeUtils.unEscape(
            new byte[] {ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 2, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscape(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Then return {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[])}
   */
  @Test
  @DisplayName("Test unEscape(byte[]) with 'bytes'; then return 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscape(byte[])"})
  void testUnEscapeWithBytes_thenReturnXaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "XAXAXAX".getBytes("UTF-8"),
        ByteArrayEscapeUtils.unEscape(
            new byte[] {
              ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'
            }));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscape(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscape(byte[])}
   */
  @Test
  @DisplayName(
      "Test unEscape(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscape(byte[])"})
  void testUnEscapeWithBytes_whenAxaxaxaxBytesIsUtf8_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), ByteArrayEscapeUtils.unEscape("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return array of {@code byte} with {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscapeByPosition(byte[], int, int); when 'A'; then return array of byte with 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscapeByPosition(byte[], int, int)"})
  void testUnEscapeByPosition_whenA_thenReturnArrayOfByteWithA() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'A'},
        ByteArrayEscapeUtils.unEscapeByPosition(
            new byte[] {'A', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'A', 'X', 'A', 'X', 'A', 'X'},
            1,
            3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return array of {@code byte} with {@code X} and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscapeByPosition(byte[], int, int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return array of byte with 'X' and 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscapeByPosition(byte[], int, int)"})
  void testUnEscapeByPosition_whenAxaxaxaxBytesIsUtf8_thenReturnArrayOfByteWithXAndA()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'X', 'A'},
        ByteArrayEscapeUtils.unEscapeByPosition("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscapeByPosition(byte[], int, int); when eight; then return 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscapeByPosition(byte[], int, int)"})
  void testUnEscapeByPosition_whenEight_thenReturnXaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "XAXAXAX".getBytes("UTF-8"),
        ByteArrayEscapeUtils.unEscapeByPosition("AXAXAXAX".getBytes("UTF-8"), 1, 8));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link InvalidParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscapeByPosition(byte[], int, int); when empty array of byte; then throw InvalidParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscapeByPosition(byte[], int, int)"})
  void testUnEscapeByPosition_whenEmptyArrayOfByte_thenThrowInvalidParameterException() {
    // Arrange, Act and Assert
    assertThrows(
        InvalidParameterException.class,
        () -> ByteArrayEscapeUtils.unEscapeByPosition(new byte[] {}, 1, 3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return array of {@code byte} with {@link ByteArrayEscapeUtils#DELIMITER}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscapeByPosition(byte[], int, int); when 'X'; then return array of byte with DELIMITER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscapeByPosition(byte[], int, int)"})
  void testUnEscapeByPosition_whenX_thenReturnArrayOfByteWithDelimiter() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {ByteArrayEscapeUtils.DELIMITER},
        ByteArrayEscapeUtils.unEscapeByPosition(
            new byte[] {
              'A',
              ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
              ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
              'X',
              'A',
              'X',
              'A',
              'X'
            },
            1,
            3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return array of {@code byte} with {@link ByteArrayEscapeUtils#DELIMITER_PLUS_ONE}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscapeByPosition(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscapeByPosition(byte[], int, int); when 'X'; then return array of byte with DELIMITER_PLUS_ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscapeByPosition(byte[], int, int)"})
  void testUnEscapeByPosition_whenX_thenReturnArrayOfByteWithDelimiter_plus_one() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {ByteArrayEscapeUtils.DELIMITER_PLUS_ONE},
        ByteArrayEscapeUtils.unEscapeByPosition(
            new byte[] {'A', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 2, 'X', 'A', 'X', 'A', 'X'},
            1,
            3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return array of {@code byte} with {@link ByteArrayEscapeUtils#DELIMITER} and {@code
   *       A}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscapeByLength(byte[], int, int); when 'A'; then return array of byte with DELIMITER and 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscapeByLength(byte[], int, int)"})
  void testUnEscapeByLength_whenA_thenReturnArrayOfByteWithDelimiterAndA() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {ByteArrayEscapeUtils.DELIMITER, 'A'},
        ByteArrayEscapeUtils.unEscapeByLength(
            new byte[] {
              'A',
              'X',
              ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
              ByteArrayEscapeUtils.DELIMITER_PLUS_ONE,
              'A',
              'X',
              'A',
              'X'
            },
            2,
            3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return array of {@code byte} with {@link ByteArrayEscapeUtils#DELIMITER_PLUS_ONE}
   *       and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscapeByLength(byte[], int, int); when 'A'; then return array of byte with DELIMITER_PLUS_ONE and 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscapeByLength(byte[], int, int)"})
  void testUnEscapeByLength_whenA_thenReturnArrayOfByteWithDelimiter_plus_oneAndA() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'A'},
        ByteArrayEscapeUtils.unEscapeByLength(
            new byte[] {'A', 'X', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 2, 'A', 'X', 'A', 'X'},
            2,
            3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code AXA} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscapeByLength(byte[], int, int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return 'AXA' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscapeByLength(byte[], int, int)"})
  void testUnEscapeByLength_whenAxaxaxaxBytesIsUtf8_thenReturnAxaBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXA".getBytes("UTF-8"),
        ByteArrayEscapeUtils.unEscapeByLength("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link InvalidParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscapeByLength(byte[], int, int); when empty array of byte; then throw InvalidParameterException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscapeByLength(byte[], int, int)"})
  void testUnEscapeByLength_whenEmptyArrayOfByte_thenThrowInvalidParameterException() {
    // Arrange, Act and Assert
    assertThrows(
        InvalidParameterException.class,
        () -> ByteArrayEscapeUtils.unEscapeByLength(new byte[] {}, 2, 3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code XAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscapeByLength(byte[], int, int); when five; then return 'XAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscapeByLength(byte[], int, int)"})
  void testUnEscapeByLength_whenFive_thenReturnXaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "XAX".getBytes("UTF-8"),
        ByteArrayEscapeUtils.unEscapeByLength("AXAXAXAX".getBytes("UTF-8"), 5, 3));
  }

  /**
   * Test {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}.
   *
   * <ul>
   *   <li>When {@code X}.
   *   <li>Then return array of {@code byte} with {@code X} and {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ByteArrayEscapeUtils#unEscapeByLength(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test unEscapeByLength(byte[], int, int); when 'X'; then return array of byte with 'X' and 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ByteArrayEscapeUtils.unEscapeByLength(byte[], int, int)"})
  void testUnEscapeByLength_whenX_thenReturnArrayOfByteWithXAndA() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {'X', 'A'},
        ByteArrayEscapeUtils.unEscapeByLength(
            new byte[] {'A', 'X', ByteArrayEscapeUtils.DELIMITER_PLUS_ONE, 'X', 'A', 'X', 'A', 'X'},
            2,
            3));
  }
}
