/*
 * Copyright 2026 Crown Copyright
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;
import uk.gov.gchq.gaffer.named.operation.DeleteNamedOperation;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedOperationCache;
import uk.gov.gchq.gaffer.user.User;

class DeleteNamedOperationHandlerDiffblueTest {
  /**
   * Test {@link DeleteNamedOperationHandler#DeleteNamedOperationHandler(NamedOperationCache)}.
   *
   * <p>Method under test: {@link
   * DeleteNamedOperationHandler#DeleteNamedOperationHandler(NamedOperationCache)}
   */
  @Test
  @DisplayName("Test new DeleteNamedOperationHandler(NamedOperationCache)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeleteNamedOperationHandler.<init>(NamedOperationCache)"})
  void testNewDeleteNamedOperationHandler() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named operation cache name",
        new DeleteNamedOperationHandler(
                new NamedOperationCache("Suffix Named Operation Cache Name"))
            .getSuffixCacheName());
  }

  /**
   * Test {@link DeleteNamedOperationHandler#DeleteNamedOperationHandler(String)}.
   *
   * <p>Method under test: {@link DeleteNamedOperationHandler#DeleteNamedOperationHandler(String)}
   */
  @Test
  @DisplayName("Test new DeleteNamedOperationHandler(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeleteNamedOperationHandler.<init>(String)"})
  void testNewDeleteNamedOperationHandler2() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named operation cache name",
        new DeleteNamedOperationHandler("Suffix Named Operation Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link DeleteNamedOperationHandler#DeleteNamedOperationHandler(String)}.
   *
   * <ul>
   *   <li>Then return SuffixCacheName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeleteNamedOperationHandler#DeleteNamedOperationHandler(String)}
   */
  @Test
  @DisplayName(
      "Test new DeleteNamedOperationHandler(String); then return SuffixCacheName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeleteNamedOperationHandler.<init>(String)"})
  void testNewDeleteNamedOperationHandler_thenReturnSuffixCacheNameIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new DeleteNamedOperationHandler("").getSuffixCacheName());
  }

  /**
   * Test {@link DeleteNamedOperationHandler#DeleteNamedOperationHandler(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return SuffixCacheName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteNamedOperationHandler#DeleteNamedOperationHandler(String)}
   */
  @Test
  @DisplayName(
      "Test new DeleteNamedOperationHandler(String); when 'null'; then return SuffixCacheName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeleteNamedOperationHandler.<init>(String)"})
  void testNewDeleteNamedOperationHandler_whenNull_thenReturnSuffixCacheNameIsNull() {
    // Arrange, Act and Assert
    assertNull(new DeleteNamedOperationHandler((String) null).getSuffixCacheName());
  }

  /**
   * Test {@link DeleteNamedOperationHandler#getSuffixCacheName()}.
   *
   * <ul>
   *   <li>Then return {@code suffix named operation cache name}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteNamedOperationHandler#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); then return 'suffix named operation cache name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DeleteNamedOperationHandler.getSuffixCacheName()"})
  void testGetSuffixCacheName_thenReturnSuffixNamedOperationCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named operation cache name",
        new DeleteNamedOperationHandler("Suffix Named Operation Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link DeleteNamedOperationHandler#doOperation(DeleteNamedOperation, Context, Store)} with
   * {@code DeleteNamedOperation}, {@code Context}, {@code Store}.
   *
   * <p>Method under test: {@link DeleteNamedOperationHandler#doOperation(DeleteNamedOperation,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteNamedOperation, Context, Store) with 'DeleteNamedOperation', 'Context', 'Store'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Void DeleteNamedOperationHandler.doOperation(DeleteNamedOperation, Context, Store)"
  })
  void testDoOperationWithDeleteNamedOperationContextStore()
      throws CacheOperationException, OperationException {
    // Arrange
    NamedOperationCache cache = mock(NamedOperationCache.class);
    doThrow(new CacheOperationException())
        .when(cache)
        .deleteNamedOperation(Mockito.<String>any(), Mockito.<User>any(), Mockito.<String>any());
    DeleteNamedOperationHandler deleteNamedOperationHandler =
        new DeleteNamedOperationHandler(cache);
    DeleteNamedOperation operation = new DeleteNamedOperation();
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> deleteNamedOperationHandler.doOperation(operation, context, store));
    verify(store).getProperties();
    verify(cache).deleteNamedOperation(isNull(), isA(User.class), eq(""));
  }

  /**
   * Test {@link DeleteNamedOperationHandler#doOperation(DeleteNamedOperation, Context, Store)} with
   * {@code DeleteNamedOperation}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteNamedOperationHandler#doOperation(DeleteNamedOperation,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteNamedOperation, Context, Store) with 'DeleteNamedOperation', 'Context', 'Store'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Void DeleteNamedOperationHandler.doOperation(DeleteNamedOperation, Context, Store)"
  })
  void testDoOperationWithDeleteNamedOperationContextStore_thenReturnNull()
      throws CacheOperationException, OperationException {
    // Arrange
    NamedOperationCache cache = mock(NamedOperationCache.class);
    doNothing()
        .when(cache)
        .deleteNamedOperation(Mockito.<String>any(), Mockito.<User>any(), Mockito.<String>any());
    DeleteNamedOperationHandler deleteNamedOperationHandler =
        new DeleteNamedOperationHandler(cache);
    DeleteNamedOperation operation = new DeleteNamedOperation();
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Void actualDoOperationResult =
        deleteNamedOperationHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getProperties();
    verify(cache).deleteNamedOperation(isNull(), isA(User.class), eq(""));
    assertNull(actualDoOperationResult);
  }

  /**
   * Test {@link DeleteNamedOperationHandler#doOperation(DeleteNamedOperation, Context, Store)} with
   * {@code DeleteNamedOperation}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then throw {@link OperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteNamedOperationHandler#doOperation(DeleteNamedOperation,
   * Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(DeleteNamedOperation, Context, Store) with 'DeleteNamedOperation', 'Context', 'Store'; then throw OperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Void DeleteNamedOperationHandler.doOperation(DeleteNamedOperation, Context, Store)"
  })
  void testDoOperationWithDeleteNamedOperationContextStore_thenThrowOperationException()
      throws OperationException {
    // Arrange
    DeleteNamedOperationHandler deleteNamedOperationHandler =
        new DeleteNamedOperationHandler("Suffix Named Operation Cache Name");
    DeleteNamedOperation operation = new DeleteNamedOperation();
    Context context = new Context();

    TestAddToGraphLibraryImpl store = mock(TestAddToGraphLibraryImpl.class);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> deleteNamedOperationHandler.doOperation(operation, context, store));
    verify(store).getProperties();
  }
}
