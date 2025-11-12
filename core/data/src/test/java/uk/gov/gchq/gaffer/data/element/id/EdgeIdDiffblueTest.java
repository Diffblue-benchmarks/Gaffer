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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.IdentifierType;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.Properties;

class EdgeIdDiffblueTest {
  /**
   * Method under test: {@link EdgeId#isEqual(EdgeId)}
   */
  @Test
  void testIsEqual() {
    // Arrange, Act and Assert
    assertFalse((new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class))).isEqual((EdgeId) null));
    assertFalse((new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class))).isEqual((ElementId) null));
  }

  /**
   * Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  void testIsRelated() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge lazyEdge = new LazyEdge(new Edge("Group"), valueLoader);

    Entity that = new Entity("Group");
    that.putProperty("Name", "Value");

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEdge.isRelated((ElementId) that);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.BOTH, actualIsRelatedResult);
  }

  /**
   * Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  void testIsRelated2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge lazyEdge = new LazyEdge(new Edge("Group"), valueLoader);

    Entity that = new Entity("Group", "Vertex");
    that.putProperty("Name", "Value");

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEdge.isRelated((ElementId) that);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.NONE, actualIsRelatedResult);
  }

  /**
   * Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  void testIsRelated3() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge lazyEdge = new LazyEdge(new Edge("Group", "Source", "Destination", true), valueLoader);

    Entity that = new Entity("Group");
    that.putProperty("Name", "Value");

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEdge.isRelated((ElementId) that);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.NONE, actualIsRelatedResult);
  }

  /**
   * Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  void testIsRelated4() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    LazyEdge lazyEdge = new LazyEdge(new Edge("Group"), valueLoader);
    lazyEdge.putIdentifier(IdentifierType.DESTINATION, "Value");

    Entity that = new Entity("Group");
    that.putProperty("Name", "Value");

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEdge.isRelated((ElementId) that);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.SOURCE, actualIsRelatedResult);
  }

  /**
   * Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  void testIsRelated5() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge lazyEdge = new LazyEdge(new Edge("Group", "Source", null, true), valueLoader);

    Entity that = new Entity("Group");
    that.putProperty("Name", "Value");

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEdge.isRelated((ElementId) that);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.DESTINATION, actualIsRelatedResult);
  }

  /**
   * Method under test: {@link EdgeId#isRelated(ElementId)}
   */
  @Test
  void testIsRelated6() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge lazyEdge = new LazyEdge(new Edge("Group", "Source", null, true), valueLoader);

    Edge that = new Edge("Group", "Source", "Destination", true);
    that.putProperty("Name", "Value");

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEdge.isRelated(that);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.NONE, actualIsRelatedResult);
  }

  /**
   * Method under test: {@link EdgeId#isRelated(EntityId)}
   */
  @Test
  void testIsRelated7() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge lazyEdge = new LazyEdge(new Edge("Group"), valueLoader);

    // Act
    ElementId.Matches actualIsRelatedResult = lazyEdge.isRelated((EntityId) new Entity("Group", "Vertex"));

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(ElementId.Matches.NONE, actualIsRelatedResult);
  }

  /**
   * Method under test: {@link EdgeId#isDirected()}
   */
  @Test
  void testIsDirected() {
    // Arrange, Act and Assert
    assertFalse((new Edge("Group")).isDirected());
    assertTrue((new Edge("Group", "Source", "Destination", true)).isDirected());
  }

  /**
   * Method under test: {@link EdgeId#isDirected()}
   */
  @Test
  void testIsDirected2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    boolean actualIsDirectedResult = (new LazyEdge(new Edge("Group"), valueLoader)).isDirected();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertFalse(actualIsDirectedResult);
  }

  /**
   * Method under test: {@link EdgeId#isUndirected()}
   */
  @Test
  void testIsUndirected() {
    // Arrange, Act and Assert
    assertFalse((new Edge("Group", "Source", "Destination", true)).isUndirected());
  }

  /**
   * Method under test: {@link EdgeId#isUndirected()}
   */
  @Test
  void testIsUndirected2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    boolean actualIsUndirectedResult = (new LazyEdge(new Edge("Group"), valueLoader)).isUndirected();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertTrue(actualIsUndirectedResult);
  }

  /**
   * Method under test:
   * {@link EdgeId.MatchedVertex#isEqual(EdgeId.MatchedVertex, EdgeId.MatchedVertex)}
   */
  @Test
  void testMatchedVertexIsEqual() {
    // Arrange, Act and Assert
    assertTrue(EdgeId.MatchedVertex.isEqual(EdgeId.MatchedVertex.SOURCE, EdgeId.MatchedVertex.SOURCE));
    assertTrue(EdgeId.MatchedVertex.isEqual(null, EdgeId.MatchedVertex.SOURCE));
    assertTrue(EdgeId.MatchedVertex.isEqual(EdgeId.MatchedVertex.SOURCE, null));
    assertFalse(EdgeId.MatchedVertex.isEqual(EdgeId.MatchedVertex.DESTINATION, EdgeId.MatchedVertex.SOURCE));
    assertFalse(EdgeId.MatchedVertex.isEqual(EdgeId.MatchedVertex.DESTINATION, null));
    assertFalse(EdgeId.MatchedVertex.isEqual(null, EdgeId.MatchedVertex.DESTINATION));
  }

  /**
   * Method under test:
   * {@link EdgeId#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  void testSetIdentifiers() {
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
   * Method under test: {@link EdgeId#getMatchedVertexValue()}
   */
  @Test
  void testGetMatchedVertexValue() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualMatchedVertexValue = (new LazyEdge(new Edge("Group"), valueLoader)).getMatchedVertexValue();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualMatchedVertexValue);
  }

  /**
   * Method under test: {@link EdgeId#getMatchedVertexValue()}
   */
  @Test
  void testGetMatchedVertexValue2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualMatchedVertexValue = (new LazyEdge(
        new Edge("Group", "Source", "Destination", false, EdgeId.MatchedVertex.SOURCE, new Properties()), valueLoader))
            .getMatchedVertexValue();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Source", actualMatchedVertexValue);
  }

  /**
   * Method under test: {@link EdgeId#getAdjacentMatchedVertexValue()}
   */
  @Test
  void testGetAdjacentMatchedVertexValue() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualAdjacentMatchedVertexValue = (new LazyEdge(new Edge("Group"), valueLoader))
        .getAdjacentMatchedVertexValue();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualAdjacentMatchedVertexValue);
  }

  /**
   * Method under test: {@link EdgeId#getAdjacentMatchedVertexValue()}
   */
  @Test
  void testGetAdjacentMatchedVertexValue2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualAdjacentMatchedVertexValue = (new LazyEdge(
        new Edge("Group", "Source", "Destination", false, EdgeId.MatchedVertex.SOURCE, new Properties()), valueLoader))
            .getAdjacentMatchedVertexValue();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Destination", actualAdjacentMatchedVertexValue);
  }
}
