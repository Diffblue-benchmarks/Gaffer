package uk.gov.gchq.gaffer.federated;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;

class ToElementSeedDiffblueTest {
  /**
   * Test {@link ToElementSeed#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with group is {@code |Edge}.
   *   <li>Then return {@link EdgeSeed}.
   * </ul>
   *
   * <p>Method under test: {@link ToElementSeed#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; when Edge(String) with group is '|Edge'; then return EdgeSeed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementId ToElementSeed.apply(Element)"})
  void testApplyWithElement_whenEdgeWithGroupIsEdge_thenReturnEdgeSeed() {
    // Arrange
    ToElementSeed toElementSeed = new ToElementSeed();

    // Act
    ElementId actualApplyResult = toElementSeed.apply(new Edge("|Edge"));

    // Assert
    assertTrue(actualApplyResult instanceof EdgeSeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EdgeSeed", actualApplyResult.getClassName());
    assertNull(((EdgeSeed) actualApplyResult).getAdjacentMatchedVertexValue());
    assertNull(((EdgeSeed) actualApplyResult).getMatchedVertexValue());
    assertNull(((EdgeSeed) actualApplyResult).getDestination());
    assertNull(((EdgeSeed) actualApplyResult).getSource());
    assertEquals(DirectedType.UNDIRECTED, ((EdgeSeed) actualApplyResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((EdgeSeed) actualApplyResult).getMatchedVertex());
    assertFalse(((EdgeSeed) actualApplyResult).isDirected());
    assertTrue(((EdgeSeed) actualApplyResult).isUndirected());
  }

  /**
   * Test {@link ToElementSeed#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then return {@link EntitySeed}.
   * </ul>
   *
   * <p>Method under test: {@link ToElementSeed#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; when Entity(String) with 'Group'; then return EntitySeed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementId ToElementSeed.apply(Element)"})
  void testApplyWithElement_whenEntityWithGroup_thenReturnEntitySeed() {
    // Arrange
    ToElementSeed toElementSeed = new ToElementSeed();

    // Act
    ElementId actualApplyResult = toElementSeed.apply(new Entity("Group"));

    // Assert
    assertTrue(actualApplyResult instanceof EntitySeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EntitySeed", actualApplyResult.getClassName());
    assertNull(((EntitySeed) actualApplyResult).getVertex());
  }
}
