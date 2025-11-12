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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class JavaSerialiserDiffblueTest {
  /**
   * Method under test: {@link JavaSerialiser#serialise(Object)}
   */
  @Test
  void testSerialise() throws SerialisationException {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{-84, -19, 0, 5, 't', 0, 6, 'O', 'b', 'j', 'e', 'c', 't'},
        (new JavaSerialiser()).serialise("Object"));
  }

  /**
   * Method under test: {@link JavaSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    JavaSerialiser javaSerialiser = new JavaSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class, () -> javaSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link JavaSerialiser#deserialise(byte[], int, int)}
   */
  @Test
  void testDeserialise2() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    JavaSerialiser javaSerialiser = new JavaSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class, () -> javaSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Method under test: {@link JavaSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new JavaSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link JavaSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    JavaSerialiser javaSerialiser = new JavaSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(javaSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link JavaSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    JavaSerialiser javaSerialiser = new JavaSerialiser();
    Class<Serializable> clazz = Serializable.class;

    // Act and Assert
    assertTrue(javaSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link JavaSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new JavaSerialiser()).preservesObjectOrdering());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JavaSerialiser#equals(Object)}
   *   <li>{@link JavaSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JavaSerialiser javaSerialiser = new JavaSerialiser();
    JavaSerialiser javaSerialiser2 = new JavaSerialiser();

    // Act and Assert
    assertEquals(javaSerialiser, javaSerialiser2);
    int expectedHashCodeResult = javaSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, javaSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JavaSerialiser#equals(Object)}
   *   <li>{@link JavaSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JavaSerialiser javaSerialiser = new JavaSerialiser();

    // Act and Assert
    assertEquals(javaSerialiser, javaSerialiser);
    int expectedHashCodeResult = javaSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, javaSerialiser.hashCode());
  }

  /**
   * Method under test: {@link JavaSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JavaSerialiser(), 1);
  }

  /**
   * Method under test: {@link JavaSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JavaSerialiser(), null);
  }

  /**
   * Method under test: {@link JavaSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JavaSerialiser(), "Different type to JavaSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link JavaSerialiser}
   *   <li>{@link JavaSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new JavaSerialiser()).isConsistent());
  }
}
