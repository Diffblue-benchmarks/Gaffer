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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#group(String)}
   *   <li>{@link Builder#vertex(Object)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity Builder.build()", "Builder Builder.group(String)", "Builder Builder.vertex(Object)"})
  void testBuilderBuild() {
    // Arrange and Act
    Entity actualBuildResult = (new Builder()).group("Group").vertex("Vertex").build();

    // Assert
    assertEquals("Group", actualBuildResult.getGroup());
    assertEquals("Vertex", actualBuildResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualBuildResult.getClassName());
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    Entity buildResult = (new Builder()).build();
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", buildResult.getClassName());
    assertNull(buildResult.getVertex());
    assertTrue(buildResult.getProperties().isEmpty());
    assertEquals(Element.DEFAULT_GROUP, buildResult.getGroup());
  }

  /**
   * Test Builder {@link Builder#properties(Map)}.
   * <p>
   * Method under test: {@link Builder#properties(Map)}
   */
  @Test
  @DisplayName("Test Builder properties(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.properties(Map)"})
  void testBuilderProperties() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.properties(new HashMap<>()));
  }

  /**
   * Test Builder {@link Builder#property(String, Object)}.
   * <p>
   * Method under test: {@link Builder#property(String, Object)}
   */
  @Test
  @DisplayName("Test Builder property(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.property(String, Object)"})
  void testBuilderProperty() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.property("Name", "Value"));
  }

  /**
   * Test {@link Entity#Entity()}.
   * <p>
   * Method under test: {@link Entity#Entity()}
   */
  @Test
  @DisplayName("Test new Entity()")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Entity#Entity(String)}
   */
  @Test
  @DisplayName("Test new Entity(String)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Entity#Entity(String, Object)}
   */
  @Test
  @DisplayName("Test new Entity(String, Object)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#Entity(String, Object, Properties)}
   */
  @Test
  @DisplayName("Test new Entity(String, Object, Properties); when 'null'; then return Properties Empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link Properties#Properties()}.</li>
   *   <li>Then return Properties is {@link Properties#Properties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#Entity(String, Object, Properties)}
   */
  @Test
  @DisplayName("Test new Entity(String, Object, Properties); when Properties(); then return Properties is Properties()")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Entity#setVertex(Object)}
   *   <li>{@link Entity#toString()}
   *   <li>{@link Entity#getVertex()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Entity.getVertex()", "void Entity.setVertex(Object)", "String Entity.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();

    // Act
    buildResult.setVertex("Vertex");
    String actualToStringResult = buildResult.toString();

    // Assert
    assertEquals("Entity[vertex=Vertex,group=Group,properties=Properties[]]", actualToStringResult);
    assertEquals("Vertex", buildResult.getVertex());
  }

  /**
   * Test {@link Entity#getIdentifier(IdentifierType)}.
   * <ul>
   *   <li>When {@code GROUP}.</li>
   *   <li>Then return {@link Element#DEFAULT_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); when 'GROUP'; then return DEFAULT_GROUP")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Entity.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenGroup_thenReturnDefault_group() {
    // Arrange, Act and Assert
    assertEquals(Element.DEFAULT_GROUP, (new Entity()).getIdentifier(IdentifierType.GROUP));
  }

  /**
   * Test {@link Entity#getIdentifier(IdentifierType)}.
   * <ul>
   *   <li>When {@code SOURCE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); when 'SOURCE'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Entity.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenSource_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Entity()).getIdentifier(IdentifierType.SOURCE));
  }

  /**
   * Test {@link Entity#getIdentifier(IdentifierType)}.
   * <ul>
   *   <li>When {@code VERTEX}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#getIdentifier(IdentifierType)}
   */
  @Test
  @DisplayName("Test getIdentifier(IdentifierType); when 'VERTEX'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Entity.getIdentifier(IdentifierType)"})
  void testGetIdentifier_whenVertex_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Entity()).getIdentifier(IdentifierType.VERTEX));
  }

  /**
   * Test {@link Entity#putIdentifier(IdentifierType, Object)}.
   * <ul>
   *   <li>When {@code GROUP}.</li>
   *   <li>Then {@link Entity#Entity()} Group is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object); when 'GROUP'; then Entity() Group is '42'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code SOURCE}.</li>
   *   <li>Then {@link Entity#Entity()} Group is {@link Element#DEFAULT_GROUP}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object); when 'SOURCE'; then Entity() Group is DEFAULT_GROUP")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code VERTEX}.</li>
   *   <li>Then {@link Entity#Entity()} Vertex is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object); when 'VERTEX'; then Entity() Vertex is 'Value'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Entity#equals(Object)}
   *   <li>{@link Entity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult2 = (new Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link Entity#equals(Object)}, and {@link Entity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Entity#equals(Object)}
   *   <li>{@link Entity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link Entity#equals(Entity)} with {@code entity}.
   * <p>
   * Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  @DisplayName("Test equals(Entity) with 'entity'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Entity)"})
  void testEqualsWithEntity() {
    // Arrange
    Entity entity = (new Builder()).group("Group").vertex("Vertex").build();

    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));
    lazyEntity.putIdentifier(IdentifierType.VERTEX, "Value");

    // Act and Assert
    assertFalse(lazyEntity.equals(new Entity()));
  }

  /**
   * Test {@link Entity#equals(Entity)} with {@code entity}.
   * <ul>
   *   <li>Given {@link Builder} (default constructor) group {@code Group} vertex {@code Vertex} build.</li>
   *   <li>When {@link Entity#Entity()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  @DisplayName("Test equals(Entity) with 'entity'; given Builder (default constructor) group 'Group' vertex 'Vertex' build; when Entity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Entity)"})
  void testEqualsWithEntity_givenBuilderGroupGroupVertexVertexBuild_whenEntity() {
    // Arrange
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertFalse(buildResult.equals(new Entity()));
  }

  /**
   * Test {@link Entity#equals(Entity)} with {@code entity}.
   * <ul>
   *   <li>Given {@link Entity#Entity()} Identifier {@code VERTEX} is {@code Value}.</li>
   *   <li>When {@link Entity#Entity()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  @DisplayName("Test equals(Entity) with 'entity'; given Entity() Identifier 'VERTEX' is 'Value'; when Entity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Entity)"})
  void testEqualsWithEntity_givenEntityIdentifierVertexIsValue_whenEntity() {
    // Arrange
    Entity entity = new Entity();
    entity.putIdentifier(IdentifierType.VERTEX, "Value");

    // Act and Assert
    assertFalse(entity.equals(new Entity()));
  }

  /**
   * Test {@link Entity#equals(Entity)} with {@code entity}.
   * <ul>
   *   <li>Given {@link Entity#Entity()}.</li>
   *   <li>When {@link Entity#Entity()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  @DisplayName("Test equals(Entity) with 'entity'; given Entity(); when Entity(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Entity)"})
  void testEqualsWithEntity_givenEntity_whenEntity_thenReturnTrue() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(entity.equals(new Entity()));
  }

  /**
   * Test {@link Entity#equals(Entity)} with {@code entity}.
   * <ul>
   *   <li>Given {@link Entity#Entity()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  @DisplayName("Test equals(Entity) with 'entity'; given Entity(); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Entity)"})
  void testEqualsWithEntity_givenEntity_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Entity()).equals((Entity) null));
  }

  /**
   * Test {@link Entity#equals(Entity)} with {@code entity}.
   * <ul>
   *   <li>Given {@code VERTEX}.</li>
   *   <li>When {@link Entity#Entity()} Identifier {@code VERTEX} is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Entity)}
   */
  @Test
  @DisplayName("Test equals(Entity) with 'entity'; given 'VERTEX'; when Entity() Identifier 'VERTEX' is 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Entity)"})
  void testEqualsWithEntity_givenVertex_whenEntityIdentifierVertexIsValue() {
    // Arrange
    Entity entity = new Entity();

    Entity entity2 = new Entity();
    entity2.putIdentifier(IdentifierType.VERTEX, "Value");

    // Act and Assert
    assertFalse(entity.equals(entity2));
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builder = mock(Builder.class);
    when(builder.group(Mockito.<String>any())).thenReturn(new Builder());
    Entity buildResult = builder.group("Group").vertex("Vertex").build();
    Entity buildResult2 = (new Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builder = mock(Builder.class);
    when(builder.group(Mockito.<String>any())).thenReturn(new Builder());
    Builder groupResult = builder.group("Group");
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult2 = groupResult.vertex(buildResult).build();
    Entity buildResult3 = (new Builder()).group(Element.DEFAULT_GROUP).vertex("Vertex").build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builder = mock(Builder.class);
    when(builder.group(Mockito.<String>any())).thenReturn(new Builder());
    Builder groupResult = builder.group("Group");
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();
    Entity buildResult2 = groupResult.vertex(buildResult).build();
    LazyEntity lazyEntity = mock(LazyEntity.class);
    when(lazyEntity.getVertex()).thenReturn("Vertex");
    Entity buildResult3 = (new Builder()).group(Element.DEFAULT_GROUP).vertex(lazyEntity).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link Entity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Entity.equals(Object)", "int Entity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Entity buildResult = (new Builder()).group("Group").vertex("Vertex").build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to Entity");
  }

  /**
   * Test {@link Entity#emptyClone()}.
   * <p>
   * Method under test: {@link Entity#emptyClone()}
   */
  @Test
  @DisplayName("Test emptyClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity Entity.emptyClone()"})
  void testEmptyClone() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertEquals(entity, entity.emptyClone());
  }

  /**
   * Test {@link Entity#shallowClone()}.
   * <ul>
   *   <li>Given {@link Entity#Entity()}.</li>
   *   <li>Then return {@link Entity#Entity()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given Entity(); then return Entity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity Entity.shallowClone()"})
  void testShallowClone_givenEntity_thenReturnEntity() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertEquals(entity, entity.shallowClone());
  }

  /**
   * Test {@link Entity#shallowClone()}.
   * <ul>
   *   <li>Given {@link LazyProperties} {@link LazyProperties#clone()} return {@link LazyProperties}.</li>
   *   <li>Then calls {@link LazyProperties#clone()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given LazyProperties clone() return LazyProperties; then calls clone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity Entity.shallowClone()"})
  void testShallowClone_givenLazyPropertiesCloneReturnLazyProperties_thenCallsClone() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyProperties lazyProperties = mock(LazyProperties.class);
    when(lazyProperties.clone()).thenReturn(mock(LazyProperties.class));
    Entity entity = (new Builder()).group("Group").vertex("Vertex").build();

    // Act
    Entity actualShallowCloneResult = (new LazyEntity(entity, valueLoader, lazyProperties)).shallowClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(lazyProperties).clone();
    assertEquals("Group", actualShallowCloneResult.getGroup());
    assertEquals("Vertex", actualShallowCloneResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualShallowCloneResult.getClassName());
  }

  /**
   * Test {@link Entity#shallowClone()}.
   * <ul>
   *   <li>Then return Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Entity#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity Entity.shallowClone()"})
  void testShallowClone_thenReturnPropertiesEmpty() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Entity entity = (new Builder()).group("Group").vertex("Vertex").build();

    // Act
    Entity actualShallowCloneResult = (new LazyEntity(entity, valueLoader)).shallowClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Group", actualShallowCloneResult.getGroup());
    assertEquals("Vertex", actualShallowCloneResult.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualShallowCloneResult.getClassName());
    assertTrue(actualShallowCloneResult.getProperties().isEmpty());
  }
}
