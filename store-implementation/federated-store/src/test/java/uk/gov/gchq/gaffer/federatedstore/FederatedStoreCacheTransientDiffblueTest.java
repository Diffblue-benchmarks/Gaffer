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

package uk.gov.gchq.gaffer.federatedstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FederatedStoreCacheTransientDiffblueTest {
  /**
   * Test {@link FederatedStoreCacheTransient#getCacheNameFrom(String)} with {@code
   * suffixFederatedStoreCacheName}.
   *
   * <p>Method under test: {@link FederatedStoreCacheTransient#getCacheNameFrom(String)}
   */
  @Test
  @DisplayName("Test getCacheNameFrom(String) with 'suffixFederatedStoreCacheName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FederatedStoreCacheTransient.getCacheNameFrom(String)"})
  void testGetCacheNameFromWithSuffixFederatedStoreCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "federatedStoreGraphs_suffix federated store cache name",
        FederatedStoreCacheTransient.getCacheNameFrom("Suffix Federated Store Cache Name"));
  }

  /**
   * Test {@link FederatedStoreCacheTransient#getSuffixCacheName()}.
   *
   * <p>Method under test: {@link FederatedStoreCacheTransient#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String FederatedStoreCacheTransient.getSuffixCacheName()"})
  void testGetSuffixCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix federated store cache name",
        new FederatedStoreCacheTransient("Suffix Federated Store Cache Name").getSuffixCacheName());
  }
}
