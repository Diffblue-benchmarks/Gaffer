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

package uk.gov.gchq.gaffer.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class AvroSerialiserDiffblueTest {
  /**
   * Test {@link AvroSerialiser#serialise(Object)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return forty-fifth element is fourteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvroSerialiser#serialise(Object)}
   */
  @Test
  @DisplayName("Test serialise(Object); when 'Object'; then return forty-fifth element is fourteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AvroSerialiser.serialise(Object)"})
  void testSerialise_whenObject_thenReturnFortyFifthElementIsFourteen() throws SerialisationException {
    // Arrange and Act
    byte[] actualSerialiseResult = (new AvroSerialiser()).serialise("Object");

    // Assert
    assertEquals((byte) 14, actualSerialiseResult[44]);
    assertEquals((byte) 16, actualSerialiseResult[17]);
    assertEquals((byte) 1, actualSerialiseResult[3]);
    assertEquals((byte) 22, actualSerialiseResult[5]);
    assertEquals((byte) 2, actualSerialiseResult[4]);
    assertEquals((byte) 2, actualSerialiseResult[43]);
    assertEquals(68, actualSerialiseResult.length);
    assertEquals('.', actualSerialiseResult[10]);
    assertEquals('O', actualSerialiseResult[0]);
    assertEquals('O', actualSerialiseResult[46]);
    assertEquals('"', actualSerialiseResult[18]);
    assertEquals('\f', actualSerialiseResult[45]);
    assertEquals('a', actualSerialiseResult[6]);
    assertEquals('a', actualSerialiseResult[Short.SIZE]);
    assertEquals('b', actualSerialiseResult[1]);
    assertEquals('b', actualSerialiseResult[47]);
    assertEquals('c', actualSerialiseResult[12]);
    assertEquals('c', actualSerialiseResult[50]);
    assertEquals('e', actualSerialiseResult[14]);
    assertEquals('e', actualSerialiseResult[49]);
    assertEquals('g', actualSerialiseResult[24]);
    assertEquals('h', actualSerialiseResult[13]);
    assertEquals('i', actualSerialiseResult[22]);
    assertEquals('j', actualSerialiseResult[2]);
    assertEquals('j', actualSerialiseResult[48]);
    assertEquals('m', actualSerialiseResult[15]);
    assertEquals('n', actualSerialiseResult[23]);
    assertEquals('o', actualSerialiseResult[9]);
    assertEquals('r', actualSerialiseResult[21]);
    assertEquals('r', actualSerialiseResult[8]);
    assertEquals('s', actualSerialiseResult[11]);
    assertEquals('s', actualSerialiseResult[19]);
    assertEquals('t', actualSerialiseResult[20]);
    assertEquals('t', actualSerialiseResult[51]);
    assertEquals('v', actualSerialiseResult[7]);
  }

  /**
   * Test {@link AvroSerialiser#deserialise(byte[], int, int)} with {@code allBytes}, {@code offset}, {@code length}.
   * <ul>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvroSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], int, int) with 'allBytes', 'offset', 'length'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AvroSerialiser.deserialise(byte[], int, int)"})
  void testDeserialiseWithAllBytesOffsetLength_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class, () -> avroSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link AvroSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvroSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when 'AXAXAXAX' Bytes is 'UTF-8'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AvroSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenAxaxaxaxBytesIsUtf8_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class, () -> avroSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AvroSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvroSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when empty array of byte; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AvroSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenEmptyArrayOfByte_thenThrowSerialisationException() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class, () -> (new AvroSerialiser()).deserialise(new byte[]{}));
  }

  /**
   * Test {@link AvroSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvroSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; when 'XXAXAXAX' Bytes is 'UTF-8'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AvroSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenXxaxaxaxBytesIsUtf8_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class, () -> avroSerialiser.deserialise("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link AvroSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link AvroSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object AvroSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new AvroSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link AvroSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link AvroSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AvroSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new AvroSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link AvroSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Class}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvroSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Class'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AvroSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangClass_thenReturnFalse() {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();
    Class<Class> clazz = Class.class;

    // Act and Assert
    assertFalse(avroSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link AvroSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvroSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AvroSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnTrue() {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertTrue(avroSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link AvroSerialiser#equals(Object)}, and {@link AvroSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AvroSerialiser#equals(Object)}
   *   <li>{@link AvroSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AvroSerialiser.equals(Object)", "int AvroSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();
    AvroSerialiser avroSerialiser2 = new AvroSerialiser();

    // Act and Assert
    assertEquals(avroSerialiser, avroSerialiser2);
    int expectedHashCodeResult = avroSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, avroSerialiser2.hashCode());
  }

  /**
   * Test {@link AvroSerialiser#equals(Object)}, and {@link AvroSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AvroSerialiser#equals(Object)}
   *   <li>{@link AvroSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AvroSerialiser.equals(Object)", "int AvroSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();

    // Act and Assert
    assertEquals(avroSerialiser, avroSerialiser);
    int expectedHashCodeResult = avroSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, avroSerialiser.hashCode());
  }

  /**
   * Test {@link AvroSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvroSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AvroSerialiser.equals(Object)", "int AvroSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AvroSerialiser(), 1);
  }

  /**
   * Test {@link AvroSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvroSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AvroSerialiser.equals(Object)", "int AvroSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AvroSerialiser(), null);
  }

  /**
   * Test {@link AvroSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AvroSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AvroSerialiser.equals(Object)", "int AvroSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AvroSerialiser(), "Different type to AvroSerialiser");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AvroSerialiser}
   *   <li>{@link AvroSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AvroSerialiser.<init>()", "boolean AvroSerialiser.isConsistent()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new AvroSerialiser()).isConsistent());
  }
}
