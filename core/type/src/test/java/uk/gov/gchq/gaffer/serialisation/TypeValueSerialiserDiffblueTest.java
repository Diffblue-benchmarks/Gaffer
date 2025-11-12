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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.types.TypeValue;

class TypeValueSerialiserDiffblueTest {
  /**
   * Method under test: {@link TypeValueSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(typeValueSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link TypeValueSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();
    Class<TypeValue> clazz = TypeValue.class;

    // Act and Assert
    assertTrue(typeValueSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link TypeValueSerialiser#serialise(TypeValue)}
   */
  @Test
  void testSerialise() throws SerialisationException {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();

    TypeValue typeValue = new TypeValue("Type", "42");
    typeValue.setType(null);
    typeValue.setValue(null);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> typeValueSerialiser.serialise(typeValue));
  }

  /**
   * Method under test: {@link TypeValueSerialiser#serialise(TypeValue)}
   */
  @Test
  void testSerialise2() throws SerialisationException {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();

    TypeValue typeValue = new TypeValue("Type", "42");
    typeValue.setType(null);
    typeValue.setValue("");

    // Act and Assert
    assertThrows(SerialisationException.class, () -> typeValueSerialiser.serialise(typeValue));
  }

  /**
   * Method under test: {@link TypeValueSerialiser#serialise(TypeValue)}
   */
  @Test
  void testSerialise3() throws SerialisationException {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();

    TypeValue typeValue = new TypeValue("Type", "42");
    typeValue.setType("");
    typeValue.setValue(null);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> typeValueSerialiser.serialise(typeValue));
  }

  /**
   * Method under test: {@link TypeValueSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new TypeValueSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link TypeValueSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new TypeValueSerialiser()).preservesObjectOrdering());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypeValueSerialiser#equals(Object)}
   *   <li>{@link TypeValueSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();
    TypeValueSerialiser typeValueSerialiser2 = new TypeValueSerialiser();

    // Act and Assert
    assertEquals(typeValueSerialiser, typeValueSerialiser2);
    int expectedHashCodeResult = typeValueSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, typeValueSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypeValueSerialiser#equals(Object)}
   *   <li>{@link TypeValueSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TypeValueSerialiser typeValueSerialiser = new TypeValueSerialiser();

    // Act and Assert
    assertEquals(typeValueSerialiser, typeValueSerialiser);
    int expectedHashCodeResult = typeValueSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, typeValueSerialiser.hashCode());
  }

  /**
   * Method under test: {@link TypeValueSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeValueSerialiser(), 1);
  }

  /**
   * Method under test: {@link TypeValueSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeValueSerialiser(), null);
  }

  /**
   * Method under test: {@link TypeValueSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeValueSerialiser(), "Different type to TypeValueSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TypeValueSerialiser}
   *   <li>{@link TypeValueSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new TypeValueSerialiser()).isConsistent());
  }
}
