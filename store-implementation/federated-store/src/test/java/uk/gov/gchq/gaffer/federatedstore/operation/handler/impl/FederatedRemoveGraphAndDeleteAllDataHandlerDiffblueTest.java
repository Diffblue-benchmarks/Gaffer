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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.federatedstore.operation.IFederationOperation;
import uk.gov.gchq.gaffer.federatedstore.operation.RemoveGraph;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class FederatedRemoveGraphAndDeleteAllDataHandlerDiffblueTest {
  /**
   * Test {@link FederatedRemoveGraphAndDeleteAllDataHandler#doOperation(RemoveGraph, Context, Store)} with {@code RemoveGraph}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedRemoveGraphAndDeleteAllDataHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; given 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean FederatedRemoveGraphAndDeleteAllDataHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore_givenFalse_thenReturnFalse() throws OperationException {
    // Arrange
    FederatedRemoveGraphAndDeleteAllDataHandler federatedRemoveGraphAndDeleteAllDataHandler = new FederatedRemoveGraphAndDeleteAllDataHandler();
    RemoveGraph operation = mock(RemoveGraph.class);
    when(operation.isRemoveCache()).thenReturn(true);
    when(operation.isUserRequestingAdminUsage()).thenReturn(true);
    doNothing().when(operation).addOption(Mockito.<String>any(), Mockito.<String>any());
    when(operation.getGraphId()).thenReturn("42");
    operation.addOption("FederatedStore.processed.", "42");
    Context context = mock(Context.class);
    User buildResult = (new Builder()).userId("42").build();
    when(context.getUser()).thenReturn(buildResult);
    FederatedStore store = mock(FederatedStore.class);
    when(store.remove(Mockito.<String>any(), Mockito.<User>any(), anyBoolean(), anyBoolean())).thenReturn(false);
    when(store.getGraphs(Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Boolean actualDoOperationResult = federatedRemoveGraphAndDeleteAllDataHandler.doOperation(operation, context,
        store);

    // Assert
    verify(store, atLeast(1)).getGraphs(isA(User.class), Mockito.<List<String>>any(),
        Mockito.<IFederationOperation>any());
    verify(store).remove(eq("42"), isA(User.class), eq(true), eq(true));
    verify(operation, atLeast(1)).getGraphId();
    verify(operation).isRemoveCache();
    verify(operation).isUserRequestingAdminUsage();
    verify(operation).addOption(eq("FederatedStore.processed."), eq("42"));
    verify(context, atLeast(1)).getUser();
    assertFalse(actualDoOperationResult);
  }

  /**
   * Test {@link FederatedRemoveGraphAndDeleteAllDataHandler#doOperation(RemoveGraph, Context, Store)} with {@code RemoveGraph}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedRemoveGraphAndDeleteAllDataHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean FederatedRemoveGraphAndDeleteAllDataHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore_thenReturnTrue() throws OperationException {
    // Arrange
    FederatedRemoveGraphAndDeleteAllDataHandler federatedRemoveGraphAndDeleteAllDataHandler = new FederatedRemoveGraphAndDeleteAllDataHandler();
    RemoveGraph operation = mock(RemoveGraph.class);
    when(operation.isRemoveCache()).thenReturn(true);
    when(operation.isUserRequestingAdminUsage()).thenReturn(true);
    doNothing().when(operation).addOption(Mockito.<String>any(), Mockito.<String>any());
    when(operation.getGraphId()).thenReturn("42");
    operation.addOption("FederatedStore.processed.", "42");
    Context context = mock(Context.class);
    User buildResult = (new Builder()).userId("42").build();
    when(context.getUser()).thenReturn(buildResult);
    FederatedStore store = mock(FederatedStore.class);
    when(store.remove(Mockito.<String>any(), Mockito.<User>any(), anyBoolean(), anyBoolean())).thenReturn(true);
    when(store.getGraphs(Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Boolean actualDoOperationResult = federatedRemoveGraphAndDeleteAllDataHandler.doOperation(operation, context,
        store);

    // Assert
    verify(store, atLeast(1)).getGraphs(isA(User.class), Mockito.<List<String>>any(),
        Mockito.<IFederationOperation>any());
    verify(store).remove(eq("42"), isA(User.class), eq(true), eq(true));
    verify(operation, atLeast(1)).getGraphId();
    verify(operation).isRemoveCache();
    verify(operation).isUserRequestingAdminUsage();
    verify(operation).addOption(eq("FederatedStore.processed."), eq("42"));
    verify(context, atLeast(1)).getUser();
    assertTrue(actualDoOperationResult);
  }
}
