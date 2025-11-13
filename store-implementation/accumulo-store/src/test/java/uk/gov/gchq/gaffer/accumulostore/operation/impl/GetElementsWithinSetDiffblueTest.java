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

package uk.gov.gchq.gaffer.accumulostore.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsWithinSet.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;

class GetElementsWithinSetDiffblueTest {
  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    GetElementsWithinSet _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    assertNull(_getOpResult.getIncludeIncomingOutGoing());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetElementsWithinSet actualGetElementsWithinSet = actualBuilder.build();
    assertSame(_getOpResult, actualGetElementsWithinSet);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetElementsWithinSet#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsWithinSet#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsWithinSet.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GetElementsWithinSet().getInput());
  }

  /**
   * Test {@link GetElementsWithinSet#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetElementsWithinSet#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetElementsWithinSet.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends Element>> actualOutputTypeReference =
        new GetElementsWithinSet().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableElement);
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetElementsWithinSet#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetElementsWithinSet} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsWithinSet#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetElementsWithinSet (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetElementsWithinSet GetElementsWithinSet.shallowClone()"})
  void testShallowClone_givenGetElementsWithinSet_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetElementsWithinSet actualShallowCloneResult = new GetElementsWithinSet().shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertNull(actualShallowCloneResult.getIncludeIncomingOutGoing());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetElementsWithinSet#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsWithinSet#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetElementsWithinSet GetElementsWithinSet.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    GetElementsWithinSet getElementsWithinSet = new GetElementsWithinSet();
    getElementsWithinSet.setOptions(new HashMap<>());

    // Act
    GetElementsWithinSet actualShallowCloneResult = getElementsWithinSet.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertNull(actualShallowCloneResult.getIncludeIncomingOutGoing());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetElementsWithinSet}
   *   <li>{@link GetElementsWithinSet#setDirectedType(DirectedType)}
   *   <li>{@link GetElementsWithinSet#setIncludeIncomingOutGoing(IncludeIncomingOutgoingType)}
   *   <li>{@link GetElementsWithinSet#setInput(Iterable)}
   *   <li>{@link GetElementsWithinSet#setOptions(Map)}
   *   <li>{@link GetElementsWithinSet#setView(View)}
   *   <li>{@link GetElementsWithinSet#getDirectedType()}
   *   <li>{@link GetElementsWithinSet#getIncludeIncomingOutGoing()}
   *   <li>{@link GetElementsWithinSet#getOptions()}
   *   <li>{@link GetElementsWithinSet#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetElementsWithinSet.<init>()",
    "DirectedType GetElementsWithinSet.getDirectedType()",
    "IncludeIncomingOutgoingType GetElementsWithinSet.getIncludeIncomingOutGoing()",
    "Map GetElementsWithinSet.getOptions()",
    "View GetElementsWithinSet.getView()",
    "void GetElementsWithinSet.setDirectedType(DirectedType)",
    "void GetElementsWithinSet.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType)",
    "void GetElementsWithinSet.setInput(Iterable)",
    "void GetElementsWithinSet.setOptions(Map)",
    "void GetElementsWithinSet.setView(View)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetElementsWithinSet actualGetElementsWithinSet = new GetElementsWithinSet();
    actualGetElementsWithinSet.setDirectedType(DirectedType.EITHER);
    actualGetElementsWithinSet.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.EITHER);
    ArrayList<EntityId> input = new ArrayList<>();
    actualGetElementsWithinSet.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualGetElementsWithinSet.setOptions(options);
    View view = new View();
    actualGetElementsWithinSet.setView(view);
    DirectedType actualDirectedType = actualGetElementsWithinSet.getDirectedType();
    IncludeIncomingOutgoingType actualIncludeIncomingOutGoing =
        actualGetElementsWithinSet.getIncludeIncomingOutGoing();
    Map<String, String> actualOptions = actualGetElementsWithinSet.getOptions();
    View actualView = actualGetElementsWithinSet.getView();

    // Assert
    Iterable<? extends EntityId> input2 = actualGetElementsWithinSet.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertEquals(IncludeIncomingOutgoingType.EITHER, actualIncludeIncomingOutGoing);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(view, actualView);
  }
}
