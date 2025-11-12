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

package uk.gov.gchq.gaffer.data.graph.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class SimpleEntityMapsDiffblueTest {
  /**
   * Method under test: {@link SimpleEntityMaps#asList()}
   */
  @Test
  void testAsList() {
    // Arrange, Act and Assert
    assertTrue((new SimpleEntityMaps()).asList().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SimpleEntityMaps}
   *   <li>{@link SimpleEntityMaps#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SimpleEntityMaps actualSimpleEntityMaps = new SimpleEntityMaps();
    actualSimpleEntityMaps.toString();

    // Assert
    assertEquals(0, actualSimpleEntityMaps.size());
  }
}
