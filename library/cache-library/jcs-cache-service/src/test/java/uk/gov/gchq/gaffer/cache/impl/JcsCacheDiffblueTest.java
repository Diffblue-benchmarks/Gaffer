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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import org.apache.commons.jcs.access.exception.CacheException;
import org.apache.commons.jcs.engine.CompositeCacheAttributes;
import org.apache.commons.jcs.engine.ElementAttributes;
import org.apache.commons.jcs.engine.control.CompositeCache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;

class JcsCacheDiffblueTest {
  /**
   * Test {@link JcsCache#JcsCache(CompositeCache)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link CompositeCacheAttributes} (default constructor) CacheName is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JcsCache#JcsCache(CompositeCache)}
   */
  @Test
  @DisplayName("Test new JcsCache(CompositeCache); given '42'; when CompositeCacheAttributes (default constructor) CacheName is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JcsCache.<init>(CompositeCache)"})
  void testNewJcsCache_given42_whenCompositeCacheAttributesCacheNameIs42() throws CacheException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName(" 42");

    // Act
    JcsCache<Object, Object> actualJcsCache = new JcsCache<>(new CompositeCache(cattr, new ElementAttributes()));

    // Assert
    Collection<Object> allValues = actualJcsCache.getAllValues();
    assertTrue(allValues instanceof List);
    assertEquals(0, actualJcsCache.size());
    assertTrue(allValues.isEmpty());
    assertTrue(actualJcsCache.getAllKeys().isEmpty());
  }

  /**
   * Test {@link JcsCache#JcsCache(CompositeCache)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link CompositeCacheAttributes} (default constructor) CacheName is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JcsCache#JcsCache(CompositeCache)}
   */
  @Test
  @DisplayName("Test new JcsCache(CompositeCache); given 'foo'; when CompositeCacheAttributes (default constructor) CacheName is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JcsCache.<init>(CompositeCache)"})
  void testNewJcsCache_givenFoo_whenCompositeCacheAttributesCacheNameIsFoo() throws CacheException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName(" foo");

    // Act
    JcsCache<Object, Object> actualJcsCache = new JcsCache<>(new CompositeCache(cattr, new ElementAttributes()));

    // Assert
    Collection<Object> allValues = actualJcsCache.getAllValues();
    assertTrue(allValues instanceof List);
    assertEquals(0, actualJcsCache.size());
    assertTrue(allValues.isEmpty());
    assertTrue(actualJcsCache.getAllKeys().isEmpty());
  }

  /**
   * Test {@link JcsCache#JcsCache(CompositeCache)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link CompositeCacheAttributes} (default constructor) CacheName is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JcsCache#JcsCache(CompositeCache)}
   */
  @Test
  @DisplayName("Test new JcsCache(CompositeCache); given 'foo'; when CompositeCacheAttributes (default constructor) CacheName is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JcsCache.<init>(CompositeCache)"})
  void testNewJcsCache_givenFoo_whenCompositeCacheAttributesCacheNameIsFoo2() throws CacheException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName("foo ");

    // Act
    JcsCache<Object, Object> actualJcsCache = new JcsCache<>(new CompositeCache(cattr, new ElementAttributes()));

    // Assert
    Collection<Object> allValues = actualJcsCache.getAllValues();
    assertTrue(allValues instanceof List);
    assertEquals(0, actualJcsCache.size());
    assertTrue(allValues.isEmpty());
    assertTrue(actualJcsCache.getAllKeys().isEmpty());
  }

  /**
   * Test {@link JcsCache#JcsCache(CompositeCache)}.
   * <ul>
   *   <li>Given space space.</li>
   * </ul>
   * <p>
   * Method under test: {@link JcsCache#JcsCache(CompositeCache)}
   */
  @Test
  @DisplayName("Test new JcsCache(CompositeCache); given space space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JcsCache.<init>(CompositeCache)"})
  void testNewJcsCache_givenSpaceSpace() throws CacheException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName("  ");

    // Act
    JcsCache<Object, Object> actualJcsCache = new JcsCache<>(new CompositeCache(cattr, new ElementAttributes()));

    // Assert
    Collection<Object> allValues = actualJcsCache.getAllValues();
    assertTrue(allValues instanceof List);
    assertEquals(0, actualJcsCache.size());
    assertTrue(allValues.isEmpty());
    assertTrue(actualJcsCache.getAllKeys().isEmpty());
  }

  /**
   * Test {@link JcsCache#JcsCache(CompositeCache)}.
   * <ul>
   *   <li>Given space.</li>
   *   <li>When {@link CompositeCacheAttributes} (default constructor) CacheName is space.</li>
   * </ul>
   * <p>
   * Method under test: {@link JcsCache#JcsCache(CompositeCache)}
   */
  @Test
  @DisplayName("Test new JcsCache(CompositeCache); given space; when CompositeCacheAttributes (default constructor) CacheName is space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JcsCache.<init>(CompositeCache)"})
  void testNewJcsCache_givenSpace_whenCompositeCacheAttributesCacheNameIsSpace() throws CacheException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName(" ");

    // Act
    JcsCache<Object, Object> actualJcsCache = new JcsCache<>(new CompositeCache(cattr, new ElementAttributes()));

    // Assert
    Collection<Object> allValues = actualJcsCache.getAllValues();
    assertTrue(allValues instanceof List);
    assertEquals(0, actualJcsCache.size());
    assertTrue(allValues.isEmpty());
    assertTrue(actualJcsCache.getAllKeys().isEmpty());
  }

  /**
   * Test {@link JcsCache#JcsCache(CompositeCache)}.
   * <ul>
   *   <li>Given space.</li>
   *   <li>When {@link CompositeCacheAttributes} (default constructor) CacheName is space.</li>
   * </ul>
   * <p>
   * Method under test: {@link JcsCache#JcsCache(CompositeCache)}
   */
  @Test
  @DisplayName("Test new JcsCache(CompositeCache); given space; when CompositeCacheAttributes (default constructor) CacheName is space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JcsCache.<init>(CompositeCache)"})
  void testNewJcsCache_givenSpace_whenCompositeCacheAttributesCacheNameIsSpace2() throws CacheException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName(" ");

    // Act
    JcsCache<Object, Object> actualJcsCache = new JcsCache<>(new CompositeCache(cattr, null));

    // Assert
    Collection<Object> allValues = actualJcsCache.getAllValues();
    assertTrue(allValues instanceof List);
    assertEquals(0, actualJcsCache.size());
    assertTrue(allValues.isEmpty());
    assertTrue(actualJcsCache.getAllKeys().isEmpty());
  }

  /**
   * Test {@link JcsCache#get(Object)}.
   * <ul>
   *   <li>Given {@link JcsCache#JcsCache(CompositeCache)} with cache is {@link CompositeCache#CompositeCache(ICompositeCacheAttributes, IElementAttributes)} {@code Key} is {@code Value}.</li>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JcsCache#get(Object)}
   */
  @Test
  @DisplayName("Test get(Object); given JcsCache(CompositeCache) with cache is CompositeCache(ICompositeCacheAttributes, IElementAttributes) 'Key' is 'Value'; then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JcsCache.get(Object)"})
  void testGet_givenJcsCacheWithCacheIsCompositeCacheKeyIsValue_thenReturnValue()
      throws CacheException, CacheOperationException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName("foo");

    JcsCache<Object, Object> jcsCache = new JcsCache<>(new CompositeCache(cattr, new ElementAttributes()));
    jcsCache.put("Key", "Value");

    // Act and Assert
    assertEquals("Value", jcsCache.get("Key"));
  }

  /**
   * Test {@link JcsCache#put(Object, Object)}.
   * <ul>
   *   <li>Given {@link CompositeCacheAttributes} {@link CompositeCacheAttributes#getCacheName()} return {@code foo}.</li>
   *   <li>Then calls {@link CompositeCacheAttributes#getCacheName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JcsCache#put(Object, Object)}
   */
  @Test
  @DisplayName("Test put(Object, Object); given CompositeCacheAttributes getCacheName() return 'foo'; then calls getCacheName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JcsCache.put(Object, Object)"})
  void testPut_givenCompositeCacheAttributesGetCacheNameReturnFoo_thenCallsGetCacheName()
      throws CacheException, CacheOperationException {
    // Arrange
    CompositeCacheAttributes cattr = mock(CompositeCacheAttributes.class);
    when(cattr.getSpoolChunkSize()).thenReturn(3);
    when(cattr.getCacheName()).thenReturn("foo");
    when(cattr.getMemoryCacheName()).thenReturn("Memory Cache Name");
    doNothing().when(cattr).setCacheName(Mockito.<String>any());
    JcsCache<Object, Object> jcsCache = new JcsCache<>(new CompositeCache(cattr, new ElementAttributes()));

    // Act
    jcsCache.put("Key", "Value");

    // Assert
    verify(cattr, atLeast(1)).getCacheName();
    verify(cattr).getMemoryCacheName();
    verify(cattr).getSpoolChunkSize();
    verify(cattr).setCacheName(eq("foo"));
  }

  /**
   * Test {@link JcsCache#remove(Object)}.
   * <ul>
   *   <li>Given {@link CompositeCacheAttributes} {@link CompositeCacheAttributes#getCacheName()} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JcsCache#remove(Object)}
   */
  @Test
  @DisplayName("Test remove(Object); given CompositeCacheAttributes getCacheName() return 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JcsCache.remove(Object)"})
  void testRemove_givenCompositeCacheAttributesGetCacheNameReturnFoo() throws CacheException, CacheOperationException {
    // Arrange
    CompositeCacheAttributes cattr = mock(CompositeCacheAttributes.class);
    when(cattr.getSpoolChunkSize()).thenReturn(3);
    when(cattr.getCacheName()).thenReturn("foo");
    when(cattr.getMemoryCacheName()).thenReturn("Memory Cache Name");
    doNothing().when(cattr).setCacheName(Mockito.<String>any());

    JcsCache<Object, Object> jcsCache = new JcsCache<>(new CompositeCache(cattr, new ElementAttributes()));
    jcsCache.put("Key", "Value");

    // Act
    jcsCache.remove("Key");

    // Assert
    verify(cattr, atLeast(1)).getCacheName();
    verify(cattr).getMemoryCacheName();
    verify(cattr).getSpoolChunkSize();
    verify(cattr).setCacheName(eq("foo"));
    Collection<Object> allValues = jcsCache.getAllValues();
    assertTrue(allValues instanceof List);
    assertEquals(0, jcsCache.size());
    assertTrue(allValues.isEmpty());
    assertTrue(jcsCache.getAllKeys().isEmpty());
  }
}
