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
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class OrderedFloatSerialiserDiffblueTest {
  /**
   * Method under test: {@link OrderedFloatSerialiser#serialise(Float)}
   */
  @Test
  void testSerialise() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{4, 'A', ' ', 0, 0}, (new OrderedFloatSerialiser()).serialise(10.0f));
    assertArrayEquals(new byte[]{4, -64, -1, -1, -1}, (new OrderedFloatSerialiser()).serialise(-0.5f));
  }

  /**
   * Method under test: {@link OrderedFloatSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new OrderedFloatSerialiser()).deserialise(new byte[]{0}).floatValue());
    assertEquals(-0.0f, (new OrderedFloatSerialiser()).deserialise(new byte[]{'\b'}).floatValue());
  }

  /**
   * Method under test: {@link OrderedFloatSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise2() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    OrderedFloatSerialiser orderedFloatSerialiser = new OrderedFloatSerialiser();

    // Act and Assert
    assertEquals(-0.0f, orderedFloatSerialiser.deserialise("\bXAXAXAX".getBytes("UTF-8")).floatValue());
  }

  /**
   * Method under test: {@link OrderedFloatSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new OrderedFloatSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link OrderedFloatSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new OrderedFloatSerialiser()).preservesObjectOrdering());
  }

  /**
   * Method under test: {@link OrderedFloatSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    OrderedFloatSerialiser orderedFloatSerialiser = new OrderedFloatSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderedFloatSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link OrderedFloatSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    OrderedFloatSerialiser orderedFloatSerialiser = new OrderedFloatSerialiser();
    Class<Float> clazz = Float.class;

    // Act and Assert
    assertTrue(orderedFloatSerialiser.canHandle(clazz));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedFloatSerialiser#equals(Object)}
   *   <li>{@link OrderedFloatSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderedFloatSerialiser orderedFloatSerialiser = new OrderedFloatSerialiser();
    OrderedFloatSerialiser orderedFloatSerialiser2 = new OrderedFloatSerialiser();

    // Act and Assert
    assertEquals(orderedFloatSerialiser, orderedFloatSerialiser2);
    int expectedHashCodeResult = orderedFloatSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedFloatSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedFloatSerialiser#equals(Object)}
   *   <li>{@link OrderedFloatSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderedFloatSerialiser orderedFloatSerialiser = new OrderedFloatSerialiser();

    // Act and Assert
    assertEquals(orderedFloatSerialiser, orderedFloatSerialiser);
    int expectedHashCodeResult = orderedFloatSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedFloatSerialiser.hashCode());
  }

  /**
   * Method under test: {@link OrderedFloatSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedFloatSerialiser(), 1);
  }

  /**
   * Method under test: {@link OrderedFloatSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedFloatSerialiser(), null);
  }

  /**
   * Method under test: {@link OrderedFloatSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedFloatSerialiser(), "Different type to OrderedFloatSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderedFloatSerialiser}
   *   <li>{@link OrderedFloatSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new OrderedFloatSerialiser()).isConsistent());
  }
}
