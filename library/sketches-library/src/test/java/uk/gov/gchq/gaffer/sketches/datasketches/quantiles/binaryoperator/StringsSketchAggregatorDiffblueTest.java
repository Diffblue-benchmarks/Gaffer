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

package uk.gov.gchq.gaffer.sketches.datasketches.quantiles.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.datasketches.quantiles.ItemsSketch;
import org.apache.datasketches.quantiles.ItemsSketchIterator;
import org.apache.datasketches.quantiles.ItemsSketchSortedView;
import org.apache.datasketches.quantilescommon.GenericSortedView;
import org.apache.datasketches.quantilescommon.QuantilesGenericSketchIterator;
import org.junit.jupiter.api.Test;

class StringsSketchAggregatorDiffblueTest {
  /**
   * Method under test:
   * {@link StringsSketchAggregator#_apply(ItemsSketch, ItemsSketch)}
   */
  @Test
  void test_apply() {
    // Arrange and Act
    ItemsSketch<String> actual_applyResult = (new StringsSketchAggregator())._apply(null, null);

    // Assert
    QuantilesGenericSketchIterator<String> iteratorResult = actual_applyResult.iterator();
    assertTrue(iteratorResult instanceof ItemsSketchIterator);
    GenericSortedView<String> sortedView = actual_applyResult.getSortedView();
    assertTrue(sortedView instanceof ItemsSketchSortedView);
    assertEquals(0, actual_applyResult.getNumRetained());
    assertEquals(0, sortedView.getQuantiles().length);
    assertEquals(0, sortedView.getCumulativeWeights().length);
    assertEquals(0L, actual_applyResult.getN());
    assertEquals(0L, sortedView.iterator().getN());
    assertEquals(128, actual_applyResult.getK());
    assertEquals(1L, iteratorResult.getWeight());
    assertFalse(actual_applyResult.hasMemory());
    assertFalse(actual_applyResult.isDirect());
    assertFalse(actual_applyResult.isEstimationMode());
    assertFalse(actual_applyResult.isReadOnly());
    assertTrue(actual_applyResult.isEmpty());
    assertTrue(sortedView.isEmpty());
    Class<String> expectedSketchType = String.class;
    assertEquals(expectedSketchType, actual_applyResult.getSketchType());
  }
}
