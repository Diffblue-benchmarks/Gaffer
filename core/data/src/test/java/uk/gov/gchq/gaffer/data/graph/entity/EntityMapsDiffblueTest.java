/*
 * Copyright 2026 Crown Copyright
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityMapsDiffblueTest {
  /**
   * Test {@link EntityMaps#add(EntityMap)}.
   *
   * <p>Method under test: {@link EntityMaps#add(EntityMap)}
   */
  @Test
  @DisplayName("Test add(EntityMap)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityMaps.add(EntityMap)"})
  void testAdd() {
    // Arrange
    SimpleEntityMaps simpleEntityMaps = new SimpleEntityMaps();

    // Act
    simpleEntityMaps.add(new EntityMap());

    // Assert
    assertEquals(1, simpleEntityMaps.size());
  }

  /**
   * Test {@link EntityMaps#get(int)}.
   *
   * <ul>
   *   <li>Given {@link SimpleEntityMaps} (default constructor) add {@link EntityMap} (default
   *       constructor).
   *   <li>Then return Vertices Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityMaps#get(int)}
   */
  @Test
  @DisplayName(
      "Test get(int); given SimpleEntityMaps (default constructor) add EntityMap (default constructor); then return Vertices Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityMap EntityMaps.get(int)"})
  void testGet_givenSimpleEntityMapsAddEntityMap_thenReturnVerticesEmpty() {
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
   * Test {@link EntityMaps#size()}.
   *
   * <p>Method under test: {@link EntityMaps#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EntityMaps.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new SimpleEntityMaps().size());
  }

  /**
   * Test {@link EntityMaps#empty()}.
   *
   * <ul>
   *   <li>Given {@link SimpleEntityMaps} (default constructor) add {@link EntityMap} (default
   *       constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMaps#empty()}
   */
  @Test
  @DisplayName(
      "Test empty(); given SimpleEntityMaps (default constructor) add EntityMap (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMaps.empty()"})
  void testEmpty_givenSimpleEntityMapsAddEntityMap_thenReturnFalse() {
    // Arrange
    SimpleEntityMaps simpleEntityMaps = new SimpleEntityMaps();
    simpleEntityMaps.add(new EntityMap());

    // Act and Assert
    assertFalse(simpleEntityMaps.empty());
  }

  /**
   * Test {@link EntityMaps#empty()}.
   *
   * <ul>
   *   <li>Given {@link SimpleEntityMaps} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityMaps#empty()}
   */
  @Test
  @DisplayName("Test empty(); given SimpleEntityMaps (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityMaps.empty()"})
  void testEmpty_givenSimpleEntityMaps_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new SimpleEntityMaps().empty());
  }

  /**
   * Test {@link EntityMaps#iterator()}.
   *
   * <p>Method under test: {@link EntityMaps#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Iterator EntityMaps.iterator()"})
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse(new SimpleEntityMaps().iterator().hasNext());
  }
}
