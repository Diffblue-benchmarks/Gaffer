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

package uk.gov.gchq.gaffer.data.graph.function.walk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.graph.Walk;

class ExtractWalkEntitiesFromHopDiffblueTest {
  /**
   * Method under test: {@link ExtractWalkEntitiesFromHop#apply(Walk)}
   */
  @Test
  void testApply() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new ExtractWalkEntitiesFromHop(1)).apply(null));
  }

  /**
   * Method under test: {@link ExtractWalkEntitiesFromHop#apply(Walk)}
   */
  @Test
  void testApply2() {
    // Arrange
    ExtractWalkEntitiesFromHop extractWalkEntitiesFromHop = new ExtractWalkEntitiesFromHop(1);

    ArrayList<Map.Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new AbstractMap.SimpleEntry<>("42", new HashSet<>()));
    HashSet<Entity> entitySet = new HashSet<>();
    entities.add(new AbstractMap.SimpleEntry<>("42", entitySet));

    // Act
    Set<Entity> actualApplyResult = extractWalkEntitiesFromHop.apply(new Walk(new ArrayList<>(), entities));

    // Assert
    assertTrue(actualApplyResult.isEmpty());
    assertSame(entitySet, actualApplyResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractWalkEntitiesFromHop#ExtractWalkEntitiesFromHop()}
   *   <li>{@link ExtractWalkEntitiesFromHop#setHop(int)}
   *   <li>{@link ExtractWalkEntitiesFromHop#getHop()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ExtractWalkEntitiesFromHop actualExtractWalkEntitiesFromHop = new ExtractWalkEntitiesFromHop();
    actualExtractWalkEntitiesFromHop.setHop(1);

    // Assert that nothing has changed
    assertEquals(1, actualExtractWalkEntitiesFromHop.getHop());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExtractWalkEntitiesFromHop#ExtractWalkEntitiesFromHop(int)}
   *   <li>{@link ExtractWalkEntitiesFromHop#setHop(int)}
   *   <li>{@link ExtractWalkEntitiesFromHop#getHop()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ExtractWalkEntitiesFromHop actualExtractWalkEntitiesFromHop = new ExtractWalkEntitiesFromHop(1);
    actualExtractWalkEntitiesFromHop.setHop(1);

    // Assert that nothing has changed
    assertEquals(1, actualExtractWalkEntitiesFromHop.getHop());
  }
}
