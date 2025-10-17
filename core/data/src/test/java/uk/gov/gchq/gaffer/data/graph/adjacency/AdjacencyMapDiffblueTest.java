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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class AdjacencyMapDiffblueTest {
  /**
   * Test {@link AdjacencyMap#getEdges(Object, Object)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#getEdges(Object, Object)}
   */
  @Test
  @DisplayName("Test getEdges(Object, Object); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.getEdges(Object, Object)"})
  void testGetEdges_thenReturnSizeIsOne() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge(
        "Source",
        "Destination",
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act and Assert
    assertEquals(1, adjacencyMap.getEdges("Source", "Destination").size());
  }

  /**
   * Test {@link AdjacencyMap#getEdges(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code Destination}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#getEdges(Object, Object)}
   */
  @Test
  @DisplayName("Test getEdges(Object, Object); when 'Destination'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.getEdges(Object, Object)"})
  void testGetEdges_whenDestination_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new AdjacencyMap().getEdges("Source", "Destination").isEmpty());
  }

  /**
   * Test {@link AdjacencyMap#getEdges(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#getEdges(Object, Object)}
   */
  @Test
  @DisplayName("Test getEdges(Object, Object); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.getEdges(Object, Object)"})
  void testGetEdges_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new AdjacencyMap().getEdges(null, null).isEmpty());
  }

  /**
   * Test {@link AdjacencyMap#getEdges(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#getEdges(Object, Object)}
   */
  @Test
  @DisplayName("Test getEdges(Object, Object); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.getEdges(Object, Object)"})
  void testGetEdges_whenNull_thenReturnEmpty2() {
    // Arrange, Act and Assert
    assertTrue(new AdjacencyMap().getEdges("Source", null).isEmpty());
  }

  /**
   * Test {@link AdjacencyMap#putEdges(Object, Object, Set)}.
   *
   * <p>Method under test: {@link AdjacencyMap#putEdges(Object, Object, Set)}
   */
  @Test
  @DisplayName("Test putEdges(Object, Object, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.putEdges(Object, Object, Set)"})
  void testPutEdges() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge(
        "Source",
        "Destination",
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    HashSet<Edge> set = new HashSet<>();
    set.add(
        new Builder()
            .dest(42)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    set.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Set<Edge> actualPutEdgesResult = adjacencyMap.putEdges("Source", "Destination", set);

    // Assert
    assertEquals(set, actualPutEdgesResult);
  }

  /**
   * Test {@link AdjacencyMap#putEdges(Object, Object, Set)}.
   *
   * <ul>
   *   <li>Then return {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#putEdges(Object, Object, Set)}
   */
  @Test
  @DisplayName("Test putEdges(Object, Object, Set); then return HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.putEdges(Object, Object, Set)"})
  void testPutEdges_thenReturnHashSet() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge(
        "Source",
        "Destination",
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    HashSet<Edge> set = new HashSet<>();
    set.add(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Set<Edge> actualPutEdgesResult = adjacencyMap.putEdges("Source", "Destination", set);

    // Assert
    assertEquals(set, actualPutEdgesResult);
  }

  /**
   * Test {@link AdjacencyMap#putEdges(Object, Object, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#putEdges(Object, Object, Set)}
   */
  @Test
  @DisplayName("Test putEdges(Object, Object, Set); when HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.putEdges(Object, Object, Set)"})
  void testPutEdges_whenHashSet_thenReturnEmpty() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();

    // Act and Assert
    assertTrue(adjacencyMap.putEdges("Source", "Destination", new HashSet<>()).isEmpty());
  }

  /**
   * Test {@link AdjacencyMap#putEdge(Object, Object, Edge)}.
   *
   * <ul>
   *   <li>Then {@link AdjacencyMap} (default constructor) AllDestinations size is two.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#putEdge(Object, Object, Edge)}
   */
  @Test
  @DisplayName(
      "Test putEdge(Object, Object, Edge); then AdjacencyMap (default constructor) AllDestinations size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.putEdge(Object, Object, Edge)"})
  void testPutEdge_thenAdjacencyMapAllDestinationsSizeIsTwo() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge(
        "Source",
        21,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act and Assert
    assertNull(adjacencyMap.putEdge("Source", "Destination", new Edge("Group")));
    assertEquals(1, adjacencyMap.getAllSources().size());
    assertEquals(2, adjacencyMap.getAllDestinations().size());
  }

  /**
   * Test {@link AdjacencyMap#putEdge(Object, Object, Edge)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#putEdge(Object, Object, Edge)}
   */
  @Test
  @DisplayName("Test putEdge(Object, Object, Edge); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.putEdge(Object, Object, Edge)"})
  void testPutEdge_thenReturnSizeIsTwo() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge(
        "Source",
        "Destination",
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    Set<Edge> actualPutEdgeResult =
        adjacencyMap.putEdge("Source", "Destination", new Edge("Group"));

    // Assert
    assertEquals(1, adjacencyMap.getAllDestinations().size());
    assertEquals(1, adjacencyMap.getAllSources().size());
    assertEquals(2, actualPutEdgeResult.size());
  }

  /**
   * Test {@link AdjacencyMap#putEdge(Object, Object, Edge)}.
   *
   * <ul>
   *   <li>When {@code Destination}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#putEdge(Object, Object, Edge)}
   */
  @Test
  @DisplayName("Test putEdge(Object, Object, Edge); when 'Destination'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.putEdge(Object, Object, Edge)"})
  void testPutEdge_whenDestination_thenReturnNull() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();

    // Act and Assert
    assertNull(adjacencyMap.putEdge("Source", "Destination", new Edge("Group")));
    assertEquals(1, adjacencyMap.getAllDestinations().size());
    assertEquals(1, adjacencyMap.getAllSources().size());
  }

  /**
   * Test {@link AdjacencyMap#getDestinations(Object)}.
   *
   * <ul>
   *   <li>When {@code Source}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#getDestinations(Object)}
   */
  @Test
  @DisplayName("Test getDestinations(Object); when 'Source'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.getDestinations(Object)"})
  void testGetDestinations_whenSource_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new AdjacencyMap().getDestinations("Source").isEmpty());
  }

  /**
   * Test {@link AdjacencyMap#getSources(Object)}.
   *
   * <ul>
   *   <li>When {@code Destination}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#getSources(Object)}
   */
  @Test
  @DisplayName("Test getSources(Object); when 'Destination'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.getSources(Object)"})
  void testGetSources_whenDestination_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new AdjacencyMap().getSources("Destination").isEmpty());
  }

  /**
   * Test {@link AdjacencyMap#getAllSources()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#getAllSources()}
   */
  @Test
  @DisplayName("Test getAllSources(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.getAllSources()"})
  void testGetAllSources_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new AdjacencyMap().getAllSources().isEmpty());
  }

  /**
   * Test {@link AdjacencyMap#getAllSources()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#getAllSources()}
   */
  @Test
  @DisplayName("Test getAllSources(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.getAllSources()"})
  void testGetAllSources_thenReturnSizeIsOne() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge(
        "Source",
        "Destination",
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act and Assert
    assertEquals(1, adjacencyMap.getAllSources().size());
  }

  /**
   * Test {@link AdjacencyMap#getAllDestinations()}.
   *
   * <p>Method under test: {@link AdjacencyMap#getAllDestinations()}
   */
  @Test
  @DisplayName("Test getAllDestinations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AdjacencyMap.getAllDestinations()"})
  void testGetAllDestinations() {
    // Arrange, Act and Assert
    assertTrue(new AdjacencyMap().getAllDestinations().isEmpty());
  }

  /**
   * Test {@link AdjacencyMap#removeAllWithDestination(Object)}.
   *
   * <ul>
   *   <li>Then {@link AdjacencyMap} (default constructor) AllDestinations Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#removeAllWithDestination(Object)}
   */
  @Test
  @DisplayName(
      "Test removeAllWithDestination(Object); then AdjacencyMap (default constructor) AllDestinations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdjacencyMap.removeAllWithDestination(Object)"})
  void testRemoveAllWithDestination_thenAdjacencyMapAllDestinationsEmpty() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();

    // Act
    adjacencyMap.removeAllWithDestination("Destination");

    // Assert that nothing has changed
    assertTrue(adjacencyMap.getAllDestinations().isEmpty());
    assertTrue(adjacencyMap.getAllSources().isEmpty());
  }

  /**
   * Test {@link AdjacencyMap#removeAllWithDestination(Object)}.
   *
   * <ul>
   *   <li>Then {@link AdjacencyMap} (default constructor) AllDestinations Empty.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#removeAllWithDestination(Object)}
   */
  @Test
  @DisplayName(
      "Test removeAllWithDestination(Object); then AdjacencyMap (default constructor) AllDestinations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdjacencyMap.removeAllWithDestination(Object)"})
  void testRemoveAllWithDestination_thenAdjacencyMapAllDestinationsEmpty2() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge(
        "Source",
        "Destination",
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    adjacencyMap.removeAllWithDestination("Destination");

    // Assert
    assertTrue(adjacencyMap.getAllDestinations().isEmpty());
    assertTrue(adjacencyMap.getAllSources().isEmpty());
  }

  /**
   * Test {@link AdjacencyMap#removeAllWithDestination(Object)}.
   *
   * <ul>
   *   <li>Then {@link AdjacencyMap} (default constructor) AllDestinations size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#removeAllWithDestination(Object)}
   */
  @Test
  @DisplayName(
      "Test removeAllWithDestination(Object); then AdjacencyMap (default constructor) AllDestinations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdjacencyMap.removeAllWithDestination(Object)"})
  void testRemoveAllWithDestination_thenAdjacencyMapAllDestinationsSizeIsOne() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge(
        "Source",
        42,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    adjacencyMap.putEdge(
        "Source",
        "Destination",
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    adjacencyMap.removeAllWithDestination("Destination");

    // Assert
    assertEquals(1, adjacencyMap.getAllDestinations().size());
    assertEquals(1, adjacencyMap.getAllSources().size());
  }

  /**
   * Test {@link AdjacencyMap#containsSource(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#containsSource(Object)}
   */
  @Test
  @DisplayName("Test containsSource(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdjacencyMap.containsSource(Object)"})
  void testContainsSource_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new AdjacencyMap().containsSource("Source"));
  }

  /**
   * Test {@link AdjacencyMap#containsSource(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#containsSource(Object)}
   */
  @Test
  @DisplayName("Test containsSource(Object); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdjacencyMap.containsSource(Object)"})
  void testContainsSource_thenReturnTrue() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge(
        "Source",
        "Destination",
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act and Assert
    assertTrue(adjacencyMap.containsSource("Source"));
  }

  /**
   * Test {@link AdjacencyMap#containsDestination(Object)}.
   *
   * <p>Method under test: {@link AdjacencyMap#containsDestination(Object)}
   */
  @Test
  @DisplayName("Test containsDestination(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdjacencyMap.containsDestination(Object)"})
  void testContainsDestination() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge(
        "Source",
        6,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act and Assert
    assertFalse(adjacencyMap.containsDestination("Destination"));
  }

  /**
   * Test {@link AdjacencyMap#containsDestination(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#containsDestination(Object)}
   */
  @Test
  @DisplayName("Test containsDestination(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdjacencyMap.containsDestination(Object)"})
  void testContainsDestination_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new AdjacencyMap().containsDestination("Destination"));
  }

  /**
   * Test {@link AdjacencyMap#containsDestination(Object)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMap#containsDestination(Object)}
   */
  @Test
  @DisplayName("Test containsDestination(Object); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdjacencyMap.containsDestination(Object)"})
  void testContainsDestination_thenReturnTrue() {
    // Arrange
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    adjacencyMap.putEdge(
        "Source",
        "Destination",
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act and Assert
    assertTrue(adjacencyMap.containsDestination("Destination"));
  }

  /**
   * Test new {@link AdjacencyMap} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AdjacencyMap}
   */
  @Test
  @DisplayName("Test new AdjacencyMap (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdjacencyMap.<init>()"})
  void testNewAdjacencyMap() {
    // Arrange and Act
    AdjacencyMap actualAdjacencyMap = new AdjacencyMap();

    // Assert
    assertTrue(actualAdjacencyMap.getAllDestinations().isEmpty());
    assertTrue(actualAdjacencyMap.getAllSources().isEmpty());
  }

  /**
   * Test {@link AdjacencyMap#toString()}.
   *
   * <p>Method under test: {@link AdjacencyMap#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AdjacencyMap.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("{}", new AdjacencyMap().toString());
  }
}
