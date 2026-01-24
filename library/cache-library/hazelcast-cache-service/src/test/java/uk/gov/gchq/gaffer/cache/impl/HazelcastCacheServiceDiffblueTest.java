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

package uk.gov.gchq.gaffer.cache.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.instance.impl.TerminatedLifecycleService;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.gchq.gaffer.cache.ICache;

@ExtendWith(MockitoExtension.class)
class HazelcastCacheServiceDiffblueTest {
  @InjectMocks private HazelcastCacheService hazelcastCacheService;

  @Mock private HazelcastInstance hazelcastInstance;

  /**
   * Test {@link HazelcastCacheService#initialise(Properties)}.
   *
   * <ul>
   *   <li>Given {@code gaffer.cache.config.file}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link HazelcastCacheService#initialise(Properties)}
   */
  @Test
  @DisplayName(
      "Test initialise(Properties); given 'gaffer.cache.config.file'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HazelcastCacheService.initialise(Properties)"})
  void testInitialise_givenGafferCacheConfigFile_thenThrowIllegalArgumentException() {
    // Arrange
    Properties properties = new Properties();
    properties.put("gaffer.cache.config.file", "42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> hazelcastCacheService.initialise(properties));
  }

  /**
   * Test {@link HazelcastCacheService#initialise(Properties)}.
   *
   * <ul>
   *   <li>Given {@code gaffer.cache.config.file}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link HazelcastCacheService#initialise(Properties)}
   */
  @Test
  @DisplayName(
      "Test initialise(Properties); given 'gaffer.cache.config.file'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HazelcastCacheService.initialise(Properties)"})
  void testInitialise_givenGafferCacheConfigFile_thenThrowIllegalArgumentException2() {
    // Arrange
    Properties properties = new Properties();
    properties.put("42", "42");
    properties.put("gaffer.cache.config.file", "42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> hazelcastCacheService.initialise(properties));
  }

  /**
   * Test {@link HazelcastCacheService#shutdown()}.
   *
   * <p>Method under test: {@link HazelcastCacheService#shutdown()}
   */
  @Test
  @DisplayName("Test shutdown()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HazelcastCacheService.shutdown()"})
  void testShutdown() {
    // Arrange
    when(hazelcastInstance.getLifecycleService()).thenReturn(new TerminatedLifecycleService());

    // Act
    hazelcastCacheService.shutdown();

    // Assert
    verify(hazelcastInstance).getLifecycleService();
  }

  /**
   * Test {@link HazelcastCacheService#shutdown()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link HazelcastCacheService#shutdown()}
   */
  @Test
  @DisplayName("Test shutdown(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HazelcastCacheService.shutdown()"})
  void testShutdown_thenThrowIllegalArgumentException() {
    // Arrange
    when(hazelcastInstance.getLifecycleService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> hazelcastCacheService.shutdown());
    verify(hazelcastInstance).getLifecycleService();
  }

  /**
   * Test {@link HazelcastCacheService#getCache(String)}.
   *
   * <ul>
   *   <li>Given {@link HazelcastCacheService} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HazelcastCacheService#getCache(String)}
   */
  @Test
  @DisplayName(
      "Test getCache(String); given HazelcastCacheService (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ICache HazelcastCacheService.getCache(String)"})
  void testGetCache_givenHazelcastCacheService_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new HazelcastCacheService().getCache("Cache Name"));
  }

  /**
   * Test {@link HazelcastCacheService#getCache(String)}.
   *
   * <ul>
   *   <li>Given {@link HazelcastInstance} {@link HazelcastInstance#getMap(String)} return {@code
   *       null}.
   *   <li>Then return {@link HazelcastCache}.
   * </ul>
   *
   * <p>Method under test: {@link HazelcastCacheService#getCache(String)}
   */
  @Test
  @DisplayName(
      "Test getCache(String); given HazelcastInstance getMap(String) return 'null'; then return HazelcastCache")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ICache HazelcastCacheService.getCache(String)"})
  void testGetCache_givenHazelcastInstanceGetMapReturnNull_thenReturnHazelcastCache() {
    // Arrange
    when(hazelcastInstance.getMap(Mockito.<String>any())).thenReturn(null);

    // Act
    ICache<Object, Object> actualCache = hazelcastCacheService.getCache("Cache Name");

    // Assert
    verify(hazelcastInstance).getMap("Cache Name");
    assertTrue(actualCache instanceof HazelcastCache);
  }

  /**
   * Test {@link HazelcastCacheService#getCache(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link HazelcastCacheService#getCache(String)}
   */
  @Test
  @DisplayName("Test getCache(String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ICache HazelcastCacheService.getCache(String)"})
  void testGetCache_thenThrowIllegalArgumentException() {
    // Arrange
    when(hazelcastInstance.getMap(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> hazelcastCacheService.getCache("Cache Name"));
    verify(hazelcastInstance).getMap("Cache Name");
  }
}
