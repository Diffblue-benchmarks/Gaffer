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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class StringSerialiserDiffblueTest {
  /**
   * Method under test: {@link StringSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(stringSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link StringSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();
    Class<String> clazz = String.class;

    // Act and Assert
    assertTrue(stringSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link StringSerialiser#serialiseToString(String)}
   */
  @Test
  void testSerialiseToString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("Object", (new StringSerialiser()).serialiseToString("Object"));
  }

  /**
   * Method under test: {@link StringSerialiser#deserialiseString(String)}
   */
  @Test
  void testDeserialiseString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("42", (new StringSerialiser()).deserialiseString("42"));
  }

  /**
   * Method under test: {@link StringSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertEquals("", (new StringSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link StringSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new StringSerialiser()).preservesObjectOrdering());
  }

  /**
   * Method under test: {@link StringSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringSerialiser(), 1);
  }

  /**
   * Method under test: {@link StringSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringSerialiser(), null);
  }

  /**
   * Method under test: {@link StringSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new StringSerialiser(), "Different type to StringSerialiser");
  }

  /**
   * Method under test: {@link StringSerialiser#isConsistent()}
   */
  @Test
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertTrue((new StringSerialiser()).isConsistent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringSerialiser#equals(Object)}
   *   <li>{@link StringSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();
    StringSerialiser stringSerialiser2 = new StringSerialiser();

    // Act and Assert
    assertEquals(stringSerialiser, stringSerialiser2);
    int expectedHashCodeResult = stringSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, stringSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringSerialiser#equals(Object)}
   *   <li>{@link StringSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StringSerialiser stringSerialiser = new StringSerialiser();

    // Act and Assert
    assertEquals(stringSerialiser, stringSerialiser);
    int expectedHashCodeResult = stringSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, stringSerialiser.hashCode());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link StringSerialiser}
   */
  @Test
  void testNewStringSerialiser() {
    // Arrange and Act
    StringSerialiser actualStringSerialiser = new StringSerialiser();

    // Assert
    assertEquals("UTF-8", actualStringSerialiser.getCharset());
    assertTrue(actualStringSerialiser.isConsistent());
  }
}
