package uk.gov.gchq.gaffer.bitmap.function.aggregate;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.roaringbitmap.RoaringBitmap;

class RoaringBitmapAggregatorDiffblueTest {
  /**
   * Test {@link RoaringBitmapAggregator#_apply(RoaringBitmap, RoaringBitmap)} with {@code
   * RoaringBitmap}, {@code RoaringBitmap}.
   *
   * <ul>
   *   <li>Then return {@link RoaringBitmap} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link RoaringBitmapAggregator#_apply(RoaringBitmap, RoaringBitmap)}
   */
  @Test
  @DisplayName(
      "Test _apply(RoaringBitmap, RoaringBitmap) with 'RoaringBitmap', 'RoaringBitmap'; then return RoaringBitmap (default constructor)")
  @Tag("MaintainedByDiffblue")
  void test_applyWithRoaringBitmapRoaringBitmap_thenReturnRoaringBitmap() {
    // Arrange
    RoaringBitmapAggregator roaringBitmapAggregator = new RoaringBitmapAggregator();
    RoaringBitmap a = new RoaringBitmap();

    // Act
    RoaringBitmap actual_applyResult = roaringBitmapAggregator._apply(a, new RoaringBitmap());

    // Assert
    assertSame(a, actual_applyResult);
  }
}
