package uk.gov.gchq.gaffer.federated.simple.operation.handler.misc;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
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
import uk.gov.gchq.gaffer.federated.simple.operation.RemoveGraph;
import uk.gov.gchq.gaffer.federated.simple.util.FederatedTestUtils;
import uk.gov.gchq.gaffer.federated.simple.util.FederatedTestUtils.StoreType;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.user.User;

class RemoveGraphHandlerDiffblueTest {
  /**
   * Test {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code
   * RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore()
      throws CacheOperationException, OperationException {
    // Arrange
    RemoveGraphHandler removeGraphHandler = new RemoveGraphHandler();

    RemoveGraph operation = new RemoveGraph();
    operation.setDeleteAllData(true);
    Context context = new Context();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doThrow(new OperationException("An error occurred"))
        .when(store)
        .execute(Mockito.<Operation>any(), Mockito.<Context>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act and Assert
    assertThrows(
        OperationException.class, () -> removeGraphHandler.doOperation(operation, context, store));
    verify(store).getGraphAccess(null);
    verify(store).execute(isA(Operation.class), isA(Context.class));
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
  }

  /**
   * Test {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code
   * RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore2()
      throws CacheOperationException, OperationException {
    // Arrange
    RemoveGraphHandler removeGraphHandler = new RemoveGraphHandler();

    RemoveGraph operation = new RemoveGraph();
    operation.setDeleteAllData(true);

    Context context = mock(Context.class);
    when(context.getUser())
        .thenReturn(new User.Builder().userId("FederatedStoreSystemUser").build());

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).execute(Mockito.<Operation>any(), Mockito.<Context>any());
    doNothing().when(store).removeGraph(Mockito.<String>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult = removeGraphHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getGraphAccess(null);
    verify(store).removeGraph(null);
    verify(context).getUser();
    verify(store).execute(isA(Operation.class), isA(Context.class));
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code
   * RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link User.Builder} (default constructor) userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; given Builder (default constructor) userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore_givenBuilderUserId42Build()
      throws CacheOperationException, OperationException {
    // Arrange
    RemoveGraphHandler removeGraphHandler = new RemoveGraphHandler();

    RemoveGraph operation = new RemoveGraph();
    operation.setDeleteAllData(true);

    Context context = mock(Context.class);
    when(context.getUser()).thenReturn(new User.Builder().userId("42").build());

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).execute(Mockito.<Operation>any(), Mockito.<Context>any());
    doNothing().when(store).removeGraph(Mockito.<String>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult = removeGraphHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getGraphAccess(null);
    verify(store).removeGraph(null);
    verify(context).getUser();
    verify(store).execute(isA(Operation.class), isA(Context.class));
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code
   * RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link CacheOperationException#CacheOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; given CacheOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore_givenCacheOperationException()
      throws CacheOperationException, OperationException {
    // Arrange
    RemoveGraphHandler removeGraphHandler = new RemoveGraphHandler();
    RemoveGraph operation = new RemoveGraph();
    Context context = new Context();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getGraphAccess(Mockito.<String>any())).thenThrow(new CacheOperationException());

    // Act and Assert
    assertThrows(
        OperationException.class, () -> removeGraphHandler.doOperation(operation, context, store));
    verify(store).getGraphAccess(null);
  }

  /**
   * Test {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code
   * RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given StoreProperties is {@code MAP}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; given StoreProperties is 'MAP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore_givenStorePropertiesIsMap()
      throws CacheOperationException, OperationException {
    // Arrange
    RemoveGraphHandler removeGraphHandler = new RemoveGraphHandler();
    RemoveGraph operation = new RemoveGraph();
    Context context = new Context();

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).removeGraph(Mockito.<String>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(FederatedTestUtils.getStoreProperties(StoreType.MAP));

    // Act
    Object actualDoOperationResult = removeGraphHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getGraphAccess(null);
    verify(store).removeGraph(null);
    verify(store).getProperties();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code
   * RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore_thenReturnNull()
      throws CacheOperationException, OperationException {
    // Arrange
    RemoveGraphHandler removeGraphHandler = new RemoveGraphHandler();
    RemoveGraph operation = new RemoveGraph();
    Context context = new Context();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).removeGraph(Mockito.<String>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult = removeGraphHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getGraphAccess(null);
    verify(store).removeGraph(null);
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code
   * RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link FederatedStore} {@link FederatedStore#execute(Operation, Context)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link RemoveGraphHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; when FederatedStore execute(Operation, Context) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object RemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"})
  void testDoOperationWithRemoveGraphContextStore_whenFederatedStoreExecuteDoesNothing()
      throws CacheOperationException, OperationException {
    // Arrange
    RemoveGraphHandler removeGraphHandler = new RemoveGraphHandler();

    RemoveGraph operation = new RemoveGraph();
    operation.setDeleteAllData(true);
    Context context = new Context();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getAdminAuth()).thenReturn("Admin Auth");

    FederatedStore store = mock(FederatedStore.class);
    doNothing().when(store).execute(Mockito.<Operation>any(), Mockito.<Context>any());
    doNothing().when(store).removeGraph(Mockito.<String>any());
    when(store.getGraphAccess(Mockito.<String>any())).thenReturn(new Builder().build());
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Object actualDoOperationResult = removeGraphHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getGraphAccess(null);
    verify(store).removeGraph(null);
    verify(store).execute(isA(Operation.class), isA(Context.class));
    verify(store).getProperties();
    verify(storeProperties).getAdminAuth();
    assertNull(actualDoOperationResult);
  }
}
