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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class OrderedDoubleSerialiserDiffblueTest {
  /**
   * Method under test: {@link OrderedDoubleSerialiser#serialise(Double)}
   */
  @Test
  void testSerialise() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{'\b', '@', '$', 0, 0, 0, 0, 0, 0}, (new OrderedDoubleSerialiser()).serialise(10.0d));
    assertArrayEquals(new byte[]{'\b', -64, 31, -1, -1, -1, -1, -1, -1},
        (new OrderedDoubleSerialiser()).serialise(-0.5d));
  }

  /**
   * Method under test: {@link OrderedDoubleSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals(0.0d, (new OrderedDoubleSerialiser()).deserialise(new byte[]{0}).doubleValue());
    assertEquals(-0.0d, (new OrderedDoubleSerialiser()).deserialise(new byte[]{16}).doubleValue());
    assertEquals(-0.0d,
        (new OrderedDoubleSerialiser()).deserialise(new byte[]{16, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}).doubleValue());
  }

  /**
   * Method under test: {@link OrderedDoubleSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new OrderedDoubleSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link OrderedDoubleSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new OrderedDoubleSerialiser()).preservesObjectOrdering());
  }

  /**
   * Method under test: {@link OrderedDoubleSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    OrderedDoubleSerialiser orderedDoubleSerialiser = new OrderedDoubleSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderedDoubleSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link OrderedDoubleSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    OrderedDoubleSerialiser orderedDoubleSerialiser = new OrderedDoubleSerialiser();
    Class<Double> clazz = Double.class;

    // Act and Assert
    assertTrue(orderedDoubleSerialiser.canHandle(clazz));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedDoubleSerialiser#equals(Object)}
   *   <li>{@link OrderedDoubleSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderedDoubleSerialiser orderedDoubleSerialiser = new OrderedDoubleSerialiser();
    OrderedDoubleSerialiser orderedDoubleSerialiser2 = new OrderedDoubleSerialiser();

    // Act and Assert
    assertEquals(orderedDoubleSerialiser, orderedDoubleSerialiser2);
    int expectedHashCodeResult = orderedDoubleSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedDoubleSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedDoubleSerialiser#equals(Object)}
   *   <li>{@link OrderedDoubleSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderedDoubleSerialiser orderedDoubleSerialiser = new OrderedDoubleSerialiser();

    // Act and Assert
    assertEquals(orderedDoubleSerialiser, orderedDoubleSerialiser);
    int expectedHashCodeResult = orderedDoubleSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedDoubleSerialiser.hashCode());
  }

  /**
   * Method under test: {@link OrderedDoubleSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDoubleSerialiser(), 1);
  }

  /**
   * Method under test: {@link OrderedDoubleSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDoubleSerialiser(), null);
  }

  /**
   * Method under test: {@link OrderedDoubleSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDoubleSerialiser(), "Different type to OrderedDoubleSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderedDoubleSerialiser}
   *   <li>{@link OrderedDoubleSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new OrderedDoubleSerialiser()).isConsistent());
  }
}
