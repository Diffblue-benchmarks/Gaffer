package uk.gov.gchq.gaffer.federatedstore.operation.handler.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
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
import uk.gov.gchq.gaffer.federatedstore.operation.IFederationOperation;
import uk.gov.gchq.gaffer.federatedstore.operation.RemoveGraph;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class FederatedRemoveGraphHandlerDiffblueTest {
  /**
   * Test {@link FederatedRemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code
   * RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link FederatedRemoveGraphHandler#doOperation(RemoveGraph, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean FederatedRemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"
  })
  void testDoOperationWithRemoveGraphContextStore() throws OperationException {
    // Arrange
    FederatedRemoveGraphHandler federatedRemoveGraphHandler = new FederatedRemoveGraphHandler();
    RemoveGraph operation = new RemoveGraph();

    Context context = mock(Context.class);
    when(context.getUser()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            federatedRemoveGraphHandler.doOperation(
                operation, context, mock(FederatedStore.class)));
    verify(context).getUser();
  }

  /**
   * Test {@link FederatedRemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code
   * RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedRemoveGraphHandler#doOperation(RemoveGraph, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; given 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean FederatedRemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"
  })
  void testDoOperationWithRemoveGraphContextStore_givenTrue_thenReturnTrue()
      throws OperationException {
    // Arrange
    FederatedRemoveGraphHandler federatedRemoveGraphHandler = new FederatedRemoveGraphHandler();
    RemoveGraph operation = new RemoveGraph();
    Context context = FederatedStoreTestUtil.contextAuthUser();

    FederatedStore store = mock(FederatedStore.class);
    when(store.remove(Mockito.<String>any(), Mockito.<User>any(), anyBoolean(), anyBoolean()))
        .thenReturn(true);
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Boolean actualDoOperationResult =
        federatedRemoveGraphHandler.doOperation(operation, context, store);

    // Assert
    verify(store, atLeast(1))
        .getGraphs(isA(User.class), isNull(), Mockito.<IFederationOperation>any());
    verify(store).remove(isNull(), isA(User.class), eq(true), eq(false));
    assertTrue(actualDoOperationResult);
  }

  /**
   * Test {@link FederatedRemoveGraphHandler#doOperation(RemoveGraph, Context, Store)} with {@code
   * RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedRemoveGraphHandler#doOperation(RemoveGraph, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean FederatedRemoveGraphHandler.doOperation(RemoveGraph, Context, Store)"
  })
  void testDoOperationWithRemoveGraphContextStore_thenThrowRuntimeException()
      throws OperationException {
    // Arrange
    FederatedRemoveGraphHandler federatedRemoveGraphHandler = new FederatedRemoveGraphHandler();
    RemoveGraph operation = new RemoveGraph();

    Context context = mock(Context.class);
    when(context.getUser()).thenReturn(new Builder().userId("42").build());

    FederatedStore store = mock(FederatedStore.class);
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> federatedRemoveGraphHandler.doOperation(operation, context, store));
    verify(store).getGraphs(isA(User.class), isNull(), isA(IFederationOperation.class));
    verify(context).getUser();
  }
}
