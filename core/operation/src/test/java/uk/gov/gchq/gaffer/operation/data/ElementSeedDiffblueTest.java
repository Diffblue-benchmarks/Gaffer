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

package uk.gov.gchq.gaffer.operation.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.element.id.EntityId;

class ElementSeedDiffblueTest {
  /**
   * Test {@link ElementSeed#createSeed(EdgeId)} with {@code edgeId}.
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code Dest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(EdgeId)}
   */
  @Test
  @DisplayName("Test createSeed(EdgeId) with 'edgeId'; then return AdjacentMatchedVertexValue is 'Dest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeSeed ElementSeed.createSeed(EdgeId)"})
  void testCreateSeedWithEdgeId_thenReturnAdjacentMatchedVertexValueIsDest() {
    // Arrange
    Edge edgeId = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    EdgeSeed actualCreateSeedResult = ElementSeed.createSeed((EdgeId) edgeId);

    // Assert
    assertEquals("Dest", actualCreateSeedResult.getAdjacentMatchedVertexValue());
    assertEquals("Dest", actualCreateSeedResult.getDestination());
    assertEquals("Source", actualCreateSeedResult.getMatchedVertexValue());
    assertEquals("Source", actualCreateSeedResult.getSource());
    assertEquals(DirectedType.DIRECTED, actualCreateSeedResult.getDirectedType());
    assertFalse(actualCreateSeedResult.isUndirected());
    assertTrue(actualCreateSeedResult.isDirected());
  }

  /**
   * Test {@link ElementSeed#createSeed(EdgeId)} with {@code edgeId}.
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(EdgeId)}
   */
  @Test
  @DisplayName("Test createSeed(EdgeId) with 'edgeId'; then return AdjacentMatchedVertexValue is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeSeed ElementSeed.createSeed(EdgeId)"})
  void testCreateSeedWithEdgeId_thenReturnAdjacentMatchedVertexValueIsNull() {
    // Arrange and Act
    EdgeSeed actualCreateSeedResult = ElementSeed.createSeed((EdgeId) new Edge("Group"));

    // Assert
    assertNull(actualCreateSeedResult.getAdjacentMatchedVertexValue());
    assertNull(actualCreateSeedResult.getMatchedVertexValue());
    assertNull(actualCreateSeedResult.getDestination());
    assertNull(actualCreateSeedResult.getSource());
    assertEquals(DirectedType.UNDIRECTED, actualCreateSeedResult.getDirectedType());
    assertFalse(actualCreateSeedResult.isDirected());
    assertTrue(actualCreateSeedResult.isUndirected());
  }

  /**
   * Test {@link ElementSeed#createSeed(EdgeId)} with {@code edgeId}.
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.</li>
   *   <li>Then return {@link EdgeSeed#EdgeSeed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(EdgeId)}
   */
  @Test
  @DisplayName("Test createSeed(EdgeId) with 'edgeId'; when EdgeSeed(); then return EdgeSeed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeSeed ElementSeed.createSeed(EdgeId)"})
  void testCreateSeedWithEdgeId_whenEdgeSeed_thenReturnEdgeSeed() {
    // Arrange
    EdgeSeed edgeId = new EdgeSeed();

    // Act and Assert
    assertEquals(edgeId, ElementSeed.createSeed((EdgeId) edgeId));
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   * <p>
   * Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId() {
    // Arrange
    Builder builder = new Builder();
    Edge elementId = builder.dest(new EdgeSeed())
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    Object matchedVertexValue = ((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue();
    assertTrue(matchedVertexValue instanceof EdgeSeed);
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals("uk.gov.gchq.gaffer.operation.data.EdgeSeed", ((EdgeSeed) matchedVertexValue).getClassName());
    assertNull(((EdgeSeed) matchedVertexValue).getDestination());
    assertNull(((EdgeSeed) matchedVertexValue).getSource());
    assertEquals(DirectedType.EITHER, ((EdgeSeed) matchedVertexValue).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((EdgeSeed) matchedVertexValue).getMatchedVertex());
    assertTrue(((EdgeSeed) matchedVertexValue).isDirected());
    assertSame(matchedVertexValue, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>Then MatchedVertexValue return {@link Edge}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'; then MatchedVertexValue return Edge")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenMatchedVertexValueReturnEdge() {
    // Arrange
    Builder builder = new Builder();
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge elementId = builder.dest(buildResult)
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    Object matchedVertexValue = ((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue();
    assertTrue(matchedVertexValue instanceof Edge);
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals("Dest", ((Edge) matchedVertexValue).getDestination());
    assertEquals("Dest", ((Edge) matchedVertexValue).getAdjacentMatchedVertexValue());
    assertEquals("Source", ((Edge) matchedVertexValue).getSource());
    assertEquals("Source", ((Edge) matchedVertexValue).getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, ((Edge) matchedVertexValue).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) matchedVertexValue).getMatchedVertex());
    assertFalse(((Edge) matchedVertexValue).isUndirected());
    assertTrue(((Edge) matchedVertexValue).isDirected());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>Then MatchedVertexValue Vertex return {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'; then MatchedVertexValue Vertex return Entity")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenMatchedVertexValueVertexReturnEntity() {
    // Arrange
    Builder builder = new Builder();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult2 = groupResult.vertex(buildResult).build();
    Edge elementId = builder.dest(buildResult2)
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    Object matchedVertexValue = ((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue();
    Object vertex = ((Entity) matchedVertexValue).getVertex();
    assertTrue(vertex instanceof Entity);
    assertTrue(matchedVertexValue instanceof Entity);
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals("Group", ((Entity) vertex).getGroup());
    assertEquals("Vertex", ((Entity) vertex).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", ((Entity) vertex).getClassName());
    assertSame(matchedVertexValue, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code Dest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'; then return AdjacentMatchedVertexValue is 'Dest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnAdjacentMatchedVertexValueIsDest() {
    // Arrange
    Edge elementId = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals("Dest", ((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue());
    assertEquals("Dest", ((EdgeSeed) actualCreateSeedResult).getDestination());
    assertEquals("Source", ((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue());
    assertEquals("Source", ((EdgeSeed) actualCreateSeedResult).getSource());
    assertEquals(DirectedType.DIRECTED, ((EdgeSeed) actualCreateSeedResult).getDirectedType());
    assertFalse(((EdgeSeed) actualCreateSeedResult).isUndirected());
    assertTrue(((EdgeSeed) actualCreateSeedResult).isDirected());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@link EdgeSeed#EdgeSeed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'; then return AdjacentMatchedVertexValue is EdgeSeed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnAdjacentMatchedVertexValueIsEdgeSeed() {
    // Arrange
    Builder builder = new Builder();
    EdgeSeed edgeSeed = new EdgeSeed();
    Builder matchedVertexResult = builder.dest(edgeSeed)
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE);
    Edge elementId = matchedVertexResult.source(new EdgeSeed()).build();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    Object matchedVertexValue = ((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue();
    assertTrue(matchedVertexValue instanceof EdgeSeed);
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertSame(edgeSeed, ((EdgeSeed) actualCreateSeedResult).getAdjacentMatchedVertexValue());
    assertSame(edgeSeed, ((EdgeSeed) actualCreateSeedResult).getDestination());
    assertSame(matchedVertexValue, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'; then return AdjacentMatchedVertexValue is 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return MatchedVertexValue is {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'; then return MatchedVertexValue is Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnMatchedVertexValueIsEdgeWithGroup() {
    // Arrange
    Builder builder = new Builder();
    Edge edge = new Edge("Group");
    Edge elementId = builder.dest(edge)
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertSame(edge, ((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue());
    assertSame(edge, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>Then return MatchedVertexValue is {@link EntitySeed#EntitySeed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'; then return MatchedVertexValue is EntitySeed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnMatchedVertexValueIsEntitySeed() {
    // Arrange
    Builder builder = new Builder();
    EntitySeed entitySeed = new EntitySeed();
    Edge elementId = builder.dest(entitySeed)
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertSame(entitySeed, ((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue());
    assertSame(entitySeed, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>Then return MatchedVertexValue Vertex is {@link EdgeSeed#EdgeSeed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'; then return MatchedVertexValue Vertex is EdgeSeed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnMatchedVertexValueVertexIsEdgeSeed() {
    // Arrange
    Builder builder = new Builder();
    Entity.Builder groupResult = (new Entity.Builder()).group("Group");
    EdgeSeed edgeSeed = new EdgeSeed();
    Entity buildResult = groupResult.vertex(edgeSeed).build();
    Edge elementId = builder.dest(buildResult)
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    Object matchedVertexValue = ((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue();
    assertTrue(matchedVertexValue instanceof Entity);
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertSame(edgeSeed, ((Entity) matchedVertexValue).getVertex());
    assertSame(matchedVertexValue, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>Then return MatchedVertexValue Vertex is {@code Vertex}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'; then return MatchedVertexValue Vertex is 'Vertex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ElementSeed ElementSeed.createSeed(ElementId)"})
  void testCreateSeedWithElementId_thenReturnMatchedVertexValueVertexIsVertex() {
    // Arrange
    Builder builder = new Builder();
    Entity buildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    Edge elementId = builder.dest(buildResult)
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    ElementSeed actualCreateSeedResult = ElementSeed.createSeed((ElementId) elementId);

    // Assert
    Object matchedVertexValue = ((EdgeSeed) actualCreateSeedResult).getMatchedVertexValue();
    assertTrue(matchedVertexValue instanceof Entity);
    assertTrue(actualCreateSeedResult instanceof EdgeSeed);
    assertEquals("Vertex", ((Entity) matchedVertexValue).getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", ((Entity) matchedVertexValue).getClassName());
    assertSame(matchedVertexValue, ((EdgeSeed) actualCreateSeedResult).getSource());
  }

  /**
   * Test {@link ElementSeed#createSeed(ElementId)} with {@code elementId}.
   * <ul>
   *   <li>When {@link EdgeSeed#EdgeSeed()}.</li>
   *   <li>Then return {@link EdgeSeed#EdgeSeed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'; when EdgeSeed(); then return EdgeSeed()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.</li>
   *   <li>Then return {@link EntitySeed}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(ElementId)}
   */
  @Test
  @DisplayName("Test createSeed(ElementId) with 'elementId'; when EntitySeed(); then return EntitySeed")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.</li>
   *   <li>Then return {@link EntitySeed#EntitySeed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementSeed#createSeed(EntityId)}
   */
  @Test
  @DisplayName("Test createSeed(EntityId) with 'entityId'; when EntitySeed(); then return EntitySeed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntitySeed ElementSeed.createSeed(EntityId)"})
  void testCreateSeedWithEntityId_whenEntitySeed_thenReturnEntitySeed() {
    // Arrange
    EntitySeed entityId = new EntitySeed();

    // Act and Assert
    assertEquals(entityId, ElementSeed.createSeed((EntityId) entityId));
  }
}
