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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.tinkerpop.gremlin.structure.Direction;
import org.apache.tinkerpop.gremlin.structure.Edge;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.VertexProperty;
import org.apache.tinkerpop.gremlin.structure.util.empty.EmptyVertexProperty;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;

public class GafferPopVertexDiffblueTest {
  /**
   * Test {@link GafferPopVertex#property(String)} with {@code key}.
   * <ul>
   *   <li>Then return {@link EmptyVertexProperty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertex#property(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"VertexProperty GafferPopVertex.property(String)"})
  public void testPropertyWithKey_thenReturnEmptyVertexProperty() {
    // Arrange and Act
    VertexProperty<Object> actualPropertyResult = (new GafferPopVertex("Label", "Id", null)).property("Key");

    // Assert
    assertTrue(actualPropertyResult instanceof EmptyVertexProperty);
    assertFalse(actualPropertyResult.isPresent());
  }

  /**
   * Test {@link GafferPopVertex#properties(String[])}.
   * <ul>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertex#properties(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopVertex.properties(String[])"})
  public void testProperties_thenReturnNotHasNext() {
    // Arrange, Act and Assert
    assertFalse((new GafferPopVertex("Label", "Id", null)).properties("Property Keys").hasNext());
  }

  /**
   * Test {@link GafferPopVertex#edges(Direction, String[])} with {@code direction}, {@code edgeLabels}.
   * <ul>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertex#edges(Direction, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopVertex.edges(Direction, String[])"})
  public void testEdgesWithDirectionEdgeLabels_thenReturnNotHasNext() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);

    ArrayList<Edge> edgeList = new ArrayList<>();
    when(graph.edgesWithView(Mockito.<Object>any(), Mockito.<Direction>any(), Mockito.<View>any()))
        .thenReturn(edgeList.iterator());

    // Act
    Iterator<Edge> actualEdgesResult = (new GafferPopVertex("Label", "Id", graph)).edges(Direction.OUT, "Edge Labels");

    // Assert
    verify(graph).edgesWithView(isA(Object.class), eq(Direction.OUT), isA(View.class));
    assertFalse(actualEdgesResult.hasNext());
  }

  /**
   * Test {@link GafferPopVertex#edges(Direction, View)} with {@code direction}, {@code view}.
   * <ul>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertex#edges(Direction, View)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopVertex.edges(Direction, View)"})
  public void testEdgesWithDirectionView_thenReturnNotHasNext() {
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
   * Test {@link GafferPopVertex#vertices(Direction, String[])} with {@code direction}, {@code edgeLabels}.
   * <ul>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertex#vertices(Direction, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopVertex.vertices(Direction, String[])"})
  public void testVerticesWithDirectionEdgeLabels_thenReturnNotHasNext() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);

    ArrayList<Vertex> vertexList = new ArrayList<>();
    when(graph.adjVertices(Mockito.<Object>any(), Mockito.<Direction>any(), (String[]) Mockito.any()))
        .thenReturn(vertexList.iterator());

    // Act
    Iterator<Vertex> actualVerticesResult = (new GafferPopVertex("Label", "Id", graph)).vertices(Direction.OUT,
        "Edge Labels");

    // Assert
    verify(graph).adjVertices(isA(Object.class), eq(Direction.OUT), (String[]) Mockito.any());
    assertFalse(actualVerticesResult.hasNext());
  }

  /**
   * Test {@link GafferPopVertex#vertices(Direction, View)} with {@code direction}, {@code view}.
   * <ul>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertex#vertices(Direction, View)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Iterator GafferPopVertex.vertices(Direction, View)"})
  public void testVerticesWithDirectionView_thenReturnNotHasNext() {
    // Arrange
    GafferPopGraph graph = mock(GafferPopGraph.class);

    ArrayList<Vertex> vertexList = new ArrayList<>();
    when(graph.adjVerticesWithView(Mockito.<Object>any(), Mockito.<Direction>any(), Mockito.<View>any()))
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
   * <ul>
   *   <li>Given {@link GafferPopVertex#GafferPopVertex(String, Object, GafferPopGraph)} with {@code Label} and {@code Id} and graph is {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GafferPopVertex#keys()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Set GafferPopVertex.keys()"})
  public void testKeys_givenGafferPopVertexWithLabelAndIdAndGraphIsNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new GafferPopVertex("Label", "Id", null)).keys().isEmpty());
  }
}
