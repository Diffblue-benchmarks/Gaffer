/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.data.element.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId.Matches;

class EntityIdDiffblueTest {
  /**
   * Test {@link EntityId#isRelated(EdgeId)} with {@code EdgeId}.
   *
   * <ul>
   *   <li>Given {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   *   <li>Then return {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link EntityId#isRelated(EdgeId)}
   */
  @Test
  @DisplayName(
      "Test isRelated(EdgeId) with 'EdgeId'; given Builder (default constructor) group 'Group' vertex 'Vertex' build; then return 'NONE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matches EntityId.isRelated(EdgeId)"})
  void testIsRelatedWithEdgeId_givenBuilderGroupGroupVertexVertexBuild_thenReturnNone() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    // Act
    Matches actualIsRelatedResult =
        entity.isRelated(
            (EdgeId)
                new Edge.Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build());

    // Assert
    assertEquals(Matches.NONE, actualIsRelatedResult);
  }

  /**
   * Test {@link EntityId#isRelated(ElementId)} with {@code ElementId}.
   *
   * <ul>
   *   <li>Given {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   * </ul>
   *
   * <p>Method under test: {@link EntityId#isRelated(ElementId)}
   */
  @Test
  @DisplayName(
      "Test isRelated(ElementId) with 'ElementId'; given Builder (default constructor) group 'Group' vertex 'Vertex' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matches EntityId.isRelated(ElementId)"})
  void testIsRelatedWithElementId_givenBuilderGroupGroupVertexVertexBuild() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    // Act
    Matches actualIsRelatedResult =
        entity.isRelated(
            (ElementId)
                new Edge.Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build());

    // Assert
    assertEquals(Matches.NONE, actualIsRelatedResult);
  }
}
