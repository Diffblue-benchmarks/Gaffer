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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSetsPairs.Builder;
import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.data.EntitySeed;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters.IncludeIncomingOutgoingType;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;
import uk.gov.gchq.koryphe.iterable.MappedIterable;
import uk.gov.gchq.koryphe.iterable.MappedIterator;

class GetElementsBetweenSetsPairsDiffblueTest {
  /**
   * Test Builder {@link Builder#inputIds(Iterable)}.
   *
   * <p>Method under test: {@link Builder#inputIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder inputIds(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inputIds(Iterable)"})
  void testBuilderInputIds() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputIdsResult = builder.inputIds(new ArrayList<>());

    // Assert
    assertSame(builder, actualInputIdsResult);
  }

  /**
   * Test Builder {@link Builder#input(EntityId[])} with {@code EntityId[]}.
   *
   * <ul>
   *   <li>When {@link EntitySeed#EntitySeed()}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#input(EntityId[])}
   */
  @Test
  @DisplayName(
      "Test Builder input(EntityId[]) with 'EntityId[]'; when EntitySeed(); then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.input(EntityId[])"})
  void testBuilderInputWithEntityId_whenEntitySeed_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputResult = builder.input(new EntitySeed());

    // Assert
    assertSame(builder, actualInputResult);
  }

  /**
   * Test Builder {@link Builder#input(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link Builder#input(Iterable)}
   */
  @Test
  @DisplayName("Test Builder input(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.input(Iterable)"})
  void testBuilderInputWithIterable() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputResult = builder.input(new ArrayList<>());

    // Assert
    GetElementsBetweenSetsPairs _getOpResult = actualInputResult._getOp();
    GetElementsBetweenSets backwardsCompatibleOperation =
        _getOpResult.getBackwardsCompatibleOperation();
    assertTrue(backwardsCompatibleOperation.getOutputTypeReference() instanceof IterableElement);
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableElement);
    Iterable<? extends EntityId> input = backwardsCompatibleOperation.getInput();
    assertTrue(input instanceof MappedIterable);
    Iterable<? extends EntityId> first = _getOpResult.getInput().getFirst();
    assertTrue(first instanceof MappedIterable);
    Iterator<? extends EntityId> iteratorResult = input.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    Iterator<? extends EntityId> iteratorResult2 = first.iterator();
    assertTrue(iteratorResult2 instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
    GetElementsBetweenSetsPairs actualGetElementsBetweenSetsPairs = actualInputResult.build();
    assertSame(_getOpResult, actualGetElementsBetweenSetsPairs);
  }

  /**
   * Test Builder {@link Builder#input(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link Builder#input(Iterable)}
   */
  @Test
  @DisplayName("Test Builder input(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.input(Iterable)"})
  void testBuilderInputWithIterable2() {
    // Arrange and Act
    Builder actualInputResult = new Builder().input((Iterable) null);

    // Assert
    GetElementsBetweenSetsPairs _getOpResult = actualInputResult._getOp();
    GetElementsBetweenSets backwardsCompatibleOperation =
        _getOpResult.getBackwardsCompatibleOperation();
    assertTrue(backwardsCompatibleOperation.getOutputTypeReference() instanceof IterableElement);
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableElement);
    assertNull(backwardsCompatibleOperation.getInput());
    assertNull(_getOpResult.getInput().getFirst());
    GetElementsBetweenSetsPairs actualGetElementsBetweenSetsPairs = actualInputResult.build();
    assertSame(_getOpResult, actualGetElementsBetweenSetsPairs);
  }

  /**
   * Test Builder {@link Builder#input(Object[])} with {@code Object[]}.
   *
   * <ul>
   *   <li>When {@code Input}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#input(Object[])}
   */
  @Test
  @DisplayName(
      "Test Builder input(Object[]) with 'Object[]'; when 'Input'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.input(Object[])"})
  void testBuilderInputWithObject_whenInput_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputResult = builder.input("Input");

    // Assert
    assertSame(builder, actualInputResult);
  }

  /**
   * Test Builder {@link Builder#input(Pair)} with {@code Pair}.
   *
   * <p>Method under test: {@link Builder#input(Pair)}
   */
  @Test
  @DisplayName("Test Builder input(Pair) with 'Pair'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.input(Pair)"})
  void testBuilderInputWithPair() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualInputResult = builder.input(new Pair<>());

    // Assert
    assertSame(builder, actualInputResult);
  }

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
    GetElementsBetweenSetsPairs _getOpResult = actualBuilder._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableElement);
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getDirectedType());
    assertNull(_getOpResult.getView());
    assertNull(_getOpResult.getIncludeIncomingOutGoing());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    GetElementsBetweenSetsPairs actualGetElementsBetweenSetsPairs = actualBuilder.build();
    assertSame(_getOpResult, actualGetElementsBetweenSetsPairs);
  }

  /**
   * Test {@link GetElementsBetweenSetsPairs#getInput()}.
   *
   * <p>Method under test: {@link GetElementsBetweenSetsPairs#getInput()}
   */
  @Test
  @DisplayName("Test getInput()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Pair GetElementsBetweenSetsPairs.getInput()"})
  void testGetInput() {
    // Arrange, Act and Assert
    assertNull(new GetElementsBetweenSetsPairs().getInput());
  }

  /**
   * Test {@link GetElementsBetweenSetsPairs#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetElementsBetweenSetsPairs#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetElementsBetweenSetsPairs.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<? extends Element>> actualOutputTypeReference =
        new GetElementsBetweenSetsPairs().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableElement);
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetElementsBetweenSetsPairs#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetElementsBetweenSetsPairs} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsBetweenSetsPairs#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetElementsBetweenSetsPairs (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetElementsBetweenSetsPairs GetElementsBetweenSetsPairs.shallowClone()"})
  void testShallowClone_givenGetElementsBetweenSetsPairs_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetElementsBetweenSetsPairs actualShallowCloneResult =
        new GetElementsBetweenSetsPairs().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult.getOutputTypeReference() instanceof IterableElement);
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertNull(actualShallowCloneResult.getIncludeIncomingOutGoing());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test {@link GetElementsBetweenSetsPairs#shallowClone()}.
   *
   * <ul>
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsBetweenSetsPairs#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetElementsBetweenSetsPairs GetElementsBetweenSetsPairs.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    GetElementsBetweenSetsPairs getElementsBetweenSetsPairs = new GetElementsBetweenSetsPairs();
    getElementsBetweenSetsPairs.setOptions(new HashMap<>());

    // Act
    GetElementsBetweenSetsPairs actualShallowCloneResult =
        getElementsBetweenSetsPairs.shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult.getOutputTypeReference() instanceof IterableElement);
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getDirectedType());
    assertNull(actualShallowCloneResult.getView());
    assertNull(actualShallowCloneResult.getIncludeIncomingOutGoing());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
  }

  /**
   * Test {@link GetElementsBetweenSetsPairs#getBackwardsCompatibleOperation()}.
   *
   * <ul>
   *   <li>Then Input return {@link MappedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsBetweenSetsPairs#getBackwardsCompatibleOperation()}
   */
  @Test
  @DisplayName("Test getBackwardsCompatibleOperation(); then Input return MappedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetElementsBetweenSets GetElementsBetweenSetsPairs.getBackwardsCompatibleOperation()"
  })
  void testGetBackwardsCompatibleOperation_thenInputReturnMappedIterable() {
    // Arrange
    Pair<Iterable<? extends EntityId>, Iterable<? extends EntityId>> input =
        new Pair<>(new ArrayList<>());
    input.setSecond(new ArrayList<>());

    GetElementsBetweenSetsPairs getElementsBetweenSetsPairs = new GetElementsBetweenSetsPairs();
    getElementsBetweenSetsPairs.setInput(input);

    // Act
    GetElementsBetweenSets actualBackwardsCompatibleOperation =
        getElementsBetweenSetsPairs.getBackwardsCompatibleOperation();

    // Assert
    Iterable<? extends EntityId> input2 = actualBackwardsCompatibleOperation.getInput();
    assertTrue(input2 instanceof MappedIterable);
    Iterable<? extends EntityId> inputB = actualBackwardsCompatibleOperation.getInputB();
    assertTrue(inputB instanceof MappedIterable);
    Iterator<? extends EntityId> iteratorResult = input2.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    Iterator<? extends EntityId> iteratorResult2 = inputB.iterator();
    assertTrue(iteratorResult2 instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(iteratorResult2.hasNext());
  }

  /**
   * Test {@link GetElementsBetweenSetsPairs#getBackwardsCompatibleOperation()}.
   *
   * <ul>
   *   <li>Then OutputTypeReference return {@link TypeReferenceImpl.IterableElement}.
   * </ul>
   *
   * <p>Method under test: {@link GetElementsBetweenSetsPairs#getBackwardsCompatibleOperation()}
   */
  @Test
  @DisplayName(
      "Test getBackwardsCompatibleOperation(); then OutputTypeReference return IterableElement")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "GetElementsBetweenSets GetElementsBetweenSetsPairs.getBackwardsCompatibleOperation()"
  })
  void testGetBackwardsCompatibleOperation_thenOutputTypeReferenceReturnIterableElement() {
    // Arrange and Act
    GetElementsBetweenSets actualBackwardsCompatibleOperation =
        new GetElementsBetweenSetsPairs().getBackwardsCompatibleOperation();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference =
        actualBackwardsCompatibleOperation.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualBackwardsCompatibleOperation.getOutputType();
    assertEquals(
        "java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        outputType.getTypeName());
    assertNull(actualBackwardsCompatibleOperation.getInput());
    assertNull(actualBackwardsCompatibleOperation.getInputB());
    assertNull(actualBackwardsCompatibleOperation.getOptions());
    assertNull(actualBackwardsCompatibleOperation.getDirectedType());
    assertNull(actualBackwardsCompatibleOperation.getView());
    assertNull(actualBackwardsCompatibleOperation.getIncludeIncomingOutGoing());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualBackwardsCompatibleOperation.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetElementsBetweenSetsPairs}
   *   <li>{@link GetElementsBetweenSetsPairs#setDirectedType(DirectedType)}
   *   <li>{@link
   *       GetElementsBetweenSetsPairs#setIncludeIncomingOutGoing(IncludeIncomingOutgoingType)}
   *   <li>{@link GetElementsBetweenSetsPairs#setInput(Pair)}
   *   <li>{@link GetElementsBetweenSetsPairs#setOptions(Map)}
   *   <li>{@link GetElementsBetweenSetsPairs#setView(View)}
   *   <li>{@link GetElementsBetweenSetsPairs#getDirectedType()}
   *   <li>{@link GetElementsBetweenSetsPairs#getIncludeIncomingOutGoing()}
   *   <li>{@link GetElementsBetweenSetsPairs#getOptions()}
   *   <li>{@link GetElementsBetweenSetsPairs#getView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetElementsBetweenSetsPairs.<init>()",
    "DirectedType GetElementsBetweenSetsPairs.getDirectedType()",
    "IncludeIncomingOutgoingType GetElementsBetweenSetsPairs.getIncludeIncomingOutGoing()",
    "Map GetElementsBetweenSetsPairs.getOptions()",
    "View GetElementsBetweenSetsPairs.getView()",
    "void GetElementsBetweenSetsPairs.setDirectedType(DirectedType)",
    "void GetElementsBetweenSetsPairs.setIncludeIncomingOutGoing(IncludeIncomingOutgoingType)",
    "void GetElementsBetweenSetsPairs.setInput(Pair)",
    "void GetElementsBetweenSetsPairs.setOptions(Map)",
    "void GetElementsBetweenSetsPairs.setView(View)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetElementsBetweenSetsPairs actualGetElementsBetweenSetsPairs =
        new GetElementsBetweenSetsPairs();
    actualGetElementsBetweenSetsPairs.setDirectedType(DirectedType.EITHER);
    actualGetElementsBetweenSetsPairs.setIncludeIncomingOutGoing(
        IncludeIncomingOutgoingType.EITHER);
    Pair<Iterable<? extends EntityId>, Iterable<? extends EntityId>> input = new Pair<>();
    actualGetElementsBetweenSetsPairs.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualGetElementsBetweenSetsPairs.setOptions(options);
    View view = new View();
    actualGetElementsBetweenSetsPairs.setView(view);
    DirectedType actualDirectedType = actualGetElementsBetweenSetsPairs.getDirectedType();
    IncludeIncomingOutgoingType actualIncludeIncomingOutGoing =
        actualGetElementsBetweenSetsPairs.getIncludeIncomingOutGoing();
    Map<String, String> actualOptions = actualGetElementsBetweenSetsPairs.getOptions();
    View actualView = actualGetElementsBetweenSetsPairs.getView();

    // Assert
    assertEquals(DirectedType.EITHER, actualDirectedType);
    assertEquals(IncludeIncomingOutgoingType.EITHER, actualIncludeIncomingOutGoing);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
    assertSame(input, actualGetElementsBetweenSetsPairs.getInput());
    assertSame(view, actualView);
  }
}
