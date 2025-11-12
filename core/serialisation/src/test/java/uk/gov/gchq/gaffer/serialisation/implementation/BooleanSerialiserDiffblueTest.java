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

package uk.gov.gchq.gaffer.serialisation.implementation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class BooleanSerialiserDiffblueTest {
  /**
   * Method under test: {@link BooleanSerialiser#serialise(Boolean)}
   */
  @Test
  void testSerialise() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{1}, (new BooleanSerialiser()).serialise(true));
    assertArrayEquals(new byte[]{0}, (new BooleanSerialiser()).serialise(false));
  }

  /**
   * Method under test: {@link BooleanSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();

    // Act and Assert
    assertFalse(booleanSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link BooleanSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise2() throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue((new BooleanSerialiser()).deserialise(new byte[]{1}));
  }

  /**
   * Method under test: {@link BooleanSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise3() throws SerialisationException {
    // Arrange, Act and Assert
    assertFalse((new BooleanSerialiser()).deserialise(new byte[]{'A'}));
  }

  /**
   * Method under test: {@link BooleanSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  void testDeserialise4() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();

    // Act and Assert
    assertFalse(booleanSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Method under test: {@link BooleanSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  void testDeserialise5() throws SerialisationException {
    // Arrange, Act and Assert
    assertFalse((new BooleanSerialiser()).deserialise(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 1));
  }

  /**
   * Method under test: {@link BooleanSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  void testDeserialise6() throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue((new BooleanSerialiser()).deserialise(new byte[]{'A', 'X', 1, 'X', 'A', 'X', 'A', 'X'}, 2, 1));
  }

  /**
   * Method under test: {@link BooleanSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertFalse((new BooleanSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link BooleanSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(booleanSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link BooleanSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();
    Class<Boolean> clazz = Boolean.class;

    // Act and Assert
    assertTrue(booleanSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link BooleanSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new BooleanSerialiser()).preservesObjectOrdering());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BooleanSerialiser#equals(Object)}
   *   <li>{@link BooleanSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();
    BooleanSerialiser booleanSerialiser2 = new BooleanSerialiser();

    // Act and Assert
    assertEquals(booleanSerialiser, booleanSerialiser2);
    int expectedHashCodeResult = booleanSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, booleanSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BooleanSerialiser#equals(Object)}
   *   <li>{@link BooleanSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BooleanSerialiser booleanSerialiser = new BooleanSerialiser();

    // Act and Assert
    assertEquals(booleanSerialiser, booleanSerialiser);
    int expectedHashCodeResult = booleanSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, booleanSerialiser.hashCode());
  }

  /**
   * Method under test: {@link BooleanSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanSerialiser(), 1);
  }

  /**
   * Method under test: {@link BooleanSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanSerialiser(), null);
  }

  /**
   * Method under test: {@link BooleanSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanSerialiser(), "Different type to BooleanSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BooleanSerialiser}
   *   <li>{@link BooleanSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new BooleanSerialiser()).isConsistent());
  }
}
