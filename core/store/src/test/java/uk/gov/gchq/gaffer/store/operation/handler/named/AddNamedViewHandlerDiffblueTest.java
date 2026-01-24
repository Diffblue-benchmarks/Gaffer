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
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.view.AddNamedView;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.TestAddToGraphLibraryImpl;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedViewCache;

class AddNamedViewHandlerDiffblueTest {
  /**
   * Test {@link AddNamedViewHandler#AddNamedViewHandler(NamedViewCache)}.
   *
   * <p>Method under test: {@link AddNamedViewHandler#AddNamedViewHandler(NamedViewCache)}
   */
  @Test
  @DisplayName("Test new AddNamedViewHandler(NamedViewCache)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedViewHandler.<init>(NamedViewCache)"})
  void testNewAddNamedViewHandler() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new AddNamedViewHandler(new NamedViewCache("Suffix Named View Cache Name"))
            .getSuffixCacheName());
  }

  /**
   * Test {@link AddNamedViewHandler#AddNamedViewHandler(String)}.
   *
   * <p>Method under test: {@link AddNamedViewHandler#AddNamedViewHandler(String)}
   */
  @Test
  @DisplayName("Test new AddNamedViewHandler(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedViewHandler.<init>(String)"})
  void testNewAddNamedViewHandler2() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new AddNamedViewHandler("Suffix Named View Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link AddNamedViewHandler#getSuffixCacheName()}.
   *
   * <ul>
   *   <li>Then return {@code suffix named view cache name}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedViewHandler#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); then return 'suffix named view cache name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AddNamedViewHandler.getSuffixCacheName()"})
  void testGetSuffixCacheName_thenReturnSuffixNamedViewCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new AddNamedViewHandler("Suffix Named View Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link AddNamedViewHandler#doOperation(AddNamedView, Context, Store)} with {@code
   * AddNamedView}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedViewHandler#doOperation(AddNamedView, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddNamedView, Context, Store) with 'AddNamedView', 'Context', 'Store'; given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object AddNamedViewHandler.doOperation(AddNamedView, Context, Store)"
  })
  void testDoOperationWithAddNamedViewContextStore_givenEmptyString() throws OperationException {
    // Arrange
    AddNamedViewHandler addNamedViewHandler =
        new AddNamedViewHandler("Suffix Named View Cache Name");

    AddNamedView operation = new AddNamedView();
    operation.setName("");
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> addNamedViewHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }

  /**
   * Test {@link AddNamedViewHandler#doOperation(AddNamedView, Context, Store)} with {@code
   * AddNamedView}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>When {@link AddNamedView} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AddNamedViewHandler#doOperation(AddNamedView, Context, Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(AddNamedView, Context, Store) with 'AddNamedView', 'Context', 'Store'; when AddNamedView (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Object AddNamedViewHandler.doOperation(AddNamedView, Context, Store)"
  })
  void testDoOperationWithAddNamedViewContextStore_whenAddNamedView() throws OperationException {
    // Arrange
    AddNamedViewHandler addNamedViewHandler =
        new AddNamedViewHandler("Suffix Named View Cache Name");
    AddNamedView operation = new AddNamedView();
    Context context = new Context();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> addNamedViewHandler.doOperation(operation, context, new TestAddToGraphLibraryImpl()));
  }
}
