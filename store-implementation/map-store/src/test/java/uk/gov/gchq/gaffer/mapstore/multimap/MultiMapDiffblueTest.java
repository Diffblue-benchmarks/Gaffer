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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class MultiMapDiffblueTest {
  /**
   * Method under test: {@link MultiMap#putAll(MultiMap)}
   */
  @Test
  void testPutAll() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    MapOfSets<Object, Object> map = new MapOfSets<>(multiMap);

    // Act
    mapOfSets.putAll(map);

    // Assert that nothing has changed
    Map<Object, Set<Object>> wrappedMap = map.getWrappedMap();
    assertTrue(wrappedMap.isEmpty());
    assertSame(multiMap, wrappedMap);
  }

  /**
   * Method under test: {@link MultiMap#putAll(MultiMap)}
   */
  @Test
  void testPutAll2() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());

    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    multiMap.put("42", new HashSet<>());
    MapOfSets<Object, Object> map = new MapOfSets<>(multiMap);

    // Act
    mapOfSets.putAll(map);

    // Assert
    Map<Object, Set<Object>> wrappedMap = map.getWrappedMap();
    assertEquals(1, wrappedMap.size());
    assertTrue(wrappedMap.containsKey("42"));
    assertSame(multiMap, wrappedMap);
  }

  /**
   * Method under test: {@link MultiMap#putAll(MultiMap)}
   */
  @Test
  void testPutAll3() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());

    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    multiMap.computeIfPresent("42", mock(BiFunction.class));
    multiMap.put("42", new HashSet<>());
    MapOfSets<Object, Object> map = new MapOfSets<>(multiMap);

    // Act
    mapOfSets.putAll(map);

    // Assert
    Map<Object, Set<Object>> wrappedMap = map.getWrappedMap();
    assertEquals(1, wrappedMap.size());
    assertTrue(wrappedMap.containsKey("42"));
    assertSame(multiMap, wrappedMap);
  }

  /**
   * Method under test: {@link MultiMap#putAll(MultiMap)}
   */
  @Test
  void testPutAll4() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    multiMap.put("42", new HashSet<>());
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);

    HashMap<Object, Set<Object>> multiMap2 = new HashMap<>();
    multiMap2.put("42", new HashSet<>());
    MapOfSets<Object, Object> map = new MapOfSets<>(multiMap2);

    // Act
    mapOfSets.putAll(map);

    // Assert
    Map<Object, Set<Object>> wrappedMap = map.getWrappedMap();
    assertEquals(1, wrappedMap.size());
    assertTrue(wrappedMap.containsKey("42"));
    assertSame(multiMap2, wrappedMap);
  }
}
