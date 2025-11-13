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

package uk.gov.gchq.gaffer.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;

class CacheDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Cache#Cache(String)}
   *   <li>{@link Cache#getCacheName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Cache.<init>(String)", "String Cache.getCacheName()"})
  void testGettersAndSetters() {
    // Arrange and Act
    Cache<Object, Object> actualCache = new Cache<>("Cache Name");

    // Assert
    assertEquals("Cache Name", actualCache.getCacheName());
  }

  /**
   * Test {@link Cache#Cache(String, String)}.
   * <p>
   * Method under test: {@link Cache#Cache(String, String)}
   */
  @Test
  @DisplayName("Test new Cache(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Cache.<init>(String, String)"})
  void testNewCache() {
    // Arrange and Act
    Cache<Object, Object> actualCache = new Cache<>("Cache Name", "Service Name");

    // Assert
    assertEquals("Cache Name", actualCache.getCacheName());
    assertNull(actualCache.getCache());
  }

  /**
   * Test {@link Cache#contains(String)}.
   * <p>
   * Method under test: {@link Cache#contains(String)}
   */
  @Test
  @DisplayName("Test contains(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Cache.contains(String)"})
  void testContains() {
    // Arrange
    Cache<Object, Object> cache = new Cache<>("Cache Name");

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> cache.contains("42"));
  }

  /**
   * Test {@link Cache#getCache()}.
   * <p>
   * Method under test: {@link Cache#getCache()}
   */
  @Test
  @DisplayName("Test getCache()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"uk.gov.gchq.gaffer.cache.ICache Cache.getCache()"})
  void testGetCache() {
    // Arrange
    Cache<Object, Object> cache = new Cache<>("Cache Name");

    // Act and Assert
    assertNull(cache.getCache());
  }

  /**
   * Test {@link Cache#getSuffixCacheNameWithoutPrefix(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Cache#getSuffixCacheNameWithoutPrefix(String)}
   */
  @Test
  @DisplayName("Test getSuffixCacheNameWithoutPrefix(String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Cache.getSuffixCacheNameWithoutPrefix(String)"})
  void testGetSuffixCacheNameWithoutPrefix_thenReturnNull() {
    // Arrange
    Cache<Object, Object> cache = new Cache<>("Prefix Cache Service Name");

    // Act and Assert
    assertNull(cache.getSuffixCacheNameWithoutPrefix("Prefix Cache Service Name"));
  }

  /**
   * Test {@link Cache#getSuffixCacheNameWithoutPrefix(String)}.
   * <ul>
   *   <li>When {@link CacheServiceLoader#DEFAULT_SERVICE_NAME}.</li>
   *   <li>Then return {@code me}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Cache#getSuffixCacheNameWithoutPrefix(String)}
   */
  @Test
  @DisplayName("Test getSuffixCacheNameWithoutPrefix(String); when DEFAULT_SERVICE_NAME; then return 'me'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Cache.getSuffixCacheNameWithoutPrefix(String)"})
  void testGetSuffixCacheNameWithoutPrefix_whenDefault_service_name_thenReturnMe() {
    // Arrange
    Cache<Object, Object> cache = new Cache<>("Cache Name");

    // Act and Assert
    assertEquals("me", cache.getSuffixCacheNameWithoutPrefix(CacheServiceLoader.DEFAULT_SERVICE_NAME));
  }

  /**
   * Test {@link Cache#getCacheNameFrom(String, String)}.
   * <p>
   * Method under test: {@link Cache#getCacheNameFrom(String, String)}
   */
  @Test
  @DisplayName("Test getCacheNameFrom(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Cache.getCacheNameFrom(String, String)"})
  void testGetCacheNameFrom() {
    // Arrange, Act and Assert
    assertEquals("Prefix Cache Service Name_suffix cache name",
        Cache.getCacheNameFrom("Prefix Cache Service Name", "Suffix Cache Name"));
  }
}
