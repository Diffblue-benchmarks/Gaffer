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

package uk.gov.gchq.gaffer.store.operation.handler.named.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedViewDetail;
import uk.gov.gchq.gaffer.user.User;

class NamedViewCacheDiffblueTest {
  /**
   * Test {@link NamedViewCache#NamedViewCache(String)}.
   *
   * <p>Method under test: {@link NamedViewCache#NamedViewCache(String)}
   */
  @Test
  @DisplayName("Test new NamedViewCache(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewCache.<init>(String)"})
  void testNewNamedViewCache() {
    // Arrange and Act
    NamedViewCache actualNamedViewCache = new NamedViewCache("Suffix Named View Cache Name");

    // Assert
    assertEquals("NamedView_suffix named view cache name", actualNamedViewCache.getCacheName());
    assertEquals("suffix named view cache name", actualNamedViewCache.getSuffixCacheName());
    assertNull(actualNamedViewCache.getCache());
  }

  /**
   * Test {@link NamedViewCache#getCacheNameFrom(String)} with {@code suffixNamedViewCacheName}.
   *
   * <p>Method under test: {@link NamedViewCache#getCacheNameFrom(String)}
   */
  @Test
  @DisplayName("Test getCacheNameFrom(String) with 'suffixNamedViewCacheName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamedViewCache.getCacheNameFrom(String)"})
  void testGetCacheNameFromWithSuffixNamedViewCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "NamedView_suffix named view cache name",
        NamedViewCache.getCacheNameFrom("Suffix Named View Cache Name"));
  }

  /**
   * Test {@link NamedViewCache#getSuffixCacheName()}.
   *
   * <p>Method under test: {@link NamedViewCache#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamedViewCache.getSuffixCacheName()"})
  void testGetSuffixCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named view cache name",
        new NamedViewCache("Suffix Named View Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link NamedViewCache#addNamedView(NamedViewDetail, boolean, User, String)} with {@code
   * namedViewDetail}, {@code overwrite}, {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link NamedViewCache#addNamedView(NamedViewDetail, boolean, User,
   * String)}
   */
  @Test
  @DisplayName(
      "Test addNamedView(NamedViewDetail, boolean, User, String) with 'namedViewDetail', 'overwrite', 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewCache.addNamedView(NamedViewDetail, boolean, User, String)"})
  void testAddNamedViewWithNamedViewDetailOverwriteUserAdminAuth() throws CacheOperationException {
    // Arrange
    NamedViewCache namedViewCache = new NamedViewCache("Suffix Named View Cache Name");
    NamedViewDetail namedViewDetail = new NamedViewDetail();

    // Act and Assert
    assertThrows(
        CacheOperationException.class,
        () -> namedViewCache.addNamedView(namedViewDetail, true, new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedViewCache#addNamedView(NamedViewDetail, boolean, User, String)} with {@code
   * namedViewDetail}, {@code overwrite}, {@code user}, {@code adminAuth}.
   *
   * <p>Method under test: {@link NamedViewCache#addNamedView(NamedViewDetail, boolean, User,
   * String)}
   */
  @Test
  @DisplayName(
      "Test addNamedView(NamedViewDetail, boolean, User, String) with 'namedViewDetail', 'overwrite', 'user', 'adminAuth'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewCache.addNamedView(NamedViewDetail, boolean, User, String)"})
  void testAddNamedViewWithNamedViewDetailOverwriteUserAdminAuth2() throws CacheOperationException {
    // Arrange
    NamedViewCache namedViewCache = new NamedViewCache("Suffix Named View Cache Name");
    NamedViewDetail namedViewDetail =
        new NamedViewDetail(
            "NamedView name cannot be null",
            "NamedView name cannot be null",
            "The characteristics of someone or something",
            new HashMap<>());

    // Act and Assert
    assertThrows(
        GafferRuntimeException.class,
        () -> namedViewCache.addNamedView(namedViewDetail, true, new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedViewCache#addNamedView(NamedViewDetail, boolean)} with {@code
   * namedViewDetail}, {@code overwrite}.
   *
   * <ul>
   *   <li>Then throw {@link CacheOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#addNamedView(NamedViewDetail, boolean)}
   */
  @Test
  @DisplayName(
      "Test addNamedView(NamedViewDetail, boolean) with 'namedViewDetail', 'overwrite'; then throw CacheOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewCache.addNamedView(NamedViewDetail, boolean)"})
  void testAddNamedViewWithNamedViewDetailOverwrite_thenThrowCacheOperationException()
      throws CacheOperationException {
    // Arrange
    NamedViewCache namedViewCache = new NamedViewCache("Suffix Named View Cache Name");

    // Act and Assert
    assertThrows(
        CacheOperationException.class,
        () -> namedViewCache.addNamedView(new NamedViewDetail(), true));
  }

  /**
   * Test {@link NamedViewCache#addNamedView(NamedViewDetail, boolean)} with {@code
   * namedViewDetail}, {@code overwrite}.
   *
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#addNamedView(NamedViewDetail, boolean)}
   */
  @Test
  @DisplayName(
      "Test addNamedView(NamedViewDetail, boolean) with 'namedViewDetail', 'overwrite'; then throw GafferRuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewCache.addNamedView(NamedViewDetail, boolean)"})
  void testAddNamedViewWithNamedViewDetailOverwrite_thenThrowGafferRuntimeException()
      throws CacheOperationException {
    // Arrange
    NamedViewCache namedViewCache = new NamedViewCache("Suffix Named View Cache Name");
    NamedViewDetail namedViewDetail =
        new NamedViewDetail(
            "NamedView name cannot be null",
            "NamedView name cannot be null",
            "The characteristics of someone or something",
            new HashMap<>());

    // Act and Assert
    assertThrows(
        GafferRuntimeException.class, () -> namedViewCache.addNamedView(namedViewDetail, true));
  }

  /**
   * Test {@link NamedViewCache#deleteNamedView(String, User, String)} with {@code name}, {@code
   * user}, {@code adminAuth}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#deleteNamedView(String, User, String)}
   */
  @Test
  @DisplayName(
      "Test deleteNamedView(String, User, String) with 'name', 'user', 'adminAuth'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewCache.deleteNamedView(String, User, String)"})
  void testDeleteNamedViewWithNameUserAdminAuth_thenThrowIllegalArgumentException()
      throws CacheOperationException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new NamedViewCache("Suffix Named View Cache Name")
                .deleteNamedView(null, null, "not empty"));
  }

  /**
   * Test {@link NamedViewCache#deleteNamedView(String, User)} with {@code name}, {@code user}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#deleteNamedView(String, User)}
   */
  @Test
  @DisplayName(
      "Test deleteNamedView(String, User) with 'name', 'user'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedViewCache.deleteNamedView(String, User)"})
  void testDeleteNamedViewWithNameUser_whenNull_thenThrowIllegalArgumentException()
      throws CacheOperationException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new NamedViewCache("Suffix Named View Cache Name").deleteNamedView(null, null));
  }

  /**
   * Test {@link NamedViewCache#getNamedView(String, User, String)} with {@code name}, {@code user},
   * {@code adminAuth}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link CacheOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#getNamedView(String, User, String)}
   */
  @Test
  @DisplayName(
      "Test getNamedView(String, User, String) with 'name', 'user', 'adminAuth'; when 'null'; then throw CacheOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamedViewDetail NamedViewCache.getNamedView(String, User, String)"})
  void testGetNamedViewWithNameUserAdminAuth_whenNull_thenThrowCacheOperationException()
      throws CacheOperationException {
    // Arrange
    NamedViewCache namedViewCache = new NamedViewCache("Suffix Named View Cache Name");

    // Act and Assert
    assertThrows(
        CacheOperationException.class,
        () -> namedViewCache.getNamedView(null, new User(), "not empty"));
  }

  /**
   * Test {@link NamedViewCache#getNamedView(String, User)} with {@code name}, {@code user}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link CacheOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#getNamedView(String, User)}
   */
  @Test
  @DisplayName(
      "Test getNamedView(String, User) with 'name', 'user'; when 'null'; then throw CacheOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamedViewDetail NamedViewCache.getNamedView(String, User)"})
  void testGetNamedViewWithNameUser_whenNull_thenThrowCacheOperationException()
      throws CacheOperationException {
    // Arrange
    NamedViewCache namedViewCache = new NamedViewCache("Suffix Named View Cache Name");

    // Act and Assert
    assertThrows(
        CacheOperationException.class, () -> namedViewCache.getNamedView(null, new User()));
  }

  /**
   * Test {@link NamedViewCache#getFromCache(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link NamedViewCache#getFromCache(String)}
   */
  @Test
  @DisplayName("Test getFromCache(String); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NamedViewDetail NamedViewCache.getFromCache(String)"})
  void testGetFromCache_whenNull_thenThrowIllegalArgumentException()
      throws CacheOperationException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new NamedViewCache("Suffix Named View Cache Name").getFromCache(null));
  }
}
