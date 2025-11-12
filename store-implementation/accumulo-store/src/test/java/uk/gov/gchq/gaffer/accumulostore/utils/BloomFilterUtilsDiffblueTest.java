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
import org.junit.jupiter.api.Test;

class BloomFilterUtilsDiffblueTest {
  /**
   * Method under test:
   * {@link BloomFilterUtils#calculateBloomFilterSize(double, int, int)}
   */
  @Test
  void testCalculateBloomFilterSize() {
    // Arrange, Act and Assert
    assertEquals(-47,
        BloomFilterUtils.calculateBloomFilterSize(10.0d, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY, 3));
    assertEquals(-14,
        BloomFilterUtils.calculateBloomFilterSize(2.0d, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY, 3));
    assertEquals(3,
        BloomFilterUtils.calculateBloomFilterSize(0.5d, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY, 3));
    assertEquals(0,
        BloomFilterUtils.calculateBloomFilterSize(-0.5d, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY, 3));
  }

  /**
   * Method under test: {@link BloomFilterUtils#calculateNumHashes(int, int)}
   */
  @Test
  void testCalculateNumHashes() {
    // Arrange, Act and Assert
    assertEquals(1, BloomFilterUtils.calculateNumHashes(3, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY));
    assertEquals(1323130,
        BloomFilterUtils.calculateNumHashes(19088743, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY));
    assertEquals(1, BloomFilterUtils.calculateNumHashes(1, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY));
    assertEquals(1, BloomFilterUtils.calculateNumHashes(0, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY));
  }

  /**
   * Method under test: {@link BloomFilterUtils#getBloomFilter(double, int, int)}
   */
  @Test
  void testGetBloomFilter() {
    // Arrange, Act and Assert
    assertEquals(3,
        BloomFilterUtils.getBloomFilter(0.5d, AccumuloStoreConstants.AGGREGATOR_ITERATOR_PRIORITY, 3).getVectorSize());
    assertEquals(3, BloomFilterUtils.getBloomFilter(3).getVectorSize());
  }
}
