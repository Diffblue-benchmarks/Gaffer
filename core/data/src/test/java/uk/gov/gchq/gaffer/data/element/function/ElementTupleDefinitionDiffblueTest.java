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

package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class ElementTupleDefinitionDiffblueTest {
  /**
   * Method under test: {@link ElementTupleDefinition#getGroup()}
   */
  @Test
  void testGetGroup() {
    // Arrange, Act and Assert
    assertNull((new ElementTupleDefinition()).getGroup());
  }

  /**
   * Method under test: {@link ElementTupleDefinition#getGroup()}
   */
  @Test
  void testGetGroup2() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.put(ElementTupleDefinition.GROUP, "42");

    // Act and Assert
    assertEquals("42", elementTupleDefinition.getGroup());
  }

  /**
   * Method under test: {@link ElementTupleDefinition#get(Object)}
   */
  @Test
  void testGet() {
    // Arrange, Act and Assert
    assertNull((new ElementTupleDefinition()).get("Key"));
  }

  /**
   * Method under test: {@link ElementTupleDefinition#get(Object)}
   */
  @Test
  void testGet2() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.computeIfPresent(ElementTupleDefinition.DIRECTED, mock(BiFunction.class));

    // Act and Assert
    assertNull(elementTupleDefinition.get("Key"));
  }

  /**
   * Method under test: {@link ElementTupleDefinition#get(Object)}
   */
  @Test
  void testGet3() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.put(ElementTupleDefinition.DIRECTED, "42");

    // Act and Assert
    assertEquals("42", elementTupleDefinition.get(ElementTupleDefinition.DIRECTED));
  }

  /**
   * Method under test: {@link ElementTupleDefinition#vertex(Object)}
   */
  @Test
  void testVertex() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualVertexResult = elementTupleDefinition.vertex("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.VERTEX));
    assertEquals(1, actualVertexResult.size());
    assertEquals("Value", actualVertexResult.get(ElementTupleDefinition.VERTEX));
    assertSame(elementTupleDefinition, actualVertexResult);
  }

  /**
   * Method under test: {@link ElementTupleDefinition#vertex(Object)}
   */
  @Test
  void testVertex2() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.computeIfPresent(ElementTupleDefinition.VERTEX, mock(BiFunction.class));

    // Act
    ElementTupleDefinition actualVertexResult = elementTupleDefinition.vertex("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.VERTEX));
    assertEquals(1, actualVertexResult.size());
    assertEquals("Value", actualVertexResult.get(ElementTupleDefinition.VERTEX));
    assertSame(elementTupleDefinition, actualVertexResult);
  }

  /**
   * Method under test: {@link ElementTupleDefinition#source(Object)}
   */
  @Test
  void testSource() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualSourceResult = elementTupleDefinition.source("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.SOURCE));
    assertEquals(1, actualSourceResult.size());
    assertEquals("Value", actualSourceResult.get(ElementTupleDefinition.SOURCE));
    assertSame(elementTupleDefinition, actualSourceResult);
  }

  /**
   * Method under test: {@link ElementTupleDefinition#source(Object)}
   */
  @Test
  void testSource2() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.computeIfPresent(ElementTupleDefinition.SOURCE, mock(BiFunction.class));

    // Act
    ElementTupleDefinition actualSourceResult = elementTupleDefinition.source("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.SOURCE));
    assertEquals(1, actualSourceResult.size());
    assertEquals("Value", actualSourceResult.get(ElementTupleDefinition.SOURCE));
    assertSame(elementTupleDefinition, actualSourceResult);
  }

  /**
   * Method under test: {@link ElementTupleDefinition#destination(Object)}
   */
  @Test
  void testDestination() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualDestinationResult = elementTupleDefinition.destination("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.DESTINATION));
    assertEquals(1, actualDestinationResult.size());
    assertEquals("Value", actualDestinationResult.get(ElementTupleDefinition.DESTINATION));
    assertSame(elementTupleDefinition, actualDestinationResult);
  }

  /**
   * Method under test: {@link ElementTupleDefinition#destination(Object)}
   */
  @Test
  void testDestination2() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.computeIfPresent(ElementTupleDefinition.DESTINATION, mock(BiFunction.class));

    // Act
    ElementTupleDefinition actualDestinationResult = elementTupleDefinition.destination("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.DESTINATION));
    assertEquals(1, actualDestinationResult.size());
    assertEquals("Value", actualDestinationResult.get(ElementTupleDefinition.DESTINATION));
    assertSame(elementTupleDefinition, actualDestinationResult);
  }

  /**
   * Method under test: {@link ElementTupleDefinition#directed(Object)}
   */
  @Test
  void testDirected() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualDirectedResult = elementTupleDefinition.directed("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.DIRECTED));
    assertEquals(1, actualDirectedResult.size());
    assertEquals("Value", actualDirectedResult.get(ElementTupleDefinition.DIRECTED));
    assertSame(elementTupleDefinition, actualDirectedResult);
  }

  /**
   * Method under test: {@link ElementTupleDefinition#directed(Object)}
   */
  @Test
  void testDirected2() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.computeIfPresent(ElementTupleDefinition.DIRECTED, mock(BiFunction.class));

    // Act
    ElementTupleDefinition actualDirectedResult = elementTupleDefinition.directed("Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get(ElementTupleDefinition.DIRECTED));
    assertEquals(1, actualDirectedResult.size());
    assertEquals("Value", actualDirectedResult.get(ElementTupleDefinition.DIRECTED));
    assertSame(elementTupleDefinition, actualDirectedResult);
  }

  /**
   * Method under test: {@link ElementTupleDefinition#property(String)}
   */
  @Test
  void testProperty() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualPropertyResult = elementTupleDefinition.property("Key");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Key", elementTupleDefinition.get("Key"));
    assertEquals(1, actualPropertyResult.size());
    assertEquals("Key", actualPropertyResult.get("Key"));
    assertSame(elementTupleDefinition, actualPropertyResult);
  }

  /**
   * Method under test: {@link ElementTupleDefinition#property(String)}
   */
  @Test
  void testProperty2() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    ElementTupleDefinition actualPropertyResult = elementTupleDefinition.property("Key");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Key", elementTupleDefinition.get("Key"));
    assertEquals(1, actualPropertyResult.size());
    assertEquals("Key", actualPropertyResult.get("Key"));
    assertSame(elementTupleDefinition, actualPropertyResult);
  }

  /**
   * Method under test: {@link ElementTupleDefinition#property(String, Object)}
   */
  @Test
  void testProperty3() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();

    // Act
    ElementTupleDefinition actualPropertyResult = elementTupleDefinition.property("Key", "Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get("Key"));
    assertEquals(1, actualPropertyResult.size());
    assertEquals("Value", actualPropertyResult.get("Key"));
    assertSame(elementTupleDefinition, actualPropertyResult);
  }

  /**
   * Method under test: {@link ElementTupleDefinition#property(String, Object)}
   */
  @Test
  void testProperty4() {
    // Arrange
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    ElementTupleDefinition actualPropertyResult = elementTupleDefinition.property("Key", "Value");

    // Assert
    assertEquals(1, elementTupleDefinition.size());
    assertEquals("Value", elementTupleDefinition.get("Key"));
    assertEquals(1, actualPropertyResult.size());
    assertEquals("Value", actualPropertyResult.get("Key"));
    assertSame(elementTupleDefinition, actualPropertyResult);
  }

  /**
   * Method under test: {@link ElementTupleDefinition#ElementTupleDefinition()}
   */
  @Test
  void testNewElementTupleDefinition() {
    // Arrange, Act and Assert
    assertTrue((new ElementTupleDefinition()).isEmpty());
  }

  /**
   * Method under test:
   * {@link ElementTupleDefinition#ElementTupleDefinition(String)}
   */
  @Test
  void testNewElementTupleDefinition2() {
    // Arrange and Act
    ElementTupleDefinition actualElementTupleDefinition = new ElementTupleDefinition("Group");

    // Assert
    assertEquals(1, actualElementTupleDefinition.size());
    assertEquals("Group", actualElementTupleDefinition.get(ElementTupleDefinition.GROUP));
  }
}
