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

package uk.gov.gchq.gaffer.mapstore.multimap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class MapOfSetsDiffblueTest {
  /**
   * Method under test: {@link MapOfSets#put(Object, Object)}
   */
  @Test
  void testPut() {
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
   * Method under test: {@link MapOfSets#put(Object, Object)}
   */
  @Test
  void testPut2() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    Class<Set> setClass = Set.class;
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap, setClass);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> mapOfSets.put("Key", "Value"));
  }

  /**
   * Method under test: {@link MapOfSets#put(Object, Object)}
   */
  @Test
  void testPut3() {
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
   * Method under test: {@link MapOfSets#put(Object, Object)}
   */
  @Test
  void testPut4() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    multiMap.computeIfPresent("42", mock(BiFunction.class));
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
   * Method under test: {@link MapOfSets#put(Object, Collection)}
   */
  @Test
  void testPut5() {
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
   * Method under test: {@link MapOfSets#put(Object, Collection)}
   */
  @Test
  void testPut6() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();

    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);
    mapOfSets.put("Key", "Value");

    // Act
    mapOfSets.put("Key", (Collection<Object>) new ArrayList<>());

    // Assert
    Map<Object, Set<Object>> wrappedMap = mapOfSets.getWrappedMap();
    assertEquals(1, wrappedMap.size());
    assertEquals(1, wrappedMap.get("Key").size());
    assertSame(multiMap, wrappedMap);
  }

  /**
   * Method under test: {@link MapOfSets#put(Object, Collection)}
   */
  @Test
  void testPut7() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");

    // Act
    mapOfSets.put("Key", (Collection<Object>) value);

    // Assert
    Map<Object, Set<Object>> wrappedMap = mapOfSets.getWrappedMap();
    assertEquals(1, wrappedMap.size());
    assertEquals(1, wrappedMap.get("Key").size());
    assertSame(multiMap, wrappedMap);
  }

  /**
   * Method under test: {@link MapOfSets#put(Object, Collection)}
   */
  @Test
  void testPut8() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);

    ArrayList<Object> value = new ArrayList<>();
    value.add("42");
    value.add("42");

    // Act
    mapOfSets.put("Key", (Collection<Object>) value);

    // Assert
    Map<Object, Set<Object>> wrappedMap = mapOfSets.getWrappedMap();
    assertEquals(1, wrappedMap.size());
    assertEquals(1, wrappedMap.get("Key").size());
    assertSame(multiMap, wrappedMap);
  }

  /**
   * Method under test: {@link MapOfSets#put(Object, Collection)}
   */
  @Test
  void testPut9() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    multiMap.computeIfPresent("42", mock(BiFunction.class));
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
   * Method under test: {@link MapOfSets#remove(Object, Object)}
   */
  @Test
  void testRemove() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());
    mapOfSets.put("Key", "Value");

    // Act and Assert
    assertFalse(mapOfSets.remove("Key", "Value To Delete"));
  }

  /**
   * Method under test: {@link MapOfSets#get(Object)}
   */
  @Test
  void testGet() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());

    // Act and Assert
    assertNull(mapOfSets.get("Key"));
  }

  /**
   * Method under test: {@link MapOfSets#get(Object)}
   */
  @Test
  void testGet2() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    multiMap.computeIfPresent("42", mock(BiFunction.class));
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);

    // Act and Assert
    assertNull(mapOfSets.get("Key"));
  }

  /**
   * Method under test: {@link MapOfSets#keySet()}
   */
  @Test
  void testKeySet() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());

    // Act and Assert
    assertTrue(mapOfSets.keySet().isEmpty());
  }

  /**
   * Method under test: {@link MapOfSets#keySet()}
   */
  @Test
  void testKeySet2() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    multiMap.computeIfPresent("42", mock(BiFunction.class));
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);

    // Act and Assert
    assertTrue(mapOfSets.keySet().isEmpty());
  }

  /**
   * Method under test: {@link MapOfSets#entrySet()}
   */
  @Test
  void testEntrySet() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());

    // Act
    Collection<Map.Entry<Object, Set<Object>>> actualEntrySetResult = mapOfSets.entrySet();

    // Assert
    assertTrue(actualEntrySetResult instanceof Set);
    assertTrue(actualEntrySetResult.isEmpty());
  }

  /**
   * Method under test: {@link MapOfSets#entrySet()}
   */
  @Test
  void testEntrySet2() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    multiMap.computeIfPresent("42", mock(BiFunction.class));
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);

    // Act
    Collection<Map.Entry<Object, Set<Object>>> actualEntrySetResult = mapOfSets.entrySet();

    // Assert
    assertTrue(actualEntrySetResult instanceof Set);
    assertTrue(actualEntrySetResult.isEmpty());
  }

  /**
   * Method under test: {@link MapOfSets#createSet()}
   */
  @Test
  void testCreateSet() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());

    // Act and Assert
    assertTrue(mapOfSets.createSet().isEmpty());
  }

  /**
   * Method under test: {@link MapOfSets#createSet()}
   */
  @Test
  void testCreateSet2() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    Class<Set> setClass = Set.class;
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap, setClass);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> mapOfSets.createSet());
  }

  /**
   * Method under test: {@link MapOfSets#createSet()}
   */
  @Test
  void testCreateSet3() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    multiMap.computeIfPresent("42", mock(BiFunction.class));
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);

    // Act and Assert
    assertTrue(mapOfSets.createSet().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MapOfSets#MapOfSets(Map)}
   *   <li>{@link MapOfSets#getWrappedMap()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link MapOfSets#MapOfSets(Map, Class)}
   *   <li>{@link MapOfSets#getWrappedMap()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
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
}
