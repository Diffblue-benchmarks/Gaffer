package uk.gov.gchq.gaffer.store.operation.handler.named;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.named.operation.GetAllNamedOperations;
import uk.gov.gchq.gaffer.named.operation.NamedOperationDetail;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedOperationCache;
import uk.gov.gchq.gaffer.user.User;
import uk.gov.gchq.koryphe.iterable.MappedIterable;
import uk.gov.gchq.koryphe.iterable.MappedIterator;

class GetAllNamedOperationsHandlerDiffblueTest {
  /**
   * Test {@link GetAllNamedOperationsHandler#GetAllNamedOperationsHandler(NamedOperationCache)}.
   *
   * <p>Method under test: {@link
   * GetAllNamedOperationsHandler#GetAllNamedOperationsHandler(NamedOperationCache)}
   */
  @Test
  @DisplayName("Test new GetAllNamedOperationsHandler(NamedOperationCache)")
  @Tag("MaintainedByDiffblue")
  void testNewGetAllNamedOperationsHandler() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named operation cache name",
        new GetAllNamedOperationsHandler(
                new NamedOperationCache("Suffix Named Operation Cache Name"))
            .getSuffixCacheName());
  }

  /**
   * Test {@link GetAllNamedOperationsHandler#GetAllNamedOperationsHandler(String)}.
   *
   * <p>Method under test: {@link GetAllNamedOperationsHandler#GetAllNamedOperationsHandler(String)}
   */
  @Test
  @DisplayName("Test new GetAllNamedOperationsHandler(String)")
  @Tag("MaintainedByDiffblue")
  void testNewGetAllNamedOperationsHandler2() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named operation cache name",
        new GetAllNamedOperationsHandler("Suffix Named Operation Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link GetAllNamedOperationsHandler#GetAllNamedOperationsHandler(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return SuffixCacheName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllNamedOperationsHandler#GetAllNamedOperationsHandler(String)}
   */
  @Test
  @DisplayName(
      "Test new GetAllNamedOperationsHandler(String); when 'null'; then return SuffixCacheName is 'null'")
  @Tag("MaintainedByDiffblue")
  void testNewGetAllNamedOperationsHandler_whenNull_thenReturnSuffixCacheNameIsNull() {
    // Arrange, Act and Assert
    assertNull(new GetAllNamedOperationsHandler((String) null).getSuffixCacheName());
  }

  /**
   * Test {@link GetAllNamedOperationsHandler#getSuffixCacheName()}.
   *
   * <ul>
   *   <li>Then return {@code suffix named operation cache name}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllNamedOperationsHandler#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); then return 'suffix named operation cache name'")
  @Tag("MaintainedByDiffblue")
  void testGetSuffixCacheName_thenReturnSuffixNamedOperationCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named operation cache name",
        new GetAllNamedOperationsHandler("Suffix Named Operation Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link GetAllNamedOperationsHandler#doOperation(GetAllNamedOperations, Context, Store)}
   * with {@code GetAllNamedOperations}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return {@link MappedIterable}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllNamedOperationsHandler#doOperation(GetAllNamedOperations,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetAllNamedOperations, Context, Store) with 'GetAllNamedOperations', 'Context', 'Store'; then return MappedIterable")
  @Tag("MaintainedByDiffblue")
  void testDoOperationWithGetAllNamedOperationsContextStore_thenReturnMappedIterable()
      throws OperationException {
    // Arrange
    NamedOperationCache cache = mock(NamedOperationCache.class);
    when(cache.getAllNamedOperations(Mockito.<User>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    GetAllNamedOperationsHandler getAllNamedOperationsHandler =
        new GetAllNamedOperationsHandler(cache);
    GetAllNamedOperations operation = new GetAllNamedOperations();
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Iterable<NamedOperationDetail> actualDoOperationResult =
        getAllNamedOperationsHandler.doOperation(operation, context, store);
    Iterator<NamedOperationDetail> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(store).getProperties();
    verify(cache).getAllNamedOperations(isA(User.class), eq(""));
    assertTrue(actualDoOperationResult instanceof MappedIterable);
    Iterator<NamedOperationDetail> iteratorResult = actualDoOperationResult.iterator();
    assertTrue(iteratorResult instanceof MappedIterator);
    assertTrue(actualIteratorResult instanceof MappedIterator);
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualIteratorResult.hasNext());
  }
}
