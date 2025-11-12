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

package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;

class EdgeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Edge.Builder#build()}
   *   <li>{@link Edge.Builder#dest(Object)}
   *   <li>{@link Edge.Builder#directed(boolean)}
   *   <li>{@link Edge.Builder#group(String)}
   *   <li>{@link Edge.Builder#matchedVertex(EdgeId.MatchedVertex)}
   *   <li>{@link Edge.Builder#source(Object)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    Edge actualBuildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(EdgeId.MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Assert
    assertEquals("Dest", actualBuildResult.getDestination());
    assertEquals("Dest", actualBuildResult.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualBuildResult.getGroup());
    assertEquals("Source", actualBuildResult.getSource());
    assertEquals("Source", actualBuildResult.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualBuildResult.getClassName());
    assertEquals(DirectedType.DIRECTED, actualBuildResult.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, actualBuildResult.getMatchedVertex());
    assertFalse(actualBuildResult.isUndirected());
    assertTrue(actualBuildResult.isDirected());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link Edge.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    Edge buildResult = (new Edge.Builder()).build();
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", buildResult.getClassName());
    assertNull(buildResult.getDestination());
    assertNull(buildResult.getSource());
    assertNull(buildResult.getAdjacentMatchedVertexValue());
    assertNull(buildResult.getMatchedVertexValue());
    assertNull(buildResult.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, buildResult.getDirectedType());
    assertFalse(buildResult.isDirected());
    assertTrue(buildResult.getProperties().isEmpty());
    assertTrue(buildResult.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, buildResult.getGroup());
  }

  /**
   * Method under test: {@link Edge.Builder#properties(Map)}
   */
  @Test
  void testBuilderProperties() {
    // Arrange
    Edge.Builder builder = new Edge.Builder();

    // Act and Assert
    assertSame(builder, builder.properties(new HashMap<>()));
  }

  /**
   * Method under test: {@link Edge.Builder#properties(Map)}
   */
  @Test
  void testBuilderProperties2() {
    // Arrange
    Edge.Builder builder = new Edge.Builder();

    HashMap<String, String> properties = new HashMap<>();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertSame(builder, builder.properties(properties));
  }

  /**
   * Method under test: {@link Edge.Builder#property(String, Object)}
   */
  @Test
  void testBuilderProperty() {
    // Arrange
    Edge.Builder builder = new Edge.Builder();

    // Act and Assert
    assertSame(builder, builder.property("Name", "Value"));
  }

  /**
   * Method under test: {@link Edge#getDirectedType()}
   */
  @Test
  void testGetDirectedType() {
    // Arrange, Act and Assert
    assertEquals(DirectedType.UNDIRECTED, (new Edge()).getDirectedType());
  }

  /**
   * Method under test: {@link Edge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier() {
    // Arrange, Act and Assert
    assertNull((new Edge()).getIdentifier(IdentifierType.VERTEX));
    assertEquals(Element.DEFAULT_GROUP, (new Edge()).getIdentifier(IdentifierType.GROUP));
    assertNull((new Edge()).getIdentifier(IdentifierType.SOURCE));
    assertNull((new Edge()).getIdentifier(IdentifierType.DESTINATION));
    assertNull((new Edge()).getIdentifier(IdentifierType.MATCHED_VERTEX));
    assertNull((new Edge()).getIdentifier(IdentifierType.ADJACENT_MATCHED_VERTEX));
  }

  /**
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  void testPutIdentifier() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.VERTEX, "Value");

    // Assert
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  void testPutIdentifier2() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.GROUP, null);

    // Assert
    assertNull(edge.getGroup());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  void testPutIdentifier3() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.SOURCE, null);

    // Assert
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  void testPutIdentifier4() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DESTINATION, null);

    // Assert
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  void testPutIdentifier5() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DIRECTED, null);

    // Assert
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  void testPutIdentifier6() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DIRECTED, DirectedType.UNDIRECTED);

    // Assert
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Method under test: {@link Edge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  void testPutIdentifier7() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putIdentifier(IdentifierType.DIRECTED, DirectedType.EITHER);

    // Assert
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertFalse(edge.isUndirected());
    assertTrue(edge.isDirected());
    assertEquals(Element.DEFAULT_GROUP, edge.getGroup());
  }

  /**
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  void testSetIdentifiers() {
    // Arrange
    Edge edge = new Edge();

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
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  void testSetIdentifiers2() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Method under test: {@link Edge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  void testSetIdentifiers3() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers((byte) 'A', "Destination", DirectedType.UNDIRECTED);

    // Assert
    assertEquals("Destination", edge.getDestination());
    assertEquals("Destination", edge.getAdjacentMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#setIdentifiers(Object, Object, DirectedType, EdgeId.MatchedVertex)}
   */
  @Test
  void testSetIdentifiers4() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.EITHER, EdgeId.MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", edge.getDestination());
    assertEquals("Destination", edge.getAdjacentMatchedVertexValue());
    assertEquals("Source", edge.getSource());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, edge.getMatchedVertex());
    assertFalse(edge.isUndirected());
    assertTrue(edge.isDirected());
  }

  /**
   * Method under test:
   * {@link Edge#setIdentifiers(Object, Object, DirectedType, EdgeId.MatchedVertex)}
   */
  @Test
  void testSetIdentifiers5() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED, EdgeId.MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getAdjacentMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.DESTINATION, edge.getMatchedVertex());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#setIdentifiers(Object, Object, DirectedType, EdgeId.MatchedVertex)}
   */
  @Test
  void testSetIdentifiers6() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers((byte) 'A', "Destination", DirectedType.UNDIRECTED, EdgeId.MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", edge.getDestination());
    assertEquals("Destination", edge.getAdjacentMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, edge.getMatchedVertex());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#setIdentifiers(Object, Object, DirectedType, EdgeId.MatchedVertex)}
   */
  @Test
  void testSetIdentifiers7() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED, null);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertNull(edge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#setIdentifiers(Object, Object, DirectedType, EdgeId.MatchedVertex)}
   */
  @Test
  void testSetIdentifiers8() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED, EdgeId.MatchedVertex.DESTINATION);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, edge.getMatchedVertex());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  void testSetIdentifiers9() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", true);

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
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  void testSetIdentifiers10() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", false);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Method under test: {@link Edge#setIdentifiers(Object, Object, boolean)}
   */
  @Test
  void testSetIdentifiers11() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers((byte) 'A', "Destination", false);

    // Assert
    assertEquals("Destination", edge.getDestination());
    assertEquals("Destination", edge.getAdjacentMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#setIdentifiers(Object, Object, boolean, EdgeId.MatchedVertex)}
   */
  @Test
  void testSetIdentifiers12() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", true, EdgeId.MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", edge.getDestination());
    assertEquals("Destination", edge.getAdjacentMatchedVertexValue());
    assertEquals("Source", edge.getSource());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, edge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, edge.getMatchedVertex());
    assertFalse(edge.isUndirected());
    assertTrue(edge.isDirected());
  }

  /**
   * Method under test:
   * {@link Edge#setIdentifiers(Object, Object, boolean, EdgeId.MatchedVertex)}
   */
  @Test
  void testSetIdentifiers13() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", false, EdgeId.MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getAdjacentMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.DESTINATION, edge.getMatchedVertex());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#setIdentifiers(Object, Object, boolean, EdgeId.MatchedVertex)}
   */
  @Test
  void testSetIdentifiers14() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers((byte) 'A', "Destination", false, EdgeId.MatchedVertex.SOURCE);

    // Assert
    assertEquals("Destination", edge.getDestination());
    assertEquals("Destination", edge.getAdjacentMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, edge.getMatchedVertex());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#setIdentifiers(Object, Object, boolean, EdgeId.MatchedVertex)}
   */
  @Test
  void testSetIdentifiers15() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", false, null);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertNull(edge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#setIdentifiers(Object, Object, boolean, EdgeId.MatchedVertex)}
   */
  @Test
  void testSetIdentifiers16() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setIdentifiers("Source", "Destination", false, EdgeId.MatchedVertex.DESTINATION);

    // Assert
    assertEquals("Destination", edge.getSource());
    assertEquals("Destination", edge.getMatchedVertexValue());
    assertEquals("Source", edge.getDestination());
    assertEquals("Source", edge.getAdjacentMatchedVertexValue());
    assertEquals(DirectedType.UNDIRECTED, edge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, edge.getMatchedVertex());
    assertFalse(edge.isDirected());
    assertTrue(edge.isUndirected());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Edge#equals(Object)}
   *   <li>{@link Edge#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Edge edge = new Edge();
    Edge edge2 = new Edge();

    // Act and Assert
    assertEquals(edge, edge2);
    int expectedHashCodeResult = edge.hashCode();
    assertEquals(expectedHashCodeResult, edge2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Edge#equals(Object)}
   *   <li>{@link Edge#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LazyEdge lazyEdge = new LazyEdge(new Edge(), mock(ElementValueLoader.class));
    Edge edge = new Edge();

    // Act and Assert
    assertEquals(lazyEdge, edge);
    int expectedHashCodeResult = lazyEdge.hashCode();
    assertEquals(expectedHashCodeResult, edge.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Edge#equals(Object)}
   *   <li>{@link Edge#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertEquals(edge, edge);
    int expectedHashCodeResult = edge.hashCode();
    assertEquals(expectedHashCodeResult, edge.hashCode());
  }

  /**
   * Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  void testEquals() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertTrue(edge.equals(new Edge()));
  }

  /**
   * Method under test: {@link Edge#equals(Edge)}
   */
  @Test
  void testEquals2() {
    // Arrange
    Edge edge = new Edge("Group");

    // Act and Assert
    assertFalse(edge.equals(new Edge()));
  }

  /**
   * Method under test: {@link Edge#emptyClone()}
   */
  @Test
  void testEmptyClone() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertEquals(edge, edge.emptyClone());
  }

  /**
   * Method under test: {@link Edge#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertEquals(edge, edge.shallowClone());
  }

  /**
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Edge edge = new Edge("Group");

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Edge edge = new Edge("Group", "Source", "Destination", true);

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Edge(), null);
  }

  /**
   * Method under test: {@link Edge#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Edge(), "Different type to Edge");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Edge#getDestination()}
   *   <li>{@link Edge#getMatchedVertex()}
   *   <li>{@link Edge#getSource()}
   *   <li>{@link Edge#isDirected()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Edge edge = new Edge();

    // Act
    Object actualDestination = edge.getDestination();
    EdgeId.MatchedVertex actualMatchedVertex = edge.getMatchedVertex();
    Object actualSource = edge.getSource();

    // Assert
    assertNull(actualDestination);
    assertNull(actualSource);
    assertNull(actualMatchedVertex);
    assertFalse(edge.isDirected());
  }

  /**
   * Method under test: {@link Edge#Edge()}
   */
  @Test
  void testNewEdge() {
    // Arrange and Act
    Edge actualEdge = new Edge();

    // Assert
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertNull(actualEdge.getDestination());
    assertNull(actualEdge.getSource());
    assertNull(actualEdge.getAdjacentMatchedVertexValue());
    assertNull(actualEdge.getMatchedVertexValue());
    assertNull(actualEdge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isDirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isUndirected());
    assertEquals(Element.DEFAULT_GROUP, actualEdge.getGroup());
  }

  /**
   * Method under test: {@link Edge#Edge(String)}
   */
  @Test
  void testNewEdge2() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group");

    // Assert
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertNull(actualEdge.getDestination());
    assertNull(actualEdge.getSource());
    assertNull(actualEdge.getAdjacentMatchedVertexValue());
    assertNull(actualEdge.getMatchedVertexValue());
    assertNull(actualEdge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isDirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new Edge("Group", "Source", "Destination", true,
        DirectedType.EITHER, EdgeId.MatchedVertex.SOURCE, new Properties()));

  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge4() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", null, null, EdgeId.MatchedVertex.SOURCE, null);

    // Assert
    assertEquals("Destination", actualEdge.getDestination());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getSource());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge5() {
    // Arrange
    Properties properties = new Properties();

    // Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", null, null, EdgeId.MatchedVertex.SOURCE, properties);

    // Assert
    assertEquals("Destination", actualEdge.getDestination());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getSource());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isUndirected());
    Properties properties2 = actualEdge.getProperties();
    assertTrue(properties2.isEmpty());
    assertTrue(actualEdge.isDirected());
    assertSame(properties, properties2);
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge6() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", null, DirectedType.UNDIRECTED,
        EdgeId.MatchedVertex.SOURCE, null);

    // Assert
    assertEquals("Destination", actualEdge.getSource());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getDestination());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.DESTINATION, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isDirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge7() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", null, DirectedType.EITHER, EdgeId.MatchedVertex.SOURCE,
        null);

    // Assert
    assertEquals("Destination", actualEdge.getDestination());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getSource());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge8() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", true, null, EdgeId.MatchedVertex.SOURCE, null);

    // Assert
    assertEquals("Destination", actualEdge.getDestination());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getSource());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge9() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", (byte) 'A', "Destination", null, DirectedType.UNDIRECTED,
        EdgeId.MatchedVertex.SOURCE, null);

    // Assert
    assertEquals("Destination", actualEdge.getDestination());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isDirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge10() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", null, DirectedType.UNDIRECTED, null, null);

    // Assert
    assertEquals("Destination", actualEdge.getSource());
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getDestination());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertNull(actualEdge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isDirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, Boolean, DirectedType, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge11() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", null, DirectedType.UNDIRECTED,
        EdgeId.MatchedVertex.DESTINATION, null);

    // Assert
    assertEquals("Destination", actualEdge.getSource());
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getDestination());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isDirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isUndirected());
  }

  /**
   * Method under test: {@link Edge#Edge(String, Object, Object, boolean)}
   */
  @Test
  void testNewEdge12() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", true);

    // Assert
    assertEquals("Destination", actualEdge.getDestination());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getSource());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertNull(actualEdge.getMatchedVertex());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Method under test: {@link Edge#Edge(String, Object, Object, boolean)}
   */
  @Test
  void testNewEdge13() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", false);

    // Assert
    assertEquals("Destination", actualEdge.getSource());
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getDestination());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertNull(actualEdge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isDirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isUndirected());
  }

  /**
   * Method under test: {@link Edge#Edge(String, Object, Object, boolean)}
   */
  @Test
  void testNewEdge14() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", (byte) 'A', "Destination", false);

    // Assert
    assertEquals("Destination", actualEdge.getDestination());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertNull(actualEdge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isDirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isUndirected());
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, boolean, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge15() {
    // Arrange
    Properties properties = new Properties();

    // Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", true, EdgeId.MatchedVertex.SOURCE, properties);

    // Assert
    assertEquals("Destination", actualEdge.getDestination());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getSource());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isUndirected());
    Properties properties2 = actualEdge.getProperties();
    assertTrue(properties2.isEmpty());
    assertTrue(actualEdge.isDirected());
    assertSame(properties, properties2);
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, boolean, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge16() {
    // Arrange and Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", true, EdgeId.MatchedVertex.SOURCE, null);

    // Assert
    assertEquals("Destination", actualEdge.getDestination());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getSource());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isUndirected());
    assertTrue(actualEdge.getProperties().isEmpty());
    assertTrue(actualEdge.isDirected());
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, boolean, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge17() {
    // Arrange
    Properties properties = new Properties();

    // Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", false, EdgeId.MatchedVertex.SOURCE, properties);

    // Assert
    assertEquals("Destination", actualEdge.getSource());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getDestination());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.DESTINATION, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isDirected());
    Properties properties2 = actualEdge.getProperties();
    assertTrue(properties2.isEmpty());
    assertTrue(actualEdge.isUndirected());
    assertSame(properties, properties2);
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, boolean, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge18() {
    // Arrange
    Properties properties = new Properties();

    // Act
    Edge actualEdge = new Edge("Group", (byte) 'A', "Destination", false, EdgeId.MatchedVertex.SOURCE, properties);

    // Assert
    assertEquals("Destination", actualEdge.getDestination());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isDirected());
    Properties properties2 = actualEdge.getProperties();
    assertTrue(properties2.isEmpty());
    assertTrue(actualEdge.isUndirected());
    assertSame(properties, properties2);
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, boolean, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge19() {
    // Arrange
    Properties properties = new Properties();

    // Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", false, null, properties);

    // Assert
    assertEquals("Destination", actualEdge.getSource());
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getDestination());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertNull(actualEdge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertFalse(actualEdge.isDirected());
    Properties properties2 = actualEdge.getProperties();
    assertTrue(properties2.isEmpty());
    assertTrue(actualEdge.isUndirected());
    assertSame(properties, properties2);
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, boolean, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge20() {
    // Arrange
    Properties properties = new Properties();

    // Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", false, EdgeId.MatchedVertex.DESTINATION, properties);

    // Assert
    assertEquals("Destination", actualEdge.getSource());
    assertEquals("Destination", actualEdge.getMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getDestination());
    assertEquals("Source", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.UNDIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isDirected());
    Properties properties2 = actualEdge.getProperties();
    assertTrue(properties2.isEmpty());
    assertTrue(actualEdge.isUndirected());
    assertSame(properties, properties2);
  }

  /**
   * Method under test:
   * {@link Edge#Edge(String, Object, Object, boolean, EdgeId.MatchedVertex, Properties)}
   */
  @Test
  void testNewEdge21() {
    // Arrange
    Properties properties = new Properties();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    Edge actualEdge = new Edge("Group", "Source", "Destination", true, EdgeId.MatchedVertex.SOURCE, properties);

    // Assert
    assertEquals("Destination", actualEdge.getDestination());
    assertEquals("Destination", actualEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualEdge.getGroup());
    assertEquals("Source", actualEdge.getSource());
    assertEquals("Source", actualEdge.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualEdge.getClassName());
    assertEquals(DirectedType.DIRECTED, actualEdge.getDirectedType());
    assertEquals(EdgeId.MatchedVertex.SOURCE, actualEdge.getMatchedVertex());
    assertFalse(actualEdge.isUndirected());
    Properties properties2 = actualEdge.getProperties();
    assertTrue(properties2.isEmpty());
    assertTrue(actualEdge.isDirected());
    assertSame(properties, properties2);
  }
}
