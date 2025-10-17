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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;

class EntityDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#group(String)}
   *   <li>{@link Builder#vertex(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity Builder.build()",
    "Builder Builder.group(String)",
    "Builder Builder.vertex(Object)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Entity actualEntity = new Builder().group("Group").vertex("Vertex").build();

    // Assert
    assertEquals("Group", actualEntity.getGroup());
    assertEquals("Vertex", actualEntity.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualEntity.getClassName());
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    Entity entity = new Builder().build();
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", entity.getClassName());
    assertNull(entity.getVertex());
    assertTrue(entity.getProperties().isEmpty());
    assertEquals(Element.DEFAULT_GROUP, entity.getGroup());
  }

  /**
   * Test Builder {@link Builder#properties(Map)}.
   *
   * <p>Method under test: {@link Builder#properties(Map)}
   */
  @Test
  @DisplayName("Test Builder properties(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.properties(Map)"})
  void testBuilderProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertiesResult = builder.properties(new HashMap<>());

    // Assert
    assertSame(builder, actualPropertiesResult);
  }

  /**
   * Test Builder {@link Builder#property(String, Object)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#property(String, Object)}
   */
  @Test
  @DisplayName("Test Builder property(String, Object); when 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.property(String, Object)"})
  void testBuilderProperty_whenName() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertyResult = builder.property("Name", null);

    // Assert
    assertSame(builder, actualPropertyResult);
  }

  /**
   * Test Builder {@link Builder#property(String, Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#property(String, Object)}
   */
  @Test
  @DisplayName("Test Builder property(String, Object); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.property(String, Object)"})
  void testBuilderProperty_whenNull() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertyResult = builder.property(null, null);

    // Assert
    assertSame(builder, actualPropertyResult);
  }

  /**
   * Test Builder {@link Builder#property(String, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#property(String, Object)}
   */
  @Test
  @DisplayName("Test Builder property(String, Object); when 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.property(String, Object)"})
  void testBuilderProperty_whenValue() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualPropertyResult = builder.property("Name", "Value");

    // Assert
    assertSame(builder, actualPropertyResult);
  }

  /**
   * Test {@link Entity#Entity()}.
   *
   * <p>Method under test: {@link Entity#Entity()}
   */
  @Test
  @DisplayName("Test new Entity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.<init>()"})
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
   * Test {@link Entity#Entity(String)}.
   *
   * <p>Method under test: {@link Entity#Entity(String)}
   */
  @Test
  @DisplayName("Test new Entity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.<init>(String)"})
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
   * Test {@link Entity#Entity(String, Object)}.
   *
   * <p>Method under test: {@link Entity#Entity(String, Object)}
   */
  @Test
  @DisplayName("Test new Entity(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.<init>(String, Object)"})
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
   * Test {@link Entity#Entity(String, Object, Properties)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Properties Empty.
   * </ul>
   *
   * <p>Method under test: {@link Entity#Entity(String, Object, Properties)}
   */
  @Test
  @DisplayName(
      "Test new Entity(String, Object, Properties); when 'null'; then return Properties Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.<init>(String, Object, Properties)"})
  void testNewEntity_whenNull_thenReturnPropertiesEmpty() {
    // Arrange and Act
    Entity actualEntity = new Entity("Group", "Vertex", null);

    // Assert
    assertEquals("Group", actualEntity.getGroup());
    assertEquals("Vertex", actualEntity.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualEntity.getClassName());
    assertTrue(actualEntity.getProperties().isEmpty());
  }

  /**
   * Test {@link Entity#Entity(String, Object, Properties)}.
   *
   * <ul>
   *   <li>When {@link Properties#Properties()}.
   *   <li>Then return Properties is {@link Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#Entity(String, Object, Properties)}
   */
  @Test
  @DisplayName(
      "Test new Entity(String, Object, Properties); when Properties(); then return Properties is Properties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.<init>(String, Object, Properties)"})
  void testNewEntity_whenProperties_thenReturnPropertiesIsProperties() {
    // Arrange
    Properties properties = new Properties();

    // Act
    Entity actualEntity = new Entity("Group", "Vertex", properties);

    // Assert
    assertEquals("Group", actualEntity.getGroup());
    assertEquals("Vertex", actualEntity.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualEntity.getClassName());
    assertSame(properties, actualEntity.getProperties());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Entity#setVertex(Object)}
   *   <li>{@link Entity#toString()}
   *   <li>{@link Entity#getVertex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object Entity.getVertex()",
    "void Entity.setVertex(Object)",
    "String Entity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    // Act
    entity.setVertex("Vertex");
    String actualToStringResult = entity.toString();

    // Assert
    assertEquals("Entity[vertex=Vertex,group=Group,properties=Properties[]]", actualToStringResult);
    assertEquals("Vertex", entity.getVertex());
  }

  /**
   * Test {@link Entity#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>When {@code GROUP}.
   *   <li>Then return {@link Element#DEFAULT_GROUP}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); when 'GROUP'; then return DEFAULT_GROUP")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Entity.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenGroup_thenReturnDefault_group() {
    // Arrange, Act and Assert
    assertEquals(Element.DEFAULT_GROUP, new Entity().getIdentifier(IdentifierType.GROUP));
  }

  /**
   * Test {@link Entity#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>When {@code SOURCE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); when 'SOURCE'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Entity.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenSource_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Entity().getIdentifier(IdentifierType.SOURCE));
  }

  /**
   * Test {@link Entity#getIdentifier(IdentifierType)}.
   *
   * <ul>
   *   <li>When {@code VERTEX}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); when 'VERTEX'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object Entity.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenVertex_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Entity().getIdentifier(IdentifierType.VERTEX));
  }

  /**
   * Test {@link Entity#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@code GROUP}.
   *   <li>Then {@link Entity#Entity()} Group is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName(
      "Test putIdentifier(IdentifierType, Object); when 'GROUP'; then Entity() Group is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenGroup_thenEntityGroupIs42() {
    // Arrange
    Entity entity = new Entity();

    // Act
    entity.putIdentifier(IdentifierType.GROUP, "42");

    // Assert
    assertEquals("42", entity.getGroup());
    assertNull(entity.getVertex());
  }

  /**
   * Test {@link Entity#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@code SOURCE}.
   *   <li>Then {@link Entity#Entity()} Group is {@link Element#DEFAULT_GROUP}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName(
      "Test putIdentifier(IdentifierType, Object); when 'SOURCE'; then Entity() Group is DEFAULT_GROUP")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenSource_thenEntityGroupIsDefault_group() {
    // Arrange
    Entity entity = new Entity();

    // Act
    entity.putIdentifier(IdentifierType.SOURCE, "Value");

    // Assert that nothing has changed
    assertEquals(Element.DEFAULT_GROUP, entity.getGroup());
  }

  /**
   * Test {@link Entity#putIdentifier(IdentifierType, Object)}.
   *
   * <ul>
   *   <li>When {@code VERTEX}.
   *   <li>Then {@link Entity#Entity()} Vertex is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName(
      "Test putIdentifier(IdentifierType, Object); when 'VERTEX'; then Entity() Vertex is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Entity.putIdentifier(IdentifierType, Object)"})
  void testPutIdentifier_whenVertex_thenEntityVertexIsValue() {
    // Arrange
    Entity entity = new Entity();

    // Act
    entity.putIdentifier(IdentifierType.VERTEX, "Value");

    // Assert
    assertEquals("Value", entity.getVertex());
    assertEquals(Element.DEFAULT_GROUP, entity.getGroup());
  }

  /**
   * Test {@link Entity#equals(Object)}, and {@link Entity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Entity#equals(Object)}
   *   <li>{@link Entity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    Entity entity2 = new Builder().group("Group").vertex("Vertex").build();

    // Act and Assert
    assertEquals(entity, entity2);
    assertEquals(entity.hashCode(), entity2.hashCode());
  }

  /**
   * Test {@link Entity#equals(Object)}, and {@link Entity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Entity#equals(Object)}
   *   <li>{@link Entity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    // Act and Assert
    assertEquals(entity, entity);
    int expectedHashCodeResult = entity.hashCode();
    assertEquals(expectedHashCodeResult, entity.hashCode());
  }

  /**
   * Test {@link Entity#equals(Entity)} with {@code entity}.
   *
   * <p>Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  @DisplayName("Test equals(Entity) with 'entity'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Entity.equals(Entity)"})
  void testEqualsWithEntity() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act and Assert
    assertFalse(lazyEntity.equals(new Entity()));
  }

  /**
   * Test {@link Entity#equals(Entity)} with {@code entity}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Group} Properties is {@code null}.
   *   <li>When {@link Entity#Entity()}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  @DisplayName(
      "Test equals(Entity) with 'entity'; given Entity(String) with 'Group' Properties is 'null'; when Entity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Entity.equals(Entity)"})
  void testEqualsWithEntity_givenEntityWithGroupPropertiesIsNull_whenEntity() {
    // Arrange
    Entity entity = new Entity("Group");
    entity.setGroup(null);
    entity.setProperties(null);

    // Act and Assert
    assertFalse(entity.equals(new Entity()));
  }

  /**
   * Test {@link Entity#equals(Entity)} with {@code entity}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Group} Properties is {@code null}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  @DisplayName(
      "Test equals(Entity) with 'entity'; given Entity(String) with 'Group' Properties is 'null'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Entity.equals(Entity)"})
  void testEqualsWithEntity_givenEntityWithGroupPropertiesIsNull_whenNull() {
    // Arrange
    Entity entity = new Entity("Group");
    entity.setGroup(null);
    entity.setProperties(null);

    // Act and Assert
    assertFalse(entity.equals((Entity) null));
  }

  /**
   * Test {@link Entity#equals(Entity)} with {@code entity}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity(String)} with {@code Group} Properties is {@link
   *       Properties#Properties()}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  @DisplayName(
      "Test equals(Entity) with 'entity'; given Entity(String) with 'Group' Properties is Properties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Entity.equals(Entity)"})
  void testEqualsWithEntity_givenEntityWithGroupPropertiesIsProperties() {
    // Arrange
    Entity entity = new Entity("Group");
    entity.setGroup(null);
    entity.setProperties(new Properties());

    Entity entity2 = new Entity("Group");
    entity2.setGroup(null);
    entity2.setProperties(null);

    // Act
    boolean actualEqualsResult = entity.equals(entity2);

    // Assert
    assertFalse(actualEqualsResult);
  }

  /**
   * Test {@link Entity#equals(Entity)} with {@code entity}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity()}.
   *   <li>When {@link Entity#Entity()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  @DisplayName(
      "Test equals(Entity) with 'entity'; given Entity(); when Entity(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Entity.equals(Entity)"})
  void testEqualsWithEntity_givenEntity_whenEntity_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(entity.equals(new Entity()));
  }

  /**
   * Test {@link Entity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Entity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Entity entity = new Builder().group(Element.DEFAULT_GROUP).vertex("Vertex").build();

    // Act and Assert
    assertNotEquals(entity, new Builder().group("Group").vertex("Vertex").build());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Entity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder groupResult = new Builder().group("Group");
    Entity entity =
        groupResult.vertex(new Builder().group("Group").vertex("Vertex").build()).build();

    // Act and Assert
    assertNotEquals(entity, new Builder().group("Group").vertex("Vertex").build());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Entity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder groupResult = new Builder().group("Group");
    Entity entity =
        groupResult.vertex(new Builder().group("Group").vertex("Vertex").build()).build();

    LazyEntity lazyEntity = mock(LazyEntity.class);
    when(lazyEntity.getVertex()).thenReturn("Vertex");

    // Act and Assert
    assertNotEquals(entity, new Builder().group("Group").vertex(lazyEntity).build());
  }

  /**
   * Test {@link Entity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Entity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().group("Group").vertex("Vertex").build(), null);
  }

  /**
   * Test {@link Entity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Entity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder().group("Group").vertex("Vertex").build(), "Different type to Entity");
  }

  /**
   * Test {@link Entity#emptyClone()}.
   *
   * <p>Method under test: {@link Entity#emptyClone()}
   */
  @Test
  @DisplayName("Test emptyClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.emptyClone()"})
  void testEmptyClone() {
    // Arrange
    Entity entity = new Entity();

    // Act
    Entity actualEmptyCloneResult = entity.emptyClone();

    // Assert
    assertEquals(entity, actualEmptyCloneResult);
  }

  /**
   * Test {@link Entity#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link Entity#Entity()}.
   *   <li>Then return {@link Entity#Entity()}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given Entity(); then return Entity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.shallowClone()"})
  void testShallowClone_givenEntity_thenReturnEntity() {
    // Arrange
    Entity entity = new Entity();

    // Act
    Entity actualShallowCloneResult = entity.shallowClone();

    // Assert
    assertEquals(entity, actualShallowCloneResult);
  }

  /**
   * Test {@link Entity#shallowClone()}.
   *
   * <ul>
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link Entity#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity Entity.shallowClone()"})
  void testShallowClone_thenReturnGroup() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    LazyEntity lazyEntity = new LazyEntity(entity, valueLoader);

    // Act
    Entity actualShallowCloneResult = lazyEntity.shallowClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Group", actualShallowCloneResult.getGroup());
    assertEquals("Vertex", actualShallowCloneResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualShallowCloneResult.getClassName());
    assertTrue(actualShallowCloneResult.getProperties().isEmpty());
  }
}
