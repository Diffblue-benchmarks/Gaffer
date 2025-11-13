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

package uk.gov.gchq.gaffer.data.element.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId.Matches;

class EdgeIdDiffblueTest {
  /**
   * Test {@link EdgeId#isDirected()}.
   * <ul>
   *   <li>Given {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeId#isDirected()}
   */
  @Test
  @DisplayName("Test isDirected(); given Edge(String) with 'Group'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeId.isDirected()"})
  void testIsDirected_givenEdgeWithGroup_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Edge("Group")).isDirected());
  }

  /**
   * Test {@link EdgeId#isDirected()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeId#isDirected()}
   */
  @Test
  @DisplayName("Test isDirected(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeId.isDirected()"})
  void testIsDirected_thenReturnTrue() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertTrue(buildResult.isDirected());
  }

  /**
   * Test {@link EdgeId#isUndirected()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeId#isUndirected()}
   */
  @Test
  @DisplayName("Test isUndirected(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeId.isUndirected()"})
  void testIsUndirected_thenReturnFalse() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertFalse(buildResult.isUndirected());
  }

  /**
   * Test MatchedVertex {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}.
   * <ul>
   *   <li>When {@code DESTINATION}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}
   */
  @Test
  @DisplayName("Test MatchedVertex isEqual(MatchedVertex, MatchedVertex); when 'DESTINATION'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MatchedVertex.isEqual(MatchedVertex, MatchedVertex)"})
  void testMatchedVertexIsEqual_whenDestination_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MatchedVertex.isEqual(MatchedVertex.DESTINATION, null));
  }

  /**
   * Test MatchedVertex {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}.
   * <ul>
   *   <li>When {@code DESTINATION}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}
   */
  @Test
  @DisplayName("Test MatchedVertex isEqual(MatchedVertex, MatchedVertex); when 'DESTINATION'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MatchedVertex.isEqual(MatchedVertex, MatchedVertex)"})
  void testMatchedVertexIsEqual_whenDestination_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(MatchedVertex.isEqual(null, MatchedVertex.DESTINATION));
  }

  /**
   * Test MatchedVertex {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}.
   * <ul>
   *   <li>When {@code SOURCE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}
   */
  @Test
  @DisplayName("Test MatchedVertex isEqual(MatchedVertex, MatchedVertex); when 'SOURCE'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MatchedVertex.isEqual(MatchedVertex, MatchedVertex)"})
  void testMatchedVertexIsEqual_whenSource_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MatchedVertex.isEqual(MatchedVertex.DESTINATION, MatchedVertex.SOURCE));
  }

  /**
   * Test MatchedVertex {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}.
   * <ul>
   *   <li>When {@code SOURCE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}
   */
  @Test
  @DisplayName("Test MatchedVertex isEqual(MatchedVertex, MatchedVertex); when 'SOURCE'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MatchedVertex.isEqual(MatchedVertex, MatchedVertex)"})
  void testMatchedVertexIsEqual_whenSource_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MatchedVertex.isEqual(MatchedVertex.SOURCE, MatchedVertex.SOURCE));
  }

  /**
   * Test MatchedVertex {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}.
   * <ul>
   *   <li>When {@link MatchedVertex#SOURCE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}
   */
  @Test
  @DisplayName("Test MatchedVertex isEqual(MatchedVertex, MatchedVertex); when SOURCE; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MatchedVertex.isEqual(MatchedVertex, MatchedVertex)"})
  void testMatchedVertexIsEqual_whenSource_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(MatchedVertex.isEqual(null, MatchedVertex.SOURCE));
  }

  /**
   * Test MatchedVertex {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}.
   * <ul>
   *   <li>When {@link MatchedVertex#SOURCE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MatchedVertex#isEqual(MatchedVertex, MatchedVertex)}
   */
  @Test
  @DisplayName("Test MatchedVertex isEqual(MatchedVertex, MatchedVertex); when SOURCE; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MatchedVertex.isEqual(MatchedVertex, MatchedVertex)"})
  void testMatchedVertexIsEqual_whenSource_thenReturnTrue3() {
    // Arrange, Act and Assert
    assertTrue(MatchedVertex.isEqual(MatchedVertex.SOURCE, null));
  }

  /**
   * Test {@link EdgeId#setIdentifiers(Object, Object, DirectedType)} with {@code Object}, {@code Object}, {@code DirectedType}.
   * <p>
   * Method under test: {@link EdgeId#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName("Test setIdentifiers(Object, Object, DirectedType) with 'Object', 'Object', 'DirectedType'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeId.setIdentifiers(Object, Object, DirectedType)"})
  void testSetIdentifiersWithObjectObjectDirectedType() {
    // Arrange
    Edge edge = new Edge("Group");

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.EITHER);

    // Assert
    assertEquals("Destination", edge.getDestination());
    assertEquals("Destination", edge.getAdjacentMatchedVertexValue());
    assertEquals("Source", edge.getSource());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertFalse(edge.isUndirected());
    assertTrue(edge.isDirected());
  }

  /**
   * Test {@link EdgeId#isRelated(ElementId)} with {@code ElementId}.
   * <p>
   * Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  @DisplayName("Test isRelated(ElementId) with 'ElementId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Matches EdgeId.isRelated(ElementId)"})
  void testIsRelatedWithElementId() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Entity that = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    that.putProperty("Name", "Value");

    // Act and Assert
    assertEquals(Matches.NONE, buildResult.isRelated((ElementId) that));
  }

  /**
   * Test {@link EdgeId#isRelated(ElementId)} with {@code ElementId}.
   * <ul>
   *   <li>Then return {@code DESTINATION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  @DisplayName("Test isRelated(ElementId) with 'ElementId'; then return 'DESTINATION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Matches EdgeId.isRelated(ElementId)"})
  void testIsRelatedWithElementId_thenReturnDestination() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Vertex")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Entity that = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    that.putProperty("Name", "Value");

    // Act and Assert
    assertEquals(Matches.DESTINATION, buildResult.isRelated((ElementId) that));
  }

  /**
   * Test {@link EdgeId#isRelated(ElementId)} with {@code ElementId}.
   * <ul>
   *   <li>Then return {@code SOURCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  @DisplayName("Test isRelated(ElementId) with 'ElementId'; then return 'SOURCE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Matches EdgeId.isRelated(ElementId)"})
  void testIsRelatedWithElementId_thenReturnSource() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Vertex")
        .build();
    Entity that = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    that.putProperty("Name", "Value");

    // Act and Assert
    assertEquals(Matches.SOURCE, buildResult.isRelated((ElementId) that));
  }

  /**
   * Test {@link EdgeId#getMatchedVertexValue()}.
   * <ul>
   *   <li>Then return {@code Source}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeId#getMatchedVertexValue()}
   */
  @Test
  @DisplayName("Test getMatchedVertexValue(); then return 'Source'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object EdgeId.getMatchedVertexValue()"})
  void testGetMatchedVertexValue_thenReturnSource() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge = (new Builder()).dest("Dest")
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Object actualMatchedVertexValue = (new LazyEdge(edge, valueLoader)).getMatchedVertexValue();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Source", actualMatchedVertexValue);
  }

  /**
   * Test {@link EdgeId#getAdjacentMatchedVertexValue()}.
   * <ul>
   *   <li>Then return {@code Dest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeId#getAdjacentMatchedVertexValue()}
   */
  @Test
  @DisplayName("Test getAdjacentMatchedVertexValue(); then return 'Dest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object EdgeId.getAdjacentMatchedVertexValue()"})
  void testGetAdjacentMatchedVertexValue_thenReturnDest() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge = (new Builder()).dest("Dest")
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Object actualAdjacentMatchedVertexValue = (new LazyEdge(edge, valueLoader)).getAdjacentMatchedVertexValue();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Dest", actualAdjacentMatchedVertexValue);
  }
}
