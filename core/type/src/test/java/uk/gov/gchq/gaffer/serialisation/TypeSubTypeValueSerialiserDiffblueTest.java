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
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class TypeSubTypeValueSerialiserDiffblueTest {
  /**
   * Method under test: {@link TypeSubTypeValueSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(typeSubTypeValueSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link TypeSubTypeValueSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();
    Class<TypeSubTypeValue> clazz = TypeSubTypeValue.class;

    // Act and Assert
    assertTrue(typeSubTypeValueSerialiser.canHandle(clazz));
  }

  /**
   * Method under test:
   * {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)}
   */
  @Test
  void testSerialise() throws SerialisationException {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();

    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("Type", "Sub Type", "42");
    typeSubTypeValue.setType(null);
    typeSubTypeValue.setSubType(null);
    typeSubTypeValue.setValue(null);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> typeSubTypeValueSerialiser.serialise(typeSubTypeValue));
  }

  /**
   * Method under test:
   * {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)}
   */
  @Test
  void testSerialise2() throws SerialisationException {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();

    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("Type", "Sub Type", "42");
    typeSubTypeValue.setType(null);
    typeSubTypeValue.setSubType(null);
    typeSubTypeValue.setValue("");

    // Act and Assert
    assertThrows(SerialisationException.class, () -> typeSubTypeValueSerialiser.serialise(typeSubTypeValue));
  }

  /**
   * Method under test:
   * {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)}
   */
  @Test
  void testSerialise3() throws SerialisationException {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();

    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("Type", "Sub Type", "42");
    typeSubTypeValue.setType(null);
    typeSubTypeValue.setSubType("");
    typeSubTypeValue.setValue(null);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> typeSubTypeValueSerialiser.serialise(typeSubTypeValue));
  }

  /**
   * Method under test:
   * {@link TypeSubTypeValueSerialiser#serialise(TypeSubTypeValue)}
   */
  @Test
  void testSerialise4() throws SerialisationException {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();

    TypeSubTypeValue typeSubTypeValue = new TypeSubTypeValue("Type", "Sub Type", "42");
    typeSubTypeValue.setType("");
    typeSubTypeValue.setSubType(null);
    typeSubTypeValue.setValue(null);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> typeSubTypeValueSerialiser.serialise(typeSubTypeValue));
  }

  /**
   * Method under test:
   * {@link TypeSubTypeValueSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new TypeSubTypeValueSerialiser()).preservesObjectOrdering());
  }

  /**
   * Method under test: {@link TypeSubTypeValueSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange and Act
    TypeSubTypeValue actualDeserialiseEmptyResult = (new TypeSubTypeValueSerialiser()).deserialiseEmpty();

    // Assert
    assertNull(actualDeserialiseEmptyResult.getSubType());
    assertNull(actualDeserialiseEmptyResult.getType());
    assertNull(actualDeserialiseEmptyResult.getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypeSubTypeValueSerialiser#equals(Object)}
   *   <li>{@link TypeSubTypeValueSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser2 = new TypeSubTypeValueSerialiser();

    // Act and Assert
    assertEquals(typeSubTypeValueSerialiser, typeSubTypeValueSerialiser2);
    int expectedHashCodeResult = typeSubTypeValueSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, typeSubTypeValueSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TypeSubTypeValueSerialiser#equals(Object)}
   *   <li>{@link TypeSubTypeValueSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TypeSubTypeValueSerialiser typeSubTypeValueSerialiser = new TypeSubTypeValueSerialiser();

    // Act and Assert
    assertEquals(typeSubTypeValueSerialiser, typeSubTypeValueSerialiser);
    int expectedHashCodeResult = typeSubTypeValueSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, typeSubTypeValueSerialiser.hashCode());
  }

  /**
   * Method under test: {@link TypeSubTypeValueSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeSubTypeValueSerialiser(), 1);
  }

  /**
   * Method under test: {@link TypeSubTypeValueSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeSubTypeValueSerialiser(), null);
  }

  /**
   * Method under test: {@link TypeSubTypeValueSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TypeSubTypeValueSerialiser(), "Different type to TypeSubTypeValueSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TypeSubTypeValueSerialiser}
   *   <li>{@link TypeSubTypeValueSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new TypeSubTypeValueSerialiser()).isConsistent());
  }
}
