/*
 * Copyright 2025 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.gchq.gaffer.operation.data.generator;

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
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.operation.data.EdgeSeed;

class EdgeIdExtractorDiffblueTest {
  /**
   * Test {@link EdgeIdExtractor#_apply(Edge)} with {@code Edge}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdExtractor#_apply(Edge)}
   */
  @Test
  @DisplayName("Test _apply(Edge) with 'Edge'; then return AdjacentMatchedVertexValue is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeId EdgeIdExtractor._apply(Edge)"})
  void test_applyWithEdge_thenReturnAdjacentMatchedVertexValueIsDest() {
    // Arrange
    EdgeIdExtractor edgeIdExtractor = new EdgeIdExtractor();

    // Act
    EdgeId actual_applyResult =
        edgeIdExtractor._apply(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    assertTrue(actual_applyResult instanceof EdgeSeed);
    assertEquals("Dest", actual_applyResult.getAdjacentMatchedVertexValue());
    assertEquals("Dest", actual_applyResult.getDestination());
    assertEquals("Source", actual_applyResult.getMatchedVertexValue());
    assertEquals("Source", actual_applyResult.getSource());
    assertEquals(DirectedType.DIRECTED, actual_applyResult.getDirectedType());
    assertFalse(actual_applyResult.isUndirected());
    assertTrue(actual_applyResult.isDirected());
  }

  /**
   * Test {@link EdgeIdExtractor#_apply(Edge)} with {@code Edge}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return AdjacentMatchedVertexValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdExtractor#_apply(Edge)}
   */
  @Test
  @DisplayName(
      "Test _apply(Edge) with 'Edge'; when Edge(String) with 'Group'; then return AdjacentMatchedVertexValue is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeId EdgeIdExtractor._apply(Edge)"})
  void test_applyWithEdge_whenEdgeWithGroup_thenReturnAdjacentMatchedVertexValueIsNull() {
    // Arrange
    EdgeIdExtractor edgeIdExtractor = new EdgeIdExtractor();

    // Act
    EdgeId actual_applyResult = edgeIdExtractor._apply(new Edge("Group"));

    // Assert
    assertTrue(actual_applyResult instanceof EdgeSeed);
    assertNull(actual_applyResult.getAdjacentMatchedVertexValue());
    assertNull(actual_applyResult.getDestination());
    assertNull(actual_applyResult.getMatchedVertexValue());
    assertNull(actual_applyResult.getSource());
    assertEquals(DirectedType.UNDIRECTED, actual_applyResult.getDirectedType());
    assertFalse(actual_applyResult.isDirected());
    assertTrue(actual_applyResult.isUndirected());
  }

  /**
   * Test {@link EdgeIdExtractor#_apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdExtractor#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element) with 'Element'; then return AdjacentMatchedVertexValue is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeId EdgeIdExtractor._apply(Element)"})
  void test_applyWithElement_thenReturnAdjacentMatchedVertexValueIsDest() {
    // Arrange
    EdgeIdExtractor edgeIdExtractor = new EdgeIdExtractor();

    // Act
    EdgeId actual_applyResult =
        edgeIdExtractor._apply(
            (Element)
                new Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build());

    // Assert
    assertTrue(actual_applyResult instanceof EdgeSeed);
    assertEquals("Dest", actual_applyResult.getAdjacentMatchedVertexValue());
    assertEquals("Dest", actual_applyResult.getDestination());
    assertEquals("Source", actual_applyResult.getMatchedVertexValue());
    assertEquals("Source", actual_applyResult.getSource());
    assertEquals(DirectedType.DIRECTED, actual_applyResult.getDirectedType());
    assertFalse(actual_applyResult.isUndirected());
    assertTrue(actual_applyResult.isDirected());
  }

  /**
   * Test {@link EdgeIdExtractor#_apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeIdExtractor#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element) with 'Element'; then return AdjacentMatchedVertexValue is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeId EdgeIdExtractor._apply(Element)"})
  void test_applyWithElement_thenReturnAdjacentMatchedVertexValueIsNull() {
    // Arrange
    EdgeIdExtractor edgeIdExtractor = new EdgeIdExtractor();

    // Act
    EdgeId actual_applyResult = edgeIdExtractor._apply((Element) new Edge("Group"));

    // Assert
    assertTrue(actual_applyResult instanceof EdgeSeed);
    assertNull(actual_applyResult.getAdjacentMatchedVertexValue());
    assertNull(actual_applyResult.getDestination());
    assertNull(actual_applyResult.getMatchedVertexValue());
    assertNull(actual_applyResult.getSource());
    assertEquals(DirectedType.UNDIRECTED, actual_applyResult.getDirectedType());
    assertFalse(actual_applyResult.isDirected());
    assertTrue(actual_applyResult.isUndirected());
  }
}
