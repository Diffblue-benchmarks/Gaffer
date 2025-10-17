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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.access.predicate.AccessPredicate;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;
import uk.gov.gchq.gaffer.federated.simple.FederatedStore;
import uk.gov.gchq.gaffer.federated.simple.access.GraphAccess;
import uk.gov.gchq.gaffer.federated.simple.access.GraphAccess.Builder;
import uk.gov.gchq.gaffer.federated.simple.operation.ChangeGraphAccess;
import uk.gov.gchq.gaffer.federated.simple.util.FederatedTestUtils;
import uk.gov.gchq.gaffer.federated.simple.util.FederatedTestUtils.StoreType;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.user.User;

class ChangeGraphAccessHandlerDiffblueTest {
  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with
   * {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();
    ChangeGraphAccess operation = new ChangeGraphAccess();
    Context context = new Context();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getGraphAccess(Mockito.<String>any())).thenThrow(new CacheOperationException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> changeGraphAccessHandler.doOperation(operation, context, store));
    verify(store).getGraphAccess(null);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with
   * {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore2()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();
    ChangeGraphAccess operation = new ChangeGraphAccess();
    Context context = new Context();

    FederatedStore store = mock(FederatedStore.class);
    doThrow(new CacheOperationException())
        .when(store)
        .changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(FederatedTestUtils.getStoreProperties(StoreType.MAP));

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> changeGraphAccessHandler.doOperation(operation, context, store));
    verify(store).changeGraphAccess(isNull(), isA(GraphAccess.class));
    verify(store).getGraphAccess(null);
    verify(store).getProperties();
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with
   * {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore3()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();

    ChangeGraphAccess operation = new ChangeGraphAccess();
    operation.setReadPredicate(new AccessPredicate(mock(Predicate.class)));
    Context context = new Context();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult =
        changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(isNull(), isA(GraphAccess.class));
    verify(store).getGraphAccess(null);
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with
   * {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore4()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();

    ChangeGraphAccess operation = new ChangeGraphAccess();
    operation.setWritePredicate(new AccessPredicate(mock(Predicate.class)));
    Context context = new Context();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult =
        changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(isNull(), isA(GraphAccess.class));
    verify(store).getGraphAccess(null);
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with
   * {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore5()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();

    ChangeGraphAccess operation = mock(ChangeGraphAccess.class);
    when(operation.isPublic()).thenReturn(null);
    when(operation.getOwner()).thenReturn(null);
    when(operation.getReadPredicate()).thenReturn(null);
    when(operation.getWritePredicate()).thenReturn(null);
    when(operation.getGraphId()).thenReturn("42");

    Context context = mock(Context.class);
    when(context.getUser())
        .thenReturn(new User.Builder().userId("FederatedStoreSystemUser").build());

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult =
        changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(eq("42"), isA(GraphAccess.class));
    verify(store).getGraphAccess("42");
    verify(operation, atLeast(1)).getGraphId();
    verify(operation).getOwner();
    verify(operation).getReadPredicate();
    verify(operation).getWritePredicate();
    verify(operation).isPublic();
    verify(context).getUser();
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with
   * {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link User.Builder} (default constructor) userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; given Builder (default constructor) userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore_givenBuilderUserId42Build()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();

    ChangeGraphAccess operation = mock(ChangeGraphAccess.class);
    when(operation.isPublic()).thenReturn(null);
    when(operation.getOwner()).thenReturn(null);
    when(operation.getReadPredicate()).thenReturn(null);
    when(operation.getWritePredicate()).thenReturn(null);
    when(operation.getGraphId()).thenReturn("42");

    Context context = mock(Context.class);
    when(context.getUser()).thenReturn(new User.Builder().userId("42").build());

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult =
        changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(eq("42"), isA(GraphAccess.class));
    verify(store).getGraphAccess("42");
    verify(operation, atLeast(1)).getGraphId();
    verify(operation).getOwner();
    verify(operation).getReadPredicate();
    verify(operation).getWritePredicate();
    verify(operation).isPublic();
    verify(context).getUser();
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with
   * {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore_givenFalse()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();

    ChangeGraphAccess operation = mock(ChangeGraphAccess.class);
    when(operation.isPublic()).thenReturn(false);
    when(operation.getOwner()).thenReturn(null);
    when(operation.getReadPredicate()).thenReturn(null);
    when(operation.getWritePredicate()).thenReturn(null);
    when(operation.getGraphId()).thenReturn("42");

    Context context = mock(Context.class);
    when(context.getUser()).thenReturn(new User.Builder().userId("42").build());

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult =
        changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(eq("42"), isA(GraphAccess.class));
    verify(store).getGraphAccess("42");
    verify(operation, atLeast(1)).getGraphId();
    verify(operation).getOwner();
    verify(operation).getReadPredicate();
    verify(operation).getWritePredicate();
    verify(operation, atLeast(1)).isPublic();
    verify(context).getUser();
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with
   * {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code FederatedStoreSystemUser}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; given 'FederatedStoreSystemUser'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore_givenFederatedStoreSystemUser()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();

    ChangeGraphAccess operation = new ChangeGraphAccess();
    operation.setOwner("FederatedStoreSystemUser");
    Context context = new Context();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult =
        changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(isNull(), isA(GraphAccess.class));
    verify(store).getGraphAccess(null);
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with
   * {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given StoreProperties is {@code MAP}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; given StoreProperties is 'MAP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore_givenStorePropertiesIsMap()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();
    ChangeGraphAccess operation = new ChangeGraphAccess();
    Context context = new Context();

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(FederatedTestUtils.getStoreProperties(StoreType.MAP));

    // Act
    Object actualDoOperationResult =
        changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(isNull(), isA(GraphAccess.class));
    verify(store).getGraphAccess(null);
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with
   * {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore_givenTrue()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();

    ChangeGraphAccess operation = new ChangeGraphAccess();
    operation.setIsPublic(true);
    Context context = new Context();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult =
        changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(isNull(), isA(GraphAccess.class));
    verify(store).getGraphAccess(null);
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with
   * {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link ChangeGraphAccess} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; when ChangeGraphAccess (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"
  })
  void testDoOperationWithChangeGraphAccessContextStore_whenChangeGraphAccess()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();
    ChangeGraphAccess operation = new ChangeGraphAccess();
    Context context = new Context();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult =
        changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(isNull(), isA(GraphAccess.class));
    verify(store).getGraphAccess(null);
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }
}
