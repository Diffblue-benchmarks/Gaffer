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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Edge.Builder;
import uk.gov.gchq.gaffer.data.element.id.EdgeId;
import uk.gov.gchq.gaffer.data.element.id.EdgeId.MatchedVertex;

class ElementTupleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementTuple#ElementTuple()}
   *   <li>{@link ElementTuple#setElement(Element)}
   *   <li>{@link ElementTuple#toString()}
   *   <li>{@link ElementTuple#getElement()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementTuple.<init>()", "void ElementTuple.<init>(Element)",
      "Element ElementTuple.getElement()", "void ElementTuple.setElement(Element)", "String ElementTuple.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ElementTuple actualElementTuple = new ElementTuple();
    Edge element = new Edge();
    actualElementTuple.setElement(element);
    String actualToStringResult = actualElementTuple.toString();

    // Assert
    assertEquals("ElementTuple[element=Edge[directed=false,group=UNKNOWN,properties=Properties[]]]",
        actualToStringResult);
    assertSame(element, actualElementTuple.getElement());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementTuple#ElementTuple(Element)}
   *   <li>{@link ElementTuple#setElement(Element)}
   *   <li>{@link ElementTuple#toString()}
   *   <li>{@link ElementTuple#getElement()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Edge()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementTuple.<init>()", "void ElementTuple.<init>(Element)",
      "Element ElementTuple.getElement()", "void ElementTuple.setElement(Element)", "String ElementTuple.toString()"})
  void testGettersAndSetters_whenEdge() {
    // Arrange and Act
    ElementTuple actualElementTuple = new ElementTuple(new Edge());
    Edge element = new Edge();
    actualElementTuple.setElement(element);
    String actualToStringResult = actualElementTuple.toString();

    // Assert
    assertEquals("ElementTuple[element=Edge[directed=false,group=UNKNOWN,properties=Properties[]]]",
        actualToStringResult);
    assertSame(element, actualElementTuple.getElement());
  }

  /**
   * Test {@link ElementTuple#get(String)} with {@code String}.
   * <p>
   * Method under test: {@link ElementTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ElementTuple.get(String)"})
  void testGetWithString() {
    // Arrange
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    ElementTuple elementTuple = new ElementTuple(new LazyEdge(edge, mock(ElementValueLoader.class)));

    // Act
    Object actualGetResult = elementTuple.get(ElementTuple.PROPERTIES);

    // Assert
    assertTrue(actualGetResult instanceof Map);
    Element element = elementTuple.getElement();
    assertTrue(element instanceof LazyEdge);
    assertTrue(element.getElement().getProperties().isEmpty());
    assertTrue(((Map<Object, Object>) actualGetResult).isEmpty());
  }

  /**
   * Test {@link ElementTuple#get(String)} with {@code String}.
   * <p>
   * Method under test: {@link ElementTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ElementTuple.get(String)"})
  void testGetWithString2() {
    // Arrange
    ElementValueLoader valueLoader = mock(ElementValueLoader.class);
    when(valueLoader.getProperty(Mockito.<String>any(), Mockito.<Properties>any())).thenReturn("Property");
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();
    ElementTuple elementTuple = new ElementTuple(new LazyEdge(edge, valueLoader));

    // Act
    Object actualGetResult = elementTuple.get("Reference");

    // Assert
    verify(valueLoader).getProperty(eq("Reference"), isA(Properties.class));
    Element element = elementTuple.getElement();
    assertTrue(element instanceof LazyEdge);
    Properties properties = element.getElement().getProperties();
    assertEquals(1, properties.size());
    assertEquals("Property", properties.get("Reference"));
    Properties properties2 = element.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Property", properties2.get("Reference"));
    assertEquals("Property", actualGetResult);
  }

  /**
   * Test {@link ElementTuple#get(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link ElementTuple#ElementTuple(Element)} with element is {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Map}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; given ElementTuple(Element) with element is Edge(); then return Map")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ElementTuple.get(String)"})
  void testGetWithString_givenElementTupleWithElementIsEdge_thenReturnMap() {
    // Arrange and Act
    Object actualGetResult = (new ElementTuple(new Edge())).get(ElementTuple.PROPERTIES);

    // Assert
    assertTrue(actualGetResult instanceof Map);
    assertTrue(((Map<Object, Object>) actualGetResult).isEmpty());
  }

  /**
   * Test {@link ElementTuple#get(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link ElementTuple#ElementTuple(Element)} with element is {@link Edge#Edge()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; given ElementTuple(Element) with element is Edge(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ElementTuple.get(String)"})
  void testGetWithString_givenElementTupleWithElementIsEdge_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ElementTuple(new Edge())).get("Reference"));
  }

  /**
   * Test {@link ElementTuple#get(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link ElementTuple#ElementTuple()}.</li>
   *   <li>When {@link ElementTuple#ELEMENT}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; given ElementTuple(); when ELEMENT; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ElementTuple.get(String)"})
  void testGetWithString_givenElementTuple_whenElement_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ElementTuple()).get(ElementTuple.ELEMENT));
  }

  /**
   * Test {@link ElementTuple#get(String)} with {@code String}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ElementTuple.get(String)"})
  void testGetWithString_thenReturnValue() {
    // Arrange
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    ElementTuple elementTuple = new ElementTuple(new LazyEdge(edge, mock(ElementValueLoader.class)));
    elementTuple.put("Reference", "Value");

    // Act
    Object actualGetResult = elementTuple.get("Reference");

    // Assert
    Element element = elementTuple.getElement();
    assertTrue(element instanceof LazyEdge);
    assertEquals("Value", actualGetResult);
    Properties properties = element.getProperties();
    assertEquals(1, properties.size());
    assertTrue(properties.containsKey("Reference"));
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then {@link ElementTuple#ElementTuple()} Element Properties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; given HashSet(); then ElementTuple() Element Properties size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject_givenHashSet_thenElementTupleElementPropertiesSizeIsOne() {
    // Arrange
    Edge element = new Edge();
    Properties properties = new Properties();
    element.setProperties(properties);

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);
    LazyProperties lazyProperties = mock(LazyProperties.class);
    when(lazyProperties.entrySet()).thenReturn(new HashSet<>());

    // Act
    elementTuple.put(ElementTuple.PROPERTIES, lazyProperties);

    // Assert
    verify(lazyProperties).entrySet();
    Element element2 = elementTuple.getElement();
    assertTrue(element2 instanceof Edge);
    Properties properties2 = element2.getProperties();
    assertEquals(1, properties2.size());
    assertSame(properties, properties2);
    assertSame(lazyProperties, properties2.get(ElementTuple.PROPERTIES));
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   * <ul>
   *   <li>Then {@link ElementTuple#ElementTuple()} Element Element Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; then ElementTuple() Element Element Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject_thenElementTupleElementElementPropertiesEmpty() {
    // Arrange
    LazyProperties lazyProperties = mock(LazyProperties.class);
    when(lazyProperties.put(Mockito.<String>any(), Mockito.<Object>any())).thenReturn("Put");
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    LazyEdge element = new LazyEdge(edge, mock(ElementValueLoader.class), lazyProperties);
    element.putIdentifier(IdentifierType.SOURCE, "Value");
    element.setProperties(new Properties());

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);
    LazyProperties lazyProperties2 = mock(LazyProperties.class);
    when(lazyProperties2.entrySet()).thenReturn(new HashSet<>());

    // Act
    elementTuple.put(ElementTuple.PROPERTIES, lazyProperties2);

    // Assert that nothing has changed
    verify(lazyProperties2).entrySet();
    verify(lazyProperties).put(eq("PROPERTIES"), isA(Object.class));
    Element element2 = elementTuple.getElement();
    assertTrue(element2 instanceof LazyEdge);
    assertTrue(element2.getElement().getProperties().isEmpty());
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   * <ul>
   *   <li>Then {@link ElementTuple#ElementTuple()} Element Element Properties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; then ElementTuple() Element Element Properties size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject_thenElementTupleElementElementPropertiesSizeIsOne() {
    // Arrange
    Edge edge = (new Builder()).dest("Dest")
        .directed(true)
        .group("Group")
        .matchedVertex(MatchedVertex.SOURCE)
        .source("Source")
        .build();

    LazyEdge element = new LazyEdge(edge, mock(ElementValueLoader.class));
    element.putIdentifier(IdentifierType.SOURCE, "Value");
    element.setProperties(new Properties());

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);
    LazyProperties lazyProperties = mock(LazyProperties.class);
    when(lazyProperties.entrySet()).thenReturn(new HashSet<>());

    // Act
    elementTuple.put(ElementTuple.PROPERTIES, lazyProperties);

    // Assert
    verify(lazyProperties).entrySet();
    Element element2 = elementTuple.getElement();
    assertTrue(element2 instanceof LazyEdge);
    Properties properties = element2.getElement().getProperties();
    assertEquals(1, properties.size());
    Properties properties2 = element2.getProperties();
    assertEquals(1, properties2.size());
    assertSame(lazyProperties, properties.get(ElementTuple.PROPERTIES));
    assertSame(lazyProperties, properties2.get(ElementTuple.PROPERTIES));
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   * <ul>
   *   <li>Then {@link ElementTuple#ElementTuple()} Element Properties {@code Reference} is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; then ElementTuple() Element Properties 'Reference' is 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject_thenElementTupleElementPropertiesReferenceIsValue() {
    // Arrange
    Edge element = new Edge();
    Properties properties = new Properties();
    element.setProperties(properties);

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);

    // Act
    elementTuple.put("Reference", "Value");

    // Assert
    Element element2 = elementTuple.getElement();
    assertTrue(element2 instanceof Edge);
    Properties properties2 = element2.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get("Reference"));
    assertSame(properties, properties2);
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   * <ul>
   *   <li>Then {@link ElementTuple#ElementTuple()} Element Properties size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; then ElementTuple() Element Properties size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject_thenElementTupleElementPropertiesSizeIsTwo() {
    // Arrange
    Edge element = new Edge();
    element.setProperties(new Properties());

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);

    HashSet<Entry<String, Object>> entrySet = new HashSet<>();
    entrySet.add(new SimpleEntry<>(ElementTuple.ELEMENT, "42"));
    LazyProperties lazyProperties = mock(LazyProperties.class);
    when(lazyProperties.entrySet()).thenReturn(entrySet);

    // Act
    elementTuple.put(ElementTuple.PROPERTIES, lazyProperties);

    // Assert
    verify(lazyProperties).entrySet();
    Element element2 = elementTuple.getElement();
    assertTrue(element2 instanceof Edge);
    Properties properties = element2.getProperties();
    assertEquals(2, properties.size());
    assertEquals("42", properties.get(ElementTuple.ELEMENT));
    assertSame(lazyProperties, properties.get(ElementTuple.PROPERTIES));
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   * <ul>
   *   <li>When {@link ElementTuple#ELEMENT}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; when ELEMENT; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject_whenElement_thenThrowIllegalArgumentException() {
    // Arrange
    Edge element = new Edge();
    element.setProperties(new Properties());

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> elementTuple.put(ElementTuple.ELEMENT, null));
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ElementTuple#ElementTuple()} Element Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; when 'null'; then ElementTuple() Element Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject_whenNull_thenElementTupleElementPropertiesEmpty() {
    // Arrange
    Edge element = new Edge();
    Properties properties = new Properties();
    element.setProperties(properties);

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);

    // Act
    elementTuple.put(ElementTuple.PROPERTIES, null);

    // Assert that nothing has changed
    Element element2 = elementTuple.getElement();
    assertTrue(element2 instanceof Edge);
    Properties properties2 = element2.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Test {@link ElementTuple#put(String, Object)} with {@code String}, {@code Object}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ElementTuple#ElementTuple()} Element Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object) with 'String', 'Object'; when 'null'; then ElementTuple() Element Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ElementTuple.put(String, Object)"})
  void testPutWithStringObject_whenNull_thenElementTupleElementPropertiesEmpty2() {
    // Arrange
    Edge element = new Edge();
    Properties properties = new Properties();
    element.setProperties(properties);

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);

    // Act
    elementTuple.put(null, null);

    // Assert that nothing has changed
    Element element2 = elementTuple.getElement();
    assertTrue(element2 instanceof Edge);
    Properties properties2 = element2.getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Test {@link ElementTuple#equals(Object)}, and {@link ElementTuple#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementTuple#equals(Object)}
   *   <li>{@link ElementTuple#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementTuple.equals(Object)", "int ElementTuple.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementTuple elementTuple = new ElementTuple();
    ElementTuple elementTuple2 = new ElementTuple();

    // Act and Assert
    assertEquals(elementTuple, elementTuple2);
    int expectedHashCodeResult = elementTuple.hashCode();
    assertEquals(expectedHashCodeResult, elementTuple2.hashCode());
  }

  /**
   * Test {@link ElementTuple#equals(Object)}, and {@link ElementTuple#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ElementTuple#equals(Object)}
   *   <li>{@link ElementTuple#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementTuple.equals(Object)", "int ElementTuple.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementTuple elementTuple = new ElementTuple();

    // Act and Assert
    assertEquals(elementTuple, elementTuple);
    int expectedHashCodeResult = elementTuple.hashCode();
    assertEquals(expectedHashCodeResult, elementTuple.hashCode());
  }

  /**
   * Test {@link ElementTuple#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementTuple.equals(Object)", "int ElementTuple.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(new Edge());

    // Act and Assert
    assertNotEquals(elementTuple, new ElementTuple());
  }

  /**
   * Test {@link ElementTuple#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementTuple.equals(Object)", "int ElementTuple.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementTuple(), null);
  }

  /**
   * Test {@link ElementTuple#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ElementTuple#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ElementTuple.equals(Object)", "int ElementTuple.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementTuple(), "Different type to ElementTuple");
  }
}
