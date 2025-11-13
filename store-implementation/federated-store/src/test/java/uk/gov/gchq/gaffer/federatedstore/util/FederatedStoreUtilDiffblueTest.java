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

package uk.gov.gchq.gaffer.federatedstore.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.operation.hdfs.operation.ImportAccumuloKeyValueFiles;
import uk.gov.gchq.gaffer.core.exception.GafferCheckedException;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.federatedstore.FederatedStoreTestUtil;
import uk.gov.gchq.gaffer.federatedstore.operation.AddGraph;
import uk.gov.gchq.gaffer.federatedstore.operation.ChangeGraphAccess;
import uk.gov.gchq.gaffer.federatedstore.operation.FederatedOperation;
import uk.gov.gchq.gaffer.federatedstore.operation.FederatedOperation.BuilderParent;
import uk.gov.gchq.gaffer.federatedstore.operation.FederatedOperationChainValidator;
import uk.gov.gchq.gaffer.federatedstore.util.FederatedStoreUtil.SerialisableConfiguredMergeFunctionsMap;
import uk.gov.gchq.gaffer.graph.Graph;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationChainDAO;
import uk.gov.gchq.gaffer.operation.export.graph.ExportToOtherAuthorisedGraph;
import uk.gov.gchq.gaffer.operation.impl.DiscardOutput;
import uk.gov.gchq.gaffer.operation.impl.If;
import uk.gov.gchq.gaffer.operation.impl.OperationImpl;
import uk.gov.gchq.gaffer.operation.impl.add.AddElements;
import uk.gov.gchq.gaffer.operation.impl.io.GenericInputImpl;
import uk.gov.gchq.gaffer.operation.io.Input;
import uk.gov.gchq.gaffer.operation.io.InputOutput;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.util.Conditional;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.TypeReferenceStoreImpl;
import uk.gov.gchq.gaffer.store.operation.GetSchema;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.koryphe.iterable.ChainedIterable;
import uk.gov.gchq.koryphe.iterable.ChainedIterator;

class FederatedStoreUtilDiffblueTest {
  /**
   * Test {@link FederatedStoreUtil#createOperationErrorMsg(Operation, String, Exception)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#createOperationErrorMsg(Operation, String,
   * Exception)}
   */
  @Test
  @DisplayName(
      "Test createOperationErrorMsg(Operation, String, Exception); when AddGraph (default constructor); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FederatedStoreUtil.createOperationErrorMsg(Operation, String, Exception)"
  })
  void testCreateOperationErrorMsg_whenAddGraph_thenReturnAString() {
    // Arrange
    AddGraph operation = new AddGraph();

    // Act
    String actualCreateOperationErrorMsgResult =
        FederatedStoreUtil.createOperationErrorMsg(operation, "42", new Exception());

    // Assert
    assertEquals(
        "Failed to execute AddGraph on graph 42.\n"
            + " Set the skip and continue option: skipFailedFederatedExecution for operation: AddGraph.\n"
            + " Error: null",
        actualCreateOperationErrorMsgResult);
  }

  /**
   * Test {@link FederatedStoreUtil#getCleanStrings(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getCleanStrings(String)}
   */
  @Test
  @DisplayName("Test getCleanStrings(String); when '42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FederatedStoreUtil.getCleanStrings(String)"})
  void testGetCleanStrings_when42_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualCleanStrings = FederatedStoreUtil.getCleanStrings("42");

    // Assert
    assertEquals(1, actualCleanStrings.size());
    assertEquals("42", actualCleanStrings.get(0));
  }

  /**
   * Test {@link FederatedStoreUtil#getCleanStrings(String)}.
   *
   * <ul>
   *   <li>When {@code ,42}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getCleanStrings(String)}
   */
  @Test
  @DisplayName("Test getCleanStrings(String); when ',42'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FederatedStoreUtil.getCleanStrings(String)"})
  void testGetCleanStrings_when42_thenReturnSizeIsOne2() {
    // Arrange and Act
    List<String> actualCleanStrings = FederatedStoreUtil.getCleanStrings(",42");

    // Assert
    assertEquals(1, actualCleanStrings.size());
    assertEquals("42", actualCleanStrings.get(0));
  }

  /**
   * Test {@link FederatedStoreUtil#getCleanStrings(String)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getCleanStrings(String)}
   */
  @Test
  @DisplayName("Test getCleanStrings(String); when ','; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FederatedStoreUtil.getCleanStrings(String)"})
  void testGetCleanStrings_whenComma_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualCleanStrings = FederatedStoreUtil.getCleanStrings(",");

    // Assert
    assertTrue(actualCleanStrings.isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#getCleanStrings(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getCleanStrings(String)}
   */
  @Test
  @DisplayName("Test getCleanStrings(String); when empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FederatedStoreUtil.getCleanStrings(String)"})
  void testGetCleanStrings_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualCleanStrings = FederatedStoreUtil.getCleanStrings("");

    // Assert
    assertTrue(actualCleanStrings.isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#getCleanStrings(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getCleanStrings(String)}
   */
  @Test
  @DisplayName("Test getCleanStrings(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FederatedStoreUtil.getCleanStrings(String)"})
  void testGetCleanStrings_whenNull_thenReturnNull() {
    // Arrange and Act
    List<String> actualCleanStrings = FederatedStoreUtil.getCleanStrings(null);

    // Assert
    assertNull(actualCleanStrings);
  }

  /**
   * Test SerialisableConfiguredMergeFunctionsMap getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SerialisableConfiguredMergeFunctionsMap}
   *   <li>{@link SerialisableConfiguredMergeFunctionsMap#setMap(HashMap)}
   *   <li>{@link SerialisableConfiguredMergeFunctionsMap#getMap()}
   * </ul>
   */
  @Test
  @DisplayName("Test SerialisableConfiguredMergeFunctionsMap getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SerialisableConfiguredMergeFunctionsMap.<init>()",
    "HashMap SerialisableConfiguredMergeFunctionsMap.getMap()",
    "void SerialisableConfiguredMergeFunctionsMap.setMap(HashMap)"
  })
  void testSerialisableConfiguredMergeFunctionsMapGettersAndSetters() {
    // Arrange and Act
    SerialisableConfiguredMergeFunctionsMap actualSerialisableConfiguredMergeFunctionsMap =
        new SerialisableConfiguredMergeFunctionsMap();
    HashMap<String, BiFunction> map = new HashMap<>();
    actualSerialisableConfiguredMergeFunctionsMap.setMap(map);

    // Assert
    assertSame(map, actualSerialisableConfiguredMergeFunctionsMap.getMap());
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName("Test updateOperationForGraph(Operation, Graph, Context)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph() {
    // Arrange
    OperationChainDAO<Object> operationChainDAO =
        new OperationChainDAO<>((Operation) new OperationChain<>());

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            operationChainDAO, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    assertEquals(operationChainDAO, actualUpdateOperationForGraphResult);
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName("Test updateOperationForGraph(Operation, Graph, Context)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph2() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    OperationImpl op = new OperationImpl();
    operation.payloadOperation(op);
    OperationChain<Object> wrapResult = OperationChain.wrap(operation);

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            wrapResult, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    List<Operation> operations =
        ((OperationChain<Object>) actualUpdateOperationForGraphResult).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof FederatedOperation);
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    assertTrue(
        ((FederatedOperation<Object, Object>) getResult).getPayloadOperation()
            instanceof OperationImpl);
    Operation unClonedPayload =
        ((FederatedOperation<Object, Object>) getResult).getUnClonedPayload();
    assertTrue(unClonedPayload instanceof OperationImpl);
    Class<OperationImpl> expectedPayloadClass = OperationImpl.class;
    assertEquals(
        expectedPayloadClass, ((FederatedOperation<Object, Object>) getResult).getPayloadClass());
    assertSame(op, unClonedPayload);
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName("Test updateOperationForGraph(Operation, Graph, Context)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph3() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    OperationChain<Object> op = new OperationChain<>();
    operation.payloadOperation(op);
    OperationChain<Object> wrapResult = OperationChain.wrap(operation);

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            wrapResult, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    List<Operation> operations =
        ((OperationChain<Object>) actualUpdateOperationForGraphResult).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof FederatedOperation);
    Operation payloadOperation =
        ((FederatedOperation<Object, Object>) getResult).getPayloadOperation();
    assertTrue(payloadOperation instanceof OperationChain);
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    assertEquals(op, payloadOperation);
    Class<OperationChain> expectedPayloadClass = OperationChain.class;
    assertEquals(
        expectedPayloadClass, ((FederatedOperation<Object, Object>) getResult).getPayloadClass());
    assertSame(op, ((FederatedOperation<Object, Object>) getResult).getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName("Test updateOperationForGraph(Operation, Graph, Context)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph4() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    op.payloadOperation(new AddGraph());

    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    operation.payloadOperation(op);
    OperationChain<Object> wrapResult = OperationChain.wrap(operation);

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            wrapResult, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    List<Operation> operations =
        ((OperationChain<Object>) actualUpdateOperationForGraphResult).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof FederatedOperation);
    Operation payloadOperation =
        ((FederatedOperation<Object, Object>) getResult).getPayloadOperation();
    assertTrue(payloadOperation instanceof FederatedOperation);
    Operation unClonedPayload =
        ((FederatedOperation<Object, Object>) getResult).getUnClonedPayload();
    assertTrue(unClonedPayload instanceof FederatedOperation);
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    assertEquals(op, payloadOperation);
    Class<FederatedOperation> expectedPayloadClass = FederatedOperation.class;
    assertEquals(
        expectedPayloadClass, ((FederatedOperation<Object, Object>) getResult).getPayloadClass());
    assertSame(op, unClonedPayload);
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName(
      "Test updateOperationForGraph(Operation, Graph, Context); given AddGraph (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph_givenAddGraph() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    AddGraph op = new AddGraph();
    operation.payloadOperation(op);
    OperationChain<Object> wrapResult = OperationChain.wrap(operation);

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            wrapResult, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    List<Operation> operations =
        ((OperationChain<Object>) actualUpdateOperationForGraphResult).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(
        ((FederatedOperation<Object, Object>) getResult).getPayloadOperation() instanceof AddGraph);
    Operation unClonedPayload =
        ((FederatedOperation<Object, Object>) getResult).getUnClonedPayload();
    assertTrue(unClonedPayload instanceof AddGraph);
    assertTrue(getResult instanceof FederatedOperation);
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    Class<AddGraph> expectedPayloadClass = AddGraph.class;
    assertEquals(
        expectedPayloadClass, ((FederatedOperation<Object, Object>) getResult).getPayloadClass());
    assertSame(op, unClonedPayload);
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <ul>
   *   <li>Given {@link Conditional#Conditional()}.
   *   <li>When {@link If} (default constructor) Conditional is {@link Conditional#Conditional()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName(
      "Test updateOperationForGraph(Operation, Graph, Context); given Conditional(); when If (default constructor) Conditional is Conditional()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph_givenConditional_whenIfConditionalIsConditional() {
    // Arrange
    If<Object, Object> operation = new If<>();
    operation.setConditional(new Conditional());
    OperationChain<Object> wrapResult = OperationChain.wrap(operation);

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            wrapResult, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    assertEquals(wrapResult, actualUpdateOperationForGraphResult);
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName(
      "Test updateOperationForGraph(Operation, Graph, Context); given HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph_givenHashMap_thenReturnOptionsEmpty() {
    // Arrange
    AddGraph addGraph = new AddGraph();
    addGraph.setOptions(new HashMap<>());

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            addGraph, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    assertTrue(actualUpdateOperationForGraphResult instanceof AddGraph);
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getGraphId());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getParentPropertiesId());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getParentSchemaIds());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getProperties());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getGraphAuths());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getReadAccessPredicate());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getWriteAccessPredicate());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getStoreProperties());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getSchema());
    assertFalse(((AddGraph) actualUpdateOperationForGraphResult).getIsPublic());
    assertFalse(((AddGraph) actualUpdateOperationForGraphResult).isUserRequestingAdminUsage());
    assertTrue(actualUpdateOperationForGraphResult.getOptions().isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <ul>
   *   <li>Then Operations first return {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName(
      "Test updateOperationForGraph(Operation, Graph, Context); then Operations first return AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph_thenOperationsFirstReturnAddGraph() {
    // Arrange
    OperationChainDAO<Object> operationChainDAO = new OperationChainDAO<>(new AddGraph());

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            operationChainDAO, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    List<Operation> operations =
        ((OperationChain<Object>) actualUpdateOperationForGraphResult).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof AddGraph);
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    assertNull(((AddGraph) getResult).getGraphId());
    assertNull(((AddGraph) getResult).getParentPropertiesId());
    assertNull(((AddGraph) getResult).getParentSchemaIds());
    assertNull(getResult.getOptions());
    assertNull(((AddGraph) getResult).getProperties());
    assertNull(((AddGraph) getResult).getGraphAuths());
    assertNull(((AddGraph) getResult).getReadAccessPredicate());
    assertNull(((AddGraph) getResult).getWriteAccessPredicate());
    assertNull(((AddGraph) getResult).getStoreProperties());
    assertNull(((AddGraph) getResult).getSchema());
    assertFalse(((AddGraph) getResult).getIsPublic());
    assertFalse(((AddGraph) getResult).isUserRequestingAdminUsage());
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <ul>
   *   <li>Then Operations first return {@link NamedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName(
      "Test updateOperationForGraph(Operation, Graph, Context); then Operations first return NamedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph_thenOperationsFirstReturnNamedOperation() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new NamedOperation<>());

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            wrapResult, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    List<Operation> operations =
        ((OperationChain<Object>) actualUpdateOperationForGraphResult).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof NamedOperation);
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    assertTrue(
        ((NamedOperation<Object, Object>) getResult).getOutputTypeReference()
            instanceof TypeReferenceImpl.Object);
    assertNull(((NamedOperation<Object, Object>) getResult).getInput());
    assertNull(((NamedOperation<Object, Object>) getResult).getOperationName());
    assertNull(((NamedOperation<Object, Object>) getResult).getParameters());
    assertNull(getResult.getOptions());
    assertTrue(((NamedOperation<Object, Object>) getResult).getOperations().isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <ul>
   *   <li>Then return Operations first Operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName(
      "Test updateOperationForGraph(Operation, Graph, Context); then return Operations first Operations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph_thenReturnOperationsFirstOperationsSizeIsOne() {
    // Arrange
    AddGraph op = new AddGraph();
    op.setOptions(new HashMap<>());

    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    operation.graphIds(new ArrayList<>());
    operation.payloadOperation(op);
    OperationChain<Object> wrapResult = OperationChain.wrap(operation);

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            wrapResult, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    List<Operation> operations =
        ((OperationChain<Object>) actualUpdateOperationForGraphResult).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    Collection<Operation> operations2 =
        ((FederatedOperation<Object, Object>) getResult).getOperations();
    assertEquals(1, operations2.size());
    assertTrue(operations2 instanceof List);
    Operation getResult2 = ((List<Operation>) operations2).get(0);
    assertTrue(getResult2 instanceof AddGraph);
    Operation payloadOperation =
        ((FederatedOperation<Object, Object>) getResult).getPayloadOperation();
    assertTrue(payloadOperation instanceof AddGraph);
    Operation unClonedPayload =
        ((FederatedOperation<Object, Object>) getResult).getUnClonedPayload();
    assertTrue(unClonedPayload instanceof AddGraph);
    assertTrue(getResult instanceof FederatedOperation);
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    assertTrue(((FederatedOperation<Object, Object>) getResult).getGraphIds().isEmpty());
    assertTrue(getResult2.getOptions().isEmpty());
    assertTrue(payloadOperation.getOptions().isEmpty());
    assertTrue(unClonedPayload.getOptions().isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <ul>
   *   <li>Then return Operations first PayloadClass is {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName(
      "Test updateOperationForGraph(Operation, Graph, Context); then return Operations first PayloadClass is AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph_thenReturnOperationsFirstPayloadClassIsAddGraph() {
    // Arrange
    AddGraph op = new AddGraph();
    op.setOptions(new HashMap<>());

    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    operation.payloadOperation(op);
    OperationChain<Object> wrapResult = OperationChain.wrap(operation);

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            wrapResult, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    List<Operation> operations =
        ((OperationChain<Object>) actualUpdateOperationForGraphResult).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(
        ((FederatedOperation<Object, Object>) getResult).getPayloadOperation() instanceof AddGraph);
    Operation unClonedPayload =
        ((FederatedOperation<Object, Object>) getResult).getUnClonedPayload();
    assertTrue(unClonedPayload instanceof AddGraph);
    assertTrue(getResult instanceof FederatedOperation);
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    Class<AddGraph> expectedPayloadClass = AddGraph.class;
    assertEquals(
        expectedPayloadClass, ((FederatedOperation<Object, Object>) getResult).getPayloadClass());
    assertSame(op, unClonedPayload);
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <ul>
   *   <li>Then return Operations first PayloadOperation is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName(
      "Test updateOperationForGraph(Operation, Graph, Context); then return Operations first PayloadOperation is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph_thenReturnOperationsFirstPayloadOperationIsNull() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    GenericInputImpl op = new GenericInputImpl();
    operation.payloadOperation(op);
    OperationChain<Object> wrapResult = OperationChain.wrap(operation);

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            wrapResult, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    List<Operation> operations =
        ((OperationChain<Object>) actualUpdateOperationForGraphResult).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof FederatedOperation);
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    assertNull(((FederatedOperation<Object, Object>) getResult).getPayloadOperation());
    Class<GenericInputImpl> expectedPayloadClass = GenericInputImpl.class;
    assertEquals(
        expectedPayloadClass, ((FederatedOperation<Object, Object>) getResult).getPayloadClass());
    assertSame(op, ((FederatedOperation<Object, Object>) getResult).getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName(
      "Test updateOperationForGraph(Operation, Graph, Context); when AddGraph (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph_whenAddGraph_thenReturnOptionsIsNull() {
    // Arrange
    AddGraph addGraph = new AddGraph();

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            addGraph, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    assertTrue(actualUpdateOperationForGraphResult instanceof AddGraph);
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getGraphId());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getParentPropertiesId());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getParentSchemaIds());
    assertNull(actualUpdateOperationForGraphResult.getOptions());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getProperties());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getGraphAuths());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getReadAccessPredicate());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getWriteAccessPredicate());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getStoreProperties());
    assertNull(((AddGraph) actualUpdateOperationForGraphResult).getSchema());
    assertFalse(((AddGraph) actualUpdateOperationForGraphResult).getIsPublic());
    assertFalse(((AddGraph) actualUpdateOperationForGraphResult).isUserRequestingAdminUsage());
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.
   *   <li>Then return {@link OperationChain#OperationChain()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName(
      "Test updateOperationForGraph(Operation, Graph, Context); when OperationChain(); then return OperationChain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph_whenOperationChain_thenReturnOperationChain() {
    // Arrange
    OperationChain<Object> operationChain = new OperationChain<>();

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            operationChain, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    assertEquals(operationChain, actualUpdateOperationForGraphResult);
  }

  /**
   * Test {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph, Context)}.
   *
   * <ul>
   *   <li>When wrap {@link If} (default constructor).
   *   <li>Then return wrap {@link If} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#updateOperationForGraph(Operation, Graph,
   * Context)}
   */
  @Test
  @DisplayName(
      "Test updateOperationForGraph(Operation, Graph, Context); when wrap If (default constructor); then return wrap If (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation FederatedStoreUtil.updateOperationForGraph(Operation, Graph, Context)"
  })
  void testUpdateOperationForGraph_whenWrapIf_thenReturnWrapIf() {
    // Arrange
    OperationChain<Object> wrapResult = OperationChain.wrap(new If<>());

    // Act
    Operation actualUpdateOperationForGraphResult =
        FederatedStoreUtil.updateOperationForGraph(
            wrapResult, null, FederatedStoreTestUtil.contextAuthUser());

    // Assert
    assertTrue(actualUpdateOperationForGraphResult instanceof OperationChain);
    assertEquals(wrapResult, actualUpdateOperationForGraphResult);
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Input)} with {@code Input}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Input)}
   */
  @Test
  @DisplayName("Test getFederatedOperation(Input) with 'Input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Input)"})
  void testGetFederatedOperationWithInput() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "");

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation((Input<Object>) operation);

    // Assert
    Operation unClonedPayload = actualFederatedOperation.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof FederatedOperation);
    Map<String, String> options = actualFederatedOperation.getOptions();
    assertEquals(1, options.size());
    assertEquals("", options.get(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION));
    List<String> graphIds = actualFederatedOperation.getGraphIds();
    assertTrue(graphIds.isEmpty());
    assertEquals(graphIds, ((FederatedOperation<Object, Object>) unClonedPayload).getOperations());
    assertEquals(options, unClonedPayload.getOptions());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(InputOutput)} with {@code InputOutput}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(InputOutput)}
   */
  @Test
  @DisplayName("Test getFederatedOperation(InputOutput) with 'InputOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(InputOutput)"})
  void testGetFederatedOperationWithInputOutput() {
    // Arrange
    FederatedOperation<Object, Iterable<?>> operation = new FederatedOperation<>();

    // Act
    FederatedOperation<Object, Iterable<?>> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation(operation);

    // Assert
    Class<FederatedOperation> expectedPayloadClass = FederatedOperation.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, actualFederatedOperation.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(InputOutput)} with {@code InputOutput}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(InputOutput)}
   */
  @Test
  @DisplayName("Test getFederatedOperation(InputOutput) with 'InputOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(InputOutput)"})
  void testGetFederatedOperationWithInputOutput2() {
    // Arrange
    If<Object, Iterable<?>> operation = new If<>();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "42");

    // Act
    FederatedOperation<Object, Iterable<?>> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation(operation);

    // Assert
    Collection<Operation> operations = actualFederatedOperation.getOperations();
    assertEquals(1, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(actualFederatedOperation.getPayloadOperation() instanceof If);
    Operation unClonedPayload = actualFederatedOperation.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof If);
    assertEquals(1, actualFederatedOperation.getGraphIds().size());
    Class<If> expectedPayloadClass = If.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, unClonedPayload);
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(InputOutput)} with {@code InputOutput}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(InputOutput)}
   */
  @Test
  @DisplayName("Test getFederatedOperation(InputOutput) with 'InputOutput'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(InputOutput)"})
  void testGetFederatedOperationWithInputOutput3() {
    // Arrange
    FederatedOperation<Object, Iterable<?>> operation = new FederatedOperation<>();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "");

    // Act
    FederatedOperation<Object, Iterable<?>> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation(operation);

    // Assert
    Operation unClonedPayload = actualFederatedOperation.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof FederatedOperation);
    Map<String, String> options = actualFederatedOperation.getOptions();
    assertEquals(1, options.size());
    assertEquals("", options.get(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION));
    List<String> graphIds = actualFederatedOperation.getGraphIds();
    assertTrue(graphIds.isEmpty());
    assertEquals(graphIds, ((FederatedOperation<Object, Object>) unClonedPayload).getOperations());
    assertEquals(options, unClonedPayload.getOptions());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(InputOutput)} with {@code InputOutput}.
   *
   * <ul>
   *   <li>Then return GraphIds first is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(InputOutput)}
   */
  @Test
  @DisplayName(
      "Test getFederatedOperation(InputOutput) with 'InputOutput'; then return GraphIds first is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(InputOutput)"})
  void testGetFederatedOperationWithInputOutput_thenReturnGraphIdsFirstIs42() {
    // Arrange
    FederatedOperation<Object, Iterable<?>> operation = new FederatedOperation<>();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "42");

    // Act
    FederatedOperation<Object, Iterable<?>> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation(operation);

    // Assert
    Operation unClonedPayload = actualFederatedOperation.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof FederatedOperation);
    List<String> graphIds = actualFederatedOperation.getGraphIds();
    assertEquals(1, graphIds.size());
    assertEquals("42", graphIds.get(0));
    Map<String, String> options = actualFederatedOperation.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION));
    assertEquals(options, unClonedPayload.getOptions());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(InputOutput)} with {@code InputOutput}.
   *
   * <ul>
   *   <li>When {@link If} (default constructor).
   *   <li>Then return GraphIds is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(InputOutput)}
   */
  @Test
  @DisplayName(
      "Test getFederatedOperation(InputOutput) with 'InputOutput'; when If (default constructor); then return GraphIds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(InputOutput)"})
  void testGetFederatedOperationWithInputOutput_whenIf_thenReturnGraphIdsIsNull() {
    // Arrange
    If<Object, Iterable<?>> operation = new If<>();

    // Act
    FederatedOperation<Object, Iterable<?>> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation(operation);

    // Assert
    Collection<Operation> operations = actualFederatedOperation.getOperations();
    assertEquals(1, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(actualFederatedOperation.getPayloadOperation() instanceof If);
    Operation unClonedPayload = actualFederatedOperation.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof If);
    assertNull(actualFederatedOperation.getGraphIds());
    assertTrue(actualFederatedOperation.getOptions().isEmpty());
    Class<If> expectedPayloadClass = If.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, unClonedPayload);
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Input)} with {@code Input}.
   *
   * <ul>
   *   <li>Then return GraphIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Input)}
   */
  @Test
  @DisplayName("Test getFederatedOperation(Input) with 'Input'; then return GraphIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Input)"})
  void testGetFederatedOperationWithInput_thenReturnGraphIdsSizeIsOne() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "42");

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation((Input<Object>) operation);

    // Assert
    Operation unClonedPayload = actualFederatedOperation.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof FederatedOperation);
    List<String> graphIds = actualFederatedOperation.getGraphIds();
    assertEquals(1, graphIds.size());
    assertEquals("42", graphIds.get(0));
    Map<String, String> options = actualFederatedOperation.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION));
    assertEquals(options, unClonedPayload.getOptions());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Input)} with {@code Input}.
   *
   * <ul>
   *   <li>Then return Operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Input)}
   */
  @Test
  @DisplayName("Test getFederatedOperation(Input) with 'Input'; then return Operations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Input)"})
  void testGetFederatedOperationWithInput_thenReturnOperationsSizeIsOne() {
    // Arrange
    DiscardOutput operation = new DiscardOutput();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "42");

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation(operation);

    // Assert
    Collection<Operation> operations = actualFederatedOperation.getOperations();
    assertEquals(1, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(((List<Operation>) operations).get(0) instanceof DiscardOutput);
    Operation payloadOperation = actualFederatedOperation.getPayloadOperation();
    assertTrue(payloadOperation instanceof DiscardOutput);
    assertNull(((DiscardOutput) payloadOperation).getInput());
    Class<DiscardOutput> expectedPayloadClass = DiscardOutput.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, actualFederatedOperation.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Input)} with {@code Input}.
   *
   * <ul>
   *   <li>Then return PayloadClass is {@link FederatedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Input)}
   */
  @Test
  @DisplayName(
      "Test getFederatedOperation(Input) with 'Input'; then return PayloadClass is FederatedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Input)"})
  void testGetFederatedOperationWithInput_thenReturnPayloadClassIsFederatedOperation() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation((Input<Object>) operation);

    // Assert
    Class<FederatedOperation> expectedPayloadClass = FederatedOperation.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, actualFederatedOperation.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Input)} with {@code Input}.
   *
   * <ul>
   *   <li>Then UnClonedPayload return {@link DiscardOutput}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Input)}
   */
  @Test
  @DisplayName(
      "Test getFederatedOperation(Input) with 'Input'; then UnClonedPayload return DiscardOutput")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Input)"})
  void testGetFederatedOperationWithInput_thenUnClonedPayloadReturnDiscardOutput() {
    // Arrange and Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation(new DiscardOutput());

    // Assert
    Operation payloadOperation = actualFederatedOperation.getPayloadOperation();
    assertTrue(payloadOperation instanceof DiscardOutput);
    Operation unClonedPayload = actualFederatedOperation.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof DiscardOutput);
    assertNull(actualFederatedOperation.getGraphIds());
    assertNull(payloadOperation.getOptions());
    assertNull(unClonedPayload.getOptions());
    assertTrue(actualFederatedOperation.getOptions().isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Operation)} with {@code Operation}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Operation)}
   */
  @Test
  @DisplayName("Test getFederatedOperation(Operation) with 'Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Operation)"})
  void testGetFederatedOperationWithOperation() {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.put(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "Operation");

    ImportAccumuloKeyValueFiles operation = new ImportAccumuloKeyValueFiles();
    operation.setOptions(options);

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation(operation);

    // Assert
    Collection<Operation> operations = actualFederatedOperation.getOperations();
    assertEquals(1, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(((List<Operation>) operations).get(0) instanceof ImportAccumuloKeyValueFiles);
    Operation payloadOperation = actualFederatedOperation.getPayloadOperation();
    assertTrue(payloadOperation instanceof ImportAccumuloKeyValueFiles);
    List<String> graphIds = actualFederatedOperation.getGraphIds();
    assertEquals(1, graphIds.size());
    assertEquals("Operation", graphIds.get(0));
    Map<String, String> options2 = actualFederatedOperation.getOptions();
    assertEquals(1, options2.size());
    assertEquals("Operation", options2.get(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION));
    assertNull(((ImportAccumuloKeyValueFiles) payloadOperation).getFailurePath());
    assertNull(((ImportAccumuloKeyValueFiles) payloadOperation).getInputPath());
    Map<String, String> options3 = payloadOperation.getOptions();
    assertEquals(1, options3.size());
    assertTrue(options3.containsKey(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION));
    Class<ImportAccumuloKeyValueFiles> expectedPayloadClass = ImportAccumuloKeyValueFiles.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, actualFederatedOperation.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Operation)} with {@code Operation}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Operation)}
   */
  @Test
  @DisplayName("Test getFederatedOperation(Operation) with 'Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Operation)"})
  void testGetFederatedOperationWithOperation2() {
    // Arrange
    ExportToOtherAuthorisedGraph operation = new ExportToOtherAuthorisedGraph();

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation((Operation) operation);

    // Assert
    Class<ExportToOtherAuthorisedGraph> expectedPayloadClass = ExportToOtherAuthorisedGraph.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, actualFederatedOperation.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Operation)} with {@code Operation}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Operation)}
   */
  @Test
  @DisplayName("Test getFederatedOperation(Operation) with 'Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Operation)"})
  void testGetFederatedOperationWithOperation3() {
    // Arrange
    ChangeGraphAccess operation = new ChangeGraphAccess();

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation((Operation) operation);

    // Assert
    assertTrue(actualFederatedOperation.getPayloadOperation() instanceof ChangeGraphAccess);
    Operation unClonedPayload = actualFederatedOperation.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof ChangeGraphAccess);
    Class<ChangeGraphAccess> expectedPayloadClass = ChangeGraphAccess.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, unClonedPayload);
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Operation)} with {@code Operation}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Operation)}
   */
  @Test
  @DisplayName("Test getFederatedOperation(Operation) with 'Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Operation)"})
  void testGetFederatedOperationWithOperation4() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "42");

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation((Operation) operation);

    // Assert
    Class<FederatedOperation> expectedPayloadClass = FederatedOperation.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, actualFederatedOperation.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>Then Operations first return {@link AddElements}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test getFederatedOperation(Operation) with 'Operation'; then Operations first return AddElements")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Operation)"})
  void testGetFederatedOperationWithOperation_thenOperationsFirstReturnAddElements() {
    // Arrange
    AddElements operation = new AddElements();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "42");

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation((Operation) operation);

    // Assert
    Collection<Operation> operations = actualFederatedOperation.getOperations();
    assertEquals(1, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(((List<Operation>) operations).get(0) instanceof AddElements);
    assertTrue(actualFederatedOperation.getPayloadOperation() instanceof AddElements);
    Class<AddElements> expectedPayloadClass = AddElements.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, actualFederatedOperation.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>Then Operations first return {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test getFederatedOperation(Operation) with 'Operation'; then Operations first return AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Operation)"})
  void testGetFederatedOperationWithOperation_thenOperationsFirstReturnAddGraph() {
    // Arrange
    AddGraph operation = new AddGraph();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "");

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation(operation);

    // Assert
    Collection<Operation> operations = actualFederatedOperation.getOperations();
    assertEquals(1, operations.size());
    assertTrue(operations instanceof List);
    Operation getResult = ((List<Operation>) operations).get(0);
    assertTrue(getResult instanceof AddGraph);
    Operation payloadOperation = actualFederatedOperation.getPayloadOperation();
    assertTrue(payloadOperation instanceof AddGraph);
    Operation unClonedPayload = actualFederatedOperation.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof AddGraph);
    Map<String, String> options = actualFederatedOperation.getOptions();
    assertEquals(1, options.size());
    assertEquals("", options.get(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION));
    assertTrue(actualFederatedOperation.getGraphIds().isEmpty());
    assertEquals(options, getResult.getOptions());
    assertEquals(options, payloadOperation.getOptions());
    assertEquals(options, unClonedPayload.getOptions());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>Then return PayloadClass is {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test getFederatedOperation(Operation) with 'Operation'; then return PayloadClass is AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Operation)"})
  void testGetFederatedOperationWithOperation_thenReturnPayloadClassIsAddGraph() {
    // Arrange
    AddGraph operation = new AddGraph();

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation(operation);

    // Assert
    assertTrue(actualFederatedOperation.getPayloadOperation() instanceof AddGraph);
    Operation unClonedPayload = actualFederatedOperation.getUnClonedPayload();
    assertTrue(unClonedPayload instanceof AddGraph);
    Class<AddGraph> expectedPayloadClass = AddGraph.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, unClonedPayload);
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>Then return PayloadClass is {@link OperationChain}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test getFederatedOperation(Operation) with 'Operation'; then return PayloadClass is OperationChain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Operation)"})
  void testGetFederatedOperationWithOperation_thenReturnPayloadClassIsOperationChain() {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new FederatedOperation<>());
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "42");

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation((Operation) operation);

    // Assert
    Class<OperationChain> expectedPayloadClass = OperationChain.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, actualFederatedOperation.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>Then return PayloadOperation is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test getFederatedOperation(Operation) with 'Operation'; then return PayloadOperation is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Operation)"})
  void testGetFederatedOperationWithOperation_thenReturnPayloadOperationIsNull() {
    // Arrange
    GenericInputImpl operation = new GenericInputImpl();

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation((Operation) operation);

    // Assert
    Collection<Operation> operations = actualFederatedOperation.getOperations();
    assertTrue(operations instanceof List);
    assertNull(actualFederatedOperation.getPayloadOperation());
    assertTrue(operations.isEmpty());
    Class<GenericInputImpl> expectedPayloadClass = GenericInputImpl.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, actualFederatedOperation.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Operation)} with {@code Operation}.
   *
   * <ul>
   *   <li>When {@link FederatedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Operation)}
   */
  @Test
  @DisplayName(
      "Test getFederatedOperation(Operation) with 'Operation'; when FederatedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Operation)"})
  void testGetFederatedOperationWithOperation_whenFederatedOperation() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();

    // Act
    FederatedOperation<Object, Void> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation((Operation) operation);

    // Assert
    Class<FederatedOperation> expectedPayloadClass = FederatedOperation.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, actualFederatedOperation.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#getFederatedOperation(Output)} with {@code Output}.
   *
   * <ul>
   *   <li>Then PayloadOperation return {@link OperationChain}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getFederatedOperation(Output)}
   */
  @Test
  @DisplayName(
      "Test getFederatedOperation(Output) with 'Output'; then PayloadOperation return OperationChain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FederatedOperation FederatedStoreUtil.getFederatedOperation(Output)"})
  void testGetFederatedOperationWithOutput_thenPayloadOperationReturnOperationChain() {
    // Arrange
    OperationChain<Iterable<?>> operation = new OperationChain<>();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "42");

    // Act
    FederatedOperation<Void, Iterable<?>> actualFederatedOperation =
        FederatedStoreUtil.getFederatedOperation(operation);

    // Assert
    Collection<Operation> operations = actualFederatedOperation.getOperations();
    assertTrue(operations instanceof List);
    Operation payloadOperation = actualFederatedOperation.getPayloadOperation();
    assertTrue(payloadOperation instanceof OperationChain);
    assertTrue(operations.isEmpty());
    assertEquals(operation, payloadOperation);
    Class<OperationChain> expectedPayloadClass = OperationChain.class;
    assertEquals(expectedPayloadClass, actualFederatedOperation.getPayloadClass());
    assertSame(operation, actualFederatedOperation.getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#getDefaultMergeFunction()}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#getDefaultMergeFunction()}
   */
  @Test
  @DisplayName("Test getDefaultMergeFunction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BiFunction FederatedStoreUtil.getDefaultMergeFunction()"})
  void testGetDefaultMergeFunction() {
    // Arrange and Act
    BiFunction actualDefaultMergeFunction = FederatedStoreUtil.getDefaultMergeFunction();

    // Assert
    Iterable<Object> applyResult =
        ((ConcatenateMergeFunction) actualDefaultMergeFunction).apply("Update", null);
    assertTrue(applyResult instanceof List);
    assertTrue(actualDefaultMergeFunction instanceof ConcatenateMergeFunction);
    assertEquals(1, ((List<Object>) applyResult).size());
    assertEquals("Update", ((List<Object>) applyResult).get(0));
  }

  /**
   * Test {@link FederatedStoreUtil#getDefaultMergeFunction()}.
   *
   * <ul>
   *   <li>Then apply {@code 42} and {@link ArrayList#ArrayList()} return {@link ChainedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getDefaultMergeFunction()}
   */
  @Test
  @DisplayName(
      "Test getDefaultMergeFunction(); then apply '42' and ArrayList() return ChainedIterable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BiFunction FederatedStoreUtil.getDefaultMergeFunction()"})
  void testGetDefaultMergeFunction_thenApply42AndArrayListReturnChainedIterable() {
    // Arrange and Act
    BiFunction actualDefaultMergeFunction = FederatedStoreUtil.getDefaultMergeFunction();
    ArrayList<Object> objectList = new ArrayList<>();
    Object actualApplyResult = actualDefaultMergeFunction.apply("42", objectList);

    // Assert
    Iterable<Object> applyResult =
        ((ConcatenateMergeFunction) actualDefaultMergeFunction).apply("Update", null);
    assertTrue(applyResult instanceof List);
    assertTrue(actualDefaultMergeFunction instanceof ConcatenateMergeFunction);
    assertTrue(actualApplyResult instanceof ChainedIterable);
    Iterator<Object> iteratorResult = ((ChainedIterable<Object>) actualApplyResult).iterator();
    assertTrue(iteratorResult instanceof ChainedIterator);
    assertEquals("42", iteratorResult.next());
    assertEquals(1, ((List<Object>) applyResult).size());
    assertEquals("Update", ((List<Object>) applyResult).get(0));
    assertFalse(iteratorResult.hasNext());
    assertTrue(objectList.isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation, BuilderParent)}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation,
   * FederatedOperation.BuilderParent)}
   */
  @Test
  @DisplayName("Test addDeprecatedGraphIds(Operation, BuilderParent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedOperation.BuilderParent FederatedStoreUtil.addDeprecatedGraphIds(Operation, FederatedOperation.BuilderParent)"
  })
  void testAddDeprecatedGraphIds() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "42");

    BuilderParent<Object, Object> builder = mock(BuilderParent.class);
    when(builder.graphIdsCSV(Mockito.<String>any())).thenReturn(mock(BuilderParent.class));

    // Act
    FederatedStoreUtil.addDeprecatedGraphIds(operation, builder);

    // Assert
    verify(builder).graphIdsCSV("42");
  }

  /**
   * Test {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation, BuilderParent)}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation,
   * FederatedOperation.BuilderParent)}
   */
  @Test
  @DisplayName("Test addDeprecatedGraphIds(Operation, BuilderParent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedOperation.BuilderParent FederatedStoreUtil.addDeprecatedGraphIds(Operation, FederatedOperation.BuilderParent)"
  })
  void testAddDeprecatedGraphIds2() {
    // Arrange
    AddElements operation = new AddElements();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "42");

    BuilderParent<Object, Object> builder = mock(BuilderParent.class);
    when(builder.graphIdsCSV(Mockito.<String>any())).thenReturn(mock(BuilderParent.class));

    // Act
    FederatedStoreUtil.addDeprecatedGraphIds(operation, builder);

    // Assert
    verify(builder).graphIdsCSV("42");
  }

  /**
   * Test {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation, BuilderParent)}.
   *
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation,
   * FederatedOperation.BuilderParent)}
   */
  @Test
  @DisplayName(
      "Test addDeprecatedGraphIds(Operation, BuilderParent); then throw GafferRuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedOperation.BuilderParent FederatedStoreUtil.addDeprecatedGraphIds(Operation, FederatedOperation.BuilderParent)"
  })
  void testAddDeprecatedGraphIds_thenThrowGafferRuntimeException() {
    // Arrange
    AddGraph operation = new AddGraph();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "42");

    BuilderParent<Object, Object> builder = mock(BuilderParent.class);
    when(builder.graphIdsCSV(Mockito.<String>any()))
        .thenThrow(new GafferRuntimeException("An error occurred"));

    // Act and Assert
    assertThrows(
        GafferRuntimeException.class,
        () -> FederatedStoreUtil.addDeprecatedGraphIds(operation, builder));
    verify(builder).graphIdsCSV("42");
  }

  /**
   * Test {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation, BuilderParent)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor) addOption {@link
   *       FederatedStoreUtil#DEPRECATED_GRAPHIDS_OPTION} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation,
   * FederatedOperation.BuilderParent)}
   */
  @Test
  @DisplayName(
      "Test addDeprecatedGraphIds(Operation, BuilderParent); when AddGraph (default constructor) addOption DEPRECATED_GRAPHIDS_OPTION and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedOperation.BuilderParent FederatedStoreUtil.addDeprecatedGraphIds(Operation, FederatedOperation.BuilderParent)"
  })
  void testAddDeprecatedGraphIds_whenAddGraphAddOptionDeprecated_graphids_optionAnd42() {
    // Arrange
    AddGraph operation = new AddGraph();
    operation.addOption(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "42");

    BuilderParent<Object, Object> builder = mock(BuilderParent.class);
    when(builder.graphIdsCSV(Mockito.<String>any())).thenReturn(mock(BuilderParent.class));

    // Act
    FederatedStoreUtil.addDeprecatedGraphIds(operation, builder);

    // Assert
    verify(builder).graphIdsCSV("42");
  }

  /**
   * Test {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation, BuilderParent)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation,
   * FederatedOperation.BuilderParent)}
   */
  @Test
  @DisplayName(
      "Test addDeprecatedGraphIds(Operation, BuilderParent); when AddGraph (default constructor); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedOperation.BuilderParent FederatedStoreUtil.addDeprecatedGraphIds(Operation, FederatedOperation.BuilderParent)"
  })
  void testAddDeprecatedGraphIds_whenAddGraph_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> FederatedStoreUtil.addDeprecatedGraphIds(new AddGraph(), mock(BuilderParent.class)));
  }

  /**
   * Test {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation, BuilderParent)}.
   *
   * <ul>
   *   <li>When {@link GenericInputImpl#GenericInputImpl()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation,
   * FederatedOperation.BuilderParent)}
   */
  @Test
  @DisplayName(
      "Test addDeprecatedGraphIds(Operation, BuilderParent); when GenericInputImpl(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedOperation.BuilderParent FederatedStoreUtil.addDeprecatedGraphIds(Operation, FederatedOperation.BuilderParent)"
  })
  void testAddDeprecatedGraphIds_whenGenericInputImpl_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            FederatedStoreUtil.addDeprecatedGraphIds(
                new GenericInputImpl(), mock(BuilderParent.class)));
  }

  /**
   * Test {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation, BuilderParent)}.
   *
   * <ul>
   *   <li>When wrap {@link FederatedOperation} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#addDeprecatedGraphIds(Operation,
   * FederatedOperation.BuilderParent)}
   */
  @Test
  @DisplayName(
      "Test addDeprecatedGraphIds(Operation, BuilderParent); when wrap FederatedOperation (default constructor); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FederatedOperation.BuilderParent FederatedStoreUtil.addDeprecatedGraphIds(Operation, FederatedOperation.BuilderParent)"
  })
  void testAddDeprecatedGraphIds_whenWrapFederatedOperation_thenDoesNotThrow() {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new FederatedOperation<>());

    // Act
    assertDoesNotThrow(
        () -> FederatedStoreUtil.addDeprecatedGraphIds(operation, mock(BuilderParent.class)));
  }

  /**
   * Test {@link FederatedStoreUtil#getDeprecatedGraphIds(Operation)}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#getDeprecatedGraphIds(Operation)}
   */
  @Test
  @DisplayName("Test getDeprecatedGraphIds(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FederatedStoreUtil.getDeprecatedGraphIds(Operation)"})
  void testGetDeprecatedGraphIds() throws GafferRuntimeException {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    operation.addOption("uk.gov.gchq.gaffer.federatedstore.operation.FederatedOperation", "Value");

    // Act and Assert
    assertNull(FederatedStoreUtil.getDeprecatedGraphIds(operation));
  }

  /**
   * Test {@link FederatedStoreUtil#getDeprecatedGraphIds(Operation)}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#getDeprecatedGraphIds(Operation)}
   */
  @Test
  @DisplayName("Test getDeprecatedGraphIds(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FederatedStoreUtil.getDeprecatedGraphIds(Operation)"})
  void testGetDeprecatedGraphIds2() throws GafferRuntimeException {
    // Arrange
    AddElements operation = new AddElements();
    operation.addOption("uk.gov.gchq.gaffer.federatedstore.operation.FederatedOperation", "Value");

    // Act and Assert
    assertNull(FederatedStoreUtil.getDeprecatedGraphIds(operation));
  }

  /**
   * Test {@link FederatedStoreUtil#getDeprecatedGraphIds(Operation)}.
   *
   * <ul>
   *   <li>Then return {@code Operation}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getDeprecatedGraphIds(Operation)}
   */
  @Test
  @DisplayName("Test getDeprecatedGraphIds(Operation); then return 'Operation'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FederatedStoreUtil.getDeprecatedGraphIds(Operation)"})
  void testGetDeprecatedGraphIds_thenReturnOperation() throws GafferRuntimeException {
    // Arrange
    HashMap<String, String> options = new HashMap<>();
    options.put(FederatedStoreUtil.DEPRECATED_GRAPHIDS_OPTION, "Operation");

    ImportAccumuloKeyValueFiles operation = new ImportAccumuloKeyValueFiles();
    operation.setOptions(options);

    // Act and Assert
    assertEquals("Operation", FederatedStoreUtil.getDeprecatedGraphIds(operation));
  }

  /**
   * Test {@link FederatedStoreUtil#getDeprecatedGraphIds(Operation)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getDeprecatedGraphIds(Operation)}
   */
  @Test
  @DisplayName(
      "Test getDeprecatedGraphIds(Operation); when AddGraph (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FederatedStoreUtil.getDeprecatedGraphIds(Operation)"})
  void testGetDeprecatedGraphIds_whenAddGraph_thenReturnNull() throws GafferRuntimeException {
    // Arrange, Act and Assert
    assertNull(FederatedStoreUtil.getDeprecatedGraphIds(new AddGraph()));
  }

  /**
   * Test {@link FederatedStoreUtil#getDeprecatedGraphIds(Operation)}.
   *
   * <ul>
   *   <li>When {@link FederatedOperation} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getDeprecatedGraphIds(Operation)}
   */
  @Test
  @DisplayName(
      "Test getDeprecatedGraphIds(Operation); when FederatedOperation (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FederatedStoreUtil.getDeprecatedGraphIds(Operation)"})
  void testGetDeprecatedGraphIds_whenFederatedOperation_thenReturnNull()
      throws GafferRuntimeException {
    // Arrange, Act and Assert
    assertNull(FederatedStoreUtil.getDeprecatedGraphIds(new FederatedOperation<>()));
  }

  /**
   * Test {@link FederatedStoreUtil#getDeprecatedGraphIds(Operation)}.
   *
   * <ul>
   *   <li>When wrap {@link FederatedOperation} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getDeprecatedGraphIds(Operation)}
   */
  @Test
  @DisplayName(
      "Test getDeprecatedGraphIds(Operation); when wrap FederatedOperation (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FederatedStoreUtil.getDeprecatedGraphIds(Operation)"})
  void testGetDeprecatedGraphIds_whenWrapFederatedOperation_thenReturnNull()
      throws GafferRuntimeException {
    // Arrange
    OperationChain<Object> operation = OperationChain.wrap(new FederatedOperation<>());

    // Act and Assert
    assertNull(FederatedStoreUtil.getDeprecatedGraphIds(operation));
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName("Test shallowCloneWithDeepOptions(Operation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions() {
    // Arrange
    OperationChainDAO<Object> op = new OperationChainDAO<>((Operation) new OperationChain<>());
    op.addOption("Name", "42");

    // Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(op);

    // Assert
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof OperationChain);
    assertEquals(op, actualShallowCloneWithDeepOptionsResult);
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor).
   *   <li>Then PayloadOperation return {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName(
      "Test shallowCloneWithDeepOptions(Operation); given AddGraph (default constructor); then PayloadOperation return AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions_givenAddGraph_thenPayloadOperationReturnAddGraph() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    AddGraph op2 = new AddGraph();
    op.payloadOperation(op2);

    // Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(op);

    // Assert
    Collection<Operation> operations =
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getOperations();
    assertEquals(1, operations.size());
    assertTrue(operations instanceof List);
    assertTrue(
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
                .getPayloadOperation()
            instanceof AddGraph);
    Operation unClonedPayload =
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getUnClonedPayload();
    assertTrue(unClonedPayload instanceof AddGraph);
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof FederatedOperation);
    Class<AddGraph> expectedPayloadClass = AddGraph.class;
    assertEquals(
        expectedPayloadClass,
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getPayloadClass());
    assertSame(op2, unClonedPayload);
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor).
   *   <li>Then return wrap {@link FederatedOperation} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName(
      "Test shallowCloneWithDeepOptions(Operation); given AddGraph (default constructor); then return wrap FederatedOperation (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions_givenAddGraph_thenReturnWrapFederatedOperation() {
    // Arrange
    FederatedOperation<Object, Object> operation = new FederatedOperation<>();
    operation.payloadOperation(new AddGraph());

    OperationChain<Object> op = OperationChain.wrap(operation);
    op.addOption("Name", "42");

    // Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(op);

    // Assert
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof OperationChain);
    assertEquals(op, actualShallowCloneWithDeepOptionsResult);
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return GraphIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName(
      "Test shallowCloneWithDeepOptions(Operation); given ArrayList(); then return GraphIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions_givenArrayList_thenReturnGraphIdsEmpty() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    op.graphIds(new ArrayList<>());
    GenericInputImpl op2 = new GenericInputImpl();
    op.payloadOperation(op2);

    // Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(op);

    // Assert
    Collection<Operation> operations =
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getOperations();
    assertTrue(operations instanceof List);
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof FederatedOperation);
    assertNull(
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getPayloadOperation());
    assertTrue(operations.isEmpty());
    assertTrue(
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getGraphIds()
            .isEmpty());
    Class<GenericInputImpl> expectedPayloadClass = GenericInputImpl.class;
    assertEquals(
        expectedPayloadClass,
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getPayloadClass());
    assertSame(
        op2,
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName(
      "Test shallowCloneWithDeepOptions(Operation); given HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions_givenHashMap_thenReturnOptionsEmpty() {
    // Arrange
    AddGraph op = new AddGraph();
    op.setOptions(new HashMap<>());

    // Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(op);

    // Assert
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof AddGraph);
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getGraphId());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getParentPropertiesId());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getParentSchemaIds());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getProperties());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getGraphAuths());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getReadAccessPredicate());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getWriteAccessPredicate());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getStoreProperties());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getSchema());
    assertFalse(((AddGraph) actualShallowCloneWithDeepOptionsResult).getIsPublic());
    assertFalse(((AddGraph) actualShallowCloneWithDeepOptionsResult).isUserRequestingAdminUsage());
    assertTrue(actualShallowCloneWithDeepOptionsResult.getOptions().isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <ul>
   *   <li>Then Operations first return {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName("Test shallowCloneWithDeepOptions(Operation); then Operations first return AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions_thenOperationsFirstReturnAddGraph() {
    // Arrange
    OperationChainDAO<Object> op = new OperationChainDAO<>(new AddGraph());
    op.addOption("Name", "42");

    // Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(op);

    // Assert
    List<Operation> operations =
        ((OperationChain<Object>) actualShallowCloneWithDeepOptionsResult).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof AddGraph);
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof OperationChain);
    assertNull(((AddGraph) getResult).getGraphId());
    assertNull(((AddGraph) getResult).getParentPropertiesId());
    assertNull(((AddGraph) getResult).getParentSchemaIds());
    assertNull(getResult.getOptions());
    assertNull(((AddGraph) getResult).getProperties());
    assertNull(((AddGraph) getResult).getGraphAuths());
    assertNull(((AddGraph) getResult).getReadAccessPredicate());
    assertNull(((AddGraph) getResult).getWriteAccessPredicate());
    assertNull(((AddGraph) getResult).getStoreProperties());
    assertNull(((AddGraph) getResult).getSchema());
    assertFalse(((AddGraph) getResult).getIsPublic());
    assertFalse(((AddGraph) getResult).isUserRequestingAdminUsage());
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <ul>
   *   <li>Then Operations first return {@link NamedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName(
      "Test shallowCloneWithDeepOptions(Operation); then Operations first return NamedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions_thenOperationsFirstReturnNamedOperation() {
    // Arrange
    OperationChain<Object> op = OperationChain.wrap(new NamedOperation<>());
    op.addOption("Name", "42");

    // Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(op);

    // Assert
    List<Operation> operations =
        ((OperationChain<Object>) actualShallowCloneWithDeepOptionsResult).getOperations();
    assertEquals(1, operations.size());
    Operation getResult = operations.get(0);
    assertTrue(getResult instanceof NamedOperation);
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof OperationChain);
    assertTrue(
        ((NamedOperation<Object, Object>) getResult).getOutputTypeReference()
            instanceof TypeReferenceImpl.Object);
    assertNull(((NamedOperation<Object, Object>) getResult).getInput());
    assertNull(((NamedOperation<Object, Object>) getResult).getOperationName());
    assertNull(((NamedOperation<Object, Object>) getResult).getParameters());
    assertNull(getResult.getOptions());
    assertTrue(((NamedOperation<Object, Object>) getResult).getOperations().isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <ul>
   *   <li>Then return {@link OperationChain#OperationChain()}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName("Test shallowCloneWithDeepOptions(Operation); then return OperationChain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions_thenReturnOperationChain() {
    // Arrange
    OperationChain<Object> op = new OperationChain<>();
    op.addOption("Name", "42");

    // Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(op);

    // Assert
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof OperationChain);
    assertEquals(op, actualShallowCloneWithDeepOptionsResult);
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <ul>
   *   <li>Then return {@link OperationImpl}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName("Test shallowCloneWithDeepOptions(Operation); then return OperationImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions_thenReturnOperationImpl() {
    // Arrange
    OperationImpl op = new OperationImpl();
    op.addOption("Name", "42");

    // Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(op);

    // Assert
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof OperationImpl);
    Map<String, String> options = actualShallowCloneWithDeepOptionsResult.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get("Name"));
    assertNull(((OperationImpl) actualShallowCloneWithDeepOptionsResult).getRequiredField1());
    assertNull(((OperationImpl) actualShallowCloneWithDeepOptionsResult).getOptionalField1());
    assertNull(((OperationImpl) actualShallowCloneWithDeepOptionsResult).getOptionalField2());
    assertNull(((OperationImpl) actualShallowCloneWithDeepOptionsResult).getRequiredField2());
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <ul>
   *   <li>Then return PayloadClass is {@link FederatedOperation}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName(
      "Test shallowCloneWithDeepOptions(Operation); then return PayloadClass is FederatedOperation")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions_thenReturnPayloadClassIsFederatedOperation() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    FederatedOperation<Object, Object> op2 = new FederatedOperation<>();
    op.payloadOperation(op2);

    // Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(op);

    // Assert
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof FederatedOperation);
    Class<FederatedOperation> expectedPayloadClass = FederatedOperation.class;
    assertEquals(
        expectedPayloadClass,
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getPayloadClass());
    assertSame(
        op2,
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <ul>
   *   <li>Then return PayloadClass is {@link OperationChain}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName(
      "Test shallowCloneWithDeepOptions(Operation); then return PayloadClass is OperationChain")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions_thenReturnPayloadClassIsOperationChain() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    OperationChain<Object> op2 = OperationChain.wrap(new FederatedOperation<>());
    op.payloadOperation(op2);

    // Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(op);

    // Assert
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof FederatedOperation);
    Class<OperationChain> expectedPayloadClass = OperationChain.class;
    assertEquals(
        expectedPayloadClass,
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getPayloadClass());
    assertSame(
        op2,
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <ul>
   *   <li>Then return PayloadOperation is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName(
      "Test shallowCloneWithDeepOptions(Operation); then return PayloadOperation is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions_thenReturnPayloadOperationIsNull() {
    // Arrange
    FederatedOperation<Object, Object> op = new FederatedOperation<>();
    GenericInputImpl op2 = new GenericInputImpl();
    op.payloadOperation(op2);

    // Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(op);

    // Assert
    Collection<Operation> operations =
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getOperations();
    assertTrue(operations instanceof List);
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof FederatedOperation);
    assertNull(
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getPayloadOperation());
    assertTrue(operations.isEmpty());
    Class<GenericInputImpl> expectedPayloadClass = GenericInputImpl.class;
    assertEquals(
        expectedPayloadClass,
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getPayloadClass());
    assertSame(
        op2,
        ((FederatedOperation<Object, Object>) actualShallowCloneWithDeepOptionsResult)
            .getUnClonedPayload());
  }

  /**
   * Test {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}.
   *
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#shallowCloneWithDeepOptions(Operation)}
   */
  @Test
  @DisplayName(
      "Test shallowCloneWithDeepOptions(Operation); when AddGraph (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedStoreUtil.shallowCloneWithDeepOptions(Operation)"})
  void testShallowCloneWithDeepOptions_whenAddGraph_thenReturnOptionsIsNull() {
    // Arrange and Act
    Operation actualShallowCloneWithDeepOptionsResult =
        FederatedStoreUtil.shallowCloneWithDeepOptions(new AddGraph());

    // Assert
    assertTrue(actualShallowCloneWithDeepOptionsResult instanceof AddGraph);
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getGraphId());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getParentPropertiesId());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getParentSchemaIds());
    assertNull(actualShallowCloneWithDeepOptionsResult.getOptions());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getProperties());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getGraphAuths());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getReadAccessPredicate());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getWriteAccessPredicate());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getStoreProperties());
    assertNull(((AddGraph) actualShallowCloneWithDeepOptionsResult).getSchema());
    assertFalse(((AddGraph) actualShallowCloneWithDeepOptionsResult).getIsPublic());
    assertFalse(((AddGraph) actualShallowCloneWithDeepOptionsResult).isUserRequestingAdminUsage());
  }

  /**
   * Test {@link FederatedStoreUtil#processIfFunctionIsContextSpecific(BiFunction, Operation,
   * Context, List, FederatedStore)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#processIfFunctionIsContextSpecific(BiFunction,
   * Operation, Context, List, FederatedStore)}
   */
  @Test
  @DisplayName(
      "Test processIfFunctionIsContextSpecific(BiFunction, Operation, Context, List, FederatedStore); given '42'; then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BiFunction FederatedStoreUtil.processIfFunctionIsContextSpecific(BiFunction, Operation, Context, List, FederatedStore)"
  })
  void testProcessIfFunctionIsContextSpecific_given42_thenArrayListSizeIsTwo() {
    // Arrange
    BiFunction mergeFunction = mock(BiFunction.class);
    when(mergeFunction.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Apply");
    AddGraph payload = new AddGraph();
    Context operationContext = FederatedStoreTestUtil.contextAuthUser();

    ArrayList<String> graphIds = new ArrayList<>();
    graphIds.add("42");
    graphIds.add("foo");
    FederatedStore federatedStore = new FederatedStore();

    // Act
    BiFunction actualProcessIfFunctionIsContextSpecificResult =
        FederatedStoreUtil.processIfFunctionIsContextSpecific(
            mergeFunction, payload, operationContext, graphIds, federatedStore);
    Object actualApplyResult = actualProcessIfFunctionIsContextSpecificResult.apply("42", "42");

    // Assert
    verify(mergeFunction).apply(isA(Object.class), isA(Object.class));
    assertTrue(
        federatedStore.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    assertEquals(2, graphIds.size());
    assertEquals("42", graphIds.get(0));
    assertEquals("Apply", actualApplyResult);
    assertEquals("foo", graphIds.get(1));
    assertNull(payload.getGraphId());
    assertNull(payload.getParentPropertiesId());
    assertNull(federatedStore.getGraphId());
    assertNull(federatedStore.getStoreConfiguredGraphIds());
    assertNull(payload.getParentSchemaIds());
    assertNull(payload.getOptions());
    assertNull(payload.getProperties());
    assertNull(payload.getGraphAuths());
    assertNull(payload.getReadAccessPredicate());
    assertNull(payload.getWriteAccessPredicate());
    assertNull(federatedStore.getProperties());
    assertNull(federatedStore.getJobTracker());
    assertNull(operationContext.getOriginalOpChain());
    assertNull(payload.getStoreProperties());
    assertNull(federatedStore.getGraphLibrary());
    assertNull(payload.getSchema());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        federatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertFalse(payload.getIsPublic());
    assertFalse(payload.isUserRequestingAdminUsage());
    assertTrue(operationContext.getExporters().isEmpty());
    assertTrue(federatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(operationContext.getVariables().isEmpty());
    assertTrue(federatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(federatedStore.getSupportedOperations().isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#processIfFunctionIsContextSpecific(BiFunction, Operation,
   * Context, List, FederatedStore)}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#processIfFunctionIsContextSpecific(BiFunction,
   * Operation, Context, List, FederatedStore)}
   */
  @Test
  @DisplayName(
      "Test processIfFunctionIsContextSpecific(BiFunction, Operation, Context, List, FederatedStore); given 'Apply'; then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BiFunction FederatedStoreUtil.processIfFunctionIsContextSpecific(BiFunction, Operation, Context, List, FederatedStore)"
  })
  void testProcessIfFunctionIsContextSpecific_givenApply_thenArrayListSizeIsOne() {
    // Arrange
    BiFunction mergeFunction = mock(BiFunction.class);
    when(mergeFunction.apply(Mockito.<Object>any(), Mockito.<Object>any())).thenReturn("Apply");
    AddGraph payload = new AddGraph();
    Context operationContext = FederatedStoreTestUtil.contextAuthUser();

    ArrayList<String> graphIds = new ArrayList<>();
    graphIds.add("foo");
    FederatedStore federatedStore = new FederatedStore();

    // Act
    BiFunction actualProcessIfFunctionIsContextSpecificResult =
        FederatedStoreUtil.processIfFunctionIsContextSpecific(
            mergeFunction, payload, operationContext, graphIds, federatedStore);
    Object actualApplyResult = actualProcessIfFunctionIsContextSpecificResult.apply("42", "42");

    // Assert
    verify(mergeFunction).apply(isA(Object.class), isA(Object.class));
    assertTrue(
        federatedStore.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    assertEquals(1, graphIds.size());
    assertEquals("Apply", actualApplyResult);
    assertEquals("foo", graphIds.get(0));
    assertNull(payload.getGraphId());
    assertNull(payload.getParentPropertiesId());
    assertNull(federatedStore.getGraphId());
    assertNull(federatedStore.getStoreConfiguredGraphIds());
    assertNull(payload.getParentSchemaIds());
    assertNull(payload.getOptions());
    assertNull(payload.getProperties());
    assertNull(payload.getGraphAuths());
    assertNull(payload.getReadAccessPredicate());
    assertNull(payload.getWriteAccessPredicate());
    assertNull(federatedStore.getProperties());
    assertNull(federatedStore.getJobTracker());
    assertNull(operationContext.getOriginalOpChain());
    assertNull(payload.getStoreProperties());
    assertNull(federatedStore.getGraphLibrary());
    assertNull(payload.getSchema());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        federatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertFalse(payload.getIsPublic());
    assertFalse(payload.isUserRequestingAdminUsage());
    assertTrue(operationContext.getExporters().isEmpty());
    assertTrue(federatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(operationContext.getVariables().isEmpty());
    assertTrue(federatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(federatedStore.getSupportedOperations().isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#processIfFunctionIsContextSpecific(BiFunction, Operation,
   * Context, List, FederatedStore)}.
   *
   * <ul>
   *   <li>When {@link BiFunction}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#processIfFunctionIsContextSpecific(BiFunction,
   * Operation, Context, List, FederatedStore)}
   */
  @Test
  @DisplayName(
      "Test processIfFunctionIsContextSpecific(BiFunction, Operation, Context, List, FederatedStore); when BiFunction; then ArrayList() Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BiFunction FederatedStoreUtil.processIfFunctionIsContextSpecific(BiFunction, Operation, Context, List, FederatedStore)"
  })
  void testProcessIfFunctionIsContextSpecific_whenBiFunction_thenArrayListEmpty() {
    // Arrange
    BiFunction mergeFunction = mock(BiFunction.class);
    AddGraph payload = new AddGraph();
    Context operationContext = FederatedStoreTestUtil.contextAuthUser();
    ArrayList<String> graphIds = new ArrayList<>();
    FederatedStore federatedStore = new FederatedStore();

    // Act
    FederatedStoreUtil.processIfFunctionIsContextSpecific(
        mergeFunction, payload, operationContext, graphIds, federatedStore);

    // Assert that nothing has changed
    assertTrue(
        federatedStore.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        federatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertFalse(payload.getIsPublic());
    assertFalse(payload.isUserRequestingAdminUsage());
    assertTrue(graphIds.isEmpty());
    assertTrue(operationContext.getExporters().isEmpty());
    assertTrue(federatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(operationContext.getVariables().isEmpty());
    assertTrue(federatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(federatedStore.getSupportedOperations().isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#processIfFunctionIsContextSpecific(BiFunction, Operation,
   * Context, List, FederatedStore)}.
   *
   * <ul>
   *   <li>When {@link MergeSchema#MergeSchema()}.
   *   <li>Then return {@link MergeSchema}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#processIfFunctionIsContextSpecific(BiFunction,
   * Operation, Context, List, FederatedStore)}
   */
  @Test
  @DisplayName(
      "Test processIfFunctionIsContextSpecific(BiFunction, Operation, Context, List, FederatedStore); when MergeSchema(); then return MergeSchema")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BiFunction FederatedStoreUtil.processIfFunctionIsContextSpecific(BiFunction, Operation, Context, List, FederatedStore)"
  })
  void testProcessIfFunctionIsContextSpecific_whenMergeSchema_thenReturnMergeSchema() {
    // Arrange
    MergeSchema mergeFunction = new MergeSchema();
    AddGraph payload = new AddGraph();
    Context operationContext = FederatedStoreTestUtil.contextAuthUser();
    ArrayList<String> graphIds = new ArrayList<>();
    FederatedStore federatedStore = new FederatedStore();

    // Act
    BiFunction actualProcessIfFunctionIsContextSpecificResult =
        FederatedStoreUtil.processIfFunctionIsContextSpecific(
            mergeFunction, payload, operationContext, graphIds, federatedStore);

    // Assert
    assertTrue(
        federatedStore.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    assertTrue(actualProcessIfFunctionIsContextSpecificResult instanceof MergeSchema);
    assertNull(payload.getGraphId());
    assertNull(payload.getParentPropertiesId());
    assertNull(federatedStore.getGraphId());
    assertNull(federatedStore.getStoreConfiguredGraphIds());
    assertNull(payload.getParentSchemaIds());
    assertNull(payload.getOptions());
    assertNull(payload.getProperties());
    assertNull(payload.getGraphAuths());
    assertNull(payload.getReadAccessPredicate());
    assertNull(payload.getWriteAccessPredicate());
    assertNull(federatedStore.getProperties());
    assertNull(federatedStore.getJobTracker());
    assertNull(operationContext.getOriginalOpChain());
    assertNull(payload.getStoreProperties());
    assertNull(federatedStore.getGraphLibrary());
    assertNull(payload.getSchema());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        federatedStore.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertFalse(payload.getIsPublic());
    assertFalse(payload.isUserRequestingAdminUsage());
    assertTrue(graphIds.isEmpty());
    assertTrue(operationContext.getExporters().isEmpty());
    assertTrue(federatedStore.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(operationContext.getVariables().isEmpty());
    assertTrue(federatedStore.getExternallySupportedOperations().isEmpty());
    assertTrue(
        ((MergeSchema) actualProcessIfFunctionIsContextSpecificResult)
            .getRequiredContextValues()
            .isEmpty());
    assertTrue(federatedStore.getSupportedOperations().isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#getStoreConfiguredMergeFunction(Operation, Context, List,
   * FederatedStore)}.
   *
   * <ul>
   *   <li>Then apply {@code Update} and {@code null} return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getStoreConfiguredMergeFunction(Operation,
   * Context, List, FederatedStore)}
   */
  @Test
  @DisplayName(
      "Test getStoreConfiguredMergeFunction(Operation, Context, List, FederatedStore); then apply 'Update' and 'null' return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BiFunction FederatedStoreUtil.getStoreConfiguredMergeFunction(Operation, Context, List, FederatedStore)"
  })
  void testGetStoreConfiguredMergeFunction_thenApplyUpdateAndNullReturnList()
      throws GafferCheckedException {
    // Arrange
    AddGraph payload = new AddGraph();
    Context context = FederatedStoreTestUtil.contextAuthUser();
    ArrayList<Object> graphIds = new ArrayList<>();
    FederatedStore store = new FederatedStore();

    // Act
    BiFunction actualStoreConfiguredMergeFunction =
        FederatedStoreUtil.getStoreConfiguredMergeFunction(payload, context, graphIds, store);

    // Assert
    Iterable<Object> applyResult =
        ((ConcatenateMergeFunction) actualStoreConfiguredMergeFunction).apply("Update", null);
    assertTrue(applyResult instanceof List);
    assertTrue(store.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    assertTrue(actualStoreConfiguredMergeFunction instanceof ConcatenateMergeFunction);
    assertNull(payload.getGraphId());
    assertNull(payload.getParentPropertiesId());
    assertNull(store.getGraphId());
    assertNull(store.getStoreConfiguredGraphIds());
    assertNull(payload.getParentSchemaIds());
    assertNull(payload.getOptions());
    assertNull(payload.getProperties());
    assertNull(payload.getGraphAuths());
    assertNull(payload.getReadAccessPredicate());
    assertNull(payload.getWriteAccessPredicate());
    assertNull(store.getProperties());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(payload.getStoreProperties());
    assertNull(store.getGraphLibrary());
    assertNull(payload.getSchema());
    assertEquals(1, ((List<Object>) applyResult).size());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        store.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertFalse(payload.getIsPublic());
    assertFalse(payload.isUserRequestingAdminUsage());
    assertTrue(graphIds.isEmpty());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(context.getVariables().isEmpty());
    assertTrue(store.getExternallySupportedOperations().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
  }

  /**
   * Test {@link FederatedStoreUtil#getStoreConfiguredMergeFunction(Operation, Context, List,
   * FederatedStore)}.
   *
   * <ul>
   *   <li>When {@link GetSchema} (default constructor).
   *   <li>Then return {@link MergeSchema}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#getStoreConfiguredMergeFunction(Operation,
   * Context, List, FederatedStore)}
   */
  @Test
  @DisplayName(
      "Test getStoreConfiguredMergeFunction(Operation, Context, List, FederatedStore); when GetSchema (default constructor); then return MergeSchema")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BiFunction FederatedStoreUtil.getStoreConfiguredMergeFunction(Operation, Context, List, FederatedStore)"
  })
  void testGetStoreConfiguredMergeFunction_whenGetSchema_thenReturnMergeSchema()
      throws GafferCheckedException {
    // Arrange
    GetSchema payload = new GetSchema();
    Context context = FederatedStoreTestUtil.contextAuthUser();
    ArrayList<Object> graphIds = new ArrayList<>();
    FederatedStore store = new FederatedStore();

    // Act
    BiFunction actualStoreConfiguredMergeFunction =
        FederatedStoreUtil.getStoreConfiguredMergeFunction(payload, context, graphIds, store);

    // Assert
    assertTrue(store.getOperationChainValidator() instanceof FederatedOperationChainValidator);
    assertTrue(actualStoreConfiguredMergeFunction instanceof MergeSchema);
    assertTrue(payload.getOutputTypeReference() instanceof TypeReferenceStoreImpl.Schema);
    assertNull(store.getGraphId());
    assertNull(store.getStoreConfiguredGraphIds());
    assertNull(payload.getOptions());
    assertNull(store.getProperties());
    assertNull(store.getJobTracker());
    assertNull(context.getOriginalOpChain());
    assertNull(store.getGraphLibrary());
    Map<String, BiFunction> storeConfiguredMergeFunctions =
        store.getStoreConfiguredMergeFunctions();
    assertEquals(4, storeConfiguredMergeFunctions.size());
    assertFalse(payload.isCompact());
    assertTrue(graphIds.isEmpty());
    assertTrue(context.getExporters().isEmpty());
    assertTrue(store.getOperationChainOptimisers().isEmpty());
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetAllElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey(
            "uk.gov.gchq.gaffer.operation.impl.get.GetElements"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetSchema"));
    assertTrue(
        storeConfiguredMergeFunctions.containsKey("uk.gov.gchq.gaffer.store.operation.GetTraits"));
    assertTrue(context.getVariables().isEmpty());
    assertTrue(store.getExternallySupportedOperations().isEmpty());
    assertTrue(
        ((MergeSchema) actualStoreConfiguredMergeFunction).getRequiredContextValues().isEmpty());
    assertTrue(store.getSupportedOperations().isEmpty());
    Class<Schema> expectedOutputClass = Schema.class;
    assertEquals(expectedOutputClass, payload.getOutputClass());
  }

  /**
   * Test {@link FederatedStoreUtil#loadStoreConfiguredGraphIdsListFrom(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedStoreUtil#loadStoreConfiguredGraphIdsListFrom(String)}
   */
  @Test
  @DisplayName("Test loadStoreConfiguredGraphIdsListFrom(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FederatedStoreUtil.loadStoreConfiguredGraphIdsListFrom(String)"})
  void testLoadStoreConfiguredGraphIdsListFrom_whenNull_thenReturnNull() throws IOException {
    // Arrange and Act
    List<String> actualLoadStoreConfiguredGraphIdsListFromResult =
        FederatedStoreUtil.loadStoreConfiguredGraphIdsListFrom(null);

    // Assert
    assertNull(actualLoadStoreConfiguredGraphIdsListFromResult);
  }

  /**
   * Test {@link FederatedStoreUtil#loadStoreConfiguredMergeFunctionMapFrom(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedStoreUtil#loadStoreConfiguredMergeFunctionMapFrom(String)}
   */
  @Test
  @DisplayName(
      "Test loadStoreConfiguredMergeFunctionMapFrom(String); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map FederatedStoreUtil.loadStoreConfiguredMergeFunctionMapFrom(String)"})
  void testLoadStoreConfiguredMergeFunctionMapFrom_whenNull_thenReturnEmpty() throws IOException {
    // Arrange and Act
    Map<String, BiFunction> actualLoadStoreConfiguredMergeFunctionMapFromResult =
        FederatedStoreUtil.loadStoreConfiguredMergeFunctionMapFrom(null);

    // Assert
    assertTrue(actualLoadStoreConfiguredMergeFunctionMapFromResult.isEmpty());
  }
}
