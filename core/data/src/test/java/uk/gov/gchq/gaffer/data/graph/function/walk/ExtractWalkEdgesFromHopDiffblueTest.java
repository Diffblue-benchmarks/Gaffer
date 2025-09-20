package uk.gov.gchq.gaffer.data.graph.function.walk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.graph.Walk;

class ExtractWalkEdgesFromHopDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtractWalkEdgesFromHop#ExtractWalkEdgesFromHop()}
   *   <li>{@link ExtractWalkEdgesFromHop#setHop(int)}
   *   <li>{@link ExtractWalkEdgesFromHop#getHop()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    ExtractWalkEdgesFromHop actualExtractWalkEdgesFromHop = new ExtractWalkEdgesFromHop();
    actualExtractWalkEdgesFromHop.setHop(1);

    // Assert
    assertEquals(1, actualExtractWalkEdgesFromHop.getHop());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExtractWalkEdgesFromHop#ExtractWalkEdgesFromHop(int)}
   *   <li>{@link ExtractWalkEdgesFromHop#setHop(int)}
   *   <li>{@link ExtractWalkEdgesFromHop#getHop()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters_whenOne() {
    // Arrange and Act
    ExtractWalkEdgesFromHop actualExtractWalkEdgesFromHop = new ExtractWalkEdgesFromHop(1);
    actualExtractWalkEdgesFromHop.setHop(1);

    // Assert
    assertEquals(1, actualExtractWalkEdgesFromHop.getHop());
  }

  /**
   * Test {@link ExtractWalkEdgesFromHop#apply(Walk)} with {@code Walk}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ExtractWalkEdgesFromHop#apply(Walk)}
   */
  @Test
  @DisplayName(
      "Test apply(Walk) with 'Walk'; given HashSet(); when ArrayList() add HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  void testApplyWithWalk_givenHashSet_whenArrayListAddHashSet_thenReturnEmpty() {
    // Arrange
    ExtractWalkEdgesFromHop extractWalkEdgesFromHop = new ExtractWalkEdgesFromHop(1);

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(new HashSet<>());
    edges.add(new HashSet<>());
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertTrue(extractWalkEdgesFromHop.apply(walk).isEmpty());
  }

  /**
   * Test {@link ExtractWalkEdgesFromHop#apply(Walk)} with {@code Walk}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractWalkEdgesFromHop#apply(Walk)}
   */
  @Test
  @DisplayName("Test apply(Walk) with 'Walk'; when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  void testApplyWithWalk_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ExtractWalkEdgesFromHop(1).apply(null));
  }
}
