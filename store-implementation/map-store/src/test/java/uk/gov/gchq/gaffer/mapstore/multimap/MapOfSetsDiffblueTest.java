/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.mapstore.multimap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapOfSetsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapOfSets#MapOfSets(Map)}
   *   <li>{@link MapOfSets#getWrappedMap()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MapOfSets.<init>(Map)",
    "void MapOfSets.<init>(Map, Class)",
    "Map MapOfSets.getWrappedMap()"
  })
  void testGettersAndSetters_whenHashMap() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();

    // Act
    MapOfSets<Object, Object> actualMapOfSets = new MapOfSets<>(multiMap);
    Map<Object, Set<Object>> actualWrappedMap = actualMapOfSets.getWrappedMap();

    // Assert
    assertTrue(actualWrappedMap.isEmpty());
    assertSame(multiMap, actualWrappedMap);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Set}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MapOfSets#MapOfSets(Map, Class)}
   *   <li>{@link MapOfSets#getWrappedMap()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'java.util.Set'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MapOfSets.<init>(Map)",
    "void MapOfSets.<init>(Map, Class)",
    "Map MapOfSets.getWrappedMap()"
  })
  void testGettersAndSetters_whenJavaUtilSet() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    Class<Set> setClass = Set.class;

    // Act
    MapOfSets<Object, Object> actualMapOfSets = new MapOfSets<>(multiMap, setClass);
    Map<Object, Set<Object>> actualWrappedMap = actualMapOfSets.getWrappedMap();

    // Assert
    assertTrue(actualWrappedMap.isEmpty());
    assertSame(multiMap, actualWrappedMap);
  }

  /**
   * Test {@link MapOfSets#put(Object, Collection)} with {@code Object}, {@code Collection}.
   *
   * <p>Method under test: {@link MapOfSets#put(Object, Collection)}
   */
  @Test
  @DisplayName("Test put(Object, Collection) with 'Object', 'Collection'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapOfSets.put(Object, Collection)"})
  void testPutWithObjectCollection() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);
    HashSet<Object> value = new HashSet<>();

    // Act
    mapOfSets.put("Key", (Collection<Object>) value);

    // Assert
    Map<Object, Set<Object>> wrappedMap = mapOfSets.getWrappedMap();
    assertEquals(1, wrappedMap.size());
    assertSame(multiMap, wrappedMap);
    assertSame(value, wrappedMap.get("Key"));
  }

  /**
   * Test {@link MapOfSets#put(Object, Collection)} with {@code Object}, {@code Collection}.
   *
   * <p>Method under test: {@link MapOfSets#put(Object, Collection)}
   */
  @Test
  @DisplayName("Test put(Object, Collection) with 'Object', 'Collection'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapOfSets.put(Object, Collection)"})
  void testPutWithObjectCollection2() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();

    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);
    mapOfSets.put("Key", "Value");

    // Act
    mapOfSets.put("Key", (Collection<Object>) new ArrayList<>());

    // Assert that nothing has changed
    Map<Object, Set<Object>> wrappedMap = mapOfSets.getWrappedMap();
    assertEquals(1, wrappedMap.size());
    assertEquals(1, wrappedMap.get("Key").size());
    assertSame(multiMap, wrappedMap);
  }

  /**
   * Test {@link MapOfSets#put(Object, Collection)} with {@code Object}, {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MapOfSets#put(Object, Collection)}
   */
  @Test
  @DisplayName(
      "Test put(Object, Collection) with 'Object', 'Collection'; given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapOfSets.put(Object, Collection)"})
  void testPutWithObjectCollection_given42_whenArrayListAdd42() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();

    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);
    mapOfSets.put("Key", "Value");

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");

    // Act
    mapOfSets.put("Key", (Collection<Object>) value);

    // Assert
    assertSame(multiMap, mapOfSets.getWrappedMap());
  }

  /**
   * Test {@link MapOfSets#put(Object, Collection)} with {@code Object}, {@code Collection}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MapOfSets#put(Object, Collection)}
   */
  @Test
  @DisplayName(
      "Test put(Object, Collection) with 'Object', 'Collection'; given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapOfSets.put(Object, Collection)"})
  void testPutWithObjectCollection_given42_whenArrayListAdd422() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();

    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);
    mapOfSets.put("Key", "Value");

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    value.add("42");

    // Act
    mapOfSets.put("Key", (Collection<Object>) value);

    // Assert
    assertSame(multiMap, mapOfSets.getWrappedMap());
  }

  /**
   * Test {@link MapOfSets#put(Object, Collection)} with {@code Object}, {@code Collection}.
   *
   * <ul>
   *   <li>Then {@link MapOfSets#MapOfSets(Map)} with multiMap is {@link HashMap#HashMap()}
   *       WrappedMap {@code Key} Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapOfSets#put(Object, Collection)}
   */
  @Test
  @DisplayName(
      "Test put(Object, Collection) with 'Object', 'Collection'; then MapOfSets(Map) with multiMap is HashMap() WrappedMap 'Key' Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MapOfSets.put(Object, Collection)"})
  void testPutWithObjectCollection_thenMapOfSetsWithMultiMapIsHashMapWrappedMapKeyEmpty() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);

    // Act
    mapOfSets.put("Key", (Collection<Object>) new ArrayList<>());

    // Assert
    Map<Object, Set<Object>> wrappedMap = mapOfSets.getWrappedMap();
    assertEquals(1, wrappedMap.size());
    assertTrue(wrappedMap.get("Key").isEmpty());
    assertSame(multiMap, wrappedMap);
  }

  /**
   * Test {@link MapOfSets#put(Object, Object)} with {@code Object}, {@code Object}.
   *
   * <ul>
   *   <li>Given {@code Set}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MapOfSets#put(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test put(Object, Object) with 'Object', 'Object'; given 'java.util.Set'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapOfSets.put(Object, Object)"})
  void testPutWithObjectObject_givenJavaUtilSet_thenThrowIllegalArgumentException() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    Class<Set> setClass = Set.class;

    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap, setClass);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> mapOfSets.put("Key", "Value"));
  }

  /**
   * Test {@link MapOfSets#put(Object, Object)} with {@code Object}, {@code Object}.
   *
   * <ul>
   *   <li>Given {@link MapOfSets#MapOfSets(Map)} with multiMap is {@link HashMap#HashMap()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MapOfSets#put(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test put(Object, Object) with 'Object', 'Object'; given MapOfSets(Map) with multiMap is HashMap(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapOfSets.put(Object, Object)"})
  void testPutWithObjectObject_givenMapOfSetsWithMultiMapIsHashMap_thenReturnTrue() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);

    // Act
    boolean actualPutResult = mapOfSets.put("Key", "Value");

    // Assert
    Map<Object, Set<Object>> wrappedMap = mapOfSets.getWrappedMap();
    assertEquals(1, wrappedMap.size());
    assertEquals(1, wrappedMap.get("Key").size());
    assertTrue(actualPutResult);
    assertSame(multiMap, wrappedMap);
  }

  /**
   * Test {@link MapOfSets#put(Object, Object)} with {@code Object}, {@code Object}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MapOfSets#put(Object, Object)}
   */
  @Test
  @DisplayName("Test put(Object, Object) with 'Object', 'Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapOfSets.put(Object, Object)"})
  void testPutWithObjectObject_thenReturnFalse() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();

    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);
    mapOfSets.put("Key", "Value");

    // Act
    boolean actualPutResult = mapOfSets.put("Key", "Value");

    // Assert
    Map<Object, Set<Object>> wrappedMap = mapOfSets.getWrappedMap();
    assertEquals(1, wrappedMap.size());
    assertEquals(1, wrappedMap.get("Key").size());
    assertFalse(actualPutResult);
    assertSame(multiMap, wrappedMap);
  }

  /**
   * Test {@link MapOfSets#remove(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link MapOfSets#MapOfSets(Map)} with multiMap is {@link HashMap#HashMap()} {@code
   *       Key} is {@code Value}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MapOfSets#remove(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object, Object); given MapOfSets(Map) with multiMap is HashMap() 'Key' is 'Value'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MapOfSets.remove(Object, Object)"})
  void testRemove_givenMapOfSetsWithMultiMapIsHashMapKeyIsValue_thenReturnFalse() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());
    mapOfSets.put("Key", "Value");

    // Act and Assert
    assertFalse(mapOfSets.remove("Key", "Value To Delete"));
  }

  /**
   * Test {@link MapOfSets#get(Object)}.
   *
   * <p>Method under test: {@link MapOfSets#get(Object)}
   */
  @Test
  @DisplayName("Test get(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MapOfSets.get(Object)"})
  void testGet() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());

    // Act and Assert
    assertNull(mapOfSets.get("Key"));
  }

  /**
   * Test {@link MapOfSets#keySet()}.
   *
   * <p>Method under test: {@link MapOfSets#keySet()}
   */
  @Test
  @DisplayName("Test keySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MapOfSets.keySet()"})
  void testKeySet() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());

    // Act and Assert
    assertTrue(mapOfSets.keySet().isEmpty());
  }

  /**
   * Test {@link MapOfSets#entrySet()}.
   *
   * <p>Method under test: {@link MapOfSets#entrySet()}
   */
  @Test
  @DisplayName("Test entrySet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection MapOfSets.entrySet()"})
  void testEntrySet() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());

    // Act
    Collection<Entry<Object, Set<Object>>> actualEntrySetResult = mapOfSets.entrySet();

    // Assert
    assertTrue(actualEntrySetResult instanceof Set);
    assertTrue(actualEntrySetResult.isEmpty());
  }

  /**
   * Test {@link MapOfSets#createSet()}.
   *
   * <ul>
   *   <li>Given {@code Set}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link MapOfSets#createSet()}
   */
  @Test
  @DisplayName("Test createSet(); given 'java.util.Set'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MapOfSets.createSet()"})
  void testCreateSet_givenJavaUtilSet_thenThrowIllegalArgumentException() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    Class<Set> setClass = Set.class;

    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap, setClass);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> mapOfSets.createSet());
  }

  /**
   * Test {@link MapOfSets#createSet()}.
   *
   * <ul>
   *   <li>Given {@link MapOfSets#MapOfSets(Map)} with multiMap is {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MapOfSets#createSet()}
   */
  @Test
  @DisplayName(
      "Test createSet(); given MapOfSets(Map) with multiMap is HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set MapOfSets.createSet()"})
  void testCreateSet_givenMapOfSetsWithMultiMapIsHashMap_thenReturnEmpty() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());

    // Act and Assert
    assertTrue(mapOfSets.createSet().isEmpty());
  }
}
