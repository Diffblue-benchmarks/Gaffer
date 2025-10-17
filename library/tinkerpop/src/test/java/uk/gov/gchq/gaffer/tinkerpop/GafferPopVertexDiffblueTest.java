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

package uk.gov.gchq.gaffer.tinkerpop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.tinkerpop.gremlin.structure.Direction;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Graph.Features;
import org.apache.tinkerpop.gremlin.structure.Graph.Features.VertexFeatures;
import org.apache.tinkerpop.gremlin.structure.Graph.Features.VertexPropertyFeatures;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.VertexProperty;
import org.apache.tinkerpop.gremlin.structure.VertexProperty.Cardinality;
import org.apache.tinkerpop.gremlin.structure.util.empty.EmptyVertexProperty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;

class GafferPopVertexDiffblueTest {
  /**
   * Test {@link GafferPopVertex#property(Cardinality, String, Object, Object[])} with {@code
   * cardinality}, {@code key}, {@code value}, {@code keyValues}.
   *
   * <p>Method under test: {@link GafferPopVertex#property(VertexProperty.Cardinality, String,
   * Object, Object[])}
   */
  @Test
  @DisplayName(
      "Test property(Cardinality, String, Object, Object[]) with 'cardinality', 'key', 'value', 'keyValues'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "VertexProperty GafferPopVertex.property(VertexProperty.Cardinality, String, Object, Object[])"
  })
  void testPropertyWithCardinalityKeyValueKeyValues() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    doNothing().when(graph).addVertex(Mockito.<GafferPopVertex>any());
    when(graph.features()).thenReturn(new GafferPopGraphFeatures());
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", graph);

    // Act
    VertexProperty<Object> actualPropertyResult =
        gafferPopVertex.property(Cardinality.single, "Key", "Value");

    // Assert
    verify(graph).addVertex(isA(GafferPopVertex.class));
    verify(graph, atLeast(1)).features();
    assertTrue(actualPropertyResult instanceof GafferPopVertexProperty);
    Object idResult = actualPropertyResult.id();
    assertEquals("[Id,Key,Value]", idResult);
    assertEquals("[Id,Key,Value]", ((GafferPopVertexProperty<Object>) actualPropertyResult).id);
    assertNull(((GafferPopVertexProperty<Object>) actualPropertyResult).properties);
    assertSame(gafferPopVertex, actualPropertyResult.element());
    assertSame(((GafferPopElement) actualPropertyResult).id, idResult);
  }

  /**
   * Test {@link GafferPopVertex#property(Cardinality, String, Object, Object[])} with {@code
   * cardinality}, {@code key}, {@code value}, {@code keyValues}.
   *
   * <p>Method under test: {@link GafferPopVertex#property(VertexProperty.Cardinality, String,
   * Object, Object[])}
   */
  @Test
  @DisplayName(
      "Test property(Cardinality, String, Object, Object[]) with 'cardinality', 'key', 'value', 'keyValues'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "VertexProperty GafferPopVertex.property(VertexProperty.Cardinality, String, Object, Object[])"
  })
  void testPropertyWithCardinalityKeyValueKeyValues2() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    doThrow(new UnsupportedOperationException())
        .when(graph)
        .addVertex(Mockito.<GafferPopVertex>any());
    when(graph.features()).thenReturn(new GafferPopGraphFeatures());
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", graph);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> gafferPopVertex.property(Cardinality.single, "Key", "Value"));
    verify(graph).addVertex(isA(GafferPopVertex.class));
    verify(graph, atLeast(1)).features();
  }

  /**
   * Test {@link GafferPopVertex#property(Cardinality, String, Object, Object[])} with {@code
   * cardinality}, {@code key}, {@code value}, {@code keyValues}.
   *
   * <ul>
   *   <li>Then calls {@link VertexPropertyFeatures#supportsNullPropertyValues()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertex#property(VertexProperty.Cardinality, String,
   * Object, Object[])}
   */
  @Test
  @DisplayName(
      "Test property(Cardinality, String, Object, Object[]) with 'cardinality', 'key', 'value', 'keyValues'; then calls supportsNullPropertyValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "VertexProperty GafferPopVertex.property(VertexProperty.Cardinality, String, Object, Object[])"
  })
  void testPropertyWithCardinalityKeyValueKeyValues_thenCallsSupportsNullPropertyValues() {
    // Arrange
    VertexPropertyFeatures vertexPropertyFeatures = mock(VertexPropertyFeatures.class);
    when(vertexPropertyFeatures.supportsNullPropertyValues()).thenReturn(false);

    VertexFeatures vertexFeatures = mock(VertexFeatures.class);
    when(vertexFeatures.properties()).thenReturn(vertexPropertyFeatures);

    GafferPopGraphFeatures gafferPopGraphFeatures = mock(GafferPopGraphFeatures.class);
    when(gafferPopGraphFeatures.vertex()).thenReturn(vertexFeatures);

    GafferPopGraph graph = mock(GafferPopGraph.class);
    doNothing().when(graph).addVertex(Mockito.<GafferPopVertex>any());
    when(graph.features()).thenReturn(gafferPopGraphFeatures);
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", graph);

    // Act
    VertexProperty<Object> actualPropertyResult =
        gafferPopVertex.property(Cardinality.single, "Key", "Value");

    // Assert
    verify(vertexFeatures, atLeast(1)).properties();
    verify(vertexPropertyFeatures, atLeast(1)).supportsNullPropertyValues();
    verify(graph).addVertex(isA(GafferPopVertex.class));
    verify(graph, atLeast(1)).features();
    verify(gafferPopGraphFeatures, atLeast(1)).vertex();
    assertTrue(actualPropertyResult instanceof GafferPopVertexProperty);
    Object idResult = actualPropertyResult.id();
    assertEquals("[Id,Key,Value]", idResult);
    assertEquals("[Id,Key,Value]", ((GafferPopVertexProperty<Object>) actualPropertyResult).id);
    assertNull(((GafferPopVertexProperty<Object>) actualPropertyResult).properties);
    assertSame(gafferPopVertex, actualPropertyResult.element());
    assertSame(((GafferPopElement) actualPropertyResult).id, idResult);
  }

  /**
   * Test {@link GafferPopVertex#property(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@link EmptyVertexProperty}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertex#property(String)}
   */
  @Test
  @DisplayName("Test property(String) with 'key'; then return EmptyVertexProperty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"VertexProperty GafferPopVertex.property(String)"})
  void testPropertyWithKey_thenReturnEmptyVertexProperty() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act
    VertexProperty<Object> actualPropertyResult = gafferPopVertex.property("Key");

    // Assert
    assertTrue(actualPropertyResult instanceof EmptyVertexProperty);
    assertFalse(actualPropertyResult.isPresent());
  }

  /**
   * Test {@link GafferPopVertex#properties(String[])}.
   *
   * <ul>
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertex#properties(String[])}
   */
  @Test
  @DisplayName("Test properties(String[]); then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopVertex.properties(String[])"})
  void testProperties_thenReturnNotHasNext() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act and Assert
    assertFalse(gafferPopVertex.properties("Property Keys").hasNext());
  }

  /**
   * Test {@link GafferPopVertex#propertyWithoutUpdate(Cardinality, String, Object, Object[])}.
   *
   * <p>Method under test: {@link GafferPopVertex#propertyWithoutUpdate(VertexProperty.Cardinality,
   * String, Object, Object[])}
   */
  @Test
  @DisplayName("Test propertyWithoutUpdate(Cardinality, String, Object, Object[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "VertexProperty GafferPopVertex.propertyWithoutUpdate(VertexProperty.Cardinality, String, Object, Object[])"
  })
  void testPropertyWithoutUpdate() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.features()).thenReturn(new GafferPopGraphFeatures());
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", graph);

    // Act
    VertexProperty<Object> actualPropertyWithoutUpdateResult =
        gafferPopVertex.propertyWithoutUpdate(Cardinality.single, "Key", "Value");

    // Assert
    verify(graph, atLeast(1)).features();
    assertTrue(actualPropertyWithoutUpdateResult instanceof GafferPopVertexProperty);
    Object idResult = actualPropertyWithoutUpdateResult.id();
    assertEquals("[Id,Key,Value]", idResult);
    assertEquals(
        "[Id,Key,Value]", ((GafferPopVertexProperty<Object>) actualPropertyWithoutUpdateResult).id);
    assertNull(((GafferPopVertexProperty<Object>) actualPropertyWithoutUpdateResult).properties);
    assertSame(gafferPopVertex, actualPropertyWithoutUpdateResult.element());
    assertSame(((GafferPopElement) actualPropertyWithoutUpdateResult).id, idResult);
  }

  /**
   * Test {@link GafferPopVertex#propertyWithoutUpdate(Cardinality, String, Object, Object[])}.
   *
   * <ul>
   *   <li>Then calls {@link VertexPropertyFeatures#supportsNullPropertyValues()}.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertex#propertyWithoutUpdate(VertexProperty.Cardinality,
   * String, Object, Object[])}
   */
  @Test
  @DisplayName(
      "Test propertyWithoutUpdate(Cardinality, String, Object, Object[]); then calls supportsNullPropertyValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "VertexProperty GafferPopVertex.propertyWithoutUpdate(VertexProperty.Cardinality, String, Object, Object[])"
  })
  void testPropertyWithoutUpdate_thenCallsSupportsNullPropertyValues() {
    // Arrange
    VertexPropertyFeatures vertexPropertyFeatures = mock(VertexPropertyFeatures.class);
    when(vertexPropertyFeatures.supportsNullPropertyValues()).thenReturn(false);

    VertexFeatures vertexFeatures = mock(VertexFeatures.class);
    when(vertexFeatures.properties()).thenReturn(vertexPropertyFeatures);

    GafferPopGraphFeatures gafferPopGraphFeatures = mock(GafferPopGraphFeatures.class);
    when(gafferPopGraphFeatures.vertex()).thenReturn(vertexFeatures);

    GafferPopGraph graph = mock(GafferPopGraph.class);
    when(graph.features()).thenReturn(gafferPopGraphFeatures);
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", graph);

    // Act
    VertexProperty<Object> actualPropertyWithoutUpdateResult =
        gafferPopVertex.propertyWithoutUpdate(Cardinality.single, "Key", "Value");

    // Assert
    verify(vertexFeatures, atLeast(1)).properties();
    verify(vertexPropertyFeatures, atLeast(1)).supportsNullPropertyValues();
    verify(graph, atLeast(1)).features();
    verify(gafferPopGraphFeatures, atLeast(1)).vertex();
    assertTrue(actualPropertyWithoutUpdateResult instanceof GafferPopVertexProperty);
    Object idResult = actualPropertyWithoutUpdateResult.id();
    assertEquals("[Id,Key,Value]", idResult);
    assertEquals(
        "[Id,Key,Value]", ((GafferPopVertexProperty<Object>) actualPropertyWithoutUpdateResult).id);
    assertNull(((GafferPopVertexProperty<Object>) actualPropertyWithoutUpdateResult).properties);
    assertSame(gafferPopVertex, actualPropertyWithoutUpdateResult.element());
    assertSame(((GafferPopElement) actualPropertyWithoutUpdateResult).id, idResult);
  }

  /**
   * Test {@link GafferPopVertex#edges(Direction, String[])} with {@code direction}, {@code
   * edgeLabels}.
   *
   * <ul>
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertex#edges(Direction, String[])}
   */
  @Test
  @DisplayName(
      "Test edges(Direction, String[]) with 'direction', 'edgeLabels'; then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopVertex.edges(Direction, String[])"})
  void testEdgesWithDirectionEdgeLabels_thenReturnNotHasNext() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);

    ArrayList<Edge> edgeList = new ArrayList<>();
    when(graph.edgesWithView(Mockito.<Object>any(), Mockito.<Direction>any(), Mockito.<View>any()))
        .thenReturn(edgeList.iterator());
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", graph);

    // Act
    Iterator<Edge> actualEdgesResult = gafferPopVertex.edges(Direction.OUT, "Edge Labels");

    // Assert
    verify(graph).edgesWithView(isA(Object.class), eq(Direction.OUT), isA(View.class));
    assertFalse(actualEdgesResult.hasNext());
  }

  /**
   * Test {@link GafferPopVertex#edges(Direction, View)} with {@code direction}, {@code view}.
   *
   * <ul>
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertex#edges(Direction, View)}
   */
  @Test
  @DisplayName("Test edges(Direction, View) with 'direction', 'view'; then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopVertex.edges(Direction, View)"})
  void testEdgesWithDirectionView_thenReturnNotHasNext() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);

    ArrayList<Edge> edgeList = new ArrayList<>();
    when(graph.edgesWithView(Mockito.<Object>any(), Mockito.<Direction>any(), Mockito.<View>any()))
        .thenReturn(edgeList.iterator());
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", graph);

    // Act
    Iterator<Edge> actualEdgesResult = gafferPopVertex.edges(Direction.OUT, new View());

    // Assert
    verify(graph).edgesWithView(isA(Object.class), eq(Direction.OUT), isA(View.class));
    assertFalse(actualEdgesResult.hasNext());
  }

  /**
   * Test {@link GafferPopVertex#vertices(Direction, String[])} with {@code direction}, {@code
   * edgeLabels}.
   *
   * <ul>
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertex#vertices(Direction, String[])}
   */
  @Test
  @DisplayName(
      "Test vertices(Direction, String[]) with 'direction', 'edgeLabels'; then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopVertex.vertices(Direction, String[])"})
  void testVerticesWithDirectionEdgeLabels_thenReturnNotHasNext() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);

    ArrayList<Vertex> vertexList = new ArrayList<>();
    when(graph.adjVertices(
            Mockito.<Object>any(), Mockito.<Direction>any(), (String[]) Mockito.any()))
        .thenReturn(vertexList.iterator());
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", graph);

    // Act
    Iterator<Vertex> actualVerticesResult = gafferPopVertex.vertices(Direction.OUT, "Edge Labels");

    // Assert
    verify(graph).adjVertices(isA(Object.class), eq(Direction.OUT), (String[]) Mockito.any());
    assertFalse(actualVerticesResult.hasNext());
  }

  /**
   * Test {@link GafferPopVertex#vertices(Direction, View)} with {@code direction}, {@code view}.
   *
   * <ul>
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertex#vertices(Direction, View)}
   */
  @Test
  @DisplayName("Test vertices(Direction, View) with 'direction', 'view'; then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator GafferPopVertex.vertices(Direction, View)"})
  void testVerticesWithDirectionView_thenReturnNotHasNext() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);

    ArrayList<Vertex> vertexList = new ArrayList<>();
    when(graph.adjVerticesWithView(
            Mockito.<Object>any(), Mockito.<Direction>any(), Mockito.<View>any()))
        .thenReturn(vertexList.iterator());
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", graph);

    // Act
    Iterator<Vertex> actualVerticesResult = gafferPopVertex.vertices(Direction.OUT, new View());

    // Assert
    verify(graph).adjVerticesWithView(isA(Object.class), eq(Direction.OUT), isA(View.class));
    assertFalse(actualVerticesResult.hasNext());
  }

  /**
   * Test {@link GafferPopVertex#keys()}.
   *
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code
   *       Label} and {@code Id} and graph is {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link GafferPopVertex#keys()}
   */
  @Test
  @DisplayName(
      "Test keys(); given GafferPopVertex(String, Object, GafferPopGraph) with 'Label' and 'Id' and graph is 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set GafferPopVertex.keys()"})
  void testKeys_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnEmpty() {
    // Arrange
    GafferPopVertex gafferPopVertex = new GafferPopVertex("Label", "Id", null);

    // Act and Assert
    assertTrue(gafferPopVertex.keys().isEmpty());
  }
}
