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

package uk.gov.gchq.gaffer.federated.simple.operation.handler;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.operation.impl.GetElementsBetweenSets;
import uk.gov.gchq.gaffer.federated.simple.FederatedStore;
import uk.gov.gchq.gaffer.federated.simple.operation.AddGraph;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Context.Builder;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;

class FederatedOperationHandlerDiffblueTest {
  /**
   * Test {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link GetElementsBetweenSets} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Operation, Context, Store); given HashMap(); when GetElementsBetweenSets (default constructor) Options is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object FederatedOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_givenHashMap_whenGetElementsBetweenSetsOptionsIsHashMap() throws OperationException {
    // Arrange
    FederatedOperationHandler<Operation> federatedOperationHandler = new FederatedOperationHandler<>();

    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();
    getElementsBetweenSets.setView(null);
    getElementsBetweenSets.setOptions(new HashMap<>());
    Context context = new Context();

    // Act and Assert
    assertNull(federatedOperationHandler.doOperation(getElementsBetweenSets, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link GetElementsBetweenSets} (default constructor) Options is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Operation, Context, Store); given 'null'; when GetElementsBetweenSets (default constructor) Options is 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object FederatedOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_givenNull_whenGetElementsBetweenSetsOptionsIsNull_thenReturnNull() throws OperationException {
    // Arrange
    FederatedOperationHandler<Operation> federatedOperationHandler = new FederatedOperationHandler<>();

    GetElementsBetweenSets getElementsBetweenSets = new GetElementsBetweenSets();
    getElementsBetweenSets.setView(null);
    getElementsBetweenSets.setOptions(null);
    Context context = new Context();

    // Act and Assert
    assertNull(federatedOperationHandler.doOperation(getElementsBetweenSets, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}.
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Operation, Context, Store); when AddGraph (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object FederatedOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_whenAddGraph_thenReturnNull() throws OperationException {
    // Arrange
    FederatedOperationHandler<Operation> federatedOperationHandler = new FederatedOperationHandler<>();
    AddGraph addGraph = new AddGraph();
    Context context = new Context();

    // Act and Assert
    assertNull(federatedOperationHandler.doOperation(addGraph, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationHandler#doOperation(Operation, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Operation, Context, Store); when OperationChain(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object FederatedOperationHandler.doOperation(Operation, Context, Store)"})
  void testDoOperation_whenOperationChain_thenReturnNull() throws OperationException {
    // Arrange
    FederatedOperationHandler<Operation> federatedOperationHandler = new FederatedOperationHandler<>();
    OperationChain<Object> operationChain = new OperationChain<>();

    Builder builder = new Builder();
    User user = (new User.Builder()).userId("42").build();
    Context context = builder.user(user).build();

    // Act and Assert
    assertNull(federatedOperationHandler.doOperation(operationChain, context, new FederatedStore()));
  }

  /**
   * Test {@link FederatedOperationHandler#getGraphsToExecuteOn(Operation, Context, FederatedStore)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link AddGraph} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationHandler#getGraphsToExecuteOn(Operation, Context, FederatedStore)}
   */
  @Test
  @DisplayName("Test getGraphsToExecuteOn(Operation, Context, FederatedStore); given HashMap(); when AddGraph (default constructor) Options is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List FederatedOperationHandler.getGraphsToExecuteOn(Operation, Context, FederatedStore)"})
  void testGetGraphsToExecuteOn_givenHashMap_whenAddGraphOptionsIsHashMap() throws OperationException {
    // Arrange
    FederatedOperationHandler<Operation> federatedOperationHandler = new FederatedOperationHandler<>();

    AddGraph operation = new AddGraph();
    operation.setOptions(new HashMap<>());
    Context context = new Context();

    // Act and Assert
    assertTrue(federatedOperationHandler.getGraphsToExecuteOn(operation, context, new FederatedStore()).isEmpty());
  }

  /**
   * Test {@link FederatedOperationHandler#getGraphsToExecuteOn(Operation, Context, FederatedStore)}.
   * <ul>
   *   <li>When {@link AddGraph} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedOperationHandler#getGraphsToExecuteOn(Operation, Context, FederatedStore)}
   */
  @Test
  @DisplayName("Test getGraphsToExecuteOn(Operation, Context, FederatedStore); when AddGraph (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "java.util.List FederatedOperationHandler.getGraphsToExecuteOn(Operation, Context, FederatedStore)"})
  void testGetGraphsToExecuteOn_whenAddGraph_thenReturnEmpty() throws OperationException {
    // Arrange
    FederatedOperationHandler<Operation> federatedOperationHandler = new FederatedOperationHandler<>();
    AddGraph operation = new AddGraph();
    Context context = new Context();

    // Act and Assert
    assertTrue(federatedOperationHandler.getGraphsToExecuteOn(operation, context, new FederatedStore()).isEmpty());
  }
}
