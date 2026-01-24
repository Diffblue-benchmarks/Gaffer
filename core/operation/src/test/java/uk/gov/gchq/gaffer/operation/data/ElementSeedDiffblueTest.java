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

package uk.gov.gchq.gaffer.operation.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import uk.gov.gchq.gaffer.data.element.IdentifierType;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.element.id.EntityId;

class ElementSeedDiffblueTest {
  /**
   * Test {@link ElementSeed#createSeed(EdgeId)} with {@code edgeId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(EdgeId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(EdgeId) with 'edgeId'; then return AdjacentMatchedVertexValue is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeSeed ElementSeed.createSeed(EdgeId)"})
  void testCreateSeedWithEdgeId_thenReturnAdjacentMatchedVertexValueIsDest() {
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

    LazyEdge edgeId = new LazyEdge(edge, valueLoader);
    edgeId.putIdentifier(IdentifierType.DIRECTED, "Value");

    // Act
    EdgeSeed actualCreateSeedResult = ElementSeed.createSeed((EdgeId) edgeId);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Dest", actualCreateSeedResult.getAdjacentMatchedVertexValue());
    assertEquals("Dest", actualCreateSeedResult.getSource());
    assertEquals("Source", actualCreateSeedResult.getMatchedVertexValue());
    assertEquals("Source", actualCreateSeedResult.getDestination());
    assertEquals(DirectedType.UNDIRECTED, actualCreateSeedResult.getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, actualCreateSeedResult.getMatchedVertex());
    assertFalse(actualCreateSeedResult.isDirected());
    assertTrue(actualCreateSeedResult.isUndirected());
  }

  /**
   * Test {@link ElementSeed#createSeed(EdgeId)} with {@code edgeId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(EdgeId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(EdgeId) with 'edgeId'; then return AdjacentMatchedVertexValue is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeSeed ElementSeed.createSeed(EdgeId)"})
  void testCreateSeedWithEdgeId_thenReturnAdjacentMatchedVertexValueIsNull() {
    // Arrange and Act
    EdgeSeed actualCreateSeedResult = ElementSeed.createSeed((EdgeId) new Edge("Group"));

    // Assert
    assertNull(actualCreateSeedResult.getAdjacentMatchedVertexValue());
    assertNull(actualCreateSeedResult.getMatchedVertexValue());
    assertNull(actualCreateSeedResult.getDestination());
    assertNull(actualCreateSeedResult.getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(EdgeId)} with {@code edgeId}.
   *
   * <ul>
   *   <li>Then return Destination is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(EdgeId)}
   */
  @Test
  @DisplayName("Test createSeed(EdgeId) with 'edgeId'; then return Destination is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeSeed ElementSeed.createSeed(EdgeId)"})
  void testCreateSeedWithEdgeId_thenReturnDestinationIsDest() {
    // Arrange
    Edge edgeId =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    EdgeSeed actualCreateSeedResult = ElementSeed.createSeed((EdgeId) edgeId);

    // Assert
    assertEquals("Dest", actualCreateSeedResult.getDestination());
    assertEquals("Source", actualCreateSeedResult.getSource());
    assertEquals(DirectedType.DIRECTED, actualCreateSeedResult.getDirectedType());
    assertFalse(actualCreateSeedResult.isUndirected());
    assertTrue(actualCreateSeedResult.isDirected());
  }

  /**
   * Test {@link ElementSeed#createSeed(EdgeId)} with {@code edgeId}.
   *
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.
   *   <li>Then return {@link EdgeSeed#EdgeSeed()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(EdgeId)}
   */
  @Test
  @DisplayName("Test createSeed(EdgeId) with 'edgeId'; when EdgeSeed(); then return EdgeSeed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeSeed ElementSeed.createSeed(EdgeId)"})
  void testCreateSeedWithEdgeId_whenEdgeSeed_thenReturnEdgeSeed() {
    // Arrange
    EdgeSeed edgeId = new EdgeSeed();

    // Act
    EdgeSeed actualCreateSeedResult = ElementSeed.createSeed((EdgeId) edgeId);

    // Assert
    assertEquals(edgeId, actualCreateSeedResult);
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then AdjacentMatchedVertexValue return {@link Edge}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; then AdjacentMatchedVertexValue return Edge")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenAdjacentMatchedVertexValueReturnEdge() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    Builder builder = new Builder();
    Edge edge =
        builder
            .dest(
                new Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge elementId = new LazyEdge(edge, valueLoader);
    elementId.putIdentifier(IdentifierType.DIRECTED, "Value");

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    Object adjacentMatchedVertexValue =
        ((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue instanceof Edge);
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals("Dest", ((Edge) adjacentMatchedVertexValue).getDestination());
    assertEquals("Dest", ((Edge) adjacentMatchedVertexValue).getAdjacentMatchedVertexValue());
    assertEquals("Source", ((Edge) adjacentMatchedVertexValue).getSource());
    assertEquals("Source", ((Edge) adjacentMatchedVertexValue).getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, ((Edge) adjacentMatchedVertexValue).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) adjacentMatchedVertexValue).getMatchedVertex());
    assertFalse(((Edge) adjacentMatchedVertexValue).isUndirected());
    assertTrue(((Edge) adjacentMatchedVertexValue).isDirected());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then AdjacentMatchedVertexValue Vertex return {@link Entity}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; then AdjacentMatchedVertexValue Vertex return Entity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenAdjacentMatchedVertexValueVertexReturnEntity() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    Builder builder = new Builder();

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    Edge edge =
        builder
            .dest(
                groupResult
                    .vertex(new Entity.Builder().group("Group").vertex("Vertex").build())
                    .build())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge elementId = new LazyEdge(edge, valueLoader);
    elementId.putIdentifier(IdentifierType.DIRECTED, "Value");

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    Object adjacentMatchedVertexValue =
        ((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue();
    Object vertex = ((Entity) adjacentMatchedVertexValue).getVertex();
    assertTrue(vertex instanceof Entity);
    assertTrue(adjacentMatchedVertexValue instanceof Entity);
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals("Group", ((Entity) vertex).getGroup());
    assertEquals("Vertex", ((Entity) vertex).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", ((Entity) vertex).getClassName());
    assertSame(adjacentMatchedVertexValue, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; then return AdjacentMatchedVertexValue is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnAdjacentMatchedVertexValueIsDest() {
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

    LazyEdge elementId = new LazyEdge(edge, valueLoader);
    elementId.putIdentifier(IdentifierType.DIRECTED, "Value");

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals("Dest", ((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue());
    assertEquals("Dest", ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@link EdgeSeed#EdgeSeed()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; then return AdjacentMatchedVertexValue is EdgeSeed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnAdjacentMatchedVertexValueIsEdgeSeed() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    Builder builder = new Builder();
    EdgeSeed edgeSeed = new EdgeSeed();
    Edge edge =
        builder
            .dest(edgeSeed)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge elementId = new LazyEdge(edge, valueLoader);
    elementId.putIdentifier(IdentifierType.DIRECTED, "Value");

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertSame(edgeSeed, ((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue());
    assertSame(edgeSeed, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; then return AdjacentMatchedVertexValue is Edge(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnAdjacentMatchedVertexValueIsEdgeWithGroup() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    Builder builder = new Builder();
    Edge edge = new Edge("Group");
    Edge edge2 =
        builder
            .dest(edge)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge elementId = new LazyEdge(edge2, valueLoader);
    elementId.putIdentifier(IdentifierType.DIRECTED, "Value");

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertSame(edge, ((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue());
    assertSame(edge, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@link EntitySeed#EntitySeed()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; then return AdjacentMatchedVertexValue is EntitySeed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnAdjacentMatchedVertexValueIsEntitySeed() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    Builder builder = new Builder();
    EntitySeed entitySeed = new EntitySeed();
    Edge edge =
        builder
            .dest(entitySeed)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge elementId = new LazyEdge(edge, valueLoader);
    elementId.putIdentifier(IdentifierType.DIRECTED, "Value");

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertSame(entitySeed, ((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue());
    assertSame(entitySeed, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; then return AdjacentMatchedVertexValue is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnAdjacentMatchedVertexValueIsNull() {
    // Arrange and Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) new Edge("Group"));

    // Assert
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertNull(((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue());
    assertNull(((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue());
    assertNull(((EdgeSeed) actualCreateSeedResult).getDestination());
    assertNull(((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue Vertex is {@link EdgeSeed#EdgeSeed()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; then return AdjacentMatchedVertexValue Vertex is EdgeSeed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnAdjacentMatchedVertexValueVertexIsEdgeSeed() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    Builder builder = new Builder();

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    EdgeSeed edgeSeed = new EdgeSeed();
    Edge edge =
        builder
            .dest(groupResult.vertex(edgeSeed).build())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge elementId = new LazyEdge(edge, valueLoader);
    elementId.putIdentifier(IdentifierType.DIRECTED, "Value");

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    Object adjacentMatchedVertexValue =
        ((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue instanceof Entity);
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertSame(edgeSeed, ((Entity) adjacentMatchedVertexValue).getVertex());
    assertSame(adjacentMatchedVertexValue, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue Vertex is {@code Vertex}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; then return AdjacentMatchedVertexValue Vertex is 'Vertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnAdjacentMatchedVertexValueVertexIsVertex() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    Builder builder = new Builder();
    Edge edge =
        builder
            .dest(new Entity.Builder().group("Group").vertex("Vertex").build())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge elementId = new LazyEdge(edge, valueLoader);
    elementId.putIdentifier(IdentifierType.DIRECTED, "Value");

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    Object adjacentMatchedVertexValue =
        ((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue instanceof Entity);
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals("Vertex", ((Entity) adjacentMatchedVertexValue).getVertex());
    assertEquals(
        "uk.gov.gchq.gaffer.data.element.Entity",
        ((Entity) adjacentMatchedVertexValue).getClassName());
    assertSame(adjacentMatchedVertexValue, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then return Destination is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'; then return Destination is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnDestinationIsDest() {
    // Arrange
    Edge elementId =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals("Dest", ((EdgeSeed) actualCreateSeedResult).getDestination());
    assertEquals("Source", ((EdgeSeed) actualCreateSeedResult).getSource());
    assertEquals(DirectedType.DIRECTED, ((EdgeSeed) actualCreateSeedResult).getDirectedType());
    assertFalse(((EdgeSeed) actualCreateSeedResult).isUndirected());
    assertTrue(((EdgeSeed) actualCreateSeedResult).isDirected());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>Then return MatchedVertexValue is {@link EntitySeed#EntitySeed()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; then return MatchedVertexValue is EntitySeed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnMatchedVertexValueIsEntitySeed() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    Builder builder = new Builder();

    Builder matchedVertexResult =
        builder
            .dest(new EdgeSeed())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE);
    EntitySeed entitySeed = new EntitySeed();
    Edge edge = matchedVertexResult.source(entitySeed).build();

    LazyEdge elementId = new LazyEdge(edge, valueLoader);
    elementId.putIdentifier(IdentifierType.DIRECTED, "Value");

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertSame(entitySeed, ((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue());
    assertSame(entitySeed, ((EdgeSeed) actualCreateSeedResult).getDestination());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.
   *   <li>Then return {@link EdgeSeed#EdgeSeed()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; when EdgeSeed(); then return EdgeSeed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_whenEdgeSeed_thenReturnEdgeSeed() {
    // Arrange
    EdgeSeed elementId = new EdgeSeed();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals(elementId, actualCreateSeedResult);
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   *   <li>Then return {@link EntitySeed}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(ElementId) with 'elementId'; when EntitySeed(); then return EntitySeed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_whenEntitySeed_thenReturnEntitySeed() {
    // Arrange
    EntitySeed elementId = new EntitySeed();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    assertTrue(actualCreateSeedResult instanceof EntitySeed);
    assertEquals(elementId, actualCreateSeedResult);
  }

  /**
   * Test {@link ElementSeed#createSeed(EntityId)} with {@code entityId}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   *   <li>Then return {@link EntitySeed#EntitySeed()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementSeed#createSeed(EntityId)}
   */
  @Test
  @DisplayName(
      "Test createSeed(EntityId) with 'entityId'; when EntitySeed(); then return EntitySeed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntitySeed ElementSeed.createSeed(EntityId)"})
  void testCreateSeedWithEntityId_whenEntitySeed_thenReturnEntitySeed() {
    // Arrange
    EntitySeed entityId = new EntitySeed();

    // Act
    EntitySeed actualCreateSeedResult = ElementSeed.createSeed((EntityId) entityId);

    // Assert
    assertEquals(entityId, actualCreateSeedResult);
  }
}
