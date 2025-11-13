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

package uk.gov.gchq.gaffer.sketches.datasketches.cardinality.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.hll.HllSketch;
import org.apache.datasketches.hll.TgtHllType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HllSketchAggregatorDiffblueTest {
  /**
   * Test {@link HllSketchAggregator#_apply(HllSketch, HllSketch)} with {@code HllSketch}, {@code HllSketch}.
   * <ul>
   *   <li>When {@link HllSketch#HllSketch()}.</li>
   *   <li>Then return CompositeEstimate is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link HllSketchAggregator#_apply(HllSketch, HllSketch)}
   */
  @Test
  @DisplayName("Test _apply(HllSketch, HllSketch) with 'HllSketch', 'HllSketch'; when HllSketch(); then return CompositeEstimate is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HllSketch HllSketchAggregator._apply(HllSketch, HllSketch)"})
  void test_applyWithHllSketchHllSketch_whenHllSketch_thenReturnCompositeEstimateIsZero() {
    // Arrange
    HllSketchAggregator hllSketchAggregator = new HllSketchAggregator();
    HllSketch a = new HllSketch();

    // Act
    HllSketch actual_applyResult = hllSketchAggregator._apply(a, new HllSketch());

    // Assert
    assertEquals(0.0d, actual_applyResult.getCompositeEstimate());
    assertEquals(0.0d, actual_applyResult.getEstimate());
    assertEquals(12, actual_applyResult.getLgConfigK());
    assertEquals(40, actual_applyResult.getUpdatableSerializationBytes());
    assertEquals(8, actual_applyResult.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actual_applyResult.getTgtHllType());
    assertFalse(actual_applyResult.isCompact());
    assertFalse(actual_applyResult.isMemory());
    assertFalse(actual_applyResult.isOffHeap());
    assertTrue(actual_applyResult.isEmpty());
  }

  /**
   * Test {@link HllSketchAggregator#_apply(HllSketch, HllSketch)} with {@code HllSketch}, {@code HllSketch}.
   * <ul>
   *   <li>When {@link HllSketch#HllSketch()}.</li>
   *   <li>Then return CompositeEstimate is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link HllSketchAggregator#_apply(HllSketch, HllSketch)}
   */
  @Test
  @DisplayName("Test _apply(HllSketch, HllSketch) with 'HllSketch', 'HllSketch'; when HllSketch(); then return CompositeEstimate is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HllSketch HllSketchAggregator._apply(HllSketch, HllSketch)"})
  void test_applyWithHllSketchHllSketch_whenHllSketch_thenReturnCompositeEstimateIsZero2() {
    // Arrange
    HllSketchAggregator hllSketchAggregator = new HllSketchAggregator();

    // Act
    HllSketch actual_applyResult = hllSketchAggregator._apply(new HllSketch(), null);

    // Assert
    assertEquals(0.0d, actual_applyResult.getCompositeEstimate());
    assertEquals(0.0d, actual_applyResult.getEstimate());
    assertEquals(12, actual_applyResult.getLgConfigK());
    assertEquals(40, actual_applyResult.getUpdatableSerializationBytes());
    assertEquals(8, actual_applyResult.getCompactSerializationBytes());
    assertEquals(TgtHllType.HLL_4, actual_applyResult.getTgtHllType());
    assertFalse(actual_applyResult.isCompact());
    assertFalse(actual_applyResult.isMemory());
    assertFalse(actual_applyResult.isOffHeap());
    assertTrue(actual_applyResult.isEmpty());
  }
}
