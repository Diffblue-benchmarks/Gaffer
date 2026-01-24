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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedViewDetail;
import uk.gov.gchq.gaffer.named.view.GetAllNamedViews;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedViewCache;
import uk.gov.gchq.gaffer.user.User;

class GetAllNamedViewsHandlerDiffblueTest {
  /**
   * Test {@link GetAllNamedViewsHandler#GetAllNamedViewsHandler(NamedViewCache)}.
   *
   * <p>Method under test: {@link GetAllNamedViewsHandler#GetAllNamedViewsHandler(NamedViewCache)}
   */
  @Test
  @DisplayName("Test new GetAllNamedViewsHandler(NamedViewCache)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetAllNamedViewsHandler.<init>(NamedViewCache)"})
  void testNewGetAllNamedViewsHandler() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new GetAllNamedViewsHandler(new NamedViewCache("Suffix Named View Cache Name"))
            .getSuffixCacheName());
  }

  /**
   * Test {@link GetAllNamedViewsHandler#GetAllNamedViewsHandler(String)}.
   *
   * <p>Method under test: {@link GetAllNamedViewsHandler#GetAllNamedViewsHandler(String)}
   */
  @Test
  @DisplayName("Test new GetAllNamedViewsHandler(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GetAllNamedViewsHandler.<init>(String)"})
  void testNewGetAllNamedViewsHandler2() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new GetAllNamedViewsHandler("Suffix Named View Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link GetAllNamedViewsHandler#getSuffixCacheName()}.
   *
   * <ul>
   *   <li>Then return {@code suffix named view cache name}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllNamedViewsHandler#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); then return 'suffix named view cache name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GetAllNamedViewsHandler.getSuffixCacheName()"})
  void testGetSuffixCacheName_thenReturnSuffixNamedViewCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new GetAllNamedViewsHandler("Suffix Named View Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link GetAllNamedViewsHandler#doOperation(GetAllNamedViews, Context, Store)} with {@code
   * GetAllNamedViews}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link GetAllNamedViewsHandler#doOperation(GetAllNamedViews, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetAllNamedViews, Context, Store) with 'GetAllNamedViews', 'Context', 'Store'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Iterable GetAllNamedViewsHandler.doOperation(GetAllNamedViews, Context, Store)"
  })
  void testDoOperationWithGetAllNamedViewsContextStore_thenReturnList()
      throws CacheOperationException, OperationException {
    // Arrange
    NamedViewCache cache = mock(NamedViewCache.class);
    when(cache.getAllNamedViews(Mockito.<User>any())).thenReturn(new ArrayList<>());
    GetAllNamedViewsHandler getAllNamedViewsHandler = new GetAllNamedViewsHandler(cache);
    GetAllNamedViews operation = new GetAllNamedViews();
    Context context = new Context();

    // Act
    Iterable<NamedViewDetail> actualDoOperationResult =
        getAllNamedViewsHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl());
    Iterator<NamedViewDetail> actualIteratorResult = actualDoOperationResult.iterator();

    // Assert
    verify(cache).getAllNamedViews(isA(User.class));
    assertTrue(actualDoOperationResult instanceof List);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((List<NamedViewDetail>) actualDoOperationResult).isEmpty());
  }
}
