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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.LazyEdge;

class AdjacencyMapDiffblueTest {
  /**
   * Method under test: {@link AdjacencyMap#getEdges(Object, Object)}
   */
  @Test
  void testGetEdges() {
    // Arrange, Act and Assert
    assertTrue((new AdjacencyMap()).getEdges("Source", "Destination").isEmpty());
    assertTrue((new AdjacencyMap()).getEdges(null, null).isEmpty());
    assertTrue((new AdjacencyMap()).getEdges("Source", null).isEmpty());
  }

  /**
   * Method under test: {@link AdjacencyMap#getEdges(Object, Object)}
   */
  @Test
  void testGetEdges2() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new Edge("Group"));

    // Act and Assert
    assertEquals(1, adjacencyMap.getEdges("Source", "Destination").size());
  }

  /**
   * Method under test: {@link AdjacencyMap#getEdges(Object, Object)}
   */
  @Test
  void testGetEdges3() {
    // Arrange
    LazyEdge edge = new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class));
    edge.putProperty("Name", "Value");

    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", edge);

    // Act and Assert
    assertEquals(1, adjacencyMap.getEdges("Source", "Destination").size());
  }

  /**
   * Method under test: {@link AdjacencyMap#putEdges(Object, Object, Set)}
   */
  @Test
  void testPutEdges() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();

    // Act and Assert
    assertTrue(adjacencyMap.putEdges("Source", "Destination", new HashSet<>()).isEmpty());
  }

  /**
   * Method under test: {@link AdjacencyMap#putEdges(Object, Object, Set)}
   */
  @Test
  void testPutEdges2() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new Edge("Group"));

    HashSet<Edge> set = new HashSet<>();
    set.add(new Edge("Group"));

    // Act and Assert
    assertEquals(1, adjacencyMap.putEdges("Source", "Destination", set).size());
  }

  /**
   * Method under test: {@link AdjacencyMap#putEdges(Object, Object, Set)}
   */
  @Test
  void testPutEdges3() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new Edge("Group"));

    HashSet<Edge> set = new HashSet<>();
    set.add(new Edge("directed"));
    set.add(new Edge("Group"));

    // Act and Assert
    assertEquals(set, adjacencyMap.putEdges("Source", "Destination", set));
  }

  /**
   * Method under test: {@link AdjacencyMap#putEdge(Object, Object, Edge)}
   */
  @Test
  void testPutEdge() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();

    // Act and Assert
    assertNull(adjacencyMap.putEdge("Source", "Destination", new Edge("Group")));
    assertEquals(1, adjacencyMap.getAllDestinations().size());
    assertEquals(1, adjacencyMap.getAllSources().size());
  }

  /**
   * Method under test: {@link AdjacencyMap#putEdge(Object, Object, Edge)}
   */
  @Test
  void testPutEdge2() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new Edge("Group"));

    // Act
    Set<Edge> actualPutEdgeResult = adjacencyMap.putEdge("Source", "Destination", new Edge("Group"));

    // Assert
    assertEquals(1, adjacencyMap.getAllDestinations().size());
    assertEquals(1, adjacencyMap.getAllSources().size());
    assertEquals(1, actualPutEdgeResult.size());
  }

  /**
   * Method under test: {@link AdjacencyMap#putEdge(Object, Object, Edge)}
   */
  @Test
  void testPutEdge3() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    LazyEdge lazyEdge = new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class));

    adjacencyMap.putEdge(lazyEdge, "Destination", new Edge("Group"));

    // Act and Assert
    assertNull(adjacencyMap.putEdge("Source", "Destination", new Edge("Group")));
    assertEquals(1, adjacencyMap.getAllDestinations().size());
    assertEquals(2, adjacencyMap.getAllSources().size());
  }

  /**
   * Method under test: {@link AdjacencyMap#putEdge(Object, Object, Edge)}
   */
  @Test
  void testPutEdge4() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", 21, new Edge("Group"));

    // Act and Assert
    assertNull(adjacencyMap.putEdge("Source", "Destination", new Edge("Group")));
    assertEquals(1, adjacencyMap.getAllSources().size());
    assertEquals(2, adjacencyMap.getAllDestinations().size());
  }

  /**
   * Method under test: {@link AdjacencyMap#getDestinations(Object)}
   */
  @Test
  void testGetDestinations() {
    // Arrange, Act and Assert
    assertTrue((new AdjacencyMap()).getDestinations("Source").isEmpty());
  }

  /**
   * Method under test: {@link AdjacencyMap#getDestinations(Object)}
   */
  @Test
  void testGetDestinations2() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertEquals(1, adjacencyMap.getDestinations("Source").size());
  }

  /**
   * Method under test: {@link AdjacencyMap#getSources(Object)}
   */
  @Test
  void testGetSources() {
    // Arrange, Act and Assert
    assertTrue((new AdjacencyMap()).getSources("Destination").isEmpty());
  }

  /**
   * Method under test: {@link AdjacencyMap#getSources(Object)}
   */
  @Test
  void testGetSources2() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertEquals(1, adjacencyMap.getSources("Destination").size());
  }

  /**
   * Method under test: {@link AdjacencyMap#getAllSources()}
   */
  @Test
  void testGetAllSources() {
    // Arrange, Act and Assert
    assertTrue((new AdjacencyMap()).getAllSources().isEmpty());
  }

  /**
   * Method under test: {@link AdjacencyMap#getAllSources()}
   */
  @Test
  void testGetAllSources2() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new Edge("Group"));

    // Act and Assert
    assertEquals(1, adjacencyMap.getAllSources().size());
  }

  /**
   * Method under test: {@link AdjacencyMap#getAllSources()}
   */
  @Test
  void testGetAllSources3() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertEquals(1, adjacencyMap.getAllSources().size());
  }

  /**
   * Method under test: {@link AdjacencyMap#getAllDestinations()}
   */
  @Test
  void testGetAllDestinations() {
    // Arrange, Act and Assert
    assertTrue((new AdjacencyMap()).getAllDestinations().isEmpty());
  }

  /**
   * Method under test: {@link AdjacencyMap#getAllDestinations()}
   */
  @Test
  void testGetAllDestinations2() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertEquals(1, adjacencyMap.getAllDestinations().size());
  }

  /**
   * Method under test: {@link AdjacencyMap#removeAllWithDestination(Object)}
   */
  @Test
  void testRemoveAllWithDestination() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();

    // Act
    adjacencyMap.removeAllWithDestination("Destination");

    // Assert
    assertTrue(adjacencyMap.getAllDestinations().isEmpty());
    assertTrue(adjacencyMap.getAllSources().isEmpty());
  }

  /**
   * Method under test: {@link AdjacencyMap#removeAllWithDestination(Object)}
   */
  @Test
  void testRemoveAllWithDestination2() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new Edge("Group"));

    // Act
    adjacencyMap.removeAllWithDestination("Destination");

    // Assert
    assertTrue(adjacencyMap.getAllDestinations().isEmpty());
    assertTrue(adjacencyMap.getAllSources().isEmpty());
  }

  /**
   * Method under test: {@link AdjacencyMap#removeAllWithDestination(Object)}
   */
  @Test
  void testRemoveAllWithDestination3() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", 42, new Edge("Group"));
    adjacencyMap.putEdge("Source", "Destination", new Edge("Group"));

    // Act
    adjacencyMap.removeAllWithDestination("Destination");

    // Assert
    assertEquals(1, adjacencyMap.getAllDestinations().size());
    assertEquals(1, adjacencyMap.getAllSources().size());
  }

  /**
   * Method under test: {@link AdjacencyMap#removeAllWithDestination(Object)}
   */
  @Test
  void testRemoveAllWithDestination4() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act
    adjacencyMap.removeAllWithDestination("Destination");

    // Assert
    assertTrue(adjacencyMap.getAllDestinations().isEmpty());
    assertTrue(adjacencyMap.getAllSources().isEmpty());
  }

  /**
   * Method under test: {@link AdjacencyMap#containsSource(Object)}
   */
  @Test
  void testContainsSource() {
    // Arrange, Act and Assert
    assertFalse((new AdjacencyMap()).containsSource("Source"));
  }

  /**
   * Method under test: {@link AdjacencyMap#containsSource(Object)}
   */
  @Test
  void testContainsSource2() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new Edge("Group"));

    // Act and Assert
    assertTrue(adjacencyMap.containsSource("Source"));
  }

  /**
   * Method under test: {@link AdjacencyMap#containsSource(Object)}
   */
  @Test
  void testContainsSource3() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertTrue(adjacencyMap.containsSource("Source"));
  }

  /**
   * Method under test: {@link AdjacencyMap#containsDestination(Object)}
   */
  @Test
  void testContainsDestination() {
    // Arrange, Act and Assert
    assertFalse((new AdjacencyMap()).containsDestination("Destination"));
  }

  /**
   * Method under test: {@link AdjacencyMap#containsDestination(Object)}
   */
  @Test
  void testContainsDestination2() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new Edge("Group"));

    // Act and Assert
    assertTrue(adjacencyMap.containsDestination("Destination"));
  }

  /**
   * Method under test: {@link AdjacencyMap#containsDestination(Object)}
   */
  @Test
  void testContainsDestination3() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", 6, new Edge("Group"));

    // Act and Assert
    assertFalse(adjacencyMap.containsDestination("Destination"));
  }

  /**
   * Method under test: {@link AdjacencyMap#containsDestination(Object)}
   */
  @Test
  void testContainsDestination4() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge("Source", "Destination", new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertTrue(adjacencyMap.containsDestination("Destination"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AdjacencyMap}
   */
  @Test
  void testNewAdjacencyMap() {
    // Arrange and Act
    AdjacencyMap actualAdjacencyMap = new AdjacencyMap();

    // Assert
    assertTrue(actualAdjacencyMap.getAllDestinations().isEmpty());
    assertTrue(actualAdjacencyMap.getAllSources().isEmpty());
  }

  /**
   * Method under test: {@link AdjacencyMap#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("{}", (new AdjacencyMap()).toString());
  }
}
