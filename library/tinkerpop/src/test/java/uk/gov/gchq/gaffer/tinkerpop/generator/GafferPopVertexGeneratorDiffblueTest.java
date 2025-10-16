package uk.gov.gchq.gaffer.tinkerpop.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopVertex;

class GafferPopVertexGeneratorDiffblueTest {
  /**
   * Test {@link GafferPopVertexGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>Then return id is a string.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); then return id is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopVertex GafferPopVertexGenerator._apply(Element)"})
  void test_apply_thenReturnIdIsAString() {
    // Arrange
    GafferPopVertexGenerator gafferPopVertexGenerator = new GafferPopVertexGenerator(null);

    Entity element = new Entity("An Edge cannot be converted into a GafferPopVertex");
    element.setVertex(
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    // Act
    GafferPopVertex actual_applyResult = gafferPopVertexGenerator._apply(element);

    // Assert
    assertEquals("An Edge cannot be converted into a GafferPopVertex", actual_applyResult.label());
    assertEquals(
        "Edge[source=Source,destination=Dest,directed=true,matchedVertex=SOURCE,group=Group,properties"
            + "=Properties[]]",
        actual_applyResult.id());
    assertNull(actual_applyResult.graph());
    assertTrue(actual_applyResult.isReadOnly());
  }

  /**
   * Test {@link GafferPopVertexGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>Then return id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); then return id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopVertex GafferPopVertexGenerator._apply(Element)"})
  void test_apply_thenReturnIdIsNull() {
    // Arrange
    GafferPopVertexGenerator gafferPopVertexGenerator = new GafferPopVertexGenerator(null);

    Entity element = new Entity("An Edge cannot be converted into a GafferPopVertex");
    element.setVertex(null);

    // Act
    GafferPopVertex actual_applyResult = gafferPopVertexGenerator._apply(element);

    // Assert
    assertEquals("An Edge cannot be converted into a GafferPopVertex", actual_applyResult.label());
    assertNull(actual_applyResult.id());
    assertNull(actual_applyResult.graph());
    assertTrue(actual_applyResult.isReadOnly());
  }

  /**
   * Test {@link GafferPopVertexGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   *   <li>Then return label is {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); when Builder (default constructor) group 'Group' vertex 'Vertex' build; then return label is 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopVertex GafferPopVertexGenerator._apply(Element)"})
  void test_apply_whenBuilderGroupGroupVertexVertexBuild_thenReturnLabelIsGroup() {
    // Arrange
    GafferPopVertexGenerator gafferPopVertexGenerator = new GafferPopVertexGenerator(null);

    // Act
    GafferPopVertex actual_applyResult =
        gafferPopVertexGenerator._apply(new Builder().group("Group").vertex("Vertex").build());

    // Assert
    assertEquals("Group", actual_applyResult.label());
    assertEquals("Vertex", actual_applyResult.id());
    assertNull(actual_applyResult.graph());
    assertTrue(actual_applyResult.isReadOnly());
  }

  /**
   * Test {@link GafferPopVertexGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); when Edge(String) with 'Group'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopVertex GafferPopVertexGenerator._apply(Element)"})
  void test_apply_whenEdgeWithGroup_thenThrowIllegalArgumentException() {
    // Arrange
    GafferPopVertexGenerator gafferPopVertexGenerator = new GafferPopVertexGenerator(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> gafferPopVertexGenerator._apply(new Edge("Group")));
  }
}
