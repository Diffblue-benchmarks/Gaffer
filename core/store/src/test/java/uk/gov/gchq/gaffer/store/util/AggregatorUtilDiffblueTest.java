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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.data.element.GroupedProperties;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator;
import uk.gov.gchq.gaffer.data.element.function.ElementAggregator.Builder;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewElementDefinition;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;
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
   * <p>
   * Method under test: {@link ElementBinaryOperator#ElementBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test ElementBinaryOperator new ElementBinaryOperator(Schema, View)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementBinaryOperator.<init>(Schema, View)"})
  void testElementBinaryOperatorNewElementBinaryOperator() {
    // Arrange
    Schema schema = new Schema();

    // Act and Assert
    assertNull((new ElementBinaryOperator(schema, new View())).apply(null, null));
  }

  /**
   * Test ElementBinaryOperator {@link ElementBinaryOperator#ElementBinaryOperator(Schema, View)}.
   * <p>
   * Method under test: {@link ElementBinaryOperator#ElementBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test ElementBinaryOperator new ElementBinaryOperator(Schema, View)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementBinaryOperator.<init>(Schema, View)"})
  void testElementBinaryOperatorNewElementBinaryOperator2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new ElementBinaryOperator(null, new View()));

  }

  /**
   * Test ElementBinaryOperator {@link ElementBinaryOperator#_apply(Element, Element)} with {@code Element}, {@code Element}.
   * <p>
   * Method under test: {@link ElementBinaryOperator#_apply(Element, Element)}
   */
  @Test
  @DisplayName("Test ElementBinaryOperator _apply(Element, Element) with 'Element', 'Element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ElementBinaryOperator._apply(Element, Element)"})
  void testElementBinaryOperator_applyWithElementElement() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    ElementBinaryOperator elementBinaryOperator = new ElementBinaryOperator(schema, null);
    Edge a = new Edge("Group");

    // Act
    Element actual_applyResult = elementBinaryOperator._apply(a, new Edge("Group"));

    // Assert
    verify(schema).getElement(eq("Group"));
    assertSame(a, actual_applyResult);
  }

  /**
   * Test ElementBinaryOperator {@link ElementBinaryOperator#_apply(Element, Element)} with {@code Element}, {@code Element}.
   * <ul>
   *   <li>Then calls {@link View#getElement(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementBinaryOperator#_apply(Element, Element)}
   */
  @Test
  @DisplayName("Test ElementBinaryOperator _apply(Element, Element) with 'Element', 'Element'; then calls getElement(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ElementBinaryOperator._apply(Element, Element)"})
  void testElementBinaryOperator_applyWithElementElement_thenCallsGetElement() {
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
    verify(view).getElement(eq("Group"));
    verify(schema).getElement(eq("Group"));
    assertSame(a, actual_applyResult);
  }

  /**
   * Test ElementBinaryOperator {@link ElementBinaryOperator#_apply(Element, Element)} with {@code Element}, {@code Element}.
   * <ul>
   *   <li>Then calls {@link SchemaElementDefinition#getQueryAggregator(Set, ElementAggregator)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementBinaryOperator#_apply(Element, Element)}
   */
  @Test
  @DisplayName("Test ElementBinaryOperator _apply(Element, Element) with 'Element', 'Element'; then calls getQueryAggregator(Set, ElementAggregator)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ElementBinaryOperator._apply(Element, Element)"})
  void testElementBinaryOperator_applyWithElementElement_thenCallsGetQueryAggregator() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    ElementAggregator buildResult = (new Builder()).build();
    when(schemaEdgeDefinition.getQueryAggregator(Mockito.<Set<String>>any(), Mockito.<ElementAggregator>any()))
        .thenReturn(buildResult);
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());
    ElementBinaryOperator elementBinaryOperator = new ElementBinaryOperator(schema, view);
    Edge a = new Edge("Group");

    // Act
    Element actual_applyResult = elementBinaryOperator._apply(a, new Edge("Group"));

    // Assert
    verify(view).getElement(eq("Group"));
    verify(schema).getElement(eq("Group"));
    verify(schemaEdgeDefinition).getQueryAggregator(isNull(), isNull());
    assertSame(a, actual_applyResult);
  }

  /**
   * Test {@link AggregatorUtil#ingestAggregate(Iterable, Schema)}.
   * <p>
   * Method under test: {@link AggregatorUtil#ingestAggregate(Iterable, Schema)}
   */
  @Test
  @DisplayName("Test ingestAggregate(Iterable, Schema)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable AggregatorUtil.ingestAggregate(Iterable, Schema)"})
  void testIngestAggregate() {
    // Arrange
    ArrayList<Element> elements = new ArrayList<>();

    // Act
    Iterable<Element> actualIngestAggregateResult = AggregatorUtil.ingestAggregate(elements, new Schema());
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
   * Test IngestElementBinaryOperator {@link IngestElementBinaryOperator#IngestElementBinaryOperator(Schema)}.
   * <p>
   * Method under test: {@link IngestElementBinaryOperator#IngestElementBinaryOperator(Schema)}
   */
  @Test
  @DisplayName("Test IngestElementBinaryOperator new IngestElementBinaryOperator(Schema)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IngestElementBinaryOperator.<init>(Schema)"})
  void testIngestElementBinaryOperatorNewIngestElementBinaryOperator() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    // Act
    IngestElementBinaryOperator actualIngestElementBinaryOperator = new IngestElementBinaryOperator(schema);
    Edge edge = new Edge("Group");
    Element actualApplyResult = actualIngestElementBinaryOperator.apply(edge, new Edge("Group"));

    // Assert
    verify(schema).getElement(eq("Group"));
    assertSame(edge, actualApplyResult);
  }

  /**
   * Test IngestElementBinaryOperator {@link IngestElementBinaryOperator#IngestElementBinaryOperator(Schema)}.
   * <p>
   * Method under test: {@link IngestElementBinaryOperator#IngestElementBinaryOperator(Schema)}
   */
  @Test
  @DisplayName("Test IngestElementBinaryOperator new IngestElementBinaryOperator(Schema)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IngestElementBinaryOperator.<init>(Schema)"})
  void testIngestElementBinaryOperatorNewIngestElementBinaryOperator2() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    ElementAggregator buildResult = (new Builder()).build();
    when(schemaEdgeDefinition.getIngestAggregator()).thenReturn(buildResult);
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

    // Act
    IngestElementBinaryOperator actualIngestElementBinaryOperator = new IngestElementBinaryOperator(schema);
    Edge edge = new Edge("Group");
    Element actualApplyResult = actualIngestElementBinaryOperator.apply(edge, new Edge("Group"));

    // Assert
    verify(schema).getElement(eq("Group"));
    verify(schemaEdgeDefinition).getIngestAggregator();
    assertSame(edge, actualApplyResult);
  }

  /**
   * Test IngestPropertiesBinaryOperator {@link IngestPropertiesBinaryOperator#IngestPropertiesBinaryOperator(Schema)}.
   * <p>
   * Method under test: {@link IngestPropertiesBinaryOperator#IngestPropertiesBinaryOperator(Schema)}
   */
  @Test
  @DisplayName("Test IngestPropertiesBinaryOperator new IngestPropertiesBinaryOperator(Schema)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IngestPropertiesBinaryOperator.<init>(Schema)"})
  void testIngestPropertiesBinaryOperatorNewIngestPropertiesBinaryOperator() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());

    // Act
    IngestPropertiesBinaryOperator actualIngestPropertiesBinaryOperator = new IngestPropertiesBinaryOperator(schema);
    GroupedProperties groupedProperties = new GroupedProperties();
    GroupedProperties actualApplyResult = actualIngestPropertiesBinaryOperator.apply(groupedProperties,
        new GroupedProperties());

    // Assert
    verify(schema).getElement((String) isNull());
    assertSame(groupedProperties, actualApplyResult);
  }

  /**
   * Test IngestPropertiesBinaryOperator {@link IngestPropertiesBinaryOperator#IngestPropertiesBinaryOperator(Schema)}.
   * <p>
   * Method under test: {@link IngestPropertiesBinaryOperator#IngestPropertiesBinaryOperator(Schema)}
   */
  @Test
  @DisplayName("Test IngestPropertiesBinaryOperator new IngestPropertiesBinaryOperator(Schema)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IngestPropertiesBinaryOperator.<init>(Schema)"})
  void testIngestPropertiesBinaryOperatorNewIngestPropertiesBinaryOperator2() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    ElementAggregator buildResult = (new Builder()).build();
    when(schemaEdgeDefinition.getIngestAggregator()).thenReturn(buildResult);
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);

    // Act
    IngestPropertiesBinaryOperator actualIngestPropertiesBinaryOperator = new IngestPropertiesBinaryOperator(schema);
    GroupedProperties groupedProperties = new GroupedProperties();
    GroupedProperties actualApplyResult = actualIngestPropertiesBinaryOperator.apply(groupedProperties,
        new GroupedProperties());

    // Assert
    verify(schema).getElement((String) isNull());
    verify(schemaEdgeDefinition).getIngestAggregator();
    assertSame(groupedProperties, actualApplyResult);
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#IsElementAggregated(Collection)}.
   * <p>
   * Method under test: {@link IsElementAggregated#IsElementAggregated(Collection)}
   */
  @Test
  @DisplayName("Test IsElementAggregated new IsElementAggregated(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IsElementAggregated.<init>(Collection)"})
  void testIsElementAggregatedNewIsElementAggregated() {
    // Arrange
    ArrayList<String> aggregatedGroups = new ArrayList<>();
    aggregatedGroups.add("foo");

    // Act
    IsElementAggregated actualIsElementAggregated = new IsElementAggregated(aggregatedGroups);
    boolean actualTestResult = actualIsElementAggregated.test(new Edge("Group"));

    // Assert
    Collection<String> collection = actualIsElementAggregated.aggregatedGroups;
    assertEquals(1, collection.size());
    assertTrue(collection instanceof List);
    assertEquals("foo", ((List<String>) collection).get(0));
    assertFalse(actualTestResult);
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#IsElementAggregated(Collection)}.
   * <p>
   * Method under test: {@link IsElementAggregated#IsElementAggregated(Collection)}
   */
  @Test
  @DisplayName("Test IsElementAggregated new IsElementAggregated(Collection)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IsElementAggregated.<init>(Collection)"})
  void testIsElementAggregatedNewIsElementAggregated2() {
    // Arrange
    ArrayList<String> aggregatedGroups = new ArrayList<>();
    aggregatedGroups.add("42");
    aggregatedGroups.add("foo");

    // Act
    IsElementAggregated actualIsElementAggregated = new IsElementAggregated(aggregatedGroups);
    boolean actualTestResult = actualIsElementAggregated.test(new Edge("Group"));

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
   * <ul>
   *   <li>Then return {@link IsElementAggregated#aggregatedGroups} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link IsElementAggregated#IsElementAggregated(Collection)}
   */
  @Test
  @DisplayName("Test IsElementAggregated new IsElementAggregated(Collection); then return aggregatedGroups Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IsElementAggregated.<init>(Collection)"})
  void testIsElementAggregatedNewIsElementAggregated_thenReturnAggregatedGroupsEmpty() {
    // Arrange and Act
    IsElementAggregated actualIsElementAggregated = new IsElementAggregated(new ArrayList<>());

    // Assert
    Collection<String> collection = actualIsElementAggregated.aggregatedGroups;
    assertTrue(collection instanceof List);
    assertFalse(actualIsElementAggregated.test(new Edge("Group")));
    assertTrue(collection.isEmpty());
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#IsElementAggregated(Schema)}.
   * <ul>
   *   <li>Then return not test {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IsElementAggregated#IsElementAggregated(Schema)}
   */
  @Test
  @DisplayName("Test IsElementAggregated new IsElementAggregated(Schema); then return not test Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IsElementAggregated.<init>(Schema)"})
  void testIsElementAggregatedNewIsElementAggregated_thenReturnNotTestEdgeWithGroup() {
    // Arrange and Act
    IsElementAggregated actualIsElementAggregated = new IsElementAggregated(new Schema());
    Edge element = new Edge("Group");

    // Assert
    Collection<String> collection = actualIsElementAggregated.aggregatedGroups;
    assertTrue(collection instanceof List);
    assertFalse(actualIsElementAggregated.test(element));
    assertTrue(collection.isEmpty());
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#IsElementAggregated(Collection)}.
   * <ul>
   *   <li>Then return not test {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IsElementAggregated#IsElementAggregated(Collection)}
   */
  @Test
  @DisplayName("Test IsElementAggregated new IsElementAggregated(Collection); then return not test 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IsElementAggregated.<init>(Collection)"})
  void testIsElementAggregatedNewIsElementAggregated_thenReturnNotTestNull() {
    // Arrange and Act
    IsElementAggregated actualIsElementAggregated = new IsElementAggregated(new ArrayList<>());

    // Assert
    Collection<String> collection = actualIsElementAggregated.aggregatedGroups;
    assertTrue(collection instanceof List);
    assertFalse(actualIsElementAggregated.test(null));
    assertTrue(collection.isEmpty());
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#IsElementAggregated(Schema)}.
   * <ul>
   *   <li>Then return not test {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IsElementAggregated#IsElementAggregated(Schema)}
   */
  @Test
  @DisplayName("Test IsElementAggregated new IsElementAggregated(Schema); then return not test 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IsElementAggregated.<init>(Schema)"})
  void testIsElementAggregatedNewIsElementAggregated_thenReturnNotTestNull2() {
    // Arrange and Act
    IsElementAggregated actualIsElementAggregated = new IsElementAggregated(new Schema());

    // Assert
    Collection<String> collection = actualIsElementAggregated.aggregatedGroups;
    assertTrue(collection instanceof List);
    assertFalse(actualIsElementAggregated.test(null));
    assertTrue(collection.isEmpty());
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#IsElementAggregated(Collection)}.
   * <ul>
   *   <li>Then return test {@link Edge#Edge(String)} with group is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IsElementAggregated#IsElementAggregated(Collection)}
   */
  @Test
  @DisplayName("Test IsElementAggregated new IsElementAggregated(Collection); then return test Edge(String) with group is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IsElementAggregated.<init>(Collection)"})
  void testIsElementAggregatedNewIsElementAggregated_thenReturnTestEdgeWithGroupIs42() {
    // Arrange
    ArrayList<String> aggregatedGroups = new ArrayList<>();
    aggregatedGroups.add("42");
    aggregatedGroups.add("foo");

    // Act
    IsElementAggregated actualIsElementAggregated = new IsElementAggregated(aggregatedGroups);
    boolean actualTestResult = actualIsElementAggregated.test(new Edge("42"));

    // Assert
    Collection<String> collection = actualIsElementAggregated.aggregatedGroups;
    assertEquals(2, collection.size());
    assertTrue(collection instanceof List);
    assertEquals("42", ((List<String>) collection).get(0));
    assertEquals("foo", ((List<String>) collection).get(1));
    assertTrue(actualTestResult);
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#test(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IsElementAggregated#test(Element)}
   */
  @Test
  @DisplayName("Test IsElementAggregated test(Element) with 'Element'; when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IsElementAggregated.test(Element)"})
  void testIsElementAggregatedTestWithElement_whenEdgeWithGroup() {
    // Arrange
    IsElementAggregated isElementAggregated = new IsElementAggregated(new ArrayList<>());

    // Act and Assert
    assertFalse(isElementAggregated.test(new Edge("Group")));
  }

  /**
   * Test IsElementAggregated {@link IsElementAggregated#test(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IsElementAggregated#test(Element)}
   */
  @Test
  @DisplayName("Test IsElementAggregated test(Element) with 'Element'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean IsElementAggregated.test(Element)"})
  void testIsElementAggregatedTestWithElement_whenNull() {
    // Arrange, Act and Assert
    assertFalse((new IsElementAggregated(new ArrayList<>())).test(null));
  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#PropertiesBinaryOperator(Schema, View)}.
   * <p>
   * Method under test: {@link PropertiesBinaryOperator#PropertiesBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test PropertiesBinaryOperator new PropertiesBinaryOperator(Schema, View)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PropertiesBinaryOperator.<init>(Schema, View)"})
  void testPropertiesBinaryOperatorNewPropertiesBinaryOperator() {
    // Arrange
    Schema schema = new Schema();

    // Act and Assert
    assertNull((new PropertiesBinaryOperator(schema, new View())).apply(null, null));
  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#PropertiesBinaryOperator(Schema, View)}.
   * <p>
   * Method under test: {@link PropertiesBinaryOperator#PropertiesBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test PropertiesBinaryOperator new PropertiesBinaryOperator(Schema, View)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PropertiesBinaryOperator.<init>(Schema, View)"})
  void testPropertiesBinaryOperatorNewPropertiesBinaryOperator2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PropertiesBinaryOperator(null, new View()));

  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#_apply(GroupedProperties, GroupedProperties)} with {@code GroupedProperties}, {@code GroupedProperties}.
   * <p>
   * Method under test: {@link PropertiesBinaryOperator#_apply(GroupedProperties, GroupedProperties)}
   */
  @Test
  @DisplayName("Test PropertiesBinaryOperator _apply(GroupedProperties, GroupedProperties) with 'GroupedProperties', 'GroupedProperties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GroupedProperties PropertiesBinaryOperator._apply(GroupedProperties, GroupedProperties)"})
  void testPropertiesBinaryOperator_applyWithGroupedPropertiesGroupedProperties() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    PropertiesBinaryOperator propertiesBinaryOperator = new PropertiesBinaryOperator(schema, null);
    GroupedProperties a = new GroupedProperties();

    // Act
    GroupedProperties actual_applyResult = propertiesBinaryOperator._apply(a, new GroupedProperties());

    // Assert
    verify(schema).getElement((String) isNull());
    assertSame(a, actual_applyResult);
  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#_apply(GroupedProperties, GroupedProperties)} with {@code GroupedProperties}, {@code GroupedProperties}.
   * <p>
   * Method under test: {@link PropertiesBinaryOperator#_apply(GroupedProperties, GroupedProperties)}
   */
  @Test
  @DisplayName("Test PropertiesBinaryOperator _apply(GroupedProperties, GroupedProperties) with 'GroupedProperties', 'GroupedProperties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GroupedProperties PropertiesBinaryOperator._apply(GroupedProperties, GroupedProperties)"})
  void testPropertiesBinaryOperator_applyWithGroupedPropertiesGroupedProperties2() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());
    PropertiesBinaryOperator propertiesBinaryOperator = new PropertiesBinaryOperator(schema, view);
    GroupedProperties a = new GroupedProperties();

    // Act
    GroupedProperties actual_applyResult = propertiesBinaryOperator._apply(a, new GroupedProperties());

    // Assert
    verify(view).getElement((String) isNull());
    verify(schema).getElement((String) isNull());
    assertSame(a, actual_applyResult);
  }

  /**
   * Test PropertiesBinaryOperator {@link PropertiesBinaryOperator#_apply(GroupedProperties, GroupedProperties)} with {@code GroupedProperties}, {@code GroupedProperties}.
   * <p>
   * Method under test: {@link PropertiesBinaryOperator#_apply(GroupedProperties, GroupedProperties)}
   */
  @Test
  @DisplayName("Test PropertiesBinaryOperator _apply(GroupedProperties, GroupedProperties) with 'GroupedProperties', 'GroupedProperties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GroupedProperties PropertiesBinaryOperator._apply(GroupedProperties, GroupedProperties)"})
  void testPropertiesBinaryOperator_applyWithGroupedPropertiesGroupedProperties3() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    ElementAggregator buildResult = (new Builder()).build();
    when(schemaEdgeDefinition.getQueryAggregator(Mockito.<Set<String>>any(), Mockito.<ElementAggregator>any()))
        .thenReturn(buildResult);
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());
    PropertiesBinaryOperator propertiesBinaryOperator = new PropertiesBinaryOperator(schema, view);
    GroupedProperties a = new GroupedProperties();

    // Act
    GroupedProperties actual_applyResult = propertiesBinaryOperator._apply(a, new GroupedProperties());

    // Assert
    verify(view).getElement((String) isNull());
    verify(schema).getElement((String) isNull());
    verify(schemaEdgeDefinition).getQueryAggregator(isNull(), isNull());
    assertSame(a, actual_applyResult);
  }

  /**
   * Test {@link AggregatorUtil#queryAggregate(Iterable, Schema, View)} with {@code elements}, {@code schema}, {@code view}.
   * <p>
   * Method under test: {@link AggregatorUtil#queryAggregate(Iterable, Schema, View)}
   */
  @Test
  @DisplayName("Test queryAggregate(Iterable, Schema, View) with 'elements', 'schema', 'view'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable AggregatorUtil.queryAggregate(Iterable, Schema, View)"})
  void testQueryAggregateWithElementsSchemaView() {
    // Arrange
    ArrayList<Element> elements = new ArrayList<>();
    Schema schema = new Schema();

    // Act
    Iterable<Element> actualQueryAggregateResult = AggregatorUtil.queryAggregate(elements, schema, new View());
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
   * Test {@link AggregatorUtil#queryAggregate(Iterable, Schema, View, boolean)} with {@code elements}, {@code schema}, {@code view}, {@code includeMatchedVertex}.
   * <p>
   * Method under test: {@link AggregatorUtil#queryAggregate(Iterable, Schema, View, boolean)}
   */
  @Test
  @DisplayName("Test queryAggregate(Iterable, Schema, View, boolean) with 'elements', 'schema', 'view', 'includeMatchedVertex'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable AggregatorUtil.queryAggregate(Iterable, Schema, View, boolean)"})
  void testQueryAggregateWithElementsSchemaViewIncludeMatchedVertex() {
    // Arrange
    ArrayList<Element> elements = new ArrayList<>();
    Schema schema = new Schema();

    // Act
    Iterable<Element> actualQueryAggregateResult = AggregatorUtil.queryAggregate(elements, schema, new View(), true);
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggregatorUtil#getIngestGroupBys(Schema)}
   */
  @Test
  @DisplayName("Test getIngestGroupBys(Schema); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map AggregatorUtil.getIngestGroupBys(Schema)"})
  void testGetIngestGroupBys_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AggregatorUtil.getIngestGroupBys(null));
  }

  /**
   * Test {@link AggregatorUtil#getIngestGroupBys(Schema)}.
   * <ul>
   *   <li>When {@link Schema#Schema()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggregatorUtil#getIngestGroupBys(Schema)}
   */
  @Test
  @DisplayName("Test getIngestGroupBys(Schema); when Schema(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map AggregatorUtil.getIngestGroupBys(Schema)"})
  void testGetIngestGroupBys_whenSchema_thenReturnEmpty() {
    // Arrange and Act
    Map<String, Set<String>> actualIngestGroupBys = AggregatorUtil.getIngestGroupBys(new Schema());

    // Assert
    assertTrue(actualIngestGroupBys.isEmpty());
  }

  /**
   * Test {@link AggregatorUtil#getQueryGroupBys(Schema, View)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggregatorUtil#getQueryGroupBys(Schema, View)}
   */
  @Test
  @DisplayName("Test getQueryGroupBys(Schema, View); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map AggregatorUtil.getQueryGroupBys(Schema, View)"})
  void testGetQueryGroupBys_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AggregatorUtil.getQueryGroupBys(null, new View()));
  }

  /**
   * Test {@link AggregatorUtil#getQueryGroupBys(Schema, View)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggregatorUtil#getQueryGroupBys(Schema, View)}
   */
  @Test
  @DisplayName("Test getQueryGroupBys(Schema, View); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map AggregatorUtil.getQueryGroupBys(Schema, View)"})
  void testGetQueryGroupBys_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AggregatorUtil.getQueryGroupBys(new Schema(), null));
  }

  /**
   * Test {@link AggregatorUtil#getQueryGroupBys(Schema, View)}.
   * <ul>
   *   <li>When {@link Schema#Schema()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggregatorUtil#getQueryGroupBys(Schema, View)}
   */
  @Test
  @DisplayName("Test getQueryGroupBys(Schema, View); when Schema(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map AggregatorUtil.getQueryGroupBys(Schema, View)"})
  void testGetQueryGroupBys_whenSchema_thenReturnEmpty() {
    // Arrange
    Schema schema = new Schema();

    // Act
    Map<String, Set<String>> actualQueryGroupBys = AggregatorUtil.getQueryGroupBys(schema, new View());

    // Assert
    assertTrue(actualQueryGroupBys.isEmpty());
  }

  /**
   * Test {@link AggregatorUtil#getIngestGroupBy(String, Schema)}.
   * <ul>
   *   <li>When {@link Schema#Schema()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggregatorUtil#getIngestGroupBy(String, Schema)}
   */
  @Test
  @DisplayName("Test getIngestGroupBy(String, Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set AggregatorUtil.getIngestGroupBy(String, Schema)"})
  void testGetIngestGroupBy_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AggregatorUtil.getIngestGroupBy("Group", new Schema()));
  }

  /**
   * Test {@link AggregatorUtil#getQueryGroupBy(String, Schema, View)}.
   * <ul>
   *   <li>When {@link Schema#Schema()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggregatorUtil#getQueryGroupBy(String, Schema, View)}
   */
  @Test
  @DisplayName("Test getQueryGroupBy(String, Schema, View); when Schema(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set AggregatorUtil.getQueryGroupBy(String, Schema, View)"})
  void testGetQueryGroupBy_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange
    Schema schema = new Schema();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AggregatorUtil.getQueryGroupBy("Group", schema, new View()));
  }

  /**
   * Test {@link AggregatorUtil#getQueryGroupBy(String, Schema, View)}.
   * <ul>
   *   <li>When {@link Schema#Schema()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AggregatorUtil#getQueryGroupBy(String, Schema, View)}
   */
  @Test
  @DisplayName("Test getQueryGroupBy(String, Schema, View); when Schema(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set AggregatorUtil.getQueryGroupBy(String, Schema, View)"})
  void testGetQueryGroupBy_whenSchema_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> AggregatorUtil.getQueryGroupBy("Group", new Schema(), null));
  }

  /**
   * Test QueryElementBinaryOperator {@link QueryElementBinaryOperator#QueryElementBinaryOperator(Schema, View)}.
   * <p>
   * Method under test: {@link QueryElementBinaryOperator#QueryElementBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test QueryElementBinaryOperator new QueryElementBinaryOperator(Schema, View)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueryElementBinaryOperator.<init>(Schema, View)"})
  void testQueryElementBinaryOperatorNewQueryElementBinaryOperator() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());

    // Act
    QueryElementBinaryOperator actualQueryElementBinaryOperator = new QueryElementBinaryOperator(schema, view);
    Edge edge = new Edge("Group");
    Element actualApplyResult = actualQueryElementBinaryOperator.apply(edge, new Edge("Group"));

    // Assert
    verify(view).getElement(eq("Group"));
    verify(schema).getElement(eq("Group"));
    assertSame(edge, actualApplyResult);
  }

  /**
   * Test QueryElementBinaryOperator {@link QueryElementBinaryOperator#QueryElementBinaryOperator(Schema, View)}.
   * <p>
   * Method under test: {@link QueryElementBinaryOperator#QueryElementBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test QueryElementBinaryOperator new QueryElementBinaryOperator(Schema, View)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueryElementBinaryOperator.<init>(Schema, View)"})
  void testQueryElementBinaryOperatorNewQueryElementBinaryOperator2() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    ElementAggregator buildResult = (new Builder()).build();
    when(schemaEdgeDefinition.getQueryAggregator(Mockito.<Set<String>>any(), Mockito.<ElementAggregator>any()))
        .thenReturn(buildResult);
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());

    // Act
    QueryElementBinaryOperator actualQueryElementBinaryOperator = new QueryElementBinaryOperator(schema, view);
    Edge edge = new Edge("Group");
    Element actualApplyResult = actualQueryElementBinaryOperator.apply(edge, new Edge("Group"));

    // Assert
    verify(view).getElement(eq("Group"));
    verify(schema).getElement(eq("Group"));
    verify(schemaEdgeDefinition).getQueryAggregator(isNull(), isNull());
    assertSame(edge, actualApplyResult);
  }

  /**
   * Test QueryPropertiesBinaryOperator {@link QueryPropertiesBinaryOperator#QueryPropertiesBinaryOperator(Schema, View)}.
   * <p>
   * Method under test: {@link QueryPropertiesBinaryOperator#QueryPropertiesBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test QueryPropertiesBinaryOperator new QueryPropertiesBinaryOperator(Schema, View)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueryPropertiesBinaryOperator.<init>(Schema, View)"})
  void testQueryPropertiesBinaryOperatorNewQueryPropertiesBinaryOperator() {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(new SchemaEdgeDefinition());
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());

    // Act
    QueryPropertiesBinaryOperator actualQueryPropertiesBinaryOperator = new QueryPropertiesBinaryOperator(schema, view);
    GroupedProperties groupedProperties = new GroupedProperties();
    GroupedProperties actualApplyResult = actualQueryPropertiesBinaryOperator.apply(groupedProperties,
        new GroupedProperties());

    // Assert
    verify(view).getElement((String) isNull());
    verify(schema).getElement((String) isNull());
    assertSame(groupedProperties, actualApplyResult);
  }

  /**
   * Test QueryPropertiesBinaryOperator {@link QueryPropertiesBinaryOperator#QueryPropertiesBinaryOperator(Schema, View)}.
   * <p>
   * Method under test: {@link QueryPropertiesBinaryOperator#QueryPropertiesBinaryOperator(Schema, View)}
   */
  @Test
  @DisplayName("Test QueryPropertiesBinaryOperator new QueryPropertiesBinaryOperator(Schema, View)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueryPropertiesBinaryOperator.<init>(Schema, View)"})
  void testQueryPropertiesBinaryOperatorNewQueryPropertiesBinaryOperator2() {
    // Arrange
    SchemaEdgeDefinition schemaEdgeDefinition = mock(SchemaEdgeDefinition.class);
    ElementAggregator buildResult = (new Builder()).build();
    when(schemaEdgeDefinition.getQueryAggregator(Mockito.<Set<String>>any(), Mockito.<ElementAggregator>any()))
        .thenReturn(buildResult);
    Schema schema = mock(Schema.class);
    when(schema.getElement(Mockito.<String>any())).thenReturn(schemaEdgeDefinition);
    View view = mock(View.class);
    when(view.getElement(Mockito.<String>any())).thenReturn(new ViewElementDefinition());

    // Act
    QueryPropertiesBinaryOperator actualQueryPropertiesBinaryOperator = new QueryPropertiesBinaryOperator(schema, view);
    GroupedProperties groupedProperties = new GroupedProperties();
    GroupedProperties actualApplyResult = actualQueryPropertiesBinaryOperator.apply(groupedProperties,
        new GroupedProperties());

    // Assert
    verify(view).getElement((String) isNull());
    verify(schema).getElement((String) isNull());
    verify(schemaEdgeDefinition).getQueryAggregator(isNull(), isNull());
    assertSame(groupedProperties, actualApplyResult);
  }

  /**
   * Test ToElementKey {@link ToElementKey#apply(Element)} with {@code Element}.
   * <p>
   * Method under test: {@link ToElementKey#apply(Element)}
   */
  @Test
  @DisplayName("Test ToElementKey apply(Element) with 'Element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ToElementKey.apply(Element)"})
  void testToElementKeyApplyWithElement() {
    // Arrange
    HashMap<String, Set<String>> groupToGroupBys = new HashMap<>();
    groupToGroupBys.put("Group %s was not recognised", new HashSet<>());
    ToElementKey toElementKey = new ToElementKey(groupToGroupBys);
    Edge element = new Edge("Group %s was not recognised", "Source", "Destination", true);

    // Act
    Element actualApplyResult = toElementKey.apply(element);

    // Assert
    assertTrue(actualApplyResult instanceof Edge);
    assertEquals(element, actualApplyResult);
  }

  /**
   * Test ToElementKey {@link ToElementKey#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToElementKey#apply(Element)}
   */
  @Test
  @DisplayName("Test ToElementKey apply(Element) with 'Element'; given '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ToElementKey.apply(Element)"})
  void testToElementKeyApplyWithElement_given42() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("42");

    HashMap<String, Set<String>> groupToGroupBys = new HashMap<>();
    groupToGroupBys.put("Group %s was not recognised", stringSet);
    ToElementKey toElementKey = new ToElementKey(groupToGroupBys);

    Edge element = new Edge("Group %s was not recognised", "Source", "Destination", true);
    element.putProperty("42", "Value");

    // Act
    Element actualApplyResult = toElementKey.apply(element);

    // Assert
    assertTrue(actualApplyResult instanceof Edge);
    assertEquals(element, actualApplyResult);
  }

  /**
   * Test ToElementKey {@link ToElementKey#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@code Group %s was not recognised}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToElementKey#apply(Element)}
   */
  @Test
  @DisplayName("Test ToElementKey apply(Element) with 'Element'; given 'Group %s was not recognised'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ToElementKey.apply(Element)"})
  void testToElementKeyApplyWithElement_givenGroupSWasNotRecognised() {
    // Arrange
    ToElementKey toElementKey = new ToElementKey(new HashMap<>());
    Entity element = (new Entity.Builder()).group("Group").vertex("Vertex").build();
    element.putProperty("Group %s was not recognised", "Value");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> toElementKey.apply(element));
  }

  /**
   * Test ToElementKey {@link ToElementKey#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToElementKey#apply(Element)}
   */
  @Test
  @DisplayName("Test ToElementKey apply(Element) with 'Element'; given HashSet() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ToElementKey.apply(Element)"})
  void testToElementKeyApplyWithElement_givenHashSetAdd42() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("42");

    HashMap<String, Set<String>> groupToGroupBys = new HashMap<>();
    groupToGroupBys.put("Group %s was not recognised", stringSet);
    ToElementKey toElementKey = new ToElementKey(groupToGroupBys);
    Edge element = new Edge("Group %s was not recognised", "Source", "Destination", true);

    // Act
    Element actualApplyResult = toElementKey.apply(element);

    // Assert
    assertTrue(actualApplyResult instanceof Edge);
    assertEquals(element, actualApplyResult);
  }

  /**
   * Test ToElementKey {@link ToElementKey#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToElementKey#apply(Element)}
   */
  @Test
  @DisplayName("Test ToElementKey apply(Element) with 'Element'; when Edge(String) with 'Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element ToElementKey.apply(Element)"})
  void testToElementKeyApplyWithElement_whenEdgeWithGroup() {
    // Arrange
    ToElementKey toElementKey = new ToElementKey(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> toElementKey.apply(new Edge("Group")));
  }
}
