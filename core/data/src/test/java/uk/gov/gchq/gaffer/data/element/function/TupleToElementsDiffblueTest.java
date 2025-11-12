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

class TupleToElementsDiffblueTest {
  /**
   * Method under test: {@link TupleToElements#setElements(List)}
   */
  @Test
  void testSetElements() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    // Act
    tupleToElements.setElements(new ArrayList<>());

    // Assert
    assertTrue(tupleToElements.getElements().isEmpty());
  }

  /**
   * Method under test: {@link TupleToElements#setElements(List)}
   */
  @Test
  void testSetElements2() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    ArrayList<ElementTupleDefinition> elements = new ArrayList<>();
    elements.add(new ElementTupleDefinition());

    // Act
    tupleToElements.setElements(elements);

    // Assert
    assertEquals(elements, tupleToElements.getElements());
  }

  /**
   * Method under test: {@link TupleToElements#setElements(List)}
   */
  @Test
  void testSetElements3() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    ArrayList<ElementTupleDefinition> elements = new ArrayList<>();
    elements.add(new ElementTupleDefinition());
    elements.add(new ElementTupleDefinition());

    // Act
    tupleToElements.setElements(elements);

    // Assert
    assertEquals(elements, tupleToElements.getElements());
  }

  /**
   * Method under test: {@link TupleToElements#setElements(List)}
   */
  @Test
  void testSetElements4() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.computeIfPresent("foo", mock(BiFunction.class));

    ArrayList<ElementTupleDefinition> elements = new ArrayList<>();
    elements.add(elementTupleDefinition);

    // Act
    tupleToElements.setElements(elements);

    // Assert
    assertEquals(elements, tupleToElements.getElements());
  }

  /**
   * Method under test: {@link TupleToElements#element(ElementTupleDefinition)}
   */
  @Test
  void testElement() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    // Act and Assert
    assertSame(tupleToElements, tupleToElements.element(new ElementTupleDefinition()));
  }

  /**
   * Method under test: {@link TupleToElements#element(ElementTupleDefinition)}
   */
  @Test
  void testElement2() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    ElementTupleDefinition elementDef = new ElementTupleDefinition();
    elementDef.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertSame(tupleToElements, tupleToElements.element(elementDef));
  }

  /**
   * Method under test: {@link TupleToElements#elements(List)}
   */
  @Test
  void testElements() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    // Act and Assert
    assertSame(tupleToElements, tupleToElements.elements(new ArrayList<>()));
  }

  /**
   * Method under test: {@link TupleToElements#elements(List)}
   */
  @Test
  void testElements2() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    ArrayList<ElementTupleDefinition> elementDef = new ArrayList<>();
    elementDef.add(new ElementTupleDefinition());

    // Act and Assert
    assertSame(tupleToElements, tupleToElements.elements(elementDef));
  }

  /**
   * Method under test: {@link TupleToElements#elements(List)}
   */
  @Test
  void testElements3() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    ArrayList<ElementTupleDefinition> elementDef = new ArrayList<>();
    elementDef.add(new ElementTupleDefinition());
    elementDef.add(new ElementTupleDefinition());

    // Act and Assert
    assertSame(tupleToElements, tupleToElements.elements(elementDef));
  }

  /**
   * Method under test: {@link TupleToElements#elements(List)}
   */
  @Test
  void testElements4() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementTupleDefinition.computeIfPresent("foo", mock(BiFunction.class));

    ArrayList<ElementTupleDefinition> elementDef = new ArrayList<>();
    elementDef.add(elementTupleDefinition);

    // Act and Assert
    assertSame(tupleToElements, tupleToElements.elements(elementDef));
  }

  /**
   * Method under test: {@link TupleToElements#useGroupMapping(boolean)}
   */
  @Test
  void testUseGroupMapping() {
    // Arrange
    TupleToElements tupleToElements = new TupleToElements();

    // Act
    TupleToElements actualUseGroupMappingResult = tupleToElements.useGroupMapping(true);

    // Assert
    assertTrue(tupleToElements.getUseGroupMapping());
    assertSame(tupleToElements, actualUseGroupMappingResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TupleToElements}
   *   <li>{@link TupleToElements#setUseGroupMapping(boolean)}
   *   <li>{@link TupleToElements#getElements()}
   *   <li>{@link TupleToElements#getUseGroupMapping()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TupleToElements actualTupleToElements = new TupleToElements();
    actualTupleToElements.setUseGroupMapping(true);
    List<ElementTupleDefinition> actualElements = actualTupleToElements.getElements();
    boolean actualUseGroupMapping = actualTupleToElements.getUseGroupMapping();

    // Assert that nothing has changed
    assertTrue(actualElements.isEmpty());
    assertTrue(actualUseGroupMapping);
  }
}
