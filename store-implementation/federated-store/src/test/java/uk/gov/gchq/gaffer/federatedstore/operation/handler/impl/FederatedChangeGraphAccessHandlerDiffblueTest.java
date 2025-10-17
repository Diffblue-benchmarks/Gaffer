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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.federatedstore.FederatedAccess;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.federatedstore.FederatedStoreTestUtil;
import uk.gov.gchq.gaffer.federatedstore.exception.StorageException;
import uk.gov.gchq.gaffer.federatedstore.operation.ChangeGraphAccess;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class FederatedChangeGraphAccessHandlerDiffblueTest {
  /**
   * Test {@link FederatedChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)}
   * with {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link FederatedChangeGraphAccessHandler#doOperation(ChangeGraphAccess,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean FederatedChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore() throws OperationException {
    // Arrange
    FederatedChangeGraphAccessHandler federatedChangeGraphAccessHandler =
        new FederatedChangeGraphAccessHandler();
    ChangeGraphAccess operation = new ChangeGraphAccess();

    Context context = mock(Context.class);
    when(context.getUser()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            federatedChangeGraphAccessHandler.doOperation(
                operation, context, mock(FederatedStore.class)));
    verify(context).getUser();
  }

  /**
   * Test {@link FederatedChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)}
   * with {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link User.Builder} (default constructor) userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link FederatedChangeGraphAccessHandler#doOperation(ChangeGraphAccess,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; given Builder (default constructor) userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean FederatedChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore_givenBuilderUserId42Build()
      throws StorageException, OperationException {
    // Arrange
    FederatedChangeGraphAccessHandler federatedChangeGraphAccessHandler =
        new FederatedChangeGraphAccessHandler();
    ChangeGraphAccess operation = new ChangeGraphAccess();

    Context context = mock(Context.class);
    when(context.getUser()).thenReturn(new Builder().userId("42").build());

    FederatedStore store = mock(FederatedStore.class);
    when(store.changeGraphAccess(
            Mockito.<User>any(),
            Mockito.<String>any(),
            Mockito.<FederatedAccess>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> federatedChangeGraphAccessHandler.doOperation(operation, context, store));
    verify(store)
        .changeGraphAccess(isA(User.class), isNull(), isA(FederatedAccess.class), eq(false));
    verify(context).getUser();
  }

  /**
   * Test {@link FederatedChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)}
   * with {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedChangeGraphAccessHandler#doOperation(ChangeGraphAccess,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; given 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean FederatedChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore_givenTrue_thenReturnTrue()
      throws StorageException, OperationException {
    // Arrange
    FederatedChangeGraphAccessHandler federatedChangeGraphAccessHandler =
        new FederatedChangeGraphAccessHandler();
    ChangeGraphAccess operation = new ChangeGraphAccess();
    Context context = FederatedStoreTestUtil.contextAuthUser();

    FederatedStore store = mock(FederatedStore.class);
    when(store.changeGraphAccess(
            Mockito.<User>any(),
            Mockito.<String>any(),
            Mockito.<FederatedAccess>any(),
            anyBoolean()))
        .thenReturn(true);

    // Act
    Boolean actualDoOperationResult =
        federatedChangeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store)
        .changeGraphAccess(isA(User.class), isNull(), isA(FederatedAccess.class), eq(false));
    assertTrue(actualDoOperationResult);
  }
}
