package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.ByteBufferInput;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.OutputChunked;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.FreqMap;

class FreqMapKryoSerializerDiffblueTest {
  /**
   * Test new {@link FreqMapKryoSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FreqMapKryoSerializer}
   */
  @Test
  @DisplayName("Test new FreqMapKryoSerializer (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewFreqMapKryoSerializer() {
    // Arrange and Act
    FreqMapKryoSerializer actualFreqMapKryoSerializer = new FreqMapKryoSerializer();

    // Assert
    assertFalse(actualFreqMapKryoSerializer.getAcceptsNull());
    assertFalse(actualFreqMapKryoSerializer.isImmutable());
  }

  /**
   * Test {@link FreqMapKryoSerializer#write(Kryo, Output, FreqMap)} with {@code Kryo}, {@code
   * Output}, {@code FreqMap}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then fourth element is eleven.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#write(Kryo, Output, FreqMap)}
   */
  @Test
  @DisplayName(
      "Test write(Kryo, Output, FreqMap) with 'Kryo', 'Output', 'FreqMap'; given '42'; then fourth element is eleven")
  @Tag("MaintainedByDiffblue")
  void testWriteWithKryoOutputFreqMap_given42_thenFourthElementIsEleven() {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    Output output = new Output(102);

    FreqMap freqMap = new FreqMap();
    freqMap.put("42", 2L);
    freqMap.put("foo", 1L);

    // Act
    freqMapKryoSerializer.write(kryo, output, freqMap);

    // Assert
    byte[] buffer = output.getBuffer();
    assertEquals(102, buffer.length);
    assertEquals((byte) 11, buffer[3]);
    assertEquals(15, output.position());
    assertEquals(15L, output.total());
    assertEquals((byte) 2, buffer[14]);
    assertEquals('2', buffer[12]);
    assertEquals('4', buffer[11]);
    assertArrayEquals(
        new byte[] {0, 0, 0, 11, 'f', 'o', 'o', 0, 1, 2, 0, '4', '2', 0, 2}, output.toBytes());
  }

  /**
   * Test {@link FreqMapKryoSerializer#write(Kryo, Output, FreqMap)} with {@code Kryo}, {@code
   * Output}, {@code FreqMap}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then tenth element is one.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#write(Kryo, Output, FreqMap)}
   */
  @Test
  @DisplayName(
      "Test write(Kryo, Output, FreqMap) with 'Kryo', 'Output', 'FreqMap'; given zero; then tenth element is one")
  @Tag("MaintainedByDiffblue")
  void testWriteWithKryoOutputFreqMap_givenZero_thenTenthElementIsOne() {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    Output output = new Output(102);

    FreqMap freqMap = new FreqMap();
    freqMap.put("foo", 0L);

    // Act
    freqMapKryoSerializer.write(kryo, output, freqMap);

    // Assert
    assertEquals(10, output.position());
    byte[] buffer = output.getBuffer();
    assertEquals(102, buffer.length);
    assertEquals(10L, output.total());
    assertEquals((byte) 1, buffer[9]);
    assertEquals((byte) 6, buffer[3]);
    assertArrayEquals(new byte[] {0, 0, 0, 6, 'f', 'o', 'o', 0, 1, 1}, output.toBytes());
  }

  /**
   * Test {@link FreqMapKryoSerializer#write(Kryo, Output, FreqMap)} with {@code Kryo}, {@code
   * Output}, {@code FreqMap}.
   *
   * <ul>
   *   <li>Then tenth element is two.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#write(Kryo, Output, FreqMap)}
   */
  @Test
  @DisplayName(
      "Test write(Kryo, Output, FreqMap) with 'Kryo', 'Output', 'FreqMap'; then tenth element is two")
  @Tag("MaintainedByDiffblue")
  void testWriteWithKryoOutputFreqMap_thenTenthElementIsTwo() {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    Output output = new Output(102);

    FreqMap freqMap = new FreqMap();
    freqMap.put("foo", 1L);

    // Act
    freqMapKryoSerializer.write(kryo, output, freqMap);

    // Assert
    assertEquals(10, output.position());
    byte[] buffer = output.getBuffer();
    assertEquals(102, buffer.length);
    assertEquals(10L, output.total());
    assertEquals((byte) 2, buffer[9]);
    assertEquals((byte) 6, buffer[3]);
    assertArrayEquals(new byte[] {0, 0, 0, 6, 'f', 'o', 'o', 0, 1, 2}, output.toBytes());
  }

  /**
   * Test {@link FreqMapKryoSerializer#write(Kryo, Output, FreqMap)} with {@code Kryo}, {@code
   * Output}, {@code FreqMap}.
   *
   * <ul>
   *   <li>When {@link OutputChunked#OutputChunked()}.
   *   <li>Then fourth element is zero.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#write(Kryo, Output, FreqMap)}
   */
  @Test
  @DisplayName(
      "Test write(Kryo, Output, FreqMap) with 'Kryo', 'Output', 'FreqMap'; when OutputChunked(); then fourth element is zero")
  @Tag("MaintainedByDiffblue")
  void testWriteWithKryoOutputFreqMap_whenOutputChunked_thenFourthElementIsZero() {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    OutputChunked output = new OutputChunked();

    // Act
    freqMapKryoSerializer.write(kryo, output, new FreqMap());

    // Assert
    byte[] buffer = output.getBuffer();
    assertEquals((byte) 0, buffer[3]);
    assertEquals((byte) 0, buffer[9]);
    assertEquals(2048, buffer.length);
    assertEquals(4, output.position());
    assertEquals(4L, output.total());
    assertArrayEquals(new byte[] {0, 0, 0, 0}, output.toBytes());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); given array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  void testRead_givenArrayOfByteWithAAndX() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();

    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 0});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(1);
    verify(input).readInt();
    assertTrue(actualReadResult.isEmpty());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and zero.
   *   <li>Then return {@code A} longValue is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName(
      "Test read(Kryo, Input, Class); given array of byte with 'A' and zero; then return 'A' longValue is sixty-five")
  @Tag("MaintainedByDiffblue")
  void testRead_givenArrayOfByteWithAAndZero_thenReturnALongValueIsSixtyFive()
      throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();

    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[] {'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(1);
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(65L, actualReadResult.get("A").longValue());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and one.
   *   <li>Then return empty string longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName(
      "Test read(Kryo, Input, Class); given array of byte with zero and one; then return empty string longValue is one")
  @Tag("MaintainedByDiffblue")
  void testRead_givenArrayOfByteWithZeroAndOne_thenReturnEmptyStringLongValueIsOne()
      throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();

    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[] {0, 1, 2, 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(1);
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(1L, actualReadResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and one.
   *   <li>Then return empty string longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName(
      "Test read(Kryo, Input, Class); given array of byte with zero and one; then return empty string longValue is zero")
  @Tag("MaintainedByDiffblue")
  void testRead_givenArrayOfByteWithZeroAndOne_thenReturnEmptyStringLongValueIsZero()
      throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();

    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[] {0, 1, 1, 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(1);
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(0L, actualReadResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with zero and zero.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); given array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  void testRead_givenArrayOfByteWithZeroAndZero() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();

    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[] {0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(1);
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(65L, actualReadResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  void testRead_givenAxaxaxaxBytesIsUtf8() throws KryoException, UnsupportedEncodingException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();

    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(1);
    verify(input).readInt();
    assertTrue(actualReadResult.isEmpty());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); given empty array of byte")
  @Tag("MaintainedByDiffblue")
  void testRead_givenEmptyArrayOfByte() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();

    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[] {});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(1);
    verify(input).readInt();
    assertTrue(actualReadResult.isEmpty());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   *
   * <ul>
   *   <li>Then return empty string longValue is eighty-eight.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); then return empty string longValue is eighty-eight")
  @Tag("MaintainedByDiffblue")
  void testRead_thenReturnEmptyStringLongValueIsEightyEight() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();

    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(1);
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(88L, actualReadResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   *
   * <ul>
   *   <li>Then return empty string longValue is eighty-eight.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); then return empty string longValue is eighty-eight")
  @Tag("MaintainedByDiffblue")
  void testRead_thenReturnEmptyStringLongValueIsEightyEight2() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();

    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[] {0, 'X', 0, 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(1);
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(88L, actualReadResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   *
   * <ul>
   *   <li>Then return empty string longValue is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); then return empty string longValue is sixty-five")
  @Tag("MaintainedByDiffblue")
  void testRead_thenReturnEmptyStringLongValueIsSixtyFive() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();

    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[] {0, 1, 'A', 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(1);
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(65L, actualReadResult.get("").longValue());
  }
}
