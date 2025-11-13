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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GroupCountsDiffblueTest {
  /**
   * Test {@link GroupCounts#addEntityGroup(String)}.
   * <ul>
   *   <li>Then {@link GroupCounts} (default constructor) EntityGroups {@code Group} intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupCounts#addEntityGroup(String)}
   */
  @Test
  @DisplayName("Test addEntityGroup(String); then GroupCounts (default constructor) EntityGroups 'Group' intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GroupCounts.addEntityGroup(String)"})
  void testAddEntityGroup_thenGroupCountsEntityGroupsGroupIntValueIsOne() {
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
   * Test {@link GroupCounts#addEntityGroup(String)}.
   * <ul>
   *   <li>Then {@link GroupCounts} (default constructor) EntityGroups {@code Group} intValue is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupCounts#addEntityGroup(String)}
   */
  @Test
  @DisplayName("Test addEntityGroup(String); then GroupCounts (default constructor) EntityGroups 'Group' intValue is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GroupCounts.addEntityGroup(String)"})
  void testAddEntityGroup_thenGroupCountsEntityGroupsGroupIntValueIsTwo() {
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
   * Test {@link GroupCounts#addEdgeGroup(String)}.
   * <ul>
   *   <li>Given {@link GroupCounts} (default constructor).</li>
   *   <li>Then {@link GroupCounts} (default constructor) EdgeGroups {@code Group} intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupCounts#addEdgeGroup(String)}
   */
  @Test
  @DisplayName("Test addEdgeGroup(String); given GroupCounts (default constructor); then GroupCounts (default constructor) EdgeGroups 'Group' intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GroupCounts.addEdgeGroup(String)"})
  void testAddEdgeGroup_givenGroupCounts_thenGroupCountsEdgeGroupsGroupIntValueIsOne() {
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
   * Test {@link GroupCounts#addEdgeGroup(String)}.
   * <ul>
   *   <li>Then {@link GroupCounts} (default constructor) EdgeGroups {@code Group} intValue is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GroupCounts#addEdgeGroup(String)}
   */
  @Test
  @DisplayName("Test addEdgeGroup(String); then GroupCounts (default constructor) EdgeGroups 'Group' intValue is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GroupCounts.addEdgeGroup(String)"})
  void testAddEdgeGroup_thenGroupCountsEdgeGroupsGroupIntValueIsTwo() {
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GroupCounts}
   *   <li>{@link GroupCounts#setEdgeGroups(Map)}
   *   <li>{@link GroupCounts#setEntityGroups(Map)}
   *   <li>{@link GroupCounts#setLimitHit(boolean)}
   *   <li>{@link GroupCounts#toString()}
   *   <li>{@link GroupCounts#getEdgeGroups()}
   *   <li>{@link GroupCounts#getEntityGroups()}
   *   <li>{@link GroupCounts#isLimitHit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GroupCounts.<init>()", "Map GroupCounts.getEdgeGroups()",
      "Map GroupCounts.getEntityGroups()", "boolean GroupCounts.isLimitHit()", "void GroupCounts.setEdgeGroups(Map)",
      "void GroupCounts.setEntityGroups(Map)", "void GroupCounts.setLimitHit(boolean)",
      "String GroupCounts.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    GroupCounts actualGroupCounts = new GroupCounts();
    HashMap<String, Integer> edgeGroups = new HashMap<>();
    actualGroupCounts.setEdgeGroups(edgeGroups);
    HashMap<String, Integer> entityGroups = new HashMap<>();
    actualGroupCounts.setEntityGroups(entityGroups);
    actualGroupCounts.setLimitHit(true);
    String actualToStringResult = actualGroupCounts.toString();
    Map<String, Integer> actualEdgeGroups = actualGroupCounts.getEdgeGroups();
    Map<String, Integer> actualEntityGroups = actualGroupCounts.getEntityGroups();
    boolean actualIsLimitHitResult = actualGroupCounts.isLimitHit();

    // Assert
    assertEquals("GroupCounts[entityGroups={},edgeGroups={},limitHit=true]", actualToStringResult);
    assertTrue(actualEdgeGroups.isEmpty());
    assertTrue(actualEntityGroups.isEmpty());
    assertTrue(actualIsLimitHitResult);
    assertSame(edgeGroups, actualEdgeGroups);
    assertSame(entityGroups, actualEntityGroups);
  }
}
