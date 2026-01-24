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

package uk.gov.gchq.gaffer.federatedstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FederatedStoreCacheDiffblueTest {
  /**
   * Test {@link FederatedStoreCache#FederatedStoreCache(String)}.
   *
   * <p>Method under test: {@link FederatedStoreCache#FederatedStoreCache(String)}
   */
  @Test
  @DisplayName("Test new FederatedStoreCache(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStoreCache.<init>(String)"})
  void testNewFederatedStoreCache() {
    // Arrange and Act
    FederatedStoreCache actualFederatedStoreCache =
        new FederatedStoreCache("Suffix Federated Store Cache Name");

    // Assert
    assertEquals(
        "federatedStoreGraphs_suffix federated store cache name",
        actualFederatedStoreCache.getCacheName());
    assertNull(actualFederatedStoreCache.getCache());
  }

  /**
   * Test {@link FederatedStoreCache#getCacheName()}.
   *
   * <p>Method under test: {@link FederatedStoreCache#getCacheName()}
   */
  @Test
  @DisplayName("Test getCacheName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FederatedStoreCache.getCacheName()"})
  void testGetCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "federatedStoreGraphs_suffix federated store cache name",
        new FederatedStoreCache("Suffix Federated Store Cache Name").getCacheName());
  }

  /**
   * Test {@link FederatedStoreCache#getCache()}.
   *
   * <p>Method under test: {@link FederatedStoreCache#getCache()}
   */
  @Test
  @DisplayName("Test getCache()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"uk.gov.gchq.gaffer.cache.ICache FederatedStoreCache.getCache()"})
  void testGetCache() {
    // Arrange, Act and Assert
    assertNull(new FederatedStoreCache("Suffix Federated Store Cache Name").getCache());
  }

  /**
   * Test {@link FederatedStoreCache#getCacheNameFrom(String)}.
   *
   * <p>Method under test: {@link FederatedStoreCache#getCacheNameFrom(String)}
   */
  @Test
  @DisplayName("Test getCacheNameFrom(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FederatedStoreCache.getCacheNameFrom(String)"})
  void testGetCacheNameFrom() {
    // Arrange, Act and Assert
    assertEquals(
        "federatedStoreGraphs_suffix cache name",
        FederatedStoreCache.getCacheNameFrom("Suffix Cache Name"));
  }
}
