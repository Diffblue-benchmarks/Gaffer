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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class CompactRawSerialisationUtilsDiffblueTest {
  /**
   * Method under test: {@link CompactRawSerialisationUtils#writeLong(long)}
   */
  @Test
  void testWriteLong() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-120, 1, '#', 'E', 'g', -119, -85, -51, -17},
        CompactRawSerialisationUtils.writeLong(81985529216486895L));
    assertArrayEquals(new byte[]{-112}, CompactRawSerialisationUtils.writeLong(-112L));
    assertArrayEquals(new byte[]{-121, 'p'}, CompactRawSerialisationUtils.writeLong(-113L));
  }

  /**
   * Method under test: {@link CompactRawSerialisationUtils#readLong(byte[])}
   */
  @Test
  void testReadLong() throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertEquals(65L, CompactRawSerialisationUtils.readLong("AXAXAXAX".getBytes("UTF-8")));
    assertEquals(65L, CompactRawSerialisationUtils.readLong("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Method under test:
   * {@link CompactRawSerialisationUtils#write(long, OutputStream)}
   */
  @Test
  void testWrite() throws SerialisationException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    CompactRawSerialisationUtils.write(81985529216486895L, output);

    // Assert that nothing has changed
    assertArrayEquals(new byte[]{-120, 1, '#', 'E', 'g', -119, -85, -51, -17}, output.toByteArray());
  }

  /**
   * Method under test:
   * {@link CompactRawSerialisationUtils#write(long, OutputStream)}
   */
  @Test
  void testWrite2() throws SerialisationException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    CompactRawSerialisationUtils.write(-112L, output);

    // Assert that nothing has changed
    assertArrayEquals(new byte[]{-112}, output.toByteArray());
  }

  /**
   * Method under test:
   * {@link CompactRawSerialisationUtils#write(long, OutputStream)}
   */
  @Test
  void testWrite3() throws SerialisationException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    CompactRawSerialisationUtils.write(-113L, output);

    // Assert that nothing has changed
    assertArrayEquals(new byte[]{-121, 'p'}, output.toByteArray());
  }

  /**
   * Method under test:
   * {@link CompactRawSerialisationUtils#write(long, OutputStream)}
   */
  @Test
  void testWrite4() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class,
        () -> CompactRawSerialisationUtils.write(81985529216486895L, new PipedOutputStream()));
  }

  /**
   * Method under test:
   * {@link CompactRawSerialisationUtils#write(long, OutputStream)}
   */
  @Test
  void testWrite5() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class,
        () -> CompactRawSerialisationUtils.write(-112L, new PipedOutputStream()));
  }

  /**
   * Method under test: {@link CompactRawSerialisationUtils#read(InputStream)}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(65L, CompactRawSerialisationUtils.read(input));
    byte[] byteArray = new byte[7];
    assertEquals(7, input.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Method under test: {@link CompactRawSerialisationUtils#read(InputStream)}
   */
  @Test
  void testRead2() throws IOException {
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
   * Method under test: {@link CompactRawSerialisationUtils#read(InputStream)}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read()).thenReturn(1);

    // Act
    long actualReadResult = CompactRawSerialisationUtils.read(input);

    // Assert
    verify(input).read();
    assertEquals(1L, actualReadResult);
  }

  /**
   * Method under test: {@link CompactRawSerialisationUtils#read(InputStream)}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    DataInputStream input = mock(DataInputStream.class);
    when(input.read()).thenThrow(new SerialisationException("An error occurred"));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> CompactRawSerialisationUtils.read(input));
    verify(input).read();
  }

  /**
   * Method under test: {@link CompactRawSerialisationUtils#decodeVIntSize(byte)}
   */
  @Test
  void testDecodeVIntSize() {
    // Arrange, Act and Assert
    assertEquals(1, CompactRawSerialisationUtils.decodeVIntSize((byte) 'A'));
    assertEquals(2, CompactRawSerialisationUtils.decodeVIntSize((byte) -113));
    assertEquals(2, CompactRawSerialisationUtils.decodeVIntSize((byte) -121));
  }
}
