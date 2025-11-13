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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.federatedstore.FederatedAccess;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.federatedstore.exception.StorageException;
import uk.gov.gchq.gaffer.federatedstore.operation.ChangeGraphAccess;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class FederatedChangeGraphAccessHandlerDiffblueTest {
  /**
   * Test {@link FederatedChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; given 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean FederatedChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"})
  void testDoOperationWithChangeGraphAccessContextStore_givenFalse_thenReturnFalse()
      throws StorageException, OperationException {
    // Arrange
    FederatedChangeGraphAccessHandler federatedChangeGraphAccessHandler = new FederatedChangeGraphAccessHandler();
    ChangeGraphAccess operation = mock(ChangeGraphAccess.class);
    when(operation.getIsPublic()).thenReturn(true);
    when(operation.isUserRequestingAdminUsage()).thenReturn(true);
    when(operation.getGraphId()).thenReturn("42");
    when(operation.getOwnerUserId()).thenReturn("42");
    when(operation.getGraphAuths()).thenReturn(new HashSet<>());
    Context context = mock(Context.class);
    User buildResult = (new Builder()).userId("42").build();
    when(context.getUser()).thenReturn(buildResult);
    FederatedStore store = mock(FederatedStore.class);
    when(store.changeGraphAccess(Mockito.<User>any(), Mockito.<String>any(), Mockito.<FederatedAccess>any(),
        anyBoolean())).thenReturn(false);

    // Act
    Boolean actualDoOperationResult = federatedChangeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(isA(User.class), eq("42"), isA(FederatedAccess.class), eq(true));
    verify(operation).getGraphAuths();
    verify(operation).getGraphId();
    verify(operation).getIsPublic();
    verify(operation).getOwnerUserId();
    verify(operation).isUserRequestingAdminUsage();
    verify(context).getUser();
    assertFalse(actualDoOperationResult);
  }

  /**
   * Test {@link FederatedChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean FederatedChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"})
  void testDoOperationWithChangeGraphAccessContextStore_thenReturnTrue() throws StorageException, OperationException {
    // Arrange
    FederatedChangeGraphAccessHandler federatedChangeGraphAccessHandler = new FederatedChangeGraphAccessHandler();
    ChangeGraphAccess operation = mock(ChangeGraphAccess.class);
    when(operation.getIsPublic()).thenReturn(true);
    when(operation.isUserRequestingAdminUsage()).thenReturn(true);
    when(operation.getGraphId()).thenReturn("42");
    when(operation.getOwnerUserId()).thenReturn("42");
    when(operation.getGraphAuths()).thenReturn(new HashSet<>());
    Context context = mock(Context.class);
    User buildResult = (new Builder()).userId("42").build();
    when(context.getUser()).thenReturn(buildResult);
    FederatedStore store = mock(FederatedStore.class);
    when(store.changeGraphAccess(Mockito.<User>any(), Mockito.<String>any(), Mockito.<FederatedAccess>any(),
        anyBoolean())).thenReturn(true);

    // Act
    Boolean actualDoOperationResult = federatedChangeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(isA(User.class), eq("42"), isA(FederatedAccess.class), eq(true));
    verify(operation).getGraphAuths();
    verify(operation).getGraphId();
    verify(operation).getIsPublic();
    verify(operation).getOwnerUserId();
    verify(operation).isUserRequestingAdminUsage();
    verify(context).getUser();
    assertTrue(actualDoOperationResult);
  }
}
