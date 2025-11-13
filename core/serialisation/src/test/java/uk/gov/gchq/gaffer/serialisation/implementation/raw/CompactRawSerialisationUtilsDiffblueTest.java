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

package uk.gov.gchq.gaffer.serialisation.implementation.raw;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class CompactRawSerialisationUtilsDiffblueTest {
  /**
   * Test {@link CompactRawSerialisationUtils#writeLong(long)}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#writeLong(long)}
   */
  @Test
  @DisplayName("Test writeLong(long); then return array of byte with minus one hundred twelve")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CompactRawSerialisationUtils.writeLong(long)"})
  void testWriteLong_thenReturnArrayOfByteWithMinusOneHundredTwelve() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-112}, CompactRawSerialisationUtils.writeLong(-112L));
  }

  /**
   * Test {@link CompactRawSerialisationUtils#writeLong(long)}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#writeLong(long)}
   */
  @Test
  @DisplayName("Test writeLong(long); then return array of byte with minus one hundred twenty and one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CompactRawSerialisationUtils.writeLong(long)"})
  void testWriteLong_thenReturnArrayOfByteWithMinusOneHundredTwentyAndOne() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-120, 1, '#', 'E', 'g', -119, -85, -51, -17},
        CompactRawSerialisationUtils.writeLong(81985529216486895L));
  }

  /**
   * Test {@link CompactRawSerialisationUtils#writeLong(long)}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus one hundred twenty-one and {@code p}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#writeLong(long)}
   */
  @Test
  @DisplayName("Test writeLong(long); then return array of byte with minus one hundred twenty-one and 'p'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CompactRawSerialisationUtils.writeLong(long)"})
  void testWriteLong_thenReturnArrayOfByteWithMinusOneHundredTwentyOneAndP() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-121, 'p'}, CompactRawSerialisationUtils.writeLong(-113L));
  }

  /**
   * Test {@link CompactRawSerialisationUtils#readLong(byte[], int)} with {@code allBytes}, {@code offset}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#readLong(byte[], int)}
   */
  @Test
  @DisplayName("Test readLong(byte[], int) with 'allBytes', 'offset'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CompactRawSerialisationUtils.readLong(byte[], int)"})
  void testReadLongWithAllBytesOffset_whenAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertEquals(65L, CompactRawSerialisationUtils.readLong("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link CompactRawSerialisationUtils#readLong(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#readLong(byte[])}
   */
  @Test
  @DisplayName("Test readLong(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CompactRawSerialisationUtils.readLong(byte[])"})
  void testReadLongWithBytes_whenAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertEquals(65L, CompactRawSerialisationUtils.readLong("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CompactRawSerialisationUtils#write(long, OutputStream)}.
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#write(long, OutputStream)}
   */
  @Test
  @DisplayName("Test write(long, OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CompactRawSerialisationUtils.write(long, OutputStream)"})
  void testWrite() throws SerialisationException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    CompactRawSerialisationUtils.write(81985529216486895L, output);

    // Assert
    assertArrayEquals(new byte[]{-120, 1, '#', 'E', 'g', -119, -85, -51, -17}, output.toByteArray());
  }

  /**
   * Test {@link CompactRawSerialisationUtils#write(long, OutputStream)}.
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#write(long, OutputStream)}
   */
  @Test
  @DisplayName("Test write(long, OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CompactRawSerialisationUtils.write(long, OutputStream)"})
  void testWrite2() throws SerialisationException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    CompactRawSerialisationUtils.write(-112L, output);

    // Assert
    assertArrayEquals(new byte[]{-112}, output.toByteArray());
  }

  /**
   * Test {@link CompactRawSerialisationUtils#write(long, OutputStream)}.
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#write(long, OutputStream)}
   */
  @Test
  @DisplayName("Test write(long, OutputStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CompactRawSerialisationUtils.write(long, OutputStream)"})
  void testWrite3() throws SerialisationException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    CompactRawSerialisationUtils.write(-113L, output);

    // Assert
    assertArrayEquals(new byte[]{-121, 'p'}, output.toByteArray());
  }

  /**
   * Test {@link CompactRawSerialisationUtils#write(long, OutputStream)}.
   * <ul>
   *   <li>When {@link PipedOutputStream#PipedOutputStream()}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#write(long, OutputStream)}
   */
  @Test
  @DisplayName("Test write(long, OutputStream); when PipedOutputStream(); then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CompactRawSerialisationUtils.write(long, OutputStream)"})
  void testWrite_whenPipedOutputStream_thenThrowSerialisationException() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class,
        () -> CompactRawSerialisationUtils.write(81985529216486895L, new PipedOutputStream()));
  }

  /**
   * Test {@link CompactRawSerialisationUtils#write(long, OutputStream)}.
   * <ul>
   *   <li>When {@link PipedOutputStream#PipedOutputStream()}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#write(long, OutputStream)}
   */
  @Test
  @DisplayName("Test write(long, OutputStream); when PipedOutputStream(); then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CompactRawSerialisationUtils.write(long, OutputStream)"})
  void testWrite_whenPipedOutputStream_thenThrowSerialisationException2() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class,
        () -> CompactRawSerialisationUtils.write(-112L, new PipedOutputStream()));
  }

  /**
   * Test {@link CompactRawSerialisationUtils#read(InputStream)}.
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X} read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#read(InputStream)}
   */
  @Test
  @DisplayName("Test read(InputStream); then ByteArrayInputStream(byte[]) with array of byte with MIN_VALUE and 'X' read is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CompactRawSerialisationUtils.read(InputStream)"})
  void testRead_thenByteArrayInputStreamWithArrayOfByteWithMin_valueAndXReadIsMinusOne() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream(
        new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act
    long actualReadResult = CompactRawSerialisationUtils.read(input);

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(-6359461186500647168L, actualReadResult);
  }

  /**
   * Test {@link CompactRawSerialisationUtils#read(InputStream)}.
   * <ul>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#read(InputStream)}
   */
  @Test
  @DisplayName("Test read(InputStream); then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CompactRawSerialisationUtils.read(InputStream)"})
  void testRead_thenThrowSerialisationException() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read()).thenThrow(new SerialisationException("An error occurred"));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> CompactRawSerialisationUtils.read(input));
    verify(input).read();
  }

  /**
   * Test {@link CompactRawSerialisationUtils#read(InputStream)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#read(InputStream)}
   */
  @Test
  @DisplayName("Test read(InputStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long CompactRawSerialisationUtils.read(InputStream)"})
  void testRead_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(65L, CompactRawSerialisationUtils.read(input));
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link CompactRawSerialisationUtils#decodeVIntSize(byte)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#decodeVIntSize(byte)}
   */
  @Test
  @DisplayName("Test decodeVIntSize(byte); when 'A'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CompactRawSerialisationUtils.decodeVIntSize(byte)"})
  void testDecodeVIntSize_whenA_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, CompactRawSerialisationUtils.decodeVIntSize((byte) 'A'));
  }

  /**
   * Test {@link CompactRawSerialisationUtils#decodeVIntSize(byte)}.
   * <ul>
   *   <li>When minus one hundred thirteen.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#decodeVIntSize(byte)}
   */
  @Test
  @DisplayName("Test decodeVIntSize(byte); when minus one hundred thirteen; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CompactRawSerialisationUtils.decodeVIntSize(byte)"})
  void testDecodeVIntSize_whenMinusOneHundredThirteen_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, CompactRawSerialisationUtils.decodeVIntSize((byte) -113));
  }

  /**
   * Test {@link CompactRawSerialisationUtils#decodeVIntSize(byte)}.
   * <ul>
   *   <li>When minus one hundred twenty-one.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompactRawSerialisationUtils#decodeVIntSize(byte)}
   */
  @Test
  @DisplayName("Test decodeVIntSize(byte); when minus one hundred twenty-one; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CompactRawSerialisationUtils.decodeVIntSize(byte)"})
  void testDecodeVIntSize_whenMinusOneHundredTwentyOne_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, CompactRawSerialisationUtils.decodeVIntSize((byte) -121));
  }
}
