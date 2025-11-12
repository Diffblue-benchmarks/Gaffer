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
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.cache.exception.CacheOperationException;
import uk.gov.gchq.gaffer.named.operation.NamedOperationDetail;
import uk.gov.gchq.gaffer.user.User;

class NamedOperationCacheDiffblueTest {
  /**
   * Method under test: {@link NamedOperationCache#getCacheNameFrom(String)}
   */
  @Test
  void testGetCacheNameFrom() {
    // Arrange, Act and Assert
    assertEquals("NamedOperation_suffix named operation cache name",
        NamedOperationCache.getCacheNameFrom("Suffix Named Operation Cache Name"));
  }

  /**
   * Method under test: {@link NamedOperationCache#getSuffixCacheName()}
   */
  @Test
  void testGetSuffixCacheName() {
    // Arrange, Act and Assert
    assertEquals("suffix named operation cache name",
        (new NamedOperationCache("Suffix Named Operation Cache Name")).getSuffixCacheName());
  }

  /**
   * Method under test:
   * {@link NamedOperationCache#addNamedOperation(NamedOperationDetail, boolean, User)}
   */
  @Test
  void testAddNamedOperation() throws CacheOperationException {
    // Arrange
    NamedOperationCache namedOperationCache = new NamedOperationCache("Suffix Named Operation Cache Name");

    // Act and Assert
    assertThrows(CacheOperationException.class, () -> namedOperationCache.addNamedOperation(null, true, new User()));
  }

  /**
   * Method under test:
   * {@link NamedOperationCache#addNamedOperation(NamedOperationDetail, boolean, User, String)}
   */
  @Test
  void testAddNamedOperation2() throws CacheOperationException {
    // Arrange
    NamedOperationCache namedOperationCache = new NamedOperationCache("Suffix Named Operation Cache Name");

    // Act and Assert
    assertThrows(CacheOperationException.class,
        () -> namedOperationCache.addNamedOperation(null, true, new User(), "Admin Auth"));
  }
}
