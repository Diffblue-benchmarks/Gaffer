package uk.gov.gchq.gaffer.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <p>Method under test: {@link ICacheService#getFromCache(String, Object)}
   */
  @Test
  @DisplayName("Test getFromCache(String, Object)")
  @Tag("MaintainedByDiffblue")
  void testGetFromCache() throws CacheOperationException {
    // Arrange, Act and Assert
    assertNull(new HashMapCacheService().getFromCache("Cache Name", "Key"));
  }

  /**
   * Test {@link ICacheService#putInCache(String, Object, Object)}.
   *
   * <p>Method under test: {@link ICacheService#putInCache(String, Object, Object)}
   */
  @Test
  @DisplayName("Test putInCache(String, Object, Object)")
  @Tag("MaintainedByDiffblue")
  void testPutInCache() throws CacheOperationException {
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
  @Tag("MaintainedByDiffblue")
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
   * <p>Method under test: {@link ICacheService#getAllValuesFromCache(String)}
   */
  @Test
  @DisplayName("Test getAllValuesFromCache(String)")
  @Tag("MaintainedByDiffblue")
  void testGetAllValuesFromCache() {
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
   * <p>Method under test: {@link ICacheService#getAllKeysFromCache(String)}
   */
  @Test
  @DisplayName("Test getAllKeysFromCache(String)")
  @Tag("MaintainedByDiffblue")
  void testGetAllKeysFromCache() {
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
   * <p>Method under test: {@link ICacheService#sizeOfCache(String)}
   */
  @Test
  @DisplayName("Test sizeOfCache(String)")
  @Tag("MaintainedByDiffblue")
  void testSizeOfCache() {
    // Arrange, Act and Assert
    assertEquals(0, new HashMapCacheService().sizeOfCache("Cache Name"));
  }
}
