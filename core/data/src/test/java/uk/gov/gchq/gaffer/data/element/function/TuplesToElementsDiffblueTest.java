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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TuplesToElementsDiffblueTest {
  /**
   * Test {@link TuplesToElements#apply(Iterable)} with {@code Iterable}.
   * <p>
   * Method under test: {@link TuplesToElements#apply(Iterable)}
   */
  @Test
  @DisplayName("Test apply(Iterable) with 'Iterable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable TuplesToElements.apply(Iterable)"})
  void testApplyWithIterable() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    // Act and Assert
    assertFalse(tuplesToElements.apply(new ArrayList<>()).iterator().hasNext());
  }

  /**
   * Test {@link TuplesToElements#setElements(List)}.
   * <ul>
   *   <li>Then {@link TuplesToElements} (default constructor) Elements is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TuplesToElements#setElements(List)}
   */
  @Test
  @DisplayName("Test setElements(List); then TuplesToElements (default constructor) Elements is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TuplesToElements.setElements(List)"})
  void testSetElements_thenTuplesToElementsElementsIsArrayList() {
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
   * Test {@link TuplesToElements#setElements(List)}.
   * <ul>
   *   <li>Then {@link TuplesToElements} (default constructor) Elements size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TuplesToElements#setElements(List)}
   */
  @Test
  @DisplayName("Test setElements(List); then TuplesToElements (default constructor) Elements size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TuplesToElements.setElements(List)"})
  void testSetElements_thenTuplesToElementsElementsSizeIsOne() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    ArrayList<ElementTupleDefinition> elements = new ArrayList<>();
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elements.add(elementTupleDefinition);

    // Act
    tuplesToElements.setElements(elements);

    // Assert
    List<ElementTupleDefinition> elements2 = tuplesToElements.getElements();
    assertEquals(1, elements2.size());
    assertSame(elementTupleDefinition, elements2.get(0));
  }

  /**
   * Test {@link TuplesToElements#setElements(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link TuplesToElements} (default constructor) Elements Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TuplesToElements#setElements(List)}
   */
  @Test
  @DisplayName("Test setElements(List); when ArrayList(); then TuplesToElements (default constructor) Elements Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TuplesToElements.setElements(List)"})
  void testSetElements_whenArrayList_thenTuplesToElementsElementsEmpty() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    // Act
    tuplesToElements.setElements(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(tuplesToElements.getElements().isEmpty());
  }

  /**
   * Test {@link TuplesToElements#element(ElementTupleDefinition)}.
   * <p>
   * Method under test: {@link TuplesToElements#element(ElementTupleDefinition)}
   */
  @Test
  @DisplayName("Test element(ElementTupleDefinition)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TuplesToElements TuplesToElements.element(ElementTupleDefinition)"})
  void testElement() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    // Act and Assert
    assertSame(tuplesToElements, tuplesToElements.element(new ElementTupleDefinition()));
  }

  /**
   * Test {@link TuplesToElements#elements(List)}.
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()}.</li>
   *   <li>Then return Elements is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TuplesToElements#elements(List)}
   */
  @Test
  @DisplayName("Test elements(List); given ElementTupleDefinition(); then return Elements is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TuplesToElements TuplesToElements.elements(List)"})
  void testElements_givenElementTupleDefinition_thenReturnElementsIsArrayList() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    ArrayList<ElementTupleDefinition> elementDef = new ArrayList<>();
    elementDef.add(new ElementTupleDefinition());

    // Act and Assert
    assertEquals(elementDef, tuplesToElements.elements(elementDef).getElements());
  }

  /**
   * Test {@link TuplesToElements#elements(List)}.
   * <ul>
   *   <li>Given {@link ElementTupleDefinition#ElementTupleDefinition()}.</li>
   *   <li>Then return Elements size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link TuplesToElements#elements(List)}
   */
  @Test
  @DisplayName("Test elements(List); given ElementTupleDefinition(); then return Elements size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TuplesToElements TuplesToElements.elements(List)"})
  void testElements_givenElementTupleDefinition_thenReturnElementsSizeIsTwo() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    ArrayList<ElementTupleDefinition> elementDef = new ArrayList<>();
    elementDef.add(new ElementTupleDefinition());
    ElementTupleDefinition elementTupleDefinition = new ElementTupleDefinition();
    elementDef.add(elementTupleDefinition);

    // Act and Assert
    List<ElementTupleDefinition> elements = tuplesToElements.elements(elementDef).getElements();
    assertEquals(2, elements.size());
    assertSame(elementTupleDefinition, elements.get(1));
  }

  /**
   * Test {@link TuplesToElements#elements(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link TuplesToElements} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TuplesToElements#elements(List)}
   */
  @Test
  @DisplayName("Test elements(List); when ArrayList(); then return TuplesToElements (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TuplesToElements TuplesToElements.elements(List)"})
  void testElements_whenArrayList_thenReturnTuplesToElements() {
    // Arrange
    TuplesToElements tuplesToElements = new TuplesToElements();

    // Act and Assert
    assertSame(tuplesToElements, tuplesToElements.elements(new ArrayList<>()));
  }

  /**
   * Test {@link TuplesToElements#useGroupMapping(boolean)}.
   * <p>
   * Method under test: {@link TuplesToElements#useGroupMapping(boolean)}
   */
  @Test
  @DisplayName("Test useGroupMapping(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TuplesToElements TuplesToElements.useGroupMapping(boolean)"})
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TuplesToElements}
   *   <li>{@link TuplesToElements#setUseGroupMapping(boolean)}
   *   <li>{@link TuplesToElements#getElements()}
   *   <li>{@link TuplesToElements#getUseGroupMapping()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TuplesToElements.<init>()", "List TuplesToElements.getElements()",
      "boolean TuplesToElements.getUseGroupMapping()", "void TuplesToElements.setUseGroupMapping(boolean)"})
  void testGettersAndSetters() {
    // Arrange and Act
    TuplesToElements actualTuplesToElements = new TuplesToElements();
    actualTuplesToElements.setUseGroupMapping(true);
    List<ElementTupleDefinition> actualElements = actualTuplesToElements.getElements();
    boolean actualUseGroupMapping = actualTuplesToElements.getUseGroupMapping();

    // Assert
    assertTrue(actualElements.isEmpty());
    assertTrue(actualUseGroupMapping);
  }
}
