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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.accumulo.core.client.IteratorSetting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.graph.GraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements;

class ByteEntityIteratorSettingsFactoryDiffblueTest {
  /**
   * Test {@link
   * ByteEntityIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}.
   *
   * <p>Method under test: {@link
   * ByteEntityIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}
   */
  @Test
  @DisplayName("Test getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ByteEntityIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)"
  })
  void testGetEdgeEntityDirectionFilterIteratorSetting() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    // Act and Assert
    assertNull(
        byteEntityIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(
            new GetElementsBetweenSets()));
  }

  /**
   * Test {@link
   * ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}.
   *
   * <p>Method under test: {@link
   * ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}
   */
  @Test
  @DisplayName("Test getElementPropertyRangeQueryFilter(GraphFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ByteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(GraphFilters)"
  })
  void testGetElementPropertyRangeQueryFilter() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.INCOMING);
    operation.setView(new View());

    // Act
    IteratorSetting actualElementPropertyRangeQueryFilter =
        byteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(operation);

    // Assert
    assertEquals("Range_Element_Property_Filter", actualElementPropertyRangeQueryFilter.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityRangeElementPropertyFilt"
            + "erIterator",
        actualElementPropertyRangeQueryFilter.getIteratorClass());
    Map<String, String> options = actualElementPropertyRangeQueryFilter.getOptions();
    assertEquals(2, options.size());
    assertEquals(Boolean.TRUE.toString(), options.get("Incoming_Edges_Only"));
    assertEquals(Boolean.TRUE.toString(), options.get("all"));
    assertEquals(Integer.SIZE, actualElementPropertyRangeQueryFilter.getPriority());
  }

  /**
   * Test {@link
   * ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}.
   *
   * <p>Method under test: {@link
   * ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}
   */
  @Test
  @DisplayName("Test getElementPropertyRangeQueryFilter(GraphFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ByteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(GraphFilters)"
  })
  void testGetElementPropertyRangeQueryFilter2() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setDirectedType(DirectedType.DIRECTED);
    operation.setView(new View());

    // Act
    IteratorSetting actualElementPropertyRangeQueryFilter =
        byteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(operation);

    // Assert
    assertEquals("Range_Element_Property_Filter", actualElementPropertyRangeQueryFilter.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityRangeElementPropertyFilt"
            + "erIterator",
        actualElementPropertyRangeQueryFilter.getIteratorClass());
    Map<String, String> options = actualElementPropertyRangeQueryFilter.getOptions();
    assertEquals(2, options.size());
    assertEquals(Boolean.TRUE.toString(), options.get("Directed_Edges_Only"));
    assertEquals(Boolean.TRUE.toString(), options.get("all"));
    assertEquals(Integer.SIZE, actualElementPropertyRangeQueryFilter.getPriority());
  }

  /**
   * Test {@link
   * ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}.
   *
   * <p>Method under test: {@link
   * ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}
   */
  @Test
  @DisplayName("Test getElementPropertyRangeQueryFilter(GraphFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ByteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(GraphFilters)"
  })
  void testGetElementPropertyRangeQueryFilter3() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setDirectedType(DirectedType.UNDIRECTED);
    operation.setView(new View());

    // Act
    IteratorSetting actualElementPropertyRangeQueryFilter =
        byteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(operation);

    // Assert
    assertEquals("Range_Element_Property_Filter", actualElementPropertyRangeQueryFilter.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityRangeElementPropertyFilt"
            + "erIterator",
        actualElementPropertyRangeQueryFilter.getIteratorClass());
    Map<String, String> options = actualElementPropertyRangeQueryFilter.getOptions();
    assertEquals(2, options.size());
    assertEquals(Boolean.TRUE.toString(), options.get("Undirected_Edges_Only"));
    assertEquals(Boolean.TRUE.toString(), options.get("all"));
    assertEquals(Integer.SIZE, actualElementPropertyRangeQueryFilter.getPriority());
  }

  /**
   * Test {@link
   * ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}.
   *
   * <ul>
   *   <li>Given {@code OUTGOING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}
   */
  @Test
  @DisplayName("Test getElementPropertyRangeQueryFilter(GraphFilters); given 'OUTGOING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ByteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(GraphFilters)"
  })
  void testGetElementPropertyRangeQueryFilter_givenOutgoing() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.OUTGOING);
    operation.setView(new View());

    // Act
    IteratorSetting actualElementPropertyRangeQueryFilter =
        byteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(operation);

    // Assert
    assertEquals("Range_Element_Property_Filter", actualElementPropertyRangeQueryFilter.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityRangeElementPropertyFilt"
            + "erIterator",
        actualElementPropertyRangeQueryFilter.getIteratorClass());
    Map<String, String> options = actualElementPropertyRangeQueryFilter.getOptions();
    assertEquals(2, options.size());
    assertEquals(Boolean.TRUE.toString(), options.get("Outgoing_Edges_Only"));
    assertEquals(Boolean.TRUE.toString(), options.get("all"));
    assertEquals(Integer.SIZE, actualElementPropertyRangeQueryFilter.getPriority());
  }

  /**
   * Test {@link
   * ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}.
   *
   * <ul>
   *   <li>Then return Options size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}
   */
  @Test
  @DisplayName(
      "Test getElementPropertyRangeQueryFilter(GraphFilters); then return Options size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ByteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(GraphFilters)"
  })
  void testGetElementPropertyRangeQueryFilter_thenReturnOptionsSizeIsOne() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setView(new View());

    // Act
    IteratorSetting actualElementPropertyRangeQueryFilter =
        byteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(operation);

    // Assert
    assertEquals("Range_Element_Property_Filter", actualElementPropertyRangeQueryFilter.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityRangeElementPropertyFilt"
            + "erIterator",
        actualElementPropertyRangeQueryFilter.getIteratorClass());
    Map<String, String> options = actualElementPropertyRangeQueryFilter.getOptions();
    assertEquals(1, options.size());
    assertEquals(Boolean.TRUE.toString(), options.get("all"));
    assertEquals(Integer.SIZE, actualElementPropertyRangeQueryFilter.getPriority());
  }

  /**
   * Test {@link
   * ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}.
   *
   * <ul>
   *   <li>Then return Options size is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * ByteEntityIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}
   */
  @Test
  @DisplayName(
      "Test getElementPropertyRangeQueryFilter(GraphFilters); then return Options size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ByteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(GraphFilters)"
  })
  void testGetElementPropertyRangeQueryFilter_thenReturnOptionsSizeIsThree() {
    // Arrange
    ByteEntityIteratorSettingsFactory byteEntityIteratorSettingsFactory =
        new ByteEntityIteratorSettingsFactory();

    GetAllElements operation = new GetAllElements();
    operation.setView(new View());

    // Act
    IteratorSetting actualElementPropertyRangeQueryFilter =
        byteEntityIteratorSettingsFactory.getElementPropertyRangeQueryFilter(operation);

    // Assert
    assertEquals("Range_Element_Property_Filter", actualElementPropertyRangeQueryFilter.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityRangeElementPropertyFilt"
            + "erIterator",
        actualElementPropertyRangeQueryFilter.getIteratorClass());
    Map<String, String> options = actualElementPropertyRangeQueryFilter.getOptions();
    assertEquals(3, options.size());
    assertEquals(Boolean.TRUE.toString(), options.get("Deduplicate_Undirected_Edges"));
    assertEquals(Boolean.TRUE.toString(), options.get("Outgoing_Edges_Only"));
    assertEquals(Boolean.TRUE.toString(), options.get("all"));
    assertEquals(Integer.SIZE, actualElementPropertyRangeQueryFilter.getPriority());
  }
}
