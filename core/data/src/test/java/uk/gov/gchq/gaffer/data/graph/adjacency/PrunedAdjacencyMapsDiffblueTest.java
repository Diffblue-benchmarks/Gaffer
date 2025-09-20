package uk.gov.gchq.gaffer.data.graph.adjacency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class PrunedAdjacencyMapsDiffblueTest {
  /**
   * Test {@link PrunedAdjacencyMaps#add(AdjacencyMap)}.
   *
   * <ul>
   *   <li>Given {@link PrunedAdjacencyMaps} (default constructor) add {@link AdjacencyMap} (default
   *       constructor).
   *   <li>Then {@link PrunedAdjacencyMaps} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link PrunedAdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  @DisplayName(
      "Test add(AdjacencyMap); given PrunedAdjacencyMaps (default constructor) add AdjacencyMap (default constructor); then PrunedAdjacencyMaps (default constructor) size is two")
  @Tag("MaintainedByDiffblue")
  void testAdd_givenPrunedAdjacencyMapsAddAdjacencyMap_thenPrunedAdjacencyMapsSizeIsTwo() {
    // Arrange
    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Act
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Assert
    assertEquals(2, prunedAdjacencyMaps.size());
  }

  /**
   * Test {@link PrunedAdjacencyMaps#add(AdjacencyMap)}.
   *
   * <ul>
   *   <li>Given {@link PrunedAdjacencyMaps} (default constructor).
   *   <li>Then {@link PrunedAdjacencyMaps} (default constructor) size is one.
   * </ul>
   *
   * <p>Method under test: {@link PrunedAdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  @DisplayName(
      "Test add(AdjacencyMap); given PrunedAdjacencyMaps (default constructor); then PrunedAdjacencyMaps (default constructor) size is one")
  @Tag("MaintainedByDiffblue")
  void testAdd_givenPrunedAdjacencyMaps_thenPrunedAdjacencyMapsSizeIsOne() {
    // Arrange
    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();

    // Act
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Assert
    assertEquals(1, prunedAdjacencyMaps.size());
  }

  /**
   * Test {@link PrunedAdjacencyMaps#add(AdjacencyMap)}.
   *
   * <ul>
   *   <li>Then {@link PrunedAdjacencyMaps} (default constructor) size is two.
   * </ul>
   *
   * <p>Method under test: {@link PrunedAdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  @DisplayName("Test add(AdjacencyMap); then PrunedAdjacencyMaps (default constructor) size is two")
  @Tag("MaintainedByDiffblue")
  void testAdd_thenPrunedAdjacencyMapsSizeIsTwo() {
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

    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();
    prunedAdjacencyMaps.add(adjacencyMap);

    // Act
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Assert
    assertEquals(2, prunedAdjacencyMaps.size());
  }

  /**
   * Test {@link PrunedAdjacencyMaps#asList()}.
   *
   * <p>Method under test: {@link PrunedAdjacencyMaps#asList()}
   */
  @Test
  @DisplayName("Test asList()")
  @Tag("MaintainedByDiffblue")
  void testAsList() {
    // Arrange, Act and Assert
    assertTrue(new PrunedAdjacencyMaps().asList().isEmpty());
  }

  /**
   * Test new {@link PrunedAdjacencyMaps} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PrunedAdjacencyMaps}
   */
  @Test
  @DisplayName("Test new PrunedAdjacencyMaps (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewPrunedAdjacencyMaps() {
    // Arrange, Act and Assert
    assertEquals(0, new PrunedAdjacencyMaps().size());
  }
}
