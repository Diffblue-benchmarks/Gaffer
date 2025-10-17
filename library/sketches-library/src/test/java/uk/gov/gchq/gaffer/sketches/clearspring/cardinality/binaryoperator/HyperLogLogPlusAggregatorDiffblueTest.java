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

package uk.gov.gchq.gaffer.sketches.clearspring.cardinality.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HyperLogLogPlusAggregatorDiffblueTest {
  /**
   * Test {@link HyperLogLogPlusAggregator#_apply(HyperLogLogPlus, HyperLogLogPlus)} with {@code
   * HyperLogLogPlus}, {@code HyperLogLogPlus}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HyperLogLogPlusAggregator#_apply(HyperLogLogPlus,
   * HyperLogLogPlus)}
   */
  @Test
  @DisplayName(
      "Test _apply(HyperLogLogPlus, HyperLogLogPlus) with 'HyperLogLogPlus', 'HyperLogLogPlus'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HyperLogLogPlus HyperLogLogPlusAggregator._apply(HyperLogLogPlus, HyperLogLogPlus)"
  })
  void test_applyWithHyperLogLogPlusHyperLogLogPlus_thenThrowRuntimeException() {
    // Arrange
    HyperLogLogPlusAggregator hyperLogLogPlusAggregator = new HyperLogLogPlusAggregator();
    HyperLogLogPlus a = new HyperLogLogPlus(4);

    HyperLogLogPlus b = mock(HyperLogLogPlus.class);
    when(b.sizeof()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> hyperLogLogPlusAggregator._apply(a, b));
    verify(b).sizeof();
  }
}
