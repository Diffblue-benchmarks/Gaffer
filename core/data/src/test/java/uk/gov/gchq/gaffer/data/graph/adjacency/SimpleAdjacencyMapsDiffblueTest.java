package uk.gov.gchq.gaffer.data.graph.adjacency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SimpleAdjacencyMapsDiffblueTest {
  /**
   * Test {@link SimpleAdjacencyMaps#asList()}.
   *
   * <p>Method under test: {@link SimpleAdjacencyMaps#asList()}
   */
  @Test
  @DisplayName("Test asList()")
  @Tag("MaintainedByDiffblue")
  void testAsList() {
    // Arrange, Act and Assert
    assertTrue(new SimpleAdjacencyMaps().asList().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SimpleAdjacencyMaps}
   *   <li>{@link SimpleAdjacencyMaps#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    SimpleAdjacencyMaps actualSimpleAdjacencyMaps = new SimpleAdjacencyMaps();
    actualSimpleAdjacencyMaps.toString();

    // Assert
    assertEquals(0, actualSimpleAdjacencyMaps.size());
  }
}
