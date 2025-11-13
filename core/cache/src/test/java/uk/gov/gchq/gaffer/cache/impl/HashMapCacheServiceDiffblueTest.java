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

package uk.gov.gchq.gaffer.cache.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.cache.ICache;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;

class HashMapCacheServiceDiffblueTest {
  /**
   * Test {@link HashMapCacheService#getCache(String)}.
   * <ul>
   *   <li>Then return AllValues size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashMapCacheService#getCache(String)}
   */
  @Test
  @DisplayName("Test getCache(String); then return AllValues size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ICache HashMapCacheService.getCache(String)"})
  void testGetCache_thenReturnAllValuesSizeIsOne() throws CacheOperationException {
    // Arrange
    HashMapCacheService hashMapCacheService = new HashMapCacheService();
    hashMapCacheService.putInCache("Cache Name", "Key", "Value");

    // Act
    ICache<Object, Object> actualCache = hashMapCacheService.getCache("Cache Name");

    // Assert
    assertTrue(actualCache instanceof HashMapCache);
    assertEquals(1, ((Collection<Object>) actualCache.getAllValues()).size());
    assertEquals(1, ((Set<Object>) actualCache.getAllKeys()).size());
    assertEquals(1, actualCache.size());
  }

  /**
   * Test {@link HashMapCacheService#getCache(String)}.
   * <ul>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link HashMapCacheService#getCache(String)}
   */
  @Test
  @DisplayName("Test getCache(String); then return size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ICache HashMapCacheService.getCache(String)"})
  void testGetCache_thenReturnSizeIsZero() {
    // Arrange and Act
    ICache<Object, Object> actualCache = (new HashMapCacheService()).getCache("Cache Name");

    // Assert
    assertTrue(actualCache instanceof HashMapCache);
    assertEquals(0, actualCache.size());
    assertTrue(((Collection<Object>) actualCache.getAllValues()).isEmpty());
    assertTrue(((Set<Object>) actualCache.getAllKeys()).isEmpty());
  }

  /**
   * Test new {@link HashMapCacheService} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link HashMapCacheService}
   */
  @Test
  @DisplayName("Test new HashMapCacheService (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HashMapCacheService.<init>()"})
  void testNewHashMapCacheService() {
    // Arrange, Act and Assert
    assertEquals(0, (new HashMapCacheService()).sizeOfCache("Cache Name"));
  }
}
