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

class CompactRawLongSerialiserDiffblueTest {
  /**
   * Method under test: {@link CompactRawLongSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    CompactRawLongSerialiser compactRawLongSerialiser = new CompactRawLongSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(compactRawLongSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link CompactRawLongSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    CompactRawLongSerialiser compactRawLongSerialiser = new CompactRawLongSerialiser();
    Class<Long> clazz = Long.class;

    // Act and Assert
    assertTrue(compactRawLongSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link CompactRawLongSerialiser#serialise(Long)}
   */
  @Test
  void testSerialise() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1}, (new CompactRawLongSerialiser()).serialise(1L));
    assertArrayEquals(new byte[]{-121, 'p'}, (new CompactRawLongSerialiser()).serialise(-113L));
    assertArrayEquals(new byte[]{-113, Byte.MIN_VALUE}, (new CompactRawLongSerialiser()).serialise(128L));
  }

  /**
   * Method under test: {@link CompactRawLongSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    CompactRawLongSerialiser compactRawLongSerialiser = new CompactRawLongSerialiser();

    // Act and Assert
    assertEquals(65L, compactRawLongSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")).longValue());
  }

  /**
   * Method under test:
   * {@link CompactRawLongSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  void testDeserialise2() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    CompactRawLongSerialiser compactRawLongSerialiser = new CompactRawLongSerialiser();

    // Act and Assert
    assertEquals(65L, compactRawLongSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3).longValue());
  }

  /**
   * Method under test: {@link CompactRawLongSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new CompactRawLongSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link CompactRawLongSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new CompactRawLongSerialiser()).preservesObjectOrdering());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompactRawLongSerialiser#equals(Object)}
   *   <li>{@link CompactRawLongSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CompactRawLongSerialiser compactRawLongSerialiser = new CompactRawLongSerialiser();
    CompactRawLongSerialiser compactRawLongSerialiser2 = new CompactRawLongSerialiser();

    // Act and Assert
    assertEquals(compactRawLongSerialiser, compactRawLongSerialiser2);
    int expectedHashCodeResult = compactRawLongSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, compactRawLongSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompactRawLongSerialiser#equals(Object)}
   *   <li>{@link CompactRawLongSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CompactRawLongSerialiser compactRawLongSerialiser = new CompactRawLongSerialiser();

    // Act and Assert
    assertEquals(compactRawLongSerialiser, compactRawLongSerialiser);
    int expectedHashCodeResult = compactRawLongSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, compactRawLongSerialiser.hashCode());
  }

  /**
   * Method under test: {@link CompactRawLongSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompactRawLongSerialiser(), 1);
  }

  /**
   * Method under test: {@link CompactRawLongSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompactRawLongSerialiser(), null);
  }

  /**
   * Method under test: {@link CompactRawLongSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CompactRawLongSerialiser(), "Different type to CompactRawLongSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CompactRawLongSerialiser}
   *   <li>{@link CompactRawLongSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new CompactRawLongSerialiser()).isConsistent());
  }
}
