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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;
import uk.gov.gchq.gaffer.named.operation.NamedOperationDetail;
import uk.gov.gchq.gaffer.user.User;

class NamedOperationCacheDiffblueTest {
  /**
   * Test {@link NamedOperationCache#NamedOperationCache(String)}.
   * <p>
   * Method under test: {@link NamedOperationCache#NamedOperationCache(String)}
   */
  @Test
  @DisplayName("Test new NamedOperationCache(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedOperationCache.<init>(String)"})
  void testNewNamedOperationCache() {
    // Arrange and Act
    NamedOperationCache actualNamedOperationCache = new NamedOperationCache("Suffix Named Operation Cache Name");

    // Assert
    assertEquals("NamedOperation_suffix named operation cache name", actualNamedOperationCache.getCacheName());
    assertEquals("suffix named operation cache name", actualNamedOperationCache.getSuffixCacheName());
    assertNull(actualNamedOperationCache.getCache());
  }

  /**
   * Test {@link NamedOperationCache#NamedOperationCache(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return SuffixCacheName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedOperationCache#NamedOperationCache(String)}
   */
  @Test
  @DisplayName("Test new NamedOperationCache(String); when 'null'; then return SuffixCacheName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedOperationCache.<init>(String)"})
  void testNewNamedOperationCache_whenNull_thenReturnSuffixCacheNameIsNull() {
    // Arrange and Act
    NamedOperationCache actualNamedOperationCache = new NamedOperationCache(null);

    // Assert
    assertNull(actualNamedOperationCache.getSuffixCacheName());
    assertNull(actualNamedOperationCache.getCache());
    assertEquals(NamedOperationCache.CACHE_SERVICE_NAME_PREFIX, actualNamedOperationCache.getCacheName());
  }

  /**
   * Test {@link NamedOperationCache#getCacheNameFrom(String)} with {@code suffixNamedOperationCacheName}.
   * <p>
   * Method under test: {@link NamedOperationCache#getCacheNameFrom(String)}
   */
  @Test
  @DisplayName("Test getCacheNameFrom(String) with 'suffixNamedOperationCacheName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String NamedOperationCache.getCacheNameFrom(String)"})
  void testGetCacheNameFromWithSuffixNamedOperationCacheName() {
    // Arrange, Act and Assert
    assertEquals("NamedOperation_suffix named operation cache name",
        NamedOperationCache.getCacheNameFrom("Suffix Named Operation Cache Name"));
  }

  /**
   * Test {@link NamedOperationCache#getSuffixCacheName()}.
   * <p>
   * Method under test: {@link NamedOperationCache#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String NamedOperationCache.getSuffixCacheName()"})
  void testGetSuffixCacheName() {
    // Arrange, Act and Assert
    assertEquals("suffix named operation cache name",
        (new NamedOperationCache("Suffix Named Operation Cache Name")).getSuffixCacheName());
  }

  /**
   * Test {@link NamedOperationCache#addNamedOperation(NamedOperationDetail, boolean, User, String)} with {@code namedOperation}, {@code overwrite}, {@code user}, {@code adminAuth}.
   * <p>
   * Method under test: {@link NamedOperationCache#addNamedOperation(NamedOperationDetail, boolean, User, String)}
   */
  @Test
  @DisplayName("Test addNamedOperation(NamedOperationDetail, boolean, User, String) with 'namedOperation', 'overwrite', 'user', 'adminAuth'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedOperationCache.addNamedOperation(NamedOperationDetail, boolean, User, String)"})
  void testAddNamedOperationWithNamedOperationOverwriteUserAdminAuth() throws CacheOperationException {
    // Arrange
    NamedOperationCache namedOperationCache = new NamedOperationCache("Suffix Named Operation Cache Name");

    // Act and Assert
    assertThrows(CacheOperationException.class,
        () -> namedOperationCache.addNamedOperation(null, false, new User(), null));
  }

  /**
   * Test {@link NamedOperationCache#addNamedOperation(NamedOperationDetail, boolean, User, String)} with {@code namedOperation}, {@code overwrite}, {@code user}, {@code adminAuth}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedOperationCache#addNamedOperation(NamedOperationDetail, boolean, User, String)}
   */
  @Test
  @DisplayName("Test addNamedOperation(NamedOperationDetail, boolean, User, String) with 'namedOperation', 'overwrite', 'user', 'adminAuth'; when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedOperationCache.addNamedOperation(NamedOperationDetail, boolean, User, String)"})
  void testAddNamedOperationWithNamedOperationOverwriteUserAdminAuth_whenTrue() throws CacheOperationException {
    // Arrange
    NamedOperationCache namedOperationCache = new NamedOperationCache("Suffix Named Operation Cache Name");
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();
    NamedOperationDetail namedOperation = new NamedOperationDetail("Operation Name",
        "The characteristics of someone or something", "42", "Operations", readers, writers, new HashMap<>(), 3);

    // Act and Assert
    assertThrows(CacheOperationException.class,
        () -> namedOperationCache.addNamedOperation(namedOperation, true, new User(), "Admin Auth"));
  }

  /**
   * Test {@link NamedOperationCache#addNamedOperation(NamedOperationDetail, boolean, User)} with {@code namedOperation}, {@code overwrite}, {@code user}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedOperationCache#addNamedOperation(NamedOperationDetail, boolean, User)}
   */
  @Test
  @DisplayName("Test addNamedOperation(NamedOperationDetail, boolean, User) with 'namedOperation', 'overwrite', 'user'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedOperationCache.addNamedOperation(NamedOperationDetail, boolean, User)"})
  void testAddNamedOperationWithNamedOperationOverwriteUser_whenNull() throws CacheOperationException {
    // Arrange
    NamedOperationCache namedOperationCache = new NamedOperationCache("Suffix Named Operation Cache Name");

    // Act and Assert
    assertThrows(CacheOperationException.class, () -> namedOperationCache.addNamedOperation(null, false, new User()));
  }

  /**
   * Test {@link NamedOperationCache#addNamedOperation(NamedOperationDetail, boolean, User)} with {@code namedOperation}, {@code overwrite}, {@code user}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamedOperationCache#addNamedOperation(NamedOperationDetail, boolean, User)}
   */
  @Test
  @DisplayName("Test addNamedOperation(NamedOperationDetail, boolean, User) with 'namedOperation', 'overwrite', 'user'; when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamedOperationCache.addNamedOperation(NamedOperationDetail, boolean, User)"})
  void testAddNamedOperationWithNamedOperationOverwriteUser_whenTrue() throws CacheOperationException {
    // Arrange
    NamedOperationCache namedOperationCache = new NamedOperationCache("Suffix Named Operation Cache Name");
    ArrayList<String> readers = new ArrayList<>();
    ArrayList<String> writers = new ArrayList<>();
    NamedOperationDetail namedOperation = new NamedOperationDetail("Operation Name",
        "The characteristics of someone or something", "42", "Operations", readers, writers, new HashMap<>(), 3);

    // Act and Assert
    assertThrows(CacheOperationException.class,
        () -> namedOperationCache.addNamedOperation(namedOperation, true, new User()));
  }
}
