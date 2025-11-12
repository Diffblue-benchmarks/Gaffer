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
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class ElementDiffblueTest {
  /**
   * Method under test: {@link Element#putProperty(String, Object)}
   */
  @Test
  void testPutProperty() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.putProperty("Name", "Value");

    // Assert that nothing has changed
    Properties properties = edge.getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
  }

  /**
   * Method under test: {@link Element#putProperty(String, Object)}
   */
  @Test
  void testPutProperty2() {
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
   * Method under test: {@link Element#putProperty(String, Object)}
   */
  @Test
  void testPutProperty3() {
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
   * Method under test: {@link Element#copyProperties(Properties)}
   */
  @Test
  void testCopyProperties() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.copyProperties(new Properties());

    // Assert that nothing has changed
    assertTrue(edge.getProperties().isEmpty());
  }

  /**
   * Method under test: {@link Element#copyProperties(Properties)}
   */
  @Test
  void testCopyProperties2() {
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
   * Method under test: {@link Element#copyProperties(Properties)}
   */
  @Test
  void testCopyProperties3() {
    // Arrange
    Edge edge = new Edge();

    Properties properties = new Properties();
    properties.put("foo", "42");

    // Act
    edge.copyProperties(properties);

    // Assert that nothing has changed
    Properties properties2 = edge.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("42", properties2.get("foo"));
  }

  /**
   * Method under test: {@link Element#getProperty(String)}
   */
  @Test
  void testGetProperty() {
    // Arrange, Act and Assert
    assertNull((new Edge()).getProperty("Name"));
  }

  /**
   * Method under test: {@link Element#getProperties()}
   */
  @Test
  void testGetProperties() {
    // Arrange, Act and Assert
    assertTrue((new Edge()).getProperties().isEmpty());
    assertTrue((new LazyEdge(new Edge(), mock(ElementValueLoader.class))).getProperties().isEmpty());
  }

  /**
   * Method under test: {@link Element#removeProperty(String)}
   */
  @Test
  void testRemoveProperty() {
    // Arrange, Act and Assert
    assertNull((new Edge()).removeProperty("Prop Name"));
    assertNull((new LazyEdge(new Edge(), mock(ElementValueLoader.class))).removeProperty("Prop Name"));
  }

  /**
   * Method under test: {@link Element#getGroup()}
   */
  @Test
  void testGetGroup() {
    // Arrange, Act and Assert
    assertEquals(Element.DEFAULT_GROUP, (new Edge()).getGroup());
    assertEquals(Element.DEFAULT_GROUP, (new LazyEdge(new Edge(), mock(ElementValueLoader.class))).getGroup());
  }

  /**
   * Method under test: {@link Element#equals(Object)}
   */
  @Test
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
   * Method under test: {@link Element#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LazyEdge lazyEdge = new LazyEdge(new Edge(), mock(ElementValueLoader.class));
    Edge edge = new Edge();

    // Act and Assert
    assertEquals(lazyEdge, edge);
    int expectedHashCodeResult = lazyEdge.hashCode();
    assertEquals(expectedHashCodeResult, edge.hashCode());
  }

  /**
   * Method under test: {@link Element#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertEquals(edge, edge);
    int expectedHashCodeResult = edge.hashCode();
    assertEquals(expectedHashCodeResult, edge.hashCode());
  }

  /**
   * Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  void testShallowEquals() {
    // Arrange, Act and Assert
    assertFalse((new Edge()).shallowEquals("Obj"));
    assertFalse((new LazyEdge(new Edge(), mock(ElementValueLoader.class))).shallowEquals("Obj"));
    assertFalse((new Edge()).shallowEquals((Object) null));
    assertFalse((new Edge()).shallowEquals((Element) null));
  }

  /**
   * Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  void testShallowEquals2() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertTrue(edge.shallowEquals((Object) new Edge()));
  }

  /**
   * Method under test: {@link Element#shallowEquals(Object)}
   */
  @Test
  void testShallowEquals3() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertFalse(edge.shallowEquals((Object) new Edge("Group")));
  }

  /**
   * Method under test: {@link Element#shallowEquals(Element)}
   */
  @Test
  void testShallowEquals4() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertTrue(edge.shallowEquals(new Edge()));
  }

  /**
   * Method under test: {@link Element#shallowEquals(Element)}
   */
  @Test
  void testShallowEquals5() {
    // Arrange
    Edge edge = new Edge("Group");

    // Act and Assert
    assertFalse(edge.shallowEquals(new Edge()));
  }

  /**
   * Method under test: {@link Element#shallowEquals(Element)}
   */
  @Test
  void testShallowEquals6() {
    // Arrange
    LazyEdge lazyEdge = new LazyEdge(new Edge(), mock(ElementValueLoader.class));

    // Act and Assert
    assertTrue(lazyEdge.shallowEquals(new Edge()));
  }

  /**
   * Method under test: {@link Element#shallowClone()}
   */
  @Test
  void testShallowClone() {
    // Arrange
    Edge edge = new Edge();

    // Act
    Edge actualShallowCloneResult = edge.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult instanceof Edge);
    assertEquals(edge, actualShallowCloneResult);
  }

  /**
   * Method under test: {@link Element#getElement()}
   */
  @Test
  void testGetElement() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertSame(edge, edge.getElement());
  }

  /**
   * Method under test: {@link Element#getElement()}
   */
  @Test
  void testGetElement2() {
    // Arrange
    Edge edge = new Edge();

    // Act and Assert
    assertSame(edge, (new LazyEdge(edge, mock(ElementValueLoader.class))).getElement());
  }

  /**
   * Method under test: {@link Element#setGroup(String)}
   */
  @Test
  void testSetGroup() {
    // Arrange
    Edge edge = new Edge();

    // Act
    edge.setGroup("Group");

    // Assert
    assertEquals("Group", edge.getGroup());
  }

  /**
   * Method under test: {@link Element#setProperties(Properties)}
   */
  @Test
  void testSetProperties() {
    // Arrange
    Edge edge = new Edge();
    Properties properties = new Properties();

    // Act
    edge.setProperties(properties);

    // Assert
    assertSame(properties, edge.getProperties());
  }

  /**
   * Method under test: {@link Element#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Edge edge = new Edge("Group");

    // Act and Assert
    assertNotEquals(edge, new Edge());
  }

  /**
   * Method under test: {@link Element#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Edge(), null);
  }

  /**
   * Method under test: {@link Element#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Edge(), "Different type to Element");
  }
}
