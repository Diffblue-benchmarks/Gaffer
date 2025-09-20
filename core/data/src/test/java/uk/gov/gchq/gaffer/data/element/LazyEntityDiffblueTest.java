package uk.gov.gchq.gaffer.data.element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Entity.Builder;

class LazyEntityDiffblueTest {
  /**
   * Test {@link LazyEntity#LazyEntity(Entity, ElementValueLoader)}.
   *
   * <ul>
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEntity#LazyEntity(Entity, ElementValueLoader)}
   */
  @Test
  @DisplayName("Test new LazyEntity(Entity, ElementValueLoader); then return 'Group'")
  @Tag("MaintainedByDiffblue")
  void testNewLazyEntity_thenReturnGroup() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity entity2 = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act
    LazyEntity actualLazyEntity = new LazyEntity(entity2, mock(ElementValueLoader.class));

    // Assert
    assertEquals("Group", actualLazyEntity.getGroup());
    assertEquals("Vertex", actualLazyEntity.getVertex());
    assertSame(entity2, actualLazyEntity.getElement());
  }

  /**
   * Test {@link LazyEntity#LazyEntity(Entity, ElementValueLoader, LazyProperties)}.
   *
   * <ul>
   *   <li>Then return {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEntity#LazyEntity(Entity, ElementValueLoader, LazyProperties)}
   */
  @Test
  @DisplayName(
      "Test new LazyEntity(Entity, ElementValueLoader, LazyProperties); then return 'Group'")
  @Tag("MaintainedByDiffblue")
  void testNewLazyEntity_thenReturnGroup2() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity entity2 = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act
    LazyEntity actualLazyEntity = new LazyEntity(entity2, mock(ElementValueLoader.class), null);

    // Assert
    assertEquals("Group", actualLazyEntity.getGroup());
    assertEquals("Vertex", actualLazyEntity.getVertex());
    assertSame(entity2, actualLazyEntity.getElement());
  }

  /**
   * Test {@link LazyEntity#getProperty(String)}.
   *
   * <p>Method under test: {@link LazyEntity#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String)")
  @Tag("MaintainedByDiffblue")
  void testGetProperty() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn("Property");
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    LazyEntity lazyEntity = new LazyEntity(entity, valueLoader);

    // Act
    lazyEntity.getProperty("Name");

    // Assert
    verify(valueLoader).getProperty(eq("Name"), isA(Properties.class));
    Properties properties = lazyEntity.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Property", properties.get("Name"));
    LazyProperties properties2 = lazyEntity.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Property", properties2.get((Object) "Name"));
  }

  /**
   * Test {@link LazyEntity#getProperty(String)}.
   *
   * <p>Method under test: {@link LazyEntity#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String)")
  @Tag("MaintainedByDiffblue")
  void testGetProperty2() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));
    lazyEntity.putProperty("Name", "Value");

    // Act
    Object actualProperty = lazyEntity.getProperty("Name");

    // Assert
    Properties properties = lazyEntity.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
    assertEquals("Value", actualProperty);
    LazyProperties properties2 = lazyEntity.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get((Object) "Name"));
  }

  /**
   * Test {@link LazyEntity#getProperty(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEntity#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String); when 'null'; then return 'Property'")
  @Tag("MaintainedByDiffblue")
  void testGetProperty_whenNull_thenReturnProperty() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any()))
        .thenReturn("Property");
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    LazyEntity lazyEntity = new LazyEntity(entity, valueLoader);

    // Act
    Object actualProperty = lazyEntity.getProperty(null);

    // Assert
    verify(valueLoader).getProperty(isNull(), isA(Properties.class));
    assertEquals("Property", actualProperty);
    assertTrue(lazyEntity.getElement().getProperties().isEmpty());
    assertTrue(lazyEntity.getProperties().isEmpty());
  }

  /**
   * Test {@link LazyEntity#getVertex()}.
   *
   * <ul>
   *   <li>Given {@link ElementValueLoader} {@link ElementValueLoader#loadIdentifiers(Element)} does
   *       nothing.
   *   <li>Then return {@code Vertex}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEntity#getVertex()}
   */
  @Test
  @DisplayName(
      "Test getVertex(); given ElementValueLoader loadIdentifiers(Element) does nothing; then return 'Vertex'")
  @Tag("MaintainedByDiffblue")
  void testGetVertex_givenElementValueLoaderLoadIdentifiersDoesNothing_thenReturnVertex() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    LazyEntity lazyEntity = new LazyEntity(entity, valueLoader);

    // Act
    Object actualVertex = lazyEntity.getVertex();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertEquals("Vertex", actualVertex);
  }

  /**
   * Test {@link LazyEntity#getVertex()}.
   *
   * <ul>
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link LazyEntity#getVertex()}
   */
  @Test
  @DisplayName("Test getVertex(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  void testGetVertex_thenReturnValue() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));
    lazyEntity.putIdentifier(IdentifierType.VERTEX, "Value");

    // Act and Assert
    assertEquals("Value", lazyEntity.getVertex());
  }

  /**
   * Test {@link LazyEntity#putProperty(String, Object)}.
   *
   * <p>Method under test: {@link LazyEntity#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object)")
  @Tag("MaintainedByDiffblue")
  void testPutProperty() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act
    lazyEntity.putProperty("Name", "Value");

    // Assert
    Properties properties = lazyEntity.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
    LazyProperties properties2 = lazyEntity.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get((Object) "Name"));
  }

  /**
   * Test {@link LazyEntity#putProperty(String, Object)}.
   *
   * <p>Method under test: {@link LazyEntity#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object)")
  @Tag("MaintainedByDiffblue")
  void testPutProperty2() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act
    lazyEntity.putProperty(null, null);

    // Assert that nothing has changed
    assertTrue(lazyEntity.getElement().getProperties().isEmpty());
    assertTrue(lazyEntity.getProperties().isEmpty());
  }

  /**
   * Test {@link LazyEntity#putProperty(String, Object)}.
   *
   * <p>Method under test: {@link LazyEntity#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object)")
  @Tag("MaintainedByDiffblue")
  void testPutProperty3() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act
    lazyEntity.putProperty("Name", null);

    // Assert that nothing has changed
    assertTrue(lazyEntity.getElement().getProperties().isEmpty());
    assertTrue(lazyEntity.getProperties().isEmpty());
  }

  /**
   * Test {@link LazyEntity#getGroup()}.
   *
   * <p>Method under test: {@link LazyEntity#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup()")
  @Tag("MaintainedByDiffblue")
  void testGetGroup() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act and Assert
    assertEquals("Group", lazyEntity.getGroup());
  }

  /**
   * Test {@link LazyEntity#getElement()}.
   *
   * <p>Method under test: {@link LazyEntity#getElement()}
   */
  @Test
  @DisplayName("Test getElement()")
  @Tag("MaintainedByDiffblue")
  void testGetElement() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act
    Entity actualElement = lazyEntity.getElement();

    // Assert
    assertEquals("Group", actualElement.getGroup());
    assertEquals("Vertex", actualElement.getVertex());
    assertEquals("uk.gov.gchq.gaffer.data.element.Entity", actualElement.getClassName());
    assertTrue(actualElement.getProperties().isEmpty());
  }

  /**
   * Test {@link LazyEntity#getProperties()}.
   *
   * <p>Method under test: {@link LazyEntity#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("MaintainedByDiffblue")
  void testGetProperties() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act and Assert
    assertTrue(lazyEntity.getProperties().isEmpty());
  }

  /**
   * Test {@link LazyEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Entity entity2 = new Builder().group("Group").vertex("Vertex").build();

    // Act and Assert
    assertNotEquals(lazyEntity, new LazyEntity(entity2, valueLoader));
  }

  /**
   * Test {@link LazyEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Entity entity2 = new Builder().group("Group").vertex("Vertex").build();

    LazyEntity lazyEntity2 = new LazyEntity(entity2, valueLoader);
    lazyEntity2.putIdentifier(IdentifierType.VERTEX, "Value");

    // Act and Assert
    assertNotEquals(lazyEntity, lazyEntity2);
  }

  /**
   * Test {@link LazyEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder groupResult = new Builder().group("Group");
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));
    Entity entity2 = groupResult.vertex(lazyEntity).build();
    LazyEntity lazyEntity2 = new LazyEntity(entity2, mock(ElementValueLoader.class));

    // Act and Assert
    assertNotEquals(lazyEntity2, new Builder().group("Group").vertex("Vertex").build());
  }

  /**
   * Test {@link LazyEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act and Assert
    assertEquals(lazyEntity, new Builder().group("Group").vertex("Vertex").build());
  }

  /**
   * Test {@link LazyEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    // Act and Assert
    assertNotEquals(new LazyEntity(entity, mock(ElementValueLoader.class)), null);
  }

  /**
   * Test {@link LazyEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is same; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsSame_thenReturnNotEqual() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    // Act and Assert
    assertNotEquals(
        new LazyEntity(entity, mock(ElementValueLoader.class)),
        new LazyEntity(entity, mock(ElementValueLoader.class)));
  }

  /**
   * Test {@link LazyEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LazyEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();

    // Act and Assert
    assertNotEquals(
        new LazyEntity(entity, mock(ElementValueLoader.class)), "Different type to LazyEntity");
  }

  /**
   * Test {@link LazyEntity#putIdentifier(IdentifierType, Object)}.
   *
   * <p>Method under test: {@link LazyEntity#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object)")
  @Tag("MaintainedByDiffblue")
  void testPutIdentifier() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act
    lazyEntity.putIdentifier(IdentifierType.VERTEX, "Value");

    // Assert
    assertEquals("Value", lazyEntity.getElement().getVertex());
    assertEquals("Value", lazyEntity.getVertex());
  }

  /**
   * Test {@link LazyEntity#putIdentifier(IdentifierType, Object)}.
   *
   * <p>Method under test: {@link LazyEntity#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object)")
  @Tag("MaintainedByDiffblue")
  void testPutIdentifier2() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act
    lazyEntity.putIdentifier(IdentifierType.GROUP, "42");

    // Assert
    Entity element = lazyEntity.getElement();
    assertEquals("42", element.getGroup());
    assertEquals("42", lazyEntity.getGroup());
    assertEquals("Vertex", element.getVertex());
    assertEquals("Vertex", lazyEntity.getVertex());
  }

  /**
   * Test {@link LazyEntity#putIdentifier(IdentifierType, Object)}.
   *
   * <p>Method under test: {@link LazyEntity#putIdentifier(IdentifierType, Object)}
   */
  @Test
  @DisplayName("Test putIdentifier(IdentifierType, Object)")
  @Tag("MaintainedByDiffblue")
  void testPutIdentifier3() {
    // Arrange
    Entity entity = new Builder().group("Group").vertex("Vertex").build();
    LazyEntity lazyEntity = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act
    lazyEntity.putIdentifier(IdentifierType.SOURCE, "Value");

    // Assert that nothing has changed
    Entity element = lazyEntity.getElement();
    assertEquals("Group", element.getGroup());
    assertEquals("Group", lazyEntity.getGroup());
    assertEquals("Vertex", element.getVertex());
    assertEquals("Vertex", lazyEntity.getVertex());
  }
}
