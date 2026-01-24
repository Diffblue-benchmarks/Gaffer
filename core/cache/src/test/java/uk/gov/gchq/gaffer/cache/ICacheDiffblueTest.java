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
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;
import uk.gov.gchq.gaffer.cache.impl.HashMapCache;
import uk.gov.gchq.gaffer.commonutil.exception.OverwritingException;

class ICacheDiffblueTest {
  /**
   * Test {@link ICache#putSafe(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link HashMapCache#HashMapCache()}.
   *   <li>Then {@link HashMapCache#HashMapCache()} AllValues size is one.
   * </ul>
   *
   * <p>Method under test: {@link ICache#putSafe(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test putSafe(Object, Object); given HashMapCache(); then HashMapCache() AllValues size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ICache.putSafe(Object, Object)"})
  void testPutSafe_givenHashMapCache_thenHashMapCacheAllValuesSizeIsOne()
      throws CacheOperationException, OverwritingException {
    // Arrange
    HashMapCache<Object, Object> hashMapCache = new HashMapCache<>();

    // Act
    hashMapCache.putSafe("Key", "Value");

    // Assert
    assertEquals(1, hashMapCache.getAllValues().size());
    assertEquals(1, hashMapCache.getAllKeys().size());
    assertEquals(1, hashMapCache.size());
  }

  /**
   * Test {@link ICache#putSafe(Object, Object)}.
   *
   * <ul>
   *   <li>Then throw {@link OverwritingException}.
   * </ul>
   *
   * <p>Method under test: {@link ICache#putSafe(Object, Object)}
   */
  @Test
  @DisplayName("Test putSafe(Object, Object); then throw OverwritingException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ICache.putSafe(Object, Object)"})
  void testPutSafe_thenThrowOverwritingException()
      throws CacheOperationException, OverwritingException {
    // Arrange
    HashMapCache<Object, Object> hashMapCache = new HashMapCache<>(true);
    hashMapCache.put("Key", "Value");

    // Act and Assert
    assertThrows(OverwritingException.class, () -> hashMapCache.putSafe("Key", "Value"));
  }
}
