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

package uk.gov.gchq.gaffer.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.user.User;

class GraphRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GraphRequest#equals(Object)}
   *   <li>{@link GraphRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, new Context());

    // Act and Assert
    assertEquals(graphRequest, graphRequest);
    int expectedHashCodeResult = graphRequest.hashCode();
    assertEquals(expectedHashCodeResult, graphRequest.hashCode());
  }

  /**
   * Method under test: {@link GraphRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, new Context());
    ExportToOtherAuthorisedGraph operation2 = new ExportToOtherAuthorisedGraph();

    // Act and Assert
    assertNotEquals(graphRequest, new GraphRequest<>((Operation) operation2, new Context()));
  }

  /**
   * Method under test: {@link GraphRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OperationChain<Object> operation = mock(OperationChain.class);
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, new Context());
    ExportToOtherAuthorisedGraph operation2 = new ExportToOtherAuthorisedGraph();

    // Act and Assert
    assertNotEquals(graphRequest, new GraphRequest<>((Operation) operation2, new Context()));
  }

  /**
   * Method under test: {@link GraphRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, new Context());

    // Act and Assert
    assertNotEquals(graphRequest, null);
  }

  /**
   * Method under test: {@link GraphRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, new Context());

    // Act and Assert
    assertNotEquals(graphRequest, "Different type to GraphRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GraphRequest#getContext()}
   *   <li>{@link GraphRequest#getOperationChain()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();
    Context context = new Context();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);

    // Act
    Context actualContext = graphRequest.getContext();
    OperationChain<Object> actualOperationChain = graphRequest.getOperationChain();

    // Assert
    assertTrue(actualOperationChain.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    List<Operation> operations = actualOperationChain.getOperations();
    assertEquals(1, operations.size());
    assertTrue(actualOperationChain.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualOperationChain.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualOperationChain.getOperationsClass());
    assertSame(operation, operations.get(0));
    assertSame(context, actualContext);
  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Operation, Context)}
   */
  @Test
  void testNewGraphRequest() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();
    Context context = new Context();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Operation) operation, context);

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    TypeReference<Object> outputTypeReference = operationChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    assertTrue(operationChain.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = operationChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, operationChain.getOperationsClass());
    assertSame(operation, operations.get(0));
    assertSame(context, actualGraphRequest.getContext());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, operationChain.getOutputType());
  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Operation, Context)}
   */
  @Test
  void testNewGraphRequest2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphRequest<>((Operation) null, (Context) null));

  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Operation, Context)}
   */
  @Test
  void testNewGraphRequest3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new GraphRequest<>((Operation) new ExportToOtherAuthorisedGraph(), (Context) null));

  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Operation, Context)}
   */
  @Test
  void testNewGraphRequest4() {
    // Arrange
    OperationChain<Object> operation = new OperationChain<>();
    Context context = new Context();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Operation) operation, context);

    // Assert
    assertSame(operation, actualGraphRequest.getOperationChain());
    assertSame(context, actualGraphRequest.getContext());
  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Operation, User)}
   */
  @Test
  void testNewGraphRequest5() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();
    User user = new User();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Operation) operation, user);

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    TypeReference<Object> outputTypeReference = operationChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    Context context = actualGraphRequest.getContext();
    assertNull(context.getOriginalOpChain());
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(operationChain.getOptions().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = operationChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, operationChain.getOperationsClass());
    assertSame(operation, operations.get(0));
    assertSame(user, context.getUser());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, operationChain.getOutputType());
  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Operation, User)}
   */
  @Test
  void testNewGraphRequest6() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphRequest<>((Operation) null, (User) null));

  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Operation, User)}
   */
  @Test
  void testNewGraphRequest7() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new GraphRequest<>((Operation) new ExportToOtherAuthorisedGraph(), (User) null));

  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Operation, User)}
   */
  @Test
  void testNewGraphRequest8() {
    // Arrange
    OperationChain<Object> operation = new OperationChain<>();
    User user = new User();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Operation) operation, user);

    // Assert
    Context context = actualGraphRequest.getContext();
    assertNull(context.getOriginalOpChain());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertSame(operation, actualGraphRequest.getOperationChain());
    assertSame(user, context.getUser());
  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  void testNewGraphRequest9() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    Context context = new Context();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Output<Object>) operation, context);

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    TypeReference<Object> outputTypeReference = operationChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    assertTrue(operationChain.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = operationChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, operationChain.getOperationsClass());
    assertSame(operation, operations.get(0));
    assertSame(context, actualGraphRequest.getContext());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, operationChain.getOutputType());
  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  void testNewGraphRequest10() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphRequest<>((Output<Object>) null, (Context) null));

  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  void testNewGraphRequest11() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new GraphRequest<>((Output<Object>) new NamedOperation<>(), (Context) null));

  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  void testNewGraphRequest12() {
    // Arrange
    OperationChain<Object> operation = new OperationChain<>();
    Context context = new Context();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>(operation, context);

    // Assert
    assertSame(operation, actualGraphRequest.getOperationChain());
    assertSame(context, actualGraphRequest.getContext());
  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  void testNewGraphRequest13() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    operation.addOption("Name", "42");
    Context context = new Context();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Output<Object>) operation, context);

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    TypeReference<Object> outputTypeReference = operationChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    Map<String, String> options = operationChain.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get("Name"));
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = operationChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, operationChain.getOperationsClass());
    assertSame(operation, operations.get(0));
    assertSame(context, actualGraphRequest.getContext());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, operationChain.getOutputType());
  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  void testNewGraphRequest14() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    User user = new User();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Output<Object>) operation, user);

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    TypeReference<Object> outputTypeReference = operationChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    Context context = actualGraphRequest.getContext();
    assertNull(context.getOriginalOpChain());
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(operationChain.getOptions().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = operationChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, operationChain.getOperationsClass());
    assertSame(operation, operations.get(0));
    assertSame(user, context.getUser());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, operationChain.getOutputType());
  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  void testNewGraphRequest15() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphRequest<>((Output<Object>) null, (User) null));

  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  void testNewGraphRequest16() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new GraphRequest<>((Output<Object>) new NamedOperation<>(), (User) null));

  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  void testNewGraphRequest17() {
    // Arrange
    OperationChain<Object> operation = new OperationChain<>();
    User user = new User();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>(operation, user);

    // Assert
    Context context = actualGraphRequest.getContext();
    assertNull(context.getOriginalOpChain());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertSame(operation, actualGraphRequest.getOperationChain());
    assertSame(user, context.getUser());
  }

  /**
   * Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  void testNewGraphRequest18() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    operation.addOption("Name", "42");
    User user = new User();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Output<Object>) operation, user);

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    TypeReference<Object> outputTypeReference = operationChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    Map<String, String> options = operationChain.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get("Name"));
    Context context = actualGraphRequest.getContext();
    assertNull(context.getOriginalOpChain());
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = operationChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, operationChain.getOperationsClass());
    assertSame(operation, operations.get(0));
    assertSame(user, context.getUser());
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, operationChain.getOutputType());
  }
}
