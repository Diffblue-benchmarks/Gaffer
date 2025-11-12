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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;

class MapSerialiserDiffblueTest {
  /**
   * Method under test: {@link MapSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(mapSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link MapSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    Class<Map> clazz = Map.class;

    // Act and Assert
    assertTrue(mapSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link MapSerialiser#serialise(Map)}
   */
  @Test
  void testSerialise() throws SerialisationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();

    // Act and Assert
    assertEquals(0, mapSerialiser.serialise(new HashMap<>()).length);
  }

  /**
   * Method under test: {@link MapSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise() throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue((new MapSerialiser()).deserialise(new byte[]{}).isEmpty());
  }

  /**
   * Method under test: {@link MapSerialiser#deserialise(byte[])}
   */
  @Test
  void testDeserialise2() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    Class<Map> mapClass = Map.class;
    mapSerialiser.setMapClass(mapClass);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> mapSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link MapSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new MapSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link MapSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new MapSerialiser()).preservesObjectOrdering());
  }

  /**
   * Method under test: {@link MapSerialiser#serialiseNull()}
   */
  @Test
  void testSerialiseNull() {
    // Arrange, Act and Assert
    assertEquals(0, (new MapSerialiser()).serialiseNull().length);
  }

  /**
   * Method under test: {@link MapSerialiser#getKeySerialiserClassString()}
   */
  @Test
  void testGetKeySerialiserClassString() {
    // Arrange, Act and Assert
    assertNull((new MapSerialiser()).getKeySerialiserClassString());
  }

  /**
   * Method under test: {@link MapSerialiser#getKeySerialiserClassString()}
   */
  @Test
  void testGetKeySerialiserClassString2() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act and Assert
    assertEquals("uk.gov.gchq.gaffer.serialisation.implementation.BooleanSerialiser",
        mapSerialiser.getKeySerialiserClassString());
  }

  /**
   * Method under test: {@link MapSerialiser#setKeySerialiserClassString(String)}
   */
  @Test
  void testSetKeySerialiserClassString() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act
    mapSerialiser.setKeySerialiserClassString("uk.gov.gchq.gaffer.serialisation.implementation.MapSerialiser");

    // Assert
    ToBytesSerialiser keySerialiser = mapSerialiser.getKeySerialiser();
    assertTrue(keySerialiser instanceof MapSerialiser);
    assertEquals("uk.gov.gchq.gaffer.serialisation.implementation.MapSerialiser",
        mapSerialiser.getKeySerialiserClassString());
    assertNull(((MapSerialiser) keySerialiser).getMapClass());
    assertNull(((MapSerialiser) keySerialiser).getKeySerialiserClassString());
    assertNull(((MapSerialiser) keySerialiser).getMapClassString());
    assertNull(((MapSerialiser) keySerialiser).getValueSerialiserClassString());
    assertNull(((MapSerialiser) keySerialiser).getKeySerialiser());
    assertNull(((MapSerialiser) keySerialiser).getValueSerialiser());
    assertFalse(keySerialiser.isConsistent());
  }

  /**
   * Method under test: {@link MapSerialiser#getValueSerialiserClassString()}
   */
  @Test
  void testGetValueSerialiserClassString() {
    // Arrange, Act and Assert
    assertNull((new MapSerialiser()).getValueSerialiserClassString());
  }

  /**
   * Method under test: {@link MapSerialiser#getValueSerialiserClassString()}
   */
  @Test
  void testGetValueSerialiserClassString2() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setValueSerialiser(new BooleanSerialiser());

    // Act and Assert
    assertEquals("uk.gov.gchq.gaffer.serialisation.implementation.BooleanSerialiser",
        mapSerialiser.getValueSerialiserClassString());
  }

  /**
   * Method under test:
   * {@link MapSerialiser#setValueSerialiserClassString(String)}
   */
  @Test
  void testSetValueSerialiserClassString()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act
    mapSerialiser.setValueSerialiserClassString("uk.gov.gchq.gaffer.serialisation.implementation.MapSerialiser");

    // Assert
    ToBytesSerialiser valueSerialiser = mapSerialiser.getValueSerialiser();
    assertTrue(valueSerialiser instanceof MapSerialiser);
    assertEquals("uk.gov.gchq.gaffer.serialisation.implementation.MapSerialiser",
        mapSerialiser.getValueSerialiserClassString());
    assertNull(((MapSerialiser) valueSerialiser).getMapClass());
    assertNull(((MapSerialiser) valueSerialiser).getKeySerialiserClassString());
    assertNull(((MapSerialiser) valueSerialiser).getMapClassString());
    assertNull(((MapSerialiser) valueSerialiser).getValueSerialiserClassString());
    assertNull(((MapSerialiser) valueSerialiser).getKeySerialiser());
    assertNull(((MapSerialiser) valueSerialiser).getValueSerialiser());
    assertFalse(valueSerialiser.isConsistent());
  }

  /**
   * Method under test: {@link MapSerialiser#getMapClassString()}
   */
  @Test
  void testGetMapClassString() {
    // Arrange, Act and Assert
    assertNull((new MapSerialiser()).getMapClassString());
  }

  /**
   * Method under test: {@link MapSerialiser#getMapClassString()}
   */
  @Test
  void testGetMapClassString2() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    Class<Map> mapClass = Map.class;
    mapSerialiser.setMapClass(mapClass);

    // Act and Assert
    assertEquals("java.util.Map", mapSerialiser.getMapClassString());
  }

  /**
   * Method under test: {@link MapSerialiser#setMapClassString(String)}
   */
  @Test
  void testSetMapClassString() throws ClassNotFoundException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();

    // Act
    mapSerialiser.setMapClassString("java.util.Map");

    // Assert
    assertEquals("java.util.Map", mapSerialiser.getMapClassString());
    Class<Map> expectedMapClass = Map.class;
    assertEquals(expectedMapClass, mapSerialiser.getMapClass());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MapSerialiser#equals(Object)}
   *   <li>{@link MapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    MapSerialiser mapSerialiser2 = new MapSerialiser();

    // Act and Assert
    assertEquals(mapSerialiser, mapSerialiser2);
    int expectedHashCodeResult = mapSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, mapSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MapSerialiser#equals(Object)}
   *   <li>{@link MapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();

    // Act and Assert
    assertEquals(mapSerialiser, mapSerialiser);
    int expectedHashCodeResult = mapSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, mapSerialiser.hashCode());
  }

  /**
   * Method under test: {@link MapSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act and Assert
    assertNotEquals(mapSerialiser, new MapSerialiser());
  }

  /**
   * Method under test: {@link MapSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(mock(ToBytesSerialiser.class));

    // Act and Assert
    assertNotEquals(mapSerialiser, new MapSerialiser());
  }

  /**
   * Method under test: {@link MapSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapSerialiser(), null);
  }

  /**
   * Method under test: {@link MapSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapSerialiser(), "Different type to MapSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MapSerialiser}
   *   <li>{@link MapSerialiser#setKeySerialiser(ToBytesSerialiser)}
   *   <li>{@link MapSerialiser#setMapClass(Class)}
   *   <li>{@link MapSerialiser#setValueSerialiser(ToBytesSerialiser)}
   *   <li>{@link MapSerialiser#getKeySerialiser()}
   *   <li>{@link MapSerialiser#getMapClass()}
   *   <li>{@link MapSerialiser#getValueSerialiser()}
   *   <li>{@link MapSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MapSerialiser actualMapSerialiser = new MapSerialiser();
    BooleanSerialiser keySerialiser = new BooleanSerialiser();
    actualMapSerialiser.setKeySerialiser(keySerialiser);
    Class<Map> mapClass = Map.class;
    actualMapSerialiser.setMapClass(mapClass);
    BooleanSerialiser valueSerialiser = new BooleanSerialiser();
    actualMapSerialiser.setValueSerialiser(valueSerialiser);
    ToBytesSerialiser actualKeySerialiser = actualMapSerialiser.getKeySerialiser();
    Class<? extends Map> actualMapClass = actualMapSerialiser.getMapClass();
    ToBytesSerialiser actualValueSerialiser = actualMapSerialiser.getValueSerialiser();

    // Assert that nothing has changed
    assertTrue(actualKeySerialiser instanceof BooleanSerialiser);
    assertFalse(actualMapSerialiser.isConsistent());
    Class<Map> expectedMapClass = Map.class;
    assertEquals(expectedMapClass, actualMapClass);
    assertSame(keySerialiser, actualKeySerialiser);
    assertSame(valueSerialiser, actualValueSerialiser);
    assertSame(mapClass, actualMapClass);
  }
}
