package uk.gov.gchq.gaffer.operation.graph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.operation.impl.get.GetAdjacentIds;

class GraphFiltersDiffblueTest {
  /**
   * Test Builder {@link GraphFilters.Builder#directedType(DirectedType)}.
   *
   * <p>Method under test: {@link GraphFilters.Builder#directedType(DirectedType)}
   */
  @Test
  @DisplayName("Test Builder directedType(DirectedType)")
  @Tag("MaintainedByDiffblue")
  void testBuilderDirectedType() {
    // Arrange
    GetAdjacentIds.Builder builder = new GetAdjacentIds.Builder();

    // Act
    GetAdjacentIds.Builder actualDirectedTypeResult = builder.directedType(DirectedType.EITHER);

    // Assert
    assertSame(builder, actualDirectedTypeResult);
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@link
   *       DirectedType#DIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName(
      "Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is DIRECTED")
  @Tag("MaintainedByDiffblue")
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsDirected() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.DIRECTED);

    // Act
    boolean actualValidateResult =
        getAdjacentIds.validate(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@link
   *       DirectedType#DIRECTED}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName(
      "Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is DIRECTED; when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsDirected_whenEdgeWithGroup() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.DIRECTED);

    // Act
    boolean actualValidateResult = getAdjacentIds.validate(new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@link
   *       DirectedType#EITHER}.
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName(
      "Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is EITHER; when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsEither_whenEdgeWithGroup() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.EITHER);

    // Act
    boolean actualValidateResult = getAdjacentIds.validate(new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@code null}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName(
      "Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is 'null'; when 'null'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsNull_whenNull() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(null);

    // Act and Assert
    assertFalse(getAdjacentIds.validate((Edge) null));
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@link
   *       DirectedType#UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName(
      "Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is UNDIRECTED")
  @Tag("MaintainedByDiffblue")
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsUndirected() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.UNDIRECTED);

    // Act
    boolean actualValidateResult = getAdjacentIds.validate(new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@link
   *       DirectedType#UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName(
      "Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is UNDIRECTED")
  @Tag("MaintainedByDiffblue")
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsUndirected2() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.UNDIRECTED);

    // Act
    boolean actualValidateResult =
        getAdjacentIds.validate(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName(
      "Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor); when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  void testValidateWithEdge_givenGetAdjacentIds_whenEdgeWithGroup() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act
    boolean actualValidateResult = getAdjacentIds.validate(new Edge("Group"));

    // Assert
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link GraphFilters#validateFlags(Edge)}.
   *
   * <p>Method under test: {@link GraphFilters#validateFlags(Edge)}
   */
  @Test
  @DisplayName("Test validateFlags(Edge)")
  @Tag("MaintainedByDiffblue")
  void testValidateFlags() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.DIRECTED);

    // Act
    boolean actualValidateFlagsResult =
        getAdjacentIds.validateFlags(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    assertTrue(actualValidateFlagsResult);
  }

  /**
   * Test {@link GraphFilters#validateFlags(Edge)}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@code DIRECTED}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validateFlags(Edge)}
   */
  @Test
  @DisplayName(
      "Test validateFlags(Edge); given GetAdjacentIds (default constructor) DirectedType is 'DIRECTED'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateFlags_givenGetAdjacentIdsDirectedTypeIsDirected_thenReturnFalse() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.DIRECTED);

    // Act
    boolean actualValidateFlagsResult = getAdjacentIds.validateFlags(new Edge("Group"));

    // Assert
    assertFalse(actualValidateFlagsResult);
  }

  /**
   * Test {@link GraphFilters#validateFlags(Edge)}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@code EITHER}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validateFlags(Edge)}
   */
  @Test
  @DisplayName(
      "Test validateFlags(Edge); given GetAdjacentIds (default constructor) DirectedType is 'EITHER'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testValidateFlags_givenGetAdjacentIdsDirectedTypeIsEither_thenReturnTrue() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.EITHER);

    // Act
    boolean actualValidateFlagsResult = getAdjacentIds.validateFlags(new Edge("Group"));

    // Assert
    assertTrue(actualValidateFlagsResult);
  }

  /**
   * Test {@link GraphFilters#validateFlags(Edge)}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@code UNDIRECTED}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validateFlags(Edge)}
   */
  @Test
  @DisplayName(
      "Test validateFlags(Edge); given GetAdjacentIds (default constructor) DirectedType is 'UNDIRECTED'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testValidateFlags_givenGetAdjacentIdsDirectedTypeIsUndirected_thenReturnTrue() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.UNDIRECTED);

    // Act
    boolean actualValidateFlagsResult = getAdjacentIds.validateFlags(new Edge("Group"));

    // Assert
    assertTrue(actualValidateFlagsResult);
  }

  /**
   * Test {@link GraphFilters#validateFlags(Edge)}.
   *
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validateFlags(Edge)}
   */
  @Test
  @DisplayName(
      "Test validateFlags(Edge); given GetAdjacentIds (default constructor); when Edge(String) with 'Group'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  void testValidateFlags_givenGetAdjacentIds_whenEdgeWithGroup_thenReturnTrue() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act
    boolean actualValidateFlagsResult = getAdjacentIds.validateFlags(new Edge("Group"));

    // Assert
    assertTrue(actualValidateFlagsResult);
  }

  /**
   * Test {@link GraphFilters#validateFlags(Edge)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validateFlags(Edge)}
   */
  @Test
  @DisplayName("Test validateFlags(Edge); then return 'false'")
  @Tag("MaintainedByDiffblue")
  void testValidateFlags_thenReturnFalse() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.UNDIRECTED);

    // Act
    boolean actualValidateFlagsResult =
        getAdjacentIds.validateFlags(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    assertFalse(actualValidateFlagsResult);
  }
}
