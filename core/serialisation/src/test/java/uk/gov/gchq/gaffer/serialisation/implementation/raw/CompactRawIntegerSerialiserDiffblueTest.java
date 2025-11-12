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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class CompactRawIntegerSerialiserDiffblueTest {
  /**
   * Method under test: {@link CompactRawIntegerSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    CompactRawIntegerSerialiser compactRawIntegerSerialiser = new CompactRawIntegerSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(compactRawIntegerSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link CompactRawIntegerSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    CompactRawIntegerSerialiser compactRawIntegerSerialiser = new CompactRawIntegerSerialiser();
    Class<Integer> clazz = Integer.class;

    // Act and Assert
    assertTrue(compactRawIntegerSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link CompactRawIntegerSerialiser#serialise(Integer)}
   */
  @Test
  void testSerialise() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1}, (new CompactRawIntegerSerialiser()).serialise(1));
    assertArrayEquals(new byte[]{-124, Byte.MAX_VALUE, -1, -1, -1},
        (new CompactRawIntegerSerialiser()).serialise(Integer.MIN_VALUE));
  }

  /**
   * Method under test: {@link CompactRawIntegerSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    CompactRawIntegerSerialiser compactRawIntegerSerialiser = new CompactRawIntegerSerialiser();

    // Act and Assert
    assertEquals(65, compactRawIntegerSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")).intValue());
  }

  /**
   * Method under test:
   * {@link CompactRawIntegerSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  void testDeserialise2() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    CompactRawIntegerSerialiser compactRawIntegerSerialiser = new CompactRawIntegerSerialiser();

    // Act and Assert
    assertEquals(65, compactRawIntegerSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3).intValue());
  }

  /**
   * Method under test: {@link CompactRawIntegerSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new CompactRawIntegerSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test:
   * {@link CompactRawIntegerSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new CompactRawIntegerSerialiser()).preservesObjectOrdering());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompactRawIntegerSerialiser#equals(Object)}
   *   <li>{@link CompactRawIntegerSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CompactRawIntegerSerialiser compactRawIntegerSerialiser = new CompactRawIntegerSerialiser();
    CompactRawIntegerSerialiser compactRawIntegerSerialiser2 = new CompactRawIntegerSerialiser();

    // Act and Assert
    assertEquals(compactRawIntegerSerialiser, compactRawIntegerSerialiser2);
    int expectedHashCodeResult = compactRawIntegerSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, compactRawIntegerSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompactRawIntegerSerialiser#equals(Object)}
   *   <li>{@link CompactRawIntegerSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompactRawIntegerSerialiser compactRawIntegerSerialiser = new CompactRawIntegerSerialiser();

    // Act and Assert
    assertEquals(compactRawIntegerSerialiser, compactRawIntegerSerialiser);
    int expectedHashCodeResult = compactRawIntegerSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, compactRawIntegerSerialiser.hashCode());
  }

  /**
   * Method under test: {@link CompactRawIntegerSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompactRawIntegerSerialiser(), 1);
  }

  /**
   * Method under test: {@link CompactRawIntegerSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompactRawIntegerSerialiser(), null);
  }

  /**
   * Method under test: {@link CompactRawIntegerSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompactRawIntegerSerialiser(), "Different type to CompactRawIntegerSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link CompactRawIntegerSerialiser}
   *   <li>{@link CompactRawIntegerSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new CompactRawIntegerSerialiser()).isConsistent());
  }
}
