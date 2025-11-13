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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.If.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.util.Conditional;

class IfDiffblueTest {
  /**
   * Test Builder {@link Builder#condition(Boolean)}.
   *
   * <p>Method under test: {@link Builder#condition(Boolean)}
   */
  @Test
  @DisplayName("Test Builder condition(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.condition(Boolean)"})
  void testBuilderCondition() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualConditionResult = builder.condition(true);

    // Assert
    assertSame(builder, actualConditionResult);
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
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualConditionalResult = builder.conditional(new Conditional());

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
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualConditionalResult = builder.conditional(mock(Predicate.class));

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
    Builder<Object, Object> builder = new Builder<>();
    Predicate predicate = mock(Predicate.class);

    // Act
    Builder<Object, Object> actualConditionalResult =
        builder.conditional(predicate, new AddNamedOperation());

    // Assert
    assertSame(builder, actualConditionalResult);
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
    Builder<Object, Object> actualBuilder = new Builder<>();

    // Assert
    If<Object, Object> _getOpResult = actualBuilder._getOp();
    Collection<Operation> operations = _getOpResult.getOperations();
    assertEquals(3, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(_getOpResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(_getOpResult.getCondition());
    assertNull(_getOpResult.getInput());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getOtherwise());
    assertNull(_getOpResult.getThen());
    assertNull(_getOpResult.getConditional());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, _getOpResult.getOperationsClass());
    If<Object, Object> actualResultIf = actualBuilder.build();
    assertSame(_getOpResult, actualResultIf);
  }

  /**
   * Test Builder {@link Builder#otherwise(Operation)}.
   *
   * <p>Method under test: {@link Builder#otherwise(Operation)}
   */
  @Test
  @DisplayName("Test Builder otherwise(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.otherwise(Operation)"})
  void testBuilderOtherwise() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualOtherwiseResult = builder.otherwise(new AddNamedOperation());

    // Assert
    assertSame(builder, actualOtherwiseResult);
  }

  /**
   * Test Builder {@link Builder#then(Operation)}.
   *
   * <p>Method under test: {@link Builder#then(Operation)}
   */
  @Test
  @DisplayName("Test Builder then(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.then(Operation)"})
  void testBuilderThen() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act
    Builder<Object, Object> actualThenResult = builder.then(new AddNamedOperation());

    // Assert
    assertSame(builder, actualThenResult);
  }

  /**
   * Test {@link If#getOutputTypeReference()}.
   *
   * <p>Method under test: {@link If#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"com.fasterxml.jackson.core.type.TypeReference If.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act and Assert
    assertTrue(resultIf.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link If#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link If} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return {@link If} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link If#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given If (default constructor) Options is HashMap(); then return If (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"If If.shallowClone()"})
  void testShallowClone_givenIfOptionsIsHashMap_thenReturnIf() throws CloneFailedException {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    resultIf.setOptions(new HashMap<>());

    // Act
    If<Object, Object> actualShallowCloneResult = resultIf.shallowClone();

    // Assert
    assertEquals(resultIf, actualShallowCloneResult);
  }

  /**
   * Test {@link If#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link If} (default constructor).
   *   <li>Then return {@link If} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link If#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given If (default constructor); then return If (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"If If.shallowClone()"})
  void testShallowClone_givenIf_thenReturnIf() throws CloneFailedException {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act
    If<Object, Object> actualShallowCloneResult = resultIf.shallowClone();

    // Assert
    assertEquals(resultIf, actualShallowCloneResult);
  }

  /**
   * Test {@link If#shallowClone()}.
   *
   * <ul>
   *   <li>Then Conditional Transform return {@link AddNamedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link If#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then Conditional Transform return AddNamedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"If If.shallowClone()"})
  void testShallowClone_thenConditionalTransformReturnAddNamedOperation()
      throws CloneFailedException {
    // Arrange
    Conditional conditional = new Conditional(mock(Predicate.class));
    conditional.setTransform(new AddNamedOperation());

    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(conditional);
    resultIf.setThen(new AddNamedOperation());
    resultIf.setOtherwise(new AddNamedOperation());

    // Act
    If<Object, Object> actualShallowCloneResult = resultIf.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertEquals(3, operations.size());
    assertTrue(operations instanceof List);
    Operation transform = actualShallowCloneResult.getConditional().getTransform();
    assertTrue(transform instanceof AddNamedOperation);
    Operation getResult = ((List<Operation>) operations).get(0);
    assertTrue(getResult instanceof OperationChain);
    assertNull(((AddNamedOperation) transform).getScore());
    assertNull(((AddNamedOperation) transform).getDescription());
    assertNull(((AddNamedOperation) transform).getOperationChainAsString());
    assertNull(((AddNamedOperation) transform).getOperationName());
    assertNull(((AddNamedOperation) transform).getLabels());
    assertNull(((AddNamedOperation) transform).getReadAccessRoles());
    assertNull(((AddNamedOperation) transform).getWriteAccessRoles());
    assertNull(transform.getOptions());
    assertNull(((AddNamedOperation) transform).getParameters());
    assertNull(((AddNamedOperation) transform).getReadAccessPredicate());
    assertNull(((AddNamedOperation) transform).getWriteAccessPredicate());
    assertEquals(1, ((OperationChain<Object>) getResult).getOperations().size());
    assertFalse(((AddNamedOperation) transform).isOverwriteFlag());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, ((AddNamedOperation) transform).getOperationsClass());
  }

  /**
   * Test {@link If#shallowClone()}.
   *
   * <ul>
   *   <li>Then Otherwise return {@link AddNamedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link If#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then Otherwise return AddNamedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"If If.shallowClone()"})
  void testShallowClone_thenOtherwiseReturnAddNamedOperation() throws CloneFailedException {
    // Arrange
    Conditional conditional = new Conditional(mock(Predicate.class));
    conditional.setTransform(null);

    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(conditional);
    resultIf.setThen(new AddNamedOperation());
    resultIf.setOtherwise(new AddNamedOperation());

    // Act
    If<Object, Object> actualShallowCloneResult = resultIf.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertEquals(3, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(actualShallowCloneResult.getOtherwise() instanceof AddNamedOperation);
    assertTrue(actualShallowCloneResult.getThen() instanceof AddNamedOperation);
    assertEquals(conditional, actualShallowCloneResult.getConditional());
  }

  /**
   * Test {@link If#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link If#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given AddNamedOperation (default constructor) Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection If.getOperations()"})
  void testGetOperations_givenAddNamedOperationOptionsIsNull() {
    // Arrange
    AddNamedOperation transform = new AddNamedOperation();
    transform.setOptions(new HashMap<>());

    Conditional conditional = new Conditional(mock(Predicate.class));
    conditional.setTransform(transform);

    AddNamedOperation then = new AddNamedOperation();
    then.setOptions(new HashMap<>());

    AddNamedOperation otherwise = new AddNamedOperation();
    otherwise.setOptions(null);

    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(conditional);
    resultIf.setThen(then);
    resultIf.setOtherwise(otherwise);

    // Act
    Collection<Operation> actualOperations = resultIf.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(3, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(2);
    assertTrue(getResult instanceof OperationChain);
    List<Operation> operations = ((OperationChain<Object>) getResult).getOperations();
    assertEquals(1, operations.size());
    assertSame(otherwise, operations.get(0));
  }

  /**
   * Test {@link If#getOperations()}.
   *
   * <ul>
   *   <li>Given {@link If} (default constructor).
   *   <li>Then first return {@link OperationChain}.
   * </ul>
   *
   * <p>Method under test: {@link If#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); given If (default constructor); then first return OperationChain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection If.getOperations()"})
  void testGetOperations_givenIf_thenFirstReturnOperationChain() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act
    Collection<Operation> actualOperations = resultIf.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(3, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(0);
    assertTrue(getResult instanceof OperationChain);
    Operation getResult2 = ((List<Operation>) actualOperations).get(1);
    assertTrue(getResult2 instanceof OperationChain);
    Operation getResult3 = ((List<Operation>) actualOperations).get(2);
    assertTrue(getResult3 instanceof OperationChain);
    assertTrue(((OperationChain<Object>) getResult).getOperations().isEmpty());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
  }

  /**
   * Test {@link If#getOperations()}.
   *
   * <ul>
   *   <li>Then return third is wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link If#getOperations()}
   */
  @Test
  @DisplayName(
      "Test getOperations(); then return third is wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection If.getOperations()"})
  void testGetOperations_thenReturnThirdIsWrapNamedOperation() {
    // Arrange
    AddNamedOperation transform = new AddNamedOperation();
    transform.setOptions(new HashMap<>());

    Conditional conditional = new Conditional(mock(Predicate.class));
    conditional.setTransform(transform);

    AddNamedOperation then = new AddNamedOperation();
    then.setOptions(new HashMap<>());

    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(conditional);
    resultIf.setThen(then);
    OperationChain<Object> otherwise = OperationChain.wrap(new NamedOperation<>());
    resultIf.setOtherwise(otherwise);

    // Act
    Collection<Operation> actualOperations = resultIf.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(3, actualOperations.size());
    assertSame(otherwise, ((List<Operation>) actualOperations).get(2));
  }

  /**
   * Test {@link If#getOperations()}.
   *
   * <ul>
   *   <li>Then return third Operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link If#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); then return third Operations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection If.getOperations()"})
  void testGetOperations_thenReturnThirdOperationsSizeIsOne() {
    // Arrange
    AddNamedOperation transform = new AddNamedOperation();
    transform.setOptions(new HashMap<>());

    Conditional conditional = new Conditional(mock(Predicate.class));
    conditional.setTransform(transform);

    AddNamedOperation then = new AddNamedOperation();
    then.setOptions(new HashMap<>());

    AddNamedOperation otherwise = new AddNamedOperation();
    otherwise.setOptions(new HashMap<>());

    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(conditional);
    resultIf.setThen(then);
    resultIf.setOtherwise(otherwise);

    // Act
    Collection<Operation> actualOperations = resultIf.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(3, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(2);
    assertTrue(getResult instanceof OperationChain);
    List<Operation> operations = ((OperationChain<Object>) getResult).getOperations();
    assertEquals(1, operations.size());
    assertSame(otherwise, operations.get(0));
  }

  /**
   * Test {@link If#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Given {@link ForEach} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link ForEach} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); given ForEach (default constructor); when ArrayList() add ForEach (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void If.updateOperations(Collection)"})
  void testUpdateOperations_givenForEach_whenArrayListAddForEach() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    ArrayList<Operation> operations = new ArrayList<>();
    operations.add(new ForEach<>());
    operations.add(new AddNamedOperation());
    operations.add(new AddNamedOperation());

    // Act
    resultIf.updateOperations(operations);

    // Assert that nothing has changed
    Collection<Operation> operations2 = resultIf.getOperations();
    assertEquals(3, operations2.size());
    assertTrue(operations2 instanceof List);
    Operation getResult = ((List<Operation>) operations2).get(0);
    assertTrue(getResult instanceof OperationChain);
    Operation getResult2 = ((List<Operation>) operations2).get(2);
    assertTrue(getResult2 instanceof OperationChain);
    assertTrue(((OperationChain<Object>) getResult).getOperations().isEmpty());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link If#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Given {@link If} (default constructor) Conditional is {@link Conditional#Conditional()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); given If (default constructor) Conditional is Conditional(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void If.updateOperations(Collection)"})
  void testUpdateOperations_givenIfConditionalIsConditional_whenNull() {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(new Conditional());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resultIf.updateOperations(null));
  }

  /**
   * Test {@link If#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Given {@link If} (default constructor).
   *   <li>Then {@link If} (default constructor) Operations first Operations Empty.
   * </ul>
   *
   * <p>Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); given If (default constructor); then If (default constructor) Operations first Operations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void If.updateOperations(Collection)"})
  void testUpdateOperations_givenIf_thenIfOperationsFirstOperationsEmpty() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    ArrayList<Operation> operations = new ArrayList<>();
    operations.add(new AddNamedOperation());
    operations.add(new AddNamedOperation());
    operations.add(new AddNamedOperation());

    // Act
    resultIf.updateOperations(operations);

    // Assert that nothing has changed
    Collection<Operation> operations2 = resultIf.getOperations();
    assertEquals(3, operations2.size());
    assertTrue(operations2 instanceof List);
    Operation getResult = ((List<Operation>) operations2).get(0);
    assertTrue(getResult instanceof OperationChain);
    Operation getResult2 = ((List<Operation>) operations2).get(2);
    assertTrue(getResult2 instanceof OperationChain);
    assertTrue(((OperationChain<Object>) getResult).getOperations().isEmpty());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link If#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Given {@link If} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); given If (default constructor); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void If.updateOperations(Collection)"})
  void testUpdateOperations_givenIf_thenThrowIllegalArgumentException() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    ArrayList<Operation> operations = new ArrayList<>();
    operations.add(new AddNamedOperation());
    operations.add(new AddNamedOperation());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resultIf.updateOperations(operations));
  }

  /**
   * Test {@link If#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Given {@link If} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); given If (default constructor); when ArrayList(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void If.updateOperations(Collection)"})
  void testUpdateOperations_givenIf_whenArrayList_thenThrowIllegalArgumentException() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> resultIf.updateOperations(new ArrayList<>()));
  }

  /**
   * Test {@link If#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Given {@link OperationImpl} (default constructor).
   *   <li>Then {@link If} (default constructor) Conditional Predicate is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); given OperationImpl (default constructor); then If (default constructor) Conditional Predicate is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void If.updateOperations(Collection)"})
  void testUpdateOperations_givenOperationImpl_thenIfConditionalPredicateIsNull() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    ArrayList<Operation> operations = new ArrayList<>();
    OperationImpl operationImpl = new OperationImpl();
    operations.add(operationImpl);
    operations.add(new AddNamedOperation());
    operations.add(new AddNamedOperation());

    // Act
    resultIf.updateOperations(operations);

    // Assert
    Collection<Operation> operations2 = resultIf.getOperations();
    assertEquals(3, operations2.size());
    assertTrue(operations2 instanceof List);
    Operation getResult = ((List<Operation>) operations2).get(0);
    assertTrue(getResult instanceof OperationChain);
    Operation getResult2 = ((List<Operation>) operations2).get(2);
    assertTrue(getResult2 instanceof OperationChain);
    Conditional conditional = resultIf.getConditional();
    assertNull(conditional.getPredicate());
    List<Operation> operations3 = ((OperationChain<Object>) getResult).getOperations();
    assertEquals(1, operations3.size());
    assertEquals(((List<Operation>) operations2).get(1), getResult2);
    assertSame(operationImpl, operations3.get(0));
    assertSame(operationImpl, conditional.getTransform());
  }

  /**
   * Test {@link If#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>Then {@link If} (default constructor) Operations first Operations Empty.
   * </ul>
   *
   * <p>Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); then If (default constructor) Operations first Operations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void If.updateOperations(Collection)"})
  void testUpdateOperations_thenIfOperationsFirstOperationsEmpty() {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(new Conditional());

    ArrayList<Operation> operations = new ArrayList<>();
    operations.add(new AddNamedOperation());
    operations.add(new AddNamedOperation());
    operations.add(new AddNamedOperation());

    // Act
    resultIf.updateOperations(operations);

    // Assert that nothing has changed
    Collection<Operation> operations2 = resultIf.getOperations();
    assertEquals(3, operations2.size());
    assertTrue(operations2 instanceof List);
    Operation getResult = ((List<Operation>) operations2).get(0);
    assertTrue(getResult instanceof OperationChain);
    Operation getResult2 = ((List<Operation>) operations2).get(2);
    assertTrue(getResult2 instanceof OperationChain);
    assertTrue(((OperationChain<Object>) getResult).getOperations().isEmpty());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link If#updateOperations(Collection)}.
   *
   * <ul>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@link AddNamedOperation} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName(
      "Test updateOperations(Collection); when LinkedHashSet() add AddNamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void If.updateOperations(Collection)"})
  void testUpdateOperations_whenLinkedHashSetAddAddNamedOperation() {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(new Conditional());

    LinkedHashSet<Operation> operations = new LinkedHashSet<>();
    operations.add(new AddNamedOperation());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resultIf.updateOperations(operations));
  }

  /**
   * Test {@link If#equals(Object)}, and {@link If#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link If#equals(Object)}
   *   <li>{@link If#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean If.equals(Object)", "int If.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    If<Object, Object> resultIf2 = new If<>();

    // Act and Assert
    assertEquals(resultIf, resultIf2);
    assertEquals(resultIf.hashCode(), resultIf2.hashCode());
  }

  /**
   * Test {@link If#equals(Object)}, and {@link If#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link If#equals(Object)}
   *   <li>{@link If#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean If.equals(Object)", "int If.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act and Assert
    assertEquals(resultIf, resultIf);
    int expectedHashCodeResult = resultIf.hashCode();
    assertEquals(expectedHashCodeResult, resultIf.hashCode());
  }

  /**
   * Test {@link If#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link If#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean If.equals(Object)", "int If.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    resultIf.setOptions(new HashMap<>());

    // Act and Assert
    assertNotEquals(resultIf, new If<>());
  }

  /**
   * Test {@link If#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link If#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean If.equals(Object)", "int If.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act and Assert
    assertNotEquals(resultIf, null);
  }

  /**
   * Test {@link If#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link If#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean If.equals(Object)", "int If.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act and Assert
    assertNotEquals(resultIf, "Different type to If");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link If}
   *   <li>{@link If#setCondition(Boolean)}
   *   <li>{@link If#setConditional(Conditional)}
   *   <li>{@link If#setOptions(Map)}
   *   <li>{@link If#setOtherwise(Operation)}
   *   <li>{@link If#setThen(Operation)}
   *   <li>{@link If#toString()}
   *   <li>{@link If#getCondition()}
   *   <li>{@link If#getConditional()}
   *   <li>{@link If#getOptions()}
   *   <li>{@link If#getOtherwise()}
   *   <li>{@link If#getThen()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void If.<init>()",
    "Boolean If.getCondition()",
    "Conditional If.getConditional()",
    "Map If.getOptions()",
    "Operation If.getOtherwise()",
    "Operation If.getThen()",
    "void If.setCondition(Boolean)",
    "void If.setConditional(Conditional)",
    "void If.setOptions(Map)",
    "void If.setOtherwise(Operation)",
    "void If.setThen(Operation)",
    "String If.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    If<Object, Object> actualResultIf = new If<>();
    actualResultIf.setCondition(true);
    Conditional conditional = new Conditional();
    actualResultIf.setConditional(conditional);
    HashMap<String, String> options = new HashMap<>();
    actualResultIf.setOptions(options);
    AddNamedOperation otherwise = new AddNamedOperation();
    actualResultIf.setOtherwise(otherwise);
    AddNamedOperation then = new AddNamedOperation();
    actualResultIf.setThen(then);
    actualResultIf.toString();
    Boolean actualCondition = actualResultIf.getCondition();
    Conditional actualConditional = actualResultIf.getConditional();
    Map<String, String> actualOptions = actualResultIf.getOptions();
    Operation actualOtherwise = actualResultIf.getOtherwise();
    Operation actualThen = actualResultIf.getThen();

    // Assert
    assertNull(actualResultIf.getInput());
    assertTrue(actualOptions.isEmpty());
    assertTrue(actualCondition);
    assertSame(options, actualOptions);
    assertSame(otherwise, actualOtherwise);
    assertSame(then, actualThen);
    assertSame(conditional, actualConditional);
  }
}
