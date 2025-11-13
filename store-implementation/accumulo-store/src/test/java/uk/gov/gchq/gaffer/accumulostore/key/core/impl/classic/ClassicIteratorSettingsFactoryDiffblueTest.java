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

package uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

class ClassicIteratorSettingsFactoryDiffblueTest {
  /**
   * Test {@link
   * ClassicIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}.
   *
   * <p>Method under test: {@link
   * ClassicIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}
   */
  @Test
  @DisplayName("Test getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ClassicIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)"
  })
  void testGetEdgeEntityDirectionFilterIteratorSetting() {
    // Arrange
    ClassicIteratorSettingsFactory classicIteratorSettingsFactory =
        new ClassicIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.OUTGOING);
    operation.setView(new View());

    // Act
    IteratorSetting actualEdgeEntityDirectionFilterIteratorSetting =
        classicIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(operation);

    // Assert
    assertEquals(
        "Edge_Entity_Directed_Undirected_Incoming_Outgoing_Filter",
        actualEdgeEntityDirectionFilterIteratorSetting.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic.ClassicEdgeDirectedUndirectedFilterIterator",
        actualEdgeEntityDirectionFilterIteratorSetting.getIteratorClass());
    Map<String, String> options = actualEdgeEntityDirectionFilterIteratorSetting.getOptions();
    assertEquals(1, options.size());
    assertEquals(33, actualEdgeEntityDirectionFilterIteratorSetting.getPriority());
    assertEquals(Boolean.TRUE.toString(), options.get("Outgoing_Edges_Only"));
  }

  /**
   * Test {@link
   * ClassicIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}.
   *
   * <p>Method under test: {@link
   * ClassicIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}
   */
  @Test
  @DisplayName("Test getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ClassicIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)"
  })
  void testGetEdgeEntityDirectionFilterIteratorSetting2() {
    // Arrange
    ClassicIteratorSettingsFactory classicIteratorSettingsFactory =
        new ClassicIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setDirectedType(DirectedType.DIRECTED);
    operation.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.INCOMING);
    operation.setView(new View());

    // Act
    IteratorSetting actualEdgeEntityDirectionFilterIteratorSetting =
        classicIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(operation);

    // Assert
    assertEquals(
        "Edge_Entity_Directed_Undirected_Incoming_Outgoing_Filter",
        actualEdgeEntityDirectionFilterIteratorSetting.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic.ClassicEdgeDirectedUndirectedFilterIterator",
        actualEdgeEntityDirectionFilterIteratorSetting.getIteratorClass());
    Map<String, String> options = actualEdgeEntityDirectionFilterIteratorSetting.getOptions();
    assertEquals(2, options.size());
    assertEquals(33, actualEdgeEntityDirectionFilterIteratorSetting.getPriority());
    assertEquals(Boolean.TRUE.toString(), options.get("Directed_Edges_Only"));
    assertEquals(Boolean.TRUE.toString(), options.get("Incoming_Edges_Only"));
  }

  /**
   * Test {@link
   * ClassicIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}.
   *
   * <p>Method under test: {@link
   * ClassicIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}
   */
  @Test
  @DisplayName("Test getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ClassicIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)"
  })
  void testGetEdgeEntityDirectionFilterIteratorSetting3() {
    // Arrange
    ClassicIteratorSettingsFactory classicIteratorSettingsFactory =
        new ClassicIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setDirectedType(DirectedType.UNDIRECTED);
    operation.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.INCOMING);
    operation.setView(new View());

    // Act
    IteratorSetting actualEdgeEntityDirectionFilterIteratorSetting =
        classicIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(operation);

    // Assert
    assertEquals(
        "Edge_Entity_Directed_Undirected_Incoming_Outgoing_Filter",
        actualEdgeEntityDirectionFilterIteratorSetting.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic.ClassicEdgeDirectedUndirectedFilterIterator",
        actualEdgeEntityDirectionFilterIteratorSetting.getIteratorClass());
    Map<String, String> options = actualEdgeEntityDirectionFilterIteratorSetting.getOptions();
    assertEquals(2, options.size());
    assertEquals(33, actualEdgeEntityDirectionFilterIteratorSetting.getPriority());
    assertEquals(Boolean.TRUE.toString(), options.get("Incoming_Edges_Only"));
    assertEquals(Boolean.TRUE.toString(), options.get("Undirected_Edges_Only"));
  }

  /**
   * Test {@link
   * ClassicIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}.
   *
   * <ul>
   *   <li>Given {@code EITHER}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassicIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}
   */
  @Test
  @DisplayName("Test getEdgeEntityDirectionFilterIteratorSetting(GraphFilters); given 'EITHER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ClassicIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)"
  })
  void testGetEdgeEntityDirectionFilterIteratorSetting_givenEither() {
    // Arrange
    ClassicIteratorSettingsFactory classicIteratorSettingsFactory =
        new ClassicIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.EITHER);
    operation.setView(new View());

    // Act
    IteratorSetting actualEdgeEntityDirectionFilterIteratorSetting =
        classicIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(operation);

    // Assert
    assertEquals(
        "Edge_Entity_Directed_Undirected_Incoming_Outgoing_Filter",
        actualEdgeEntityDirectionFilterIteratorSetting.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic.ClassicEdgeDirectedUndirectedFilterIterator",
        actualEdgeEntityDirectionFilterIteratorSetting.getIteratorClass());
    assertEquals(33, actualEdgeEntityDirectionFilterIteratorSetting.getPriority());
    assertTrue(actualEdgeEntityDirectionFilterIteratorSetting.getOptions().isEmpty());
  }

  /**
   * Test {@link
   * ClassicIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassicIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}
   */
  @Test
  @DisplayName(
      "Test getEdgeEntityDirectionFilterIteratorSetting(GraphFilters); given View (default constructor); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ClassicIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)"
  })
  void testGetEdgeEntityDirectionFilterIteratorSetting_givenView_thenReturnOptionsEmpty() {
    // Arrange
    ClassicIteratorSettingsFactory classicIteratorSettingsFactory =
        new ClassicIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setView(new View());

    // Act
    IteratorSetting actualEdgeEntityDirectionFilterIteratorSetting =
        classicIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(operation);

    // Assert
    assertEquals(
        "Edge_Entity_Directed_Undirected_Incoming_Outgoing_Filter",
        actualEdgeEntityDirectionFilterIteratorSetting.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic.ClassicEdgeDirectedUndirectedFilterIterator",
        actualEdgeEntityDirectionFilterIteratorSetting.getIteratorClass());
    assertEquals(33, actualEdgeEntityDirectionFilterIteratorSetting.getPriority());
    assertTrue(actualEdgeEntityDirectionFilterIteratorSetting.getOptions().isEmpty());
  }

  /**
   * Test {@link
   * ClassicIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}.
   *
   * <ul>
   *   <li>Then return Options size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ClassicIteratorSettingsFactory#getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)}
   */
  @Test
  @DisplayName(
      "Test getEdgeEntityDirectionFilterIteratorSetting(GraphFilters); then return Options size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ClassicIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(GraphFilters)"
  })
  void testGetEdgeEntityDirectionFilterIteratorSetting_thenReturnOptionsSizeIsOne() {
    // Arrange
    ClassicIteratorSettingsFactory classicIteratorSettingsFactory =
        new ClassicIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.INCOMING);
    operation.setView(new View());

    // Act
    IteratorSetting actualEdgeEntityDirectionFilterIteratorSetting =
        classicIteratorSettingsFactory.getEdgeEntityDirectionFilterIteratorSetting(operation);

    // Assert
    assertEquals(
        "Edge_Entity_Directed_Undirected_Incoming_Outgoing_Filter",
        actualEdgeEntityDirectionFilterIteratorSetting.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic.ClassicEdgeDirectedUndirectedFilterIterator",
        actualEdgeEntityDirectionFilterIteratorSetting.getIteratorClass());
    Map<String, String> options = actualEdgeEntityDirectionFilterIteratorSetting.getOptions();
    assertEquals(1, options.size());
    assertEquals(33, actualEdgeEntityDirectionFilterIteratorSetting.getPriority());
    assertEquals(Boolean.TRUE.toString(), options.get("Incoming_Edges_Only"));
  }

  /**
   * Test {@link ClassicIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}.
   *
   * <p>Method under test: {@link
   * ClassicIteratorSettingsFactory#getElementPropertyRangeQueryFilter(GraphFilters)}
   */
  @Test
  @DisplayName("Test getElementPropertyRangeQueryFilter(GraphFilters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IteratorSetting ClassicIteratorSettingsFactory.getElementPropertyRangeQueryFilter(GraphFilters)"
  })
  void testGetElementPropertyRangeQueryFilter() {
    // Arrange
    ClassicIteratorSettingsFactory classicIteratorSettingsFactory =
        new ClassicIteratorSettingsFactory();

    GetElementsBetweenSets operation = new GetElementsBetweenSets();
    operation.setView(new View());

    // Act
    IteratorSetting actualElementPropertyRangeQueryFilter =
        classicIteratorSettingsFactory.getElementPropertyRangeQueryFilter(operation);

    // Assert
    assertEquals("Range_Element_Property_Filter", actualElementPropertyRangeQueryFilter.getName());
    assertEquals(
        "uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic.ClassicRangeElementPropertyFilterIterator",
        actualElementPropertyRangeQueryFilter.getIteratorClass());
    Map<String, String> options = actualElementPropertyRangeQueryFilter.getOptions();
    assertEquals(1, options.size());
    assertEquals(Boolean.TRUE.toString(), options.get("all"));
    assertEquals(Integer.SIZE, actualElementPropertyRangeQueryFilter.getPriority());
  }
}
