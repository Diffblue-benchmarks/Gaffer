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

package uk.gov.gchq.gaffer.types.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.FreqMap;

class FreqMapAggregatorDiffblueTest {
  /**
   * Method under test: {@link FreqMapAggregator#_apply(FreqMap, FreqMap)}
   */
  @Test
  void test_apply() {
    // Arrange
    FreqMapAggregator freqMapAggregator = new FreqMapAggregator();
    FreqMap a = new FreqMap();

    // Act and Assert
    assertTrue(freqMapAggregator._apply(a, new FreqMap()).isEmpty());
  }

  /**
   * Method under test: {@link FreqMapAggregator#_apply(FreqMap, FreqMap)}
   */
  @Test
  void test_apply2() {
    // Arrange
    FreqMapAggregator freqMapAggregator = new FreqMapAggregator();
    FreqMap a = new FreqMap();

    FreqMap b = new FreqMap();
    b.put("foo", 1L);

    // Act
    FreqMap actual_applyResult = freqMapAggregator._apply(a, b);

    // Assert
    assertEquals(1, actual_applyResult.size());
    assertEquals(1L, actual_applyResult.get("foo").longValue());
  }

  /**
   * Method under test: {@link FreqMapAggregator#_apply(FreqMap, FreqMap)}
   */
  @Test
  void test_apply3() {
    // Arrange
    FreqMapAggregator freqMapAggregator = new FreqMapAggregator();
    FreqMap a = new FreqMap();

    FreqMap b = new FreqMap();
    b.computeIfPresent("foo", mock(BiFunction.class));
    b.put("foo", 1L);

    // Act
    FreqMap actual_applyResult = freqMapAggregator._apply(a, b);

    // Assert
    assertEquals(1, actual_applyResult.size());
    assertEquals(1L, actual_applyResult.get("foo").longValue());
  }

  /**
   * Method under test: {@link FreqMapAggregator#_apply(FreqMap, FreqMap)}
   */
  @Test
  void test_apply4() {
    // Arrange
    FreqMapAggregator freqMapAggregator = new FreqMapAggregator();

    FreqMap a = new FreqMap();
    a.put("foo", 0L);

    FreqMap b = new FreqMap();
    b.put("foo", 1L);

    // Act
    FreqMap actual_applyResult = freqMapAggregator._apply(a, b);

    // Assert
    assertEquals(1, actual_applyResult.size());
    assertEquals(1L, actual_applyResult.get("foo").longValue());
  }
}
