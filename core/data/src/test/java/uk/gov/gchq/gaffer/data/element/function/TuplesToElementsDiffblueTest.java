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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class TuplesToElementsDiffblueTest {
  /**
   * Method under test: {@link TuplesToElements#setElements(List)}
   */
  @Test
  void testSetElements() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    // Act
    tuplesToElements.setElements(new ArrayList<>());

    // Assert
    assertTrue(tuplesToElements.getElements().isEmpty());
  }

  /**
   * Method under test: {@link TuplesToElements#setElements(List)}
   */
  @Test
  void testSetElements2() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    ArrayList<ElementTupleDefinition> elements = new ArrayList<>();
    elements.add(new ElementTupleDefinition());

    // Act
    tuplesToElements.setElements(elements);

    // Assert
    assertEquals(elements, tuplesToElements.getElements());
  }

  /**
   * Method under test: {@link TuplesToElements#setElements(List)}
   */
  @Test
  void testSetElements3() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    ArrayList<ElementTupleDefinition> elements = new ArrayList<>();
    elements.add(new ElementTupleDefinition());
    elements.add(new ElementTupleDefinition());

    // Act
    tuplesToElements.setElements(elements);

    // Assert
    assertEquals(elements, tuplesToElements.getElements());
  }

  /**
   * Method under test: {@link TuplesToElements#setElements(List)}
   */
  @Test
  void testSetElements4() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.computeIfPresent("foo", mock(BiFunction.class));

    ArrayList<ElementTupleDefinition> elements = new ArrayList<>();
    elements.add(elementTupleDefinition);

    // Act
    tuplesToElements.setElements(elements);

    // Assert
    assertEquals(elements, tuplesToElements.getElements());
  }

  /**
   * Method under test: {@link TuplesToElements#element(ElementTupleDefinition)}
   */
  @Test
  void testElement() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    // Act and Assert
    assertSame(tuplesToElements, tuplesToElements.element(new ElementTupleDefinition()));
  }

  /**
   * Method under test: {@link TuplesToElements#element(ElementTupleDefinition)}
   */
  @Test
  void testElement2() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    ElementTupleDefinition elementDef = new ElementTupleDefinition();
    elementDef.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertSame(tuplesToElements, tuplesToElements.element(elementDef));
  }

  /**
   * Method under test: {@link TuplesToElements#elements(List)}
   */
  @Test
  void testElements() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    // Act and Assert
    assertSame(tuplesToElements, tuplesToElements.elements(new ArrayList<>()));
  }

  /**
   * Method under test: {@link TuplesToElements#elements(List)}
   */
  @Test
  void testElements2() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    ArrayList<ElementTupleDefinition> elementDef = new ArrayList<>();
    elementDef.add(new ElementTupleDefinition());

    // Act and Assert
    assertSame(tuplesToElements, tuplesToElements.elements(elementDef));
  }

  /**
   * Method under test: {@link TuplesToElements#elements(List)}
   */
  @Test
  void testElements3() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    ArrayList<ElementTupleDefinition> elementDef = new ArrayList<>();
    elementDef.add(new ElementTupleDefinition());
    elementDef.add(new ElementTupleDefinition());

    // Act and Assert
    assertSame(tuplesToElements, tuplesToElements.elements(elementDef));
  }

  /**
   * Method under test: {@link TuplesToElements#elements(List)}
   */
  @Test
  void testElements4() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.computeIfPresent("foo", mock(BiFunction.class));

    ArrayList<ElementTupleDefinition> elementDef = new ArrayList<>();
    elementDef.add(elementTupleDefinition);

    // Act and Assert
    assertSame(tuplesToElements, tuplesToElements.elements(elementDef));
  }

  /**
   * Method under test: {@link TuplesToElements#useGroupMapping(boolean)}
   */
  @Test
  void testUseGroupMapping() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    // Act
    TuplesToElements actualUseGroupMappingResult = tuplesToElements.useGroupMapping(true);

    // Assert
    assertTrue(tuplesToElements.getUseGroupMapping());
    assertSame(tuplesToElements, actualUseGroupMappingResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TuplesToElements}
   *   <li>{@link TuplesToElements#setUseGroupMapping(boolean)}
   *   <li>{@link TuplesToElements#getElements()}
   *   <li>{@link TuplesToElements#getUseGroupMapping()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TuplesToElements actualTuplesToElements = new TuplesToElements();
    actualTuplesToElements.setUseGroupMapping(true);
    List<ElementTupleDefinition> actualElements = actualTuplesToElements.getElements();
    boolean actualUseGroupMapping = actualTuplesToElements.getUseGroupMapping();

    // Assert that nothing has changed
    assertTrue(actualElements.isEmpty());
    assertTrue(actualUseGroupMapping);
  }
}
