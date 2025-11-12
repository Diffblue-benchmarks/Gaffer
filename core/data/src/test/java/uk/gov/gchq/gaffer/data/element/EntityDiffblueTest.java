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

package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class EntityDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Entity.Builder#build()}
   *   <li>{@link Entity.Builder#group(String)}
   *   <li>{@link Entity.Builder#vertex(Object)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    Entity actualBuildResult = (new Entity.Builder()).group("Group").vertex("Vertex").build();

    // Assert
    assertEquals("Group", actualBuildResult.getGroup());
    assertEquals("Vertex", actualBuildResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualBuildResult.getClassName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link Entity.Builder}
   */
  @Test
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    Entity buildResult = (new Entity.Builder()).build();
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", buildResult.getClassName());
    assertNull(buildResult.getVertex());
    assertTrue(buildResult.getProperties().isEmpty());
    assertEquals(Element.DEFAULT_GROUP, buildResult.getGroup());
  }

  /**
   * Method under test: {@link Entity.Builder#properties(Map)}
   */
  @Test
  void testBuilderProperties() {
    // Arrange
    Entity.Builder builder = new Entity.Builder();

    // Act and Assert
    assertSame(builder, builder.properties(new HashMap<>()));
  }

  /**
   * Method under test: {@link Entity.Builder#properties(Map)}
   */
  @Test
  void testBuilderProperties2() {
    // Arrange
    Entity.Builder builder = new Entity.Builder();

    HashMap<String, String> properties = new HashMap<>();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertSame(builder, builder.properties(properties));
  }

  /**
   * Method under test: {@link Entity.Builder#property(String, Object)}
   */
  @Test
  void testBuilderProperty() {
    // Arrange
    Entity.Builder builder = new Entity.Builder();

    // Act and Assert
    assertSame(builder, builder.property("Name", "Value"));
  }

  /**
   * Method under test: {@link Entity#getIdentifier(IdentifierType)}
   */
  @Test
  void testGetIdentifier() {
    // Arrange, Act and Assert
    assertNull((new Entity()).getIdentifier(IdentifierType.VERTEX));
    assertEquals(Element.DEFAULT_GROUP, (new Entity()).getIdentifier(IdentifierType.GROUP));
  }

  /**
   * Method under test: {@link Entity#putIdentifier(IdentifierType, Object)}
   */
  @Test
  void testPutIdentifier() {
    // Arrange
    Entity entity = new Entity();

    // Act
    entity.putIdentifier(IdentifierType.VERTEX, "Value");

    // Assert
    assertEquals("Value", entity.getVertex());
    assertEquals(Element.DEFAULT_GROUP, entity.getGroup());
  }

  /**
   * Method under test: {@link Entity#putIdentifier(IdentifierType, Object)}
   */
  @Test
  void testPutIdentifier2() {
    // Arrange
    Entity entity = new Entity();

    // Act
    entity.putIdentifier(IdentifierType.GROUP, "42");

    // Assert
    assertEquals("42", entity.getGroup());
    assertNull(entity.getVertex());
  }

  /**
   * Method under test: {@link Entity#putIdentifier(IdentifierType, Object)}
   */
  @Test
  void testPutIdentifier3() {
    // Arrange
    Entity entity = new Entity();

    // Act
    entity.putIdentifier(IdentifierType.SOURCE, "Value");

    // Assert
    assertNull(entity.getVertex());
    assertEquals(Element.DEFAULT_GROUP, entity.getGroup());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Entity#equals(Object)}
   *   <li>{@link Entity#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Entity entity = new Entity();
    Entity entity2 = new Entity();

    // Act and Assert
    assertEquals(entity, entity2);
    int expectedHashCodeResult = entity.hashCode();
    assertEquals(expectedHashCodeResult, entity2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Entity#equals(Object)}
   *   <li>{@link Entity#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertEquals(entity, entity);
    int expectedHashCodeResult = entity.hashCode();
    assertEquals(expectedHashCodeResult, entity.hashCode());
  }

  /**
   * Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  void testEquals() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(entity.equals(new Entity()));
  }

  /**
   * Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  void testEquals2() {
    // Arrange
    Entity entity = new Entity();
    entity.putIdentifier(IdentifierType.VERTEX, "Value");

    // Act and Assert
    assertFalse(entity.equals(new Entity()));
  }

  /**
   * Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  void testEquals3() {
    // Arrange
    Entity entity = new Entity("Group");
    entity.putIdentifier(IdentifierType.VERTEX, "Value");

    // Act and Assert
    assertFalse(entity.equals(new Entity()));
  }

  /**
   * Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  void testEquals4() {
    // Arrange
    LazyEntity lazyEntity = new LazyEntity(new Entity(), mock(ElementValueLoader.class));
    lazyEntity.putIdentifier(IdentifierType.VERTEX, "Value");

    // Act and Assert
    assertFalse(lazyEntity.equals(new Entity()));
  }

  /**
   * Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  void testEquals5() {
    // Arrange
    Entity entity = new Entity();

    Entity entity2 = new Entity();
    entity2.putIdentifier(IdentifierType.VERTEX, "Value");

    // Act and Assert
    assertFalse(entity.equals(entity2));
  }

  /**
   * Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  void testEquals6() {
    // Arrange, Act and Assert
    assertFalse((new Entity()).equals((Entity) null));
  }

  /**
   * Method under test: {@link Entity#emptyClone()}
   */
  @Test
  void testEmptyClone() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertEquals(entity, entity.emptyClone());
  }

  /**
   * Method under test: {@link Entity#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertEquals(entity, entity.shallowClone());
  }

  /**
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Entity entity = new Entity();
    entity.putIdentifier(IdentifierType.VERTEX, "Value");

    // Act and Assert
    assertNotEquals(entity, new Entity());
  }

  /**
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LazyEntity lazyEntity = new LazyEntity(new Entity(), mock(ElementValueLoader.class));
    lazyEntity.putIdentifier(IdentifierType.VERTEX, "Value");

    // Act and Assert
    assertNotEquals(lazyEntity, new Entity());
  }

  /**
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Entity(), null);
  }

  /**
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Entity(), "Different type to Entity");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Entity#setVertex(Object)}
   *   <li>{@link Entity#getVertex()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Entity entity = new Entity();

    // Act
    entity.setVertex("Vertex");

    // Assert that nothing has changed
    assertEquals("Vertex", entity.getVertex());
  }

  /**
   * Method under test: {@link Entity#Entity()}
   */
  @Test
  void testNewEntity() {
    // Arrange and Act
    Entity actualEntity = new Entity();

    // Assert
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualEntity.getClassName());
    assertNull(actualEntity.getVertex());
    assertTrue(actualEntity.getProperties().isEmpty());
    assertEquals(Element.DEFAULT_GROUP, actualEntity.getGroup());
  }

  /**
   * Method under test: {@link Entity#Entity(String)}
   */
  @Test
  void testNewEntity2() {
    // Arrange and Act
    Entity actualEntity = new Entity("Group");

    // Assert
    assertEquals("Group", actualEntity.getGroup());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualEntity.getClassName());
    assertNull(actualEntity.getVertex());
    assertTrue(actualEntity.getProperties().isEmpty());
  }

  /**
   * Method under test: {@link Entity#Entity(String, Object)}
   */
  @Test
  void testNewEntity3() {
    // Arrange and Act
    Entity actualEntity = new Entity("Group", "Vertex");

    // Assert
    assertEquals("Group", actualEntity.getGroup());
    assertEquals("Vertex", actualEntity.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualEntity.getClassName());
    assertTrue(actualEntity.getProperties().isEmpty());
  }

  /**
   * Method under test: {@link Entity#Entity(String, Object, Properties)}
   */
  @Test
  void testNewEntity4() {
    // Arrange
    Properties properties = new Properties();

    // Act
    Entity actualEntity = new Entity("Group", "Vertex", properties);

    // Assert
    assertEquals("Group", actualEntity.getGroup());
    assertEquals("Vertex", actualEntity.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualEntity.getClassName());
    Properties properties2 = actualEntity.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Method under test: {@link Entity#Entity(String, Object, Properties)}
   */
  @Test
  void testNewEntity5() {
    // Arrange and Act
    Entity actualEntity = new Entity("Group", "Vertex", null);

    // Assert
    assertEquals("Group", actualEntity.getGroup());
    assertEquals("Vertex", actualEntity.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualEntity.getClassName());
    assertTrue(actualEntity.getProperties().isEmpty());
  }

  /**
   * Method under test: {@link Entity#Entity(String, Object, Properties)}
   */
  @Test
  void testNewEntity6() {
    // Arrange
    Properties properties = new Properties();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    Entity actualEntity = new Entity("Group", "Vertex", properties);

    // Assert
    assertEquals("Group", actualEntity.getGroup());
    assertEquals("Vertex", actualEntity.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualEntity.getClassName());
    Properties properties2 = actualEntity.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }
}
