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
import static org.mockito.ArgumentMatchers.isNull;
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
import uk.gov.gchq.gaffer.federated.simple.operation.ChangeGraphId;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.user.User;

class ChangeGraphIdHandlerDiffblueTest {
  /**
   * Test {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with {@code ChangeGraphId}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"})
  void testDoOperationWithChangeGraphIdContextStore()
      throws CacheOperationException, OperationException, StoreException {
    // Arrange
    ChangeGraphIdHandler changeGraphIdHandler = new ChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();
    Context context = mock(Context.class);
    User buildResult = (new User.Builder()).userId("FederatedStoreSystemUser").build();
    when(context.getUser()).thenReturn(buildResult);
    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphId(Mockito.<String>any(), Mockito.<String>any());
    GraphAccess buildResult2 = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult2);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Object actualDoOperationResult = changeGraphIdHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphId(isNull(), isNull());
    verify(store).getGraphAccess(isNull());
    verify(context).getUser();
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with {@code ChangeGraphId}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link User.Builder} (default constructor) userId {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'; given Builder (default constructor) userId '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"})
  void testDoOperationWithChangeGraphIdContextStore_givenBuilderUserId42Build()
      throws CacheOperationException, OperationException, StoreException {
    // Arrange
    ChangeGraphIdHandler changeGraphIdHandler = new ChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();
    Context context = mock(Context.class);
    User buildResult = (new User.Builder()).userId("42").build();
    when(context.getUser()).thenReturn(buildResult);
    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphId(Mockito.<String>any(), Mockito.<String>any());
    GraphAccess buildResult2 = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult2);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Object actualDoOperationResult = changeGraphIdHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphId(isNull(), isNull());
    verify(store).getGraphAccess(isNull());
    verify(context).getUser();
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with {@code ChangeGraphId}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then throw {@link OperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'; then throw OperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"})
  void testDoOperationWithChangeGraphIdContextStore_thenThrowOperationException()
      throws CacheOperationException, OperationException, StoreException {
    // Arrange
    ChangeGraphIdHandler changeGraphIdHandler = new ChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();
    Context context = new Context();
    FederatedStore store = mock(FederatedStore.class);
    doThrow(new StoreException("An error occurred")).when(store)
        .changeGraphId(Mockito.<String>any(), Mockito.<String>any());
    GraphAccess buildResult = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act and Assert
    assertThrows(OperationException.class, () -> changeGraphIdHandler.doOperation(operation, context, store));
    verify(store).changeGraphId(isNull(), isNull());
    verify(store).getGraphAccess(isNull());
    verify(store).getProperties();
  }

  /**
   * Test {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with {@code ChangeGraphId}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link Context#Context()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'; when Context(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"})
  void testDoOperationWithChangeGraphIdContextStore_whenContext_thenReturnNull()
      throws CacheOperationException, OperationException, StoreException {
    // Arrange
    ChangeGraphIdHandler changeGraphIdHandler = new ChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();
    Context context = new Context();
    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphId(Mockito.<String>any(), Mockito.<String>any());
    GraphAccess buildResult = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Object actualDoOperationResult = changeGraphIdHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphId(isNull(), isNull());
    verify(store).getGraphAccess(isNull());
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }
}
