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
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class AvroSerialiserDiffblueTest {
  /**
   * Method under test: {@link AvroSerialiser#serialise(Object)}
   */
  @Test
  void testSerialise() throws SerialisationException {
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
   * Method under test: {@link AvroSerialiser#serialise(Object)}
   */
  @Test
  void testSerialise2() throws SerialisationException {
    // Arrange and Act
    byte[] actualSerialiseResult = (new AvroSerialiser()).serialise(42);

    // Assert
    assertEquals((byte) 0, actualSerialiseResult[23]);
    assertEquals((byte) 1, actualSerialiseResult[3]);
    assertEquals((byte) 22, actualSerialiseResult[5]);
    assertEquals((byte) 2, actualSerialiseResult[4]);
    assertEquals((byte) 2, actualSerialiseResult[40]);
    assertEquals((byte) 2, actualSerialiseResult[41]);
    assertEquals(59, actualSerialiseResult.length);
    assertEquals('.', actualSerialiseResult[10]);
    assertEquals('O', actualSerialiseResult[0]);
    assertEquals('T', actualSerialiseResult[42]);
    assertEquals('"', actualSerialiseResult[18]);
    assertEquals('"', actualSerialiseResult[22]);
    assertEquals('\n', actualSerialiseResult[17]);
    assertEquals('a', actualSerialiseResult[6]);
    assertEquals('a', actualSerialiseResult[Short.SIZE]);
    assertEquals('b', actualSerialiseResult[1]);
    assertEquals('c', actualSerialiseResult[12]);
    assertEquals('e', actualSerialiseResult[14]);
    assertEquals('h', actualSerialiseResult[13]);
    assertEquals('i', actualSerialiseResult[19]);
    assertEquals('j', actualSerialiseResult[2]);
    assertEquals('m', actualSerialiseResult[15]);
    assertEquals('n', actualSerialiseResult[20]);
    assertEquals('o', actualSerialiseResult[9]);
    assertEquals('r', actualSerialiseResult[8]);
    assertEquals('s', actualSerialiseResult[11]);
    assertEquals('t', actualSerialiseResult[21]);
    assertEquals('v', actualSerialiseResult[7]);
  }

  /**
   * Method under test: {@link AvroSerialiser#serialise(Object)}
   */
  @Test
  void testSerialise3() throws SerialisationException {
    // Arrange and Act
    byte[] actualSerialiseResult = (new AvroSerialiser()).serialise(1);

    // Assert
    assertEquals((byte) 0, actualSerialiseResult[23]);
    assertEquals((byte) 1, actualSerialiseResult[3]);
    assertEquals((byte) 22, actualSerialiseResult[5]);
    assertEquals((byte) 2, actualSerialiseResult[4]);
    assertEquals((byte) 2, actualSerialiseResult[40]);
    assertEquals((byte) 2, actualSerialiseResult[41]);
    assertEquals((byte) 2, actualSerialiseResult[42]);
    assertEquals(59, actualSerialiseResult.length);
    assertEquals('.', actualSerialiseResult[10]);
    assertEquals('O', actualSerialiseResult[0]);
    assertEquals('"', actualSerialiseResult[18]);
    assertEquals('"', actualSerialiseResult[22]);
    assertEquals('\n', actualSerialiseResult[17]);
    assertEquals('a', actualSerialiseResult[6]);
    assertEquals('a', actualSerialiseResult[Short.SIZE]);
    assertEquals('b', actualSerialiseResult[1]);
    assertEquals('c', actualSerialiseResult[12]);
    assertEquals('e', actualSerialiseResult[14]);
    assertEquals('h', actualSerialiseResult[13]);
    assertEquals('i', actualSerialiseResult[19]);
    assertEquals('j', actualSerialiseResult[2]);
    assertEquals('m', actualSerialiseResult[15]);
    assertEquals('n', actualSerialiseResult[20]);
    assertEquals('o', actualSerialiseResult[9]);
    assertEquals('r', actualSerialiseResult[8]);
    assertEquals('s', actualSerialiseResult[11]);
    assertEquals('t', actualSerialiseResult[21]);
    assertEquals('v', actualSerialiseResult[7]);
  }

  /**
   * Method under test: {@link AvroSerialiser#serialise(Object)}
   */
  @Test
  void testSerialise4() throws SerialisationException {
    // Arrange and Act
    byte[] actualSerialiseResult = (new AvroSerialiser()).serialise(Integer.MIN_VALUE);

    // Assert
    assertEquals((byte) -1, actualSerialiseResult[42]);
    assertEquals((byte) -1, actualSerialiseResult[43]);
    assertEquals((byte) -1, actualSerialiseResult[44]);
    assertEquals((byte) -1, actualSerialiseResult[45]);
    assertEquals((byte) 0, actualSerialiseResult[23]);
    assertEquals((byte) 15, actualSerialiseResult[46]);
    assertEquals((byte) 1, actualSerialiseResult[3]);
    assertEquals((byte) 22, actualSerialiseResult[5]);
    assertEquals((byte) 2, actualSerialiseResult[4]);
    assertEquals((byte) 2, actualSerialiseResult[40]);
    assertEquals(63, actualSerialiseResult.length);
    assertEquals('.', actualSerialiseResult[10]);
    assertEquals('O', actualSerialiseResult[0]);
    assertEquals('"', actualSerialiseResult[18]);
    assertEquals('"', actualSerialiseResult[22]);
    assertEquals('\n', actualSerialiseResult[17]);
    assertEquals('\n', actualSerialiseResult[41]);
    assertEquals('a', actualSerialiseResult[6]);
    assertEquals('a', actualSerialiseResult[Short.SIZE]);
    assertEquals('b', actualSerialiseResult[1]);
    assertEquals('c', actualSerialiseResult[12]);
    assertEquals('e', actualSerialiseResult[14]);
    assertEquals('h', actualSerialiseResult[13]);
    assertEquals('i', actualSerialiseResult[19]);
    assertEquals('j', actualSerialiseResult[2]);
    assertEquals('m', actualSerialiseResult[15]);
    assertEquals('n', actualSerialiseResult[20]);
    assertEquals('o', actualSerialiseResult[9]);
    assertEquals('r', actualSerialiseResult[8]);
    assertEquals('s', actualSerialiseResult[11]);
    assertEquals('t', actualSerialiseResult[21]);
    assertEquals('v', actualSerialiseResult[7]);
  }

  /**
   * Method under test: {@link AvroSerialiser#serialise(Object)}
   */
  @Test
  void testSerialise5() throws SerialisationException {
    // Arrange and Act
    byte[] actualSerialiseResult = (new AvroSerialiser()).serialise("");

    // Assert
    assertEquals((byte) 0, actualSerialiseResult[45]);
    assertEquals((byte) 16, actualSerialiseResult[17]);
    assertEquals((byte) 1, actualSerialiseResult[3]);
    assertEquals((byte) 22, actualSerialiseResult[5]);
    assertEquals((byte) 2, actualSerialiseResult[4]);
    assertEquals((byte) 2, actualSerialiseResult[43]);
    assertEquals((byte) 2, actualSerialiseResult[44]);
    assertEquals(62, actualSerialiseResult.length);
    assertEquals('.', actualSerialiseResult[10]);
    assertEquals('O', actualSerialiseResult[0]);
    assertEquals('"', actualSerialiseResult[18]);
    assertEquals('a', actualSerialiseResult[6]);
    assertEquals('a', actualSerialiseResult[Short.SIZE]);
    assertEquals('b', actualSerialiseResult[1]);
    assertEquals('c', actualSerialiseResult[12]);
    assertEquals('e', actualSerialiseResult[14]);
    assertEquals('g', actualSerialiseResult[24]);
    assertEquals('h', actualSerialiseResult[13]);
    assertEquals('i', actualSerialiseResult[22]);
    assertEquals('j', actualSerialiseResult[2]);
    assertEquals('m', actualSerialiseResult[15]);
    assertEquals('n', actualSerialiseResult[23]);
    assertEquals('o', actualSerialiseResult[9]);
    assertEquals('r', actualSerialiseResult[21]);
    assertEquals('r', actualSerialiseResult[8]);
    assertEquals('s', actualSerialiseResult[11]);
    assertEquals('s', actualSerialiseResult[19]);
    assertEquals('t', actualSerialiseResult[20]);
    assertEquals('v', actualSerialiseResult[7]);
  }

  /**
   * Method under test: {@link AvroSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class, () -> avroSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link AvroSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise2() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class, () -> avroSerialiser.deserialise("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link AvroSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise3() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class, () -> (new AvroSerialiser()).deserialise(new byte[]{}));
  }

  /**
   * Method under test: {@link AvroSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  void testDeserialise4() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class, () -> avroSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Method under test: {@link AvroSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new AvroSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link AvroSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new AvroSerialiser()).preservesObjectOrdering());
  }

  /**
   * Method under test: {@link AvroSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertTrue(avroSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link AvroSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();
    Class<Class> clazz = Class.class;

    // Act and Assert
    assertFalse(avroSerialiser.canHandle(clazz));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AvroSerialiser#equals(Object)}
   *   <li>{@link AvroSerialiser#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link AvroSerialiser#equals(Object)}
   *   <li>{@link AvroSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AvroSerialiser avroSerialiser = new AvroSerialiser();

    // Act and Assert
    assertEquals(avroSerialiser, avroSerialiser);
    int expectedHashCodeResult = avroSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, avroSerialiser.hashCode());
  }

  /**
   * Method under test: {@link AvroSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AvroSerialiser(), 1);
  }

  /**
   * Method under test: {@link AvroSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AvroSerialiser(), null);
  }

  /**
   * Method under test: {@link AvroSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AvroSerialiser(), "Different type to AvroSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AvroSerialiser}
   *   <li>{@link AvroSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new AvroSerialiser()).isConsistent());
  }
}
