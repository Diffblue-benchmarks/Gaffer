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

package uk.gov.gchq.gaffer.serialisation.implementation.ordered;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class OrderedLongSerialiserDiffblueTest {
  /**
   * Method under test: {@link OrderedLongSerialiser#serialise(Long)}
   */
  @Test
  void testSerialise() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'\b', Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 1},
        (new OrderedLongSerialiser()).serialise(1L));
    assertArrayEquals(new byte[]{'\b', Byte.MAX_VALUE, -1, -1, -1, -1, -1, -1, -1},
        (new OrderedLongSerialiser()).serialise(-1L));
    assertArrayEquals(new byte[]{16}, (new OrderedLongSerialiser()).serialise(Long.MAX_VALUE));
  }

  /**
   * Method under test: {@link OrderedLongSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    OrderedLongSerialiser orderedLongSerialiser = new OrderedLongSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class, () -> orderedLongSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link OrderedLongSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise2() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(Long.MIN_VALUE, (new OrderedLongSerialiser()).deserialise(new byte[]{0}).longValue());
  }

  /**
   * Method under test: {@link OrderedLongSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise3() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class, () -> (new OrderedLongSerialiser()).deserialise(new byte[]{-1}));
  }

  /**
   * Method under test: {@link OrderedLongSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise4() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE, (new OrderedLongSerialiser()).deserialise(new byte[]{16}).longValue());
  }

  /**
   * Method under test: {@link OrderedLongSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise5() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE,
        (new OrderedLongSerialiser()).deserialise(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}).longValue());
  }

  /**
   * Method under test: {@link OrderedLongSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    OrderedLongSerialiser orderedLongSerialiser = new OrderedLongSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderedLongSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link OrderedLongSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    OrderedLongSerialiser orderedLongSerialiser = new OrderedLongSerialiser();
    Class<Long> clazz = Long.class;

    // Act and Assert
    assertTrue(orderedLongSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link OrderedLongSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new OrderedLongSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link OrderedLongSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new OrderedLongSerialiser()).preservesObjectOrdering());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedLongSerialiser#equals(Object)}
   *   <li>{@link OrderedLongSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderedLongSerialiser orderedLongSerialiser = new OrderedLongSerialiser();
    OrderedLongSerialiser orderedLongSerialiser2 = new OrderedLongSerialiser();

    // Act and Assert
    assertEquals(orderedLongSerialiser, orderedLongSerialiser2);
    int expectedHashCodeResult = orderedLongSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedLongSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedLongSerialiser#equals(Object)}
   *   <li>{@link OrderedLongSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderedLongSerialiser orderedLongSerialiser = new OrderedLongSerialiser();

    // Act and Assert
    assertEquals(orderedLongSerialiser, orderedLongSerialiser);
    int expectedHashCodeResult = orderedLongSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedLongSerialiser.hashCode());
  }

  /**
   * Method under test: {@link OrderedLongSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedLongSerialiser(), 1);
  }

  /**
   * Method under test: {@link OrderedLongSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedLongSerialiser(), null);
  }

  /**
   * Method under test: {@link OrderedLongSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedLongSerialiser(), "Different type to OrderedLongSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderedLongSerialiser}
   *   <li>{@link OrderedLongSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new OrderedLongSerialiser()).isConsistent());
  }
}
