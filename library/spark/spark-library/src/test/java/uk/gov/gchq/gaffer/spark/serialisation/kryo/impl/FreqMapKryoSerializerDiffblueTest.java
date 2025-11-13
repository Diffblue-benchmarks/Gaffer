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

package uk.gov.gchq.gaffer.spark.serialisation.kryo.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
   * <p>
   * Method under test: default or parameterless constructor of {@link FreqMapKryoSerializer}
   */
  @Test
  @DisplayName("Test new FreqMapKryoSerializer (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FreqMapKryoSerializer.<init>()"})
  void testNewFreqMapKryoSerializer() {
    // Arrange and Act
    FreqMapKryoSerializer actualFreqMapKryoSerializer = new FreqMapKryoSerializer();

    // Assert
    assertFalse(actualFreqMapKryoSerializer.getAcceptsNull());
    assertFalse(actualFreqMapKryoSerializer.isImmutable());
  }

  /**
   * Test {@link FreqMapKryoSerializer#write(Kryo, Output, FreqMap)} with {@code Kryo}, {@code Output}, {@code FreqMap}.
   * <ul>
   *   <li>When {@link OutputChunked#OutputChunked()}.</li>
   *   <li>Then {@link OutputChunked#OutputChunked()} position is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapKryoSerializer#write(Kryo, Output, FreqMap)}
   */
  @Test
  @DisplayName("Test write(Kryo, Output, FreqMap) with 'Kryo', 'Output', 'FreqMap'; when OutputChunked(); then OutputChunked() position is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FreqMapKryoSerializer.write(Kryo, Output, FreqMap)"})
  void testWriteWithKryoOutputFreqMap_whenOutputChunked_thenOutputChunkedPositionIsFour() {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    OutputChunked output = new OutputChunked();

    // Act
    freqMapKryoSerializer.write(kryo, output, new FreqMap());

    // Assert
    assertEquals(4, output.position());
    assertEquals(4L, output.total());
    assertArrayEquals(new byte[]{0, 0, 0, 0}, output.toBytes());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); given array of byte with 'A' and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapKryoSerializer.read(Kryo, Input, Class)"})
  void testRead_givenArrayOfByteWithAAndX() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(eq(1));
    verify(input).readInt();
    assertTrue(actualReadResult.isEmpty());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   * <ul>
   *   <li>Given array of {@code byte} with {@code A} and zero.</li>
   *   <li>Then return {@code A} longValue is sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); given array of byte with 'A' and zero; then return 'A' longValue is sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapKryoSerializer.read(Kryo, Input, Class)"})
  void testRead_givenArrayOfByteWithAAndZero_thenReturnALongValueIsSixtyFive() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(eq(1));
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(65L, actualReadResult.get("A").longValue());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and one.</li>
   *   <li>Then return empty string longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); given array of byte with zero and one; then return empty string longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapKryoSerializer.read(Kryo, Input, Class)"})
  void testRead_givenArrayOfByteWithZeroAndOne_thenReturnEmptyStringLongValueIsOne() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[]{0, 1, 2, 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(eq(1));
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(1L, actualReadResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and one.</li>
   *   <li>Then return empty string longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); given array of byte with zero and one; then return empty string longValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapKryoSerializer.read(Kryo, Input, Class)"})
  void testRead_givenArrayOfByteWithZeroAndOne_thenReturnEmptyStringLongValueIsZero() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[]{0, 1, 1, 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(eq(1));
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(0L, actualReadResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   * <ul>
   *   <li>Given array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); given array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapKryoSerializer.read(Kryo, Input, Class)"})
  void testRead_givenArrayOfByteWithZeroAndZero() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(eq(1));
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(65L, actualReadResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapKryoSerializer.read(Kryo, Input, Class)"})
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
    verify(input).readBytes(eq(1));
    verify(input).readInt();
    assertTrue(actualReadResult.isEmpty());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); given empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapKryoSerializer.read(Kryo, Input, Class)"})
  void testRead_givenEmptyArrayOfByte() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[]{});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(eq(1));
    verify(input).readInt();
    assertTrue(actualReadResult.isEmpty());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   * <ul>
   *   <li>Then return empty string longValue is eighty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); then return empty string longValue is eighty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapKryoSerializer.read(Kryo, Input, Class)"})
  void testRead_thenReturnEmptyStringLongValueIsEightyEight() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(eq(1));
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(88L, actualReadResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   * <ul>
   *   <li>Then return empty string longValue is eighty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); then return empty string longValue is eighty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapKryoSerializer.read(Kryo, Input, Class)"})
  void testRead_thenReturnEmptyStringLongValueIsEightyEight2() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[]{0, 'X', 0, 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(eq(1));
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(88L, actualReadResult.get("").longValue());
  }

  /**
   * Test {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}.
   * <ul>
   *   <li>Then return empty string longValue is sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link FreqMapKryoSerializer#read(Kryo, Input, Class)}
   */
  @Test
  @DisplayName("Test read(Kryo, Input, Class); then return empty string longValue is sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FreqMap FreqMapKryoSerializer.read(Kryo, Input, Class)"})
  void testRead_thenReturnEmptyStringLongValueIsSixtyFive() throws KryoException {
    // Arrange
    FreqMapKryoSerializer freqMapKryoSerializer = new FreqMapKryoSerializer();
    Kryo kryo = new Kryo();
    ByteBufferInput input = mock(ByteBufferInput.class);
    when(input.readBytes(anyInt())).thenReturn(new byte[]{0, 1, 'A', 'X', 'A', 'X', 'A', 'X'});
    when(input.readInt()).thenReturn(1);
    Class<FreqMap> aClass = FreqMap.class;

    // Act
    FreqMap actualReadResult = freqMapKryoSerializer.read(kryo, input, aClass);

    // Assert
    verify(input).readBytes(eq(1));
    verify(input).readInt();
    assertEquals(1, actualReadResult.size());
    assertEquals(65L, actualReadResult.get("").longValue());
  }
}
