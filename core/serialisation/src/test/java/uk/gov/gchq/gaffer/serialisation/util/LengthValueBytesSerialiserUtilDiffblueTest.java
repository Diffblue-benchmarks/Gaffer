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

package uk.gov.gchq.gaffer.serialisation.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.JavaSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.MapSerialiser;
import uk.gov.gchq.gaffer.serialisation.implementation.NullSerialiser;
import uk.gov.gchq.gaffer.serialisation.util.LengthValueBytesSerialiserUtil.LengthValueBuilder;
import uk.gov.gchq.gaffer.serialisation.util.LengthValueBytesSerialiserUtil.ObjectCarriage;

class LengthValueBytesSerialiserUtilDiffblueTest {
  /**
   * Test {@link LengthValueBytesSerialiserUtil#createByteArray()}.
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#createByteArray()}
   */
  @Test
  @DisplayName("Test createByteArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ByteArrayOutputStream LengthValueBytesSerialiserUtil.createByteArray()"})
  void testCreateByteArray() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, LengthValueBytesSerialiserUtil.createByteArray().toByteArray());
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#appendLengthValueFromObjectToByteStream(ByteArrayOutputStream, ToBytesSerialiser, Object)}.
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#appendLengthValueFromObjectToByteStream(ByteArrayOutputStream, ToBytesSerialiser, Object)}
   */
  @Test
  @DisplayName("Test appendLengthValueFromObjectToByteStream(ByteArrayOutputStream, ToBytesSerialiser, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ByteArrayOutputStream LengthValueBytesSerialiserUtil.appendLengthValueFromObjectToByteStream(ByteArrayOutputStream, ToBytesSerialiser, Object)"})
  void testAppendLengthValueFromObjectToByteStream() throws SerialisationException {
    // Arrange
    ByteArrayOutputStream byteOut = LengthValueBytesSerialiserUtil.createByteArray();

    // Act and Assert
    assertArrayEquals(
        new byte[]{'\r', -84, -19, MultiSerialiserStorageTest.BYTE, 5, 't', MultiSerialiserStorageTest.BYTE, 6, 'O',
            'b', 'j', 'e', 'c', 't'},
        LengthValueBytesSerialiserUtil.appendLengthValueFromObjectToByteStream(byteOut, new JavaSerialiser(), "Object")
            .toByteArray());
    assertArrayEquals(new byte[]{'\r', -84, -19, MultiSerialiserStorageTest.BYTE, 5, 't',
        MultiSerialiserStorageTest.BYTE, 6, 'O', 'b', 'j', 'e', 'c', 't'}, byteOut.toByteArray());
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#appendLengthValueFromObjectToByteStream(ByteArrayOutputStream, ToBytesSerialiser, Object)}.
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#appendLengthValueFromObjectToByteStream(ByteArrayOutputStream, ToBytesSerialiser, Object)}
   */
  @Test
  @DisplayName("Test appendLengthValueFromObjectToByteStream(ByteArrayOutputStream, ToBytesSerialiser, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ByteArrayOutputStream LengthValueBytesSerialiserUtil.appendLengthValueFromObjectToByteStream(ByteArrayOutputStream, ToBytesSerialiser, Object)"})
  void testAppendLengthValueFromObjectToByteStream2() throws SerialisationException {
    // Arrange
    ByteArrayOutputStream byteOut = LengthValueBytesSerialiserUtil.createByteArray();
    MapSerialiser serialiser = new MapSerialiser();

    // Act and Assert
    assertArrayEquals(new byte[]{MultiSerialiserStorageTest.BYTE},
        LengthValueBytesSerialiserUtil.appendLengthValueFromObjectToByteStream(byteOut, serialiser, new HashMap<>())
            .toByteArray());
    assertArrayEquals(new byte[]{MultiSerialiserStorageTest.BYTE}, byteOut.toByteArray());
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#appendLengthValueFromBytesToByteStream(ByteArrayOutputStream, byte[])}.
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#appendLengthValueFromBytesToByteStream(ByteArrayOutputStream, byte[])}
   */
  @Test
  @DisplayName("Test appendLengthValueFromBytesToByteStream(ByteArrayOutputStream, byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ByteArrayOutputStream LengthValueBytesSerialiserUtil.appendLengthValueFromBytesToByteStream(ByteArrayOutputStream, byte[])"})
  void testAppendLengthValueFromBytesToByteStream() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    ByteArrayOutputStream byteOut = LengthValueBytesSerialiserUtil.createByteArray();

    // Act
    ByteArrayOutputStream actualAppendLengthValueFromBytesToByteStreamResult = LengthValueBytesSerialiserUtil
        .appendLengthValueFromBytesToByteStream(byteOut, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    byte[] expectedToByteArrayResult = "\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, actualAppendLengthValueFromBytesToByteStreamResult.toByteArray());
    byte[] expectedToByteArrayResult2 = "\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult2, byteOut.toByteArray());
  }

  /**
   * Test LengthValueBuilder {@link LengthValueBuilder#appendLengthValueFromBytesToByteStream(byte[])}.
   * <p>
   * Method under test: {@link LengthValueBuilder#appendLengthValueFromBytesToByteStream(byte[])}
   */
  @Test
  @DisplayName("Test LengthValueBuilder appendLengthValueFromBytesToByteStream(byte[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LengthValueBuilder LengthValueBuilder.appendLengthValueFromBytesToByteStream(byte[])"})
  void testLengthValueBuilderAppendLengthValueFromBytesToByteStream()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    LengthValueBuilder lengthValueBuilder = new LengthValueBuilder();

    // Act and Assert
    assertSame(lengthValueBuilder,
        lengthValueBuilder.appendLengthValueFromBytesToByteStream("AXAXAXAX".getBytes("UTF-8")));
    byte[] expectedToByteArrayResult = "\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, lengthValueBuilder.byteOut.toByteArray());
    byte[] expectedToArrayResult = "\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToArrayResult, lengthValueBuilder.toArray());
  }

  /**
   * Test LengthValueBuilder new {@link LengthValueBuilder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link LengthValueBuilder}
   */
  @Test
  @DisplayName("Test LengthValueBuilder new LengthValueBuilder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LengthValueBuilder.<init>()"})
  void testLengthValueBuilderNewLengthValueBuilder() {
    // Arrange and Act
    LengthValueBuilder actualLengthValueBuilder = new LengthValueBuilder();

    // Assert
    assertArrayEquals(new byte[]{}, actualLengthValueBuilder.byteOut.toByteArray());
    assertArrayEquals(new byte[]{}, actualLengthValueBuilder.toArray());
  }

  /**
   * Test LengthValueBuilder {@link LengthValueBuilder#toArray()}.
   * <p>
   * Method under test: {@link LengthValueBuilder#toArray()}
   */
  @Test
  @DisplayName("Test LengthValueBuilder toArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBuilder.toArray()"})
  void testLengthValueBuilderToArray() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new LengthValueBuilder()).toArray());
  }

  /**
   * Test ObjectCarriage getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ObjectCarriage#ObjectCarriage(Object, int)}
   *   <li>{@link ObjectCarriage#setCarriage(int)}
   *   <li>{@link ObjectCarriage#setObject(Object)}
   *   <li>{@link ObjectCarriage#getCarriage()}
   *   <li>{@link ObjectCarriage#getObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test ObjectCarriage getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ObjectCarriage.<init>(Object, int)", "int ObjectCarriage.getCarriage()",
      "Object ObjectCarriage.getObject()", "void ObjectCarriage.setCarriage(int)",
      "void ObjectCarriage.setObject(Object)"})
  void testObjectCarriageGettersAndSetters() {
    // Arrange and Act
    ObjectCarriage<Object> actualObjectCarriage = new ObjectCarriage<>("Object", 1);
    actualObjectCarriage.setCarriage(1);
    actualObjectCarriage.setObject("Object");
    int actualCarriage = actualObjectCarriage.getCarriage();

    // Assert
    assertEquals("Object", actualObjectCarriage.getObject());
    assertEquals(1, actualCarriage);
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#serialise(ToBytesSerialiser, Object)} with {@code serialiser}, {@code value}.
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#serialise(ToBytesSerialiser, Object)}
   */
  @Test
  @DisplayName("Test serialise(ToBytesSerialiser, Object) with 'serialiser', 'value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.serialise(ToBytesSerialiser, Object)"})
  void testSerialiseWithSerialiserValue() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'\f', -84, -19, MultiSerialiserStorageTest.BYTE, 5, 't',
        MultiSerialiserStorageTest.BYTE, 5, 'V', 'a', 'l', 'u', 'e'},
        LengthValueBytesSerialiserUtil.serialise(new JavaSerialiser(), "Value"));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#serialise(ToBytesSerialiser, Object, ByteArrayOutputStream)} with {@code serialiser}, {@code value}, {@code out}.
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#serialise(ToBytesSerialiser, Object, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName("Test serialise(ToBytesSerialiser, Object, ByteArrayOutputStream) with 'serialiser', 'value', 'out'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LengthValueBytesSerialiserUtil.serialise(ToBytesSerialiser, Object, ByteArrayOutputStream)"})
  void testSerialiseWithSerialiserValueOut() throws SerialisationException {
    // Arrange
    JavaSerialiser serialiser = new JavaSerialiser();
    ByteArrayOutputStream out = LengthValueBytesSerialiserUtil.createByteArray();

    // Act
    LengthValueBytesSerialiserUtil.serialise(serialiser, "Value", out);

    // Assert
    assertArrayEquals(new byte[]{'\f', -84, -19, MultiSerialiserStorageTest.BYTE, 5, 't',
        MultiSerialiserStorageTest.BYTE, 5, 'V', 'a', 'l', 'u', 'e'}, out.toByteArray());
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#serialise(ToBytesSerialiser, Object, ByteArrayOutputStream)} with {@code serialiser}, {@code value}, {@code out}.
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#serialise(ToBytesSerialiser, Object, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName("Test serialise(ToBytesSerialiser, Object, ByteArrayOutputStream) with 'serialiser', 'value', 'out'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LengthValueBytesSerialiserUtil.serialise(ToBytesSerialiser, Object, ByteArrayOutputStream)"})
  void testSerialiseWithSerialiserValueOut2() throws SerialisationException {
    // Arrange
    ByteArrayOutputStream out = LengthValueBytesSerialiserUtil.createByteArray();

    // Act
    LengthValueBytesSerialiserUtil.serialise(null, null, out);

    // Assert
    assertArrayEquals(new byte[]{MultiSerialiserStorageTest.BYTE}, out.toByteArray());
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#serialise(ToBytesSerialiser, Object, ByteArrayOutputStream)} with {@code serialiser}, {@code value}, {@code out}.
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#serialise(ToBytesSerialiser, Object, ByteArrayOutputStream)}
   */
  @Test
  @DisplayName("Test serialise(ToBytesSerialiser, Object, ByteArrayOutputStream) with 'serialiser', 'value', 'out'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LengthValueBytesSerialiserUtil.serialise(ToBytesSerialiser, Object, ByteArrayOutputStream)"})
  void testSerialiseWithSerialiserValueOut3() throws SerialisationException {
    // Arrange
    JavaSerialiser serialiser = new JavaSerialiser();
    ByteArrayOutputStream out = LengthValueBytesSerialiserUtil.createByteArray();

    // Act
    LengthValueBytesSerialiserUtil.serialise(serialiser, null, out);

    // Assert
    assertArrayEquals(new byte[]{MultiSerialiserStorageTest.BYTE}, out.toByteArray());
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#serialise(ToBytesSerialiser, Object)} with {@code serialiser}, {@code value}.
   * <ul>
   *   <li>Then return array of {@code byte} with {@link MultiSerialiserStorageTest#BYTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#serialise(ToBytesSerialiser, Object)}
   */
  @Test
  @DisplayName("Test serialise(ToBytesSerialiser, Object) with 'serialiser', 'value'; then return array of byte with BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.serialise(ToBytesSerialiser, Object)"})
  void testSerialiseWithSerialiserValue_thenReturnArrayOfByteWithByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{MultiSerialiserStorageTest.BYTE},
        LengthValueBytesSerialiserUtil.serialise(new JavaSerialiser(), null));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#serialise(byte[], ByteArrayOutputStream)} with {@code valueBytes}, {@code out}.
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#serialise(byte[], ByteArrayOutputStream)}
   */
  @Test
  @DisplayName("Test serialise(byte[], ByteArrayOutputStream) with 'valueBytes', 'out'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LengthValueBytesSerialiserUtil.serialise(byte[], ByteArrayOutputStream)"})
  void testSerialiseWithValueBytesOut() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    byte[] valueBytes = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream out = LengthValueBytesSerialiserUtil.createByteArray();

    // Act
    LengthValueBytesSerialiserUtil.serialise(valueBytes, out);

    // Assert
    byte[] expectedToByteArrayResult = "\bAXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, out.toByteArray());
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#serialise(byte[], ByteArrayOutputStream)} with {@code valueBytes}, {@code out}.
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#serialise(byte[], ByteArrayOutputStream)}
   */
  @Test
  @DisplayName("Test serialise(byte[], ByteArrayOutputStream) with 'valueBytes', 'out'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LengthValueBytesSerialiserUtil.serialise(byte[], ByteArrayOutputStream)"})
  void testSerialiseWithValueBytesOut2() throws SerialisationException {
    // Arrange
    ByteArrayOutputStream out = LengthValueBytesSerialiserUtil.createByteArray();

    // Act
    LengthValueBytesSerialiserUtil.serialise(new byte[]{}, out);

    // Assert
    assertArrayEquals(new byte[]{MultiSerialiserStorageTest.BYTE}, out.toByteArray());
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#serialise(byte[])} with {@code valueBytes}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#serialise(byte[])}
   */
  @Test
  @DisplayName("Test serialise(byte[]) with 'valueBytes'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.serialise(byte[])"})
  void testSerialiseWithValueBytes_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    byte[] actualSerialiseResult = LengthValueBytesSerialiserUtil.serialise("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("\bAXAXAXAX".getBytes("UTF-8"), actualSerialiseResult);
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#serialise(byte[])} with {@code valueBytes}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return array of {@code byte} with {@link MultiSerialiserStorageTest#BYTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#serialise(byte[])}
   */
  @Test
  @DisplayName("Test serialise(byte[]) with 'valueBytes'; when empty array of byte; then return array of byte with BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.serialise(byte[])"})
  void testSerialiseWithValueBytes_whenEmptyArrayOfByte_thenReturnArrayOfByteWithByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{MultiSerialiserStorageTest.BYTE},
        LengthValueBytesSerialiserUtil.serialise(new byte[]{}));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#serialise(byte[])} with {@code valueBytes}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array of {@code byte} with {@link MultiSerialiserStorageTest#BYTE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#serialise(byte[])}
   */
  @Test
  @DisplayName("Test serialise(byte[]) with 'valueBytes'; when 'null'; then return array of byte with BYTE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.serialise(byte[])"})
  void testSerialiseWithValueBytes_whenNull_thenReturnArrayOfByteWithByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{MultiSerialiserStorageTest.BYTE}, LengthValueBytesSerialiserUtil.serialise(null));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int[])} with {@code allBytes}, {@code delimiterWrapper}.
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int[]) with 'allBytes', 'delimiterWrapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.deserialise(byte[], int[])"})
  void testDeserialiseWithAllBytesDelimiterWrapper() throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> LengthValueBytesSerialiserUtil.deserialise("AXAXAXAX".getBytes("UTF-8"), new int[]{1, 0, 1, 0}));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int)} with {@code allBytes}, {@code delimiter}.
   * <ul>
   *   <li>Then return array length is eighty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int) with 'allBytes', 'delimiter'; then return array length is eighty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.deserialise(byte[], int)"})
  void testDeserialiseWithAllBytesDelimiter_thenReturnArrayLengthIsEightyEight()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    byte[] actualDeserialiseResult = LengthValueBytesSerialiserUtil.deserialise("AXAXAXAX".getBytes("UTF-8"), 1);

    // Assert
    assertEquals(88, actualDeserialiseResult.length);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[10]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[11]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[12]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[13]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[14]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[15]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[17]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[18]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[19]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[20]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[21]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[22]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[23]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[24]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[6]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[63]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[65]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[66]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[67]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[68]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[69]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[7]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[70]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[71]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[72]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[73]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[74]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[75]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[76]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[77]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[78]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[79]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[8]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[80]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[81]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[82]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[83]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[84]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[85]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[86]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[87]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[9]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[Double.SIZE]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[Short.SIZE]);
    assertEquals('A', actualDeserialiseResult[0]);
    assertEquals('A', actualDeserialiseResult[2]);
    assertEquals('A', actualDeserialiseResult[4]);
    assertEquals('X', actualDeserialiseResult[1]);
    assertEquals('X', actualDeserialiseResult[3]);
    assertEquals('X', actualDeserialiseResult[5]);
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int)} with {@code allBytes}, {@code delimiter}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int) with 'allBytes', 'delimiter'; when empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.deserialise(byte[], int)"})
  void testDeserialiseWithAllBytesDelimiter_whenEmptyArrayOfByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, LengthValueBytesSerialiserUtil.deserialise(new byte[]{}, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int)} with {@code allBytes}, {@code delimiter}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int) with 'allBytes', 'delimiter'; when 'null'; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.deserialise(byte[], int)"})
  void testDeserialiseWithAllBytesDelimiter_whenNull_thenReturnEmptyArrayOfByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, LengthValueBytesSerialiserUtil.deserialise(null, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int, int, int)} with {@code allBytes}, {@code lengthSize}, {@code valueSize}, {@code delimiter}.
   * <ul>
   *   <li>Then return {@code AXA} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int, int, int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int, int, int) with 'allBytes', 'lengthSize', 'valueSize', 'delimiter'; then return 'AXA' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.deserialise(byte[], int, int, int)"})
  void testDeserialiseWithAllBytesLengthSizeValueSizeDelimiter_thenReturnAxaBytesIsUtf8()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    byte[] actualDeserialiseResult = LengthValueBytesSerialiserUtil.deserialise("AXAXAXAX".getBytes("UTF-8"), 3, 3, 1);

    // Assert
    assertArrayEquals("AXA".getBytes("UTF-8"), actualDeserialiseResult);
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int, int, int)} with {@code allBytes}, {@code lengthSize}, {@code valueSize}, {@code delimiter}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int, int, int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int, int, int) with 'allBytes', 'lengthSize', 'valueSize', 'delimiter'; when empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.deserialise(byte[], int, int, int)"})
  void testDeserialiseWithAllBytesLengthSizeValueSizeDelimiter_whenEmptyArrayOfByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, LengthValueBytesSerialiserUtil.deserialise(new byte[]{}, 3, 3, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int, int, int)} with {@code allBytes}, {@code lengthSize}, {@code valueSize}, {@code delimiter}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(byte[], int, int, int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int, int, int) with 'allBytes', 'lengthSize', 'valueSize', 'delimiter'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.deserialise(byte[], int, int, int)"})
  void testDeserialiseWithAllBytesLengthSizeValueSizeDelimiter_whenNull() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, LengthValueBytesSerialiserUtil.deserialise(null, 3, 3, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(byte[])} with {@code allBytes}.
   * <ul>
   *   <li>Then return array length is sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'allBytes'; then return array length is sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.deserialise(byte[])"})
  void testDeserialiseWithAllBytes_thenReturnArrayLengthIsSixtyFive()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange and Act
    byte[] actualDeserialiseResult = LengthValueBytesSerialiserUtil.deserialise("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(65, actualDeserialiseResult.length);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[10]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[11]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[12]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[13]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[14]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[15]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[17]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[18]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[19]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[20]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[21]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[22]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[23]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[24]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[40]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[41]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[42]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[43]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[44]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[45]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[46]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[47]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[48]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[49]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[50]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[51]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[52]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[53]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[54]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[55]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[56]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[57]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[58]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[59]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[60]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[61]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[62]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[63]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[7]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[8]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[9]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[Double.SIZE]);
    assertEquals(MultiSerialiserStorageTest.BYTE, actualDeserialiseResult[Short.SIZE]);
    assertEquals('A', actualDeserialiseResult[1]);
    assertEquals('A', actualDeserialiseResult[3]);
    assertEquals('A', actualDeserialiseResult[5]);
    assertEquals('X', actualDeserialiseResult[0]);
    assertEquals('X', actualDeserialiseResult[2]);
    assertEquals('X', actualDeserialiseResult[4]);
    assertEquals('X', actualDeserialiseResult[6]);
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(byte[])} with {@code allBytes}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'allBytes'; when empty array of byte; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.deserialise(byte[])"})
  void testDeserialiseWithAllBytes_whenEmptyArrayOfByte_thenReturnEmptyArrayOfByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, LengthValueBytesSerialiserUtil.deserialise(new byte[]{}));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(byte[])} with {@code allBytes}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'allBytes'; when 'null'; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.deserialise(byte[])"})
  void testDeserialiseWithAllBytes_whenNull_thenReturnEmptyArrayOfByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, LengthValueBytesSerialiserUtil.deserialise(null));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[], int[])} with {@code serialiser}, {@code allBytes}, {@code delimiterWrapper}.
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[], int[])}
   */
  @Test
  @DisplayName("Test deserialise(ToBytesSerialiser, byte[], int[]) with 'serialiser', 'allBytes', 'delimiterWrapper'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LengthValueBytesSerialiserUtil.deserialise(ToBytesSerialiser, byte[], int[])"})
  void testDeserialiseWithSerialiserAllBytesDelimiterWrapper()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    JavaSerialiser serialiser = new JavaSerialiser();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> LengthValueBytesSerialiserUtil.deserialise(serialiser,
        "AXAXAXAX".getBytes("UTF-8"), new int[]{1, 0, 1, 0}));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[], int)} with {@code serialiser}, {@code allBytes}, {@code delimiter}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[], int)}
   */
  @Test
  @DisplayName("Test deserialise(ToBytesSerialiser, byte[], int) with 'serialiser', 'allBytes', 'delimiter'; when empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LengthValueBytesSerialiserUtil.deserialise(ToBytesSerialiser, byte[], int)"})
  void testDeserialiseWithSerialiserAllBytesDelimiter_whenEmptyArrayOfByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(LengthValueBytesSerialiserUtil.deserialise(new JavaSerialiser(), new byte[]{}, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[], int)} with {@code serialiser}, {@code allBytes}, {@code delimiter}.
   * <ul>
   *   <li>When {@link NullSerialiser} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[], int)}
   */
  @Test
  @DisplayName("Test deserialise(ToBytesSerialiser, byte[], int) with 'serialiser', 'allBytes', 'delimiter'; when NullSerialiser (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LengthValueBytesSerialiserUtil.deserialise(ToBytesSerialiser, byte[], int)"})
  void testDeserialiseWithSerialiserAllBytesDelimiter_whenNullSerialiser_thenReturnNull()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    NullSerialiser serialiser = new NullSerialiser();

    // Act and Assert
    assertNull(LengthValueBytesSerialiserUtil.deserialise(serialiser, "AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[], int)} with {@code serialiser}, {@code allBytes}, {@code delimiter}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[], int)}
   */
  @Test
  @DisplayName("Test deserialise(ToBytesSerialiser, byte[], int) with 'serialiser', 'allBytes', 'delimiter'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LengthValueBytesSerialiserUtil.deserialise(ToBytesSerialiser, byte[], int)"})
  void testDeserialiseWithSerialiserAllBytesDelimiter_whenNull_thenReturnNull() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(LengthValueBytesSerialiserUtil.deserialise(new JavaSerialiser(), null, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[])} with {@code serialiser}, {@code allBytes}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[])}
   */
  @Test
  @DisplayName("Test deserialise(ToBytesSerialiser, byte[]) with 'serialiser', 'allBytes'; when empty array of byte; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LengthValueBytesSerialiserUtil.deserialise(ToBytesSerialiser, byte[])"})
  void testDeserialiseWithSerialiserAllBytes_whenEmptyArrayOfByte_thenReturnNull() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(LengthValueBytesSerialiserUtil.deserialise(new JavaSerialiser(), new byte[]{}));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[])} with {@code serialiser}, {@code allBytes}.
   * <ul>
   *   <li>When {@link NullSerialiser} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[])}
   */
  @Test
  @DisplayName("Test deserialise(ToBytesSerialiser, byte[]) with 'serialiser', 'allBytes'; when NullSerialiser (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LengthValueBytesSerialiserUtil.deserialise(ToBytesSerialiser, byte[])"})
  void testDeserialiseWithSerialiserAllBytes_whenNullSerialiser_thenReturnNull()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    NullSerialiser serialiser = new NullSerialiser();

    // Act and Assert
    assertNull(LengthValueBytesSerialiserUtil.deserialise(serialiser, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[])} with {@code serialiser}, {@code allBytes}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialise(ToBytesSerialiser, byte[])}
   */
  @Test
  @DisplayName("Test deserialise(ToBytesSerialiser, byte[]) with 'serialiser', 'allBytes'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object LengthValueBytesSerialiserUtil.deserialise(ToBytesSerialiser, byte[])"})
  void testDeserialiseWithSerialiserAllBytes_whenNull_thenReturnNull() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(LengthValueBytesSerialiserUtil.deserialise(new JavaSerialiser(), null));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getLengthSize(byte[], int)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getLengthSize(byte[], int)}
   */
  @Test
  @DisplayName("Test getLengthSize(byte[], int); when 'A'; then return nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getLengthSize(byte[], int)"})
  void testGetLengthSize_whenA_thenReturnNine() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(9,
        LengthValueBytesSerialiserUtil.getLengthSize(new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getLengthSize(byte[], int)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getLengthSize(byte[], int)}
   */
  @Test
  @DisplayName("Test getLengthSize(byte[], int); when 'AXAXAXAX' Bytes is 'UTF-8'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getLengthSize(byte[], int)"})
  void testGetLengthSize_whenAxaxaxaxBytesIsUtf8_thenReturnOne()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertEquals(1, LengthValueBytesSerialiserUtil.getLengthSize("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getValueSize(byte[], int)} with {@code allBytes}, {@code delimiter}.
   * <ul>
   *   <li>Then return eighty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getValueSize(byte[], int)}
   */
  @Test
  @DisplayName("Test getValueSize(byte[], int) with 'allBytes', 'delimiter'; then return eighty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getValueSize(byte[], int)"})
  void testGetValueSizeWithAllBytesDelimiter_thenReturnEightyEight()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertEquals(88, LengthValueBytesSerialiserUtil.getValueSize("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getValueSize(byte[], int)} with {@code allBytes}, {@code delimiter}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code -1096351744}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getValueSize(byte[], int)}
   */
  @Test
  @DisplayName("Test getValueSize(byte[], int) with 'allBytes', 'delimiter'; when 'A'; then return '-1096351744'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getValueSize(byte[], int)"})
  void testGetValueSizeWithAllBytesDelimiter_whenA_thenReturn1096351744() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(-1096351744,
        LengthValueBytesSerialiserUtil.getValueSize(new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getValueSize(byte[], int, int)} with {@code allBytes}, {@code lengthSize}, {@code delimiter}.
   * <ul>
   *   <li>Then return eighty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getValueSize(byte[], int, int)}
   */
  @Test
  @DisplayName("Test getValueSize(byte[], int, int) with 'allBytes', 'lengthSize', 'delimiter'; then return eighty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getValueSize(byte[], int, int)"})
  void testGetValueSizeWithAllBytesLengthSizeDelimiter_thenReturnEightyEight()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertEquals(88, LengthValueBytesSerialiserUtil.getValueSize("AXAXAXAX".getBytes("UTF-8"), 3, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getValueSize(byte[], int, int)} with {@code allBytes}, {@code lengthSize}, {@code delimiter}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getValueSize(byte[], int, int)}
   */
  @Test
  @DisplayName("Test getValueSize(byte[], int, int) with 'allBytes', 'lengthSize', 'delimiter'; when 'A'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getValueSize(byte[], int, int)"})
  void testGetValueSizeWithAllBytesLengthSizeDelimiter_whenA_thenReturnZero() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(0, LengthValueBytesSerialiserUtil
        .getValueSize(new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 3, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getNextDelimiter(byte[], int)} with {@code allBytes}, {@code delimiter}.
   * <ul>
   *   <li>Then return ninety.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getNextDelimiter(byte[], int)}
   */
  @Test
  @DisplayName("Test getNextDelimiter(byte[], int) with 'allBytes', 'delimiter'; then return ninety")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getNextDelimiter(byte[], int)"})
  void testGetNextDelimiterWithAllBytesDelimiter_thenReturnNinety()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange, Act and Assert
    assertEquals(90, LengthValueBytesSerialiserUtil.getNextDelimiter("AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getNextDelimiter(byte[], int)} with {@code allBytes}, {@code delimiter}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return {@code -1096351734}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getNextDelimiter(byte[], int)}
   */
  @Test
  @DisplayName("Test getNextDelimiter(byte[], int) with 'allBytes', 'delimiter'; when 'A'; then return '-1096351734'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getNextDelimiter(byte[], int)"})
  void testGetNextDelimiterWithAllBytesDelimiter_whenA_thenReturn1096351734() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(-1096351734, LengthValueBytesSerialiserUtil
        .getNextDelimiter(new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getNextDelimiter(byte[], byte[], int)} with {@code allBytes}, {@code valueBytes}, {@code lastDelimiter}.
   * <ul>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getNextDelimiter(byte[], byte[], int)}
   */
  @Test
  @DisplayName("Test getNextDelimiter(byte[], byte[], int) with 'allBytes', 'valueBytes', 'lastDelimiter'; then return ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getNextDelimiter(byte[], byte[], int)"})
  void testGetNextDelimiterWithAllBytesValueBytesLastDelimiter_thenReturnTen() throws UnsupportedEncodingException {
    // Arrange
    byte[] allBytes = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(10, LengthValueBytesSerialiserUtil.getNextDelimiter(allBytes, "AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getNextDelimiter(byte[], byte[], int)} with {@code allBytes}, {@code valueBytes}, {@code lastDelimiter}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return eighteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getNextDelimiter(byte[], byte[], int)}
   */
  @Test
  @DisplayName("Test getNextDelimiter(byte[], byte[], int) with 'allBytes', 'valueBytes', 'lastDelimiter'; when 'A'; then return eighteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getNextDelimiter(byte[], byte[], int)"})
  void testGetNextDelimiterWithAllBytesValueBytesLastDelimiter_whenA_thenReturnEighteen()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(18, LengthValueBytesSerialiserUtil.getNextDelimiter(
        new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, "AXAXAXAX".getBytes("UTF-8"), 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getNextDelimiter(byte[], int, int)} with {@code allBytes}, {@code valueSize}, {@code lastDelimiter}.
   * <ul>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getNextDelimiter(byte[], int, int)}
   */
  @Test
  @DisplayName("Test getNextDelimiter(byte[], int, int) with 'allBytes', 'valueSize', 'lastDelimiter'; then return five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getNextDelimiter(byte[], int, int)"})
  void testGetNextDelimiterWithAllBytesValueSizeLastDelimiter_thenReturnFive() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(5, LengthValueBytesSerialiserUtil.getNextDelimiter("AXAXAXAX".getBytes("UTF-8"), 3, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getNextDelimiter(byte[], int, int)} with {@code allBytes}, {@code valueSize}, {@code lastDelimiter}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return thirteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getNextDelimiter(byte[], int, int)}
   */
  @Test
  @DisplayName("Test getNextDelimiter(byte[], int, int) with 'allBytes', 'valueSize', 'lastDelimiter'; when 'A'; then return thirteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getNextDelimiter(byte[], int, int)"})
  void testGetNextDelimiterWithAllBytesValueSizeLastDelimiter_whenA_thenReturnThirteen() {
    // Arrange, Act and Assert
    assertEquals(13, LengthValueBytesSerialiserUtil
        .getNextDelimiter(new byte[]{'A', Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, 3, 1));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getNextDelimiter(int, int, int)} with {@code lengthSize}, {@code valueSize}, {@code lastDelimiter}.
   * <ul>
   *   <li>Then return five.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getNextDelimiter(int, int, int)}
   */
  @Test
  @DisplayName("Test getNextDelimiter(int, int, int) with 'lengthSize', 'valueSize', 'lastDelimiter'; then return five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getNextDelimiter(int, int, int)"})
  void testGetNextDelimiterWithLengthSizeValueSizeLastDelimiter_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5, LengthValueBytesSerialiserUtil.getNextDelimiter(-1, 3, 3));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getNextDelimiter(int, int, int)} with {@code lengthSize}, {@code valueSize}, {@code lastDelimiter}.
   * <ul>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getNextDelimiter(int, int, int)}
   */
  @Test
  @DisplayName("Test getNextDelimiter(int, int, int) with 'lengthSize', 'valueSize', 'lastDelimiter'; then return nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getNextDelimiter(int, int, int)"})
  void testGetNextDelimiterWithLengthSizeValueSizeLastDelimiter_thenReturnNine() {
    // Arrange, Act and Assert
    assertEquals(9, LengthValueBytesSerialiserUtil.getNextDelimiter(3, 3, 3));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getNextDelimiter(int, int, int)} with {@code lengthSize}, {@code valueSize}, {@code lastDelimiter}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getNextDelimiter(int, int, int)}
   */
  @Test
  @DisplayName("Test getNextDelimiter(int, int, int) with 'lengthSize', 'valueSize', 'lastDelimiter'; when one; then return seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getNextDelimiter(int, int, int)"})
  void testGetNextDelimiterWithLengthSizeValueSizeLastDelimiter_whenOne_thenReturnSeven() {
    // Arrange, Act and Assert
    assertEquals(7, LengthValueBytesSerialiserUtil.getNextDelimiter(1, 3, 3));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getNextDelimiter(int, int, int)} with {@code lengthSize}, {@code valueSize}, {@code lastDelimiter}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return six.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getNextDelimiter(int, int, int)}
   */
  @Test
  @DisplayName("Test getNextDelimiter(int, int, int) with 'lengthSize', 'valueSize', 'lastDelimiter'; when zero; then return six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LengthValueBytesSerialiserUtil.getNextDelimiter(int, int, int)"})
  void testGetNextDelimiterWithLengthSizeValueSizeLastDelimiter_whenZero_thenReturnSix() {
    // Arrange, Act and Assert
    assertEquals(6, LengthValueBytesSerialiserUtil.getNextDelimiter(0, 3, 3));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getValueBytes(ToBytesSerialiser, Object)}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus eighty-four and minus nineteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getValueBytes(ToBytesSerialiser, Object)}
   */
  @Test
  @DisplayName("Test getValueBytes(ToBytesSerialiser, Object); then return array of byte with minus eighty-four and minus nineteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.getValueBytes(ToBytesSerialiser, Object)"})
  void testGetValueBytes_thenReturnArrayOfByteWithMinusEightyFourAndMinusNineteen() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-84, -19, MultiSerialiserStorageTest.BYTE, 5, 't', MultiSerialiserStorageTest.BYTE, 5,
        'V', 'a', 'l', 'u', 'e'}, LengthValueBytesSerialiserUtil.getValueBytes(new JavaSerialiser(), "Value"));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getValueBytes(ToBytesSerialiser, Object)}.
   * <ul>
   *   <li>When {@link JavaSerialiser} (default constructor).</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getValueBytes(ToBytesSerialiser, Object)}
   */
  @Test
  @DisplayName("Test getValueBytes(ToBytesSerialiser, Object); when JavaSerialiser (default constructor); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.getValueBytes(ToBytesSerialiser, Object)"})
  void testGetValueBytes_whenJavaSerialiser_thenReturnEmptyArrayOfByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, LengthValueBytesSerialiserUtil.getValueBytes(new JavaSerialiser(), null));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#getValueBytes(ToBytesSerialiser, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#getValueBytes(ToBytesSerialiser, Object)}
   */
  @Test
  @DisplayName("Test getValueBytes(ToBytesSerialiser, Object); when 'null'; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] LengthValueBytesSerialiserUtil.getValueBytes(ToBytesSerialiser, Object)"})
  void testGetValueBytes_whenNull_thenReturnEmptyArrayOfByte() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, LengthValueBytesSerialiserUtil.getValueBytes(null, null));
  }

  /**
   * Test {@link LengthValueBytesSerialiserUtil#deserialiseNextObject(ToBytesSerialiser, int, byte[])}.
   * <ul>
   *   <li>When {@link NullSerialiser} (default constructor).</li>
   *   <li>Then return Object is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LengthValueBytesSerialiserUtil#deserialiseNextObject(ToBytesSerialiser, int, byte[])}
   */
  @Test
  @DisplayName("Test deserialiseNextObject(ToBytesSerialiser, int, byte[]); when NullSerialiser (default constructor); then return Object is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ObjectCarriage LengthValueBytesSerialiserUtil.deserialiseNextObject(ToBytesSerialiser, int, byte[])"})
  void testDeserialiseNextObject_whenNullSerialiser_thenReturnObjectIsNull()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    NullSerialiser serialiser = new NullSerialiser();

    // Act
    ObjectCarriage<Object> actualDeserialiseNextObjectResult = LengthValueBytesSerialiserUtil
        .deserialiseNextObject(serialiser, 1, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualDeserialiseNextObjectResult.getObject());
    assertEquals(90, actualDeserialiseNextObjectResult.getCarriage());
  }
}
