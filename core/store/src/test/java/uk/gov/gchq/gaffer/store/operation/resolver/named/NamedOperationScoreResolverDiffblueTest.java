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

package uk.gov.gchq.gaffer.store.operation.resolver.named;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.NamedOperation;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedOperationCache;
import uk.gov.gchq.gaffer.store.operation.resolver.ScoreResolver;

class NamedOperationScoreResolverDiffblueTest {
  /**
   * Test {@link NamedOperationScoreResolver#NamedOperationScoreResolver(NamedOperationCache)}.
   *
   * <p>Method under test: {@link
   * NamedOperationScoreResolver#NamedOperationScoreResolver(NamedOperationCache)}
   */
  @Test
  @DisplayName("Test new NamedOperationScoreResolver(NamedOperationCache)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedOperationScoreResolver.<init>(NamedOperationCache)"})
  void testNewNamedOperationScoreResolver() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named operation cache name",
        new NamedOperationScoreResolver(
                new NamedOperationCache("Suffix Named Operation Cache Name"))
            .getSuffixCacheName());
  }

  /**
   * Test {@link NamedOperationScoreResolver#NamedOperationScoreResolver(String)}.
   *
   * <p>Method under test: {@link NamedOperationScoreResolver#NamedOperationScoreResolver(String)}
   */
  @Test
  @DisplayName("Test new NamedOperationScoreResolver(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedOperationScoreResolver.<init>(String)"})
  void testNewNamedOperationScoreResolver2() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named operation cache name",
        new NamedOperationScoreResolver("Suffix Named Operation Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link NamedOperationScoreResolver#NamedOperationScoreResolver(String)}.
   *
   * <ul>
   *   <li>Then return SuffixCacheName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationScoreResolver#NamedOperationScoreResolver(String)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationScoreResolver(String); then return SuffixCacheName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedOperationScoreResolver.<init>(String)"})
  void testNewNamedOperationScoreResolver_thenReturnSuffixCacheNameIsEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new NamedOperationScoreResolver("").getSuffixCacheName());
  }

  /**
   * Test {@link NamedOperationScoreResolver#NamedOperationScoreResolver(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return SuffixCacheName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationScoreResolver#NamedOperationScoreResolver(String)}
   */
  @Test
  @DisplayName(
      "Test new NamedOperationScoreResolver(String); when 'null'; then return SuffixCacheName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedOperationScoreResolver.<init>(String)"})
  void testNewNamedOperationScoreResolver_whenNull_thenReturnSuffixCacheNameIsNull() {
    // Arrange, Act and Assert
    assertNull(new NamedOperationScoreResolver((String) null).getSuffixCacheName());
  }

  /**
   * Test {@link NamedOperationScoreResolver#getSuffixCacheName()}.
   *
   * <ul>
   *   <li>Then return {@code suffix named operation cache name}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationScoreResolver#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); then return 'suffix named operation cache name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamedOperationScoreResolver.getSuffixCacheName()"})
  void testGetSuffixCacheName_thenReturnSuffixNamedOperationCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named operation cache name",
        new NamedOperationScoreResolver("Suffix Named Operation Cache Name").getSuffixCacheName());
  }

  /**
   * Test {@link NamedOperationScoreResolver#getScore(NamedOperation, ScoreResolver)} with {@code
   * operation}, {@code defaultScoreResolver}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationScoreResolver#getScore(NamedOperation,
   * ScoreResolver)}
   */
  @Test
  @DisplayName(
      "Test getScore(NamedOperation, ScoreResolver) with 'operation', 'defaultScoreResolver'; given 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Integer NamedOperationScoreResolver.getScore(NamedOperation, ScoreResolver)"
  })
  void testGetScoreWithOperationDefaultScoreResolver_givenNull_thenReturnNull() {
    // Arrange
    NamedOperationScoreResolver namedOperationScoreResolver =
        new NamedOperationScoreResolver("Suffix Named Operation Cache Name");

    NamedOperation operation = new NamedOperation();
    operation.setOperationName(null);

    // Act and Assert
    assertNull(namedOperationScoreResolver.getScore(operation, null));
  }

  /**
   * Test {@link NamedOperationScoreResolver#getScore(NamedOperation, ScoreResolver)} with {@code
   * operation}, {@code defaultScoreResolver}.
   *
   * <ul>
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationScoreResolver#getScore(NamedOperation,
   * ScoreResolver)}
   */
  @Test
  @DisplayName(
      "Test getScore(NamedOperation, ScoreResolver) with 'operation', 'defaultScoreResolver'; then return intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Integer NamedOperationScoreResolver.getScore(NamedOperation, ScoreResolver)"
  })
  void testGetScoreWithOperationDefaultScoreResolver_thenReturnIntValueIsZero() {
    // Arrange
    NamedOperationScoreResolver namedOperationScoreResolver =
        new NamedOperationScoreResolver("Suffix Named Operation Cache Name");

    // Act and Assert
    assertEquals(
        0,
        namedOperationScoreResolver
            .getScore(new NamedOperation(), mock(ScoreResolver.class))
            .intValue());
  }

  /**
   * Test {@link NamedOperationScoreResolver#getScore(NamedOperation)} with {@code operation}.
   *
   * <ul>
   *   <li>When {@link NamedOperation} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationScoreResolver#getScore(NamedOperation)}
   */
  @Test
  @DisplayName(
      "Test getScore(NamedOperation) with 'operation'; when NamedOperation (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer NamedOperationScoreResolver.getScore(NamedOperation)"})
  void testGetScoreWithOperation_whenNamedOperation_thenReturnNull() {
    // Arrange
    NamedOperationScoreResolver namedOperationScoreResolver =
        new NamedOperationScoreResolver("Suffix Named Operation Cache Name");

    // Act and Assert
    assertNull(namedOperationScoreResolver.getScore(new NamedOperation()));
  }

  /**
   * Test {@link NamedOperationScoreResolver#getScore(NamedOperation)} with {@code operation}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link NamedOperationScoreResolver#getScore(NamedOperation)}
   */
  @Test
  @DisplayName(
      "Test getScore(NamedOperation) with 'operation'; when 'null'; then return intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer NamedOperationScoreResolver.getScore(NamedOperation)"})
  void testGetScoreWithOperation_whenNull_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new NamedOperationScoreResolver("Suffix Named Operation Cache Name")
            .getScore(null)
            .intValue());
  }
}
