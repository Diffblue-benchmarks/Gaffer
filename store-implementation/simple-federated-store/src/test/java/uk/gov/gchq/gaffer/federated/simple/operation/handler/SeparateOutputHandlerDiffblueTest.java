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

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federated.simple.FederatedStore;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.io.Output;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;

class SeparateOutputHandlerDiffblueTest {
  /**
   * Test {@link SeparateOutputHandler#doOperation(Output, Context, Store)} with {@code Output}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link SeparateOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map SeparateOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore() throws OperationException {
    // Arrange
    SeparateOutputHandler<Output<Object>, Object> separateOutputHandler = new SeparateOutputHandler<>();

    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    namedOperation.addOption(FederatedOperationHandler.OPT_FIX_OP_LIMIT, "42");
    Context context = new Context();

    // Act and Assert
    assertTrue(separateOutputHandler.doOperation(namedOperation, context, new FederatedStore()).isEmpty());
  }

  /**
   * Test {@link SeparateOutputHandler#doOperation(Output, Context, Store)} with {@code Output}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeparateOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'; when NamedOperation (default constructor); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map SeparateOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore_whenNamedOperation_thenReturnEmpty() throws OperationException {
    // Arrange
    SeparateOutputHandler<Output<Object>, Object> separateOutputHandler = new SeparateOutputHandler<>();
    NamedOperation<Object, Object> namedOperation = new NamedOperation<>();
    Context context = new Context();

    // Act and Assert
    assertTrue(separateOutputHandler.doOperation(namedOperation, context, new FederatedStore()).isEmpty());
  }

  /**
   * Test {@link SeparateOutputHandler#doOperation(Output, Context, Store)} with {@code Output}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link OperationChain#OperationChain()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SeparateOutputHandler#doOperation(Output, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(Output, Context, Store) with 'Output', 'Context', 'Store'; when OperationChain(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Map SeparateOutputHandler.doOperation(Output, Context, Store)"})
  void testDoOperationWithOutputContextStore_whenOperationChain_thenReturnEmpty() throws OperationException {
    // Arrange
    SeparateOutputHandler<Output<Object>, Object> separateOutputHandler = new SeparateOutputHandler<>();
    OperationChain<Object> operationChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertTrue(separateOutputHandler.doOperation(operationChain, context, new FederatedStore()).isEmpty());
  }
}
