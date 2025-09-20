package uk.gov.gchq.gaffer.cache.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Collection;
import java.util.List;
import org.apache.commons.jcs.access.exception.CacheException;
import org.apache.commons.jcs.engine.CompositeCacheAttributes;
import org.apache.commons.jcs.engine.ElementAttributes;
import org.apache.commons.jcs.engine.control.CompositeCache;
import org.apache.commons.jcs.engine.control.event.ElementEventQueue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;

class JcsCacheDiffblueTest {
  /**
   * Test {@link JcsCache#JcsCache(CompositeCache)}.
   *
   * <ul>
   *   <li>Given {@link ElementEventQueue} (default constructor).
   *   <li>Then AllValues return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link JcsCache#JcsCache(CompositeCache)}
   */
  @Test
  @DisplayName(
      "Test new JcsCache(CompositeCache); given ElementEventQueue (default constructor); then AllValues return List")
  @Tag("MaintainedByDiffblue")
  void testNewJcsCache_givenElementEventQueue_thenAllValuesReturnList() throws CacheException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName(" ");

    CompositeCache cache = new CompositeCache(cattr, new ElementAttributes());
    cache.setElementEventQueue(new ElementEventQueue());

    // Act
    JcsCache<Object, Object> actualJcsCache = new JcsCache<>(cache);

    // Assert
    Collection<Object> allValues = actualJcsCache.getAllValues();
    assertTrue(allValues instanceof List);
    assertEquals(0, actualJcsCache.size());
    assertTrue(allValues.isEmpty());
    assertTrue(actualJcsCache.getAllKeys().isEmpty());
  }

  /**
   * Test {@link JcsCache#get(Object)}.
   *
   * <ul>
   *   <li>Given {@link JcsCache#JcsCache(CompositeCache)} with cache is {@link
   *       CompositeCache#CompositeCache(ICompositeCacheAttributes, IElementAttributes)} {@code Key}
   *       is {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link JcsCache#get(Object)}
   */
  @Test
  @DisplayName(
      "Test get(Object); given JcsCache(CompositeCache) with cache is CompositeCache(ICompositeCacheAttributes, IElementAttributes) 'Key' is 'Value'; then return 'Value'")
  @Tag("MaintainedByDiffblue")
  void testGet_givenJcsCacheWithCacheIsCompositeCacheKeyIsValue_thenReturnValue()
      throws CacheException, CacheOperationException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName("foo");
    CompositeCache cache = new CompositeCache(cattr, new ElementAttributes());

    JcsCache<Object, Object> jcsCache = new JcsCache<>(cache);
    jcsCache.put("Key", "Value");

    // Act and Assert
    assertEquals("Value", jcsCache.get("Key"));
  }

  /**
   * Test {@link JcsCache#put(Object, Object)}.
   *
   * <ul>
   *   <li>Then throw {@link CacheOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link JcsCache#put(Object, Object)}
   */
  @Test
  @DisplayName("Test put(Object, Object); then throw CacheOperationException")
  @Tag("MaintainedByDiffblue")
  void testPut_thenThrowCacheOperationException() throws CacheException, CacheOperationException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName("foo");
    CompositeCache cache = new CompositeCache(cattr, new ElementAttributes());
    JcsCache<Object, Object> jcsCache = new JcsCache<>(cache);

    // Act and Assert
    assertThrows(CacheOperationException.class, () -> jcsCache.put(null, null));
  }

  /**
   * Test {@link JcsCache#put(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code Key must not be null}.
   *   <li>Then throw {@link CacheOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link JcsCache#put(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test put(Object, Object); when 'Key must not be null'; then throw CacheOperationException")
  @Tag("MaintainedByDiffblue")
  void testPut_whenKeyMustNotBeNull_thenThrowCacheOperationException()
      throws CacheException, CacheOperationException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName("foo");
    CompositeCache cache = new CompositeCache(cattr, new ElementAttributes());
    JcsCache<Object, Object> jcsCache = new JcsCache<>(cache);

    // Act and Assert
    assertThrows(CacheOperationException.class, () -> jcsCache.put("Key must not be null", null));
  }

  /**
   * Test {@link JcsCache#remove(Object)}.
   *
   * <ul>
   *   <li>Then {@link JcsCache#JcsCache(CompositeCache)} with cache is {@link
   *       CompositeCache#CompositeCache(ICompositeCacheAttributes, IElementAttributes)} size is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link JcsCache#remove(Object)}
   */
  @Test
  @DisplayName(
      "Test remove(Object); then JcsCache(CompositeCache) with cache is CompositeCache(ICompositeCacheAttributes, IElementAttributes) size is zero")
  @Tag("MaintainedByDiffblue")
  void testRemove_thenJcsCacheWithCacheIsCompositeCacheSizeIsZero() throws CacheException {
    // Arrange
    CompositeCacheAttributes cattr = mock(CompositeCacheAttributes.class);
    when(cattr.getSpoolChunkSize()).thenReturn(3);
    when(cattr.getCacheName()).thenReturn("Cache Name");
    when(cattr.getMemoryCacheName()).thenReturn("Memory Cache Name");
    doNothing().when(cattr).setCacheName(Mockito.<String>any());
    CompositeCache cache = new CompositeCache(cattr, new ElementAttributes());
    JcsCache<Object, Object> jcsCache = new JcsCache<>(cache);

    // Act
    jcsCache.remove("Key");

    // Assert that nothing has changed
    verify(cattr, atLeast(1)).getCacheName();
    verify(cattr).getMemoryCacheName();
    verify(cattr).getSpoolChunkSize();
    verify(cattr).setCacheName("Cache Name");
    Collection<Object> allValues = jcsCache.getAllValues();
    assertTrue(allValues instanceof List);
    assertEquals(0, jcsCache.size());
    assertTrue(allValues.isEmpty());
    assertTrue(jcsCache.getAllKeys().isEmpty());
  }

  /**
   * Test {@link JcsCache#clear()}.
   *
   * <ul>
   *   <li>Then calls {@link CompositeCache#getCacheAttributes()}.
   * </ul>
   *
   * <p>Method under test: {@link JcsCache#clear()}
   */
  @Test
  @DisplayName("Test clear(); then calls getCacheAttributes()")
  @Tag("MaintainedByDiffblue")
  void testClear_thenCallsGetCacheAttributes() throws CacheException, CacheOperationException {
    // Arrange
    CompositeCache cache = mock(CompositeCache.class);
    when(cache.getCacheName()).thenReturn("Cache Name");
    when(cache.getCacheAttributes()).thenReturn(new CompositeCacheAttributes());
    JcsCache<Object, Object> jcsCache = new JcsCache<>(cache);

    // Act
    jcsCache.clear();

    // Assert
    verify(cache).getCacheAttributes();
    verify(cache).getCacheName();
  }
}
