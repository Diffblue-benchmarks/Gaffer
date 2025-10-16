package uk.gov.gchq.gaffer.federatedstore.operation.handler.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.federatedstore.operation.GetAllGraphIds;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class FederatedGetAllGraphIDHandlerDiffblueTest {
  /**
   * Test {@link FederatedGetAllGraphIDHandler#doOperation(GetAllGraphIds, Context, Store)} with
   * {@code GetAllGraphIds}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGetAllGraphIDHandler#doOperation(GetAllGraphIds, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetAllGraphIds, Context, Store) with 'GetAllGraphIds', 'Context', 'Store'; given ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Iterable FederatedGetAllGraphIDHandler.doOperation(GetAllGraphIds, Context, Store)"
  })
  void testDoOperationWithGetAllGraphIdsContextStore_givenArrayList_thenReturnList()
      throws OperationException {
    // Arrange
    FederatedGetAllGraphIDHandler federatedGetAllGraphIDHandler =
        new FederatedGetAllGraphIDHandler();

    GetAllGraphIds operation = mock(GetAllGraphIds.class);
    when(operation.isUserRequestingAdminUsage()).thenReturn(true);

    Context context = mock(Context.class);
    when(context.getUser()).thenReturn(new Builder().userId("42").build());

    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphIds(Mockito.<User>any(), anyBoolean())).thenReturn(new ArrayList<>());

    // Act
    Iterable<? extends String> actualDoOperationResult =
        federatedGetAllGraphIDHandler.doOperation(operation, context, store);
    Iterator<? extends String> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(store).getAllGraphIds(isA(User.class), eq(true));
    verify(operation).isUserRequestingAdminUsage();
    verify(context).getUser();
    assertTrue(actualDoOperationResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<? extends String>) actualDoOperationResult).isEmpty());
  }
}
