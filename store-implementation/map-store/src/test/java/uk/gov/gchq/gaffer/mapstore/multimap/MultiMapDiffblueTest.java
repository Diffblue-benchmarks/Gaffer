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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MultiMapDiffblueTest {
  /**
   * Test {@link MultiMap#putAll(MultiMap)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link MapOfSets#MapOfSets(Map)} with multiMap is {@link HashMap#HashMap()}
   *       WrappedMap size is one.
   * </ul>
   *
   * <p>Method under test: {@link MultiMap#putAll(MultiMap)}
   */
  @Test
  @DisplayName(
      "Test putAll(MultiMap); given '42'; then MapOfSets(Map) with multiMap is HashMap() WrappedMap size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiMap.putAll(MultiMap)"})
  void testPutAll_given42_thenMapOfSetsWithMultiMapIsHashMapWrappedMapSizeIsOne() {
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
   * Test {@link MultiMap#putAll(MultiMap)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link MultiMap#putAll(MultiMap)}
   */
  @Test
  @DisplayName("Test putAll(MultiMap); given HashMap() '42' is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiMap.putAll(MultiMap)"})
  void testPutAll_givenHashMap42IsHashSet() {
    // Arrange
    HashMap<Object, Set<Object>> multiMap = new HashMap<>();
    multiMap.put("42", new HashSet<>());
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(multiMap);

    HashMap<Object, Set<Object>> multiMap2 = new HashMap<>();
    multiMap2.put("42", new HashSet<>());
    MapOfSets<Object, Object> map = new MapOfSets<>(multiMap2);

    // Act
    mapOfSets.putAll(map);

    // Assert that nothing has changed
    Map<Object, Set<Object>> wrappedMap = map.getWrappedMap();
    assertEquals(1, wrappedMap.size());
    assertTrue(wrappedMap.containsKey("42"));
    assertSame(multiMap2, wrappedMap);
  }

  /**
   * Test {@link MultiMap#putAll(MultiMap)}.
   *
   * <ul>
   *   <li>Then {@link MapOfSets#MapOfSets(Map)} with multiMap is {@link HashMap#HashMap()}
   *       WrappedMap Empty.
   * </ul>
   *
   * <p>Method under test: {@link MultiMap#putAll(MultiMap)}
   */
  @Test
  @DisplayName(
      "Test putAll(MultiMap); then MapOfSets(Map) with multiMap is HashMap() WrappedMap Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiMap.putAll(MultiMap)"})
  void testPutAll_thenMapOfSetsWithMultiMapIsHashMapWrappedMapEmpty() {
    // Arrange
    MapOfSets<Object, Object> mapOfSets = new MapOfSets<>(new HashMap<>());
    MapOfSets<Object, Object> map = new MapOfSets<>(new HashMap<>());

    // Act
    mapOfSets.putAll(map);

    // Assert that nothing has changed
    assertTrue(map.getWrappedMap().isEmpty());
  }
}
