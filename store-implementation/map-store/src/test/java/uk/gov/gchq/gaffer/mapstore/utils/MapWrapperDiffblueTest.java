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

package uk.gov.gchq.gaffer.mapstore.utils;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class MapWrapperDiffblueTest {
  /**
   * Method under test: {@link MapWrapper#getMap()}
   */
  @Test
  void testGetMap() {
    // Arrange
    HashMap<Object, Object> map = new HashMap<>();
    MapWrapper<Object, Object> objectObjectMap = new MapWrapper<>(map);

    // Act
    Map<Object, Object> actualMap = objectObjectMap.getMap();

    // Assert
    assertTrue(actualMap.isEmpty());
    assertSame(map, actualMap);
  }

  /**
   * Method under test: {@link MapWrapper#MapWrapper(Map)}
   */
  @Test
  void testNewMapWrapper() {
    // Arrange and Act
    MapWrapper<Object, Object> actualObjectObjectMap = new MapWrapper<>(new HashMap<>());

    // Assert
    assertTrue(actualObjectObjectMap.isEmpty());
  }

  /**
   * Method under test: {@link MapWrapper#MapWrapper(Map)}
   */
  @Test
  void testNewMapWrapper2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MapWrapper<>(null));
  }

  /**
   * Method under test: {@link MapWrapper#MapWrapper(Map)}
   */
  @Test
  void testNewMapWrapper3() {
    // Arrange
    HashMap<Object, Object> map = new HashMap<>();
    map.computeIfPresent("42", mock(BiFunction.class));

    // Act
    MapWrapper<Object, Object> actualObjectObjectMap = new MapWrapper<>(map);

    // Assert
    assertTrue(actualObjectObjectMap.isEmpty());
  }
}
