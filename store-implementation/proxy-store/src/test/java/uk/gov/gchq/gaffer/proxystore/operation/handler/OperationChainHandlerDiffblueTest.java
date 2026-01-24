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

package uk.gov.gchq.gaffer.proxystore.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationChainDAO;
import uk.gov.gchq.gaffer.proxystore.ProxyStore;
import uk.gov.gchq.gaffer.proxystore.exception.ProxyStoreException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.OperationChainValidator;
import uk.gov.gchq.gaffer.store.schema.ViewValidator;

class OperationChainHandlerDiffblueTest {
  /**
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code
   * OperationChain}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OperationChainHandler.doOperation(OperationChain, Context, Store)"})
  void testDoOperationWithOperationChainContextStore() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(opChainValidator, new ArrayList<>());

    OperationChain<Object> operation = new OperationChain<>();
    operation.addOption(OperationChainHandler.PROXY_STORE_OPERATION_CHAIN_HANDLER, "42");
    OperationChain<Object> operationChain = OperationChain.wrap(operation);
    Context context = new Context();

    // Act and Assert
    assertNull(operationChainHandler.doOperation(operationChain, context, new ProxyStore()));
    Map<String, String> options = operationChain.getOptions();
    assertEquals(1, options.size());
    assertEquals(
        OperationChainHandler.RESOLVED,
        options.get(OperationChainHandler.PROXY_STORE_OPERATION_CHAIN_HANDLER));
  }

  /**
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code
   * OperationChain}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OperationChainHandler.doOperation(OperationChain, Context, Store)"})
  void testDoOperationWithOperationChainContextStore2() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(opChainValidator, new ArrayList<>());

    AddNamedOperation operation = new AddNamedOperation();
    operation.setOperationChain(OperationChainHandler.PROXY_STORE_OPERATION_CHAIN_HANDLER);
    OperationChain<Object> operationChain = OperationChain.wrap(new OperationChainDAO<>(operation));
    Context context = new Context();

    // Act and Assert
    assertThrows(
        ProxyStoreException.class,
        () -> operationChainHandler.doOperation(operationChain, context, new ProxyStore()));
  }

  /**
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code
   * OperationChain}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OperationChainHandler.doOperation(OperationChain, Context, Store)"})
  void testDoOperationWithOperationChainContextStore_thenReturnNull() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(opChainValidator, new ArrayList<>());
    OperationChain<Object> operationChain = OperationChain.wrap(new OperationChain<>());
    Context context = new Context();

    // Act and Assert
    assertNull(operationChainHandler.doOperation(operationChain, context, new ProxyStore()));
    Map<String, String> options = operationChain.getOptions();
    assertEquals(1, options.size());
    assertEquals(
        OperationChainHandler.RESOLVED,
        options.get(OperationChainHandler.PROXY_STORE_OPERATION_CHAIN_HANDLER));
  }

  /**
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code
   * OperationChain}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link ProxyStoreException}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'; then throw ProxyStoreException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OperationChainHandler.doOperation(OperationChain, Context, Store)"})
  void testDoOperationWithOperationChainContextStore_thenThrowProxyStoreException() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(opChainValidator, new ArrayList<>());
    OperationChain<Object> operationChain =
        OperationChain.wrap(new OperationChainDAO<>(new AddNamedOperation()));
    Context context = new Context();

    // Act and Assert
    assertThrows(
        ProxyStoreException.class,
        () -> operationChainHandler.doOperation(operationChain, context, new ProxyStore()));
  }

  /**
   * Test {@link OperationChainHandler#doOperation(OperationChain, Context, Store)} with {@code
   * OperationChain}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OperationChainHandler#doOperation(OperationChain, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(OperationChain, Context, Store) with 'OperationChain', 'Context', 'Store'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object OperationChainHandler.doOperation(OperationChain, Context, Store)"})
  void testDoOperationWithOperationChainContextStore_whenNull() {
    // Arrange
    OperationChainValidator opChainValidator = new OperationChainValidator(new ViewValidator());
    OperationChainHandler<Object> operationChainHandler =
        new OperationChainHandler<>(opChainValidator, new ArrayList<>());
    OperationChain<Object> operationChain = OperationChain.wrap(new NamedOperation<>());

    // Act and Assert
    assertThrows(
        ProxyStoreException.class,
        () -> operationChainHandler.doOperation(operationChain, new Context(), null));
  }
}
