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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeId.isUndirected()"})
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
   * Test {@link EdgeId#isEqual(ElementId)} with {@code ElementId}.
   *
   * <p>Method under test: {@link EdgeId#isEqual(ElementId)}
   */
  @Test
  @DisplayName("Test isEqual(ElementId) with 'ElementId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeId.isEqual(ElementId)"})
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
   * <ul>
   *   <li>Given {@code Dest}.
   *   <li>Then return {@code DESTINATION}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  @DisplayName(
      "Test isRelated(ElementId) with 'ElementId'; given 'Dest'; then return 'DESTINATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matches EdgeId.isRelated(ElementId)"})
  void testIsRelatedWithElementId_givenDest_thenReturnDestination() {
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
    that.setVertex("Dest");

    // Act
    Matches actualIsRelatedResult = edge.isRelated((ElementId) that);

    // Assert
    assertEquals(Matches.DESTINATION, actualIsRelatedResult);
  }

  /**
   * Test {@link EdgeId#isRelated(ElementId)} with {@code ElementId}.
   *
   * <ul>
   *   <li>Given {@code Source}.
   *   <li>Then return {@code SOURCE}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  @DisplayName("Test isRelated(ElementId) with 'ElementId'; given 'Source'; then return 'SOURCE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matches EdgeId.isRelated(ElementId)"})
  void testIsRelatedWithElementId_givenSource_thenReturnSource() {
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
    that.setVertex("Source");

    // Act
    Matches actualIsRelatedResult = edge.isRelated((ElementId) that);

    // Assert
    assertEquals(Matches.SOURCE, actualIsRelatedResult);
  }

  /**
   * Test {@link EdgeId#isRelated(ElementId)} with {@code ElementId}.
   *
   * <ul>
   *   <li>Given {@code That}.
   *   <li>When {@link Entity#Entity(String)} with {@code Group} Vertex is {@code That}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  @DisplayName(
      "Test isRelated(ElementId) with 'ElementId'; given 'That'; when Entity(String) with 'Group' Vertex is 'That'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matches EdgeId.isRelated(ElementId)"})
  void testIsRelatedWithElementId_givenThat_whenEntityWithGroupVertexIsThat() {
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
    that.setVertex("That");

    // Act
    Matches actualIsRelatedResult = edge.isRelated((ElementId) that);

    // Assert
    assertEquals(Matches.NONE, actualIsRelatedResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matches EdgeId.isRelated(EntityId)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matches EdgeId.isRelated(EntityId)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matches EdgeId.isRelated(EntityId)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object EdgeId.getMatchedVertexValue()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object EdgeId.getAdjacentMatchedVertexValue()"})
  void testGetAdjacentMatchedVertexValue_thenReturnSource() {
    // Arrange
    Edge edge =
        new Edge(
            "Group", "Source", "Destination", true, MatchedVertex.DESTINATION, new Properties());

    // Act and Assert
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatchedVertex.isEqual(MatchedVertex, MatchedVertex)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatchedVertex.isEqual(MatchedVertex, MatchedVertex)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatchedVertex.isEqual(MatchedVertex, MatchedVertex)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatchedVertex.isEqual(MatchedVertex, MatchedVertex)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatchedVertex.isEqual(MatchedVertex, MatchedVertex)"})
  void testMatchedVertexIsEqual_whenSource_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(MatchedVertex.isEqual(MatchedVertex.SOURCE, null));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MatchedVertex.isEqual(MatchedVertex, MatchedVertex)"})
  void testMatchedVertexIsEqual_whenSource_thenReturnTrue3() {
    // Arrange, Act and Assert
    assertTrue(MatchedVertex.isEqual(null, MatchedVertex.SOURCE));
  }
}
