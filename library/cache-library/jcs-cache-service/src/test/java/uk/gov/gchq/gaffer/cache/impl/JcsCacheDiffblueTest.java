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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;

class JcsCacheDiffblueTest {
  /**
   * Test {@link JcsCache#JcsCache(CompositeCache)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>Then AllValues return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link JcsCache#JcsCache(CompositeCache)}
   */
  @Test
  @DisplayName("Test new JcsCache(CompositeCache); given space; then AllValues return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JcsCache.<init>(CompositeCache)"})
  void testNewJcsCache_givenSpace_thenAllValuesReturnList() throws CacheException {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JcsCache.put(Object, Object)"})
  void testPut_thenThrowCacheOperationException() throws CacheException, CacheOperationException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName("Cache Name");
    CompositeCache cache = new CompositeCache(cattr, new ElementAttributes());
    JcsCache<Object, Object> jcsCache = new JcsCache<>(cache);

    // Act and Assert
    assertThrows(CacheOperationException.class, () -> jcsCache.put("Key", null));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JcsCache.put(Object, Object)"})
  void testPut_thenThrowCacheOperationException2() throws CacheException, CacheOperationException {
    // Arrange
    CompositeCacheAttributes cattr = new CompositeCacheAttributes();
    cattr.setCacheName("Cache Name");
    CompositeCache cache = new CompositeCache(cattr, new ElementAttributes());
    JcsCache<Object, Object> jcsCache = new JcsCache<>(cache);

    // Act and Assert
    assertThrows(CacheOperationException.class, () -> jcsCache.put(null, "Value"));
  }
}
