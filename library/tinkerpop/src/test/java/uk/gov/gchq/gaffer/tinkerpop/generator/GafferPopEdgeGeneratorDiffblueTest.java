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

package uk.gov.gchq.gaffer.tinkerpop.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopEdge;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopVertex;

class GafferPopEdgeGeneratorDiffblueTest {
  /**
   * Test {@link GafferPopEdgeGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>Then return id third is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdgeGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); then return id third is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopEdge GafferPopEdgeGenerator._apply(Element)"})
  void test_apply_thenReturnIdThirdIsDest() {
    // Arrange
    GafferPopEdgeGenerator gafferPopEdgeGenerator = new GafferPopEdgeGenerator(null);

    // Act
    GafferPopEdge actual_applyResult =
        gafferPopEdgeGenerator._apply(
            new Edge.Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    Object idResult = actual_applyResult.id();
    assertTrue(idResult instanceof List);
    Vertex inVertexResult = actual_applyResult.inVertex();
    assertTrue(inVertexResult instanceof GafferPopVertex);
    Vertex outVertexResult = actual_applyResult.outVertex();
    assertTrue(outVertexResult instanceof GafferPopVertex);
    assertEquals(3, ((List<String>) idResult).size());
    assertEquals("Dest", ((List<String>) idResult).get(2));
    assertEquals("Dest", inVertexResult.id());
    assertEquals("Source", ((List<String>) idResult).get(0));
    assertEquals("Source", outVertexResult.id());
  }

  /**
   * Test {@link GafferPopEdgeGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdgeGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopEdge GafferPopEdgeGenerator._apply(Element)"})
  void test_apply_thenThrowIllegalArgumentException() {
    // Arrange
    GafferPopEdgeGenerator gafferPopEdgeGenerator = new GafferPopEdgeGenerator(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> gafferPopEdgeGenerator._apply(new Builder().group("Group").vertex("Vertex").build()));
  }

  /**
   * Test {@link GafferPopEdgeGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return inVertex id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopEdgeGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); when Edge(String) with 'Group'; then return inVertex id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopEdge GafferPopEdgeGenerator._apply(Element)"})
  void test_apply_whenEdgeWithGroup_thenReturnInVertexIdIsNull() {
    // Arrange
    GafferPopEdgeGenerator gafferPopEdgeGenerator = new GafferPopEdgeGenerator(null);

    // Act
    GafferPopEdge actual_applyResult = gafferPopEdgeGenerator._apply(new Edge("Group"));

    // Assert
    Object idResult = actual_applyResult.id();
    assertTrue(idResult instanceof List);
    Vertex inVertexResult = actual_applyResult.inVertex();
    assertTrue(inVertexResult instanceof GafferPopVertex);
    Vertex outVertexResult = actual_applyResult.outVertex();
    assertTrue(outVertexResult instanceof GafferPopVertex);
    assertNull(inVertexResult.id());
    assertNull(outVertexResult.id());
    assertEquals(3, ((List<String>) idResult).size());
    assertNull(((List<String>) idResult).get(0));
    assertNull(((List<String>) idResult).get(2));
  }
}
