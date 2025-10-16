package uk.gov.gchq.gaffer.federatedstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FederatedStoreCacheTransientDiffblueTest {
  /**
   * Test {@link FederatedStoreCacheTransient#FederatedStoreCacheTransient(String)}.
   *
   * <p>Method under test: {@link FederatedStoreCacheTransient#FederatedStoreCacheTransient(String)}
   */
  @Test
  @DisplayName("Test new FederatedStoreCacheTransient(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedStoreCacheTransient.<init>(String)"})
  void testNewFederatedStoreCacheTransient() {
    // Arrange and Act
    FederatedStoreCacheTransient actualFederatedStoreCacheTransient =
        new FederatedStoreCacheTransient("Suffix Federated Store Cache Name");

    // Assert
    assertEquals(
        "federatedStoreGraphs_suffix federated store cache name",
        actualFederatedStoreCacheTransient.getCacheName());
    assertEquals(
        "suffix federated store cache name",
        actualFederatedStoreCacheTransient.getSuffixCacheName());
    assertNull(actualFederatedStoreCacheTransient.getCache());
  }

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
