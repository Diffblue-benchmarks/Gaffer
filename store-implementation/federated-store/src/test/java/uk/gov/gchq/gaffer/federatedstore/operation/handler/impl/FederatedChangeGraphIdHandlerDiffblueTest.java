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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.federatedstore.FederatedStore;
import uk.gov.gchq.gaffer.federatedstore.FederatedStoreTestUtil;
import uk.gov.gchq.gaffer.federatedstore.exception.StorageException;
import uk.gov.gchq.gaffer.federatedstore.operation.ChangeGraphId;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.gaffer.user.User.Builder;

class FederatedChangeGraphIdHandlerDiffblueTest {
  /**
   * Test {@link FederatedChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with
   * {@code ChangeGraphId}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link FederatedChangeGraphIdHandler#doOperation(ChangeGraphId, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean FederatedChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"
  })
  void testDoOperationWithChangeGraphIdContextStore() throws OperationException {
    // Arrange
    FederatedChangeGraphIdHandler federatedChangeGraphIdHandler =
        new FederatedChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();

    Context context = mock(Context.class);
    when(context.getUser()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () ->
            federatedChangeGraphIdHandler.doOperation(
                operation, context, mock(FederatedStore.class)));
    verify(context).getUser();
  }

  /**
   * Test {@link FederatedChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with
   * {@code ChangeGraphId}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link User.Builder} (default constructor) userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link FederatedChangeGraphIdHandler#doOperation(ChangeGraphId, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'; given Builder (default constructor) userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean FederatedChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"
  })
  void testDoOperationWithChangeGraphIdContextStore_givenBuilderUserId42Build()
      throws StorageException, OperationException {
    // Arrange
    FederatedChangeGraphIdHandler federatedChangeGraphIdHandler =
        new FederatedChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();

    Context context = mock(Context.class);
    when(context.getUser()).thenReturn(new Builder().userId("42").build());

    FederatedStore store = mock(FederatedStore.class);
    when(store.changeGraphId(
            Mockito.<User>any(), Mockito.<String>any(), Mockito.<String>any(), anyBoolean()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> federatedChangeGraphIdHandler.doOperation(operation, context, store));
    verify(store).changeGraphId(isA(User.class), isNull(), isNull(), eq(false));
    verify(context).getUser();
  }

  /**
   * Test {@link FederatedChangeGraphIdHandler#doOperation(ChangeGraphId, Context, Store)} with
   * {@code ChangeGraphId}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedChangeGraphIdHandler#doOperation(ChangeGraphId, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(ChangeGraphId, Context, Store) with 'ChangeGraphId', 'Context', 'Store'; given 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean FederatedChangeGraphIdHandler.doOperation(ChangeGraphId, Context, Store)"
  })
  void testDoOperationWithChangeGraphIdContextStore_givenTrue_thenReturnTrue()
      throws StorageException, OperationException {
    // Arrange
    FederatedChangeGraphIdHandler federatedChangeGraphIdHandler =
        new FederatedChangeGraphIdHandler();
    ChangeGraphId operation = new ChangeGraphId();
    Context context = FederatedStoreTestUtil.contextAuthUser();

    FederatedStore store = mock(FederatedStore.class);
    when(store.changeGraphId(
            Mockito.<User>any(), Mockito.<String>any(), Mockito.<String>any(), anyBoolean()))
        .thenReturn(true);

    // Act
    Boolean actualDoOperationResult =
        federatedChangeGraphIdHandler.doOperation(operation, context, store);

    // Assert
    verify(store).changeGraphId(isA(User.class), isNull(), isNull(), eq(false));
    assertTrue(actualDoOperationResult);
  }
}
