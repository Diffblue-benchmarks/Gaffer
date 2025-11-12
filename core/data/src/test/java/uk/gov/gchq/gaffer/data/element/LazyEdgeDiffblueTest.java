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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;

class LazyEdgeDiffblueTest {
  /**
   * Method under test: {@link LazyEdge#getSource()}
   */
  @Test
  void testGetSource() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualSource = (new LazyEdge(new Edge(), valueLoader)).getSource();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualSource);
  }

  /**
   * Method under test: {@link LazyEdge#getSource()}
   */
  @Test
  void testGetSource2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge(), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualSource = (new LazyEdge(edge, valueLoader2)).getSource();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
    assertNull(actualSource);
  }

  /**
   * Method under test: {@link LazyEdge#getDestination()}
   */
  @Test
  void testGetDestination() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualDestination = (new LazyEdge(new Edge(), valueLoader)).getDestination();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualDestination);
  }

  /**
   * Method under test: {@link LazyEdge#getDestination()}
   */
  @Test
  void testGetDestination2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge(), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualDestination = (new LazyEdge(edge, valueLoader2)).getDestination();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
    assertNull(actualDestination);
  }

  /**
   * Method under test: {@link LazyEdge#isDirected()}
   */
  @Test
  void testIsDirected() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    boolean actualIsDirectedResult = (new LazyEdge(new Edge(), valueLoader)).isDirected();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertFalse(actualIsDirectedResult);
  }

  /**
   * Method under test: {@link LazyEdge#isDirected()}
   */
  @Test
  void testIsDirected2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge(), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    boolean actualIsDirectedResult = (new LazyEdge(edge, valueLoader2)).isDirected();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
    assertFalse(actualIsDirectedResult);
  }

  /**
   * Method under test: {@link LazyEdge#isDirected()}
   */
  @Test
  void testIsDirected3() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge("Group", "Source", "Destination", true), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    boolean actualIsDirectedResult = (new LazyEdge(edge, valueLoader2)).isDirected();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
    assertTrue(actualIsDirectedResult);
  }

  /**
   * Method under test: {@link LazyEdge#getGroup()}
   */
  @Test
  void testGetGroup() {
    // Arrange, Act and Assert
    assertEquals(Element.DEFAULT_GROUP, (new LazyEdge(new Edge(), mock(ElementValueLoader.class))).getGroup());
    assertEquals(Element.DEFAULT_GROUP,
        (new LazyEdge(new LazyEdge(new Edge(), mock(ElementValueLoader.class)), mock(ElementValueLoader.class)))
            .getGroup());
  }

  /**
   * Method under test: {@link LazyEdge#getElement()}
   */
  @Test
  void testGetElement() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertSame(edge, (new LazyEdge(edge, mock(ElementValueLoader.class))).getElement());
  }

  /**
   * Method under test: {@link LazyEdge#getProperties()}
   */
  @Test
  void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue((new LazyEdge(new Edge(), mock(ElementValueLoader.class))).getProperties().isEmpty());
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualIdentifier = (new LazyEdge(new Edge(), valueLoader)).getIdentifier(IdentifierType.VERTEX);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualIdentifier);
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualIdentifier = (new LazyEdge(new Edge(), valueLoader)).getIdentifier(IdentifierType.SOURCE);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualIdentifier);
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier3() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualIdentifier = (new LazyEdge(new Edge(), valueLoader)).getIdentifier(IdentifierType.GROUP);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(Element.DEFAULT_GROUP, actualIdentifier);
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier4() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualIdentifier = (new LazyEdge(new Edge(), valueLoader)).getIdentifier(IdentifierType.DESTINATION);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualIdentifier);
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier5() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    (new LazyEdge(new Edge(), valueLoader)).getIdentifier(IdentifierType.DIRECTED);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier6() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualIdentifier = (new LazyEdge(new Edge(), valueLoader)).getIdentifier(IdentifierType.MATCHED_VERTEX);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualIdentifier);
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier7() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualIdentifier = (new LazyEdge(new Edge(), valueLoader))
        .getIdentifier(IdentifierType.ADJACENT_MATCHED_VERTEX);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualIdentifier);
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier8() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge(), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualIdentifier = (new LazyEdge(edge, valueLoader2)).getIdentifier(IdentifierType.SOURCE);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
    assertNull(actualIdentifier);
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier9() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge(), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualIdentifier = (new LazyEdge(edge, valueLoader2)).getIdentifier(IdentifierType.GROUP);

    // Assert
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
    assertEquals(Element.DEFAULT_GROUP, actualIdentifier);
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier10() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge(), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualIdentifier = (new LazyEdge(edge, valueLoader2)).getIdentifier(IdentifierType.DESTINATION);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
    assertNull(actualIdentifier);
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier11() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge(), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    (new LazyEdge(edge, valueLoader2)).getIdentifier(IdentifierType.DIRECTED);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier12() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge(), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualIdentifier = (new LazyEdge(edge, valueLoader2)).getIdentifier(IdentifierType.MATCHED_VERTEX);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
    assertNull(actualIdentifier);
  }

  /**
   * Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier13() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge("Group", "Source", "Destination", true), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    (new LazyEdge(edge, valueLoader2)).getIdentifier(IdentifierType.DIRECTED);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
  }

  /**
   * Method under test: {@link LazyEdge#getMatchedVertex()}
   */
  @Test
  void testGetMatchedVertex() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    EdgeId.MatchedVertex actualMatchedVertex = (new LazyEdge(new Edge(), valueLoader)).getMatchedVertex();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualMatchedVertex);
  }

  /**
   * Method under test: {@link LazyEdge#getMatchedVertex()}
   */
  @Test
  void testGetMatchedVertex2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge(), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    EdgeId.MatchedVertex actualMatchedVertex = (new LazyEdge(edge, valueLoader2)).getMatchedVertex();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
    assertNull(actualMatchedVertex);
  }

  /**
   * Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LazyEdge lazyEdge = new LazyEdge(new Edge(), mock(ElementValueLoader.class));
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act and Assert
    assertNotEquals(lazyEdge, new LazyEdge(new Edge(), valueLoader));
  }

  /**
   * Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LazyEdge lazyEdge = new LazyEdge(new LazyEdge(new Edge(), mock(ElementValueLoader.class)),
        mock(ElementValueLoader.class));
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act and Assert
    assertNotEquals(lazyEdge, new LazyEdge(new Edge(), valueLoader));
  }

  /**
   * Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LazyEdge lazyEdge = new LazyEdge(new Edge(), mock(ElementValueLoader.class), null);
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge(), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act and Assert
    assertNotEquals(lazyEdge, new LazyEdge(edge, valueLoader2));
  }

  /**
   * Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LazyEdge lazyEdge = new LazyEdge(new Edge(), mock(ElementValueLoader.class), null);
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEdge edge = new LazyEdge(new Edge("Group", "Source", "Destination", true), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act and Assert
    assertNotEquals(lazyEdge, new LazyEdge(edge, valueLoader2));
  }

  /**
   * Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LazyEdge lazyEdge = new LazyEdge(new Edge(), mock(ElementValueLoader.class), null);

    // Act and Assert
    assertEquals(lazyEdge, new Edge());
  }

  /**
   * Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LazyEdge(new Edge(), mock(ElementValueLoader.class)), null);
  }

  /**
   * Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsSame_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LazyEdge(new Edge(), mock(ElementValueLoader.class)),
        new LazyEdge(new Edge(), mock(ElementValueLoader.class)));
  }

  /**
   * Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LazyEdge(new Edge(), mock(ElementValueLoader.class)), "Different type to LazyEdge");
  }

  /**
   * Method under test:
   * {@link LazyEdge#LazyEdge(Edge, ElementValueLoader, LazyProperties)}
   */
  @Test
  void testNewLazyEdge() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getGroup()).thenReturn("Group");
    when(edge.getProperties()).thenReturn(new Properties());
    LazyEdge edge2 = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    LazyEdge actualLazyEdge = new LazyEdge(edge2, mock(ElementValueLoader.class), null);

    // Assert
    verify(edge, atLeast(1)).getGroup();
    verify(edge).getProperties();
    assertEquals("Group", actualLazyEdge.getGroup());
    assertEquals("uk.gov.gchq.gaffer.data.element.LazyEdge", actualLazyEdge.getClassName());
    assertNull(actualLazyEdge.getDestination());
    assertNull(actualLazyEdge.getSource());
    assertNull(actualLazyEdge.getAdjacentMatchedVertexValue());
    assertNull(actualLazyEdge.getMatchedVertexValue());
    assertNull(actualLazyEdge.getProperties());
    assertNull(actualLazyEdge.getMatchedVertex());
    assertEquals(DirectedType.UNDIRECTED, actualLazyEdge.getDirectedType());
    assertFalse(actualLazyEdge.isDirected());
    assertTrue(actualLazyEdge.isUndirected());
    assertSame(edge2, actualLazyEdge.getElement());
  }
}
