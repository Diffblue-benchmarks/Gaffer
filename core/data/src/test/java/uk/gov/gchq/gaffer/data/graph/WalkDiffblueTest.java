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
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Builder.<init>()",
    "Walk Builder.build()",
    "java.lang.String Builder.toString()"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Walk actualWalk = new Builder().build();

    // Assert
    assertEquals(0, actualWalk.length());
    assertFalse(actualWalk.iterator().hasNext());
    assertTrue(actualWalk.getEdges().isEmpty());
    assertTrue(actualWalk.getEntities().isEmpty());
    assertTrue(actualWalk.getEntitiesAsEntries().isEmpty());
    assertTrue(actualWalk.getVerticesOrdered().isEmpty());
    assertTrue(actualWalk.getVertexSet().isEmpty());
    assertTrue(actualWalk.isPath());
  }

  /**
   * Test Builder {@link Builder#edge(Edge)}.
   *
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build DestinationVertex is {@code Dest}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#edge(Edge)}
   */
  @Test
  @DisplayName(
      "Test Builder edge(Edge); then Builder (default constructor) build DestinationVertex is 'Dest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edge(Edge)"})
  void testBuilderEdge_thenBuilderBuildDestinationVertexIsDest() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgeResult =
        builder.edge(
            new Edge.Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    Walk walk = builder.build();
    assertEquals("Dest", walk.getDestinationVertex());
    Walk walk2 = actualEdgeResult.build();
    assertEquals("Dest", walk2.getDestinationVertex());
    assertEquals("Source", walk.getSourceVertex());
    assertEquals("Source", walk2.getSourceVertex());
    assertEquals(2, walk.getVertexSet().size());
    assertEquals(2, walk2.getVertexSet().size());
    assertTrue(walk.isPath());
    assertTrue(walk2.isPath());
  }

  /**
   * Test Builder {@link Builder#edge(Edge)}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then {@link Builder} (default constructor) build DestinationVertex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#edge(Edge)}
   */
  @Test
  @DisplayName(
      "Test Builder edge(Edge); when Edge(String) with 'Group'; then Builder (default constructor) build DestinationVertex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edge(Edge)"})
  void testBuilderEdge_whenEdgeWithGroup_thenBuilderBuildDestinationVertexIsNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgeResult = builder.edge(new Edge("Group"));

    // Assert
    Walk walk = builder.build();
    assertNull(walk.getDestinationVertex());
    Walk walk2 = actualEdgeResult.build();
    assertNull(walk2.getDestinationVertex());
    assertNull(walk.getSourceVertex());
    assertNull(walk2.getSourceVertex());
    assertEquals(1, walk.getVertexSet().size());
    assertEquals(1, walk2.getVertexSet().size());
    assertEquals(2, walk2.getEntitiesAsEntries().size());
    assertFalse(walk.isPath());
    assertFalse(walk2.isPath());
  }

  /**
   * Test Builder {@link Builder#edges(Edge[])} with {@code Edge[]}.
   *
   * <p>Method under test: {@link Builder#edges(Edge[])}
   */
  @Test
  @DisplayName("Test Builder edges(Edge[]) with 'Edge[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Edge[])"})
  void testBuilderEdgesWithEdge() {
    // Arrange
    Builder builder = new Builder();
    Edge edge =
        new Edge.Builder()
            .dest(1)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            builder.edges(
                edge,
                new Edge.Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build()));
  }

  /**
   * Test Builder {@link Builder#edges(Edge[])} with {@code Edge[]}.
   *
   * <p>Method under test: {@link Builder#edges(Edge[])}
   */
  @Test
  @DisplayName("Test Builder edges(Edge[]) with 'Edge[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Edge[])"})
  void testBuilderEdgesWithEdge2() {
    // Arrange
    Builder builder = new Builder();

    Edge.Builder builder2 = new Edge.Builder();
    Edge edge =
        builder2
            .dest(
                new Edge.Builder()
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            builder.edges(
                edge,
                new Edge.Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build()));
  }

  /**
   * Test Builder {@link Builder#edges(Edge[])} with {@code Edge[]}.
   *
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build DestinationVertex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#edges(Edge[])}
   */
  @Test
  @DisplayName(
      "Test Builder edges(Edge[]) with 'Edge[]'; then Builder (default constructor) build DestinationVertex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Edge[])"})
  void testBuilderEdgesWithEdge_thenBuilderBuildDestinationVertexIsNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgesResult = builder.edges(new Edge("Group"));

    // Assert
    Walk walk = builder.build();
    assertNull(walk.getDestinationVertex());
    Walk walk2 = actualEdgesResult.build();
    assertNull(walk2.getDestinationVertex());
    assertNull(walk.getSourceVertex());
    assertNull(walk2.getSourceVertex());
    assertEquals(1, walk.getVertexSet().size());
    assertEquals(1, walk2.getVertexSet().size());
    assertEquals(2, walk2.getEntitiesAsEntries().size());
  }

  /**
   * Test Builder {@link Builder#edges(Edge[])} with {@code Edge[]}.
   *
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build length is zero.
   * </ul>
   *
   * <p>Method under test: {@link Builder#edges(Edge[])}
   */
  @Test
  @DisplayName(
      "Test Builder edges(Edge[]) with 'Edge[]'; then Builder (default constructor) build length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Edge[])"})
  void testBuilderEdgesWithEdge_thenBuilderBuildLengthIsZero() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgesResult = builder.edges();

    // Assert
    Walk walk = builder.build();
    assertEquals(0, walk.length());
    Walk walk2 = actualEdgesResult.build();
    assertEquals(0, walk2.length());
    assertFalse(walk.iterator().hasNext());
    assertFalse(walk2.iterator().hasNext());
    assertTrue(walk2.getEdges().isEmpty());
    assertTrue(walk.getEntities().isEmpty());
    assertTrue(walk2.getEntities().isEmpty());
    assertTrue(walk2.getEntitiesAsEntries().isEmpty());
    assertTrue(walk.getVerticesOrdered().isEmpty());
    assertTrue(walk2.getVerticesOrdered().isEmpty());
    assertTrue(walk.getVertexSet().isEmpty());
    assertTrue(walk2.getVertexSet().isEmpty());
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Edge> edgeList = new ArrayList<>();
    edgeList.add(
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    edgeList.add(
        new Edge.Builder()
            .dest(1)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    Stream<Edge> streamResult = edgeList.stream();

    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> builder.edges(new StreamIterable<>(streamSupplier)));
    verify(streamSupplier).get();
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Edge> edgeList = new ArrayList<>();
    edgeList.add(
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    Edge.Builder builder2 = new Edge.Builder();
    edgeList.add(
        builder2
            .dest(
                new Edge.Builder()
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
            .build());
    Stream<Edge> streamResult = edgeList.stream();

    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> builder.edges(new StreamIterable<>(streamSupplier)));
    verify(streamSupplier).get();
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable3() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Edge> edgeList = new ArrayList<>();
    edgeList.add(
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    Edge.Builder builder2 = new Edge.Builder();
    edgeList.add(
        builder2
            .dest(new Edge("Group"))
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    Stream<Edge> streamResult = edgeList.stream();

    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> builder.edges(new StreamIterable<>(streamSupplier)));
    verify(streamSupplier).get();
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable4() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Edge> edgeList = new ArrayList<>();

    Edge.Builder builder2 = new Edge.Builder();
    edgeList.add(
        builder2
            .dest(
                new Edge.Builder()
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
            .build());
    edgeList.add(
        new Edge.Builder()
            .dest(1)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());
    Stream<Edge> streamResult = edgeList.stream();

    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> builder.edges(new StreamIterable<>(streamSupplier)));
    verify(streamSupplier).get();
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable5() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Edge> edgeList = new ArrayList<>();

    Edge.Builder builder2 = new Edge.Builder();
    Edge edge =
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));
    edgeList.add(
        builder2
            .dest(lazyEdge)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    Edge.Builder builder3 = new Edge.Builder();

    Edge.Builder matchedVertexResult =
        builder3
            .dest(
                new Edge.Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE);
    edgeList.add(matchedVertexResult.source(new Edge("Group")).build());
    Stream<Edge> streamResult = edgeList.stream();

    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> builder.edges(new StreamIterable<>(streamSupplier)));
    verify(streamSupplier).get();
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} stream.
   *   <li>Then {@link Builder} (default constructor) build length is zero.
   * </ul>
   *
   * <p>Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder edges(Iterable) with 'Iterable'; given ArrayList() stream; then Builder (default constructor) build length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    Walk walk = builder.build();
    assertEquals(0, walk.length());
    Walk walk2 = actualEdgesResult.build();
    assertEquals(0, walk2.length());
    assertFalse(walk.iterator().hasNext());
    assertFalse(walk2.iterator().hasNext());
    assertTrue(walk2.getEdges().isEmpty());
    assertTrue(walk.getEntities().isEmpty());
    assertTrue(walk2.getEntities().isEmpty());
    assertTrue(walk2.getEntitiesAsEntries().isEmpty());
    assertTrue(walk.getVerticesOrdered().isEmpty());
    assertTrue(walk2.getVerticesOrdered().isEmpty());
    assertTrue(walk2.getVertexSet().isEmpty());
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build VerticesOrdered size is three.
   * </ul>
   *
   * <p>Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder edges(Iterable) with 'Iterable'; then Builder (default constructor) build VerticesOrdered size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable_thenBuilderBuildVerticesOrderedSizeIsThree() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Edge> edgeList = new ArrayList<>();

    Edge.Builder builder2 = new Edge.Builder();
    Edge edge =
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));
    edgeList.add(
        builder2
            .dest(lazyEdge)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    Edge.Builder builder3 = new Edge.Builder();
    edgeList.add(
        builder3
            .dest(
                new Edge.Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build())
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.DESTINATION)
            .source("Source")
            .build());
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
   *
   * <ul>
   *   <li>Then calls {@link ElementValueLoader#loadIdentifiers(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName("Test Builder edges(Iterable) with 'Iterable'; then calls loadIdentifiers(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable_thenCallsLoadIdentifiers() {
    // Arrange
    Builder builder = new Builder();

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge =
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);
    Edge edge2 =
        new Edge.Builder()
            .dest(lazyEdge)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();

    ArrayList<Edge> edgeList = new ArrayList<>();
    edgeList.add(edge2);

    Edge.Builder builder2 = new Edge.Builder();
    edgeList.add(
        builder2
            .dest(
                new Edge.Builder()
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
            .build());
    Stream<Edge> streamResult = edgeList.stream();

    Supplier<Stream<Edge>> streamSupplier = mock(Supplier.class);
    when(streamSupplier.get()).thenReturn(streamResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> builder.edges(new StreamIterable<>(streamSupplier)));
    verify(streamSupplier).get();
    verify(valueLoader).loadIdentifiers(isA(Element.class));
  }

  /**
   * Test Builder {@link Builder#edges(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link Builder} (default constructor) build length is zero.
   * </ul>
   *
   * <p>Method under test: {@link Builder#edges(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder edges(Iterable) with 'Iterable'; when ArrayList(); then Builder (default constructor) build length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.edges(Iterable)"})
  void testBuilderEdgesWithIterable_whenArrayList_thenBuilderBuildLengthIsZero() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgesResult = builder.edges(new ArrayList<>());

    // Assert
    Walk walk = builder.build();
    assertEquals(0, walk.length());
    Walk walk2 = actualEdgesResult.build();
    assertEquals(0, walk2.length());
    assertFalse(walk.iterator().hasNext());
    assertFalse(walk2.iterator().hasNext());
    assertTrue(walk2.getEdges().isEmpty());
    assertTrue(walk.getEntities().isEmpty());
    assertTrue(walk2.getEntities().isEmpty());
    assertTrue(walk2.getEntitiesAsEntries().isEmpty());
    assertTrue(walk.getVerticesOrdered().isEmpty());
    assertTrue(walk2.getVerticesOrdered().isEmpty());
    assertTrue(walk2.getVertexSet().isEmpty());
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   *
   * <p>Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity() {
    // Arrange
    Builder builder = new Builder();
    Entity entity = new Entity.Builder().group("Group").vertex(1).build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            builder.entities(entity, new Entity.Builder().group("Group").vertex("Vertex").build()));
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   *
   * <p>Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity2() {
    // Arrange
    Builder builder = new Builder();

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    Entity entity =
        groupResult.vertex(new Entity.Builder().group("Group").vertex("Vertex").build()).build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            builder.entities(entity, new Entity.Builder().group("Group").vertex("Vertex").build()));
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   *
   * <p>Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity3() {
    // Arrange
    Builder builder = new Builder();

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    Entity entity =
        groupResult
            .vertex(
                new Edge.Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build())
            .build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            builder.entities(entity, new Entity.Builder().group("Group").vertex("Vertex").build()));
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   *
   * <p>Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity4() {
    // Arrange
    Builder builder = new Builder();

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    Entity entity = groupResult.vertex(new Edge("Group")).build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            builder.entities(entity, new Entity.Builder().group("Group").vertex("Vertex").build()));
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   *
   * <p>Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity5() {
    // Arrange
    Builder builder = new Builder();

    Entity.Builder groupResult = new Entity.Builder().group("Group");

    Entity.Builder groupResult2 = new Entity.Builder().group("Group");
    Entity entity =
        groupResult
            .vertex(
                groupResult2
                    .vertex(new Entity.Builder().group("Group").vertex("Vertex").build())
                    .build())
            .build();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            builder.entities(entity, new Entity.Builder().group("Group").vertex("Vertex").build()));
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   *
   * <ul>
   *   <li>Then build DestinationVertex return {@link Entity}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Entity[]) with 'Entity[]'; then build DestinationVertex return Entity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity_thenBuildDestinationVertexReturnEntity() {
    // Arrange
    Builder builder = new Builder();

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    Entity entity =
        groupResult.vertex(new Entity.Builder().group("Group").vertex("Vertex").build()).build();

    Entity.Builder groupResult2 = new Entity.Builder().group("Group");

    // Act and Assert
    Walk walk =
        builder
            .entities(
                entity,
                groupResult2
                    .vertex(new Entity.Builder().group("Group").vertex("Vertex").build())
                    .build())
            .build();
    Object destinationVertex = walk.getDestinationVertex();
    assertTrue(destinationVertex instanceof Entity);
    assertEquals("Group", ((Entity) destinationVertex).getGroup());
    assertEquals("Vertex", ((Entity) destinationVertex).getVertex());
    assertEquals(
        "uk.gov.gchq.gaffer.data.element.Entity", ((Entity) destinationVertex).getClassName());
    List<Object> verticesOrdered = walk.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertTrue(((Entity) destinationVertex).getProperties().isEmpty());
    assertSame(destinationVertex, verticesOrdered.get(0));
    assertSame(destinationVertex, walk.getSourceVertex());
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   *
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build VerticesOrdered first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Entity[]) with 'Entity[]'; then Builder (default constructor) build VerticesOrdered first is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity_thenBuilderBuildVerticesOrderedFirstIsNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntitiesResult = builder.entities(new Entity("Group"));

    // Assert
    Walk walk = builder.build();
    List<Object> verticesOrdered = walk.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertNull(verticesOrdered.get(0));
    Walk walk2 = actualEntitiesResult.build();
    List<Object> verticesOrdered2 = walk2.getVerticesOrdered();
    assertEquals(1, verticesOrdered2.size());
    assertNull(verticesOrdered2.get(0));
    assertNull(walk.getDestinationVertex());
    assertNull(walk2.getDestinationVertex());
    assertNull(walk.getSourceVertex());
    assertNull(walk2.getSourceVertex());
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   *
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build VerticesOrdered first is {@code Vertex}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Entity[]) with 'Entity[]'; then Builder (default constructor) build VerticesOrdered first is 'Vertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity_thenBuilderBuildVerticesOrderedFirstIsVertex() {
    // Arrange
    Builder builder = new Builder();
    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();

    // Act
    Builder actualEntitiesResult =
        builder.entities(entity, new Entity.Builder().group("Group").vertex("Vertex").build());

    // Assert
    Walk walk = builder.build();
    List<Object> verticesOrdered = walk.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertEquals("Vertex", verticesOrdered.get(0));
    Walk walk2 = actualEntitiesResult.build();
    List<Object> verticesOrdered2 = walk2.getVerticesOrdered();
    assertEquals(1, verticesOrdered2.size());
    assertEquals("Vertex", verticesOrdered2.get(0));
    assertEquals("Vertex", walk.getDestinationVertex());
    assertEquals("Vertex", walk2.getDestinationVertex());
    assertEquals("Vertex", walk.getSourceVertex());
    assertEquals("Vertex", walk2.getSourceVertex());
  }

  /**
   * Test Builder {@link Builder#entities(Entity[])} with {@code Entity[]}.
   *
   * <ul>
   *   <li>Then return build Entities Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Entity[])}
   */
  @Test
  @DisplayName("Test Builder entities(Entity[]) with 'Entity[]'; then return build Entities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Entity[])"})
  void testBuilderEntitiesWithEntity_thenReturnBuildEntitiesEmpty() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    Walk walk = builder.entities().build();
    assertTrue(walk.getEntities().isEmpty());
    assertTrue(walk.getEntitiesAsEntries().isEmpty());
    assertTrue(builder.build().getVerticesOrdered().isEmpty());
    assertTrue(walk.getVerticesOrdered().isEmpty());
    assertTrue(walk.getVertexSet().isEmpty());
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entities(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    entities.add(
        groupResult
            .vertex(
                new Edge.Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build())
            .build());
    entities.add(new Entity.Builder().group("Group").vertex("Vertex").build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(entities));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@link Entity.Builder} (default constructor) group {@code Group} vertex {@link
   *       Edge#Edge(String)} with {@code Group} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Iterable) with 'Iterable'; given Builder (default constructor) group 'Group' vertex Edge(String) with 'Group' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_givenBuilderGroupGroupVertexEdgeWithGroupBuild() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    entities.add(groupResult.vertex(new Edge("Group")).build());
    entities.add(new Entity.Builder().group("Group").vertex("Vertex").build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(entities));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@link Entity.Builder} (default constructor) group {@code Group} vertex one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Iterable) with 'Iterable'; given Builder (default constructor) group 'Group' vertex one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_givenBuilderGroupGroupVertexOneBuild() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();
    entities.add(new Entity.Builder().group("Group").vertex(1).build());
    entities.add(new Entity.Builder().group("Group").vertex("Vertex").build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(entities));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then build DestinationVertex return {@link Entity}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Iterable) with 'Iterable'; then build DestinationVertex return Entity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_thenBuildDestinationVertexReturnEntity() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    entities.add(
        groupResult.vertex(new Entity.Builder().group("Group").vertex("Vertex").build()).build());

    Entity.Builder groupResult2 = new Entity.Builder().group("Group");
    entities.add(
        groupResult2.vertex(new Entity.Builder().group("Group").vertex("Vertex").build()).build());
    entities.add(new Entity.Builder().group("Group").vertex("Vertex").build());

    // Act and Assert
    Walk walk = builder.entities(entities).build();
    Object destinationVertex = walk.getDestinationVertex();
    assertTrue(destinationVertex instanceof Entity);
    assertEquals("Group", ((Entity) destinationVertex).getGroup());
    assertEquals("Vertex", ((Entity) destinationVertex).getVertex());
    assertEquals(
        "uk.gov.gchq.gaffer.data.element.Entity", ((Entity) destinationVertex).getClassName());
    List<Object> verticesOrdered = walk.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertTrue(((Entity) destinationVertex).getProperties().isEmpty());
    assertSame(destinationVertex, verticesOrdered.get(0));
    assertSame(destinationVertex, walk.getSourceVertex());
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build VerticesOrdered first is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Iterable) with 'Iterable'; then Builder (default constructor) build VerticesOrdered first is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_thenBuilderBuildVerticesOrderedFirstIsNull() {
    // Arrange
    Builder builder = new Builder();

    LinkedHashSet<Entity> entities = new LinkedHashSet<>();
    entities.add(new Entity("Group"));

    // Act
    Builder actualEntitiesResult = builder.entities(entities);

    // Assert
    Walk walk = builder.build();
    List<Object> verticesOrdered = walk.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertNull(verticesOrdered.get(0));
    Walk walk2 = actualEntitiesResult.build();
    List<Object> verticesOrdered2 = walk2.getVerticesOrdered();
    assertEquals(1, verticesOrdered2.size());
    assertNull(verticesOrdered2.get(0));
    assertNull(walk.getDestinationVertex());
    assertNull(walk2.getDestinationVertex());
    assertNull(walk.getSourceVertex());
    assertNull(walk2.getSourceVertex());
    List<Set<Entity>> entities2 = walk2.getEntities();
    assertEquals(1, entities2.size());
    assertEquals(entities, entities2.get(0));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then calls {@link ElementValueLoader#loadIdentifiers(Element)}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Iterable) with 'Iterable'; then calls loadIdentifiers(Element)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_thenCallsLoadIdentifiers() {
    // Arrange
    Builder builder = new Builder();

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Entity entity = new Entity.Builder().group("Group").vertex("Vertex").build();

    LazyEntity lazyEntity = new LazyEntity(entity, valueLoader);
    Entity entity2 = new Entity.Builder().group("Group").vertex(lazyEntity).build();

    ArrayList<Entity> entities = new ArrayList<>();
    entities.add(entity2);

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    entities.add(
        groupResult.vertex(new Entity.Builder().group("Group").vertex("Vertex").build()).build());
    entities.add(new Entity.Builder().group("Group").vertex("Vertex").build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(entities));
    verify(valueLoader).loadIdentifiers(isA(Element.class));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then return build Entities first size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Iterable) with 'Iterable'; then return build Entities first size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_thenReturnBuildEntitiesFirstSizeIsOne() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();
    entities.add(new Entity.Builder().group("Group").vertex("Vertex").build());
    entities.add(new Entity.Builder().group("Group").vertex("Vertex").build());

    // Act
    Builder actualEntitiesResult = builder.entities(entities);

    // Assert
    Walk walk = builder.build();
    List<Object> verticesOrdered = walk.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertEquals("Vertex", verticesOrdered.get(0));
    Walk walk2 = actualEntitiesResult.build();
    List<Object> verticesOrdered2 = walk2.getVerticesOrdered();
    assertEquals(1, verticesOrdered2.size());
    assertEquals("Vertex", verticesOrdered2.get(0));
    assertEquals("Vertex", walk.getDestinationVertex());
    assertEquals("Vertex", walk2.getDestinationVertex());
    assertEquals("Vertex", walk.getSourceVertex());
    assertEquals("Vertex", walk2.getSourceVertex());
    List<Set<Entity>> entities2 = walk2.getEntities();
    assertEquals(1, entities2.size());
    assertEquals(1, entities2.get(0).size());
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then return build Entities first size is two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Iterable) with 'Iterable'; then return build Entities first size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_thenReturnBuildEntitiesFirstSizeIsTwo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();
    entities.add(new Entity.Builder().group("Group").vertex("Vertex").build());

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    entities.add(
        groupResult.vertex(new Entity.Builder().group("Group").vertex("Vertex").build()).build());
    entities.add(new Entity.Builder().group("Group").vertex("Vertex").build());

    // Act
    Builder actualEntitiesResult = builder.entities(entities);

    // Assert
    Walk walk = builder.build();
    List<Object> verticesOrdered = walk.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertEquals("Vertex", verticesOrdered.get(0));
    Walk walk2 = actualEntitiesResult.build();
    List<Object> verticesOrdered2 = walk2.getVerticesOrdered();
    assertEquals(1, verticesOrdered2.size());
    assertEquals("Vertex", verticesOrdered2.get(0));
    assertEquals("Vertex", walk.getDestinationVertex());
    assertEquals("Vertex", walk2.getDestinationVertex());
    assertEquals("Vertex", walk.getSourceVertex());
    assertEquals("Vertex", walk2.getSourceVertex());
    List<Set<Entity>> entities2 = walk2.getEntities();
    assertEquals(1, entities2.size());
    assertEquals(2, entities2.get(0).size());
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Iterable) with 'Iterable'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_thenThrowIllegalArgumentException() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Entity> entities = new ArrayList<>();

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    entities.add(
        groupResult.vertex(new Entity.Builder().group("Group").vertex("Vertex").build()).build());
    entities.add(new Entity.Builder().group("Group").vertex("Vertex").build());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> builder.entities(entities));
  }

  /**
   * Test Builder {@link Builder#entities(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return build Entities Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entities(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder entities(Iterable) with 'Iterable'; when ArrayList(); then return build Entities Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entities(Iterable)"})
  void testBuilderEntitiesWithIterable_whenArrayList_thenReturnBuildEntitiesEmpty() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    Walk walk = builder.entities(new ArrayList<>()).build();
    assertTrue(walk.getEntities().isEmpty());
    assertTrue(walk.getEntitiesAsEntries().isEmpty());
    assertTrue(builder.build().getVerticesOrdered().isEmpty());
    assertTrue(walk.getVerticesOrdered().isEmpty());
    assertTrue(walk.getVertexSet().isEmpty());
  }

  /**
   * Test Builder {@link Builder#entity(Entity)}.
   *
   * <ul>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.
   *   <li>Then {@link Builder} (default constructor) build DestinationVertex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entity(Entity)}
   */
  @Test
  @DisplayName(
      "Test Builder entity(Entity); when Entity(String) with 'Group'; then Builder (default constructor) build DestinationVertex is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entity(Entity)"})
  void testBuilderEntity_whenEntityWithGroup_thenBuilderBuildDestinationVertexIsNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntityResult = builder.entity(new Entity("Group"));

    // Assert
    Walk walk = builder.build();
    assertNull(walk.getDestinationVertex());
    assertNull(walk.getSourceVertex());
    assertEquals(1, walk.getEntities().size());
    assertEquals(1, walk.getVerticesOrdered().size());
    assertEquals(1, walk.getVertexSet().size());
    assertSame(builder, actualEntityResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Walk#Walk(List, List)}
   *   <li>{@link Walk#toString()}
   *   <li>{@link Walk#getEdges()}
   *   <li>{@link Walk#getEntitiesAsEntries()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Walk.<init>(List, List)",
    "List Walk.getEdges()",
    "List Walk.getEntitiesAsEntries()",
    "java.lang.String Walk.toString()"
  })
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
   *
   * <p>Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName("Test getEntitiesForVertex(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex() {
    // Arrange
    HashSet<Entity> entitySet = new HashSet<>();
    entitySet.add(new Entity.Builder().group("Group").vertex(0).build());

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    entitySet.add(
        groupResult.vertex(new Entity.Builder().group("Group").vertex("Vertex").build()).build());
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("Vertex", entitySet);

    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertEquals(entitySet, walk.getEntitiesForVertex("Vertex"));
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   *
   * <p>Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName("Test getEntitiesForVertex(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex2() {
    // Arrange
    HashSet<Entity> entitySet = new HashSet<>();
    entitySet.add(new Entity.Builder().group("Group").vertex(0).build());

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    entitySet.add(
        groupResult
            .vertex(
                new Edge.Builder()
                    .dest("Dest")
                    .directed(true)
                    .group("Group")
                    .matchedVertex(MatchedVertex.SOURCE)
                    .source("Source")
                    .build())
            .build());
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("Vertex", entitySet);

    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertEquals(entitySet, walk.getEntitiesForVertex("Vertex"));
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   *
   * <p>Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName("Test getEntitiesForVertex(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex3() {
    // Arrange
    HashSet<Entity> entitySet = new HashSet<>();
    entitySet.add(new Entity.Builder().group("Group").vertex(0).build());

    Entity.Builder groupResult = new Entity.Builder().group("Group");
    entitySet.add(groupResult.vertex(new Edge("Vertex")).build());
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("Vertex", entitySet);

    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertEquals(entitySet, walk.getEntitiesForVertex("Vertex"));
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code 42} and {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName(
      "Test getEntitiesForVertex(Object); given ArrayList() add SimpleEntry(Object, Object) with '42' and HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex_givenArrayListAddSimpleEntryWith42AndHashSet() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertTrue(walk.getEntitiesForVertex("Vertex").isEmpty());
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code 42} and {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName(
      "Test getEntitiesForVertex(Object); given ArrayList() add SimpleEntry(Object, Object) with '42' and HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex_givenArrayListAddSimpleEntryWith42AndHashSet2() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry);
    SimpleEntry<Object, Set<Entity>> simpleEntry2 = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry2);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertTrue(walk.getEntitiesForVertex("Vertex").isEmpty());
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Entity.Builder} (default constructor) group
   *       {@code Group} vertex {@code null} build.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName(
      "Test getEntitiesForVertex(Object); given HashSet() add Builder (default constructor) group 'Group' vertex 'null' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex_givenHashSetAddBuilderGroupGroupVertexNullBuild() {
    // Arrange
    HashSet<Entity> entitySet = new HashSet<>();
    entitySet.add(new Entity.Builder().group("Group").vertex(0).build());
    entitySet.add(new Entity.Builder().group("Group").vertex(null).build());
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("Vertex", entitySet);

    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertEquals(entitySet, walk.getEntitiesForVertex("Vertex"));
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Entity.Builder} (default constructor) group
   *       {@code Group} vertex {@code null} build.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName(
      "Test getEntitiesForVertex(Object); given HashSet() add Builder (default constructor) group 'Group' vertex 'null' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex_givenHashSetAddBuilderGroupGroupVertexNullBuild2() {
    // Arrange
    HashSet<Entity> entitySet = new HashSet<>();
    entitySet.add(new Entity.Builder().group("Group").vertex(null).build());
    entitySet.add(new Entity.Builder().group("Group").vertex(0).build());
    entitySet.add(new Entity.Builder().group("Group").vertex(null).build());
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("Vertex", entitySet);

    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertEquals(entitySet, walk.getEntitiesForVertex("Vertex"));
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Entity.Builder} (default constructor) group
   *       {@code Group} vertex {@code Vertex} build.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName(
      "Test getEntitiesForVertex(Object); given HashSet() add Builder (default constructor) group 'Group' vertex 'Vertex' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex_givenHashSetAddBuilderGroupGroupVertexVertexBuild() {
    // Arrange
    HashSet<Entity> entitySet = new HashSet<>();
    entitySet.add(new Entity.Builder().group("Group").vertex("Vertex").build());
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("Vertex", entitySet);

    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertEquals(1, walk.getEntitiesForVertex("Vertex").size());
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName("Test getEntitiesForVertex(Object); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex_thenReturnEmpty() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertTrue(walk.getEntitiesForVertex("Vertex").isEmpty());
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName("Test getEntitiesForVertex(Object); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex_thenReturnEmpty2() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("Vertex", new HashSet<>());
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertTrue(walk.getEntitiesForVertex("Vertex").isEmpty());
  }

  /**
   * Test {@link Walk#getEntitiesForVertex(Object)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  @DisplayName("Test getEntitiesForVertex(Object); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesForVertex(Object)"})
  void testGetEntitiesForVertex_thenReturnSizeIsOne() {
    // Arrange
    HashSet<Entity> entitySet = new HashSet<>();
    entitySet.add(new Entity.Builder().group("Group").vertex(null).build());
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("Vertex", entitySet);

    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertEquals(1, walk.getEntitiesForVertex("Vertex").size());
  }

  /**
   * Test {@link Walk#getEntitiesAtDistance(int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntitiesAtDistance(int)}
   */
  @Test
  @DisplayName(
      "Test getEntitiesAtDistance(int); given ArrayList() add nullPair; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesAtDistance(int)"})
  void testGetEntitiesAtDistance_givenArrayListAddNullPair_thenReturnNull() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry);
    ImmutablePair<Object, Set<Entity>> nullPairResult = ImmutablePair.nullPair();
    entities.add(nullPairResult);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertNull(walk.getEntitiesAtDistance(1));
  }

  /**
   * Test {@link Walk#getEntitiesAtDistance(int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntitiesAtDistance(int)}
   */
  @Test
  @DisplayName("Test getEntitiesAtDistance(int); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getEntitiesAtDistance(int)"})
  void testGetEntitiesAtDistance_thenReturnEmpty() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry);
    SimpleEntry<Object, Set<Entity>> simpleEntry2 = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry2);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertTrue(walk.getEntitiesAtDistance(1).isEmpty());
  }

  /**
   * Test {@link Walk#getEntities()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntities()}
   */
  @Test
  @DisplayName("Test getEntities(); given ArrayList() add nullPair; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Walk.getEntities()"})
  void testGetEntities_givenArrayListAddNullPair_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    ImmutablePair<Object, Set<Entity>> nullPairResult = ImmutablePair.nullPair();
    entities.add(nullPairResult);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act
    List<Set<Entity>> actualEntities = walk.getEntities();

    // Assert
    assertEquals(1, actualEntities.size());
    assertNull(actualEntities.get(0));
  }

  /**
   * Test {@link Walk#getEntities()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntities()}
   */
  @Test
  @DisplayName("Test getEntities(); given ArrayList() add nullPair; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Walk.getEntities()"})
  void testGetEntities_givenArrayListAddNullPair_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    ImmutablePair<Object, Set<Entity>> nullPairResult = ImmutablePair.nullPair();
    entities.add(nullPairResult);
    ImmutablePair<Object, Set<Entity>> nullPairResult2 = ImmutablePair.nullPair();
    entities.add(nullPairResult2);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act
    List<Set<Entity>> actualEntities = walk.getEntities();

    // Assert
    assertEquals(2, actualEntities.size());
    assertNull(actualEntities.get(0));
    assertNull(actualEntities.get(1));
  }

  /**
   * Test {@link Walk#getEntities()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getEntities()}
   */
  @Test
  @DisplayName("Test getEntities(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Walk.getEntities()"})
  void testGetEntities_thenReturnEmpty() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertTrue(walk.getEntities().isEmpty());
  }

  /**
   * Test {@link Walk#getVerticesOrdered()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getVerticesOrdered()}
   */
  @Test
  @DisplayName("Test getVerticesOrdered(); given ArrayList() add nullPair; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Walk.getVerticesOrdered()"})
  void testGetVerticesOrdered_givenArrayListAddNullPair_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    ImmutablePair<Object, Set<Entity>> nullPairResult = ImmutablePair.nullPair();
    entities.add(nullPairResult);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act
    List<Object> actualVerticesOrdered = walk.getVerticesOrdered();

    // Assert
    assertEquals(1, actualVerticesOrdered.size());
    assertNull(actualVerticesOrdered.get(0));
  }

  /**
   * Test {@link Walk#getVerticesOrdered()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getVerticesOrdered()}
   */
  @Test
  @DisplayName("Test getVerticesOrdered(); given ArrayList() add nullPair; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Walk.getVerticesOrdered()"})
  void testGetVerticesOrdered_givenArrayListAddNullPair_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    ImmutablePair<Object, Set<Entity>> nullPairResult = ImmutablePair.nullPair();
    entities.add(nullPairResult);
    ImmutablePair<Object, Set<Entity>> nullPairResult2 = ImmutablePair.nullPair();
    entities.add(nullPairResult2);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act
    List<Object> actualVerticesOrdered = walk.getVerticesOrdered();

    // Assert
    assertEquals(2, actualVerticesOrdered.size());
    assertNull(actualVerticesOrdered.get(0));
    assertNull(actualVerticesOrdered.get(1));
  }

  /**
   * Test {@link Walk#getVerticesOrdered()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getVerticesOrdered()}
   */
  @Test
  @DisplayName("Test getVerticesOrdered(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Walk.getVerticesOrdered()"})
  void testGetVerticesOrdered_thenReturnEmpty() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertTrue(walk.getVerticesOrdered().isEmpty());
  }

  /**
   * Test {@link Walk#getVertexSet()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getVertexSet()}
   */
  @Test
  @DisplayName("Test getVertexSet(); given ArrayList() add nullPair; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getVertexSet()"})
  void testGetVertexSet_givenArrayListAddNullPair_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    ImmutablePair<Object, Set<Entity>> nullPairResult = ImmutablePair.nullPair();
    entities.add(nullPairResult);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertEquals(1, walk.getVertexSet().size());
  }

  /**
   * Test {@link Walk#getVertexSet()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getVertexSet()}
   */
  @Test
  @DisplayName("Test getVertexSet(); given ArrayList() add nullPair; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getVertexSet()"})
  void testGetVertexSet_givenArrayListAddNullPair_thenReturnSizeIsOne2() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    ImmutablePair<Object, Set<Entity>> nullPairResult = ImmutablePair.nullPair();
    entities.add(nullPairResult);
    ImmutablePair<Object, Set<Entity>> nullPairResult2 = ImmutablePair.nullPair();
    entities.add(nullPairResult2);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertEquals(1, walk.getVertexSet().size());
  }

  /**
   * Test {@link Walk#getVertexSet()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getVertexSet()}
   */
  @Test
  @DisplayName("Test getVertexSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Walk.getVertexSet()"})
  void testGetVertexSet_thenReturnEmpty() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertTrue(walk.getVertexSet().isEmpty());
  }

  /**
   * Test {@link Walk#length()}.
   *
   * <p>Method under test: {@link Walk#length()}
   */
  @Test
  @DisplayName("Test length()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Walk.length()"})
  void testLength() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertEquals(0, walk.length());
  }

  /**
   * Test {@link Walk#isTrail()}.
   *
   * <p>Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();
    edgeSet.add(
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet);
    edges.add(new HashSet<>());
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertTrue(walk.isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   *
   * <p>Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail2() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();
    edgeSet.add(
        new Edge.Builder()
            .dest(null)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet);
    edges.add(new HashSet<>());
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertTrue(walk.isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   *
   * <p>Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail3() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();
    edgeSet.add(
        new Edge.Builder()
            .dest("Dest")
            .directed(false)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet);
    edges.add(new HashSet<>());
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertTrue(walk.isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   *
   * <p>Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail4() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();

    Edge.Builder builder = new Edge.Builder();
    edgeSet.add(
        builder
            .dest(
                new Edge.Builder()
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
            .build());

    HashSet<Edge> edgeSet2 = new HashSet<>();
    edgeSet2.add(
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet2);
    edges.add(edgeSet);
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertTrue(walk.isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   *
   * <p>Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail5() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();
    edgeSet.add(
        new Edge.Builder()
            .dest(0)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    HashSet<Edge> edgeSet2 = new HashSet<>();
    edgeSet2.add(
        new Edge.Builder()
            .dest(null)
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet2);
    edges.add(edgeSet);
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertTrue(walk.isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail(); given ArrayList() add HashSet(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail_givenArrayListAddHashSet_thenReturnFalse() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(new HashSet<>());
    edges.add(new HashSet<>());
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertFalse(walk.isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail_thenReturnFalse() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();
    edgeSet.add(
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    HashSet<Edge> edgeSet2 = new HashSet<>();
    edgeSet2.add(
        new Edge.Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build());

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet2);
    edges.add(edgeSet);
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertFalse(walk.isTrail());
  }

  /**
   * Test {@link Walk#isTrail()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#isTrail()}
   */
  @Test
  @DisplayName("Test isTrail(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.isTrail()"})
  void testIsTrail_thenReturnTrue() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertTrue(walk.isTrail());
  }

  /**
   * Test {@link Walk#isPath()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#isPath()}
   */
  @Test
  @DisplayName("Test isPath(); given ArrayList() add nullPair; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.isPath()"})
  void testIsPath_givenArrayListAddNullPair_thenReturnTrue() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    ImmutablePair<Object, Set<Entity>> nullPairResult = ImmutablePair.nullPair();
    entities.add(nullPairResult);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertTrue(walk.isPath());
  }

  /**
   * Test {@link Walk#isPath()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code 42} and {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#isPath()}
   */
  @Test
  @DisplayName(
      "Test isPath(); given ArrayList() add SimpleEntry(Object, Object) with '42' and HashSet(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.isPath()"})
  void testIsPath_givenArrayListAddSimpleEntryWith42AndHashSet_thenReturnFalse() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry);
    SimpleEntry<Object, Set<Entity>> simpleEntry2 = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry2);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertFalse(walk.isPath());
  }

  /**
   * Test {@link Walk#isPath()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code 42} and {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#isPath()}
   */
  @Test
  @DisplayName(
      "Test isPath(); given ArrayList() add SimpleEntry(Object, Object) with '42' and HashSet(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.isPath()"})
  void testIsPath_givenArrayListAddSimpleEntryWith42AndHashSet_thenReturnTrue() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertTrue(walk.isPath());
  }

  /**
   * Test {@link Walk#isPath()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#isPath()}
   */
  @Test
  @DisplayName("Test isPath(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.isPath()"})
  void testIsPath_thenReturnTrue() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertTrue(walk.isPath());
  }

  /**
   * Test {@link Walk#getSourceVertex()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getSourceVertex()}
   */
  @Test
  @DisplayName("Test getSourceVertex(); given ArrayList() add nullPair; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Walk.getSourceVertex()"})
  void testGetSourceVertex_givenArrayListAddNullPair_thenReturnNull() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    ImmutablePair<Object, Set<Entity>> nullPairResult = ImmutablePair.nullPair();
    entities.add(nullPairResult);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertNull(walk.getSourceVertex());
  }

  /**
   * Test {@link Walk#getSourceVertex()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       AbstractMap.SimpleEntry#SimpleEntry(Object, Object)} with {@code 42} and {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getSourceVertex()}
   */
  @Test
  @DisplayName(
      "Test getSourceVertex(); given ArrayList() add SimpleEntry(Object, Object) with '42' and HashSet(); then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Walk.getSourceVertex()"})
  void testGetSourceVertex_givenArrayListAddSimpleEntryWith42AndHashSet_thenReturn42() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertEquals("42", walk.getSourceVertex());
  }

  /**
   * Test {@link Walk#getDestinationVertex()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getDestinationVertex()}
   */
  @Test
  @DisplayName("Test getDestinationVertex(); given ArrayList() add nullPair; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Walk.getDestinationVertex()"})
  void testGetDestinationVertex_givenArrayListAddNullPair_thenReturnNull() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    ImmutablePair<Object, Set<Entity>> nullPairResult = ImmutablePair.nullPair();
    entities.add(nullPairResult);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertNull(walk.getDestinationVertex());
  }

  /**
   * Test {@link Walk#getDestinationVertex()}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Walk#getDestinationVertex()}
   */
  @Test
  @DisplayName("Test getDestinationVertex(); then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Walk.getDestinationVertex()"})
  void testGetDestinationVertex_thenReturn42() {
    // Arrange
    ArrayList<Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    SimpleEntry<Object, Set<Entity>> simpleEntry = new SimpleEntry<>("42", new HashSet<>());
    entities.add(simpleEntry);
    Walk walk = new Walk(new ArrayList<>(), entities);

    // Act and Assert
    assertEquals("42", walk.getDestinationVertex());
  }

  /**
   * Test {@link Walk#equals(Object)}, and {@link Walk#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Walk#equals(Object)}
   *   <li>{@link Walk#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.equals(Object)", "int Walk.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Walk walk = new Builder().build();
    Walk walk2 = new Builder().build();

    // Act and Assert
    assertEquals(walk, walk2);
    assertEquals(walk.hashCode(), walk2.hashCode());
  }

  /**
   * Test {@link Walk#equals(Object)}, and {@link Walk#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Walk#equals(Object)}
   *   <li>{@link Walk#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.equals(Object)", "int Walk.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Walk walk = new Builder().build();

    // Act and Assert
    assertEquals(walk, walk);
    int expectedHashCodeResult = walk.hashCode();
    assertEquals(expectedHashCodeResult, walk.hashCode());
  }

  /**
   * Test {@link Walk#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Walk#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.equals(Object)", "int Walk.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().build(), null);
  }

  /**
   * Test {@link Walk#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Walk#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Walk.equals(Object)", "int Walk.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().build(), "Different type to Walk");
  }

  /**
   * Test {@link Walk#iterator()}.
   *
   * <p>Method under test: {@link Walk#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator Walk.iterator()"})
  void testIterator() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertFalse(walk.iterator().hasNext());
  }
}
