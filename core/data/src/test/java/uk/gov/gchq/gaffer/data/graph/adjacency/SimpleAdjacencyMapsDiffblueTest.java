package uk.gov.gchq.gaffer.data.graph.adjacency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List SimpleAdjacencyMaps.asList()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SimpleAdjacencyMaps.<init>()",
    "java.lang.String SimpleAdjacencyMaps.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SimpleAdjacencyMaps actualSimpleAdjacencyMaps = new SimpleAdjacencyMaps();
    actualSimpleAdjacencyMaps.toString();

    // Assert
    assertEquals(0, actualSimpleAdjacencyMaps.size());
  }
}
