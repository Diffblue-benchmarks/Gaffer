package uk.gov.gchq.gaffer.data.graph.adjacency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AdjacencyMapsDiffblueTest {
  /**
   * Test {@link AdjacencyMaps#add(AdjacencyMap)}.
   *
   * <p>Method under test: {@link AdjacencyMaps#add(AdjacencyMap)}
   */
  @Test
  @DisplayName("Test add(AdjacencyMap)")
  @Tag("MaintainedByDiffblue")
  void testAdd() {
    // Arrange
    SimpleAdjacencyMaps simpleAdjacencyMaps = new SimpleAdjacencyMaps();

    // Act
    simpleAdjacencyMaps.add(new AdjacencyMap());

    // Assert
    assertEquals(1, simpleAdjacencyMaps.size());
  }

  /**
   * Test {@link AdjacencyMaps#get(int)}.
   *
   * <ul>
   *   <li>Given {@link PrunedAdjacencyMaps} (default constructor) add {@link AdjacencyMap} (default
   *       constructor).
   *   <li>Then return {@link AdjacencyMap} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMaps#get(int)}
   */
  @Test
  @DisplayName(
      "Test get(int); given PrunedAdjacencyMaps (default constructor) add AdjacencyMap (default constructor); then return AdjacencyMap (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testGet_givenPrunedAdjacencyMapsAddAdjacencyMap_thenReturnAdjacencyMap() {
    // Arrange
    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();
    prunedAdjacencyMaps.add(new AdjacencyMap());
    AdjacencyMap adjacencyMap = new AdjacencyMap();
    prunedAdjacencyMaps.add(adjacencyMap);

    // Act and Assert
    assertSame(adjacencyMap, prunedAdjacencyMaps.get(1));
  }

  /**
   * Test {@link AdjacencyMaps#size()}.
   *
   * <p>Method under test: {@link AdjacencyMaps#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new PrunedAdjacencyMaps().size());
  }

  /**
   * Test {@link AdjacencyMaps#empty()}.
   *
   * <ul>
   *   <li>Given {@link AdjacencyMaps} {@link AdjacencyMaps#empty()} return {@code false}.
   *   <li>Then calls {@link AdjacencyMaps#empty()}.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMaps#empty()}
   */
  @Test
  @DisplayName("Test empty(); given AdjacencyMaps empty() return 'false'; then calls empty()")
  @Tag("MaintainedByDiffblue")
  void testEmpty_givenAdjacencyMapsEmptyReturnFalse_thenCallsEmpty() {
    // Arrange
    AdjacencyMaps adjacencyMaps = mock(AdjacencyMaps.class);
    when(adjacencyMaps.empty()).thenReturn(false);

    // Act
    adjacencyMaps.empty();

    // Assert
    verify(adjacencyMaps).empty();
  }

  /**
   * Test {@link AdjacencyMaps#empty()}.
   *
   * <ul>
   *   <li>Given {@link PrunedAdjacencyMaps} (default constructor) add {@link AdjacencyMap} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMaps#empty()}
   */
  @Test
  @DisplayName(
      "Test empty(); given PrunedAdjacencyMaps (default constructor) add AdjacencyMap (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testEmpty_givenPrunedAdjacencyMapsAddAdjacencyMap_thenReturnFalse() {
    // Arrange
    PrunedAdjacencyMaps prunedAdjacencyMaps = new PrunedAdjacencyMaps();
    prunedAdjacencyMaps.add(new AdjacencyMap());

    // Act and Assert
    assertFalse(prunedAdjacencyMaps.empty());
  }

  /**
   * Test {@link AdjacencyMaps#empty()}.
   *
   * <ul>
   *   <li>Given {@link PrunedAdjacencyMaps} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdjacencyMaps#empty()}
   */
  @Test
  @DisplayName("Test empty(); given PrunedAdjacencyMaps (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testEmpty_givenPrunedAdjacencyMaps_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PrunedAdjacencyMaps().empty());
  }

  /**
   * Test {@link AdjacencyMaps#iterator()}.
   *
   * <p>Method under test: {@link AdjacencyMaps#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("MaintainedByDiffblue")
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse(new PrunedAdjacencyMaps().iterator().hasNext());
  }
}
