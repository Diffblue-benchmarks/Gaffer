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

package uk.gov.gchq.gaffer.bitmap.function.aggregate;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.roaringbitmap.RoaringBitmap;

class RoaringBitmapAggregatorDiffblueTest {
  /**
   * Test {@link RoaringBitmapAggregator#_apply(RoaringBitmap, RoaringBitmap)} with {@code RoaringBitmap}, {@code RoaringBitmap}.
   * <ul>
   *   <li>Then return {@link RoaringBitmap} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RoaringBitmapAggregator#_apply(RoaringBitmap, RoaringBitmap)}
   */
  @Test
  @DisplayName("Test _apply(RoaringBitmap, RoaringBitmap) with 'RoaringBitmap', 'RoaringBitmap'; then return RoaringBitmap (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RoaringBitmap RoaringBitmapAggregator._apply(RoaringBitmap, RoaringBitmap)"})
  void test_applyWithRoaringBitmapRoaringBitmap_thenReturnRoaringBitmap() {
    // Arrange
    RoaringBitmapAggregator roaringBitmapAggregator = new RoaringBitmapAggregator();
    RoaringBitmap a = new RoaringBitmap();

    // Act and Assert
    assertSame(a, roaringBitmapAggregator._apply(a, new RoaringBitmap()));
  }
}
