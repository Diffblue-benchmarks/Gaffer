package uk.gov.gchq.gaffer.data.element.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId.Matches;

class EdgeIdDiffblueTest {
  /**
   * Test {@link EdgeId#isDirected()}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#isDirected()}
   */
  @Test
  @DisplayName("Test isDirected(); given Edge(String) with 'Group'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testIsDirected_givenEdgeWithGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Edge("Group").isDirected());
  }

  /**
   * Test {@link EdgeId#isDirected()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#isDirected()}
   */
  @Test
  @DisplayName("Test isDirected(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testIsDirected_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build()
            .isDirected());
  }

  /**
   * Test {@link EdgeId#isUndirected()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#isUndirected()}
   */
  @Test
  @DisplayName("Test isUndirected(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testIsUndirected_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build()
            .isUndirected());
  }

  /**
   * Test MatchedVertex {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code DESTINATION}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test MatchedVertex isEqual(MatchedVertex, MatchedVertex); when 'DESTINATION'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testMatchedVertexIsEqual_whenDestination_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MatchedVertex.isEqual(MatchedVertex.DESTINATION, null));
  }

  /**
   * Test MatchedVertex {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code DESTINATION}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test MatchedVertex isEqual(MatchedVertex, MatchedVertex); when 'DESTINATION'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testMatchedVertexIsEqual_whenDestination_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(MatchedVertex.isEqual(null, MatchedVertex.DESTINATION));
  }

  /**
   * Test MatchedVertex {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code SOURCE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test MatchedVertex isEqual(MatchedVertex, MatchedVertex); when 'SOURCE'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testMatchedVertexIsEqual_whenSource_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MatchedVertex.isEqual(MatchedVertex.DESTINATION, MatchedVertex.SOURCE));
  }

  /**
   * Test MatchedVertex {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@code SOURCE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test MatchedVertex isEqual(MatchedVertex, MatchedVertex); when 'SOURCE'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testMatchedVertexIsEqual_whenSource_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MatchedVertex.isEqual(MatchedVertex.SOURCE, MatchedVertex.SOURCE));
  }

  /**
   * Test MatchedVertex {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@link MatchedVertex#SOURCE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test MatchedVertex isEqual(MatchedVertex, MatchedVertex); when SOURCE; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testMatchedVertexIsEqual_whenSource_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(MatchedVertex.isEqual(null, MatchedVertex.SOURCE));
  }

  /**
   * Test MatchedVertex {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}.
   *
   * <ul>
   *   <li>When {@link MatchedVertex#SOURCE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test MatchedVertex isEqual(MatchedVertex, MatchedVertex); when SOURCE; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testMatchedVertexIsEqual_whenSource_thenReturnTrue3() {
    // Arrange, Act and Assert
    assertTrue(MatchedVertex.isEqual(MatchedVertex.SOURCE, null));
  }

  /**
   * Test {@link EdgeId#setIdentifiers(Object, Object, DirectedType)} with {@code Object}, {@code
   * Object}, {@code DirectedType}.
   *
   * <p>Method under test: {@link EdgeId#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType) with 'Object', 'Object', 'DirectedType'")
  @Tag("MaintainedByDiffblue")
  void testSetIdentifiersWithObjectObjectDirectedType() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.EITHER);

    // Assert that nothing has changed
    assertEquals("Source", edge.getSource());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertFalse(edge.isUndirected());
    assertTrue(edge.isDirected());
  }

  /**
   * Test {@link EdgeId#setIdentifiers(Object, Object, DirectedType)} with {@code Object}, {@code
   * Object}, {@code DirectedType}.
   *
   * <ul>
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Source is {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType) with 'Object', 'Object', 'DirectedType'; then Edge(String) with 'Group' Source is 'Source'")
  @Tag("MaintainedByDiffblue")
  void testSetIdentifiersWithObjectObjectDirectedType_thenEdgeWithGroupSourceIsSource() {
    // Arrange
    Edge edge = new Edge("Group");

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.EITHER);

    // Assert
    assertEquals("Source", edge.getSource());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertFalse(edge.isUndirected());
    assertTrue(edge.isDirected());
  }

  /**
   * Test {@link EdgeId#isEqual(ElementId)} with {@code ElementId}.
   *
   * <p>Method under test: {@link EdgeId#isEqual(ElementId)}
   */
  @Test
  @DisplayName("Test isEqual(ElementId) with 'ElementId'")
  @Tag("MaintainedByDiffblue")
  void testIsEqualWithElementId() {
    // Arrange
    Edge edge =
        new Builder()
            .dest(null)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    boolean actualIsEqualResult =
        edge.isEqual(
            (ElementId)
                new Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build());

    // Assert
    assertFalse(actualIsEqualResult);
  }

  /**
   * Test {@link EdgeId#isRelated(ElementId)} with {@code ElementId}.
   *
   * <p>Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  @DisplayName("Test isRelated(ElementId) with 'ElementId'")
  @Tag("MaintainedByDiffblue")
  void testIsRelatedWithElementId() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    Entity that = new Entity("Group");
    that.setVertex(null);

    // Act
    Matches actualIsRelatedResult = edge.isRelated((ElementId) that);

    // Assert
    assertEquals(Matches.NONE, actualIsRelatedResult);
  }

  /**
   * Test {@link EdgeId#isRelated(ElementId)} with {@code ElementId}.
   *
   * <ul>
   *   <li>Then return {@code DESTINATION}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  @DisplayName("Test isRelated(ElementId) with 'ElementId'; then return 'DESTINATION'")
  @Tag("MaintainedByDiffblue")
  void testIsRelatedWithElementId_thenReturnDestination() {
    // Arrange
    Edge edge =
        new Builder()
            .dest(null)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    Entity that = new Entity("Group");
    that.setVertex(null);

    // Act
    Matches actualIsRelatedResult = edge.isRelated((ElementId) that);

    // Assert
    assertEquals(Matches.DESTINATION, actualIsRelatedResult);
  }

  /**
   * Test {@link EdgeId#isRelated(ElementId)} with {@code ElementId}.
   *
   * <ul>
   *   <li>Then return {@code SOURCE}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  @DisplayName("Test isRelated(ElementId) with 'ElementId'; then return 'SOURCE'")
  @Tag("MaintainedByDiffblue")
  void testIsRelatedWithElementId_thenReturnSource() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source(null)
            .build();

    Entity that = new Entity("Group");
    that.setVertex(null);

    // Act
    Matches actualIsRelatedResult = edge.isRelated((ElementId) that);

    // Assert
    assertEquals(Matches.SOURCE, actualIsRelatedResult);
  }

  /**
   * Test {@link EdgeId#isRelated(EntityId)} with {@code EntityId}.
   *
   * <ul>
   *   <li>Then return {@code DESTINATION}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#isRelated(EntityId)}
   */
  @Test
  @DisplayName("Test isRelated(EntityId) with 'EntityId'; then return 'DESTINATION'")
  @Tag("MaintainedByDiffblue")
  void testIsRelatedWithEntityId_thenReturnDestination() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Vertex")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    Matches actualIsRelatedResult =
        edge.isRelated((EntityId) new Entity.Builder().group("Group").vertex("Vertex").build());

    // Assert
    assertEquals(Matches.DESTINATION, actualIsRelatedResult);
  }

  /**
   * Test {@link EdgeId#isRelated(EntityId)} with {@code EntityId}.
   *
   * <ul>
   *   <li>Then return {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#isRelated(EntityId)}
   */
  @Test
  @DisplayName("Test isRelated(EntityId) with 'EntityId'; then return 'NONE'")
  @Tag("MaintainedByDiffblue")
  void testIsRelatedWithEntityId_thenReturnNone() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    Matches actualIsRelatedResult =
        edge.isRelated((EntityId) new Entity.Builder().group("Group").vertex("Vertex").build());

    // Assert
    assertEquals(Matches.NONE, actualIsRelatedResult);
  }

  /**
   * Test {@link EdgeId#isRelated(EntityId)} with {@code EntityId}.
   *
   * <ul>
   *   <li>Then return {@code SOURCE}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#isRelated(EntityId)}
   */
  @Test
  @DisplayName("Test isRelated(EntityId) with 'EntityId'; then return 'SOURCE'")
  @Tag("MaintainedByDiffblue")
  void testIsRelatedWithEntityId_thenReturnSource() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Vertex")
            .build();

    // Act
    Matches actualIsRelatedResult =
        edge.isRelated((EntityId) new Entity.Builder().group("Group").vertex("Vertex").build());

    // Assert
    assertEquals(Matches.SOURCE, actualIsRelatedResult);
  }

  /**
   * Test {@link EdgeId#getMatchedVertexValue()}.
   *
   * <ul>
   *   <li>Then return {@code Destination}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#getMatchedVertexValue()}
   */
  @Test
  @DisplayName("Test getMatchedVertexValue(); then return 'Destination'")
  @Tag("MaintainedByDiffblue")
  void testGetMatchedVertexValue_thenReturnDestination() {
    // Arrange
    Edge edge =
        new Edge(
            "Group", "Source", "Destination", true, MatchedVertex.DESTINATION, new Properties());

    // Act and Assert
    assertEquals("Destination", edge.getMatchedVertexValue());
  }

  /**
   * Test {@link EdgeId#getAdjacentMatchedVertexValue()}.
   *
   * <ul>
   *   <li>Then return {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#getAdjacentMatchedVertexValue()}
   */
  @Test
  @DisplayName("Test getAdjacentMatchedVertexValue(); then return 'Source'")
  @Tag("MaintainedByDiffblue")
  void testGetAdjacentMatchedVertexValue_thenReturnSource() {
    // Arrange
    Edge edge =
        new Edge(
            "Group", "Source", "Destination", true, MatchedVertex.DESTINATION, new Properties());

    // Act and Assert
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
  }
}
