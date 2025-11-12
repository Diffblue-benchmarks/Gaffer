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

class OrderedIntegerSerialiserDiffblueTest {
  /**
   * Method under test: {@link OrderedIntegerSerialiser#serialise(Integer)}
   */
  @Test
  void testSerialise() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{4, Byte.MIN_VALUE, 0, 0, 1}, (new OrderedIntegerSerialiser()).serialise(1));
    assertArrayEquals(new byte[]{0}, (new OrderedIntegerSerialiser()).serialise(Integer.MIN_VALUE));
  }

  /**
   * Method under test: {@link OrderedIntegerSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    OrderedIntegerSerialiser orderedIntegerSerialiser = new OrderedIntegerSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> orderedIntegerSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link OrderedIntegerSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise2() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(Integer.MIN_VALUE, (new OrderedIntegerSerialiser()).deserialise(new byte[]{0}).intValue());
  }

  /**
   * Method under test: {@link OrderedIntegerSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise3() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class, () -> (new OrderedIntegerSerialiser()).deserialise(new byte[]{-1}));
  }

  /**
   * Method under test: {@link OrderedIntegerSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise4() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new OrderedIntegerSerialiser()).deserialise(new byte[]{'\b'}).intValue());
  }

  /**
   * Method under test: {@link OrderedIntegerSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise5() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    OrderedIntegerSerialiser orderedIntegerSerialiser = new OrderedIntegerSerialiser();

    // Act and Assert
    assertEquals(Integer.MAX_VALUE, orderedIntegerSerialiser.deserialise("\bXAXAXAX".getBytes("UTF-8")).intValue());
  }

  /**
   * Method under test: {@link OrderedIntegerSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new OrderedIntegerSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link OrderedIntegerSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new OrderedIntegerSerialiser()).preservesObjectOrdering());
  }

  /**
   * Method under test: {@link OrderedIntegerSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    OrderedIntegerSerialiser orderedIntegerSerialiser = new OrderedIntegerSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderedIntegerSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link OrderedIntegerSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    OrderedIntegerSerialiser orderedIntegerSerialiser = new OrderedIntegerSerialiser();
    Class<Integer> clazz = Integer.class;

    // Act and Assert
    assertTrue(orderedIntegerSerialiser.canHandle(clazz));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedIntegerSerialiser#equals(Object)}
   *   <li>{@link OrderedIntegerSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderedIntegerSerialiser orderedIntegerSerialiser = new OrderedIntegerSerialiser();
    OrderedIntegerSerialiser orderedIntegerSerialiser2 = new OrderedIntegerSerialiser();

    // Act and Assert
    assertEquals(orderedIntegerSerialiser, orderedIntegerSerialiser2);
    int expectedHashCodeResult = orderedIntegerSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedIntegerSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedIntegerSerialiser#equals(Object)}
   *   <li>{@link OrderedIntegerSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderedIntegerSerialiser orderedIntegerSerialiser = new OrderedIntegerSerialiser();

    // Act and Assert
    assertEquals(orderedIntegerSerialiser, orderedIntegerSerialiser);
    int expectedHashCodeResult = orderedIntegerSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedIntegerSerialiser.hashCode());
  }

  /**
   * Method under test: {@link OrderedIntegerSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedIntegerSerialiser(), 1);
  }

  /**
   * Method under test: {@link OrderedIntegerSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedIntegerSerialiser(), null);
  }

  /**
   * Method under test: {@link OrderedIntegerSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedIntegerSerialiser(), "Different type to OrderedIntegerSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderedIntegerSerialiser}
   *   <li>{@link OrderedIntegerSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new OrderedIntegerSerialiser()).isConsistent());
  }
}
