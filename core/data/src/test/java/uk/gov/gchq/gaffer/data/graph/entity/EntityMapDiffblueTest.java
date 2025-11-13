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

package uk.gov.gchq.gaffer.data.graph.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;

class EntityMapDiffblueTest {
  /**
   * Test {@link EntityMap#putEntity(Object, Entity)}.
   * <ul>
   *   <li>Given {@link EntityMap} (default constructor).</li>
   *   <li>When {@link Entity#Entity(String)} with {@code Group}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMap#putEntity(Object, Entity)}
   */
  @Test
  @DisplayName("Test putEntity(Object, Entity); given EntityMap (default constructor); when Entity(String) with 'Group'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityMap.putEntity(Object, Entity)"})
  void testPutEntity_givenEntityMap_whenEntityWithGroup_thenReturnTrue() {
    // Arrange
    EntityMap entityMap = new EntityMap();

    // Act
    boolean actualPutEntityResult = entityMap.putEntity("Vertex", new Entity("Group"));

    // Assert
    assertEquals(1, entityMap.getVertices().size());
    assertTrue(actualPutEntityResult);
  }

  /**
   * Test {@link EntityMap#putEntity(Object, Entity)}.
   * <ul>
   *   <li>Given {@code Vertex}.</li>
   *   <li>When {@link Entity#Entity(String)} with {@code Group} Vertex is {@code Vertex}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMap#putEntity(Object, Entity)}
   */
  @Test
  @DisplayName("Test putEntity(Object, Entity); given 'Vertex'; when Entity(String) with 'Group' Vertex is 'Vertex'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityMap.putEntity(Object, Entity)"})
  void testPutEntity_givenVertex_whenEntityWithGroupVertexIsVertex_thenReturnFalse() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    Entity entity = (new Builder()).group("Group").vertex("Vertex").build();
    entityMap.putEntity("Vertex", entity);

    Entity entity2 = new Entity("Group");
    entity2.setVertex("Vertex");

    // Act
    boolean actualPutEntityResult = entityMap.putEntity("Vertex", entity2);

    // Assert
    assertEquals(1, entityMap.getVertices().size());
    assertFalse(actualPutEntityResult);
  }

  /**
   * Test {@link EntityMap#putEntity(Object, Entity)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMap#putEntity(Object, Entity)}
   */
  @Test
  @DisplayName("Test putEntity(Object, Entity); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityMap.putEntity(Object, Entity)"})
  void testPutEntity_thenReturnTrue() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    Entity entity = (new Builder()).group("Group").vertex("Vertex").build();
    entityMap.putEntity("Vertex", entity);

    // Act
    boolean actualPutEntityResult = entityMap.putEntity("Vertex", new Entity("Group"));

    // Assert
    assertEquals(1, entityMap.getVertices().size());
    assertTrue(actualPutEntityResult);
  }

  /**
   * Test {@link EntityMap#putEntities(Object, Set)}.
   * <ul>
   *   <li>Given {@link Entity.Builder} (default constructor) group {@code UNKNOWN} vertex {@code Vertex} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMap#putEntities(Object, Set)}
   */
  @Test
  @DisplayName("Test putEntities(Object, Set); given Builder (default constructor) group 'UNKNOWN' vertex 'Vertex' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityMap.putEntities(Object, Set)"})
  void testPutEntities_givenBuilderGroupUnknownVertexVertexBuild() {
    // Arrange
    EntityMap entityMap = new EntityMap();

    HashSet<Entity> entities = new HashSet<>();
    Entity buildResult = (new Builder()).group("UNKNOWN").vertex("Vertex").build();
    entities.add(buildResult);
    Entity buildResult2 = (new Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult2);

    // Act
    boolean actualPutEntitiesResult = entityMap.putEntities("Vertex", entities);

    // Assert
    assertEquals(1, entityMap.getVertices().size());
    assertTrue(actualPutEntitiesResult);
  }

  /**
   * Test {@link EntityMap#putEntities(Object, Set)}.
   * <ul>
   *   <li>Given {@link EntityMap} (default constructor) Entity {@code Vertex} is {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code Vertex} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMap#putEntities(Object, Set)}
   */
  @Test
  @DisplayName("Test putEntities(Object, Set); given EntityMap (default constructor) Entity 'Vertex' is Builder (default constructor) group 'Group' vertex 'Vertex' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityMap.putEntities(Object, Set)"})
  void testPutEntities_givenEntityMapEntityVertexIsBuilderGroupGroupVertexVertexBuild() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    Entity entity = (new Builder()).group("Group").vertex("Vertex").build();
    entityMap.putEntity("Vertex", entity);

    HashSet<Entity> entities = new HashSet<>();
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult);

    // Act
    boolean actualPutEntitiesResult = entityMap.putEntities("Vertex", entities);

    // Assert
    assertEquals(1, entityMap.getVertices().size());
    assertFalse(actualPutEntitiesResult);
  }

  /**
   * Test {@link EntityMap#putEntities(Object, Set)}.
   * <ul>
   *   <li>Given {@link EntityMap} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMap#putEntities(Object, Set)}
   */
  @Test
  @DisplayName("Test putEntities(Object, Set); given EntityMap (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityMap.putEntities(Object, Set)"})
  void testPutEntities_givenEntityMap_thenReturnTrue() {
    // Arrange
    EntityMap entityMap = new EntityMap();

    HashSet<Entity> entities = new HashSet<>();
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();
    entities.add(buildResult);

    // Act
    boolean actualPutEntitiesResult = entityMap.putEntities("Vertex", entities);

    // Assert
    assertEquals(1, entityMap.getVertices().size());
    assertTrue(actualPutEntitiesResult);
  }

  /**
   * Test {@link EntityMap#putEntities(Object, Set)}.
   * <ul>
   *   <li>Given {@link EntityMap} (default constructor).</li>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then {@link EntityMap} (default constructor) Vertices Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMap#putEntities(Object, Set)}
   */
  @Test
  @DisplayName("Test putEntities(Object, Set); given EntityMap (default constructor); when HashSet(); then EntityMap (default constructor) Vertices Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityMap.putEntities(Object, Set)"})
  void testPutEntities_givenEntityMap_whenHashSet_thenEntityMapVerticesEmpty() {
    // Arrange
    EntityMap entityMap = new EntityMap();

    // Act and Assert
    assertFalse(entityMap.putEntities("Vertex", new HashSet<>()));
    assertTrue(entityMap.getVertices().isEmpty());
  }

  /**
   * Test {@link EntityMap#get(Object)}.
   * <ul>
   *   <li>Given {@link EntityMap} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMap#get(Object)}
   */
  @Test
  @DisplayName("Test get(Object); given EntityMap (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set EntityMap.get(Object)"})
  void testGet_givenEntityMap_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new EntityMap()).get("Vertex").isEmpty());
  }

  /**
   * Test {@link EntityMap#get(Object)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMap#get(Object)}
   */
  @Test
  @DisplayName("Test get(Object); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set EntityMap.get(Object)"})
  void testGet_thenReturnSizeIsOne() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    Entity entity = (new Builder()).group("Group").vertex("Vertex").build();
    entityMap.putEntity("Vertex", entity);

    // Act and Assert
    assertEquals(1, entityMap.get("Vertex").size());
  }

  /**
   * Test {@link EntityMap#getVertices()}.
   * <p>
   * Method under test: {@link EntityMap#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set EntityMap.getVertices()"})
  void testGetVertices() {
    // Arrange, Act and Assert
    assertTrue((new EntityMap()).getVertices().isEmpty());
  }

  /**
   * Test {@link EntityMap#containsVertex(Object)}.
   * <ul>
   *   <li>Given {@link EntityMap} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMap#containsVertex(Object)}
   */
  @Test
  @DisplayName("Test containsVertex(Object); given EntityMap (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityMap.containsVertex(Object)"})
  void testContainsVertex_givenEntityMap_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new EntityMap()).containsVertex("Vertex"));
  }

  /**
   * Test {@link EntityMap#containsVertex(Object)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityMap#containsVertex(Object)}
   */
  @Test
  @DisplayName("Test containsVertex(Object); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityMap.containsVertex(Object)"})
  void testContainsVertex_thenReturnTrue() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    Entity entity = (new Builder()).group("Group").vertex("Vertex").build();
    entityMap.putEntity("Vertex", entity);

    // Act and Assert
    assertTrue(entityMap.containsVertex("Vertex"));
  }

  /**
   * Test new {@link EntityMap} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link EntityMap}
   */
  @Test
  @DisplayName("Test new EntityMap (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityMap.<init>()"})
  void testNewEntityMap() {
    // Arrange, Act and Assert
    assertTrue((new EntityMap()).getVertices().isEmpty());
  }

  /**
   * Test {@link EntityMap#toString()}.
   * <p>
   * Method under test: {@link EntityMap#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String EntityMap.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("{}", (new EntityMap()).toString());
  }
}
