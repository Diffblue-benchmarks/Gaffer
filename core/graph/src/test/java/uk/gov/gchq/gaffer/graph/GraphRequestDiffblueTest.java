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

package uk.gov.gchq.gaffer.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
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
   * Test {@link GraphRequest#GraphRequest(Operation, Context)}.
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Operation, Context)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Operation, Context)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, Context)"})
  void testNewGraphRequest() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    // Act
    GraphRequest<Object> actualGraphRequest =
        new GraphRequest<>((Operation) operation, new Context());

    // Assert
    List<Operation> operations = actualGraphRequest.getOperationChain().getOperations();
    assertEquals(1, operations.size());
    assertSame(operation, operations.get(0));
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, User)}.
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Operation, User)}
   */
  @Test
  @DisplayName("Test new GraphRequest(Operation, User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, User)"})
  void testNewGraphRequest2() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Operation) operation, new User());

    // Assert
    List<Operation> operations = actualGraphRequest.getOperationChain().getOperations();
    assertEquals(1, operations.size());
    assertSame(operation, operations.get(0));
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, Context)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Operation, Context)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Operation, Context); given HashMap(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, Context)"})
  void testNewGraphRequest_givenHashMap_thenThrowIllegalArgumentException() {
    // Arrange
    AddNamedOperation operation = new AddNamedOperation();
    operation.setOptions(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new GraphRequest<>(operation, (Context) null));
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, User)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Operation, User)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Operation, User); given HashMap(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, User)"})
  void testNewGraphRequest_givenHashMap_thenThrowIllegalArgumentException2() {
    // Arrange
    AddNamedOperation operation = new AddNamedOperation();
    operation.setOptions(new HashMap<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphRequest<>(operation, (User) null));
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, Context)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return OperationChain Options size is one.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Output, Context); given 'Name'; then return OperationChain Options size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Output, Context)"})
  void testNewGraphRequest_givenName_thenReturnOperationChainOptionsSizeIsOne() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    operation.addOption("Name", "42");
    Context context = new Context();

    // Act
    GraphRequest<Object> actualGraphRequest =
        new GraphRequest<>((Output<Object>) operation, context);

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    assertTrue(operationChain.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertEquals(1, operationChain.getOperations().size());
    Map<String, String> options = operationChain.getOptions();
    assertEquals(1, options.size());
    assertTrue(options.containsKey("Name"));
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, operationChain.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, operationChain.getOperationsClass());
    assertSame(context, actualGraphRequest.getContext());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, User)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return OperationChain Options size is one.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Output, User); given 'Name'; then return OperationChain Options size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Output, User)"})
  void testNewGraphRequest_givenName_thenReturnOperationChainOptionsSizeIsOne2() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    operation.addOption("Name", "42");
    User user = new User();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Output<Object>) operation, user);

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    assertTrue(operationChain.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    Context context = actualGraphRequest.getContext();
    assertNull(context.getOriginalOpChain());
    assertEquals(1, operationChain.getOperations().size());
    Map<String, String> options = operationChain.getOptions();
    assertEquals(1, options.size());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(options.containsKey("Name"));
    assertTrue(context.getVariables().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, operationChain.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, operationChain.getOperationsClass());
    assertSame(user, context.getUser());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, Context)}.
   *
   * <ul>
   *   <li>Then return OperationChain is wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Operation, Context)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Operation, Context); then return OperationChain is wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, Context)"})
  void testNewGraphRequest_thenReturnOperationChainIsWrapNamedOperation() {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act
    GraphRequest<Object> actualGraphRequest =
        new GraphRequest<>((Operation) operation, new Context());

    // Assert
    assertSame(operation, actualGraphRequest.getOperationChain());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, User)}.
   *
   * <ul>
   *   <li>Then return OperationChain is wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Operation, User)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Operation, User); then return OperationChain is wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, User)"})
  void testNewGraphRequest_thenReturnOperationChainIsWrapNamedOperation2() {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Operation) operation, new User());

    // Assert
    assertSame(operation, actualGraphRequest.getOperationChain());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, Context)}.
   *
   * <ul>
   *   <li>Then return OperationChain is wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Output, Context); then return OperationChain is wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Output, Context)"})
  void testNewGraphRequest_thenReturnOperationChainIsWrapNamedOperation3() {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    Context context = new Context();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>(operation, context);

    // Assert
    assertSame(context, actualGraphRequest.getContext());
    assertSame(operation, actualGraphRequest.getOperationChain());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, User)}.
   *
   * <ul>
   *   <li>Then return OperationChain is wrap {@link NamedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Output, User); then return OperationChain is wrap NamedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Output, User)"})
  void testNewGraphRequest_thenReturnOperationChainIsWrapNamedOperation4() {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());
    User user = new User();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>(operation, user);

    // Assert
    Context context = actualGraphRequest.getContext();
    assertNull(context.getOriginalOpChain());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    assertSame(user, context.getUser());
    assertSame(operation, actualGraphRequest.getOperationChain());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, Context)}.
   *
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).
   *   <li>Then return OperationChain Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Output, Context); when NamedOperation (default constructor); then return OperationChain Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Output, Context)"})
  void testNewGraphRequest_whenNamedOperation_thenReturnOperationChainOptionsEmpty() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    Context context = new Context();

    // Act
    GraphRequest<Object> actualGraphRequest =
        new GraphRequest<>((Output<Object>) operation, context);

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    assertTrue(operationChain.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    assertEquals(1, operationChain.getOperations().size());
    assertTrue(operationChain.getOptions().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, operationChain.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, operationChain.getOperationsClass());
    assertSame(context, actualGraphRequest.getContext());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, User)}.
   *
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).
   *   <li>Then return OperationChain Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Output, User); when NamedOperation (default constructor); then return OperationChain Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Output, User)"})
  void testNewGraphRequest_whenNamedOperation_thenReturnOperationChainOptionsEmpty2() {
    // Arrange
    NamedOperation<Object, Object> operation = new NamedOperation<>();
    User user = new User();

    // Act
    GraphRequest<Object> actualGraphRequest = new GraphRequest<>((Output<Object>) operation, user);

    // Assert
    OperationChain<Object> operationChain = actualGraphRequest.getOperationChain();
    assertTrue(operationChain.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    Context context = actualGraphRequest.getContext();
    assertNull(context.getOriginalOpChain());
    assertEquals(1, operationChain.getOperations().size());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(operationChain.getOptions().isEmpty());
    assertTrue(context.getVariables().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, operationChain.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, operationChain.getOperationsClass());
    assertSame(user, context.getUser());
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, Context)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Operation, Context)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Operation, Context); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, Context)"})
  void testNewGraphRequest_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new GraphRequest<>((Operation) null, new Context()));
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Operation, User)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Operation, User)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Operation, User); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Operation, User)"})
  void testNewGraphRequest_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new GraphRequest<>((Operation) null, new User()));
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, Context)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Output, Context); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Output, Context)"})
  void testNewGraphRequest_whenNull_thenThrowIllegalArgumentException3() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphRequest<>((Output<Object>) null, new Context()));
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, User)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Output, User); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Output, User)"})
  void testNewGraphRequest_whenNull_thenThrowIllegalArgumentException4() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphRequest<>((Output<Object>) null, new User()));
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, Context)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Output, Context)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Output, Context); when wrap NamedOperation (default constructor); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Output, Context)"})
  void testNewGraphRequest_whenWrapNamedOperation_thenThrowIllegalArgumentException() {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new GraphRequest<>(operation, (Context) null));
  }

  /**
   * Test {@link GraphRequest#GraphRequest(Output, User)}.
   *
   * <ul>
   *   <li>When wrap {@link NamedOperation} (default constructor).
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#GraphRequest(Output, User)}
   */
  @Test
  @DisplayName(
      "Test new GraphRequest(Output, User); when wrap NamedOperation (default constructor); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphRequest.<init>(Output, User)"})
  void testNewGraphRequest_whenWrapNamedOperation_thenThrowIllegalArgumentException2() {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new GraphRequest<>(operation, (User) null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GraphRequest#toString()}
   *   <li>{@link GraphRequest#getContext()}
   *   <li>{@link GraphRequest#getOperationChain()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Context GraphRequest.getContext()",
    "OperationChain GraphRequest.getOperationChain()",
    "String GraphRequest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);

    // Act
    graphRequest.toString();
    Context actualContext = graphRequest.getContext();
    OperationChain<Object> actualOperationChain = graphRequest.getOperationChain();

    // Assert
    assertTrue(actualOperationChain.getOutputTypeReference() instanceof TypeReferenceImpl.Object);
    User user = actualContext.getUser();
    assertEquals("42", user.getUserId());
    assertNull(actualContext.getOriginalOpChain());
    List<Operation> operations = actualOperationChain.getOperations();
    assertEquals(1, operations.size());
    assertTrue(actualContext.getExporters().isEmpty());
    assertTrue(actualOperationChain.getOptions().isEmpty());
    assertTrue(actualContext.getVariables().isEmpty());
    assertTrue(user.getDataAuths().isEmpty());
    assertTrue(user.getOpAuths().isEmpty());
    Class<Object> expectedOutputClass = Object.class;
    assertEquals(expectedOutputClass, actualOperationChain.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualOperationChain.getOperationsClass());
    assertSame(operation, operations.get(0));
  }

  /**
   * Test {@link GraphRequest#equals(Object)}, and {@link GraphRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GraphRequest#equals(Object)}
   *   <li>{@link GraphRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphRequest.equals(Object)", "int GraphRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);

    // Act and Assert
    assertEquals(graphRequest, graphRequest);
    int expectedHashCodeResult = graphRequest.hashCode();
    assertEquals(expectedHashCodeResult, graphRequest.hashCode());
  }

  /**
   * Test {@link GraphRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphRequest.equals(Object)", "int GraphRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);
    ExportToOtherAuthorisedGraph operation2 = new ExportToOtherAuthorisedGraph();

    Builder builder2 = new Builder();
    Context context2 = builder2.user(new User.Builder().userId("42").build()).build();

    // Act and Assert
    assertNotEquals(graphRequest, new GraphRequest<>((Operation) operation2, context2));
  }

  /**
   * Test {@link GraphRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then throw exception.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then throw exception")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphRequest.equals(Object)", "int GraphRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenThrowException() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);

    OperationChain<Object> operation2 = mock(OperationChain.class);
    when(operation2.getOperations()).thenThrow(new IllegalArgumentException());

    Builder builder2 = new Builder();
    Context context2 = builder2.user(new User.Builder().userId("42").build()).build();
    GraphRequest<Object> graphRequest2 = new GraphRequest<>((Operation) operation2, context2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> graphRequest.equals(graphRequest2));
  }

  /**
   * Test {@link GraphRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphRequest.equals(Object)", "int GraphRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);

    // Act and Assert
    assertNotEquals(graphRequest, null);
  }

  /**
   * Test {@link GraphRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link GraphRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GraphRequest.equals(Object)", "int GraphRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    Builder builder = new Builder();
    Context context = builder.user(new User.Builder().userId("42").build()).build();
    GraphRequest<Object> graphRequest = new GraphRequest<>((Operation) operation, context);

    // Act and Assert
    assertNotEquals(graphRequest, "Different type to GraphRequest");
  }
}
