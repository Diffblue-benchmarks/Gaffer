package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class LazyEdgeDiffblueTest {
  /**
   * Test {@link LazyEdge#LazyEdge(Edge, ElementValueLoader)}.
   *
   * <ul>
   *   <li>Then Element return {@link LazyEdge}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#LazyEdge(Edge, ElementValueLoader)}
   */
  @Test
  @DisplayName("Test new LazyEdge(Edge, ElementValueLoader); then Element return LazyEdge")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.<init>(Edge, ElementValueLoader)"})
  void testNewLazyEdge_thenElementReturnLazyEdge() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge edge2 = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    LazyEdge actualLazyEdge = new LazyEdge(edge2, mock(ElementValueLoader.class));

    // Assert
    Edge element = actualLazyEdge.getElement();
    assertTrue(element instanceof LazyEdge);
    assertEquals("Dest", actualLazyEdge.getDestination());
    assertEquals("Dest", actualLazyEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualLazyEdge.getGroup());
    assertEquals("Source", actualLazyEdge.getSource());
    assertEquals("Source", actualLazyEdge.getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, actualLazyEdge.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualLazyEdge.getMatchedVertex());
    assertFalse(actualLazyEdge.isUndirected());
    assertTrue(actualLazyEdge.isDirected());
    assertSame(edge2, element);
  }

  /**
   * Test {@link LazyEdge#LazyEdge(Edge, ElementValueLoader, LazyProperties)}.
   *
   * <ul>
   *   <li>Then Element return {@link LazyEdge}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#LazyEdge(Edge, ElementValueLoader, LazyProperties)}
   */
  @Test
  @DisplayName(
      "Test new LazyEdge(Edge, ElementValueLoader, LazyProperties); then Element return LazyEdge")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.<init>(Edge, ElementValueLoader, LazyProperties)"})
  void testNewLazyEdge_thenElementReturnLazyEdge2() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge edge2 = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    LazyEdge actualLazyEdge = new LazyEdge(edge2, mock(ElementValueLoader.class), null);

    // Assert
    Edge element = actualLazyEdge.getElement();
    assertTrue(element instanceof LazyEdge);
    assertEquals("Dest", actualLazyEdge.getDestination());
    assertEquals("Dest", actualLazyEdge.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualLazyEdge.getGroup());
    assertEquals("Source", actualLazyEdge.getSource());
    assertEquals("Source", actualLazyEdge.getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, actualLazyEdge.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualLazyEdge.getMatchedVertex());
    assertFalse(actualLazyEdge.isUndirected());
    assertTrue(actualLazyEdge.isDirected());
    assertSame(edge2, element);
  }

  /**
   * Test {@link LazyEdge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link LazyEdge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.setIdentifiers(Object, Object, boolean, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.setIdentifiers("Source", "Destination", true, MatchedVertex.SOURCE);

    // Assert that nothing has changed
    assertEquals("Source", lazyEdge.getElement().getSource());
    assertEquals("Source", lazyEdge.getSource());
  }

  /**
   * Test {@link LazyEdge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link LazyEdge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.setIdentifiers(Object, Object, boolean, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex2() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.setIdentifiers("Source", "Destination", false, MatchedVertex.SOURCE);

    // Assert
    Edge element = lazyEdge.getElement();
    assertEquals("Destination", element.getSource());
    assertEquals("Destination", lazyEdge.getSource());
    assertEquals("Source", element.getDestination());
    assertEquals("Source", lazyEdge.getDestination());
    assertEquals("Source", lazyEdge.getMatchedVertexValue());
    assertEquals("Source", element.getMatchedVertexValue());
    assertEquals(MatchedVertex.DESTINATION, element.getMatchedVertex());
    assertEquals(MatchedVertex.DESTINATION, lazyEdge.getMatchedVertex());
  }

  /**
   * Test {@link LazyEdge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link LazyEdge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.setIdentifiers(Object, Object, boolean, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex3() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.setIdentifiers((byte) 'A', "Destination", false, MatchedVertex.SOURCE);

    // Assert
    Edge element = lazyEdge.getElement();
    assertEquals('A', ((Byte) element.getSource()).byteValue());
    assertEquals('A', ((Byte) lazyEdge.getSource()).byteValue());
    assertEquals('A', ((Byte) lazyEdge.getMatchedVertexValue()).byteValue());
    assertEquals('A', ((Byte) element.getMatchedVertexValue()).byteValue());
  }

  /**
   * Test {@link LazyEdge#setIdentifiers(Object, Object, boolean, MatchedVertex)} with {@code
   * source}, {@code destination}, {@code directed}, {@code matchedVertex}.
   *
   * <p>Method under test: {@link LazyEdge#setIdentifiers(Object, Object, boolean, MatchedVertex)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, boolean, MatchedVertex) with 'source', 'destination', 'directed', 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.setIdentifiers(Object, Object, boolean, MatchedVertex)"})
  void testSetIdentifiersWithSourceDestinationDirectedMatchedVertex4() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.setIdentifiers("Source", "Destination", false, MatchedVertex.DESTINATION);

    // Assert
    assertEquals("Destination", lazyEdge.getMatchedVertexValue());
    Edge element = lazyEdge.getElement();
    assertEquals("Destination", element.getMatchedVertexValue());
    assertEquals("Source", lazyEdge.getAdjacentMatchedVertexValue());
    assertEquals("Source", element.getAdjacentMatchedVertexValue());
  }

  /**
   * Test {@link LazyEdge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code
   * destination}, {@code directedType}.
   *
   * <p>Method under test: {@link LazyEdge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.setIdentifiers(Object, Object, DirectedType)"})
  void testSetIdentifiersWithSourceDestinationDirectedType() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.setIdentifiers("Source", "Destination", DirectedType.EITHER);

    // Assert that nothing has changed
    assertEquals("Source", lazyEdge.getElement().getSource());
    assertEquals("Source", lazyEdge.getSource());
  }

  /**
   * Test {@link LazyEdge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code
   * destination}, {@code directedType}.
   *
   * <p>Method under test: {@link LazyEdge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.setIdentifiers(Object, Object, DirectedType)"})
  void testSetIdentifiersWithSourceDestinationDirectedType2() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED);

    // Assert
    Edge element = lazyEdge.getElement();
    assertEquals("Source", element.getDestination());
    assertEquals("Source", lazyEdge.getDestination());
    assertEquals(MatchedVertex.DESTINATION, element.getMatchedVertex());
    assertEquals(MatchedVertex.DESTINATION, lazyEdge.getMatchedVertex());
  }

  /**
   * Test {@link LazyEdge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code
   * destination}, {@code directedType}.
   *
   * <p>Method under test: {@link LazyEdge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.setIdentifiers(Object, Object, DirectedType)"})
  void testSetIdentifiersWithSourceDestinationDirectedType3() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(false)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.setIdentifiers("Source", "Destination", DirectedType.UNDIRECTED);

    // Assert
    assertEquals("Destination", lazyEdge.getMatchedVertexValue());
    Edge element = lazyEdge.getElement();
    assertEquals("Destination", element.getMatchedVertexValue());
    assertEquals("Source", element.getDestination());
    assertEquals("Source", lazyEdge.getDestination());
    assertEquals("Source", lazyEdge.getAdjacentMatchedVertexValue());
    assertEquals("Source", element.getAdjacentMatchedVertexValue());
    assertEquals(MatchedVertex.SOURCE, element.getMatchedVertex());
    assertEquals(MatchedVertex.SOURCE, lazyEdge.getMatchedVertex());
  }

  /**
   * Test {@link LazyEdge#setIdentifiers(Object, Object, DirectedType)} with {@code source}, {@code
   * destination}, {@code directedType}.
   *
   * <p>Method under test: {@link LazyEdge#setIdentifiers(Object, Object, DirectedType)}
   */
  @Test
  @DisplayName(
      "Test setIdentifiers(Object, Object, DirectedType) with 'source', 'destination', 'directedType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.setIdentifiers(Object, Object, DirectedType)"})
  void testSetIdentifiersWithSourceDestinationDirectedType4() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.setIdentifiers((byte) 'A', "Destination", DirectedType.UNDIRECTED);

    // Assert
    Edge element = lazyEdge.getElement();
    assertEquals('A', ((Byte) element.getSource()).byteValue());
    assertEquals('A', ((Byte) lazyEdge.getSource()).byteValue());
    assertEquals('A', ((Byte) lazyEdge.getMatchedVertexValue()).byteValue());
    assertEquals('A', ((Byte) element.getMatchedVertexValue()).byteValue());
  }

  /**
   * Test {@link LazyEdge#getProperty(String)}.
   *
   * <p>Method under test: {@link LazyEdge#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getProperty(String)"})
  void testGetProperty() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn("Property");
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    lazyEdge.getProperty("Name");

    // Assert
    verify(valueLoader).getProperty(eq("Name"), isA(Properties.class));
    Properties properties = lazyEdge.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Property", properties.get("Name"));
    LazyProperties properties2 = lazyEdge.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Property", properties2.get((Object) "Name"));
  }

  /**
   * Test {@link LazyEdge#getProperty(String)}.
   *
   * <p>Method under test: {@link LazyEdge#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getProperty(String)"})
  void testGetProperty2() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));
    lazyEdge.putProperty("Name", "Value");

    // Act
    Object actualProperty = lazyEdge.getProperty("Name");

    // Assert
    Properties properties = lazyEdge.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
    assertEquals("Value", actualProperty);
    LazyProperties properties2 = lazyEdge.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get((Object) "Name"));
  }

  /**
   * Test {@link LazyEdge#getProperty(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String); when 'null'; then return 'Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getProperty(String)"})
  void testGetProperty_whenNull_thenReturnProperty() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn("Property");
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualProperty = lazyEdge.getProperty(null);

    // Assert
    verify(valueLoader).getProperty(isNull(), isA(Properties.class));
    assertEquals("Property", actualProperty);
    assertTrue(lazyEdge.getElement().getProperties().isEmpty());
    assertTrue(lazyEdge.getProperties().isEmpty());
  }

  /**
   * Test {@link LazyEdge#getSource()}.
   *
   * <p>Method under test: {@link LazyEdge#getSource()}
   */
  @Test
  @DisplayName("Test getSource()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getSource()"})
  void testGetSource() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualSource = lazyEdge.getSource();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Source", actualSource);
  }

  /**
   * Test {@link LazyEdge#getDestination()}.
   *
   * <p>Method under test: {@link LazyEdge#getDestination()}
   */
  @Test
  @DisplayName("Test getDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getDestination()"})
  void testGetDestination() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualDestination = lazyEdge.getDestination();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Dest", actualDestination);
  }

  /**
   * Test {@link LazyEdge#isDirected()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#isDirected()}
   */
  @Test
  @DisplayName("Test isDirected(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LazyEdge.isDirected()"})
  void testIsDirected_thenReturnFalse() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(false)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    boolean actualIsDirectedResult = lazyEdge.isDirected();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertFalse(actualIsDirectedResult);
  }

  /**
   * Test {@link LazyEdge#isDirected()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#isDirected()}
   */
  @Test
  @DisplayName("Test isDirected(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LazyEdge.isDirected()"})
  void testIsDirected_thenReturnTrue() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    boolean actualIsDirectedResult = lazyEdge.isDirected();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertTrue(actualIsDirectedResult);
  }

  /**
   * Test {@link LazyEdge#putIdentifier(IdentifierType, Object)}.
   *
   * <p>Method under test: {@link LazyEdge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.putIdentifier(IdentifierType.GROUP, null);

    // Assert
    Edge element = lazyEdge.getElement();
    assertNull(element.getGroup());
    assertNull(lazyEdge.getGroup());
    assertEquals(DirectedType.DIRECTED, lazyEdge.getDirectedType());
    assertEquals(DirectedType.DIRECTED, element.getDirectedType());
    assertFalse(lazyEdge.isUndirected());
    assertFalse(element.isUndirected());
    assertTrue(element.isDirected());
    assertTrue(lazyEdge.isDirected());
  }

  /**
   * Test {@link LazyEdge#putIdentifier(IdentifierType, Object)}.
   *
   * <p>Method under test: {@link LazyEdge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier2() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.putIdentifier(IdentifierType.SOURCE, null);

    // Assert
    Edge element = lazyEdge.getElement();
    assertNull(element.getSource());
    assertNull(lazyEdge.getSource());
    assertNull(lazyEdge.getMatchedVertexValue());
    assertNull(element.getMatchedVertexValue());
  }

  /**
   * Test {@link LazyEdge#putIdentifier(IdentifierType, Object)}.
   *
   * <p>Method under test: {@link LazyEdge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier3() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.putIdentifier(IdentifierType.DESTINATION, null);

    // Assert
    Edge element = lazyEdge.getElement();
    assertNull(element.getDestination());
    assertNull(lazyEdge.getDestination());
    assertNull(lazyEdge.getAdjacentMatchedVertexValue());
    assertNull(element.getAdjacentMatchedVertexValue());
  }

  /**
   * Test {@link LazyEdge#putIdentifier(IdentifierType, Object)}.
   *
   * <p>Method under test: {@link LazyEdge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier4() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.putIdentifier(IdentifierType.DIRECTED, null);

    // Assert
    assertEquals(DirectedType.UNDIRECTED, lazyEdge.getDirectedType());
    Edge element = lazyEdge.getElement();
    assertEquals(DirectedType.UNDIRECTED, element.getDirectedType());
    assertFalse(element.isDirected());
    assertFalse(lazyEdge.isDirected());
    assertTrue(lazyEdge.isUndirected());
    assertTrue(element.isUndirected());
  }

  /**
   * Test {@link LazyEdge#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@link DirectedType#UNDIRECTED}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object); when UNDIRECTED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenUndirected() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.putIdentifier(IdentifierType.DIRECTED, DirectedType.UNDIRECTED);

    // Assert
    assertEquals(DirectedType.UNDIRECTED, lazyEdge.getDirectedType());
    Edge element = lazyEdge.getElement();
    assertEquals(DirectedType.UNDIRECTED, element.getDirectedType());
    assertFalse(element.isDirected());
    assertFalse(lazyEdge.isDirected());
    assertTrue(lazyEdge.isUndirected());
    assertTrue(element.isUndirected());
  }

  /**
   * Test {@link LazyEdge#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@code VERTEX}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object); when 'VERTEX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenVertex() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.putIdentifier(IdentifierType.VERTEX, "Value");

    // Assert that nothing has changed
    assertEquals(DirectedType.DIRECTED, lazyEdge.getDirectedType());
    Edge element = lazyEdge.getElement();
    assertEquals(DirectedType.DIRECTED, element.getDirectedType());
    assertFalse(lazyEdge.isUndirected());
    assertFalse(element.isUndirected());
    assertTrue(element.isDirected());
    assertTrue(lazyEdge.isDirected());
  }

  /**
   * Test {@link LazyEdge#putProperty(String, Object)}.
   *
   * <p>Method under test: {@link LazyEdge#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.putProperty(String, Object)"})
  void testPutProperty() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.putProperty("Name", "Value");

    // Assert
    Properties properties = lazyEdge.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
    LazyProperties properties2 = lazyEdge.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get((Object) "Name"));
  }

  /**
   * Test {@link LazyEdge#putProperty(String, Object)}.
   *
   * <p>Method under test: {@link LazyEdge#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.putProperty(String, Object)"})
  void testPutProperty2() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.putProperty(null, null);

    // Assert that nothing has changed
    assertTrue(lazyEdge.getElement().getProperties().isEmpty());
    assertTrue(lazyEdge.getProperties().isEmpty());
  }

  /**
   * Test {@link LazyEdge#putProperty(String, Object)}.
   *
   * <p>Method under test: {@link LazyEdge#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LazyEdge.putProperty(String, Object)"})
  void testPutProperty3() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.putProperty("Name", null);

    // Assert that nothing has changed
    assertTrue(lazyEdge.getElement().getProperties().isEmpty());
    assertTrue(lazyEdge.getProperties().isEmpty());
  }

  /**
   * Test {@link LazyEdge#getGroup()}.
   *
   * <p>Method under test: {@link LazyEdge#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String LazyEdge.getGroup()"})
  void testGetGroup() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act and Assert
    assertEquals("Group", lazyEdge.getGroup());
  }

  /**
   * Test {@link LazyEdge#getElement()}.
   *
   * <p>Method under test: {@link LazyEdge#getElement()}
   */
  @Test
  @DisplayName("Test getElement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge LazyEdge.getElement()"})
  void testGetElement() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    Edge actualElement = lazyEdge.getElement();

    // Assert
    assertEquals("Dest", actualElement.getDestination());
    assertEquals("Dest", actualElement.getAdjacentMatchedVertexValue());
    assertEquals("Group", actualElement.getGroup());
    assertEquals("Source", actualElement.getSource());
    assertEquals("Source", actualElement.getMatchedVertexValue());
    assertEquals("uk.gov.gchq.gaffer.data.element.Edge", actualElement.getClassName());
    assertEquals(DirectedType.DIRECTED, actualElement.getDirectedType());
    assertEquals(MatchedVertex.SOURCE, actualElement.getMatchedVertex());
    assertFalse(actualElement.isUndirected());
    assertTrue(actualElement.getProperties().isEmpty());
    assertTrue(actualElement.isDirected());
  }

  /**
   * Test {@link LazyEdge#getProperties()}.
   *
   * <p>Method under test: {@link LazyEdge#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LazyProperties LazyEdge.getProperties()"})
  void testGetProperties() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act and Assert
    assertTrue(lazyEdge.getProperties().isEmpty());
  }

  /**
   * Test {@link LazyEdge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_thenReturnFalse() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(false)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualIdentifier = lazyEdge.getIdentifier(IdentifierType.DIRECTED);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertFalse((Boolean) actualIdentifier);
  }

  /**
   * Test {@link LazyEdge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>When {@code ADJACENT_MATCHED_VERTEX}.
   *   <li>Then return {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName(
      "Test getIdentifier(IdentifierType); when 'ADJACENT_MATCHED_VERTEX'; then return 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenAdjacentMatchedVertex_thenReturnDest() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualIdentifier = lazyEdge.getIdentifier(IdentifierType.ADJACENT_MATCHED_VERTEX);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Dest", actualIdentifier);
  }

  /**
   * Test {@link LazyEdge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>When {@code DESTINATION}.
   *   <li>Then return {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); when 'DESTINATION'; then return 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenDestination_thenReturnDest() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualIdentifier = lazyEdge.getIdentifier(IdentifierType.DESTINATION);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Dest", actualIdentifier);
  }

  /**
   * Test {@link LazyEdge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>When {@code DIRECTED}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); when 'DIRECTED'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenDirected_thenReturnTrue() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualIdentifier = lazyEdge.getIdentifier(IdentifierType.DIRECTED);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertTrue((Boolean) actualIdentifier);
  }

  /**
   * Test {@link LazyEdge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>When {@code GROUP}.
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); when 'GROUP'; then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenGroup_thenReturnGroup() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualIdentifier = lazyEdge.getIdentifier(IdentifierType.GROUP);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Group", actualIdentifier);
  }

  /**
   * Test {@link LazyEdge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>When {@code MATCHED_VERTEX}.
   *   <li>Then return {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); when 'MATCHED_VERTEX'; then return 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenMatchedVertex_thenReturnSource() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualIdentifier = lazyEdge.getIdentifier(IdentifierType.MATCHED_VERTEX);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Source", actualIdentifier);
  }

  /**
   * Test {@link LazyEdge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>When {@code SOURCE}.
   *   <li>Then return {@code Source}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); when 'SOURCE'; then return 'Source'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenSource_thenReturnSource() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualIdentifier = lazyEdge.getIdentifier(IdentifierType.SOURCE);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Source", actualIdentifier);
  }

  /**
   * Test {@link LazyEdge#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>When {@code VERTEX}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); when 'VERTEX'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object LazyEdge.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenVertex_thenReturnNull() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualIdentifier = lazyEdge.getIdentifier(IdentifierType.VERTEX);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualIdentifier);
  }

  /**
   * Test {@link LazyEdge#getMatchedVertex()}.
   *
   * <p>Method under test: {@link LazyEdge#getMatchedVertex()}
   */
  @Test
  @DisplayName("Test getMatchedVertex()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MatchedVertex LazyEdge.getMatchedVertex()"})
  void testGetMatchedVertex() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    MatchedVertex actualMatchedVertex = lazyEdge.getMatchedVertex();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals(MatchedVertex.SOURCE, actualMatchedVertex);
  }

  /**
   * Test {@link LazyEdge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LazyEdge.equals(Object)", "int LazyEdge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge2 =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertNotEquals(lazyEdge, new LazyEdge(edge2, valueLoader));
  }

  /**
   * Test {@link LazyEdge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LazyEdge.equals(Object)", "int LazyEdge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builder = new Builder();
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));
    Edge edge2 =
        builder
            .dest(lazyEdge)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge2 = new LazyEdge(edge2, mock(ElementValueLoader.class));

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge3 =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertNotEquals(lazyEdge2, new LazyEdge(edge3, valueLoader));
  }

  /**
   * Test {@link LazyEdge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LazyEdge.equals(Object)", "int LazyEdge.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builder = new Builder();
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));
    Edge edge2 =
        builder
            .dest(lazyEdge)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge2 = new LazyEdge(edge2, mock(ElementValueLoader.class));

    // Act and Assert
    assertNotEquals(
        lazyEdge2,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
  }

  /**
   * Test {@link LazyEdge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LazyEdge.equals(Object)", "int LazyEdge.hashCode()"})
  void testEquals_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act and Assert
    assertEquals(
        lazyEdge,
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
  }

  /**
   * Test {@link LazyEdge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LazyEdge.equals(Object)", "int LazyEdge.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertNotEquals(new LazyEdge(edge, mock(ElementValueLoader.class)), null);
  }

  /**
   * Test {@link LazyEdge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is same; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LazyEdge.equals(Object)", "int LazyEdge.hashCode()"})
  void testEquals_whenOtherIsSame_thenReturnNotEqual() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertNotEquals(
        new LazyEdge(edge, mock(ElementValueLoader.class)),
        new LazyEdge(edge, mock(ElementValueLoader.class)));
  }

  /**
   * Test {@link LazyEdge#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEdge#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LazyEdge.equals(Object)", "int LazyEdge.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Edge edge =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertNotEquals(
        new LazyEdge(edge, mock(ElementValueLoader.class)), "Different type to LazyEdge");
  }
}
