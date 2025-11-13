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
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.user.User;

class ChangeGraphAccessHandlerDiffblueTest {
  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   * <p>
   * Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"})
  void testDoOperationWithChangeGraphAccessContextStore() throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();
    ChangeGraphAccess operation = mock(ChangeGraphAccess.class);
    when(operation.isPublic()).thenReturn(true);
    when(operation.getGraphId()).thenReturn("42");
    when(operation.getOwner()).thenReturn("Owner");
    when(operation.getReadPredicate()).thenReturn(new AccessPredicate(mock(Predicate.class)));
    when(operation.getWritePredicate()).thenReturn(new AccessPredicate(mock(Predicate.class)));
    Context context = mock(Context.class);
    User buildResult = (new User.Builder()).userId("FederatedStoreSystemUser").build();
    when(context.getUser()).thenReturn(buildResult);
    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    GraphAccess buildResult2 = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult2);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Object actualDoOperationResult = changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(eq("42"), isA(GraphAccess.class));
    verify(store).getGraphAccess(eq("42"));
    verify(operation, atLeast(1)).getGraphId();
    verify(operation, atLeast(1)).getOwner();
    verify(operation, atLeast(1)).getReadPredicate();
    verify(operation, atLeast(1)).getWritePredicate();
    verify(operation, atLeast(1)).isPublic();
    verify(context).getUser();
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@link User.Builder} (default constructor) userId {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; given Builder (default constructor) userId '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"})
  void testDoOperationWithChangeGraphAccessContextStore_givenBuilderUserId42Build()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();
    ChangeGraphAccess operation = mock(ChangeGraphAccess.class);
    when(operation.isPublic()).thenReturn(true);
    when(operation.getGraphId()).thenReturn("42");
    when(operation.getOwner()).thenReturn("Owner");
    when(operation.getReadPredicate()).thenReturn(new AccessPredicate(mock(Predicate.class)));
    when(operation.getWritePredicate()).thenReturn(new AccessPredicate(mock(Predicate.class)));
    Context context = mock(Context.class);
    User buildResult = (new User.Builder()).userId("42").build();
    when(context.getUser()).thenReturn(buildResult);
    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    GraphAccess buildResult2 = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult2);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Object actualDoOperationResult = changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(eq("42"), isA(GraphAccess.class));
    verify(store).getGraphAccess(eq("42"));
    verify(operation, atLeast(1)).getGraphId();
    verify(operation, atLeast(1)).getOwner();
    verify(operation, atLeast(1)).getReadPredicate();
    verify(operation, atLeast(1)).getWritePredicate();
    verify(operation, atLeast(1)).isPublic();
    verify(context).getUser();
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"})
  void testDoOperationWithChangeGraphAccessContextStore_givenFalse()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();
    ChangeGraphAccess operation = mock(ChangeGraphAccess.class);
    when(operation.isPublic()).thenReturn(false);
    when(operation.getGraphId()).thenReturn("42");
    when(operation.getOwner()).thenReturn("Owner");
    when(operation.getReadPredicate()).thenReturn(new AccessPredicate(mock(Predicate.class)));
    when(operation.getWritePredicate()).thenReturn(new AccessPredicate(mock(Predicate.class)));
    Context context = new Context();
    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    GraphAccess buildResult = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Object actualDoOperationResult = changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(eq("42"), isA(GraphAccess.class));
    verify(store).getGraphAccess(eq("42"));
    verify(operation, atLeast(1)).getGraphId();
    verify(operation, atLeast(1)).getOwner();
    verify(operation, atLeast(1)).getReadPredicate();
    verify(operation, atLeast(1)).getWritePredicate();
    verify(operation, atLeast(1)).isPublic();
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link ChangeGraphAccess#getGraphId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; given 'true'; then calls getGraphId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"})
  void testDoOperationWithChangeGraphAccessContextStore_givenTrue_thenCallsGetGraphId()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();
    ChangeGraphAccess operation = mock(ChangeGraphAccess.class);
    when(operation.isPublic()).thenReturn(true);
    when(operation.getGraphId()).thenReturn("42");
    when(operation.getOwner()).thenReturn("Owner");
    when(operation.getReadPredicate()).thenReturn(new AccessPredicate(mock(Predicate.class)));
    when(operation.getWritePredicate()).thenReturn(new AccessPredicate(mock(Predicate.class)));
    Context context = new Context();
    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    GraphAccess buildResult = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Object actualDoOperationResult = changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(eq("42"), isA(GraphAccess.class));
    verify(store).getGraphAccess(eq("42"));
    verify(operation, atLeast(1)).getGraphId();
    verify(operation, atLeast(1)).getOwner();
    verify(operation, atLeast(1)).getReadPredicate();
    verify(operation, atLeast(1)).getWritePredicate();
    verify(operation, atLeast(1)).isPublic();
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>Then throw {@link OperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; then throw OperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"})
  void testDoOperationWithChangeGraphAccessContextStore_thenThrowOperationException()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();
    ChangeGraphAccess operation = new ChangeGraphAccess();
    Context context = new Context();
    FederatedStore store = mock(FederatedStore.class);
    doThrow(new CacheOperationException()).when(store)
        .changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    GraphAccess buildResult = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act and Assert
    assertThrows(OperationException.class, () -> changeGraphAccessHandler.doOperation(operation, context, store));
    verify(store).changeGraphAccess(isNull(), isA(GraphAccess.class));
    verify(store).getGraphAccess(isNull());
    verify(store).getProperties();
  }

  /**
   * Test {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)} with {@code ChangeGraphAccess}, {@code Context}, {@code Store}.
   * <ul>
   *   <li>When {@link ChangeGraphAccess} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ChangeGraphAccessHandler#doOperation(ChangeGraphAccess, Context, Store)}
   */
  @Test
  @DisplayName("Test doOperation(ChangeGraphAccess, Context, Store) with 'ChangeGraphAccess', 'Context', 'Store'; when ChangeGraphAccess (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ChangeGraphAccessHandler.doOperation(ChangeGraphAccess, Context, Store)"})
  void testDoOperationWithChangeGraphAccessContextStore_whenChangeGraphAccess()
      throws CacheOperationException, OperationException {
    // Arrange
    ChangeGraphAccessHandler changeGraphAccessHandler = new ChangeGraphAccessHandler();
    ChangeGraphAccess operation = new ChangeGraphAccess();
    Context context = new Context();
    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).changeGraphAccess(Mockito.<String>any(), Mockito.<GraphAccess>any());
    GraphAccess buildResult = (new Builder()).build();
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(buildResult);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Object actualDoOperationResult = changeGraphAccessHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphAccess(isNull(), isA(GraphAccess.class));
    verify(store).getGraphAccess(isNull());
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }
}
