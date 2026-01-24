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

package uk.gov.gchq.gaffer.operation.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator.Builder;

class AggregatePairDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AggregatePair#AggregatePair()}
   *   <li>{@link AggregatePair#setElementAggregator(ElementAggregator)}
   *   <li>{@link AggregatePair#setGroupBy(String[])}
   *   <li>{@link AggregatePair#getElementAggregator()}
   *   <li>{@link AggregatePair#getGroupBy()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AggregatePair.<init>()",
    "void AggregatePair.<init>(ElementAggregator)",
    "void AggregatePair.<init>(String[])",
    "void AggregatePair.<init>(String[], ElementAggregator)",
    "ElementAggregator AggregatePair.getElementAggregator()",
    "String[] AggregatePair.getGroupBy()",
    "void AggregatePair.setElementAggregator(ElementAggregator)",
    "void AggregatePair.setGroupBy(String[])"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AggregatePair actualAggregatePair = new AggregatePair();
    ElementAggregator elementAggregator = new Builder().build();
    actualAggregatePair.setElementAggregator(elementAggregator);
    String[] groupBy = new String[] {"Group By"};
    actualAggregatePair.setGroupBy(groupBy);
    ElementAggregator actualElementAggregator = actualAggregatePair.getElementAggregator();
    String[] actualGroupBy = actualAggregatePair.getGroupBy();

    // Assert
    assertTrue(actualElementAggregator.getComponents().isEmpty());
    assertSame(elementAggregator, actualElementAggregator);
    assertSame(groupBy, actualGroupBy);
    assertArrayEquals(new String[] {"Group By"}, actualGroupBy);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code Group By}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AggregatePair#AggregatePair(String[], ElementAggregator)}
   *   <li>{@link AggregatePair#setElementAggregator(ElementAggregator)}
   *   <li>{@link AggregatePair#setGroupBy(String[])}
   *   <li>{@link AggregatePair#getElementAggregator()}
   *   <li>{@link AggregatePair#getGroupBy()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when array of String with 'Group By'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AggregatePair.<init>()",
    "void AggregatePair.<init>(ElementAggregator)",
    "void AggregatePair.<init>(String[])",
    "void AggregatePair.<init>(String[], ElementAggregator)",
    "ElementAggregator AggregatePair.getElementAggregator()",
    "String[] AggregatePair.getGroupBy()",
    "void AggregatePair.setElementAggregator(ElementAggregator)",
    "void AggregatePair.setGroupBy(String[])"
  })
  void testGettersAndSetters_whenArrayOfStringWithGroupBy() {
    // Arrange
    String[] groupBy = new String[] {"Group By"};
    ElementAggregator aggregator = new Builder().build();

    // Act
    AggregatePair actualAggregatePair = new AggregatePair(groupBy, aggregator);
    ElementAggregator elementAggregator = new Builder().build();
    actualAggregatePair.setElementAggregator(elementAggregator);
    String[] groupBy2 = new String[] {"Group By"};
    actualAggregatePair.setGroupBy(groupBy2);
    ElementAggregator actualElementAggregator = actualAggregatePair.getElementAggregator();
    String[] actualGroupBy = actualAggregatePair.getGroupBy();

    // Assert
    assertTrue(actualElementAggregator.getComponents().isEmpty());
    assertSame(elementAggregator, actualElementAggregator);
    assertSame(groupBy2, actualGroupBy);
    assertArrayEquals(new String[] {"Group By"}, actualGroupBy);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Builder#Builder()} build.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AggregatePair#AggregatePair(ElementAggregator)}
   *   <li>{@link AggregatePair#setElementAggregator(ElementAggregator)}
   *   <li>{@link AggregatePair#setGroupBy(String[])}
   *   <li>{@link AggregatePair#getElementAggregator()}
   *   <li>{@link AggregatePair#getGroupBy()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Builder() build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AggregatePair.<init>()",
    "void AggregatePair.<init>(ElementAggregator)",
    "void AggregatePair.<init>(String[])",
    "void AggregatePair.<init>(String[], ElementAggregator)",
    "ElementAggregator AggregatePair.getElementAggregator()",
    "String[] AggregatePair.getGroupBy()",
    "void AggregatePair.setElementAggregator(ElementAggregator)",
    "void AggregatePair.setGroupBy(String[])"
  })
  void testGettersAndSetters_whenBuilderBuild() {
    // Arrange
    ElementAggregator aggregator = new Builder().build();

    // Act
    AggregatePair actualAggregatePair = new AggregatePair(aggregator);
    ElementAggregator elementAggregator = new Builder().build();
    actualAggregatePair.setElementAggregator(elementAggregator);
    String[] groupBy = new String[] {"Group By"};
    actualAggregatePair.setGroupBy(groupBy);
    ElementAggregator actualElementAggregator = actualAggregatePair.getElementAggregator();
    String[] actualGroupBy = actualAggregatePair.getGroupBy();

    // Assert
    assertTrue(actualElementAggregator.getComponents().isEmpty());
    assertSame(elementAggregator, actualElementAggregator);
    assertSame(groupBy, actualGroupBy);
    assertArrayEquals(new String[] {"Group By"}, actualGroupBy);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Group By}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AggregatePair#AggregatePair(String[])}
   *   <li>{@link AggregatePair#setElementAggregator(ElementAggregator)}
   *   <li>{@link AggregatePair#setGroupBy(String[])}
   *   <li>{@link AggregatePair#getElementAggregator()}
   *   <li>{@link AggregatePair#getGroupBy()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Group By'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AggregatePair.<init>()",
    "void AggregatePair.<init>(ElementAggregator)",
    "void AggregatePair.<init>(String[])",
    "void AggregatePair.<init>(String[], ElementAggregator)",
    "ElementAggregator AggregatePair.getElementAggregator()",
    "String[] AggregatePair.getGroupBy()",
    "void AggregatePair.setElementAggregator(ElementAggregator)",
    "void AggregatePair.setGroupBy(String[])"
  })
  void testGettersAndSetters_whenGroupBy() {
    // Arrange and Act
    AggregatePair actualAggregatePair = new AggregatePair("Group By");
    ElementAggregator elementAggregator = new Builder().build();
    actualAggregatePair.setElementAggregator(elementAggregator);
    String[] groupBy = new String[] {"Group By"};
    actualAggregatePair.setGroupBy(groupBy);
    ElementAggregator actualElementAggregator = actualAggregatePair.getElementAggregator();
    String[] actualGroupBy = actualAggregatePair.getGroupBy();

    // Assert
    assertTrue(actualElementAggregator.getComponents().isEmpty());
    assertSame(elementAggregator, actualElementAggregator);
    assertSame(groupBy, actualGroupBy);
    assertArrayEquals(new String[] {"Group By"}, actualGroupBy);
  }
}
