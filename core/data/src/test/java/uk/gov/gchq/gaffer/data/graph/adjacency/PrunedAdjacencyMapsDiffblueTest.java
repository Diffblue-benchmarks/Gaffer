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

package uk.gov.gchq.gaffer.data.graph.adjacency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.LazyEdge;

class PrunedAdjacencyMapsDiffblueTest {
  /**
   * Method under test: {@link PrunedAdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  void testAdd() {
    // Arrange
    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();

    // Act
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Assert
    assertEquals(1, prunedAdjacencyMaps.size());
  }

  /**
   * Method under test: {@link PrunedAdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  void testAdd2() {
    // Arrange
    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Act
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Assert
    assertEquals(2, prunedAdjacencyMaps.size());
  }

  /**
   * Method under test: {@link PrunedAdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  void testAdd3() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new Edge("Group"));

    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();
    prunedAdjacencyMaps.add(adjacencyMap);

    // Act
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Assert
    assertEquals(2, prunedAdjacencyMaps.size());
  }

  /**
   * Method under test: {@link PrunedAdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  void testAdd4() {
    // Arrange
    LazyEdge edge = new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class));
    edge.putProperty("Name", "Value");

    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", edge);

    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();
    prunedAdjacencyMaps.add(adjacencyMap);

    // Act
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Assert
    assertEquals(2, prunedAdjacencyMaps.size());
  }

  /**
   * Method under test: {@link PrunedAdjacencyMaps#asList()}
   */
  @Test
  void testAsList() {
    // Arrange, Act and Assert
    assertTrue((new PrunedAdjacencyMaps()).asList().isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PrunedAdjacencyMaps}
   */
  @Test
  void testNewPrunedAdjacencyMaps() {
    // Arrange, Act and Assert
    assertEquals(0, (new PrunedAdjacencyMaps()).size());
  }
}
