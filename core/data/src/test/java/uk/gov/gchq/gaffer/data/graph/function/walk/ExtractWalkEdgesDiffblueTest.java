package uk.gov.gchq.gaffer.data.graph.function.walk;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.graph.Walk;

class ExtractWalkEdgesDiffblueTest {
  /**
   * Test {@link ExtractWalkEdges#apply(Walk)} with {@code Walk}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractWalkEdges#apply(Walk)}
   */
  @Test
  @DisplayName("Test apply(Walk) with 'Walk'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ExtractWalkEdges.apply(Walk)"})
  void testApplyWithWalk_thenReturnList() {
    // Arrange
    ExtractWalkEdges extractWalkEdges = new ExtractWalkEdges();
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act
    Iterable<Set<Edge>> actualApplyResult = extractWalkEdges.apply(walk);
    Iterator<Set<Edge>> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Set<Edge>>) actualApplyResult).isEmpty());
  }
}
