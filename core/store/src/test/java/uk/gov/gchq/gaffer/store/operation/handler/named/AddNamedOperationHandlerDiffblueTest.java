/*
 * Copyright 2025 Crown Copyright
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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedOperationCache;

class AddNamedOperationHandlerDiffblueTest {
  /**
   * Test {@link AddNamedOperationHandler#AddNamedOperationHandler(String, Boolean)}.
   *
   * <p>Method under test: {@link AddNamedOperationHandler#AddNamedOperationHandler(String,
   * Boolean)}
   */
  @Test
  @DisplayName("Test new AddNamedOperationHandler(String, Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedOperationHandler.<init>(String, Boolean)"})
  void testNewAddNamedOperationHandler() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler =
        new AddNamedOperationHandler("Suffix Named Operation Cache Name", true);

    // Assert
    assertEquals(
        "suffix named operation cache name", actualAddNamedOperationHandler.getSuffixCacheName());
    assertTrue(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#AddNamedOperationHandler(String, Boolean)}.
   *
   * <ul>
   *   <li>Then return not NestedNamedOperationsAllowed.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperationHandler#AddNamedOperationHandler(String,
   * Boolean)}
   */
  @Test
  @DisplayName(
      "Test new AddNamedOperationHandler(String, Boolean); then return not NestedNamedOperationsAllowed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedOperationHandler.<init>(String, Boolean)"})
  void testNewAddNamedOperationHandler_thenReturnNotNestedNamedOperationsAllowed() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler =
        new AddNamedOperationHandler("Suffix Named Operation Cache Name", false);

    // Assert
    assertEquals(
        "suffix named operation cache name", actualAddNamedOperationHandler.getSuffixCacheName());
    assertFalse(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#AddNamedOperationHandler(NamedOperationCache, Boolean)}.
   *
   * <ul>
   *   <li>Then return not NestedNamedOperationsAllowed.
   * </ul>
   *
   * <p>Method under test: {@link
   * AddNamedOperationHandler#AddNamedOperationHandler(NamedOperationCache, Boolean)}
   */
  @Test
  @DisplayName(
      "Test new AddNamedOperationHandler(NamedOperationCache, Boolean); then return not NestedNamedOperationsAllowed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedOperationHandler.<init>(NamedOperationCache, Boolean)"})
  void testNewAddNamedOperationHandler_thenReturnNotNestedNamedOperationsAllowed2() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler =
        new AddNamedOperationHandler(
            new NamedOperationCache("Suffix Named Operation Cache Name"), false);

    // Assert
    assertEquals(
        "suffix named operation cache name", actualAddNamedOperationHandler.getSuffixCacheName());
    assertFalse(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#AddNamedOperationHandler(String, Boolean)}.
   *
   * <ul>
   *   <li>Then return SuffixCacheName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperationHandler#AddNamedOperationHandler(String,
   * Boolean)}
   */
  @Test
  @DisplayName(
      "Test new AddNamedOperationHandler(String, Boolean); then return SuffixCacheName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedOperationHandler.<init>(String, Boolean)"})
  void testNewAddNamedOperationHandler_thenReturnSuffixCacheNameIsEmptyString() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler =
        new AddNamedOperationHandler("", true);

    // Assert
    assertEquals("", actualAddNamedOperationHandler.getSuffixCacheName());
    assertTrue(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#AddNamedOperationHandler(String, Boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return SuffixCacheName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperationHandler#AddNamedOperationHandler(String,
   * Boolean)}
   */
  @Test
  @DisplayName(
      "Test new AddNamedOperationHandler(String, Boolean); when 'null'; then return SuffixCacheName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedOperationHandler.<init>(String, Boolean)"})
  void testNewAddNamedOperationHandler_whenNull_thenReturnSuffixCacheNameIsNull() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler =
        new AddNamedOperationHandler((String) null, true);

    // Assert
    assertNull(actualAddNamedOperationHandler.getSuffixCacheName());
    assertTrue(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#AddNamedOperationHandler(NamedOperationCache, Boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return NestedNamedOperationsAllowed.
   * </ul>
   *
   * <p>Method under test: {@link
   * AddNamedOperationHandler#AddNamedOperationHandler(NamedOperationCache, Boolean)}
   */
  @Test
  @DisplayName(
      "Test new AddNamedOperationHandler(NamedOperationCache, Boolean); when 'true'; then return NestedNamedOperationsAllowed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddNamedOperationHandler.<init>(NamedOperationCache, Boolean)"})
  void testNewAddNamedOperationHandler_whenTrue_thenReturnNestedNamedOperationsAllowed() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler =
        new AddNamedOperationHandler(
            new NamedOperationCache("Suffix Named Operation Cache Name"), true);

    // Assert
    assertEquals(
        "suffix named operation cache name", actualAddNamedOperationHandler.getSuffixCacheName());
    assertTrue(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#isNestedNamedOperationsAllowed()}.
   *
   * <p>Method under test: {@link AddNamedOperationHandler#isNestedNamedOperationsAllowed()}
   */
  @Test
  @DisplayName("Test isNestedNamedOperationsAllowed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AddNamedOperationHandler.isNestedNamedOperationsAllowed()"})
  void testIsNestedNamedOperationsAllowed() {
    // Arrange, Act and Assert
    assertTrue(
        new AddNamedOperationHandler("Suffix Named Operation Cache Name", true)
            .isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#getSuffixCacheName()}.
   *
   * <ul>
   *   <li>Then return {@code suffix named operation cache name}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperationHandler#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); then return 'suffix named operation cache name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AddNamedOperationHandler.getSuffixCacheName()"})
  void testGetSuffixCacheName_thenReturnSuffixNamedOperationCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named operation cache name",
        new AddNamedOperationHandler("Suffix Named Operation Cache Name", true)
            .getSuffixCacheName());
  }
}
