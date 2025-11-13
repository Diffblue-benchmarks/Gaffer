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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;

class MapSerialiserDiffblueTest {
  /**
   * Test {@link MapSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@code Map}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.util.Map'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link MapSerialiser} (default constructor).
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#serialise(Map)}
   */
  @Test
  @DisplayName(
      "Test serialise(Map) with 'Map'; given MapSerialiser (default constructor); when HashMap(); then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MapSerialiser.serialise(Map)"})
  void testSerialiseWithMap_givenMapSerialiser_whenHashMap_thenReturnEmptyArrayOfByte()
      throws SerialisationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();

    // Act and Assert
    assertArrayEquals(new byte[] {}, mapSerialiser.serialise(new HashMap<>()));
  }

  /**
   * Test {@link MapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link MapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes() throws SerialisationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setValueSerialiser(new SetSerialiser(new BooleanSerialiser()));
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act
    Map<?, ?> actualDeserialiseResult =
        mapSerialiser.deserialise(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(1, actualDeserialiseResult.size());
    Object getResult = actualDeserialiseResult.get(false);
    assertTrue(getResult instanceof Set);
    assertEquals(1, ((Set<Boolean>) getResult).size());
  }

  /**
   * Test {@link MapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link MapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName("Test deserialise(byte[]) with 'bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes2() throws SerialisationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setValueSerialiser(new SetSerialiser(new SetSerialiser(new BooleanSerialiser())));
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act
    Map<?, ?> actualDeserialiseResult =
        mapSerialiser.deserialise(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(1, actualDeserialiseResult.size());
    Object getResult = actualDeserialiseResult.get(false);
    assertTrue(getResult instanceof Set);
    assertEquals(1, ((Set<HashSet>) getResult).size());
  }

  /**
   * Test {@link MapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Given {@code Map}.
   *   <li>Then throw {@link SerialisationException}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; given 'java.util.Map'; then throw SerialisationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_givenJavaUtilMap_thenThrowSerialisationException()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    Class<Map> mapClass = Map.class;
    mapSerialiser.setMapClass(mapClass);

    // Act and Assert
    assertThrows(
        SerialisationException.class,
        () -> mapSerialiser.deserialise("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link MapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>Given {@link MapSerialiser} (default constructor).
   *   <li>When empty array of {@code byte}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; given MapSerialiser (default constructor); when empty array of byte; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_givenMapSerialiser_whenEmptyArrayOfByte_thenReturnEmpty()
      throws SerialisationException {
    // Arrange, Act and Assert
    assertTrue(new MapSerialiser().deserialise(new byte[] {}).isEmpty());
  }

  /**
   * Test {@link MapSerialiser#deserialise(byte[])} with {@code bytes}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one and {@code X}.
   *   <li>Then return not {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#deserialise(byte[])}
   */
  @Test
  @DisplayName(
      "Test deserialise(byte[]) with 'bytes'; when array of byte with one and 'X'; then return not 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapSerialiser.deserialise(byte[])"})
  void testDeserialiseWithBytes_whenArrayOfByteWithOneAndX_thenReturnNotFalse()
      throws SerialisationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setValueSerialiser(new BooleanSerialiser());
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act
    Map<?, ?> actualDeserialiseResult =
        mapSerialiser.deserialise(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertEquals(1, actualDeserialiseResult.size());
    assertFalse((Boolean) actualDeserialiseResult.get(false));
  }

  /**
   * Test {@link MapSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link MapSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MapSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull(new MapSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link MapSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link MapSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertFalse(new MapSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link MapSerialiser#serialiseNull()}.
   *
   * <p>Method under test: {@link MapSerialiser#serialiseNull()}
   */
  @Test
  @DisplayName("Test serialiseNull()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] MapSerialiser.serialiseNull()"})
  void testSerialiseNull() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, new MapSerialiser().serialiseNull());
  }

  /**
   * Test {@link MapSerialiser#getKeySerialiserClassString()}.
   *
   * <p>Method under test: {@link MapSerialiser#getKeySerialiserClassString()}
   */
  @Test
  @DisplayName("Test getKeySerialiserClassString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MapSerialiser.getKeySerialiserClassString()"})
  void testGetKeySerialiserClassString() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act and Assert
    assertEquals(
        "uk.gov.gchq.gaffer.serialisation.implementation.BooleanSerialiser",
        mapSerialiser.getKeySerialiserClassString());
  }

  /**
   * Test {@link MapSerialiser#getKeySerialiserClassString()}.
   *
   * <ul>
   *   <li>Given {@link MapSerialiser} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#getKeySerialiserClassString()}
   */
  @Test
  @DisplayName(
      "Test getKeySerialiserClassString(); given MapSerialiser (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MapSerialiser.getKeySerialiserClassString()"})
  void testGetKeySerialiserClassString_givenMapSerialiser_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new MapSerialiser().getKeySerialiserClassString());
  }

  /**
   * Test {@link MapSerialiser#setKeySerialiserClassString(String)}.
   *
   * <ul>
   *   <li>Then {@link MapSerialiser} (default constructor) KeySerialiserClassString is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#setKeySerialiserClassString(String)}
   */
  @Test
  @DisplayName(
      "Test setKeySerialiserClassString(String); then MapSerialiser (default constructor) KeySerialiserClassString is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapSerialiser.setKeySerialiserClassString(String)"})
  void testSetKeySerialiserClassString_thenMapSerialiserKeySerialiserClassStringIsNull()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act
    mapSerialiser.setKeySerialiserClassString(null);

    // Assert
    assertNull(mapSerialiser.getKeySerialiserClassString());
    assertNull(mapSerialiser.getKeySerialiser());
  }

  /**
   * Test {@link MapSerialiser#setKeySerialiserClassString(String)}.
   *
   * <ul>
   *   <li>Then {@link MapSerialiser} (default constructor) KeySerialiser {@link MapSerialiser}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#setKeySerialiserClassString(String)}
   */
  @Test
  @DisplayName(
      "Test setKeySerialiserClassString(String); then MapSerialiser (default constructor) KeySerialiser MapSerialiser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapSerialiser.setKeySerialiserClassString(String)"})
  void testSetKeySerialiserClassString_thenMapSerialiserKeySerialiserMapSerialiser()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act
    mapSerialiser.setKeySerialiserClassString(
        "uk.gov.gchq.gaffer.serialisation.implementation.MapSerialiser");

    // Assert
    ToBytesSerialiser keySerialiser = mapSerialiser.getKeySerialiser();
    assertTrue(keySerialiser instanceof MapSerialiser);
    assertEquals(
        "uk.gov.gchq.gaffer.serialisation.implementation.MapSerialiser",
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
   *
   * <p>Method under test: {@link MapSerialiser#getValueSerialiserClassString()}
   */
  @Test
  @DisplayName("Test getValueSerialiserClassString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MapSerialiser.getValueSerialiserClassString()"})
  void testGetValueSerialiserClassString() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setValueSerialiser(new BooleanSerialiser());

    // Act and Assert
    assertEquals(
        "uk.gov.gchq.gaffer.serialisation.implementation.BooleanSerialiser",
        mapSerialiser.getValueSerialiserClassString());
  }

  /**
   * Test {@link MapSerialiser#getValueSerialiserClassString()}.
   *
   * <ul>
   *   <li>Given {@link MapSerialiser} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#getValueSerialiserClassString()}
   */
  @Test
  @DisplayName(
      "Test getValueSerialiserClassString(); given MapSerialiser (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MapSerialiser.getValueSerialiserClassString()"})
  void testGetValueSerialiserClassString_givenMapSerialiser_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new MapSerialiser().getValueSerialiserClassString());
  }

  /**
   * Test {@link MapSerialiser#setValueSerialiserClassString(String)}.
   *
   * <p>Method under test: {@link MapSerialiser#setValueSerialiserClassString(String)}
   */
  @Test
  @DisplayName("Test setValueSerialiserClassString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapSerialiser.setValueSerialiserClassString(String)"})
  void testSetValueSerialiserClassString()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act
    mapSerialiser.setValueSerialiserClassString(null);

    // Assert that nothing has changed
    assertNull(mapSerialiser.getValueSerialiserClassString());
    assertNull(mapSerialiser.getValueSerialiser());
  }

  /**
   * Test {@link MapSerialiser#setValueSerialiserClassString(String)}.
   *
   * <ul>
   *   <li>Then {@link MapSerialiser} (default constructor) ValueSerialiser {@link MapSerialiser}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#setValueSerialiserClassString(String)}
   */
  @Test
  @DisplayName(
      "Test setValueSerialiserClassString(String); then MapSerialiser (default constructor) ValueSerialiser MapSerialiser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapSerialiser.setValueSerialiserClassString(String)"})
  void testSetValueSerialiserClassString_thenMapSerialiserValueSerialiserMapSerialiser()
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act
    mapSerialiser.setValueSerialiserClassString(
        "uk.gov.gchq.gaffer.serialisation.implementation.MapSerialiser");

    // Assert
    ToBytesSerialiser valueSerialiser = mapSerialiser.getValueSerialiser();
    assertTrue(valueSerialiser instanceof MapSerialiser);
    assertEquals(
        "uk.gov.gchq.gaffer.serialisation.implementation.MapSerialiser",
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
   *
   * <ul>
   *   <li>Given {@code Map}.
   *   <li>Then return {@code Map}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#getMapClassString()}
   */
  @Test
  @DisplayName("Test getMapClassString(); given 'java.util.Map'; then return 'java.util.Map'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link MapSerialiser} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#getMapClassString()}
   */
  @Test
  @DisplayName(
      "Test getMapClassString(); given MapSerialiser (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MapSerialiser.getMapClassString()"})
  void testGetMapClassString_givenMapSerialiser_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new MapSerialiser().getMapClassString());
  }

  /**
   * Test {@link MapSerialiser#setMapClassString(String)}.
   *
   * <ul>
   *   <li>Then {@link MapSerialiser} (default constructor) MapClass is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#setMapClassString(String)}
   */
  @Test
  @DisplayName(
      "Test setMapClassString(String); then MapSerialiser (default constructor) MapClass is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapSerialiser.setMapClassString(String)"})
  void testSetMapClassString_thenMapSerialiserMapClassIsNull() throws ClassNotFoundException {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new BooleanSerialiser());

    // Act
    mapSerialiser.setMapClassString(null);

    // Assert that nothing has changed
    assertNull(mapSerialiser.getMapClass());
    assertNull(mapSerialiser.getMapClassString());
  }

  /**
   * Test {@link MapSerialiser#setMapClassString(String)}.
   *
   * <ul>
   *   <li>Then {@link MapSerialiser} (default constructor) MapClassString is {@code Map}.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#setMapClassString(String)}
   */
  @Test
  @DisplayName(
      "Test setMapClassString(String); then MapSerialiser (default constructor) MapClassString is 'java.util.Map'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapSerialiser.setMapClassString(String)"})
  void testSetMapClassString_thenMapSerialiserMapClassStringIsJavaUtilMap()
      throws ClassNotFoundException {
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
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapSerialiser#equals(Object)}
   *   <li>{@link MapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapSerialiser.equals(Object)", "int MapSerialiser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    MapSerialiser mapSerialiser2 = new MapSerialiser();

    // Act and Assert
    assertEquals(mapSerialiser, mapSerialiser2);
    assertEquals(mapSerialiser.hashCode(), mapSerialiser2.hashCode());
  }

  /**
   * Test {@link MapSerialiser#equals(Object)}, and {@link MapSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapSerialiser#equals(Object)}
   *   <li>{@link MapSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapSerialiser.equals(Object)", "int MapSerialiser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MapSerialiser mapSerialiser = new MapSerialiser();
    mapSerialiser.setKeySerialiser(new MapSerialiser());

    MapSerialiser mapSerialiser2 = new MapSerialiser();
    mapSerialiser2.setKeySerialiser(new BooleanSerialiser());

    // Act and Assert
    assertNotEquals(mapSerialiser, mapSerialiser2);
  }

  /**
   * Test {@link MapSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapSerialiser.equals(Object)", "int MapSerialiser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapSerialiser(), null);
  }

  /**
   * Test {@link MapSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MapSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapSerialiser.equals(Object)", "int MapSerialiser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MapSerialiser(), "Different type to MapSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MapSerialiser.<init>()",
    "ToBytesSerialiser MapSerialiser.getKeySerialiser()",
    "Class MapSerialiser.getMapClass()",
    "ToBytesSerialiser MapSerialiser.getValueSerialiser()",
    "boolean MapSerialiser.isConsistent()",
    "void MapSerialiser.setKeySerialiser(ToBytesSerialiser)",
    "void MapSerialiser.setMapClass(Class)",
    "void MapSerialiser.setValueSerialiser(ToBytesSerialiser)"
  })
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
  }
}
