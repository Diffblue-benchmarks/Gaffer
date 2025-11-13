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

package uk.gov.gchq.gaffer.store.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.GroupedProperties;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewElementDefinition;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.util.AggregatorUtil.ElementBinaryOperator;
import uk.gov.gchq.gaffer.store.util.AggregatorUtil.IngestElementBinaryOperator;
import uk.gov.gchq.gaffer.store.util.AggregatorUtil.IngestPropertiesBinaryOperator;
import uk.gov.gchq.gaffer.store.util.AggregatorUtil.IsElementAggregated;
import uk.gov.gchq.gaffer.store.util.AggregatorUtil.PropertiesBinaryOperator;
import uk.gov.gchq.gaffer.store.util.AggregatorUtil.QueryElementBinaryOperator;
import uk.gov.gchq.gaffer.store.util.AggregatorUtil.QueryPropertiesBinaryOperator;
import uk.gov.gchq.gaffer.store.util.AggregatorUtil.ToElementKey;
import uk.gov.gchq.koryphe.iterable.ChainedIterable;
import uk.gov.gchq.koryphe.iterable.ChainedIterator;

class AggregatorUtilDiffblueTest {
  /**
   * Test ElementBinaryOperator {@link ElementBinaryOperator#ElementBinaryOperator(Schema, View)}.
   *
   * <p>Method under test: {@link ElementBinaryOperator#ElementBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test ElementBinaryOperator new ElementBinaryOperator(Schema, View)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementBinaryOperator.<init>(Schema, View)"})
  void testElementBinaryOperatorNewElementBinaryOperator() {
    // Arrange
    Schema schema = new Schema();

    // Act
    ElementBinaryOperator actualElementBinaryOperator =
        new ElementBinaryOperator(schema, new View());

    // Assert
    assertNull(actualElementBinaryOperator.apply(null, null));
  }

  /**
   * Test ElementBinaryOperator {@link ElementBinaryOperator#ElementBinaryOperator(Schema, View)}.
   *
   * <p>Method under test: {@link ElementBinaryOperator#ElementBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test ElementBinaryOperator new ElementBinaryOperator(Schema, View)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementBinaryOperator.<init>(Schema, View)"})
  void testElementBinaryOperatorNewElementBinaryOperator2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ElementBinaryOperator(null, new View()));
  }

  /**
   * Test ElementBinaryOperator {@link ElementBinaryOperator#_apply(Element, Element)} with {@code
   * Element}, {@code Element}.
   *
   * <p>Method under test: {@link ElementBinaryOperator#_apply(Element, Element)}
   */
  @Test
  @DisplayName("Test ElementBinaryOperator _apply(Element, Element) with 'Element', 'Element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element ElementBinaryOperator._apply(Element, Element)"})
  void testElementBinaryOperator_applyWithElementElement() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    ElementBinaryOperator elementBinaryOperator = new ElementBinaryOperator(schema, new View());
    Edge a = new Edge("Group");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> elementBinaryOperator._apply(a, new Edge("Group")));
    verify(schema).getElement("Group");
  }

  /**
   * Test ElementBinaryOperator {@link ElementBinaryOperator#_apply(Element, Element)} with {@code
   * Element}, {@code Element}.
   *
   * <p>Method under test: {@link ElementBinaryOperator#_apply(Element, Element)}
   */
  @Test
  @DisplayName("Test ElementBinaryOperator _apply(Element, Element) with 'Element', 'Element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element ElementBinaryOperator._apply(Element, Element)"})
  void testElementBinaryOperator_applyWithElementElement2() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    ElementBinaryOperator elementBinaryOperator = new ElementBinaryOperator(schema, null);
    Edge a = new Edge("Group");

    // Act
    Element actual_applyResult = elementBinaryOperator._apply(a, new Edge("Group"));

    // Assert
    verify(schema).getElement("Group");
    assertSame(a, actual_applyResult);
  }

  /**
   * Test ElementBinaryOperator {@link ElementBinaryOperator#_apply(Element, Element)} with {@code
   * Element}, {@code Element}.
   *
   * <p>Method under test: {@link ElementBinaryOperator#_apply(Element, Element)}
   */
  @Test
  @DisplayName("Test ElementBinaryOperator _apply(Element, Element) with 'Element', 'Element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element ElementBinaryOperator._apply(Element, Element)"})
  void testElementBinaryOperator_applyWithElementElement3() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    ElementBinaryOperator elementBinaryOperator = new ElementBinaryOperator(schema, null);
    Edge a = new Edge("Group");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> elementBinaryOperator._apply(a, new Edge("Group")));
    verify(schema).getElement("Group");
  }

  /**
   * Test ElementBinaryOperator {@link ElementBinaryOperator#_apply(Element, Element)} with {@code
   * Element}, {@code Element}.
   *
   * <p>Method under test: {@link ElementBinaryOperator#_apply(Element, Element)}
   */
  @Test
  @DisplayName("Test ElementBinaryOperator _apply(Element, Element) with 'Element', 'Element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element ElementBinaryOperator._apply(Element, Element)"})
  void testElementBinaryOperator_applyWithElementElement4() {
    // Arrange
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    ElementBinaryOperator elementBinaryOperator =
        new ElementBinaryOperator(mock(Schema.class), view);
    Edge a = new Edge("Group");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> elementBinaryOperator._apply(a, new Edge("Group")));
    verify(view).getElement("Group");
  }

  /**
   * Test ElementBinaryOperator {@link ElementBinaryOperator#_apply(Element, Element)} with {@code
   * Element}, {@code Element}.
   *
   * <ul>
   *   <li>Then calls {@link SchemaEdgeDefinition#getQueryAggregator(Set, ElementAggregator)}.
   * </ul>
   *
   * <p>Method under test: {@link ElementBinaryOperator#_apply(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test ElementBinaryOperator _apply(Element, Element) with 'Element', 'Element'; then calls getQueryAggregator(Set, ElementAggregator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element ElementBinaryOperator._apply(Element, Element)"})
  void testElementBinaryOperator_applyWithElementElement_thenCallsGetQueryAggregator() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getQueryAggregator(
            Mockito.<Set<String>>any(), Mockito.<ElementAggregator>any()))
        .thenReturn(new ElementAggregator.Builder().build());

    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());

    ElementBinaryOperator elementBinaryOperator = new ElementBinaryOperator(schema, view);
    Edge a = new Edge("Group");

    // Act
    Element actual_applyResult = elementBinaryOperator._apply(a, new Edge("Group"));

    // Assert
    verify(view).getElement("Group");
    verify(schema).getElement("Group");
    verify(schemaEdgeDefinition).getQueryAggregator(isNull(), isNull());
    assertSame(a, actual_applyResult);
  }

  /**
   * Test ElementBinaryOperator {@link ElementBinaryOperator#_apply(Element, Element)} with {@code
   * Element}, {@code Element}.
   *
   * <ul>
   *   <li>Then return {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ElementBinaryOperator#_apply(Element, Element)}
   */
  @Test
  @DisplayName(
      "Test ElementBinaryOperator _apply(Element, Element) with 'Element', 'Element'; then return Edge(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element ElementBinaryOperator._apply(Element, Element)"})
  void testElementBinaryOperator_applyWithElementElement_thenReturnEdgeWithGroup() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());

    ElementBinaryOperator elementBinaryOperator = new ElementBinaryOperator(schema, view);
    Edge a = new Edge("Group");

    // Act
    Element actual_applyResult = elementBinaryOperator._apply(a, new Edge("Group"));

    // Assert
    verify(view).getElement("Group");
    verify(schema).getElement("Group");
    assertSame(a, actual_applyResult);
  }

  /**
   * Test {@link AggregatorUtil#ingestAggregate(Iterable, Schema)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   *   <li>Then return {@link ChainedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#ingestAggregate(Iterable, Schema)}
   */
  @Test
  @DisplayName(
      "Test ingestAggregate(Iterable, Schema); given 'null'; when LinkedHashSet() add 'null'; then return ChainedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregatorUtil.ingestAggregate(Iterable, Schema)"})
  void testIngestAggregate_givenNull_whenLinkedHashSetAddNull_thenReturnChainedIterable() {
    // Arrange
    LinkedHashSet<? extends Element> elements = new LinkedHashSet<>();
    elements.add(null);

    // Act
    Iterable<Element> actualIngestAggregateResult =
        AggregatorUtil.ingestAggregate(elements, new Schema());
    Iterator<Element> actualIteratorResult = actualIngestAggregateResult.iterator();

    // Assert
    assertTrue(actualIngestAggregateResult instanceof ChainedIterable);
    Iterator<Element> iteratorResult = actualIngestAggregateResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregatorUtil#ingestAggregate(Iterable, Schema)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ChainedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#ingestAggregate(Iterable, Schema)}
   */
  @Test
  @DisplayName(
      "Test ingestAggregate(Iterable, Schema); when ArrayList(); then return ChainedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregatorUtil.ingestAggregate(Iterable, Schema)"})
  void testIngestAggregate_whenArrayList_thenReturnChainedIterable() {
    // Arrange
    ArrayList<Element> elements = new ArrayList<>();

    // Act
    Iterable<Element> actualIngestAggregateResult =
        AggregatorUtil.ingestAggregate(elements, new Schema());
    Iterator<Element> actualIteratorResult = actualIngestAggregateResult.iterator();

    // Assert
    assertTrue(actualIngestAggregateResult instanceof ChainedIterable);
    Iterator<Element> iteratorResult = actualIngestAggregateResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test IngestElementBinaryOperator {@link
   * IngestElementBinaryOperator#IngestElementBinaryOperator(Schema)}.
   *
   * <p>Method under test: {@link IngestElementBinaryOperator#IngestElementBinaryOperator(Schema)}
   */
  @Test
  @DisplayName("Test IngestElementBinaryOperator new IngestElementBinaryOperator(Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IngestElementBinaryOperator.<init>(Schema)"})
  void testIngestElementBinaryOperatorNewIngestElementBinaryOperator() {
    // Arrange, Act and Assert
    assertNull(new IngestElementBinaryOperator(new Schema()).apply(null, null));
  }

  /**
   * Test IngestPropertiesBinaryOperator {@link
   * IngestPropertiesBinaryOperator#IngestPropertiesBinaryOperator(Schema)}.
   *
   * <p>Method under test: {@link
   * IngestPropertiesBinaryOperator#IngestPropertiesBinaryOperator(Schema)}
   */
  @Test
  @DisplayName("Test IngestPropertiesBinaryOperator new IngestPropertiesBinaryOperator(Schema)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IngestPropertiesBinaryOperator.<init>(Schema)"})
  void testIngestPropertiesBinaryOperatorNewIngestPropertiesBinaryOperator() {
    // Arrange, Act and Assert
    assertNull(new IngestPropertiesBinaryOperator(new Schema()).apply(null, null));
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#IsElementAggregated(Collection)}.
   *
   * <p>Method under test: {@link IsElementAggregated#IsElementAggregated(Collection)}
   */
  @Test
  @DisplayName("Test IsElementAggregated new IsElementAggregated(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IsElementAggregated.<init>(Collection)"})
  void testIsElementAggregatedNewIsElementAggregated() {
    // Arrange
    ArrayList<String> aggregatedGroups = new ArrayList<>();
    aggregatedGroups.add("foo");

    // Act
    IsElementAggregated actualIsElementAggregated = new IsElementAggregated(aggregatedGroups);
    boolean actualTestResult =
        actualIsElementAggregated.test(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    Collection<String> collection = actualIsElementAggregated.aggregatedGroups;
    assertEquals(1, collection.size());
    assertTrue(collection instanceof List);
    assertEquals("foo", ((List<String>) collection).get(0));
    assertFalse(actualTestResult);
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#IsElementAggregated(Collection)}.
   *
   * <p>Method under test: {@link IsElementAggregated#IsElementAggregated(Collection)}
   */
  @Test
  @DisplayName("Test IsElementAggregated new IsElementAggregated(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IsElementAggregated.<init>(Collection)"})
  void testIsElementAggregatedNewIsElementAggregated2() {
    // Arrange
    ArrayList<String> aggregatedGroups = new ArrayList<>();
    aggregatedGroups.add("42");
    aggregatedGroups.add("foo");

    // Act
    IsElementAggregated actualIsElementAggregated = new IsElementAggregated(aggregatedGroups);
    boolean actualTestResult =
        actualIsElementAggregated.test(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    Collection<String> collection = actualIsElementAggregated.aggregatedGroups;
    assertEquals(2, collection.size());
    assertTrue(collection instanceof List);
    assertEquals("42", ((List<String>) collection).get(0));
    assertEquals("foo", ((List<String>) collection).get(1));
    assertFalse(actualTestResult);
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#IsElementAggregated(Collection)}.
   *
   * <p>Method under test: {@link IsElementAggregated#IsElementAggregated(Collection)}
   */
  @Test
  @DisplayName("Test IsElementAggregated new IsElementAggregated(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IsElementAggregated.<init>(Collection)"})
  void testIsElementAggregatedNewIsElementAggregated3() {
    // Arrange
    ArrayList<String> aggregatedGroups = new ArrayList<>();
    aggregatedGroups.add("42");
    aggregatedGroups.add("foo");

    // Act
    IsElementAggregated actualIsElementAggregated = new IsElementAggregated(aggregatedGroups);
    boolean actualTestResult =
        actualIsElementAggregated.test(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("42")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    Collection<String> collection = actualIsElementAggregated.aggregatedGroups;
    assertEquals(2, collection.size());
    assertTrue(collection instanceof List);
    assertEquals("42", ((List<String>) collection).get(0));
    assertEquals("foo", ((List<String>) collection).get(1));
    assertTrue(actualTestResult);
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#IsElementAggregated(Schema)}.
   *
   * <ul>
   *   <li>Then {@link IsElementAggregated#aggregatedGroups} return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link IsElementAggregated#IsElementAggregated(Schema)}
   */
  @Test
  @DisplayName(
      "Test IsElementAggregated new IsElementAggregated(Schema); then aggregatedGroups return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IsElementAggregated.<init>(Schema)"})
  void testIsElementAggregatedNewIsElementAggregated_thenAggregatedGroupsReturnList() {
    // Arrange and Act
    IsElementAggregated actualIsElementAggregated = new IsElementAggregated(new Schema());
    Edge element =
        new Builder()
            .dest("Dest")
            .directed(true)
            .group("Group")
            .matchedVertex(MatchedVertex.SOURCE)
            .source("Source")
            .build();
    boolean actualTestResult = actualIsElementAggregated.test(element);

    // Assert
    Collection<String> collection = actualIsElementAggregated.aggregatedGroups;
    assertTrue(collection instanceof List);
    assertFalse(actualTestResult);
    assertTrue(collection.isEmpty());
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#IsElementAggregated(Collection)}.
   *
   * <ul>
   *   <li>Then return {@link IsElementAggregated#aggregatedGroups} Empty.
   * </ul>
   *
   * <p>Method under test: {@link IsElementAggregated#IsElementAggregated(Collection)}
   */
  @Test
  @DisplayName(
      "Test IsElementAggregated new IsElementAggregated(Collection); then return aggregatedGroups Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void IsElementAggregated.<init>(Collection)"})
  void testIsElementAggregatedNewIsElementAggregated_thenReturnAggregatedGroupsEmpty() {
    // Arrange and Act
    IsElementAggregated actualIsElementAggregated = new IsElementAggregated(new ArrayList<>());
    boolean actualTestResult =
        actualIsElementAggregated.test(
            new Builder()
                .dest("Dest")
                .directed(true)
                .group("Group")
                .matchedVertex(MatchedVertex.SOURCE)
                .source("Source")
                .build());

    // Assert
    Collection<String> collection = actualIsElementAggregated.aggregatedGroups;
    assertTrue(collection instanceof List);
    assertFalse(actualTestResult);
    assertTrue(collection.isEmpty());
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#test(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link IsElementAggregated#test(Element)}
   */
  @Test
  @DisplayName(
      "Test IsElementAggregated test(Element) with 'Element'; when Edge(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IsElementAggregated.test(Element)"})
  void testIsElementAggregatedTestWithElement_whenEdgeWithGroup() {
    // Arrange
    IsElementAggregated isElementAggregated = new IsElementAggregated(new ArrayList<>());

    // Act
    boolean actualTestResult = isElementAggregated.test(new Edge("Group"));

    // Assert
    assertFalse(actualTestResult);
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#test(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IsElementAggregated#test(Element)}
   */
  @Test
  @DisplayName("Test IsElementAggregated test(Element) with 'Element'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean IsElementAggregated.test(Element)"})
  void testIsElementAggregatedTestWithElement_whenNull() {
    // Arrange, Act and Assert
    assertFalse(new IsElementAggregated(new ArrayList<>()).test(null));
  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#PropertiesBinaryOperator(Schema,
   * View)}.
   *
   * <p>Method under test: {@link PropertiesBinaryOperator#PropertiesBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test PropertiesBinaryOperator new PropertiesBinaryOperator(Schema, View)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PropertiesBinaryOperator.<init>(Schema, View)"})
  void testPropertiesBinaryOperatorNewPropertiesBinaryOperator() {
    // Arrange
    Schema schema = new Schema();

    // Act
    PropertiesBinaryOperator actualPropertiesBinaryOperator =
        new PropertiesBinaryOperator(schema, new View());

    // Assert
    assertNull(actualPropertiesBinaryOperator.apply(null, null));
  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#PropertiesBinaryOperator(Schema,
   * View)}.
   *
   * <p>Method under test: {@link PropertiesBinaryOperator#PropertiesBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test PropertiesBinaryOperator new PropertiesBinaryOperator(Schema, View)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PropertiesBinaryOperator.<init>(Schema, View)"})
  void testPropertiesBinaryOperatorNewPropertiesBinaryOperator2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PropertiesBinaryOperator(null, new View()));
  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#_apply(GroupedProperties,
   * GroupedProperties)} with {@code GroupedProperties}, {@code GroupedProperties}.
   *
   * <p>Method under test: {@link PropertiesBinaryOperator#_apply(GroupedProperties,
   * GroupedProperties)}
   */
  @Test
  @DisplayName(
      "Test PropertiesBinaryOperator _apply(GroupedProperties, GroupedProperties) with 'GroupedProperties', 'GroupedProperties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GroupedProperties PropertiesBinaryOperator._apply(GroupedProperties, GroupedProperties)"
  })
  void testPropertiesBinaryOperator_applyWithGroupedPropertiesGroupedProperties() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    PropertiesBinaryOperator propertiesBinaryOperator =
        new PropertiesBinaryOperator(schema, new View());
    GroupedProperties a = new GroupedProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> propertiesBinaryOperator._apply(a, new GroupedProperties()));
    verify(schema).getElement(null);
  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#_apply(GroupedProperties,
   * GroupedProperties)} with {@code GroupedProperties}, {@code GroupedProperties}.
   *
   * <p>Method under test: {@link PropertiesBinaryOperator#_apply(GroupedProperties,
   * GroupedProperties)}
   */
  @Test
  @DisplayName(
      "Test PropertiesBinaryOperator _apply(GroupedProperties, GroupedProperties) with 'GroupedProperties', 'GroupedProperties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GroupedProperties PropertiesBinaryOperator._apply(GroupedProperties, GroupedProperties)"
  })
  void testPropertiesBinaryOperator_applyWithGroupedPropertiesGroupedProperties2() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    PropertiesBinaryOperator propertiesBinaryOperator = new PropertiesBinaryOperator(schema, null);
    GroupedProperties a = new GroupedProperties();

    // Act
    GroupedProperties actual_applyResult =
        propertiesBinaryOperator._apply(a, new GroupedProperties());

    // Assert
    verify(schema).getElement(null);
    assertSame(a, actual_applyResult);
  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#_apply(GroupedProperties,
   * GroupedProperties)} with {@code GroupedProperties}, {@code GroupedProperties}.
   *
   * <p>Method under test: {@link PropertiesBinaryOperator#_apply(GroupedProperties,
   * GroupedProperties)}
   */
  @Test
  @DisplayName(
      "Test PropertiesBinaryOperator _apply(GroupedProperties, GroupedProperties) with 'GroupedProperties', 'GroupedProperties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GroupedProperties PropertiesBinaryOperator._apply(GroupedProperties, GroupedProperties)"
  })
  void testPropertiesBinaryOperator_applyWithGroupedPropertiesGroupedProperties3() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    PropertiesBinaryOperator propertiesBinaryOperator = new PropertiesBinaryOperator(schema, null);
    GroupedProperties a = new GroupedProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> propertiesBinaryOperator._apply(a, new GroupedProperties()));
    verify(schema).getElement(null);
  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#_apply(GroupedProperties,
   * GroupedProperties)} with {@code GroupedProperties}, {@code GroupedProperties}.
   *
   * <p>Method under test: {@link PropertiesBinaryOperator#_apply(GroupedProperties,
   * GroupedProperties)}
   */
  @Test
  @DisplayName(
      "Test PropertiesBinaryOperator _apply(GroupedProperties, GroupedProperties) with 'GroupedProperties', 'GroupedProperties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GroupedProperties PropertiesBinaryOperator._apply(GroupedProperties, GroupedProperties)"
  })
  void testPropertiesBinaryOperator_applyWithGroupedPropertiesGroupedProperties4() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());

    PropertiesBinaryOperator propertiesBinaryOperator = new PropertiesBinaryOperator(schema, view);
    GroupedProperties a = new GroupedProperties();

    // Act
    GroupedProperties actual_applyResult =
        propertiesBinaryOperator._apply(a, new GroupedProperties());

    // Assert
    verify(view).getElement(null);
    verify(schema).getElement(null);
    assertSame(a, actual_applyResult);
  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#_apply(GroupedProperties,
   * GroupedProperties)} with {@code GroupedProperties}, {@code GroupedProperties}.
   *
   * <p>Method under test: {@link PropertiesBinaryOperator#_apply(GroupedProperties,
   * GroupedProperties)}
   */
  @Test
  @DisplayName(
      "Test PropertiesBinaryOperator _apply(GroupedProperties, GroupedProperties) with 'GroupedProperties', 'GroupedProperties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GroupedProperties PropertiesBinaryOperator._apply(GroupedProperties, GroupedProperties)"
  })
  void testPropertiesBinaryOperator_applyWithGroupedPropertiesGroupedProperties5() {
    // Arrange
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    PropertiesBinaryOperator propertiesBinaryOperator =
        new PropertiesBinaryOperator(mock(Schema.class), view);
    GroupedProperties a = new GroupedProperties();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> propertiesBinaryOperator._apply(a, new GroupedProperties()));
    verify(view).getElement(null);
  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#_apply(GroupedProperties,
   * GroupedProperties)} with {@code GroupedProperties}, {@code GroupedProperties}.
   *
   * <p>Method under test: {@link PropertiesBinaryOperator#_apply(GroupedProperties,
   * GroupedProperties)}
   */
  @Test
  @DisplayName(
      "Test PropertiesBinaryOperator _apply(GroupedProperties, GroupedProperties) with 'GroupedProperties', 'GroupedProperties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GroupedProperties PropertiesBinaryOperator._apply(GroupedProperties, GroupedProperties)"
  })
  void testPropertiesBinaryOperator_applyWithGroupedPropertiesGroupedProperties6() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    when(schemaEdgeDefinition.getQueryAggregator(
            Mockito.<Set<String>>any(), Mockito.<ElementAggregator>any()))
        .thenReturn(new ElementAggregator.Builder().build());

    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());

    PropertiesBinaryOperator propertiesBinaryOperator = new PropertiesBinaryOperator(schema, view);
    GroupedProperties a = new GroupedProperties();

    // Act
    GroupedProperties actual_applyResult =
        propertiesBinaryOperator._apply(a, new GroupedProperties());

    // Assert
    verify(view).getElement(null);
    verify(schema).getElement(null);
    verify(schemaEdgeDefinition).getQueryAggregator(isNull(), isNull());
    assertSame(a, actual_applyResult);
  }

  /**
   * Test {@link AggregatorUtil#queryAggregate(Iterable, Schema, View, boolean)} with {@code
   * elements}, {@code schema}, {@code view}, {@code includeMatchedVertex}.
   *
   * <p>Method under test: {@link AggregatorUtil#queryAggregate(Iterable, Schema, View, boolean)}
   */
  @Test
  @DisplayName(
      "Test queryAggregate(Iterable, Schema, View, boolean) with 'elements', 'schema', 'view', 'includeMatchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregatorUtil.queryAggregate(Iterable, Schema, View, boolean)"})
  void testQueryAggregateWithElementsSchemaViewIncludeMatchedVertex() {
    // Arrange
    ArrayList<Element> elements = new ArrayList<>();
    Schema schema = new Schema();

    // Act
    Iterable<Element> actualQueryAggregateResult =
        AggregatorUtil.queryAggregate(elements, schema, new View(), true);
    Iterator<Element> actualIteratorResult = actualQueryAggregateResult.iterator();

    // Assert
    assertTrue(actualQueryAggregateResult instanceof ChainedIterable);
    Iterator<Element> iteratorResult = actualQueryAggregateResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregatorUtil#queryAggregate(Iterable, Schema, View, boolean)} with {@code
   * elements}, {@code schema}, {@code view}, {@code includeMatchedVertex}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#queryAggregate(Iterable, Schema, View, boolean)}
   */
  @Test
  @DisplayName(
      "Test queryAggregate(Iterable, Schema, View, boolean) with 'elements', 'schema', 'view', 'includeMatchedVertex'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregatorUtil.queryAggregate(Iterable, Schema, View, boolean)"})
  void testQueryAggregateWithElementsSchemaViewIncludeMatchedVertex_givenNull() {
    // Arrange
    LinkedHashSet<? extends Element> elements = new LinkedHashSet<>();
    elements.add(null);
    Schema schema = new Schema();

    // Act
    Iterable<Element> actualQueryAggregateResult =
        AggregatorUtil.queryAggregate(elements, schema, new View(), true);
    Iterator<Element> actualIteratorResult = actualQueryAggregateResult.iterator();

    // Assert
    assertTrue(actualQueryAggregateResult instanceof ChainedIterable);
    Iterator<Element> iteratorResult = actualQueryAggregateResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregatorUtil#queryAggregate(Iterable, Schema, View)} with {@code elements},
   * {@code schema}, {@code view}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#queryAggregate(Iterable, Schema, View)}
   */
  @Test
  @DisplayName(
      "Test queryAggregate(Iterable, Schema, View) with 'elements', 'schema', 'view'; given 'null'; when LinkedHashSet() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregatorUtil.queryAggregate(Iterable, Schema, View)"})
  void testQueryAggregateWithElementsSchemaView_givenNull_whenLinkedHashSetAddNull() {
    // Arrange
    LinkedHashSet<? extends Element> elements = new LinkedHashSet<>();
    elements.add(null);
    Schema schema = new Schema();

    // Act
    Iterable<Element> actualQueryAggregateResult =
        AggregatorUtil.queryAggregate(elements, schema, new View());
    Iterator<Element> actualIteratorResult = actualQueryAggregateResult.iterator();

    // Assert
    assertTrue(actualQueryAggregateResult instanceof ChainedIterable);
    Iterator<Element> iteratorResult = actualQueryAggregateResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregatorUtil#queryAggregate(Iterable, Schema, View)} with {@code elements},
   * {@code schema}, {@code view}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ChainedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#queryAggregate(Iterable, Schema, View)}
   */
  @Test
  @DisplayName(
      "Test queryAggregate(Iterable, Schema, View) with 'elements', 'schema', 'view'; when ArrayList(); then return ChainedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable AggregatorUtil.queryAggregate(Iterable, Schema, View)"})
  void testQueryAggregateWithElementsSchemaView_whenArrayList_thenReturnChainedIterable() {
    // Arrange
    ArrayList<Element> elements = new ArrayList<>();
    Schema schema = new Schema();

    // Act
    Iterable<Element> actualQueryAggregateResult =
        AggregatorUtil.queryAggregate(elements, schema, new View());
    Iterator<Element> actualIteratorResult = actualQueryAggregateResult.iterator();

    // Assert
    assertTrue(actualQueryAggregateResult instanceof ChainedIterable);
    Iterator<Element> iteratorResult = actualQueryAggregateResult.iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertTrue(actualIteratorResult instanceof ChainedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link AggregatorUtil#getIngestGroupBys(Schema)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#getIngestGroupBys(Schema)}
   */
  @Test
  @DisplayName("Test getIngestGroupBys(Schema); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AggregatorUtil.getIngestGroupBys(Schema)"})
  void testGetIngestGroupBys_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AggregatorUtil.getIngestGroupBys(null));
  }

  /**
   * Test {@link AggregatorUtil#getIngestGroupBys(Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#getIngestGroupBys(Schema)}
   */
  @Test
  @DisplayName("Test getIngestGroupBys(Schema); when Schema(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AggregatorUtil.getIngestGroupBys(Schema)"})
  void testGetIngestGroupBys_whenSchema_thenReturnEmpty() {
    // Arrange and Act
    Map<String, Set<String>> actualIngestGroupBys = AggregatorUtil.getIngestGroupBys(new Schema());

    // Assert
    assertTrue(actualIngestGroupBys.isEmpty());
  }

  /**
   * Test {@link AggregatorUtil#getQueryGroupBys(Schema, View)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#getQueryGroupBys(Schema, View)}
   */
  @Test
  @DisplayName(
      "Test getQueryGroupBys(Schema, View); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AggregatorUtil.getQueryGroupBys(Schema, View)"})
  void testGetQueryGroupBys_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> AggregatorUtil.getQueryGroupBys(null, new View()));
  }

  /**
   * Test {@link AggregatorUtil#getQueryGroupBys(Schema, View)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#getQueryGroupBys(Schema, View)}
   */
  @Test
  @DisplayName(
      "Test getQueryGroupBys(Schema, View); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AggregatorUtil.getQueryGroupBys(Schema, View)"})
  void testGetQueryGroupBys_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> AggregatorUtil.getQueryGroupBys(new Schema(), null));
  }

  /**
   * Test {@link AggregatorUtil#getQueryGroupBys(Schema, View)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#getQueryGroupBys(Schema, View)}
   */
  @Test
  @DisplayName("Test getQueryGroupBys(Schema, View); when Schema(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AggregatorUtil.getQueryGroupBys(Schema, View)"})
  void testGetQueryGroupBys_whenSchema_thenReturnEmpty() {
    // Arrange
    Schema schema = new Schema();

    // Act
    Map<String, Set<String>> actualQueryGroupBys =
        AggregatorUtil.getQueryGroupBys(schema, new View());

    // Assert
    assertTrue(actualQueryGroupBys.isEmpty());
  }

  /**
   * Test {@link AggregatorUtil#getIngestGroupBy(String, Schema)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#getIngestGroupBy(String, Schema)}
   */
  @Test
  @DisplayName(
      "Test getIngestGroupBy(String, Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregatorUtil.getIngestGroupBy(String, Schema)"})
  void testGetIngestGroupBy_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> AggregatorUtil.getIngestGroupBy("Group", new Schema()));
  }

  /**
   * Test {@link AggregatorUtil#getQueryGroupBy(String, Schema, View)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#getQueryGroupBy(String, Schema, View)}
   */
  @Test
  @DisplayName(
      "Test getQueryGroupBy(String, Schema, View); when Schema(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregatorUtil.getQueryGroupBy(String, Schema, View)"})
  void testGetQueryGroupBy_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> AggregatorUtil.getQueryGroupBy("Group", schema, new View()));
  }

  /**
   * Test {@link AggregatorUtil#getQueryGroupBy(String, Schema, View)}.
   *
   * <ul>
   *   <li>When {@link Schema#Schema()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AggregatorUtil#getQueryGroupBy(String, Schema, View)}
   */
  @Test
  @DisplayName(
      "Test getQueryGroupBy(String, Schema, View); when Schema(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AggregatorUtil.getQueryGroupBy(String, Schema, View)"})
  void testGetQueryGroupBy_whenSchema_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> AggregatorUtil.getQueryGroupBy("Group", new Schema(), null));
  }

  /**
   * Test QueryElementBinaryOperator {@link
   * QueryElementBinaryOperator#QueryElementBinaryOperator(Schema, View)}.
   *
   * <p>Method under test: {@link QueryElementBinaryOperator#QueryElementBinaryOperator(Schema,
   * View)}
   */
  @Test
  @DisplayName("Test QueryElementBinaryOperator new QueryElementBinaryOperator(Schema, View)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueryElementBinaryOperator.<init>(Schema, View)"})
  void testQueryElementBinaryOperatorNewQueryElementBinaryOperator() {
    // Arrange
    Schema schema = new Schema();

    // Act
    QueryElementBinaryOperator actualQueryElementBinaryOperator =
        new QueryElementBinaryOperator(schema, new View());

    // Assert
    assertNull(actualQueryElementBinaryOperator.apply(null, null));
  }

  /**
   * Test QueryPropertiesBinaryOperator {@link
   * QueryPropertiesBinaryOperator#QueryPropertiesBinaryOperator(Schema, View)}.
   *
   * <p>Method under test: {@link
   * QueryPropertiesBinaryOperator#QueryPropertiesBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test QueryPropertiesBinaryOperator new QueryPropertiesBinaryOperator(Schema, View)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueryPropertiesBinaryOperator.<init>(Schema, View)"})
  void testQueryPropertiesBinaryOperatorNewQueryPropertiesBinaryOperator() {
    // Arrange
    Schema schema = new Schema();

    // Act
    QueryPropertiesBinaryOperator actualQueryPropertiesBinaryOperator =
        new QueryPropertiesBinaryOperator(schema, new View());

    // Assert
    assertNull(actualQueryPropertiesBinaryOperator.apply(null, null));
  }

  /**
   * Test ToElementKey {@link ToElementKey#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Entity.Builder} (default constructor) group {@code Group} vertex {@code
   *       Vertex} build.
   * </ul>
   *
   * <p>Method under test: {@link ToElementKey#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test ToElementKey apply(Element) with 'Element'; when Builder (default constructor) group 'Group' vertex 'Vertex' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element ToElementKey.apply(Element)"})
  void testToElementKeyApplyWithElement_whenBuilderGroupGroupVertexVertexBuild() {
    // Arrange
    ToElementKey toElementKey = new ToElementKey(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> toElementKey.apply(new Entity.Builder().group("Group").vertex("Vertex").build()));
  }

  /**
   * Test ToElementKey {@link ToElementKey#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ToElementKey#apply(Element)}
   */
  @Test
  @DisplayName("Test ToElementKey apply(Element) with 'Element'; when Edge(String) with 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element ToElementKey.apply(Element)"})
  void testToElementKeyApplyWithElement_whenEdgeWithGroup() {
    // Arrange
    ToElementKey toElementKey = new ToElementKey(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> toElementKey.apply(new Edge("Group")));
  }
}
