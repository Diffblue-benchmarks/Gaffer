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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.tinkerpop.GafferPopVertex;

class GafferPopVertexGeneratorDiffblueTest {
  /**
   * Test {@link GafferPopVertexGenerator#_apply(Element)}.
   *
   * <ul>
   *   <li>Then return label is {@code An Edge cannot be converted into a GafferPopVertex}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertexGenerator#_apply(Element)}
   */
  @Test
  @DisplayName(
      "Test _apply(Element); then return label is 'An Edge cannot be converted into a GafferPopVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GafferPopVertex GafferPopVertexGenerator._apply(Element)"})
  void test_apply_thenReturnLabelIsAnEdgeCannotBeConvertedIntoAGafferPopVertex() {
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
