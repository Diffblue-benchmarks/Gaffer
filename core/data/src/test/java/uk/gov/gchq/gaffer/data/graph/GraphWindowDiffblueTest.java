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

package uk.gov.gchq.gaffer.data.graph;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.graph.adjacency.AdjacencyMaps;
import uk.gov.gchq.gaffer.data.graph.entity.EntityMaps;

class GraphWindowDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GraphWindow#GraphWindow(AdjacencyMaps, EntityMaps)}
   *   <li>{@link GraphWindow#getAdjacencyMaps()}
   *   <li>{@link GraphWindow#getEntityMaps()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    AdjacencyMaps adjacencyMaps = mock(AdjacencyMaps.class);
    EntityMaps entityMaps = mock(EntityMaps.class);

    // Act
    GraphWindow actualGraphWindow = new GraphWindow(adjacencyMaps, entityMaps);
    AdjacencyMaps actualAdjacencyMaps = actualGraphWindow.getAdjacencyMaps();

    // Assert
    assertSame(adjacencyMaps, actualAdjacencyMaps);
    assertSame(entityMaps, actualGraphWindow.getEntityMaps());
  }
}
