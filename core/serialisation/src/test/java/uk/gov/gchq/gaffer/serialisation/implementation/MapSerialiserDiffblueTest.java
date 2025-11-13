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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;

class MapSerialiserDiffblueTest {
  /**
   * Test {@link MapSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(mapSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link MapSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Map}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.util.Map'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaUtilMap_thenReturnTrue() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    Class<Map> clazz = Map.class;

    // Act and Assert
    assertTrue(mapSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link MapSerialiser#serialise(Map)} with {@code Map}.
   * <ul>
   *   <li>Given {@link MapSerialiser} (default constructor).</li>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#serialise(Map)}
   */
  @Test
  @DisplayName("Test serialise(Map) with 'Map'; given MapSerialiser (default constructor); when HashMap(); then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] MapSerialiser.serialise(Map)"})
  void testSerialiseWithMap_givenMapSerialiser_whenHashMap_thenReturnEmptyArrayOfByte() throws SerialisationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();

    // Act and Assert
    assertArrayEquals(new byte[]{}, mapSerialiser.serialise(new HashMap<>()));
  }

  /**
   * Test {@link MapSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>Given {@code Map}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; given 'java.util.Map'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map MapSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_givenJavaUtilMap_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    Class<Map> mapClass = Map.class;
    mapSerialiser.setMapClass(mapClass);

    // Act and Assert
    assertThrows(SerialisationException.class, () -> mapSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MapSerialiser#deserialise(byte[])} with {@code bytes}.
   * <ul>
   *   <li>Given {@link MapSerialiser} (default constructor).</li>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'; given MapSerialiser (default constructor); when empty array of byte; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map MapSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_givenMapSerialiser_whenEmptyArrayOfByte_thenReturnEmpty()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue((new MapSerialiser()).deserialise(new byte[]{}).isEmpty());
  }

  /**
   * Test {@link MapSerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link MapSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map MapSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new MapSerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link MapSerialiser#preservesObjectOrdering()}.
   * <p>
   * Method under test: {@link MapSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse((new MapSerialiser()).preservesObjectOrdering());
  }

  /**
   * Test {@link MapSerialiser#serialiseNull()}.
   * <p>
   * Method under test: {@link MapSerialiser#serialiseNull()}
   */
  @Test
  @DisplayName("Test serialiseNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] MapSerialiser.serialiseNull()"})
  void testSerialiseNull() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{}, (new MapSerialiser()).serialiseNull());
  }

  /**
   * Test {@link MapSerialiser#getKeySerialiserClassString()}.
   * <p>
   * Method under test: {@link MapSerialiser#getKeySerialiserClassString()}
   */
  @Test
  @DisplayName("Test getKeySerialiserClassString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MapSerialiser.getKeySerialiserClassString()"})
  void testGetKeySerialiserClassString() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act and Assert
    assertEquals("uk.gov.gchq.gaffer.serialisation.implementation.BooleanSerialiser",
        mapSerialiser.getKeySerialiserClassString());
  }

  /**
   * Test {@link MapSerialiser#getKeySerialiserClassString()}.
   * <ul>
   *   <li>Given {@link MapSerialiser} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#getKeySerialiserClassString()}
   */
  @Test
  @DisplayName("Test getKeySerialiserClassString(); given MapSerialiser (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MapSerialiser.getKeySerialiserClassString()"})
  void testGetKeySerialiserClassString_givenMapSerialiser_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new MapSerialiser()).getKeySerialiserClassString());
  }

  /**
   * Test {@link MapSerialiser#setKeySerialiserClassString(String)}.
   * <ul>
   *   <li>Then {@link MapSerialiser} (default constructor) KeySerialiser {@link MapSerialiser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#setKeySerialiserClassString(String)}
   */
  @Test
  @DisplayName("Test setKeySerialiserClassString(String); then MapSerialiser (default constructor) KeySerialiser MapSerialiser")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapSerialiser.setKeySerialiserClassString(String)"})
  void testSetKeySerialiserClassString_thenMapSerialiserKeySerialiserMapSerialiser()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
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
   * Test {@link MapSerialiser#getValueSerialiserClassString()}.
   * <p>
   * Method under test: {@link MapSerialiser#getValueSerialiserClassString()}
   */
  @Test
  @DisplayName("Test getValueSerialiserClassString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MapSerialiser.getValueSerialiserClassString()"})
  void testGetValueSerialiserClassString() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setValueSerialiser(new BooleanSerialiser());

    // Act and Assert
    assertEquals("uk.gov.gchq.gaffer.serialisation.implementation.BooleanSerialiser",
        mapSerialiser.getValueSerialiserClassString());
  }

  /**
   * Test {@link MapSerialiser#getValueSerialiserClassString()}.
   * <ul>
   *   <li>Given {@link MapSerialiser} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#getValueSerialiserClassString()}
   */
  @Test
  @DisplayName("Test getValueSerialiserClassString(); given MapSerialiser (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MapSerialiser.getValueSerialiserClassString()"})
  void testGetValueSerialiserClassString_givenMapSerialiser_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new MapSerialiser()).getValueSerialiserClassString());
  }

  /**
   * Test {@link MapSerialiser#setValueSerialiserClassString(String)}.
   * <ul>
   *   <li>Then {@link MapSerialiser} (default constructor) ValueSerialiser {@link MapSerialiser}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#setValueSerialiserClassString(String)}
   */
  @Test
  @DisplayName("Test setValueSerialiserClassString(String); then MapSerialiser (default constructor) ValueSerialiser MapSerialiser")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapSerialiser.setValueSerialiserClassString(String)"})
  void testSetValueSerialiserClassString_thenMapSerialiserValueSerialiserMapSerialiser()
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
   * Test {@link MapSerialiser#getMapClassString()}.
   * <ul>
   *   <li>Given {@code Map}.</li>
   *   <li>Then return {@code Map}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#getMapClassString()}
   */
  @Test
  @DisplayName("Test getMapClassString(); given 'java.util.Map'; then return 'java.util.Map'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MapSerialiser.getMapClassString()"})
  void testGetMapClassString_givenJavaUtilMap_thenReturnJavaUtilMap() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    Class<Map> mapClass = Map.class;
    mapSerialiser.setMapClass(mapClass);

    // Act and Assert
    assertEquals("java.util.Map", mapSerialiser.getMapClassString());
  }

  /**
   * Test {@link MapSerialiser#getMapClassString()}.
   * <ul>
   *   <li>Given {@link MapSerialiser} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#getMapClassString()}
   */
  @Test
  @DisplayName("Test getMapClassString(); given MapSerialiser (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MapSerialiser.getMapClassString()"})
  void testGetMapClassString_givenMapSerialiser_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new MapSerialiser()).getMapClassString());
  }

  /**
   * Test {@link MapSerialiser#setMapClassString(String)}.
   * <ul>
   *   <li>Then {@link MapSerialiser} (default constructor) MapClassString is {@code Map}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#setMapClassString(String)}
   */
  @Test
  @DisplayName("Test setMapClassString(String); then MapSerialiser (default constructor) MapClassString is 'java.util.Map'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapSerialiser.setMapClassString(String)"})
  void testSetMapClassString_thenMapSerialiserMapClassStringIsJavaUtilMap() throws ClassNotFoundException {
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
   * Test {@link MapSerialiser#equals(Object)}, and {@link MapSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapSerialiser#equals(Object)}
   *   <li>{@link MapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapSerialiser.equals(Object)", "int MapSerialiser.hashCode()"})
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
   * Test {@link MapSerialiser#equals(Object)}, and {@link MapSerialiser#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MapSerialiser#equals(Object)}
   *   <li>{@link MapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapSerialiser.equals(Object)", "int MapSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();

    // Act and Assert
    assertEquals(mapSerialiser, mapSerialiser);
    int expectedHashCodeResult = mapSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, mapSerialiser.hashCode());
  }

  /**
   * Test {@link MapSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapSerialiser.equals(Object)", "int MapSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act and Assert
    assertNotEquals(mapSerialiser, new MapSerialiser());
  }

  /**
   * Test {@link MapSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapSerialiser.equals(Object)", "int MapSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapSerialiser(), null);
  }

  /**
   * Test {@link MapSerialiser#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MapSerialiser.equals(Object)", "int MapSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapSerialiser(), "Different type to MapSerialiser");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapSerialiser.<init>()", "ToBytesSerialiser MapSerialiser.getKeySerialiser()",
      "Class MapSerialiser.getMapClass()", "ToBytesSerialiser MapSerialiser.getValueSerialiser()",
      "boolean MapSerialiser.isConsistent()", "void MapSerialiser.setKeySerialiser(ToBytesSerialiser)",
      "void MapSerialiser.setMapClass(Class)", "void MapSerialiser.setValueSerialiser(ToBytesSerialiser)"})
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

    // Assert
    assertTrue(actualKeySerialiser instanceof BooleanSerialiser);
    assertFalse(actualMapSerialiser.isConsistent());
    Class<Map> expectedMapClass = Map.class;
    assertEquals(expectedMapClass, actualMapClass);
    assertSame(keySerialiser, actualKeySerialiser);
    assertSame(valueSerialiser, actualValueSerialiser);
    assertSame(mapClass, actualMapClass);
  }
}
