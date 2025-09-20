package uk.gov.gchq.gaffer.federatedstore.operation.handler.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.federatedstore.FederatedStoreTestUtil;
import uk.gov.gchq.gaffer.federatedstore.operation.GetAllGraphInfo;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class FederatedGetAllGraphInfoHandlerDiffblueTest {
  /**
   * Test {@link FederatedGetAllGraphInfoHandler#doOperation(GetAllGraphInfo, Context, Store)} with
   * {@code GetAllGraphInfo}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link FederatedGetAllGraphInfoHandler#doOperation(GetAllGraphInfo,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetAllGraphInfo, Context, Store) with 'GetAllGraphInfo', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FederatedGetAllGraphInfoHandler.doOperation(GetAllGraphInfo, Context, Store)"
  })
  void testDoOperationWithGetAllGraphInfoContextStore() throws OperationException {
    // Arrange
    FederatedGetAllGraphInfoHandler federatedGetAllGraphInfoHandler =
        new FederatedGetAllGraphInfoHandler();
    GetAllGraphInfo operation = new GetAllGraphInfo();

    Context context = mock(Context.class);
    when(context.getUser()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            federatedGetAllGraphInfoHandler.doOperation(
                operation, context, mock(FederatedStore.class)));
    verify(context).getUser();
  }

  /**
   * Test {@link FederatedGetAllGraphInfoHandler#doOperation(GetAllGraphInfo, Context, Store)} with
   * {@code GetAllGraphInfo}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link User.Builder} (default constructor) userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGetAllGraphInfoHandler#doOperation(GetAllGraphInfo,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetAllGraphInfo, Context, Store) with 'GetAllGraphInfo', 'Context', 'Store'; given Builder (default constructor) userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FederatedGetAllGraphInfoHandler.doOperation(GetAllGraphInfo, Context, Store)"
  })
  void testDoOperationWithGetAllGraphInfoContextStore_givenBuilderUserId42Build()
      throws OperationException {
    // Arrange
    FederatedGetAllGraphInfoHandler federatedGetAllGraphInfoHandler =
        new FederatedGetAllGraphInfoHandler();
    GetAllGraphInfo operation = new GetAllGraphInfo();

    Context context = mock(Context.class);
    when(context.getUser()).thenReturn(new Builder().userId("42").build());

    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphsAndAuths(Mockito.<User>any(), Mockito.<List<String>>any(), anyBoolean()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> federatedGetAllGraphInfoHandler.doOperation(operation, context, store));
    verify(store).getAllGraphsAndAuths(isA(User.class), isNull(), eq(false));
    verify(context).getUser();
  }

  /**
   * Test {@link FederatedGetAllGraphInfoHandler#doOperation(GetAllGraphInfo, Context, Store)} with
   * {@code GetAllGraphInfo}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGetAllGraphInfoHandler#doOperation(GetAllGraphInfo,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetAllGraphInfo, Context, Store) with 'GetAllGraphInfo', 'Context', 'Store'; given HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FederatedGetAllGraphInfoHandler.doOperation(GetAllGraphInfo, Context, Store)"
  })
  void testDoOperationWithGetAllGraphInfoContextStore_givenHashMap_thenReturnEmpty()
      throws OperationException {
    // Arrange
    FederatedGetAllGraphInfoHandler federatedGetAllGraphInfoHandler =
        new FederatedGetAllGraphInfoHandler();
    GetAllGraphInfo operation = new GetAllGraphInfo();
    Context context = FederatedStoreTestUtil.contextAuthUser();

    FederatedStore store = mock(FederatedStore.class);
    when(store.getAllGraphsAndAuths(Mockito.<User>any(), Mockito.<List<String>>any(), anyBoolean()))
        .thenReturn(new HashMap<>());

    // Act
    Map<String, Object> actualDoOperationResult =
        federatedGetAllGraphInfoHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getAllGraphsAndAuths(isA(User.class), isNull(), eq(false));
    assertTrue(actualDoOperationResult.isEmpty());
  }
}
