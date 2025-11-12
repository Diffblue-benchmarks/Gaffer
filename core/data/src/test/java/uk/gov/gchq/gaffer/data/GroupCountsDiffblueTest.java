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

package uk.gov.gchq.gaffer.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class GroupCountsDiffblueTest {
  /**
   * Method under test: {@link GroupCounts#addEntityGroup(String)}
   */
  @Test
  void testAddEntityGroup() {
    // Arrange
    GroupCounts groupCounts = new GroupCounts();

    // Act
    groupCounts.addEntityGroup("Group");

    // Assert
    Map<String, Integer> entityGroups = groupCounts.getEntityGroups();
    assertEquals(1, entityGroups.size());
    assertEquals(1, entityGroups.get("Group").intValue());
  }

  /**
   * Method under test: {@link GroupCounts#addEntityGroup(String)}
   */
  @Test
  void testAddEntityGroup2() {
    // Arrange
    GroupCounts groupCounts = new GroupCounts();
    groupCounts.addEntityGroup("Group");

    // Act
    groupCounts.addEntityGroup("Group");

    // Assert
    Map<String, Integer> entityGroups = groupCounts.getEntityGroups();
    assertEquals(1, entityGroups.size());
    assertEquals(2, entityGroups.get("Group").intValue());
  }

  /**
   * Method under test: {@link GroupCounts#addEntityGroup(String)}
   */
  @Test
  void testAddEntityGroup3() {
    // Arrange
    HashMap<String, Integer> entityGroups = new HashMap<>();
    entityGroups.computeIfPresent("foo", mock(BiFunction.class));

    GroupCounts groupCounts = new GroupCounts();
    groupCounts.setEntityGroups(entityGroups);
    groupCounts.addEntityGroup("Group");

    // Act
    groupCounts.addEntityGroup("Group");

    // Assert
    Map<String, Integer> entityGroups2 = groupCounts.getEntityGroups();
    assertEquals(1, entityGroups2.size());
    assertEquals(2, entityGroups2.get("Group").intValue());
    assertSame(entityGroups, entityGroups2);
  }

  /**
   * Method under test: {@link GroupCounts#addEdgeGroup(String)}
   */
  @Test
  void testAddEdgeGroup() {
    // Arrange
    GroupCounts groupCounts = new GroupCounts();

    // Act
    groupCounts.addEdgeGroup("Group");

    // Assert
    Map<String, Integer> edgeGroups = groupCounts.getEdgeGroups();
    assertEquals(1, edgeGroups.size());
    assertEquals(1, edgeGroups.get("Group").intValue());
  }

  /**
   * Method under test: {@link GroupCounts#addEdgeGroup(String)}
   */
  @Test
  void testAddEdgeGroup2() {
    // Arrange
    GroupCounts groupCounts = new GroupCounts();
    groupCounts.addEdgeGroup("Group");

    // Act
    groupCounts.addEdgeGroup("Group");

    // Assert
    Map<String, Integer> edgeGroups = groupCounts.getEdgeGroups();
    assertEquals(1, edgeGroups.size());
    assertEquals(2, edgeGroups.get("Group").intValue());
  }

  /**
   * Method under test: {@link GroupCounts#addEdgeGroup(String)}
   */
  @Test
  void testAddEdgeGroup3() {
    // Arrange
    HashMap<String, Integer> entityGroups = new HashMap<>();
    entityGroups.computeIfPresent("foo", mock(BiFunction.class));

    GroupCounts groupCounts = new GroupCounts();
    groupCounts.setEntityGroups(entityGroups);
    groupCounts.addEdgeGroup("Group");

    // Act
    groupCounts.addEdgeGroup("Group");

    // Assert
    Map<String, Integer> edgeGroups = groupCounts.getEdgeGroups();
    assertEquals(1, edgeGroups.size());
    assertEquals(2, edgeGroups.get("Group").intValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GroupCounts}
   *   <li>{@link GroupCounts#setEdgeGroups(Map)}
   *   <li>{@link GroupCounts#setEntityGroups(Map)}
   *   <li>{@link GroupCounts#setLimitHit(boolean)}
   *   <li>{@link GroupCounts#getEdgeGroups()}
   *   <li>{@link GroupCounts#getEntityGroups()}
   *   <li>{@link GroupCounts#isLimitHit()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GroupCounts actualGroupCounts = new GroupCounts();
    HashMap<String, Integer> edgeGroups = new HashMap<>();
    actualGroupCounts.setEdgeGroups(edgeGroups);
    HashMap<String, Integer> entityGroups = new HashMap<>();
    actualGroupCounts.setEntityGroups(entityGroups);
    actualGroupCounts.setLimitHit(true);
    Map<String, Integer> actualEdgeGroups = actualGroupCounts.getEdgeGroups();
    Map<String, Integer> actualEntityGroups = actualGroupCounts.getEntityGroups();
    boolean actualIsLimitHitResult = actualGroupCounts.isLimitHit();

    // Assert that nothing has changed
    assertTrue(actualEdgeGroups.isEmpty());
    assertTrue(actualEntityGroups.isEmpty());
    assertTrue(actualIsLimitHitResult);
    assertSame(edgeGroups, actualEdgeGroups);
    assertSame(entityGroups, actualEntityGroups);
  }
}
