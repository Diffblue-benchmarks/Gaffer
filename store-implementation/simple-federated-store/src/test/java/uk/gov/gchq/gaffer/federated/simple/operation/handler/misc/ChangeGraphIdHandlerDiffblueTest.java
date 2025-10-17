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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import uk.gov.gchq.gaffer.federated.simple.util.FederatedTestUtils;
import uk.gov.gchq.gaffer.federated.simple.util.FederatedTestUtils.StoreType;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.user.User;

class ChangeGraphIdHandlerDiffblueTest {
  /**
   * Test {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with {@code
   * ChangeGraphId}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"})
  void testDoOperationWithChangeGraphIdContextStore()
      throws CacheOperationException, OperationException, StoreException {
    // Arrange
    ChangeGraphIdHandler changeGraphIdHandler = new ChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();
    Context context = new Context();

    FederatedStore store = mock(FederatedStore.class);
    doThrow(new StoreException("An error occurred"))
        .when(store)
        .changeGraphId(Mockito.<String>any(), Mockito.<String>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(FederatedTestUtils.getStoreProperties(StoreType.MAP));

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> changeGraphIdHandler.doOperation(operation, context, store));
    verify(store).changeGraphId(null, null);
    verify(store).getGraphAccess(null);
    verify(store).getProperties();
  }

  /**
   * Test {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with {@code
   * ChangeGraphId}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"})
  void testDoOperationWithChangeGraphIdContextStore2()
      throws CacheOperationException, OperationException, StoreException {
    // Arrange
    ChangeGraphIdHandler changeGraphIdHandler = new ChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();

    Context context = mock(Context.class);
    when(context.getUser())
        .thenReturn(new User.Builder().userId("FederatedStoreSystemUser").build());

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphId(Mockito.<String>any(), Mockito.<String>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult = changeGraphIdHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphId(null, null);
    verify(store).getGraphAccess(null);
    verify(context).getUser();
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with {@code
   * ChangeGraphId}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link User.Builder} (default constructor) userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'; given Builder (default constructor) userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"})
  void testDoOperationWithChangeGraphIdContextStore_givenBuilderUserId42Build()
      throws CacheOperationException, OperationException, StoreException {
    // Arrange
    ChangeGraphIdHandler changeGraphIdHandler = new ChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();

    Context context = mock(Context.class);
    when(context.getUser()).thenReturn(new User.Builder().userId("42").build());

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphId(Mockito.<String>any(), Mockito.<String>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult = changeGraphIdHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphId(null, null);
    verify(store).getGraphAccess(null);
    verify(context).getUser();
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with {@code
   * ChangeGraphId}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link CacheOperationException#CacheOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'; given CacheOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"})
  void testDoOperationWithChangeGraphIdContextStore_givenCacheOperationException()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphIdHandler changeGraphIdHandler = new ChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();
    Context context = new Context();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getGraphAccess(Mockito.<String>any())).thenThrow(new CacheOperationException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> changeGraphIdHandler.doOperation(operation, context, store));
    verify(store).getGraphAccess(null);
  }

  /**
   * Test {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with {@code
   * ChangeGraphId}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given StoreProperties is {@code MAP}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'; given StoreProperties is 'MAP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"})
  void testDoOperationWithChangeGraphIdContextStore_givenStorePropertiesIsMap()
      throws CacheOperationException, OperationException, StoreException {
    // Arrange
    ChangeGraphIdHandler changeGraphIdHandler = new ChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();
    Context context = new Context();

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphId(Mockito.<String>any(), Mockito.<String>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(FederatedTestUtils.getStoreProperties(StoreType.MAP));

    // Act
    Object actualDoOperationResult = changeGraphIdHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphId(null, null);
    verify(store).getGraphAccess(null);
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with {@code
   * ChangeGraphId}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link StoreProperties#getAdminAuth()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'; then calls getAdminAuth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"})
  void testDoOperationWithChangeGraphIdContextStore_thenCallsGetAdminAuth()
      throws CacheOperationException, OperationException, StoreException {
    // Arrange
    ChangeGraphIdHandler changeGraphIdHandler = new ChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();
    Context context = new Context();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphId(Mockito.<String>any(), Mockito.<String>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult = changeGraphIdHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphId(null, null);
    verify(store).getGraphAccess(null);
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }
}
