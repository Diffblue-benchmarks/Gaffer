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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CacheServiceLoaderDiffblueTest {
  /**
   * Test {@link CacheServiceLoader#initialise(String)} with {@code cacheClass}.
   * <ul>
   *   <li>When {@code Cache Class}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheServiceLoader#initialise(String)}
   */
  @Test
  @DisplayName("Test initialise(String) with 'cacheClass'; when 'Cache Class'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheServiceLoader.initialise(String)"})
  void testInitialiseWithCacheClass_whenCacheClass() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CacheServiceLoader.initialise("Cache Class"));
  }

  /**
   * Test {@link CacheServiceLoader#initialise(String)} with {@code cacheClass}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheServiceLoader#initialise(String)}
   */
  @Test
  @DisplayName("Test initialise(String) with 'cacheClass'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheServiceLoader.initialise(String)"})
  void testInitialiseWithCacheClass_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CacheServiceLoader.initialise((String) null));
  }

  /**
   * Test {@link CacheServiceLoader#initialise(String)} with {@code cacheClass}.
   * <ul>
   *   <li>When {@code uk.gov.gchq.gaffer.cache.ICacheService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheServiceLoader#initialise(String)}
   */
  @Test
  @DisplayName("Test initialise(String) with 'cacheClass'; when 'uk.gov.gchq.gaffer.cache.ICacheService'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheServiceLoader.initialise(String)"})
  void testInitialiseWithCacheClass_whenUkGovGchqGafferCacheICacheService() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> CacheServiceLoader.initialise("uk.gov.gchq.gaffer.cache.ICacheService"));
  }

  /**
   * Test {@link CacheServiceLoader#initialise(String, String, Properties)} with {@code serviceName}, {@code cacheClass}, {@code properties}.
   * <p>
   * Method under test: {@link CacheServiceLoader#initialise(String, String, Properties)}
   */
  @Test
  @DisplayName("Test initialise(String, String, Properties) with 'serviceName', 'cacheClass', 'properties'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheServiceLoader.initialise(String, String, Properties)"})
  void testInitialiseWithServiceNameCacheClassProperties() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> CacheServiceLoader.initialise("Failed to instantiate cache, cache class was null/missing",
            "uk.gov.gchq.gaffer.cache.ICacheService", new Properties()));
  }

  /**
   * Test {@link CacheServiceLoader#initialise(String, String, Properties)} with {@code serviceName}, {@code cacheClass}, {@code properties}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheServiceLoader#initialise(String, String, Properties)}
   */
  @Test
  @DisplayName("Test initialise(String, String, Properties) with 'serviceName', 'cacheClass', 'properties'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheServiceLoader.initialise(String, String, Properties)"})
  void testInitialiseWithServiceNameCacheClassProperties_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CacheServiceLoader.initialise(null, null, new Properties()));
  }

  /**
   * Test {@link CacheServiceLoader#initialise(String, String, Properties)} with {@code serviceName}, {@code cacheClass}, {@code properties}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheServiceLoader#initialise(String, String, Properties)}
   */
  @Test
  @DisplayName("Test initialise(String, String, Properties) with 'serviceName', 'cacheClass', 'properties'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheServiceLoader.initialise(String, String, Properties)"})
  void testInitialiseWithServiceNameCacheClassProperties_whenNull2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> CacheServiceLoader.initialise(null, "Cache Class", new Properties()));
  }

  /**
   * Test {@link CacheServiceLoader#initialise(String, String, Properties)} with {@code serviceName}, {@code cacheClass}, {@code properties}.
   * <ul>
   *   <li>When {@code Service Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CacheServiceLoader#initialise(String, String, Properties)}
   */
  @Test
  @DisplayName("Test initialise(String, String, Properties) with 'serviceName', 'cacheClass', 'properties'; when 'Service Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CacheServiceLoader.initialise(String, String, Properties)"})
  void testInitialiseWithServiceNameCacheClassProperties_whenServiceName() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> CacheServiceLoader.initialise("Service Name", "Cache Class", new Properties()));
  }

  /**
   * Test {@link CacheServiceLoader#getDefaultService()}.
   * <p>
   * Method under test: {@link CacheServiceLoader#getDefaultService()}
   */
  @Test
  @DisplayName("Test getDefaultService()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"uk.gov.gchq.gaffer.cache.ICacheService CacheServiceLoader.getDefaultService()"})
  void testGetDefaultService() {
    // Arrange, Act and Assert
    assertNull(CacheServiceLoader.getDefaultService());
  }

  /**
   * Test {@link CacheServiceLoader#getService()}.
   * <p>
   * Method under test: {@link CacheServiceLoader#getService()}
   */
  @Test
  @DisplayName("Test getService()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"uk.gov.gchq.gaffer.cache.ICacheService CacheServiceLoader.getService()"})
  void testGetService() {
    // Arrange, Act and Assert
    assertNull(CacheServiceLoader.getService());
  }

  /**
   * Test {@link CacheServiceLoader#getService(String)} with {@code String}.
   * <p>
   * Method under test: {@link CacheServiceLoader#getService(String)}
   */
  @Test
  @DisplayName("Test getService(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"uk.gov.gchq.gaffer.cache.ICacheService CacheServiceLoader.getService(String)"})
  void testGetServiceWithString() {
    // Arrange, Act and Assert
    assertNull(CacheServiceLoader.getService("Service Name"));
  }

  /**
   * Test {@link CacheServiceLoader#isDefaultEnabled()}.
   * <p>
   * Method under test: {@link CacheServiceLoader#isDefaultEnabled()}
   */
  @Test
  @DisplayName("Test isDefaultEnabled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CacheServiceLoader.isDefaultEnabled()"})
  void testIsDefaultEnabled() {
    // Arrange, Act and Assert
    assertFalse(CacheServiceLoader.isDefaultEnabled());
  }

  /**
   * Test {@link CacheServiceLoader#isEnabled()}.
   * <p>
   * Method under test: {@link CacheServiceLoader#isEnabled()}
   */
  @Test
  @DisplayName("Test isEnabled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CacheServiceLoader.isEnabled()"})
  void testIsEnabled() {
    // Arrange, Act and Assert
    assertFalse(CacheServiceLoader.isEnabled());
  }

  /**
   * Test {@link CacheServiceLoader#isEnabled(String)} with {@code String}.
   * <p>
   * Method under test: {@link CacheServiceLoader#isEnabled(String)}
   */
  @Test
  @DisplayName("Test isEnabled(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CacheServiceLoader.isEnabled(String)"})
  void testIsEnabledWithString() {
    // Arrange, Act and Assert
    assertFalse(CacheServiceLoader.isEnabled("Service Name"));
  }
}
