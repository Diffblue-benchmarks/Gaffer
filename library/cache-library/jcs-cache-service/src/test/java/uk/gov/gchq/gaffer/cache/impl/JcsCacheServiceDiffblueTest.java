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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.cache.ICache;

class JcsCacheServiceDiffblueTest {
  /**
   * Test {@link JcsCacheService#initialise(Properties)}.
   *
   * <p>Method under test: {@link JcsCacheService#initialise(Properties)}
   */
  @Test
  @DisplayName("Test initialise(Properties)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void JcsCacheService.initialise(Properties)"})
  void testInitialise() {
    // Arrange
    JcsCacheService jcsCacheService = new JcsCacheService();

    // Act
    jcsCacheService.initialise(new Properties());

    // Assert
    assertEquals(0, jcsCacheService.sizeOfCache("Cache Name"));
  }

  /**
   * Test {@link JcsCacheService#getCache(String)}.
   *
   * <ul>
   *   <li>When {@code Cache Name}.
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link JcsCacheService#getCache(String)}
   */
  @Test
  @DisplayName("Test getCache(String); when 'Cache Name'; then return size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ICache JcsCacheService.getCache(String)"})
  void testGetCache_whenCacheName_thenReturnSizeIsZero() {
    // Arrange
    JcsCacheService jcsCacheService = new JcsCacheService();
    jcsCacheService.initialise(new Properties());

    // Act
    ICache<Object, Object> actualCache = jcsCacheService.getCache("Cache Name");

    // Assert
    Iterable<Object> allValues = actualCache.getAllValues();
    assertTrue(allValues instanceof List);
    assertTrue(actualCache instanceof JcsCache);
    assertEquals(0, actualCache.size());
    assertTrue(((List<Object>) allValues).isEmpty());
    assertTrue(((Set<Object>) actualCache.getAllKeys()).isEmpty());
  }
}
