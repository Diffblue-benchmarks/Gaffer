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

package uk.gov.gchq.gaffer.cache.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.hazelcast.map.IMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;

class HazelcastCacheDiffblueTest {
  /**
   * Test {@link HazelcastCache#get(Object)}.
   * <p>
   * Method under test: {@link HazelcastCache#get(Object)}
   */
  @Test
  @DisplayName("Test get(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object HazelcastCache.get(Object)"})
  void testGet() {
    // Arrange
    IMap<Object, Object> distributedMap = mock(IMap.class);
    when(distributedMap.get(Mockito.<Object>any())).thenReturn("Get");
    HazelcastCache<Object, Object> hazelcastCache = new HazelcastCache<>(distributedMap);

    // Act
    Object actualGetResult = hazelcastCache.get("Key");

    // Assert
    verify(distributedMap).get(isA(Object.class));
    assertEquals("Get", actualGetResult);
  }

  /**
   * Test {@link HazelcastCache#put(Object, Object)}.
   * <p>
   * Method under test: {@link HazelcastCache#put(Object, Object)}
   */
  @Test
  @DisplayName("Test put(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HazelcastCache.put(Object, Object)"})
  void testPut() throws CacheOperationException {
    // Arrange
    IMap<Object, Object> distributedMap = mock(IMap.class);
    when(distributedMap.put(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Put");
    HazelcastCache<Object, Object> hazelcastCache = new HazelcastCache<>(distributedMap);

    // Act
    hazelcastCache.put("Key", "Value");

    // Assert
    verify(distributedMap).put(isA(Object.class), isA(Object.class));
  }

  /**
   * Test {@link HazelcastCache#remove(Object)}.
   * <p>
   * Method under test: {@link HazelcastCache#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HazelcastCache.remove(Object)"})
  void testRemove() {
    // Arrange
    IMap<Object, Object> distributedMap = mock(IMap.class);
    when(distributedMap.remove(Mockito.<Object>any())).thenReturn("Remove");
    HazelcastCache<Object, Object> hazelcastCache = new HazelcastCache<>(distributedMap);

    // Act
    hazelcastCache.remove("Key");

    // Assert
    verify(distributedMap).remove(isA(Object.class));
  }

  /**
   * Test {@link HazelcastCache#getAllValues()}.
   * <p>
   * Method under test: {@link HazelcastCache#getAllValues()}
   */
  @Test
  @DisplayName("Test getAllValues()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection HazelcastCache.getAllValues()"})
  void testGetAllValues() {
    // Arrange
    IMap<Object, Object> distributedMap = mock(IMap.class);
    ArrayList<Object> objectList = new ArrayList<>();
    when(distributedMap.values()).thenReturn(objectList);
    HazelcastCache<Object, Object> hazelcastCache = new HazelcastCache<>(distributedMap);

    // Act
    Collection<Object> actualAllValues = hazelcastCache.getAllValues();

    // Assert
    verify(distributedMap).values();
    assertTrue(actualAllValues instanceof List);
    assertTrue(actualAllValues.isEmpty());
    assertSame(objectList, actualAllValues);
  }

  /**
   * Test {@link HazelcastCache#getAllKeys()}.
   * <p>
   * Method under test: {@link HazelcastCache#getAllKeys()}
   */
  @Test
  @DisplayName("Test getAllKeys()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set HazelcastCache.getAllKeys()"})
  void testGetAllKeys() {
    // Arrange
    IMap<Object, Object> distributedMap = mock(IMap.class);
    when(distributedMap.keySet()).thenReturn(new HashSet<>());
    HazelcastCache<Object, Object> hazelcastCache = new HazelcastCache<>(distributedMap);

    // Act
    Set<Object> actualAllKeys = hazelcastCache.getAllKeys();

    // Assert
    verify(distributedMap).keySet();
    assertTrue(actualAllKeys.isEmpty());
  }

  /**
   * Test {@link HazelcastCache#size()}.
   * <p>
   * Method under test: {@link HazelcastCache#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int HazelcastCache.size()"})
  void testSize() {
    // Arrange
    IMap<Object, Object> distributedMap = mock(IMap.class);
    when(distributedMap.size()).thenReturn(3);
    HazelcastCache<Object, Object> hazelcastCache = new HazelcastCache<>(distributedMap);

    // Act
    int actualSizeResult = hazelcastCache.size();

    // Assert
    verify(distributedMap).size();
    assertEquals(3, actualSizeResult);
  }

  /**
   * Test {@link HazelcastCache#clear()}.
   * <p>
   * Method under test: {@link HazelcastCache#clear()}
   */
  @Test
  @DisplayName("Test clear()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HazelcastCache.clear()"})
  void testClear() throws CacheOperationException {
    // Arrange
    IMap<Object, Object> distributedMap = mock(IMap.class);
    doNothing().when(distributedMap).clear();
    HazelcastCache<Object, Object> hazelcastCache = new HazelcastCache<>(distributedMap);

    // Act
    hazelcastCache.clear();

    // Assert
    verify(distributedMap).clear();
  }
}
