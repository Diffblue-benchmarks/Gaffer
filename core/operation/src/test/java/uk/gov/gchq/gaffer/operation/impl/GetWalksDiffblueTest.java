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

package uk.gov.gchq.gaffer.operation.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.data.graph.Walk;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.GetWalks.Builder;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableWalk;
import uk.gov.gchq.gaffer.operation.util.Conditional;
import uk.gov.gchq.koryphe.ValidationResult;

class GetWalksDiffblueTest {
  /**
   * Test Builder {@link Builder#addOperations(List)} with {@code List}.
   *
   * <p>Method under test: {@link Builder#addOperations(List)}
   */
  @Test
  @DisplayName("Test Builder addOperations(List) with 'List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperations(List)"})
  void testBuilderAddOperationsWithList() {
    // Arrange
    Builder builder = new Builder();

    NamedOperation<Object, Iterable<Element>> namedOperation = new NamedOperation<>();
    namedOperation.addOption("Name", "42");

    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    operations.add(namedOperation);

    // Act and Assert
    List<OperationChain<Iterable<Element>>> operations2 =
        builder.addOperations(operations)._getOp().getOperations();
    assertEquals(1, operations2.size());
    OperationChain<Iterable<Element>> getResult = operations2.get(0);
    List<Operation> operations3 = getResult.getOperations();
    assertEquals(1, operations3.size());
    Operation getResult2 = operations3.get(0);
    assertTrue(getResult2 instanceof NamedOperation);
    Map<String, String> options = getResult.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get("Name"));
    assertSame(options, getResult2.getOptions());
  }

  /**
   * Test Builder {@link Builder#addOperations(List)} with {@code List}.
   *
   * <ul>
   *   <li>Then return _getOp Operations is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOperations(List)}
   */
  @Test
  @DisplayName(
      "Test Builder addOperations(List) with 'List'; then return _getOp Operations is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperations(List)"})
  void testBuilderAddOperationsWithList_thenReturn_getOpOperationsIsArrayList() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    OperationChain<Iterable<Element>> wrapResult = OperationChain.wrap(new NamedOperation<>());
    operations.add(wrapResult);

    // Act and Assert
    assertEquals(operations, builder.addOperations(operations)._getOp().getOperations());
  }

  /**
   * Test Builder {@link Builder#addOperations(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOperations(List)}
   */
  @Test
  @DisplayName(
      "Test Builder addOperations(List) with 'List'; when ArrayList(); then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperations(List)"})
  void testBuilderAddOperationsWithList_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddOperationsResult = builder.addOperations(new ArrayList<>());

    // Assert
    assertSame(builder, actualAddOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addOperations(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOperations(List)}
   */
  @Test
  @DisplayName(
      "Test Builder addOperations(List) with 'List'; when 'null'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperations(List)"})
  void testBuilderAddOperationsWithList_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddOperationsResult =
        builder.addOperations((List<Output<Iterable<Element>>>) null);

    // Assert
    assertSame(builder, actualAddOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addOperations(Output[])} with {@code Output[]}.
   *
   * <p>Method under test: {@link Builder#addOperations(Output[])}
   */
  @Test
  @DisplayName("Test Builder addOperations(Output[]) with 'Output[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperations(Output[])"})
  void testBuilderAddOperationsWithOutput() {
    // Arrange
    Builder builder = new Builder();

    OperationChain<Object> operationChain = new OperationChain<>();
    operationChain.addOption("Name", "42");

    // Act
    Builder actualAddOperationsResult = builder.addOperations(operationChain);

    // Assert
    GetWalks _getOpResult = actualAddOperationsResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableWalk);
    List<OperationChain<Iterable<Element>>> operations = _getOpResult.getOperations();
    assertEquals(1, operations.size());
    assertSame(operationChain, operations.get(0));
    GetWalks actualGetWalks = actualAddOperationsResult.build();
    assertSame(_getOpResult, actualGetWalks);
  }

  /**
   * Test Builder {@link Builder#addOperations(Output[])} with {@code Output[]}.
   *
   * <ul>
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOperations(Output[])}
   */
  @Test
  @DisplayName(
      "Test Builder addOperations(Output[]) with 'Output[]'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperations(Output[])"})
  void testBuilderAddOperationsWithOutput_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddOperationsResult = builder.addOperations();

    // Assert
    assertSame(builder, actualAddOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addOperations(Output[])} with {@code Output[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#addOperations(Output[])}
   */
  @Test
  @DisplayName(
      "Test Builder addOperations(Output[]) with 'Output[]'; when 'null'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperations(Output[])"})
  void testBuilderAddOperationsWithOutput_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddOperationsResult = builder.addOperations((Output[]) null);

    // Assert
    assertSame(builder, actualAddOperationsResult);
  }

  /**
   * Test Builder {@link Builder#conditional(Conditional)} with {@code conditional}.
   *
   * <p>Method under test: {@link Builder#conditional(Conditional)}
   */
  @Test
  @DisplayName("Test Builder conditional(Conditional) with 'conditional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.conditional(Conditional)"})
  void testBuilderConditionalWithConditional() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConditionalResult = builder.conditional(new Conditional());

    // Assert
    assertSame(builder, actualConditionalResult);
  }

  /**
   * Test Builder {@link Builder#conditional(Predicate)} with {@code predicate}.
   *
   * <p>Method under test: {@link Builder#conditional(Predicate)}
   */
  @Test
  @DisplayName("Test Builder conditional(Predicate) with 'predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.conditional(Predicate)"})
  void testBuilderConditionalWithPredicate() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualConditionalResult = builder.conditional(mock(Predicate.class));

    // Assert
    assertSame(builder, actualConditionalResult);
  }

  /**
   * Test Builder {@link Builder#conditional(Predicate, Operation)} with {@code predicate}, {@code
   * transform}.
   *
   * <p>Method under test: {@link Builder#conditional(Predicate, Operation)}
   */
  @Test
  @DisplayName("Test Builder conditional(Predicate, Operation) with 'predicate', 'transform'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.conditional(Predicate, Operation)"})
  void testBuilderConditionalWithPredicateTransform() {
    // Arrange
    Builder builder = new Builder();
    Predicate predicate = mock(Predicate.class);

    // Act
    Builder actualConditionalResult = builder.conditional(predicate, new AddNamedOperation());

    // Assert
    assertSame(builder, actualConditionalResult);
  }

  /**
   * Test Builder {@link Builder#includePartial()}.
   *
   * <p>Method under test: {@link Builder#includePartial()}
   */
  @Test
  @DisplayName("Test Builder includePartial()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.includePartial()"})
  void testBuilderIncludePartial() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIncludePartialResult = builder.includePartial();

    // Assert
    assertSame(builder, actualIncludePartialResult);
  }

  /**
   * Test Builder {@link Builder#includePartial(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link Builder#includePartial(boolean)}
   */
  @Test
  @DisplayName("Test Builder includePartial(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.includePartial(boolean)"})
  void testBuilderIncludePartialWithBoolean() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIncludePartialResult = builder.includePartial(true);

    // Assert
    assertSame(builder, actualIncludePartialResult);
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
    GetWalks _getOpResult = actualBuilder._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableWalk);
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getConditional());
    assertEquals(0, _getOpResult.getNumberOfGetEdgeOperations());
    assertFalse(_getOpResult.isIncludePartial());
    assertTrue(_getOpResult.getOperations().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, _getOpResult.getOperationsClass());
    assertEquals(GetWalks.DEFAULT_RESULTS_LIMIT, _getOpResult.getResultsLimit().intValue());
    GetWalks actualGetWalks = actualBuilder.build();
    assertSame(_getOpResult, actualGetWalks);
  }

  /**
   * Test Builder {@link Builder#operations(List)} with {@code List}.
   *
   * <p>Method under test: {@link Builder#operations(List)}
   */
  @Test
  @DisplayName("Test Builder operations(List) with 'List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operations(List)"})
  void testBuilderOperationsWithList() {
    // Arrange
    Builder builder = new Builder();

    NamedOperation<Object, Iterable<Element>> namedOperation = new NamedOperation<>();
    namedOperation.addOption("Name", "42");

    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    operations.add(namedOperation);

    // Act and Assert
    List<OperationChain<Iterable<Element>>> operations2 =
        builder.operations(operations)._getOp().getOperations();
    assertEquals(1, operations2.size());
    OperationChain<Iterable<Element>> getResult = operations2.get(0);
    List<Operation> operations3 = getResult.getOperations();
    assertEquals(1, operations3.size());
    Operation getResult2 = operations3.get(0);
    assertTrue(getResult2 instanceof NamedOperation);
    Map<String, String> options = getResult.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get("Name"));
    assertSame(options, getResult2.getOptions());
  }

  /**
   * Test Builder {@link Builder#operations(List)} with {@code List}.
   *
   * <ul>
   *   <li>Then return _getOp Operations is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operations(List)}
   */
  @Test
  @DisplayName(
      "Test Builder operations(List) with 'List'; then return _getOp Operations is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operations(List)"})
  void testBuilderOperationsWithList_thenReturn_getOpOperationsIsArrayList() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    OperationChain<Iterable<Element>> wrapResult = OperationChain.wrap(new NamedOperation<>());
    operations.add(wrapResult);

    // Act and Assert
    assertEquals(operations, builder.operations(operations)._getOp().getOperations());
  }

  /**
   * Test Builder {@link Builder#operations(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#operations(List)}
   */
  @Test
  @DisplayName(
      "Test Builder operations(List) with 'List'; when ArrayList(); then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operations(List)"})
  void testBuilderOperationsWithList_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOperationsResult = builder.operations(new ArrayList<>());

    // Assert
    assertSame(builder, actualOperationsResult);
  }

  /**
   * Test Builder {@link Builder#operations(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#operations(List)}
   */
  @Test
  @DisplayName(
      "Test Builder operations(List) with 'List'; when 'null'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operations(List)"})
  void testBuilderOperationsWithList_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOperationsResult = builder.operations((List<Output<Iterable<Element>>>) null);

    // Assert
    assertSame(builder, actualOperationsResult);
  }

  /**
   * Test Builder {@link Builder#operations(Output[])} with {@code Output[]}.
   *
   * <ul>
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#operations(Output[])}
   */
  @Test
  @DisplayName(
      "Test Builder operations(Output[]) with 'Output[]'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operations(Output[])"})
  void testBuilderOperationsWithOutput_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOperationsResult = builder.operations();

    // Assert
    assertSame(builder, actualOperationsResult);
  }

  /**
   * Test Builder {@link Builder#operations(Output[])} with {@code Output[]}.
   *
   * <ul>
   *   <li>Then return _getOp Operations first is {@link OperationChain#OperationChain()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operations(Output[])}
   */
  @Test
  @DisplayName(
      "Test Builder operations(Output[]) with 'Output[]'; then return _getOp Operations first is OperationChain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operations(Output[])"})
  void testBuilderOperationsWithOutput_thenReturn_getOpOperationsFirstIsOperationChain() {
    // Arrange
    Builder builder = new Builder();

    OperationChain<Object> operationChain = new OperationChain<>();
    operationChain.addOption("Name", "42");

    // Act
    Builder actualOperationsResult = builder.operations(operationChain);

    // Assert
    GetWalks _getOpResult = actualOperationsResult._getOp();
    assertTrue(_getOpResult.getOutputTypeReference() instanceof IterableWalk);
    List<OperationChain<Iterable<Element>>> operations = _getOpResult.getOperations();
    assertEquals(1, operations.size());
    assertSame(operationChain, operations.get(0));
    GetWalks actualGetWalks = actualOperationsResult.build();
    assertSame(_getOpResult, actualGetWalks);
  }

  /**
   * Test Builder {@link Builder#operations(Output[])} with {@code Output[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#operations(Output[])}
   */
  @Test
  @DisplayName(
      "Test Builder operations(Output[]) with 'Output[]'; when 'null'; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operations(Output[])"})
  void testBuilderOperationsWithOutput_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualOperationsResult = builder.operations((Output[]) null);

    // Assert
    assertSame(builder, actualOperationsResult);
  }

  /**
   * Test Builder {@link Builder#resultsLimit(Integer)}.
   *
   * <p>Method under test: {@link Builder#resultsLimit(Integer)}
   */
  @Test
  @DisplayName("Test Builder resultsLimit(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.resultsLimit(Integer)"})
  void testBuilderResultsLimit() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualResultsLimitResult = builder.resultsLimit(1);

    // Assert
    assertSame(builder, actualResultsLimitResult);
  }

  /**
   * Test {@link GetWalks#getInput()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#getInput()}
   */
  @Test
  @DisplayName("Test getInput(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable GetWalks.getInput()"})
  void testGetInput_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GetWalks().getInput());
  }

  /**
   * Test {@link GetWalks#getOperations()}.
   *
   * <p>Method under test: {@link GetWalks#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GetWalks.getOperations()"})
  void testGetOperations() {
    // Arrange, Act and Assert
    assertTrue(new GetWalks().getOperations().isEmpty());
  }

  /**
   * Test {@link GetWalks#setOperations(List)}.
   *
   * <ul>
   *   <li>Then {@link GetWalks} (default constructor) Operations first is wrap {@link
   *       NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#setOperations(List)}
   */
  @Test
  @DisplayName(
      "Test setOperations(List); then GetWalks (default constructor) Operations first is wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetWalks.setOperations(List)"})
  void testSetOperations_thenGetWalksOperationsFirstIsWrapNamedOperation() {
    // Arrange
    GetWalks getWalks = new GetWalks();

    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    OperationChain<Iterable<Element>> wrapResult = OperationChain.wrap(new NamedOperation<>());
    operations.add(wrapResult);

    // Act
    getWalks.setOperations(operations);

    // Assert
    List<OperationChain<Iterable<Element>>> operations2 = getWalks.getOperations();
    assertEquals(1, operations2.size());
    assertSame(wrapResult, operations2.get(0));
  }

  /**
   * Test {@link GetWalks#setOperations(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link GetWalks} (default constructor) Operations Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#setOperations(List)}
   */
  @Test
  @DisplayName(
      "Test setOperations(List); when ArrayList(); then GetWalks (default constructor) Operations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetWalks.setOperations(List)"})
  void testSetOperations_whenArrayList_thenGetWalksOperationsEmpty() {
    // Arrange
    GetWalks getWalks = new GetWalks();

    // Act
    getWalks.setOperations(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(getWalks.getOperations().isEmpty());
  }

  /**
   * Test {@link GetWalks#addOperations(List)}.
   *
   * <ul>
   *   <li>Then {@link GetWalks} (default constructor) Operations first is wrap {@link
   *       NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#addOperations(List)}
   */
  @Test
  @DisplayName(
      "Test addOperations(List); then GetWalks (default constructor) Operations first is wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetWalks.addOperations(List)"})
  void testAddOperations_thenGetWalksOperationsFirstIsWrapNamedOperation() {
    // Arrange
    GetWalks getWalks = new GetWalks();

    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    OperationChain<Iterable<Element>> wrapResult = OperationChain.wrap(new NamedOperation<>());
    operations.add(wrapResult);

    // Act
    getWalks.addOperations(operations);

    // Assert
    List<OperationChain<Iterable<Element>>> operations2 = getWalks.getOperations();
    assertEquals(1, operations2.size());
    assertSame(wrapResult, operations2.get(0));
  }

  /**
   * Test {@link GetWalks#addOperations(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link GetWalks} (default constructor) Operations Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#addOperations(List)}
   */
  @Test
  @DisplayName(
      "Test addOperations(List); when ArrayList(); then GetWalks (default constructor) Operations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetWalks.addOperations(List)"})
  void testAddOperations_whenArrayList_thenGetWalksOperationsEmpty() {
    // Arrange
    GetWalks getWalks = new GetWalks();

    // Act
    getWalks.addOperations(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(getWalks.getOperations().isEmpty());
  }

  /**
   * Test {@link GetWalks#validate()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link If} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#validate()}
   */
  @Test
  @DisplayName("Test validate(); given ArrayList() add If (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult GetWalks.validate()"})
  void testValidate_givenArrayListAddIf() {
    // Arrange
    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    operations.add(new If<>());

    GetWalks getWalks = new GetWalks();
    getWalks.addOperations(operations);

    // Act
    ValidationResult actualValidateResult = getWalks.validate();

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "No hops were provided. A hop is a GetElements operation that selects at least 1 edge group.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(
        errors.contains(
            "No hops were provided. A hop is a GetElements operation that selects at least 1 edge group."));
  }

  /**
   * Test {@link GetWalks#validate()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#validate()}
   */
  @Test
  @DisplayName("Test validate(); given ArrayList() add NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult GetWalks.validate()"})
  void testValidate_givenArrayListAddNamedOperation() {
    // Arrange
    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    operations.add(new NamedOperation<>());

    GetWalks getWalks = new GetWalks();
    getWalks.addOperations(operations);

    // Act
    ValidationResult actualValidateResult = getWalks.validate();

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "No hops were provided. A hop is a GetElements operation that selects at least 1 edge group.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(
        errors.contains(
            "No hops were provided. A hop is a GetElements operation that selects at least 1 edge group."));
  }

  /**
   * Test {@link GetWalks#validate()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#validate()}
   */
  @Test
  @DisplayName("Test validate(); given ArrayList() add NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult GetWalks.validate()"})
  void testValidate_givenArrayListAddNamedOperation2() {
    // Arrange
    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    operations.add(new NamedOperation<>());
    operations.add(new NamedOperation<>());

    GetWalks getWalks = new GetWalks();
    getWalks.addOperations(operations);

    // Act
    ValidationResult actualValidateResult = getWalks.validate();

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "No hops were provided. A hop is a GetElements operation that selects at least 1 edge group.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(
        errors.contains(
            "No hops were provided. A hop is a GetElements operation that selects at least 1 edge group."));
  }

  /**
   * Test {@link GetWalks#validate()}.
   *
   * <ul>
   *   <li>Given {@link GetWalks} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#validate()}
   */
  @Test
  @DisplayName("Test validate(); given GetWalks (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult GetWalks.validate()"})
  void testValidate_givenGetWalks() {
    // Arrange and Act
    ValidationResult actualValidateResult = new GetWalks().validate();

    // Assert
    assertEquals(
        "Validation errors: \n"
            + "No hops were provided. A hop is a GetElements operation that selects at least 1 edge group.",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(
        errors.contains(
            "No hops were provided. A hop is a GetElements operation that selects at least 1 edge group."));
  }

  /**
   * Test {@link GetWalks#flatten()}.
   *
   * <p>Method under test: {@link GetWalks#flatten()}
   */
  @Test
  @DisplayName("Test flatten()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List GetWalks.flatten()"})
  void testFlatten() {
    // Arrange
    GetWalks getWalks = new GetWalks();

    // Act
    List<Operation> actualFlattenResult = getWalks.flatten();

    // Assert
    assertEquals(1, actualFlattenResult.size());
    assertSame(getWalks, actualFlattenResult.get(0));
  }

  /**
   * Test {@link GetWalks#getNumberOfGetEdgeOperations()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link If} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#getNumberOfGetEdgeOperations()}
   */
  @Test
  @DisplayName(
      "Test getNumberOfGetEdgeOperations(); given ArrayList() add If (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GetWalks.getNumberOfGetEdgeOperations()"})
  void testGetNumberOfGetEdgeOperations_givenArrayListAddIf() {
    // Arrange
    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    operations.add(new If<>());

    GetWalks getWalks = new GetWalks();
    getWalks.addOperations(operations);

    // Act and Assert
    assertEquals(0, getWalks.getNumberOfGetEdgeOperations());
  }

  /**
   * Test {@link GetWalks#getNumberOfGetEdgeOperations()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#getNumberOfGetEdgeOperations()}
   */
  @Test
  @DisplayName(
      "Test getNumberOfGetEdgeOperations(); given ArrayList() add NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GetWalks.getNumberOfGetEdgeOperations()"})
  void testGetNumberOfGetEdgeOperations_givenArrayListAddNamedOperation() {
    // Arrange
    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    operations.add(new NamedOperation<>());

    GetWalks getWalks = new GetWalks();
    getWalks.addOperations(operations);

    // Act and Assert
    assertEquals(0, getWalks.getNumberOfGetEdgeOperations());
  }

  /**
   * Test {@link GetWalks#getNumberOfGetEdgeOperations()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#getNumberOfGetEdgeOperations()}
   */
  @Test
  @DisplayName(
      "Test getNumberOfGetEdgeOperations(); given ArrayList() add NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GetWalks.getNumberOfGetEdgeOperations()"})
  void testGetNumberOfGetEdgeOperations_givenArrayListAddNamedOperation2() {
    // Arrange
    ArrayList<Output<Iterable<Element>>> operations = new ArrayList<>();
    operations.add(new NamedOperation<>());
    operations.add(new NamedOperation<>());

    GetWalks getWalks = new GetWalks();
    getWalks.addOperations(operations);

    // Act and Assert
    assertEquals(0, getWalks.getNumberOfGetEdgeOperations());
  }

  /**
   * Test {@link GetWalks#getNumberOfGetEdgeOperations()}.
   *
   * <ul>
   *   <li>Given {@link GetWalks} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#getNumberOfGetEdgeOperations()}
   */
  @Test
  @DisplayName("Test getNumberOfGetEdgeOperations(); given GetWalks (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GetWalks.getNumberOfGetEdgeOperations()"})
  void testGetNumberOfGetEdgeOperations_givenGetWalks() {
    // Arrange, Act and Assert
    assertEquals(0, new GetWalks().getNumberOfGetEdgeOperations());
  }

  /**
   * Test {@link GetWalks#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link GetWalks#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeReference GetWalks.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<Walk>> actualOutputTypeReference =
        new GetWalks().getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableWalk);
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.data.graph.Walk>",
        actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetWalks#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetWalks} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetWalks (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetWalks GetWalks.shallowClone()"})
  void testShallowClone_givenGetWalksOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    GetWalks getWalks = new GetWalks();
    getWalks.setOptions(new HashMap<>());

    // Act
    GetWalks actualShallowCloneResult = getWalks.shallowClone();

    // Assert
    TypeReference<Iterable<Walk>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableWalk);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.data.graph.Walk>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getConditional());
    assertEquals(0, actualShallowCloneResult.getNumberOfGetEdgeOperations());
    assertFalse(actualShallowCloneResult.isIncludePartial());
    assertTrue(actualShallowCloneResult.getOperations().isEmpty());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
    assertEquals(
        GetWalks.DEFAULT_RESULTS_LIMIT, actualShallowCloneResult.getResultsLimit().intValue());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetWalks#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link GetWalks} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetWalks#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given GetWalks (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"GetWalks GetWalks.shallowClone()"})
  void testShallowClone_givenGetWalks_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetWalks actualShallowCloneResult = new GetWalks().shallowClone();

    // Assert
    TypeReference<Iterable<Walk>> outputTypeReference =
        actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableWalk);
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals(
        "java.lang.Iterable<uk.gov.gchq.gaffer.data.graph.Walk>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getInput());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getConditional());
    assertEquals(0, actualShallowCloneResult.getNumberOfGetEdgeOperations());
    assertFalse(actualShallowCloneResult.isIncludePartial());
    assertTrue(actualShallowCloneResult.getOperations().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualShallowCloneResult.getOperationsClass());
    assertEquals(
        GetWalks.DEFAULT_RESULTS_LIMIT, actualShallowCloneResult.getResultsLimit().intValue());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link GetWalks}
   *   <li>{@link GetWalks#setConditional(Conditional)}
   *   <li>{@link GetWalks#setIncludePartial(boolean)}
   *   <li>{@link GetWalks#setInput(Iterable)}
   *   <li>{@link GetWalks#setOptions(Map)}
   *   <li>{@link GetWalks#setResultsLimit(Integer)}
   *   <li>{@link GetWalks#getConditional()}
   *   <li>{@link GetWalks#getOptions()}
   *   <li>{@link GetWalks#getResultsLimit()}
   *   <li>{@link GetWalks#isIncludePartial()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetWalks.<init>()",
    "Conditional GetWalks.getConditional()",
    "Map GetWalks.getOptions()",
    "Integer GetWalks.getResultsLimit()",
    "boolean GetWalks.isIncludePartial()",
    "void GetWalks.setConditional(Conditional)",
    "void GetWalks.setIncludePartial(boolean)",
    "void GetWalks.setInput(Iterable)",
    "void GetWalks.setOptions(Map)",
    "void GetWalks.setResultsLimit(Integer)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    GetWalks actualGetWalks = new GetWalks();
    Conditional conditional = new Conditional();
    actualGetWalks.setConditional(conditional);
    actualGetWalks.setIncludePartial(true);
    ArrayList<EntityId> input = new ArrayList<>();
    actualGetWalks.setInput(input);
    HashMap<String, String> options = new HashMap<>();
    actualGetWalks.setOptions(options);
    actualGetWalks.setResultsLimit(1);
    Conditional actualConditional = actualGetWalks.getConditional();
    Map<String, String> actualOptions = actualGetWalks.getOptions();
    Integer actualResultsLimit = actualGetWalks.getResultsLimit();
    boolean actualIsIncludePartialResult = actualGetWalks.isIncludePartial();

    // Assert
    Iterable<? extends EntityId> input2 = actualGetWalks.getInput();
    assertTrue(input2 instanceof List);
    assertEquals(1, actualResultsLimit.intValue());
    assertTrue(actualGetWalks.getOperations().isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualIsIncludePartialResult);
    assertSame(input, input2);
    assertSame(options, actualOptions);
    assertSame(conditional, actualConditional);
  }
}
