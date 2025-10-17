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

package uk.gov.gchq.gaffer.accumulostore.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.hadoop.util.bloom.BloomFilter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BloomFilterUtilsDiffblueTest {
  /**
   * Test {@link BloomFilterUtils#calculateBloomFilterSize(double, int, int)}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link BloomFilterUtils#calculateBloomFilterSize(double, int, int)}
   */
  @Test
  @DisplayName("Test calculateBloomFilterSize(double, int, int); when '0.5'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BloomFilterUtils.calculateBloomFilterSize(double, int, int)"})
  void testCalculateBloomFilterSize_when05_thenReturnThree() {
    // Arrange and Act
    int actualCalculateBloomFilterSizeResult =
        BloomFilterUtils.calculateBloomFilterSize(
            0.5d, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY, 3);

    // Assert
    assertEquals(3, actualCalculateBloomFilterSizeResult);
  }

  /**
   * Test {@link BloomFilterUtils#calculateBloomFilterSize(double, int, int)}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link BloomFilterUtils#calculateBloomFilterSize(double, int, int)}
   */
  @Test
  @DisplayName("Test calculateBloomFilterSize(double, int, int); when '-0.5'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BloomFilterUtils.calculateBloomFilterSize(double, int, int)"})
  void testCalculateBloomFilterSize_when05_thenReturnZero() {
    // Arrange and Act
    int actualCalculateBloomFilterSizeResult =
        BloomFilterUtils.calculateBloomFilterSize(
            -0.5d, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY, 3);

    // Assert
    assertEquals(0, actualCalculateBloomFilterSizeResult);
  }

  /**
   * Test {@link BloomFilterUtils#calculateBloomFilterSize(double, int, int)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return minus forty-seven.
   * </ul>
   *
   * <p>Method under test: {@link BloomFilterUtils#calculateBloomFilterSize(double, int, int)}
   */
  @Test
  @DisplayName(
      "Test calculateBloomFilterSize(double, int, int); when ten; then return minus forty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BloomFilterUtils.calculateBloomFilterSize(double, int, int)"})
  void testCalculateBloomFilterSize_whenTen_thenReturnMinusFortySeven() {
    // Arrange and Act
    int actualCalculateBloomFilterSizeResult =
        BloomFilterUtils.calculateBloomFilterSize(
            10.0d, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY, 3);

    // Assert
    assertEquals(-47, actualCalculateBloomFilterSizeResult);
  }

  /**
   * Test {@link BloomFilterUtils#calculateBloomFilterSize(double, int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return minus fourteen.
   * </ul>
   *
   * <p>Method under test: {@link BloomFilterUtils#calculateBloomFilterSize(double, int, int)}
   */
  @Test
  @DisplayName(
      "Test calculateBloomFilterSize(double, int, int); when two; then return minus fourteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BloomFilterUtils.calculateBloomFilterSize(double, int, int)"})
  void testCalculateBloomFilterSize_whenTwo_thenReturnMinusFourteen() {
    // Arrange and Act
    int actualCalculateBloomFilterSizeResult =
        BloomFilterUtils.calculateBloomFilterSize(
            2.0d, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY, 3);

    // Assert
    assertEquals(-14, actualCalculateBloomFilterSizeResult);
  }

  /**
   * Test {@link BloomFilterUtils#calculateNumHashes(int, int)}.
   *
   * <ul>
   *   <li>When {@code 19088743}.
   *   <li>Then return {@code 1323130}.
   * </ul>
   *
   * <p>Method under test: {@link BloomFilterUtils#calculateNumHashes(int, int)}
   */
  @Test
  @DisplayName("Test calculateNumHashes(int, int); when '19088743'; then return '1323130'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BloomFilterUtils.calculateNumHashes(int, int)"})
  void testCalculateNumHashes_when19088743_thenReturn1323130() {
    // Arrange, Act and Assert
    assertEquals(
        1323130,
        BloomFilterUtils.calculateNumHashes(
            19088743, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY));
  }

  /**
   * Test {@link BloomFilterUtils#calculateNumHashes(int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link BloomFilterUtils#calculateNumHashes(int, int)}
   */
  @Test
  @DisplayName("Test calculateNumHashes(int, int); when one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BloomFilterUtils.calculateNumHashes(int, int)"})
  void testCalculateNumHashes_whenOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        BloomFilterUtils.calculateNumHashes(
            1, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY));
  }

  /**
   * Test {@link BloomFilterUtils#calculateNumHashes(int, int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link BloomFilterUtils#calculateNumHashes(int, int)}
   */
  @Test
  @DisplayName("Test calculateNumHashes(int, int); when three; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BloomFilterUtils.calculateNumHashes(int, int)"})
  void testCalculateNumHashes_whenThree_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        BloomFilterUtils.calculateNumHashes(
            3, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY));
  }

  /**
   * Test {@link BloomFilterUtils#calculateNumHashes(int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link BloomFilterUtils#calculateNumHashes(int, int)}
   */
  @Test
  @DisplayName("Test calculateNumHashes(int, int); when zero; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BloomFilterUtils.calculateNumHashes(int, int)"})
  void testCalculateNumHashes_whenZero_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        BloomFilterUtils.calculateNumHashes(
            0, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY));
  }

  /**
   * Test {@link BloomFilterUtils#getBloomFilter(double, int, int)} with {@code falsePositiveRate},
   * {@code numItemsToBeAdded}, {@code maximumSize}.
   *
   * <p>Method under test: {@link BloomFilterUtils#getBloomFilter(double, int, int)}
   */
  @Test
  @DisplayName(
      "Test getBloomFilter(double, int, int) with 'falsePositiveRate', 'numItemsToBeAdded', 'maximumSize'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BloomFilter BloomFilterUtils.getBloomFilter(double, int, int)"})
  void testGetBloomFilterWithFalsePositiveRateNumItemsToBeAddedMaximumSize() {
    // Arrange and Act
    BloomFilter actualBloomFilter =
        BloomFilterUtils.getBloomFilter(
            0.5d, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY, 3);

    // Assert
    assertEquals(3, actualBloomFilter.getVectorSize());
  }

  /**
   * Test {@link BloomFilterUtils#getBloomFilter(int)} with {@code size}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return VectorSize is three.
   * </ul>
   *
   * <p>Method under test: {@link BloomFilterUtils#getBloomFilter(int)}
   */
  @Test
  @DisplayName("Test getBloomFilter(int) with 'size'; when three; then return VectorSize is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BloomFilter BloomFilterUtils.getBloomFilter(int)"})
  void testGetBloomFilterWithSize_whenThree_thenReturnVectorSizeIsThree() {
    // Arrange and Act
    BloomFilter actualBloomFilter = BloomFilterUtils.getBloomFilter(3);

    // Assert
    assertEquals(3, actualBloomFilter.getVectorSize());
  }
}
