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
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import uk.gov.gchq.gaffer.tinkerpop.GafferPopEdge;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopElement;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopVertex;

class GafferPopElementGeneratorDiffblueTest {
  /**
   * Test {@link GafferPopElementGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   *   <li>Then return {@link GafferPopVertex}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopElementGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); when Builder (default constructor) group 'Group' vertex 'Vertex' build; then return GafferPopVertex")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopElement GafferPopElementGenerator._apply(Element)"})
  void test_apply_whenBuilderGroupGroupVertexVertexBuild_thenReturnGafferPopVertex() {
    // Arrange
    GafferPopElementGenerator gafferPopElementGenerator = new GafferPopElementGenerator(null);

    // Act
    GafferPopElement actual_applyResult =
        gafferPopElementGenerator._apply(new Builder().group("Group").vertex("Vertex").build());

    // Assert
    assertTrue(actual_applyResult instanceof GafferPopVertex);
    assertEquals("Group", actual_applyResult.label());
    assertEquals("Vertex", actual_applyResult.id());
    assertNull(actual_applyResult.graph());
    assertTrue(actual_applyResult.isReadOnly());
  }

  /**
   * Test {@link GafferPopElementGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then id return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopElementGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); when Edge(String) with 'Group'; then id return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopElement GafferPopElementGenerator._apply(Element)"})
  void test_apply_whenEdgeWithGroup_thenIdReturnList() {
    // Arrange
    GafferPopElementGenerator gafferPopElementGenerator = new GafferPopElementGenerator(null);

    // Act
    GafferPopElement actual_applyResult = gafferPopElementGenerator._apply(new Edge("Group"));

    // Assert
    Object idResult = actual_applyResult.id();
    assertTrue(idResult instanceof List);
    assertTrue(actual_applyResult instanceof GafferPopEdge);
    Vertex inVertexResult = ((GafferPopEdge) actual_applyResult).inVertex();
    assertTrue(inVertexResult instanceof GafferPopVertex);
    Vertex outVertexResult = ((GafferPopEdge) actual_applyResult).outVertex();
    assertTrue(outVertexResult instanceof GafferPopVertex);
    assertEquals(3, ((List<String>) idResult).size());
    assertEquals("Group", ((List<String>) idResult).get(1));
    assertEquals("id", inVertexResult.label());
    assertEquals("id", outVertexResult.label());
    assertNull(inVertexResult.id());
    assertNull(outVertexResult.id());
    assertNull(((List<String>) idResult).get(0));
    assertNull(((List<String>) idResult).get(2));
    assertNull(inVertexResult.graph());
    assertNull(outVertexResult.graph());
    assertFalse(((GafferPopVertex) inVertexResult).isReadOnly());
    assertFalse(((GafferPopVertex) outVertexResult).isReadOnly());
  }

  /**
   * Test {@link GafferPopElementGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopElementGenerator#_apply(Element)}
   */
  @Test
  @DisplayName("Test _apply(Element); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopElement GafferPopElementGenerator._apply(Element)"})
  void test_apply_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new GafferPopElementGenerator(null)._apply(null));
  }
}
