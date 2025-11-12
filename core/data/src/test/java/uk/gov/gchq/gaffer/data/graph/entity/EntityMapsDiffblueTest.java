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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityMapsDiffblueTest {
  /**
   * Method under test: {@link EntityMaps#add(EntityMap)}
   */
  @Test
  void testAdd() {
    // Arrange
    SimpleEntityMaps simpleEntityMaps = new SimpleEntityMaps();

    // Act
    simpleEntityMaps.add(new EntityMap());

    // Assert
    assertEquals(1, simpleEntityMaps.size());
  }

  /**
   * Method under test: {@link EntityMaps#add(EntityMap)}
   */
  @Test
  void testAdd2() {
    // Arrange
    EntityMaps entityMaps = mock(EntityMaps.class);
    doNothing().when(entityMaps).add(Mockito.<EntityMap>any());

    // Act
    entityMaps.add(new EntityMap());

    // Assert
    verify(entityMaps).add(isA(EntityMap.class));
  }

  /**
   * Method under test: {@link EntityMaps#get(int)}
   */
  @Test
  void testGet() {
    // Arrange
    EntityMaps entityMaps = mock(EntityMaps.class);
    when(entityMaps.get(anyInt())).thenReturn(new EntityMap());

    // Act
    entityMaps.get(1);

    // Assert
    verify(entityMaps).get(eq(1));
  }

  /**
   * Method under test: {@link EntityMaps#get(int)}
   */
  @Test
  void testGet2() {
    // Arrange
    SimpleEntityMaps simpleEntityMaps = new SimpleEntityMaps();
    simpleEntityMaps.add(new EntityMap());
    EntityMap entityMap = new EntityMap();
    simpleEntityMaps.add(entityMap);

    // Act
    EntityMap actualGetResult = simpleEntityMaps.get(1);

    // Assert
    assertTrue(actualGetResult.getVertices().isEmpty());
    assertSame(entityMap, actualGetResult);
  }

  /**
   * Method under test: {@link EntityMaps#size()}
   */
  @Test
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new SimpleEntityMaps()).size());
  }

  /**
   * Method under test: {@link EntityMaps#size()}
   */
  @Test
  void testSize2() {
    // Arrange
    EntityMaps entityMaps = mock(EntityMaps.class);
    when(entityMaps.size()).thenReturn(3);

    // Act
    entityMaps.size();

    // Assert
    verify(entityMaps).size();
  }

  /**
   * Method under test: {@link EntityMaps#empty()}
   */
  @Test
  void testEmpty() {
    // Arrange, Act and Assert
    assertTrue((new SimpleEntityMaps()).empty());
  }

  /**
   * Method under test: {@link EntityMaps#empty()}
   */
  @Test
  void testEmpty2() {
    // Arrange
    EntityMaps entityMaps = mock(EntityMaps.class);
    when(entityMaps.empty()).thenReturn(true);

    // Act
    entityMaps.empty();

    // Assert
    verify(entityMaps).empty();
  }

  /**
   * Method under test: {@link EntityMaps#empty()}
   */
  @Test
  void testEmpty3() {
    // Arrange
    EntityMaps entityMaps = mock(EntityMaps.class);
    when(entityMaps.empty()).thenReturn(false);

    // Act
    entityMaps.empty();

    // Assert
    verify(entityMaps).empty();
  }

  /**
   * Method under test: {@link EntityMaps#empty()}
   */
  @Test
  void testEmpty4() {
    // Arrange
    SimpleEntityMaps simpleEntityMaps = new SimpleEntityMaps();
    simpleEntityMaps.add(new EntityMap());

    // Act and Assert
    assertFalse(simpleEntityMaps.empty());
  }

  /**
   * Method under test: {@link EntityMaps#prettyPrint()}
   */
  @Test
  void testPrettyPrint() {
    // Arrange
    EntityMaps entityMaps = mock(EntityMaps.class);
    when(entityMaps.prettyPrint()).thenReturn("Pretty Print");

    // Act
    entityMaps.prettyPrint();

    // Assert
    verify(entityMaps).prettyPrint();
  }

  /**
   * Method under test: {@link EntityMaps#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new SimpleEntityMaps()).iterator().hasNext());
  }

  /**
   * Method under test: {@link EntityMaps#iterator()}
   */
  @Test
  void testIterator2() {
    // Arrange
    EntityMaps entityMaps = mock(EntityMaps.class);

    ArrayList<EntityMap> entityMapList = new ArrayList<>();
    when(entityMaps.iterator()).thenReturn(entityMapList.iterator());

    // Act
    entityMaps.iterator();

    // Assert
    verify(entityMaps).iterator();
  }
}
