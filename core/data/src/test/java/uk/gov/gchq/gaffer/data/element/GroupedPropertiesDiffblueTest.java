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
import static org.mockito.Mockito.mock;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class GroupedPropertiesDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GroupedProperties#equals(Object)}
   *   <li>{@link GroupedProperties#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GroupedProperties groupedProperties = new GroupedProperties();
    GroupedProperties groupedProperties2 = new GroupedProperties();

    // Act and Assert
    assertEquals(groupedProperties, groupedProperties2);
    int expectedHashCodeResult = groupedProperties.hashCode();
    assertEquals(expectedHashCodeResult, groupedProperties2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GroupedProperties#equals(Object)}
   *   <li>{@link GroupedProperties#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    GroupedProperties groupedProperties = new GroupedProperties();
    groupedProperties.computeIfPresent("foo", mock(BiFunction.class));
    GroupedProperties groupedProperties2 = new GroupedProperties();

    // Act and Assert
    assertEquals(groupedProperties, groupedProperties2);
    int expectedHashCodeResult = groupedProperties.hashCode();
    assertEquals(expectedHashCodeResult, groupedProperties2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GroupedProperties#equals(Object)}
   *   <li>{@link GroupedProperties#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GroupedProperties groupedProperties = new GroupedProperties();

    // Act and Assert
    assertEquals(groupedProperties, groupedProperties);
    int expectedHashCodeResult = groupedProperties.hashCode();
    assertEquals(expectedHashCodeResult, groupedProperties.hashCode());
  }

  /**
   * Method under test: {@link GroupedProperties#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GroupedProperties groupedProperties = new GroupedProperties();
    groupedProperties.setGroup("Group");

    // Act and Assert
    assertNotEquals(groupedProperties, new GroupedProperties());
  }

  /**
   * Method under test: {@link GroupedProperties#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GroupedProperties(), null);
  }

  /**
   * Method under test: {@link GroupedProperties#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GroupedProperties(), "Different type to GroupedProperties");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GroupedProperties#GroupedProperties()}
   *   <li>{@link GroupedProperties#setGroup(String)}
   *   <li>{@link GroupedProperties#getGroup()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GroupedProperties actualGroupedProperties = new GroupedProperties();
    actualGroupedProperties.setGroup("Group");

    // Assert that nothing has changed
    assertEquals("Group", actualGroupedProperties.getGroup());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GroupedProperties#GroupedProperties(String)}
   *   <li>{@link GroupedProperties#setGroup(String)}
   *   <li>{@link GroupedProperties#getGroup()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    GroupedProperties actualGroupedProperties = new GroupedProperties("Group");
    actualGroupedProperties.setGroup("Group");

    // Assert that nothing has changed
    assertEquals("Group", actualGroupedProperties.getGroup());
  }
}
