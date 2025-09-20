package uk.gov.gchq.gaffer.cache.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   *
   * <ul>
   *   <li>Then return AllValues size is one.
   * </ul>
   *
   * <p>Method under test: {@link HashMapCacheService#getCache(String)}
   */
  @Test
  @DisplayName("Test getCache(String); then return AllValues size is one")
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link HashMapCacheService#getCache(String)}
   */
  @Test
  @DisplayName("Test getCache(String); then return size is zero")
  @Tag("MaintainedByDiffblue")
  void testGetCache_thenReturnSizeIsZero() {
    // Arrange and Act
    ICache<Object, Object> actualCache = new HashMapCacheService().getCache("Cache Name");

    // Assert
    assertTrue(actualCache instanceof HashMapCache);
    assertEquals(0, actualCache.size());
    assertTrue(((Collection<Object>) actualCache.getAllValues()).isEmpty());
    assertTrue(((Set<Object>) actualCache.getAllKeys()).isEmpty());
  }

  /**
   * Test new {@link HashMapCacheService} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link HashMapCacheService}
   */
  @Test
  @DisplayName("Test new HashMapCacheService (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testNewHashMapCacheService() {
    // Arrange, Act and Assert
    assertEquals(0, new HashMapCacheService().sizeOfCache("Cache Name"));
  }
}
