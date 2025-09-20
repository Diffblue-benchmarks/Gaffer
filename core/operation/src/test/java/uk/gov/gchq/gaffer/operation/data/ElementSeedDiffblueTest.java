package uk.gov.gchq.gaffer.operation.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.element.id.EntityId;

class ElementSeedDiffblueTest {
  /**
   * Test {@link ElementSeed#createSeed(EdgeId)} with {@code edgeId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(EdgeId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(EdgeId) with 'edgeId'; then return AdjacentMatchedVertexValue is 'Dest'")
  @Tag("MaintainedByDiffblue")
  void testCreateSeedWithEdgeId_thenReturnAdjacentMatchedVertexValueIsDest() {
    // Arrange
    Edge edgeId =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    EdgeSeed actualCreateSeedResult = ElementSeed.createSeed((EdgeId) edgeId);

    // Assert
    assertEquals("Dest", actualCreateSeedResult.getAdjacentMatchedVertexValue());
    assertEquals("Dest", actualCreateSeedResult.getDestination());
    assertEquals("Source", actualCreateSeedResult.getMatchedVertexValue());
    assertEquals("Source", actualCreateSeedResult.getSource());
    assertEquals(DirectedType.DIRECTED, actualCreateSeedResult.getDirectedType());
    assertFalse(actualCreateSeedResult.isUndirected());
    assertTrue(actualCreateSeedResult.isDirected());
  }

  /**
   * Test {@link ElementSeed#createSeed(EdgeId)} with {@code edgeId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(EdgeId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(EdgeId) with 'edgeId'; then return AdjacentMatchedVertexValue is 'null'")
  @Tag("MaintainedByDiffblue")
  void testCreateSeedWithEdgeId_thenReturnAdjacentMatchedVertexValueIsNull() {
    // Arrange and Act
    EdgeSeed actualCreateSeedResult = ElementSeed.createSeed((EdgeId) new Edge("Group"));

    // Assert
    assertNull(actualCreateSeedResult.getAdjacentMatchedVertexValue());
    assertNull(actualCreateSeedResult.getMatchedVertexValue());
    assertNull(actualCreateSeedResult.getDestination());
    assertNull(actualCreateSeedResult.getSource());
    assertEquals(DirectedType.UNDIRECTED, actualCreateSeedResult.getDirectedType());
    assertFalse(actualCreateSeedResult.isDirected());
    assertTrue(actualCreateSeedResult.isUndirected());
  }

  /**
   * Test {@link ElementSeed#createSeed(EdgeId)} with {@code edgeId}.
   *
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.
   *   <li>Then return {@link EdgeSeed#EdgeSeed()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(EdgeId)}
   */
  @Test
  @DisplayName("Test createSeed(EdgeId) with 'edgeId'; when EdgeSeed(); then return EdgeSeed()")
  @Tag("MaintainedByDiffblue")
  void testCreateSeedWithEdgeId_whenEdgeSeed_thenReturnEdgeSeed() {
    // Arrange
    EdgeSeed edgeId = new EdgeSeed();

    // Act
    EdgeSeed actualCreateSeedResult = ElementSeed.createSeed((EdgeId) edgeId);

    // Assert
    assertEquals(edgeId, actualCreateSeedResult);
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; then return AdjacentMatchedVertexValue is 'Dest'")
  @Tag("MaintainedByDiffblue")
  void testCreateSeedWithElementId_thenReturnAdjacentMatchedVertexValueIsDest() {
    // Arrange
    Edge elementId =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals("Dest", ((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue());
    assertEquals("Dest", ((EdgeSeed) actualCreateSeedResult).getDestination());
    assertEquals("Source", ((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue());
    assertEquals("Source", ((EdgeSeed) actualCreateSeedResult).getSource());
    assertEquals(DirectedType.DIRECTED, ((EdgeSeed) actualCreateSeedResult).getDirectedType());
    assertFalse(((EdgeSeed) actualCreateSeedResult).isUndirected());
    assertTrue(((EdgeSeed) actualCreateSeedResult).isDirected());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; then return AdjacentMatchedVertexValue is 'null'")
  @Tag("MaintainedByDiffblue")
  void testCreateSeedWithElementId_thenReturnAdjacentMatchedVertexValueIsNull() {
    // Arrange and Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) new Edge("Group"));

    // Assert
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertNull(((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue());
    assertNull(((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue());
    assertNull(((EdgeSeed) actualCreateSeedResult).getDestination());
    assertNull(((EdgeSeed) actualCreateSeedResult).getSource());
    assertEquals(DirectedType.UNDIRECTED, ((EdgeSeed) actualCreateSeedResult).getDirectedType());
    assertFalse(((EdgeSeed) actualCreateSeedResult).isDirected());
    assertTrue(((EdgeSeed) actualCreateSeedResult).isUndirected());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.
   *   <li>Then return {@link EdgeSeed#EdgeSeed()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; when EdgeSeed(); then return EdgeSeed()")
  @Tag("MaintainedByDiffblue")
  void testCreateSeedWithElementId_whenEdgeSeed_thenReturnEdgeSeed() {
    // Arrange
    EdgeSeed elementId = new EdgeSeed();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals(elementId, actualCreateSeedResult);
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   *   <li>Then return {@link EntitySeed}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; when EntitySeed(); then return EntitySeed")
  @Tag("MaintainedByDiffblue")
  void testCreateSeedWithElementId_whenEntitySeed_thenReturnEntitySeed() {
    // Arrange
    EntitySeed elementId = new EntitySeed();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    assertTrue(actualCreateSeedResult instanceof EntitySeed);
    assertEquals(elementId, actualCreateSeedResult);
  }

  /**
   * Test {@link ElementSeed#createSeed(EntityId)} with {@code entityId}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   *   <li>Then return {@link EntitySeed#EntitySeed()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(EntityId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(EntityId) with 'entityId'; when EntitySeed(); then return EntitySeed()")
  @Tag("MaintainedByDiffblue")
  void testCreateSeedWithEntityId_whenEntitySeed_thenReturnEntitySeed() {
    // Arrange
    EntitySeed entityId = new EntitySeed();

    // Act
    EntitySeed actualCreateSeedResult = ElementSeed.createSeed((EntityId) entityId);

    // Assert
    assertEquals(entityId, actualCreateSeedResult);
  }
}
