package uk.gov.gchq.gaffer.data.graph.function.walk;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.graph.Walk;

class ExtractWalkEntitiesDiffblueTest {
  /**
   * Test {@link ExtractWalkEntities#apply(Walk)} with {@code Walk}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link ExtractWalkEntities#apply(Walk)}
   */
  @Test
  @DisplayName("Test apply(Walk) with 'Walk'; then return List")
  @Tag("MaintainedByDiffblue")
  void testApplyWithWalk_thenReturnList() {
    // Arrange
    ExtractWalkEntities extractWalkEntities = new ExtractWalkEntities();
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act
    Iterable<Set<Entity>> actualApplyResult = extractWalkEntities.apply(walk);
    Iterator<Set<Entity>> actualIteratorResult = actualApplyResult.iterator();

    // Assert
    assertTrue(actualApplyResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<Set<Entity>>) actualApplyResult).isEmpty());
  }
}
