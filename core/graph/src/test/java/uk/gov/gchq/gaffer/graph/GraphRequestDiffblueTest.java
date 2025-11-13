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
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.user.User;

class GraphRequestDiffblueTest {
  /**
   * Test {@link GraphRequest#GraphRequest(Output, Context)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then OperationChain OutputTypeReference return {@link TypeReferenceImpl.Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Output, Context); given 'Name'; then OperationChain OutputTypeReference return Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Output, Context)"})
  void testNewGraphRequest_givenName_thenOperationChainOutputTypeReferenceReturnObject() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    operation.addOption("Name", "42");

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Output<Object>) operation, new Context());

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
    assertSame(operation, operations.get(0));
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, operationChain.getOutputType());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, User)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then OperationChain OutputTypeReference return {@link TypeReferenceImpl.Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Output, User); given 'Name'; then OperationChain OutputTypeReference return Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Output, User)"})
  void testNewGraphRequest_givenName_thenOperationChainOutputTypeReferenceReturnObject2() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    operation.addOption("Name", "42");

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Output<Object>) operation, new User());

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
    assertSame(operation, operations.get(0));
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, operationChain.getOutputType());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, Context)}.
   * <ul>
   *   <li>Then OperationChain Operations first return {@link NamedOperation}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Output, Context); then OperationChain Operations first return NamedOperation")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Output, Context)"})
  void testNewGraphRequest_thenOperationChainOperationsFirstReturnNamedOperation() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Output<Object>) operation, new Context());

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof NamedOperation);
    assertTrue(
        ((NamedOperation<Object, Object>) getResult).getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(((NamedOperation<Object, Object>) getResult).getInput());
    assertNull(((NamedOperation<Object, Object>) getResult).getOperationName());
    assertNull(((NamedOperation<Object, Object>) getResult).getParameters());
    assertNull(getResult.getOptions());
    assertTrue(((NamedOperation<Object, Object>) getResult).getOperations().isEmpty());
    assertTrue(operationChain.getOptions().isEmpty());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, User)}.
   * <ul>
   *   <li>Then OperationChain Operations first return {@link NamedOperation}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Output, User); then OperationChain Operations first return NamedOperation")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Output, User)"})
  void testNewGraphRequest_thenOperationChainOperationsFirstReturnNamedOperation2() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Output<Object>) operation, new User());

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof NamedOperation);
    assertTrue(
        ((NamedOperation<Object, Object>) getResult).getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertNull(((NamedOperation<Object, Object>) getResult).getInput());
    assertNull(((NamedOperation<Object, Object>) getResult).getOperationName());
    assertNull(((NamedOperation<Object, Object>) getResult).getParameters());
    assertNull(getResult.getOptions());
    assertTrue(((NamedOperation<Object, Object>) getResult).getOperations().isEmpty());
    assertTrue(operationChain.getOptions().isEmpty());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, Context)}.
   * <ul>
   *   <li>Then OperationChain OutputTypeReference return {@link TypeReferenceImpl.Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Operation, Context)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Operation, Context); then OperationChain OutputTypeReference return Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, Context)"})
  void testNewGraphRequest_thenOperationChainOutputTypeReferenceReturnObject() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Operation) operation, new Context());

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    TypeReference<Object> outputTypeReference = operationChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = operationChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(operation, operations.get(0));
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, operationChain.getOutputType());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, User)}.
   * <ul>
   *   <li>Then OperationChain OutputTypeReference return {@link TypeReferenceImpl.Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Operation, User)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Operation, User); then OperationChain OutputTypeReference return Object")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, User)"})
  void testNewGraphRequest_thenOperationChainOutputTypeReferenceReturnObject2() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Operation) operation, new User());

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    TypeReference<Object> outputTypeReference = operationChain.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof TypeReferenceImpl.Object);
    List<Operation> operations = operationChain.getOperations();
    assertEquals(1, operations.size());
    Class<Object> expectedOutputClass = Object.class;
    Class<?> outputClass = operationChain.getOutputClass();
    assertEquals(expectedOutputClass, outputClass);
    assertSame(operation, operations.get(0));
    assertSame(outputClass, outputTypeReference.getType());
    assertSame(outputClass, operationChain.getOutputType());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, Context)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Operation, Context)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Operation, Context); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, Context)"})
  void testNewGraphRequest_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new GraphRequest<>((Operation) new ExportToOtherAuthorisedGraph(), (Context) null));

  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, User)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Operation, User)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Operation, User); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, User)"})
  void testNewGraphRequest_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new GraphRequest<>((Operation) new ExportToOtherAuthorisedGraph(), (User) null));

  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, Context)}.
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Output, Context); when NamedOperation (default constructor); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Output, Context)"})
  void testNewGraphRequest_whenNamedOperation_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new GraphRequest<>((Output<Object>) new NamedOperation<>(), (Context) null));

  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, User)}.
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Output, User); when NamedOperation (default constructor); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Output, User)"})
  void testNewGraphRequest_whenNamedOperation_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new GraphRequest<>((Output<Object>) new NamedOperation<>(), (User) null));

  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, Context)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Operation, Context)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Operation, Context); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, Context)"})
  void testNewGraphRequest_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphRequest<>((Operation) null, (Context) null));

  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, User)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Operation, User)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Operation, User); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, User)"})
  void testNewGraphRequest_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphRequest<>((Operation) null, (User) null));

  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, Context)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Output, Context); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Output, Context)"})
  void testNewGraphRequest_whenNull_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphRequest<>((Output<Object>) null, (Context) null));

  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, User)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Output, User); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Output, User)"})
  void testNewGraphRequest_whenNull_thenThrowIllegalArgumentException4() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphRequest<>((Output<Object>) null, (User) null));

  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, Context)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return OperationChain is {@link OperationChain#OperationChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Operation, Context)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Operation, Context); when OperationChain(); then return OperationChain is OperationChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, Context)"})
  void testNewGraphRequest_whenOperationChain_thenReturnOperationChainIsOperationChain() {
    // Arrange
    OperationChain<Object> operation = new OperationChain<>();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Operation) operation, new Context());

    // Assert
    assertSame(operation, actualGraphRequest.getOperationChain());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, User)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return OperationChain is {@link OperationChain#OperationChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Operation, User)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Operation, User); when OperationChain(); then return OperationChain is OperationChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, User)"})
  void testNewGraphRequest_whenOperationChain_thenReturnOperationChainIsOperationChain2() {
    // Arrange
    OperationChain<Object> operation = new OperationChain<>();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Operation) operation, new User());

    // Assert
    assertSame(operation, actualGraphRequest.getOperationChain());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, Context)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return OperationChain is {@link OperationChain#OperationChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Output, Context); when OperationChain(); then return OperationChain is OperationChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Output, Context)"})
  void testNewGraphRequest_whenOperationChain_thenReturnOperationChainIsOperationChain3() {
    // Arrange
    OperationChain<Object> operation = new OperationChain<>();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>(operation, new Context());

    // Assert
    assertSame(operation, actualGraphRequest.getOperationChain());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, User)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return OperationChain is {@link OperationChain#OperationChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Output, User); when OperationChain(); then return OperationChain is OperationChain()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GraphRequest.<init>(Output, User)"})
  void testNewGraphRequest_whenOperationChain_thenReturnOperationChainIsOperationChain4() {
    // Arrange
    OperationChain<Object> operation = new OperationChain<>();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>(operation, new User());

    // Assert
    assertSame(operation, actualGraphRequest.getOperationChain());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GraphRequest#toString()}
   *   <li>{@link GraphRequest#getContext()}
   *   <li>{@link GraphRequest#getOperationChain()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Context GraphRequest.getContext()", "OperationChain GraphRequest.getOperationChain()",
      "String GraphRequest.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);

    // Act
    graphRequest.toString();
    Context actualContext = graphRequest.getContext();
    OperationChain<Object> actualOperationChain = graphRequest.getOperationChain();

    // Assert
    assertTrue(actualOperationChain.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    User user2 = actualContext.getUser();
    assertEquals("42", user2.getUserId());
    assertNull(actualContext.getOriginalOpChain());
    List<Operation> operations = actualOperationChain.getOperations();
    assertEquals(1, operations.size());
    assertTrue(actualContext.getExporters().isEmpty());
    assertTrue(actualOperationChain.getOptions().isEmpty());
    assertTrue(actualContext.getVariables().isEmpty());
    assertTrue(user2.getDataAuths().isEmpty());
    assertTrue(user2.getOpAuths().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualOperationChain.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualOperationChain.getOperationsClass());
    assertSame(operation, operations.get(0));
  }

  /**
   * Test {@link GraphRequest#equals(Object)}, and {@link GraphRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GraphRequest#equals(Object)}
   *   <li>{@link GraphRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphRequest.equals(Object)", "int GraphRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);

    // Act and Assert
    assertEquals(graphRequest, graphRequest);
    int expectedHashCodeResult = graphRequest.hashCode();
    assertEquals(expectedHashCodeResult, graphRequest.hashCode());
  }

  /**
   * Test {@link GraphRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphRequest.equals(Object)", "int GraphRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);
    ExportToOtherAuthorisedGraph operation2 = new ExportToOtherAuthorisedGraph();

    Builder builder2 = new Builder();
    User user2 = (new User.Builder()).userId("42").build();
    Context context2 = builder2.user(user2).build();

    // Act and Assert
    assertNotEquals(graphRequest, new GraphRequest<>((Operation) operation2, context2));
  }

  /**
   * Test {@link GraphRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then throw exception.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then throw exception")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphRequest.equals(Object)", "int GraphRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenThrowException() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);
    OperationChain<Object> operation2 = mock(OperationChain.class);
    when(operation2.getOperations()).thenThrow(new IllegalArgumentException("foo"));

    Builder builder2 = new Builder();
    User user2 = (new User.Builder()).userId("42").build();
    Context context2 = builder2.user(user2).build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> graphRequest.equals(new GraphRequest<>((Operation) operation2, context2)));
  }

  /**
   * Test {@link GraphRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphRequest.equals(Object)", "int GraphRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);

    // Act and Assert
    assertNotEquals(graphRequest, null);
  }

  /**
   * Test {@link GraphRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GraphRequest.equals(Object)", "int GraphRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);

    // Act and Assert
    assertNotEquals(graphRequest, "Different type to GraphRequest");
  }
}
