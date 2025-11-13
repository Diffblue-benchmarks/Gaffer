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

package uk.gov.gchq.gaffer.federated.simple.operation.handler.misc;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;
import uk.gov.gchq.gaffer.federated.simple.FederatedStore;
import uk.gov.gchq.gaffer.federated.simple.access.GraphAccess;
import uk.gov.gchq.gaffer.federated.simple.access.GraphAccess.Builder;
import uk.gov.gchq.gaffer.federated.simple.operation.RemoveGraph;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.user.User;

class RemoveGraphHandlerDiffblueTest {
  /**
   * Test {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code RemoveGraph}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object RemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore() throws CacheOperationException, OperationException {
    // Arrange
    RemoveGraphHandler removeGraphHandler = new RemoveGraphHandler();
    RemoveGraph operation = mock(RemoveGraph.class);
    when(operation.getDeleteAllData()).thenReturn(true);
    when(operation.getGraphId()).thenReturn("42");
    Context context = mock(Context.class);
    User buildResult = (new User.Builder()).userId("FederatedStoreSystemUser").build();
    when(context.getUser()).thenReturn(buildResult);
    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).execute(Mockito.<Operation>any(), Mockito.<Context>any());
    doNothing().when(store).removeGraph(Mockito.<String>any());
    GraphAccess buildResult2 = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult2);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Object actualDoOperationResult = removeGraphHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getGraphAccess(eq("42"));
    verify(store).removeGraph(eq("42"));
    verify(operation).getDeleteAllData();
    verify(operation, atLeast(1)).getGraphId();
    verify(context).getUser();
    verify(store).execute(isA(Operation.class), isA(Context.class));
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code RemoveGraph}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link User.Builder} (default constructor) userId {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; given Builder (default constructor) userId '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object RemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore_givenBuilderUserId42Build()
      throws CacheOperationException, OperationException {
    // Arrange
    RemoveGraphHandler removeGraphHandler = new RemoveGraphHandler();
    RemoveGraph operation = mock(RemoveGraph.class);
    when(operation.getDeleteAllData()).thenReturn(true);
    when(operation.getGraphId()).thenReturn("42");
    Context context = mock(Context.class);
    User buildResult = (new User.Builder()).userId("42").build();
    when(context.getUser()).thenReturn(buildResult);
    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).execute(Mockito.<Operation>any(), Mockito.<Context>any());
    doNothing().when(store).removeGraph(Mockito.<String>any());
    GraphAccess buildResult2 = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult2);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Object actualDoOperationResult = removeGraphHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getGraphAccess(eq("42"));
    verify(store).removeGraph(eq("42"));
    verify(operation).getDeleteAllData();
    verify(operation, atLeast(1)).getGraphId();
    verify(context).getUser();
    verify(store).execute(isA(Operation.class), isA(Context.class));
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code RemoveGraph}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Context#Context()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; given 'true'; when Context(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object RemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore_givenTrue_whenContext_thenReturnNull()
      throws CacheOperationException, OperationException {
    // Arrange
    RemoveGraphHandler removeGraphHandler = new RemoveGraphHandler();
    RemoveGraph operation = mock(RemoveGraph.class);
    when(operation.getDeleteAllData()).thenReturn(true);
    when(operation.getGraphId()).thenReturn("42");
    Context context = new Context();
    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).execute(Mockito.<Operation>any(), Mockito.<Context>any());
    doNothing().when(store).removeGraph(Mockito.<String>any());
    GraphAccess buildResult = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Object actualDoOperationResult = removeGraphHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getGraphAccess(eq("42"));
    verify(store).removeGraph(eq("42"));
    verify(operation).getDeleteAllData();
    verify(operation, atLeast(1)).getGraphId();
    verify(store).execute(isA(Operation.class), isA(Context.class));
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code RemoveGraph}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then throw {@link OperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; then throw OperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object RemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore_thenThrowOperationException()
      throws CacheOperationException, OperationException {
    // Arrange
    RemoveGraphHandler removeGraphHandler = new RemoveGraphHandler();
    RemoveGraph operation = mock(RemoveGraph.class);
    when(operation.getDeleteAllData()).thenReturn(true);
    when(operation.getGraphId()).thenReturn("42");
    Context context = new Context();
    FederatedStore store = mock(FederatedStore.class);
    doThrow(new OperationException("An error occurred")).when(store)
        .execute(Mockito.<Operation>any(), Mockito.<Context>any());
    GraphAccess buildResult = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act and Assert
    assertThrows(OperationException.class, () -> removeGraphHandler.doOperation(operation, context, store));
    verify(store).getGraphAccess(eq("42"));
    verify(operation).getDeleteAllData();
    verify(operation, atLeast(1)).getGraphId();
    verify(store).execute(isA(Operation.class), isA(Context.class));
    verify(store).getProperties();
  }

  /**
   * Test {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code RemoveGraph}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link RemoveGraph} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; when RemoveGraph (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object RemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore_whenRemoveGraph_thenReturnNull()
      throws CacheOperationException, OperationException {
    // Arrange
    RemoveGraphHandler removeGraphHandler = new RemoveGraphHandler();
    RemoveGraph operation = new RemoveGraph();
    Context context = new Context();
    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).removeGraph(Mockito.<String>any());
    GraphAccess buildResult = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Object actualDoOperationResult = removeGraphHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getGraphAccess(isNull());
    verify(store).removeGraph(isNull());
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }
}
