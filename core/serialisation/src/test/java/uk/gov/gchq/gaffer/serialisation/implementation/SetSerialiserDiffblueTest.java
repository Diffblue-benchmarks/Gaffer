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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;

class SetSerialiserDiffblueTest {
  /**
   * Method under test: {@link SetSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(setSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link SetSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    Class<Set> clazz = Set.class;

    // Act and Assert
    assertTrue(setSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link SetSerialiser#serialise(Set)}
   */
  @Test
  void testSerialise() throws SerialisationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();

    // Act and Assert
    assertEquals(0, setSerialiser.serialise(new HashSet<>()).length);
  }

  /**
   * Method under test: {@link SetSerialiser#serialise(Set)}
   */
  @Test
  void testSerialise2() throws SerialisationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser(new JavaSerialiser());

    HashSet<Object> object = new HashSet<>();
    object.add("42");

    // Act and Assert
    assertArrayEquals(new byte[]{'\t', -84, -19, 0, 5, 't', 0, 2, '4', '2'}, setSerialiser.serialise(object));
  }

  /**
   * Method under test: {@link SetSerialiser#serialise(Set)}
   */
  @Test
  void testSerialise3() throws SerialisationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser(new MapSerialiser());

    HashSet<Object> object = new HashSet<>();
    object.add(new HashMap<>());

    // Act and Assert
    assertArrayEquals(new byte[]{0}, setSerialiser.serialise(object));
  }

  /**
   * Method under test: {@link SetSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser(new BooleanSerialiser());

    // Act and Assert
    assertEquals(1, setSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")).size());
  }

  /**
   * Method under test: {@link SetSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise2() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    Class<Set> setClass = Set.class;
    setSerialiser.setSetClass(setClass);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> setSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link SetSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue((new SetSerialiser()).deserialiseEmpty().isEmpty());
  }

  /**
   * Method under test: {@link SetSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty2() throws SerialisationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    Class<Set> setClass = Set.class;
    setSerialiser.setSetClass(setClass);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> setSerialiser.deserialiseEmpty());
  }

  /**
   * Method under test: {@link SetSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new SetSerialiser()).preservesObjectOrdering());
  }

  /**
   * Method under test: {@link SetSerialiser#serialiseNull()}
   */
  @Test
  void testSerialiseNull() {
    // Arrange, Act and Assert
    assertEquals(0, (new SetSerialiser()).serialiseNull().length);
  }

  /**
   * Method under test: {@link SetSerialiser#getObjectSerialiserClassString()}
   */
  @Test
  void testGetObjectSerialiserClassString() {
    // Arrange, Act and Assert
    assertNull((new SetSerialiser()).getObjectSerialiserClassString());
    assertEquals("uk.gov.gchq.gaffer.serialisation.implementation.BooleanSerialiser",
        (new SetSerialiser(new BooleanSerialiser())).getObjectSerialiserClassString());
  }

  /**
   * Method under test:
   * {@link SetSerialiser#setObjectSerialiserClassString(String)}
   */
  @Test
  void testSetObjectSerialiserClassString()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser(new BooleanSerialiser());

    // Act
    setSerialiser.setObjectSerialiserClassString("uk.gov.gchq.gaffer.serialisation.implementation.SetSerialiser");

    // Assert
    ToBytesSerialiser objectSerialiser = setSerialiser.getObjectSerialiser();
    assertTrue(objectSerialiser instanceof SetSerialiser);
    assertEquals("uk.gov.gchq.gaffer.serialisation.implementation.SetSerialiser",
        setSerialiser.getObjectSerialiserClassString());
    assertNull(((SetSerialiser) objectSerialiser).getSetClass());
    assertNull(((SetSerialiser) objectSerialiser).getObjectSerialiserClassString());
    assertNull(((SetSerialiser) objectSerialiser).getSetClassString());
    assertNull(((SetSerialiser) objectSerialiser).getObjectSerialiser());
    assertFalse(objectSerialiser.isConsistent());
  }

  /**
   * Method under test: {@link SetSerialiser#getSetClassString()}
   */
  @Test
  void testGetSetClassString() {
    // Arrange, Act and Assert
    assertNull((new SetSerialiser()).getSetClassString());
  }

  /**
   * Method under test: {@link SetSerialiser#getSetClassString()}
   */
  @Test
  void testGetSetClassString2() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    Class<Set> setClass = Set.class;
    setSerialiser.setSetClass(setClass);

    // Act and Assert
    assertEquals("java.util.Set", setSerialiser.getSetClassString());
  }

  /**
   * Method under test: {@link SetSerialiser#setSetClassString(String)}
   */
  @Test
  void testSetSetClassString() throws ClassNotFoundException {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();

    // Act
    setSerialiser.setSetClassString("java.util.Set");

    // Assert
    assertEquals("java.util.Set", setSerialiser.getSetClassString());
    Class<Set> expectedSetClass = Set.class;
    assertEquals(expectedSetClass, setSerialiser.getSetClass());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SetSerialiser#equals(Object)}
   *   <li>{@link SetSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    SetSerialiser setSerialiser2 = new SetSerialiser();

    // Act and Assert
    assertEquals(setSerialiser, setSerialiser2);
    int expectedHashCodeResult = setSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, setSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SetSerialiser#equals(Object)}
   *   <li>{@link SetSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();

    // Act and Assert
    assertEquals(setSerialiser, setSerialiser);
    int expectedHashCodeResult = setSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, setSerialiser.hashCode());
  }

  /**
   * Method under test: {@link SetSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    setSerialiser.setObjectSerialiser(new BooleanSerialiser());

    // Act and Assert
    assertNotEquals(setSerialiser, new SetSerialiser());
  }

  /**
   * Method under test: {@link SetSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SetSerialiser setSerialiser = new SetSerialiser();
    setSerialiser.setObjectSerialiser(mock(ToBytesSerialiser.class));

    // Act and Assert
    assertNotEquals(setSerialiser, new SetSerialiser());
  }

  /**
   * Method under test: {@link SetSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SetSerialiser(), null);
  }

  /**
   * Method under test: {@link SetSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SetSerialiser(), "Different type to SetSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SetSerialiser#SetSerialiser()}
   *   <li>{@link SetSerialiser#setObjectSerialiser(ToBytesSerialiser)}
   *   <li>{@link SetSerialiser#setSetClass(Class)}
   *   <li>{@link SetSerialiser#getObjectSerialiser()}
   *   <li>{@link SetSerialiser#getSetClass()}
   *   <li>{@link SetSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SetSerialiser actualSetSerialiser = new SetSerialiser();
    BooleanSerialiser objectSerialiser = new BooleanSerialiser();
    actualSetSerialiser.setObjectSerialiser(objectSerialiser);
    Class<Set> setClass = Set.class;
    actualSetSerialiser.setSetClass(setClass);
    ToBytesSerialiser actualObjectSerialiser = actualSetSerialiser.getObjectSerialiser();
    Class<? extends Set> actualSetClass = actualSetSerialiser.getSetClass();

    // Assert that nothing has changed
    assertTrue(actualObjectSerialiser instanceof BooleanSerialiser);
    assertFalse(actualSetSerialiser.isConsistent());
    Class<Set> expectedSetClass = Set.class;
    assertEquals(expectedSetClass, actualSetClass);
    assertSame(objectSerialiser, actualObjectSerialiser);
    assertSame(setClass, actualSetClass);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SetSerialiser#SetSerialiser(ToBytesSerialiser)}
   *   <li>{@link SetSerialiser#setObjectSerialiser(ToBytesSerialiser)}
   *   <li>{@link SetSerialiser#setSetClass(Class)}
   *   <li>{@link SetSerialiser#getObjectSerialiser()}
   *   <li>{@link SetSerialiser#getSetClass()}
   *   <li>{@link SetSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    SetSerialiser actualSetSerialiser = new SetSerialiser(new BooleanSerialiser());
    BooleanSerialiser objectSerialiser = new BooleanSerialiser();
    actualSetSerialiser.setObjectSerialiser(objectSerialiser);
    Class<Set> setClass = Set.class;
    actualSetSerialiser.setSetClass(setClass);
    ToBytesSerialiser actualObjectSerialiser = actualSetSerialiser.getObjectSerialiser();
    Class<? extends Set> actualSetClass = actualSetSerialiser.getSetClass();

    // Assert that nothing has changed
    assertFalse(actualSetSerialiser.isConsistent());
    Class<Set> expectedSetClass = Set.class;
    assertEquals(expectedSetClass, actualSetClass);
    assertSame(objectSerialiser, actualObjectSerialiser);
    assertSame(setClass, actualSetClass);
  }
}
