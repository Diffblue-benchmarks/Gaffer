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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class ElementDiffblueTest {
  /**
   * Test {@link Element#putProperty(String, Object)}.
   * <p>
   * Method under test: {@link Element#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Element.putProperty(String, Object)"})
  void testPutProperty() {
    // Arrange
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));

    // Act
    lazyEdge.putProperty("Name", "Value");

    // Assert
    Properties properties = lazyEdge.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
    LazyProperties properties2 = lazyEdge.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get((Object) "Name"));
  }

  /**
   * Test {@link Element#putProperty(String, Object)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()} Properties is {@link Properties#Properties()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Edge#Edge()} Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object); given Edge() Properties is Properties(); when 'null'; then Edge() Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Element.putProperty(String, Object)"})
  void testPutProperty_givenEdgePropertiesIsProperties_whenNull_thenEdgePropertiesEmpty() {
    // Arrange
    Edge edge = new Edge();
    Properties properties = new Properties();
    edge.setProperties(properties);

    // Act
    edge.putProperty(null, null);

    // Assert that nothing has changed
    Properties properties2 = edge.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Test {@link Element#putProperty(String, Object)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()} Properties is {@link Properties#Properties()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Edge#Edge()} Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object); given Edge() Properties is Properties(); when 'null'; then Edge() Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Element.putProperty(String, Object)"})
  void testPutProperty_givenEdgePropertiesIsProperties_whenNull_thenEdgePropertiesEmpty2() {
    // Arrange
    Edge edge = new Edge();
    Properties properties = new Properties();
    edge.setProperties(properties);

    // Act
    edge.putProperty("Name", null);

    // Assert that nothing has changed
    Properties properties2 = edge.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Test {@link Element#putProperty(String, Object)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>When {@code Value}.</li>
   *   <li>Then {@link Edge#Edge()} Properties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#putProperty(String, Object)}
   */
  @Test
  @DisplayName("Test putProperty(String, Object); given Edge(); when 'Value'; then Edge() Properties size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Element.putProperty(String, Object)"})
  void testPutProperty_givenEdge_whenValue_thenEdgePropertiesSizeIsOne() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putProperty("Name", "Value");

    // Assert
    Properties properties = edge.getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
  }

  /**
   * Test {@link Element#copyProperties(Properties)}.
   * <p>
   * Method under test: {@link Element#copyProperties(Properties)}
   */
  @Test
  @DisplayName("Test copyProperties(Properties)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Element.copyProperties(Properties)"})
  void testCopyProperties() {
    // Arrange
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class));
    lazyEdge.putIdentifier(IdentifierType.SOURCE, "Value");

    Properties properties = new Properties();
    properties.put("Name", "Value");

    // Act
    lazyEdge.copyProperties(properties);

    // Assert
    LazyProperties properties2 = lazyEdge.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get((Object) "Name"));
    assertEquals(properties, lazyEdge.getElement().getProperties());
  }

  /**
   * Test {@link Element#copyProperties(Properties)}.
   * <p>
   * Method under test: {@link Element#copyProperties(Properties)}
   */
  @Test
  @DisplayName("Test copyProperties(Properties)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Element.copyProperties(Properties)"})
  void testCopyProperties2() {
    // Arrange
    LazyProperties lazyProperties = mock(LazyProperties.class);
    when(lazyProperties.put(Mockito.<String>any(), Mockito.<Object>any())).thenReturn("Put");
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    LazyEdge lazyEdge = new LazyEdge(edge, mock(ElementValueLoader.class), lazyProperties);
    lazyEdge.putIdentifier(IdentifierType.SOURCE, "Value");

    Properties properties = new Properties();
    properties.put("Name", "Value");

    // Act
    lazyEdge.copyProperties(properties);

    // Assert that nothing has changed
    verify(lazyProperties).put(eq("Name"), isA(Object.class));
    assertTrue(lazyEdge.getElement().getProperties().isEmpty());
  }

  /**
   * Test {@link Element#copyProperties(Properties)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()} Properties is {@link Properties#Properties()}.</li>
   *   <li>Then {@link Edge#Edge()} Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#copyProperties(Properties)}
   */
  @Test
  @DisplayName("Test copyProperties(Properties); given Edge() Properties is Properties(); then Edge() Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Element.copyProperties(Properties)"})
  void testCopyProperties_givenEdgePropertiesIsProperties_thenEdgePropertiesEmpty() {
    // Arrange
    Edge edge = new Edge();
    Properties properties = new Properties();
    edge.setProperties(properties);

    // Act
    edge.copyProperties(null);

    // Assert that nothing has changed
    Properties properties2 = edge.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Test {@link Element#copyProperties(Properties)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>Then {@link Edge#Edge()} Properties is {@link Properties#Properties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#copyProperties(Properties)}
   */
  @Test
  @DisplayName("Test copyProperties(Properties); given Edge(); then Edge() Properties is Properties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Element.copyProperties(Properties)"})
  void testCopyProperties_givenEdge_thenEdgePropertiesIsProperties() {
    // Arrange
    Edge edge = new Edge();

    Properties properties = new Properties();
    properties.put("Name", "Value");

    // Act
    edge.copyProperties(properties);

    // Assert
    assertEquals(properties, edge.getProperties());
  }

  /**
   * Test {@link Element#copyProperties(Properties)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>When {@link Properties#Properties()}.</li>
   *   <li>Then {@link Edge#Edge()} Properties is {@link Properties#Properties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#copyProperties(Properties)}
   */
  @Test
  @DisplayName("Test copyProperties(Properties); given Edge(); when Properties(); then Edge() Properties is Properties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Element.copyProperties(Properties)"})
  void testCopyProperties_givenEdge_whenProperties_thenEdgePropertiesIsProperties() {
    // Arrange
    Edge edge = new Edge();
    Properties properties = new Properties();

    // Act
    edge.copyProperties(properties);

    // Assert that nothing has changed
    assertEquals(properties, edge.getProperties());
  }

  /**
   * Test {@link Element#getProperty(String)}.
   * <p>
   * Method under test: {@link Element#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Element.getProperty(String)"})
  void testGetProperty() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any())).thenReturn("Property");
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    LazyEdge lazyEdge = new LazyEdge(edge, valueLoader);

    // Act
    Object actualProperty = lazyEdge.getProperty("Name");

    // Assert
    verify(valueLoader).getProperty(eq("Name"), isA(Properties.class));
    Properties properties = lazyEdge.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Property", properties.get("Name"));
    assertEquals("Property", actualProperty);
    LazyProperties properties2 = lazyEdge.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Property", properties2.get((Object) "Name"));
  }

  /**
   * Test {@link Element#getProperty(String)}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String); given Edge(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Element.getProperty(String)"})
  void testGetProperty_givenEdge_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Edge()).getProperty("Name"));
  }

  /**
   * Test {@link Element#getProperties()}.
   * <p>
   * Method under test: {@link Element#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Properties Element.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue((new Edge()).getProperties().isEmpty());
  }

  /**
   * Test {@link Element#removeProperty(String)}.
   * <p>
   * Method under test: {@link Element#removeProperty(String)}
   */
  @Test
  @DisplayName("Test removeProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object Element.removeProperty(String)"})
  void testRemoveProperty() {
    // Arrange, Act and Assert
    assertNull((new Edge()).removeProperty("Prop Name"));
  }

  /**
   * Test {@link Element#getGroup()}.
   * <p>
   * Method under test: {@link Element#getGroup()}
   */
  @Test
  @DisplayName("Test getGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Element.getGroup()"})
  void testGetGroup() {
    // Arrange, Act and Assert
    assertEquals(Element.DEFAULT_GROUP, (new Edge()).getGroup());
  }

  /**
   * Test {@link Element#shallowEquals(Element)} with {@code element}.
   * <p>
   * Method under test: {@link Element#shallowEquals(Element)}
   */
  @Test
  @DisplayName("Test shallowEquals(Element) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.shallowEquals(Element)"})
  void testShallowEqualsWithElement() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertFalse(buildResult.shallowEquals(new Edge()));
  }

  /**
   * Test {@link Element#shallowEquals(Element)} with {@code element}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#shallowEquals(Element)}
   */
  @Test
  @DisplayName("Test shallowEquals(Element) with 'element'; given Edge(); when Edge(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.shallowEquals(Element)"})
  void testShallowEqualsWithElement_givenEdge_whenEdge_thenReturnTrue() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertTrue(edge.shallowEquals(new Edge()));
  }

  /**
   * Test {@link Element#shallowEquals(Element)} with {@code element}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#shallowEquals(Element)}
   */
  @Test
  @DisplayName("Test shallowEquals(Element) with 'element'; given Edge(); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.shallowEquals(Element)"})
  void testShallowEqualsWithElement_givenEdge_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Edge()).shallowEquals((Element) null));
  }

  /**
   * Test {@link Element#shallowEquals(Object)} with {@code obj}.
   * <p>
   * Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  @DisplayName("Test shallowEquals(Object) with 'obj'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.shallowEquals(Object)"})
  void testShallowEqualsWithObj() {
    // Arrange
    Edge edge = new Edge();
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertFalse(edge.shallowEquals((Object) buildResult));
  }

  /**
   * Test {@link Element#shallowEquals(Object)} with {@code obj}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  @DisplayName("Test shallowEquals(Object) with 'obj'; when Edge(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.shallowEquals(Object)"})
  void testShallowEqualsWithObj_whenEdge_thenReturnTrue() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertTrue(edge.shallowEquals((Object) new Edge()));
  }

  /**
   * Test {@link Element#shallowEquals(Object)} with {@code obj}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  @DisplayName("Test shallowEquals(Object) with 'obj'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.shallowEquals(Object)"})
  void testShallowEqualsWithObj_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Edge()).shallowEquals((Object) null));
  }

  /**
   * Test {@link Element#shallowEquals(Object)} with {@code obj}.
   * <ul>
   *   <li>When {@code Obj}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  @DisplayName("Test shallowEquals(Object) with 'obj'; when 'Obj'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.shallowEquals(Object)"})
  void testShallowEqualsWithObj_whenObj_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Edge()).shallowEquals("Obj"));
  }

  /**
   * Test {@link Element#equals(Object)}, and {@link Element#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.equals(Object)", "int Element.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Edge edge = new Edge();
    Edge edge2 = new Edge();

    // Act and Assert
    assertEquals(edge, edge2);
    int expectedHashCodeResult = edge.hashCode();
    assertEquals(expectedHashCodeResult, edge2.hashCode());
  }

  /**
   * Test {@link Element#equals(Object)}, and {@link Element#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.equals(Object)", "int Element.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertEquals(edge, edge);
    int expectedHashCodeResult = edge.hashCode();
    assertEquals(expectedHashCodeResult, edge.hashCode());
  }

  /**
   * Test {@link Element#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.equals(Object)", "int Element.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, new Edge());
  }

  /**
   * Test {@link Element#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.equals(Object)", "int Element.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Edge edge = new Edge();
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge2 = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertNotEquals(edge, new LazyEdge(edge2, valueLoader));
  }

  /**
   * Test {@link Element#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.equals(Object)", "int Element.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Edge(), null);
  }

  /**
   * Test {@link Element#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Element.equals(Object)", "int Element.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Edge(), "Different type to Element");
  }

  /**
   * Test {@link Element#toString()}.
   * <p>
   * Method under test: {@link Element#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Element.toString()"})
  void testToString() {
    // Arrange
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act and Assert
    assertEquals("Edge[source=Source,destination=Dest,directed=true,matchedVertex=SOURCE,group=Group,properties"
        + "=Properties[]]", buildResult.toString());
  }

  /**
   * Test {@link Element#toString()}.
   * <p>
   * Method under test: {@link Element#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Element.toString()"})
  void testToString2() {
    // Arrange
    Edge edge = new Edge();
    edge.putProperty("source", "Value");

    // Act and Assert
    assertEquals("Edge[directed=false,group=UNKNOWN,properties=Properties[source=<java.lang.String>Value]]",
        edge.toString());
  }

  /**
   * Test {@link Element#toString()}.
   * <ul>
   *   <li>Given {@link Edge#Edge()} Property {@code destination} is {@code Value}.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#toString()}
   */
  @Test
  @DisplayName("Test toString(); given Edge() Property 'destination' is 'Value'; then return a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Element.toString()"})
  void testToString_givenEdgePropertyDestinationIsValue_thenReturnAString() {
    // Arrange
    Edge edge = new Edge();
    edge.putProperty("destination", "Value");
    edge.putProperty("source", "Value");

    // Act and Assert
    assertEquals("Edge[directed=false,group=UNKNOWN,properties=Properties[destination=<java.lang.String>Value,source="
        + "<java.lang.String>Value]]", edge.toString());
  }

  /**
   * Test {@link Element#toString()}.
   * <ul>
   *   <li>Then return {@code Edge[directed=false,group=UNKNOWN,properties=Properties[]]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Edge[directed=false,group=UNKNOWN,properties=Properties[]]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Element.toString()"})
  void testToString_thenReturnEdgeDirectedFalseGroupUnknownPropertiesProperties() {
    // Arrange, Act and Assert
    assertEquals("Edge[directed=false,group=UNKNOWN,properties=Properties[]]", (new Edge()).toString());
  }

  /**
   * Test {@link Element#shallowClone()}.
   * <p>
   * Method under test: {@link Element#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element Element.shallowClone()"})
  void testShallowClone() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyProperties lazyProperties = mock(LazyProperties.class);
    when(lazyProperties.clone()).thenReturn(mock(LazyProperties.class));
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Edge actualShallowCloneResult = (new LazyEdge(edge, valueLoader, lazyProperties)).shallowClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(lazyProperties).clone();
    assertTrue(actualShallowCloneResult instanceof Edge);
    assertEquals("Dest", ((Edge) actualShallowCloneResult).getDestination());
    assertEquals("Dest", ((Edge) actualShallowCloneResult).getAdjacentMatchedVertexValue());
    assertEquals("Source", ((Edge) actualShallowCloneResult).getSource());
    assertEquals(DirectedType.DIRECTED, ((Edge) actualShallowCloneResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) actualShallowCloneResult).getMatchedVertex());
    assertFalse(((Edge) actualShallowCloneResult).isUndirected());
    assertTrue(((Edge) actualShallowCloneResult).isDirected());
  }

  /**
   * Test {@link Element#shallowClone()}.
   * <p>
   * Method under test: {@link Element#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element Element.shallowClone()"})
  void testShallowClone2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyProperties lazyProperties = mock(LazyProperties.class);
    when(lazyProperties.clone()).thenReturn(mock(LazyProperties.class));

    Builder builder = new Builder();

    Builder builder2 = new Builder();
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge buildResult2 = builder2.dest(buildResult)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge edge = builder.dest(buildResult2)
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Edge actualShallowCloneResult = (new LazyEdge(edge, valueLoader, lazyProperties)).shallowClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(lazyProperties).clone();
    assertTrue(actualShallowCloneResult instanceof Edge);
    Object adjacentMatchedVertexValue = ((Edge) actualShallowCloneResult).getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue instanceof Edge);
    Object adjacentMatchedVertexValue2 = ((Edge) adjacentMatchedVertexValue).getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue2 instanceof Edge);
    assertEquals("Dest", ((Edge) adjacentMatchedVertexValue2).getDestination());
    assertEquals("Dest", ((Edge) adjacentMatchedVertexValue2).getAdjacentMatchedVertexValue());
    assertEquals("Group", ((Edge) adjacentMatchedVertexValue2).getGroup());
    assertEquals("Source", ((Edge) adjacentMatchedVertexValue2).getSource());
    assertEquals("Source", ((Edge) adjacentMatchedVertexValue2).getMatchedVertexValue());
    assertEquals(DirectedType.DIRECTED, ((Edge) adjacentMatchedVertexValue2).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) adjacentMatchedVertexValue2).getMatchedVertex());
    assertFalse(((Edge) adjacentMatchedVertexValue2).isUndirected());
    assertTrue(((Edge) adjacentMatchedVertexValue2).isDirected());
    assertEquals(((Edge) adjacentMatchedVertexValue2).getProperties(),
        ((Edge) adjacentMatchedVertexValue2).getProperties());
  }

  /**
   * Test {@link Element#shallowClone()}.
   * <ul>
   *   <li>Given {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given Edge(); then return Edge()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element Element.shallowClone()"})
  void testShallowClone_givenEdge_thenReturnEdge() {
    // Arrange
    Edge edge = new Edge();

    // Act
    Edge actualShallowCloneResult = edge.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof Edge);
    assertEquals(edge, actualShallowCloneResult);
  }

  /**
   * Test {@link Element#shallowClone()}.
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue Destination is {@code Dest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return AdjacentMatchedVertexValue Destination is 'Dest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element Element.shallowClone()"})
  void testShallowClone_thenReturnAdjacentMatchedVertexValueDestinationIsDest() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyProperties lazyProperties = mock(LazyProperties.class);
    when(lazyProperties.clone()).thenReturn(mock(LazyProperties.class));

    Builder builder = new Builder();
    Edge buildResult = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge edge = builder.dest(buildResult)
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Edge actualShallowCloneResult = (new LazyEdge(edge, valueLoader, lazyProperties)).shallowClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(lazyProperties).clone();
    assertTrue(actualShallowCloneResult instanceof Edge);
    Object adjacentMatchedVertexValue = ((Edge) actualShallowCloneResult).getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue instanceof Edge);
    assertEquals("Dest", ((Edge) adjacentMatchedVertexValue).getDestination());
    assertEquals("Dest", ((Edge) adjacentMatchedVertexValue).getAdjacentMatchedVertexValue());
  }

  /**
   * Test {@link Element#shallowClone()}.
   * <ul>
   *   <li>Then return AdjacentMatchedVertexValue Destination is {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return AdjacentMatchedVertexValue Destination is Edge()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element Element.shallowClone()"})
  void testShallowClone_thenReturnAdjacentMatchedVertexValueDestinationIsEdge() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyProperties lazyProperties = mock(LazyProperties.class);
    when(lazyProperties.clone()).thenReturn(mock(LazyProperties.class));

    Builder builder = new Builder();

    Builder builder2 = new Builder();
    Edge edge = new Edge();
    Edge buildResult = builder2.dest(edge)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge edge2 = builder.dest(buildResult)
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Edge actualShallowCloneResult = (new LazyEdge(edge2, valueLoader, lazyProperties)).shallowClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(lazyProperties).clone();
    assertTrue(actualShallowCloneResult instanceof Edge);
    Object adjacentMatchedVertexValue = ((Edge) actualShallowCloneResult).getAdjacentMatchedVertexValue();
    assertTrue(adjacentMatchedVertexValue instanceof Edge);
    assertSame(edge, ((Edge) adjacentMatchedVertexValue).getDestination());
    assertSame(edge, ((Edge) adjacentMatchedVertexValue).getAdjacentMatchedVertexValue());
  }

  /**
   * Test {@link Element#shallowClone()}.
   * <ul>
   *   <li>Then return Destination is {@code Source}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Destination is 'Source'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element Element.shallowClone()"})
  void testShallowClone_thenReturnDestinationIsSource() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    LazyProperties lazyProperties = mock(LazyProperties.class);
    when(lazyProperties.clone()).thenReturn(mock(LazyProperties.class));

    Builder builder = new Builder();
    Edge buildResult = (new Builder()).dest(null)
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    Edge edge = builder.dest(buildResult)
        .directed(false)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Edge actualShallowCloneResult = (new LazyEdge(edge, valueLoader, lazyProperties)).shallowClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    verify(lazyProperties).clone();
    assertTrue(actualShallowCloneResult instanceof Edge);
    assertEquals("Source", ((Edge) actualShallowCloneResult).getDestination());
    assertEquals(DirectedType.UNDIRECTED, ((Edge) actualShallowCloneResult).getDirectedType());
    assertEquals(MatchedVertex.DESTINATION, ((Edge) actualShallowCloneResult).getMatchedVertex());
    assertFalse(((Edge) actualShallowCloneResult).isDirected());
    assertTrue(((Edge) actualShallowCloneResult).isUndirected());
  }

  /**
   * Test {@link Element#shallowClone()}.
   * <ul>
   *   <li>Then return Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Element#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element Element.shallowClone()"})
  void testShallowClone_thenReturnPropertiesEmpty() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    doNothing().when(valueLoader).loadIdentifiers(Mockito.<Element>any());
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    // Act
    Edge actualShallowCloneResult = (new LazyEdge(edge, valueLoader)).shallowClone();

    // Assert
    verify(valueLoader).loadIdentifiers(isA(Element.class));
    assertTrue(actualShallowCloneResult instanceof Edge);
    assertEquals("Dest", ((Edge) actualShallowCloneResult).getDestination());
    assertEquals("Dest", ((Edge) actualShallowCloneResult).getAdjacentMatchedVertexValue());
    assertEquals("Source", ((Edge) actualShallowCloneResult).getSource());
    assertEquals(DirectedType.DIRECTED, ((Edge) actualShallowCloneResult).getDirectedType());
    assertEquals(MatchedVertex.SOURCE, ((Edge) actualShallowCloneResult).getMatchedVertex());
    assertFalse(((Edge) actualShallowCloneResult).isUndirected());
    assertTrue(actualShallowCloneResult.getProperties().isEmpty());
    assertTrue(((Edge) actualShallowCloneResult).isDirected());
  }

  /**
   * Test {@link Element#getElement()}.
   * <p>
   * Method under test: {@link Element#getElement()}
   */
  @Test
  @DisplayName("Test getElement()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Element Element.getElement()"})
  void testGetElement() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertSame(edge, edge.getElement());
  }

  /**
   * Test {@link Element#setGroup(String)}.
   * <p>
   * Method under test: {@link Element#setGroup(String)}
   */
  @Test
  @DisplayName("Test setGroup(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Element.setGroup(String)"})
  void testSetGroup() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setGroup("Group");

    // Assert
    assertEquals("Group", edge.getGroup());
  }

  /**
   * Test {@link Element#setProperties(Properties)}.
   * <p>
   * Method under test: {@link Element#setProperties(Properties)}
   */
  @Test
  @DisplayName("Test setProperties(Properties)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Element.setProperties(Properties)"})
  void testSetProperties() {
    // Arrange
    Edge edge = new Edge();
    Properties properties = new Properties();

    // Act
    edge.setProperties(properties);

    // Assert
    assertSame(properties, edge.getProperties());
  }
}
