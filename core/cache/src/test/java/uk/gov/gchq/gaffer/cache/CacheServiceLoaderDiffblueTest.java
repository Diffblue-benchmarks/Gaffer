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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Properties;
import org.junit.jupiter.api.Test;

class CacheServiceLoaderDiffblueTest {
  /**
   * Method under test: {@link CacheServiceLoader#initialise(String)}
   */
  @Test
  void testInitialise() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CacheServiceLoader.initialise("Cache Class"));
    assertThrows(IllegalArgumentException.class, () -> CacheServiceLoader.initialise((String) null));
    assertThrows(IllegalArgumentException.class,
        () -> CacheServiceLoader.initialise("uk.gov.gchq.gaffer.cache.ICacheService"));
    assertThrows(IllegalArgumentException.class,
        () -> CacheServiceLoader.initialise("Service Name", "Cache Class", new Properties()));
    assertThrows(IllegalArgumentException.class, () -> CacheServiceLoader.initialise(null, null, new Properties()));
    assertThrows(IllegalArgumentException.class,
        () -> CacheServiceLoader.initialise(null, "Cache Class", new Properties()));
    assertThrows(IllegalArgumentException.class,
        () -> CacheServiceLoader.initialise("Failed to instantiate cache, cache class was null/missing",
            "uk.gov.gchq.gaffer.cache.ICacheService", new Properties()));
  }

  /**
   * Method under test: {@link CacheServiceLoader#isDefaultEnabled()}
   */
  @Test
  void testIsDefaultEnabled() {
    // Arrange, Act and Assert
    assertFalse(CacheServiceLoader.isDefaultEnabled());
  }

  /**
   * Method under test: {@link CacheServiceLoader#isEnabled()}
   */
  @Test
  void testIsEnabled() {
    // Arrange, Act and Assert
    assertFalse(CacheServiceLoader.isEnabled());
    assertFalse(CacheServiceLoader.isEnabled("Service Name"));
  }
}
