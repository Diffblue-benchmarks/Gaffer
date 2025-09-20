package uk.gov.gchq.gaffer.store.operation.handler.named;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;
import uk.gov.gchq.gaffer.named.view.DeleteNamedView;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedViewCache;
import uk.gov.gchq.gaffer.user.User;

class DeleteNamedViewHandlerDiffblueTest {
  /**
   * Test {@link DeleteNamedViewHandler#DeleteNamedViewHandler(NamedViewCache)}.
   *
   * <p>Method under test: {@link DeleteNamedViewHandler#DeleteNamedViewHandler(NamedViewCache)}
   */
  @Test
  @DisplayName("Test new DeleteNamedViewHandler(NamedViewCache)")
  @Tag("MaintainedByDiffblue")
  void testNewDeleteNamedViewHandler() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new DeleteNamedViewHandler(new NamedViewCache("Suffix Named View Cache Name"))
            .getSuffixCacheName());
  }

  /**
   * Test {@link DeleteNamedViewHandler#DeleteNamedViewHandler(String)}.
   *
   * <p>Method under test: {@link DeleteNamedViewHandler#DeleteNamedViewHandler(String)}
   */
  @Test
  @DisplayName("Test new DeleteNamedViewHandler(String)")
  @Tag("MaintainedByDiffblue")
  void testNewDeleteNamedViewHandler2() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new DeleteNamedViewHandler("Suffix Named View Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link DeleteNamedViewHandler#getSuffixCacheName()}.
   *
   * <ul>
   *   <li>Then return {@code suffix named view cache name}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteNamedViewHandler#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); then return 'suffix named view cache name'")
  @Tag("MaintainedByDiffblue")
  void testGetSuffixCacheName_thenReturnSuffixNamedViewCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new DeleteNamedViewHandler("Suffix Named View Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link DeleteNamedViewHandler#doOperation(DeleteNamedView, Context, Store)} with {@code
   * DeleteNamedView}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteNamedViewHandler#doOperation(DeleteNamedView, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteNamedView, Context, Store) with 'DeleteNamedView', 'Context', 'Store'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithDeleteNamedViewContextStore_thenReturnNull()
      throws CacheOperationException, OperationException {
    // Arrange
    NamedViewCache cache = mock(NamedViewCache.class);
    doNothing()
        .when(cache)
        .deleteNamedView(Mockito.<String>any(), Mockito.<User>any(), Mockito.<String>any());
    DeleteNamedViewHandler deleteNamedViewHandler = new DeleteNamedViewHandler(cache);
    DeleteNamedView namedViewOp = new DeleteNamedView();
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Void actualDoOperationResult = deleteNamedViewHandler.doOperation(namedViewOp, context, store);

    // Assert
    verify(store).getProperties();
    verify(cache).deleteNamedView(isNull(), isA(User.class), eq(""));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link DeleteNamedViewHandler#doOperation(DeleteNamedView, Context, Store)} with {@code
   * DeleteNamedView}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteNamedViewHandler#doOperation(DeleteNamedView, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteNamedView, Context, Store) with 'DeleteNamedView', 'Context', 'Store'; then throw OperationException")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithDeleteNamedViewContextStore_thenThrowOperationException()
      throws CacheOperationException, OperationException {
    // Arrange
    NamedViewCache cache = mock(NamedViewCache.class);
    doThrow(new CacheOperationException())
        .when(cache)
        .deleteNamedView(Mockito.<String>any(), Mockito.<User>any(), Mockito.<String>any());
    DeleteNamedViewHandler deleteNamedViewHandler = new DeleteNamedViewHandler(cache);
    DeleteNamedView namedViewOp = new DeleteNamedView();
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> deleteNamedViewHandler.doOperation(namedViewOp, context, store));
    verify(store).getProperties();
    verify(cache).deleteNamedView(isNull(), isA(User.class), eq(""));
  }
}
