package uk.gov.gchq.gaffer.data.graph;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.graph.adjacency.AdjacencyMaps;
import uk.gov.gchq.gaffer.data.graph.entity.EntityMaps;

class GraphWindowDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GraphWindow#GraphWindow(AdjacencyMaps, EntityMaps)}
   *   <li>{@link GraphWindow#getAdjacencyMaps()}
   *   <li>{@link GraphWindow#getEntityMaps()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GraphWindow.<init>(AdjacencyMaps, EntityMaps)",
    "AdjacencyMaps GraphWindow.getAdjacencyMaps()",
    "EntityMaps GraphWindow.getEntityMaps()"
  })
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
