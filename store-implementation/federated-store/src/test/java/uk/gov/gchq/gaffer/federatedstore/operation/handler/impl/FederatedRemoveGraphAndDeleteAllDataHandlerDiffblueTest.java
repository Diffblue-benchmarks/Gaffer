package uk.gov.gchq.gaffer.federatedstore.operation.handler.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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

class FederatedRemoveGraphAndDeleteAllDataHandlerDiffblueTest {
  /**
   * Test {@link FederatedRemoveGraphAndDeleteAllDataHandler#doOperation(RemoveGraph, Context,
   * Store)} with {@code RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link
   * FederatedRemoveGraphAndDeleteAllDataHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean FederatedRemoveGraphAndDeleteAllDataHandler.doOperation(RemoveGraph, Context, Store)"
  })
  void testDoOperationWithRemoveGraphContextStore() throws OperationException {
    // Arrange
    FederatedRemoveGraphAndDeleteAllDataHandler federatedRemoveGraphAndDeleteAllDataHandler =
        new FederatedRemoveGraphAndDeleteAllDataHandler();

    RemoveGraph operation = mock(RemoveGraph.class);
    doNothing().when(operation).addOption(Mockito.<String>any(), Mockito.<String>any());
    when(operation.getGraphId()).thenReturn("42");
    operation.addOption("FederatedStore.processed.", "42");

    Context context = mock(Context.class);
    when(context.getUser()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            federatedRemoveGraphAndDeleteAllDataHandler.doOperation(
                operation, context, mock(FederatedStore.class)));
    verify(operation).getGraphId();
    verify(operation).addOption("FederatedStore.processed.", "42");
    verify(context).getUser();
  }

  /**
   * Test {@link FederatedRemoveGraphAndDeleteAllDataHandler#doOperation(RemoveGraph, Context,
   * Store)} with {@code RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedRemoveGraphAndDeleteAllDataHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; given ArrayList(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean FederatedRemoveGraphAndDeleteAllDataHandler.doOperation(RemoveGraph, Context, Store)"
  })
  void testDoOperationWithRemoveGraphContextStore_givenArrayList_thenReturnTrue()
      throws OperationException {
    // Arrange
    FederatedRemoveGraphAndDeleteAllDataHandler federatedRemoveGraphAndDeleteAllDataHandler =
        new FederatedRemoveGraphAndDeleteAllDataHandler();

    RemoveGraph operation = mock(RemoveGraph.class);
    when(operation.isRemoveCache()).thenReturn(true);
    when(operation.isUserRequestingAdminUsage()).thenReturn(true);
    doNothing().when(operation).addOption(Mockito.<String>any(), Mockito.<String>any());
    when(operation.getGraphId()).thenReturn("42");
    operation.addOption("FederatedStore.processed.", "42");
    Context context = FederatedStoreTestUtil.contextAuthUser();

    FederatedStore store = mock(FederatedStore.class);
    when(store.remove(Mockito.<String>any(), Mockito.<User>any(), anyBoolean(), anyBoolean()))
        .thenReturn(true);
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Boolean actualDoOperationResult =
        federatedRemoveGraphAndDeleteAllDataHandler.doOperation(operation, context, store);

    // Assert
    verify(store, atLeast(1))
        .getGraphs(
            isA(User.class), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any());
    verify(store).remove(eq("42"), isA(User.class), eq(true), eq(true));
    verify(operation, atLeast(1)).getGraphId();
    verify(operation).isRemoveCache();
    verify(operation).isUserRequestingAdminUsage();
    verify(operation).addOption("FederatedStore.processed.", "42");
    assertTrue(actualDoOperationResult);
  }

  /**
   * Test {@link FederatedRemoveGraphAndDeleteAllDataHandler#doOperation(RemoveGraph, Context,
   * Store)} with {@code RemoveGraph}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link User.Builder} (default constructor) userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * FederatedRemoveGraphAndDeleteAllDataHandler#doOperation(RemoveGraph, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(RemoveGraph, Context, Store) with 'RemoveGraph', 'Context', 'Store'; given Builder (default constructor) userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean FederatedRemoveGraphAndDeleteAllDataHandler.doOperation(RemoveGraph, Context, Store)"
  })
  void testDoOperationWithRemoveGraphContextStore_givenBuilderUserId42Build()
      throws OperationException {
    // Arrange
    FederatedRemoveGraphAndDeleteAllDataHandler federatedRemoveGraphAndDeleteAllDataHandler =
        new FederatedRemoveGraphAndDeleteAllDataHandler();

    RemoveGraph operation = mock(RemoveGraph.class);
    doNothing().when(operation).addOption(Mockito.<String>any(), Mockito.<String>any());
    when(operation.getGraphId()).thenReturn("42");
    operation.addOption("FederatedStore.processed.", "42");

    Context context = mock(Context.class);
    when(context.getUser()).thenReturn(new Builder().userId("42").build());

    FederatedStore store = mock(FederatedStore.class);
    when(store.getGraphs(
            Mockito.<User>any(), Mockito.<List<String>>any(), Mockito.<IFederationOperation>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> federatedRemoveGraphAndDeleteAllDataHandler.doOperation(operation, context, store));
    verify(store).getGraphs(isA(User.class), isA(List.class), isA(IFederationOperation.class));
    verify(operation, atLeast(1)).getGraphId();
    verify(operation).addOption("FederatedStore.processed.", "42");
    verify(context).getUser();
  }
}
