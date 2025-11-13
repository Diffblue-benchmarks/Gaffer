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
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.If.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.util.Conditional;

class IfDiffblueTest {
  /**
   * Test Builder {@link Builder#condition(Boolean)}.
   * <p>
   * Method under test: {@link Builder#condition(Boolean)}
   */
  @Test
  @DisplayName("Test Builder condition(Boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.condition(Boolean)"})
  void testBuilderCondition() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act and Assert
    assertSame(builder, builder.condition(true));
  }

  /**
   * Test Builder {@link Builder#conditional(Conditional)} with {@code conditional}.
   * <p>
   * Method under test: {@link Builder#conditional(Conditional)}
   */
  @Test
  @DisplayName("Test Builder conditional(Conditional) with 'conditional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.conditional(Conditional)"})
  void testBuilderConditionalWithConditional() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act and Assert
    assertSame(builder, builder.conditional(new Conditional()));
  }

  /**
   * Test Builder {@link Builder#conditional(Predicate)} with {@code predicate}.
   * <p>
   * Method under test: {@link Builder#conditional(Predicate)}
   */
  @Test
  @DisplayName("Test Builder conditional(Predicate) with 'predicate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.conditional(Predicate)"})
  void testBuilderConditionalWithPredicate() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act and Assert
    assertSame(builder, builder.conditional(mock(Predicate.class)));
  }

  /**
   * Test Builder {@link Builder#conditional(Predicate, Operation)} with {@code predicate}, {@code transform}.
   * <p>
   * Method under test: {@link Builder#conditional(Predicate, Operation)}
   */
  @Test
  @DisplayName("Test Builder conditional(Predicate, Operation) with 'predicate', 'transform'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.conditional(Predicate, Operation)"})
  void testBuilderConditionalWithPredicateTransform() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();
    Predicate predicate = mock(Predicate.class);

    // Act and Assert
    assertSame(builder, builder.conditional(predicate, new AddNamedOperation()));
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
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
    Class<?> outputClass = _getOpResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, _getOpResult.getOperationsClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputClass, _getOpResult.getOutputType());
  }

  /**
   * Test Builder {@link Builder#otherwise(Operation)}.
   * <p>
   * Method under test: {@link Builder#otherwise(Operation)}
   */
  @Test
  @DisplayName("Test Builder otherwise(Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.otherwise(Operation)"})
  void testBuilderOtherwise() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act and Assert
    assertSame(builder, builder.otherwise(new AddNamedOperation()));
  }

  /**
   * Test Builder {@link Builder#then(Operation)}.
   * <p>
   * Method under test: {@link Builder#then(Operation)}
   */
  @Test
  @DisplayName("Test Builder then(Operation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.then(Operation)"})
  void testBuilderThen() {
    // Arrange
    Builder<Object, Object> builder = new Builder<>();

    // Act and Assert
    assertSame(builder, builder.then(new AddNamedOperation()));
  }

  /**
   * Test {@link If#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link If#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"com.fasterxml.jackson.core.type.TypeReference If.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act and Assert
    assertTrue(resultIf.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link If#shallowClone()}.
   * <ul>
   *   <li>Given {@link If} (default constructor) Conditional is {@link Conditional#Conditional()}.</li>
   *   <li>Then return {@link If} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link If#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given If (default constructor) Conditional is Conditional(); then return If (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"If If.shallowClone()"})
  void testShallowClone_givenIfConditionalIsConditional_thenReturnIf() throws CloneFailedException {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(new Conditional());
    resultIf.setThen(null);
    resultIf.setOtherwise(null);

    // Act and Assert
    assertEquals(resultIf, resultIf.shallowClone());
  }

  /**
   * Test {@link If#shallowClone()}.
   * <ul>
   *   <li>Given {@link If} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given If (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"If If.shallowClone()"})
  void testShallowClone_givenIfOptionsIsHashMap_thenReturnOptionsEmpty() throws CloneFailedException {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    resultIf.setOptions(new HashMap<>());

    // Act
    If<Object, Object> actualShallowCloneResult = resultIf.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertEquals(3, operations.size());
    assertTrue(operations instanceof List);
    Operation getResult = ((List<Operation>) operations).get(1);
    assertTrue(getResult instanceof OperationChain);
    Operation getResult2 = ((List<Operation>) operations).get(2);
    assertTrue(getResult2 instanceof OperationChain);
    assertNull(actualShallowCloneResult.getConditional());
    assertTrue(((OperationChain<Object>) getResult2).getOperations().isEmpty());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertEquals(((List<Operation>) operations).get(0), getResult);
  }

  /**
   * Test {@link If#shallowClone()}.
   * <ul>
   *   <li>Given {@link If} (default constructor) Then is {@link AddNamedOperation} (default constructor).</li>
   *   <li>Then Then Operations return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given If (default constructor) Then is AddNamedOperation (default constructor); then Then Operations return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"If If.shallowClone()"})
  void testShallowClone_givenIfThenIsAddNamedOperation_thenThenOperationsReturnList() throws CloneFailedException {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(null);
    resultIf.setThen(new AddNamedOperation());
    resultIf.setOtherwise(null);

    // Act and Assert
    Operation then = resultIf.shallowClone().getThen();
    Collection<Operation> operations = ((AddNamedOperation) then).getOperations();
    assertTrue(operations instanceof List);
    assertTrue(then instanceof AddNamedOperation);
    assertNull(((AddNamedOperation) then).getScore());
    assertNull(((AddNamedOperation) then).getDescription());
    assertNull(((AddNamedOperation) then).getOperationChainAsString());
    assertNull(((AddNamedOperation) then).getOperationName());
    assertNull(((AddNamedOperation) then).getLabels());
    assertNull(((AddNamedOperation) then).getReadAccessRoles());
    assertNull(((AddNamedOperation) then).getWriteAccessRoles());
    assertNull(then.getOptions());
    assertNull(((AddNamedOperation) then).getParameters());
    assertNull(((AddNamedOperation) then).getReadAccessPredicate());
    assertNull(((AddNamedOperation) then).getWriteAccessPredicate());
    assertFalse(((AddNamedOperation) then).isOverwriteFlag());
    assertTrue(operations.isEmpty());
  }

  /**
   * Test {@link If#shallowClone()}.
   * <ul>
   *   <li>Given {@link If} (default constructor).</li>
   *   <li>Then Operations second return {@link OperationChain}.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given If (default constructor); then Operations second return OperationChain")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"If If.shallowClone()"})
  void testShallowClone_givenIf_thenOperationsSecondReturnOperationChain() throws CloneFailedException {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act
    If<Object, Object> actualShallowCloneResult = resultIf.shallowClone();

    // Assert
    Collection<Operation> operations = actualShallowCloneResult.getOperations();
    assertEquals(3, operations.size());
    assertTrue(operations instanceof List);
    Operation getResult = ((List<Operation>) operations).get(1);
    assertTrue(getResult instanceof OperationChain);
    Operation getResult2 = ((List<Operation>) operations).get(2);
    assertTrue(getResult2 instanceof OperationChain);
    assertNull(actualShallowCloneResult.getConditional());
    assertTrue(((OperationChain<Object>) getResult2).getOperations().isEmpty());
    assertEquals(((List<Operation>) operations).get(0), getResult);
  }

  /**
   * Test {@link If#shallowClone()}.
   * <ul>
   *   <li>Then Conditional Transform Operations return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then Conditional Transform Operations return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"If If.shallowClone()"})
  void testShallowClone_thenConditionalTransformOperationsReturnList() throws CloneFailedException {
    // Arrange
    Conditional conditional = new Conditional();
    conditional.setTransform(new AddNamedOperation());

    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(conditional);
    resultIf.setThen(null);
    resultIf.setOtherwise(null);

    // Act
    If<Object, Object> actualShallowCloneResult = resultIf.shallowClone();

    // Assert
    Operation transform = actualShallowCloneResult.getConditional().getTransform();
    Collection<Operation> operations = ((AddNamedOperation) transform).getOperations();
    assertTrue(operations instanceof List);
    Collection<Operation> operations2 = actualShallowCloneResult.getOperations();
    assertEquals(3, operations2.size());
    assertTrue(operations2 instanceof List);
    assertTrue(transform instanceof AddNamedOperation);
    Operation getResult = ((List<Operation>) operations2).get(0);
    assertTrue(getResult instanceof OperationChain);
    Operation getResult2 = ((List<Operation>) operations2).get(2);
    assertTrue(getResult2 instanceof OperationChain);
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
    assertTrue(operations.isEmpty());
    assertEquals(((List<Operation>) operations2).get(1), getResult2);
  }

  /**
   * Test {@link If#shallowClone()}.
   * <ul>
   *   <li>Then Otherwise Operations return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then Otherwise Operations return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"If If.shallowClone()"})
  void testShallowClone_thenOtherwiseOperationsReturnList() throws CloneFailedException {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(null);
    resultIf.setThen(null);
    resultIf.setOtherwise(new AddNamedOperation());

    // Act and Assert
    Operation otherwise = resultIf.shallowClone().getOtherwise();
    Collection<Operation> operations = ((AddNamedOperation) otherwise).getOperations();
    assertTrue(operations instanceof List);
    assertTrue(otherwise instanceof AddNamedOperation);
    assertNull(((AddNamedOperation) otherwise).getScore());
    assertNull(((AddNamedOperation) otherwise).getDescription());
    assertNull(((AddNamedOperation) otherwise).getOperationChainAsString());
    assertNull(((AddNamedOperation) otherwise).getOperationName());
    assertNull(((AddNamedOperation) otherwise).getLabels());
    assertNull(((AddNamedOperation) otherwise).getReadAccessRoles());
    assertNull(((AddNamedOperation) otherwise).getWriteAccessRoles());
    assertNull(otherwise.getOptions());
    assertNull(((AddNamedOperation) otherwise).getParameters());
    assertNull(((AddNamedOperation) otherwise).getReadAccessPredicate());
    assertNull(((AddNamedOperation) otherwise).getWriteAccessPredicate());
    assertFalse(((AddNamedOperation) otherwise).isOverwriteFlag());
    assertTrue(operations.isEmpty());
  }

  /**
   * Test {@link If#getOperations()}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); given AddNamedOperation (default constructor) Options is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection If.getOperations()"})
  void testGetOperations_givenAddNamedOperationOptionsIsHashMap() {
    // Arrange
    AddNamedOperation then = new AddNamedOperation();
    then.setOptions(null);

    AddNamedOperation otherwise = new AddNamedOperation();
    otherwise.setOptions(new HashMap<>());

    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(null);
    resultIf.setThen(then);
    resultIf.setOtherwise(otherwise);

    // Act
    Collection<Operation> actualOperations = resultIf.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(3, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(1);
    assertTrue(getResult instanceof OperationChain);
    Operation getResult2 = ((List<Operation>) actualOperations).get(2);
    assertTrue(getResult2 instanceof OperationChain);
    assertEquals(1, ((OperationChain<Object>) getResult).getOperations().size());
    assertEquals(1, ((OperationChain<Object>) getResult2).getOperations().size());
  }

  /**
   * Test {@link If#getOperations()}.
   * <ul>
   *   <li>Given {@link If} (default constructor) Conditional is {@link Conditional#Conditional()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); given If (default constructor) Conditional is Conditional()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection If.getOperations()"})
  void testGetOperations_givenIfConditionalIsConditional() {
    // Arrange
    AddNamedOperation then = new AddNamedOperation();
    then.setOptions(null);

    AddNamedOperation otherwise = new AddNamedOperation();
    otherwise.setOptions(null);

    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(new Conditional());
    resultIf.setThen(then);
    resultIf.setOtherwise(otherwise);

    // Act
    Collection<Operation> actualOperations = resultIf.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(3, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(1);
    assertTrue(getResult instanceof OperationChain);
    Operation getResult2 = ((List<Operation>) actualOperations).get(2);
    assertTrue(getResult2 instanceof OperationChain);
    assertEquals(1, ((OperationChain<Object>) getResult).getOperations().size());
    assertEquals(1, ((OperationChain<Object>) getResult2).getOperations().size());
  }

  /**
   * Test {@link If#getOperations()}.
   * <ul>
   *   <li>Given {@link If} (default constructor) Conditional is {@code null}.</li>
   *   <li>Then return second Operations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); given If (default constructor) Conditional is 'null'; then return second Operations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection If.getOperations()"})
  void testGetOperations_givenIfConditionalIsNull_thenReturnSecondOperationsSizeIsOne() {
    // Arrange
    AddNamedOperation then = new AddNamedOperation();
    then.setOptions(null);

    AddNamedOperation otherwise = new AddNamedOperation();
    otherwise.setOptions(null);

    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(null);
    resultIf.setThen(then);
    resultIf.setOtherwise(otherwise);

    // Act
    Collection<Operation> actualOperations = resultIf.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(3, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(1);
    assertTrue(getResult instanceof OperationChain);
    Operation getResult2 = ((List<Operation>) actualOperations).get(2);
    assertTrue(getResult2 instanceof OperationChain);
    assertEquals(1, ((OperationChain<Object>) getResult).getOperations().size());
    assertEquals(1, ((OperationChain<Object>) getResult2).getOperations().size());
  }

  /**
   * Test {@link If#getOperations()}.
   * <ul>
   *   <li>Given {@link If} (default constructor).</li>
   *   <li>Then return second Operations Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations(); given If (default constructor); then return second Operations Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection If.getOperations()"})
  void testGetOperations_givenIf_thenReturnSecondOperationsEmpty() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act
    Collection<Operation> actualOperations = resultIf.getOperations();

    // Assert
    assertTrue(actualOperations instanceof List);
    assertEquals(3, actualOperations.size());
    Operation getResult = ((List<Operation>) actualOperations).get(1);
    assertTrue(getResult instanceof OperationChain);
    Operation getResult2 = ((List<Operation>) actualOperations).get(2);
    assertTrue(getResult2 instanceof OperationChain);
    assertTrue(((OperationChain<Object>) getResult).getOperations().isEmpty());
    assertTrue(((OperationChain<Object>) getResult2).getOperations().isEmpty());
  }

  /**
   * Test {@link If#updateOperations(Collection)}.
   * <ul>
   *   <li>Given {@link ForEach} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ForEach} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName("Test updateOperations(Collection); given ForEach (default constructor); when ArrayList() add ForEach (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link If} (default constructor) Conditional is {@link Conditional#Conditional()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName("Test updateOperations(Collection); given If (default constructor) Conditional is Conditional()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void If.updateOperations(Collection)"})
  void testUpdateOperations_givenIfConditionalIsConditional() {
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
   * <ul>
   *   <li>Given {@link If} (default constructor) Conditional is {@code null}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName("Test updateOperations(Collection); given If (default constructor) Conditional is 'null'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void If.updateOperations(Collection)"})
  void testUpdateOperations_givenIfConditionalIsNull_whenNull() {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resultIf.updateOperations(null));
  }

  /**
   * Test {@link If#updateOperations(Collection)}.
   * <ul>
   *   <li>Given {@link If} (default constructor).</li>
   *   <li>Then {@link If} (default constructor) Operations first Operations Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName("Test updateOperations(Collection); given If (default constructor); then If (default constructor) Operations first Operations Empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link If} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName("Test updateOperations(Collection); given If (default constructor); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link If} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName("Test updateOperations(Collection); given If (default constructor); when ArrayList(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void If.updateOperations(Collection)"})
  void testUpdateOperations_givenIf_whenArrayList_thenThrowIllegalArgumentException() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resultIf.updateOperations(new ArrayList<>()));
  }

  /**
   * Test {@link If#updateOperations(Collection)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName("Test updateOperations(Collection); given 'null'; when LinkedHashSet() add 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void If.updateOperations(Collection)"})
  void testUpdateOperations_givenNull_whenLinkedHashSetAddNull() {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    resultIf.setConditional(null);

    LinkedHashSet<Operation> operations = new LinkedHashSet<>();
    operations.add(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> resultIf.updateOperations(operations));
  }

  /**
   * Test {@link If#updateOperations(Collection)}.
   * <ul>
   *   <li>Given {@link OperationImpl} (default constructor).</li>
   *   <li>Then {@link If} (default constructor) Conditional Predicate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#updateOperations(Collection)}
   */
  @Test
  @DisplayName("Test updateOperations(Collection); given OperationImpl (default constructor); then If (default constructor) Conditional Predicate is 'null'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link If#equals(Object)}, and {@link If#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link If#equals(Object)}
   *   <li>{@link If#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean If.equals(Object)", "int If.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    If<Object, Object> resultIf = new If<>();
    If<Object, Object> resultIf2 = new If<>();

    // Act and Assert
    assertEquals(resultIf, resultIf2);
    int expectedHashCodeResult = resultIf.hashCode();
    assertEquals(expectedHashCodeResult, resultIf2.hashCode());
  }

  /**
   * Test {@link If#equals(Object)}, and {@link If#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link If#equals(Object)}
   *   <li>{@link If#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean If.equals(Object)", "int If.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act and Assert
    assertNotEquals(resultIf, null);
  }

  /**
   * Test {@link If#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link If#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean If.equals(Object)", "int If.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    If<Object, Object> resultIf = new If<>();

    // Act and Assert
    assertNotEquals(resultIf, "Different type to If");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void If.<init>()", "Boolean If.getCondition()", "Conditional If.getConditional()",
      "Map If.getOptions()", "Operation If.getOtherwise()", "Operation If.getThen()", "void If.setCondition(Boolean)",
      "void If.setConditional(Conditional)", "void If.setOptions(Map)", "void If.setOtherwise(Operation)",
      "void If.setThen(Operation)", "String If.toString()"})
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
