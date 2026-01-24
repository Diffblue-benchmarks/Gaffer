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

package uk.gov.gchq.gaffer.operation.graph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GraphFilters.Builder GraphFilters.Builder.directedType(DirectedType)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
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
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@link
   *       DirectedType#EITHER}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName(
      "Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is EITHER; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsEither_whenNull() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.EITHER);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validateFlags(Edge)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validateFlags(Edge)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validateFlags(Edge)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validateFlags(Edge)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validateFlags(Edge)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphFilters.validateFlags(Edge)"})
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
