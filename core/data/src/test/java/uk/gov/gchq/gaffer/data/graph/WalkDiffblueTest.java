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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEdge;

class WalkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Walk.Builder#build()}
   *   <li>default or parameterless constructor of {@link Walk.Builder}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    Walk actualBuildResult = (new Walk.Builder()).build();

    // Assert
    assertEquals(0, actualBuildResult.length());
    assertFalse(actualBuildResult.iterator().hasNext());
    assertTrue(actualBuildResult.getEdges().isEmpty());
    assertTrue(actualBuildResult.getEntities().isEmpty());
    assertTrue(actualBuildResult.getEntitiesAsEntries().isEmpty());
    assertTrue(actualBuildResult.getVerticesOrdered().isEmpty());
    assertTrue(actualBuildResult.getVertexSet().isEmpty());
  }

  /**
   * Method under test: {@link Walk.Builder#entities(Iterable)}
   */
  @Test
  void testBuilderEntities() {
    // Arrange
    Walk.Builder builder = new Walk.Builder();

    // Act
    Walk.Builder actualEntitiesResult = builder.entities(new ArrayList<>());

    // Assert
    Walk buildResult = builder.build();
    assertTrue(buildResult.getEntities().isEmpty());
    assertTrue(buildResult.getVerticesOrdered().isEmpty());
    assertTrue(buildResult.getVertexSet().isEmpty());
    assertSame(builder, actualEntitiesResult);
  }

  /**
   * Method under test: {@link Walk.Builder#entities(Iterable)}
   */
  @Test
  void testBuilderEntities2() {
    // Arrange
    Walk.Builder builder = new Walk.Builder();

    ArrayList<Entity> entities = new ArrayList<>();
    entities.add(new Entity("Group"));

    // Act
    Walk.Builder actualEntitiesResult = builder.entities(entities);

    // Assert
    Walk buildResult = builder.build();
    List<Object> verticesOrdered = buildResult.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertNull(verticesOrdered.get(0));
    assertNull(buildResult.getDestinationVertex());
    assertNull(buildResult.getSourceVertex());
    assertEquals(1, buildResult.getEntities().size());
    assertEquals(1, buildResult.getVertexSet().size());
    assertSame(builder, actualEntitiesResult);
  }

  /**
   * Method under test: {@link Walk.Builder#entities(Entity[])}
   */
  @Test
  void testBuilderEntities3() {
    // Arrange
    Walk.Builder builder = new Walk.Builder();

    // Act
    Walk.Builder actualEntitiesResult = builder.entities(new Entity("Group"));

    // Assert
    Walk buildResult = builder.build();
    List<Object> verticesOrdered = buildResult.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertNull(verticesOrdered.get(0));
    assertNull(buildResult.getDestinationVertex());
    assertNull(buildResult.getSourceVertex());
    assertEquals(1, buildResult.getEntities().size());
    assertEquals(1, buildResult.getVertexSet().size());
    assertSame(builder, actualEntitiesResult);
  }

  /**
   * Method under test: {@link Walk.Builder#entity(Entity)}
   */
  @Test
  void testBuilderEntity() {
    // Arrange
    Walk.Builder builder = new Walk.Builder();

    // Act
    Walk.Builder actualEntityResult = builder.entity(new Entity("Group"));

    // Assert
    Walk buildResult = builder.build();
    List<Object> verticesOrdered = buildResult.getVerticesOrdered();
    assertEquals(1, verticesOrdered.size());
    assertNull(verticesOrdered.get(0));
    assertNull(buildResult.getDestinationVertex());
    assertNull(buildResult.getSourceVertex());
    assertEquals(1, buildResult.getEntities().size());
    assertEquals(1, buildResult.getVertexSet().size());
    assertSame(builder, actualEntityResult);
  }

  /**
   * Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  void testGetEntitiesForVertex() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).getEntitiesForVertex("Vertex").isEmpty());
  }

  /**
   * Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  void testGetEntitiesForVertex2() {
    // Arrange
    ArrayList<Map.Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new AbstractMap.SimpleEntry<>("42", new HashSet<>()));

    // Act and Assert
    assertTrue((new Walk(new ArrayList<>(), entities)).getEntitiesForVertex("Vertex").isEmpty());
  }

  /**
   * Method under test: {@link Walk#getEntitiesForVertex(Object)}
   */
  @Test
  void testGetEntitiesForVertex3() {
    // Arrange
    ArrayList<Map.Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new AbstractMap.SimpleEntry<>("42", new HashSet<>()));
    entities.add(new AbstractMap.SimpleEntry<>("42", new HashSet<>()));

    // Act and Assert
    assertTrue((new Walk(new ArrayList<>(), entities)).getEntitiesForVertex("Vertex").isEmpty());
  }

  /**
   * Method under test: {@link Walk#getEntitiesAtDistance(int)}
   */
  @Test
  void testGetEntitiesAtDistance() {
    // Arrange
    ArrayList<Map.Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new AbstractMap.SimpleEntry<>("42", new HashSet<>()));
    HashSet<Entity> entitySet = new HashSet<>();
    entities.add(new AbstractMap.SimpleEntry<>("42", entitySet));

    // Act
    Set<Entity> actualEntitiesAtDistance = (new Walk(new ArrayList<>(), entities)).getEntitiesAtDistance(1);

    // Assert
    assertTrue(actualEntitiesAtDistance.isEmpty());
    assertSame(entitySet, actualEntitiesAtDistance);
  }

  /**
   * Method under test: {@link Walk#getEntities()}
   */
  @Test
  void testGetEntities() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).getEntities().isEmpty());
  }

  /**
   * Method under test: {@link Walk#getVerticesOrdered()}
   */
  @Test
  void testGetVerticesOrdered() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).getVerticesOrdered().isEmpty());
  }

  /**
   * Method under test: {@link Walk#getVertexSet()}
   */
  @Test
  void testGetVertexSet() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).getVertexSet().isEmpty());
  }

  /**
   * Method under test: {@link Walk#length()}
   */
  @Test
  void testLength() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertEquals(0, (new Walk(edges, new ArrayList<>())).length());
  }

  /**
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  void testIsTrail() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  void testIsTrail2() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(new HashSet<>());
    edges.add(new HashSet<>());

    // Act and Assert
    assertFalse((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  void testIsTrail3() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();
    edgeSet.add(new Edge("Group"));

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet);
    edges.add(new HashSet<>());

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  void testIsTrail4() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();
    edgeSet.add(new Edge("Group", "Source", "Destination", true));

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet);
    edges.add(new HashSet<>());

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  void testIsTrail5() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();
    edgeSet.add(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet);
    edges.add(new HashSet<>());

    // Act and Assert
    assertTrue((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Method under test: {@link Walk#isTrail()}
   */
  @Test
  void testIsTrail6() {
    // Arrange
    HashSet<Edge> edgeSet = new HashSet<>();
    edgeSet.add(new Edge("Group"));

    HashSet<Edge> edgeSet2 = new HashSet<>();
    edgeSet2.add(new Edge("Group"));

    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(edgeSet2);
    edges.add(edgeSet);

    // Act and Assert
    assertFalse((new Walk(edges, new ArrayList<>())).isTrail());
  }

  /**
   * Method under test: {@link Walk#getSourceVertex()}
   */
  @Test
  void testGetSourceVertex() {
    // Arrange
    ArrayList<Map.Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new AbstractMap.SimpleEntry<>("42", new HashSet<>()));

    // Act and Assert
    assertEquals("42", (new Walk(new ArrayList<>(), entities)).getSourceVertex());
  }

  /**
   * Method under test: {@link Walk#getDestinationVertex()}
   */
  @Test
  void testGetDestinationVertex() {
    // Arrange
    ArrayList<Map.Entry<Object, Set<Entity>>> entities = new ArrayList<>();
    entities.add(new AbstractMap.SimpleEntry<>("42", new HashSet<>()));

    // Act and Assert
    assertEquals("42", (new Walk(new ArrayList<>(), entities)).getDestinationVertex());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Walk#equals(Object)}
   *   <li>{@link Walk#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());
    ArrayList<Set<Edge>> edges2 = new ArrayList<>();
    Walk walk2 = new Walk(edges2, new ArrayList<>());

    // Act and Assert
    assertEquals(walk, walk2);
    int expectedHashCodeResult = walk.hashCode();
    assertEquals(expectedHashCodeResult, walk2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Walk#equals(Object)}
   *   <li>{@link Walk#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    Walk walk = new Walk(edges, new ArrayList<>());

    // Act and Assert
    assertEquals(walk, walk);
    int expectedHashCodeResult = walk.hashCode();
    assertEquals(expectedHashCodeResult, walk.hashCode());
  }

  /**
   * Method under test: {@link Walk#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertFalse((new Walk(edges, new ArrayList<>())).iterator().hasNext());
  }

  /**
   * Method under test: {@link Walk#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    edges.add(new HashSet<>());
    Walk walk = new Walk(edges, new ArrayList<>());
    ArrayList<Set<Edge>> edges2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(walk, new Walk(edges2, new ArrayList<>()));
  }

  /**
   * Method under test: {@link Walk#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertNotEquals(new Walk(edges, new ArrayList<>()), null);
  }

  /**
   * Method under test: {@link Walk#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();

    // Act and Assert
    assertNotEquals(new Walk(edges, new ArrayList<>()), "Different type to Walk");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Walk#Walk(List, List)}
   *   <li>{@link Walk#toString()}
   *   <li>{@link Walk#getEdges()}
   *   <li>{@link Walk#getEntitiesAsEntries()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ArrayList<Set<Edge>> edges = new ArrayList<>();
    ArrayList<Map.Entry<Object, Set<Entity>>> entities = new ArrayList<>();

    // Act
    Walk actualWalk = new Walk(edges, entities);
    actualWalk.toString();
    List<Set<Edge>> actualEdges = actualWalk.getEdges();
    List<Map.Entry<Object, Set<Entity>>> actualEntitiesAsEntries = actualWalk.getEntitiesAsEntries();

    // Assert
    assertTrue(actualEdges.isEmpty());
    assertTrue(actualEntitiesAsEntries.isEmpty());
    assertSame(edges, actualEdges);
    assertSame(entities, actualEntitiesAsEntries);
  }
}
