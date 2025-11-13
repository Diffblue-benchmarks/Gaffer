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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HazelcastCacheServiceDiffblueTest {
  /**
   * Test {@link HazelcastCacheService#initialise(Properties)}.
   * <ul>
   *   <li>Given {@code gaffer.cache.config.file}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HazelcastCacheService#initialise(Properties)}
   */
  @Test
  @DisplayName("Test initialise(Properties); given 'gaffer.cache.config.file'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HazelcastCacheService.initialise(Properties)"})
  void testInitialise_givenGafferCacheConfigFile_thenThrowIllegalArgumentException() {
    // Arrange
    HazelcastCacheService hazelcastCacheService = new HazelcastCacheService();

    Properties properties = new Properties();
    properties.put("gaffer.cache.config.file", "42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> hazelcastCacheService.initialise(properties));
  }

  /**
   * Test {@link HazelcastCacheService#initialise(Properties)}.
   * <ul>
   *   <li>Given {@code gaffer.cache.config.file}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HazelcastCacheService#initialise(Properties)}
   */
  @Test
  @DisplayName("Test initialise(Properties); given 'gaffer.cache.config.file'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HazelcastCacheService.initialise(Properties)"})
  void testInitialise_givenGafferCacheConfigFile_thenThrowIllegalArgumentException2() {
    // Arrange
    HazelcastCacheService hazelcastCacheService = new HazelcastCacheService();

    Properties properties = new Properties();
    properties.put("42", "42");
    properties.put("gaffer.cache.config.file", "42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> hazelcastCacheService.initialise(properties));
  }

  /**
   * Test {@link HazelcastCacheService#getCache(String)}.
   * <p>
   * Method under test: {@link HazelcastCacheService#getCache(String)}
   */
  @Test
  @DisplayName("Test getCache(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"uk.gov.gchq.gaffer.cache.ICache HazelcastCacheService.getCache(String)"})
  void testGetCache() {
    // Arrange, Act and Assert
    assertNull((new HazelcastCacheService()).getCache("Cache Name"));
  }
}
