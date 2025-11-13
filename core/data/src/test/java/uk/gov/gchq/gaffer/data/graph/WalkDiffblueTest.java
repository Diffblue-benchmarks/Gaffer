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

package uk.gov.gchq.gaffer.data.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamFlatMapIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.StreamIterable;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.LazyEntity;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.graph.Walk.Builder;

class WalkDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()", "Walk Builder.build()", "java.lang.String Builder.toString()"})
  void testBuilderBuild() {
    // Arrange and Act
    Walk actualBuildResult = (new Builder()).build();

    // Assert
    assertEquals(0, actualBuildResult.length());
    assertFalse(actualBuildResult.iterator().hasNext());
    assertTrue(actualBuildResult.getEdges().isEmpty());
    assertTrue(actualBuildResult.getEntities().isEmpty());
    assertTrue(actualBuildResult.getEntitiesAsEntries().isEmpty());
    assertTrue(actualBuildResult.getVerticesOrdered().isEmpty());
    assertTrue(actualBuildResult.getVertexSet().isEmpty());
    assertTrue(actualBuildResult.isPath());
  }

  /**
   * Test Builder {@link Builder#edge(Edge)}.
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build DestinationVertex is {@code Dest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#edge(Edge)}
   */
  @Test
  @DisplayName("Test Builder edge(Edge); then Builder (default constructor) build DestinationVertex is 'Dest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edge(Edge)"})
  void testBuilderEdge_thenBuilderBuildDestinationVertexIsDest() {
    // Arrange
    Builder builder = new Builder();
    Edge edge = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Builder actualEdgeResult = builder.edge(edge);

    // Assert
    Walk buildResult = builder.build();
    assertEquals("Dest", buildResult.getDestinationVertex());
    Walk buildResult2 = actualEdgeResult.build();
    assertEquals("Dest", buildResult2.getDestinationVertex());
    assertEquals("Source", buildResult.getSourceVertex());
    assertEquals("Source", buildResult2.getSourceVertex());
    assertEquals(2, buildResult.getVertexSet().size());
    assertEquals(2, buildResult2.getVertexSet().size());
    assertTrue(buildResult.isPath());
    assertTrue(buildResult2.isPath());
  }

  /**
   * Test Builder {@link Builder#edge(Edge)}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then {@link Builder} (default constructor) build DestinationVertex is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#edge(Edge)}
   */
  @Test
  @DisplayName("Test Builder edge(Edge); when Edge(String) with 'Group'; then Builder (default constructor) build DestinationVertex is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edge(Edge)"})
  void testBuilderEdge_whenEdgeWithGroup_thenBuilderBuildDestinationVertexIsNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgeResult = builder.edge(new Edge("Group"));

    // Assert
    Walk buildResult = builder.build();
    assertNull(buildResult.getDestinationVertex());
    Walk buildResult2 = actualEdgeResult.build();
    assertNull(buildResult2.getDestinationVertex());
    assertNull(buildResult.getSourceVertex());
    assertNull(buildResult2.getSourceVertex());
    assertEquals(1, buildResult.getVertexSet().size());
    assertEquals(1, buildResult2.getVertexSet().size());
    assertEquals(2, buildResult2.getEntitiesAsEntries().size());
    assertFalse(buildResult.isPath());
    assertFalse(buildResult2.isPath());
  }

  /**
   * Test Builder {@link Builder#edges(Edge[])} with {@code Edge[]}.
   * <p>
   * Method under test: {@link Builder#edges(Edge[])}
   */
  @Test
  @DisplayName("Test Builder edges(Edge[]) with 'Edge[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Edge[])"})
  void testBuilderEdgesWithEdge() {
    // Arrange
    Builder builder = new Builder();
    Edge buildResult = (new Edge.Builder()).dest(1)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult2 = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.edges(buildResult, buildResult2));
  }

  /**
   * Test Builder {@link Builder#edges(Edge[])} with {@code Edge[]}.
   * <p>
   * Method under test: {@link Builder#edges(Edge[])}
   */
  @Test
  @DisplayName("Test Builder edges(Edge[]) with 'Edge[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Edge[])"})
  void testBuilderEdgesWithEdge2() {
    // Arrange
    Builder builder = new Builder();

    Edge.Builder builder2 = new Edge.Builder();
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult2 = builder2.dest(buildResult)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult3 = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.edges(buildResult2, buildResult3));
  }

  /**
   * Test Builder {@link Builder#edges(Edge[])} with {@code Edge[]}.
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build DestinationVertex is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#edges(Edge[])}
   */
  @Test
  @DisplayName("Test Builder edges(Edge[]) with 'Edge[]'; then Builder (default constructor) build DestinationVertex is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Edge[])"})
  void testBuilderEdgesWithEdge_thenBuilderBuildDestinationVertexIsNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgesResult = builder.edges(new Edge("Group"));

    // Assert
    Walk buildResult = builder.build();
    assertNull(buildResult.getDestinationVertex());
    Walk buildResult2 = actualEdgesResult.build();
    assertNull(buildResult2.getDestinationVertex());
    assertNull(buildResult.getSourceVertex());
    assertNull(buildResult2.getSourceVertex());
    assertEquals(1, buildResult.getVertexSet().size());
    assertEquals(1, buildResult2.getVertexSet().size());
    assertEquals(2, buildResult2.getEntitiesAsEntries().size());
  }

  /**
   * Test Builder {@link Builder#edges(Edge[])} with {@code Edge[]}.
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#edges(Edge[])}
   */
  @Test
  @DisplayName("Test Builder edges(Edge[]) with 'Edge[]'; then Builder (default constructor) build length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Edge[])"})
  void testBuilderEdgesWithEdge_thenBuilderBuildLengthIsZero() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgesResult = builder.edges();

    // Assert
    Walk buildResult = builder.build();
    assertEquals(0, buildResult.length());
    Walk buildResult2 = actualEdgesResult.build();
    assertEquals(0, buildResult2.length());
    assertFalse(buildResult.iterator().hasNext());
    assertFalse(buildResult2.iterator().hasNext());
    assertTrue(buildResult2.getEdges().isEmpty());
    assertTrue(buildResult.getEntities().isEmpty());
    assertTrue(buildResult2.getEntities().isEmpty());
    assertTrue(buildResult2.getEntitiesAsEntries().isEmpty());
    assertTrue(buildResult.getVerticesOrdered().isEmpty());
    assertTrue(buildResult2.getVerticesOrdered().isEmpty());
    assertTrue(buildResult.getVertexSet().isEmpty());
    assertTrue(buildResult2.getVertexSet().isEmpty());
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Edge> edgeList = new ArrayList<>();
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeList.add(buildResult);

    Edge.Builder builder2 = new Edge.Builder();
    Edge buildResult2 = builder2.dest(new StreamFlatMapIterable<>(new ArrayList<>(), mock(Function.class)))
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeList.add(buildResult2);
    Stream<Edge> streamResult = edgeList.stream();
    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.edges(new StreamIterable<>(streamSupplier)));
    verify(streamSupplier).get();
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Edge> edgeList = new ArrayList<>();
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeList.add(buildResult);

    Edge.Builder builder2 = new Edge.Builder();
    Edge buildResult2 = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult3 = builder2.dest(buildResult2)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeList.add(buildResult3);
    Stream<Edge> streamResult = edgeList.stream();
    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.edges(new StreamIterable<>(streamSupplier)));
    verify(streamSupplier).get();
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable3() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Edge> edgeList = new ArrayList<>();
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeList.add(buildResult);

    Edge.Builder builder2 = new Edge.Builder();
    Edge buildResult2 = builder2.dest(new Edge("Group"))
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeList.add(buildResult2);
    Stream<Edge> streamResult = edgeList.stream();
    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.edges(new StreamIterable<>(streamSupplier)));
    verify(streamSupplier).get();
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable4() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Edge> edgeList = new ArrayList<>();

    Edge.Builder builder2 = new Edge.Builder();
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult2 = builder2.dest(buildResult)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeList.add(buildResult2);

    Edge.Builder builder3 = new Edge.Builder();
    Edge buildResult3 = builder3.dest(new StreamFlatMapIterable<>(new ArrayList<>(), mock(Function.class)))
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeList.add(buildResult3);
    Stream<Edge> streamResult = edgeList.stream();
    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.edges(new StreamIterable<>(streamSupplier)));
    verify(streamSupplier).get();
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable5() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Edge> edgeList = new ArrayList<>();

    Edge.Builder builder2 = new Edge.Builder();
    Edge edge = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult = builder2.dest(new LazyEdge(edge, mock(ElementValueLoader.class)))
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeList.add(buildResult);

    Edge.Builder builder3 = new Edge.Builder();
    Edge buildResult2 = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge.Builder matchedVertexResult = builder3.dest(buildResult2)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE);
    Edge buildResult3 = matchedVertexResult.source(new Edge("Group")).build();
    edgeList.add(buildResult3);
    Stream<Edge> streamResult = edgeList.stream();
    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.edges(new StreamIterable<>(streamSupplier)));
    verify(streamSupplier).get();
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} stream.</li>
   *   <li>Then {@link Builder} (default constructor) build length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'; given ArrayList() stream; then Builder (default constructor) build length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable_givenArrayListStream_thenBuilderBuildLengthIsZero() {
    // Arrange
    Builder builder = new Builder();
    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);

    ArrayList<Edge> edgeList = new ArrayList<>();
    Stream<Edge> streamResult = edgeList.stream();
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act
    Builder actualEdgesResult = builder.edges(new StreamIterable<>(streamSupplier));

    // Assert
    verify(streamSupplier).get();
    Walk buildResult = builder.build();
    assertEquals(0, buildResult.length());
    Walk buildResult2 = actualEdgesResult.build();
    assertEquals(0, buildResult2.length());
    assertFalse(buildResult.iterator().hasNext());
    assertFalse(buildResult2.iterator().hasNext());
    assertTrue(buildResult2.getEdges().isEmpty());
    assertTrue(buildResult.getEntities().isEmpty());
    assertTrue(buildResult2.getEntities().isEmpty());
    assertTrue(buildResult2.getEntitiesAsEntries().isEmpty());
    assertTrue(buildResult.getVerticesOrdered().isEmpty());
    assertTrue(buildResult2.getVerticesOrdered().isEmpty());
    assertTrue(buildResult2.getVertexSet().isEmpty());
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build VerticesOrdered size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'; then Builder (default constructor) build VerticesOrdered size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable_thenBuilderBuildVerticesOrderedSizeIsThree() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Edge> edgeList = new ArrayList<>();

    Edge.Builder builder2 = new Edge.Builder();
    Edge edge = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    Edge buildResult = builder2.dest(lazyEdge)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeList.add(buildResult);

    Edge.Builder builder3 = new Edge.Builder();
    Edge buildResult2 = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult3 = builder3.dest(buildResult2)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.DESTINATION)
        .source("Source")
        .build();
    edgeList.add(buildResult3);
    Stream<Edge> streamResult = edgeList.stream();
    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act
    Builder actualEdgesResult = builder.edges(new StreamIterable<>(streamSupplier));

    // Assert
    verify(streamSupplier).get();
    List<Object> verticesOrdered = builder.build().getVerticesOrdered();
    assertEquals(3, verticesOrdered.size());
    List<Object> verticesOrdered2 = actualEdgesResult.build().getVerticesOrdered();
    assertEquals(3, verticesOrdered2.size());
    assertSame(lazyEdge, verticesOrdered.get(1));
    assertSame(lazyEdge, verticesOrdered2.get(1));
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then calls {@link ElementValueLoader#loadIdentifiers(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'; then calls loadIdentifiers(Element)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable_thenCallsLoadIdentifiers() {
    // Arrange
    Builder builder = new Builder();
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    Edge buildResult = (new Edge.Builder()).dest(lazyEdge)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    ArrayList<Edge> edgeList = new ArrayList<>();
    edgeList.add(buildResult);

    Edge.Builder builder2 = new Edge.Builder();
    Edge buildResult2 = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult3 = builder2.dest(buildResult2)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeList.add(buildResult3);
    Stream<Edge> streamResult = edgeList.stream();
    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.edges(new StreamIterable<>(streamSupplier)));
    verify(streamSupplier).get();
    verify(valueLoader).loadIdentifiers(isA(Element.class));
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link Builder} (default constructor) build length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'; when ArrayList(); then Builder (default constructor) build length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable_whenArrayList_thenBuilderBuildLengthIsZero() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgesResult = builder.edges(new ArrayList<>());

    // Assert
    Walk buildResult = builder.build();
    assertEquals(0, buildResult.length());
    Walk buildResult2 = actualEdgesResult.build();
    assertEquals(0, buildResult2.length());
    assertFalse(buildResult.iterator().hasNext());
    assertFalse(buildResult2.iterator().hasNext());
    assertTrue(buildResult2.getEdges().isEmpty());
    assertTrue(buildResult.getEntities().isEmpty());
    assertTrue(buildResult2.getEntities().isEmpty());
    assertTrue(buildResult2.getEntitiesAsEntries().isEmpty());
    assertTrue(buildResult.getVerticesOrdered().isEmpty());
    assertTrue(buildResult2.getVerticesOrdered().isEmpty());
    assertTrue(buildResult2.getVertexSet().isEmpty());
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   * <p>
   * Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity() {
    // Arrange
    Builder builder = new Builder();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Entity buildResult = groupResult.vertex(new StreamFlatMapIterable<>(new ArrayList<>(), mock(Function.class)))
        .build();
    Entity buildResult2 = (new Entity.Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(buildResult, buildResult2));
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   * <p>
   * Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity2() {
    // Arrange
    Builder builder = new Builder();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult2 = groupResult.vertex(buildResult).build();
    Entity buildResult3 = (new Entity.Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(buildResult2, buildResult3));
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   * <p>
   * Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity3() {
    // Arrange
    Builder builder = new Builder();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Entity buildResult2 = groupResult.vertex(buildResult).build();
    Entity buildResult3 = (new Entity.Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(buildResult2, buildResult3));
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   * <p>
   * Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity4() {
    // Arrange
    Builder builder = new Builder();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Entity buildResult = groupResult.vertex(new Edge("Group")).build();
    Entity buildResult2 = (new Entity.Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(buildResult, buildResult2));
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   * <p>
   * Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity5() {
    // Arrange
    Builder builder = new Builder();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Entity.Builder groupResult2 = (new Entity.Builder()).group("Group");
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult2 = groupResult2.vertex(buildResult).build();
    Entity buildResult3 = groupResult.vertex(buildResult2).build();
    Entity buildResult4 = (new Entity.Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(buildResult3, buildResult4));
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   * <ul>
   *   <li>Then build DestinationVertex return {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'; then build DestinationVertex return Entity")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity_thenBuildDestinationVertexReturnEntity() {
    // Arrange
    Builder builder = new Builder();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult2 = groupResult.vertex(buildResult).build();
    Entity.Builder groupResult2 = (new Entity.Builder()).group("Group");
    Entity buildResult3 = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult4 = groupResult2.vertex(buildResult3).build();

    // Act and Assert
    Walk buildResult5 = builder.entities(buildResult2, buildResult4).build();
    Object destinationVertex = buildResult5.getDestinationVertex();
    assertTrue(destinationVertex instanceof Entity);
    assertEquals("Group", ((Entity) destinationVertex).getGroup());
    assertEquals("Vertex", ((Entity) destinationVertex).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", ((Entity) destinationVertex).getClassName());
    List<Object> verticesOrdered = buildResult5.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertTrue(((Entity) destinationVertex).getProperties().isEmpty());
    assertSame(destinationVertex, verticesOrdered.get(0));
    assertSame(destinationVertex, buildResult5.getSourceVertex());
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build VerticesOrdered first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'; then Builder (default constructor) build VerticesOrdered first is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity_thenBuilderBuildVerticesOrderedFirstIsNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntitiesResult = builder.entities(new Entity("Group"));

    // Assert
    Walk buildResult = builder.build();
    List<Object> verticesOrdered = buildResult.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertNull(verticesOrdered.get(0));
    Walk buildResult2 = actualEntitiesResult.build();
    List<Object> verticesOrdered2 = buildResult2.getVerticesOrdered();
    assertEquals(1, verticesOrdered2.size());
    assertNull(verticesOrdered2.get(0));
    assertNull(buildResult.getDestinationVertex());
    assertNull(buildResult2.getDestinationVertex());
    assertNull(buildResult.getSourceVertex());
    assertNull(buildResult2.getSourceVertex());
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build VerticesOrdered first is {@code Vertex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'; then Builder (default constructor) build VerticesOrdered first is 'Vertex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity_thenBuilderBuildVerticesOrderedFirstIsVertex() {
    // Arrange
    Builder builder = new Builder();
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult2 = (new Entity.Builder()).group("Group").vertex("Vertex").build();

    // Act
    Builder actualEntitiesResult = builder.entities(buildResult, buildResult2);

    // Assert
    Walk buildResult3 = builder.build();
    List<Object> verticesOrdered = buildResult3.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertEquals("Vertex", verticesOrdered.get(0));
    Walk buildResult4 = actualEntitiesResult.build();
    List<Object> verticesOrdered2 = buildResult4.getVerticesOrdered();
    assertEquals(1, verticesOrdered2.size());
    assertEquals("Vertex", verticesOrdered2.get(0));
    assertEquals("Vertex", buildResult3.getDestinationVertex());
    assertEquals("Vertex", buildResult4.getDestinationVertex());
    assertEquals("Vertex", buildResult3.getSourceVertex());
    assertEquals("Vertex", buildResult4.getSourceVertex());
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   * <ul>
   *   <li>Then return build Entities Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'; then return build Entities Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity_thenReturnBuildEntitiesEmpty() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    Walk buildResult = builder.entities().build();
    assertTrue(buildResult.getEntities().isEmpty());
    assertTrue(buildResult.getEntitiesAsEntries().isEmpty());
    assertTrue(builder.build().getVerticesOrdered().isEmpty());
    assertTrue(buildResult.getVerticesOrdered().isEmpty());
    assertTrue(buildResult.getVertexSet().isEmpty());
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Entity buildResult = groupResult.vertex(new StreamFlatMapIterable<>(new ArrayList<>(), mock(Function.class)))
        .build();
    entities.add(buildResult);
    Entity buildResult2 = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(entities));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Entity buildResult2 = groupResult.vertex(buildResult).build();
    entities.add(buildResult2);
    Entity buildResult3 = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(entities));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Given {@link Entity.Builder} (default constructor) group {@code Group} vertex {@link Edge#Edge(String)} with {@code Group} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable) with 'Iterable'; given Builder (default constructor) group 'Group' vertex Edge(String) with 'Group' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_givenBuilderGroupGroupVertexEdgeWithGroupBuild() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Entity buildResult = groupResult.vertex(new Edge("Group")).build();
    entities.add(buildResult);
    Entity buildResult2 = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(entities));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then build DestinationVertex return {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable) with 'Iterable'; then build DestinationVertex return Entity")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_thenBuildDestinationVertexReturnEntity() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult2 = groupResult.vertex(buildResult).build();
    entities.add(buildResult2);
    Entity.Builder groupResult2 = (new Entity.Builder()).group("Group");
    Entity buildResult3 = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult4 = groupResult2.vertex(buildResult3).build();
    entities.add(buildResult4);
    Entity buildResult5 = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult5);

    // Act and Assert
    Walk buildResult6 = builder.entities(entities).build();
    Object destinationVertex = buildResult6.getDestinationVertex();
    assertTrue(destinationVertex instanceof Entity);
    assertEquals("Group", ((Entity) destinationVertex).getGroup());
    assertEquals("Vertex", ((Entity) destinationVertex).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", ((Entity) destinationVertex).getClassName());
    List<Object> verticesOrdered = buildResult6.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertTrue(((Entity) destinationVertex).getProperties().isEmpty());
    assertSame(destinationVertex, verticesOrdered.get(0));
    assertSame(destinationVertex, buildResult6.getSourceVertex());
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build VerticesOrdered first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable) with 'Iterable'; then Builder (default constructor) build VerticesOrdered first is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_thenBuilderBuildVerticesOrderedFirstIsNull() {
    // Arrange
    Builder builder = new Builder();

    LinkedHashSet<Entity> entities = new LinkedHashSet<>();
    entities.add(new Entity("Group"));

    // Act
    Builder actualEntitiesResult = builder.entities(entities);

    // Assert
    Walk buildResult = builder.build();
    List<Object> verticesOrdered = buildResult.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertNull(verticesOrdered.get(0));
    Walk buildResult2 = actualEntitiesResult.build();
    List<Object> verticesOrdered2 = buildResult2.getVerticesOrdered();
    assertEquals(1, verticesOrdered2.size());
    assertNull(verticesOrdered2.get(0));
    assertNull(buildResult.getDestinationVertex());
    assertNull(buildResult2.getDestinationVertex());
    assertNull(buildResult.getSourceVertex());
    assertNull(buildResult2.getSourceVertex());
    List<Set<Entity>> entities2 = buildResult2.getEntities();
    assertEquals(1, entities2.size());
    assertEquals(entities, entities2.get(0));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then calls {@link ElementValueLoader#loadIdentifiers(Element)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable) with 'Iterable'; then calls loadIdentifiers(Element)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_thenCallsLoadIdentifiers() {
    // Arrange
    Builder builder = new Builder();
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Entity entity = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, valueLoader);

    Entity buildResult = (new Entity.Builder()).group("Group").vertex(lazyEntity).build();

    ArrayList<Entity> entities = new ArrayList<>();
    entities.add(buildResult);
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Entity buildResult2 = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult3 = groupResult.vertex(buildResult2).build();
    entities.add(buildResult3);
    Entity buildResult4 = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult4);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(entities));
    verify(valueLoader).loadIdentifiers(isA(Element.class));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then return build Entities first size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable) with 'Iterable'; then return build Entities first size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_thenReturnBuildEntitiesFirstSizeIsOne() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult);
    Entity buildResult2 = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult2);

    // Act
    Builder actualEntitiesResult = builder.entities(entities);

    // Assert
    Walk buildResult3 = builder.build();
    List<Object> verticesOrdered = buildResult3.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertEquals("Vertex", verticesOrdered.get(0));
    Walk buildResult4 = actualEntitiesResult.build();
    List<Object> verticesOrdered2 = buildResult4.getVerticesOrdered();
    assertEquals(1, verticesOrdered2.size());
    assertEquals("Vertex", verticesOrdered2.get(0));
    assertEquals("Vertex", buildResult3.getDestinationVertex());
    assertEquals("Vertex", buildResult4.getDestinationVertex());
    assertEquals("Vertex", buildResult3.getSourceVertex());
    assertEquals("Vertex", buildResult4.getSourceVertex());
    List<Set<Entity>> entities2 = buildResult4.getEntities();
    assertEquals(1, entities2.size());
    assertEquals(1, entities2.get(0).size());
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then return build Entities first size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable) with 'Iterable'; then return build Entities first size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_thenReturnBuildEntitiesFirstSizeIsTwo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult);
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Entity buildResult2 = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult3 = groupResult.vertex(buildResult2).build();
    entities.add(buildResult3);
    Entity buildResult4 = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult4);

    // Act
    Builder actualEntitiesResult = builder.entities(entities);

    // Assert
    Walk buildResult5 = builder.build();
    List<Object> verticesOrdered = buildResult5.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertEquals("Vertex", verticesOrdered.get(0));
    Walk buildResult6 = actualEntitiesResult.build();
    List<Object> verticesOrdered2 = buildResult6.getVerticesOrdered();
    assertEquals(1, verticesOrdered2.size());
    assertEquals("Vertex", verticesOrdered2.get(0));
    assertEquals("Vertex", buildResult5.getDestinationVertex());
    assertEquals("Vertex", buildResult6.getDestinationVertex());
    assertEquals("Vertex", buildResult5.getSourceVertex());
    assertEquals("Vertex", buildResult6.getSourceVertex());
    List<Set<Entity>> entities2 = buildResult6.getEntities();
    assertEquals(1, entities2.size());
    assertEquals(2, entities2.get(0).size());
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable) with 'Iterable'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_thenThrowIllegalArgumentException() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult2 = groupResult.vertex(buildResult).build();
    entities.add(buildResult2);
    Entity buildResult3 = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(entities));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build Entities Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable) with 'Iterable'; when ArrayList(); then return build Entities Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_whenArrayList_thenReturnBuildEntitiesEmpty() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    Walk buildResult = builder.entities(new ArrayList<>()).build();
    assertTrue(buildResult.getEntities().isEmpty());
    assertTrue(buildResult.getEntitiesAsEntries().isEmpty());
    assertTrue(builder.build().getVerticesOrdered().isEmpty());
    assertTrue(buildResult.getVerticesOrdered().isEmpty());
    assertTrue(buildResult.getVertexSet().isEmpty());
  }

  /**
   * Test Builder {@link Builder#entity(Entity)}.
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.</li>
   *   <li>Then {@link Builder} (default constructor) build DestinationVertex is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entity(Entity)}
   */
  @Test
  @DisplayName("Test Builder entity(Entity); when Entity(String) with 'Group'; then Builder (default constructor) build DestinationVertex is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entity(Entity)"})
  void testBuilderEntity_whenEntityWithGroup_thenBuilderBuildDestinationVertexIsNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntityResult = builder.entity(new Entity("Group"));

    // Assert
    Walk buildResult = builder.build();
    assertNull(buildResult.getDestinationVertex());
    assertNull(buildResult.getSourceVertex());
    assertEquals(1, buildResult.getEntities().size());
    assertEquals(1, buildResult.getVerticesOrdered().size());
    assertEquals(1, buildResult.getVertexSet().size());
    assertSame(builder, actualEntityResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Walk#Walk(List, List)}
   *   <li>{@link Walk#toString()}
   *   <li>{@link Walk#getEdges()}
   *   <li>{@link Walk#getEntitiesAsEntries()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Walk.<init>(List, List)", "List Walk.getEdges()", "List Walk.getEntitiesAsEntries()",
      "java.lang.String Walk.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();

    // Act
    Walk actualWalk = new Walk(edges, entities);
    actualWalk.toString();
    List<Set<Edge>> actualEdges = actualWalk.getEdges();
    List<Entry<Object, Set<Entity>>> actualEntitiesAsEntries = actualWalk.getEntitiesAsEntries();

    // Assert
    assertTrue(actualEdges.isEmpty());
    assertTrue(actualEntitiesAsEntries.isEmpty());
    assertSame(edges, actualEdges);
    assertSame(entities, actualEntitiesAsEntries);
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code 42} and {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName("Test getEntitiesForVertex(Object); given ArrayList() add SimpleEntry(Object, Object) with '42' and HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex_givenArrayListAddSimpleEntryWith42AndHashSet() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new SimpleEntry<>("42", new HashSet<>()));

    // Act and Assert
    assertTrue((new Walk(new ArrayList<>(), entities)).getEntitiesForVertex("Vertex").isEmpty());
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code 42} and {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName("Test getEntitiesForVertex(Object); given ArrayList() add SimpleEntry(Object, Object) with '42' and HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex_givenArrayListAddSimpleEntryWith42AndHashSet2() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new SimpleEntry<>("42", new HashSet<>()));
    entities.add(new SimpleEntry<>("42", new HashSet<>()));

    // Act and Assert
    assertTrue((new Walk(new ArrayList<>(), entities)).getEntitiesForVertex("Vertex").isEmpty());
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName("Test getEntitiesForVertex(Object); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex_thenReturnEmpty() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).getEntitiesForVertex("Vertex").isEmpty());
  }

  /**
   * Test {@link Walk#getEntitiesAtDistance(int)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#getEntitiesAtDistance(int)}
   */
  @Test
  @DisplayName("Test getEntitiesAtDistance(int); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Walk.getEntitiesAtDistance(int)"})
  void testGetEntitiesAtDistance_thenReturnEmpty() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new SimpleEntry<>("42", new HashSet<>()));
    entities.add(new SimpleEntry<>("42", new HashSet<>()));

    // Act and Assert
    assertTrue((new Walk(new ArrayList<>(), entities)).getEntitiesAtDistance(1).isEmpty());
  }

  /**
   * Test {@link Walk#getEntities()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#getEntities()}
   */
  @Test
  @DisplayName("Test getEntities(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Walk.getEntities()"})
  void testGetEntities_thenReturnEmpty() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).getEntities().isEmpty());
  }

  /**
   * Test {@link Walk#getVerticesOrdered()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#getVerticesOrdered()}
   */
  @Test
  @DisplayName("Test getVerticesOrdered(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Walk.getVerticesOrdered()"})
  void testGetVerticesOrdered_thenReturnEmpty() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).getVerticesOrdered().isEmpty());
  }

  /**
   * Test {@link Walk#getVertexSet()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#getVertexSet()}
   */
  @Test
  @DisplayName("Test getVertexSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Walk.getVertexSet()"})
  void testGetVertexSet_thenReturnEmpty() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).getVertexSet().isEmpty());
  }

  /**
   * Test {@link Walk#length()}.
   * <p>
   * Method under test: {@link Walk#length()}
   */
  @Test
  @DisplayName("Test length()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Walk.length()"})
  void testLength() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertEquals(0, (new Walk(edges, new ArrayList<>())).length());
  }

  /**
   * Test {@link Walk#isTrail()}.
   * <p>
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeSet.add(buildResult);

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet);
    edges.add(new HashSet<>());

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   * <p>
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail2() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeSet.add(buildResult);

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet);
    edges.add(new HashSet<>());

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   * <p>
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail3() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();

    Edge.Builder builder = new Edge.Builder();
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult2 = builder.dest(buildResult)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeSet.add(buildResult2);

    HashSet<Edge> edgeSet2 = new HashSet<>();
    Edge buildResult3 = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeSet2.add(buildResult3);

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet2);
    edges.add(edgeSet);

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   * <p>
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail4() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();

    Edge.Builder builder = new Edge.Builder();
    Edge buildResult = builder.dest(new Edge("Group"))
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeSet.add(buildResult);

    HashSet<Edge> edgeSet2 = new HashSet<>();
    Edge buildResult2 = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeSet2.add(buildResult2);

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet2);
    edges.add(edgeSet);

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail(); given ArrayList() add HashSet(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail_givenArrayListAddHashSet_thenReturnFalse() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(new HashSet<>());
    edges.add(new HashSet<>());

    // Act and Assert
    assertFalse((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail_thenReturnFalse() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();
    Edge buildResult = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeSet.add(buildResult);

    HashSet<Edge> edgeSet2 = new HashSet<>();
    Edge buildResult2 = (new Edge.Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    edgeSet2.add(buildResult2);

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet2);
    edges.add(edgeSet);

    // Act and Assert
    assertFalse((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail_thenReturnTrue() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Test {@link Walk#isPath()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code 42} and {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#isPath()}
   */
  @Test
  @DisplayName("Test isPath(); given ArrayList() add SimpleEntry(Object, Object) with '42' and HashSet(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.isPath()"})
  void testIsPath_givenArrayListAddSimpleEntryWith42AndHashSet_thenReturnFalse() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new SimpleEntry<>("42", new HashSet<>()));
    entities.add(new SimpleEntry<>("42", new HashSet<>()));

    // Act and Assert
    assertFalse((new Walk(new ArrayList<>(), entities)).isPath());
  }

  /**
   * Test {@link Walk#isPath()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code 42} and {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#isPath()}
   */
  @Test
  @DisplayName("Test isPath(); given ArrayList() add SimpleEntry(Object, Object) with '42' and HashSet(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.isPath()"})
  void testIsPath_givenArrayListAddSimpleEntryWith42AndHashSet_thenReturnTrue() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new SimpleEntry<>("42", new HashSet<>()));

    // Act and Assert
    assertTrue((new Walk(new ArrayList<>(), entities)).isPath());
  }

  /**
   * Test {@link Walk#isPath()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#isPath()}
   */
  @Test
  @DisplayName("Test isPath(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.isPath()"})
  void testIsPath_thenReturnTrue() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).isPath());
  }

  /**
   * Test {@link Walk#getSourceVertex()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code 42} and {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#getSourceVertex()}
   */
  @Test
  @DisplayName("Test getSourceVertex(); given ArrayList() add SimpleEntry(Object, Object) with '42' and HashSet(); then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Walk.getSourceVertex()"})
  void testGetSourceVertex_givenArrayListAddSimpleEntryWith42AndHashSet_thenReturn42() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new SimpleEntry<>("42", new HashSet<>()));

    // Act and Assert
    assertEquals("42", (new Walk(new ArrayList<>(), entities)).getSourceVertex());
  }

  /**
   * Test {@link Walk#getDestinationVertex()}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#getDestinationVertex()}
   */
  @Test
  @DisplayName("Test getDestinationVertex(); then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Walk.getDestinationVertex()"})
  void testGetDestinationVertex_thenReturn42() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new SimpleEntry<>("42", new HashSet<>()));

    // Act and Assert
    assertEquals("42", (new Walk(new ArrayList<>(), entities)).getDestinationVertex());
  }

  /**
   * Test {@link Walk#equals(Object)}, and {@link Walk#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Walk#equals(Object)}
   *   <li>{@link Walk#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.equals(Object)", "int Walk.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Walk buildResult = (new Builder()).build();
    Walk buildResult2 = (new Builder()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link Walk#equals(Object)}, and {@link Walk#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Walk#equals(Object)}
   *   <li>{@link Walk#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.equals(Object)", "int Walk.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Walk buildResult = (new Builder()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link Walk#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.equals(Object)", "int Walk.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Walk buildResult = (new Builder()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link Walk#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Walk#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Walk.equals(Object)", "int Walk.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Walk buildResult = (new Builder()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to Walk");
  }

  /**
   * Test {@link Walk#iterator()}.
   * <p>
   * Method under test: {@link Walk#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Iterator Walk.iterator()"})
  void testIterator() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertFalse((new Walk(edges, new ArrayList<>())).iterator().hasNext());
  }
}
