/*
 * Copyright 2026 Crown Copyright
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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets.Builder;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;
import uk.gov.gchq.koryphe.iterable.MappedIterable;
import uk.gov.gchq.koryphe.iterable.MappedIterator;

class GetElementsBetweenSetsDiffblueTest {
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
    GetElementsBetweenSets _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = _getOpResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getInputB());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    assertNull(_getOpResult.getIncludeIncomingOutGoing());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetElementsBetweenSets actualGetElementsBetweenSets = actualBuilder.build();
    assertSame(_getOpResult, actualGetElementsBetweenSets);
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetElementsBetweenSets#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsBetweenSets#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsBetweenSets.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GetElementsBetweenSets().getInput());
  }

  /**
   * Test {@link GetElementsBetweenSets#createInputBArray()}.
   *
   * <ul>
   *   <li>Given {@link GetElementsBetweenSets} (default constructor) InputB is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsBetweenSets#createInputBArray()}
   */
  @Test
  @DisplayName(
      "Test createInputBArray(); given GetElementsBetweenSets (default constructor) InputB is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] GetElementsBetweenSets.createInputBArray()"})
  void testCreateInputBArray_givenGetElementsBetweenSetsInputBIsArrayList() {
    // Arrange
    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();
    getElementsBetweenSets.setInputB(new ArrayList<>());

    // Act and Assert
    assertEquals(0, getElementsBetweenSets.createInputBArray().length);
  }

  /**
   * Test {@link GetElementsBetweenSets#createInputBArray()}.
   *
   * <ul>
   *   <li>Given {@link GetElementsBetweenSets} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsBetweenSets#createInputBArray()}
   */
  @Test
  @DisplayName(
      "Test createInputBArray(); given GetElementsBetweenSets (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] GetElementsBetweenSets.createInputBArray()"})
  void testCreateInputBArray_givenGetElementsBetweenSets_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GetElementsBetweenSets().createInputBArray());
  }

  /**
   * Test {@link GetElementsBetweenSets#createInputBArray()}.
   *
   * <ul>
   *   <li>Then calls {@link Iterable#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsBetweenSets#createInputBArray()}
   */
  @Test
  @DisplayName("Test createInputBArray(); then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] GetElementsBetweenSets.createInputBArray()"})
  void testCreateInputBArray_thenCallsIterator() {
    // Arrange
    Iterable<EntityId> inputB = mock(Iterable.class);

    ArrayList<EntityId> entityIdList = new ArrayList<>();
    when(inputB.iterator()).thenReturn(entityIdList.iterator());

    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();
    getElementsBetweenSets.setInputB(inputB);

    // Act
    Object[] actualCreateInputBArrayResult = getElementsBetweenSets.createInputBArray();

    // Assert
    verify(inputB).iterator();
    assertEquals(0, actualCreateInputBArrayResult.length);
  }

  /**
   * Test {@link GetElementsBetweenSets#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetElementsBetweenSets#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetElementsBetweenSets.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends Element>> actualOutputTypeReference =
        new GetElementsBetweenSets().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableElement);
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetElementsBetweenSets#getInputB()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsBetweenSets#getInputB()}
   */
  @Test
  @DisplayName("Test getInputB(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetElementsBetweenSets.getInputB()"})
  void testGetInputB_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GetElementsBetweenSets().getInputB());
  }

  /**
   * Test {@link GetElementsBetweenSets#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetElementsBetweenSets} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetElementsBetweenSets#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetElementsBetweenSets (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetElementsBetweenSets GetElementsBetweenSets.shallowClone()"})
  void testShallowClone_givenGetElementsBetweenSets() {
    // Arrange and Act
    GetElementsBetweenSets actualShallowCloneResult = new GetElementsBetweenSets().shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getInputB());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertNull(actualShallowCloneResult.getIncludeIncomingOutGoing());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetElementsBetweenSets#shallowClone()}.
   *
   * <ul>
   *   <li>Then Input return {@link MappedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsBetweenSets#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then Input return MappedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetElementsBetweenSets GetElementsBetweenSets.shallowClone()"})
  void testShallowClone_thenInputReturnMappedIterable() {
    // Arrange
    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();
    getElementsBetweenSets.setInput(new ArrayList<>());

    // Act
    GetElementsBetweenSets actualShallowCloneResult = getElementsBetweenSets.shallowClone();

    // Assert
    Iterable<? extends EntityId> input = actualShallowCloneResult.getInput();
    assertTrue(input instanceof MappedIterable);
    Iterator<? extends EntityId> iteratorResult = input.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertNull(actualShallowCloneResult.getOptions());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link GetElementsBetweenSets#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsBetweenSets#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetElementsBetweenSets GetElementsBetweenSets.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();
    getElementsBetweenSets.setOptions(new HashMap<>());

    // Act
    GetElementsBetweenSets actualShallowCloneResult = getElementsBetweenSets.shallowClone();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getInputB());
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
   *   <li>default or parameterless constructor of {@link GetElementsBetweenSets}
   *   <li>{@link GetElementsBetweenSets#setDirectedType(DirectedType)}
   *   <li>{@link GetElementsBetweenSets#setIncludeIncomingOutGoing(IncludeIncomingOutgoingType)}
   *   <li>{@link GetElementsBetweenSets#setInput(Iterable)}
   *   <li>{@link GetElementsBetweenSets#setInputB(Iterable)}
   *   <li>{@link GetElementsBetweenSets#setOptions(Map)}
   *   <li>{@link GetElementsBetweenSets#setView(View)}
   *   <li>{@link GetElementsBetweenSets#getDirectedType()}
   *   <li>{@link GetElementsBetweenSets#getIncludeIncomingOutGoing()}
   *   <li>{@link GetElementsBetweenSets#getOptions()}
   *   <li>{@link GetElementsBetweenSets#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetElementsBetweenSets.<init>()",
    "DirectedType GetElementsBetweenSets.getDirectedType()",
    "IncludeIncomingOutgoingType GetElementsBetweenSets.getIncludeIncomingOutGoing()",
    "Map GetElementsBetweenSets.getOptions()",
    "View GetElementsBetweenSets.getView()",
    "void GetElementsBetweenSets.setDirectedType(DirectedType)",
    "void GetElementsBetweenSets.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType)",
    "void GetElementsBetweenSets.setInput(Iterable)",
    "void GetElementsBetweenSets.setInputB(Iterable)",
    "void GetElementsBetweenSets.setOptions(Map)",
    "void GetElementsBetweenSets.setView(View)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetElementsBetweenSets actualGetElementsBetweenSets = new GetElementsBetweenSets();
    actualGetElementsBetweenSets.setDirectedType(DirectedType.EITHER);
    actualGetElementsBetweenSets.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType.EITHER);
    ArrayList<EntityId> input = new ArrayList<>();
    actualGetElementsBetweenSets.setInput(input);
    ArrayList<EntityId> inputB = new ArrayList<>();
    actualGetElementsBetweenSets.setInputB(inputB);
    HashMap<String, String> options = new HashMap<>();
    actualGetElementsBetweenSets.setOptions(options);
    View view = new View();
    actualGetElementsBetweenSets.setView(view);
    DirectedType actualDirectedType = actualGetElementsBetweenSets.getDirectedType();
    IncludeIncomingOutgoingType actualIncludeIncomingOutGoing =
        actualGetElementsBetweenSets.getIncludeIncomingOutGoing();
    Map<String, String> actualOptions = actualGetElementsBetweenSets.getOptions();
    View actualView = actualGetElementsBetweenSets.getView();

    // Assert
    Iterable<? extends EntityId> input2 = actualGetElementsBetweenSets.getInput();
    assertTrue(input2 instanceof List);
    Iterable<? extends EntityId> inputB2 = actualGetElementsBetweenSets.getInputB();
    assertTrue(inputB2 instanceof List);
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertEquals(IncludeIncomingOutgoingType.EITHER, actualIncludeIncomingOutGoing);
    assertTrue(actualOptions.isEmpty());
    assertSame(input, input2);
    assertSame(inputB, inputB2);
    assertSame(options, actualOptions);
    assertSame(view, actualView);
  }
}
