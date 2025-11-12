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
import static org.mockito.Mockito.mock;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class ElementTupleDiffblueTest {
  /**
   * Method under test: {@link ElementTuple#get(String)}
   */
  @Test
  void testGet() {
    // Arrange, Act and Assert
    assertNull((new ElementTuple()).get(ElementTuple.ELEMENT));
    assertNull((new ElementTuple(new Edge())).get("Reference"));
  }

  /**
   * Method under test: {@link ElementTuple#get(String)}
   */
  @Test
  void testGet2() {
    // Arrange and Act
    Object actualGetResult = (new ElementTuple(new Edge())).get(ElementTuple.PROPERTIES);

    // Assert
    assertTrue(actualGetResult instanceof Map);
    assertTrue(((Map<Object, Object>) actualGetResult).isEmpty());
  }

  /**
   * Method under test: {@link ElementTuple#get(String)}
   */
  @Test
  void testGet3() {
    // Arrange and Act
    Object actualGetResult = (new ElementTuple(new LazyEdge(new Edge(), mock(ElementValueLoader.class))))
        .get(ElementTuple.PROPERTIES);

    // Assert
    assertTrue(actualGetResult instanceof Map);
    assertTrue(((Map<Object, Object>) actualGetResult).isEmpty());
  }

  /**
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  void testPut() {
    // Arrange
    Edge element = new Edge();
    element.setProperties(new Properties());

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> elementTuple.put(ElementTuple.ELEMENT, null));
  }

  /**
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  void testPut2() {
    // Arrange
    Edge element = new Edge();
    element.setProperties(new Properties());

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);

    // Act
    elementTuple.put(ElementTuple.PROPERTIES, null);

    // Assert that nothing has changed
    assertSame(element, elementTuple.getElement());
  }

  /**
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  void testPut3() {
    // Arrange
    Edge element = new Edge();
    element.setProperties(new Properties());

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);

    // Act
    elementTuple.put(null, null);

    // Assert that nothing has changed
    assertSame(element, elementTuple.getElement());
  }

  /**
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  void testPut4() {
    // Arrange
    Edge element = new Edge();
    element.setProperties(new Properties());

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);

    // Act
    elementTuple.put("Reference", "Value");

    // Assert that nothing has changed
    assertSame(element, elementTuple.getElement());
  }

  /**
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  void testPut5() {
    // Arrange
    Edge element = new Edge();
    element.setProperties(new Properties());

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);

    // Act
    elementTuple.put(ElementTuple.PROPERTIES, new GroupedProperties());

    // Assert that nothing has changed
    assertSame(element, elementTuple.getElement());
  }

  /**
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  void testPut6() {
    // Arrange
    Properties properties = new Properties();
    properties.computeIfPresent(ElementTuple.ELEMENT, mock(BiFunction.class));

    Edge element = new Edge();
    element.setProperties(properties);

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);

    // Act
    elementTuple.put(null, null);

    // Assert that nothing has changed
    assertSame(element, elementTuple.getElement());
  }

  /**
   * Method under test: {@link ElementTuple#put(String, Object)}
   */
  @Test
  void testPut7() {
    // Arrange
    LazyEdge element = new LazyEdge(new Edge(), mock(ElementValueLoader.class));
    element.putIdentifier(IdentifierType.VERTEX, "Value");
    element.setProperties(new Properties());

    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(element);

    // Act
    elementTuple.put("Reference", "Value");

    // Assert
    assertSame(element, elementTuple.getElement());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementTuple#equals(Object)}
   *   <li>{@link ElementTuple#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link ElementTuple#equals(Object)}
   *   <li>{@link ElementTuple#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementTuple elementTuple = new ElementTuple();

    // Act and Assert
    assertEquals(elementTuple, elementTuple);
    int expectedHashCodeResult = elementTuple.hashCode();
    assertEquals(expectedHashCodeResult, elementTuple.hashCode());
  }

  /**
   * Method under test: {@link ElementTuple#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(new Edge());

    // Act and Assert
    assertNotEquals(elementTuple, new ElementTuple());
  }

  /**
   * Method under test: {@link ElementTuple#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ElementTuple elementTuple = new ElementTuple();
    elementTuple.setElement(mock(Element.class));

    // Act and Assert
    assertNotEquals(elementTuple, new ElementTuple());
  }

  /**
   * Method under test: {@link ElementTuple#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementTuple(), null);
  }

  /**
   * Method under test: {@link ElementTuple#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ElementTuple(), "Different type to ElementTuple");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementTuple#ElementTuple()}
   *   <li>{@link ElementTuple#setElement(Element)}
   *   <li>{@link ElementTuple#getElement()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ElementTuple actualElementTuple = new ElementTuple();
    Edge element = new Edge();
    actualElementTuple.setElement(element);

    // Assert that nothing has changed
    assertSame(element, actualElementTuple.getElement());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ElementTuple#ElementTuple(Element)}
   *   <li>{@link ElementTuple#setElement(Element)}
   *   <li>{@link ElementTuple#getElement()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ElementTuple actualElementTuple = new ElementTuple(new Edge());
    Edge element = new Edge();
    actualElementTuple.setElement(element);

    // Assert that nothing has changed
    assertSame(element, actualElementTuple.getElement());
  }
}
