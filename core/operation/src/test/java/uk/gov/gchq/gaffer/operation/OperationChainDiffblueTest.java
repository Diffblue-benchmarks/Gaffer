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

package uk.gov.gchq.gaffer.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChain.Builder;
import uk.gov.gchq.gaffer.operation.impl.ForEach;
import uk.gov.gchq.gaffer.operation.impl.io.GenericInputImpl;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;

class OperationChainDiffblueTest {
  /**
   * Test Builder {@link Builder#first(Operation)} with {@code Operation}.
   * <p>
   * Method under test: {@link Builder#first(Operation)}
   */
  @Test
  @DisplayName("Test Builder first(Operation) with 'Operation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain.NoOutputBuilder Builder.first(Operation)"})
  void testBuilderFirstWithOperation() {
    // Arrange
    Builder builder = new Builder();
    AddNamedOperation op = new AddNamedOperation();

    // Act and Assert
    OperationChain<Void> buildResult = builder.first(op).build();
    Operation[] operationArray = buildResult.getOperationArray();
    Operation operation = operationArray[0];
    assertTrue(operation instanceof AddNamedOperation);
    TypeReference<Void> outputTypeReference = buildResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Void);
    List<Operation> operations = buildResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertTrue(buildResult.getOptions().isEmpty());
    Class<Void> expectedOutputClass = Void.class;
    Class<?> outputClass = buildResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, buildResult.getOperationsClass());
    assertSame(op, operations.get(0));
    assertSame(op, operation);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, buildResult.getOutputType());
  }

  /**
   * Test Builder {@link Builder#first(Output)} with {@code Output}.
   * <p>
   * Method under test: {@link Builder#first(Output)}
   */
  @Test
  @DisplayName("Test Builder first(Output) with 'Output'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain.OutputBuilder Builder.first(Output)"})
  void testBuilderFirstWithOutput() {
    // Arrange
    Builder builder = new Builder();
    NamedOperation<Object, Object> op = new NamedOperation<>();

    // Act and Assert
    OperationChain<Object> buildResult = builder.first(op).build();
    Operation[] operationArray = buildResult.getOperationArray();
    Operation operation = operationArray[0];
    assertTrue(operation instanceof NamedOperation);
    TypeReference<Object> outputTypeReference = buildResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    List<Operation> operations = buildResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertTrue(buildResult.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = buildResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, buildResult.getOperationsClass());
    assertSame(op, operations.get(0));
    assertSame(op, operation);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, buildResult.getOutputType());
  }

  /**
   * Test {@link OperationChain#OperationChain(Output)}.
   * <p>
   * Method under test: {@link OperationChain#OperationChain(Output)}
   */
  @Test
  @DisplayName("Test new OperationChain(Output)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChain.<init>(Output)"})
  void testNewOperationChain() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();

    // Act
    OperationChain<Object> actualOperationChain = new OperationChain<>((Output<Object>) operation);

    // Assert
    Operation[] operationArray = actualOperationChain.getOperationArray();
    Operation operation2 = operationArray[0];
    assertTrue(operation2 instanceof NamedOperation);
    TypeReference<Object> outputTypeReference = actualOperationChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    List<Operation> operations = actualOperationChain.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertTrue(actualOperationChain.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualOperationChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualOperationChain.getOperationsClass());
    assertSame(operation, operations.get(0));
    assertSame(operation, operation2);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualOperationChain.getOutputType());
  }

  /**
   * Test {@link OperationChain#OperationChain(List)}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).</li>
   *   <li>Then return array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#OperationChain(List)}
   */
  @Test
  @DisplayName("Test new OperationChain(List); given AddNamedOperation (default constructor); then return array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChain.<init>(List)"})
  void testNewOperationChain_givenAddNamedOperation_thenReturnArrayLengthIsOne() {
    // Arrange
    ArrayList<Operation> operations = new ArrayList<>();
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    operations.add(addNamedOperation);

    // Act
    OperationChain<Object> actualOperationChain = new OperationChain<>(operations);

    // Assert
    Operation[] operationArray = actualOperationChain.getOperationArray();
    assertEquals(1, operationArray.length);
    assertEquals(operations, actualOperationChain.getOperations());
    assertSame(addNamedOperation, operationArray[0]);
  }

  /**
   * Test {@link OperationChain#OperationChain(List)}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).</li>
   *   <li>Then return Operations size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#OperationChain(List)}
   */
  @Test
  @DisplayName("Test new OperationChain(List); given AddNamedOperation (default constructor); then return Operations size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChain.<init>(List)"})
  void testNewOperationChain_givenAddNamedOperation_thenReturnOperationsSizeIsTwo() {
    // Arrange
    ArrayList<Operation> operations = new ArrayList<>();
    operations.add(new AddNamedOperation());
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    operations.add(addNamedOperation);

    // Act
    OperationChain<Object> actualOperationChain = new OperationChain<>(operations);

    // Assert
    List<Operation> operations2 = actualOperationChain.getOperations();
    assertEquals(2, operations2.size());
    Operation[] operationArray = actualOperationChain.getOperationArray();
    assertEquals(2, operationArray.length);
    assertSame(addNamedOperation, operations2.get(1));
    assertSame(addNamedOperation, operationArray[1]);
  }

  /**
   * Test {@link OperationChain#OperationChain(List, boolean)}.
   * <ul>
   *   <li>Given {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return {@link OperationChain#OperationChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#OperationChain(List, boolean)}
   */
  @Test
  @DisplayName("Test new OperationChain(List, boolean); given OperationChain(); then return OperationChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChain.<init>(List, boolean)"})
  void testNewOperationChain_givenOperationChain_thenReturnOperationChain() {
    // Arrange
    ArrayList<Operation> operations = new ArrayList<>();
    OperationChain<Object> operationChain = new OperationChain<>();
    operations.add(operationChain);

    // Act and Assert
    assertEquals(operationChain, new OperationChain<>(operations, true));
  }

  /**
   * Test {@link OperationChain#OperationChain(List, boolean)}.
   * <ul>
   *   <li>Then return Operations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#OperationChain(List, boolean)}
   */
  @Test
  @DisplayName("Test new OperationChain(List, boolean); then return Operations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChain.<init>(List, boolean)"})
  void testNewOperationChain_thenReturnOperationsSizeIsOne() {
    // Arrange
    ForEach<Object, Object> forEach = new ForEach<>();
    GenericInputImpl operation = new GenericInputImpl();
    forEach.setOperation(operation);

    ArrayList<Operation> operations = new ArrayList<>();
    operations.add(forEach);

    // Act
    OperationChain<Object> actualOperationChain = new OperationChain<>(operations, true);

    // Assert
    List<Operation> operations2 = actualOperationChain.getOperations();
    assertEquals(1, operations2.size());
    Operation[] operationArray = actualOperationChain.getOperationArray();
    assertEquals(1, operationArray.length);
    assertSame(operation, operations2.get(0));
    assertSame(operation, operationArray[0]);
  }

  /**
   * Test {@link OperationChain#wrap(Operation)} with {@code Operation}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link AddNamedOperation} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#wrap(Operation)}
   */
  @Test
  @DisplayName("Test wrap(Operation) with 'Operation'; given HashMap(); when AddNamedOperation (default constructor) Options is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Operation)"})
  void testWrapWithOperation_givenHashMap_whenAddNamedOperationOptionsIsHashMap() {
    // Arrange
    AddNamedOperation operation = new AddNamedOperation();
    operation.setOptions(new HashMap<>());

    // Act
    OperationChain<?> actualWrapResult = OperationChain.wrap(operation);

    // Assert
    Operation[] operationArray = actualWrapResult.getOperationArray();
    Operation operation2 = operationArray[0];
    assertTrue(operation2 instanceof AddNamedOperation);
    assertTrue(actualWrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Void);
    List<Operation> operations = actualWrapResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertSame(operation, operations.get(0));
    assertSame(operation, operation2);
  }

  /**
   * Test {@link OperationChain#wrap(Operation)} with {@code Operation}.
   * <ul>
   *   <li>When {@link AddNamedOperation} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#wrap(Operation)}
   */
  @Test
  @DisplayName("Test wrap(Operation) with 'Operation'; when AddNamedOperation (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Operation)"})
  void testWrapWithOperation_whenAddNamedOperation() {
    // Arrange
    AddNamedOperation operation = new AddNamedOperation();

    // Act
    OperationChain<?> actualWrapResult = OperationChain.wrap(operation);

    // Assert
    Operation[] operationArray = actualWrapResult.getOperationArray();
    Operation operation2 = operationArray[0];
    assertTrue(operation2 instanceof AddNamedOperation);
    assertTrue(actualWrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Void);
    List<Operation> operations = actualWrapResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    assertSame(operation, operations.get(0));
    assertSame(operation, operation2);
  }

  /**
   * Test {@link OperationChain#wrap(Operation)} with {@code Operation}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#wrap(Operation)}
   */
  @Test
  @DisplayName("Test wrap(Operation) with 'Operation'; when 'null'; then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Operation)"})
  void testWrapWithOperation_whenNull_thenReturnArrayLengthIsZero() {
    // Arrange and Act
    OperationChain<?> actualWrapResult = OperationChain.wrap(null);

    // Assert
    assertTrue(actualWrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Void);
    assertEquals(0, actualWrapResult.getOperationArray().length);
    assertTrue(actualWrapResult.getOperations().isEmpty());
  }

  /**
   * Test {@link OperationChain#wrap(Operation)} with {@code Operation}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#wrap(Operation)}
   */
  @Test
  @DisplayName("Test wrap(Operation) with 'Operation'; when OperationChain(); then return array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Operation)"})
  void testWrapWithOperation_whenOperationChain_thenReturnArrayLengthIsZero() {
    // Arrange and Act
    OperationChain<?> actualWrapResult = OperationChain.wrap(new OperationChain<>());

    // Assert
    assertTrue(actualWrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Void);
    assertEquals(0, actualWrapResult.getOperationArray().length);
    assertTrue(actualWrapResult.getOperations().isEmpty());
  }

  /**
   * Test {@link OperationChain#wrap(Output)} with {@code Output}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return Options size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#wrap(Output)}
   */
  @Test
  @DisplayName("Test wrap(Output) with 'Output'; given 'Name'; then return Options size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Output)"})
  void testWrapWithOutput_givenName_thenReturnOptionsSizeIsOne() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    operation.addOption("Name", "42");

    // Act
    OperationChain<Object> actualWrapResult = OperationChain.wrap(operation);

    // Assert
    Operation[] operationArray = actualWrapResult.getOperationArray();
    Operation operation2 = operationArray[0];
    assertTrue(operation2 instanceof NamedOperation);
    TypeReference<Object> outputTypeReference = actualWrapResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    Map<String, String> options = actualWrapResult.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get("Name"));
    List<Operation> operations = actualWrapResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualWrapResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(operation, operations.get(0));
    assertSame(operation, operation2);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualWrapResult.getOutputType());
  }

  /**
   * Test {@link OperationChain#wrap(Output)} with {@code Output}.
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).</li>
   *   <li>Then first element return {@link NamedOperation}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#wrap(Output)}
   */
  @Test
  @DisplayName("Test wrap(Output) with 'Output'; when NamedOperation (default constructor); then first element return NamedOperation")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain OperationChain.wrap(Output)"})
  void testWrapWithOutput_whenNamedOperation_thenFirstElementReturnNamedOperation() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();

    // Act
    OperationChain<Object> actualWrapResult = OperationChain.wrap(operation);

    // Assert
    Operation[] operationArray = actualWrapResult.getOperationArray();
    Operation operation2 = operationArray[0];
    assertTrue(operation2 instanceof NamedOperation);
    TypeReference<Object> outputTypeReference = actualWrapResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    List<Operation> operations = actualWrapResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualWrapResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(operation, operations.get(0));
    assertSame(operation, operation2);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualWrapResult.getOutputType());
  }

  /**
   * Test {@link OperationChain#getOutputTypeReference()}.
   * <ul>
   *   <li>Given wrap {@link NamedOperation} (default constructor).</li>
   *   <li>Then return {@link TypeReferenceImpl.Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference(); given wrap NamedOperation (default constructor); then return Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference OperationChain.getOutputTypeReference()"})
  void testGetOutputTypeReference_givenWrapNamedOperation_thenReturnObject() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertTrue(wrapResult.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link OperationChain#getOperations()}.
   * <p>
   * Method under test: {@link OperationChain#getOperations()}
   */
  @Test
  @DisplayName("Test getOperations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List OperationChain.getOperations()"})
  void testGetOperations() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act and Assert
    assertTrue(operationChain.getOperations().isEmpty());
  }

  /**
   * Test {@link OperationChain#getOperationArray()}.
   * <p>
   * Method under test: {@link OperationChain#getOperationArray()}
   */
  @Test
  @DisplayName("Test getOperationArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation[] OperationChain.getOperationArray()"})
  void testGetOperationArray() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act and Assert
    assertEquals(0, operationChain.getOperationArray().length);
  }

  /**
   * Test {@link OperationChain#setOperationArray(Operation[])}.
   * <ul>
   *   <li>Then {@link OperationChain#OperationChain()} Operations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#setOperationArray(Operation[])}
   */
  @Test
  @DisplayName("Test setOperationArray(Operation[]); then OperationChain() Operations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChain.setOperationArray(Operation[])"})
  void testSetOperationArray_thenOperationChainOperationsSizeIsOne() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();
    AddNamedOperation addNamedOperation = new AddNamedOperation();

    // Act
    operationChain.setOperationArray(addNamedOperation);

    // Assert
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    Operation[] operationArray = operationChain.getOperationArray();
    assertEquals(1, operationArray.length);
    assertSame(addNamedOperation, operations.get(0));
    assertSame(addNamedOperation, operationArray[0]);
  }

  /**
   * Test {@link OperationChain#setOperationArray(Operation[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#setOperationArray(Operation[])}
   */
  @Test
  @DisplayName("Test setOperationArray(Operation[]); when 'null'; then array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChain.setOperationArray(Operation[])"})
  void testSetOperationArray_whenNull_thenArrayLengthIsZero() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act
    operationChain.setOperationArray(null);

    // Assert that nothing has changed
    assertEquals(0, operationChain.getOperationArray().length);
    assertTrue(operationChain.getOperations().isEmpty());
  }

  /**
   * Test {@link OperationChain#shallowClone()}.
   * <ul>
   *   <li>Given {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return {@link OperationChain#OperationChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given OperationChain(); then return OperationChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain OperationChain.shallowClone()"})
  void testShallowClone_givenOperationChain_thenReturnOperationChain() throws CloneFailedException {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act and Assert
    assertEquals(operationChain, operationChain.shallowClone());
  }

  /**
   * Test {@link OperationChain#shallowClone()}.
   * <ul>
   *   <li>Given wrap {@link NamedOperation} (default constructor).</li>
   *   <li>Then first element return {@link NamedOperation}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given wrap NamedOperation (default constructor); then first element return NamedOperation")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain OperationChain.shallowClone()"})
  void testShallowClone_givenWrapNamedOperation_thenFirstElementReturnNamedOperation() throws CloneFailedException {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act
    OperationChain<Object> actualShallowCloneResult = wrapResult.shallowClone();

    // Assert
    Operation[] operationArray = actualShallowCloneResult.getOperationArray();
    Operation operation = operationArray[0];
    assertTrue(operation instanceof NamedOperation);
    TypeReference<Object> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    List<Operation> operations = actualShallowCloneResult.getOperations();
    assertEquals(1, operations.size());
    assertEquals(1, operationArray.length);
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = actualShallowCloneResult.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, actualShallowCloneResult.getOutputType());
    assertSame(operation, operations.get(0));
  }

  /**
   * Test {@link OperationChain#shallowClone()}.
   * <ul>
   *   <li>Then return {@link OperationChainDAO#OperationChainDAO(Operation)} with operation is {@link OperationChain#OperationChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return OperationChainDAO(Operation) with operation is OperationChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain OperationChain.shallowClone()"})
  void testShallowClone_thenReturnOperationChainDAOWithOperationIsOperationChain() throws CloneFailedException {
    // Arrange
    OperationChainDAO<Object> operationChainDAO = new OperationChainDAO<>((Operation) new OperationChain<>());

    // Act and Assert
    assertEquals(operationChainDAO, operationChainDAO.shallowClone());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OperationChain#toString()}
   *   <li>{@link OperationChain#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map OperationChain.getOptions()", "String OperationChain.toString()"})
  void testGettersAndSetters() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act
    String actualToStringResult = operationChain.toString();

    // Assert
    assertEquals("OperationChain[operations=[]]", actualToStringResult);
    assertTrue(operationChain.getOptions().isEmpty());
  }

  /**
   * Test {@link OperationChain#setOptions(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link OperationChain#OperationChain()} Options is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#setOptions(Map)}
   */
  @Test
  @DisplayName("Test setOptions(Map); when HashMap(); then OperationChain() Options is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChain.setOptions(Map)"})
  void testSetOptions_whenHashMap_thenOperationChainOptionsIsHashMap() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();
    HashMap<String, String> options = new HashMap<>();

    // Act
    operationChain.setOptions(options);

    // Assert
    assertSame(options, operationChain.getOptions());
  }

  /**
   * Test {@link OperationChain#setOptions(Map)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link OperationChain#OperationChain()} Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#setOptions(Map)}
   */
  @Test
  @DisplayName("Test setOptions(Map); when 'null'; then OperationChain() Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChain.setOptions(Map)"})
  void testSetOptions_whenNull_thenOperationChainOptionsEmpty() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act
    operationChain.setOptions(null);

    // Assert that nothing has changed
    assertTrue(operationChain.getOptions().isEmpty());
  }

  /**
   * Test {@link OperationChain#toOverviewString()}.
   * <ul>
   *   <li>Given array of {@link Operation} with {@code null}.</li>
   *   <li>Then return {@code OperationChain[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#toOverviewString()}
   */
  @Test
  @DisplayName("Test toOverviewString(); given array of Operation with 'null'; then return 'OperationChain[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String OperationChain.toOverviewString()"})
  void testToOverviewString_givenArrayOfOperationWithNull_thenReturnOperationChain() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();
    operationChain.setOperationArray(null);

    // Act and Assert
    assertEquals("OperationChain[]", operationChain.toOverviewString());
  }

  /**
   * Test {@link OperationChain#toOverviewString()}.
   * <ul>
   *   <li>Given {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return {@code OperationChain[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#toOverviewString()}
   */
  @Test
  @DisplayName("Test toOverviewString(); given OperationChain(); then return 'OperationChain[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String OperationChain.toOverviewString()"})
  void testToOverviewString_givenOperationChain_thenReturnOperationChain() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act and Assert
    assertEquals("OperationChain[]", operationChain.toOverviewString());
  }

  /**
   * Test {@link OperationChain#toOverviewString()}.
   * <ul>
   *   <li>Then return {@code OperationChain[AddNamedOperation->AddNamedOperation]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#toOverviewString()}
   */
  @Test
  @DisplayName("Test toOverviewString(); then return 'OperationChain[AddNamedOperation->AddNamedOperation]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String OperationChain.toOverviewString()"})
  void testToOverviewString_thenReturnOperationChainAddNamedOperationAddNamedOperation() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    operationChain.setOperationArray(addNamedOperation, new AddNamedOperation());

    // Act and Assert
    assertEquals("OperationChain[AddNamedOperation->AddNamedOperation]", operationChain.toOverviewString());
  }

  /**
   * Test {@link OperationChain#toOverviewString()}.
   * <ul>
   *   <li>Then return {@code OperationChain[NamedOperation]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#toOverviewString()}
   */
  @Test
  @DisplayName("Test toOverviewString(); then return 'OperationChain[NamedOperation]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String OperationChain.toOverviewString()"})
  void testToOverviewString_thenReturnOperationChainNamedOperation() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertEquals("OperationChain[NamedOperation]", wrapResult.toOverviewString());
  }

  /**
   * Test {@link OperationChain#close()}.
   * <ul>
   *   <li>Given array of {@link Operation} with {@code null}.</li>
   *   <li>Then calls {@link Operation#getOptions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#close()}
   */
  @Test
  @DisplayName("Test close(); given array of Operation with 'null'; then calls getOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChain.close()"})
  void testClose_givenArrayOfOperationWithNull_thenCallsGetOptions() throws IOException {
    // Arrange
    Output<Object> operation = mock(Output.class);
    when(operation.getOptions()).thenReturn(new HashMap<>());
    try (OperationChain<Object> wrapResult = OperationChain.wrap(operation)) {
      wrapResult.setOperationArray(null);
    }

    // Act and Assert
    verify(operation).getOptions();
  }

  /**
   * Test {@link OperationChain#close()}.
   * <ul>
   *   <li>Given array of {@link Operation} with {@link OperationChain#OperationChain()}.</li>
   *   <li>Then calls {@link Operation#getOptions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#close()}
   */
  @Test
  @DisplayName("Test close(); given array of Operation with OperationChain(); then calls getOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChain.close()"})
  void testClose_givenArrayOfOperationWithOperationChain_thenCallsGetOptions() throws IOException {
    // Arrange
    Output<Object> operation = mock(Output.class);
    when(operation.getOptions()).thenReturn(new HashMap<>());
    try (OperationChain<Object> wrapResult = OperationChain.wrap(operation)) {
      wrapResult.setOperationArray(new OperationChain<>());
    }

    // Act and Assert
    verify(operation).getOptions();
  }

  /**
   * Test {@link OperationChain#close()}.
   * <ul>
   *   <li>Given {@link Output} {@link Operation#close()} does nothing.</li>
   *   <li>Then calls {@link Operation#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#close()}
   */
  @Test
  @DisplayName("Test close(); given Output close() does nothing; then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OperationChain.close()"})
  void testClose_givenOutputCloseDoesNothing_thenCallsClose() throws IOException {
    // Arrange
    Output<Object> operation = mock(Output.class);
    when(operation.getOptions()).thenReturn(new HashMap<>());
    doNothing().when(operation).close();
    try (OperationChain<Object> wrapResult = OperationChain.wrap(operation)) {}

    // Act and Assert
    verify(operation).close();
    verify(operation).getOptions();
  }

  /**
   * Test {@link OperationChain#equals(Object)}, and {@link OperationChain#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OperationChain#equals(Object)}
   *   <li>{@link OperationChain#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();
    OperationChain<Object> operationChain2 = new OperationChain<>();

    // Act and Assert
    assertEquals(operationChain, operationChain2);
    int expectedHashCodeResult = operationChain.hashCode();
    assertEquals(expectedHashCodeResult, operationChain2.hashCode());
  }

  /**
   * Test {@link OperationChain#equals(Object)}, and {@link OperationChain#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OperationChain#equals(Object)}
   *   <li>{@link OperationChain#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act and Assert
    assertEquals(operationChain, operationChain);
    int expectedHashCodeResult = operationChain.hashCode();
    assertEquals(expectedHashCodeResult, operationChain.hashCode());
  }

  /**
   * Test {@link OperationChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertNotEquals(wrapResult, new OperationChain<>());
  }

  /**
   * Test {@link OperationChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();
    OperationChainDAO<Object> operationChainDAO = mock(OperationChainDAO.class);
    when(operationChainDAO.getOperations()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertNotEquals(operationChain, operationChainDAO);
  }

  /**
   * Test {@link OperationChain#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then throw exception")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenThrowException() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();
    OperationChainDAO<Object> operationChainDAO = mock(OperationChainDAO.class);
    when(operationChainDAO.getOperations()).thenThrow(new CloneFailedException("An error occurred"));

    // Act and Assert
    assertThrows(CloneFailedException.class, () -> operationChain.equals(operationChainDAO));
  }

  /**
   * Test {@link OperationChain#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act and Assert
    assertNotEquals(operationChain, null);
  }

  /**
   * Test {@link OperationChain#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationChain#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OperationChain.equals(Object)", "int OperationChain.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act and Assert
    assertNotEquals(operationChain, "Different type to OperationChain");
  }
}
