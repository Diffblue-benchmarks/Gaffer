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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LazyEntityDiffblueTest {
  /**
   * Method under test: {@link LazyEntity#getVertex()}
   */
  @Test
  void testGetVertex() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualVertex = (new LazyEntity(new Entity(), valueLoader)).getVertex();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertNull(actualVertex);
  }

  /**
   * Method under test: {@link LazyEntity#getVertex()}
   */
  @Test
  void testGetVertex2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyEntity entity = new LazyEntity(new Entity(), valueLoader);

    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualVertex = (new LazyEntity(entity, valueLoader2)).getVertex();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
    assertNull(actualVertex);
  }

  /**
   * Method under test: {@link LazyEntity#getVertex()}
   */
  @Test
  void testGetVertex3() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    LazyEntity entity = new LazyEntity(new Entity(), valueLoader);
    entity.putIdentifier(IdentifierType.SOURCE, "Value");
    ElementValueLoader valueLoader2 = mock(ElementValueLoader.class);
    doNothing().when(valueLoader2).loadIdentifiers(Mockito.<Element>any());

    // Act
    Object actualVertex = (new LazyEntity(entity, valueLoader2)).getVertex();

    // Assert
    verify(valueLoader2).loadIdentifiers(isA(Element.class));
    assertNull(actualVertex);
  }

  /**
   * Method under test: {@link LazyEntity#getGroup()}
   */
  @Test
  void testGetGroup() {
    // Arrange, Act and Assert
    assertEquals(Element.DEFAULT_GROUP, (new LazyEntity(new Entity(), mock(ElementValueLoader.class))).getGroup());
    assertEquals(Element.DEFAULT_GROUP,
        (new LazyEntity(new LazyEntity(new Entity(), mock(ElementValueLoader.class)), mock(ElementValueLoader.class)))
            .getGroup());
  }

  /**
   * Method under test: {@link LazyEntity#getElement()}
   */
  @Test
  void testGetElement() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertSame(entity, (new LazyEntity(entity, mock(ElementValueLoader.class))).getElement());
  }

  /**
   * Method under test: {@link LazyEntity#getProperties()}
   */
  @Test
  void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue((new LazyEntity(new Entity(), mock(ElementValueLoader.class))).getProperties().isEmpty());
  }

  /**
   * Method under test: {@link LazyEntity#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LazyEntity lazyEntity = new LazyEntity(new Entity(), mock(ElementValueLoader.class));
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act and Assert
    assertNotEquals(lazyEntity, new LazyEntity(new Entity(), valueLoader));
  }

  /**
   * Method under test: {@link LazyEntity#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LazyEntity lazyEntity = new LazyEntity(new LazyEntity(new Entity(), mock(ElementValueLoader.class)),
        mock(ElementValueLoader.class));
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());

    // Act and Assert
    assertNotEquals(lazyEntity, new LazyEntity(new Entity(), valueLoader));
  }

  /**
   * Method under test: {@link LazyEntity#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LazyEntity(new Entity(), mock(ElementValueLoader.class)), null);
  }

  /**
   * Method under test: {@link LazyEntity#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsSame_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LazyEntity(new Entity(), mock(ElementValueLoader.class)),
        new LazyEntity(new Entity(), mock(ElementValueLoader.class)));
  }

  /**
   * Method under test: {@link LazyEntity#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LazyEntity(new Entity(), mock(ElementValueLoader.class)), "Different type to LazyEntity");
  }

  /**
   * Method under test:
   * {@link LazyEntity#LazyEntity(Entity, ElementValueLoader, LazyProperties)}
   */
  @Test
  void testNewLazyEntity() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getGroup()).thenReturn("Group");
    when(entity.getProperties()).thenReturn(new Properties());
    LazyEntity entity2 = new LazyEntity(entity, mock(ElementValueLoader.class));

    // Act
    LazyEntity actualLazyEntity = new LazyEntity(entity2, mock(ElementValueLoader.class), null);

    // Assert
    verify(entity, atLeast(1)).getGroup();
    verify(entity).getProperties();
    assertEquals("Group", actualLazyEntity.getGroup());
    assertEquals("uk.gov.gchq.gaffer.data.element.LazyEntity", actualLazyEntity.getClassName());
    assertNull(actualLazyEntity.getVertex());
    assertNull(actualLazyEntity.getProperties());
    assertSame(entity2, actualLazyEntity.getElement());
  }
}
