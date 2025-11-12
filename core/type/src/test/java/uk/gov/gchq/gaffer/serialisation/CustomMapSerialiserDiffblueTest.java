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
import uk.gov.gchq.gaffer.types.CustomMap;

class CustomMapSerialiserDiffblueTest {
  /**
   * Method under test: {@link CustomMapSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    CustomMapSerialiser customMapSerialiser = new CustomMapSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(customMapSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link CustomMapSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    CustomMapSerialiser customMapSerialiser = new CustomMapSerialiser();
    Class<CustomMap> clazz = CustomMap.class;

    // Act and Assert
    assertTrue(customMapSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link CustomMapSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    CustomMapSerialiser customMapSerialiser = new CustomMapSerialiser();

    // Act and Assert
    assertThrows(SerialisationException.class, () -> customMapSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link CustomMapSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new CustomMapSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link CustomMapSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new CustomMapSerialiser()).preservesObjectOrdering());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomMapSerialiser#equals(Object)}
   *   <li>{@link CustomMapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomMapSerialiser customMapSerialiser = new CustomMapSerialiser();
    CustomMapSerialiser customMapSerialiser2 = new CustomMapSerialiser();

    // Act and Assert
    assertEquals(customMapSerialiser, customMapSerialiser2);
    int expectedHashCodeResult = customMapSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, customMapSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomMapSerialiser#equals(Object)}
   *   <li>{@link CustomMapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomMapSerialiser customMapSerialiser = new CustomMapSerialiser();

    // Act and Assert
    assertEquals(customMapSerialiser, customMapSerialiser);
    int expectedHashCodeResult = customMapSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, customMapSerialiser.hashCode());
  }

  /**
   * Method under test: {@link CustomMapSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CustomMapSerialiser(), 1);
  }

  /**
   * Method under test: {@link CustomMapSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CustomMapSerialiser(), null);
  }

  /**
   * Method under test: {@link CustomMapSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CustomMapSerialiser(), "Different type to CustomMapSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomMapSerialiser}
   *   <li>{@link CustomMapSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse((new CustomMapSerialiser()).isConsistent());
  }
}
