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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MapWrapperDiffblueTest {
  /**
   * Test {@link MapWrapper#MapWrapper(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapWrapper#MapWrapper(Map)}
   */
  @Test
  @DisplayName("Test new MapWrapper(Map); when HashMap(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapWrapper.<init>(Map)"})
  void testNewMapWrapper_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    MapWrapper<Object, Object> actualObjectObjectMap = new MapWrapper<>(new HashMap<>());

    // Assert
    assertTrue(actualObjectObjectMap.isEmpty());
  }

  /**
   * Test {@link MapWrapper#MapWrapper(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapWrapper#MapWrapper(Map)}
   */
  @Test
  @DisplayName("Test new MapWrapper(Map); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapWrapper.<init>(Map)"})
  void testNewMapWrapper_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MapWrapper<>(null));
  }

  /**
   * Test {@link MapWrapper#getMap()}.
   * <p>
   * Method under test: {@link MapWrapper#getMap()}
   */
  @Test
  @DisplayName("Test getMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map MapWrapper.getMap()"})
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
}
