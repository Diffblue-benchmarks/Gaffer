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

package uk.gov.gchq.gaffer.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;
import uk.gov.gchq.gaffer.cache.impl.HashMapCacheService;

class ICacheServiceDiffblueTest {
  /**
   * Test {@link ICacheService#getFromCache(String, Object)}.
   *
   * <ul>
   *   <li>Given {@link HashMapCacheService} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ICacheService#getFromCache(String, Object)}
   */
  @Test
  @DisplayName(
      "Test getFromCache(String, Object); given HashMapCacheService (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ICacheService.getFromCache(String, Object)"})
  void testGetFromCache_givenHashMapCacheService_thenReturnNull() throws CacheOperationException {
    // Arrange, Act and Assert
    assertNull(new HashMapCacheService().getFromCache("Cache Name", "Key"));
  }

  /**
   * Test {@link ICacheService#putInCache(String, Object, Object)}.
   *
   * <ul>
   *   <li>Then {@link HashMapCacheService} (default constructor) sizeOfCache {@code Cache Name} is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link ICacheService#putInCache(String, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test putInCache(String, Object, Object); then HashMapCacheService (default constructor) sizeOfCache 'Cache Name' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ICacheService.putInCache(String, Object, Object)"})
  void testPutInCache_thenHashMapCacheServiceSizeOfCacheCacheNameIsOne()
      throws CacheOperationException {
    // Arrange
    HashMapCacheService hashMapCacheService = new HashMapCacheService();

    // Act
    hashMapCacheService.putInCache("Cache Name", "Key", "Value");

    // Assert
    assertEquals(1, hashMapCacheService.sizeOfCache("Cache Name"));
  }

  /**
   * Test {@link ICacheService#putSafeInCache(String, Object, Object)}.
   *
   * <ul>
   *   <li>Then {@link HashMapCacheService} (default constructor) sizeOfCache {@code Cache Name} is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link ICacheService#putSafeInCache(String, Object, Object)}
   */
  @Test
  @DisplayName(
      "Test putSafeInCache(String, Object, Object); then HashMapCacheService (default constructor) sizeOfCache 'Cache Name' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ICacheService.putSafeInCache(String, Object, Object)"})
  void testPutSafeInCache_thenHashMapCacheServiceSizeOfCacheCacheNameIsOne()
      throws CacheOperationException {
    // Arrange
    HashMapCacheService hashMapCacheService = new HashMapCacheService();

    // Act
    hashMapCacheService.putSafeInCache("Cache Name", "Key", "Value");

    // Assert
    assertEquals(1, hashMapCacheService.sizeOfCache("Cache Name"));
  }

  /**
   * Test {@link ICacheService#getAllValuesFromCache(String)}.
   *
   * <ul>
   *   <li>Given {@link HashMapCacheService} (default constructor).
   *   <li>Then return {@link Collection}.
   * </ul>
   *
   * <p>Method under test: {@link ICacheService#getAllValuesFromCache(String)}
   */
  @Test
  @DisplayName(
      "Test getAllValuesFromCache(String); given HashMapCacheService (default constructor); then return Collection")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ICacheService.getAllValuesFromCache(String)"})
  void testGetAllValuesFromCache_givenHashMapCacheService_thenReturnCollection() {
    // Arrange and Act
    Iterable<Object> actualAllValuesFromCache =
        new HashMapCacheService().getAllValuesFromCache("Cache Name");
    Iterator<Object> actualIteratorResult = actualAllValuesFromCache.iterator();

    // Assert
    assertTrue(actualAllValuesFromCache instanceof Collection);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Collection<Object>) actualAllValuesFromCache).isEmpty());
  }

  /**
   * Test {@link ICacheService#getAllKeysFromCache(String)}.
   *
   * <ul>
   *   <li>Given {@link HashMapCacheService} (default constructor).
   *   <li>Then return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link ICacheService#getAllKeysFromCache(String)}
   */
  @Test
  @DisplayName(
      "Test getAllKeysFromCache(String); given HashMapCacheService (default constructor); then return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable ICacheService.getAllKeysFromCache(String)"})
  void testGetAllKeysFromCache_givenHashMapCacheService_thenReturnSet() {
    // Arrange and Act
    Iterable<Object> actualAllKeysFromCache =
        new HashMapCacheService().getAllKeysFromCache("Cache Name");
    Iterator<Object> actualIteratorResult = actualAllKeysFromCache.iterator();

    // Assert
    assertTrue(actualAllKeysFromCache instanceof Set);
    assertFalse(actualIteratorResult.hasNext());
    assertTrue(((Set<Object>) actualAllKeysFromCache).isEmpty());
  }

  /**
   * Test {@link ICacheService#sizeOfCache(String)}.
   *
   * <ul>
   *   <li>Given {@link HashMapCacheService} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ICacheService#sizeOfCache(String)}
   */
  @Test
  @DisplayName(
      "Test sizeOfCache(String); given HashMapCacheService (default constructor); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ICacheService.sizeOfCache(String)"})
  void testSizeOfCache_givenHashMapCacheService_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new HashMapCacheService().sizeOfCache("Cache Name"));
  }
}
