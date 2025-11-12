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
import static org.mockito.Mockito.mock;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.LazyEntity;

class EntityMapDiffblueTest {
  /**
   * Method under test: {@link EntityMap#putEntity(Object, Entity)}
   */
  @Test
  void testPutEntity() {
    // Arrange
    EntityMap entityMap = new EntityMap();

    // Act
    boolean actualPutEntityResult = entityMap.putEntity("Vertex", new Entity("Group"));

    // Assert
    assertEquals(1, entityMap.getVertices().size());
    assertTrue(actualPutEntityResult);
  }

  /**
   * Method under test: {@link EntityMap#putEntity(Object, Entity)}
   */
  @Test
  void testPutEntity2() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    entityMap.putEntity("Vertex", new Entity("Group"));

    // Act
    boolean actualPutEntityResult = entityMap.putEntity("Vertex", new Entity("Group"));

    // Assert
    assertEquals(1, entityMap.getVertices().size());
    assertFalse(actualPutEntityResult);
  }

  /**
   * Method under test: {@link EntityMap#putEntity(Object, Entity)}
   */
  @Test
  void testPutEntity3() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    LazyEntity lazyEntity = new LazyEntity(new Entity("Group"), mock(ElementValueLoader.class));

    entityMap.putEntity(lazyEntity, new Entity("Group"));

    // Act
    boolean actualPutEntityResult = entityMap.putEntity("Vertex", new Entity("Group"));

    // Assert
    assertEquals(2, entityMap.getVertices().size());
    assertTrue(actualPutEntityResult);
  }

  /**
   * Method under test: {@link EntityMap#putEntities(Object, Set)}
   */
  @Test
  void testPutEntities() {
    // Arrange
    EntityMap entityMap = new EntityMap();

    // Act and Assert
    assertFalse(entityMap.putEntities("Vertex", new HashSet<>()));
    assertTrue(entityMap.getVertices().isEmpty());
  }

  /**
   * Method under test: {@link EntityMap#putEntities(Object, Set)}
   */
  @Test
  void testPutEntities2() {
    // Arrange
    EntityMap entityMap = new EntityMap();

    HashSet<Entity> entities = new HashSet<>();
    entities.add(new Entity("Group"));

    // Act
    boolean actualPutEntitiesResult = entityMap.putEntities("Vertex", entities);

    // Assert
    assertEquals(1, entityMap.getVertices().size());
    assertTrue(actualPutEntitiesResult);
  }

  /**
   * Method under test: {@link EntityMap#putEntities(Object, Set)}
   */
  @Test
  void testPutEntities3() {
    // Arrange
    EntityMap entityMap = new EntityMap();

    HashSet<Entity> entities = new HashSet<>();
    entities.add(new Entity("uk.gov.gchq.gaffer.data.element.Entity"));
    entities.add(new Entity("Group"));

    // Act
    boolean actualPutEntitiesResult = entityMap.putEntities("Vertex", entities);

    // Assert
    assertEquals(1, entityMap.getVertices().size());
    assertTrue(actualPutEntitiesResult);
  }

  /**
   * Method under test: {@link EntityMap#putEntities(Object, Set)}
   */
  @Test
  void testPutEntities4() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    entityMap.putEntity("Vertex", new Entity("Group"));

    HashSet<Entity> entities = new HashSet<>();
    entities.add(new Entity("Group"));

    // Act
    boolean actualPutEntitiesResult = entityMap.putEntities("Vertex", entities);

    // Assert
    assertEquals(1, entityMap.getVertices().size());
    assertFalse(actualPutEntitiesResult);
  }

  /**
   * Method under test: {@link EntityMap#putEntities(Object, Set)}
   */
  @Test
  void testPutEntities5() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    LazyEntity lazyEntity = new LazyEntity(new Entity("Group"), mock(ElementValueLoader.class));

    entityMap.putEntity(lazyEntity, new Entity("Group"));

    HashSet<Entity> entities = new HashSet<>();
    entities.add(new Entity("Group"));

    // Act
    boolean actualPutEntitiesResult = entityMap.putEntities("Vertex", entities);

    // Assert
    assertEquals(2, entityMap.getVertices().size());
    assertTrue(actualPutEntitiesResult);
  }

  /**
   * Method under test: {@link EntityMap#get(Object)}
   */
  @Test
  void testGet() {
    // Arrange, Act and Assert
    assertTrue((new EntityMap()).get("Vertex").isEmpty());
  }

  /**
   * Method under test: {@link EntityMap#get(Object)}
   */
  @Test
  void testGet2() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    entityMap.putEntity("Vertex", new Entity("Group"));

    // Act and Assert
    assertEquals(1, entityMap.get("Vertex").size());
  }

  /**
   * Method under test: {@link EntityMap#get(Object)}
   */
  @Test
  void testGet3() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    entityMap.putEntity("Vertex", new LazyEntity(new Entity("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertEquals(1, entityMap.get("Vertex").size());
  }

  /**
   * Method under test: {@link EntityMap#getVertices()}
   */
  @Test
  void testGetVertices() {
    // Arrange, Act and Assert
    assertTrue((new EntityMap()).getVertices().isEmpty());
  }

  /**
   * Method under test: {@link EntityMap#getVertices()}
   */
  @Test
  void testGetVertices2() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    entityMap.putEntity("Vertex", new LazyEntity(new Entity("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertEquals(1, entityMap.getVertices().size());
  }

  /**
   * Method under test: {@link EntityMap#containsVertex(Object)}
   */
  @Test
  void testContainsVertex() {
    // Arrange, Act and Assert
    assertFalse((new EntityMap()).containsVertex("Vertex"));
  }

  /**
   * Method under test: {@link EntityMap#containsVertex(Object)}
   */
  @Test
  void testContainsVertex2() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    entityMap.putEntity("Vertex", new Entity("Group"));

    // Act and Assert
    assertTrue(entityMap.containsVertex("Vertex"));
  }

  /**
   * Method under test: {@link EntityMap#containsVertex(Object)}
   */
  @Test
  void testContainsVertex3() {
    // Arrange
    EntityMap entityMap = new EntityMap();
    entityMap.putEntity("Vertex", new LazyEntity(new Entity("Group"), mock(ElementValueLoader.class)));

    // Act and Assert
    assertTrue(entityMap.containsVertex("Vertex"));
  }

  /**
   * Method under test: default or parameterless constructor of {@link EntityMap}
   */
  @Test
  void testNewEntityMap() {
    // Arrange, Act and Assert
    assertTrue((new EntityMap()).getVertices().isEmpty());
  }

  /**
   * Method under test: {@link EntityMap#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("{}", (new EntityMap()).toString());
  }
}
