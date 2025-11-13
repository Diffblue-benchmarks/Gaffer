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

package uk.gov.gchq.gaffer.operation.graph;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>
   * Method under test: {@link GraphFilters.Builder#directedType(DirectedType)}
   */
  @Test
  @DisplayName("Test Builder directedType(DirectedType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GraphFilters.Builder GraphFilters.Builder.directedType(DirectedType)"})
  void testBuilderDirectedType() {
    // Arrange
    GetAdjacentIds.Builder builder = new GetAdjacentIds.Builder();

    // Act and Assert
    assertSame(builder, builder.directedType(DirectedType.EITHER));
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@link DirectedType#DIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName("Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is DIRECTED")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsDirected() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.DIRECTED);
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertFalse(getAdjacentIds.validate(edge));
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@link DirectedType#DIRECTED}.</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName("Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is DIRECTED; when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsDirected_whenEdgeWithGroup() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.DIRECTED);

    // Act and Assert
    assertFalse(getAdjacentIds.validate(new Edge("Group")));
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@link DirectedType#EITHER}.</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName("Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is EITHER; when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsEither_whenEdgeWithGroup() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.EITHER);

    // Act and Assert
    assertFalse(getAdjacentIds.validate(new Edge("Group")));
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@code null}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName("Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is 'null'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsNull_whenNull() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(null);

    // Act and Assert
    assertFalse(getAdjacentIds.validate((Edge) null));
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@link DirectedType#UNDIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName("Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is UNDIRECTED")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsUndirected() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.UNDIRECTED);

    // Act and Assert
    assertFalse(getAdjacentIds.validate(new Edge("Group")));
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@link DirectedType#UNDIRECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName("Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor) DirectedType is UNDIRECTED")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
  void testValidateWithEdge_givenGetAdjacentIdsDirectedTypeIsUndirected2() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.UNDIRECTED);
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertFalse(getAdjacentIds.validate(edge));
  }

  /**
   * Test {@link GraphFilters#validate(Edge)} with {@code edge}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphFilters#validate(Edge)}
   */
  @Test
  @DisplayName("Test validate(Edge) with 'edge'; given GetAdjacentIds (default constructor); when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validate(Edge)"})
  void testValidateWithEdge_givenGetAdjacentIds_whenEdgeWithGroup() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act and Assert
    assertFalse(getAdjacentIds.validate(new Edge("Group")));
  }

  /**
   * Test {@link GraphFilters#validateFlags(Edge)}.
   * <p>
   * Method under test: {@link GraphFilters#validateFlags(Edge)}
   */
  @Test
  @DisplayName("Test validateFlags(Edge)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validateFlags(Edge)"})
  void testValidateFlags() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.DIRECTED);
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertTrue(getAdjacentIds.validateFlags(edge));
  }

  /**
   * Test {@link GraphFilters#validateFlags(Edge)}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@code DIRECTED}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphFilters#validateFlags(Edge)}
   */
  @Test
  @DisplayName("Test validateFlags(Edge); given GetAdjacentIds (default constructor) DirectedType is 'DIRECTED'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validateFlags(Edge)"})
  void testValidateFlags_givenGetAdjacentIdsDirectedTypeIsDirected_thenReturnFalse() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.DIRECTED);

    // Act and Assert
    assertFalse(getAdjacentIds.validateFlags(new Edge("Group")));
  }

  /**
   * Test {@link GraphFilters#validateFlags(Edge)}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@code EITHER}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphFilters#validateFlags(Edge)}
   */
  @Test
  @DisplayName("Test validateFlags(Edge); given GetAdjacentIds (default constructor) DirectedType is 'EITHER'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validateFlags(Edge)"})
  void testValidateFlags_givenGetAdjacentIdsDirectedTypeIsEither_thenReturnTrue() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.EITHER);

    // Act and Assert
    assertTrue(getAdjacentIds.validateFlags(new Edge("Group")));
  }

  /**
   * Test {@link GraphFilters#validateFlags(Edge)}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor) DirectedType is {@code UNDIRECTED}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphFilters#validateFlags(Edge)}
   */
  @Test
  @DisplayName("Test validateFlags(Edge); given GetAdjacentIds (default constructor) DirectedType is 'UNDIRECTED'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validateFlags(Edge)"})
  void testValidateFlags_givenGetAdjacentIdsDirectedTypeIsUndirected_thenReturnTrue() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.UNDIRECTED);

    // Act and Assert
    assertTrue(getAdjacentIds.validateFlags(new Edge("Group")));
  }

  /**
   * Test {@link GraphFilters#validateFlags(Edge)}.
   * <ul>
   *   <li>Given {@link GetAdjacentIds} (default constructor).</li>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphFilters#validateFlags(Edge)}
   */
  @Test
  @DisplayName("Test validateFlags(Edge); given GetAdjacentIds (default constructor); when Edge(String) with 'Group'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validateFlags(Edge)"})
  void testValidateFlags_givenGetAdjacentIds_whenEdgeWithGroup_thenReturnTrue() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();

    // Act and Assert
    assertTrue(getAdjacentIds.validateFlags(new Edge("Group")));
  }

  /**
   * Test {@link GraphFilters#validateFlags(Edge)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphFilters#validateFlags(Edge)}
   */
  @Test
  @DisplayName("Test validateFlags(Edge); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphFilters.validateFlags(Edge)"})
  void testValidateFlags_thenReturnFalse() {
    // Arrange
    GetAdjacentIds getAdjacentIds = new GetAdjacentIds();
    getAdjacentIds.setDirectedType(DirectedType.UNDIRECTED);
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertFalse(getAdjacentIds.validateFlags(edge));
  }
}
