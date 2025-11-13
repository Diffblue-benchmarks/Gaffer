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

package uk.gov.gchq.gaffer.sketches.datasketches.frequencies.binaryoperator;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.datasketches.frequencies.ItemsSketch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringsSketchAggregatorDiffblueTest {
  /**
   * Test {@link StringsSketchAggregator#_apply(ItemsSketch, ItemsSketch)} with {@code ItemsSketch}, {@code ItemsSketch}.
   * <ul>
   *   <li>Then return {@link ItemsSketch#ItemsSketch(int)} with maxMapSize is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringsSketchAggregator#_apply(ItemsSketch, ItemsSketch)}
   */
  @Test
  @DisplayName("Test _apply(ItemsSketch, ItemsSketch) with 'ItemsSketch', 'ItemsSketch'; then return ItemsSketch(int) with maxMapSize is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ItemsSketch StringsSketchAggregator._apply(ItemsSketch, ItemsSketch)"})
  void test_applyWithItemsSketchItemsSketch_thenReturnItemsSketchWithMaxMapSizeIsOne() {
    // Arrange
    StringsSketchAggregator stringsSketchAggregator = new StringsSketchAggregator();
    ItemsSketch<String> a = new ItemsSketch<>(1);

    // Act and Assert
    assertSame(a, stringsSketchAggregator._apply(a, new ItemsSketch<>(1)));
  }

  /**
   * Test {@link StringsSketchAggregator#_apply(ItemsSketch, ItemsSketch)} with {@code ItemsSketch}, {@code ItemsSketch}.
   * <ul>
   *   <li>Then return {@link ItemsSketch#ItemsSketch(int)} with maxMapSize is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringsSketchAggregator#_apply(ItemsSketch, ItemsSketch)}
   */
  @Test
  @DisplayName("Test _apply(ItemsSketch, ItemsSketch) with 'ItemsSketch', 'ItemsSketch'; then return ItemsSketch(int) with maxMapSize is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ItemsSketch StringsSketchAggregator._apply(ItemsSketch, ItemsSketch)"})
  void test_applyWithItemsSketchItemsSketch_thenReturnItemsSketchWithMaxMapSizeIsOne2() {
    // Arrange
    StringsSketchAggregator stringsSketchAggregator = new StringsSketchAggregator();
    ItemsSketch<String> a = new ItemsSketch<>(1);

    // Act and Assert
    assertSame(a, stringsSketchAggregator._apply(a, null));
  }
}
