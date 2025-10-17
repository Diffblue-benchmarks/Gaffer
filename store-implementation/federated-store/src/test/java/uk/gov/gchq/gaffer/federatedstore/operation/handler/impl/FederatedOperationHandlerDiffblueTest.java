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

package uk.gov.gchq.gaffer.federatedstore.operation.handler.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.federatedstore.FederatedStoreTestUtil;
import uk.gov.gchq.gaffer.federatedstore.operation.FederatedOperation;
import uk.gov.gchq.gaffer.federatedstore.operation.IFederationOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class FederatedOperationHandlerDiffblueTest {
  /**
   * Test {@link FederatedOperationHandler#doOperation(FederatedOperation, Context, Store)} with
   * {@code FederatedOperation}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link FederatedOperationHandler#doOperation(FederatedOperation, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(FederatedOperation, Context, Store) with 'FederatedOperation', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FederatedOperationHandler.doOperation(FederatedOperation, Context, Store)"
  })
  void testDoOperationWithFederatedOperationContextStore() throws OperationException {
    // Arrange
    FederatedOperationHandler<Object, Object> federatedOperationHandler =
        new FederatedOperationHandler<>();

    FederatedOperation<Object, Object> operation = mock(FederatedOperation.class);
    when(operation.getGraphIds()).thenReturn(new ArrayList<>());
    when(operation.payloadOperation(Mockito.<Operation>any()))
        .thenReturn(new FederatedOperation<>());
    operation.payloadOperation(mock(Operation.class));
    Context context = FederatedStoreTestUtil.contextAuthUser();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Object actualDoOperationResult =
        federatedOperationHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getGraphs(isA(User.class), isA(List.class), isA(IFederationOperation.class));
    verify(operation).getGraphIds();
    verify(operation).payloadOperation(isA(Operation.class));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link FederatedOperationHandler#doOperation(FederatedOperation, Context, Store)} with
   * {@code FederatedOperation}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link FederatedOperationHandler#doOperation(FederatedOperation, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(FederatedOperation, Context, Store) with 'FederatedOperation', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FederatedOperationHandler.doOperation(FederatedOperation, Context, Store)"
  })
  void testDoOperationWithFederatedOperationContextStore2() throws OperationException {
    // Arrange
    FederatedOperationHandler<Object, Object> federatedOperationHandler =
        new FederatedOperationHandler<>();

    FederatedOperation<Object, Object> operation = mock(FederatedOperation.class);
    when(operation.getGraphIds()).thenReturn(new ArrayList<>());
    when(operation.payloadOperation(Mockito.<Operation>any()))
        .thenReturn(new FederatedOperation<>());
    operation.payloadOperation(mock(Operation.class));
    Context context = FederatedStoreTestUtil.contextAuthUser();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> federatedOperationHandler.doOperation(operation, context, store));
    verify(store).getGraphs(isA(User.class), isA(List.class), isA(IFederationOperation.class));
    verify(operation).getGraphIds();
    verify(operation).payloadOperation(isA(Operation.class));
  }

  /**
   * Test {@link FederatedOperationHandler#doOperation(FederatedOperation, Context, Store)} with
   * {@code FederatedOperation}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link FederatedOperationHandler#doOperation(FederatedOperation, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(FederatedOperation, Context, Store) with 'FederatedOperation', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FederatedOperationHandler.doOperation(FederatedOperation, Context, Store)"
  })
  void testDoOperationWithFederatedOperationContextStore3() throws OperationException {
    // Arrange
    FederatedOperationHandler<Object, Object> federatedOperationHandler =
        new FederatedOperationHandler<>();

    FederatedOperation<Object, Object> operation = mock(FederatedOperation.class);
    when(operation.payloadOperation(Mockito.<Operation>any()))
        .thenReturn(new FederatedOperation<>());
    operation.payloadOperation(mock(Operation.class));

    Context context = mock(Context.class);
    when(context.getUser()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            federatedOperationHandler.doOperation(operation, context, mock(FederatedStore.class)));
    verify(operation).payloadOperation(isA(Operation.class));
    verify(context).getUser();
  }

  /**
   * Test {@link FederatedOperationHandler#doOperation(FederatedOperation, Context, Store)} with
   * {@code FederatedOperation}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link User.Builder} (default constructor) userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link FederatedOperationHandler#doOperation(FederatedOperation, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(FederatedOperation, Context, Store) with 'FederatedOperation', 'Context', 'Store'; given Builder (default constructor) userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object FederatedOperationHandler.doOperation(FederatedOperation, Context, Store)"
  })
  void testDoOperationWithFederatedOperationContextStore_givenBuilderUserId42Build()
      throws OperationException {
    // Arrange
    FederatedOperationHandler<Object, Object> federatedOperationHandler =
        new FederatedOperationHandler<>();

    FederatedOperation<Object, Object> operation = mock(FederatedOperation.class);
    when(operation.getGraphIds()).thenReturn(new ArrayList<>());
    when(operation.payloadOperation(Mockito.<Operation>any()))
        .thenReturn(new FederatedOperation<>());
    operation.payloadOperation(mock(Operation.class));

    Context context = mock(Context.class);
    when(context.getUser()).thenReturn(new Builder().userId("42").build());

    FederatedStore store = mock(FederatedStore.class);
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Object actualDoOperationResult =
        federatedOperationHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getGraphs(isA(User.class), isA(List.class), isA(IFederationOperation.class));
    verify(operation).getGraphIds();
    verify(operation).payloadOperation(isA(Operation.class));
    verify(context).getUser();
    assertNull(actualDoOperationResult);
  }
}
